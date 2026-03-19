package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.location.LocationRequestCompat;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import com.kwad.components.core.video.m;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.k;
import java.io.File;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class SplashPreloadManager {
    private HashMap<String, PreLoadItem> He;
    private List<String> Hf;
    private volatile SharedPreferences Hg;
    private final Object mLock;

    public static class PreLoadItem extends com.kwad.sdk.core.response.a.a implements Serializable {
        public long cacheTime;
        public long expiredTime;
        public int materialType;
        public String preloadId;
    }

    /* synthetic */ SplashPreloadManager(byte b) {
        this();
    }

    static class a {
        private static final SplashPreloadManager Hh = new SplashPreloadManager(0);
    }

    private void init() {
        Context context = ServiceProvider.getContext();
        if (context != null) {
            this.Hg = context.getSharedPreferences("ksadsdk_splash_preload_id_list", 0);
            initData();
        }
    }

    private SplashPreloadManager() {
        this.mLock = new Object();
        this.He = new HashMap<>();
        this.Hf = new ArrayList();
        init();
    }

    private void initData() {
        Map<String, ?> all = this.Hg.getAll();
        ArrayList arrayList = new ArrayList();
        for (String str : all.keySet()) {
            PreLoadItem preLoadItem = new PreLoadItem();
            try {
                Object obj = all.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (TextUtils.isEmpty(str2)) {
                        continue;
                    } else {
                        preLoadItem.parseJson(new JSONObject(str2));
                        if (TextUtils.isEmpty(preLoadItem.preloadId)) {
                            continue;
                        } else {
                            File fileDw = com.kwad.sdk.core.diskcache.b.a.ZH().dw(preLoadItem.preloadId);
                            if (fileDw != null && fileDw.exists()) {
                                synchronized (this.mLock) {
                                    this.He.put(str, preLoadItem);
                                    if (!this.Hf.contains(str)) {
                                        this.Hf.add(str);
                                    }
                                }
                            } else {
                                arrayList.add(preLoadItem.preloadId);
                                com.kwad.sdk.core.d.c.d("PreloadManager", "Remove null file list " + preLoadItem.preloadId);
                            }
                        }
                    }
                } else {
                    continue;
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        SharedPreferences.Editor editorEdit = this.Hg.edit();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            editorEdit.remove((String) it.next());
        }
        editorEdit.apply();
    }

    public final void a(long j, int i) {
        int i2;
        int i3;
        int i4;
        int size;
        long jCurrentTimeMillis = System.currentTimeMillis();
        int size2 = this.Hf.size();
        synchronized (this.mLock) {
            ArrayList<String> arrayList = new ArrayList();
            i3 = 0;
            i4 = 0;
            for (String str : this.He.keySet()) {
                PreLoadItem preLoadItem = this.He.get(str);
                if (preLoadItem != null && preLoadItem.expiredTime < jCurrentTimeMillis) {
                    arrayList.add(str);
                    if (preLoadItem.materialType == 2) {
                        i3++;
                    } else if (preLoadItem.materialType == 1) {
                        i4++;
                    }
                }
            }
            SharedPreferences.Editor editorEdit = this.Hg.edit();
            for (String str2 : arrayList) {
                this.Hf.remove(str2);
                this.He.remove(str2);
                editorEdit.remove(str2);
                com.kwad.sdk.core.diskcache.b.a.ZH().remove(str2);
            }
            editorEdit.apply();
            size = this.Hf.size();
        }
        if (size > 30) {
            com.kwad.sdk.core.d.c.d("PreloadManager", "大于 30 按失效日期远近顺序移除");
            int i5 = size - 15;
            for (i2 = 0; i2 < i5; i2++) {
                long j2 = LocationRequestCompat.PASSIVE_INTERVAL;
                String str3 = "";
                synchronized (this.mLock) {
                    for (PreLoadItem preLoadItem2 : this.He.values()) {
                        if (preLoadItem2.expiredTime < j2) {
                            j2 = preLoadItem2.expiredTime;
                            str3 = preLoadItem2.preloadId;
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        PreLoadItem preLoadItem3 = this.He.get(str3);
                        if (preLoadItem3 != null) {
                            if (preLoadItem3.materialType == 2) {
                                i3++;
                            } else if (preLoadItem3.materialType == 1) {
                                i4++;
                            }
                        }
                        this.Hf.remove(str3);
                        this.He.remove(str3);
                        this.Hg.edit().remove(str3).apply();
                        com.kwad.sdk.core.d.c.d("PreloadManager", "移除 preloadId = " + str3 + " expiredTime =  " + j2);
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    com.kwad.sdk.core.diskcache.b.a.ZH().remove(str3);
                }
            }
        }
        int i6 = i4;
        List<String> listLI = lI();
        int size3 = size2 - listLI.size();
        List<Integer> listJ = j(listLI);
        com.kwad.components.ad.splashscreen.monitor.b.md();
        com.kwad.components.ad.splashscreen.monitor.b.a(j, listLI, listJ, i, size3, i6, i3);
    }

    public static SplashPreloadManager lH() {
        SplashPreloadManager splashPreloadManager = a.Hh;
        if (splashPreloadManager.Hg == null) {
            splashPreloadManager.init();
        }
        return splashPreloadManager;
    }

    public final int a(AdResultData adResultData, boolean z, int i) throws NoSuchAlgorithmException {
        Iterator<AdInfo> it;
        String strL;
        boolean zA;
        com.kwad.components.ad.splashscreen.monitor.b.md();
        com.kwad.components.ad.splashscreen.monitor.b.k(adResultData);
        int i2 = 0;
        for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
            if (adTemplate != null) {
                Iterator<AdInfo> it2 = adTemplate.adInfoList.iterator();
                while (it2.hasNext()) {
                    AdInfo next = it2.next();
                    if (next.adPreloadInfo != null && this.Hg != null) {
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        if (!q(next)) {
                            if (com.kwad.sdk.core.response.b.a.bi(next)) {
                                strL = com.kwad.sdk.core.response.b.a.L(next);
                            } else {
                                strL = com.kwad.sdk.core.response.b.a.bj(next) ? com.kwad.sdk.core.response.b.a.aY(next).materialUrl : null;
                            }
                            if (!TextUtils.isEmpty(strL)) {
                                String strBf = com.kwad.sdk.core.response.b.a.bf(next);
                                if (next.adPreloadInfo.preloadType != 1 || ao.isWifiConnected(ServiceProvider.getContext()) || z) {
                                    com.kwad.sdk.core.d.c.d("PreloadManager", "start Download preloadId " + strBf + " true url " + strL);
                                    it = it2;
                                    a(adResultData.getPosId(), 1);
                                    a.C0589a c0589a = new a.C0589a();
                                    if (p(next)) {
                                        zA = KSImageLoader.loadImageSync(strL) != null;
                                    } else {
                                        zA = m.a(strL, strBf, c0589a);
                                    }
                                    if (zA) {
                                        o(next);
                                        i2++;
                                        com.kwad.components.ad.splashscreen.monitor.b.md();
                                        com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, SystemClock.elapsedRealtime() - jElapsedRealtime, 1, i);
                                    } else {
                                        com.kwad.components.ad.splashscreen.monitor.b.md();
                                        com.kwad.components.ad.splashscreen.monitor.b.d(adTemplate, 4, c0589a.msg);
                                        com.kwad.components.core.q.a.ss().f(adTemplate, 1, c0589a.msg);
                                    }
                                } else {
                                    it = it2;
                                    com.kwad.components.ad.splashscreen.monitor.b.md();
                                    com.kwad.components.ad.splashscreen.monitor.b.d(adTemplate, 1, SplashMonitorInfo.ERROR_NET_MSG);
                                }
                            } else {
                                it = it2;
                                com.kwad.components.ad.splashscreen.monitor.b.md();
                                com.kwad.components.ad.splashscreen.monitor.b.d(adTemplate, 2, SplashMonitorInfo.ERROR_URL_INVALID_MSG);
                            }
                        } else {
                            it = it2;
                            com.kwad.components.ad.splashscreen.monitor.b.md();
                            com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, SystemClock.elapsedRealtime() - jElapsedRealtime, 2, i);
                            o(next);
                            i2++;
                        }
                    } else {
                        it = it2;
                        com.kwad.components.ad.splashscreen.monitor.b.md();
                        com.kwad.components.ad.splashscreen.monitor.b.d(adTemplate, 3, SplashMonitorInfo.ERROR_PRELOAD_ID_INVALID_MSG);
                    }
                    it2 = it;
                }
            }
        }
        AdTemplate adTemplate2 = adResultData.getAdTemplateList().size() > 0 ? adResultData.getAdTemplateList().get(0) : null;
        if (i2 > 0) {
            k.aw("splashAd_", "onSplashVideoAdCacheSuccess");
            com.kwad.components.core.q.a.ss().e(adTemplate2, i2);
        } else {
            k.aw("splashAd_", "onSplashVideoAdCacheFailed");
        }
        return i2;
    }

    private void o(AdInfo adInfo) {
        PreLoadItem preLoadItem = new PreLoadItem();
        preLoadItem.cacheTime = System.currentTimeMillis();
        preLoadItem.expiredTime = System.currentTimeMillis() + (adInfo.adPreloadInfo.validityPeriod * 1000);
        preLoadItem.preloadId = com.kwad.sdk.core.response.b.a.bf(adInfo);
        preLoadItem.materialType = com.kwad.sdk.core.response.b.a.bi(adInfo) ? 2 : 1;
        synchronized (this.mLock) {
            this.He.put(adInfo.adPreloadInfo.preloadId, preLoadItem);
            if (!this.Hf.contains(adInfo.adPreloadInfo.preloadId)) {
                this.Hf.add(adInfo.adPreloadInfo.preloadId);
            }
        }
        if (this.Hg != null) {
            SharedPreferences.Editor editorEdit = this.Hg.edit();
            editorEdit.putString(adInfo.adPreloadInfo.preloadId, preLoadItem.toJson().toString());
            editorEdit.apply();
        }
    }

    public final boolean h(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                AdInfo adInfo = adTemplate.adInfoList.get(0);
                if (adInfo.adPreloadInfo != null) {
                    if (p(adInfo)) {
                        return KSImageLoader.isImageExist(com.kwad.sdk.core.response.b.a.aY(adInfo).materialUrl);
                    }
                    return q(adInfo);
                }
            }
        }
        return false;
    }

    private static boolean p(AdInfo adInfo) {
        return com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.HI) && com.kwad.sdk.core.response.b.a.bj(adInfo);
    }

    public static boolean i(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                return com.kwad.sdk.core.response.b.a.bj(adTemplate.adInfoList.get(0));
            }
        }
        return false;
    }

    public static boolean j(AdResultData adResultData) {
        if (!adResultData.getAdTemplateList().isEmpty()) {
            AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
            if (!adTemplate.adInfoList.isEmpty()) {
                return com.kwad.sdk.core.response.b.a.bi(adTemplate.adInfoList.get(0));
            }
        }
        return false;
    }

    private boolean q(AdInfo adInfo) {
        if (p(adInfo)) {
            return KSImageLoader.isImageExist(com.kwad.sdk.core.response.b.a.aY(adInfo).materialUrl);
        }
        String str = adInfo.adPreloadInfo.preloadId;
        if (str != null) {
            File fileDw = com.kwad.sdk.core.diskcache.b.a.ZH().dw(str);
            com.kwad.sdk.core.d.c.d("PreloadManager", "check preloadId " + str + " file exists " + (fileDw == null ? ILogConst.CACHE_PLAY_REASON_NULL : Boolean.valueOf(fileDw.exists())));
            if (fileDw != null && fileDw.exists()) {
                return true;
            }
        }
        return false;
    }

    public static File ac(String str) {
        if (str == null) {
            return null;
        }
        com.kwad.sdk.core.d.c.d("PreloadManager", "getVideoFile preloadId " + str + "  url " + str);
        File fileDw = com.kwad.sdk.core.diskcache.b.a.ZH().dw(str);
        if (fileDw == null || !fileDw.exists()) {
            return null;
        }
        return fileDw;
    }

    public final List<String> W() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.mLock) {
            com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdList start ");
            for (int i = 0; i < this.Hf.size(); i++) {
                String str = this.Hf.get(i);
                File fileDw = com.kwad.sdk.core.diskcache.b.a.ZH().dw(str);
                if (fileDw != null && fileDw.exists()) {
                    arrayList.add(str);
                }
            }
            com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdList end ");
        }
        com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdList " + this.Hf.size());
        return arrayList;
    }

    public final List<String> lI() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdListWithoutClean start ");
            arrayList = new ArrayList(this.Hf);
            com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdListWithoutClean end ");
        }
        com.kwad.sdk.core.d.c.d("PreloadManager", "getPreloadIdListWithoutClean " + this.Hf.size());
        return arrayList;
    }

    public final List<Integer> j(List<String> list) {
        PreLoadItem preLoadItem;
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        synchronized (this.mLock) {
            com.kwad.sdk.core.d.c.d("PreloadManager", "getMaterialTypeList start ");
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i);
                if (this.He.containsKey(str) && (preLoadItem = this.He.get(str)) != null) {
                    arrayList.add(Integer.valueOf(preLoadItem.materialType));
                }
            }
            com.kwad.sdk.core.d.c.d("PreloadManager", "getMaterialTypeList end ");
        }
        com.kwad.sdk.core.d.c.d("PreloadManager", "getMaterialTypeList " + arrayList.size());
        return arrayList;
    }
}

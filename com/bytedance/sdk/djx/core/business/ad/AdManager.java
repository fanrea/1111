package com.bytedance.sdk.djx.core.business.ad;

import android.text.TextUtils;
import com.bytedance.sdk.djx.core.business.ad.LoaderAbs;
import com.bytedance.sdk.djx.core.settings.SettingData;
import com.bytedance.sdk.djx.interfaces.listener.IDJXAdListener;
import com.bytedance.sdk.djx.utils.LG;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class AdManager {
    public static final int AD_LOADER_TYPE_BANNER = 8;
    public static final int AD_LOADER_TYPE_EXPRESS_DRAW_FEED = 1;
    public static final int AD_LOADER_TYPE_EXPRESS_INTERSTITIAL = 6;
    public static final int AD_LOADER_TYPE_EXPRESS_INTERSTITIAL_NEW = 7;
    public static final int AD_LOADER_TYPE_EXPRESS_REWARD = 5;
    public static final int AD_LOADER_TYPE_FEED = 3;
    public static final int AD_LOADER_TYPE_NATIVE_DRAW_FEED = 4;
    public static final int AD_LOADER_TYPE_NATIVE_EXPRESS = 2;
    private static final int MAX_CACHE_NUM = 2;
    public static final String TAG = "AdManager";
    private static volatile AdManager sInstance;
    private int mMaxNum = 2;
    private final Map<AdKey, List<IDJXAd>> mCache = new ConcurrentHashMap();
    private final Map<AdKey, LoaderAbs> mLoader = new ConcurrentHashMap();
    private final Map<AdKey, LoaderAbs> mLoaderMix = new ConcurrentHashMap();
    public Map<Integer, IDJXAdListener> mAdListenerMap = new ConcurrentHashMap();
    public Map<Integer, IDJXAd> mTempAdCache = new ConcurrentHashMap();

    public static AdManager inst() {
        if (sInstance == null) {
            synchronized (AdManager.class) {
                if (sInstance == null) {
                    sInstance = new AdManager();
                }
            }
        }
        return sInstance;
    }

    private AdManager() {
    }

    public void setMaxNum(int i) {
        this.mMaxNum = i;
    }

    public void buildAdLoader(int i, AdKey adKey, IDJXAdListener iDJXAdListener) {
        if (adKey == null || TextUtils.isEmpty(adKey.getCodeId())) {
            return;
        }
        checkCacheNull(adKey);
        if (iDJXAdListener != null) {
            this.mAdListenerMap.put(Integer.valueOf(adKey.getParamsCode()), iDJXAdListener);
        }
        LoaderAbs loaderAbs = this.mLoader.get(adKey);
        if (loaderAbs == null) {
            LoaderAbs loaderAbsBuild = AdUtils.createDefaultAdapter().build(false, i, adKey, iDJXAdListener);
            if (loaderAbsBuild != null) {
                this.mLoader.put(adKey, loaderAbsBuild);
                return;
            }
            return;
        }
        loaderAbs.mAdKey = adKey;
    }

    public void buildMixAdLoader(int i, AdKey adKey, IDJXAdListener iDJXAdListener) {
        if (adKey == null || TextUtils.isEmpty(adKey.getCodeId())) {
            return;
        }
        if (iDJXAdListener != null) {
            this.mAdListenerMap.put(Integer.valueOf(adKey.getParamsCode()), iDJXAdListener);
        }
        LoaderAbs loaderAbs = this.mLoaderMix.get(adKey);
        if (loaderAbs == null) {
            LoaderAbs loaderAbsBuild = AdUtils.createDefaultAdapter().build(true, i, adKey, iDJXAdListener);
            if (loaderAbsBuild != null) {
                this.mLoaderMix.put(adKey, loaderAbsBuild);
                return;
            }
            return;
        }
        loaderAbs.mAdKey = adKey;
    }

    public String getToken(AdKey adKey) {
        if (adKey == null || TextUtils.isEmpty(adKey.getCodeId())) {
            LG.d("AdLog-AdManager", "get token ad codeId is empty");
            return null;
        }
        LoaderAbs loaderAbs = this.mLoaderMix.get(adKey);
        if (loaderAbs != null) {
            return loaderAbs.getToken();
        }
        return null;
    }

    public void getMixAd(AdKey adKey, LoaderModel loaderModel, LoaderAbs.Callback callback) {
        if (adKey == null || TextUtils.isEmpty(adKey.getCodeId())) {
            LG.d("AdLog-AdManager", "get mix ad codeId is empty");
            return;
        }
        if (callback == null) {
            LG.d("AdLog-AdManager", "get mix ad callback is empty");
            return;
        }
        if (loaderModel == null) {
            LG.d("AdLog-AdManager", "get mix ad loaderModel is empty");
            return;
        }
        LoaderAbs loaderAbs = this.mLoaderMix.get(adKey);
        if (loaderAbs != null) {
            loaderAbs.load(loaderModel, callback);
        }
    }

    public boolean hasAd(AdKey adKey, int i) {
        boolean z = false;
        if (adKey == null || TextUtils.isEmpty(adKey.getCodeId())) {
            LG.d("AdLog-AdManager", "has ad codeId is empty");
            return false;
        }
        List<IDJXAd> listCheckCacheNull = checkCacheNull(adKey);
        if (listCheckCacheNull != null && i >= 0 && i < listCheckCacheNull.size()) {
            z = true;
        }
        if (!z) {
            LG.d("AdLog-AdManager", adKey.getCodeId() + ", has ad no ad, to load");
            load(adKey);
        }
        return z;
    }

    public IDJXAd getAd(AdKey adKey) {
        IDJXAd iDJXAdRemove;
        List<IDJXAd> listCheckCacheNull = checkCacheNull(adKey);
        if (listCheckCacheNull == null || listCheckCacheNull.isEmpty()) {
            iDJXAdRemove = null;
        } else {
            iDJXAdRemove = listCheckCacheNull.remove(0);
            LG.d("AdLog-AdManager", adKey.getCodeId() + ", get ad : 1, " + listCheckCacheNull.size());
        }
        if (listCheckCacheNull == null || listCheckCacheNull.size() < this.mMaxNum) {
            if (adKey != null) {
                LG.d("AdLog-AdManager", adKey.getCodeId() + ", get ad < max, to load");
            }
            load(adKey);
        }
        return iDJXAdRemove;
    }

    public void saveAd(AdKey adKey, IDJXAd iDJXAd) {
        List<IDJXAd> listCheckCacheNull;
        if (adKey == null || TextUtils.isEmpty(adKey.getCodeId()) || iDJXAd == null || (listCheckCacheNull = checkCacheNull(adKey)) == null) {
            return;
        }
        listCheckCacheNull.add(iDJXAd);
    }

    public void saveTempAd(int i, IDJXAd iDJXAd) {
        if (iDJXAd == null) {
            return;
        }
        if (this.mTempAdCache.size() > 4) {
            deleteMinimumKey(this.mTempAdCache);
        }
        this.mTempAdCache.put(Integer.valueOf(i), iDJXAd);
    }

    public IDJXAd getTempAd(int i) {
        if (this.mTempAdCache.isEmpty()) {
            return null;
        }
        long adExpire = SettingData.getInstance().getAdExpire() * 1000 * 60;
        Iterator<Integer> it = this.mTempAdCache.keySet().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            if (this.mTempAdCache.get(Integer.valueOf(iIntValue)) != null && System.currentTimeMillis() - this.mTempAdCache.get(Integer.valueOf(iIntValue)).getAdCacheTime() >= adExpire) {
                this.mTempAdCache.remove(Integer.valueOf(iIntValue));
                LG.d("ad past due remove");
            }
        }
        return this.mTempAdCache.get(Integer.valueOf(i));
    }

    private void deleteMinimumKey(Map<Integer, IDJXAd> map) {
        if (map.isEmpty()) {
            return;
        }
        int iIntValue = Integer.MAX_VALUE;
        for (Integer num : map.keySet()) {
            if (num.intValue() < iIntValue) {
                iIntValue = num.intValue();
            }
        }
        map.remove(Integer.valueOf(iIntValue));
    }

    public void removeTempAd(int i) {
        if (this.mTempAdCache.isEmpty()) {
            return;
        }
        this.mTempAdCache.remove(Integer.valueOf(i));
    }

    private void load(AdKey adKey) {
        if (adKey == null || TextUtils.isEmpty(adKey.getCodeId())) {
            LG.d("AdLog-AdManager", "load ad codeId is empty");
            return;
        }
        LoaderAbs loaderAbs = this.mLoader.get(adKey);
        if (loaderAbs != null) {
            loaderAbs.load();
        }
    }

    private List<IDJXAd> checkCacheNull(AdKey adKey) {
        if (adKey == null || TextUtils.isEmpty(adKey.getCodeId())) {
            LG.d("AdLog-AdManager", "check cache null codeId is empty");
            return null;
        }
        List<IDJXAd> listFilterExpireAd = filterExpireAd(this.mCache.get(adKey));
        if (listFilterExpireAd != null) {
            return listFilterExpireAd;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.mCache.put(adKey, copyOnWriteArrayList);
        return copyOnWriteArrayList;
    }

    private List<IDJXAd> filterExpireAd(List<IDJXAd> list) {
        if (list == null) {
            return null;
        }
        long adExpire = SettingData.getInstance().getAdExpire() * 1000 * 60;
        for (int size = list.size() - 1; size >= 0; size--) {
            IDJXAd iDJXAd = list.get(size);
            if (System.currentTimeMillis() - iDJXAd.getAdCacheTime() >= adExpire) {
                list.remove(iDJXAd);
                LG.d("ad past due remove");
            }
        }
        return list;
    }

    public void clear(int i) {
        Map<Integer, IDJXAdListener> map = this.mAdListenerMap;
        if (map == null) {
            return;
        }
        map.remove(Integer.valueOf(i));
    }
}

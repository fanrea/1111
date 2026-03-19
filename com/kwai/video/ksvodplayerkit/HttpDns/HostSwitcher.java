package com.kwai.video.ksvodplayerkit.HttpDns;

import android.text.TextUtils;
import com.kwai.video.ksvodplayerkit.KSVodPlayerConfig;
import com.kwai.video.ksvodplayerkit.Logger.KSVodLogger;
import com.kwai.video.ksvodplayerkit.MultiRate.AdaptationSet;
import com.kwai.video.ksvodplayerkit.MultiRate.HlsAdaptationModel;
import com.kwai.video.ksvodplayerkit.MultiRate.HlsAdaptationModel_JsonUtils;
import com.kwai.video.ksvodplayerkit.MultiRate.HlsRepresentation;
import com.kwai.video.ksvodplayerkit.MultiRate.KSVodAdaptationModel;
import com.kwai.video.ksvodplayerkit.MultiRate.KSVodAdaptationSet;
import com.kwai.video.ksvodplayerkit.MultiRate.KwaiAdaptationSet;
import com.kwai.video.ksvodplayerkit.MultiRate.KwaiMediaManifest;
import com.kwai.video.ksvodplayerkit.MultiRate.KwaiMediaManifest_JsonUtils;
import com.kwai.video.ksvodplayerkit.MultiRate.KwaiRepresentation;
import com.kwai.video.ksvodplayerkit.MultiRate.Representation;
import com.kwai.video.ksvodplayerkit.MultiRate.VideoAdaptationModel;
import com.kwai.video.ksvodplayerkit.Utils.NetworkUtils;
import com.kwai.video.ksvodplayerkit.Utils.VodPlayerUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class HostSwitcher {
    private static final int MAX_SINGLE_HOST_PARSE_IP_NUM = 2;
    private static final String TAG = "HostSwitcher";
    private String mCurrentPlayUrl;
    private String mHlsManifest;
    private HlsAdaptationModel mHlsManifestModel;
    private Map<String, HlsRepresentation> mHlsUrlRepresentationMap;
    private boolean mIsResolved;
    private String mKwaiManifest;
    private KwaiMediaManifest mKwaiManifestModel;
    private Map<String, KwaiRepresentation> mKwaiVodManifestMap;
    private VideoAdaptationModel mModel;
    private Switcher<DnsResolvedUrl> mPlayUrls;
    private Map<String, Representation> mUrlRepresentationMap;
    private int mUrlType;
    private List<String> mUrls;
    private KSVodAdaptationModel mVodAdaptationModel;

    public HostSwitcher(List<String> list) {
        this.mUrlRepresentationMap = new HashMap();
        this.mHlsUrlRepresentationMap = new HashMap();
        this.mKwaiVodManifestMap = new HashMap();
        this.mUrlType = 0;
        this.mIsResolved = false;
        this.mPlayUrls = new Switcher<>();
        this.mUrls = list;
        initUrlSwitcher(list);
    }

    public HostSwitcher(KSVodAdaptationModel kSVodAdaptationModel) {
        this.mUrlRepresentationMap = new HashMap();
        this.mHlsUrlRepresentationMap = new HashMap();
        this.mKwaiVodManifestMap = new HashMap();
        this.mIsResolved = false;
        this.mUrlType = 1;
        this.mVodAdaptationModel = kSVodAdaptationModel;
        initAdaptationSet(kSVodAdaptationModel);
    }

    public HostSwitcher(String str) {
        this.mUrlRepresentationMap = new HashMap();
        this.mHlsUrlRepresentationMap = new HashMap();
        this.mKwaiVodManifestMap = new HashMap();
        this.mIsResolved = false;
        this.mHlsManifest = str;
        this.mUrlType = 2;
        initHlsAdaptationSet(str);
    }

    public HostSwitcher(String str, int i) {
        this.mUrlRepresentationMap = new HashMap();
        this.mHlsUrlRepresentationMap = new HashMap();
        this.mKwaiVodManifestMap = new HashMap();
        this.mKwaiManifest = str;
        this.mUrlType = i;
        initKwaiVodManifest(str);
    }

    private void initUrlSwitcher(List<String> list) {
        for (String str : list) {
            ArrayList arrayList = new ArrayList();
            String host = NetworkUtils.getHost(str);
            int i = 0;
            for (ResolvedIP resolvedIP : HttpDns.get().getResolvedIPs(host)) {
                arrayList.add(new DnsResolvedUrl(host, str, str.replace(host, resolvedIP.mIP), resolvedIP));
                this.mIsResolved = true;
                if (list.size() > 1 && (i = i + 1) >= 2) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.add(new DnsResolvedUrl(host, str, str, (ResolvedIP) null));
            }
            this.mPlayUrls.append(arrayList);
        }
        if (KSVodPlayerConfig.get().isEnableHostSort()) {
            Collections.sort(this.mPlayUrls.mElements);
        }
    }

    private void initAdaptationSet(KSVodAdaptationModel kSVodAdaptationModel) {
        if (this.mModel == null) {
            VideoAdaptationModel videoAdaptationModel = new VideoAdaptationModel();
            this.mModel = videoAdaptationModel;
            videoAdaptationModel.mAdaptationSet = new ArrayList();
            AdaptationSet adaptationSet = new AdaptationSet();
            this.mModel.mAdaptationSet.add(adaptationSet);
            adaptationSet.mAdaptationId = 1L;
            adaptationSet.mDuration = String.valueOf(kSVodAdaptationModel.duration);
            adaptationSet.mRepresentation = new ArrayList();
            for (KSVodAdaptationSet kSVodAdaptationSet : kSVodAdaptationModel.vodAdaptationSets) {
                if (kSVodAdaptationSet != null) {
                    Representation representation = new Representation();
                    adaptationSet.mRepresentation.add(representation);
                    representation.mAvgBitrate = kSVodAdaptationSet.avgBitrate;
                    representation.mMaxBitrate = kSVodAdaptationSet.maxRate;
                    representation.mHeight = kSVodAdaptationSet.height;
                    representation.mWidth = kSVodAdaptationSet.width;
                    representation.mQuality = kSVodAdaptationSet.quality;
                    ArrayList arrayList = new ArrayList();
                    for (String str : kSVodAdaptationSet.urls) {
                        try {
                            String host = NetworkUtils.getHost(str);
                            int i = 0;
                            for (ResolvedIP resolvedIP : HttpDns.get().getResolvedIPs(host)) {
                                this.mIsResolved = true;
                                DnsResolvedUrl dnsResolvedUrl = new DnsResolvedUrl(host, str.replace(host, resolvedIP.mIP), resolvedIP);
                                arrayList.add(dnsResolvedUrl);
                                if (kSVodAdaptationSet.urls.size() > 1 && (i = i + 1) >= 2) {
                                    break;
                                } else {
                                    this.mUrlRepresentationMap.put(dnsResolvedUrl.mUrl, representation);
                                }
                            }
                            this.mUrlRepresentationMap.put(str, representation);
                            if (!TextUtils.isEmpty(host)) {
                                arrayList.add(new DnsResolvedUrl(host, str, null));
                            }
                        } catch (Exception e) {
                            KSVodLogger.e("MultiRateSourceSwitcher", e.getMessage());
                            return;
                        }
                    }
                    if (arrayList.size() > 0) {
                        representation.mUrlSwitcher = new Switcher<>();
                        representation.mUrlSwitcher.append(arrayList);
                        updateRepresentation(representation, representation.mUrlSwitcher.getCurrent());
                    } else {
                        KSVodLogger.e(TAG, "MultiRateSourceSwitcher. Init failed");
                    }
                }
            }
        }
    }

    private void initHlsAdaptationSet(String str) {
        HlsAdaptationModel.HlsAdaptationSet hlsAdaptationSet;
        HlsAdaptationModel hlsAdaptationModelFromJson = HlsAdaptationModel_JsonUtils.fromJson(str);
        this.mHlsManifestModel = hlsAdaptationModelFromJson;
        if (hlsAdaptationModelFromJson == null || (hlsAdaptationSet = hlsAdaptationModelFromJson.adaptationSet) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < hlsAdaptationSet.representation.size(); i++) {
            ArrayList<DnsResolvedUrl> arrayList2 = new ArrayList();
            HlsRepresentation hlsRepresentation = hlsAdaptationSet.representation.get(i);
            String str2 = hlsRepresentation.url;
            try {
                arrayList2.add(new DnsResolvedUrl(NetworkUtils.getHost(str2), str2, str2, (ResolvedIP) null));
                for (String str3 : hlsRepresentation.backupUrl) {
                    arrayList2.add(new DnsResolvedUrl(NetworkUtils.getHost(str3), str3, str3, (ResolvedIP) null));
                }
                for (DnsResolvedUrl dnsResolvedUrl : arrayList2) {
                    for (ResolvedIP resolvedIP : HttpDns.get().getResolvedIPs(dnsResolvedUrl.mHost)) {
                        this.mIsResolved = true;
                        DnsResolvedUrl dnsResolvedUrl2 = new DnsResolvedUrl(dnsResolvedUrl.mHost, dnsResolvedUrl.mOriginalUrl.replace(dnsResolvedUrl.mHost, resolvedIP.mIP), resolvedIP);
                        arrayList.add(dnsResolvedUrl2);
                        this.mHlsUrlRepresentationMap.put(dnsResolvedUrl2.mUrl, hlsRepresentation);
                    }
                    this.mHlsUrlRepresentationMap.put(dnsResolvedUrl.mOriginalUrl, hlsRepresentation);
                    if (!TextUtils.isEmpty(dnsResolvedUrl.mHost)) {
                        arrayList.add(new DnsResolvedUrl(dnsResolvedUrl.mHost, dnsResolvedUrl.mOriginalUrl, null));
                    }
                }
                if (arrayList.size() > 0) {
                    hlsRepresentation.urlSwitcher = new Switcher<>();
                    hlsRepresentation.urlSwitcher.append(arrayList);
                    updateHlsRepresentation(hlsRepresentation, hlsRepresentation.urlSwitcher.getCurrent(), null);
                }
            } catch (Exception e) {
                KSVodLogger.e("initHlsAdaptationSet host parse failed", e.getMessage());
            }
        }
    }

    private void initKwaiVodManifest(String str) {
        KwaiAdaptationSet kwaiAdaptationSet;
        Object obj;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mKwaiManifestModel = KwaiMediaManifest_JsonUtils.fromJson(str);
        for (int i = 0; i < this.mKwaiManifestModel.adaptationSet.size(); i++) {
            KwaiAdaptationSet kwaiAdaptationSet2 = this.mKwaiManifestModel.adaptationSet.get(i);
            for (int i2 = 0; i2 < kwaiAdaptationSet2.representation.size(); i2++) {
                KwaiRepresentation kwaiRepresentation = kwaiAdaptationSet2.representation.get(i2);
                if (kwaiRepresentation.qualityType == null) {
                    kwaiRepresentation.qualityType = "";
                }
                if (kwaiRepresentation.qualityLabel == null) {
                    kwaiRepresentation.qualityLabel = "";
                }
                String str2 = kwaiRepresentation.url;
                ArrayList<DnsResolvedUrl> arrayList = new ArrayList();
                try {
                    arrayList.add(new DnsResolvedUrl(NetworkUtils.getHost(str2), str2, str2, (ResolvedIP) null));
                    if (kwaiRepresentation.backupUrl != null) {
                        for (String str3 : kwaiRepresentation.backupUrl) {
                            arrayList.add(new DnsResolvedUrl(NetworkUtils.getHost(str3), str3, str3, (ResolvedIP) null));
                        }
                    }
                } catch (Exception e) {
                    KSVodLogger.e("initKwaiVodManifest host parse failed", e.getMessage());
                }
                ArrayList arrayList2 = new ArrayList();
                for (DnsResolvedUrl dnsResolvedUrl : arrayList) {
                    Iterator<ResolvedIP> it = HttpDns.get().getResolvedIPs(dnsResolvedUrl.mHost).iterator();
                    int i3 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            kwaiAdaptationSet = kwaiAdaptationSet2;
                            break;
                        }
                        ResolvedIP next = it.next();
                        this.mIsResolved = true;
                        kwaiAdaptationSet = kwaiAdaptationSet2;
                        DnsResolvedUrl dnsResolvedUrl2 = new DnsResolvedUrl(dnsResolvedUrl.mHost, str2.replace(dnsResolvedUrl.mHost, next.mIP), next);
                        arrayList2.add(dnsResolvedUrl2);
                        if (arrayList.size() > 1 && (i3 = i3 + 1) >= 2) {
                            break;
                        }
                        this.mKwaiVodManifestMap.put(dnsResolvedUrl2.mUrl, kwaiRepresentation);
                        kwaiAdaptationSet2 = kwaiAdaptationSet;
                    }
                    if (TextUtils.isEmpty(dnsResolvedUrl.mHost)) {
                        obj = null;
                    } else {
                        String str4 = dnsResolvedUrl.mHost;
                        String str5 = dnsResolvedUrl.mOriginalUrl;
                        obj = null;
                        arrayList2.add(new DnsResolvedUrl(str4, str5, null));
                    }
                    if (arrayList2.size() > 0) {
                        this.mKwaiVodManifestMap.put(str2, kwaiRepresentation);
                        kwaiRepresentation.urlSwitcher = new Switcher<>();
                        kwaiRepresentation.urlSwitcher.append(arrayList2);
                        updateKwaiRepresentation(kwaiRepresentation, kwaiRepresentation.urlSwitcher.getCurrent());
                    }
                    kwaiAdaptationSet2 = kwaiAdaptationSet;
                }
            }
        }
    }

    public boolean switchHost() {
        String str;
        Switcher<DnsResolvedUrl> switcher;
        Switcher<DnsResolvedUrl> switcher2;
        Switcher<DnsResolvedUrl> switcher3;
        if (this.mUrlType == 1) {
            Representation representation = this.mUrlRepresentationMap.get(this.mCurrentPlayUrl);
            if (representation == null || (switcher3 = representation.mUrlSwitcher) == null) {
                return false;
            }
            DnsResolvedUrl current = getCurrent();
            String str2 = current != null ? current.mUrl : null;
            if (!isLastUrl()) {
                representation.mUrlSwitcher.moveToNext();
            }
            updateRepresentation(representation, representation.mUrlSwitcher.getCurrent());
            DnsResolvedUrl current2 = switcher3.getCurrent();
            if ((current2 == null || TextUtils.equals(str2, current2.mUrl)) ? false : true) {
                KSVodLogger.d(TAG, "URL_TYPE_MULTIRATE_MANIFEST switch PlayUrls");
                return true;
            }
        }
        int i = this.mUrlType;
        if (i == 2) {
            HlsRepresentation hlsRepresentation = this.mHlsUrlRepresentationMap.get(this.mCurrentPlayUrl);
            if (hlsRepresentation == null || (switcher2 = hlsRepresentation.urlSwitcher) == null) {
                return false;
            }
            DnsResolvedUrl current3 = getCurrent();
            str = current3 != null ? current3.mUrl : null;
            if (!isLastUrl()) {
                hlsRepresentation.urlSwitcher.moveToNext();
            }
            DnsResolvedUrl current4 = switcher2.getCurrent();
            if ((current4 == null || TextUtils.equals(str, current4.mUrl)) ? false : true) {
                updateHlsRepresentation(hlsRepresentation, hlsRepresentation.urlSwitcher.getCurrent(), current3);
                KSVodLogger.d(TAG, "URL_TYPE_HLS_MANIFEST switch PlayUrls");
                return true;
            }
        } else if (i == 3) {
            KwaiRepresentation kwaiRepresentation = this.mKwaiVodManifestMap.get(this.mCurrentPlayUrl);
            if (kwaiRepresentation == null || (switcher = kwaiRepresentation.urlSwitcher) == null) {
                return false;
            }
            DnsResolvedUrl current5 = getCurrent();
            str = current5 != null ? current5.mUrl : null;
            if (!isLastUrl()) {
                kwaiRepresentation.urlSwitcher.moveToNext();
            }
            DnsResolvedUrl current6 = switcher.getCurrent();
            if ((current6 == null || TextUtils.equals(str, current6.mUrl)) ? false : true) {
                updateKwaiRepresentation(kwaiRepresentation, kwaiRepresentation.urlSwitcher.getCurrent());
                KSVodLogger.d(TAG, "URL_TYPE_HLS_MANIFEST switch PlayUrls");
                return true;
            }
        } else {
            DnsResolvedUrl current7 = getCurrent();
            str = current7 != null ? current7.mUrl : null;
            if (!isLastUrl()) {
                this.mPlayUrls.moveToNext();
            }
            DnsResolvedUrl current8 = getCurrent();
            if ((current8 == null || TextUtils.equals(str, current8.mUrl)) ? false : true) {
                KSVodLogger.d(TAG, "switch PlayUrls");
                return true;
            }
        }
        KSVodLogger.w(TAG, "switchHost play url failed! url type:" + this.mUrlType);
        return false;
    }

    public DnsResolvedUrl getCurrent() {
        Switcher<DnsResolvedUrl> switcher = getSwitcher();
        if (switcher == null || switcher.size() <= 0) {
            return null;
        }
        return switcher.getCurrent();
    }

    public int getCurrentPosition() {
        Switcher<DnsResolvedUrl> switcher = getSwitcher();
        if (switcher != null) {
            return switcher.getCurrentPosition();
        }
        return 0;
    }

    public String getCurrentHost() {
        DnsResolvedUrl current = getCurrent();
        return current != null ? current.mHost : "";
    }

    public boolean isLastUrl() {
        Switcher<DnsResolvedUrl> switcher = getSwitcher();
        return switcher != null && switcher.getCurrentPosition() == switcher.size() - 1;
    }

    public int size() {
        Switcher<DnsResolvedUrl> switcher = getSwitcher();
        if (switcher != null) {
            return switcher.size();
        }
        return 0;
    }

    public void refreshUrlList(boolean z) {
        KSVodAdaptationModel kSVodAdaptationModel;
        String str;
        if (this.mIsResolved) {
            return;
        }
        if (this.mUrlType == 0) {
            initUrlSwitcher(this.mUrls);
        }
        int i = this.mUrlType;
        if (i == 2 && (str = this.mHlsManifest) != null) {
            initHlsAdaptationSet(str);
            return;
        }
        if (i == 1 && (kSVodAdaptationModel = this.mVodAdaptationModel) != null) {
            initAdaptationSet(kSVodAdaptationModel);
        } else if (i == 3) {
            initKwaiVodManifest(this.mKwaiManifest);
        }
    }

    public void updateKwaiRepresentation(KwaiRepresentation kwaiRepresentation, DnsResolvedUrl dnsResolvedUrl) {
        kwaiRepresentation.url = dnsResolvedUrl.mUrl;
        kwaiRepresentation.host = dnsResolvedUrl.mHost;
        kwaiRepresentation.cacheKey = VodPlayerUtils.getCacheKey(dnsResolvedUrl.mUrl);
    }

    private void updateRepresentation(Representation representation, DnsResolvedUrl dnsResolvedUrl) {
        representation.mUrl = dnsResolvedUrl.mUrl;
        representation.mHost = dnsResolvedUrl.mHost;
        representation.mKey = VodPlayerUtils.getCacheKey(dnsResolvedUrl.mUrl);
    }

    private void updateHlsRepresentation(HlsRepresentation hlsRepresentation, DnsResolvedUrl dnsResolvedUrl, DnsResolvedUrl dnsResolvedUrl2) {
        hlsRepresentation.url = dnsResolvedUrl.mUrl;
        hlsRepresentation.host = dnsResolvedUrl.mHost;
        hlsRepresentation.baseUrl = hlsRepresentation.baseUrl.replace(dnsResolvedUrl.mHost, dnsResolvedUrl.mResolvedIP != null ? dnsResolvedUrl.mResolvedIP.mIP : dnsResolvedUrl.mHost);
        if (dnsResolvedUrl2 != null) {
            hlsRepresentation.m3u8Slice = "";
        }
        this.mHlsManifestModel.host = dnsResolvedUrl.mHost;
    }

    private Switcher<DnsResolvedUrl> getSwitcher() {
        int i = this.mUrlType;
        if (i == 1) {
            Representation representation = this.mUrlRepresentationMap.get(this.mCurrentPlayUrl);
            if (representation != null) {
                return representation.mUrlSwitcher;
            }
            return null;
        }
        if (i == 2) {
            HlsRepresentation hlsRepresentation = this.mHlsUrlRepresentationMap.get(this.mCurrentPlayUrl);
            if (hlsRepresentation != null) {
                return hlsRepresentation.urlSwitcher;
            }
            return null;
        }
        if (i == 3) {
            KwaiRepresentation kwaiRepresentation = this.mKwaiVodManifestMap.get(this.mCurrentPlayUrl);
            if (kwaiRepresentation != null) {
                return kwaiRepresentation.urlSwitcher;
            }
            return null;
        }
        return this.mPlayUrls;
    }

    public VideoAdaptationModel getModel() {
        return this.mModel;
    }

    public HlsAdaptationModel getHlsManifestModel() {
        return this.mHlsManifestModel;
    }

    public KwaiMediaManifest getKwaiManifestModel() {
        return this.mKwaiManifestModel;
    }

    public String getCurrentPlayCDNUrl() {
        String str;
        DnsResolvedUrl current;
        int i = this.mUrlType;
        if ((i == 2 || i == 1 || i == 3) && (str = this.mCurrentPlayUrl) != null) {
            return str;
        }
        if (i != 0 || (current = getCurrent()) == null) {
            return null;
        }
        return current.mUrl;
    }

    public void setCurrentPlayCDNUrl(String str) {
        this.mCurrentPlayUrl = str;
    }
}

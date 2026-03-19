package com.kwai.video.ksliveplayer.switcher;

import com.kwai.video.ksliveplayer.model.AdaptationSetModel;
import com.kwai.video.ksliveplayer.model.LiveAdaptionModel;
import com.kwai.video.ksliveplayer.model.LiveAdaptiveManifestModel;
import com.kwai.video.ksliveplayer.util.NetworkUtils;
import com.kwai.video.ksliveplayer.util.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class HostSwitcher {
    private Switcher<LiveAdaptiveManifestModel> mAdaptiveManifestSwitcher;
    private Switcher<ResolvedUrl> mPlayUrlSwitcher;

    public void initAdaptiveManifestSwitcher(List<LiveAdaptiveManifestModel> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (LiveAdaptiveManifestModel liveAdaptiveManifestModel : list) {
            if (liveAdaptiveManifestModel.mAdaptationSet != null && liveAdaptiveManifestModel.mAdaptationSet.mRepresentation != null && liveAdaptiveManifestModel.mAdaptationSet.mRepresentation.size() != 0) {
                String host = NetworkUtils.getHost(liveAdaptiveManifestModel.mAdaptationSet.mRepresentation.get(0).mUrl);
                List<ResolvedIP> resolvedIPs = HttpDns.get().getResolvedIPs(host);
                if (!Utils.isCollectionEmpty(resolvedIPs)) {
                    for (ResolvedIP resolvedIP : resolvedIPs) {
                        AdaptationSetModel adaptationSetModel = new AdaptationSetModel();
                        adaptationSetModel.mGopDuration = liveAdaptiveManifestModel.mAdaptationSet.mGopDuration;
                        adaptationSetModel.mRepresentation = new ArrayList();
                        for (LiveAdaptionModel liveAdaptionModel : liveAdaptiveManifestModel.mAdaptationSet.mRepresentation) {
                            adaptationSetModel.mRepresentation.add(LiveAdaptionModel.copyOf(liveAdaptionModel.mUrl.replace(host, resolvedIP.mIP), liveAdaptionModel));
                        }
                        arrayList.add(new LiveAdaptiveManifestModel(liveAdaptiveManifestModel.mVersion, liveAdaptiveManifestModel.mType, liveAdaptiveManifestModel.mIsFreeTrafficCdn, liveAdaptiveManifestModel.mHideAuto, adaptationSetModel, host));
                    }
                }
                arrayList.add(new LiveAdaptiveManifestModel(liveAdaptiveManifestModel.mVersion, liveAdaptiveManifestModel.mType, liveAdaptiveManifestModel.mIsFreeTrafficCdn, liveAdaptiveManifestModel.mHideAuto, liveAdaptiveManifestModel.mAdaptationSet, host));
            }
        }
        this.mAdaptiveManifestSwitcher = new Switcher<>();
        this.mAdaptiveManifestSwitcher.append(arrayList);
        this.mPlayUrlSwitcher = null;
    }

    public void initUrlSwitcher(String str) {
        this.mPlayUrlSwitcher = new Switcher<>();
        this.mPlayUrlSwitcher.append(getResolvedUrls(str));
        this.mAdaptiveManifestSwitcher = null;
    }

    public void initMultiPlayUrlsSwitcher(List<String> list) {
        this.mPlayUrlSwitcher = new Switcher<>();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.mPlayUrlSwitcher.append(getResolvedUrls(it.next()));
        }
    }

    private List<ResolvedUrl> getResolvedUrls(String str) {
        String host = NetworkUtils.getHost(str);
        ArrayList arrayList = new ArrayList();
        List<ResolvedIP> resolvedIPs = HttpDns.get().getResolvedIPs(host);
        if (!Utils.isCollectionEmpty(resolvedIPs)) {
            for (ResolvedIP resolvedIP : resolvedIPs) {
                ResolvedUrl resolvedUrl = new ResolvedUrl();
                resolvedUrl.url = str.replace(host, resolvedIP.mIP);
                resolvedUrl.host = host;
                arrayList.add(resolvedUrl);
            }
        }
        arrayList.add(new ResolvedUrl(str));
        return arrayList;
    }

    public boolean isLast() {
        Switcher<LiveAdaptiveManifestModel> switcher = this.mAdaptiveManifestSwitcher;
        if (switcher != null) {
            return switcher.isLast();
        }
        Switcher<ResolvedUrl> switcher2 = this.mPlayUrlSwitcher;
        if (switcher2 != null) {
            return switcher2.isLast();
        }
        return true;
    }

    public LiveAdaptiveManifestModel getCurrentManifest() {
        Switcher<LiveAdaptiveManifestModel> switcher = this.mAdaptiveManifestSwitcher;
        if (switcher != null) {
            return switcher.getCurrent();
        }
        return null;
    }

    public ResolvedUrl getCurrentResolvedUrl() {
        Switcher<ResolvedUrl> switcher = this.mPlayUrlSwitcher;
        if (switcher != null) {
            return switcher.getCurrent();
        }
        return null;
    }

    public void moveToNext() {
        Switcher<LiveAdaptiveManifestModel> switcher = this.mAdaptiveManifestSwitcher;
        if (switcher != null) {
            switcher.moveToNext();
        }
        Switcher<ResolvedUrl> switcher2 = this.mPlayUrlSwitcher;
        if (switcher2 != null) {
            switcher2.moveToNext();
        }
    }

    public int size() {
        Switcher<LiveAdaptiveManifestModel> switcher = this.mAdaptiveManifestSwitcher;
        if (switcher != null) {
            return switcher.size();
        }
        Switcher<ResolvedUrl> switcher2 = this.mPlayUrlSwitcher;
        if (switcher2 != null) {
            return switcher2.size();
        }
        return 0;
    }

    public static class ResolvedUrl {
        public String host;
        public String url;

        public ResolvedUrl() {
        }

        public ResolvedUrl(String str) {
            this.url = str;
        }
    }
}

package com.kwai.video.ksliveplayer.model;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LiveAdaptiveManifestModel {
    private static final long serialVersionUID = 6308822831616818593L;
    public AdaptationSetModel mAdaptationSet;
    public boolean mHideAuto;
    public String mHost;
    public boolean mIsFreeTrafficCdn;
    public String mType;
    public String mVersion;

    public LiveAdaptiveManifestModel() {
    }

    public LiveAdaptiveManifestModel(String str, String str2, boolean z, boolean z2, AdaptationSetModel adaptationSetModel, String str3) {
        this.mVersion = str;
        this.mType = str2;
        this.mIsFreeTrafficCdn = z;
        this.mAdaptationSet = adaptationSetModel;
        this.mHost = str3;
        this.mHideAuto = z2;
    }
}

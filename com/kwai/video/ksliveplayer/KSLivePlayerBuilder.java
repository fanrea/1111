package com.kwai.video.ksliveplayer;

import android.content.Context;
import com.kwai.video.ksliveplayer.midd.KSLivePlayerImpl;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLivePlayerBuilder {
    public Context mContext;
    public String mDataManifest;
    public String mDataSource;
    public boolean mEnableUseLastSelectQualityType = true;
    public String mLiveManifestConfig;
    public KSLiveVideoContext mLiveVideoContext;
    public List<String> mMultiPlayUrls;

    public KSLivePlayerBuilder(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @Deprecated
    public KSLivePlayerBuilder setDataSource(String str) {
        this.mDataSource = str;
        return this;
    }

    public KSLivePlayerBuilder setMultiPlayUrls(List<String> list) {
        this.mMultiPlayUrls = list;
        return this;
    }

    public KSLivePlayerBuilder setDataManifest(String str) {
        this.mDataManifest = str;
        return this;
    }

    public KSLivePlayerBuilder setLiveManifestConfigJson(String str) {
        this.mLiveManifestConfig = str;
        return this;
    }

    public KSLivePlayerBuilder setLiveVideoContext(KSLiveVideoContext kSLiveVideoContext) {
        this.mLiveVideoContext = kSLiveVideoContext;
        return this;
    }

    public KSLivePlayerBuilder setEnableUseLastSelectQualityType(boolean z) {
        this.mEnableUseLastSelectQualityType = z;
        return this;
    }

    public KSLivePlayer build() {
        return new KSLivePlayerImpl(this);
    }
}

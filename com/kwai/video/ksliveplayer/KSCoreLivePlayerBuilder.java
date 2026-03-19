package com.kwai.video.ksliveplayer;

import android.content.Context;
import com.kwai.video.ksliveplayer.impl.KSCoreLivePlayerImpl;
import com.kwai.video.ksliveplayer.model.KSLivePlayerConfigModel;
import com.kwai.video.player.kwai_player.KwaiPlayerLiveBuilder;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSCoreLivePlayerBuilder {
    public KSLivePlayerConfigModel mConfigModel;
    public Context mContext;
    public String mDataManifest;
    public String mDataSource;
    public KwaiPlayerLiveBuilder mKwaiPlayerLiveBuilder;
    public String mLiveManifestConfig;
    public KSLiveVideoContext mLiveVideoContext;
    public List<String> mMultiPlayUrls;
    public boolean mEnableUseLastSelectQualityType = false;
    public boolean isCoreIndependent = true;

    public KSCoreLivePlayerBuilder(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public KSCoreLivePlayerBuilder setMultiPlayUrls(List<String> list) {
        this.mMultiPlayUrls = list;
        return this;
    }

    public KSCoreLivePlayerBuilder setDataManifest(String str, String str2) {
        this.mDataManifest = str;
        this.mLiveManifestConfig = str2;
        return this;
    }

    public KSCoreLivePlayerBuilder setLiveVideoContext(KSLiveVideoContext kSLiveVideoContext) {
        this.mLiveVideoContext = kSLiveVideoContext;
        return this;
    }

    public KSCoreLivePlayerBuilder setLivePlayConfig(KSLivePlayerConfigModel kSLivePlayerConfigModel) {
        this.mConfigModel = kSLivePlayerConfigModel;
        return this;
    }

    public KSCoreLivePlayerBuilder setKwaiLiveBuilder(KwaiPlayerLiveBuilder kwaiPlayerLiveBuilder) {
        this.mKwaiPlayerLiveBuilder = kwaiPlayerLiveBuilder;
        return this;
    }

    public KSCoreLivePlayerBuilder setCoreIndependent(boolean z) {
        this.isCoreIndependent = z;
        return this;
    }

    public KSCoreLivePlayer build() {
        return new KSCoreLivePlayerImpl(this);
    }
}

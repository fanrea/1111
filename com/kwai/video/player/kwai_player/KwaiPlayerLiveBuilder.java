package com.kwai.video.player.kwai_player;

import android.content.Context;
import android.text.TextUtils;
import com.kwai.player.KwaiPlayerConfig;
import com.kwai.video.hodor.util.Timber;
import com.kwai.video.player.IKwaiMediaPlayer;
import com.kwai.video.player.PlayerProps;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class KwaiPlayerLiveBuilder extends KwaiPlayerBaseBuilder<KwaiPlayerLiveBuilder> {
    private float mBufferTimeMaxSec;
    private String mConfigJson;
    private boolean mIsLiveManifest;
    private KwaiPlayerConfig mKwaiPlayerConfig;
    private String mLiveLowDelayConfigJson;
    private int mNetType;
    private int mSpbBufferMs;
    private int mSpbMaxBufferCostMs;
    private boolean mUseAlignedPts;
    private boolean mUseSpbBuffer;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwai.video.player.kwai_player.KwaiPlayerBaseBuilder
    public final KwaiPlayerLiveBuilder self() {
        return this;
    }

    public KwaiPlayerLiveBuilder(Context context) {
        super(context);
        this.mBufferTimeMaxSec = 5.0f;
        this.mNetType = 0;
        this.mIsLiveManifest = false;
        this.mUseAlignedPts = true;
        this.mUseSpbBuffer = false;
        this.mSpbBufferMs = 500;
        this.mSpbMaxBufferCostMs = 1000;
        this.mUseNatvieCache = false;
    }

    public final IKwaiMediaPlayer build() {
        KwaiMediaPlayer kwaiMediaPlayer = new KwaiMediaPlayer();
        kwaiMediaPlayer.setIsLive(true);
        applyTo(kwaiMediaPlayer);
        return kwaiMediaPlayer;
    }

    @Override // com.kwai.video.player.kwai_player.KwaiPlayerBaseBuilder
    protected final void applyTo(KwaiMediaPlayer kwaiMediaPlayer) {
        super.applyTo(kwaiMediaPlayer);
        Timber.d("applyTo", new Object[0]);
        KwaiPlayerConfig kwaiPlayerConfig = this.mKwaiPlayerConfig;
        if (kwaiPlayerConfig != null) {
            kwaiMediaPlayer.setupAspectLiveRealTimeReporter(true, kwaiPlayerConfig);
            kwaiMediaPlayer.setConfig(this.mKwaiPlayerConfig);
        } else {
            kwaiMediaPlayer.setupAspectLiveRealTimeReporter(false, null);
        }
        if (!TextUtils.isEmpty(this.mConfigJson)) {
            kwaiMediaPlayer._setConfigJson(this.mConfigJson);
        }
        if (!TextUtils.isEmpty(this.mLiveLowDelayConfigJson)) {
            kwaiMediaPlayer._setLiveLowDelayConfigJson(this.mLiveLowDelayConfigJson);
        }
        kwaiMediaPlayer.setupAspectNativeCache(this.mUseNatvieCache);
        if (this.mUseNatvieCache) {
            kwaiMediaPlayer.getAspectAwesomeCache().setDataSourceType(1);
        }
        if (this.mUseAlignedPts) {
            kwaiMediaPlayer.setOption(4, "use-aligned-pts", 1L);
        }
        if (this.mUseSpbBuffer) {
            kwaiMediaPlayer._setStartPlayBlockBufferMs(this.mSpbBufferMs, this.mSpbMaxBufferCostMs);
        }
        kwaiMediaPlayer.setOption(4, "islive", 1L);
        kwaiMediaPlayer.setOption(4, "framedrop", 150L);
        kwaiMediaPlayer._setPropertyFloat(PlayerProps.FFP_PROP_FLOAT_BUFFERSIZE_MAX, this.mBufferTimeMaxSec);
        int i = this.mNetType;
        if (i > 0) {
            kwaiMediaPlayer.setOption(1, "device-network-type", i);
        }
        kwaiMediaPlayer.setupAspectKlv(this.mIsLiveManifest);
    }

    public final KwaiPlayerLiveBuilder setKwaiPlayerConfig(KwaiPlayerConfig kwaiPlayerConfig) {
        this.mKwaiPlayerConfig = kwaiPlayerConfig;
        return this;
    }

    public final KwaiPlayerLiveBuilder setBufferTimeMaxSec(float f) {
        this.mBufferTimeMaxSec = f;
        return this;
    }

    public final KwaiPlayerLiveBuilder setAdaptiveNetType(int i) {
        this.mNetType = i;
        return this;
    }

    public final KwaiPlayerLiveBuilder setConfigJson(String str) {
        this.mConfigJson = str;
        return this;
    }

    public final KwaiPlayerLiveBuilder setLiveLowDelayConfigJson(String str) {
        this.mLiveLowDelayConfigJson = str;
        return this;
    }

    public final KwaiPlayerLiveBuilder setIsLiveManifest(boolean z) {
        this.mIsLiveManifest = z;
        return this;
    }

    public final KwaiPlayerLiveBuilder setUseAlignedPts(boolean z) {
        this.mUseAlignedPts = z;
        return this;
    }

    public final KwaiPlayerLiveBuilder setStartPlayBlockBufferMs(int i, int i2) {
        this.mUseSpbBuffer = true;
        this.mSpbBufferMs = i;
        this.mSpbMaxBufferCostMs = i2;
        return this;
    }
}

package com.bytedance.sdk.djx;

import com.bytedance.sdk.djx.EMSdkConfig;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class DJXSdkConfig extends EMSdkConfig {
    private boolean mDisableTTPlayer;

    private DJXSdkConfig(Builder builder) {
        super(builder);
        this.mDisableTTPlayer = false;
        this.mDisableTTPlayer = builder.mDisableTTPlayer;
    }

    public boolean isDisableTTPlayer() {
        return this.mDisableTTPlayer;
    }

    public static final class Builder extends EMSdkConfig.Builder<Builder> {
        private boolean mDisableTTPlayer = false;

        public Builder disableTTPlayer(boolean z) {
            this.mDisableTTPlayer = z;
            return this;
        }

        public DJXSdkConfig build() {
            return new DJXSdkConfig(this);
        }
    }

    @Override // com.bytedance.sdk.djx.EMSdkConfig
    public String toString() {
        return "DJXSdkConfig{mIsDebug=" + isDebug() + ", mPrivacyController=" + getPrivacyController() + ", mImageCacheSize=" + getImageCacheSize() + ", mToastController=" + getToastController() + ", mDisableABTest=" + isDisableABTest() + ", mIsNewUser=" + isNewUser() + ", mAliveSeconds=" + getAliveSeconds() + ", mInterestType=" + getInterestType() + '}';
    }
}

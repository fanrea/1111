package com.tencent.qqlive.modules.vb.tquic.impl;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class TnetConfig {
    public int mCongestionType;
    public int mConnectTimeoutMillis;
    public boolean mEnableCongetionOptimization;
    public boolean mForceZeroRTT;
    public int mIdleTimeoutMillis;
    public int mQuicVersion;
    public boolean mSyncRead;
    public int mTotalTimeoutMillis;
    public boolean mUseRedirect;
    public boolean mUseSessionReuse;

    public int getCongestionType() {
        return this.mCongestionType;
    }

    public int getConnectTimeoutMillis() {
        return this.mConnectTimeoutMillis;
    }

    public int getIdleTimeoutMillis() {
        return this.mIdleTimeoutMillis;
    }

    public int getQuicVersion() {
        return this.mQuicVersion;
    }

    public int getTotalTimeoutMillis() {
        return this.mTotalTimeoutMillis;
    }

    public boolean isCongetionOptimizationEnabled() {
        return this.mEnableCongetionOptimization;
    }

    public boolean isForceZeroRTT() {
        return this.mForceZeroRTT;
    }

    public boolean isSyncRead() {
        return this.mSyncRead;
    }

    public boolean isUseRedirect() {
        return this.mUseRedirect;
    }

    public boolean isUseSessionReuse() {
        return this.mUseSessionReuse;
    }

    private TnetConfig(Builder builder) {
        this.mSyncRead = builder.mSyncRead;
        this.mCongestionType = builder.mCongestionType;
        this.mEnableCongetionOptimization = builder.mEnableCongetionOptimization;
        this.mTotalTimeoutMillis = builder.mTotalTimeoutMillis;
        this.mConnectTimeoutMillis = builder.mConnectTimeoutMillis;
        this.mIdleTimeoutMillis = builder.mIdleTimeoutMillis;
        this.mQuicVersion = builder.mQuicVersion;
        this.mUseRedirect = builder.mUseRedirect;
        this.mForceZeroRTT = builder.mForceZeroRTT;
        this.mUseSessionReuse = builder.mUseSessionReuse;
    }

    /* compiled from: A */
    public static class Builder {
        private int mCongestionType;
        private int mConnectTimeoutMillis;
        private boolean mEnableCongetionOptimization;
        private boolean mForceZeroRTT;
        private int mIdleTimeoutMillis;
        private int mQuicVersion;
        private boolean mSyncRead;
        private int mTotalTimeoutMillis;
        private boolean mUseRedirect;
        private boolean mUseSessionReuse;

        public Builder() {
            this.mSyncRead = false;
            this.mCongestionType = 2;
            this.mEnableCongetionOptimization = false;
            this.mTotalTimeoutMillis = 0;
            this.mConnectTimeoutMillis = 0;
            this.mIdleTimeoutMillis = 0;
            this.mQuicVersion = 43;
            this.mUseRedirect = false;
            this.mForceZeroRTT = false;
            this.mUseSessionReuse = true;
        }

        public TnetConfig build() {
            return new TnetConfig(this);
        }

        public Builder enableCongetionOptimization(boolean z) {
            this.mEnableCongetionOptimization = z;
            return this;
        }

        public Builder setCongestionType(int i) {
            this.mCongestionType = i;
            return this;
        }

        public Builder setConnectTimeoutMillis(int i) {
            this.mConnectTimeoutMillis = i;
            return this;
        }

        public Builder setForceZeroRTT(boolean z) {
            this.mForceZeroRTT = z;
            return this;
        }

        public Builder setIdleTimeoutMillis(int i) {
            this.mIdleTimeoutMillis = i;
            return this;
        }

        public Builder setQuicVersion(int i) {
            this.mQuicVersion = i;
            return this;
        }

        public Builder setSyncRead(boolean z) {
            this.mSyncRead = z;
            return this;
        }

        public Builder setTotalTimeoutMillis(int i) {
            this.mTotalTimeoutMillis = i;
            return this;
        }

        public Builder setUseRedirect(boolean z) {
            this.mUseRedirect = z;
            return this;
        }

        public Builder setUseSessionReuse(boolean z) {
            this.mUseSessionReuse = z;
            return this;
        }

        public Builder(TnetConfig tnetConfig) {
            this.mSyncRead = tnetConfig.mSyncRead;
            this.mCongestionType = tnetConfig.mCongestionType;
            this.mEnableCongetionOptimization = tnetConfig.mEnableCongetionOptimization;
            this.mTotalTimeoutMillis = tnetConfig.mTotalTimeoutMillis;
            this.mConnectTimeoutMillis = tnetConfig.mConnectTimeoutMillis;
            this.mIdleTimeoutMillis = tnetConfig.mIdleTimeoutMillis;
            this.mQuicVersion = tnetConfig.mQuicVersion;
            this.mUseRedirect = tnetConfig.mUseRedirect;
            this.mForceZeroRTT = tnetConfig.mForceZeroRTT;
            this.mUseSessionReuse = tnetConfig.mUseSessionReuse;
        }
    }
}

package com.kwai.player;

import com.bykv.vk.component.ttvideo.ILivePlayer;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KwaiPlayerConfig {
    public static final int DEFAULT_LIVE_ADAPTIVE_QOS_TICK_DURATION = 2000;
    public static final int DEFAULT_QOS_TICK_DURATION = 10000;
    private int mBufferIncrementStep;
    private int mBufferSmoothTime;
    private EnumBufferStrategy mBufferStrategy;
    private boolean mEnableLiveAdaptiveAdditionalQos;
    private boolean mEnableLiveAdaptiveQos;
    private boolean mEnableQos;
    private int mFirstBufferTime;
    private long mLiveAdaptiveQosDuration;
    private int mMaxBufferDuration;
    private int mMaxBufferTime;
    private int mMinBufferTime;
    private long mQosDuration;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public enum EnumBufferStrategy {
        LINEAR_INCREASE_BUFFER_STRATEGY(1),
        LOG_INCREASE_BUFFER_STRATEGY(2);

        private final int value;

        EnumBufferStrategy(int i) {
            this.value = i;
        }

        public static EnumBufferStrategy valueOf(int i) {
            if (i == 1) {
                return LINEAR_INCREASE_BUFFER_STRATEGY;
            }
            if (i != 2) {
                return null;
            }
            return LOG_INCREASE_BUFFER_STRATEGY;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public int getFirstBufferTime() {
        return this.mFirstBufferTime;
    }

    public int getMinBufferTime() {
        return this.mMinBufferTime;
    }

    public int getMaxBufferTime() {
        return this.mMaxBufferTime;
    }

    public EnumBufferStrategy getBufferStrategy() {
        return this.mBufferStrategy;
    }

    public int getBufferIncrementStep() {
        return this.mBufferIncrementStep;
    }

    public int getBufferSmoothTime() {
        return this.mBufferSmoothTime;
    }

    public long getLiveAdaptiveQosDuration() {
        return this.mLiveAdaptiveQosDuration;
    }

    public boolean getEnableLiveAdaptiveQos() {
        return this.mEnableLiveAdaptiveQos;
    }

    public boolean getEnableLiveAdaptiveAdditionalQos() {
        return this.mEnableLiveAdaptiveAdditionalQos;
    }

    public long getQosDuration() {
        return this.mQosDuration;
    }

    public boolean getEnableQos() {
        return this.mEnableQos;
    }

    public int getMaxBufferDuration() {
        return this.mMaxBufferDuration;
    }

    public KwaiPlayerConfig(Builder builder) {
        this.mEnableQos = builder.mEnableQos;
        this.mQosDuration = builder.mQosDuration;
        this.mEnableLiveAdaptiveQos = builder.mEnableLiveAdaptiveQos;
        this.mEnableLiveAdaptiveAdditionalQos = builder.mEnableLiveAdaptiveAdditionalQos;
        this.mLiveAdaptiveQosDuration = builder.mLiveAdaptiveQosDuration;
        this.mBufferIncrementStep = builder.mBufferIncrementStep;
        this.mBufferSmoothTime = builder.mBufferSmoothTime;
        this.mFirstBufferTime = builder.mFirstBufferTime;
        this.mMinBufferTime = builder.mMinBufferTime;
        this.mMaxBufferTime = builder.mMaxBufferTime;
        this.mBufferStrategy = builder.mBufferStrategy;
        this.mMaxBufferDuration = builder.mMaxBufferDurMs;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public static class Builder {
        private boolean mEnableQos = false;
        private long mQosDuration = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
        private boolean mEnableLiveAdaptiveQos = false;
        private boolean mEnableLiveAdaptiveAdditionalQos = false;
        private long mLiveAdaptiveQosDuration = 2000;
        private int mFirstBufferTime = 100;
        private int mMinBufferTime = 100;
        private int mMaxBufferTime = 5000;
        private int mBufferIncrementStep = 100;
        private int mBufferSmoothTime = 20000;
        private int mMaxBufferDurMs = 120000;
        private EnumBufferStrategy mBufferStrategy = EnumBufferStrategy.LINEAR_INCREASE_BUFFER_STRATEGY;

        public Builder setMaxBufferDuration(int i) {
            this.mMaxBufferDurMs = i;
            return this;
        }

        public Builder setBufferSmoothTime(int i) {
            this.mBufferSmoothTime = i;
            return this;
        }

        public Builder setFirstBufferTime(int i) {
            this.mFirstBufferTime = i;
            return this;
        }

        public Builder setMinBufferTime(int i) {
            this.mMinBufferTime = i;
            return this;
        }

        public Builder setMaxBufferTime(int i) {
            this.mMaxBufferTime = i;
            return this;
        }

        public Builder setBufferStrategy(EnumBufferStrategy enumBufferStrategy) {
            this.mBufferStrategy = enumBufferStrategy;
            return this;
        }

        public Builder setBufferIncrementStep(int i) {
            this.mBufferIncrementStep = i;
            return this;
        }

        public Builder setQosDuration(long j) {
            this.mQosDuration = j;
            return this;
        }

        public Builder setEnableQos(boolean z) {
            this.mEnableQos = z;
            return this;
        }

        public Builder setLiveAdaptiveQosDuration(long j) {
            this.mLiveAdaptiveQosDuration = j;
            return this;
        }

        public Builder setEnableLiveAdaptiveQos(boolean z) {
            this.mEnableLiveAdaptiveQos = z;
            return this;
        }

        public Builder setEnableLiveAdaptiveAdditionalQos(boolean z) {
            this.mEnableLiveAdaptiveAdditionalQos = z;
            return this;
        }

        public KwaiPlayerConfig build() {
            return new KwaiPlayerConfig(this);
        }
    }
}

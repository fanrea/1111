package com.ss.ttm.player;

import java.nio.ByteBuffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class VoiceTrait extends TraitObject {
    public static final int AV_PCM_FMT_DBL = 4;
    public static final int AV_PCM_FMT_DBLP = 9;
    public static final int AV_PCM_FMT_FLT = 3;
    public static final int AV_PCM_FMT_FLTP = 8;
    public static final int AV_PCM_FMT_NONE = -1;
    public static final int AV_PCM_FMT_S16 = 1;
    public static final int AV_PCM_FMT_S16P = 6;
    public static final int AV_PCM_FMT_S32 = 2;
    public static final int AV_PCM_FMT_S32P = 7;
    public static final int AV_PCM_FMT_U8 = 0;
    public static final int AV_PCM_FMT_U8P = 5;
    public static final int Version0 = 0;

    public static class AudioFrameInfo {
        public ByteBuffer[] mBuffers;
        public int mSamples;
        public long mTimestamp;
    }

    public abstract void audioClose();

    public abstract void audioFlush();

    public abstract int audioOpen(AudioMediaInfo audioMediaInfo);

    public abstract void audioPause();

    public abstract void audioResume();

    public abstract int audioWrite(AudioFrameInfo audioFrameInfo);

    public abstract int getLatency();

    public static class AudioMediaInfo {
        public int mBytePerSample;
        public int mChannels;
        public int mDuration;
        public int mFormat;
        public int mFrameSampleNB;
        public int mIsPacked;
        public int mSampleRate;

        public AudioMediaInfo(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            this.mSampleRate = i;
            this.mFrameSampleNB = i2;
            this.mBytePerSample = i3;
            this.mChannels = i4;
            this.mFormat = i5;
            this.mIsPacked = i6;
            this.mDuration = i7;
        }
    }

    public VoiceTrait(int i, long j) {
        super(i, j);
    }

    public VoiceTrait(int i, int i2, long j) {
        super(i, i2, j);
    }
}

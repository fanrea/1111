package com.ss.ttm.player;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class TraitObject {
    public static final int ExtVoice = 1;
    public static final int HLSChooseStream = 7;
    public static final int Illegal = 0;
    private long mNativeObj;
    private ReleaseNativeTrait mReleaseFunc;
    private final int mType;
    private final int mVersion;

    public interface ReleaseNativeTrait {
        void releaseNativeTrait(long j);
    }

    private native void nativeRelease(long j);

    public TraitObject(int i, long j) {
        this.mType = i;
        this.mVersion = -1;
        this.mNativeObj = j;
    }

    public TraitObject(int i, int i2, long j) {
        this.mType = i;
        this.mVersion = i2;
        this.mNativeObj = 0L;
    }

    public final void setReleaseFunc(ReleaseNativeTrait releaseNativeTrait) {
        this.mReleaseFunc = releaseNativeTrait;
    }

    public final int type() {
        return this.mType;
    }

    public final int version() {
        return this.mVersion;
    }

    public boolean sameAs(TraitObject traitObject) {
        if (traitObject == null) {
            return false;
        }
        return equals(traitObject);
    }

    public final void release() {
        long jTakeNativeObj = takeNativeObj();
        if (jTakeNativeObj != 0) {
            try {
                nativeRelease(jTakeNativeObj);
            } catch (UnsatisfiedLinkError unused) {
                if (this.mReleaseFunc != null) {
                    this.mReleaseFunc.releaseNativeTrait(jTakeNativeObj);
                }
            }
        }
    }

    private long takeNativeObj() {
        long j = this.mNativeObj;
        this.mNativeObj = 0L;
        return j;
    }
}

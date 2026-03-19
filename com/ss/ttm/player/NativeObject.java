package com.ss.ttm.player;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class NativeObject {
    protected long mNativeObj = 0;
    protected boolean mRetain = false;

    private native void nativeRelease(long j);

    protected void finalize() throws Throwable {
    }

    public synchronized void release() {
        if (this.mRetain) {
            long j = this.mNativeObj;
            if (j != 0) {
                nativeRelease(j);
                this.mNativeObj = 0L;
            }
        }
    }

    protected void setNativeObj(long j) {
        this.mNativeObj = j;
        this.mRetain = true;
    }

    protected void setWeakNativeObj(long j) {
        this.mNativeObj = j;
        this.mRetain = false;
    }

    private long getNativeObj() {
        return this.mNativeObj;
    }
}

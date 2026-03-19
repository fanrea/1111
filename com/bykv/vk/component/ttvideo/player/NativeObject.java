package com.bykv.vk.component.ttvideo.player;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class NativeObject {
    protected long mNativeObj = 0;

    private native void nativeRelease(long j);

    protected void finalize() throws Throwable {
    }

    public synchronized void release() {
        long j = this.mNativeObj;
        if (j != 0) {
            nativeRelease(j);
            this.mNativeObj = 0L;
        }
    }

    protected void setNativeObj(long j) {
        this.mNativeObj = j;
    }

    private long getNativeObj() {
        return this.mNativeObj;
    }
}

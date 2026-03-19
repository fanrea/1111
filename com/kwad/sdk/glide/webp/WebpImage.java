package com.kwad.sdk.glide.webp;

import com.kwad.sdk.utils.ax;
import java.nio.ByteBuffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class WebpImage {
    private int mBackgroundColor;
    private int mDurationMs;
    private int mFrameCount;
    private int[] mFrameDurations;
    private int mHeigth;
    private int mLoopCount;
    private long mNativePtr;
    private int mWidth;

    private static native WebpImage nativeCreateFromDirectByteBuffer(ByteBuffer byteBuffer);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native WebpFrame nativeGetFrame(int i);

    private native int nativeGetSizeInBytes();

    static {
        try {
            System.loadLibrary("glide-webp");
        } catch (Throwable unused) {
        }
    }

    public static WebpImage create(byte[] bArr) {
        ax.checkNotNull(bArr);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(bArr.length);
        byteBufferAllocateDirect.put(bArr);
        byteBufferAllocateDirect.rewind();
        return nativeCreateFromDirectByteBuffer(byteBufferAllocateDirect);
    }

    WebpImage(long j, int i, int i2, int i3, int i4, int[] iArr, int i5, int i6) {
        if (j == 0) {
            throw new RuntimeException("internal error: native WebpImage is 0");
        }
        this.mWidth = i;
        this.mHeigth = i2;
        this.mFrameCount = i3;
        this.mDurationMs = i4;
        this.mFrameDurations = iArr;
        this.mLoopCount = i5;
        fixFrameDurations(iArr);
        this.mBackgroundColor = i6;
        this.mNativePtr = j;
    }

    private void fixFrameDurations(int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] < 20) {
                iArr[i] = 100;
            }
        }
    }

    protected void finalize() {
        nativeFinalize();
    }

    public void dispose() {
        nativeDispose();
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeigth;
    }

    public int getFrameCount() {
        return this.mFrameCount;
    }

    public int getDuration() {
        return this.mDurationMs;
    }

    public int[] getFrameDurations() {
        return this.mFrameDurations;
    }

    public int getLoopCount() {
        return this.mLoopCount;
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public WebpFrame getFrame(int i) {
        return nativeGetFrame(i);
    }

    public c getFrameInfo(int i) {
        WebpFrame frame = getFrame(i);
        try {
            return new c(i, frame);
        } finally {
            frame.dispose();
        }
    }

    public int getSizeInBytes() {
        return nativeGetSizeInBytes();
    }
}

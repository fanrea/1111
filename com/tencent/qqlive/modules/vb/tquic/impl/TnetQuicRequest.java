package com.tencent.qqlive.modules.vb.tquic.impl;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class TnetQuicRequest {
    private final Callback mCallback;
    private long mTnetQuicAdapter;

    /* compiled from: A */
    public static abstract class Callback {
        public abstract void onClose(int i, String str) throws Exception;

        public abstract void onComplete(int i) throws Exception;

        public abstract void onConnect(int i) throws Exception;

        public abstract void onDataRecv(byte[] bArr) throws Exception;

        public abstract void onHeaderRecv(String str) throws Exception;

        public abstract void onNetworkLinked() throws Exception;
    }

    public TnetQuicRequest(Callback callback, TnetConfig tnetConfig, int i) {
        this.mCallback = callback;
        this.mTnetQuicAdapter = nativeCreateTnetQuicAdapter(tnetConfig, i);
    }

    private native void nativeAddHeaders(long j, String str, String str2);

    private native void nativeCancelRequest(long j);

    private native void nativeConnect(long j, String str, String str2);

    private native long nativeCreateTnetQuicAdapter(TnetConfig tnetConfig, int i);

    private native void nativeDestroy(long j);

    private native void nativeGetTnetStates(long j, TnetStats tnetStats);

    private native boolean nativeIsConnectCompleted(long j);

    private native boolean nativeRequestFinished(long j);

    private native boolean nativeSendRequest(long j, byte[] bArr, int i, boolean z);

    private native void nativeSetExpid(int i);

    private void onClose(int i, String str) {
        try {
            this.mCallback.onClose(i, str);
        } catch (Exception unused) {
        }
    }

    private void onComplete(int i) {
        try {
            this.mCallback.onComplete(i);
        } catch (Exception unused) {
        }
    }

    private void onConnect(int i) {
        try {
            this.mCallback.onConnect(i);
        } catch (Exception unused) {
        }
    }

    private void onDataRecv(byte[] bArr) {
        try {
            this.mCallback.onDataRecv(bArr);
        } catch (Exception unused) {
        }
    }

    private void onNetworkLinked() {
        try {
            this.mCallback.onNetworkLinked();
        } catch (Exception unused) {
        }
    }

    public void addHeaders(String str, String str2) {
        nativeAddHeaders(this.mTnetQuicAdapter, str, str2);
    }

    public void cancelRequest() {
        nativeCancelRequest(this.mTnetQuicAdapter);
    }

    public void connect(String str, String str2) {
        nativeConnect(this.mTnetQuicAdapter, str, str2);
    }

    public void destroy() {
        nativeDestroy(this.mTnetQuicAdapter);
    }

    public void getTnetStates(TnetStats tnetStats) {
        nativeGetTnetStates(this.mTnetQuicAdapter, tnetStats);
    }

    public boolean isConnectCompleted() {
        return nativeIsConnectCompleted(this.mTnetQuicAdapter);
    }

    public boolean isRequestFinished() {
        return nativeRequestFinished(this.mTnetQuicAdapter);
    }

    public boolean sendRequest(byte[] bArr, int i, boolean z) {
        return nativeSendRequest(this.mTnetQuicAdapter, bArr, i, z);
    }

    public void setExpId(int i) {
        nativeSetExpid(i);
    }
}

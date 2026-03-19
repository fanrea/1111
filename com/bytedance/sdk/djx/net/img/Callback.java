package com.bytedance.sdk.djx.net.img;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface Callback {

    public static class EmptyCallback implements Callback {
        @Override // com.bytedance.sdk.djx.net.img.Callback
        public void onError() {
        }

        @Override // com.bytedance.sdk.djx.net.img.Callback
        public void onSuccess() {
        }
    }

    void onError();

    void onSuccess();
}

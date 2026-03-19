package com.bytedance.sdk.djx.net.img;

import android.graphics.Bitmap;
import com.bytedance.sdk.djx.net.img.Picasso;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class FetchAction extends Action<Object> {
    private Callback callback;
    private final Object target;

    FetchAction(Picasso picasso, Request request, int i, int i2, Object obj, String str, Callback callback) {
        super(picasso, null, request, i, i2, 0, null, str, obj, false);
        this.target = new Object();
        this.callback = callback;
    }

    @Override // com.bytedance.sdk.djx.net.img.Action
    void complete(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
        Callback callback = this.callback;
        if (callback != null) {
            callback.onSuccess();
        }
    }

    @Override // com.bytedance.sdk.djx.net.img.Action
    void error() {
        Callback callback = this.callback;
        if (callback != null) {
            callback.onError();
        }
    }

    @Override // com.bytedance.sdk.djx.net.img.Action
    void cancel() {
        super.cancel();
        this.callback = null;
    }

    @Override // com.bytedance.sdk.djx.net.img.Action
    Object getTarget() {
        return this.target;
    }
}

package com.bytedance.sdk.djx.net.img;

import android.graphics.Bitmap;
import com.bytedance.sdk.djx.net.img.Picasso;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class GetAction extends Action<Void> {
    @Override // com.bytedance.sdk.djx.net.img.Action
    void complete(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
    }

    @Override // com.bytedance.sdk.djx.net.img.Action
    public void error() {
    }

    GetAction(Picasso picasso, Request request, int i, int i2, Object obj, String str) {
        super(picasso, null, request, i, i2, 0, null, str, obj, false);
    }
}

package com.baidu.mobads.container.g;

import android.graphics.Bitmap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class c {
    public Bitmap a;
    public int b;
    public c c = null;

    public c(Bitmap bitmap, int i) {
        this.a = bitmap;
        this.b = i;
    }

    public c(Bitmap bitmap, int i, float f) {
        if (f == 1.0f) {
            this.a = bitmap;
        } else {
            this.a = com.baidu.mobads.container.util.d.d.a(bitmap, f);
            this.a = com.baidu.mobads.container.util.d.d.b(this.a, 2);
        }
        this.b = i;
    }
}

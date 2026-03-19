package com.baidu.mobads.container.util.d;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class f implements Runnable {
    final /* synthetic */ ImageView a;
    final /* synthetic */ Bitmap b;

    f(ImageView imageView, Bitmap bitmap) {
        this.a = imageView;
        this.b = bitmap;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a != null) {
            this.a.setImageBitmap(this.b);
            this.a.setBackgroundResource(0);
            this.a.setVisibility(0);
        }
    }
}

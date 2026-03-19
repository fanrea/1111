package com.baidu.mobads.container.e;

import android.widget.ImageView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class i implements Runnable {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.a.U != null) {
            if (this.a.a.V != null) {
                this.a.a.V.setImageBitmap(this.a.a.U);
            }
            if (this.a.a.ac != null && this.a.a.ac.size() > 0) {
                for (ImageView imageView : this.a.a.ac) {
                    if (imageView != null) {
                        imageView.setImageBitmap(this.a.a.U);
                    }
                }
            }
        }
    }
}

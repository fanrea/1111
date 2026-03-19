package com.baidu.mobads.container;

import android.widget.ImageView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class as implements Runnable {
    final /* synthetic */ ImageView a;
    final /* synthetic */ String b;
    final /* synthetic */ boolean c;
    final /* synthetic */ k d;

    as(k kVar, ImageView imageView, String str, boolean z) {
        this.d = kVar;
        this.a = imageView;
        this.b = str;
        this.c = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.d.a(this.a, this.b, this.c);
    }
}

package com.baidu.mobads.container.util.d;

import android.graphics.Bitmap;
import com.baidu.mobads.container.util.cf;
import com.baidu.mobads.container.util.d.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class k extends cf.a {
    final /* synthetic */ Bitmap a;
    final /* synthetic */ d.b b;

    k(d.b bVar, Bitmap bitmap) {
        this.b = bVar;
        this.a = bitmap;
    }

    @Override // com.baidu.mobads.container.util.cf.a
    public void safeRun() {
        this.b.j.setImageBitmap(this.a);
    }
}

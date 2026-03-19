package com.component.a.a;

import android.graphics.Bitmap;
import android.view.View;
import com.component.a.a.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class c extends com.baidu.mobads.container.util.d.a {
    final /* synthetic */ b.a a;

    c(b.a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.mobads.container.util.d.a, com.baidu.mobads.container.util.d.d.InterfaceC0136d
    public void a(String str, String str2, View view, com.baidu.mobads.container.util.d.c cVar) {
        super.a(str, str2, view, cVar);
    }

    @Override // com.baidu.mobads.container.util.d.a, com.baidu.mobads.container.util.d.d.InterfaceC0136d
    public void a(String str, String str2, View view, Bitmap bitmap) {
        super.a(str, str2, view, bitmap);
        this.a.a = bitmap;
    }
}

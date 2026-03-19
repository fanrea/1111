package com.baidu.mobads.container.util.d;

import android.view.View;
import com.baidu.mobads.container.util.b.a.k;
import com.baidu.mobads.container.util.d.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class i implements k.a {
    final /* synthetic */ d.c a;
    final /* synthetic */ d.InterfaceC0136d b;
    final /* synthetic */ d.b c;

    i(d.b bVar, d.c cVar, d.InterfaceC0136d interfaceC0136d) {
        this.c = bVar;
        this.a = cVar;
        this.b = interfaceC0136d;
    }

    @Override // com.baidu.mobads.container.util.b.a.k.a
    public void a(String str, String str2, long j) {
        this.a.a(str, str2, this.c.j, (int) j);
    }

    @Override // com.baidu.mobads.container.util.b.a.k.a
    public void a(String str, String str2, com.baidu.mobads.container.util.b.f<?> fVar) {
        this.a.a(str, str2, this.c.j, this.c.a(fVar.b(), this.b));
    }

    @Override // com.baidu.mobads.container.util.b.a.k.a
    public void a(String str, String str2, c cVar) {
        this.a.a(str, str2, (View) this.c.j, cVar);
    }
}

package com.baidu.mobads.container.n;

import com.baidu.mobads.container.components.g.f;
import com.baidu.mobads.container.n.a;
import com.baidu.mobads.container.util.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class c implements f.a {
    final /* synthetic */ String a;
    final /* synthetic */ a.InterfaceC0129a b;
    final /* synthetic */ boolean c;
    final /* synthetic */ a d;

    c(a aVar, String str, a.InterfaceC0129a interfaceC0129a, boolean z) {
        this.d = aVar;
        this.a = str;
        this.b = interfaceC0129a;
        this.c = z;
    }

    @Override // com.baidu.mobads.container.components.g.f.a
    public void a(String str, String str2) {
        h.a(new d(this, str));
    }

    @Override // com.baidu.mobads.container.components.g.f.a
    public void a(String str, int i) {
        h.a(new e(this, str));
    }

    @Override // com.baidu.mobads.container.components.g.f.a
    public void a(long j) {
    }
}

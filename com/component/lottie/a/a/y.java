package com.component.lottie.a.a;

import com.component.lottie.a.b.a;
import com.component.lottie.d.b.t;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class y implements d, a.InterfaceC0322a {
    private final String a;
    private final boolean b;
    private final List<a.InterfaceC0322a> c = new ArrayList();
    private final t.a d;
    private final com.component.lottie.a.b.a<?, Float> e;
    private final com.component.lottie.a.b.a<?, Float> f;
    private final com.component.lottie.a.b.a<?, Float> g;

    public y(com.component.lottie.d.c.a aVar, com.component.lottie.d.b.t tVar) {
        this.a = tVar.a();
        this.b = tVar.f();
        this.d = tVar.b();
        this.e = tVar.d().a();
        this.f = tVar.c().a();
        this.g = tVar.e().a();
        aVar.a(this.e);
        aVar.a(this.f);
        aVar.a(this.g);
        this.e.a(this);
        this.f.a(this);
        this.g.a(this);
    }

    @Override // com.component.lottie.a.b.a.InterfaceC0322a
    public void a() {
        for (int i = 0; i < this.c.size(); i++) {
            this.c.get(i).a();
        }
    }

    @Override // com.component.lottie.a.a.d
    public void a(List<d> list, List<d> list2) {
    }

    @Override // com.component.lottie.a.a.d
    public String b() {
        return this.a;
    }

    void a(a.InterfaceC0322a interfaceC0322a) {
        this.c.add(interfaceC0322a);
    }

    t.a c() {
        return this.d;
    }

    public com.component.lottie.a.b.a<?, Float> d() {
        return this.e;
    }

    public com.component.lottie.a.b.a<?, Float> e() {
        return this.f;
    }

    public com.component.lottie.a.b.a<?, Float> f() {
        return this.g;
    }

    public boolean g() {
        return this.b;
    }
}

package com.style.widget.e;

import com.style.widget.e.f;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class r implements v {
    final /* synthetic */ f a;

    r(f fVar) {
        this.a = fVar;
    }

    @Override // com.style.widget.e.v
    public boolean a(com.component.a.f.d dVar) {
        if (this.a.E != null) {
            this.a.c();
            return this.a.E.a(dVar);
        }
        return false;
    }

    @Override // com.style.widget.e.v
    public void a() {
        if (this.a.t != null) {
            this.a.t.f();
        }
        if (this.a.u != null) {
            this.a.u.f();
        }
        Iterator it = this.a.D.iterator();
        while (it.hasNext()) {
            ((f.b) it.next()).b();
        }
    }

    @Override // com.style.widget.e.v
    public void b() {
        if (this.a.t != null) {
            this.a.t.g();
        }
        if (this.a.u != null) {
            this.a.u.g();
        }
        Iterator it = this.a.D.iterator();
        while (it.hasNext()) {
            ((f.b) it.next()).c();
        }
    }

    @Override // com.style.widget.e.v
    public void c() {
        if (this.a.t != null) {
            int iZ = (int) this.a.k.z();
            this.a.t.a(iZ, iZ, 1);
            this.a.t.e();
        }
        if (this.a.u != null) {
            int iZ2 = (int) this.a.k.z();
            this.a.u.a(iZ2, iZ2, 1);
            this.a.u.e();
        }
        Iterator it = this.a.D.iterator();
        while (it.hasNext()) {
            ((f.b) it.next()).a();
        }
    }

    @Override // com.style.widget.e.v
    public void d() {
        if (this.a.t != null) {
            this.a.t.h();
            this.a.t.setVisibility(8);
            this.a.t = null;
        }
        if (this.a.u != null) {
            this.a.u.h();
            this.a.u.setVisibility(8);
            this.a.u = null;
        }
        Iterator it = this.a.D.iterator();
        while (it.hasNext()) {
            ((f.b) it.next()).e();
        }
    }

    @Override // com.style.widget.e.v
    public void e() {
        if (this.a.t != null) {
            this.a.t.h();
            this.a.t.setVisibility(8);
            this.a.t = null;
        }
        if (this.a.u != null) {
            this.a.u.h();
            this.a.u.setVisibility(8);
            this.a.u = null;
        }
        if (this.a.C != null) {
            this.a.C.setVisibility(8);
            this.a.C = null;
        }
        Iterator it = this.a.D.iterator();
        while (it.hasNext()) {
            ((f.b) it.next()).d();
        }
        this.a.a(com.component.a.g.b.b.f);
    }
}

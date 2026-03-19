package com.qq.e.comm.plugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class yz {
    private a00 d;
    private xz f;
    private boolean g;
    private final AtomicReference<Boolean> a = new AtomicReference<>(null);
    private final AtomicInteger b = new AtomicInteger(0);
    private final nl c = new nl();
    private final List<a00> e = new ArrayList(4);

    yz() {
    }

    public boolean e() {
        return this.c.a == null;
    }

    /* compiled from: A */
    class a implements ml {
        final /* synthetic */ a00 a;

        a(a00 a00Var) {
            this.a = a00Var;
        }

        @Override // com.qq.e.comm.plugin.ml
        public void e() {
            if (yz.this.e() || !qm$h$$ExternalSyntheticBackport0.m(yz.this.a, Boolean.FALSE, Boolean.TRUE)) {
                return;
            }
            yz.this.d = this.a;
            yz.this.c.e();
        }

        @Override // com.qq.e.comm.plugin.ml
        public void a(db dbVar) {
            if (!yz.this.e() && yz.this.b.decrementAndGet() == 0 && qm$h$$ExternalSyntheticBackport0.m(yz.this.a, Boolean.FALSE, Boolean.TRUE)) {
                yz.this.c.a(dbVar);
            }
        }
    }

    public void a() {
        this.a.set(null);
        this.c.a = null;
        for (a00 a00Var : this.e) {
            if (a00Var != null) {
                a00Var.a();
            }
        }
        this.e.clear();
    }

    public String d() {
        a00 a00Var = this.d;
        if (a00Var == null) {
            return null;
        }
        return a00Var.e();
    }

    mu c() {
        a00 a00Var = this.d;
        if (a00Var == null) {
            return null;
        }
        return a00Var.d();
    }

    public File b() {
        a00 a00Var = this.d;
        if (a00Var == null) {
            return null;
        }
        return a00Var.c();
    }

    void a(mu muVar) {
        if (muVar == null || e()) {
            return;
        }
        if (qm$h$$ExternalSyntheticBackport0.m(this.a, null, Boolean.FALSE) || !this.a.get().booleanValue()) {
            this.b.incrementAndGet();
            a00 a00Var = new a00(this.g);
            if (this.d == null) {
                this.d = a00Var;
            }
            a00Var.a(this.f, new a(a00Var));
            a00Var.b();
            this.e.add(a00Var);
        }
    }

    public void a(xz xzVar, ml mlVar) {
        this.f = xzVar;
        this.g = xzVar.q;
        this.c.a = mlVar;
        this.a.set(null);
        this.b.set(0);
    }

    public void a(boolean z) {
        this.g = z;
    }
}

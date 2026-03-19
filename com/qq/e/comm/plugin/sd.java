package com.qq.e.comm.plugin;

import android.content.Context;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class sd {
    protected h4 a;

    public abstract void a(Context context);

    public abstract boolean a();

    public abstract int b();

    public abstract int c();

    public abstract String d();

    public abstract int e();

    public abstract long f();

    public abstract int h();

    public boolean i() {
        return r1.d().c().A();
    }

    public abstract boolean j();

    public abstract boolean k();

    public abstract boolean m();

    public abstract boolean n();

    public abstract boolean o();

    public abstract boolean p();

    public abstract void q();

    public abstract void r();

    public abstract boolean s();

    public sd(h4 h4Var) {
        this.a = h4Var;
    }

    public boolean l() {
        try {
            return true ^ hd.c(this.a.y0()).optBoolean("autoPlayMuted", true);
        } catch (Exception e) {
            e.getMessage();
            return true;
        }
    }

    public String g() {
        return this.a.s0();
    }
}

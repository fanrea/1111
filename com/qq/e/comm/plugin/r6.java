package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class r6 {
    protected final l20 a;
    protected boolean b;
    private boolean c;

    public abstract int a();

    protected abstract void c();

    protected abstract void d();

    public r6(l20 l20Var) {
        this.a = l20Var;
    }

    protected int a(long j) {
        int iA = ((int) ((a() - j) + 500)) / 1000;
        if (iA == 0) {
            return 1;
        }
        return iA;
    }

    public boolean b() {
        return this.c;
    }

    public void b(long j) {
        if (this.c || this.a == null) {
            return;
        }
        if (a() - j <= 0) {
            this.c = true;
            c();
        } else if (this.b) {
            this.a.a((CharSequence) String.valueOf(a(j)));
        } else {
            this.b = true;
            d();
        }
    }
}

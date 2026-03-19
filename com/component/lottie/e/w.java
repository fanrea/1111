package com.component.lottie.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
final class w {
    static final int a = 8192;
    static final int b = 1024;
    final byte[] c;
    int d;
    int e;
    boolean f;
    boolean g;
    w h;
    w i;

    w() {
        this.c = new byte[8192];
        this.g = true;
        this.f = false;
    }

    w(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.c = bArr;
        this.d = i;
        this.e = i2;
        this.f = z;
        this.g = z2;
    }

    final w a() {
        this.f = true;
        return new w(this.c, this.d, this.e, true, false);
    }

    final w b() {
        return new w((byte[]) this.c.clone(), this.d, this.e, false, true);
    }

    public final w c() {
        w wVar = this.h != this ? this.h : null;
        this.i.h = this.h;
        this.h.i = this.i;
        this.h = null;
        this.i = null;
        return wVar;
    }

    public final w a(w wVar) {
        wVar.i = this;
        wVar.h = this.h;
        this.h.i = wVar;
        this.h = wVar;
        return wVar;
    }

    public final w a(int i) {
        w wVarA;
        if (i <= 0 || i > this.e - this.d) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            wVarA = a();
        } else {
            wVarA = x.a();
            System.arraycopy(this.c, this.d, wVarA.c, 0, i);
        }
        wVarA.e = wVarA.d + i;
        this.d += i;
        this.i.a(wVarA);
        return wVarA;
    }

    public final void d() {
        if (this.i == this) {
            throw new IllegalStateException();
        }
        if (!this.i.g) {
            return;
        }
        int i = this.e - this.d;
        if (i > (8192 - this.i.e) + (this.i.f ? 0 : this.i.d)) {
            return;
        }
        a(this.i, i);
        c();
        x.a(this);
    }

    public final void a(w wVar, int i) {
        if (!wVar.g) {
            throw new IllegalArgumentException();
        }
        if (wVar.e + i > 8192) {
            if (wVar.f) {
                throw new IllegalArgumentException();
            }
            if ((wVar.e + i) - wVar.d > 8192) {
                throw new IllegalArgumentException();
            }
            System.arraycopy(wVar.c, wVar.d, wVar.c, 0, wVar.e - wVar.d);
            wVar.e -= wVar.d;
            wVar.d = 0;
        }
        System.arraycopy(this.c, this.d, wVar.c, wVar.e, i);
        wVar.e += i;
        this.d += i;
    }
}

package com.bytedance.sdk.component.b.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class e {
    e an;
    int b;
    boolean c;
    final byte[] d;
    e h;
    int hc;
    boolean u;

    e() {
        this.d = new byte[8192];
        this.u = true;
        this.c = false;
    }

    e(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.d = bArr;
        this.hc = i;
        this.b = i2;
        this.c = z;
        this.u = z2;
    }

    final e d() {
        this.c = true;
        return new e(this.d, this.hc, this.b, true, false);
    }

    public final e hc() {
        e eVar = this.an;
        e eVar2 = eVar != this ? eVar : null;
        e eVar3 = this.h;
        if (eVar3 != null) {
            eVar3.an = eVar;
        }
        e eVar4 = this.an;
        if (eVar4 != null) {
            eVar4.h = eVar3;
        }
        this.an = null;
        this.h = null;
        return eVar2;
    }

    public final e d(e eVar) {
        eVar.h = this;
        eVar.an = this.an;
        this.an.h = eVar;
        this.an = eVar;
        return eVar;
    }

    public final e d(int i) {
        e eVarD;
        if (i <= 0 || i > this.b - this.hc) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            eVarD = d();
        } else {
            eVarD = cb.d();
            System.arraycopy(this.d, this.hc, eVarD.d, 0, i);
        }
        eVarD.b = eVarD.hc + i;
        this.hc += i;
        this.h.d(eVarD);
        return eVarD;
    }

    public final void b() {
        e eVar = this.h;
        if (eVar == this) {
            throw new IllegalStateException();
        }
        if (eVar.u) {
            int i = this.b - this.hc;
            if (i > (8192 - eVar.b) + (eVar.c ? 0 : eVar.hc)) {
                return;
            }
            d(eVar, i);
            hc();
            cb.d(this);
        }
    }

    public final void d(e eVar, int i) {
        if (!eVar.u) {
            throw new IllegalArgumentException();
        }
        int i2 = eVar.b;
        if (i2 + i > 8192) {
            if (eVar.c) {
                throw new IllegalArgumentException();
            }
            int i3 = eVar.hc;
            if ((i2 + i) - i3 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = eVar.d;
            System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
            eVar.b -= eVar.hc;
            eVar.hc = 0;
        }
        System.arraycopy(this.d, this.hc, eVar.d, eVar.b, i);
        eVar.b += i;
        this.hc += i;
    }
}

package com.bytedance.sdk.component.hc.d.hc;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class an {
    an an;
    int b;
    boolean c;
    final byte[] d;
    an h;
    int hc;
    boolean u;

    an() {
        this.d = new byte[8192];
        this.u = true;
        this.c = false;
    }

    an(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.d = bArr;
        this.hc = i;
        this.b = i2;
        this.c = z;
        this.u = z2;
    }

    final an d() {
        this.c = true;
        return new an(this.d, this.hc, this.b, true, false);
    }

    public final an hc() {
        an anVar = this.an;
        an anVar2 = anVar != this ? anVar : null;
        an anVar3 = this.h;
        if (anVar3 != null) {
            anVar3.an = anVar;
        }
        an anVar4 = this.an;
        if (anVar4 != null) {
            anVar4.h = anVar3;
        }
        this.an = null;
        this.h = null;
        return anVar2;
    }

    public final an d(an anVar) {
        anVar.h = this;
        anVar.an = this.an;
        this.an.h = anVar;
        this.an = anVar;
        return anVar;
    }
}

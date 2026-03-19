package com.kwad.sdk.pngencrypt;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class p {
    byte[] buf;
    public final e cgQ;
    int chA;
    int chB;
    int chC;
    public final k chM;
    int chw;
    int chz;
    public final boolean cio;
    int cip;
    int ciq;
    int cir;
    int cis;
    int cit;
    int ciu;
    int civ;

    public p(k kVar, e eVar) {
        this.chM = kVar;
        this.cgQ = eVar;
        this.cio = eVar != null;
    }

    final void update(int i) {
        this.cip = i;
        if (this.cio) {
            this.chw = this.cgQ.amC();
            this.chA = this.cgQ.chA;
            this.chz = this.cgQ.chz;
            this.chC = this.cgQ.chC;
            this.chB = this.cgQ.chB;
            this.ciq = this.cgQ.amB();
            this.cir = this.cgQ.amA();
            this.cis = this.cgQ.amD();
            this.cit = this.cgQ.amE();
            this.ciu = ((this.chM.chW * this.cit) + 7) / 8;
            return;
        }
        this.chw = 1;
        this.chz = 1;
        this.chA = 1;
        this.chB = 0;
        this.chC = 0;
        this.cir = i;
        this.ciq = i;
        this.cis = this.chM.chx;
        this.cit = this.chM.chy;
        this.ciu = this.chM.chY;
    }

    final void j(byte[] bArr, int i) {
        this.buf = bArr;
        this.civ = i;
    }
}

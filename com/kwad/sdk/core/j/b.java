package com.kwad.sdk.core.j;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class b implements c {
    private boolean bLu = false;
    private boolean SX = false;
    private boolean SY = false;

    protected abstract void aP();

    protected abstract void aQ();

    @Override // com.kwad.sdk.core.j.c
    public final void by() {
        this.bLu = true;
        if (this.SY) {
            return;
        }
        aP();
        this.SY = true;
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bz() {
        if (this.bLu && !this.SX) {
            aQ();
            this.SX = true;
        }
    }
}

package com.kwad.components.ad.reward.presenter.f;

import com.kwad.components.ad.reward.g;
import com.kwad.components.core.webview.jshandler.ba;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e implements g.a {
    private boolean BM;
    private boolean BN;
    private ba eK;

    private void km() {
        ba baVar = this.eK;
        if (baVar == null || !this.BN) {
            return;
        }
        if (!this.BM) {
            baVar.vd();
            this.eK.ve();
            this.BM = true;
            return;
        }
        baVar.vh();
    }

    public final void b(ba baVar) {
        this.eK = baVar;
    }

    public final void A(com.kwad.components.ad.reward.g gVar) {
        gVar.a(this);
    }

    public final void B(com.kwad.components.ad.reward.g gVar) {
        ba baVar = this.eK;
        if (baVar != null) {
            baVar.vf();
            this.eK.vg();
        }
        gVar.b(this);
    }

    public final void aE() {
        km();
    }

    public final void kn() {
        ba baVar = this.eK;
        if (baVar != null) {
            baVar.vf();
            this.eK.vg();
        }
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hh() {
        this.BN = true;
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hi() {
        this.BN = true;
        km();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hj() {
        this.BN = false;
        ba baVar = this.eK;
        if (baVar != null) {
            baVar.vi();
        }
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hk() {
        this.BN = false;
    }
}

package com.kwad.components.ct.home.c;

import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.sdk.R;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ao;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class j extends com.kwad.components.ct.home.e {
    private SlidePlayViewPager aok;
    private com.kwad.components.core.widget.a.b asB;
    private com.kwad.components.ct.api.a.a.c ayi;
    private com.kwad.components.ct.api.a.a.b ayn = new com.kwad.components.ct.home.b.d() { // from class: com.kwad.components.ct.home.c.j.1
        @Override // com.kwad.components.ct.home.b.d, com.kwad.components.ct.api.a.a.b
        public final void c(boolean z, int i, int i2) {
            super.c(z, i, i2);
            if (NetworkMonitor.getInstance().WU() && j.this.asB != null && j.this.asB.wO() && ao.isMobileConnected(j.this.getContext())) {
                j.this.GM();
                j.this.GK();
            }
        }
    };
    private NetworkMonitor.a aKk = new NetworkMonitor.a() { // from class: com.kwad.components.ct.home.c.j.2
        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public final void a(NetworkMonitor.NetworkState networkState) {
            if (networkState != NetworkMonitor.NetworkState.NETWORK_MOBILE || !NetworkMonitor.getInstance().WU() || j.this.aok == null || j.this.aok.isEmpty() || j.this.asB == null || !j.this.asB.wO()) {
                return;
            }
            j.this.GM();
            j.this.GK();
            j.this.GL();
        }
    };

    @Override // com.kwad.components.ct.home.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.ct.home.j jVar = this.aGP.aol;
        if (jVar == null) {
            return;
        }
        com.kwad.components.core.widget.a.b bVar = jVar.aFs;
        this.asB = bVar;
        if (bVar == null) {
            return;
        }
        this.ayi = this.aGP.ayi;
        this.aok = this.aGP.aok;
        this.ayi.a(this.ayn);
        NetworkMonitor.getInstance().a(ServiceProvider.getContext(), this.aKk);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        GK();
        GL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GK() {
        if (this.aKk != null) {
            NetworkMonitor.getInstance().a(this.aKk);
            this.aKk = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GL() {
        com.kwad.components.ct.api.a.a.c cVar = this.ayi;
        if (cVar != null) {
            cVar.b(this.ayn);
            this.ayn = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GM() {
        ac.ae(getContext(), getContext().getString(R.string.ksad_network_dataFlow_tip));
        NetworkMonitor.getInstance().WV();
    }
}

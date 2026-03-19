package com.kwad.sdk.lib.a.b;

import com.kwad.components.ct.refreshview.RefreshLayout;
import com.kwad.sdk.lib.a.a.b;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.b.g;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ao;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d<MODEL, CallerContext extends com.kwad.sdk.lib.a.a.b<?, MODEL>> extends com.kwad.sdk.lib.a.a.a<MODEL, CallerContext> {
    private com.kwad.sdk.lib.widget.a.c<MODEL, ?> aFU;
    private com.kwad.sdk.lib.b.c<?, MODEL> avY;
    private RefreshLayout cci;
    private final RefreshLayout.b aBx = new RefreshLayout.b() { // from class: com.kwad.sdk.lib.a.b.d.1
        @Override // com.kwad.components.ct.refreshview.RefreshLayout.b
        public final void onRefresh() {
            if (!ao.isNetworkConnected(d.this.getContext())) {
                ac.dm(d.this.getContext());
                d.this.cci.setRefreshing(false);
            } else {
                d.this.avY.refresh();
            }
        }
    };
    private f awa = new g() { // from class: com.kwad.sdk.lib.a.b.d.2
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void m(boolean z, boolean z2) {
            if (!z || d.this.aFU.isEmpty() || z2) {
                return;
            }
            d.this.cci.setRefreshing(true);
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void n(boolean z, boolean z2) {
            if (z) {
                if (!d.this.aFU.isEmpty()) {
                    d.this.cci.setEnabled(true);
                }
                d.this.cci.setRefreshing(false);
            }
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void a(boolean z, int i, String str) {
            if (z) {
                d.this.cci.setRefreshing(false);
            }
        }
    };

    @Override // com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.cci = this.cck.cci;
        this.avY = (com.kwad.sdk.lib.b.c<?, MODEL>) this.cck.avY;
        this.aFU = this.cck.aFU;
        this.cci.setEnabled(false);
        this.cci.setNestedScrollingEnabled(true);
        this.cci.setOnRefreshListener(this.aBx);
        this.avY.a(this.awa);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.cci.setOnRefreshListener(null);
        this.avY.b(this.awa);
    }
}

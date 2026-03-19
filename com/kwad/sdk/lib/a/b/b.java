package com.kwad.sdk.lib.a.b;

import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.lib.a.a.b;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.b.g;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b<PAGE, MODEL, CallerContext extends com.kwad.sdk.lib.a.a.b<PAGE, MODEL>> extends com.kwad.sdk.lib.a.a.a<MODEL, CallerContext> {
    private RecyclerView Wj;
    private com.kwad.sdk.lib.widget.a.c<MODEL, ?> aFU;
    private com.kwad.sdk.lib.widget.a.d aFW;
    private com.kwad.sdk.lib.b.c<PAGE, MODEL> avY;
    private f awa = new g() { // from class: com.kwad.sdk.lib.a.b.b.1
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void a(boolean z, int i, String str) {
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void m(boolean z, boolean z2) {
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void n(boolean z, boolean z2) {
            if (b.this.ccw && b.this.Wj.getLayoutManager() == null) {
                b.this.akL();
            }
        }
    };
    private com.kwad.sdk.lib.a.b<PAGE> cct;
    private boolean ccw;

    public b(boolean z) {
        this.ccw = z;
    }

    @Override // com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.Wj = this.cck.Wj;
        this.avY = this.cck.avY;
        this.aFU = this.cck.aFU;
        this.aFW = this.cck.aFW;
        this.aFU.aC(this.avY.getItems());
        this.aFU.a((com.kwad.sdk.lib.b.c<?, MODEL>) this.cck.avY);
        this.Wj.setAdapter(this.aFW);
        this.cct = this.cck.cct;
        if (this.ccw) {
            this.avY.a(this.awa);
        } else {
            akL();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.ccw) {
            this.avY.a(this.awa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akL() {
        this.Wj.setItemAnimator(null);
        RecyclerView.ItemDecoration itemDecorationI = this.cct.i(this.avY.akR());
        if (itemDecorationI != null) {
            this.Wj.addItemDecoration(itemDecorationI);
        }
        this.Wj.setLayoutManager(this.cct.h(this.avY.akR()));
        this.aFW.d(this.Wj);
    }
}

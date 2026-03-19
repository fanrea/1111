package com.kwad.sdk.lib.a.b;

import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.lib.a.a.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a<MODEL, CallerContext extends com.kwad.sdk.lib.a.a.b<?, MODEL>> extends com.kwad.sdk.lib.a.a.a<MODEL, CallerContext> {
    private RecyclerView Wj;
    private com.kwad.sdk.lib.widget.a.c<MODEL, ?> aFU;
    private RecyclerView.OnScrollListener asg = new RecyclerView.OnScrollListener() { // from class: com.kwad.sdk.lib.a.b.a.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                a.this.Bt();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i > 0 || i2 > 0) {
                a.this.Bt();
            }
        }
    };
    private com.kwad.sdk.lib.b.c<?, MODEL> avY;

    @Override // com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.Wj = this.cck.Wj;
        this.avY = (com.kwad.sdk.lib.b.c<?, MODEL>) this.cck.avY;
        this.aFU = this.cck.aFU;
        this.Wj.addOnScrollListener(this.asg);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Wj.removeOnScrollListener(this.asg);
    }

    public final void Bt() {
        RecyclerView.LayoutManager layoutManager = this.Wj.getLayoutManager();
        if (layoutManager.getChildCount() <= 0 || !Bu()) {
            return;
        }
        if (((RecyclerView.LayoutParams) layoutManager.getChildAt(layoutManager.getChildCount() - 1).getLayoutParams()).getViewAdapterPosition() < this.aFU.getItemCount() - this.cck.ccu || this.aFU.akU()) {
            return;
        }
        this.avY.akN();
    }

    private boolean Bu() {
        com.kwad.sdk.lib.b.c<?, MODEL> cVar = this.avY;
        return (cVar == null || cVar.KE() == null || this.avY.KE().isEmpty()) ? false : true;
    }
}

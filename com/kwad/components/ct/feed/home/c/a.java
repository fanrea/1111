package com.kwad.components.ct.feed.home.c;

import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.lib.widget.a.d;
import com.kwad.sdk.lib.widget.a.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.feed.home.b.a {
    private RecyclerView Wj;
    private com.kwad.sdk.lib.widget.a.c<CtAdTemplate, ?> aFU;
    private RecyclerView.OnScrollListener asg = new RecyclerView.OnScrollListener() { // from class: com.kwad.components.ct.feed.home.c.a.1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
            RecyclerView.Adapter adapter;
            int iAkW;
            super.onScrolled(recyclerView, i, i2);
            if (a.this.Wj == null || a.this.aFU == null || (adapter = a.this.Wj.getAdapter()) == null || adapter.getItemCount() == 0) {
                return;
            }
            int iE = e.e(a.this.Wj);
            int iF = e.f(a.this.Wj);
            if (-1 == iE || -1 == iF) {
                return;
            }
            com.kwad.sdk.core.d.c.d("FeedHomeItemVisiblePresenter", "firstVisible=" + iE + "--lastVisible=" + iF);
            RecyclerView.LayoutManager layoutManager = a.this.Wj.getLayoutManager();
            while (iE <= iF) {
                if (adapter instanceof d) {
                    d dVar = (d) adapter;
                    if (a.a(a.this, iE, dVar)) {
                        iE++;
                    } else {
                        iAkW = iE - dVar.akW();
                    }
                } else {
                    iAkW = iE;
                }
                CtAdTemplate ctAdTemplate = (CtAdTemplate) a.this.aFU.getItem(iAkW);
                if (ctAdTemplate != null) {
                    if (layoutManager.findViewByPosition(iE).getGlobalVisibleRect(new Rect())) {
                        a.this.a(ctAdTemplate, r3.height() / (r2.getHeight() * 1.0f));
                    }
                }
                iE++;
            }
        }
    };

    static /* synthetic */ boolean a(a aVar, int i, d dVar) {
        return a(i, dVar);
    }

    @Override // com.kwad.components.ct.feed.home.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aFU = this.aFr.aFU;
        RecyclerView recyclerView = this.aFr.Wj;
        this.Wj = recyclerView;
        recyclerView.addOnScrollListener(this.asg);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Wj.clearOnScrollListeners();
    }

    private static boolean a(int i, d dVar) {
        return dVar.gB(i) || dVar.gC(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CtAdTemplate ctAdTemplate, float f) {
        e.a aVar = this.aFr.aFK.get(ctAdTemplate.mUniqueId);
        if (aVar != null) {
            aVar.v(f);
        }
    }
}

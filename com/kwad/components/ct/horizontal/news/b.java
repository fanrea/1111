package com.kwad.components.ct.horizontal.news;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.lib.widget.a.b.a;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.sdk.lib.widget.a.c<CtAdTemplate, com.kwad.components.ct.horizontal.news.a.a.b> {
    private final com.kwad.components.ct.horizontal.news.b.b aNx;

    @Override // com.kwad.sdk.lib.widget.a.c
    public final /* synthetic */ a.C0623a Bm() {
        return HT();
    }

    public b(KsFragment ksFragment, RecyclerView recyclerView, com.kwad.components.ct.horizontal.news.b.b bVar) {
        super(ksFragment, recyclerView, new com.kwad.components.ct.widget.a.a.a());
        this.aNx = bVar;
    }

    @Override // com.kwad.sdk.lib.widget.a.c
    public final View f(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return com.kwad.sdk.c.a.a.a(viewGroup, R.layout.ksad_news_detail_item_ad, false);
        }
        if (i == 2) {
            return com.kwad.sdk.c.a.a.a(viewGroup, R.layout.ksad_news_detail_item_news, false);
        }
        return new View(viewGroup.getContext());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        CtAdTemplate ctAdTemplate;
        if (this.ccN == null || i >= this.ccN.size() || (ctAdTemplate = (CtAdTemplate) this.ccN.get(i)) == null) {
            return -1;
        }
        if (com.kwad.components.ct.response.a.a.eH(ctAdTemplate)) {
            return 1;
        }
        return com.kwad.components.ct.response.a.a.at(ctAdTemplate) ? 2 : -1;
    }

    @Override // com.kwad.sdk.lib.widget.a.c
    public final Presenter bK(int i) {
        Presenter presenter = new Presenter();
        if (i == 1) {
            presenter.d(new com.kwad.components.ct.horizontal.news.a.b.b());
            presenter.d(new com.kwad.components.ct.horizontal.news.a.b.a());
        } else if (i == 2) {
            presenter.d(new com.kwad.components.ct.horizontal.news.a.b.b());
            presenter.d(new com.kwad.components.ct.horizontal.news.a.b.e());
            presenter.d(new com.kwad.components.ct.horizontal.news.a.b.d());
            presenter.d(new com.kwad.components.ct.horizontal.news.a.b.c());
        }
        return presenter;
    }

    private static com.kwad.components.ct.horizontal.news.a.a.b HT() {
        return new com.kwad.components.ct.horizontal.news.a.a.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.lib.widget.a.c
    public void a(com.kwad.components.ct.horizontal.news.a.a.b bVar, int i) {
        super.a((b) bVar, i);
        bVar.aNx = this.aNx;
        bVar.mScene = this.aNx.mSceneImpl;
        CtAdTemplate ctAdTemplate = (CtAdTemplate) this.ccN.get(i);
        if (!com.kwad.components.ct.response.a.a.as(ctAdTemplate) && com.kwad.sdk.core.response.b.a.aJ(com.kwad.components.ct.response.a.a.eP(ctAdTemplate))) {
            bVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(ctAdTemplate);
        } else {
            bVar.mApkDownloadHelper = null;
        }
    }
}

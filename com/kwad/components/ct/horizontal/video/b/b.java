package com.kwad.components.ct.horizontal.video.b;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.ct.horizontal.video.b.a.b.d;
import com.kwad.components.ct.horizontal.video.b.a.b.e;
import com.kwad.components.ct.horizontal.video.b.a.b.f;
import com.kwad.components.ct.horizontal.video.b.a.b.g;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.sdk.lib.widget.a.c<CtAdTemplate, com.kwad.components.ct.horizontal.video.b.a.a.b> {
    private final com.kwad.components.ct.horizontal.feed.a aLL;
    private com.kwad.components.ct.horizontal.video.b.b.b aPb;

    private static boolean cw(int i) {
        return i <= 200 && i > 100;
    }

    @Override // com.kwad.sdk.lib.widget.a.c
    public final boolean l(boolean z, boolean z2) {
        return z && !z2;
    }

    public b(KsFragment ksFragment, RecyclerView recyclerView, com.kwad.components.ct.horizontal.video.b.b.b bVar) {
        super(ksFragment, recyclerView);
        this.aPb = bVar;
        this.aLL = new com.kwad.components.ct.horizontal.feed.a();
    }

    @Override // com.kwad.sdk.lib.widget.a.c
    public final View f(ViewGroup viewGroup, int i) {
        View viewG;
        if (cw(i) && (viewG = com.kwad.components.ct.horizontal.feed.a.g(viewGroup, i - 100)) != null) {
            return viewG;
        }
        if (i == 1) {
            return com.kwad.sdk.c.a.a.a(viewGroup, R.layout.ksad_horizontal_detail_video_related_item_layout, false);
        }
        return new View(viewGroup.getContext());
    }

    @Override // com.kwad.sdk.lib.widget.a.c
    public final Presenter bK(int i) {
        Presenter presenter = new Presenter();
        if (cw(i)) {
            com.kwad.components.ct.horizontal.feed.a.a(i - 100, presenter, new com.kwad.components.ct.horizontal.video.b.a.b.a());
            return presenter;
        }
        if (i == 1) {
            presenter.d(new d());
            presenter.d(new com.kwad.components.ct.horizontal.video.b.a.b.b());
            presenter.d(new f());
            presenter.d(new g());
            presenter.d(new com.kwad.components.ct.horizontal.video.b.a.b.c());
            presenter.d(new e());
        }
        return presenter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        CtAdTemplate ctAdTemplate;
        if (this.ccN == null || i >= this.ccN.size() || (ctAdTemplate = (CtAdTemplate) this.ccN.get(i)) == null) {
            return 0;
        }
        if (com.kwad.components.ct.response.a.a.eH(ctAdTemplate)) {
            return this.aLL.z(ctAdTemplate) + 100;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.lib.widget.a.c
    /* renamed from: IC, reason: merged with bridge method [inline-methods] */
    public com.kwad.components.ct.horizontal.video.b.a.a.b Bm() {
        com.kwad.components.ct.horizontal.video.b.a.a.b bVar = new com.kwad.components.ct.horizontal.video.b.a.a.b();
        bVar.aFU = this;
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.lib.widget.a.c
    public void a(com.kwad.components.ct.horizontal.video.b.a.a.b bVar, int i) {
        super.a((b) bVar, i);
        CtAdTemplate ctAdTemplate = (CtAdTemplate) this.ccN.get(i);
        if (com.kwad.components.ct.response.a.a.eH(ctAdTemplate) && com.kwad.sdk.core.response.b.a.aJ(com.kwad.components.ct.response.a.a.eP(ctAdTemplate))) {
            bVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(ctAdTemplate);
        } else {
            bVar.mApkDownloadHelper = null;
        }
        bVar.aPb = this.aPb;
    }
}

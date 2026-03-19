package com.kwad.components.ct.tube.panel.choose;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.lib.widget.a.b.a;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.sdk.lib.widget.a.c<CtAdTemplate, com.kwad.components.ct.tube.panel.choose.a.a.b> {
    private final com.kwad.components.ct.tube.panel.choose.b.b aXl;

    @Override // com.kwad.sdk.lib.widget.a.c
    public final /* synthetic */ a.C0623a Bm() {
        return KC();
    }

    public a(KsFragment ksFragment, RecyclerView recyclerView, com.kwad.components.ct.tube.panel.choose.b.b bVar) {
        super(ksFragment, recyclerView, new com.kwad.components.ct.widget.a.a.a());
        this.aXl = bVar;
    }

    @Override // com.kwad.sdk.lib.widget.a.c
    public final View f(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new View(viewGroup.getContext());
        }
        return com.kwad.sdk.c.a.a.a(viewGroup, R.layout.ksad_tube_panel_episode_choose_item, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        return getItem(i).contentType == 2 ? 1 : 2;
    }

    @Override // com.kwad.sdk.lib.widget.a.c
    public final Presenter bK(int i) {
        Presenter presenter = new Presenter();
        if (i == 2) {
            presenter.d(new com.kwad.components.ct.tube.panel.choose.a.b.b());
            presenter.d(new com.kwad.components.ct.tube.panel.choose.a.b.a());
            presenter.d(new com.kwad.components.ct.tube.panel.choose.a.b.c());
        }
        return presenter;
    }

    private static com.kwad.components.ct.tube.panel.choose.a.a.b KC() {
        return new com.kwad.components.ct.tube.panel.choose.a.a.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.lib.widget.a.c
    public void a(com.kwad.components.ct.tube.panel.choose.a.a.b bVar, int i) {
        super.a((a) bVar, i);
        bVar.aXl = this.aXl;
        bVar.mSceneImpl = this.aXl.mSceneImpl;
        bVar.aXr = this.aXl.aXr;
        bVar.aFU = this;
    }
}

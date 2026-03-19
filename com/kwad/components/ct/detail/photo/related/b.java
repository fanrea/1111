package com.kwad.components.ct.detail.photo.related;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.lib.widget.a.b.a;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.sdk.lib.widget.a.c<CtAdTemplate, com.kwad.components.ct.detail.photo.related.a.b> {
    private CtAdTemplate mEntryAdTemplate;

    @Override // com.kwad.sdk.lib.widget.a.c
    public final boolean l(boolean z, boolean z2) {
        return z && !z2;
    }

    @Override // com.kwad.sdk.lib.widget.a.c
    public final /* synthetic */ a.C0623a Bm() {
        return Bl();
    }

    public b(KsFragment ksFragment, RecyclerView recyclerView, CtAdTemplate ctAdTemplate) {
        super(ksFragment, recyclerView, new com.kwad.components.ct.widget.a.a.a());
        this.mEntryAdTemplate = ctAdTemplate;
    }

    @Override // com.kwad.sdk.lib.widget.a.c
    public final View f(ViewGroup viewGroup, int i) {
        return com.kwad.sdk.c.a.a.a(viewGroup, R.layout.ksad_content_related_video_item, false);
    }

    @Override // com.kwad.sdk.lib.widget.a.c
    public final Presenter bK(int i) {
        Presenter presenter = new Presenter();
        presenter.d(new com.kwad.components.ct.detail.photo.related.b.b());
        presenter.d(new com.kwad.components.ct.detail.photo.related.b.c());
        presenter.d(new com.kwad.components.ct.detail.photo.related.b.d());
        presenter.d(new com.kwad.components.ct.detail.photo.related.b.a());
        return presenter;
    }

    private static com.kwad.components.ct.detail.photo.related.a.b Bl() {
        return new com.kwad.components.ct.detail.photo.related.a.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.lib.widget.a.c
    public void a(com.kwad.components.ct.detail.photo.related.a.b bVar, int i) {
        super.a((b) bVar, i);
        bVar.mEntryAdTemplate = this.mEntryAdTemplate;
    }
}

package com.kwad.components.ct.profile.tabvideo;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.ct.profile.tabvideo.a.b.d;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.lib.widget.a.b.a;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.sdk.lib.widget.a.c<CtAdTemplate, com.kwad.components.ct.profile.tabvideo.a.a.b> {
    private ProfileTabVideoParam aRO;

    @Override // com.kwad.sdk.lib.widget.a.c
    public final /* synthetic */ a.C0623a Bm() {
        return Jm();
    }

    public a(com.kwad.sdk.lib.a.c<?, CtAdTemplate> cVar, RecyclerView recyclerView, ProfileTabVideoParam profileTabVideoParam) {
        super(cVar, recyclerView, new com.kwad.components.ct.widget.a.a.a());
        this.aRO = profileTabVideoParam;
    }

    @Override // com.kwad.sdk.lib.widget.a.c
    public final View f(ViewGroup viewGroup, int i) {
        return com.kwad.sdk.c.a.a.a(viewGroup, R.layout.ksad_profile_fragment_tab_video_item_layout, false);
    }

    @Override // com.kwad.sdk.lib.widget.a.c
    public final Presenter bK(int i) {
        Presenter presenter = new Presenter();
        presenter.d(new com.kwad.components.ct.profile.tabvideo.a.b.b());
        presenter.d(new com.kwad.components.ct.profile.tabvideo.a.b.c());
        presenter.d(new d());
        presenter.d(new com.kwad.components.ct.profile.tabvideo.a.b.a());
        return presenter;
    }

    private static com.kwad.components.ct.profile.tabvideo.a.a.b Jm() {
        return new com.kwad.components.ct.profile.tabvideo.a.a.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.lib.widget.a.c
    public void a(com.kwad.components.ct.profile.tabvideo.a.a.b bVar, int i) {
        super.a((a) bVar, i);
        bVar.aRU = this.aRO;
    }
}

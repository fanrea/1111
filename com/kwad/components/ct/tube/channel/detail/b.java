package com.kwad.components.ct.tube.channel.detail;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.lib.widget.a.b.a;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.sdk.lib.widget.a.c<TubeInfo, com.kwad.components.ct.tube.channel.detail.a.a.b> {
    private final com.kwad.components.ct.tube.channel.detail.b.b aVV;

    @Override // com.kwad.sdk.lib.widget.a.c
    public final /* synthetic */ a.C0623a Bm() {
        return Kf();
    }

    public b(KsFragment ksFragment, RecyclerView recyclerView, com.kwad.components.ct.tube.channel.detail.b.b bVar) {
        super(ksFragment, recyclerView, new com.kwad.components.ct.tube.d.a());
        this.aVV = bVar;
    }

    @Override // com.kwad.sdk.lib.widget.a.c
    public final View f(ViewGroup viewGroup, int i) {
        return com.kwad.sdk.c.a.a.a(viewGroup, R.layout.ksad_tube_channel_detail_item, false);
    }

    @Override // com.kwad.sdk.lib.widget.a.c
    public final Presenter bK(int i) {
        Presenter presenter = new Presenter();
        presenter.d(new com.kwad.components.ct.tube.channel.detail.a.b.a());
        presenter.d(new com.kwad.components.ct.tube.channel.detail.a.b.b());
        presenter.d(new com.kwad.components.ct.tube.channel.detail.a.b.c());
        return presenter;
    }

    private static com.kwad.components.ct.tube.channel.detail.a.a.b Kf() {
        return new com.kwad.components.ct.tube.channel.detail.a.a.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.lib.widget.a.c
    public void a(com.kwad.components.ct.tube.channel.detail.a.a.b bVar, int i) {
        super.a((b) bVar, i);
        bVar.aVV = this.aVV;
        bVar.mSceneImpl = this.aVV.mSceneImpl;
        bVar.aVU = this.aVV.aVU;
        bVar.aFU = this.aVV.aFU;
    }
}

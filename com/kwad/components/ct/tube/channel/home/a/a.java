package com.kwad.components.ct.tube.channel.home.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.kwad.components.ct.tube.channel.home.a.a.b.d;
import com.kwad.components.ct.tube.channel.home.c.b;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.lib.widget.a.b.a;
import com.kwad.sdk.lib.widget.a.c;
import com.kwad.sdk.mvp.Presenter;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends c<TubeInfo, com.kwad.components.ct.tube.channel.home.a.a.a.a> {
    private final b aWp;

    @Override // com.kwad.sdk.lib.widget.a.c
    public final /* synthetic */ a.C0623a Bm() {
        return Ko();
    }

    public a(KsFragment ksFragment, RecyclerView recyclerView, b bVar, List<TubeInfo> list) {
        super(ksFragment, recyclerView, list);
        this.aWp = bVar;
    }

    @Override // com.kwad.sdk.lib.widget.a.c
    public final View f(ViewGroup viewGroup, int i) {
        return com.kwad.sdk.c.a.a.a(viewGroup, R.layout.ksad_tube_channel_header_history_card_item, false);
    }

    @Override // com.kwad.sdk.lib.widget.a.c
    public final Presenter bK(int i) {
        Presenter presenter = new Presenter();
        presenter.d(new com.kwad.components.ct.tube.channel.home.a.a.b.b());
        presenter.d(new com.kwad.components.ct.tube.channel.home.a.a.b.a());
        presenter.d(new d());
        presenter.d(new com.kwad.components.ct.tube.channel.home.a.a.b.c());
        return presenter;
    }

    private static com.kwad.components.ct.tube.channel.home.a.a.a.a Ko() {
        return new com.kwad.components.ct.tube.channel.home.a.a.a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.lib.widget.a.c
    public void a(com.kwad.components.ct.tube.channel.home.a.a.a.a aVar, int i) {
        super.a((a) aVar, i);
        aVar.aWp = this.aWp;
        aVar.mSceneImpl = this.aWp.mSceneImpl;
        aVar.aWo = this.aWp.aWo;
        aVar.aFU = this;
    }
}

package com.kwad.components.ad.reward.presenter.d;

import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.ad.reward.presenter.d.b.c;
import com.kwad.components.ad.reward.presenter.d.b.d;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.mvp.Presenter;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a extends com.kwad.components.ad.reward.presenter.b implements g, j {
    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, n nVar) {
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dp() {
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    public a() {
        dy();
    }

    protected void dy() {
        d(new d());
        d(new com.kwad.components.ad.reward.presenter.d.b.a());
        d(new com.kwad.components.ad.reward.presenter.d.b.b());
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        dr();
    }

    private void dr() {
        this.vb.b(this);
        com.kwad.components.ad.reward.a.gl().a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.vb.c(this);
        com.kwad.components.ad.reward.a.gl().b(this);
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void dc() {
        ff();
    }

    private void ff() {
        List<Presenter> listAme = ame();
        if (listAme == null) {
            return;
        }
        for (Object obj : listAme) {
            if (obj instanceof c) {
                ((c) obj).jS();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dq() {
        ff();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(g gVar) {
        return getPriority() - gVar.getPriority();
    }
}

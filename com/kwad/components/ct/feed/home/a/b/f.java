package com.kwad.components.ct.feed.home.a.b;

import android.widget.ImageView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f extends com.kwad.components.ct.feed.home.a.a.a implements com.kwad.components.ct.f.b {
    private com.kwad.components.ct.f.f aDL;
    private ImageView aFw;
    private CtAdTemplate mAdTemplate;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aFw = (ImageView) findViewById(R.id.ksad_feed_item_cover);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.mAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.feed.home.a.a.b) this.cdN).cdM;
        this.aDL = new com.kwad.components.ct.f.f(this);
        com.kwad.components.ct.f.d.Kb().a(this.aDL);
        k(this.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ct.f.d.Kb().b(this.aDL);
    }

    private void k(CtAdTemplate ctAdTemplate) {
        String url = com.kwad.components.ct.response.a.a.aD(ctAdTemplate).getUrl();
        com.kwad.sdk.glide.c.h(((com.kwad.components.ct.feed.home.a.a.b) this.cdN).alG).hh(url).a(new com.kwad.components.ct.b.a(url, ctAdTemplate)).d(getContext().getResources().getDrawable(EZ().aGh)).f(getContext().getResources().getDrawable(EZ().aGh)).b(this.aFw);
    }

    @Override // com.kwad.components.ct.f.b
    public final void cg(int i) {
        k(this.mAdTemplate);
    }
}

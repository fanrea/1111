package com.kwad.components.ct.feed.home.a.b;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e extends com.kwad.components.ct.feed.home.a.a.a implements com.kwad.components.ct.f.b {
    private com.kwad.components.ct.f.f aDL;
    private KSFrameLayout aFD;
    private ImageView aFw;
    private CtAdTemplate mAdTemplate;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aFD = (KSFrameLayout) findViewById(R.id.ksad_cover_container);
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
        com.kwad.sdk.core.response.model.b bVarAD = com.kwad.components.ct.response.a.a.aD(ctAdTemplate);
        int width = bVarAD.getWidth();
        int height = bVarAD.getHeight();
        String url = bVarAD.getUrl();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.aFD.getLayoutParams();
        if (height >= width) {
            marginLayoutParams.width = com.kwad.sdk.c.a.a.j(getContext(), R.dimen.ksad_content_feed_item_single_large_width);
            this.aFD.setRatio(1.3333334f);
        } else {
            marginLayoutParams.width = -1;
            this.aFD.setRatio(0.75f);
        }
        this.aFD.setLayoutParams(marginLayoutParams);
        com.kwad.sdk.glide.c.h(((com.kwad.components.ct.feed.home.a.a.b) this.cdN).alG).hh(url).a(new com.kwad.components.ct.b.a(url, ctAdTemplate)).d(getContext().getResources().getDrawable(EZ().aGg)).f(getContext().getResources().getDrawable(EZ().aGg)).b(this.aFw);
    }

    @Override // com.kwad.components.ct.f.b
    public final void cg(int i) {
        k(this.mAdTemplate);
    }
}

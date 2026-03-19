package com.kwad.components.ct.feed.home.a.b;

import android.view.View;
import android.widget.ImageView;
import com.kwad.components.ct.f.g;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.feed.home.a.a.a implements View.OnClickListener, com.kwad.components.ct.f.b {
    private ImageView Pe;
    private com.kwad.components.ct.f.f aDL;
    private com.kwad.sdk.lib.b.c<?, CtAdTemplate> avY;
    private CtAdTemplate mAdTemplate;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ImageView imageView = (ImageView) findViewById(R.id.ksad_feed_item_close);
        this.Pe = imageView;
        imageView.setOnClickListener(this);
        g.a(this.Pe, EZ().aGe);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.mAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.feed.home.a.a.b) this.cdN).cdM;
        this.avY = ((com.kwad.components.ct.feed.home.a.a.b) this.cdN).avY;
        this.aDL = new com.kwad.components.ct.f.f(this);
        com.kwad.components.ct.f.d.Kb().a(this.aDL);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ct.f.d.Kb().b(this.aDL);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (com.kwad.sdk.c.a.a.Wl()) {
            return;
        }
        if (view == this.Pe && com.kwad.components.ct.response.a.a.eH(this.mAdTemplate)) {
            com.kwad.sdk.core.adlog.c.r(this.mAdTemplate, 69);
        }
        this.avY.remove(this.mAdTemplate);
    }

    @Override // com.kwad.components.ct.f.b
    public final void cg(int i) {
        g.a(this.Pe, EZ().aGe);
    }
}

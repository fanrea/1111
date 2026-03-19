package com.kwad.components.ct.feed.home.a.b.a;

import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ct.feed.home.a.a.a {
    private KsLogoView aFP;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aFP = (KsLogoView) findViewById(R.id.ksad_feed_ad_label);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        CtAdTemplate ctAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.feed.home.a.a.b) this.cdN).cdM;
        if (com.kwad.components.ct.response.a.a.as((CtAdTemplate) ((com.kwad.components.ct.feed.home.a.a.b) this.cdN).cdM)) {
            return;
        }
        this.aFP.aQ(ctAdTemplate);
    }
}

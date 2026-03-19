package com.kwad.components.ct.feed.home.a.b.b;

import android.widget.TextView;
import com.kwad.components.ct.detail.photo.e.h;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.core.j.d;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.feed.home.a.a.a {
    private TextView Fa;
    private d aFS = new d() { // from class: com.kwad.components.ct.feed.home.a.b.b.b.1
        @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
        public final void by() {
            b.this.Fc();
        }
    };
    private TextView awp;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Fa = (TextView) findViewById(R.id.ksad_feed_item_author_name);
        this.awp = (TextView) findViewById(R.id.ksad_feed_item_author_like_count);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        CtAdTemplate ctAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.feed.home.a.a.b) this.cdN).cdM;
        if (((com.kwad.components.ct.feed.home.a.a.b) this.cdN).aFq != null && ((com.kwad.components.ct.feed.home.a.a.b) this.cdN).aFq.aFs != null) {
            ((com.kwad.components.ct.feed.home.a.a.b) this.cdN).aFq.aFs.a(this.aFS);
        }
        String strAL = com.kwad.components.ct.response.a.a.aL(ctAdTemplate);
        if (bq.isNullString(strAL) && com.kwad.components.ct.response.a.a.eH(ctAdTemplate)) {
            strAL = getContext().getString(R.string.ksad_ad_default_username_normal);
        }
        this.Fa.setText(strAL);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.cdN == 0 || ((com.kwad.components.ct.feed.home.a.a.b) this.cdN).aFq == null || ((com.kwad.components.ct.feed.home.a.a.b) this.cdN).aFq.aFs == null) {
            return;
        }
        ((com.kwad.components.ct.feed.home.a.a.b) this.cdN).aFq.aFs.b(this.aFS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void Fc() {
        CtAdTemplate ctAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.feed.home.a.a.b) this.cdN).cdM;
        long jM = com.kwad.components.ct.response.a.c.m((PhotoInfo) ctAdTemplate.photoInfo);
        boolean zY = h.a.Y(com.kwad.components.ct.response.a.c.j((PhotoInfo) ctAdTemplate.photoInfo));
        if (zY) {
            jM++;
        }
        this.awp.setText(bq.bC(jM));
        this.awp.setSelected(zY);
    }
}

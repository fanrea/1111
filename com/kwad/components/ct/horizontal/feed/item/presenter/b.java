package com.kwad.components.ct.horizontal.feed.item.presenter;

import android.graphics.Color;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.glide.load.resource.bitmap.p;
import com.kwad.sdk.utils.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.horizontal.feed.item.a.b {
    private ImageView EZ;
    private TextView Fa;
    private com.kwad.sdk.core.j.d aFS = new com.kwad.sdk.core.j.d() { // from class: com.kwad.components.ct.horizontal.feed.item.presenter.b.1
        @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
        public final void by() {
            b.this.Fc();
        }
    };
    private TextView aLW;
    private TextView awp;
    private long aww;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void Fc() {
        long jM = com.kwad.components.ct.response.a.c.m((PhotoInfo) ((CtAdTemplate) ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).cdM).photoInfo);
        boolean zY = com.kwad.components.ct.horizontal.b.b.Y(this.aww);
        if (zY) {
            jM++;
        }
        this.awp.setText(bq.bC(jM));
        this.awp.setSelected(zY);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.EZ = (ImageView) findViewById(R.id.ksad_horizontal_feed_item_video_author_icon);
        this.Fa = (TextView) findViewById(R.id.ksad_horizontal_feed_item_video_author_name);
        this.awp = (TextView) findViewById(R.id.ksad_horizontal_feed_item_video_like_count);
        this.aLW = (TextView) findViewById(R.id.ksad_horizontal_feed_item_video_watch_time);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.cdN == 0 || ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK == null || ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aFs == null) {
            return;
        }
        ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aFs.b(this.aFS);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        CtAdTemplate ctAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).cdM;
        this.aww = com.kwad.components.ct.response.a.a.bg(ctAdTemplate);
        if (this.cdN != 0 && ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK != null && ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aFs != null) {
            ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aFs.a(this.aFS);
        }
        com.kwad.sdk.glide.c.h(((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).alG).hh(com.kwad.components.ct.response.a.a.bf(ctAdTemplate)).d(getContext().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).f(getContext().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).a(new p(1.0f, Color.parseColor("#eaeaea"))).b(this.EZ);
        String strAL = com.kwad.components.ct.response.a.a.aL(ctAdTemplate);
        if (bq.isNullString(strAL) && com.kwad.components.ct.response.a.a.eH(ctAdTemplate)) {
            strAL = getContext().getString(R.string.ksad_ad_default_username_normal);
        }
        this.Fa.setText(strAL);
        this.aLW.setText(bq.bC(com.kwad.components.ct.response.a.c.n((PhotoInfo) ctAdTemplate.photoInfo)) + "次");
        Fc();
    }
}

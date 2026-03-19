package com.kwad.components.ct.horizontal.feed.item.presenter.play;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.glide.load.resource.bitmap.p;
import com.kwad.sdk.utils.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.ct.horizontal.feed.item.a.b {
    private ImageView EZ;
    private TextView Fa;
    private com.kwad.sdk.core.j.d aFS = new com.kwad.sdk.core.j.d() { // from class: com.kwad.components.ct.horizontal.feed.item.presenter.play.d.1
        @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
        public final void by() {
            d.this.Fc();
        }
    };
    private TextView aLW;
    private TextView awp;
    private long aww;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.EZ = (ImageView) findViewById(R.id.ksad_horizontal_video_desc_author_icon);
        this.Fa = (TextView) findViewById(R.id.ksad_horizontal_video_desc_author_name);
        this.awp = (TextView) findViewById(R.id.ksad_horizontal_video_desc_like_count);
        this.aLW = (TextView) findViewById(R.id.ksad_horizontal_detail_video_related_header_watch_time);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        A((CtAdTemplate) ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).cdM);
        if (this.cdN == 0 || ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK == null || ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aFs == null) {
            return;
        }
        ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aFs.a(this.aFS);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.cdN == 0 || ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK == null || ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aFs == null) {
            return;
        }
        ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aFs.b(this.aFS);
    }

    private void A(final CtAdTemplate ctAdTemplate) {
        if (ctAdTemplate == null) {
            com.kwad.sdk.core.d.c.i("HorizontalVideoDescPresenter", "refresh adTemplate is null");
            return;
        }
        this.aww = com.kwad.components.ct.response.a.a.bg(ctAdTemplate);
        com.kwad.sdk.glide.c.h(((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aoy).hh(com.kwad.components.ct.response.a.a.bf(ctAdTemplate)).d(getContext().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).f(getContext().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).a(new p(1.0f, Color.parseColor("#eaeaea"))).b(this.EZ);
        String strAL = com.kwad.components.ct.response.a.a.aL(ctAdTemplate);
        if (bq.isNullString(strAL) && com.kwad.components.ct.response.a.a.eH(ctAdTemplate)) {
            strAL = getContext().getString(R.string.ksad_ad_default_username_normal);
        }
        this.Fa.setText(strAL);
        this.awp.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.horizontal.feed.item.presenter.play.d.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (d.this.awp.isSelected()) {
                    com.kwad.components.ct.e.b.JK().g(ctAdTemplate, ((com.kwad.components.ct.horizontal.feed.item.a.a) d.this.cdN).aLK.aLP ? 1 : 0);
                    com.kwad.components.ct.horizontal.b.b.X(d.this.aww);
                } else {
                    com.kwad.components.ct.e.b.JK().b(ctAdTemplate, 0, 0, ((com.kwad.components.ct.horizontal.feed.item.a.a) d.this.cdN).aLK.aLP ? 1 : 0);
                    com.kwad.components.ct.horizontal.b.b.W(d.this.aww);
                }
                d.this.Fc();
            }
        });
        this.aLW.setText(bq.bC(com.kwad.components.ct.response.a.c.n((PhotoInfo) ctAdTemplate.photoInfo)) + "次");
        Fc();
    }

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
}

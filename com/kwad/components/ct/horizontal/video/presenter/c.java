package com.kwad.components.ct.horizontal.video.presenter;

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
public final class c extends com.kwad.components.ct.horizontal.video.a.a {
    private ImageView EZ;
    private TextView Fa;
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

    @Override // com.kwad.components.ct.horizontal.video.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        A(this.aOD.mAdTemplate);
        if (this.aOD.aLD != null) {
            this.aOD.aLD.a(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.aOD.aLD != null) {
            this.aOD.aLD.b(this);
        }
    }

    @Override // com.kwad.components.ct.horizontal.video.c
    public final void A(final CtAdTemplate ctAdTemplate) {
        if (ctAdTemplate == null) {
            com.kwad.sdk.core.d.c.i("HorizontalVideoDescPresenter", "refresh adTemplate is null");
            return;
        }
        this.aww = com.kwad.components.ct.response.a.a.bg(ctAdTemplate);
        com.kwad.sdk.glide.c.h(this.aOD.aoy).hh(com.kwad.components.ct.response.a.a.bf(ctAdTemplate)).d(getContext().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).f(getContext().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).a(new p(1.0f, Color.parseColor("#eaeaea"))).b(this.EZ);
        String strAL = com.kwad.components.ct.response.a.a.aL(ctAdTemplate);
        if (bq.isNullString(strAL) && com.kwad.components.ct.response.a.a.eH(ctAdTemplate)) {
            strAL = getContext().getString(R.string.ksad_ad_default_username_normal);
        }
        this.Fa.setText(strAL);
        F(ctAdTemplate);
        this.awp.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.horizontal.video.presenter.c.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (c.this.awp.isSelected()) {
                    com.kwad.components.ct.e.b.JK().M(ctAdTemplate);
                    com.kwad.components.ct.horizontal.b.b.X(c.this.aww);
                } else {
                    com.kwad.components.ct.e.b.JK().f(ctAdTemplate, 0, 0);
                    com.kwad.components.ct.horizontal.b.b.W(c.this.aww);
                }
                c.this.F(ctAdTemplate);
            }
        });
        this.aLW.setText(bq.bC(com.kwad.components.ct.response.a.c.n((PhotoInfo) ctAdTemplate.photoInfo)) + "次");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(CtAdTemplate ctAdTemplate) {
        long jM = com.kwad.components.ct.response.a.c.m((PhotoInfo) ctAdTemplate.photoInfo);
        boolean zY = com.kwad.components.ct.horizontal.b.b.Y(this.aww);
        if (zY) {
            jM++;
        }
        this.awp.setText(bq.bC(jM));
        this.awp.setSelected(zY);
    }
}

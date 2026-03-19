package com.kwad.components.ct.feed.home.a.b.b;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ct.f.d;
import com.kwad.components.ct.f.f;
import com.kwad.components.ct.f.g;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ct.feed.home.a.a.a implements com.kwad.components.ct.f.b {
    private ImageView EZ;
    private TextView Fa;
    private f aDL;
    private FrameLayout aFR;
    private TextView aFx;
    private TextView awp;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aFR = (FrameLayout) findViewById(R.id.ksad_feed_item_root);
        this.EZ = (ImageView) findViewById(R.id.ksad_feed_item_author_icon);
        this.Fa = (TextView) findViewById(R.id.ksad_feed_item_author_name);
        this.aFx = (TextView) findViewById(R.id.ksad_feed_item_photo_desc);
        this.awp = (TextView) findViewById(R.id.ksad_feed_item_author_like_count);
        g.c(this.aFR, EZ().aDq);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aDL = new f(this);
        d.Kb().a(this.aDL);
        CtAdTemplate ctAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.feed.home.a.a.b) this.cdN).cdM;
        com.kwad.sdk.glide.c.h(((com.kwad.components.ct.feed.home.a.a.b) this.cdN).alG).hh(com.kwad.components.ct.response.a.a.bf(ctAdTemplate)).d(getContext().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).f(getContext().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).a(new com.kwad.components.ct.widget.b.a()).b(this.EZ);
        String strAL = com.kwad.components.ct.response.a.a.aL(ctAdTemplate);
        if (bq.isNullString(strAL) && com.kwad.components.ct.response.a.a.eH(ctAdTemplate)) {
            strAL = getContext().getString(R.string.ksad_ad_default_username_normal);
        }
        g.a(this.Fa, EZ().asm);
        this.Fa.setText(strAL);
        String strAQ = com.kwad.components.ct.response.a.a.aQ(ctAdTemplate);
        if (bq.isNullString(strAQ)) {
            this.aFx.setVisibility(8);
        } else {
            this.aFx.setText(strAQ);
            g.a(this.aFx, EZ().aDt);
            this.aFx.setVisibility(0);
        }
        g.a(this.awp, EZ().aDu);
        this.awp.setText(String.format("%s 人点赞", bq.bB(com.kwad.components.ct.response.a.c.m((PhotoInfo) ctAdTemplate.photoInfo))));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        d.Kb().b(this.aDL);
    }

    @Override // com.kwad.components.ct.f.b
    public final void cg(int i) {
        com.kwad.sdk.core.d.c.d("[ThemeMode]", "FeedHomeItemPhotoBottomPresenter onThemeModeChanged themeMode=" + i);
        g.c(this.aFR, EZ().aDq);
        g.a(this.aFx, EZ().aDt);
        g.a(this.Fa, EZ().asm);
        g.a(this.awp, EZ().aDu);
    }
}

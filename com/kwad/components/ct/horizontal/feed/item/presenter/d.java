package com.kwad.components.ct.horizontal.feed.item.presenter;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.ct.horizontal.feed.item.a.b {
    private ImageView aFB;
    private ImageView aFw;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aFB = (ImageView) findViewById(R.id.ksad_horizontal_feed_item_video_bg_img);
        this.aFw = (ImageView) findViewById(R.id.ksad_horizontal_feed_item_video_img);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        CtAdTemplate ctAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).cdM;
        String strAT = com.kwad.components.ct.response.a.a.aT(ctAdTemplate);
        if (TextUtils.isEmpty(strAT)) {
            strAT = com.kwad.components.ct.response.a.a.aD(ctAdTemplate).getUrl();
        }
        com.kwad.sdk.glide.c.h(((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).alG).hh(com.kwad.components.ct.response.a.a.be(ctAdTemplate)).d(new ColorDrawable(Color.parseColor("#000000"))).f(new ColorDrawable(Color.parseColor("#000000"))).b(this.aFB);
        com.kwad.sdk.glide.c.h(((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).alG).hh(strAT).a(new com.kwad.components.ct.b.a(strAT, ctAdTemplate)).d(new ColorDrawable(Color.parseColor("#F2F2F2"))).f(new ColorDrawable(Color.parseColor("#F2F2F2"))).b(this.aFw);
    }
}

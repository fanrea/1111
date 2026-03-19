package com.kwad.components.ct.horizontal.video.b.a.b;

import android.text.TextUtils;
import android.widget.ImageView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.glide.load.resource.bitmap.t;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.ct.horizontal.video.b.a.a.a {
    private ImageView aFB;
    private ImageView aFw;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aFw = (ImageView) findViewById(R.id.ksad_horizontal_detail_video_related_item_cover);
        this.aFB = (ImageView) findViewById(R.id.ksad_horizontal_detail_video_related_bg_img);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        CtAdTemplate ctAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.horizontal.video.b.a.a.b) this.cdN).cdM;
        String url = com.kwad.components.ct.response.a.a.aD(ctAdTemplate).getUrl();
        if (TextUtils.isEmpty(url)) {
            url = com.kwad.components.ct.response.a.a.aT(ctAdTemplate);
        }
        String strBe = com.kwad.components.ct.response.a.a.be(ctAdTemplate);
        if (!TextUtils.isEmpty(url)) {
            com.kwad.sdk.glide.c.h(((com.kwad.components.ct.horizontal.video.b.a.a.b) this.cdN).alG).hh(url).a(new com.kwad.components.ct.b.a(url, ctAdTemplate)).d(getContext().getResources().getDrawable(R.drawable.ksad_horizontal_detail_related_cover_bg)).f(getContext().getResources().getDrawable(R.drawable.ksad_horizontal_detail_related_cover_bg)).a(new t(com.kwad.sdk.c.a.a.a(getContext(), 3.0f))).b(this.aFw);
            this.aFw.setVisibility(0);
        } else {
            this.aFw.setVisibility(4);
        }
        com.kwad.sdk.glide.c.h(((com.kwad.components.ct.horizontal.video.b.a.a.b) this.cdN).alG).hh(strBe).d(getContext().getResources().getDrawable(R.drawable.ksad_horizontal_detail_related_cover_bg)).f(getContext().getResources().getDrawable(R.drawable.ksad_horizontal_detail_related_cover_bg)).a(new t(com.kwad.sdk.c.a.a.a(getContext(), 3.0f))).b(this.aFB);
    }
}

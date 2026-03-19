package com.kwad.components.ct.horizontal.news.a.b;

import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.ct.horizontal.news.a.a.a {
    private ImageView aFw;
    private ColorDrawable aMg;
    private CtAdTemplate mAdTemplate;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aFw = (ImageView) findViewById(R.id.ksad_news_item_cover);
        this.aMg = com.kwad.sdk.c.a.a.k(getContext(), R.color.ksad_default_img_color);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        CtAdTemplate ctAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.horizontal.news.a.a.b) this.cdN).cdM;
        this.mAdTemplate = ctAdTemplate;
        loadImage(this.aFw, com.kwad.components.ct.response.a.a.aD(ctAdTemplate).getUrl());
    }

    private void loadImage(ImageView imageView, String str) {
        com.kwad.sdk.glide.c.h(((com.kwad.components.ct.horizontal.news.a.a.b) this.cdN).alG).hh(str).a(new com.kwad.components.ct.b.a(str, this.mAdTemplate)).d(this.aMg).f(this.aMg).b(imageView);
    }
}

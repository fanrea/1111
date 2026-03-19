package com.kwad.components.ct.horizontal.feed.item.presenter.a;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.glide.framesequence.FrameSequence;
import com.kwad.sdk.glide.load.engine.h;
import com.kwad.sdk.glide.load.resource.bitmap.g;
import com.kwad.sdk.glide.webp.decoder.WebpFrameCacheStrategy;
import com.kwad.sdk.glide.webp.decoder.k;
import com.kwad.sdk.glide.webp.decoder.n;
import com.kwad.sdk.glide.webp.decoder.o;
import com.kwad.sdk.glide.webp.decoder.p;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e extends com.kwad.components.ct.horizontal.feed.item.a.b {
    private ImageView aFB;
    private ImageView aFw;
    private ColorDrawable aMl;
    private ColorDrawable aMm;
    private CtAdTemplate mAdTemplate;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        com.kwad.components.ct.b.c.init(getContext().getApplicationContext());
        this.aFB = (ImageView) findViewById(R.id.ksad_horizontal_feed_item_cover_bg);
        this.aFw = (ImageView) findViewById(R.id.ksad_horizontal_feed_item_cover);
        this.aMl = com.kwad.sdk.c.a.a.k(getContext(), R.color.ksad_default_img_bg_color);
        this.aMm = com.kwad.sdk.c.a.a.k(getContext(), R.color.ksad_default_img_color);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        CtAdTemplate ctAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).cdM;
        this.mAdTemplate = ctAdTemplate;
        a(this.aFB, com.kwad.components.ct.response.a.a.be(ctAdTemplate), this.aMl);
        String strAT = com.kwad.components.ct.response.a.a.aT(this.mAdTemplate);
        if (!TextUtils.isEmpty(strAT) && FrameSequence.isEnable()) {
            a(this.aFw, strAT);
        } else {
            a(this.aFw, com.kwad.components.ct.response.a.a.aD(this.mAdTemplate).getUrl(), this.aMm);
        }
    }

    private void a(ImageView imageView, String str) {
        com.kwad.sdk.glide.c.h(((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).alG).hh(str).d(this.aMm).f(this.aMm).a(k.class, new n(new g())).b((com.kwad.sdk.glide.load.e<com.kwad.sdk.glide.load.e<WebpFrameCacheStrategy>>) o.caY, (com.kwad.sdk.glide.load.e<WebpFrameCacheStrategy>) WebpFrameCacheStrategy.caT).b((com.kwad.sdk.glide.load.e<com.kwad.sdk.glide.load.e<p>>) o.caZ, (com.kwad.sdk.glide.load.e<p>) p.cbi).a(h.bTs).a(new com.kwad.components.ct.b.a(str, this.mAdTemplate)).b(imageView);
    }

    private void a(ImageView imageView, String str, Drawable drawable) {
        com.kwad.sdk.glide.c.h(((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).alG).hh(str).a(new com.kwad.components.ct.b.a(str, this.mAdTemplate)).d(drawable).f(this.aMm).b(imageView);
    }
}

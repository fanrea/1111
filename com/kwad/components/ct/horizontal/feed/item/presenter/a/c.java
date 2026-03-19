package com.kwad.components.ct.horizontal.feed.item.presenter.a;

import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ct.horizontal.feed.item.a.b {
    private ImageView aFw;
    private ColorDrawable aMg;
    private int aMh;
    private CtAdTemplate mAdTemplate;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aFw = (ImageView) findViewById(R.id.ksad_horizontal_feed_item_cover);
        this.aMg = com.kwad.sdk.c.a.a.k(getContext(), R.color.ksad_default_img_color);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        Hz();
        CtAdTemplate ctAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).cdM;
        this.mAdTemplate = ctAdTemplate;
        loadImage(this.aFw, com.kwad.components.ct.response.a.d.j(com.kwad.components.ct.response.a.a.az(ctAdTemplate)).url);
    }

    private void Hz() {
        if (this.aMh != 0) {
            return;
        }
        this.aMh = (int) (((com.kwad.sdk.c.a.a.o(getActivity()) - (com.kwad.sdk.c.a.a.j(getContext(), R.dimen.ksad_horizontal_news_image_margin) * 2)) - com.kwad.sdk.c.a.a.j(getContext(), R.dimen.ksad_horizontal_news_padding)) / 3.0f);
        ViewGroup.LayoutParams layoutParams = this.aFw.getLayoutParams();
        layoutParams.width = this.aMh;
        layoutParams.height = (int) ((this.aMh * 3) / 4.0f);
        this.aFw.setLayoutParams(layoutParams);
    }

    private void loadImage(ImageView imageView, String str) {
        com.kwad.sdk.glide.c.h(((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).alG).hh(str).a(new com.kwad.components.ct.b.a(str, this.mAdTemplate)).d(this.aMg).f(this.aMg).b(imageView);
    }
}

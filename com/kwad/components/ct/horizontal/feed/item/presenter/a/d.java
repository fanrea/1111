package com.kwad.components.ct.horizontal.feed.item.presenter.a;

import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.hotspot.NewsInfo;
import com.kwad.sdk.R;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.ct.horizontal.feed.item.a.b {
    private ColorDrawable aMg;
    private ImageView aMi;
    private ImageView aMj;
    private ImageView aMk;
    private CtAdTemplate mAdTemplate;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aMi = (ImageView) findViewById(R.id.ksad_horizontal_feed_item_cover_1);
        this.aMj = (ImageView) findViewById(R.id.ksad_horizontal_feed_item_cover_2);
        this.aMk = (ImageView) findViewById(R.id.ksad_horizontal_feed_item_cover_3);
        this.aMg = com.kwad.sdk.c.a.a.k(getContext(), R.color.ksad_default_img_color);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        CtAdTemplate ctAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).cdM;
        this.mAdTemplate = ctAdTemplate;
        List<NewsInfo.ImageInfo> listL = com.kwad.components.ct.response.a.d.l(com.kwad.components.ct.response.a.a.az(ctAdTemplate));
        String str = listL.size() > 0 ? listL.get(0).url : "";
        String str2 = listL.size() > 1 ? listL.get(1).url : "";
        String str3 = listL.size() > 2 ? listL.get(2).url : "";
        loadImage(this.aMi, str);
        loadImage(this.aMj, str2);
        loadImage(this.aMk, str3);
    }

    private void loadImage(ImageView imageView, String str) {
        com.kwad.sdk.glide.c.h(((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).alG).hh(str).a(new com.kwad.components.ct.b.a(str, this.mAdTemplate)).d(this.aMg).f(this.aMg).b(imageView);
    }
}

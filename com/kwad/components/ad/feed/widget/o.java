package com.kwad.components.ad.feed.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.feed.FeedDownloadActivityProxy;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class o extends a implements View.OnClickListener, com.kwad.sdk.widget.e {
    private TextView jt;
    private ImageView ju;
    private ImageView jv;
    private KsLogoView mLogoView;

    public o(Context context) {
        super(context);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bB() {
        ((RatioFrameLayout) findViewById(R.id.ksad_container)).setRatio(0.5600000023841858d);
        this.jt = (TextView) findViewById(R.id.ksad_ad_desc);
        this.ju = (ImageView) findViewById(R.id.ksad_ad_image);
        this.jv = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_feed_logo);
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_text_immerse_image;
    }

    @Override // com.kwad.components.core.widget.b
    public final void d(AdResultData adResultData) {
        super.d(adResultData);
        this.jt.setText(com.kwad.components.ad.feed.f.m(this.mAdTemplate));
        List<String> listBg = com.kwad.sdk.core.response.b.a.bg(this.mAdInfo);
        this.mLogoView.aQ(this.mAdTemplate);
        if (listBg.size() > 0) {
            KSImageLoader.loadFeeImage(this.ju, listBg.get(0), this.mAdTemplate);
        } else {
            com.kwad.sdk.core.d.c.e("FeedTextImmerseImageView", "getImageUrlList size less than one");
        }
        com.kwad.sdk.c.a.a.a(this, this.jt, this.ju, this.jv);
        new com.kwad.sdk.widget.j(getContext(), this.jt, this);
        new com.kwad.sdk.widget.j(getContext(), this.ju, this);
        new com.kwad.sdk.widget.j(getContext(), this.jv, this);
        setOnClickListener(this);
        if (com.kwad.sdk.core.response.b.a.aJ(this.mAdInfo)) {
            cp();
        }
    }

    @Override // com.kwad.sdk.widget.e
    public final void a(View view) {
        onClick(view);
    }

    @Override // com.kwad.sdk.widget.e
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.eE(this.mAdTemplate)) {
            d(view, 153);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        if (view == this.jt) {
            i = 25;
        } else {
            i = view == this.ju ? 100 : 35;
        }
        d(view, i);
    }

    private void d(View view, int i) {
        if (view == this.jv) {
            wy();
            return;
        }
        if (com.kwad.components.core.e.d.d.a(new a.C0469a(getContext()).aC(this.mAdTemplate), 1) == 1) {
            bg(i);
        } else if (com.kwad.sdk.core.response.b.a.aJ(this.mAdInfo)) {
            bg(i);
            FeedDownloadActivityProxy.launch(this.mContext, this.mAdTemplate, this.akg);
        } else {
            bg(i);
            AdWebViewActivityProxy.launch(getContext(), this.mAdTemplate);
        }
    }
}

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
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class j extends com.kwad.components.core.widget.b<AdResultData, AdTemplate> implements View.OnClickListener {
    private TextView jt;
    private ImageView jv;
    private ImageView kf;
    private ImageView kg;
    private ImageView kh;
    private KsLogoView mLogoView;

    public j(Context context) {
        super(context);
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_text_above_group_image;
    }

    @Override // com.kwad.components.core.widget.b
    public final void bB() {
        this.jt = (TextView) findViewById(R.id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.5600000023841858d);
        this.kf = (ImageView) findViewById(R.id.ksad_ad_image_left);
        this.kg = (ImageView) findViewById(R.id.ksad_ad_image_mid);
        this.kh = (ImageView) findViewById(R.id.ksad_ad_image_right);
        this.jv = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
    }

    @Override // com.kwad.components.core.widget.b
    public final void d(AdResultData adResultData) {
        super.d(adResultData);
        this.jt.setText(com.kwad.components.ad.feed.f.m(this.mAdTemplate));
        this.mLogoView.aQ(this.mAdTemplate);
        List<String> listBg = com.kwad.sdk.core.response.b.a.bg(this.mAdInfo);
        if (listBg.size() >= 3) {
            KSImageLoader.loadFeeImage(this.kf, listBg.get(0), this.mAdTemplate);
            KSImageLoader.loadFeeImage(this.kg, listBg.get(1), this.mAdTemplate);
            KSImageLoader.loadFeeImage(this.kh, listBg.get(2), this.mAdTemplate);
        } else {
            com.kwad.sdk.core.d.c.e("FeedTextAboveGroupImageView", "getImageUrlList size less than three");
        }
        com.kwad.sdk.c.a.a.a(this, this.jt, this.kf, this.kg, this.kh, this.jv);
        setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.jv) {
            wy();
            return;
        }
        int i = 35;
        if (view == this.jt) {
            i = 25;
        } else if (view == this.kf || view == this.kg || view == this.kh) {
            i = 100;
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

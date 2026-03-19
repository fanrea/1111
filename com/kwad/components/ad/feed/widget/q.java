package com.kwad.components.ad.feed.widget;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class q extends a implements View.OnClickListener, com.kwad.sdk.widget.e {
    private DownloadProgressView jA;
    private TextView jt;
    private ImageView jv;
    private RoundAngleImageView ki;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private KsLogoView mLogoView;

    public q(Context context) {
        super(context);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bB() {
        this.jt = (TextView) findViewById(R.id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.6600000262260437d);
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.ksad_ad_image);
        this.ki = roundAngleImageView;
        roundAngleImageView.setRadius(com.kwad.sdk.c.a.a.a(getContext(), 3.0f));
        this.jv = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.jA = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_feed_logo);
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_text_right_image;
    }

    private void cs() {
        this.mLogoView.aQ(this.mAdTemplate);
        this.jA.au(this.mAdTemplate);
        this.jA.setOnClickListener(this);
        new com.kwad.sdk.widget.j(getContext(), this.jA, this);
        if (com.kwad.sdk.core.response.b.a.aJ(this.mAdInfo)) {
            com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, this.jA.getAppDownloadListener());
            this.mApkDownloadHelper = cVar;
            cVar.d(this.jA.getAppDownloadListener());
            this.mApkDownloadHelper.setOnShowListener(this);
            this.mApkDownloadHelper.setOnDismissListener(this);
            cp();
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void d(AdResultData adResultData) {
        super.d(adResultData);
        this.jt.setText(com.kwad.components.ad.feed.f.m(this.mAdTemplate));
        List<String> listBg = com.kwad.sdk.core.response.b.a.bg(this.mAdInfo);
        if (listBg.size() > 0) {
            this.jm = SystemClock.elapsedRealtime();
            KSImageLoader.loadFeeImage(this.ki, listBg.get(0), this.mAdTemplate, this.jr);
        } else {
            com.kwad.sdk.core.d.c.e("FeedTextRightImageView", "getImageUrlList size less than one");
        }
        cs();
        com.kwad.sdk.c.a.a.a(this, this.jt, this.ki, this.jA, this.jv);
        new com.kwad.sdk.widget.j(getContext(), this.jt, this);
        new com.kwad.sdk.widget.j(getContext(), this.ki, this);
        new com.kwad.sdk.widget.j(getContext(), this.jA, this);
        new com.kwad.sdk.widget.j(getContext(), this.jv, this);
        setOnClickListener(this);
    }

    @Override // com.kwad.components.core.widget.b
    public final void cv() {
        super.cv();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.jA.getAppDownloadListener());
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void ae() {
        DownloadProgressView downloadProgressView;
        super.ae();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (downloadProgressView = this.jA) == null) {
            return;
        }
        cVar.b(downloadProgressView.getAppDownloadListener());
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
        } else if (view == this.ki) {
            i = 100;
        } else {
            i = view == this.jA ? 1 : 35;
        }
        d(view, i);
    }

    private void d(View view, final int i) {
        if (view == this.jv) {
            wy();
        } else {
            com.kwad.components.core.e.d.a.a(new a.C0469a(getContext()).aC(this.mAdTemplate).aE(5).aF(i).b(this.mApkDownloadHelper).aG(view == this.jA ? 1 : 2).aq(view == this.jA).a(new a.b() { // from class: com.kwad.components.ad.feed.widget.q.1
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    q.this.bg(i);
                }
            }));
        }
    }
}

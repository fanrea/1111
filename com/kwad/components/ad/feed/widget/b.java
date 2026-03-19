package com.kwad.components.ad.feed.widget;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class b extends a implements View.OnClickListener, com.kwad.sdk.widget.e {
    protected TextView fR;
    protected ImageView ik;
    protected TextView it;
    protected DownloadProgressView jA;
    protected boolean jB;
    protected int jC;
    protected TextView jt;
    protected ImageView ju;
    protected ImageView jv;
    protected RatioFrameLayout jw;
    protected TextView jx;
    protected TextView jy;
    protected View jz;
    protected com.kwad.components.core.e.d.c mApkDownloadHelper;
    protected KsLogoView mLogoView;

    public b(Context context) {
        super(context);
        this.jB = true;
        this.jC = 8;
    }

    @Override // com.kwad.components.core.widget.b
    public void bB() {
        this.jt = (TextView) findViewById(R.id.ksad_ad_desc);
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.ksad_image_container);
        this.jw = ratioFrameLayout;
        ratioFrameLayout.setRatio(0.5600000023841858d);
        this.ju = (ImageView) findViewById(R.id.ksad_ad_image);
        this.jv = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
        this.jA = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
    }

    @Override // com.kwad.components.core.widget.b
    public final void d(AdResultData adResultData) {
        super.d(adResultData);
        this.jt.setText(com.kwad.components.ad.feed.f.m(this.mAdTemplate));
        this.mLogoView.aQ(this.mAdTemplate);
        cq();
        if (com.kwad.sdk.core.response.b.a.aJ(this.mAdInfo)) {
            findViewById(R.id.ksad_ad_download_container).setVisibility(0);
            findViewById(R.id.ksad_ad_h5_container).setVisibility(8);
            cs();
            cu();
        } else {
            findViewById(R.id.ksad_ad_h5_container).setVisibility(0);
            findViewById(R.id.ksad_ad_download_container).setVisibility(8);
            if (ct()) {
                cs();
            }
            cr();
        }
        com.kwad.sdk.c.a.a.a(this, this.jt, this.ju, this.jv);
        new com.kwad.sdk.widget.j(getContext(), this.jt, this);
        new com.kwad.sdk.widget.j(getContext(), this.ju, this);
        new com.kwad.sdk.widget.j(getContext(), this.jv, this);
        setOnClickListener(this);
    }

    public void cq() {
        this.ju.post(new bh() { // from class: com.kwad.components.ad.feed.widget.b.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(b.this.mAdTemplate);
                if (com.kwad.sdk.core.response.b.a.aY(adInfoEP).height > com.kwad.sdk.core.response.b.a.aY(adInfoEP).width) {
                    ViewGroup.LayoutParams layoutParams = b.this.jw.getLayoutParams();
                    layoutParams.width = b.this.getWidth() / 2;
                    b.this.jw.setRatio(1.7857142686843872d);
                    b.this.jw.setLayoutParams(layoutParams);
                }
                List<String> listBg = com.kwad.sdk.core.response.b.a.bg(b.this.mAdInfo);
                if (listBg.size() > 0) {
                    b.this.jm = SystemClock.elapsedRealtime();
                    KSImageLoader.loadFeeImage(b.this.ju, listBg.get(0), b.this.mAdTemplate, b.this.jr);
                    return;
                }
                com.kwad.sdk.core.d.c.e("BaseFeedTextImageView", "getImageUrlList size less than one");
            }
        });
    }

    private void cr() {
        this.jy = (TextView) findViewById(R.id.ksad_h5_desc);
        this.it = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.jz = findViewById(R.id.ksad_h5_open_cover);
        this.jy.setText(com.kwad.components.ad.feed.f.m(this.mAdTemplate));
        this.it.setText(com.kwad.sdk.core.response.b.a.aH(this.mAdInfo));
        this.jz.setOnClickListener(this);
        this.jy.setOnClickListener(this);
        this.it.setOnClickListener(this);
        new com.kwad.sdk.widget.j(getContext(), this.jz, this);
        new com.kwad.sdk.widget.j(getContext(), this.jy, this);
        new com.kwad.sdk.widget.j(getContext(), this.it, this);
    }

    private void cs() {
        this.ik = (ImageView) findViewById(R.id.ksad_app_icon);
        this.fR = (TextView) findViewById(R.id.ksad_app_title);
        TextView textView = (TextView) findViewById(R.id.ksad_app_desc);
        this.jx = textView;
        com.kwad.sdk.c.a.a.a(this, this.ik, this.fR, textView);
        new com.kwad.sdk.widget.j(getContext(), this.ik, this);
        new com.kwad.sdk.widget.j(getContext(), this.fR, this);
        new com.kwad.sdk.widget.j(getContext(), this.jx, this);
        if (ct()) {
            this.fR.setText(com.kwad.sdk.core.response.b.a.cz(this.mAdInfo));
        } else {
            this.fR.setText(com.kwad.sdk.core.response.b.a.ay(this.mAdInfo));
        }
        this.ik.setImageResource(R.drawable.ksad_default_app_icon);
        KSImageLoader.loadAppIcon(this.ik, com.kwad.sdk.core.response.b.a.cC(this.mAdInfo), this.mAdTemplate, this.jC);
        this.jx.setText(com.kwad.components.ad.feed.f.m(this.mAdTemplate));
        if (this.jB) {
            cp();
        }
    }

    private boolean ct() {
        if (FeedType.isNewVerticalType(com.kwad.sdk.core.response.b.e.fg(this.mAdTemplate))) {
            return com.kwad.sdk.core.response.b.e.fh(this.mAdTemplate) == FeedType.FeedDefaultType.FEED_VERTICAL_NOVEL_DEFAULT.getDefaultType() || com.kwad.sdk.core.response.b.e.fh(this.mAdTemplate) == FeedType.FeedDefaultType.FEED_VERTICAL_BISERIAL_DEFAULT.getDefaultType();
        }
        return false;
    }

    private void cu() {
        this.jA.au(this.mAdTemplate);
        this.jA.setOnClickListener(this);
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, this.jA.getAppDownloadListener());
        this.mApkDownloadHelper = cVar;
        cVar.d(this.jA.getAppDownloadListener());
        this.mApkDownloadHelper.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
        new com.kwad.sdk.widget.j(getContext(), this.jA, this);
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
            b(view, 153);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        if (view == this.jt) {
            i = 25;
        } else if (view == this.ju) {
            i = 100;
        } else if (view == this.jA || view == this.it || view == this.jz) {
            i = 1;
        } else if (view == this.ik) {
            i = 13;
        } else if (view == this.fR) {
            i = 14;
        } else {
            i = (view == this.jx || view == this.jy) ? 101 : 35;
        }
        b(view, i);
    }

    private void b(View view, final int i) {
        if (view == this.jv) {
            wy();
        } else {
            co();
            com.kwad.components.core.e.d.a.a(new a.C0469a(getContext()).aC(this.mAdTemplate).aE(5).aF(i).b(this.mApkDownloadHelper).aG(view == this.jA ? 1 : 2).aq(view == this.jA).a(new a.b() { // from class: com.kwad.components.ad.feed.widget.b.2
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    b.this.bg(i);
                }
            }));
        }
    }

    public void setmIsShowComplianceView(boolean z) {
        this.jB = z;
    }

    public void setRadiusDp(int i) {
        this.jC = i;
    }
}

package com.kwad.components.ad.draw.view.playend;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.draw.view.DrawDownloadProgressBar;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.p.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DrawVideoTailFrame extends FrameLayout implements View.OnClickListener {
    private KsDrawAd.AdInteractionListener eU;
    private KsAppDownloadListener fJ;
    private TextView fR;

    /* renamed from: if, reason: not valid java name */
    private AdBaseFrameLayout f3if;
    private ImageView ig;
    private ViewGroup ij;
    private ImageView ik;
    private AppScoreView il;
    private TextView im;

    /* renamed from: io, reason: collision with root package name */
    private TextView f766io;
    private DrawDownloadProgressBar iq;
    private ViewGroup ir;
    private TextView is;
    private TextView it;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private c mApkDownloadHelper;
    private KsLogoView mLogoView;

    public DrawVideoTailFrame(Context context) {
        super(context);
        B(context);
    }

    public DrawVideoTailFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        B(context);
    }

    public DrawVideoTailFrame(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        B(context);
    }

    private void B(Context context) {
        m.inflate(context, R.layout.ksad_draw_video_tailframe, this);
        this.ig = (ImageView) findViewById(R.id.ksad_video_cover);
        this.ij = (ViewGroup) findViewById(R.id.ksad_app_container);
        this.ik = (ImageView) findViewById(R.id.ksad_app_icon);
        this.fR = (TextView) findViewById(R.id.ksad_app_name);
        this.il = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.im = (TextView) findViewById(R.id.ksad_app_download_count);
        this.f766io = (TextView) findViewById(R.id.ksad_app_ad_desc);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.iq = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(15);
        this.ir = (ViewGroup) findViewById(R.id.ksad_h5_container);
        this.is = (TextView) findViewById(R.id.ksad_h5_ad_desc);
        this.it = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_draw_tailframe_logo);
    }

    public final void k(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo adInfoEP = e.eP(adTemplate);
        this.mAdInfo = adInfoEP;
        AdInfo.AdMaterialInfo.MaterialFeature materialFeatureAZ = a.aZ(adInfoEP);
        String str = materialFeatureAZ.coverUrl;
        this.mLogoView.aQ(adTemplate);
        if (!TextUtils.isEmpty(str)) {
            int i = materialFeatureAZ.width;
            int i2 = materialFeatureAZ.height;
            if (i > 0 && i > i2) {
                int screenWidth = com.kwad.sdk.c.a.a.getScreenWidth(getContext());
                if (getWidth() != 0) {
                    screenWidth = getWidth();
                }
                int i3 = (int) (screenWidth * (i2 / i));
                ViewGroup.LayoutParams layoutParams = this.ig.getLayoutParams();
                layoutParams.width = screenWidth;
                layoutParams.height = i3;
            }
            KSImageLoader.loadImage(this.ig, str, this.mAdTemplate);
        }
        if (a.aJ(this.mAdInfo)) {
            KSImageLoader.loadAppIcon(this.ik, a.cC(this.mAdInfo), this.mAdTemplate, 11);
            this.fR.setText(a.ay(this.mAdInfo));
            float fAD = a.aD(this.mAdInfo);
            if (fAD >= 3.0f) {
                this.il.setScore(fAD);
                this.il.setVisibility(0);
            }
            this.im.setText(a.aC(this.mAdInfo));
            this.f766io.setText(a.aw(this.mAdInfo));
            this.ij.setVisibility(0);
            this.ir.setVisibility(8);
        } else {
            this.is.setText(a.aw(this.mAdInfo));
            this.it.setText(a.aH(this.mAdInfo));
            this.ij.setVisibility(8);
            this.ir.setVisibility(0);
        }
        this.iq.setOnClickListener(this);
        setOnClickListener(this);
    }

    public void setApkDownloadHelper(c cVar) {
        this.mApkDownloadHelper = cVar;
    }

    public void setAdBaseFrameLayout(AdBaseFrameLayout adBaseFrameLayout) {
        this.f3if = adBaseFrameLayout;
    }

    public final void cb() {
        c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.fJ;
            if (ksAppDownloadListener != null) {
                cVar.d(ksAppDownloadListener);
                return;
            }
            KsAppDownloadListener appDownloadListener = getAppDownloadListener();
            this.fJ = appDownloadListener;
            this.mApkDownloadHelper.b(appDownloadListener);
        }
    }

    public final void release() {
        KsAppDownloadListener ksAppDownloadListener;
        c cVar = this.mApkDownloadHelper;
        if (cVar == null || (ksAppDownloadListener = this.fJ) == null) {
            return;
        }
        cVar.c(ksAppDownloadListener);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        return new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                DrawVideoTailFrame.this.iq.e(a.aH(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.iq.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                DrawVideoTailFrame.this.iq.e(i + "%", i);
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                super.onPaused(i);
                DrawVideoTailFrame.this.iq.e(a.abJ(), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                DrawVideoTailFrame.this.iq.e(a.cB(DrawVideoTailFrame.this.mAdTemplate), DrawVideoTailFrame.this.iq.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                DrawVideoTailFrame.this.iq.e(a.aH(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.iq.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                DrawVideoTailFrame.this.iq.e(a.ae(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.iq.getMax());
            }
        };
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.eU = adInteractionListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.components.core.e.d.a.a(new a.C0469a(getContext()).aC(this.mAdTemplate).b(this.mApkDownloadHelper).aG(view == this.iq ? 1 : 2).aq(view == this.iq).a(new a.b() { // from class: com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (DrawVideoTailFrame.this.eU != null) {
                    DrawVideoTailFrame.this.eU.onAdClicked();
                }
                com.kwad.sdk.core.adlog.c.a(DrawVideoTailFrame.this.mAdTemplate, 2, DrawVideoTailFrame.this.f3if.getTouchCoords());
            }
        }));
    }
}

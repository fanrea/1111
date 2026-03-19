package com.kwad.components.ad.draw.presenter;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import com.kwad.components.ad.draw.view.DrawDownloadProgressBar;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.u.r;
import com.kwad.components.core.video.n;
import com.kwad.components.core.video.o;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ad.draw.b.a implements View.OnClickListener {
    private ViewGroup fA;
    private TextView fB;
    private TextView fC;
    private TextView fD;
    private DrawDownloadProgressBar fE;
    private ValueAnimator fF;
    private int fG;
    private int fH;
    private int fI;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private KsLogoView mLogoView;
    private n mVideoPlayStateListener = new o() { // from class: com.kwad.components.ad.draw.presenter.c.1
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayStart() {
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            if (j2 >= c.this.fI * 1000) {
                c.this.fm.fr.aZ();
            } else if (j2 >= c.this.fH * 1000) {
                c.this.aW();
            } else if (j2 >= c.this.fG * 1000) {
                c.this.aU();
            }
        }
    };
    private KsAppDownloadListener fJ = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.draw.presenter.c.2
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            c.this.fD.setText(com.kwad.sdk.core.response.b.a.aH(c.this.mAdInfo));
            c.this.fE.e(com.kwad.sdk.core.response.b.a.aH(c.this.mAdInfo), c.this.fE.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i) {
            c.this.fD.setText(i + "%");
            c.this.fE.e(i + "%", i);
        }

        @Override // com.kwad.sdk.core.download.a.a
        public final void onPaused(int i) {
            super.onPaused(i);
            c.this.fD.setText(com.kwad.sdk.core.response.b.a.abJ());
            c.this.fE.e(com.kwad.sdk.core.response.b.a.abJ(), i);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            c.this.fD.setText(com.kwad.sdk.core.response.b.a.cB(c.this.mAdTemplate));
            c.this.fE.e(com.kwad.sdk.core.response.b.a.cB(c.this.mAdTemplate), c.this.fE.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            c.this.fD.setText(com.kwad.sdk.core.response.b.a.aH(c.this.mAdInfo));
            c.this.fE.e(com.kwad.sdk.core.response.b.a.aH(c.this.mAdInfo), c.this.fE.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            c.this.fD.setText(com.kwad.sdk.core.response.b.a.ae(c.this.mAdInfo));
            c.this.fE.e(com.kwad.sdk.core.response.b.a.ae(c.this.mAdInfo), c.this.fE.getMax());
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.fA = (ViewGroup) findViewById(R.id.ksad_ad_normal_container);
        this.fB = (TextView) findViewById(R.id.ksad_ad_normal_title);
        this.fC = (TextView) findViewById(R.id.ksad_ad_normal_des);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_ad_normal_logo);
        this.fD = (TextView) findViewById(R.id.ksad_ad_normal_convert_btn);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.ksad_ad_light_convert_btn);
        this.fE = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
    }

    @Override // com.kwad.components.ad.draw.b.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        AdTemplate adTemplate = this.fm.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.eP(adTemplate);
        this.mApkDownloadHelper = this.fm.mApkDownloadHelper;
        aT();
        this.mLogoView.aQ(this.mAdTemplate);
        this.fD.setText(com.kwad.sdk.core.response.b.a.aH(this.mAdInfo));
        this.fD.setVisibility(8);
        this.fE.e(com.kwad.sdk.core.response.b.a.aH(this.mAdInfo), this.fE.getMax());
        this.fE.setVisibility(8);
        this.fA.setVisibility(0);
        this.fA.setOnClickListener(this);
        if (com.kwad.sdk.core.response.b.a.aJ(this.mAdInfo)) {
            this.fB.setText(com.kwad.sdk.core.response.b.a.ay(this.mAdInfo));
            this.fB.setVisibility(0);
            com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
            if (cVar != null) {
                cVar.b(this.fJ);
            }
        } else {
            this.fB.setVisibility(8);
        }
        this.fC.setText(com.kwad.sdk.core.response.b.a.aw(this.mAdInfo));
        this.fm.fo.b(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        KsAppDownloadListener ksAppDownloadListener;
        super.onUnbind();
        aV();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null && (ksAppDownloadListener = this.fJ) != null) {
            cVar.c(ksAppDownloadListener);
        }
        this.fm.fo.a(this.mVideoPlayStateListener);
    }

    private void aT() {
        this.fG = com.kwad.sdk.core.response.b.a.bx(this.mAdInfo);
        this.fH = com.kwad.sdk.core.response.b.a.by(this.mAdInfo);
        this.fI = com.kwad.sdk.core.response.b.a.bz(this.mAdInfo);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.fA) {
            aW();
            a(false, 2);
        } else if (view == this.fD) {
            aW();
            a(true, 1);
        } else if (view == this.fE) {
            a(true, 1);
        }
    }

    private void a(boolean z, int i) {
        com.kwad.components.core.e.d.a.a(new a.C0469a(this.fA.getContext()).aC(this.mAdTemplate).b(this.mApkDownloadHelper).aG(i).aq(z).a(new a.b() { // from class: com.kwad.components.ad.draw.presenter.c.3
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(c.this.mAdTemplate, 1, c.this.fm.mRootContainer.getTouchCoords());
                if (c.this.fm.eU != null) {
                    c.this.fm.eU.onAdClicked();
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU() {
        if (this.fD.getVisibility() == 0 || this.fE.getVisibility() == 0) {
            return;
        }
        this.fD.setOnClickListener(this);
        this.fD.setVisibility(0);
        TextView textView = this.fD;
        ValueAnimator valueAnimatorB = r.b(textView, 0, com.kwad.sdk.c.a.a.a(textView.getContext(), 44.0f));
        this.fF = valueAnimatorB;
        valueAnimatorB.setInterpolator(new DecelerateInterpolator(2.0f));
        this.fF.setDuration(300L);
        this.fF.start();
    }

    private void aV() {
        ValueAnimator valueAnimator = this.fF;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.fF.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW() {
        if (this.fE.getVisibility() == 0) {
            return;
        }
        this.fE.setOnClickListener(this);
        this.fE.setVisibility(0);
        this.fD.setVisibility(8);
    }
}

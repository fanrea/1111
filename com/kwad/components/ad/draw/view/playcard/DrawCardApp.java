package com.kwad.components.ad.draw.view.playcard;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.draw.view.DrawDownloadProgressBar;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.u.r;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DrawCardApp extends FrameLayout implements View.OnClickListener {
    private KsAppDownloadListener fJ;
    private a hN;
    private ImageView hO;
    private ImageView hP;
    private TextView hQ;
    private ViewGroup hR;
    private AppScoreView hS;
    private TextView hT;
    private TextView hU;
    private KsLogoView hV;
    private DrawDownloadProgressBar hW;
    private ValueAnimator hX;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private c mApkDownloadHelper;
    private int mHeight;

    public interface a {
        void bf();

        void bg();
    }

    public DrawCardApp(Context context) {
        super(context);
        B(context);
    }

    public DrawCardApp(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        B(context);
    }

    public DrawCardApp(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        B(context);
    }

    private void B(Context context) {
        m.inflate(context, R.layout.ksad_draw_card_app, this);
        this.hO = (ImageView) findViewById(R.id.ksad_card_app_close);
        this.hP = (ImageView) findViewById(R.id.ksad_card_app_icon);
        this.hQ = (TextView) findViewById(R.id.ksad_card_app_name);
        this.hR = (ViewGroup) findViewById(R.id.ksad_card_app_score_container);
        this.hS = (AppScoreView) findViewById(R.id.ksad_card_app_score);
        this.hT = (TextView) findViewById(R.id.ksad_card_app_download_count);
        this.hU = (TextView) findViewById(R.id.ksad_card_app_desc);
        this.hV = (KsLogoView) findViewById(R.id.ksad_card_logo);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.ksad_card_app_download_btn);
        this.hW = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
        this.mHeight = com.kwad.sdk.c.a.a.a(context, 156.0f);
    }

    public final void a(AdTemplate adTemplate, a aVar) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.eP(adTemplate);
        this.hN = aVar;
        this.mApkDownloadHelper = new c(this.mAdTemplate, getAppDownloadListener());
        KSImageLoader.loadAppIcon(this.hP, com.kwad.sdk.core.response.b.a.cC(this.mAdInfo), adTemplate, 11);
        this.hQ.setText(com.kwad.sdk.core.response.b.a.ay(this.mAdInfo));
        String strAC = com.kwad.sdk.core.response.b.a.aC(this.mAdInfo);
        float fAD = com.kwad.sdk.core.response.b.a.aD(this.mAdInfo);
        boolean z = fAD >= 3.0f;
        if (z) {
            this.hS.setScore(fAD);
            this.hS.setVisibility(0);
        }
        boolean z2 = !TextUtils.isEmpty(strAC);
        if (z2) {
            this.hT.setText(strAC);
            this.hT.setVisibility(0);
        }
        if (z || z2) {
            this.hR.setVisibility(0);
        } else {
            this.hR.setVisibility(8);
        }
        this.hV.aQ(this.mAdTemplate);
        this.hU.setText(com.kwad.sdk.core.response.b.a.aw(this.mAdInfo));
        this.hO.setOnClickListener(this);
        this.hW.setOnClickListener(this);
        setOnClickListener(this);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.fJ == null) {
            this.fJ = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardApp.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    DrawCardApp.this.hW.e(com.kwad.sdk.core.response.b.a.aH(DrawCardApp.this.mAdInfo), DrawCardApp.this.hW.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    DrawCardApp.this.hW.e(i + "%", i);
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i) {
                    super.onPaused(i);
                    DrawCardApp.this.hW.e(com.kwad.sdk.core.response.b.a.abJ(), i);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    DrawCardApp.this.hW.e(com.kwad.sdk.core.response.b.a.cB(DrawCardApp.this.mAdTemplate), DrawCardApp.this.hW.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    DrawCardApp.this.hW.e(com.kwad.sdk.core.response.b.a.aH(DrawCardApp.this.mAdInfo), DrawCardApp.this.hW.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    DrawCardApp.this.hW.e(com.kwad.sdk.core.response.b.a.ae(DrawCardApp.this.mAdInfo), DrawCardApp.this.hW.getMax());
                }
            };
        }
        return this.fJ;
    }

    public final void release() {
        bq();
        this.mApkDownloadHelper = null;
    }

    public final void bY() {
        e(0, this.mHeight);
    }

    private void bZ() {
        e(this.mHeight, 0);
    }

    private void e(int i, int i2) {
        bq();
        ValueAnimator valueAnimatorB = r.b(this, i, i2);
        this.hX = valueAnimatorB;
        valueAnimatorB.setInterpolator(new DecelerateInterpolator(2.0f));
        this.hX.setDuration(300L);
        this.hX.start();
    }

    private void bq() {
        ValueAnimator valueAnimator = this.hX;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.hX.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hO) {
            bZ();
            a aVar = this.hN;
            if (aVar != null) {
                aVar.bf();
                return;
            }
            return;
        }
        com.kwad.components.core.e.d.a.a(new a.C0469a(getContext()).aC(this.mAdTemplate).b(this.mApkDownloadHelper).aq(view == this.hW).aG(view == this.hW ? 1 : 2).a(new a.b() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardApp.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (DrawCardApp.this.hN != null) {
                    DrawCardApp.this.hN.bg();
                }
            }
        }));
    }
}

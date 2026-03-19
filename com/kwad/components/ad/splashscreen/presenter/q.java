package com.kwad.components.ad.splashscreen.presenter;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class q extends e {
    private KsSplashSlidePathView IC;
    private double IJ;
    private AdMatrixInfo.SplashSlideInfo IK;
    private com.kwad.components.ad.splashscreen.e.a Iq;
    private com.kwad.components.core.e.d.c Jp;
    private TextView Js;
    private ImageView Jt;
    private com.kwad.components.ad.splashscreen.widget.d Ju;
    private AdInfo mAdInfo;
    private long mStartTime;
    private TextView mf;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mStartTime = SystemClock.elapsedRealtime();
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_slide_layout);
        if (viewStub != null) {
            viewStub.inflate();
        }
        this.mf = (TextView) findViewById(R.id.ksad_splash_slide_title);
        this.Js = (TextView) findViewById(R.id.ksad_splash_slide_actiontext);
        this.Jt = (ImageView) findViewById(R.id.ksad_splash_slideView);
        ViewStub viewStub2 = (ViewStub) findViewById(R.id.ksad_splash_slideTouchView);
        if (viewStub2 != null) {
            this.IC = (KsSplashSlidePathView) viewStub2.inflate();
        } else {
            this.IC = (KsSplashSlidePathView) findViewById(R.id.ksad_splash_slideview_root);
        }
        KsSplashSlidePathView ksSplashSlidePathView = this.IC;
        if (ksSplashSlidePathView != null) {
            ksSplashSlidePathView.setOnSlideTouchListener(new KsSplashSlidePathView.a() { // from class: com.kwad.components.ad.splashscreen.presenter.q.1
                @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                public final void a(float f, float f2, float f3, float f4) {
                    final float fPx2dip = com.kwad.sdk.c.a.a.px2dip(q.this.getContext(), (float) Math.sqrt(Math.pow(f3 - f, 2.0d) + Math.pow(f4 - f2, 2.0d)));
                    if (fPx2dip < q.this.IJ || q.this.HX == null) {
                        return;
                    }
                    q.this.HX.a(1, q.this.getContext(), 153, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.q.1.1
                        @Override // com.kwad.components.ad.splashscreen.h.a
                        public final void b(com.kwad.sdk.core.adlog.c.b bVar) {
                            bVar.eZ(q.this.IK.style);
                            bVar.fa((int) fPx2dip);
                        }
                    });
                }

                @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                public final void c(MotionEvent motionEvent) {
                    if (!com.kwad.components.ad.splashscreen.h.n(q.this.mAdInfo) || q.this.HX == null) {
                        return;
                    }
                    q.this.HX.c(1, q.this.getContext(), 53, 2);
                }
            });
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        if (this.HX == null) {
            return;
        }
        bx.postOnUiThread(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.q.2
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                q.this.HX.Hz = SystemClock.elapsedRealtime() - q.this.mStartTime;
            }
        });
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eP(this.HX.mAdTemplate);
        this.Jp = this.HX.mApkDownloadHelper;
        initView();
        if (com.kwad.sdk.core.response.b.a.aJ(this.mAdInfo)) {
            mA();
        }
    }

    private void initView() {
        this.IK = this.mAdInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.slideInfo;
        this.IJ = r0.convertDistance;
        int i = this.IK.style;
        com.kwad.components.ad.splashscreen.widget.d dVar = new com.kwad.components.ad.splashscreen.widget.d(getContext(), i);
        this.Ju = dVar;
        this.Jt.setImageDrawable(dVar);
        this.Jt.post(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.q.3
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                q.this.mC();
                if (q.this.Ju != null) {
                    q.this.Ju.start();
                }
            }
        });
        if (!TextUtils.isEmpty(this.IK.title)) {
            this.mf.setText(this.IK.title);
        } else if (i == 0) {
            this.mf.setText("向上滑动");
        } else if (i == 1) {
            this.mf.setText("向左滑动");
        } else if (i == 2) {
            this.mf.setText("向右滑动");
        }
        if (!TextUtils.isEmpty(this.IK.subtitle)) {
            this.Js.setText(this.IK.subtitle);
        } else if (com.kwad.sdk.core.response.b.a.aJ(this.mAdInfo)) {
            this.Js.setText(com.kwad.components.ad.splashscreen.d.a(this.HX.mAdTemplate, this.mAdInfo, this.Jp.pK(), 0));
        } else {
            this.Js.setText("跳转详情页或者第三方应用");
        }
    }

    private void mA() {
        com.kwad.components.ad.splashscreen.e.a aVar = this.Iq;
        if (aVar == null) {
            com.kwad.components.ad.splashscreen.e.a aVar2 = new com.kwad.components.ad.splashscreen.e.a(getContext(), this.HX.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.presenter.q.4
                {
                    super(adTemplate);
                }

                @Override // com.kwad.components.ad.splashscreen.e.a
                public final void j(int i, String str) {
                    q.this.Js.setText(str);
                }
            };
            this.Iq = aVar2;
            this.Jp.b(aVar2);
            return;
        }
        aVar.setAdTemplate(this.HX.mAdTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mC() {
        if (this.IK != null) {
            com.kwad.sdk.core.adlog.c.d(this.HX.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().eZ(this.IK.style).eR(190));
            com.kwad.components.core.webview.tachikoma.e.a.wk().bt(190);
        }
    }
}

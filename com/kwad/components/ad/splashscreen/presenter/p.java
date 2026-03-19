package com.kwad.components.ad.splashscreen.presenter;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsSlideHandView;
import com.kwad.components.ad.splashscreen.widget.KsSlideRoundView;
import com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class p extends e {
    private KsSlideRoundView IB;
    private KsSplashSlidePathView IC;
    private double IJ;
    private AdMatrixInfo.SplashSlideInfo IK;
    private float IL;
    private float IM;
    private float IN;
    private float IO;
    private float IP;
    private boolean IQ = false;
    private boolean IR = false;
    private com.kwad.components.ad.splashscreen.e.a Iq;
    private View Jm;
    private TextView Jn;
    private KsSlideHandView Jo;
    private com.kwad.components.core.e.d.c Jp;
    private float mActionBarHeight;
    private AdInfo mAdInfo;
    private long mStartTime;

    static /* synthetic */ boolean a(p pVar, boolean z) {
        pVar.IR = true;
        return true;
    }

    static /* synthetic */ boolean b(p pVar, boolean z) {
        pVar.IQ = true;
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mStartTime = SystemClock.elapsedRealtime();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        if (this.HX == null) {
            return;
        }
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eP(this.HX.mAdTemplate);
        this.Jp = this.HX.mApkDownloadHelper;
        this.IK = this.mAdInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.slideInfo;
        this.IJ = r0.convertDistance;
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_splash_slideTouchView);
        if (viewStub != null) {
            this.IC = (KsSplashSlidePathView) viewStub.inflate();
        } else {
            this.IC = (KsSplashSlidePathView) findViewById(R.id.ksad_splash_slideview_root);
        }
        KsSplashSlidePathView ksSplashSlidePathView = this.IC;
        if (ksSplashSlidePathView != null) {
            ksSplashSlidePathView.setOnSlideTouchListener(new KsSplashSlidePathView.a() { // from class: com.kwad.components.ad.splashscreen.presenter.p.1
                @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                public final void a(float f, float f2, float f3, float f4) {
                    final float fPx2dip = com.kwad.sdk.c.a.a.px2dip(p.this.mz(), (float) Math.sqrt(Math.pow(f3 - f, 2.0d) + Math.pow(f4 - f2, 2.0d)));
                    if (fPx2dip < p.this.IJ || p.this.HX == null) {
                        return;
                    }
                    p.this.HX.a(1, p.this.mz(), 153, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.p.1.1
                        @Override // com.kwad.components.ad.splashscreen.h.a
                        public final void b(com.kwad.sdk.core.adlog.c.b bVar) {
                            bVar.eZ(p.this.IK.style);
                            bVar.fa((int) fPx2dip);
                        }
                    });
                }

                @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                public final void c(MotionEvent motionEvent) {
                    if (p.this.IQ && p.this.IR) {
                        float x = motionEvent.getX() + p.this.IN;
                        float y = motionEvent.getY() + p.this.IO;
                        if (x >= p.this.IL && x <= p.this.IL + p.this.IP && y >= p.this.IM && y <= p.this.IM + p.this.mActionBarHeight) {
                            p.this.my();
                            return;
                        }
                    }
                    if (com.kwad.components.ad.splashscreen.h.n(p.this.mAdInfo)) {
                        p.this.my();
                    }
                }
            });
            this.IC.post(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.p.2
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    p.this.IC.getLocationOnScreen(new int[2]);
                    p.this.IN = r0[0];
                    p.this.IO = r0[1];
                    p.a(p.this, true);
                }
            });
        }
        bx.postOnUiThread(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.p.3
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                p.this.HX.Hz = SystemClock.elapsedRealtime() - p.this.mStartTime;
            }
        });
        initView();
        if (com.kwad.sdk.core.response.b.a.aJ(this.mAdInfo)) {
            mA();
        }
        as();
        ji();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void my() {
        if (this.HX != null) {
            this.HX.c(1, mz(), 53, 2);
        }
    }

    private void initView() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_slide_combo_layout);
        if (viewStub != null) {
            this.Jm = viewStub.inflate();
        } else {
            this.Jm = findViewById(R.id.ksad_slide_combo_root);
        }
        this.Jo = (KsSlideHandView) findViewById(R.id.ksad_slide_combo_slide_hand);
        this.Jn = (TextView) findViewById(R.id.ksad_slide_combo_action_sub_text);
        this.IB = (KsSlideRoundView) findViewById(R.id.ksad_slide_combo_round_bg);
        this.Jn.setText(mB());
        this.IB.post(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.p.4
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                p.this.IB.getLocationOnScreen(new int[2]);
                p.this.IL = r0[0];
                p.this.IM = r0[1];
                p.this.IP = r0.IB.getWidth();
                p.this.mActionBarHeight = r0.IB.getHeight();
                p.b(p.this, true);
            }
        });
    }

    protected final Context mz() {
        Context context;
        View view;
        try {
            context = getContext();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            context = null;
        }
        return (context != null || (view = this.Jm) == null) ? context : view.getContext();
    }

    private void as() {
        if (this.Jm == null || this.HX == null) {
            return;
        }
        this.Jm.setVisibility(0);
        com.kwad.sdk.core.adlog.c.b(this.HX.mAdTemplate, 243, (JSONObject) null);
        com.kwad.components.core.webview.tachikoma.e.a.wk().bt(243);
    }

    private void mA() {
        com.kwad.components.ad.splashscreen.e.a aVar = this.Iq;
        if (aVar == null) {
            com.kwad.components.ad.splashscreen.e.a aVar2 = new com.kwad.components.ad.splashscreen.e.a(mz(), this.HX.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.presenter.p.5
                {
                    super(adTemplate);
                }

                @Override // com.kwad.components.ad.splashscreen.e.a
                public final void j(int i, String str) {
                    if (p.this.Jn != null) {
                        p.this.Jn.setText(str);
                    }
                }
            };
            this.Iq = aVar2;
            this.Jp.b(aVar2);
            return;
        }
        aVar.setAdTemplate(this.HX.mAdTemplate);
    }

    private String mB() {
        try {
            return TextUtils.isEmpty(com.kwad.sdk.core.response.b.b.dW(this.mAdInfo)) ? com.kwad.sdk.core.response.b.b.dW(this.mAdInfo) : "跳转详情页或第三方应用";
        } catch (Exception unused) {
            return "跳转详情页或第三方应用";
        }
    }

    private void ji() {
        KsSlideHandView ksSlideHandView = this.Jo;
        if (ksSlideHandView != null) {
            ksSlideHandView.fR();
        }
        KsSlideRoundView ksSlideRoundView = this.IB;
        if (ksSlideRoundView != null) {
            ksSlideRoundView.fR();
        }
    }
}

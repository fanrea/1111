package com.kwad.components.ad.splashscreen.presenter;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsRotateTypeTwoView;
import com.kwad.components.ad.splashscreen.widget.KsSlideArrowView;
import com.kwad.components.ad.splashscreen.widget.KsSlideRoundView;
import com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bh;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class l extends i implements View.OnClickListener, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.g.a {
    private TextView IA;
    private KsSlideRoundView IB;
    private KsSplashSlidePathView IC;
    private KsRotateTypeTwoView IE;
    private View IF;
    private com.kwad.components.ad.splashscreen.d IG;
    private KsSlideArrowView IH;
    private KsSlideArrowView II;
    private double IJ;
    private AdMatrixInfo.SplashSlideInfo IK;
    private float IL;
    private float IM;
    private float IN;
    private float IO;
    private float IP;
    private boolean IQ = false;
    private boolean IR = false;
    private com.kwad.sdk.core.g.c iR;
    private float mActionBarHeight;
    private AdInfo mAdInfo;
    private long mStartTime;

    @Override // com.kwad.components.ad.splashscreen.g
    public final void ak(int i) {
    }

    static /* synthetic */ boolean a(l lVar, boolean z) {
        lVar.IR = true;
        return true;
    }

    static /* synthetic */ boolean b(l lVar, boolean z) {
        lVar.IQ = true;
        return true;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        View rootView;
        this.mStartTime = SystemClock.elapsedRealtime();
        super.ay();
        if (this.HX == null || (rootView = getRootView()) == null) {
            return;
        }
        rootView.post(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.l.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                if (l.this.HX != null) {
                    l.this.HX.Hz = SystemClock.elapsedRealtime() - l.this.mStartTime;
                }
            }
        });
        this.HX.a(this);
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(this.HX.mAdTemplate);
        this.mAdInfo = adInfoEP;
        try {
            this.IK = adInfoEP.adMatrixInfo.adDataV2.splashInfo.interactionInfo.slideInfo;
            this.IJ = r0.convertDistance;
            ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_splash_slideTouchView);
            if (viewStub != null) {
                this.IC = (KsSplashSlidePathView) viewStub.inflate();
            } else {
                this.IC = (KsSplashSlidePathView) findViewById(R.id.ksad_splash_slideview_root);
            }
            KsSplashSlidePathView ksSplashSlidePathView = this.IC;
            if (ksSplashSlidePathView != null) {
                ksSplashSlidePathView.setOnSlideTouchListener(new KsSplashSlidePathView.a() { // from class: com.kwad.components.ad.splashscreen.presenter.l.2
                    @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                    public final void a(float f, float f2, float f3, float f4) {
                        final float fPx2dip = com.kwad.sdk.c.a.a.px2dip(l.this.mz(), (float) Math.sqrt(Math.pow(f3 - f, 2.0d) + Math.pow(f4 - f2, 2.0d)));
                        if (fPx2dip < l.this.IJ || l.this.HX == null) {
                            return;
                        }
                        l.this.HX.a(1, l.this.mz(), 153, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.l.2.1
                            @Override // com.kwad.components.ad.splashscreen.h.a
                            public final void b(com.kwad.sdk.core.adlog.c.b bVar) {
                                bVar.eZ(l.this.IK.style);
                                bVar.fa((int) fPx2dip);
                            }
                        });
                    }

                    @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                    public final void c(MotionEvent motionEvent) {
                        if (l.this.IQ && l.this.IR) {
                            float x = motionEvent.getX() + l.this.IN;
                            float y = motionEvent.getY() + l.this.IO;
                            if (x >= l.this.IL && x <= l.this.IL + l.this.IP && y >= l.this.IM && y <= l.this.IM + l.this.mActionBarHeight) {
                                l.this.my();
                                return;
                            }
                        }
                        if (com.kwad.components.ad.splashscreen.h.n(l.this.mAdInfo)) {
                            l.this.my();
                        }
                    }
                });
                this.IC.post(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.l.3
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        l.this.IC.getLocationOnScreen(new int[2]);
                        l.this.IN = r0[0];
                        l.this.IO = r0[1];
                        l.a(l.this, true);
                    }
                });
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void my() {
        if (this.HX != null) {
            this.HX.c(1, mz(), 53, 2);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.d("SplashRotateComboPresenter", "onUnbind");
        if (this.HX != null) {
            this.HX.b(this);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void initView() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_rotate_combo_layout);
        if (viewStub != null) {
            this.IF = viewStub.inflate();
        } else {
            this.IF = findViewById(R.id.ksad_rotate_combo_root);
        }
        this.IB = (KsSlideRoundView) findViewById(R.id.ksad_rotate_combo_slide_round_img);
        this.IA = (TextView) findViewById(R.id.ksad_rotate_combo_action_text);
        this.IE = (KsRotateTypeTwoView) findViewById(R.id.ksad_rotate_combo_rotate_view);
        this.IH = (KsSlideArrowView) findViewById(R.id.ksad_rotate_combo_slide_arrow_top);
        this.II = (KsSlideArrowView) findViewById(R.id.ksad_rotate_combo_slide_arrow_bottom);
        this.IH.setAnimationDelayTime(200);
        this.II.setAnimationDelayTime(200);
        this.IB.post(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.l.4
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                l.this.IB.getLocationOnScreen(new int[2]);
                l.this.IL = r0[0];
                l.this.IM = r0[1];
                l.this.IP = r0.IB.getWidth();
                l.this.mActionBarHeight = r0.IB.getHeight();
                l.b(l.this, true);
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mr() {
        AdTemplate adTemplate = this.HX.mAdTemplate;
        com.kwad.components.ad.splashscreen.d dVarA = com.kwad.components.ad.splashscreen.d.a(adTemplate, com.kwad.sdk.core.response.b.e.eP(adTemplate), this.HX.mApkDownloadHelper, 10);
        this.IG = dVarA;
        TextView textView = this.IA;
        if (textView != null) {
            textView.setText(dVarA.lE());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void ms() {
        if (this.IF == null || this.HX == null) {
            return;
        }
        this.IF.setVisibility(0);
        com.kwad.sdk.core.adlog.c.b(this.HX.mAdTemplate, 200, (JSONObject) null);
        com.kwad.components.core.webview.tachikoma.e.a.wk().bt(200);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mt() {
        AdMatrixInfo.RotateInfo rotateInfoDJ = com.kwad.sdk.core.response.b.b.dJ(this.HX.mAdTemplate);
        com.kwad.sdk.core.g.c cVar = this.iR;
        if (cVar == null) {
            com.kwad.sdk.core.g.c cVar2 = new com.kwad.sdk.core.g.c(rotateInfoDJ);
            this.iR = cVar2;
            cVar2.a(this);
        } else {
            cVar.b(rotateInfoDJ);
        }
        KsRotateTypeTwoView ksRotateTypeTwoView = this.IE;
        if (ksRotateTypeTwoView != null) {
            ksRotateTypeTwoView.setOnClickListener(this);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mu() {
        com.kwad.sdk.core.g.c cVar = this.iR;
        if (cVar != null) {
            cVar.bW(mz());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mv() {
        com.kwad.sdk.core.g.c cVar = this.iR;
        if (cVar != null) {
            cVar.bX(mz());
        }
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
        return (context != null || (view = this.IF) == null) ? context : view.getContext();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void fR() {
        KsSlideArrowView ksSlideArrowView = this.IH;
        if (ksSlideArrowView != null && this.II != null) {
            ksSlideArrowView.postDelayed(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.l.5
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    l.this.IH.fR();
                }
            }, 200L);
            this.II.post(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.l.6
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    l.this.II.fR();
                }
            });
        }
        KsRotateTypeTwoView ksRotateTypeTwoView = this.IE;
        if (ksRotateTypeTwoView != null) {
            ksRotateTypeTwoView.post(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.l.7
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    l.this.IE.fR();
                }
            });
        }
        KsSlideRoundView ksSlideRoundView = this.IB;
        if (ksSlideRoundView != null) {
            ksSlideRoundView.post(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.l.8
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    l.this.IB.fR();
                }
            });
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void i(int i, String str) {
        if (this.IA != null) {
            if (i != 2) {
                str = "扭动或点击" + str;
            }
            this.IA.setText(str);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.HX != null) {
            this.HX.c(1, mz(), 162, 1);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void lK() {
        com.kwad.sdk.core.g.c cVar = this.iR;
        if (cVar != null) {
            cVar.bX(mz());
        }
    }

    @Override // com.kwad.sdk.core.g.a
    public final void r(final String str) {
        boolean zWO = this.HX.Hk.wO();
        boolean zPe = com.kwad.components.core.e.c.b.pe();
        if (!zWO || zPe) {
            return;
        }
        this.IH.nA();
        this.II.nA();
        this.IB.nA();
        this.IE.nA();
        if (this.HX != null) {
            this.HX.a(1, mz(), 161, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.l.9
                @Override // com.kwad.components.ad.splashscreen.h.a
                public final void b(com.kwad.sdk.core.adlog.c.b bVar) {
                    bVar.eK(str);
                }
            });
        }
        mx();
        mv();
    }

    @Override // com.kwad.sdk.core.g.a
    public final void cj() {
        com.kwad.sdk.core.adlog.c.cq(this.HX.mAdTemplate);
    }
}

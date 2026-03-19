package com.kwad.components.ad.splashscreen.presenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsButtonBorderSpreadView;
import com.kwad.components.ad.splashscreen.widget.KsShakeView;
import com.kwad.components.ad.splashscreen.widget.KsSlideArrowView;
import com.kwad.components.ad.splashscreen.widget.KsSlidePopUpView;
import com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class n extends i implements View.OnClickListener, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.g.b {
    private KsSplashSlidePathView IC;
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
    private TextView IZ;
    private TextView Ja;
    private KsSlidePopUpView Jb;
    private KsButtonBorderSpreadView Jc;
    private KsShakeView Jd;
    private View Je;
    private ImageView Jf;
    private com.kwad.sdk.core.g.d iQ;
    private Vibrator iS;
    private float mActionBarHeight;
    private AdInfo mAdInfo;
    private long mStartTime;

    @Override // com.kwad.components.ad.splashscreen.g
    public final void ak(int i) {
    }

    static /* synthetic */ boolean a(n nVar, boolean z) {
        nVar.IR = true;
        return true;
    }

    static /* synthetic */ boolean b(n nVar, boolean z) {
        nVar.IQ = true;
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
        rootView.post(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.n.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                if (n.this.HX != null) {
                    n.this.HX.Hz = SystemClock.elapsedRealtime() - n.this.mStartTime;
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
                ksSplashSlidePathView.setOnSlideTouchListener(new KsSplashSlidePathView.a() { // from class: com.kwad.components.ad.splashscreen.presenter.n.3
                    @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                    public final void a(float f, float f2, float f3, float f4) {
                        final float fPx2dip = com.kwad.sdk.c.a.a.px2dip(n.this.mz(), (float) Math.sqrt(Math.pow(f3 - f, 2.0d) + Math.pow(f4 - f2, 2.0d)));
                        if (fPx2dip < n.this.IJ || n.this.HX == null) {
                            return;
                        }
                        n.this.HX.a(1, n.this.mz(), 153, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.n.3.1
                            @Override // com.kwad.components.ad.splashscreen.h.a
                            public final void b(com.kwad.sdk.core.adlog.c.b bVar) {
                                bVar.eZ(n.this.IK.style);
                                bVar.fa((int) fPx2dip);
                            }
                        });
                    }

                    @Override // com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.a
                    public final void c(MotionEvent motionEvent) {
                        if (n.this.IQ && n.this.IR) {
                            float x = motionEvent.getX() + n.this.IN;
                            float y = motionEvent.getY() + n.this.IO;
                            if (x >= n.this.IL && x <= n.this.IL + n.this.IP && y >= n.this.IM && y <= n.this.IM + n.this.mActionBarHeight) {
                                n.this.my();
                                return;
                            }
                        }
                        if (com.kwad.components.ad.splashscreen.h.n(n.this.mAdInfo)) {
                            n.this.my();
                        }
                    }
                });
                this.IC.post(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.n.4
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        n.this.IC.getLocationOnScreen(new int[2]);
                        n.this.IN = r0[0];
                        n.this.IO = r0[1];
                        n.a(n.this, true);
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
        com.kwad.sdk.core.d.c.d("SplashShakeComboPresenter", "onUnbind");
        if (this.HX != null) {
            this.HX.b(this);
        }
        KsShakeView ksShakeView = this.Jd;
        if (ksShakeView != null) {
            ksShakeView.nC();
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
        return (context != null || (view = this.Je) == null) ? context : view.getContext();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.HX != null) {
            this.HX.c(1, mz(), 158, 1);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void lK() {
        com.kwad.sdk.core.g.d dVar = this.iQ;
        if (dVar != null) {
            dVar.bX(mz());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void initView() {
        Context contextMz = mz();
        if (contextMz != null) {
            this.iS = (Vibrator) contextMz.getSystemService("vibrator");
        }
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_shake_combo_layout);
        if (viewStub != null) {
            this.Je = viewStub.inflate();
        } else {
            this.Je = findViewById(R.id.ksad_shake_combo_root);
        }
        this.Jb = (KsSlidePopUpView) findViewById(R.id.ksad_shake_combo_slide_popup_view);
        this.IZ = (TextView) findViewById(R.id.ksad_shake_combo_shake_main_text);
        this.Ja = (TextView) findViewById(R.id.ksad_shake_combo_sub_text);
        this.Jd = (KsShakeView) findViewById(R.id.ksad_shake_combo_shake_icon);
        this.IH = (KsSlideArrowView) findViewById(R.id.ksad_shake_combo_slide_arrow_top);
        this.II = (KsSlideArrowView) findViewById(R.id.ksad_shake_combo_slide_arrow_bottom);
        this.Jc = (KsButtonBorderSpreadView) findViewById(R.id.ksad_shake_combo_button_spread);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_shake_combo_button_background);
        this.Jf = imageView;
        imageView.post(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.n.5
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                n.this.Jf.getLocationOnScreen(new int[2]);
                n.this.IL = r0[0];
                n.this.IM = r0[1];
                n.this.IP = r0.Jf.getWidth();
                n.this.mActionBarHeight = r0.Jf.getHeight();
                n.b(n.this, true);
            }
        });
        this.IH.setAnimationDelayTime(500);
        this.II.setAnimationDelayTime(500);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mr() {
        AdTemplate adTemplate = this.HX.mAdTemplate;
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        this.IG = com.kwad.components.ad.splashscreen.d.a(adTemplate, adInfoEP, this.HX.mApkDownloadHelper, 9);
        TextView textView = this.IZ;
        if (textView != null) {
            textView.setText(com.kwad.sdk.core.response.b.b.dT(adInfoEP));
        }
        TextView textView2 = this.Ja;
        if (textView2 != null) {
            textView2.setText(this.IG.lE());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void ms() {
        if (this.Je == null || this.HX == null) {
            return;
        }
        this.Je.setVisibility(0);
        com.kwad.sdk.core.adlog.c.b(this.HX.mAdTemplate, 199, (JSONObject) null);
        com.kwad.components.core.webview.tachikoma.e.a.wk().bt(199);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mt() {
        float fDI = com.kwad.sdk.core.response.b.b.dI(this.HX.mAdTemplate);
        com.kwad.sdk.core.g.d dVar = this.iQ;
        if (dVar == null) {
            com.kwad.sdk.core.g.d dVar2 = new com.kwad.sdk.core.g.d(fDI);
            this.iQ = dVar2;
            dVar2.a(this);
        } else {
            dVar.K(fDI);
        }
        KsShakeView ksShakeView = this.Jd;
        if (ksShakeView != null) {
            ksShakeView.setOnClickListener(this);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mu() {
        com.kwad.sdk.core.g.d dVar = this.iQ;
        if (dVar != null) {
            dVar.bW(mz());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void mv() {
        com.kwad.sdk.core.g.d dVar = this.iQ;
        if (dVar != null) {
            dVar.bX(mz());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void fR() {
        KsShakeView ksShakeView = this.Jd;
        if (ksShakeView != null) {
            ksShakeView.post(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.n.6
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    n.this.Jd.nB();
                }
            });
        }
        KsSlidePopUpView ksSlidePopUpView = this.Jb;
        if (ksSlidePopUpView != null) {
            ksSlidePopUpView.post(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.n.7
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    n.this.Jb.nD();
                }
            });
        }
        KsButtonBorderSpreadView ksButtonBorderSpreadView = this.Jc;
        if (ksButtonBorderSpreadView != null) {
            ksButtonBorderSpreadView.postDelayed(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.n.8
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    n.this.Jc.fR();
                }
            }, 300L);
        }
        KsSlideArrowView ksSlideArrowView = this.IH;
        if (ksSlideArrowView != null) {
            ksSlideArrowView.postDelayed(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.n.9
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    n.this.IH.fR();
                }
            }, 1000L);
        }
        KsSlideArrowView ksSlideArrowView2 = this.II;
        if (ksSlideArrowView2 != null) {
            ksSlideArrowView2.postDelayed(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.n.10
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    n.this.II.fR();
                }
            }, 800L);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.i
    protected final void i(int i, String str) {
        if (this.Ja != null) {
            if (i != 2) {
                str = "或点击" + str;
            }
            this.Ja.setText(str);
        }
    }

    @Override // com.kwad.sdk.core.g.b
    public final void d(final double d) throws Resources.NotFoundException {
        boolean zPe = com.kwad.components.core.e.c.b.pe();
        if (!this.HX.Hk.wO() || zPe) {
            return;
        }
        this.Jd.b(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.presenter.n.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (n.this.HX != null) {
                    n.this.HX.a(1, n.this.mz(), 157, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.n.2.1
                        @Override // com.kwad.components.ad.splashscreen.h.a
                        public final void b(com.kwad.sdk.core.adlog.c.b bVar) {
                            bVar.o(d);
                        }
                    });
                }
                n.this.Jd.nB();
            }
        });
        bx.a(mz(), this.iS);
        mv();
    }

    @Override // com.kwad.sdk.core.g.b
    public final void ci() {
        com.kwad.sdk.core.adlog.c.cq(this.HX.mAdTemplate);
    }
}

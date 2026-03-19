package com.kwad.components.ad.interstitial.f;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.kwad.components.ad.interstitial.f.c;
import com.kwad.components.core.video.a;
import com.kwad.components.core.widget.KsAutoCloseView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends b {
    public static float oG = 1.3333334f;
    private static float oH = 0.749f;
    private static float oI = 0.8f;
    private static float oJ = 1.0f;
    private com.kwad.sdk.core.video.videoview.a ed;
    private com.kwad.components.core.widget.a.c gR;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private KsAutoCloseView nX;
    private boolean oE;
    private KSFrameLayout oF;
    private c.b oK;
    private com.kwad.sdk.core.j.d oL = new com.kwad.sdk.core.j.d() { // from class: com.kwad.components.ad.interstitial.f.d.5
        @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
        public final void by() {
            if (!d.this.mAdTemplate.mPvReported && !d.this.oa.oe && d.this.oa.mH != null) {
                d.this.oa.mH.onAdShow();
                d.this.oa.mN.getTimerHelper().startTiming();
                com.kwad.components.ad.interstitial.report.c.eX().a(d.this.oa.mAdTemplate, 1);
            }
            com.kwad.sdk.core.adlog.c.b bVarFb = new com.kwad.sdk.core.adlog.c.b().fb(d.this.oa.oo);
            if (!d.this.mAdTemplate.mPvReported) {
                com.kwad.components.ad.interstitial.report.c.eX().E(d.this.mAdTemplate);
            }
            com.kwad.components.core.u.b.tq().a(d.this.mAdTemplate, null, bVarFb);
            d.this.nX.setCountDownPaused(false);
        }

        @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
        public final void bz() {
            d.this.nX.setCountDownPaused(true);
        }
    };
    private c oa;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        KsAutoCloseView ksAutoCloseView = (KsAutoCloseView) findViewById(R.id.ksad_interstitial_auto_close);
        this.nX = ksAutoCloseView;
        ksAutoCloseView.setViewListener(new KsAutoCloseView.a() { // from class: com.kwad.components.ad.interstitial.f.d.1
            @Override // com.kwad.components.core.widget.KsAutoCloseView.a
            public final void el() {
                d.this.o(true);
            }

            @Override // com.kwad.components.core.widget.KsAutoCloseView.a
            public final void em() {
                d.this.o(false);
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.oa.b(this.oK);
        com.kwad.components.core.widget.a.c cVar = this.gR;
        if (cVar != null) {
            cVar.b(this.oL);
            this.gR.wL();
        }
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        c cVar = (c) amf();
        this.oa = cVar;
        this.mAdTemplate = cVar.mAdTemplate;
        com.kwad.components.ad.interstitial.report.c.eX().D(this.oa.mAdTemplate);
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(this.oa.mAdTemplate);
        this.mAdInfo = adInfoEP;
        if (com.kwad.sdk.core.response.b.a.bb(adInfoEP).width > 0) {
            oG = r0.height / r0.width;
        }
        this.oa.hG.setBackgroundColor(Color.parseColor("#99000000"));
        this.oa.ob.setVisibility(0);
        this.oa.ob.I(this.mAdTemplate);
        this.oa.a(ei());
        ej();
        this.oa.ob.setViewListener(new com.kwad.components.ad.interstitial.h.e() { // from class: com.kwad.components.ad.interstitial.f.d.2
            @Override // com.kwad.components.ad.interstitial.h.e
            public final void en() {
                d.this.f(3, d.this.oa.ob.fo() ? 53 : 85);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void p(boolean z) {
                if (d.this.ed != null) {
                    d.this.ed.setVideoSoundEnable(z);
                }
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void em() {
                d.this.o(false);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void eo() {
                d.this.f(1, 39);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void ep() {
                d.this.f(1, 29);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void eq() {
                d.this.f(3, 85);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void er() {
                d.this.f(3, 85);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void es() {
                d.this.f(2, 53);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void q(boolean z) {
                d.this.oE = z;
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void a(KSFrameLayout kSFrameLayout) {
                d.this.oF = kSFrameLayout;
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void et() {
                d.this.f(2, 30);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void eu() {
                d.this.f(2, 31);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void ev() {
                d.this.f(2, 32);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void ew() {
                d.this.f(2, 15);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void ex() {
                d.this.f(2, 16);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void ey() {
                d.this.f(2, 17);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void ez() {
                d.this.f(2, 35);
            }
        });
        com.kwad.components.core.widget.a.c cVar2 = new com.kwad.components.core.widget.a.c(this.oa.ob, 100);
        this.gR = cVar2;
        cVar2.a(this.oL);
        this.gR.wK();
        final boolean zBa = com.kwad.sdk.core.response.b.a.ba(this.mAdInfo);
        getContext();
        final boolean zApb = aq.apb();
        this.oa.ob.setRatio(b(zApb, zBa));
        final ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_interstitial_native);
        viewGroup.setVisibility(0);
        viewGroup.post(new bh() { // from class: com.kwad.components.ad.interstitial.f.d.3
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                ViewGroup.LayoutParams layoutParamsA = zApb ? d.a(d.this.getRootView().getWidth(), zBa) : d.N(d.this.getRootView().getHeight());
                ViewParent parent = d.this.oa.ob.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(d.this.oa.ob);
                }
                viewGroup.addView(d.this.oa.ob);
                d.this.oa.ob.g(layoutParamsA.width, layoutParamsA.height);
                viewGroup.requestLayout();
                viewGroup.post(new bh() { // from class: com.kwad.components.ad.interstitial.f.d.3.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        if (d.this.ed != null) {
                            d.this.ed.requestLayout();
                        }
                    }
                });
            }
        });
    }

    private c.b ei() {
        c.b bVar = new c.b() { // from class: com.kwad.components.ad.interstitial.f.d.4
            @Override // com.kwad.components.ad.interstitial.f.c.b
            public final void c(long j, long j2) {
                com.kwad.components.ad.interstitial.report.a.eT().b(d.this.mAdTemplate, j, j2);
            }
        };
        this.oK = bVar;
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ViewGroup.LayoutParams a(int i, boolean z) {
        float f;
        if (z) {
            f = oI;
        } else {
            f = oJ;
        }
        int i2 = (int) (i * f);
        return new ViewGroup.LayoutParams(i2, (int) (i2 * (z ? oG : 0.749f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ViewGroup.LayoutParams N(int i) {
        int i2 = (int) (i * oH);
        return new ViewGroup.LayoutParams((int) (i2 / 0.749f), i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i, int i2) {
        if (this.oa.a(new c.C0420c(getContext()).l(this.oE).a(this.oF.getTouchCoords()).L(i).M(i2)) && com.kwad.components.ad.interstitial.d.b.u(this.mAdTemplate) && this.oa.mN != null) {
            c cVar = this.oa;
            cVar.a(false, -1, cVar.ed);
            this.oa.mN.dismiss();
            this.oa.ac();
        }
    }

    private void ej() {
        final com.kwad.components.ad.interstitial.h.d dVar = this.oa.ob;
        dVar.setAdTemplate(this.mAdTemplate);
        if (com.kwad.sdk.core.response.b.a.bj(this.mAdInfo)) {
            dVar.c(com.kwad.sdk.core.response.b.a.aY(this.mAdInfo).materialUrl, this.mAdTemplate);
            dVar.c(true, true);
            dVar.u(false);
        } else {
            dVar.u(true);
            String url = com.kwad.sdk.core.response.b.a.bA(this.mAdInfo).getUrl();
            if (!TextUtils.isEmpty(url)) {
                dVar.c(url, this.mAdTemplate);
                dVar.c(true, false);
            } else {
                dVar.c(false, false);
            }
            com.kwad.sdk.core.video.videoview.a aVar = this.oa.ed;
            this.ed = aVar;
            if (aVar.getParent() != null) {
                ((ViewGroup) this.ed.getParent()).removeView(this.ed);
            }
            if (com.kwad.sdk.core.response.b.a.bi(this.mAdInfo)) {
                dVar.a(com.kwad.sdk.core.response.b.a.aZ(this.mAdInfo).height / com.kwad.sdk.core.response.b.a.aZ(this.mAdInfo).width, this.ed);
            }
            dVar.v(this.oa.dG.isVideoSoundEnable());
            final int iM = com.kwad.sdk.core.response.b.a.M(this.mAdInfo);
            this.oa.a(new a.c() { // from class: com.kwad.components.ad.interstitial.f.d.6
                @Override // com.kwad.components.core.video.a.c
                public final void d(long j) {
                    int i = iM - ((int) (j / 1000));
                    if (i >= 0) {
                        dVar.C(String.valueOf(i));
                    } else {
                        dVar.fk();
                    }
                }

                @Override // com.kwad.components.core.video.a.c
                public final void onVideoPlayStart() {
                    dVar.u(true);
                }

                @Override // com.kwad.components.core.video.a.c
                public final void au() {
                    dVar.c(false, false);
                }

                @Override // com.kwad.components.core.video.a.c
                public final void av() {
                    d.this.ed.setVisibility(8);
                    if (d.this.oa.M(d.this.getContext())) {
                        return;
                    }
                    dVar.fm();
                }
            });
            dVar.a(this.mAdTemplate, this.mAdInfo);
            dVar.u(true);
            this.oa.oj.add(new c.d() { // from class: com.kwad.components.ad.interstitial.f.d.7
                @Override // com.kwad.components.ad.interstitial.f.c.d
                public final void eg() {
                    dVar.fn();
                    d.this.ed.setVisibility(0);
                }
            });
        }
        this.oa.a(getContext(), this.mAdInfo, this.mAdTemplate, dVar.getBlurBgView());
        String strP = com.kwad.sdk.core.response.b.a.P(this.mAdInfo);
        if (TextUtils.isEmpty(strP)) {
            strP = com.kwad.sdk.core.response.b.a.Y(this.mAdInfo);
        }
        KSImageLoader.loadImage(dVar.getTailFrameView(), strP, this.mAdTemplate);
        if (c(this.mAdInfo)) {
            this.nX.bh(true);
            ek();
        } else {
            this.nX.bh(false);
        }
    }

    private static float b(boolean z, boolean z2) {
        if (z && z2) {
            return oG;
        }
        return 0.749f;
    }

    private void ek() {
        int iMin = this.mAdInfo.adInsertScreenInfo.autoCloseTime;
        if (com.kwad.sdk.core.response.b.a.bi(this.mAdInfo)) {
            iMin = Math.min(iMin, com.kwad.sdk.core.response.b.a.M(this.mAdInfo));
            this.oa.ob.fk();
            this.oa.ob.fl();
        }
        this.nX.ai(iMin);
        com.kwad.sdk.core.adlog.c.b(this.mAdTemplate, 165, (JSONObject) null);
    }

    private static boolean c(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.autoCloseTime > 0 && !com.kwad.sdk.core.response.b.a.bT(adInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z) {
        if (!this.oa.oe && !z && !this.oa.oc && !this.oa.od && com.kwad.components.ad.interstitial.g.a.d(this.oa)) {
            this.oa.od = true;
            com.kwad.components.ad.interstitial.c.b.K(getContext());
            return;
        }
        this.oa.a(z, -1, this.ed);
        this.oa.mN.dismiss();
        com.kwad.sdk.core.video.videoview.a aVar = this.ed;
        if (aVar != null) {
            aVar.release();
        }
        this.oa.ac();
    }
}

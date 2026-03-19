package com.kwad.components.ad.c.c;

import android.animation.ObjectAnimator;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.ad.c.b.a;
import com.kwad.components.ad.c.g;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.request.j;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.u.p;
import com.kwad.components.core.widget.a;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.d.d;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.k;
import com.sigmob.sdk.base.mta.PointType;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends a {
    boolean eC;
    private com.kwad.components.ad.c.b.a er;
    private com.kwad.components.ad.c.b.a es;
    private FrameLayout et;
    private boolean eu;
    private boolean ev;
    private boolean ew;
    private long ex;
    private boolean ey;
    private long startTime;
    private Handler handler = new Handler();
    private boolean ez = true;
    private bh eA = new bh() { // from class: com.kwad.components.ad.c.c.c.1
        @Override // com.kwad.sdk.utils.bh
        public final void doTask() {
            if (c.this.ez) {
                c.this.ex = System.currentTimeMillis() - c.this.startTime;
                if (!c.this.ev || (c.this.ex >= e.YV() && com.kwad.sdk.core.response.b.a.dH(com.kwad.sdk.core.response.b.e.eP(c.this.eq.mAdTemplate)))) {
                    c.this.aB();
                    c.this.ew = true;
                    c.b(c.this, true);
                    if (c.this.ex >= e.YV()) {
                        c.this.startTime = System.currentTimeMillis();
                    }
                }
                if (com.kwad.sdk.core.response.b.a.dH(com.kwad.sdk.core.response.b.e.eP(c.this.eq.mAdTemplate))) {
                    c.this.handler.postDelayed(this, 1000L);
                }
            }
        }
    };
    private int eB = 0;

    static /* synthetic */ boolean b(c cVar, boolean z) {
        cVar.ev = true;
        return true;
    }

    static /* synthetic */ boolean d(c cVar, boolean z) {
        cVar.ey = true;
        return true;
    }

    @Override // com.kwad.components.ad.c.c.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.et = (FrameLayout) findViewById(R.id.ksad_banner_base_content);
        this.startTime = System.currentTimeMillis();
        az();
        a(this.et);
    }

    private void a(ViewGroup viewGroup) {
        if (e.Yx() || e.Yw() < 0.0f) {
            return;
        }
        com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
        viewGroup.addView(aVar);
        aVar.setViewCallback(new a.InterfaceC0500a() { // from class: com.kwad.components.ad.c.c.c.2
            @Override // com.kwad.components.core.widget.a.InterfaceC0500a
            public final void aD() {
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0500a
            public final void ae() {
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0500a
            public final void af() {
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0500a
            public final void onWindowFocusChanged(boolean z) {
                if (z) {
                    c.this.ez = true;
                    c.this.startTime = System.currentTimeMillis() - c.this.ex;
                    c.this.az();
                    return;
                }
                c.this.ez = false;
                c.this.aA();
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0500a
            public final void c(View view) {
                c.this.az();
            }
        });
        aVar.ww();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az() {
        this.handler.removeCallbacksAndMessages(this.eA);
        this.handler.post(this.eA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aA() {
        this.handler.removeCallbacksAndMessages(this.eA);
    }

    public final void aB() {
        if (this.ew || this.eq.dw.isEmpty()) {
            return;
        }
        try {
            com.kwad.components.ad.c.b.a aVar = new com.kwad.components.ad.c.b.a(getContext(), this.eq.dw.get(this.eB), new a.InterfaceC0404a() { // from class: com.kwad.components.ad.c.c.c.3
                @Override // com.kwad.components.ad.c.b.a.InterfaceC0404a
                public final void e(AdTemplate adTemplate) {
                    if (adTemplate.mPvReported) {
                        return;
                    }
                    com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                    a.C0576a c0576a = new a.C0576a();
                    c0576a.templateId = PointType.ANTI_SPAM;
                    c0576a.bvv = com.kwad.sdk.core.response.b.a.dH(com.kwad.sdk.core.response.b.e.eP(c.this.eq.mAdTemplate)) ? 1 : 2;
                    bVar.b(c0576a);
                    com.kwad.components.core.u.b.tq().a(adTemplate, null, bVar);
                    c.this.eq.aa();
                }

                @Override // com.kwad.components.ad.c.b.a.InterfaceC0404a
                public final void a(final int i, int i2, final AdTemplate adTemplate) {
                    com.kwad.components.core.e.d.a.a(new a.C0469a(c.this.getContext()).aC(adTemplate).av(true).b(new com.kwad.components.core.e.d.c(adTemplate)).as(false).aG(i2).aF(i).a(new a.b() { // from class: com.kwad.components.ad.c.c.c.3.1
                        @Override // com.kwad.components.core.e.d.a.b
                        public final void onAdClicked() {
                            com.kwad.sdk.core.adlog.c.a aVar2 = new com.kwad.sdk.core.adlog.c.a();
                            aVar2.QY = new a.C0576a();
                            aVar2.QY.templateId = PointType.ANTI_SPAM;
                            aVar2.oz = i;
                            com.kwad.sdk.core.adlog.c.a(adTemplate, aVar2, (JSONObject) null);
                        }
                    }));
                    c.this.eq.ab();
                }

                @Override // com.kwad.components.ad.c.b.a.InterfaceC0404a
                public final void f(AdTemplate adTemplate) {
                    com.kwad.sdk.core.adlog.c.h(adTemplate, (JSONObject) null);
                    c.this.eq.ac();
                    c.this.eq.dt.removeAllViews();
                    c.this.handler.removeCallbacksAndMessages(null);
                    c.this.onDestroy();
                }

                @Override // com.kwad.components.ad.c.b.a.InterfaceC0404a
                public final void ax() {
                    c.this.eq.c(0, "onMediaPlayError");
                }
            });
            aVar.a(this.eq.dv);
            this.eq.c(this.eq.dw.get(this.eB));
            if (!this.eu) {
                this.er = aVar;
                this.et.addView(aVar);
                this.er.as();
                this.handler.postDelayed(new bh() { // from class: com.kwad.components.ad.c.c.c.4
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        if (c.this.es != null) {
                            c.this.et.removeView(c.this.es);
                        }
                        c.this.ew = false;
                    }
                }, 500L);
                this.eu = true;
            } else {
                this.es = aVar;
                this.et.addView(aVar);
                this.es.as();
                this.handler.postDelayed(new bh() { // from class: com.kwad.components.ad.c.c.c.5
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        if (c.this.er != null) {
                            c.this.et.removeView(c.this.er);
                        }
                        c.this.ew = false;
                    }
                }, 500L);
                this.eu = false;
            }
            int i = this.eB + 1;
            this.eB = i;
            if (i == this.eq.dw.size()) {
                aC();
                this.eB = 0;
            }
            if (!this.eC) {
                this.eC = true;
                return;
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(aVar, "translationX", this.et.getWidth(), 0.0f);
            objectAnimatorOfFloat.setDuration(300L);
            objectAnimatorOfFloat.start();
        } catch (Exception e) {
            com.kwad.components.core.d.a.reportSdkCaughtException(e);
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    public final void aC() {
        SceneImpl sceneImplCovert = SceneImpl.covert(g.dH);
        sceneImplCovert.setBidResponse(null);
        sceneImplCovert.setBidResponseV2(null);
        d.q(sceneImplCovert);
        boolean zB = p.tH().b(sceneImplCovert, "loadBannerAd");
        sceneImplCovert.setAdStyle(5);
        KsAdLoadManager.P().a(new a.C0487a().e(new ImpInfo(sceneImplCovert)).aN(zB).a(new j() { // from class: com.kwad.components.ad.c.c.c.7
            @Override // com.kwad.components.core.request.j
            public final void al() {
            }
        }).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.c.c.c.6
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
            public final void onError(int i, String str) {
                c.this.handler.postDelayed(new bh() { // from class: com.kwad.components.ad.c.c.c.6.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        if (c.this.ey) {
                            c.this.ew = true;
                        } else {
                            c.this.aC();
                            c.d(c.this, true);
                        }
                    }
                }, e.YV());
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(AdResultData adResultData, boolean z) {
                c.this.eq.dw = adResultData.getAdTemplateList();
                if (c.this.eq.dw.isEmpty()) {
                    onError(com.kwad.sdk.core.network.e.bCy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.bCy.msg : adResultData.testErrorMsg);
                    k.aw("bannerAd_", "数据为空");
                }
            }
        }).sK());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.handler.removeCallbacksAndMessages(null);
    }
}

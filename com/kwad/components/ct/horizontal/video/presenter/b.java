package com.kwad.components.ct.horizontal.video.presenter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.kuaishou.socket.nano.SocketMessages;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.bd;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.ct.request.c;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KSApiWebView;
import com.kwad.sdk.utils.cb;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.horizontal.video.a.a implements cb.a {
    private View aJL;
    private ViewStub aJR;
    private int aJS;
    private CtAdTemplate aKX;
    private CtAdTemplate aOQ;
    private KSApiWebView aoT;
    private AnimatorSet apT;
    private cb dC;
    private com.kwad.components.core.webview.a gB;
    private com.kwad.sdk.core.webview.b gC;
    private ba gE;

    /* renamed from: if, reason: not valid java name */
    private AdBaseFrameLayout f19if;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    private int gD = -1;
    private int aOR = 0;
    private at.b gI = new at.b() { // from class: com.kwad.components.ct.horizontal.video.presenter.b.1
        @Override // com.kwad.components.core.webview.jshandler.at.b
        public final void a(at.a aVar) {
            b.this.gD = aVar.status;
            if (b.this.gD != 1) {
                b.this.br();
                return;
            }
            b.b(b.this);
            b.this.Iy();
            b.this.dC.sendEmptyMessageDelayed(666, com.kwad.sdk.core.response.b.b.cN(b.this.aOQ));
        }
    };
    private al.b gH = new al.b() { // from class: com.kwad.components.ct.horizontal.video.presenter.b.2
        @Override // com.kwad.components.core.webview.jshandler.al.b
        public final void a(al.a aVar) {
            b.this.GE();
        }
    };
    private KsAppDownloadListener rA = new com.kwad.sdk.core.download.a.c() { // from class: com.kwad.components.ct.horizontal.video.presenter.b.3
        @Override // com.kwad.sdk.core.download.a.c, com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadStarted() {
            b.this.dC.removeCallbacksAndMessages(null);
        }

        @Override // com.kwad.sdk.core.download.a.c, com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            b.this.GE();
        }
    };

    static /* synthetic */ int b(b bVar) {
        int i = bVar.aOR;
        bVar.aOR = i + 1;
        return i;
    }

    @Override // com.kwad.components.ct.horizontal.video.c
    public final void A(CtAdTemplate ctAdTemplate) {
        this.aKX = ctAdTemplate;
        this.dC.removeCallbacksAndMessages(null);
        this.aOR = 0;
        if (Iw()) {
            Ix();
        }
    }

    @Override // com.kwad.sdk.utils.cb.a
    public final void a(Message message) throws JSONException {
        if (message.what == 666) {
            GE();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("adBannerSizeType", com.kwad.sdk.core.response.b.b.cP(this.aOQ));
                jSONObject.put("adBannerType", com.kwad.sdk.core.response.b.b.cO(this.aOQ));
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
            com.kwad.sdk.core.adlog.c.a(this.aOQ, 14, (JSONObject) null, jSONObject.toString());
            com.kwad.sdk.core.d.c.d("HorizontalVideoBannerPresenter", "handleMsg MSG_BANNER_SHOW_DURATION hideBanner");
            return;
        }
        if (message.what == 888 && Iw()) {
            Ix();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aJR = (ViewStub) findViewById(R.id.ksad_home_bottom_banner_layout_vs);
        this.f19if = (AdBaseFrameLayout) findViewById(R.id.ksad_horizontal_root_container);
        this.aJS = com.kwad.sdk.c.a.a.a(getContext(), 100.0f);
        this.dC = new cb(this);
    }

    @Override // com.kwad.components.ct.horizontal.video.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        A(this.aOD.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.clear();
        }
        AnimatorSet animatorSet = this.apT;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.apT.removeAllListeners();
            this.apT = null;
        }
        this.dC.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Iw() {
        CtAdTemplate ctAdTemplate;
        return ((this.aOR >= com.kwad.components.ct.horizontal.a.b.Hk()) || (ctAdTemplate = this.aKX) == null || !com.kwad.components.ct.response.a.c.be(ctAdTemplate)) ? false : true;
    }

    private void Ix() {
        ImpInfo impInfo = new ImpInfo(this.aKX.mAdScene);
        impInfo.pageScene = r0.getPageScene();
        impInfo.subPageScene = 108L;
        com.kwad.components.ct.request.c.a(com.kwad.components.ct.response.a.c.j((PhotoInfo) com.kwad.components.ct.response.a.a.ay(this.aKX)), impInfo, new c.a() { // from class: com.kwad.components.ct.horizontal.video.presenter.b.4
            @Override // com.kwad.components.ct.request.c.a
            public final void zH() {
                com.kwad.sdk.core.d.c.d("HorizontalVideoBannerPresenter", "startRequestAd onError");
            }

            @Override // com.kwad.components.ct.request.c.a
            public final void E(CtAdTemplate ctAdTemplate) {
                if (ctAdTemplate != null && com.kwad.components.ct.response.a.a.eH(ctAdTemplate) && b.this.Iw()) {
                    b.this.D(ctAdTemplate);
                }
            }
        });
    }

    private void fy() {
        bh();
        this.aJL.setVisibility(4);
        bj();
        this.gD = -1;
        CtAdTemplate ctAdTemplate = this.aOQ;
        String strCM = ctAdTemplate != null ? com.kwad.sdk.core.response.b.b.cM(ctAdTemplate) : "";
        if (!TextUtils.isEmpty(strCM)) {
            this.aoT.loadUrl(strCM);
        } else {
            com.kwad.sdk.core.d.c.e("HorizontalVideoBannerPresenter", "initWebView fail, reason: url is empty ");
        }
    }

    private void bh() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.gC = bVar;
        bVar.setAdTemplate(this.aOQ);
        this.gC.mScreenOrientation = 0;
        this.gC.bLv = this.f19if;
        this.gC.Vu = this.f19if;
        this.gC.UO = this.aoT;
        this.gC.bLx = true;
    }

    private void bk() {
        com.kwad.components.core.webview.a aVar = this.gB;
        if (aVar != null) {
            aVar.destroy();
            this.gB = null;
        }
    }

    private void bj() {
        bk();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.aoT);
        this.gB = aVar;
        a(aVar);
        this.aoT.addJavascriptInterface(this.gB, "KwaiAd");
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new ag(this.gC));
        aVar.a(new aj(this.gC));
        aVar.a(new ae(this.gC));
        aVar.a(new at(this.gI, com.kwad.sdk.core.response.b.b.cM(this.aOQ)));
        aVar.a(new bd(this.gC, this.mApkDownloadHelper));
        aVar.a(new an(this.gC));
        aVar.b(new o(this.gC));
        aVar.b(new n(this.gC));
        aVar.a(new al(this.gH));
        aVar.a(new ac(this.gC, this.mApkDownloadHelper, null, (byte) 0));
        aVar.a(new z(this.gC, this.mApkDownloadHelper, (com.kwad.sdk.core.webview.d.a.a) null));
        aVar.a(new am(this.gC, null));
        ba baVar = new ba();
        this.gE = baVar;
        aVar.a(baVar);
        aVar.a(new com.kwad.components.core.webview.tachikoma.b.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br() {
        int i = this.gD;
        com.kwad.sdk.core.d.c.e("HorizontalVideoBannerPresenter", "show webCard fail, reason: " + (i == -1 ? "timeout" : i != 1 ? "h5error" : ILogConst.DRAW_ENTER_TYPE_OTHER));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(CtAdTemplate ctAdTemplate) {
        ViewStub viewStub;
        if (ctAdTemplate == null || !com.kwad.components.ct.response.a.a.eH(ctAdTemplate)) {
            return;
        }
        if (this.aJL == null && (viewStub = this.aJR) != null) {
            this.aJL = viewStub.inflate();
        }
        View view = this.aJL;
        if (view == null) {
            return;
        }
        KSApiWebView kSApiWebView = (KSApiWebView) view.findViewById(R.id.ksad_home_bottom_ad_banner_web);
        this.aoT = kSApiWebView;
        kSApiWebView.setBackgroundColor(0);
        this.aOQ = ctAdTemplate;
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.aOQ);
        this.mApkDownloadHelper = cVar;
        cVar.b(this.rA);
        fy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iy() {
        bQ(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GE() {
        bQ(false);
        this.dC.removeCallbacksAndMessages(null);
        this.dC.sendEmptyMessageDelayed(SocketMessages.PayloadType.SC_LIVE_WISHROOM_BULLET_COMMENT_PUSH_INFOS, com.kwad.components.ct.horizontal.a.b.Hj() * 1000);
    }

    private void bQ(final boolean z) {
        if (this.aJL == null) {
            return;
        }
        AnimatorSet animatorSet = this.apT;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.apT.removeAllListeners();
            this.apT.cancel();
        }
        this.apT = new AnimatorSet();
        com.kwad.sdk.core.d.c.d("HorizontalVideoBannerPresenter", "bottomViewAnimate + isShow : " + z);
        View view = this.aJL;
        String name = View.TRANSLATION_Y.getName();
        float[] fArr = new float[1];
        fArr[0] = z ? 0.0f : this.aJS;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, name, fArr);
        objectAnimatorOfFloat.setDuration(z ? 300L : 260L);
        this.apT.playTogether(objectAnimatorOfFloat);
        this.apT.removeAllListeners();
        this.apT.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ct.horizontal.video.presenter.b.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (!z) {
                    b.this.aJL.setVisibility(4);
                    if (b.this.gE != null) {
                        b.this.gE.vg();
                        return;
                    }
                    return;
                }
                if (b.this.gE != null) {
                    b.this.gE.ve();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                b.this.aJL.setVisibility(z ? 4 : 0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (z) {
                    b.this.aJL.setVisibility(0);
                    if (b.this.gE != null) {
                        b.this.gE.vd();
                        return;
                    }
                    return;
                }
                if (b.this.gE != null) {
                    b.this.gE.vf();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
            public final void onAnimationPause(Animator animator) {
                super.onAnimationPause(animator);
                b.this.aJL.setVisibility(z ? 4 : 0);
            }
        });
        this.apT.start();
    }
}

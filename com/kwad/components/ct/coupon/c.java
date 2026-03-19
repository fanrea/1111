package com.kwad.components.ct.coupon;

import android.graphics.Rect;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.ct.coupon.b;
import com.kwad.components.ct.coupon.bridge.WebCardGetCouponStatusHandler;
import com.kwad.components.ct.coupon.entry.CouponEntryContainer;
import com.kwad.components.ct.coupon.entry.d;
import com.kwad.components.ct.coupon.model.CouponStatus;
import com.kwad.components.ct.coupon.model.CouponStatusInfo;
import com.kwad.components.ct.coupon.request.CouponStatusResponse;
import com.kwad.components.ct.coupon.request.c;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.components.ct.home.e;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.bq;
import java.util.ArrayList;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends e {
    private CouponEntryContainer amH;
    private com.kwad.components.ct.coupon.entry.c amI;
    private com.kwad.components.ct.coupon.a.a amJ;
    private SlidePlayViewPager amK;
    private com.kwad.components.core.widget.a.b amL;
    private boolean amM;
    private b amO;
    private WebView amQ;
    private FrameLayout amR;
    private volatile boolean amN = false;
    private Rect amP = null;
    private final com.kwad.components.ct.detail.listener.a amS = new com.kwad.components.ct.detail.listener.b() { // from class: com.kwad.components.ct.coupon.c.1
        @Override // com.kwad.components.ct.detail.listener.b, com.kwad.components.ct.detail.listener.a
        public final void a(int i, CtAdTemplate ctAdTemplate) {
            c.this.amN = true;
            c.this.xC();
            c.this.amH.xQ();
            c.this.bu(String.valueOf(com.kwad.components.ct.response.a.a.bg(ctAdTemplate)));
        }

        @Override // com.kwad.components.ct.detail.listener.b, com.kwad.components.ct.detail.listener.a
        public final void b(int i, CtAdTemplate ctAdTemplate) {
            c.this.amN = false;
            c.this.amH.xR();
        }

        @Override // com.kwad.components.ct.detail.listener.b, com.kwad.components.ct.detail.listener.a
        public final void c(int i, CtAdTemplate ctAdTemplate) {
            c.this.amH.xS();
            c.this.amN = true;
        }

        @Override // com.kwad.components.ct.detail.listener.b, com.kwad.components.ct.detail.listener.a
        public final void a(int i, CtAdTemplate ctAdTemplate, int i2, int i3) {
            c.this.amN = false;
        }
    };
    private com.kwad.sdk.core.j.c gZ = new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.ct.coupon.c.3
        @Override // com.kwad.sdk.core.j.c
        public final void bz() {
        }

        @Override // com.kwad.sdk.core.j.c
        public final void by() {
            com.kwad.sdk.core.d.c.d("CouponPresenter", "onPageVisible");
            if (b.xo().xu()) {
                c.this.amH.setVisibility(8);
                return;
            }
            if (c.this.amM) {
                c.this.xy();
                if (b.xo().xv()) {
                    c.this.amH.xQ();
                    return;
                }
                return;
            }
            c.b(c.this, true);
            new com.kwad.components.ct.coupon.request.c().a(c.this.xF(), new c.a() { // from class: com.kwad.components.ct.coupon.c.3.1
                @Override // com.kwad.components.ct.coupon.request.c.a
                public final void xK() {
                    c.this.amH.setVisibility(8);
                }

                @Override // com.kwad.components.ct.coupon.request.c.a
                public final void by(int i) {
                    com.kwad.sdk.core.d.c.d("CouponPresenter", "RequestCouponStatusManager onError code=" + i);
                }

                @Override // com.kwad.components.ct.coupon.request.c.a
                public final void a(CouponStatusResponse couponStatusResponse) {
                    com.kwad.sdk.core.d.c.d("CouponPresenter", "RequestCouponStatusManager onLoad");
                    if (b.xo().xp().isEnable()) {
                        b.xo().b(couponStatusResponse.couponStatusInfo);
                        c.this.xz();
                        c.this.amI.a(c.this.amH, com.kwad.components.ct.coupon.entry.c.xU(), com.kwad.components.ct.coupon.entry.c.xV());
                        c.this.amH.setVisibility(0);
                        com.kwad.components.ct.e.b.JK().j(c.this.aGP.mSceneImpl);
                    }
                }
            });
        }
    };
    private b.a amD = new b.a() { // from class: com.kwad.components.ct.coupon.c.6
        @Override // com.kwad.components.ct.coupon.b.a
        public final void xw() {
            c.this.xy();
        }
    };

    static /* synthetic */ com.kwad.components.ct.coupon.a.a a(c cVar, com.kwad.components.ct.coupon.a.a aVar) {
        cVar.amJ = null;
        return null;
    }

    static /* synthetic */ boolean b(c cVar, boolean z) {
        cVar.amM = true;
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        com.kwad.sdk.core.d.c.d("CouponPresenter", "onCreate");
        this.amK = (SlidePlayViewPager) findViewById(R.id.ksad_slide_play_view_pager);
        this.amO = b.xo();
        this.amQ = (WebView) findViewById(R.id.ksad_home_open_coupon_web_view);
        this.amR = (FrameLayout) findViewById(R.id.ksad_home_open_coupon_webview_container);
        CouponEntryContainer couponEntryContainer = (CouponEntryContainer) findViewById(R.id.ksad_coupon_entry_container);
        this.amH = couponEntryContainer;
        couponEntryContainer.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.coupon.c.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.this.xE();
            }
        });
        this.amH.setCloseListener(new com.kwad.components.ct.coupon.entry.b() { // from class: com.kwad.components.ct.coupon.c.5
            @Override // com.kwad.components.ct.coupon.entry.b
            public final void onClosed() {
                b.xo().bm(true);
                com.kwad.components.ct.e.b.JK().g(c.this.aGP.mSceneImpl, c.this.xJ());
            }
        });
        this.amI = new com.kwad.components.ct.coupon.entry.c();
    }

    @Override // com.kwad.components.ct.home.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.amO.a(this.amD);
        this.amP = new Rect(0, 0, com.kwad.sdk.c.a.a.a(getActivity(), 100.0f), com.kwad.sdk.c.a.a.a(getActivity(), 520.0f));
        if (this.aGP.aol != null) {
            this.amL = this.aGP.aol.aFs;
        }
        com.kwad.components.core.widget.a.b bVar = this.amL;
        if (bVar != null) {
            bVar.a(this.gZ);
        }
        com.kwad.components.ct.detail.listener.c.zh().a(this.amS);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.amO.a((b.a) null);
        com.kwad.components.core.widget.a.b bVar = this.amL;
        if (bVar != null) {
            bVar.b(this.gZ);
        }
        com.kwad.components.ct.coupon.a.a aVar = this.amJ;
        if (aVar != null) {
            aVar.release();
            this.amJ = null;
        }
        com.kwad.components.ct.detail.listener.c.zh().b(this.amS);
    }

    public final void xx() {
        com.kwad.components.ct.coupon.a.a aVar = this.amJ;
        if (aVar != null && aVar.yc()) {
            this.amJ.yb();
            return;
        }
        com.kwad.components.ct.coupon.a.a aVar2 = this.amJ;
        if (aVar2 != null) {
            aVar2.release();
            this.amJ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xy() {
        this.amH.c(this.amO.xp());
        if (d.contains(xA())) {
            this.amH.xQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xz() {
        xy();
        if (b.xo().xq()) {
            com.kwad.sdk.core.d.c.d("CouponPresenter", "handleCouponStatusResponse needShowFirstCoupon");
            b.xo().bl(true);
            a(b.xo().xp());
        }
        xC();
        if (this.amN) {
            this.amH.xQ();
            com.kwad.sdk.core.d.c.d("CouponPresenter", "handleCouponStatusResponse mVideoPlaying");
            bu(xA());
        }
    }

    private String xA() {
        CtAdTemplate ctAdTemplateXB = xB();
        return ctAdTemplateXB != null ? al.md5(String.valueOf(com.kwad.components.ct.response.a.a.bg(ctAdTemplateXB))) : "";
    }

    private CtAdTemplate xB() {
        int currentItem = this.amK.getCurrentItem();
        com.kwad.components.ct.detail.viewpager.b adapter = this.amK.getAdapter();
        if (adapter != null) {
            return adapter.bU(adapter.bO(currentItem));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xC() {
        if (getRootView() != null) {
            this.amI.a(this.amP);
        }
        this.amI.F(this.amH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu(final String str) {
        if (!this.amO.isAccumulating() || d.contains(str)) {
            return;
        }
        com.kwad.sdk.core.d.c.d("CouponPresenter", "startCouponEntryProgress isAccumulating photoId = " + str);
        this.amH.setProgressSpeed(b.xo().getCouponVideoSeconds() * 1000);
        this.amH.a(new d.a() { // from class: com.kwad.components.ct.coupon.c.7
            @Override // com.kwad.components.ct.coupon.entry.d.a
            public final void onFinish() {
                com.kwad.sdk.core.d.c.d("CouponPresenter", "startCouponEntryProgress onFinish FFF photoId = " + str);
                d.bv(str);
                c.this.amO.xs();
                c.this.xy();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xD() {
        if (this.amN) {
            CouponEntryContainer couponEntryContainer = this.amH;
            if (couponEntryContainer == null || !couponEntryContainer.xT()) {
                bu(xA());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xE() {
        CouponStatus couponStatusXp = this.amO.xp();
        com.kwad.components.ct.e.b.JK().f(this.aGP.mSceneImpl, xJ());
        if (couponStatusXp.isWaitingOpen()) {
            com.kwad.sdk.core.d.c.d("CouponPresenter", "抽奖红包界面");
            a(b.xo().xp());
            return;
        }
        com.kwad.sdk.core.d.c.d("CouponPresenter", "红包列表界面");
        com.kwad.components.core.webview.a.b bVar = new com.kwad.components.core.webview.a.b();
        bVar.url = xI();
        WebCardGetCouponStatusHandler.CouponStatusParams couponStatusParams = new WebCardGetCouponStatusHandler.CouponStatusParams();
        couponStatusParams.couponStatus = b.xo().xp();
        JSONArray jSONArray = new JSONArray();
        aa.a(jSONArray, xG().toJson());
        couponStatusParams.impInfo = jSONArray;
        com.kwad.sdk.core.d.c.d("CouponPresenter", "couponStatusParams =" + couponStatusParams.toJson().toString());
        bVar.params = couponStatusParams.toJson().toString();
        com.kwad.sdk.core.d.c.d("CouponPresenter", " openNewPageData.params =" + bVar.params);
        a.a(getActivity(), bVar);
        com.kwad.sdk.core.d.c.d("CouponPresenter", "ActiveWebViewActivityImpl.launch(getActivity(), openNewPageData);");
    }

    private void a(CouponStatus couponStatus) {
        if (this.amJ == null) {
            b(couponStatus);
        } else {
            xx();
        }
    }

    private void b(CouponStatus couponStatus) {
        String strXH = xH();
        if (bq.isNullString(strXH)) {
            return;
        }
        com.kwad.components.ct.coupon.a.a aVar = new com.kwad.components.ct.coupon.a.a();
        this.amJ = aVar;
        aVar.a(getActivity(), this.amR, this.amQ, strXH, xG(), couponStatus, new com.kwad.components.ct.coupon.a.b() { // from class: com.kwad.components.ct.coupon.c.8
            @Override // com.kwad.components.ct.coupon.a.b
            public final void onClose() {
                if (c.this.amJ != null) {
                    c.this.amJ.release();
                    c.a(c.this, (com.kwad.components.ct.coupon.a.a) null);
                }
                c.this.xy();
            }
        }, new com.kwad.components.ct.coupon.a.c() { // from class: com.kwad.components.ct.coupon.c.9
            @Override // com.kwad.components.ct.coupon.a.c
            public final void xL() {
                c.this.xx();
            }
        }, new com.kwad.components.ct.coupon.bridge.a.a() { // from class: com.kwad.components.ct.coupon.c.10
            @Override // com.kwad.components.ct.coupon.bridge.a.a
            public final void a(CouponStatusInfo couponStatusInfo) {
                if (couponStatusInfo != null) {
                    b.xo().b(couponStatusInfo);
                    b.xo().xr();
                    c.this.xy();
                    c.this.amH.xQ();
                    c.this.xD();
                }
            }
        }, new ar.a() { // from class: com.kwad.components.ct.coupon.c.2
            @Override // com.kwad.components.core.webview.jshandler.ar.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                com.kwad.sdk.core.d.c.d("CouponPresenter", "onOpenNewPage ");
                a.a(c.this.aGP.aGE.getContext(), bVar);
                c.this.xD();
            }
        });
        this.amJ.pj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.kwad.components.ct.coupon.request.b xF() {
        com.kwad.components.ct.coupon.request.b bVar = new com.kwad.components.ct.coupon.request.b();
        bVar.anZ = new ArrayList(1);
        bVar.anZ.add(xG());
        bVar.activityInfo = b.xo().xt();
        return bVar;
    }

    private ImpInfo xG() {
        ImpInfo impInfo = new ImpInfo(this.aGP.mSceneImpl);
        impInfo.pageScene = this.aGP.mSceneImpl.getPageScene();
        impInfo.subPageScene = 105L;
        return impInfo;
    }

    private static String xH() {
        String str = com.kwad.sdk.core.config.e.Xw().h5Url;
        return str == null ? "" : str;
    }

    private static String xI() {
        String str = com.kwad.sdk.core.config.e.Xx().h5Url;
        return str == null ? "" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int xJ() {
        CouponStatus couponStatusXp = this.amO.xp();
        int statusCode = couponStatusXp.getStatusCode();
        if (statusCode == 3) {
            return 5;
        }
        if (statusCode == 2) {
            return 4;
        }
        if (statusCode == 1) {
            return 3;
        }
        return couponStatusXp.isWaitingOpen() ? 1 : 2;
    }
}

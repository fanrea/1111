package com.kwad.components.ct.coupon.a;

import android.app.Activity;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.bg;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.ct.coupon.bridge.WebCardGetCouponStatusHandler;
import com.kwad.components.ct.coupon.bridge.e;
import com.kwad.components.ct.coupon.bridge.f;
import com.kwad.components.ct.coupon.model.CouponStatus;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.utils.cc;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private WebView UO;
    private ar.a afN;
    private CouponStatus amC;
    private ImpInfo amX;
    private String aof;
    private b aog;
    private c aoh;
    private com.kwad.components.ct.coupon.bridge.a.a aoi;
    private com.kwad.components.core.webview.a gB;
    private com.kwad.sdk.core.webview.b gC;
    private ba gE;
    private FrameLayout gO;
    private Activity mActivity;
    private int Vt = -1;
    private am.b gG = new am.b() { // from class: com.kwad.components.ct.coupon.a.a.1
        @Override // com.kwad.components.core.webview.jshandler.am.b
        public final void a(am.a aVar) {
            com.kwad.sdk.core.d.c.d("OpenCouponWebCard", "onAdFrameValid=" + aVar);
            if (a.this.UO != null) {
                a.this.UO.setTranslationY(aVar.height + aVar.bottomMargin);
            }
        }
    };
    private at.b gI = new at.b() { // from class: com.kwad.components.ct.coupon.a.a.2
        @Override // com.kwad.components.core.webview.jshandler.at.b
        public final void a(at.a aVar) {
            a.this.Vt = aVar.status;
            if (a.this.aoh != null) {
                a.this.aoh.xL();
            }
        }
    };
    private com.kwad.sdk.core.webview.d.a.b mWebCardCloseListener = new com.kwad.sdk.core.webview.d.a.b() { // from class: com.kwad.components.ct.coupon.a.a.3
        @Override // com.kwad.sdk.core.webview.d.a.b
        public final void b(WebCloseStatus webCloseStatus) {
            com.kwad.sdk.core.d.c.d("OpenCouponWebCard", "handleWebCardHide");
            a.this.yd();
        }
    };
    private volatile boolean mIsReleased = false;

    public final void a(Activity activity, FrameLayout frameLayout, WebView webView, String str, ImpInfo impInfo, CouponStatus couponStatus, b bVar, c cVar, com.kwad.components.ct.coupon.bridge.a.a aVar, ar.a aVar2) {
        this.mActivity = activity;
        this.gO = frameLayout;
        this.UO = webView;
        this.amC = couponStatus;
        this.aof = str;
        this.amX = impInfo;
        this.aog = bVar;
        this.aoh = cVar;
        this.aoi = aVar;
        this.afN = aVar2;
        gx();
        bh();
    }

    private void gx() {
        this.gO.setVisibility(8);
        this.UO.setBackgroundColor(0);
        this.UO.getBackground().setAlpha(0);
    }

    private void bh() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.gC = bVar;
        bVar.mScreenOrientation = 0;
        this.gC.Vu = this.gO;
        this.gC.UO = this.UO;
    }

    private void bj() {
        bk();
        cc.b(this.UO);
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.UO);
        this.gB = aVar;
        a(aVar);
        this.UO.addJavascriptInterface(this.gB, "KwaiAd");
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        com.kwad.sdk.core.d.c.d("OpenCouponWebCard", "registerWebCardHandler");
        aVar.a(new aj(this.gC));
        aVar.a(new ae(this.gC));
        aVar.a(new am(this.gC, this.gG));
        aVar.a(new at(this.gI, this.aof));
        ba baVar = new ba();
        this.gE = baVar;
        aVar.a(baVar);
        aVar.a(new aa(this.mWebCardCloseListener));
        aVar.a(new an(this.gC));
        aVar.b(new o(this.gC));
        aVar.b(new n(this.gC));
        aVar.a(new bg(this.gC));
        aVar.a(new WebCardGetCouponStatusHandler(this.amC, this.amX));
        aVar.a(new ar(this.afN));
        aVar.a(new e(this.mActivity, this.amX.adScene));
        aVar.a(new f(this.aoi));
    }

    private void bk() {
        com.kwad.components.core.webview.a aVar = this.gB;
        if (aVar != null) {
            aVar.destroy();
            this.gB = null;
        }
        WebView webView = this.UO;
        if (webView != null) {
            webView.clearHistory();
            this.UO.clearCache(false);
        }
    }

    public final void pj() {
        bj();
        this.UO.setBackgroundColor(0);
        this.UO.getBackground().setAlpha(0);
        this.Vt = -1;
        this.UO.loadUrl(this.aof);
    }

    public final boolean yb() {
        if (this.Vt == 1) {
            bm();
            return true;
        }
        br();
        return false;
    }

    public final boolean yc() {
        return this.Vt == 1;
    }

    public final void release() {
        if (this.mIsReleased) {
            return;
        }
        this.mIsReleased = true;
        this.Vt = -1;
        bk();
    }

    private void br() {
        int i = this.Vt;
        com.kwad.sdk.core.d.c.w("OpenCouponWebCard", "show webCard fail, reason: " + (i == -1 ? "timeout" : i != 1 ? "h5error" : ILogConst.DRAW_ENTER_TYPE_OTHER));
    }

    private void bm() {
        this.gO.setVisibility(0);
        ba baVar = this.gE;
        if (baVar != null) {
            baVar.ve();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yd() {
        this.gO.setVisibility(8);
        b bVar = this.aog;
        if (bVar != null) {
            bVar.onClose();
        }
    }
}

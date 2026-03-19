package com.kwad.components.ad.l;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.webview.b;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.ap;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.bh;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.p.m;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.utils.ca;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b {
    private bh DH;
    protected View Of;
    private String Oh;
    private a Oi;
    private InterfaceC0426b Oj;
    protected com.kwad.sdk.core.webview.b gC;
    protected ba gE;
    private com.kwad.sdk.core.webview.d.a.a gF;
    private FrameLayout gO;
    protected KsAdWebView gz;

    /* renamed from: if, reason: not valid java name */
    private AdBaseFrameLayout f5if;
    private com.kwad.components.core.webview.b kG;
    protected AdTemplate mAdTemplate;
    private JSONObject mReportExtData;
    private List<AdTemplate> Od = new ArrayList();
    private List<c> Oe = new ArrayList();
    private int gD = -1;
    protected boolean Og = false;
    private com.kwad.components.core.webview.c kH = new com.kwad.components.core.webview.c() { // from class: com.kwad.components.ad.l.b.1
        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
            b.this.gC = bVar;
            b.this.b(bVar);
            b.this.a(aVar);
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(WebCloseStatus webCloseStatus) {
            bx.runOnUiThread(new com.kwad.sdk.utils.bh() { // from class: com.kwad.components.ad.l.b.1.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    if (b.this.Oi != null) {
                        b.this.Oi.jP();
                    }
                }
            });
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(at.a aVar) {
            b.this.gD = aVar.status;
            com.kwad.sdk.core.d.c.i("PlayEndWebCard", b.this.getName() + "updatePageStatus mPageState: " + aVar + "，targetUrl: " + b.this.Oh);
            if (aVar.isSuccess() && b.this.Oj != null) {
                b.this.Oj.iY();
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(ba baVar) {
            b.this.gE = baVar;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (b.this.gF != null) {
                b.this.gF.a(aVar);
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void h(int i, String str) {
            b.this.Og = false;
        }

        @Override // com.kwad.components.core.webview.c
        public final void onPageFinished() {
            b.this.Og = true;
            b.this.gC();
        }
    };
    private al.b gH = new al.b() { // from class: com.kwad.components.ad.l.b.2
        @Override // com.kwad.components.core.webview.jshandler.al.b
        public final void a(al.a aVar) {
            b.this.nQ();
        }
    };

    public interface a {
        void jP();
    }

    /* renamed from: com.kwad.components.ad.l.b$b, reason: collision with other inner class name */
    public interface InterfaceC0426b {
        void iY();
    }

    protected void gA() {
    }

    protected void gB() {
    }

    protected void gC() {
    }

    protected String getName() {
        return "PlayEndWebCard";
    }

    protected boolean gy() {
        return true;
    }

    public b() {
    }

    public b(JSONObject jSONObject, String str) {
        this.mReportExtData = jSONObject;
        this.Oh = str;
    }

    public final void a(com.kwad.sdk.core.webview.d.a.a aVar) {
        this.gF = aVar;
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, c cVar) {
        a(frameLayout, adBaseFrameLayout, adTemplate, cVar, 0);
    }

    @Deprecated
    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, c cVar, int i) {
        this.Oe.add(cVar);
        this.f5if = adBaseFrameLayout;
        this.gO = frameLayout;
        this.mAdTemplate = adTemplate;
        gx();
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, List<AdTemplate> list, List<c> list2) {
        this.Oe = list2;
        this.f5if = adBaseFrameLayout;
        this.gO = frameLayout;
        if (list != null && list.size() > 0) {
            this.Od = list;
            this.mAdTemplate = list.get(0);
        }
        gx();
    }

    private static int getLayoutId() {
        return R.layout.ksad_ad_web_card_layout;
    }

    protected void gx() {
        this.gO.removeAllViews();
        this.gO.setVisibility(4);
        this.Of = m.inflate(this.gO.getContext(), getLayoutId(), this.gO);
        KsAdWebView ksAdWebView = (KsAdWebView) this.gO.findViewById(R.id.ksad_web_card_webView);
        this.gz = ksAdWebView;
        if (ksAdWebView != null) {
            boolean z = false;
            ksAdWebView.setBackgroundColor(0);
            this.gz.getBackground().setAlpha(0);
            this.kG = new com.kwad.components.core.webview.b();
            b.a aVarF = new b.a().aN(this.mAdTemplate).aX(L(this.mAdTemplate)).d(this.gz).e(this.mReportExtData).k(this.f5if).f(this.Oe.get(0));
            if (this.Oe.size() > 1 && this.Od.size() > 1) {
                z = true;
            }
            this.kG.a(aVarF.aZ(z).a(this.kH));
            this.gz.loadUrl(L(this.mAdTemplate));
            gA();
        }
    }

    public final void ai(boolean z) {
        this.DH.ai(true);
    }

    protected void b(com.kwad.sdk.core.webview.b bVar) {
        bVar.setAdTemplate(this.mAdTemplate);
    }

    public final void a(InterfaceC0426b interfaceC0426b) {
        this.Oj = interfaceC0426b;
        this.gO.setVisibility(4);
        this.gD = -1;
        String strL = L(this.mAdTemplate);
        com.kwad.sdk.core.d.c.d("PlayEndWebCard", "startPreloadWebView url : " + strL);
        if (TextUtils.isEmpty(strL) || this.gz == null) {
            return;
        }
        gB();
        this.gz.loadUrl(strL);
    }

    public final long getLoadTime() {
        KsAdWebView ksAdWebView = this.gz;
        if (ksAdWebView != null) {
            return ksAdWebView.getLoadTime();
        }
        return -1L;
    }

    public final void a(a aVar) {
        this.Oi = aVar;
    }

    protected String L(AdTemplate adTemplate) {
        String str = this.Oh;
        return str == null ? com.kwad.sdk.core.response.b.b.dh(this.mAdTemplate) : str;
    }

    protected void a(com.kwad.components.core.webview.a aVar) {
        if (this.Oe.size() > 1 && this.Od.size() > 1) {
            aVar.a(new ac(this.gC, this.Oe.get(0), this.gF, (byte) 0));
            aVar.a(new z(this.gC, this.Oe, this.gF));
            aVar.a(new ap(this.Od, this.Oe));
        }
        bh bhVar = new bh();
        this.DH = bhVar;
        aVar.a(bhVar);
        aVar.a(new al(this.gH));
    }

    protected boolean cM() {
        return this.gD == 1;
    }

    public final boolean bb() {
        if (cM()) {
            ba baVar = this.gE;
            if (baVar != null) {
                baVar.vd();
            }
            FrameLayout frameLayout = this.gO;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            if (this.gE == null || !gy()) {
                return true;
            }
            this.gE.ve();
            return true;
        }
        FrameLayout frameLayout2 = this.gO;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(4);
        }
        br();
        return false;
    }

    public final void nQ() {
        if (ca.a(this.gz, 50, false)) {
            ba baVar = this.gE;
            if (baVar != null) {
                baVar.vf();
            }
            this.gO.setVisibility(4);
            ba baVar2 = this.gE;
            if (baVar2 != null) {
                baVar2.vg();
            }
        }
    }

    private void br() {
        int i = this.gD;
        com.kwad.sdk.core.d.c.w("PlayEndWebCard", "show webCard fail, reason: " + (i == -1 ? "timeout" : i != 1 ? "h5error" : ILogConst.DRAW_ENTER_TYPE_OTHER));
    }

    public final void release() {
        this.Oj = null;
    }

    public final void nC() {
        com.kwad.components.core.webview.b bVar = this.kG;
        if (bVar != null) {
            bVar.kD();
        }
    }
}

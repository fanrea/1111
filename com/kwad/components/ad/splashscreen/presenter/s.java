package com.kwad.components.ad.splashscreen.presenter;

import android.content.Context;
import android.os.SystemClock;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.bc;
import com.kwad.components.core.webview.jshandler.bd;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.R;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bx;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class s extends e implements com.kwad.components.ad.splashscreen.e, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.j.c {
    private boolean JA;
    private long JC;
    private ba JD;
    private ViewGroup JF;
    private com.kwad.components.ad.splashscreen.e.b Jz;
    private com.kwad.components.core.webview.a gB;
    private com.kwad.sdk.core.webview.b gC;
    private KsAdWebView gz;
    private com.kwad.sdk.core.g.d iQ;
    private Vibrator iS;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private long mStartTime;
    private boolean JB = false;
    private boolean JE = false;
    private final Runnable JG = new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.s.1
        @Override // java.lang.Runnable
        public final void run() {
            s.a(s.this, true);
            com.kwad.components.ad.splashscreen.monitor.c.a(s.this.mAdTemplate, com.kwad.sdk.core.response.b.b.cL(s.this.mAdTemplate), SystemClock.elapsedRealtime() - s.this.JC, 1, "");
            s.this.mE();
        }
    };

    @Override // com.kwad.components.ad.splashscreen.g
    public final void ak(int i) {
    }

    static /* synthetic */ boolean a(s sVar, boolean z) {
        sVar.JE = true;
        return true;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.mStartTime = SystemClock.elapsedRealtime();
        this.HX.Hk.a(this);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_splash_webview_container);
        this.JF = viewGroup;
        viewGroup.setVisibility(0);
        try {
            this.gz = new KsAdWebView(getContext());
            this.gz.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.JF.addView(this.gz);
        } catch (Throwable unused) {
        }
        AdTemplate adTemplate = this.HX.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        this.JA = false;
        this.JB = false;
        String strCL = com.kwad.sdk.core.response.b.b.cL(this.mAdTemplate);
        if (this.gz != null && !TextUtils.isEmpty(strCL) && !this.HX.Hp) {
            this.JC = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.c.as(this.mAdTemplate);
            a(this.gz, strCL);
            bx.a(this.JG, null, com.kwad.sdk.core.response.b.b.ep(this.mAdInfo));
        } else {
            mE();
        }
        this.HX.a(this);
    }

    private void bh() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.gC = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        this.gC.mScreenOrientation = 0;
        this.gC.bLv = this.HX.mRootContainer;
        this.gC.Vu = this.HX.mRootContainer;
        this.gC.UO = this.gz;
        this.gC.mReportExtData = null;
        this.gC.bLx = false;
        this.gC.bLy = com.kwad.components.ad.splashscreen.h.n(this.mAdInfo);
    }

    private void a(KsAdWebView ksAdWebView, final String str) {
        ksAdWebView.setBackgroundColor(0);
        ksAdWebView.setVisibility(0);
        bh();
        a((WebView) ksAdWebView, str);
        ksAdWebView.setClientConfig(ksAdWebView.getClientConfig().fj(this.HX.mAdTemplate).b(new com.kwad.sdk.core.webview.e() { // from class: com.kwad.components.ad.splashscreen.presenter.s.3
            @Override // com.kwad.sdk.core.webview.e, com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i, String str2, String str3) {
                super.onReceivedHttpError(i, str2, str3);
                bx.d(s.this.JG);
                s.this.mE();
                com.kwad.components.ad.splashscreen.monitor.c.a(s.this.mAdTemplate, str, SystemClock.elapsedRealtime() - s.this.JC, 2, str2);
            }

            @Override // com.kwad.sdk.core.webview.e, com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                super.onPageFinished();
                com.kwad.components.ad.splashscreen.monitor.c.b(s.this.mAdTemplate, str, SystemClock.elapsedRealtime() - s.this.JC);
            }
        }));
        com.kwad.components.ad.splashscreen.monitor.c.d(str, this.mAdTemplate);
        try {
            ksAdWebView.loadUrl(str);
        } catch (Throwable unused) {
            mE();
        }
    }

    private void a(WebView webView, String str) {
        bk();
        webView.getSettings().setAllowFileAccess(true);
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(webView);
        this.gB = aVar;
        a(aVar, str);
        webView.addJavascriptInterface(this.gB, "KwaiAd");
    }

    private void bk() {
        com.kwad.components.core.webview.a aVar = this.gB;
        if (aVar != null) {
            aVar.destroy();
            this.gB = null;
        }
    }

    private void a(com.kwad.components.core.webview.a aVar, final String str) {
        aVar.a(new bd(this.gC, this.HX.mApkDownloadHelper));
        aVar.a(mH());
        aVar.a(mG());
        aVar.a(new ag(this.gC));
        aVar.a(new com.kwad.components.core.webview.tachikoma.b.f());
        aVar.a(new at(new at.b() { // from class: com.kwad.components.ad.splashscreen.presenter.s.4
            @Override // com.kwad.components.core.webview.jshandler.at.b
            public final void a(at.a aVar2) {
                com.kwad.sdk.core.d.c.d("SplashWebViewPresenter", "updatePageStatus: " + aVar2);
                bx.d(s.this.JG);
                if (aVar2.status == 1) {
                    s.this.HX.HA = SystemClock.elapsedRealtime() - s.this.mStartTime;
                    if (!s.this.JE) {
                        if (s.this.JD != null) {
                            s.this.JD.vd();
                            s.this.JD.ve();
                        }
                    } else {
                        s.this.HX.isWebTimeout = true;
                    }
                    if (com.kwad.sdk.core.response.b.b.en(s.this.mAdInfo)) {
                        s.this.mD();
                        return;
                    }
                    return;
                }
                com.kwad.components.ad.splashscreen.monitor.c.a(s.this.mAdTemplate, str, SystemClock.elapsedRealtime() - s.this.JC, 3, "");
                s.this.mE();
            }
        }, str));
        aVar.a(new bc(new bc.a() { // from class: com.kwad.components.ad.splashscreen.presenter.s.5
            @Override // com.kwad.components.core.webview.jshandler.bc.a
            public final void cQ() {
                s.this.cK();
            }
        }));
        aVar.a(new an(this.gC));
        aVar.b(new com.kwad.components.core.webview.jshandler.o(this.gC));
        aVar.b(new com.kwad.components.core.webview.jshandler.n(this.gC));
        ba baVar = new ba();
        this.JD = baVar;
        aVar.a(baVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cK() {
        if (this.iQ != null || this.JB) {
            return;
        }
        com.kwad.sdk.core.g.d dVar = new com.kwad.sdk.core.g.d(com.kwad.sdk.core.response.b.b.dI(this.HX.mAdTemplate));
        this.iQ = dVar;
        dVar.a(new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.splashscreen.presenter.s.6
            @Override // com.kwad.sdk.core.g.b
            public final void ci() {
            }

            @Override // com.kwad.sdk.core.g.b
            public final void d(double d) {
                boolean zPe = com.kwad.components.core.e.c.b.pe();
                if (!s.this.HX.Hk.wO() || zPe) {
                    return;
                }
                s.this.k(d);
                if (s.this.iS == null) {
                    s sVar = s.this;
                    sVar.iS = sVar.F(sVar.getContext());
                }
                bx.a(s.this.getContext(), s.this.iS);
                s.this.iQ.bX(s.this.getContext());
            }
        });
        this.iQ.bW(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Vibrator F(Context context) {
        if (context != null) {
            return (Vibrator) getContext().getSystemService("vibrator");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(final double d) {
        if (this.HX != null) {
            this.HX.a(1, getContext(), 157, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.presenter.s.7
                @Override // com.kwad.components.ad.splashscreen.h.a
                public final void b(com.kwad.sdk.core.adlog.c.b bVar) {
                    bVar.o(d);
                }
            });
        }
    }

    public final void mD() {
        if (this.JA) {
            return;
        }
        this.JA = true;
        a.C0576a c0576a = new a.C0576a();
        c0576a.bvl = com.kwad.components.ad.splashscreen.local.b.s(this.mAdInfo);
        com.kwad.sdk.core.adlog.c.d(this.HX.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().eR(123).b(c0576a));
        com.kwad.components.core.webview.tachikoma.e.a.wk().bt(123);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mE() {
        this.JB = true;
        KsAdWebView ksAdWebView = this.gz;
        if (ksAdWebView != null) {
            ksAdWebView.setVisibility(8);
        }
        ViewGroup viewGroup = this.JF;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        final Presenter presenterY = y(this.mAdInfo);
        if (presenterY != null) {
            bx.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.s.8
                @Override // java.lang.Runnable
                public final void run() {
                    s.this.a(presenterY, true);
                }
            });
        } else {
            mF();
        }
    }

    private Presenter y(AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.a.dB(com.kwad.sdk.core.response.b.e.eP(this.HX.mAdTemplate))) {
            if (com.kwad.sdk.core.response.b.b.ef(adInfo)) {
                return new m();
            }
            return null;
        }
        if (com.kwad.sdk.core.response.b.b.ed(this.mAdInfo)) {
            return new o();
        }
        if (com.kwad.sdk.core.response.b.b.ef(this.mAdInfo)) {
            return new m();
        }
        if (com.kwad.sdk.core.response.b.b.ei(this.mAdInfo)) {
            return new q();
        }
        if (aq.isOrientationPortrait() && com.kwad.sdk.core.response.b.b.ej(this.mAdInfo)) {
            return new l();
        }
        if (aq.isOrientationPortrait() && com.kwad.sdk.core.response.b.b.ek(this.mAdInfo)) {
            return new n();
        }
        if (aq.isOrientationPortrait() && com.kwad.sdk.core.response.b.b.el(this.mAdInfo)) {
            return new p();
        }
        return null;
    }

    private void mF() {
        mD();
        com.kwad.components.ad.splashscreen.e.b bVar = new com.kwad.components.ad.splashscreen.e.b((ViewGroup) getRootView(), (ViewStub) findViewById(R.id.ksad_splash_actionbar_native_stub), com.kwad.sdk.core.response.b.d.eE(this.mAdTemplate), this.HX.mApkDownloadHelper);
        this.Jz = bVar;
        bVar.at(this.mAdTemplate);
        this.Jz.a(this);
        this.Jz.mE();
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void lK() {
        com.kwad.sdk.core.g.d dVar = this.iQ;
        if (dVar != null) {
            dVar.bX(getContext());
        }
    }

    @Override // com.kwad.sdk.core.j.c
    public final void by() {
        com.kwad.sdk.core.g.d dVar = this.iQ;
        if (dVar != null) {
            dVar.bW(getContext());
        }
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bz() {
        com.kwad.sdk.core.g.d dVar = this.iQ;
        if (dVar != null) {
            dVar.bX(getContext());
        }
    }

    private z mG() {
        return new z(this.gC, this.HX.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.s.9
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) throws JSONException {
                if (com.kwad.sdk.c.a.a.Wl()) {
                    return;
                }
                if (aVar.adM() || com.kwad.components.ad.splashscreen.h.n(s.this.mAdInfo)) {
                    s.this.a(false, aVar.afF, aVar.oz, aVar.afG.QX);
                }
            }
        });
    }

    private ac mH() {
        return new ac(this.gC, this.HX.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.s.10
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) throws JSONException {
                if (aVar.afD || !com.kwad.components.ad.splashscreen.h.n(s.this.mAdInfo)) {
                    s.this.a(false, aVar.afD ? 1 : 3, aVar.oz, "");
                }
            }
        }, (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r9, int r10, int r11, java.lang.String r12) throws org.json.JSONException {
        /*
            r8 = this;
            com.kwad.components.ad.splashscreen.h r0 = r8.HX
            r0.ab()
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            r1 = 1
            r0 = r0 ^ r1
            r2 = 0
            if (r10 != r1) goto L10
            r3 = r1
            goto L11
        L10:
            r3 = r2
        L11:
            if (r0 != 0) goto L51
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            com.kwad.components.ad.splashscreen.h r5 = r8.HX     // Catch: org.json.JSONException -> L4b
            if (r5 == 0) goto L51
            com.kwad.components.ad.splashscreen.h r5 = r8.HX     // Catch: org.json.JSONException -> L4b
            com.kwad.components.ad.splashscreen.d.a r5 = r5.Hi     // Catch: org.json.JSONException -> L4b
            if (r5 == 0) goto L2f
            java.lang.String r5 = "duration"
            com.kwad.components.ad.splashscreen.h r6 = r8.HX     // Catch: org.json.JSONException -> L4b
            com.kwad.components.ad.splashscreen.d.a r6 = r6.Hi     // Catch: org.json.JSONException -> L4b
            long r6 = r6.getCurrentPosition()     // Catch: org.json.JSONException -> L4b
            r4.put(r5, r6)     // Catch: org.json.JSONException -> L4b
        L2f:
            if (r9 == 0) goto L34
            r2 = 153(0x99, float:2.14E-43)
            goto L38
        L34:
            if (r3 == 0) goto L38
            r2 = 132(0x84, float:1.85E-43)
        L38:
            com.kwad.sdk.core.adlog.c.b r9 = new com.kwad.sdk.core.adlog.c.b     // Catch: org.json.JSONException -> L49
            r9.<init>()     // Catch: org.json.JSONException -> L49
            com.kwad.sdk.core.adlog.c.b r9 = r9.eP(r2)     // Catch: org.json.JSONException -> L49
            com.kwad.components.ad.splashscreen.h r5 = r8.HX     // Catch: org.json.JSONException -> L49
            com.kwad.sdk.core.response.model.AdTemplate r5 = r5.mAdTemplate     // Catch: org.json.JSONException -> L49
            com.kwad.sdk.core.adlog.c.a(r5, r9, r4)     // Catch: org.json.JSONException -> L49
            goto L52
        L49:
            r9 = move-exception
            goto L4d
        L4b:
            r9 = move-exception
            r2 = r11
        L4d:
            com.kwad.sdk.core.d.c.printStackTrace(r9)
            goto L52
        L51:
            r2 = r11
        L52:
            com.kwad.components.core.e.d.a$a r9 = new com.kwad.components.core.e.d.a$a
            com.kwad.components.ad.splashscreen.h r4 = r8.HX
            com.kwad.sdk.core.view.AdBaseFrameLayout r4 = r4.mRootContainer
            android.content.Context r4 = r4.getContext()
            r9.<init>(r4)
            com.kwad.components.ad.splashscreen.h r4 = r8.HX
            com.kwad.sdk.core.response.model.AdTemplate r4 = r4.mAdTemplate
            com.kwad.components.core.e.d.a$a r9 = r9.aC(r4)
            com.kwad.components.ad.splashscreen.h r4 = r8.HX
            com.kwad.components.core.e.d.c r4 = r4.mApkDownloadHelper
            com.kwad.components.core.e.d.a$a r9 = r9.b(r4)
            com.kwad.components.core.e.d.a$a r9 = r9.aq(r3)
            com.kwad.components.core.e.d.a$a r9 = r9.aG(r10)
            if (r0 == 0) goto L7a
            goto L7b
        L7a:
            r11 = r2
        L7b:
            com.kwad.components.core.e.d.a$a r9 = r9.aF(r11)
            com.kwad.components.core.e.d.a$a r9 = r9.ar(r12)
            com.kwad.components.core.e.d.a$a r9 = r9.aE(r1)
            com.kwad.components.core.e.d.a$a r9 = r9.as(r0)
            com.kwad.components.ad.splashscreen.presenter.s$2 r10 = new com.kwad.components.ad.splashscreen.presenter.s$2
            r10.<init>()
            com.kwad.components.core.e.d.a$a r9 = r9.a(r10)
            com.kwad.components.core.e.d.a.a(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.splashscreen.presenter.s.a(boolean, int, int, java.lang.String):void");
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.splashscreen.e.b bVar = this.Jz;
        if (bVar != null) {
            bVar.onUnbind();
        }
        com.kwad.sdk.core.g.d dVar = this.iQ;
        if (dVar != null) {
            dVar.bX(getContext());
        }
        ba baVar = this.JD;
        if (baVar != null) {
            baVar.vf();
            this.JD.vg();
        }
        if (this.HX != null && this.HX.Hk != null) {
            this.HX.Hk.b(this);
        }
        bk();
    }

    @Override // com.kwad.components.ad.splashscreen.e
    public final void h(boolean z, boolean z2) throws JSONException {
        com.kwad.sdk.core.d.c.d("SplashWebViewPresenter", "isClick: " + z + ", isActionBar: " + z2);
        a(!z, z2 ? 1 : 2, 132, null);
    }
}

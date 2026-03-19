package com.kwad.components.core.page.c.a;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.b;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.bj;
import com.kwad.components.core.webview.tachikoma.c.l;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.a.c;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.bx;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class g extends a implements com.kwad.components.core.webview.jshandler.a.c {
    private static final Handler mHandler = new Handler(Looper.getMainLooper());
    private ba VZ;
    public AdWebViewActivityProxy.a Vi;
    private aw Wa;
    private String Wb;
    private Runnable Wc;
    private com.kwad.components.core.webview.b kG;
    public AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;
    private boolean VX = false;
    private boolean VY = false;
    private final com.kwad.sdk.core.c.c Cf = new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.page.c.a.g.2
        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityResumed */
        public final void d(Activity activity) {
            super.d(activity);
            g.this.show();
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityPaused */
        public final void c(Activity activity) {
            super.c(activity);
            g.this.hide();
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityDestroyed */
        public final void b(Activity activity) {
            super.b(activity);
            if (g.this.mAdWebView == null || g.this.getActivity() == null || !g.this.getActivity().equals(activity)) {
                return;
            }
            g.this.mAdWebView.onActivityDestroy();
            g.a(g.this, (KsAdWebView) null);
        }
    };
    private com.kwad.components.core.webview.jshandler.b VB = new com.kwad.components.core.webview.jshandler.b() { // from class: com.kwad.components.core.page.c.a.g.3
        @Override // com.kwad.components.core.webview.jshandler.b
        public final void rG() {
            if (g.this.Wa != null) {
                g.this.Wa.vc();
            }
        }
    };
    private com.kwad.components.core.webview.c kH = new com.kwad.components.core.webview.c() { // from class: com.kwad.components.core.page.c.a.g.4
        @Override // com.kwad.components.core.webview.c
        public final boolean rH() {
            return true;
        }

        @Override // com.kwad.components.core.webview.c
        public final boolean rI() {
            return true;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
            aVar.a(new bj(new bj.b() { // from class: com.kwad.components.core.page.c.a.g.4.1
                @Override // com.kwad.components.core.webview.jshandler.bj.b
                public final void a(bj.a aVar2) {
                    if (g.this.Vx.VA == null || aVar2 == null) {
                        return;
                    }
                    g.this.Vx.VA.aW(aVar2.visibility);
                }
            }));
            g.this.Wa = new aw(new aw.b() { // from class: com.kwad.components.core.page.c.a.g.4.2
                @Override // com.kwad.components.core.webview.jshandler.aw.b
                public final void rJ() {
                    g.this.Vx.a(g.this.VB);
                }
            });
            aVar.a(g.this.Wa);
            aVar.a(new com.kwad.components.core.webview.tachikoma.b.b(bVar, g.this.Vx.mAdTemplate));
            l lVar = new l();
            lVar.aje = g.this.Vx.mAutoShow ? 1 : 0;
            aVar.a(new com.kwad.components.core.webview.tachikoma.b.g(lVar));
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(ba baVar) {
            g.this.VZ = baVar;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(at.a aVar) {
            g.this.Vx.VC = aVar.isSuccess();
        }

        @Override // com.kwad.components.core.webview.c
        public final void h(int i, String str) {
            g.this.VX = false;
            com.kwad.sdk.commercial.g.a.a(g.this.mAdTemplate, g.this.Vi.rg(), g.this.Vi.rf(), i, str);
        }

        @Override // com.kwad.components.core.webview.c
        public final void onPageFinished() {
            g.this.VX = true;
            if (!g.this.VY) {
                g.b(g.this, true);
                com.kwad.sdk.commercial.g.a.m(g.this.mAdTemplate, g.this.Vi.rg(), g.this.Vi.rf());
            }
            if (g.this.Vx.rt()) {
                g.this.show();
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(WebCloseStatus webCloseStatus) {
            if (g.this.Vx.mWebCardCloseListener != null) {
                g.this.Vx.mWebCardCloseListener.b(webCloseStatus);
            }
        }
    };

    static /* synthetic */ KsAdWebView a(g gVar, KsAdWebView ksAdWebView) {
        gVar.mAdWebView = null;
        return null;
    }

    static /* synthetic */ boolean b(g gVar, boolean z) {
        gVar.VY = true;
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_video_webview);
    }

    @Override // com.kwad.components.core.page.c.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.Vi = this.Vx.Vi;
        this.mAdTemplate = this.Vx.mAdTemplate;
        fy();
        com.kwad.sdk.core.c.b.aaf();
        com.kwad.sdk.core.c.b.a(this.Cf);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.kG.kD();
        com.kwad.sdk.core.c.b.aaf();
        com.kwad.sdk.core.c.b.b(this.Cf);
    }

    private void fy() {
        this.kG = new com.kwad.components.core.webview.b();
        this.kG.a(new b.a().aN(this.Vx.mAdTemplate).aX(this.Vx.mPageUrl).d(this.mAdWebView).k(this.Vx.lz).a(this.kH).b(this.Vx.Vz).a(this));
        rD();
        com.kwad.sdk.commercial.g.a.l(this.mAdTemplate, this.Vi.rg(), this.Vi.rf());
        com.kwad.sdk.core.webview.a.c cVar = new com.kwad.sdk.core.webview.a.c() { // from class: com.kwad.components.core.page.c.a.g.1
            @Override // com.kwad.sdk.core.webview.a.c, android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                com.kwad.sdk.core.d.c.w("KsAdWebViewClient", "shouldOverrideUrlLoading url=" + str);
                com.kwad.sdk.core.webview.b.c.b.al(this.mUniqueId, "shouldOverrideUrlLoading");
                AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(g.this.mAdTemplate);
                g.this.Wb = str;
                if (com.kwad.sdk.core.response.b.a.bq(adInfoEP) && am.dV(g.this.Vx.mContext) && am.is(str)) {
                    final c.a clientConfig = g.this.mAdWebView.getClientConfig();
                    final com.kwad.components.core.urlReplace.c cVar2 = new com.kwad.components.core.urlReplace.c();
                    final Object obj = new Object();
                    g.this.Wc = new Runnable() { // from class: com.kwad.components.core.page.c.a.g.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            synchronized (obj) {
                                com.kwad.components.core.urlReplace.c cVar3 = cVar2;
                                if (cVar3 != null) {
                                    cVar3.tm();
                                }
                                c.a aVar = clientConfig;
                                if (aVar != null && aVar.adE() && clientConfig.adA()) {
                                    if (AnonymousClass1.a(clientConfig, g.this.Wb) == 1) {
                                        com.kwad.sdk.core.adlog.c.g(g.this.mAdTemplate, false);
                                    } else {
                                        com.kwad.sdk.core.adlog.c.h(g.this.mAdTemplate, false);
                                    }
                                } else {
                                    com.kwad.sdk.core.d.c.i("LandPageWebViewLoadPresenter", "deeplink unable");
                                }
                            }
                        }
                    };
                    g.mHandler.postDelayed(g.this.Wc, com.kwad.sdk.core.response.b.a.br(adInfoEP));
                    cVar2.a(str, new com.kwad.components.core.urlReplace.a() { // from class: com.kwad.components.core.page.c.a.g.1.2
                        @Override // com.kwad.components.core.urlReplace.a
                        public final void onSuccess(String str2) {
                            synchronized (obj) {
                                g.this.Wb = str2;
                                if (g.this.Wc != null) {
                                    g.mHandler.removeCallbacks(g.this.Wc);
                                }
                                c.a aVar = clientConfig;
                                if (aVar != null && aVar.adE() && clientConfig.adA()) {
                                    if (AnonymousClass1.a(clientConfig, g.this.Wb) == 1) {
                                        com.kwad.sdk.core.adlog.c.g(g.this.mAdTemplate, true);
                                    } else {
                                        com.kwad.sdk.core.adlog.c.h(g.this.mAdTemplate, true);
                                    }
                                } else {
                                    com.kwad.sdk.core.d.c.i("LandPageWebViewLoadPresenter", "deeplink unable");
                                }
                            }
                        }
                    });
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
        };
        cVar.setClientConfig(this.mAdWebView.getClientConfig());
        this.mAdWebView.setWebViewClient(cVar);
        this.mAdWebView.loadUrl(this.Vx.mPageUrl);
        this.mAdWebView.onActivityCreate();
    }

    public final void show() {
        if (this.VX) {
            ba baVar = this.VZ;
            if (baVar != null) {
                baVar.vd();
            }
            try {
                if (this.Vx.mAdWebView != null) {
                    this.Vx.mAdWebView.setVisibility(0);
                }
            } catch (Exception e) {
                com.kwad.components.core.d.a.reportSdkCaughtException(e);
            }
            ba baVar2 = this.VZ;
            if (baVar2 != null) {
                baVar2.ve();
            }
        }
    }

    public final void hide() {
        ba baVar = this.VZ;
        if (baVar != null) {
            baVar.vf();
        }
        if (this.Vx.mAdWebView != null) {
            this.Vx.mAdWebView.setVisibility(8);
        }
        ba baVar2 = this.VZ;
        if (baVar2 != null) {
            baVar2.vg();
        }
    }

    private void rD() {
        KsAdWebView ksAdWebView;
        this.mAdWebView.setClientConfig(this.mAdWebView.getClientConfig().cK(true).fj(this.Vx.mAdTemplate).cI(false));
        if (com.kwad.sdk.core.response.b.a.bU(com.kwad.sdk.core.response.b.e.eP(this.Vx.mAdTemplate)) > 0) {
            bx.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.page.c.a.g.5
                @Override // java.lang.Runnable
                public final void run() {
                    if (g.this.mAdWebView != null) {
                        g.this.mAdWebView.getClientConfig().cI(true);
                    }
                }
            }, com.kwad.sdk.core.response.b.a.bU(com.kwad.sdk.core.response.b.e.eP(this.Vx.mAdTemplate)));
        } else if (com.kwad.sdk.core.response.b.a.bU(com.kwad.sdk.core.response.b.e.eP(this.Vx.mAdTemplate)) == 0 && (ksAdWebView = this.mAdWebView) != null) {
            ksAdWebView.getClientConfig().cI(true);
        }
        this.mAdWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.page.c.a.g.6
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                g.this.mAdWebView.getClientConfig().cI(true);
                return false;
            }
        });
    }

    @Override // com.kwad.components.core.webview.jshandler.a.c
    public final void rE() {
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}

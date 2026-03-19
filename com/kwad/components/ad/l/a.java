package com.kwad.components.ad.l;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.a.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private KsAdWebView NS;
    private boolean NT;
    private boolean NU;
    protected AdBaseFrameLayout NV;
    private InterfaceC0424a NW;
    private c.a Oa;
    private b Ob;
    private com.kwad.sdk.core.webview.d.a.a gF;
    private FrameLayout gO;

    /* renamed from: if, reason: not valid java name */
    private AdBaseFrameLayout f4if;
    private Activity mActivity;
    private AdTemplate mAdTemplate;
    private ImageView mBackIcon;
    private long mLastDown;
    private boolean NR = true;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean NX = false;
    private boolean NY = false;
    private boolean NZ = false;

    /* renamed from: com.kwad.components.ad.l.a$a, reason: collision with other inner class name */
    public interface InterfaceC0424a {
        void S(boolean z);
    }

    public interface b {
        void jK();
    }

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.NY = true;
        return true;
    }

    static /* synthetic */ boolean b(a aVar, boolean z) {
        aVar.NR = true;
        return true;
    }

    static /* synthetic */ boolean c(a aVar, boolean z) {
        aVar.NX = true;
        return true;
    }

    static /* synthetic */ boolean d(a aVar, boolean z) {
        aVar.NT = true;
        return true;
    }

    public final a ah(boolean z) {
        this.NU = true;
        return this;
    }

    public final void bi() {
        this.gO.setVisibility(4);
        String strL = L(this.mAdTemplate);
        if (TextUtils.isEmpty(strL)) {
            return;
        }
        this.NS.loadUrl(strL);
    }

    public final void a(InterfaceC0424a interfaceC0424a) {
        this.NW = interfaceC0424a;
    }

    private void gx() {
        this.gO.removeAllViews();
        this.gO.setVisibility(4);
        this.NV = (AdBaseFrameLayout) ((ViewGroup) com.kwad.sdk.c.a.a.a((ViewGroup) this.gO, R.layout.ksad_ad_landingpage_layout, true)).findViewById(R.id.ksad_web_card_frame);
        KsAdWebView ksAdWebView = (KsAdWebView) this.gO.findViewById(R.id.ksad_web_card_webView);
        this.NS = ksAdWebView;
        ksAdWebView.setBackgroundColor(-1);
        c.a aVarB = this.NS.getClientConfig().cI(false).cK(true).cJ(false).cH(true).fj(this.mAdTemplate).a(nO()).b(jy());
        this.Oa = aVarB;
        this.NS.setClientConfig(aVarB);
        this.NS.setDownloadListener(new DownloadListener() { // from class: com.kwad.components.ad.l.a.1
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                a.a(a.this, true);
                if (a.this.NW != null) {
                    a.this.NW.S(a.this.cM());
                }
            }
        });
        ImageView imageView = (ImageView) this.NV.findViewById(R.id.ksad_end_close_btn);
        this.mBackIcon = imageView;
        imageView.setVisibility(8);
        this.mBackIcon.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.l.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (a.this.Ob != null) {
                    a.this.Ob.jK();
                }
            }
        });
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate) {
        this.gO = frameLayout;
        this.f4if = adBaseFrameLayout;
        this.mAdTemplate = adTemplate;
        gx();
        this.NR = false;
    }

    private KsAdWebView.e jy() {
        return new KsAdWebView.e() { // from class: com.kwad.components.ad.l.a.3
            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i, String str, String str2) {
                a.b(a.this, true);
                if (a.this.NW != null) {
                    a.this.NW.S(a.this.cM());
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                if (a.this.NW != null) {
                    a.this.NW.S(a.this.cM());
                }
            }
        };
    }

    private KsAdWebView.b nO() {
        return new KsAdWebView.b() { // from class: com.kwad.components.ad.l.a.4
            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                a.c(a.this, true);
                if (a.this.NW != null) {
                    a.this.NW.S(a.this.cM());
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                a.c(a.this, true);
                if (a.this.NW != null) {
                    a.this.NW.S(a.this.cM());
                }
            }
        };
    }

    public final void a(b bVar) {
        this.Ob = bVar;
    }

    public final void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    private static String L(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.a.aW(e.eP(adTemplate));
    }

    public final void a(com.kwad.sdk.core.webview.d.a.a aVar) {
        this.gF = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cM() {
        return this.NZ ? !this.NR : (this.NR || this.NX || this.NY) ? false : true;
    }

    private boolean nP() {
        if (cM()) {
            FrameLayout frameLayout = this.gO;
            if (frameLayout == null) {
                return true;
            }
            frameLayout.setVisibility(0);
            return true;
        }
        FrameLayout frameLayout2 = this.gO;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
        return false;
    }

    public final boolean bb() {
        boolean zNP = nP();
        this.NZ = true;
        if (zNP && this.mActivity != null) {
            if (this.NS.getClientConfig() != null) {
                this.NS.getClientConfig().cI(true);
                this.NS.getClientConfig().cJ(true);
            }
            this.NV.a(new View.OnTouchListener() { // from class: com.kwad.components.ad.l.a.5
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getX() > a.this.mBackIcon.getX() && motionEvent.getX() - a.this.mBackIcon.getX() < a.this.mBackIcon.getWidth() && motionEvent.getY() > a.this.mBackIcon.getY() && motionEvent.getY() - a.this.mBackIcon.getY() < a.this.mBackIcon.getHeight()) {
                        com.kwad.sdk.core.d.c.d("LandingPageWebCard", "onClick backIcon");
                        return false;
                    }
                    if (motionEvent.getAction() == 0) {
                        a.this.mLastDown = SystemClock.elapsedRealtime();
                    } else if (motionEvent.getAction() == 1) {
                        long jElapsedRealtime = SystemClock.elapsedRealtime() - a.this.mLastDown;
                        if (a.this.mLastDown > 0 && jElapsedRealtime > 30 && jElapsedRealtime < 500) {
                            com.kwad.sdk.core.adlog.c.a(a.this.mAdTemplate, 155, a.this.f4if.getTouchCoords());
                            if (!a.this.NT) {
                                a.d(a.this, true);
                                if (a.this.gF != null) {
                                    com.kwad.sdk.core.webview.d.b.a aVar = new com.kwad.sdk.core.webview.d.b.a();
                                    aVar.afF = 3;
                                    a.this.gF.a(aVar);
                                }
                            }
                        }
                        a.this.mLastDown = 0L;
                    }
                    return false;
                }
            });
            long jAo = com.kwad.sdk.core.response.b.a.ao(e.eP(this.mAdTemplate));
            if (jAo == 0 || !this.NU) {
                this.mBackIcon.setVisibility(0);
            } else {
                this.mHandler.postDelayed(new Runnable() { // from class: com.kwad.components.ad.l.a.6
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (a.this.mActivity == null || a.this.mActivity.isFinishing()) {
                            return;
                        }
                        a.this.mBackIcon.setVisibility(0);
                        a.this.mBackIcon.setAlpha(0.0f);
                        a.this.mBackIcon.animate().alpha(1.0f).setDuration(500L).start();
                    }
                }, jAo);
            }
            KsAdWebView ksAdWebView = this.NS;
            if (ksAdWebView != null) {
                ksAdWebView.onActivityCreate();
            }
        }
        return zNP;
    }
}

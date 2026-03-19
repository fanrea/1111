package com.qq.e.comm.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.DownloadListener;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.bytedance.applog.util.WebViewJsUtil;
import com.qq.e.comm.plugin.u50;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class oh extends WebView implements t50, km {
    private static final sg o = new sg("webviewLayout", null);
    private static final bm p = new a();
    private List<f> a;
    private boolean b;
    private m c;
    private boolean d;
    private boolean e;
    private boolean f;
    private bm g;
    private u50 h;
    private boolean i;
    private v50 j;
    private boolean m;
    private boolean n;

    /* compiled from: A */
    class a implements bm {
        @Override // com.qq.e.comm.plugin.bm
        public bm a(c30 c30Var) {
            return this;
        }

        @Override // com.qq.e.comm.plugin.bm
        public bm a(String str, e30 e30Var) {
            return this;
        }

        @Override // com.qq.e.comm.plugin.bm
        public void a(sg sgVar) {
        }

        @Override // com.qq.e.comm.plugin.bm
        public void a(vg vgVar) {
        }

        @Override // com.qq.e.comm.plugin.bm
        public void b(String str) {
        }

        @Override // com.qq.e.comm.plugin.bm
        public ih<String> a(String str) {
            return new ih<>(1000, "");
        }

        a() {
        }
    }

    public oh(Context context) {
        super(b(context));
        this.a = new ArrayList();
        this.b = false;
        this.d = false;
        this.f = true;
        m();
        getSettings().setJavaScriptEnabled(true);
        i();
        h();
        setDownloadListener(new b(context));
        resumeTimers();
    }

    /* compiled from: A */
    class b implements DownloadListener {
        final /* synthetic */ Context a;

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            if (intent.resolveActivity(r1.d().a().getPackageManager()) != null) {
                if (!(this.a instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                try {
                    this.a.startActivity(intent);
                } catch (Throwable unused) {
                }
            }
        }

        b(Context context) {
            this.a = context;
        }
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) throws JSONException {
        if (webChromeClient != null && !(webChromeClient instanceof nh)) {
            ja jaVar = new ja();
            jaVar.a("msg", webChromeClient.toString());
            b10.b(9130004, null, 0, jaVar);
            if (r1.d().f().a("iswcc", 1) != 0) {
                return;
            }
        }
        super.setWebChromeClient(webChromeClient);
    }

    /* compiled from: A */
    class c extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (Build.VERSION.SDK_INT < 26 || renderProcessGoneDetail == null || !renderProcessGoneDetail.didCrash()) {
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            r50.a().a(webView);
            b10.a(9130001, null, 1);
            return true;
        }

        c() {
        }
    }

    public void k() {
        setWebViewClient(new c());
        setWebChromeClient(null);
        this.g = p;
        this.j = null;
    }

    private void h() {
        try {
            WebSettings settings = getSettings();
            settings.setAllowFileAccess(false);
            settings.setLoadsImagesAutomatically(true);
            settings.setCacheMode(-1);
            settings.setDomStorageEnabled(true);
        } catch (Throwable unused) {
        }
    }

    private void i() {
        l();
        getSettings().setSavePassword(false);
    }

    private void l() {
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
    }

    private void m() {
        WebSettings settings = getSettings();
        settings.setUserAgentString(settings.getUserAgentString() + " GDTMobSDK/" + su.c());
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        u50 u50Var;
        super.onAttachedToWindow();
        if (this.c != null) {
            f();
        }
        if (this.i && (u50Var = this.h) != null && u50Var.getParent() == null) {
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup instanceof FrameLayout) {
                viewGroup.addView(this.h);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.c != null) {
            n();
        }
    }

    private void f() {
        if (this.d) {
            return;
        }
        this.d = true;
        com.qq.e.comm.plugin.apkmanager.l.e().a(this.c);
    }

    private void n() {
        this.d = false;
        com.qq.e.comm.plugin.apkmanager.l.e().b(this.c);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        try {
            super.loadUrl(str);
        } catch (Throwable unused) {
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        try {
            if (this.e) {
                return;
            }
            if (!ap.e() || Build.VERSION.SDK_INT > 23) {
                loadUrl(WebViewJsUtil.EMPTY_PAGE);
            }
            ViewParent parent = getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this);
            }
            if (this.j != null) {
                this.j = null;
            }
            this.g = p;
            removeAllViews();
            super.destroy();
            this.e = true;
        } catch (Throwable unused) {
        }
    }

    public boolean j() {
        return this.e;
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        v50 v50Var = this.j;
        if (v50Var != null) {
            v50Var.a(i);
        }
    }

    @Override // android.widget.AbsoluteLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        bm bmVar;
        super.onLayout(z, i, i2, i3, i4);
        if (this.b || (bmVar = this.g) == null) {
            return;
        }
        this.b = true;
        bmVar.a(o);
    }

    public bm b() {
        return this.g;
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        u50 u50Var;
        if (!this.f) {
            scrollTo(i, 0);
            return;
        }
        super.onScrollChanged(i, i2, i3, i4);
        if (!this.i || (u50Var = this.h) == null) {
            return;
        }
        if (i2 > i4) {
            u50Var.b();
        } else {
            u50Var.d();
        }
    }

    public u50 c() {
        return this.h;
    }

    /* compiled from: A */
    class d implements u50.b {
        @Override // com.qq.e.comm.plugin.u50.b
        public void i() {
        }

        @Override // com.qq.e.comm.plugin.u50.b
        public void j() {
        }

        @Override // com.qq.e.comm.plugin.u50.b
        public void k() {
        }

        @Override // com.qq.e.comm.plugin.u50.b
        public void l() {
        }

        d() {
        }
    }

    public void a(e eVar) {
        List<f> list = this.a;
        if (list != null) {
            Iterator<f> it = list.iterator();
            while (it.hasNext()) {
                it.next().a(eVar);
            }
        }
    }

    public boolean g() {
        return this.m;
    }

    public void d(boolean z) {
        WebSettings settings = getSettings();
        if (settings == null || Build.VERSION.SDK_INT < 17) {
            return;
        }
        settings.setMediaPlaybackRequiresUserGesture(z);
    }

    public void f(boolean z) {
        if (z) {
            WebSettings settings = getSettings();
            int i = Build.VERSION.SDK_INT;
            if (i >= 21) {
                settings.setMixedContentMode(0);
            }
            setInitialScale(100);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setSupportMultipleWindows(false);
            settings.setSaveFormData(false);
            File fileA = gu.a(getContext());
            if (!fileA.exists()) {
                fileA.mkdirs();
            }
            String absolutePath = fileA.getAbsolutePath();
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(absolutePath);
            settings.setGeolocationEnabled(true);
            settings.setGeolocationDatabasePath(absolutePath);
            if (i >= 17) {
                settings.setMediaPlaybackRequiresUserGesture(false);
                return;
            }
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            setLayerType(2, null);
        } else {
            setLayerType(1, null);
        }
    }

    public void a(m mVar) {
        this.c = mVar;
    }

    public void b(boolean z) {
        this.i = z;
        if (z) {
            u50 u50Var = new u50(getContext(), this);
            this.h = u50Var;
            u50Var.a(new d());
        }
    }

    private static Context b(Context context) {
        int i = Build.VERSION.SDK_INT;
        return (i == 21 || i == 22) ? context.createConfigurationContext(new Configuration()) : context;
    }

    public void g(boolean z) {
        this.n = z;
    }

    public void a(f fVar) {
        this.a.add(fVar);
    }

    public void a(nh nhVar) throws JSONException {
        if (nhVar != null) {
            setWebChromeClient(nhVar);
        }
    }

    public void a(WebViewClient webViewClient) {
        if (webViewClient != null) {
            setWebViewClient(webViewClient);
        }
    }

    public void a(bm bmVar) {
        this.g = bmVar;
        this.j = new v50(bmVar);
    }

    @Override // com.qq.e.comm.plugin.t50
    public void a(String str, ValueCallback<String> valueCallback) {
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                evaluateJavascript(str, valueCallback);
            } else {
                loadUrl("javascript:" + str);
                if (valueCallback != null) {
                    valueCallback.onReceiveValue("");
                }
            }
        } catch (Throwable unused) {
        }
    }
}

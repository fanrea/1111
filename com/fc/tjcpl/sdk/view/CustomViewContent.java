package com.fc.tjcpl.sdk.view;

import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.widget.RelativeLayout;
import com.alipay.sdk.m.u.i;
import com.alipay.sdk.m.x.d;
import com.fc.tjcpl.sdk.i.c;
import com.fc.tjcpl.sdk.n.b;
import com.fc.tjcpl.sdk.n.e;
import com.fc.tjcpl.sdk.n.e0;
import com.fc.tjcpl.sdk.n.f;
import com.fc.tjcpl.sdk.n.g;
import com.fc.tjcpl.sdk.n.h;
import com.fc.tjcpl.sdk.n.h0;
import com.fc.tjcpl.sdk.n.i0;
import com.fc.tjcpl.sdk.n.j;
import com.fc.tjcpl.sdk.n.k;
import com.fc.tjcpl.sdk.n.m;
import com.fc.tjcpl.sdk.n.p;
import com.fc.tjcpl.sdk.n.q;
import com.fc.tjcpl.sdk.n.r;
import com.fc.tjcpl.sdk.n.s;
import com.fc.tjcpl.sdk.n.t;
import com.fc.tjcpl.sdk.n.u;
import com.fc.tjcpl.sdk.n.v;
import com.fc.tjcpl.sdk.n.w;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class CustomViewContent extends RelativeLayout implements i0 {
    public com.fc.tjcpl.sdk.n.a a;
    public BridgeWebView b;
    public ViewWebLoading c;
    public boolean d;
    public boolean e;
    public ViewDownloadBtn f;
    public String g;
    public String h;
    public int i;
    public boolean j;
    public boolean k;
    public h0 l;

    public class a implements CallBackFunction {
        public a(CustomViewContent customViewContent) {
        }

        @Override // com.github.lzyzsd.jsbridge.CallBackFunction
        public void onCallBack(String str) {
        }
    }

    public CustomViewContent(com.fc.tjcpl.sdk.n.a aVar) {
        super(aVar.a());
        this.a = aVar;
        a();
    }

    public static boolean a(CustomViewContent customViewContent, String str) {
        customViewContent.getClass();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return customViewContent.a.a().getApplicationContext().getPackageManager().getPackageInfo(str, 0) != null;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public void a(String str, String str2) {
        c.a("call handler:" + str);
        this.b.callHandler(str, str2, new a(this));
    }

    public void b() {
        ViewDownloadBtn viewDownloadBtn;
        com.fc.tjcpl.sdk.a.a aVar;
        com.fc.tjcpl.sdk.a.a aVar2;
        e0 e0Var = e0.b.a;
        if (!e0Var.e && (aVar2 = e0Var.a) != null) {
            com.fc.tjcpl.sdk.b.a.c(aVar2.h);
            com.fc.tjcpl.sdk.n.a aVar3 = e0Var.b;
            if (aVar3 != null && aVar3.a() != null && !e0Var.b.a().isFinishing()) {
                ((CustomViewContent) e0Var.f).a(d.p, "");
            }
        }
        ViewDownloadBtn viewDownloadBtn2 = this.f;
        if (viewDownloadBtn2 == null || viewDownloadBtn2.getVisibility() != 0 || (aVar = (viewDownloadBtn = this.f).c) == null || aVar.a != 1) {
            return;
        }
        com.fc.tjcpl.sdk.b.a.c(aVar.h);
        i0 i0Var = viewDownloadBtn.j;
        if (i0Var != null) {
            ((CustomViewContent) i0Var).a(d.p, "");
        }
    }

    public final void a() {
        BridgeWebView bridgeWebView = new BridgeWebView(this.a.a());
        this.b = bridgeWebView;
        addView(bridgeWebView, new RelativeLayout.LayoutParams(-1, -1));
        this.b.setBackgroundColor(-1);
        WebSettings settings = this.b.getSettings();
        settings.setJavaScriptEnabled(true);
        this.b.setScrollBarStyle(0);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setCacheMode(-1);
        settings.setBuiltInZoomControls(false);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(false);
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setDomStorageEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setUserAgentString(settings.getUserAgentString() + ";tjcplsdk;newdownload;tjv5.0" + i.b);
        c.b("tag", "UA==" + settings.getUserAgentString());
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        this.b.setWebViewClient(new p(this, this.b));
        this.b.setWebChromeClient(new q(this));
        this.b.setDownloadListener(new r(this));
        this.b.registerHandler("onSetStatusbarColor", new s(this));
        this.b.registerHandler(d.r, new t(this));
        this.b.registerHandler("setToken", new u(this));
        this.b.registerHandler("onAppDetail", new v(this));
        this.b.registerHandler("onAppDetailExit", new w(this));
        this.b.registerHandler("onAppDetailJump", new b(this));
        this.b.registerHandler("onOpenQQ", new com.fc.tjcpl.sdk.n.c(this));
        this.b.registerHandler("isInstall", new com.fc.tjcpl.sdk.n.d(this));
        this.b.registerHandler("natAppList", new e(this));
        this.b.registerHandler("natOpenBrowser", new f(this));
        this.b.registerHandler("natOpenApp", new g(this));
        this.b.registerHandler("natAddDownloadTask", new h(this));
        this.b.registerHandler("natTaskOperate", new com.fc.tjcpl.sdk.n.i(this));
        this.b.registerHandler("natTaskStop", new j(this));
        this.b.registerHandler("natFloatShow", new k(this));
        this.b.registerHandler("natFloatHide", new m(this));
        ViewDownloadBtn viewDownloadBtn = new ViewDownloadBtn(getContext().getApplicationContext());
        this.f = viewDownloadBtn;
        viewDownloadBtn.setWebListener(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.fc.tjcpl.sdk.b.a.a(getContext().getApplicationContext(), 65.0f));
        layoutParams.addRule(12);
        addView(this.f, layoutParams);
        ViewWebLoading viewWebLoading = new ViewWebLoading(getContext().getApplicationContext());
        this.c = viewWebLoading;
        viewWebLoading.setWebListener(this);
        this.c.b();
        addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
        this.f.setVisibility(8);
        e0.b.a.f = this;
        try {
            this.b.resumeTimers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0191  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r18, int r19, android.content.Intent r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 461
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fc.tjcpl.sdk.view.CustomViewContent.a(int, int, android.content.Intent):void");
    }
}

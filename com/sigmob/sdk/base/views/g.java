package com.sigmob.sdk.base.views;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.mobstat.forbes.Config;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.utils.ReflectionUtil;
import com.czhj.sdk.common.utils.RomUtils;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.StringUtil;
import com.google.android.material.badge.BadgeDrawable;
import com.sigmob.sdk.base.common.n;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.nativead.APKStatusBroadcastReceiver;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class g extends WebView {
    private static boolean a = false;
    private APKStatusBroadcastReceiver b;
    private WeakReference<n.a> c;
    private BaseAdUnit d;
    private WebViewClient e;
    private final Set<String> f;
    private final Map<String, String> g;

    private class a {
        public a() {
        }

        @JavascriptInterface
        public int cancelDownloadTask() {
            if (g.this.d == null || g.this.d.getApkDownloadType() == 0) {
                return -1;
            }
            return com.sigmob.sdk.base.common.m.c(g.this.getContext(), g.this.d);
        }

        @JavascriptInterface
        public int getApKDownloadProcess() {
            g.this.a();
            Context context = g.this.getContext();
            if (context == null || g.this.d == null) {
                return -1;
            }
            long[] jArrD = g.this.d.getApkDownloadType() != 0 ? com.sigmob.sdk.base.common.m.d(context, g.this.d) : com.sigmob.sdk.base.common.o.a(context, g.this.d.getDownloadId());
            int i = (int) jArrD[2];
            if (i != 1) {
                if (i != 2) {
                    if (i != 4) {
                        return i != 8 ? -1 : 100;
                    }
                    return -2;
                }
                long j = jArrD[0];
                long j2 = jArrD[1];
                if (j2 != 0 && j != 0) {
                    return (int) ((j * 100) / j2);
                }
            }
            return 0;
        }

        @JavascriptInterface
        public int getApKDownloadType() {
            if (g.this.d == null) {
                return -1;
            }
            return g.this.d.getApkDownloadType();
        }

        @JavascriptInterface
        public int pauseDownload() {
            if (g.this.d == null || g.this.d.getApkDownloadType() == 0) {
                return -1;
            }
            return com.sigmob.sdk.base.common.m.a(g.this.getContext(), g.this.d);
        }

        @JavascriptInterface
        public int resumeDownload() {
            if (g.this.d == null || g.this.d.getApkDownloadType() == 0) {
                return -1;
            }
            return com.sigmob.sdk.base.common.m.b(g.this.getContext(), g.this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class b {
        private BaseAdUnit b;

        b(BaseAdUnit adUnit) {
            this.b = adUnit;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            Activity activityC = com.sigmob.sdk.base.utils.o.c(g.this);
            if (activityC == null) {
                return;
            }
            com.sigmob.sdk.videoplayer.c.h((Context) activityC);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            Activity activityC = com.sigmob.sdk.base.utils.o.c(g.this);
            if (activityC == null) {
                return;
            }
            com.sigmob.sdk.videoplayer.c.j(activityC);
        }

        @JavascriptInterface
        public boolean canInstall(String apkName) {
            if (this.b == null) {
                return false;
            }
            if (TextUtils.isEmpty(apkName)) {
                apkName = TextUtils.isEmpty(this.b.getApkName()) ? TextUtils.isEmpty(this.b.getApkMd5()) ? "" : this.b.getApkMd5() + ".apk" : this.b.getApkName();
            }
            return this.b.canInstall(apkName);
        }

        @JavascriptInterface
        public boolean canOpen(String packageName) {
            BaseAdUnit baseAdUnit;
            return (!TextUtils.isEmpty(packageName) || (baseAdUnit = this.b) == null) ? com.sigmob.sdk.base.o.a().b(packageName).booleanValue() : baseAdUnit.canOpen();
        }

        @JavascriptInterface
        public int getInteractionType() {
            if (g.this.d == null) {
                return 0;
            }
            return g.this.d.getInteractionType();
        }

        @JavascriptInterface
        public int getSubInteractionType() {
            if (g.this.d == null) {
                return 0;
            }
            return g.this.d.getsubInteractionType();
        }

        @JavascriptInterface
        public void hideSystemUI() {
            ThreadPoolFactory.MainThreadRun(new Runnable() { // from class: com.sigmob.sdk.base.views.g$b$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a();
                }
            });
        }

        @JavascriptInterface
        public boolean isOpenListReport() {
            com.sigmob.sdk.base.o oVarA = com.sigmob.sdk.base.o.a();
            return (oVarA.V().isEmpty() || com.sigmob.sdk.base.services.b.a() || !oVarA.N().booleanValue()) ? false : true;
        }

        @JavascriptInterface
        public void onOpenListReport() {
            com.sigmob.sdk.base.services.b.c();
        }

        @JavascriptInterface
        public void showSystemUI() {
            ThreadPoolFactory.MainThreadRun(new Runnable() { // from class: com.sigmob.sdk.base.views.g$b$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b();
                }
            });
        }
    }

    public g(Context context) {
        super(context);
        this.f = new HashSet();
        this.g = new HashMap();
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        a(getSettings());
        if (!a) {
            b(getContext());
            a = true;
        }
        resumeTimers();
        a(context);
    }

    private static void a(Context context) {
        String str;
        if (Build.VERSION.SDK_INT < 28) {
            return;
        }
        try {
            String absolutePath = context.getDataDir().getAbsolutePath();
            HashSet hashSet = new HashSet();
            String processName = Application.getProcessName();
            if (TextUtils.equals(context.getPackageName(), processName)) {
                String str2 = Config.replace + processName;
                hashSet.add(absolutePath + "/app_webview/webview_data.lock");
                hashSet.add(absolutePath + "/app_webview" + str2 + "/webview_data.lock");
                if (RomUtils.isHuawei()) {
                    hashSet.add(absolutePath + "/app_hws_webview/webview_data.lock");
                    str = absolutePath + "/app_hws_webview" + str2 + "/webview_data.lock";
                    hashSet.add(str);
                }
            } else {
                if (TextUtils.isEmpty(processName)) {
                    processName = context.getPackageName();
                }
                WebView.setDataDirectorySuffix(processName);
                String str3 = Config.replace + processName;
                hashSet.add(absolutePath + "/app_webview" + str3 + "/webview_data.lock");
                if (RomUtils.isHuawei()) {
                    str = absolutePath + "/app_hws_webview" + str3 + "/webview_data.lock";
                    hashSet.add(str);
                }
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                File file = new File((String) it.next());
                if (file.exists()) {
                    a(file);
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(WebSettings webSettings) {
        try {
            ReflectionUtil.MethodBuilder methodBuilder = new ReflectionUtil.MethodBuilder(webSettings, new String(Base64.decode(com.sigmob.sdk.base.n.D, 2)));
            methodBuilder.addParam(Boolean.TYPE, true);
            methodBuilder.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ReflectionUtil.MethodBuilder methodBuilder2 = new ReflectionUtil.MethodBuilder(webSettings, new String(Base64.decode(com.sigmob.sdk.base.n.F, 2)));
            methodBuilder2.addParam(Boolean.TYPE, true);
            methodBuilder2.execute();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        webSettings.setDomStorageEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSupportZoom(true);
        webSettings.setDefaultTextEncodingName("UTF-8");
        webSettings.setBlockNetworkImage(false);
        webSettings.setBlockNetworkLoads(false);
        webSettings.setCacheMode(-1);
        if (Build.VERSION.SDK_INT >= 17) {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        }
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setAllowContentAccess(true);
        if (Build.VERSION.SDK_INT < 16) {
            webSettings.setAllowUniversalAccessFromFileURLs(false);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                webSettings.setSafeBrowsingEnabled(false);
            } catch (Throwable unused) {
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                webSettings.setMixedContentMode(0);
            } catch (Throwable unused2) {
            }
        }
        addJavascriptInterface(new a(), "sigandroidapk");
    }

    public static void a(final WebView webView) {
        CookieManager cookieManager = CookieManager.getInstance();
        if (Build.VERSION.SDK_INT >= 21) {
            cookieManager.setAcceptThirdPartyCookies(webView, com.sigmob.sdk.base.i.a().i());
        }
    }

    private static void a(File file) throws IOException {
        try {
            FileLock fileLockTryLock = new RandomAccessFile(file, "rw").getChannel().tryLock();
            if (fileLockTryLock != null) {
                fileLockTryLock.close();
            } else {
                a(file, file.delete());
            }
        } catch (Exception e) {
            e.printStackTrace();
            a(file, file.exists() ? file.delete() : false);
        }
    }

    private static void a(File file, boolean deleted) throws IOException {
        if (deleted) {
            try {
                if (file.exists()) {
                    return;
                }
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void b(final Context context) {
        if (Build.VERSION.SDK_INT == 19) {
            WebView webView = new WebView(context.getApplicationContext());
            webView.setBackgroundColor(0);
            webView.loadDataWithBaseURL(null, "", "text/html", "UTF-8", null);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = 1;
            layoutParams.height = 1;
            layoutParams.type = 2005;
            layoutParams.flags = 16777240;
            layoutParams.format = -2;
            layoutParams.gravity = BadgeDrawable.TOP_START;
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                windowManager.addView(webView, layoutParams);
            }
        }
    }

    public static void d() {
        CookieManager cookieManager = CookieManager.getInstance();
        if (com.sigmob.sdk.base.i.a().i()) {
            cookieManager.setAcceptCookie(true);
            CookieManager.setAcceptFileSchemeCookies(true);
            return;
        }
        cookieManager.setAcceptCookie(false);
        CookieManager.setAcceptFileSchemeCookies(false);
        if (Build.VERSION.SDK_INT < 21) {
            cookieManager.removeSessionCookie();
            cookieManager.removeAllCookie();
        } else {
            cookieManager.removeSessionCookies(null);
            cookieManager.removeAllCookies(null);
            cookieManager.flush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public n.a getListener() {
        WeakReference<n.a> weakReference = this.c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void a() {
        if (this.d == null || this.b != null) {
            return;
        }
        APKStatusBroadcastReceiver aPKStatusBroadcastReceiver = new APKStatusBroadcastReceiver(new n.a() { // from class: com.sigmob.sdk.base.views.g.1
            @Override // com.sigmob.sdk.base.common.n.a
            public void a(boolean result) {
                n.a listener = g.this.getListener();
                if (listener != null) {
                    listener.a(result);
                }
            }

            @Override // com.sigmob.sdk.base.common.n.a
            public void a(boolean result, long downloadId) {
                n.a listener = g.this.getListener();
                if (listener != null) {
                    listener.b(result, downloadId);
                } else if (result) {
                    g.this.e();
                } else {
                    g.this.f();
                }
            }

            @Override // com.sigmob.sdk.base.common.n.a
            public void b(boolean result) {
                n.a listener = g.this.getListener();
                if (listener != null) {
                    listener.b(result);
                } else if (result) {
                    g.this.i();
                } else {
                    g.this.f();
                }
            }

            @Override // com.sigmob.sdk.base.common.n.a
            public void b(boolean result, long downloadId) {
                n.a listener = g.this.getListener();
                if (listener != null) {
                    listener.b(result, downloadId);
                } else if (result) {
                    g.this.h();
                } else {
                    g.this.f();
                }
            }

            @Override // com.sigmob.sdk.base.common.n.a
            public void c(boolean result, long downloadId) {
                n.a listener = g.this.getListener();
                if (listener != null) {
                    listener.c(result, downloadId);
                }
                g.this.g();
            }
        }, this.d.getUuid());
        this.b = aPKStatusBroadcastReceiver;
        aPKStatusBroadcastReceiver.a(aPKStatusBroadcastReceiver);
    }

    public void a(final n.a listener) {
        this.c = new WeakReference<>(listener);
    }

    void a(String javascript, ValueCallback callback) {
        SigmobLog.d("Injecting Javascript into MRAID WebView:\n\t" + javascript);
        if (javascript.startsWith("bridge")) {
            javascript = javascript.replaceFirst("bridge", StringUtil.decode(StringUtil.s));
        }
        if (Build.VERSION.SDK_INT >= 19) {
            evaluateJavascript(javascript, callback);
        } else {
            loadUrl("javascript:" + javascript);
        }
    }

    public void a(final boolean enabled) {
        WebSettings settings;
        WebSettings.PluginState pluginState;
        if (Build.VERSION.SDK_INT >= 18) {
            return;
        }
        if (enabled) {
            settings = getSettings();
            pluginState = WebSettings.PluginState.ON;
        } else {
            settings = getSettings();
            pluginState = WebSettings.PluginState.OFF;
        }
        settings.setPluginState(pluginState);
    }

    @Override // android.webkit.WebView
    public void addJavascriptInterface(Object object, String key) {
        super.addJavascriptInterface(object, key);
        this.f.add(key);
    }

    public void b() {
        com.sigmob.sdk.base.utils.o.a(this);
        APKStatusBroadcastReceiver aPKStatusBroadcastReceiver = this.b;
        if (aPKStatusBroadcastReceiver != null) {
            aPKStatusBroadcastReceiver.b(aPKStatusBroadcastReceiver);
            this.b = null;
        }
        setWebViewClient(null);
        removeAllViews();
        Iterator<String> it = this.f.iterator();
        while (it.hasNext()) {
            removeJavascriptInterface(it.next());
        }
        this.f.clear();
        setWebChromeClient(null);
        loadUrl("");
        this.d = null;
    }

    public void b(boolean isFinishing) {
        if (isFinishing) {
            stopLoading();
            loadUrl("");
        }
        onPause();
    }

    public void c() {
        setWebChromeClient(new WebChromeClient() { // from class: com.sigmob.sdk.base.views.g.2
            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(final WebView view, final String url, final String message, final JsResult result) {
                SigmobLog.i(message);
                result.confirm();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsBeforeUnload(WebView view, String url, String message, JsResult result) {
                SigmobLog.i(message);
                result.confirm();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsConfirm(final WebView view, final String url, final String message, final JsResult result) {
                SigmobLog.i(message);
                result.confirm();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(final WebView view, final String url, final String message, final String defaultValue, final JsPromptResult result) {
                SigmobLog.i(message);
                result.confirm();
                return true;
            }
        });
    }

    @Override // android.webkit.WebView
    public void destroy() {
        b();
        SigmobLog.d(" BaseWebView destroy called ");
        super.destroy();
    }

    void e() {
        a("bridge.notifyApkDownloadStartEvent();", (ValueCallback) null);
    }

    void f() {
        a("bridge.notifyApkDownloadFailEvent();", (ValueCallback) null);
    }

    void g() {
        a("bridge.notifyApkDownloadPauseEvent();", (ValueCallback) null);
    }

    void h() {
        a("bridge.notifyApkDownloadEndEvent();", (ValueCallback) null);
    }

    void i() {
        a("bridge.notifyApkDownloadInstalledEvent();", (ValueCallback) null);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String url) {
        String url2 = StringUtil.getUrl(url);
        this.g.put("Referer", "");
        BaseAdUnit baseAdUnit = this.d;
        if (baseAdUnit != null && baseAdUnit.isDisablexRequestWith()) {
            this.g.put("X-Requested-With", "");
        }
        loadUrl(url2, this.g);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void setAdUnit(BaseAdUnit mAdUnit) {
        this.d = mAdUnit;
        if (mAdUnit == null) {
            return;
        }
        addJavascriptInterface(new b(mAdUnit), "sigandroidh5");
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient client) {
        this.e = client;
        super.setWebViewClient(client);
    }
}

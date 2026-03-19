package com.bytedance.sdk.component.widget.web;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.uo.b;
import com.bytedance.sdk.component.uo.d;
import com.bytedance.sdk.component.uo.hc;
import com.bytedance.sdk.component.utils.gb;
import com.kuaishou.android.live.network.ApiStatus;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class MultiWebview extends FrameLayout implements com.bytedance.sdk.component.uo.d {
    public static com.bytedance.sdk.component.widget.d c = null;
    private static int u = 1;
    private long an;
    protected WebViewImpl b;
    protected final AtomicInteger d;
    private Deque<b> gb;
    private d.InterfaceC0287d h;
    protected volatile b hc;
    private Map<b, Set<String>> tt;

    public static void setMaxWebViewCount(int i) {
        u = i + 1;
    }

    public static void setExceptionReport(com.bytedance.sdk.component.widget.d dVar) {
        c = dVar;
    }

    public MultiWebview(Context context) {
        this(context, null);
    }

    public MultiWebview(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiWebview(final Context context, final AttributeSet attributeSet, final int i) {
        super(context, attributeSet, i);
        AtomicInteger atomicInteger = new AtomicInteger();
        this.d = atomicInteger;
        this.gb = new LinkedList();
        this.tt = new ConcurrentHashMap();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        atomicInteger.set(1);
        if (u()) {
            this.b = d(context, attributeSet, i);
            c();
            this.an = System.currentTimeMillis() - jCurrentTimeMillis;
            return;
        }
        d(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.MultiWebview.1
            @Override // java.lang.Runnable
            public void run() {
                MultiWebview multiWebview = MultiWebview.this;
                multiWebview.b = multiWebview.d(context, attributeSet, i);
                MultiWebview.this.c();
                MultiWebview.this.an = System.currentTimeMillis() - jCurrentTimeMillis;
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebViewImpl d(Context context, AttributeSet attributeSet, int i) {
        WebViewImpl webViewImpl;
        try {
            this.d.set(2);
            if (i == 0) {
                webViewImpl = new WebViewImpl(this, context, attributeSet);
            } else {
                webViewImpl = new WebViewImpl(this, context, attributeSet, i);
            }
            this.d.set(3);
            return webViewImpl;
        } catch (Throwable th) {
            this.d.set(4);
            if (c == null) {
                return null;
            }
            c.d(Thread.currentThread().getName(), th);
            return null;
        }
    }

    private b b() {
        String name = Thread.currentThread().getName();
        try {
            return new WebViewImpl(this, getContext());
        } catch (Throwable th) {
            com.bytedance.sdk.component.widget.d dVar = c;
            if (dVar == null) {
                return null;
            }
            dVar.d(name, th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.b == null) {
            return;
        }
        removeAllViews();
        setBackground(null);
        try {
            this.b.getView().setId(2064056317);
        } catch (Throwable unused) {
        }
        addView(this.b.getView(), new FrameLayout.LayoutParams(-1, -1));
        this.gb.add(this.b);
        this.hc = this.b;
    }

    public void G_() {
        this.tt.clear();
        this.h = null;
        d(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.MultiWebview.2
            @Override // java.lang.Runnable
            public void run() {
                MultiWebview.this.an();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an() {
        while (true) {
            b bVarD = d();
            if (bVarD == null) {
                break;
            } else {
                removeView(bVarD.getView());
            }
        }
        WebViewImpl webViewImpl = this.b;
        if (webViewImpl != null) {
            webViewImpl.hc();
        }
    }

    @Override // com.bytedance.sdk.component.uo.d
    public int d(final String str) {
        b bVarHc;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (u == 1) {
            return 2;
        }
        if (getWebViewCount() >= u) {
            return 1;
        }
        if (u()) {
            bVarHc = hc(str);
        } else {
            final b[] bVarArr = new b[1];
            final Object obj = new Object();
            d(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.MultiWebview.3
                @Override // java.lang.Runnable
                public void run() {
                    bVarArr[0] = MultiWebview.this.hc(str);
                    synchronized (obj) {
                        obj.notifyAll();
                    }
                }
            });
            try {
                if (bVarArr[0] == null) {
                    synchronized (obj) {
                        obj.wait(2500L);
                    }
                }
            } catch (InterruptedException unused) {
            }
            bVarHc = bVarArr[0];
        }
        if (bVarHc != null) {
            return 0;
        }
        return ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b hc(String str) {
        b bVarB = b();
        if (bVarB != null) {
            b bVar = this.hc;
            this.gb.add(bVarB);
            this.hc = bVarB;
            addView(bVarB.getView(), new FrameLayout.LayoutParams(-1, -1));
            d(bVarB);
            bVarB.loadUrl(str);
            if (bVar != null) {
                bVar.onPause();
                bVar.setVisibility(8);
            }
        }
        return bVarB;
    }

    private void d(b bVar) {
        d dVar;
        Object objD;
        WebViewImpl webViewImpl = this.b;
        if (webViewImpl == null || bVar == null) {
            return;
        }
        Integer backgroundColor = webViewImpl.getBackgroundColor();
        if (backgroundColor != null) {
            bVar.setBackgroundColor(backgroundColor.intValue());
        }
        Boolean allowFileAccess = webViewImpl.getAllowFileAccess();
        if (allowFileAccess != null) {
            bVar.setAllowFileAccess(allowFileAccess.booleanValue());
        }
        Boolean databaseEnabled = webViewImpl.getDatabaseEnabled();
        if (databaseEnabled != null) {
            bVar.setDatabaseEnabled(databaseEnabled.booleanValue());
        }
        Boolean appCacheEnabled = webViewImpl.getAppCacheEnabled();
        if (appCacheEnabled != null) {
            bVar.setAppCacheEnabled(appCacheEnabled.booleanValue());
        }
        Boolean domStorageEnabled = webViewImpl.getDomStorageEnabled();
        if (domStorageEnabled != null) {
            bVar.setDomStorageEnabled(domStorageEnabled.booleanValue());
        }
        Boolean supportZoom = webViewImpl.getSupportZoom();
        if (supportZoom != null) {
            bVar.setSupportZoom(supportZoom.booleanValue());
        }
        Boolean builtInZoomControls = webViewImpl.getBuiltInZoomControls();
        if (builtInZoomControls != null) {
            bVar.setBuiltInZoomControls(builtInZoomControls.booleanValue());
        }
        Boolean useWideViewPort = webViewImpl.getUseWideViewPort();
        if (useWideViewPort != null) {
            bVar.setUseWideViewPort(useWideViewPort.booleanValue());
        }
        WebSettings.LayoutAlgorithm layoutAlgorithm = webViewImpl.getLayoutAlgorithm();
        if (layoutAlgorithm != null) {
            bVar.setLayoutAlgorithm(layoutAlgorithm);
        }
        Boolean javaScriptEnabled = webViewImpl.getJavaScriptEnabled();
        if (javaScriptEnabled != null) {
            bVar.setJavaScriptEnabled(javaScriptEnabled.booleanValue());
        }
        Boolean javaScriptCanOpenWindowsAutomatically = webViewImpl.getJavaScriptCanOpenWindowsAutomatically();
        if (javaScriptCanOpenWindowsAutomatically != null) {
            bVar.setJavaScriptCanOpenWindowsAutomatically(javaScriptCanOpenWindowsAutomatically.booleanValue());
        }
        View.OnScrollChangeListener onScrollChangeListener = webViewImpl.getOnScrollChangeListener();
        if (onScrollChangeListener != null) {
            bVar.setOnScrollChangeListener(onScrollChangeListener);
        }
        Boolean mediaPlaybackRequiresUserGesture = webViewImpl.getMediaPlaybackRequiresUserGesture();
        if (mediaPlaybackRequiresUserGesture != null) {
            bVar.setMediaPlaybackRequiresUserGesture(mediaPlaybackRequiresUserGesture.booleanValue());
        }
        Boolean savePassword = webViewImpl.getSavePassword();
        if (savePassword != null) {
            bVar.setSavePassword(savePassword.booleanValue());
        }
        Boolean allowFileAccessFromFileURLs = webViewImpl.getAllowFileAccessFromFileURLs();
        if (allowFileAccessFromFileURLs != null) {
            bVar.setAllowFileAccessFromFileURLs(allowFileAccessFromFileURLs.booleanValue());
        }
        Boolean allowUniversalAccessFromFileURLs = webViewImpl.getAllowUniversalAccessFromFileURLs();
        if (allowUniversalAccessFromFileURLs != null) {
            bVar.setAllowUniversalAccessFromFileURLs(allowUniversalAccessFromFileURLs.booleanValue());
        }
        Boolean blockNetworkImage = webViewImpl.getBlockNetworkImage();
        if (blockNetworkImage != null) {
            bVar.setBlockNetworkImage(blockNetworkImage.booleanValue());
        }
        Integer defaultFontSize = webViewImpl.getDefaultFontSize();
        if (defaultFontSize != null) {
            bVar.setDefaultFontSize(defaultFontSize.intValue());
        }
        String defaultTextEncodingName = webViewImpl.getDefaultTextEncodingName();
        if (defaultTextEncodingName != null) {
            bVar.setDefaultTextEncodingName(defaultTextEncodingName);
        }
        Integer cacheMode = webViewImpl.getCacheMode();
        if (cacheMode != null) {
            bVar.setCacheMode(cacheMode.intValue());
        }
        Boolean displayZoomControls = webViewImpl.getDisplayZoomControls();
        if (displayZoomControls != null) {
            bVar.setDisplayZoomControls(displayZoomControls.booleanValue());
        }
        Boolean loadWithOverviewMod = webViewImpl.getLoadWithOverviewMod();
        if (loadWithOverviewMod != null) {
            bVar.setLoadWithOverviewMode(loadWithOverviewMod.booleanValue());
        }
        String userAgentString = webViewImpl.getUserAgentString();
        if (userAgentString != null) {
            bVar.setUserAgentString(userAgentString);
        }
        hc.d onTouchEventListener = webViewImpl.getOnTouchEventListener();
        if (onTouchEventListener != null) {
            bVar.setTouchEventListener(onTouchEventListener);
        }
        DownloadListener downloadListener = webViewImpl.getDownloadListener();
        if (downloadListener != null) {
            bVar.setDownloadListener(downloadListener);
        }
        WebChromeClient chromeClient = webViewImpl.getChromeClient();
        if (chromeClient != null) {
            bVar.setWebChromeClient(chromeClient);
        }
        com.bytedance.sdk.component.widget.hc client = webViewImpl.getClient();
        if (client != null) {
            bVar.setWebViewClient(client.d());
        }
        Map<String, d> javascriptInterfaces = webViewImpl.getJavascriptInterfaces();
        if (javascriptInterfaces != null) {
            for (String str : javascriptInterfaces.keySet()) {
                if (str != null && (dVar = javascriptInterfaces.get(str)) != null && (objD = dVar.d()) != null) {
                    bVar.addJavascriptInterface(objD, str);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.uo.d
    public b d() {
        if (u()) {
            return h();
        }
        final b[] bVarArr = new b[1];
        final Object obj = new Object();
        d(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.MultiWebview.4
            @Override // java.lang.Runnable
            public void run() {
                bVarArr[0] = MultiWebview.this.h();
                synchronized (obj) {
                    obj.notifyAll();
                }
            }
        });
        try {
            if (bVarArr[0] == null) {
                synchronized (obj) {
                    obj.wait(2500L);
                }
            }
        } catch (InterruptedException unused) {
        }
        return bVarArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b h() {
        if (this.gb.size() < 2) {
            this.hc = this.b;
            return null;
        }
        b bVarPollLast = this.gb.pollLast();
        if (bVarPollLast != null) {
            removeView(bVarPollLast.getView());
            bVarPollLast.destroy();
            this.tt.remove(bVarPollLast);
        }
        b last = this.gb.getLast();
        if (last != null) {
            last.setVisibility(0);
            last.onResume();
            this.hc = last;
        }
        return bVarPollLast;
    }

    public void destroy() {
        while (true) {
            b bVarPollLast = this.gb.pollLast();
            if (bVarPollLast != null) {
                bVarPollLast.destroy();
            } else {
                this.b = null;
                this.hc = null;
                this.tt.clear();
                this.h = null;
                return;
            }
        }
    }

    public b getCurrentWebView() {
        return this.hc;
    }

    public int getWebViewCount() {
        return this.gb.size();
    }

    @Override // com.bytedance.sdk.component.uo.d
    public void d(b bVar, String str, String str2, Object obj) {
        if (str2 == null || bVar == null) {
            return;
        }
        for (b bVar2 : this.tt.keySet()) {
            if (bVar2 != null && bVar != bVar2) {
                Set<String> set = this.tt.get(bVar2);
                if (set == null) {
                    return;
                }
                if (set.contains(str2)) {
                    bVar2.d(str, str2, obj);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.uo.d
    public void d(b bVar, String str) {
        if (bVar == null || str == null) {
            return;
        }
        Set<String> hashSet = this.tt.get(bVar);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.tt.put(bVar, hashSet);
        }
        hashSet.add(str);
    }

    @Override // com.bytedance.sdk.component.uo.d
    public void hc(b bVar, String str) {
        Set<String> set;
        if (bVar == null || str == null || (set = this.tt.get(bVar)) == null) {
            return;
        }
        set.remove(str);
    }

    public long getCreateDuration() {
        return this.an;
    }

    protected void d(Runnable runnable) {
        d(runnable, false);
    }

    protected void d(final Runnable runnable, boolean z) {
        if (u()) {
            runnable.run();
        } else if (z) {
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.MultiWebview.5
                @Override // java.lang.Runnable
                public void run() {
                    if (MultiWebview.this.u()) {
                        runnable.run();
                    } else {
                        gb.hc().post(runnable);
                    }
                }
            });
        } else {
            gb.hc().post(runnable);
        }
    }

    protected boolean u() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}

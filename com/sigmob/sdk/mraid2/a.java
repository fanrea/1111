package com.sigmob.sdk.mraid2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.n;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.views.ar;
import com.sigmob.sdk.nativead.APKStatusBroadcastReceiver;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class a extends FrameLayout {
    public static HashMap<String, com.sigmob.sdk.mraid.j> a = new LinkedHashMap();
    private static final String b = "BaseWebView2";
    private final Map<String, APKStatusBroadcastReceiver> c;
    private com.sigmob.sdk.base.views.g d;

    /* renamed from: com.sigmob.sdk.mraid2.a$a, reason: collision with other inner class name */
    private class C0743a {
        public C0743a() {
        }

        @JavascriptInterface
        public int cancelDownloadTaskByVid(String vid) {
            BaseAdUnit baseAdUnit;
            if (a.this.getAdUnitList() == null || a.this.getAdUnitList().isEmpty()) {
                baseAdUnit = null;
            } else {
                for (int i = 0; i < a.this.getAdUnitList().size(); i++) {
                    baseAdUnit = a.this.getAdUnitList().get(i);
                    if (baseAdUnit.getAd().vid.equals(vid)) {
                        break;
                    }
                }
                baseAdUnit = null;
            }
            Log.d(a.b, baseAdUnit + "-----------resumeDownloadByVid---------" + vid);
            Context context = a.this.getContext();
            if (context == null || baseAdUnit == null || baseAdUnit.getApkDownloadType() == 0) {
                return -1;
            }
            return com.sigmob.sdk.base.common.m.c(context, baseAdUnit);
        }

        @JavascriptInterface
        public int getApKDownloadProcessId(String vid) {
            BaseAdUnit baseAdUnit;
            if (a.this.getAdUnitList() == null || a.this.getAdUnitList().isEmpty()) {
                baseAdUnit = null;
            } else {
                for (int i = 0; i < a.this.getAdUnitList().size(); i++) {
                    baseAdUnit = a.this.getAdUnitList().get(i);
                    if (baseAdUnit.getAd().vid.equals(vid)) {
                        break;
                    }
                }
                baseAdUnit = null;
            }
            Log.d(a.b, baseAdUnit + "-----------getApKDownloadProcessId---------" + vid);
            if (baseAdUnit == null) {
                baseAdUnit = a.this.getAdUnitList().get(0);
            }
            Context context = a.this.getContext();
            if (context == null || baseAdUnit == null) {
                return -1;
            }
            long[] jArrA = baseAdUnit.getApkDownloadType() == 0 ? com.sigmob.sdk.base.common.o.a(context, baseAdUnit.getDownloadId()) : com.sigmob.sdk.base.common.m.d(context, baseAdUnit);
            int i2 = (int) jArrA[2];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 4) {
                        return i2 != 8 ? -1 : 100;
                    }
                    return -2;
                }
                long j = jArrA[0];
                long j2 = jArrA[1];
                if (j2 != 0 && j != 0) {
                    return (int) ((j * 100) / j2);
                }
            }
            return 0;
        }

        @JavascriptInterface
        public int pauseDownloadByVid(String vid) {
            BaseAdUnit baseAdUnit;
            if (a.this.getAdUnitList() == null || a.this.getAdUnitList().isEmpty()) {
                baseAdUnit = null;
            } else {
                for (int i = 0; i < a.this.getAdUnitList().size(); i++) {
                    baseAdUnit = a.this.getAdUnitList().get(i);
                    if (baseAdUnit.getAd().vid.equals(vid)) {
                        break;
                    }
                }
                baseAdUnit = null;
            }
            Log.d(a.b, baseAdUnit + "-----------PauseDownloadByVid---------" + vid);
            if (a.this.getContext() == null || baseAdUnit == null || baseAdUnit.getApkDownloadType() == 0) {
                return -1;
            }
            return com.sigmob.sdk.base.common.m.a(a.this.getContext(), baseAdUnit);
        }

        @JavascriptInterface
        public void registerDownloadEvent(String vid) {
            BaseAdUnit baseAdUnit;
            if (a.this.getAdUnitList() == null || a.this.getAdUnitList().isEmpty()) {
                baseAdUnit = null;
            } else {
                for (int i = 0; i < a.this.getAdUnitList().size(); i++) {
                    baseAdUnit = a.this.getAdUnitList().get(i);
                    if (baseAdUnit.getAd().vid.equals(vid)) {
                        break;
                    }
                }
                baseAdUnit = null;
            }
            Log.d(a.b, baseAdUnit + "-----------registerDownloadEvent---------" + vid);
            if (baseAdUnit == null) {
                baseAdUnit = a.this.getAdUnitList().get(0);
            }
            a.this.a(baseAdUnit);
        }

        @JavascriptInterface
        public int resumeDownloadByVid(String vid) {
            BaseAdUnit baseAdUnit;
            if (a.this.getAdUnitList() == null || a.this.getAdUnitList().isEmpty()) {
                baseAdUnit = null;
            } else {
                for (int i = 0; i < a.this.getAdUnitList().size(); i++) {
                    baseAdUnit = a.this.getAdUnitList().get(i);
                    if (baseAdUnit.getAd().vid.equals(vid)) {
                        break;
                    }
                }
                baseAdUnit = null;
            }
            Log.d(a.b, baseAdUnit + "-----------resumeDownloadByVid---------" + vid);
            Context context = a.this.getContext();
            if (context == null || baseAdUnit == null || baseAdUnit.getApkDownloadType() == 0) {
                return -1;
            }
            return com.sigmob.sdk.base.common.m.b(context, baseAdUnit);
        }
    }

    public a(Context context) {
        super(context);
        this.c = new HashMap();
        com.sigmob.sdk.base.views.g gVarA = ar.a().a(context);
        this.d = gVarA;
        if (gVarA == null) {
            this.d = new com.sigmob.sdk.base.views.g(context);
        }
        this.d.addJavascriptInterface(new C0743a(), "sigandroidapk");
        addView(this.d, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str) {
        a("mraidbridge.notifyApkDownloadStateEvent(\"" + str + "\");", (ValueCallback) null);
    }

    public void a() {
        Map<String, APKStatusBroadcastReceiver> map = this.c;
        if (map != null && !map.isEmpty()) {
            for (APKStatusBroadcastReceiver aPKStatusBroadcastReceiver : this.c.values()) {
                aPKStatusBroadcastReceiver.b(aPKStatusBroadcastReceiver);
            }
            this.c.clear();
        }
        HashMap<String, com.sigmob.sdk.mraid.j> map2 = a;
        if (map2 != null && !map2.isEmpty()) {
            for (com.sigmob.sdk.mraid.j jVar : a.values()) {
                if (jVar != null) {
                    jVar.c();
                }
            }
            a.clear();
        }
        if (this.d != null) {
            ar.a().a(this.d);
            this.d = null;
        }
        removeAllViews();
    }

    public void a(BaseAdUnit adUnit) {
        if (adUnit != null && this.c.get(adUnit.getUuid()) == null) {
            APKStatusBroadcastReceiver aPKStatusBroadcastReceiver = new APKStatusBroadcastReceiver(new n.a() { // from class: com.sigmob.sdk.mraid2.a.1
                @Override // com.sigmob.sdk.base.common.n.a
                public void a(boolean result) {
                    if (result) {
                        a.this.f();
                    } else {
                        a.this.c();
                    }
                }

                @Override // com.sigmob.sdk.base.common.n.a
                public void a(boolean result, long downloadId) {
                    if (result) {
                        a.this.b();
                    } else {
                        a.this.c();
                    }
                }

                @Override // com.sigmob.sdk.base.common.n.a
                public void b(boolean result) {
                    if (result) {
                        a.this.g();
                    } else {
                        a.this.c();
                    }
                }

                @Override // com.sigmob.sdk.base.common.n.a
                public void b(boolean result, long downloadId) {
                    if (result) {
                        a.this.e();
                    } else {
                        a.this.c();
                    }
                }

                @Override // com.sigmob.sdk.base.common.n.a
                public void c(boolean result, long downloadId) {
                    a.this.d();
                }
            }, adUnit.getUuid());
            aPKStatusBroadcastReceiver.a(aPKStatusBroadcastReceiver);
            this.c.put(adUnit.getUuid(), aPKStatusBroadcastReceiver);
        }
    }

    void a(Object object, String name) {
        this.d.addJavascriptInterface(object, name);
    }

    public void a(String url) {
        this.d.loadUrl(url);
    }

    void a(String javascript, ValueCallback callback) {
        if (this.d == null) {
            return;
        }
        SigmobLog.d("Injecting Javascript into MRAID WebView:\n\t" + javascript);
        if (Build.VERSION.SDK_INT >= 19) {
            this.d.evaluateJavascript(javascript, callback);
        } else {
            a("javascript:" + javascript);
        }
    }

    void a(String s, String htmlData, String s1, String s2, String o) {
        com.sigmob.sdk.base.views.g gVar = this.d;
        if (gVar == null) {
            return;
        }
        gVar.loadDataWithBaseURL(s, htmlData, s1, s2, o);
    }

    void a(boolean b2) {
        com.sigmob.sdk.base.views.g gVar = this.d;
        if (gVar == null) {
            return;
        }
        gVar.a(b2);
    }

    void b() {
        b("download_start");
    }

    void b(final String state) {
        post(new Runnable() { // from class: com.sigmob.sdk.mraid2.a$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(state);
            }
        });
    }

    public void b(String javascript, ValueCallback callback) {
        com.sigmob.sdk.base.views.g gVar;
        if (Build.VERSION.SDK_INT < 19 || (gVar = this.d) == null) {
            return;
        }
        gVar.evaluateJavascript(javascript, callback);
    }

    void c() {
        b("download_fail");
    }

    void d() {
        b("download_pause");
    }

    void e() {
        b(PointCategory.DOWNLOAD_END);
    }

    void f() {
        b(com.sigmob.sdk.base.common.a.I);
    }

    void g() {
        b("install_end");
    }

    abstract List<BaseAdUnit> getAdUnitList();

    WebSettings getSettings() {
        return this.d.getSettings();
    }

    public void h() {
        com.sigmob.sdk.base.views.g gVar = this.d;
        if (gVar == null) {
            return;
        }
        gVar.reload();
    }

    public void i() {
        com.sigmob.sdk.base.views.g gVar = this.d;
        if (gVar == null) {
            return;
        }
        gVar.stopLoading();
    }

    public void j() {
        this.d.resumeTimers();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public void setBackground(Drawable background) {
        super.setBackground(background);
        if (Build.VERSION.SDK_INT >= 16) {
            this.d.setBackground(background);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int color) {
        super.setBackgroundColor(color);
        this.d.setBackgroundColor(color);
    }

    void setWebChromeClient(WebChromeClient webChromeClient) {
        com.sigmob.sdk.base.views.g gVar = this.d;
        if (gVar == null) {
            return;
        }
        gVar.setWebChromeClient(webChromeClient);
    }

    void setWebViewClient(WebViewClient webViewClient) {
        com.sigmob.sdk.base.views.g gVar = this.d;
        if (gVar == null) {
            return;
        }
        gVar.setWebViewClient(webViewClient);
    }
}

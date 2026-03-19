package com.baidu.mobstat.forbes;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.mobstat.forbes.ActivityLifeObserver;
import com.baidu.mobstat.forbes.BaiduStatJSInterface;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b {
    private static volatile boolean a = true;
    private static volatile boolean b = false;

    public static boolean a() {
        return b;
    }

    public static void a(String str) {
        b = true;
        g.a().a(str);
    }

    public static void a(boolean z) {
        g.a().a(z);
    }

    public static boolean b() {
        return a;
    }

    public static class a implements ActivityLifeObserver.IActivityLifeCallback {
        @Override // com.baidu.mobstat.forbes.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (w.c().b()) {
                w.c().a("onActivityCreated");
            }
            g.a().a(activity);
        }

        @Override // com.baidu.mobstat.forbes.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityStarted(Activity activity) {
        }

        @Override // com.baidu.mobstat.forbes.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityResumed(Activity activity) {
            if (w.c().b()) {
                w.c().a("onActivityResumed");
            }
            g.a().b(activity);
        }

        @Override // com.baidu.mobstat.forbes.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityPaused(Activity activity) {
            if (w.c().b()) {
                w.c().a("onActivityPaused");
            }
            g.a().c(activity);
        }

        @Override // com.baidu.mobstat.forbes.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityStopped(Activity activity) {
        }

        @Override // com.baidu.mobstat.forbes.ActivityLifeObserver.IActivityLifeCallback
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // com.baidu.mobstat.forbes.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityDestroyed(Activity activity) {
        }
    }

    /* renamed from: com.baidu.mobstat.forbes.b$b, reason: collision with other inner class name */
    public static class C0148b implements BaiduStatJSInterface.IWebviewPageLoadCallback {
        @Override // com.baidu.mobstat.forbes.BaiduStatJSInterface.IWebviewPageLoadCallback
        public void onPageStarted(WebView webView, String str, ag agVar) {
            if (w.c().b()) {
                w.c().a("WebView onPageStarted");
            }
            webView.addJavascriptInterface(agVar, "WebViewInterface");
        }

        @Override // com.baidu.mobstat.forbes.BaiduStatJSInterface.IWebviewPageLoadCallback
        public void onPageFinished(WebView webView, String str, ag agVar) throws JSONException {
            if (w.c().b()) {
                w.c().a("WebView onPageFinished");
            }
            webView.addJavascriptInterface(agVar, "WebViewInterface");
            g.a().a(webView, str, agVar);
        }
    }
}

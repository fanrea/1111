package com.baidu.mobstat.forbes;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.baidu.mobstat.forbes.ActivityLifeObserver;
import com.baidu.mobstat.forbes.BaiduStatJSInterface;
import com.baidu.mobstat.forbes.MtjConfig;
import com.bytedance.applog.aggregation.MetricsSQLiteCacheKt;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class p {
    public static void a(String str) {
        if (!com.baidu.mobstat.forbes.b.a() || r.a().b()) {
            return;
        }
        t.a().a(str);
    }

    public static void a(MtjConfig.FeedTrackStrategy feedTrackStrategy) {
        if (r.a().b()) {
            return;
        }
        l.a(feedTrackStrategy);
    }

    public static void a(JSONObject jSONObject) {
        if (!com.baidu.mobstat.forbes.b.a() || r.a().b()) {
            return;
        }
        q.a().a(jSONObject);
    }

    public static void a(Context context) throws JSONException {
        if (!com.baidu.mobstat.forbes.b.a() || r.a().b()) {
            return;
        }
        q.a().a(context);
    }

    public static void a(Context context, boolean z) {
        if (!com.baidu.mobstat.forbes.b.a() || r.a().b()) {
            return;
        }
        q.a().a(context, z);
    }

    public static class a implements ActivityLifeObserver.IActivityLifeCallback {
        HashMap<String, JSONObject> a = new HashMap<>();
        Map<String, Long> b = new ConcurrentHashMap();
        Map<String, Long> c = new ConcurrentHashMap();
        Map<String, String> d = new ConcurrentHashMap();
        Map<String, View.OnLayoutChangeListener> e = new ConcurrentHashMap();
        Map<String, String> f = new ConcurrentHashMap();

        @Override // com.baidu.mobstat.forbes.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityCreated(Activity activity, Bundle bundle) {
            try {
                if (ae.d(activity)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("name", activity.getLocalClassName());
                    if (TextUtils.equals(ae.a(), activity.getLocalClassName()) || TextUtils.equals(ae.b(), activity.getLocalClassName())) {
                        try {
                            jSONObject.put("type", ae.a((Object) activity));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    jSONObject.put(MetricsSQLiteCacheKt.METRICS_START_TIME, System.currentTimeMillis() + "");
                    this.a.put(activity.getLocalClassName(), jSONObject);
                    final String localClassName = activity.getLocalClassName();
                    if (Build.VERSION.SDK_INT >= 11) {
                        try {
                            if (ae.e(activity)) {
                                View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.baidu.mobstat.forbes.p.a.1
                                    int a;

                                    @Override // android.view.View.OnLayoutChangeListener
                                    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                                        try {
                                            Rect rect = new Rect();
                                            if (view == null) {
                                                return;
                                            }
                                            view.getWindowVisibleDisplayFrame(rect);
                                            if (rect.bottom != this.a && this.a != 0) {
                                                if (this.a - rect.bottom > 200 && i7 == i3) {
                                                    a.this.f.put(localClassName, "true");
                                                }
                                                this.a = rect.bottom;
                                                return;
                                            }
                                            this.a = rect.bottom;
                                        } catch (Throwable th) {
                                            th.printStackTrace();
                                        }
                                    }
                                };
                                this.e.put(localClassName, onLayoutChangeListener);
                                this.f.put(localClassName, "false");
                                activity.getWindow().getDecorView().addOnLayoutChangeListener(onLayoutChangeListener);
                            }
                        } catch (Throwable th) {
                        }
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }

        @Override // com.baidu.mobstat.forbes.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityStarted(Activity activity) {
        }

        @Override // com.baidu.mobstat.forbes.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityResumed(Activity activity) {
            String str;
            if (!com.baidu.mobstat.forbes.b.a() || r.a().b()) {
                return;
            }
            if (aa.c().b()) {
                aa.c().a("onActivityResumed");
            }
            t.a().a(activity);
            if (ae.d(activity)) {
                try {
                    this.b.put(activity.getLocalClassName(), Long.valueOf(System.currentTimeMillis()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    if (TextUtils.isEmpty(this.d.get(activity.getLocalClassName())) && CooperService.instance().getActivityContentSwitch() == 1) {
                        try {
                            JSONObject jSONObjectJ = ae.j(activity.getWindow().getDecorView());
                            str = jSONObjectJ.optString("content", "") + "|" + jSONObjectJ.optString("webview", "");
                        } catch (Throwable th) {
                            str = "";
                        }
                        ae.b("mtj_exposure", str + "");
                        if (TextUtils.isEmpty(str)) {
                            str = "***";
                        }
                        this.d.put(activity.getLocalClassName(), str);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }

        @Override // com.baidu.mobstat.forbes.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityPaused(Activity activity) {
            if (!com.baidu.mobstat.forbes.b.a() || r.a().b()) {
                return;
            }
            if (aa.c().b()) {
                aa.c().a("onActivityPaused");
            }
            t.a().b(activity);
            try {
                if (ae.d(activity)) {
                    Long l = this.b.get(activity.getLocalClassName());
                    if (l == null) {
                        l = 0L;
                    }
                    Long lValueOf = Long.valueOf(System.currentTimeMillis() - l.longValue());
                    Long l2 = this.c.get(activity.getLocalClassName());
                    if (l2 == null) {
                        l2 = 0L;
                    }
                    this.c.put(activity.getLocalClassName(), Long.valueOf(l2.longValue() + lValueOf.longValue()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.baidu.mobstat.forbes.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityStopped(Activity activity) {
        }

        @Override // com.baidu.mobstat.forbes.ActivityLifeObserver.IActivityLifeCallback
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // com.baidu.mobstat.forbes.ActivityLifeObserver.IActivityLifeCallback
        public void onActivityDestroyed(Activity activity) {
            JSONObject jSONObject;
            String strSubstring = "";
            try {
                if (ae.d(activity) && (jSONObject = this.a.get(activity.getLocalClassName())) != null) {
                    jSONObject.put(MetricsSQLiteCacheKt.METRICS_END_TIME, System.currentTimeMillis() + "");
                    jSONObject.put("live_time", this.c.get(activity.getLocalClassName()) + "");
                    jSONObject.put("activity_content", this.d.get(activity.getLocalClassName()));
                    String str = this.d.get(activity.getLocalClassName());
                    if (str != null) {
                        try {
                            if (str.contains(com.alipay.sdk.m.l.a.r)) {
                                strSubstring = str.substring(str.indexOf(com.alipay.sdk.m.l.a.r));
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    jSONObject.put("activity_content_url", strSubstring);
                    if (ae.e(activity)) {
                        jSONObject.put("Keyboard_string", this.f.get(activity.getLocalClassName()));
                        this.f.remove(activity.getLocalClassName());
                    }
                    q.a().b(jSONObject);
                    this.a.remove(activity.getLocalClassName());
                    this.c.remove(activity.getLocalClassName());
                    this.b.remove(activity.getLocalClassName());
                    this.d.remove(activity.getLocalClassName());
                    try {
                        if (ae.e(activity) && Build.VERSION.SDK_INT >= 11 && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
                            activity.getWindow().getDecorView().removeOnLayoutChangeListener(this.e.get(activity.getLocalClassName()));
                            this.e.remove(activity.getLocalClassName());
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
    }

    public static class b implements BaiduStatJSInterface.IWebviewPageLoadCallback {
        @Override // com.baidu.mobstat.forbes.BaiduStatJSInterface.IWebviewPageLoadCallback
        public void onPageStarted(WebView webView, String str, ag agVar) {
            if (!com.baidu.mobstat.forbes.b.a() || r.a().b()) {
                return;
            }
            if (aa.c().b()) {
                aa.c().a("WebView onPageStarted");
            }
            webView.addJavascriptInterface(agVar, "WebViewInterface");
        }

        @Override // com.baidu.mobstat.forbes.BaiduStatJSInterface.IWebviewPageLoadCallback
        public void onPageFinished(WebView webView, String str, ag agVar) {
            if (!com.baidu.mobstat.forbes.b.a() || r.a().b()) {
                return;
            }
            if (aa.c().b()) {
                aa.c().a("WebView onPageFinished");
            }
            webView.addJavascriptInterface(agVar, "WebViewInterface");
            t.a().a(webView, str, agVar);
        }
    }
}

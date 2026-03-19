package com.baidu.mobstat.forbes;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ag {
    private static String a;
    private WeakReference<WebView> b;
    private WeakReference<Activity> c;
    private JSONObject d;
    private boolean e;
    private boolean f;

    public void a(WebView webView, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        webView.loadUrl("javascript:" + str);
    }

    @JavascriptInterface
    public void setViewportTreeToNative(String str) {
        if (w.c().b()) {
            w.c().a("setViewportTreeToNative " + str);
        }
        a = str;
    }

    public void a(Activity activity, WebView webView, String str, JSONObject jSONObject, boolean z) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (z) {
            this.f = z;
            this.d = jSONObject;
        }
        if (z) {
            w.c().a("injectTrackJs circleConfig: " + jSONObject);
        }
        if (a(webView, z)) {
            if (z) {
                w.c().a("injectTrackJs, no need to entry");
                return;
            } else {
                aa.c().a("injectTrackJs, no need to entry");
                return;
            }
        }
        if (activity != null) {
            this.c = new WeakReference<>(activity);
        }
        if (webView != null) {
            this.b = new WeakReference<>(webView);
        }
        this.e = z;
        String strA = a();
        if (TextUtils.isEmpty(strA)) {
            strA = new JSONObject().toString();
        }
        if (w.c().b() && this.f) {
            w.c().a("injectTrackJs h5Config: " + strA);
        }
        if (aa.c().b()) {
            aa.c().a("injectTrackJs h5Config: " + strA);
        }
        String str2 = "(function(){var h5conf = {\"sdkAPI\": \"window.WebViewInterface.setEventToNative\", \"sdkType\": \"android\", \"events\": " + strA + "};" + str + "})()";
        if (webView != null) {
            webView.loadUrl("javascript:" + str2);
        }
    }

    private boolean a(WebView webView, boolean z) {
        if (this.b != null && this.b.get() == webView && this.e != z) {
            return true;
        }
        return false;
    }

    private String a() throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("matchAll", 1);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("meta", jSONObject);
            return jSONObject2.toString();
        } catch (Exception e) {
            return new JSONObject().toString();
        }
    }

    @JavascriptInterface
    public void setEventToNative(String str) throws JSONException, Resources.NotFoundException {
        Activity activity;
        WebView webView;
        if (w.c().b() && this.f) {
            w.c().a("setEventToNative: " + str);
        }
        if (aa.c().b()) {
            aa.c().a("setEventToNative: " + str);
        }
        if (this.c == null || (activity = this.c.get()) == null || this.b == null || (webView = this.b.get()) == null) {
            return;
        }
        a(str, activity, webView);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.String r37, android.app.Activity r38, android.webkit.WebView r39) throws org.json.JSONException, android.content.res.Resources.NotFoundException {
        /*
            r36 = this;
            r7 = r36
            r1 = 0
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Exception -> L36
            r2 = r37
            r0.<init>(r2)     // Catch: java.lang.Exception -> L36
            java.lang.String r2 = "h3"
            org.json.JSONArray r2 = r0.optJSONArray(r2)     // Catch: java.lang.Exception -> L36
            java.lang.String r3 = "p2"
            java.lang.String r3 = r0.optString(r3)     // Catch: java.lang.Exception -> L33
            java.lang.String r4 = "l"
            java.lang.String r4 = r0.optString(r4)     // Catch: java.lang.Exception -> L30
            java.lang.String r5 = "point"
            org.json.JSONObject r1 = r0.optJSONObject(r5)     // Catch: java.lang.Exception -> L2e
            r0 = 1
            r23 = r1
            r28 = r2
            r27 = r4
            goto L41
        L2e:
            r0 = move-exception
            goto L3a
        L30:
            r0 = move-exception
            r4 = r1
            goto L3a
        L33:
            r0 = move-exception
            r3 = r1
            goto L39
        L36:
            r0 = move-exception
            r2 = r1
            r3 = r2
        L39:
            r4 = r3
        L3a:
            r0 = 0
            r23 = r1
            r28 = r2
            r27 = r4
        L41:
            if (r0 != 0) goto L44
            return
        L44:
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 == 0) goto L4d
            java.lang.String r0 = "/"
            goto L4e
        L4d:
            r0 = r3
        L4e:
            org.json.JSONArray r29 = com.baidu.mobstat.forbes.ae.a(r38, r39)
            java.lang.Class r1 = r38.getClass()
            java.lang.String r30 = r1.getName()
            java.lang.String r5 = com.baidu.mobstat.forbes.ae.a(r29)
            java.lang.String r6 = com.baidu.mobstat.forbes.ae.b(r28)
            java.lang.String r31 = com.baidu.mobstat.forbes.ae.f(r39)
            java.util.Map r32 = com.baidu.mobstat.forbes.ae.g(r39)
            android.content.Context r33 = r38.getApplicationContext()
            long r34 = java.lang.System.currentTimeMillis()
            org.json.JSONObject r2 = r7.d
            java.lang.Class r1 = r38.getClass()
            java.lang.String r3 = r1.getName()
            r1 = r36
            r4 = r0
            boolean r1 = r1.a(r2, r3, r4, r5, r6)
            java.lang.String r2 = ""
            if (r1 == 0) goto Laa
            com.baidu.mobstat.forbes.BDStatCore r8 = com.baidu.mobstat.forbes.BDStatCore.instance()
            long r13 = java.lang.System.currentTimeMillis()
            r21 = 1
            r12 = 1
            r9 = r33
            r10 = r2
            r11 = r27
            r15 = r29
            r16 = r28
            r17 = r30
            r18 = r0
            r19 = r31
            r20 = r32
            r8.onEvent(r9, r10, r11, r12, r13, r15, r16, r17, r18, r19, r20, r21)
            goto Lc1
        Laa:
            com.baidu.mobstat.forbes.w r1 = com.baidu.mobstat.forbes.w.c()
            boolean r1 = r1.b()
            if (r1 == 0) goto Lc1
            boolean r1 = r7.f
            if (r1 == 0) goto Lc1
            com.baidu.mobstat.forbes.w r1 = com.baidu.mobstat.forbes.w.c()
            java.lang.String r3 = "setEventToNative: not circle event, will not take effect"
            r1.a(r3)
        Lc1:
            com.baidu.mobstat.forbes.q r8 = com.baidu.mobstat.forbes.q.a()
            r25 = 0
            r26 = 0
            java.lang.String r12 = ""
            r13 = 1
            r22 = 1
            java.lang.String r24 = ""
            r9 = r33
            r10 = r2
            r11 = r27
            r14 = r34
            r16 = r30
            r17 = r29
            r18 = r0
            r19 = r28
            r20 = r31
            r21 = r32
            r8.a(r9, r10, r11, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.forbes.ag.a(java.lang.String, android.app.Activity, android.webkit.WebView):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean a(JSONObject jSONObject, String str, String str2, String str3, String str4) {
        int i = 0;
        if (jSONObject == null || jSONObject.toString().equals(new JSONObject().toString()) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            return false;
        }
        try {
            if (((JSONObject) jSONObject.get("meta")).getInt("matchAll") != 0) {
                return true;
            }
        } catch (Exception e) {
        }
        try {
            JSONArray jSONArray = (JSONArray) jSONObject.get("data");
            boolean z = false;
            while (i < jSONArray.length()) {
                try {
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                    String strOptString = jSONObject2.optString("page");
                    String strOptString2 = jSONObject2.optString("layout");
                    String str5 = (String) jSONObject2.opt("url");
                    String str6 = (String) jSONObject2.opt("webLayout");
                    if (str.equals(strOptString) && str2.equals(str5) && str3.equals(strOptString2) && str4.equals(str6)) {
                        z = true;
                    }
                    i++;
                } catch (Exception e2) {
                    i = z ? 1 : 0;
                    return i;
                }
            }
            return z;
        } catch (Exception e3) {
        }
    }
}

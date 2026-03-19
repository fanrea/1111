package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.app.PayResultActivity;
import com.alipay.sdk.m.m.a;
import com.alipay.sdk.m.q.f;
import com.alipay.sdk.m.s.a;
import com.alipay.sdk.m.u.e;
import com.alipay.sdk.m.u.h;
import com.alipay.sdk.m.u.i;
import com.alipay.sdk.m.u.l;
import com.alipay.sdk.m.u.n;
import com.alipay.sdk.util.H5PayResultModel;
import com.baidu.mobads.container.adrequest.g;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class PayTask {
    public static final Object h = h.class;
    public static long i;
    public Activity a;
    public com.alipay.sdk.m.x.a b;
    public final String c = "wappaygw.alipay.com/service/rest.htm";
    public final String d = "mclient.alipay.com/service/rest.htm";
    public final String e = "mclient.alipay.com/home/exterfaceAssign.htm";
    public final String f = "mclient.alipay.com/cashier/mobilepay.htm";
    public Map<String, c> g = new HashMap();

    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ H5PayCallback c;

        public a(String str, boolean z, H5PayCallback h5PayCallback) {
            this.a = str;
            this.b = z;
            this.c = h5PayCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            H5PayResultModel h5PayResultModelH5Pay = PayTask.this.h5Pay(new com.alipay.sdk.m.s.a(PayTask.this.a, this.a, "payInterceptorWithUrl"), this.a, this.b);
            e.d(com.alipay.sdk.m.l.a.A, "inc finished: " + h5PayResultModelH5Pay.getResultCode());
            this.c.onPayResult(h5PayResultModelH5Pay);
        }
    }

    public class b implements h.f {
        public b() {
        }

        @Override // com.alipay.sdk.m.u.h.f
        public void a() {
            PayTask.this.dismissLoading();
        }

        @Override // com.alipay.sdk.m.u.h.f
        public void b() {
        }
    }

    public class c {
        public String a;
        public String b;
        public String c;
        public String d;

        public c() {
            this.a = "";
            this.b = "";
            this.c = "";
            this.d = "";
        }

        public String a() {
            return this.c;
        }

        public String b() {
            return this.a;
        }

        public String c() {
            return this.b;
        }

        public String d() {
            return this.d;
        }

        public void a(String str) {
            this.c = str;
        }

        public void b(String str) {
            this.a = str;
        }

        public void c(String str) {
            this.b = str;
        }

        public void d(String str) {
            this.d = str;
        }

        public /* synthetic */ c(PayTask payTask, a aVar) {
            this();
        }
    }

    public PayTask(Activity activity) {
        this.a = activity;
        com.alipay.sdk.m.s.b.d().a(this.a);
        this.b = new com.alipay.sdk.m.x.a(activity, com.alipay.sdk.m.x.a.j);
    }

    public static synchronized boolean fetchSdkConfig(Context context) {
        try {
            com.alipay.sdk.m.s.b.d().a(context);
            long jElapsedRealtime = SystemClock.elapsedRealtime() / 1000;
            if (jElapsedRealtime - i < com.alipay.sdk.m.m.a.z().d()) {
                return false;
            }
            i = jElapsedRealtime;
            com.alipay.sdk.m.m.a.z().a(com.alipay.sdk.m.s.a.h(), context.getApplicationContext(), false, 4);
            return true;
        } catch (Exception e) {
            e.a(e);
            return false;
        }
    }

    public void dismissLoading() {
        com.alipay.sdk.m.x.a aVar = this.b;
        if (aVar != null) {
            aVar.a();
            this.b = null;
        }
    }

    public synchronized String fetchOrderInfoFromH5PayUrl(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String strTrim = str.trim();
                if (strTrim.startsWith("https://wappaygw.alipay.com/service/rest.htm") || strTrim.startsWith("http://wappaygw.alipay.com/service/rest.htm")) {
                    String strTrim2 = strTrim.replaceFirst("(http|https)://wappaygw.alipay.com/service/rest.htm\\?", "").trim();
                    if (!TextUtils.isEmpty(strTrim2)) {
                        return "_input_charset=\"utf-8\"&ordertoken=\"" + n.a("<request_token>", "</request_token>", n.b(strTrim2).get("req_data")) + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + a(this.a) + "\"";
                    }
                }
                if (strTrim.startsWith("https://mclient.alipay.com/service/rest.htm") || strTrim.startsWith("http://mclient.alipay.com/service/rest.htm")) {
                    String strTrim3 = strTrim.replaceFirst("(http|https)://mclient.alipay.com/service/rest.htm\\?", "").trim();
                    if (!TextUtils.isEmpty(strTrim3)) {
                        return "_input_charset=\"utf-8\"&ordertoken=\"" + n.a("<request_token>", "</request_token>", n.b(strTrim3).get("req_data")) + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + a(this.a) + "\"";
                    }
                }
                if ((strTrim.startsWith("https://mclient.alipay.com/home/exterfaceAssign.htm") || strTrim.startsWith("http://mclient.alipay.com/home/exterfaceAssign.htm")) && ((strTrim.contains("alipay.wap.create.direct.pay.by.user") || strTrim.contains("create_forex_trade_wap")) && !TextUtils.isEmpty(strTrim.replaceFirst("(http|https)://mclient.alipay.com/home/exterfaceAssign.htm\\?", "").trim()))) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", str);
                    jSONObject.put("bizcontext", a(this.a));
                    return com.alipay.sdk.m.s.a.C + jSONObject.toString();
                }
                a aVar = null;
                if (Pattern.compile("^(http|https)://(maliprod\\.alipay\\.com/w/trade_pay\\.do.?|mali\\.alipay\\.com/w/trade_pay\\.do.?|mclient\\.alipay\\.com/w/trade_pay\\.do.?)").matcher(str).find()) {
                    String strA = n.a("?", "", str);
                    if (!TextUtils.isEmpty(strA)) {
                        Map<String, String> mapB = n.b(strA);
                        StringBuilder sb = new StringBuilder();
                        if (a(false, true, com.alipay.sdk.m.k.b.B0, sb, mapB, com.alipay.sdk.m.k.b.B0, "alipay_trade_no")) {
                            a(true, false, "pay_phase_id", sb, mapB, "payPhaseId", "pay_phase_id", "out_relation_id");
                            sb.append("&biz_sub_type=\"TRADE\"");
                            sb.append("&biz_type=\"trade\"");
                            String str2 = mapB.get("app_name");
                            if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(mapB.get(g.s))) {
                                str2 = "ali1688";
                            } else if (TextUtils.isEmpty(str2) && (!TextUtils.isEmpty(mapB.get(com.baidu.mobads.container.components.h.b.e.a)) || !TextUtils.isEmpty(mapB.get("s_id")))) {
                                str2 = "tb";
                            }
                            sb.append("&app_name=\"" + str2 + "\"");
                            if (!a(true, true, "extern_token", sb, mapB, "extern_token", g.s, com.baidu.mobads.container.components.h.b.e.a, "s_id")) {
                                return "";
                            }
                            a(true, false, "appenv", sb, mapB, "appenv");
                            sb.append("&pay_channel_id=\"alipay_sdk\"");
                            c cVar = new c(this, aVar);
                            cVar.b(mapB.get("return_url"));
                            cVar.c(mapB.get("show_url"));
                            cVar.a(mapB.get("pay_order_id"));
                            String str3 = sb.toString() + "&bizcontext=\"" + a(this.a) + "\"";
                            this.g.put(str3, cVar);
                            return str3;
                        }
                    }
                }
                if (!strTrim.startsWith("https://mclient.alipay.com/cashier/mobilepay.htm") && !strTrim.startsWith("http://mclient.alipay.com/cashier/mobilepay.htm") && (!EnvUtils.isSandBox() || !strTrim.contains("mobileclientgw.alipaydev.com/cashier/mobilepay.htm"))) {
                    if (com.alipay.sdk.m.m.a.z().g() && Pattern.compile("^https?://(maliprod\\.alipay\\.com|mali\\.alipay\\.com)/batch_payment\\.do\\?").matcher(strTrim).find()) {
                        Uri uri = Uri.parse(strTrim);
                        String queryParameter = uri.getQueryParameter("return_url");
                        String queryParameter2 = uri.getQueryParameter("show_url");
                        String queryParameter3 = uri.getQueryParameter("pay_order_id");
                        String strA2 = a(uri.getQueryParameter("trade_nos"), uri.getQueryParameter("alipay_trade_no"));
                        String strA3 = a(uri.getQueryParameter("payPhaseId"), uri.getQueryParameter("pay_phase_id"), uri.getQueryParameter("out_relation_id"));
                        String[] strArr = new String[4];
                        strArr[0] = uri.getQueryParameter("app_name");
                        strArr[1] = !TextUtils.isEmpty(uri.getQueryParameter(g.s)) ? "ali1688" : "";
                        strArr[2] = !TextUtils.isEmpty(uri.getQueryParameter(com.baidu.mobads.container.components.h.b.e.a)) ? "tb" : "";
                        strArr[3] = !TextUtils.isEmpty(uri.getQueryParameter("s_id")) ? "tb" : "";
                        String strA4 = a(strArr);
                        String strA5 = a(uri.getQueryParameter("extern_token"), uri.getQueryParameter(g.s), uri.getQueryParameter(com.baidu.mobads.container.components.h.b.e.a), uri.getQueryParameter("s_id"));
                        String strA6 = a(uri.getQueryParameter("appenv"));
                        if (!TextUtils.isEmpty(strA2) && !TextUtils.isEmpty(strA4) && !TextUtils.isEmpty(strA5)) {
                            String str4 = String.format("trade_no=\"%s\"&pay_phase_id=\"%s\"&biz_type=\"trade\"&biz_sub_type=\"TRADE\"&app_name=\"%s\"&extern_token=\"%s\"&appenv=\"%s\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"%s\"", strA2, strA3, strA4, strA5, strA6, a(this.a));
                            c cVar2 = new c(this, null);
                            cVar2.b(queryParameter);
                            cVar2.c(queryParameter2);
                            cVar2.a(queryParameter3);
                            cVar2.d(strA2);
                            this.g.put(str4, cVar2);
                            return str4;
                        }
                    }
                }
                String strA7 = a(this.a);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("url", strTrim);
                jSONObject2.put("bizcontext", strA7);
                return String.format("new_external_info==%s", jSONObject2.toString());
            }
        } catch (Throwable th) {
            e.a(th);
        }
        return "";
    }

    public synchronized String fetchTradeToken() {
        return i.a(new com.alipay.sdk.m.s.a(this.a, "", "fetchTradeToken"), this.a.getApplicationContext());
    }

    public String getVersion() {
        return "15.8.17";
    }

    public synchronized H5PayResultModel h5Pay(com.alipay.sdk.m.s.a aVar, String str, boolean z) {
        H5PayResultModel h5PayResultModel;
        h5PayResultModel = new H5PayResultModel();
        try {
            String[] strArrSplit = a(aVar, str, z).split(i.b);
            HashMap map = new HashMap();
            for (String str2 : strArrSplit) {
                int iIndexOf = str2.indexOf("={");
                if (iIndexOf >= 0) {
                    String strSubstring = str2.substring(0, iIndexOf);
                    map.put(strSubstring, a(str2, strSubstring));
                }
            }
            if (map.containsKey(l.a)) {
                h5PayResultModel.setResultCode(map.get(l.a));
            }
            h5PayResultModel.setReturnUrl(a(str, map));
            if (TextUtils.isEmpty(h5PayResultModel.getReturnUrl())) {
                com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.n0, "");
            }
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.o0, th);
            e.a(th);
        }
        return h5PayResultModel;
    }

    public synchronized String pay(String str, boolean z) {
        if (com.alipay.sdk.m.u.b.a()) {
            return com.alipay.sdk.m.j.b.b();
        }
        return a(new com.alipay.sdk.m.s.a(this.a, str, "pay"), str, z);
    }

    public synchronized boolean payInterceptorWithUrl(String str, boolean z, H5PayCallback h5PayCallback) {
        String strFetchOrderInfoFromH5PayUrl;
        strFetchOrderInfoFromH5PayUrl = fetchOrderInfoFromH5PayUrl(str);
        if (!TextUtils.isEmpty(strFetchOrderInfoFromH5PayUrl)) {
            e.d(com.alipay.sdk.m.l.a.A, "intercepted: " + strFetchOrderInfoFromH5PayUrl);
            new Thread(new a(strFetchOrderInfoFromH5PayUrl, z, h5PayCallback)).start();
        }
        return !TextUtils.isEmpty(strFetchOrderInfoFromH5PayUrl);
    }

    public synchronized Map<String, String> payV2(String str, boolean z) {
        String strA;
        com.alipay.sdk.m.s.a aVar;
        if (com.alipay.sdk.m.u.b.a()) {
            aVar = null;
            strA = com.alipay.sdk.m.j.b.b();
        } else {
            com.alipay.sdk.m.s.a aVar2 = new com.alipay.sdk.m.s.a(this.a, str, "payV2");
            strA = a(aVar2, str, z);
            aVar = aVar2;
        }
        return l.a(aVar, strA);
    }

    public void showLoading() {
        com.alipay.sdk.m.x.a aVar = this.b;
        if (aVar != null) {
            aVar.d();
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0045 A[Catch: all -> 0x021d, TryCatch #2 {, blocks: (B:4:0x0003, B:5:0x0006, B:7:0x0010, B:9:0x0025, B:10:0x0029, B:12:0x004a, B:14:0x0053, B:15:0x0056, B:17:0x005a, B:19:0x0062, B:20:0x006f, B:22:0x0077, B:28:0x00c5, B:36:0x0183, B:35:0x0176, B:33:0x0122, B:40:0x01ad, B:42:0x0201, B:43:0x020e, B:44:0x021c, B:11:0x0045, B:25:0x0088, B:27:0x00a5, B:32:0x011b), top: B:52:0x0003, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0053 A[Catch: all -> 0x021d, TryCatch #2 {, blocks: (B:4:0x0003, B:5:0x0006, B:7:0x0010, B:9:0x0025, B:10:0x0029, B:12:0x004a, B:14:0x0053, B:15:0x0056, B:17:0x005a, B:19:0x0062, B:20:0x006f, B:22:0x0077, B:28:0x00c5, B:36:0x0183, B:35:0x0176, B:33:0x0122, B:40:0x01ad, B:42:0x0201, B:43:0x020e, B:44:0x021c, B:11:0x0045, B:25:0x0088, B:27:0x00a5, B:32:0x011b), top: B:52:0x0003, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005a A[Catch: all -> 0x021d, TryCatch #2 {, blocks: (B:4:0x0003, B:5:0x0006, B:7:0x0010, B:9:0x0025, B:10:0x0029, B:12:0x004a, B:14:0x0053, B:15:0x0056, B:17:0x005a, B:19:0x0062, B:20:0x006f, B:22:0x0077, B:28:0x00c5, B:36:0x0183, B:35:0x0176, B:33:0x0122, B:40:0x01ad, B:42:0x0201, B:43:0x020e, B:44:0x021c, B:11:0x0045, B:25:0x0088, B:27:0x00a5, B:32:0x011b), top: B:52:0x0003, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0176 A[Catch: all -> 0x021d, PHI: r9
  0x0176: PHI (r9v19 java.lang.String) = (r9v18 java.lang.String), (r9v21 java.lang.String) binds: [B:34:0x0174, B:29:0x0117] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {, blocks: (B:4:0x0003, B:5:0x0006, B:7:0x0010, B:9:0x0025, B:10:0x0029, B:12:0x004a, B:14:0x0053, B:15:0x0056, B:17:0x005a, B:19:0x0062, B:20:0x006f, B:22:0x0077, B:28:0x00c5, B:36:0x0183, B:35:0x0176, B:33:0x0122, B:40:0x01ad, B:42:0x0201, B:43:0x020e, B:44:0x021c, B:11:0x0045, B:25:0x0088, B:27:0x00a5, B:32:0x011b), top: B:52:0x0003, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0010 A[Catch: all -> 0x021d, TryCatch #2 {, blocks: (B:4:0x0003, B:5:0x0006, B:7:0x0010, B:9:0x0025, B:10:0x0029, B:12:0x004a, B:14:0x0053, B:15:0x0056, B:17:0x005a, B:19:0x0062, B:20:0x006f, B:22:0x0077, B:28:0x00c5, B:36:0x0183, B:35:0x0176, B:33:0x0122, B:40:0x01ad, B:42:0x0201, B:43:0x020e, B:44:0x021c, B:11:0x0045, B:25:0x0088, B:27:0x00a5, B:32:0x011b), top: B:52:0x0003, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized java.lang.String a(com.alipay.sdk.m.s.a r7, java.lang.String r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 544
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.a(com.alipay.sdk.m.s.a, java.lang.String, boolean):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0055 A[Catch: all -> 0x005f, TryCatch #2 {all -> 0x005f, blocks: (B:11:0x001f, B:13:0x0048, B:15:0x0055, B:16:0x005a), top: B:25:0x001f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r6) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            java.lang.String r0 = "sc"
            java.lang.String r1 = ""
            android.content.pm.PackageManager r2 = r6.getPackageManager()     // Catch: java.lang.Exception -> L19
            java.lang.String r6 = r6.getPackageName()     // Catch: java.lang.Exception -> L19
            r3 = 0
            android.content.pm.PackageInfo r6 = r2.getPackageInfo(r6, r3)     // Catch: java.lang.Exception -> L19
            java.lang.String r2 = r6.versionName     // Catch: java.lang.Exception -> L19
            java.lang.String r6 = r6.packageName     // Catch: java.lang.Exception -> L17
            goto L1f
        L17:
            r6 = move-exception
            goto L1b
        L19:
            r6 = move-exception
            r2 = r1
        L1b:
            com.alipay.sdk.m.u.e.a(r6)
            r6 = r1
        L1f:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L5f
            r3.<init>()     // Catch: java.lang.Throwable -> L5f
            java.lang.String r4 = "appkey"
            java.lang.String r5 = "2014052600006128"
            r3.put(r4, r5)     // Catch: java.lang.Throwable -> L5f
            java.lang.String r4 = "ty"
            java.lang.String r5 = "and_lite"
            r3.put(r4, r5)     // Catch: java.lang.Throwable -> L5f
            java.lang.String r4 = "sv"
            java.lang.String r5 = "h.a.3.8.17"
            r3.put(r4, r5)     // Catch: java.lang.Throwable -> L5f
            java.lang.String r4 = "an"
            r3.put(r4, r6)     // Catch: java.lang.Throwable -> L5f
            java.lang.String r6 = "av"
            r3.put(r6, r2)     // Catch: java.lang.Throwable -> L5f
            java.lang.String r6 = "sdk_start_time"
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L5f
            r3.put(r6, r4)     // Catch: java.lang.Throwable -> L5f
            boolean r6 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L5f
            if (r6 != 0) goto L5a
            java.lang.String r6 = "h5tonative"
            r3.put(r0, r6)     // Catch: java.lang.Throwable -> L5f
        L5a:
            java.lang.String r6 = r3.toString()     // Catch: java.lang.Throwable -> L5f
            return r6
        L5f:
            r6 = move-exception
            com.alipay.sdk.m.u.e.a(r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.a(android.content.Context):java.lang.String");
    }

    public static final String a(String... strArr) {
        if (strArr == null) {
            return "";
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }

    private boolean a(boolean z, boolean z2, String str, StringBuilder sb, Map<String, String> map, String... strArr) {
        String str2;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                str2 = "";
                break;
            }
            String str3 = strArr[i2];
            if (!TextUtils.isEmpty(map.get(str3))) {
                str2 = map.get(str3);
                break;
            }
            i2++;
        }
        if (TextUtils.isEmpty(str2)) {
            return !z2;
        }
        if (z) {
            sb.append(com.alipay.sdk.m.s.a.n).append(str).append("=\"").append(str2).append("\"");
            return true;
        }
        sb.append(str).append("=\"").append(str2).append("\"");
        return true;
    }

    private String a(String str, Map<String, String> map) throws UnsupportedEncodingException {
        boolean zEquals = "9000".equals(map.get(l.a));
        String str2 = map.get("result");
        c cVarRemove = this.g.remove(str);
        if (map.containsKey("callBackUrl")) {
            return map.get("callBackUrl");
        }
        if (str2.length() > 15) {
            String strA = a(n.a("&callBackUrl=\"", "\"", str2), n.a("&call_back_url=\"", "\"", str2), n.a(com.alipay.sdk.m.l.a.u, "\"", str2), URLDecoder.decode(n.a(com.alipay.sdk.m.l.a.v, com.alipay.sdk.m.s.a.n, str2), "utf-8"), URLDecoder.decode(n.a("&callBackUrl=", com.alipay.sdk.m.s.a.n, str2), "utf-8"), n.a("call_back_url=\"", "\"", str2));
            if (!TextUtils.isEmpty(strA)) {
                return strA;
            }
        }
        if (cVarRemove != null) {
            String strB = zEquals ? cVarRemove.b() : cVarRemove.c();
            if (!TextUtils.isEmpty(strB)) {
                return strB;
            }
        }
        return cVarRemove != null ? com.alipay.sdk.m.m.a.z().o() : "";
    }

    private String a(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf(i.d));
    }

    private h.f a() {
        return new b();
    }

    private String a(String str, com.alipay.sdk.m.s.a aVar) {
        String strA = aVar.a(str);
        if (strA.contains("paymethod=\"expressGateway\"")) {
            return a(aVar, strA);
        }
        List<a.b> listJ = com.alipay.sdk.m.m.a.z().j();
        if (!com.alipay.sdk.m.m.a.z().g || listJ == null) {
            listJ = com.alipay.sdk.m.j.a.d;
        }
        if (n.a(aVar, (Context) this.a, listJ, true)) {
            h hVar = new h(this.a, aVar, a());
            e.d(com.alipay.sdk.m.l.a.A, "pay inner started: " + strA);
            String strA2 = hVar.a(strA, false);
            if (!TextUtils.isEmpty(strA2) && strA2.contains("resultStatus={" + com.alipay.sdk.m.j.c.ACTIVITY_NOT_START_EXIT.b() + i.d)) {
                n.a("alipaySdk", com.alipay.sdk.m.l.b.q, this.a, aVar);
                strA2 = hVar.a(strA, true);
            }
            e.d(com.alipay.sdk.m.l.a.A, "pay inner raw result: " + strA2);
            hVar.a();
            boolean zT = com.alipay.sdk.m.m.a.z().t();
            if (!TextUtils.equals(strA2, h.i) && !TextUtils.equals(strA2, h.j) && (!zT || !aVar.e())) {
                if (TextUtils.isEmpty(strA2)) {
                    return com.alipay.sdk.m.j.b.a();
                }
                if (!strA2.contains(PayResultActivity.b)) {
                    return strA2;
                }
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.k0);
                return a(aVar, strA, listJ, strA2, this.a);
            }
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.i0);
            return a(aVar, strA);
        }
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.j0);
        return a(aVar, strA);
    }

    public static String a(com.alipay.sdk.m.s.a aVar, String str, List<a.b> list, String str2, Activity activity) {
        n.c cVarA = n.a(aVar, activity, list);
        if (cVarA == null || cVarA.a(aVar) || cVarA.a() || !TextUtils.equals(cVarA.a.packageName, "hk.alipay.wallet")) {
            return str2;
        }
        e.b(com.alipay.sdk.m.l.a.A, "PayTask not_login");
        String strValueOf = String.valueOf(str.hashCode());
        PayResultActivity.c.put(strValueOf, new Object());
        Intent intent = new Intent(activity, (Class<?>) PayResultActivity.class);
        intent.putExtra(PayResultActivity.f, str);
        intent.putExtra(PayResultActivity.g, activity.getPackageName());
        intent.putExtra(PayResultActivity.e, strValueOf);
        a.C0059a.a(aVar, intent);
        activity.startActivity(intent);
        synchronized (PayResultActivity.c.get(strValueOf)) {
            try {
                e.b(com.alipay.sdk.m.l.a.A, "PayTask wait");
                PayResultActivity.c.get(strValueOf).wait();
            } catch (InterruptedException unused) {
                e.b(com.alipay.sdk.m.l.a.A, "PayTask interrupted");
                return com.alipay.sdk.m.j.b.a();
            }
        }
        String str3 = PayResultActivity.b.b;
        e.b(com.alipay.sdk.m.l.a.A, "PayTask ret: " + str3);
        return str3;
    }

    private String a(com.alipay.sdk.m.s.a aVar, String str) {
        showLoading();
        com.alipay.sdk.m.j.c cVarB = null;
        try {
            try {
                try {
                    JSONObject jSONObjectC = new f().a(aVar, this.a.getApplicationContext(), str).c();
                    String strOptString = jSONObjectC.optString("end_code", null);
                    List<com.alipay.sdk.m.r.b> listA = com.alipay.sdk.m.r.b.a(jSONObjectC.optJSONObject(com.alipay.sdk.m.l.c.c).optJSONObject(com.alipay.sdk.m.l.c.d));
                    for (int i2 = 0; i2 < listA.size(); i2++) {
                        if (listA.get(i2).a() == com.alipay.sdk.m.r.a.Update) {
                            com.alipay.sdk.m.r.b.a(listA.get(i2));
                        }
                    }
                    a(aVar, jSONObjectC);
                    dismissLoading();
                    com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
                    for (int i3 = 0; i3 < listA.size(); i3++) {
                        com.alipay.sdk.m.r.b bVar = listA.get(i3);
                        if (bVar.a() == com.alipay.sdk.m.r.a.WapPay) {
                            String strA = a(aVar, bVar);
                            dismissLoading();
                            com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
                            return strA;
                        }
                        if (bVar.a() == com.alipay.sdk.m.r.a.OpenWeb) {
                            String strA2 = a(aVar, bVar, strOptString);
                            dismissLoading();
                            com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
                            return strA2;
                        }
                    }
                    dismissLoading();
                    com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
                } catch (IOException e) {
                    com.alipay.sdk.m.j.c cVarB2 = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.NETWORK_ERROR.b());
                    com.alipay.sdk.m.k.a.a(aVar, "net", e);
                    dismissLoading();
                    com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
                    cVarB = cVarB2;
                }
            } catch (Throwable th) {
                e.a(th);
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.B, th);
                dismissLoading();
                com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
            }
            if (cVarB == null) {
                cVarB = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.FAILED.b());
            }
            return com.alipay.sdk.m.j.b.a(cVarB.b(), cVarB.a(), "");
        } catch (Throwable th2) {
            dismissLoading();
            com.alipay.sdk.m.k.a.a(this.a, aVar, str, aVar.d);
            throw th2;
        }
    }

    private void a(com.alipay.sdk.m.s.a aVar, JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("tid");
            String strOptString2 = jSONObject.optString(com.alipay.sdk.m.t.a.j);
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
                return;
            }
            com.alipay.sdk.m.t.a.a(com.alipay.sdk.m.s.b.d().b()).a(strOptString, strOptString2);
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.P, th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0093, code lost:
    
        r0 = r6.c();
        r11 = com.alipay.sdk.m.j.b.a(java.lang.Integer.valueOf(r0[1]).intValue(), r0[0], com.alipay.sdk.m.u.n.e(r10, r0[2]));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(com.alipay.sdk.m.s.a r10, com.alipay.sdk.m.r.b r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.a(com.alipay.sdk.m.s.a, com.alipay.sdk.m.r.b, java.lang.String):java.lang.String");
    }

    private String a(com.alipay.sdk.m.s.a aVar, com.alipay.sdk.m.r.b bVar) {
        String[] strArrC = bVar.c();
        Intent intent = new Intent(this.a, (Class<?>) H5PayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("url", strArrC[0]);
        if (strArrC.length == 2) {
            bundle.putString("cookie", strArrC[1]);
        }
        intent.putExtras(bundle);
        a.C0059a.a(aVar, intent);
        this.a.startActivity(intent);
        Object obj = h;
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException e) {
                e.a(e);
                return com.alipay.sdk.m.j.b.a();
            }
        }
        String strD = com.alipay.sdk.m.j.b.d();
        return TextUtils.isEmpty(strD) ? com.alipay.sdk.m.j.b.a() : strD;
    }
}

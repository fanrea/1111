package com.baidu.mobads.container.bridge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.CookieManager;
import androidx.core.provider.FontsContractCompat;
import com.baidu.mobads.container.ax;
import com.baidu.mobads.container.components.c.a;
import com.baidu.mobads.container.components.e.b;
import com.baidu.mobads.container.landingpage.App2Activity;
import com.baidu.mobads.container.util.IDManager;
import com.baidu.mobads.container.util.bh;
import com.baidu.mobads.container.util.bj;
import com.baidu.mobads.container.util.bp;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.ss.texturerender.TextureRenderKeys;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b implements a.InterfaceC0121a, IOAdEventListener {
    protected static final String A = "packageName";
    public static final String B = "lifecycleTime";
    public static final String C = "params";
    protected static final String D = "type";
    protected static final String E = "packageName";
    protected static final String F = "action";
    protected static final String G = "callback";
    protected static final String H = "appUrl";
    protected static final String I = "webUrl";
    protected static final String J = "file_id";

    /* renamed from: K, reason: collision with root package name */
    protected static final String f721K = "query";
    protected static final String L = "appName";
    protected static final String M = "packageImg";
    protected static final String N = "isStoreDirectLaunch";
    protected static final String O = "packageName";
    protected static final String P = "deeplinkUrl";
    protected static final String Q = "pkg";
    protected static final String R = "scheme";
    protected static final String S = "AdStatusChange";
    private static final String X = "javascript:";
    private static final String Y = "downStatus";
    private static final String Z = "process";
    protected static final String a = "JmyJsHandler";
    private static final String aa = "uri";
    private static final String ab = "completime";
    private static final String aj = "url";
    private static final String ak = "uri";
    private static final String al = "downloadUrl";
    private static final String am = "isActiveStoreDirectLaunch";
    private static final String an = "params";
    private static final String ao = "callback";
    private static final String ap = "appUrl";
    private static final String aq = "lp_JMY";
    public static final String b = "baidumobads://sdk/utils/queryAllSchemeAbilities?";
    protected static final String c = "baiduboxapp://v7/vendor/ad/download?";
    protected static final String d = "baiduboxapp://v7/vendor/ad/deeplink?";
    protected static final String e = "baiduboxapp://v16/utils/queryScheme?";
    protected static final String f = "baiduboxapp://v7/vendor/ad/registerDeeplink?";
    protected static final String g = "baidumobads://sdk/utils/getConfigs";
    public static final String h = "baidumobads://sdk/utils/queryTrackingParams?";
    protected static final String i = "baidumobads://sdk/utils/lpSupportVideo";
    public static final String j = "baidumobasds://sdk/utils/delivery";
    public static final String k = "baidumobasds://sdk/utils/sendPageInfo";
    protected static final String l = "register";
    protected static final String m = "unregister";
    protected static final String n = "startdownload";
    protected static final String o = "pausedownload";
    protected static final String p = "resumedownload";
    protected static final String q = "canceldownload";
    protected static final String r = "installapk";
    protected static final String s = "openapk";
    protected static final String t = "batchgetdownloadstatus";
    protected static final String u = "com.baidu.channel.aladdin.downloadapk";
    protected static final String v = "status";
    protected static final String w = "message";
    protected static final String x = "data";
    protected static final String y = "result";
    protected static final String z = "file_id";
    protected HashMap<String, a> T;
    protected Context U;
    protected ax V;
    protected com.baidu.mobads.container.adrequest.j W;
    private JSONObject aA;
    private com.baidu.mobads.container.landingpage.al aB;
    private CookieManager aC;
    private String aD;
    private final String ac;
    private final String ad;
    private final String ae;
    private final String af;
    private final String ag;
    private final String ah;
    private final String ai;
    private ap ar;
    private String as;
    private String at;
    private boolean au;
    private JSONObject av;
    private Activity aw;
    private App2Activity ax;
    private by.b ay;
    private String az;

    public b(Context context, ax axVar, com.baidu.mobads.container.adrequest.j jVar, String str, String str2) {
        this.ac = "IMEI";
        this.ad = "CUID";
        this.ae = "OAID";
        this.af = "aid=";
        this.ag = "im=";
        this.ah = "cuid=";
        this.ai = "oaid=";
        this.T = new HashMap<>();
        this.au = false;
        this.aD = "https://cpu.baidu.com/";
        this.U = context;
        this.V = axVar;
        this.W = jVar;
        this.as = str;
        this.at = str2;
        this.ar = new ap(context);
    }

    public b(Context context, ax axVar, com.baidu.mobads.container.adrequest.j jVar, String str, String str2, String str3) {
        this(context, axVar, jVar, str, str2);
        this.az = str3;
    }

    public void a(by.b bVar) {
        this.ay = bVar;
    }

    private void f() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        this.aB = new com.baidu.mobads.container.landingpage.al();
        this.aB.a(new c(this));
        new com.component.c.b(this.aw).a(this.aB, intentFilter);
    }

    public void a(Activity activity) {
        this.aw = activity;
        f();
        this.V.a(new d(this));
    }

    public void a(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && str != null && this.V != null) {
            String str2 = "javascript:" + str + "(\"" + jSONObject.toString().replace("\"", "\\\"") + "\")";
            bq.a().a(a, str2);
            this.V.loadUrl(str2);
            return;
        }
        bq.a().a(a, "jsPageInfo is null");
    }

    public void a(App2Activity app2Activity) {
        this.ax = app2Activity;
    }

    public boolean c(String str) {
        return d(str) || b(str);
    }

    private boolean b(String str) {
        return this.ar.a(str);
    }

    public boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(c) || str.startsWith(f) || str.startsWith(e) || str.startsWith(d) || str.startsWith(g) || str.startsWith(j) || str.startsWith(i) || str.startsWith(k);
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x01bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 1128
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.container.bridge.b.a(java.lang.String):void");
    }

    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null && "AdStatusChange".equals(iOAdEvent.getType())) {
            String message = iOAdEvent.getMessage();
            if (!TextUtils.isEmpty(message) && this.T.containsKey(message)) {
                try {
                    a aVar = this.T.get(message);
                    if (aVar == null) {
                        return;
                    }
                    b(aVar);
                    JSONObject jSONObjectA = aVar.a();
                    if (aVar.o.get()) {
                        if (k(message)) {
                            g(message, aVar.h);
                        } else {
                            f(message, jSONObjectA.optString(ContentProviderManager.PROVIDER_URI));
                        }
                    }
                    if (!TextUtils.isEmpty(aVar.g) && this.V != null) {
                        try {
                            if (k(message)) {
                                aVar.a = "6";
                                jSONObjectA = aVar.a();
                            }
                            b(aVar.g, jSONObjectA);
                        } catch (Throwable th) {
                            bq.a().b(a, th.getMessage());
                        }
                    }
                } catch (Throwable th2) {
                    bq.a().b(a, th2.getMessage());
                }
            }
        }
    }

    @Override // com.baidu.mobads.container.components.c.a.InterfaceC0121a
    public boolean a(Context context, Intent intent) {
        try {
            String dataString = intent.getDataString();
            if (TextUtils.isEmpty(dataString)) {
                return false;
            }
            String strReplace = dataString.replace("package:", "");
            if (!this.T.containsKey(strReplace)) {
                return false;
            }
            a aVar = this.T.get(strReplace);
            aVar.a = "6";
            b(aVar.g, aVar.a());
            if (!TextUtils.isEmpty(aVar.i) || aVar.j) {
                bh bhVar = new bh(5000, 1000);
                bhVar.a(new g(this, aVar, bhVar));
                bhVar.a();
                return true;
            }
            return true;
        } catch (Throwable th) {
            return true;
        }
    }

    protected void a(int i2, String str, String str2, String str3, JSONObject jSONObject) {
        a aVarN;
        if (jSONObject != null) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    aVarN = n(str3);
                } else if (!this.T.containsKey(str2)) {
                    aVarN = null;
                } else {
                    aVarN = this.T.get(str2);
                }
                by.a aVarA = by.a.a(this.U).a(i2).c(this.as).a(this.at).a(this.W).a("msg", str).a("apid", this.az == null ? "" : this.az).a("status", jSONObject.optString("status")).a("message", jSONObject.optString("message")).a(com.baidu.mobads.container.components.command.j.F, 0L).a("dl_type", aq);
                if (aVarN != null) {
                    aVarA.a("pk", aVarN.e).a(FontsContractCompat.Columns.FILE_ID, aVarN.f).a("isDirectLaunch", aVarN.j).a("isUserAction", aVarN.k);
                    String strSubstring = aVarN.h;
                    if (!TextUtils.isEmpty(strSubstring) && strSubstring.length() > 64) {
                        strSubstring = strSubstring.substring(0, 64);
                    }
                    aVarA.a("page", strSubstring);
                } else {
                    aVarA.a("pk", str2);
                    aVarA.a(FontsContractCompat.Columns.FILE_ID, str3);
                }
                aVarA.f();
            } catch (Throwable th) {
            }
        }
    }

    protected static JSONObject e(String str) {
        try {
            String strA = a(str, "params");
            if (!TextUtils.isEmpty(strA)) {
                return new JSONObject(strA);
            }
            return null;
        } catch (Throwable th) {
            bq.a().b(a, th.getMessage());
            return null;
        }
    }

    public static String a(String str, String str2) {
        try {
            Uri uri = Uri.parse(str);
            bq.a().a(a, "getQueryParameter: " + uri.toString());
            return uri.getQueryParameter(str2);
        } catch (Throwable th) {
            return "";
        }
    }

    protected void b(String str, String str2) {
        a aVar;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (aVar = this.T.get(str)) != null) {
            aVar.i = a(str2, TextureRenderKeys.KEY_IS_CALLBACK);
            try {
                aVar.h = new JSONObject(a(str2, "params")).optString("appUrl");
            } catch (Throwable th) {
            }
        }
    }

    protected void a(boolean z2, String str, String str2) {
        a aVar = this.T.get(str);
        if (aVar != null) {
            a(aVar);
            aVar.j = true;
            aVar.k = z2;
        }
        if (z2) {
            bh bhVar = new bh(5000, 500);
            this.au = false;
            bhVar.a(new h(this, str, bhVar, str2));
            bhVar.a();
        }
    }

    protected void b(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && jSONObject != null && this.V != null) {
            String str2 = "javascript:" + str + "(\"" + jSONObject.toString().replace("\"", "\\\"") + "\")";
            bq.a().a(a, str2);
            this.V.loadUrl(str2);
            return;
        }
        bq.a().a(a, "callback is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject d(String str, String str2) {
        try {
            com.baidu.mobads.container.components.command.o oVarH = h(str2, str);
            if (oVarH != null) {
                new com.baidu.mobads.container.components.command.m(this.U, oVarH, this).a();
                return j(str2);
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    protected JSONObject f(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.mobads.container.components.e.b bVarB = com.baidu.mobads.container.components.e.f.a(this.U).b(str);
                if (bVarB != null) {
                    bVarB.a(4);
                    return j(str);
                }
                return c("202", "no available downloader");
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    private JSONObject e(String str, String str2) {
        try {
            com.baidu.mobads.container.components.command.o oVarH = h(str2, str);
            if (oVarH != null && new com.baidu.mobads.container.components.command.m(this.U, oVarH, this).b()) {
                new com.baidu.mobads.container.components.command.a().a(this.U, str2);
                return j(str2);
            }
            return c("202", "no available downloader");
        } catch (Throwable th) {
            return null;
        }
    }

    protected JSONObject g(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (com.baidu.mobads.container.components.e.f.a(this.U).c(str) != null) {
                    return j(str);
                }
                return c("202", "no available downloader");
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    private JSONObject f(String str, String str2) {
        a aVar;
        com.baidu.mobads.container.components.command.j jVarA;
        try {
            if (TextUtils.isEmpty(str) || (aVar = this.T.get(str)) == null) {
                return null;
            }
            if (TextUtils.isEmpty(str2) && (jVarA = com.baidu.mobads.container.components.command.j.a(this.U, str)) != null) {
                str2 = o(jVarA.T + jVarA.S);
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addFlags(268435457);
            intent.setDataAndType(Uri.parse(str2), "application/vnd.android.package-archive");
            if (com.baidu.mobads.container.util.t.a()) {
                intent.putExtra("android.intent.extra.RETURN_RESULT", true);
            }
            a(aVar);
            this.U.startActivity(intent);
            return c("0", "success");
        } catch (Throwable th) {
            bq.a().d(a, th);
        }
        return null;
    }

    protected void a(a aVar) {
        if (aVar != null && !aVar.l) {
            com.baidu.mobads.container.components.command.j jVar = new com.baidu.mobads.container.components.command.j(aVar.e, "");
            jVar.a(aq, 0);
            com.baidu.mobads.container.components.c.g.a().a(this.U, jVar);
            com.baidu.mobads.container.components.c.g.a().a(aVar.e, this);
            aVar.l = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject g(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str2)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str2));
                intent.addFlags(268435456);
                if (this.U.getPackageManager().resolveActivity(intent, 65536) != null) {
                    this.U.startActivity(intent);
                    return c("0", "success");
                }
                return null;
            }
            if (!TextUtils.isEmpty(str)) {
                bj.b(this.U, str);
                return c("0", "success");
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    protected JSONObject h(String str) {
        try {
            if (this.V != null) {
                this.V.loadUrl(str);
                return c("0", "success");
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    private com.baidu.mobads.container.components.command.o h(String str, String str2) {
        a aVar;
        if (TextUtils.isEmpty(str) || (aVar = this.T.get(str)) == null || aVar.m == null) {
            return null;
        }
        aVar.o.set(false);
        aVar.m.d = str2;
        return aVar.m;
    }

    protected boolean a(String str, String str2, String str3, String str4, String str5) {
        if (!this.T.containsKey(str)) {
            a aVar = new a(str, str2);
            aVar.a(a(str, str4, str5));
            aVar.g = str3;
            aVar.f = str2;
            this.T.put(str, aVar);
            return true;
        }
        a aVar2 = this.T.get(str);
        if (aVar2 != null) {
            aVar2.f = str2;
            aVar2.g = str3;
            if (aVar2.m != null) {
                aVar2.m.k = str4;
                aVar2.m.a("icon_url", str5);
            } else {
                aVar2.a(a(str, str4, str5));
            }
            return true;
        }
        return false;
    }

    private com.baidu.mobads.container.components.command.o a(String str, String str2, String str3) {
        com.baidu.mobads.container.components.command.o oVarA = com.baidu.mobads.container.components.command.o.a(this.W);
        oVarA.A = true;
        oVarA.x = aq;
        oVarA.b = this.as;
        oVarA.a = this.at;
        oVarA.j = str;
        oVarA.k = str2;
        oVarA.i = str2;
        oVarA.z = false;
        oVarA.B = false;
        oVarA.w = 0;
        oVarA.a("creative_id", bp.a().a(this.W.getOriginJsonObject(), "creative_id"));
        oVarA.a("uniqueId", this.W.getUniqueId());
        oVarA.a("icon_url", str3);
        return oVarA;
    }

    protected JSONObject i(String str) {
        try {
            a aVarN = n(str);
            if (aVarN == null) {
                return null;
            }
            b(aVarN);
            JSONObject jSONObjectC = c("0", "success");
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(Y, aVarN.a);
            jSONObject2.put(Z, aVarN.b);
            jSONObject2.put(ContentProviderManager.PROVIDER_URI, aVarN.d);
            jSONObject2.put(FontsContractCompat.Columns.FILE_ID, aVarN.f);
            jSONObject2.put(ab, aVarN.c);
            jSONArray.put(jSONObject2);
            jSONObject.put("result", jSONArray);
            jSONObjectC.put("data", jSONObject);
            return jSONObjectC;
        } catch (Throwable th) {
            bq.a().b(a, th.getMessage());
            return null;
        }
    }

    private a n(String str) {
        try {
            if (!TextUtils.isEmpty(str) && !this.T.isEmpty()) {
                Iterator<String> it = this.T.keySet().iterator();
                while (it.hasNext()) {
                    a aVar = this.T.get(it.next());
                    if (aVar != null && str.equals(aVar.f)) {
                        return aVar;
                    }
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            bq.a().b(a, th.getMessage());
            return null;
        }
    }

    protected JSONObject j(String str) {
        try {
            a aVar = this.T.get(str);
            if (aVar != null) {
                b(aVar);
                return aVar.a();
            }
            return null;
        } catch (Throwable th) {
            bq.a().b(a, th.getMessage());
            return null;
        }
    }

    protected JSONObject c(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", str);
            jSONObject.put("message", str2);
            return jSONObject;
        } catch (Throwable th) {
            bq.a().b(a, th.getMessage());
            return null;
        }
    }

    protected void b(a aVar) {
        b.a aVarI;
        String str;
        String strL;
        com.baidu.mobads.container.components.e.b bVarB = com.baidu.mobads.container.components.e.f.a(this.U).b(aVar.e);
        if (bVarB == null) {
            com.baidu.mobads.container.components.command.j jVarA = com.baidu.mobads.container.components.command.j.a(this.U, aVar.e);
            if (jVarA != null && (jVarA.X == b.a.COMPLETED || jVarA.X == b.a.PAUSED)) {
                aVarI = jVarA.X;
                str = "" + jVarA.V;
                strL = jVarA.T + jVarA.S;
            } else {
                aVarI = null;
                strL = "";
                str = "0";
            }
        } else {
            aVarI = bVarB.i();
            str = "" + ((int) bVarB.h());
            strL = bVarB.l();
        }
        if (aVarI != null) {
            if (aVarI == b.a.INITING) {
                aVar.a("5", "0");
                return;
            }
            if (aVarI == b.a.DOWNLOADING) {
                aVar.a("1", str);
                aVar.a(strL + ".tmp");
                return;
            }
            if (aVarI == b.a.COMPLETED) {
                if (p(strL)) {
                    aVar.a("3", "100");
                    aVar.a(strL);
                    aVar.o.set(true);
                    return;
                }
                aVar.a("0", "0");
                return;
            }
            if (aVarI == b.a.PAUSED) {
                aVar.a("2", str);
                aVar.a(strL + ".tmp");
                return;
            } else if (aVarI == b.a.ERROR || aVarI == b.a.COMPLETE_BUT_FILE_REMOVED) {
                aVar.a("4", "0");
                aVar.a(strL + ".tmp");
                return;
            } else {
                aVar.a("0", "0");
                return;
            }
        }
        aVar.a("0", "0");
    }

    protected boolean k(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            PackageManager packageManager = this.U.getPackageManager();
            bq.a().a(a, "judge pkg :" + str);
            packageManager.getApplicationInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    protected boolean l(String str) {
        try {
            new Intent("android.intent.action.VIEW", Uri.parse(str)).addFlags(268435456);
            return !new com.component.c.d(this.U).a(r0, 65536).isEmpty();
        } catch (Throwable th) {
            return false;
        }
    }

    protected String m(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONArray(str).optJSONObject(0).optString(FontsContractCompat.Columns.FILE_ID);
            } catch (Throwable th) {
                bq.a().b(a, th.getMessage());
                return "";
            }
        }
        return "";
    }

    protected JSONObject a() {
        if (this.av == null) {
            this.av = new JSONObject();
        }
        try {
            this.av.putOpt("SDK_V", "android_9.40");
            if (TextUtils.isEmpty(this.av.optString("IMEI"))) {
                this.av.putOpt("IMEI", com.baidu.mobads.container.nativecpu.a.b.a(com.baidu.mobads.container.nativecpu.a.b.a, IDManager.getInstance().c(this.U)));
            }
            if (TextUtils.isEmpty(this.av.optString("CUID"))) {
                this.av.putOpt("CUID", com.baidu.mobads.container.nativecpu.a.b.a(com.baidu.mobads.container.nativecpu.a.b.a, IDManager.getInstance().a(this.U)));
            }
            if (TextUtils.isEmpty(this.av.optString("OAID"))) {
                this.av.putOpt("OAID", com.baidu.mobads.container.util.f.z.a(this.U));
            }
            JSONObject jSONObjectC = c("0", "success");
            jSONObjectC.put("data", this.av);
            return jSONObjectC;
        } catch (Throwable th) {
            bq.a().b(a, "getConfigs exception: " + th.getMessage());
            return null;
        }
    }

    protected void b() {
        if (this.aC == null) {
            try {
                this.aC = CookieManager.getInstance();
                this.aC.setAcceptCookie(true);
            } catch (Throwable th) {
                bq.a().a(a, th);
            }
        }
    }

    protected void c() {
        if (this.aC != null && this.av != null) {
            try {
                String cookie = this.aC.getCookie(this.aD);
                if (!TextUtils.isEmpty(cookie)) {
                    boolean z2 = false;
                    boolean z3 = false;
                    boolean z4 = false;
                    for (String str : cookie.split(com.alipay.sdk.m.u.i.b)) {
                        if (!TextUtils.isEmpty(str)) {
                            String strTrim = str.trim();
                            if (strTrim.startsWith("im=") && strTrim.length() < 80) {
                                z2 = true;
                            } else if (strTrim.startsWith("cuid=") && strTrim.length() < 82) {
                                z3 = true;
                            } else if (strTrim.startsWith("oaid=") && strTrim.length() < 12) {
                                z4 = true;
                            } else if (strTrim.startsWith("aid=")) {
                                strTrim.length();
                            }
                        }
                    }
                    if (z2) {
                        this.aC.setCookie(this.aD, "im=" + this.av.optString("IMEI") + com.alipay.sdk.m.u.i.b);
                    }
                    if (z3) {
                        this.aC.setCookie(this.aD, "cuid=" + this.av.optString("CUID") + com.alipay.sdk.m.u.i.b);
                    }
                    if (z4) {
                        this.aC.setCookie(this.aD, "oaid=" + this.av.optString("OAID") + com.alipay.sdk.m.u.i.b);
                    }
                }
            } catch (Throwable th) {
                bq.a().d(a, "updateCookies", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String o(String str) {
        Uri uriB;
        try {
            File file = new File(str);
            if (file.exists()) {
                if (!com.baidu.mobads.container.util.t.a(this.U)) {
                    uriB = Uri.fromFile(file);
                } else {
                    uriB = com.baidu.mobads.container.util.t.b(this.U, file);
                }
                if (uriB != null) {
                    return uriB.toString();
                }
                return "";
            }
            return "";
        } catch (Throwable th) {
            bq.a().b(a, th.getMessage());
            return "";
        }
    }

    private boolean p(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.length() > 0;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    protected void d() {
    }

    public void e() {
        g();
    }

    private void g() {
        if (this.aB != null && this.aw != null) {
            new com.component.c.b(this.aw).a(this.aB);
        }
    }

    protected class a {
        String e;
        String f;
        com.baidu.mobads.container.components.command.o m;
        String a = "0";
        String b = "0";
        String c = "";
        String d = "";
        String g = "";
        String h = "";
        String i = "";
        boolean j = false;
        boolean k = false;
        boolean l = false;
        private AtomicBoolean o = new AtomicBoolean(false);

        a(String str, String str2) {
            this.e = "";
            this.f = "";
            this.e = str;
            this.f = str2;
        }

        void a(com.baidu.mobads.container.components.command.o oVar) {
            this.m = oVar;
        }

        void a(String str, String str2) {
            this.a = str;
            this.b = str2;
            if ("3".equals(this.a)) {
                this.c = "" + System.currentTimeMillis();
            }
        }

        void a(String str) {
            this.d = b.this.o(str);
        }

        JSONObject a() {
            try {
                JSONObject jSONObjectC = b.this.c("0", "success");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(b.Y, this.a);
                jSONObject.put(b.Z, this.b);
                jSONObject.put(ContentProviderManager.PROVIDER_URI, this.d);
                jSONObject.put(FontsContractCompat.Columns.FILE_ID, this.f);
                jSONObject.put(b.ab, this.c);
                jSONObjectC.put("data", jSONObject);
                return jSONObjectC;
            } catch (Throwable th) {
                bq.a().b(b.a, th.getMessage());
                return null;
            }
        }
    }
}

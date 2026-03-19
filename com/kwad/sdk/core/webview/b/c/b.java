package com.kwad.sdk.core.webview.b.c;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.utils.aa;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b {
    public static final Map<String, JSONObject> bMi = new HashMap();
    public static boolean aJc = true;

    public static class a {
        public String msg;
    }

    public static void a(com.kwad.sdk.h.a.b bVar, int i) {
        com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.APM_LOG, new HybridLoadMsg().setSceneId(bVar.packageId).setH5Version(bVar.version).setLoadType(bVar.loadType).setState(i).setPackageUrl(bVar.packageUrl).setInterval(String.valueOf(System.currentTimeMillis() - bVar.akg())));
    }

    public static void a(com.kwad.sdk.h.a.b bVar, int i, int i2, String str) {
        com.kwad.sdk.commercial.b.a(ILoggerReporter.Category.ERROR_LOG, new HybridLoadMsg().setSceneId(bVar.packageId).setH5Version(bVar.version).setLoadType(bVar.loadType).setState(0).setPackageUrl(bVar.packageUrl).setFailState(i2).setInterval(String.valueOf(System.currentTimeMillis() - bVar.akg())).setFailReason(str));
    }

    public static void a(String str, String str2, int i, String str3, long j) {
        String str4 = i == 2 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG;
        if (j > 60000 || j < 0) {
            j = -1;
        }
        com.kwad.sdk.commercial.b.b(str4, new HybridLoadMsg().setSceneId(str2).setUrl(str).setState(i).setInterval(String.valueOf(j)).setFailReason(str3));
    }

    private static JSONObject gv(String str) {
        Map<String, JSONObject> map = bMi;
        JSONObject jSONObject = map.get(str);
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        map.put(str, jSONObject2);
        return jSONObject2;
    }

    private static void gw(String str) {
        bMi.remove(str);
    }

    public static void gx(String str) {
        JSONObject jSONObjectGv = gv(str);
        long jTz = com.kwad.sdk.core.webview.b.a.adH().tz();
        long jCurrentTimeMillis = jTz <= 0 ? -1L : System.currentTimeMillis() - jTz;
        aa.putValue(jSONObjectGv, "c_loadUrl", System.currentTimeMillis());
        aa.putValue(jSONObjectGv, "c_init_interval", jCurrentTimeMillis);
        aa.putValue(jSONObjectGv, "c_init_state", aJc ? 1 : 2);
        aJc = false;
    }

    public static void al(String str, String str2) {
        aa.putValue(gv(str), "c_" + str2, System.currentTimeMillis());
    }

    public static void c(String str, String str2, String str3) {
        if (str3.contains("/")) {
            str3 = str3.substring(str3.lastIndexOf("/") + 1);
        }
        aa.putValue(gv(str), "c_responseStart_" + str2 + Config.replace + str3, System.currentTimeMillis());
    }

    public static void d(String str, String str2, String str3) {
        if (str3.contains("/")) {
            str3 = str3.substring(str3.lastIndexOf("/") + 1);
        }
        aa.putValue(gv(str), "c_responseEnd_" + str2 + Config.replace + str3, System.currentTimeMillis());
    }

    public static void a(String str, String str2, String str3, String str4) {
        JSONObject jSONObjectGv = gv(str2);
        aa.putValue(jSONObjectGv, "c_" + str3, System.currentTimeMillis());
        if (str3.equals("pageStatus")) {
            try {
                if (TextUtils.isEmpty(str4)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(str4);
                int iOptInt = jSONObject.optInt("status");
                String strOptString = jSONObject.optString("errorMsg", "");
                String strOptString2 = jSONObject.optString("webViewCostParams", "");
                if (!TextUtils.isEmpty(strOptString2)) {
                    JSONObject jSONObject2 = new JSONObject(strOptString2);
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObjectGv.put(next, jSONObject2.opt(next));
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    if (iOptInt == 1) {
                        am(str, str2);
                    } else {
                        an(str, strOptString);
                    }
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            } finally {
                gw(str2);
            }
        }
    }

    private static void am(String str, String str2) {
        a(str, str2, 1, "");
    }

    public static void an(String str, String str2) {
        a(str, "", 2, str2);
    }

    private static void a(String str, String str2, int i, String str3) {
        long jCurrentTimeMillis;
        JSONObject jSONObject = bMi.get(str2);
        if (jSONObject == null) {
            jCurrentTimeMillis = -3;
        } else {
            long jOptLong = jSONObject.optLong("c_loadUrl");
            if (jOptLong <= 0) {
                jCurrentTimeMillis = -2;
            } else {
                jCurrentTimeMillis = System.currentTimeMillis() - jOptLong;
                if (jCurrentTimeMillis > 100000 || jCurrentTimeMillis < 0) {
                    jCurrentTimeMillis = -1;
                }
            }
        }
        com.kwad.sdk.commercial.b.a(i == 2 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG, new WebViewLoadMsg().setUrl(str).setState(i).setCostTime(jSONObject != null ? jSONObject.toString() : "").setInterval(String.valueOf(jCurrentTimeMillis)).setFailReason(str3));
        gw(str2);
    }
}

package com.qq.e.comm.plugin;

import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class y {
    private static boolean a(int i) {
        return i == 19 || i == 12 || i == 5 || i == 38;
    }

    public static boolean b(int i) {
        return i == 19 || i == 12;
    }

    private static i3 b(JSONObject jSONObject) {
        i3 i3Var = new i3();
        i3Var.a(jSONObject.optString("app_name"));
        i3Var.b(jSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.AUTHOR_NAME));
        i3Var.a(jSONObject.optLong("package_size_bytes"));
        i3Var.f(jSONObject.optString("permissions_url"));
        i3Var.g(jSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.PRIVACY_AGREEMENT));
        i3Var.i(jSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME));
        i3Var.c(jSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.DESCRIPTION_URL));
        i3Var.e(jSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.ICP_NUMBER));
        i3Var.h(jSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.SUITABLE_AGE));
        i3Var.d(jSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.ICP_INFO_URL));
        return i3Var;
    }

    public static boolean d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        boolean z = jSONObject.optInt("is_app_subscribe") == 1;
        int iOptInt = jSONObject.optInt("producttype");
        if (z && b(iOptInt)) {
            return false;
        }
        return a(iOptInt);
    }

    public static boolean e(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.optInt("producttype") == 38;
    }

    public static l3 a(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        l3 l3Var = new l3();
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("ext");
        if (jSONObjectOptJSONObject3 != null && (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject3.optJSONObject("app_channel_info")) != null) {
            l3Var.a(b(jSONObjectOptJSONObject2));
        }
        if (e(jSONObject) && jSONObjectOptJSONObject3 != null) {
            l3Var.c(jSONObjectOptJSONObject3.optString(ILogConst.Keys.KEY_PKG_NAME));
            l3Var.b(jSONObjectOptJSONObject3.optInt("appscore", 5));
            l3Var.a(jSONObjectOptJSONObject3.optLong("appdownloadnum", 100000L));
            l3Var.a(jSONObjectOptJSONObject3.optDouble("appprice"));
            l3Var.a(jSONObjectOptJSONObject3.optString("appname"));
            l3Var.b(jSONObjectOptJSONObject3.optString("applogo"));
            l3Var.d(jSONObjectOptJSONObject3.optString("appvername"));
            l3Var.b(jSONObjectOptJSONObject3.optLong("pkgsize"));
            l3Var.c(com.qq.e.comm.plugin.apkmanager.l.e().b(l3Var.e()));
            return l3Var;
        }
        if (d(jSONObject) && jSONObjectOptJSONObject3 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject3.optJSONObject("alist")) != null) {
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("2022");
            if (jSONObjectOptJSONObject4 != null) {
                l3Var.c(jSONObjectOptJSONObject4.optString("aid"));
            } else {
                l3Var.c(jSONObjectOptJSONObject.optString("packagename"));
            }
            l3Var.b(jSONObjectOptJSONObject3.optInt("appscore"));
            l3Var.a(jSONObjectOptJSONObject3.optDouble("appprice"));
            l3Var.a(jSONObjectOptJSONObject3.optString("appname"));
            l3Var.d(jSONObjectOptJSONObject3.optString("appvername"));
            l3Var.b(jSONObjectOptJSONObject3.optLong("pkgsize"));
            l3Var.c(com.qq.e.comm.plugin.apkmanager.l.e().b(l3Var.e()));
            JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject.optJSONObject("2025");
            if (jSONObjectOptJSONObject5 != null) {
                JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject5.optJSONObject("aid");
                if (jSONObjectOptJSONObject6 != null) {
                    l3Var.a(jSONObjectOptJSONObject6.optLong(Config.EXCEPTION_MEMORY_TOTAL));
                    l3Var.b(jSONObjectOptJSONObject6.optString("iconurl"));
                } else {
                    l3Var.a(jSONObjectOptJSONObject3.optLong("appdownloadnum"));
                }
            } else {
                l3Var.a(jSONObjectOptJSONObject3.optLong("downloadnum"));
                l3Var.b(jSONObjectOptJSONObject3.optString("applogo"));
            }
        }
        return l3Var;
    }

    public static String c(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("ext");
        if (e(jSONObject) && jSONObjectOptJSONObject2 != null) {
            return jSONObjectOptJSONObject2.optString(ILogConst.Keys.KEY_PKG_NAME);
        }
        if (!d(jSONObject) || jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("alist")) == null) {
            return null;
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("2022");
        if (jSONObjectOptJSONObject3 != null) {
            return jSONObjectOptJSONObject3.optString("aid");
        }
        return jSONObjectOptJSONObject.optString("packagename");
    }
}

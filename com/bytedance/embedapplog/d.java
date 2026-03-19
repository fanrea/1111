package com.bytedance.embedapplog;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.embedapplog.collector.Collector;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class d {
    private static boolean an = true;
    public static ConcurrentHashMap<String, String> b = new ConcurrentHashMap<>(4);
    public static hc c = null;
    public static ba d = null;
    private static volatile c gb = null;
    private static boolean h = false;
    public static boolean hc = true;
    private static volatile fs u;

    public static boolean h() {
        return true;
    }

    public static void d(Context context, gb gbVar) {
        if (u != null) {
            um.hc(new RuntimeException("Init Twice!"));
            return;
        }
        if (gbVar.s() == null) {
            um.hc(new RuntimeException("need to involve setSensitiveInfoProvider!"));
            return;
        }
        Application application = (Application) context.getApplicationContext();
        de deVarAn = de.an();
        fs fsVar = new fs(application, gbVar);
        u = fsVar;
        ba baVar = new ba(application, fsVar);
        deVarAn.d(application, fsVar, baVar, new yo(gbVar.tc()));
        d = baVar;
        if (u.w()) {
            application.registerReceiver(new Collector(), new IntentFilter());
        }
        um.c("Inited", null);
    }

    public static void d(boolean z) {
        hc = z;
    }

    public static void d() {
        ba baVar;
        if (!hc || (baVar = d) == null) {
            return;
        }
        baVar.c();
    }

    public static void hc() {
        de.d();
    }

    public static c b() {
        return gb;
    }

    public static hc c() {
        return c;
    }

    public static void d(HashMap<String, Object> map) throws JSONException {
        ba baVar = d;
        if (baVar != null) {
            baVar.d(map);
        }
    }

    public static String u() {
        ba baVar = d;
        if (baVar != null) {
            return baVar.uo();
        }
        return null;
    }

    public static JSONObject an() {
        if (u != null) {
            return u.jh();
        }
        return null;
    }

    public static <T> T d(String str, T t) {
        ba baVar = d;
        if (baVar != null) {
            return (T) baVar.d(str, t);
        }
        return null;
    }

    public static void d(String str, JSONObject jSONObject) {
        de.d(new nw(str, false, jSONObject != null ? jSONObject.toString() : null));
    }

    public static void d(String str, JSONObject jSONObject, int i) {
        de.d(new nw(str, false, jSONObject != null ? jSONObject.toString() : null, i));
    }

    public static void d(String str, Bundle bundle) {
        JSONObject jSONObject = null;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        for (String str2 : bundle.keySet()) {
                            jSONObject2.put(str2, bundle.get(str2));
                        }
                        jSONObject = jSONObject2;
                    } catch (Throwable th) {
                        th = th;
                        jSONObject = jSONObject2;
                        um.hc(th);
                        d(str, jSONObject);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        d(str, jSONObject);
    }

    public static void d(String str, Bundle bundle, int i) {
        JSONObject jSONObject = null;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        for (String str2 : bundle.keySet()) {
                            jSONObject2.put(str2, bundle.get(str2));
                        }
                        jSONObject = jSONObject2;
                    } catch (Throwable th) {
                        th = th;
                        jSONObject = jSONObject2;
                        um.hc(th);
                        d(str, jSONObject, i);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        d(str, jSONObject, i);
    }

    public static void hc(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() <= 0) {
            um.hc("call onEventData with invalid params, return", null);
            return;
        }
        try {
            de.d(new ia(str, jSONObject));
        } catch (Exception e) {
            um.b("call onEventData get exception: ", e);
        }
    }

    public static String gb() {
        ba baVar = d;
        return baVar != null ? baVar.h() : "";
    }

    public static String tt() {
        ba baVar = d;
        return baVar != null ? baVar.tt() : "";
    }

    public static String tc() {
        ba baVar = d;
        return baVar != null ? baVar.tc() : "";
    }

    public static b mk() {
        return qr.d();
    }

    public static void d(u uVar) {
        f.d(uVar);
    }

    public static gb mq() {
        if (u != null) {
            return u.wl();
        }
        return null;
    }
}

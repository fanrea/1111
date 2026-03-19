package com.qq.e.comm.plugin;

import android.os.Build;
import android.util.Pair;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class c5 {
    private static void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        jSONObject.putOpt("ast", x1.a(r1.d()));
        jSONObject.putOpt(com.kuaishou.weapon.p0.t.o, o3.d().c());
        jSONObject.put("pms_istl_pkg", ym.a());
        jSONObject.putOpt("c_osver", Build.VERSION.RELEASE);
    }

    public static String a(Map<String, Object> map) throws JSONException {
        int iA;
        b10.a(1408000, (f5) null);
        int iIntValue = -1;
        if (map != null) {
            try {
                Object obj = map.get("staIn");
                iA = obj instanceof String ? kp.b().a((String) obj) : -1;
                Object obj2 = map.get("meSrc");
                if (obj2 instanceof Integer) {
                    iIntValue = ((Integer) obj2).intValue();
                    kp.b().a(iIntValue);
                }
            } catch (Exception e) {
                e.getMessage();
                return "";
            }
        } else {
            iA = -1;
        }
        JSONObject jSONObject = new JSONObject();
        boolean z = true;
        if (r1.d().f().a("sgbcids", 1) != 1) {
            z = false;
        }
        Pair<String, String> pairF = c20.f();
        if (pairF != null) {
            jSONObject.put("taid", pairF.first);
            if (z) {
                jSONObject.put("oaid", pairF.second);
            }
        }
        if (z) {
            jSONObject.put("anid", ma.ANDROIDID.c().a(r1.d().a()));
            jSONObject.put(com.baidu.mobads.container.adrequest.g.z, ma.IMEI.c().a(r1.d().a()));
        }
        jSONObject.put("sdkver", su.c());
        if (iIntValue > 0) {
            jSONObject.put("mc_f", iIntValue);
        }
        if (iA > 0) {
            jSONObject.put("mc_s", iA);
        }
        x1.a(jSONObject, (w1) null);
        jSONObject.put("c_ori", ht.a());
        jSONObject.put("support_features", p10.a());
        jSONObject.put("tpl2_info", a());
        jSONObject.put("support_h265", oi.a().a(r1.d()));
        Long lB = u1.a().b();
        if (lB != null) {
            jSONObject.put("lrts", lB);
        }
        if (ar.b()) {
            jSONObject.put("c_devicetype", t10.c());
        }
        return lx.a(jSONObject.toString());
    }

    public static String a(String str) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("wx_installed", i50.a(true));
            jSONObject.put("opensdk_ver", i50.a());
            jSONObject.put("support_features", p10.a());
            jSONObject.put("qq_ver", m3.a());
            jSONObject.put("tpl2_info", a());
            x1.a(jSONObject, str, (w1) null);
            a(jSONObject);
            return lx.a(jSONObject.toString());
        } catch (Exception e) {
            e.getMessage();
            return "";
        }
    }

    private static JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(String.valueOf(e2.SPLASH.c), 2);
        jSONObject.put(String.valueOf(e2.UNIFIED_INTERSTITIAL.c), 2);
        jSONObject.put(String.valueOf(e2.NATIVEEXPRESSAD.c), 2);
        jSONObject.put(String.valueOf(e2.UNIFIED_BANNER.c), 2);
        jSONObject.put(String.valueOf(e2.NATIVEUNIFIEDAD.c), 2);
        jSONObject.put(String.valueOf(e2.UNIFIED_INTERSTITIAL_FULLSCREEN.c), 2);
        jSONObject.put(String.valueOf(e2.REWARDVIDEOAD.c), 2);
        return jSONObject;
    }
}

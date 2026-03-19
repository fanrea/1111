package com.bytedance.sdk.component.gb.hc;

import android.text.TextUtils;
import com.bytedance.sdk.component.gb.d.an;
import com.bytedance.sdk.component.gb.d.h;
import com.bytedance.sdk.component.gb.d.u;
import com.bytedance.sdk.component.utils.mq;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    public static final ConcurrentHashMap<String, hc> d = new ConcurrentHashMap<>();
    private static volatile List<com.bytedance.sdk.component.gb.d.b> hc = new ArrayList();
    private static ConcurrentHashMap<String, u> b = new ConcurrentHashMap<>();

    public static h d(com.bytedance.sdk.component.gb.d.d dVar) {
        if (dVar == null || TextUtils.isEmpty(dVar.u()) || dVar.getContext() == null) {
            mq.c("csj_log_error", "config or adLogFrom or context is null");
            return null;
        }
        ConcurrentHashMap<String, hc> concurrentHashMap = d;
        hc hcVar = concurrentHashMap.get(dVar.u());
        if (hcVar == null) {
            hcVar = new hc(dVar);
        } else {
            hcVar.hc(dVar);
        }
        concurrentHashMap.put(dVar.u(), hcVar);
        return hcVar;
    }

    public static void d(an anVar, String str) {
        b(str).d(anVar);
    }

    public static void d(boolean z, String str) {
        b(str).d(z);
    }

    public static List<com.bytedance.sdk.component.gb.d.b> d() {
        return hc;
    }

    public static void d(com.bytedance.sdk.component.gb.d.b bVar) {
        if (bVar != null) {
            hc.add(bVar);
        }
    }

    public static boolean d(String str) {
        hc hcVar = d.get(str);
        return hcVar == null || hcVar.b() == null || hcVar.c() == null || hcVar.u() == null;
    }

    public static void hc(String str) {
        d(false, str);
        b(str).d();
    }

    public static h b(String str) {
        ConcurrentHashMap<String, hc> concurrentHashMap = d;
        hc hcVar = concurrentHashMap.get(str);
        if (hcVar != null) {
            return hcVar;
        }
        hc hcVar2 = new hc();
        concurrentHashMap.put(str, hcVar2);
        return hcVar2;
    }

    public static void d(String str, String str2) {
        b(str).d(str2);
    }

    public static void d(String str, String str2, List<String> list, boolean z, Map<String, String> map, JSONObject jSONObject) {
        b(str).d(str2, list, z, map, jSONObject);
    }

    public static void d(com.bytedance.sdk.component.gb.d.hc hcVar, String str) {
        b(str).d(hcVar);
    }

    public static void c(String str) {
        b(str).hc();
    }

    public static u u(String str) {
        u uVarB = b.get(str);
        if (uVarB == null && (uVarB = b(str).b()) != null) {
            b.put(str, uVarB);
        }
        return uVarB;
    }
}

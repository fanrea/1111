package com.bytedance.msdk.u;

import android.content.Context;
import com.bytedance.msdk.gb.he;
import com.bytedance.msdk.u.hc;
import com.bytedance.sdk.component.gb.d.d;
import com.bytedance.sdk.component.utils.mq;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private static volatile boolean d = false;
    private static final AtomicLong hc = new AtomicLong(0);

    public static void d() {
        d = true;
    }

    public static boolean hc() {
        return d;
    }

    public static void d(Context context) {
        int iHe = com.bytedance.msdk.core.hc.hc().he();
        com.bytedance.sdk.component.gb.hc.d.d(new d.C0276d().d(new tt()).hc(com.bytedance.sdk.component.gb.hc.c.hc.d.d(iHe, iHe, 172800000L)).hc(com.bytedance.msdk.core.d.mk().uo()).d(new tc()).d(mk.d).d("csj_mediation").d(context).d());
        com.bytedance.sdk.component.gb.hc.d.hc("csj_mediation");
    }

    public static void d(Context context, c cVar, Map<String, Object> map) {
        if (com.bytedance.msdk.core.hc.hc().k()) {
            Context context2 = context == null ? com.bytedance.msdk.core.hc.getContext() : context;
            JSONObject jSONObject = new JSONObject();
            if (map != null) {
                try {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                } catch (JSONException unused) {
                }
            }
            jSONObject.put("eventIndex", hc.getAndIncrement());
            jSONObject.put("is_main_process", he.d(context));
            jSONObject.put("is_cypher_v4", com.bytedance.msdk.core.hc.d().d());
            if (com.bytedance.msdk.core.d.mk().tt()) {
                jSONObject.put("e2e_test_flag", "1");
            }
            if (cVar != null) {
                cVar.d("event_id", UUID.randomUUID().toString());
            }
            JSONObject jSONObjectD = d.d(cVar, jSONObject);
            if (!d) {
                hc.d().d(cVar, jSONObjectD);
            } else {
                d(context2, cVar, jSONObjectD);
            }
        }
    }

    public static void hc(Context context) {
        try {
            List<hc.d> listHc = hc.d().hc();
            if (listHc != null) {
                for (hc.d dVar : listHc) {
                    if (dVar != null) {
                        d(context, dVar.d(), dVar.hc());
                    }
                }
            }
            hc.d().b();
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    private static void d(Context context, c cVar, JSONObject jSONObject) {
        if (com.bytedance.sdk.component.gb.hc.d.d("csj_mediation")) {
            d(context);
        }
        h hVarD = h.d(context, cVar, jSONObject);
        com.bytedance.msdk.gb.c.hc.d(hVarD, true);
        com.bytedance.sdk.component.gb.hc.c.d.d dVar = new com.bytedance.sdk.component.gb.hc.c.d.d(hVarD.d, hVarD);
        dVar.d((byte) 3);
        dVar.hc((byte) 2);
        com.bytedance.sdk.component.gb.hc.d.d(dVar, "csj_mediation");
    }

    public static void b() {
        com.bytedance.sdk.component.gb.hc.d.c("csj_mediation");
    }
}

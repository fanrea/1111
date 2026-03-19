package com.bytedance.msdk.an.hc;

import android.util.SparseArray;
import com.bytedance.msdk.api.c.tc;
import com.bytedance.sdk.openadsdk.core.s;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u {
    public static void d(com.bytedance.sdk.openadsdk.w.c cVar) {
        com.bytedance.sdk.openadsdk.w.b.b.d dVar = new com.bytedance.sdk.openadsdk.w.b.b.d(com.bytedance.msdk.core.d.mk().y().sparseArray());
        cVar.d(8475, com.bytedance.sdk.openadsdk.w.b.c.d(d(dVar.mk())));
        cVar.d(8457, com.bytedance.sdk.openadsdk.w.b.c.d(d(dVar.e())));
        cVar.d(1, Boolean.valueOf(com.bytedance.msdk.h.d.d.d().tt()));
    }

    public static void d(com.bytedance.sdk.openadsdk.w.c cVar, com.bytedance.sdk.openadsdk.w.c cVar2) {
        cVar.d(8424, com.bytedance.sdk.openadsdk.w.b.c.d(cVar2.hc()));
    }

    public static SparseArray<Object> d(com.bytedance.sdk.openadsdk.mediation.init.d.hc.d.d dVar) {
        if (dVar == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.w.c cVarD = com.bytedance.sdk.openadsdk.w.c.d();
        cVarD.d(8458, Boolean.valueOf(dVar.u()));
        cVarD.d(8459, dVar.mk());
        cVarD.d(8460, dVar.d());
        cVarD.d(8461, Boolean.valueOf(dVar.hc()));
        cVarD.d(8310, new gb(dVar.b()));
        cVarD.d(8462, dVar.c());
        cVarD.d(8463, dVar.an());
        cVarD.d(8464, dVar.h());
        cVarD.d(8465, Boolean.valueOf(dVar.gb()));
        cVarD.d(8466, Boolean.valueOf(dVar.tt()));
        cVarD.d(8467, Boolean.valueOf(dVar.tc()));
        return cVarD.hc();
    }

    public static SparseArray<Object> d(com.bytedance.sdk.openadsdk.w.b.b.c cVar) {
        com.bytedance.sdk.openadsdk.w.c cVarD = com.bytedance.sdk.openadsdk.w.c.d();
        if (cVar != null) {
            cVarD.d(8311, new d(cVar.cb()));
            cVarD.d(8023, Boolean.valueOf(cVar.b()));
            cVarD.d(8024, Boolean.valueOf(cVar.d()));
            cVarD.d(8025, Boolean.valueOf(cVar.u()));
            cVarD.d(8026, Boolean.valueOf(cVar.hc()));
            cVarD.d(8480, Boolean.valueOf(cVar.c()));
            cVarD.d(8479, Boolean.valueOf(cVar.an()));
            cVarD.d(8312, cVar.tt() != null ? new an(cVar.tt()) : null);
            cVarD.d(8483, cVar.tt());
            cVarD.d(8484, cVar.tc());
            cVarD.d(8485, cVar.k());
            cVarD.d(8486, cVar.mq());
            cVarD.d(8487, cVar.mk());
            cVarD.d(8554, cVar.e());
            cVarD.d(8549, Boolean.valueOf(cVar.h()));
        } else {
            cVarD.d(8311, new d(null));
            cVarD.d(8023, Boolean.TRUE);
            cVarD.d(8024, Boolean.TRUE);
            cVarD.d(8025, Boolean.TRUE);
            cVarD.d(8026, Boolean.TRUE);
            cVarD.d(8480, Boolean.TRUE);
            cVarD.d(8479, Boolean.TRUE);
            cVarD.d(8312, new an(null));
            cVarD.d(8483, (Object) null);
            cVarD.d(8484, "");
            cVarD.d(8485, "");
            cVarD.d(8486, "");
            cVarD.d(8487, "");
            cVarD.d(8549, Boolean.TRUE);
        }
        return cVarD.hc();
    }

    private static class d extends h {
        public d(com.bytedance.sdk.openadsdk.mediation.init.d.hc.d.hc hcVar) {
            super(hcVar);
        }

        @Override // com.bytedance.msdk.an.hc.h
        public boolean d() {
            int i = com.bytedance.msdk.core.hc.hc().to();
            if (i > 0) {
                return true;
            }
            if (i < 0) {
                return false;
            }
            return super.d();
        }

        @Override // com.bytedance.msdk.an.hc.h
        public boolean hc() {
            int iRa = com.bytedance.msdk.core.hc.hc().ra();
            if (iRa > 0) {
                return false;
            }
            if (iRa < 0) {
                return true;
            }
            return super.hc();
        }
    }

    public static void d() {
        tc.d(new com.bytedance.sdk.openadsdk.w.b.b.d(com.bytedance.msdk.core.d.mk().y().sparseArray()).mk());
    }

    public static JSONObject hc() {
        try {
            JSONObject jSONObject = new JSONObject();
            Map<String, com.bytedance.msdk.d.d.c> mapHc = hc.d().hc();
            if (mapHc != null && mapHc.size() > 0) {
                for (Map.Entry<String, com.bytedance.msdk.d.d.c> entry : mapHc.entrySet()) {
                    String key = entry.getKey();
                    com.bytedance.msdk.d.d.c value = entry.getValue();
                    long jU = value.u();
                    int iAn = value.an();
                    if (jU != 0) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("status", iAn);
                        jSONObject2.put("duration", jU);
                        jSONObject.put(key, jSONObject2);
                        value.h();
                    }
                }
            }
            if (com.bytedance.sdk.gromore.init.u.an > 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("status", 1);
                jSONObject3.put("duration", com.bytedance.sdk.gromore.init.u.an);
                jSONObject3.put("plugin", s.hc() ? 1 : 0);
                jSONObject.put("pangle", jSONObject3);
                com.bytedance.sdk.gromore.init.u.an = 0L;
            }
            if (com.bytedance.sdk.gromore.init.u.h > 0) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("status", 1);
                jSONObject4.put("duration", com.bytedance.sdk.gromore.init.u.h);
                jSONObject4.put("plugin", s.hc() ? 1 : 0);
                jSONObject.put("fusion", jSONObject4);
                com.bytedance.sdk.gromore.init.u.h = 0L;
            }
            if (com.bytedance.msdk.an.hc.d.c() != null && com.bytedance.msdk.an.hc.d.c().d() != null && com.bytedance.msdk.an.hc.d.c().d().size() > 0) {
                for (Map.Entry<String, com.bytedance.msdk.api.c.d.hc.an.d> entry2 : com.bytedance.msdk.an.hc.d.c().d().entrySet()) {
                    String key2 = entry2.getKey();
                    com.bytedance.msdk.api.c.d.hc.an.d value2 = entry2.getValue();
                    long jU2 = value2.u();
                    int iAn2 = value2.an();
                    if (jU2 != 0) {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("status", iAn2);
                        jSONObject5.put("duration", jU2);
                        jSONObject.put(key2, jSONObject5);
                        value2.h();
                    }
                }
            }
            if (jSONObject.length() == 0) {
                return null;
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }
}

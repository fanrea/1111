package com.bytedance.msdk.b.b.hc.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.bmf_mods.common.ErrorCode;
import com.bytedance.msdk.an.hc.u;
import com.bytedance.msdk.api.c.tt;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b extends hc {
    private com.bytedance.msdk.b.an.hc.hc b;
    private com.bytedance.msdk.api.d.hc c;
    private d hc;

    public b(com.bytedance.msdk.b.d.hc hcVar) {
        super(hcVar);
    }

    @Override // com.bytedance.msdk.b.b.hc.d.hc
    public void hc(Context context, com.bytedance.msdk.b.an.hc.hc hcVar, com.bytedance.msdk.api.d.hc hcVar2, Map<String, Object> map) throws ExecutionException, InterruptedException {
        this.b = hcVar;
        this.c = hcVar2;
        com.bytedance.sdk.openadsdk.w.c cVarD = d(hcVar, hcVar2, map);
        if (cVarD != null) {
            this.hc = new d(hcVar2, hcVar, this);
            cVarD.d(8429, hcVar.cb());
            cVarD.d(8430, hcVar.w());
            cVarD.d(8011, this.hc);
            cVarD.d(8010, hcVar.yo());
            cVarD.d(8561, Integer.valueOf(hcVar.r()));
            com.bytedance.msdk.an.hc.d.hc(hcVar.uo());
            d(context, cVarD);
        }
    }

    @Override // com.bytedance.msdk.b.b.hc.d.hc, com.bytedance.msdk.b.d.d
    public String d(Context context, com.bytedance.msdk.b.an.hc.hc hcVar, com.bytedance.msdk.api.d.hc hcVar2) {
        if (hcVar != null && hcVar2 != null) {
            HashMap map = new HashMap();
            map.put("bidding_token", "true");
            if (this.hc == null) {
                this.hc = new d(hcVar2, hcVar, this);
                com.bytedance.sdk.openadsdk.w.c cVarD = com.bytedance.sdk.openadsdk.w.c.d();
                cVarD.d(8011, this.hc);
                cVarD.d(8010, hcVar.yo());
                com.bytedance.sdk.openadsdk.w.c cVarD2 = com.bytedance.sdk.openadsdk.w.c.d();
                cVarD2.d(ErrorCode.EXECUTE_HYDRA_KERNEL_FAILED, map);
                com.bytedance.sdk.openadsdk.w.c cVarD3 = com.bytedance.sdk.openadsdk.w.c.d();
                cVarD3.d(8443, cVarD2.hc());
                cVarD.d(8090, com.bytedance.sdk.openadsdk.w.c.d(hcVar2.bc()).d(8089, cVarD3.hc()).hc());
                Function<SparseArray<Object>, Object> functionH = com.bytedance.msdk.core.mk.d.d().h();
                if (functionH != null) {
                    com.bytedance.sdk.openadsdk.w.c cVarD4 = com.bytedance.sdk.openadsdk.w.c.d();
                    cVarD4.d(8009, com.bytedance.msdk.d.u.d.d(context)).d(8106).d(Void.class);
                    u.d(cVarD4, cVarD);
                    functionH.apply(cVarD4.hc());
                } else {
                    com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "load ad class loader is null ");
                }
            }
            if (this.hc != null && hcVar2.sy() != null) {
                com.bytedance.sdk.openadsdk.mediation.hc.hc.hc hcVarZw = hcVar2.sy().zw();
                return this.hc.d(context, hcVar.mq(), com.bytedance.msdk.core.cb.d.d((Map<String, Object>) (hcVarZw != null ? hcVarZw.an() : null)));
            }
        }
        return null;
    }

    private void d(Context context, com.bytedance.sdk.openadsdk.w.c cVar) {
        com.bytedance.msdk.b.an.hc.hc hcVar = this.b;
        Function<SparseArray<Object>, Object> functionD = (hcVar == null || this.c == null) ? null : com.bytedance.msdk.core.d.d.u.d(hcVar.uo(), this.c.de(), this.b.e());
        if (functionD != null) {
            functionD.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8241).d(Void.class).d(8009, com.bytedance.msdk.d.u.d.d(context)).d(8424, cVar.hc()).hc());
        } else {
            hc(context, cVar);
        }
    }

    private void hc(Context context, com.bytedance.sdk.openadsdk.w.c cVar) {
        Function<SparseArray<Object>, Object> functionH = com.bytedance.msdk.core.mk.d.d().h();
        if (functionH != null) {
            if (com.bytedance.sdk.gromore.init.d.d() >= 5900) {
                com.bytedance.sdk.openadsdk.w.c cVarD = com.bytedance.sdk.openadsdk.w.c.d().d(8009, com.bytedance.msdk.d.u.d.d(context)).d(8106).d(Void.class);
                u.d(cVarD, cVar);
                functionH.apply(cVarD.hc());
                return;
            } else {
                cVar.d(8009, com.bytedance.msdk.d.u.d.d(context)).d(8106).d(Void.class);
                functionH.apply(cVar.hc());
                return;
            }
        }
        com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "load ad class loader is null ");
    }

    private com.bytedance.sdk.openadsdk.w.c d(com.bytedance.msdk.b.an.hc.hc hcVar, com.bytedance.msdk.api.d.hc hcVar2, Map<String, Object> map) {
        HashMap map2 = null;
        if (hcVar == null || hcVar2 == null || hcVar2.sy() == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.w.c cVarD = com.bytedance.sdk.openadsdk.w.c.d();
        com.bytedance.sdk.openadsdk.mediation.hc.hc.d dVarSy = hcVar2.sy();
        com.bytedance.sdk.openadsdk.mediation.hc.hc.hc hcVarZw = dVarSy.zw();
        com.bytedance.sdk.openadsdk.w.c cVarD2 = com.bytedance.sdk.openadsdk.w.c.d(hcVar2.bc()).d(15, dVarSy.k()).d(13, Integer.valueOf(hcVar2.vv())).d(7, Integer.valueOf(dVarSy.an())).d(8, Integer.valueOf(dVarSy.h())).d(16, Integer.valueOf(dVarSy.e())).d(20, Integer.valueOf(dVarSy.yo())).d(11, Boolean.valueOf(dVarSy.tc())).d(17, Integer.valueOf(hcVar2.w()));
        com.bytedance.sdk.openadsdk.w.c cVarD3 = com.bytedance.sdk.openadsdk.w.c.d();
        HashMap map3 = new HashMap();
        if (hcVarZw != null) {
            if (hcVarZw.an() != null) {
                map3.putAll(hcVarZw.an());
            }
            if (hcVar.gb() != null) {
                map3.put("waterfall_config", hcVar.gb());
            }
            map3.put("dynamic_adapter_type", Integer.valueOf(com.bytedance.msdk.h.d.d.d().c()));
            map3.put("wf_dynamic_adapter_type", Integer.valueOf(com.bytedance.msdk.h.d.d.d().u()));
            com.bytedance.msdk.core.c.d.d(hcVar2, hcVar.gb(), map3);
            cVarD3.d(8444, Boolean.valueOf(hcVarZw.b())).d(8445, Boolean.valueOf(hcVarZw.d())).d(8446, Boolean.valueOf(hcVarZw.hc())).d(8447, Float.valueOf(hcVarZw.c())).d(ErrorCode.EXECUTE_HYDRA_FAILED, Boolean.valueOf(hcVarZw.u())).d(8450, Boolean.valueOf(hcVarZw.h())).d(8451, hcVarZw.gb()).d(8454, Boolean.valueOf(hcVarZw.tt())).d(8455, Float.valueOf(hcVarZw.mk())).d(8456, Float.valueOf(hcVarZw.mq()));
        } else {
            map3.put("dynamic_adapter_type", Integer.valueOf(com.bytedance.msdk.h.d.d.d().c()));
            map3.put("wf_dynamic_adapter_type", Integer.valueOf(com.bytedance.msdk.h.d.d.d().u()));
        }
        tt ttVarHc = com.bytedance.msdk.core.d.mk().j().hc();
        if (ttVarHc != null) {
            map3.put("lng", Double.valueOf(ttVarHc.hc()));
            map3.put("lat", Double.valueOf(ttVarHc.d()));
            map3.put("loc_time", Long.valueOf(System.currentTimeMillis() / 1000));
        } else {
            map3.put("lng", -1);
            map3.put("lat", -1);
            map3.put("loc_time", -1);
        }
        map3.put("load_type", com.bytedance.msdk.core.d.d.u.d());
        map3.put("load_can_log", Boolean.valueOf(com.bytedance.msdk.h.d.d.d().tt()));
        cVarD3.d(ErrorCode.EXECUTE_HYDRA_KERNEL_FAILED, map3);
        cVarD3.d(8044, map3);
        d(cVarD3, dVarSy, hcVarZw);
        cVarD2.d(8443, cVarD3.hc());
        cVarD.d(8090, com.bytedance.sdk.openadsdk.w.b.c.d(com.bytedance.sdk.openadsdk.w.c.d(hcVar2.bc()).d(8089, cVarD2.hc()).hc()));
        cVarD.d(8007, hcVar.mq());
        cVarD.d(4, hcVar2.v());
        cVarD.d(8003, hcVar.uo());
        cVarD.d(17, Integer.valueOf(hcVar2.w()));
        if (hcVar2.hv() != null) {
            HashMap map4 = new HashMap();
            for (Map.Entry<String, Object> entry : hcVar2.hv().entrySet()) {
                Object value = entry.getValue();
                map4.put(entry.getKey(), value == null ? null : value.toString());
            }
            map2 = map4;
        }
        if (map2 != null) {
            cVarD.d(8013, map2);
        }
        if (map != null) {
            cVarD.d(8096, Integer.valueOf(map.get("ad_load_timeout") != null ? ((Integer) map.get("ad_load_timeout")).intValue() : 3000));
        }
        Object obj = map.get("contentUrl");
        if (obj instanceof String) {
            cVarD.d(8083, (String) obj);
        }
        Object obj2 = map.get("testDevices");
        if (obj2 instanceof String) {
            cVarD.d(8084, (String) obj2);
        }
        Object obj3 = map.get("tt_ad_origin_type");
        if (obj3 != null) {
            int iIntValue = ((Integer) obj3).intValue();
            if (iIntValue == 1 || iIntValue == 3) {
                cVarD.d(8033, Boolean.TRUE);
            }
            cVarD.d(8085, Integer.valueOf(iIntValue));
        }
        Object obj4 = map.get("tt_ad_sub_type");
        if (obj4 != null) {
            cVarD.d(8094, Integer.valueOf(((Integer) obj4).intValue()));
        }
        Object obj5 = map.get("render_control");
        if (obj5 instanceof Integer) {
            cVarD.d(8553, Integer.valueOf(((Integer) obj5).intValue()));
        }
        return cVarD;
    }

    private void d(com.bytedance.sdk.openadsdk.w.c cVar, com.bytedance.sdk.openadsdk.mediation.hc.hc.d dVar, com.bytedance.sdk.openadsdk.mediation.hc.hc.hc hcVar) {
        if (cVar == null || dVar == null) {
            return;
        }
        if (hcVar != null && !TextUtils.isEmpty(hcVar.k()) && hcVar.e() != 0) {
            cVar.d(8452, hcVar.k());
            cVar.d(8453, Integer.valueOf(hcVar.e()));
        } else {
            if (TextUtils.isEmpty(dVar.np()) || dVar.yi() == 0) {
                return;
            }
            cVar.d(8452, dVar.np());
            cVar.d(8453, Integer.valueOf(dVar.yi()));
        }
    }

    @Override // com.bytedance.msdk.b.d.d
    public String d(String str) {
        com.bytedance.msdk.d.d.c cVarD = com.bytedance.msdk.an.hc.hc.d().d(str);
        if (cVarD != null) {
            return cVarD.hc();
        }
        return null;
    }
}

package com.bytedance.msdk.core.hc;

import com.baidu.mobads.container.rewardvideo.RemoteRewardActivity;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    public static void d(com.bytedance.msdk.hc.b bVar, com.bytedance.msdk.api.d.hc hcVar, Map<String, Object> map) {
        if (com.bytedance.msdk.core.hc.hc().r()) {
            String strV = hcVar != null ? hcVar.v() : null;
            hc hcVarBc = com.bytedance.msdk.core.hc.hc().bc();
            if (hcVarBc != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("lt_days", Integer.valueOf(hcVarBc.d()));
                    jSONObject.putOpt("rule_id", hcVarBc.b(strV));
                } catch (Exception e) {
                    com.bytedance.msdk.d.u.b.c("AdLoadEventManager", "put 元素 异常：" + e.getMessage());
                }
                try {
                    jSONObject.putOpt(RemoteRewardActivity.JSON_BANNER_SCORE_ID, Float.valueOf(com.bytedance.msdk.core.d.mk().d(strV)));
                } catch (Exception e2) {
                    com.bytedance.msdk.d.u.b.c("AdLoadEventManager", "put 元素异常：" + e2.getMessage());
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.putOpt("dis_c", Integer.valueOf(d.hc(strV)));
                    jSONObject2.putOpt("ins_d", Integer.valueOf(d.u()));
                    jSONObject2.putOpt("act_d", Integer.valueOf(d.hc()));
                    jSONObject2.putOpt("act_times", Integer.valueOf(d.c()));
                    jSONObject.putOpt("active_target", jSONObject2);
                } catch (Exception e3) {
                    com.bytedance.msdk.d.u.b.c("AdLoadEventManager", "put 元素异常：" + e3.getMessage());
                }
                if (hcVar != null && hcVar.hv() != null) {
                    Map<String, Object> mapHv = hcVar.hv();
                    if (mapHv.containsKey("usePolicy")) {
                        try {
                            jSONObject.putOpt("user_enter", mapHv.get("usePolicy"));
                        } catch (Exception e4) {
                            com.bytedance.msdk.d.u.b.c("AdLoadEventManager", "put 元素异常：" + e4.getMessage());
                        }
                    }
                }
                map.put("dynamic_policy", jSONObject);
            }
        }
    }
}

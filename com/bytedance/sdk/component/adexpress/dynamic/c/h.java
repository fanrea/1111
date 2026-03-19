package com.bytedance.sdk.component.adexpress.dynamic.c;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.component.adexpress.hc.uo;
import com.bytedance.sdk.component.utils.mq;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h implements gb {
    private com.bytedance.sdk.component.adexpress.dynamic.u.hc d;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.c.gb
    public void d(com.bytedance.sdk.component.adexpress.dynamic.u.hc hcVar) {
        this.d = hcVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.c.gb
    public void d(final uo uoVar) {
        if (uoVar.e() == 1) {
            hc(uoVar);
        } else {
            com.bytedance.sdk.component.adexpress.c.u.d(new com.bytedance.sdk.component.tc.tt("dynamicparse") { // from class: com.bytedance.sdk.component.adexpress.dynamic.c.h.1
                @Override // java.lang.Runnable
                public void run() {
                    h.this.hc(uoVar);
                }
            }, 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc(uo uoVar) {
        try {
            JSONObject jSONObjectU = uoVar.u();
            JSONObject jSONObject = new JSONObject(jSONObjectU.optString("template_Plugin"));
            JSONObject jSONObjectOptJSONObject = jSONObjectU.optJSONObject("creative");
            com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVarD = new an(jSONObject, jSONObjectOptJSONObject, jSONObjectU.optJSONObject("AdSize"), new JSONObject(jSONObjectU.optString("diff_template_Plugin"))).d(uoVar.c(), uoVar.uo(), jSONObjectOptJSONObject.optDouble("score_exact_i18n"), jSONObjectOptJSONObject.optString("comment_num_i18n"), uoVar);
            try {
                JSONObject jSONObject2 = new JSONObject(jSONObjectOptJSONObject.optString("dynamic_creative"));
                gbVarD.d(jSONObject2.optString(TypedValues.Custom.S_COLOR));
                gbVarD.d(jSONObject2.optJSONArray("material_center"));
            } catch (Throwable unused) {
            }
            this.d.d(gbVarD);
        } catch (Exception e) {
            mq.d(e);
        }
    }
}

package com.bytedance.msdk.u;

import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.msdk.gb.zw;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tt implements com.bytedance.sdk.component.gb.d.mk {
    public com.bytedance.msdk.u.hc.d<d> d;
    private static final Handler hc = new Handler(com.bytedance.msdk.d.u.an.hc());
    private static final Runnable b = new Runnable() { // from class: com.bytedance.msdk.u.tt.2
        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.msdk.d.u.b.d("TMe", "--==--- upload event routine");
            com.bytedance.sdk.component.gb.hc.d.c("csj_mediation");
            tt.hc();
        }
    };

    @Override // com.bytedance.sdk.component.gb.d.mk
    public void d(final List<com.bytedance.sdk.component.gb.d.hc> list, final com.bytedance.sdk.component.gb.d.tc tcVar) {
        if (list != null && list.size() > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            final ArrayList arrayList = new ArrayList();
            int i = 0;
            JSONObject jSONObject = null;
            for (com.bytedance.sdk.component.gb.d.hc hcVar : list) {
                JSONObject jSONObjectH = hcVar.h();
                byte bU = hcVar.u();
                byte bC = hcVar.c();
                if (bU == 2 && bC == 3) {
                    hc(jSONObjectH, list.size(), jCurrentTimeMillis, i, jSONObject);
                    arrayList.add(new h(hcVar.b(), jSONObjectH));
                } else {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("not_v3", jSONObjectH);
                        jSONObject2.putOpt("batchId", Long.valueOf(jCurrentTimeMillis));
                        jSONObject2.putOpt("batchIndex", Integer.valueOf(i));
                        zw.d(jSONObject2);
                    } catch (Throwable unused) {
                    }
                }
                i++;
                jSONObject = jSONObjectH;
            }
            if (arrayList.size() > 0) {
                com.bytedance.msdk.d.u.an.h().execute(new Runnable() { // from class: com.bytedance.msdk.u.tt.1
                    @Override // java.lang.Runnable
                    public void run() {
                        u uVarD = tt.this.d(arrayList);
                        if (tcVar == null || uVarD == null) {
                            return;
                        }
                        com.bytedance.sdk.component.gb.hc.hc.b.hc hcVar2 = new com.bytedance.sdk.component.gb.hc.hc.b.hc(uVarD.d, uVarD.hc, uVarD.b, uVarD.c, "");
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(new com.bytedance.sdk.component.gb.hc.hc.b.d(hcVar2, list));
                        tcVar.d(arrayList2);
                        if (uVarD.d) {
                            tt.hc();
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hc() {
        Handler handler = hc;
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(b, com.bytedance.msdk.core.hc.hc().vv());
    }

    private void d(JSONObject jSONObject, int i, long j, int i2, JSONObject jSONObject2) {
        if (jSONObject != null) {
            try {
                String strOptString = jSONObject.optString("event_extra");
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                JSONObject jSONObject3 = new JSONObject(strOptString);
                jSONObject3.putOpt("size", Integer.valueOf(i));
                jSONObject3.putOpt("batchId", Long.valueOf(j));
                jSONObject3.putOpt("batchIndex", Integer.valueOf(i2));
                jSONObject3.putOpt("preEventId", jSONObject2 != null ? jSONObject2.optString("event_id") : "-1");
                jSONObject.put("event_extra", jSONObject3.toString());
            } catch (Throwable unused) {
            }
        }
    }

    private void hc(JSONObject jSONObject, int i, long j, int i2, JSONObject jSONObject2) {
        if (jSONObject != null) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("params");
                if (jSONObjectOptJSONObject != null) {
                    d(jSONObjectOptJSONObject, i, j, i2, jSONObject2 != null ? jSONObject2.optJSONObject("params") : null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public u d(List<d> list) {
        try {
            if (this.d == null) {
                this.d = com.bytedance.msdk.core.hc.d();
            }
        } catch (Exception unused) {
        }
        com.bytedance.msdk.u.hc.d<d> dVar = this.d;
        if (dVar == null) {
            return null;
        }
        return dVar.d(list);
    }
}

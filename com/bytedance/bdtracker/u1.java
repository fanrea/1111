package com.bytedance.bdtracker;

import android.content.Context;
import com.bytedance.applog.util.HardwareUtils;
import com.bytedance.bdtracker.l0;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u1 extends l1 {
    public final Context e;
    public final s1 f;
    public final q1 g;

    public u1(Context context, q1 q1Var, s1 s1Var) {
        super(false, false);
        this.e = context;
        this.f = s1Var;
        this.g = q1Var;
    }

    @Override // com.bytedance.bdtracker.l1
    public String a() {
        return "DeviceParams";
    }

    @Override // com.bytedance.bdtracker.l1
    public boolean a(JSONObject jSONObject) {
        q1 q1Var = this.g;
        if (q1Var.c.isOperatorInfoEnabled() && !q1Var.a("carrier")) {
            String operatorName = HardwareUtils.getOperatorName(this.e);
            if (l0.b.d(operatorName)) {
                s1.a(jSONObject, "carrier", operatorName);
            }
            String operatorMccMnc = HardwareUtils.getOperatorMccMnc(this.e);
            if (l0.b.d(operatorMccMnc)) {
                s1.a(jSONObject, "mcc_mnc", operatorMccMnc);
            }
        }
        s1.a(jSONObject, "clientudid", ((m4) this.f.h).a());
        s1.a(jSONObject, "openudid", ((m4) this.f.h).c());
        return true;
    }
}

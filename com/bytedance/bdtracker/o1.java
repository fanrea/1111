package com.bytedance.bdtracker;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class o1 extends l1 {
    public final q1 e;

    public o1(q1 q1Var) {
        super(true, false);
        this.e = q1Var;
    }

    @Override // com.bytedance.bdtracker.l1
    public String a() {
        return "Cdid";
    }

    @Override // com.bytedance.bdtracker.l1
    public boolean a(JSONObject jSONObject) throws JSONException {
        String strA = h5.a(this.e.f);
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        jSONObject.put("cdid", strA);
        return true;
    }
}

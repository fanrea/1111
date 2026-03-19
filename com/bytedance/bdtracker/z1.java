package com.bytedance.bdtracker;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class z1 extends l1 {
    public final Context e;

    public z1(Context context) {
        super(true, true);
        this.e = context;
    }

    @Override // com.bytedance.bdtracker.l1
    public String a() {
        return "Net";
    }

    @Override // com.bytedance.bdtracker.l1
    public boolean a(JSONObject jSONObject) {
        s1.a(jSONObject, "access", s4.a(this.e, true));
        return true;
    }
}

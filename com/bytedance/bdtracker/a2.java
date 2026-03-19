package com.bytedance.bdtracker;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class a2 extends l1 {
    public final Context e;
    public final q1 f;

    public a2(Context context, q1 q1Var) {
        super(true, false);
        this.e = context;
        this.f = q1Var;
    }

    @Override // com.bytedance.bdtracker.l1
    public String a() {
        return "Oaid";
    }

    @Override // com.bytedance.bdtracker.l1
    public boolean a(JSONObject jSONObject) throws JSONException {
        SharedPreferences sharedPreferences = this.f.f;
        if (!r0.j()) {
            return true;
        }
        Map mapA = h5.a(this.e);
        if (mapA == null) {
            return false;
        }
        jSONObject.put("oaid", new JSONObject(mapA));
        return true;
    }
}

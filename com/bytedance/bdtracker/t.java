package com.bytedance.bdtracker;

import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.bdtracker.b;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class t implements b.f {
    public final /* synthetic */ d4 a;

    public t(d4 d4Var) {
        this.a = d4Var;
    }

    @Override // com.bytedance.bdtracker.b.f
    public t3 a() {
        d4 d4Var = (d4) this.a.m347clone();
        JSONObject jSONObjectOptJSONObject = d4Var.h().optJSONObject("params");
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
        }
        try {
            jSONObjectOptJSONObject.put("$page_duration", d4Var.s);
        } catch (Throwable th) {
            LoggerImpl.global().error("JSON handle failed", th, new Object[0]);
        }
        a4 a4Var = new a4("$bav2b_page_leave");
        a4Var.a(0L);
        a4Var.o = jSONObjectOptJSONObject;
        return a4Var;
    }
}

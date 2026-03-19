package com.baidu.mobads.container.components.j;

import com.baidu.mobads.container.components.g.k;
import com.baidu.mobstat.forbes.Config;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class d implements com.baidu.mobads.container.components.g.a {
    final /* synthetic */ JSONObject a;
    final /* synthetic */ long b;
    final /* synthetic */ c c;

    d(c cVar, JSONObject jSONObject, long j) {
        this.c = cVar;
        this.a = jSONObject;
        this.b = j;
    }

    @Override // com.baidu.mobads.container.components.g.a
    public void a(String str, int i) throws JSONException {
        if (com.baidu.mobads.container.h.a.a().G()) {
            try {
                this.a.put(Config.STAT_SDK_TYPE, this.b);
                this.a.put(Config.EXCEPTION_CRASH_TYPE, System.currentTimeMillis() - this.b);
                this.a.put("code", i);
                this.a.put("msg", str);
            } catch (JSONException e) {
                com.baidu.mobads.container.l.g.b(e);
            }
            this.c.e.a(this.a.toString());
            this.c.c();
        }
    }

    @Override // com.baidu.mobads.container.components.g.a
    public void a(com.baidu.mobads.container.components.g.d dVar, k kVar) {
    }
}

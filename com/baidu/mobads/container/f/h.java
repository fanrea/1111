package com.baidu.mobads.container.f;

import com.component.a.g.g;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class h extends g.b {
    final /* synthetic */ com.baidu.mobads.container.adrequest.j a;
    final /* synthetic */ float b;
    final /* synthetic */ b c;

    h(b bVar, com.baidu.mobads.container.adrequest.j jVar, float f) {
        this.c = bVar;
        this.a = jVar;
        this.b = f;
    }

    @Override // com.component.a.g.g.b
    public void a(String str, String str2, JSONObject jSONObject) {
        try {
            if (!"dislike_view".equals(str2)) {
                if (this.b > 0.0f && this.c.g(str)) {
                    this.c.a(jSONObject, this.b);
                }
            } else {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("config");
                if (jSONObjectOptJSONObject != null) {
                    if (1 == jSONObjectOptJSONObject.optInt("px_close", 0)) {
                        this.c.f(this.a.getUniqueId());
                    }
                }
            }
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.b(th);
        }
    }
}

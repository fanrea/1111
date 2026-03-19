package com.component.a.g;

import com.component.a.g.g;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class e extends g.b {
    final /* synthetic */ g.b a;
    final /* synthetic */ d b;

    e(d dVar, g.b bVar) {
        this.b = dVar;
        this.a = bVar;
    }

    @Override // com.component.a.g.g.b
    public boolean a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            if (this.a != null) {
                return this.a.a(str, jSONObject, jSONObject2);
            }
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.b(th);
        }
        return super.a(str, jSONObject, jSONObject2);
    }

    @Override // com.component.a.g.g.b
    public void a(String str, String str2, JSONObject jSONObject) {
        try {
            if (this.a != null) {
                this.a.a(str, str2, jSONObject);
            }
            this.b.h.a(str, jSONObject);
            this.b.h.b(str, jSONObject);
            this.b.i.a(jSONObject);
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.b(th);
        }
    }
}

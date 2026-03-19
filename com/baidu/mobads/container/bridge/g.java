package com.baidu.mobads.container.bridge;

import com.baidu.mobads.container.bridge.b;
import com.baidu.mobads.container.util.bh;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class g implements bh.a {
    final /* synthetic */ b.a a;
    final /* synthetic */ bh b;
    final /* synthetic */ b c;

    g(b bVar, b.a aVar, bh bhVar) {
        this.c = bVar;
        this.a = aVar;
        this.b = bhVar;
    }

    @Override // com.baidu.mobads.container.util.bh.a
    public void a() {
        JSONObject jSONObjectC = this.c.c("202", "over 5 seconds");
        this.c.b(this.a.i, jSONObjectC);
        this.c.a(713, "wait_over_time", this.a.e, this.a.f, jSONObjectC);
    }

    @Override // com.baidu.mobads.container.util.bh.a
    public void a(int i) {
        JSONObject jSONObjectC;
        if (com.baidu.mobads.container.util.t.f(this.c.U, this.c.U.getPackageName())) {
            JSONObject jSONObjectG = this.c.g(this.a.e, this.a.h);
            if (jSONObjectG != null) {
                jSONObjectC = jSONObjectG;
            } else {
                jSONObjectC = this.c.c("202", "");
            }
            this.c.b(this.a.i, jSONObjectC);
            this.c.a(713, "success", this.a.e, this.a.f, jSONObjectC);
            this.b.b();
        }
    }
}

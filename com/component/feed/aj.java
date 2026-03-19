package com.component.feed;

import com.baidu.mobads.container.o.j;
import com.component.a.i.n;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class aj implements n.a {
    final /* synthetic */ com.baidu.mobads.container.adrequest.j a;
    final /* synthetic */ ah b;

    aj(ah ahVar, com.baidu.mobads.container.adrequest.j jVar) {
        this.b = ahVar;
        this.a = jVar;
    }

    @Override // com.component.a.i.n.a
    public void a(String str, com.component.a.f.e eVar) {
        JSONObject jSONObjectC = eVar.c();
        if (jSONObjectC != null && jSONObjectC.optInt("slide_enable", 0) == 1) {
            com.baidu.mobads.container.adrequest.n.a(this.a, j.a.GESTURE_VIEW.b(), jSONObjectC.optString("slide_dir", ""), jSONObjectC.optString("slide_check", ""), jSONObjectC.optString("slide_angle", ""));
        }
    }
}

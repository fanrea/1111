package com.baidu.mobads.container.f;

import com.baidu.mobads.container.p.a;
import java.util.HashMap;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class n implements a.b {
    final /* synthetic */ HashMap a;
    final /* synthetic */ b b;

    n(b bVar, HashMap map) {
        this.b = bVar;
        this.a = map;
    }

    @Override // com.baidu.mobads.container.p.a.b
    public void a(com.baidu.mobads.container.adrequest.j jVar, Boolean bool, Boolean bool2) throws JSONException {
        new com.baidu.mobads.container.components.k.c().a((com.baidu.mobads.container.k) this.b, jVar, (Boolean) true, this.a, bool2.booleanValue());
    }
}

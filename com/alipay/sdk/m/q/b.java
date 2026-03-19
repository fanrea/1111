package com.alipay.sdk.m.q;

import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b extends com.alipay.sdk.m.p.e {
    @Override // com.alipay.sdk.m.p.e
    public JSONObject a() throws JSONException {
        return com.alipay.sdk.m.p.e.a("sdkConfig", "obtain");
    }

    @Override // com.alipay.sdk.m.p.e
    public String b() {
        return "5.0.0";
    }

    @Override // com.alipay.sdk.m.p.e
    public boolean c() {
        return true;
    }

    @Override // com.alipay.sdk.m.p.e
    public String a(com.alipay.sdk.m.s.a aVar, HashMap<String, String> map, HashMap<String, String> map2) throws JSONException {
        if (map2 == null) {
            map2 = new HashMap<>();
        }
        map2.putAll(com.alipay.sdk.m.u.a.a(aVar));
        com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.A, "cf " + map2);
        return super.a(aVar, map, map2);
    }
}

package com.kwad.components.ad.adbit;

import com.kwad.sdk.utils.aa;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    public JSONObject dn;

    /* renamed from: do, reason: not valid java name */
    public Map<String, String> f2do;

    public a(JSONObject jSONObject, Map<String, String> map) {
        this.dn = jSONObject;
        this.f2do = map;
    }

    public final String R() {
        for (String str : this.f2do.keySet()) {
            aa.putValue(this.dn, str, this.f2do.get(str));
        }
        return this.dn.toString();
    }
}

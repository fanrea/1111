package com.kwad.sdk.i;

import java.util.Iterator;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class k implements b {
    public JSONObject cfU = new JSONObject();
    public String actionId = UUID.randomUUID().toString();

    public k(String str, String str2, i iVar) {
        JSONObject jSONObjectAlr = h.alv().alz().alr();
        Iterator<String> itKeys = jSONObjectAlr.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            c.a(jSONObjectAlr, next, jSONObjectAlr.opt(next));
        }
        c.putValue(this.cfU, "customKey", str);
        c.putValue(this.cfU, "customValue", str2);
        c.putValue(this.cfU, com.alipay.sdk.m.t.a.k, iVar.cfR);
        c.putValue(this.cfU, "actionId", this.actionId);
    }

    @Override // com.kwad.sdk.i.b
    public final JSONObject toJson() {
        return this.cfU;
    }

    public final String toString() {
        return this.cfU.toString();
    }
}

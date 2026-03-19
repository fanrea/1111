package com.kwad.sdk.crash.online.monitor.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    public List<String> bOh = new ArrayList();
    public List<String> bOi = new ArrayList();
    public List<String> bOj = new ArrayList();
    public List<String> bOk = new ArrayList();
    public List<b> bOl = new ArrayList();
    public Map<String, b> bOm = new HashMap();
    public int bOn;
    public int bOo;
    public int bOp;
    public double bun;

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        List<b> list = this.bOl;
        if (list != null) {
            for (b bVar : list) {
                this.bOm.put(bVar.appId, bVar);
            }
            this.bOl.clear();
        }
    }
}

package com.kwad.sdk.core.b.a;

import com.sigmob.sdk.base.mta.PointType;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class cb implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.crash.online.monitor.a.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.crash.online.monitor.a.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.crash.online.monitor.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.bOh = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("systemFilterList");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                aVar.bOh.add((String) jSONArrayOptJSONArray.opt(i));
            }
        }
        aVar.bOi = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("sdkFilterList");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                aVar.bOi.add((String) jSONArrayOptJSONArray2.opt(i2));
            }
        }
        aVar.bOj = new ArrayList();
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("matrixPrinterNameList");
        if (jSONArrayOptJSONArray3 != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                aVar.bOj.add((String) jSONArrayOptJSONArray3.opt(i3));
            }
        }
        aVar.bOk = new ArrayList();
        JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("commonPrinterNameList");
        if (jSONArrayOptJSONArray4 != null) {
            for (int i4 = 0; i4 < jSONArrayOptJSONArray4.length(); i4++) {
                aVar.bOk.add((String) jSONArrayOptJSONArray4.opt(i4));
            }
        }
        aVar.bOl = new ArrayList();
        JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray("featureConfigList");
        if (jSONArrayOptJSONArray5 != null) {
            for (int i5 = 0; i5 < jSONArrayOptJSONArray5.length(); i5++) {
                com.kwad.sdk.crash.online.monitor.a.b bVar = new com.kwad.sdk.crash.online.monitor.a.b();
                bVar.parseJson(jSONArrayOptJSONArray5.optJSONObject(i5));
                aVar.bOl.add(bVar);
            }
        }
        aVar.bOn = jSONObject.optInt("afterFilterSystemCheckNum", new Integer("5").intValue());
        aVar.bOo = jSONObject.optInt("batchNum", new Integer(PointType.SIGMOB_APP).intValue());
        aVar.bun = jSONObject.optDouble(com.sigmob.sdk.base.n.C, new Double("0.01").doubleValue());
        aVar.bOp = jSONObject.optInt("monitorSwitch");
    }

    private static JSONObject b(com.kwad.sdk.crash.online.monitor.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "systemFilterList", aVar.bOh);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "sdkFilterList", aVar.bOi);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "matrixPrinterNameList", aVar.bOj);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "commonPrinterNameList", aVar.bOk);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "featureConfigList", aVar.bOl);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "afterFilterSystemCheckNum", aVar.bOn);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "batchNum", aVar.bOo);
        com.kwad.sdk.utils.aa.putValue(jSONObject, com.sigmob.sdk.base.n.C, aVar.bun);
        if (aVar.bOp != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "monitorSwitch", aVar.bOp);
        }
        return jSONObject;
    }
}

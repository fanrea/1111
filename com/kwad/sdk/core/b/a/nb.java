package com.kwad.sdk.core.b.a;

import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class nb implements com.kwad.sdk.core.d<BlockEvent.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((BlockEvent.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((BlockEvent.a) bVar, jSONObject);
    }

    private static void a(BlockEvent.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.bOa = jSONObject.optLong("endTimestamp");
        aVar.repeatCount = jSONObject.optInt("repeatCount", new Integer("1").intValue());
        aVar.bOb = jSONObject.optBoolean("runIdle");
        aVar.bOc = jSONObject.optString("stackTraceDetail");
        if (JSONObject.NULL.toString().equals(aVar.bOc)) {
            aVar.bOc = "";
        }
        aVar.bOd = jSONObject.optLong("startTimestamp");
    }

    private static JSONObject b(BlockEvent.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.bOa != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "endTimestamp", aVar.bOa);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "repeatCount", aVar.repeatCount);
        if (aVar.bOb) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "runIdle", aVar.bOb);
        }
        if (aVar.bOc != null && !aVar.bOc.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "stackTraceDetail", aVar.bOc);
        }
        if (aVar.bOd != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "startTimestamp", aVar.bOd);
        }
        return jSONObject;
    }
}

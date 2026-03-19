package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ex implements com.kwad.sdk.core.d<com.kwad.components.ct.response.model.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ct.response.model.a.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ct.response.model.a.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ct.response.model.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aVa = jSONObject.optInt("entryType");
        aVar.aVb = jSONObject.optString("sourceDesc");
        if (JSONObject.NULL.toString().equals(aVar.aVb)) {
            aVar.aVb = "";
        }
        aVar.aVc = jSONObject.optInt("sourceDescPos", new Integer("1").intValue());
        aVar.aVd = jSONObject.optInt("likePos");
        aVar.entryId = jSONObject.optString("entryId");
        if (JSONObject.NULL.toString().equals(aVar.entryId)) {
            aVar.entryId = "";
        }
        aVar.aVe = jSONObject.optString("entryTitle", new String("精彩短视频"));
        aVar.aVf = jSONObject.optInt("entryTitlePos", new Integer("1").intValue());
        aVar.aVg = jSONObject.optInt("videoDurationPos", new Integer("1").intValue());
        aVar.aVh = jSONObject.optInt("videoDescPos", new Integer("1").intValue());
        aVar.aVi = jSONObject.optInt("commentsPos", new Integer("1").intValue());
    }

    private static JSONObject b(com.kwad.components.ct.response.model.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.aVa != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "entryType", aVar.aVa);
        }
        if (aVar.aVb != null && !aVar.aVb.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "sourceDesc", aVar.aVb);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "sourceDescPos", aVar.aVc);
        if (aVar.aVd != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "likePos", aVar.aVd);
        }
        if (aVar.entryId != null && !aVar.entryId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "entryId", aVar.entryId);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "entryTitle", aVar.aVe);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "entryTitlePos", aVar.aVf);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "videoDurationPos", aVar.aVg);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "videoDescPos", aVar.aVh);
        com.kwad.sdk.utils.aa.putValue(jSONObject, "commentsPos", aVar.aVi);
        return jSONObject;
    }
}

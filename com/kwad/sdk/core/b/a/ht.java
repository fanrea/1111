package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ht implements com.kwad.sdk.core.d<WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel) bVar, jSONObject);
    }

    private static void a(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kSAdJSCornerModel.topLeft = jSONObject.optDouble("topLeft");
        kSAdJSCornerModel.topRight = jSONObject.optDouble("topRight");
        kSAdJSCornerModel.bottomRight = jSONObject.optDouble("bottomRight");
        kSAdJSCornerModel.bottomLeft = jSONObject.optDouble("bottomLeft");
    }

    private static JSONObject b(WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (kSAdJSCornerModel.topLeft != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "topLeft", kSAdJSCornerModel.topLeft);
        }
        if (kSAdJSCornerModel.topRight != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "topRight", kSAdJSCornerModel.topRight);
        }
        if (kSAdJSCornerModel.bottomRight != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "bottomRight", kSAdJSCornerModel.bottomRight);
        }
        if (kSAdJSCornerModel.bottomLeft != 0.0d) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "bottomLeft", kSAdJSCornerModel.bottomLeft);
        }
        return jSONObject;
    }
}

package com.kwad.sdk.core.webview.c;

import com.kwad.sdk.utils.aa;
import com.ss.texturerender.TextureRenderKeys;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b implements com.kwad.sdk.core.b {
    public String aQX;
    public String anf;
    public String data;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.anf = jSONObject.optString("action");
        this.data = jSONObject.optString("data");
        this.aQX = jSONObject.optString(TextureRenderKeys.KEY_IS_CALLBACK);
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "action", this.anf);
        aa.putValue(jSONObject, "data", this.data);
        aa.putValue(jSONObject, TextureRenderKeys.KEY_IS_CALLBACK, this.aQX);
        return jSONObject;
    }
}

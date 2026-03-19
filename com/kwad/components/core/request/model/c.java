package com.kwad.components.core.request.model;

import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.aa;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c implements com.kwad.sdk.core.b {
    public long authorId;
    public long photoId;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "photoId", this.photoId);
        aa.putValue(jSONObject, URLPackage.KEY_AUTHOR_ID, this.authorId);
        return jSONObject;
    }
}

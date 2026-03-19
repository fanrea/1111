package com.kwad.components.ct.response.model.home;

import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.a.a;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.aa;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class PhotoShareInfo extends BaseResultData implements b, Serializable {
    private static final long serialVersionUID = 1941263519515554943L;
    public ShareUrlInfo data = new ShareUrlInfo();

    public static class ShareUrlInfo extends a implements Serializable {
        private static final long serialVersionUID = -7887599282226106153L;
        public String mediaShareItem;
        public String shareUrl;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.data.parseJson(new JSONObject(d.getResponseData(jSONObject.optString("data"))));
        } catch (Exception e) {
            c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        aa.a(json, "data", this.data);
        return json;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData
    public boolean isDataEmpty() {
        return this.data == null;
    }

    public String getShareUrl() {
        ShareUrlInfo shareUrlInfo = this.data;
        return shareUrlInfo != null ? shareUrlInfo.shareUrl : "";
    }

    public String getMediaShareItem() {
        ShareUrlInfo shareUrlInfo = this.data;
        return shareUrlInfo != null ? shareUrlInfo.mediaShareItem : "";
    }
}

package com.kwad.components.ct.response.model.home;

import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.aa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class CommentResponse extends BaseResultData implements b, Serializable {
    private static final long serialVersionUID = 7438022026198734874L;
    public long commentCount;
    public List<PhotoComment> rootComments = new ArrayList();

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) throws JSONException {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(d.getResponseData(jSONObject.optString("data")));
            this.commentCount = jSONObject2.optLong("commentCount");
            JSONArray jSONArray = jSONObject2.getJSONArray("rootComments");
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        PhotoComment photoComment = new PhotoComment();
                        photoComment.parseJson(jSONObjectOptJSONObject);
                        this.rootComments.add(photoComment);
                    }
                }
            }
        } catch (Exception e) {
            c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "commentCount", this.commentCount);
        aa.putValue(jSONObject, "rootComments", this.rootComments);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData
    public boolean isDataEmpty() {
        List<PhotoComment> list = this.rootComments;
        return list == null || list.isEmpty();
    }
}

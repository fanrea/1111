package com.kwad.components.ct.profile.home.model;

import com.kwad.sdk.core.b;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.aa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class UserProfile implements b, Serializable {
    private static final long serialVersionUID = 8190442197779201133L;
    public String authorArea;
    public String authorGender;
    public String authorIcon;
    public long authorId;
    public String authorName;
    public OwnerCount ownerCount = new OwnerCount();
    public List<TabInfo> tabList = new ArrayList();

    @Override // com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.authorId = jSONObject.optLong(URLPackage.KEY_AUTHOR_ID);
        this.authorName = jSONObject.optString("authorName");
        this.authorIcon = jSONObject.optString("authorIcon");
        this.authorGender = jSONObject.optString("authorGender");
        this.authorArea = jSONObject.optString("authorArea");
        this.ownerCount.parseJson(jSONObject.optJSONObject("ownerCount"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("tabList");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                TabInfo tabInfo = new TabInfo();
                tabInfo.parseJson(jSONObjectOptJSONObject);
                this.tabList.add(tabInfo);
            }
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, URLPackage.KEY_AUTHOR_ID, this.authorId);
        aa.putValue(jSONObject, "authorName", this.authorName);
        aa.putValue(jSONObject, "authorGender", this.authorGender);
        aa.putValue(jSONObject, "authorArea", this.authorArea);
        aa.putValue(jSONObject, "authorIcon", this.authorIcon);
        aa.a(jSONObject, "ownerCount", this.ownerCount);
        aa.putValue(jSONObject, "tabList", this.tabList);
        return jSONObject;
    }

    public static class OwnerCount implements b, Serializable {
        private static final long serialVersionUID = 6850889799944988895L;
        public long fansCount;
        public long followCount;
        public long ownerCount;
        public long publicPhotoCount;

        @Override // com.kwad.sdk.core.b
        public void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.fansCount = jSONObject.optLong("fansCount");
            this.followCount = jSONObject.optLong("followCount");
            this.ownerCount = jSONObject.optLong("ownerCount");
            this.publicPhotoCount = jSONObject.optLong("publicPhotoCount");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "fansCount", this.fansCount);
            aa.putValue(jSONObject, "followCount", this.followCount);
            aa.putValue(jSONObject, "ownerCount", this.ownerCount);
            aa.putValue(jSONObject, "publicPhotoCount", this.publicPhotoCount);
            return jSONObject;
        }
    }

    public static class TabInfo implements b, Serializable {
        private static final long serialVersionUID = -4013982742376017878L;
        public long tabId;
        public String tabName;

        @Override // com.kwad.sdk.core.b
        public void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.tabId = jSONObject.optLong("tabId");
            this.tabName = jSONObject.optString("tabName");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "tabId", this.tabId);
            aa.putValue(jSONObject, "tabName", this.tabName);
            return jSONObject;
        }
    }
}

package com.kwad.components.ct.home.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.mobads.container.rewardvideo.RemoteRewardActivity;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.aa;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.sdk.core.config.item.b<C0519a> {
    private final String aHZ;
    private String aIa;

    public a(String str, String str2) {
        super(str, new C0519a("", "", str2));
        this.aHZ = str2;
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void g(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(getKey());
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        this.aIa = jSONObjectOptJSONObject.toString();
        C0519a c0519a = new C0519a();
        c0519a.parseJson(jSONObjectOptJSONObject);
        setValue(c0519a);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences.Editor editor) {
        editor.putString(getKey(), this.aIa);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString(getKey(), null);
        this.aIa = string;
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.aIa);
            C0519a c0519a = new C0519a();
            c0519a.parseJson(jSONObject);
            setValue(c0519a);
        } catch (JSONException e) {
            c.printStackTrace(e);
        }
    }

    public final String FY() {
        C0519a value = getValue();
        return value != null ? value.uM : this.aHZ;
    }

    public final String FZ() {
        C0519a value = getValue();
        return value != null ? value.iconUrl : "";
    }

    public final String Ga() {
        C0519a value = getValue();
        return value != null ? value.aIb : "";
    }

    /* renamed from: com.kwad.components.ct.home.config.item.a$a, reason: collision with other inner class name */
    public static final class C0519a implements com.kwad.sdk.core.b {
        public String aIb;
        public String iconUrl;
        public String uM;

        C0519a() {
            this.iconUrl = "";
            this.aIb = "";
            this.uM = "";
        }

        C0519a(String str, String str2, String str3) {
            this.iconUrl = str;
            this.aIb = str2;
            this.uM = str3;
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.iconUrl = jSONObject.optString("iconUrl", this.iconUrl);
            this.aIb = jSONObject.optString("nightIconUrl", this.aIb);
            this.uM = jSONObject.optString(RemoteRewardActivity.JSON_BANNER_DESC_ID, this.uM);
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "icon", this.iconUrl);
            aa.putValue(jSONObject, "nightIconUrl", this.aIb);
            aa.putValue(jSONObject, RemoteRewardActivity.JSON_BANNER_DESC_ID, this.uM);
            return jSONObject;
        }
    }
}

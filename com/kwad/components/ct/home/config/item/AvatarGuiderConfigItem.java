package com.kwad.components.ct.home.config.item;

import android.content.SharedPreferences;
import com.kwad.sdk.core.d.c;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class AvatarGuiderConfigItem extends com.kwad.sdk.core.config.item.b<AvatarGuiderConfig> {

    public static class AvatarGuiderConfig extends com.kwad.sdk.core.response.a.a implements Serializable {
        public int showByPlayRate;
        public int showMaxTimes;
        public int showTimeLength;
    }

    public AvatarGuiderConfigItem() {
        super("avatarGuiderConfig", null);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void g(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject(getKey())) != null) {
            AvatarGuiderConfig avatarGuiderConfig = new AvatarGuiderConfig();
            avatarGuiderConfig.parseJson(jSONObjectOptJSONObject);
            c.d("AvatarGuiderConfigItem", "AvatarGuiderConfigItem = " + avatarGuiderConfig.toJson().toString());
            setValue(avatarGuiderConfig);
            return;
        }
        c.d("AvatarGuiderConfigItem", "AvatarGuiderConfigItem = getDefault");
        setValue(Zh());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences.Editor editor) {
        if (getValue() != null && getValue().toJson() != null) {
            editor.putString(getKey(), getValue().toJson().toString());
        } else {
            editor.putString(getKey(), "");
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        AvatarGuiderConfig value = getValue();
        if (value == null) {
            value = new AvatarGuiderConfig();
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(sharedPreferences.getString(getKey(), ""));
        } catch (JSONException e) {
            c.printStackTraceOnly(e);
        }
        if (jSONObject != null) {
            value.parseJson(jSONObject);
        }
        setValue(value);
    }
}

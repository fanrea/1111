package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class r extends a<String> {
    public r(String str) {
        this(str, "");
    }

    public r(String str, String str2) {
        super(str, str2);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void g(JSONObject jSONObject) {
        String strOptString = jSONObject != null ? jSONObject.optString(getKey(), Zh()) : null;
        if (TextUtils.isEmpty(strOptString)) {
            setValue(Zh());
        } else {
            setValue(strOptString);
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences.Editor editor) {
        editor.putString(getKey(), eO(getValue()));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        setValue(getDecodeString(sharedPreferences.getString(getKey(), Zh())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final String getValue() {
        return (String) super.getValue();
    }
}

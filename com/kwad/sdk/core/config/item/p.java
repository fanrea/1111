package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class p extends b<String> {
    private static volatile String[] bAD;

    public p(String str, String str2) {
        super(str, str2);
        bAD = null;
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void g(JSONObject jSONObject) {
        if (jSONObject != null) {
            String strOptString = jSONObject.optString(getKey(), Zh());
            setValue(strOptString);
            eQ(strOptString);
            return;
        }
        setValue(Zh());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences.Editor editor) {
        editor.putString(getKey(), getValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString(getKey(), Zh());
        setValue(string);
        eQ(string);
    }

    public static boolean aG(long j) {
        if (bAD == null) {
            return false;
        }
        for (String str : bAD) {
            if (str != null && String.valueOf(j).equals(str.trim())) {
                return true;
            }
        }
        return false;
    }

    private static void eQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        bAD = str.split(",");
    }
}

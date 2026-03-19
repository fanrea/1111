package com.bytedance.bdtracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.applog.log.LoggerImpl;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class l5 {
    public final SharedPreferences a;

    public l5(Context context) {
        this.a = f4.a(context, "device_register_oaid_refine", 0);
    }

    public k5 a() {
        String string = this.a.getString("oaid", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            return new k5(jSONObject.optString("id", null), jSONObject.optString(com.baidu.mobads.container.adrequest.g.o, null), jSONObject.has("is_track_limited") ? Boolean.valueOf(jSONObject.optBoolean("is_track_limited")) : null, jSONObject.has("take_ms") ? Long.valueOf(jSONObject.optLong("take_ms", -1L)) : null, jSONObject.has("time") ? Long.valueOf(jSONObject.optLong("time", -1L)) : null, jSONObject.has("query_times") ? Integer.valueOf(jSONObject.optInt("query_times", -1)) : null, jSONObject.has("hw_id_version_code") ? Long.valueOf(jSONObject.optLong("hw_id_version_code", -1L)) : null);
        } catch (Throwable th) {
            LoggerImpl.global().error(1, "Create model failed", th, new Object[0]);
            return null;
        }
    }

    public void a(k5 k5Var) {
        if (k5Var == null) {
            return;
        }
        this.a.edit().putString("oaid", k5Var.b().toString()).apply();
    }
}

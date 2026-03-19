package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class f {
    private static gv<ho> d = new gv<ho>() { // from class: com.bytedance.embedapplog.f.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.gv
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ho d(Object... objArr) {
            return new ho((Context) objArr[0]);
        }
    };

    public static void d(Context context) {
        d.hc(context).hc();
    }

    public static String d(SharedPreferences sharedPreferences) {
        SystemClock.elapsedRealtime();
        return wb.d(sharedPreferences);
    }

    public static Map<String, String> d(Context context, SharedPreferences sharedPreferences) {
        SystemClock.elapsedRealtime();
        ho hoVarHc = d.hc(context);
        return hoVarHc.d(hoVarHc.d() instanceof p ? 200 : 100);
    }

    public static String d(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("id", null);
        }
        return null;
    }

    public static void d(u uVar) {
        ho.d(uVar);
    }
}

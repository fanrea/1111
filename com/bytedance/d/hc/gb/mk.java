package com.bytedance.d.hc.gb;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class mk {
    public static void d(com.bytedance.d.hc.b.d dVar, com.bytedance.d.hc.b.hc hcVar, com.bytedance.d.hc.b bVar) {
        if (dVar == null || dVar.d() == null || bVar == null) {
            return;
        }
        JSONObject jSONObjectD = dVar.d();
        long jOptLong = jSONObjectD.optLong("crash_time");
        int iHc = hc(d("aid"));
        String strD = com.bytedance.d.hc.gb.b().d();
        if (jOptLong <= 0 || iHc <= 0 || TextUtils.isEmpty(strD) || "0".equals(strD) || TextUtils.isEmpty(bVar.d())) {
            return;
        }
        try {
            String str = "android_" + iHc + Config.replace + strD + Config.replace + jOptLong + Config.replace + bVar;
            if (hcVar != null) {
                JSONObject jSONObjectD2 = hcVar.d();
                if (jSONObjectD2 != null) {
                    jSONObjectD2.put("unique_key", str);
                    return;
                }
                return;
            }
            jSONObjectD.put("unique_key", str);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    public static String d(String str) {
        Map<String, Object> mapD;
        if (com.bytedance.d.hc.gb.d() == null || (mapD = com.bytedance.d.hc.gb.d().d()) == null) {
            return null;
        }
        Object obj = mapD.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public static int hc(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            tc.hc(e);
            return 0;
        }
    }
}

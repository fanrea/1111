package com.bytedance.d.d;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.d.hc.gb;
import com.bytedance.d.hc.gb.tc;
import com.bytedance.d.hc.h.u;
import io.reactivex.annotations.SchedulerSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    static volatile JSONObject d;

    public static void d(hc hcVar) {
        Map<String, Object> mapD = gb.d().d();
        if (mapD == null && mapD.get("aid") == null) {
            return;
        }
        try {
            byte[] bytes = d(mapD).toString().getBytes("UTF-8");
            StringBuilder sb = new StringBuilder(com.bytedance.d.hc.h.hc.hc(mapD));
            sb.append("?device_platform=android&version_code=137&iid=iid&aid=").append(mapD.get("aid"));
            com.bytedance.d.hc.h.hc.d(new u.d().d(sb.toString()).d(true).d(bytes).d());
        } catch (Throwable unused) {
        }
    }

    private static String d() {
        String str = Build.VERSION.RELEASE;
        return str.contains(".") ? str : str + ".0";
    }

    private static JSONObject d(Map map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        if (d == null) {
            Context contextC = gb.c();
            try {
                JSONObject jSONObject2 = new JSONObject();
                d = jSONObject2;
                jSONObject2.put("os", "Android");
                d.put("platform", "Android");
                d.put("sdk_lib", "Android");
                d.put("os_version", d());
                d.put("os_api", Build.VERSION.SDK_INT);
                d.put("use_apm_sdk", "1");
                d.put("sdk_version", 137);
                d.put("sdk_version_code", 137);
                d.put("sdk_version_name", "0.0.1-alpha.17-cloud");
                String str = Build.MODEL;
                String str2 = Build.BRAND;
                if (str == null) {
                    str = str2;
                } else if (str2 != null && !str.contains(str2)) {
                    str = str2 + ' ' + str;
                }
                d.put("device_model", str);
                d.put("device_brand", Build.BRAND);
                d.put("device_manufacturer", Build.MANUFACTURER);
                if (map != null) {
                    d.put("aid", String.valueOf(map.get("aid")));
                    d.put("app_version", map.get("app_version"));
                    d.put("version_code", map.get("version_code"));
                    d.put("update_version_code", map.get("update_version_code"));
                    d.put("manifest_version_code", map.get("version_code"));
                    d.put("channel", map.get("channel"));
                }
                d.put("bd_did", gb.b().d());
                d.put("package", contextC.getPackageName());
                d.put("display_name", contextC.getApplicationInfo().name);
                d(d);
            } catch (Exception unused) {
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        jSONObject.put("header", d);
        jSONObject.put("local_time", jCurrentTimeMillis);
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject3 = new JSONObject();
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        jSONObject3.put("local_time_ms", jCurrentTimeMillis2);
        jSONObject3.put("tea_event_index", 10001);
        jSONObject3.put("session_id", UUID.randomUUID().toString());
        jSONObject3.put("datetime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(jCurrentTimeMillis2)));
        jSONArray.put(jSONObject3);
        jSONObject.put(Config.LAUNCH, jSONArray);
        return jSONObject;
    }

    private static void d(JSONObject jSONObject) throws JSONException {
        Map<String, Object> mapHc;
        Object obj;
        com.bytedance.d.hc.u.d dVarD = gb.d();
        if (dVarD == null || jSONObject == null || (mapHc = dVarD.hc()) == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (String str : mapHc.keySet()) {
                if (!TextUtils.isEmpty(str) && (obj = mapHc.get(str)) != null) {
                    jSONObject2.put(str, obj);
                }
            }
            jSONObject.put(SchedulerSupport.CUSTOM, jSONObject2);
        } catch (Exception e) {
            tc.hc(e);
        }
    }
}

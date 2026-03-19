package com.netease.htprotect.necrash.p006Ooo;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.netease.htprotect.necrash.〇Ooo.O8〇oO8〇88, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class O8oO888 {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static final String f186O8oO888 = "1.0.1";

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static Map m626O8oO888(Context context, String str, String str2, String str3, String str4, String str5, String str6, long j) throws JSONException {
        String strJoin;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject.put(Config.INPUT_DEF_VERSION, f186O8oO888);
            jSONObject.put("appid", "A008185364");
            jSONObject.put("uploadtime", System.currentTimeMillis());
            jSONObject.put("isencoded", 1);
            jSONObject2.put("appname", str5);
            jSONObject2.put(Config.INPUT_DEF_VERSION, str4);
            jSONObject2.put("packagename", str6);
            jSONObject2.put("tag", str2);
            jSONObject2.put("exceptiontype", "exception");
            jSONObject2.put("crashinfo", str);
            jSONObject3.put("OS", Build.VERSION.CODENAME);
            jSONObject3.put("OSVERSION", Build.VERSION.RELEASE);
            jSONObject3.put("STARTTIME", j);
            jSONObject3.put("CRASHTIME", System.currentTimeMillis());
            jSONObject3.put("DEVICEID", com.netease.htprotect.necrash.p005O8.O8oO888.m622o0o0(context));
            jSONObject3.put("FINGERPRINT", Build.FINGERPRINT);
            jSONObject3.put("MANUFACTURER", Build.MANUFACTURER);
            jSONObject3.put("DEVICE", Build.DEVICE);
            jSONObject3.put("MODEL", Build.MODEL);
            if (Build.VERSION.SDK_INT >= 21) {
                strJoin = TextUtils.join(",", Build.SUPPORTED_ABIS);
            } else {
                strJoin = Build.CPU_ABI;
                String str7 = Build.CPU_ABI2;
                if (!TextUtils.isEmpty(str7)) {
                    strJoin = strJoin + "," + str7;
                }
            }
            jSONObject3.put("CPU_ABI", strJoin);
            jSONObject2.put("machineInfo", jSONObject3.toString());
            jSONObject4.put("UserId", com.netease.htprotect.necrash.p005O8.O8oO888.m617O8(context));
            jSONObject4.put("UserTag", str3);
            jSONObject2.put("extraInfo", jSONObject4.toString());
        } catch (JSONException unused) {
        }
        HashMap map = new HashMap();
        map.put("head", jSONObject.toString());
        map.put("data", jSONObject2.toString());
        return map;
    }
}

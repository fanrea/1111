package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.applog.util.SensitiveUtils;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.HashMap;
import kotlin.text.Typography;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class xp {
    private static final String[] d = {"ab_version", "device_brand", "language", "os_api", "resolution", "google_aid", SensitiveUtils.KEY_BUILD_SERIAL, "carrier", "install_id", "package", "app_version", "device_model", "udid", "density_dpi", SensitiveUtils.KEY_ALIYUN_UUID, "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", com.baidu.mobads.upgrade.remote.gray.c.l, "openudid", "clientudid", "aid"};
    private static final String[] hc = {"ab_version", "device_brand", "language", "os_api", "resolution", "google_aid", SensitiveUtils.KEY_BUILD_SERIAL, "carrier", Config.IID, "app_name", NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, "device_type", "uuid", "dpi", SensitiveUtils.KEY_ALIYUN_UUID, "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", com.baidu.mobads.upgrade.remote.gray.c.l, "openudid", "clientudid", "aid"};

    public static String d(Context context, JSONObject jSONObject, String str, boolean z, hc hcVar) {
        HashMap<String, String> mapD;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        HashMap map = new HashMap(d.length + 10);
        int i = 0;
        while (true) {
            String[] strArr = d;
            if (i >= strArr.length) {
                break;
            }
            String strOptString = jSONObject.optString(strArr[i], null);
            if (!TextUtils.isEmpty(strOptString)) {
                map.put(hc[i], strOptString);
            }
            i++;
        }
        if (hcVar != null) {
            try {
                mapD = hcVar.d(context);
            } catch (Exception e) {
                um.hc(e);
            }
        } else {
            mapD = null;
        }
        if (fv.hc(context) && mapD != null) {
            map.putAll(mapD);
        }
        try {
            HashMap<String, String> mapD2 = d.b() == null ? null : d.b().d();
            if (mapD2 != null) {
                map.putAll(mapD2);
            }
        } catch (Exception e2) {
            um.hc(e2);
        }
        if (d.b.size() > 0) {
            map.putAll(d.b);
        }
        if (z) {
            map.put("ssmix", "a");
        }
        String strD = qy.d(context);
        if (!TextUtils.isEmpty(strD)) {
            map.put("ac", strD);
        }
        String str2 = (String) d.d("tweaked_channel", "");
        if (TextUtils.isEmpty(str2)) {
            str2 = (String) d.d("channel", "");
        }
        if (!TextUtils.isEmpty(str2)) {
            map.put("channel", str2);
        }
        String strOptString2 = jSONObject.optString("os_version", null);
        if (strOptString2 != null && strOptString2.length() > 10) {
            strOptString2 = strOptString2.substring(0, 10);
        }
        map.put("os_version", strOptString2);
        map.put("_rticket", String.valueOf(System.currentTimeMillis()));
        map.put("device_platform", "android");
        int iIntValue = ((Integer) d.d("version_code", -1)).intValue();
        if (iIntValue != -1) {
            map.put("version_code", String.valueOf(iIntValue));
        }
        int iIntValue2 = ((Integer) d.d("manifest_version_code", -1)).intValue();
        if (iIntValue2 != -1) {
            map.put("manifest_version_code", String.valueOf(iIntValue2));
        }
        int iIntValue3 = ((Integer) d.d("update_version_code", -1)).intValue();
        if (iIntValue3 != -1) {
            map.put("update_version_code", String.valueOf(iIntValue3));
        }
        String strD2 = f.d(jSONObject.optJSONObject("oaid"));
        if (!TextUtils.isEmpty(strD2)) {
            map.put("oaid", strD2);
        }
        String strOptString3 = jSONObject.optString("cdid");
        if (!TextUtils.isEmpty(strOptString3)) {
            map.put("cdid", strOptString3);
        }
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        return fv.d(str + (str.indexOf(63) >= 0 ? Typography.amp : '?'), map, "UTF-8");
    }

    public static String[] d(de deVar, Context context, JSONObject jSONObject) {
        String[] strArrHc = deVar.gb().hc();
        String[] strArr = new String[strArrHc.length];
        String str = d.h() ? "?tt_data=a" : "?";
        for (int i = 0; i < strArrHc.length; i++) {
            String strD = d(context, jSONObject, strArrHc[i] + str, true, d.c());
            strArr[i] = strD;
            strArr[i] = fu.d(strD, fu.hc);
        }
        return strArr;
    }
}

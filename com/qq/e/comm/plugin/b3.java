package com.qq.e.comm.plugin;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import com.baidu.mobstat.forbes.Config;
import com.kuaishou.android.live.network.ApiStatus;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.util.GDTLogger;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class b3 {
    public static int a = -999;
    public static int b = -999;
    private static long c;

    public static void b(String str) {
        int iA = r1.d().f().a("gasi", 999);
        if (iA == -1) {
            return;
        }
        if (iA == 999) {
            if (a >= 0 && b >= 0) {
                return;
            }
        } else if (iA > 0 && System.currentTimeMillis() - c < iA * 60000) {
            return;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) r1.d().a().getSystemService("accessibility");
        c = System.currentTimeMillis();
        if (accessibilityManager == null) {
            a = ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG;
            b = ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG;
            return;
        }
        try {
            List<AccessibilityServiceInfo> installedAccessibilityServiceList = accessibilityManager.getInstalledAccessibilityServiceList();
            if (installedAccessibilityServiceList == null) {
                a = 0;
            } else {
                int i = 0;
                for (AccessibilityServiceInfo accessibilityServiceInfo : installedAccessibilityServiceList) {
                    if (accessibilityServiceInfo != null) {
                        String[] strArr = accessibilityServiceInfo.packageNames;
                        if (strArr == null) {
                            i++;
                        } else {
                            for (String str2 : strArr) {
                                if (TextUtils.equals(str, str2)) {
                                    i++;
                                }
                            }
                        }
                    }
                }
                a = i;
            }
        } catch (Throwable unused) {
            a = ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG;
        }
        try {
            List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(-1);
            if (enabledAccessibilityServiceList == null) {
                b = 0;
            } else {
                b = enabledAccessibilityServiceList.size();
            }
        } catch (Throwable unused2) {
            b = ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG;
        }
    }

    public static String a(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            jSONObject.putOpt("g", jSONObject2.optString("g"));
            jSONObject.putOpt(Config.STAT_SDK_CHANNEL, jSONObject2.optString(Config.STAT_SDK_CHANNEL));
            jSONObject.putOpt("ec", jSONObject2.optString("ec"));
            jSONObject.putOpt("aa", jSONObject2.optString("aa"));
            jSONObject.putOpt("ab", jSONObject2.optString("ab"));
            jSONObject.putOpt("ba", jSONObject2.optString("ba"));
            jSONObject.putOpt("bb", jSONObject2.optString("bb"));
            jSONObject.putOpt("vp", jSONObject2.optString("vp"));
            jSONObject.putOpt("d", jSONObject2.optString("d"));
            jSONObject.putOpt("p", jSONObject2.optString("p"));
            jSONObject.putOpt("f", jSONObject2.optString("f"));
            jSONObject.putOpt("x", jSONObject2.optString("x"));
            jSONObject.putOpt("sz", jSONObject2.optString("sz"));
            jSONObject.putOpt("tid", jSONObject2.optString("tid"));
            jSONObject.putOpt("da", jSONObject2.optString("da"));
            jSONObject.putOpt("db", jSONObject2.optString("db"));
            jSONObject.putOpt("sm", jSONObject2.optString("sm"));
            jSONObject.putOpt("in", jSONObject2.optString("in"));
            jSONObject.putOpt("pcs", jSONObject2.optString("pcs"));
            jSONObject.putOpt("se", jSONObject2.optString("se"));
            jSONObject.putOpt("do", jSONObject2.optString("do"));
            jSONObject.putOpt("ac", jSONObject2.optString("ac"));
            jSONObject.putOpt("ot", jSONObject2.optString("ot"));
            jSONObject.putOpt("rwd", jSONObject2.optString("rwd"));
            return URLEncoder.encode(jSONObject.toString(), "UTF-8");
        } catch (Exception e) {
            e.getMessage();
            return str;
        }
    }

    public static String a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        HashMap map = new HashMap();
        try {
            String[] strArrSplit = r1.d().f().b("poudw", "user_id#100").split("#");
            for (int i = 0; i < strArrSplit.length / 2; i++) {
                int i2 = i * 2;
                map.put(strArrSplit[i2], Integer.valueOf(strArrSplit[i2 + 1]));
            }
        } catch (Exception unused) {
            map.put("user_id", 100);
        }
        JSONObject jSONObjectOptJSONObject = GlobalSetting.getSettings().optJSONObject("media_ext");
        if (jSONObjectOptJSONObject != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Integer num = (Integer) map.get(next);
                if (num != null) {
                    String strOptString = jSONObjectOptJSONObject.optString(next);
                    if (strOptString != null && strOptString.getBytes().length <= num.intValue()) {
                        try {
                            jSONObject.put(next, strOptString);
                        } catch (JSONException unused2) {
                            GDTLogger.e("GlobalSetting.mediaExtData参数拼接异常，参数已丢弃，请检查！");
                        }
                    } else {
                        GDTLogger.e("GlobalSetting.mediaExtData参数value值过长，参数已丢弃，请检查！");
                    }
                }
            }
        }
        return jSONObject.toString();
    }
}

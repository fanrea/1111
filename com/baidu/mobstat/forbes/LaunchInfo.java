package com.baidu.mobstat.forbes;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class LaunchInfo {
    private String a;
    private String b;
    private String c;

    public String getPushLandingPage() {
        if (TextUtils.isEmpty(this.a)) {
            return "";
        }
        return this.a;
    }

    public String getPushContent() {
        if (TextUtils.isEmpty(this.b)) {
            return "";
        }
        return this.b;
    }

    public String getRefererPkgName() {
        if (TextUtils.isEmpty(this.c)) {
            return "";
        }
        return this.c;
    }

    public void setPushInfo(String str, String str2) {
        this.a = str;
        this.b = as.a(str2, 1024);
    }

    public void setRefererPkgName(String str) {
        this.c = str;
    }

    public int getLaunchType(Context context) {
        String packageName;
        if (!TextUtils.isEmpty(this.a)) {
            return 2;
        }
        if (context == null) {
            packageName = "";
        } else {
            packageName = context.getPackageName();
        }
        if (!TextUtils.isEmpty(this.c) && !this.c.equals(packageName)) {
            String strA = ae.a(context);
            return !TextUtils.isEmpty(strA) ? !this.c.equals(strA) ? 1 : 0 : !ae.a(context, this.c) ? 1 : 0;
        }
        return 0;
    }

    public static JSONObject getConvertedJson(int i, String str, String str2) throws JSONException {
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("type", String.valueOf(i));
                if (str == null) {
                    str = "";
                }
                jSONObject2.put(Config.LAUNCH_REFERER, str);
                if (str2 == null) {
                    str2 = "";
                }
                jSONObject2.put(Config.LAUNCH_INFO, str2);
                jSONObject2.put("content", "");
                return jSONObject2;
            } catch (Exception e) {
                jSONObject = jSONObject2;
                return jSONObject;
            }
        } catch (Exception e2) {
        }
    }

    public static String getLauncherHomePkgName(Context context) {
        String strA = ae.a(context);
        if (TextUtils.isEmpty(strA)) {
            return "";
        }
        return strA;
    }
}

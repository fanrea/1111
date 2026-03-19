package com.bytedance.d.hc.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.mobads.upgrade.remote.gray.c;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.d.hc.gb;
import com.bytedance.d.hc.gb.tc;
import com.bytedance.d.hc.gb.tt;
import com.bytedance.d.hc.gb.uo;
import com.bytedance.sdk.component.utils.mq;
import com.pandora.common.Constants;
import io.reactivex.annotations.SchedulerSupport;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class hc {
    private static final String[] d = {"version_code", "manifest_version_code", "aid", "update_version_code"};
    private JSONObject b = new JSONObject();
    private Context hc;

    public hc(Context context) {
        this.hc = context;
    }

    public static hc d(Context context) throws JSONException, PackageManager.NameNotFoundException {
        hc hcVar = new hc(context);
        JSONObject jSONObjectD = hcVar.d();
        hcVar.d(jSONObjectD);
        hcVar.b(jSONObjectD);
        hcVar.c(jSONObjectD);
        hcVar.u(jSONObjectD);
        hcVar.an(jSONObjectD);
        hcVar.h(jSONObjectD);
        hcVar.hc(jSONObjectD);
        return hcVar;
    }

    private void d(JSONObject jSONObject) throws JSONException, PackageManager.NameNotFoundException {
        int i;
        try {
            PackageInfo packageInfo = this.hc.getPackageManager().getPackageInfo(this.hc.getPackageName(), 0);
            if (packageInfo.applicationInfo != null && (i = packageInfo.applicationInfo.labelRes) > 0) {
                jSONObject.put("display_name", this.hc.getString(i));
            }
            jSONObject.put("sdk_version", 137);
            jSONObject.put("sdk_version_name", "0.0.1-alpha.17-cloud");
            jSONObject.put("os", "Android");
            jSONObject.put("os_version", b());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            jSONObject.put("cpu_abi", hc());
        } catch (Exception unused) {
        }
    }

    private String hc() {
        try {
            StringBuilder sb = new StringBuilder();
            if (Build.VERSION.SDK_INT >= 21 && Build.SUPPORTED_ABIS.length > 0) {
                for (int i = 0; i < Build.SUPPORTED_ABIS.length; i++) {
                    sb.append(Build.SUPPORTED_ABIS[i]);
                    if (i != Build.SUPPORTED_ABIS.length - 1) {
                        sb.append(", ");
                    }
                }
            } else {
                sb = new StringBuilder(Build.CPU_ABI);
            }
            return TextUtils.isEmpty(sb.toString()) ? "unknown" : sb.toString();
        } catch (Exception e) {
            tc.hc(e);
            return "unknown";
        }
    }

    private void hc(JSONObject jSONObject) throws JSONException {
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

    private String b() {
        String str = Build.VERSION.RELEASE;
        return str.contains(".") ? str : str + ".0";
    }

    private void b(JSONObject jSONObject) throws JSONException {
        try {
            DisplayMetrics displayMetrics = this.hc.getResources().getDisplayMetrics();
            int i = displayMetrics.densityDpi;
            String str = i != 120 ? i != 240 ? i != 320 ? "mdpi" : "xhdpi" : "hdpi" : "ldpi";
            jSONObject.put("density_dpi", i);
            jSONObject.put("display_density", str);
            jSONObject.put("resolution", displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        } catch (Exception unused) {
        }
    }

    private void c(JSONObject jSONObject) throws JSONException {
        try {
            String language = this.hc.getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                jSONObject.put("language", language);
            }
            String country = Locale.getDefault().getCountry();
            if (!TextUtils.isEmpty(country)) {
                jSONObject.put(Constants.APPLog.APP_REGION, country);
            }
            int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
            if (rawOffset < -12) {
                rawOffset = -12;
            }
            if (rawOffset > 12) {
                rawOffset = 12;
            }
            jSONObject.put("timezone", rawOffset);
        } catch (Exception unused) {
        }
    }

    private void u(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        try {
            if (com.bytedance.d.hc.gb.b.b()) {
                sb.append("MIUI-");
            } else if (com.bytedance.d.hc.gb.b.c()) {
                sb.append("FLYME-");
            } else {
                String strD = com.bytedance.d.hc.gb.b.d();
                if (com.bytedance.d.hc.gb.b.d(strD)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(strD)) {
                    sb.append(strD).append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
            if (sb.length() > 0) {
                jSONObject.put(Config.ROM, sb.toString());
            }
            jSONObject.put("rom_version", uo.d());
        } catch (Throwable unused) {
        }
    }

    private void an(JSONObject jSONObject) throws JSONException {
        try {
            jSONObject.put("access", tt.d(this.hc));
        } catch (JSONException e) {
            mq.d(e);
        }
    }

    private void h(JSONObject jSONObject) throws JSONException {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.hc.getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (!TextUtils.isEmpty(networkOperatorName)) {
                    jSONObject.put("carrier", networkOperatorName);
                }
                String networkOperator = telephonyManager.getNetworkOperator();
                if (TextUtils.isEmpty(networkOperator)) {
                    return;
                }
                jSONObject.put("mcc_mnc", networkOperator);
            }
        } catch (Exception e) {
            mq.d(e);
        }
    }

    public JSONObject d(Map<String, Object> map) {
        if (map == null) {
            return this.b;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!this.b.has(entry.getKey())) {
                this.b.put(entry.getKey(), entry.getValue());
            }
        }
        for (String str : d) {
            if (map.containsKey(str)) {
                try {
                    this.b.put(str, Integer.parseInt((String) map.get(str)));
                } catch (Exception unused) {
                    this.b.put(str, map.get(str));
                }
            }
        }
        if (map.containsKey("version_code") && !map.containsKey("manifest_version_code")) {
            this.b.put("manifest_version_code", Integer.parseInt((String) map.get("version_code")));
        }
        if (map.containsKey(Config.IID)) {
            this.b.put("udid", map.get(Config.IID));
            this.b.remove(Config.IID);
        }
        return this.b;
    }

    public JSONObject d(String str) throws JSONException {
        try {
            this.b.put(c.l, str);
        } catch (JSONException e) {
            mq.d(e);
        }
        return this.b;
    }

    public JSONObject hc(String str) throws JSONException {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.b.put("user_id", str);
            }
        } catch (JSONException e) {
            mq.d(e);
        }
        return this.b;
    }

    public JSONObject d() {
        return this.b;
    }
}

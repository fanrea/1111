package com.bytedance.msdk.gb;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.g;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.applog.util.SensitiveUtils;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.pandora.common.Constants;
import com.sigmob.sdk.base.n;
import io.reactivex.annotations.SchedulerSupport;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class v {
    public static JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("os", np.uo());
            jSONObject.put(g.z, np.sy());
            jSONObject.put("imei_md5", de.d(np.sy()));
            jSONObject.put(Config.GAID, gb.d().hc());
            jSONObject.put("oaid", np.hc());
            jSONObject.put("applog_did", np.d());
            jSONObject.put("device_model", np.h());
            jSONObject.put("vendor", np.w());
            jSONObject.put("ua", np.s());
            jSONObject.put("ip", np.de());
            jSONObject.put(n.p, fs.d());
            jSONObject.put("publisher_did", com.bytedance.msdk.core.d.mk().yo());
            jSONObject.put("android_id", np.c());
            jSONObject.put("os_version", np.k());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static JSONObject d(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(g.z, np.sy());
            jSONObject.put("android_id", np.c());
            jSONObject.put("uuid", np.v());
            jSONObject.put("ssid", np.yi());
            jSONObject.put("wifi_mac", np.he());
            jSONObject.put("imsi", np.np());
            jSONObject.put("power_on_time", new StringBuilder().append(SystemClock.elapsedRealtime()).toString());
            jSONObject.put("rom_version", vv.d());
            jSONObject.put("sys_compiling_time", np.b());
            jSONObject.put("type", np.j());
            jSONObject.put("os", np.uo());
            jSONObject.put("os_version", np.k());
            jSONObject.put("vendor", np.w());
            jSONObject.put("device_model", np.h());
            jSONObject.put("language", np.tt());
            jSONObject.put("conn_type", np.u());
            jSONObject.put(g.w, np.zw());
            jSONObject.put("screen_width", com.bytedance.msdk.d.u.h.hc(context));
            jSONObject.put("screen_height", com.bytedance.msdk.d.u.h.b(context));
            jSONObject.put("oaid", np.hc());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static JSONObject hc() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Context context = com.bytedance.msdk.core.hc.getContext();
        try {
            jSONObject.put(com.baidu.mobads.upgrade.remote.gray.c.l, np.d());
            jSONObject.put("user_unique_id", !TextUtils.isEmpty(np.d()) ? np.d() : UUID.randomUUID().toString());
            jSONObject.put("sdk_version", com.bytedance.msdk.hc.hc.hc());
            jSONObject.put(ILogConst.Keys.KEY_PLUGIN_VERSION, com.bytedance.msdk.hc.hc.c());
            jSONObject.put("os", "Android");
            jSONObject.put("os_version", np.k());
            jSONObject.put("device_model", np.h());
            jSONObject.put("resolution", com.bytedance.msdk.d.u.h.b(com.bytedance.msdk.core.hc.getContext()) + "x" + com.bytedance.msdk.d.u.h.hc(com.bytedance.msdk.core.hc.getContext()));
            jSONObject.put("language", np.tt());
            jSONObject.put("timezone", np.z());
            jSONObject.put("access", np.an());
            jSONObject.put("openudid", np.c());
            jSONObject.put("aid", "5685");
            jSONObject.put("display_name", tt.hc());
            jSONObject.put("app_version", tt.d());
            jSONObject.put("package", fs.d());
            jSONObject.put(Constants.APPLog.APP_REGION, Locale.getDefault().getCountry());
            jSONObject.put("tz_name", Calendar.getInstance().getTimeZone().getID());
            jSONObject.put("tz_offset", Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000);
            jSONObject.put(Config.ROM, np.us());
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            d(context, jSONObject);
            jSONObject.put("display_density", np.fs());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("density_dpi", com.bytedance.msdk.d.u.h.u(context));
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put("cpu_abi", Build.CPU_ABI);
            jSONObject.put(SensitiveUtils.KEY_BUILD_SERIAL, np.vv());
            jSONObject.put("version_code", fs.hc());
            jSONObject.put("udid", np.sy());
            jSONObject.put(SchedulerSupport.CUSTOM, b());
            String strDe = np.de();
            if (TextUtils.isEmpty(strDe)) {
                strDe = "127.0.0.1";
            } else if (strDe.contains(",")) {
                strDe = d(strDe);
            }
            jSONObject.put("ip", strDe);
        } catch (Exception e) {
            com.bytedance.msdk.u.hc.hc.d("getUploadEventV3Header", "exception: " + e.toString());
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        return jSONObject;
    }

    private static void d(Context context, JSONObject jSONObject) throws JSONException {
        ArrayList<String> arrayListD;
        if (context == null || jSONObject == null || (arrayListD = tc.d(context, "MD5")) == null || arrayListD.isEmpty()) {
            return;
        }
        try {
            jSONObject.put("sig_hash", Build.MANUFACTURER);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private static JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(g.z, np.sy());
            jSONObject.put("imei_md5", de.d(np.sy()));
            jSONObject.put(Config.GAID, gb.d().hc());
            jSONObject.put("applog_did", np.d());
            jSONObject.put("publisher_did", com.bytedance.msdk.core.d.mk().yo());
            jSONObject.put("android_id", np.c());
            jSONObject.put("oaid", np.hc());
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private static String d(String str) {
        String[] strArrSplit = str.split(",");
        return (strArrSplit == null || strArrSplit.length <= 0 || TextUtils.isEmpty(strArrSplit[0])) ? "127.0.0.1" : strArrSplit[0].trim();
    }
}

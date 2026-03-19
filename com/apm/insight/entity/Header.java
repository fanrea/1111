package com.apm.insight.entity;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.apm.insight.f;
import com.apm.insight.g;
import com.apm.insight.o.q;
import com.apm.insight.runtime.t;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.apm.common.utility.NetworkUtils;
import com.bytedance.apm.common.utility.PackageUtils;
import com.bytedance.apm.common.utility.ToolUtils;
import com.pandora.common.Constants;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class Header {
    private static final String[] a = {"version_code", "manifest_version_code", "aid", "update_version_code"};
    private static String d = null;
    private static int e = -1;
    private static int f = -1;
    private Context b;
    private JSONObject c = new JSONObject();

    public Header(Context context) {
        this.b = context;
    }

    public static Header a(Context context) throws JSONException {
        Header header = new Header(context);
        header.e(header.g());
        return header;
    }

    public static Header a(Context context, long j) throws JSONException {
        Header headerA;
        t tVarA = t.a();
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        JSONObject jSONObjectA = tVarA.a(j);
        if (jSONObjectA == null || jSONObjectA.length() == 0) {
            headerA = a(g.f());
            headerA.c();
            try {
                headerA.g().put("errHeader", 1);
            } catch (Throwable unused) {
            }
        } else {
            headerA = new Header(g.f());
        }
        b(headerA);
        headerA.a(jSONObjectA);
        return headerA;
    }

    public static Header a(Header header) throws JSONException {
        addRuntimeHeader(header.g());
        return header;
    }

    public static boolean a() {
        if (e == -1) {
            e = h().contains("64") ? 1 : 0;
        }
        return e == 1;
    }

    public static void addOtherHeader(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        h(jSONObject);
        f(jSONObject);
        g(jSONObject);
        try {
            jSONObject.put("os", "Android");
            jSONObject.put(com.baidu.mobads.upgrade.remote.gray.c.l, g.c().a());
            jSONObject.put("os_version", i());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            String str = Build.MODEL;
            String str2 = Build.BRAND;
            if (str == null) {
                str = str2;
            } else if (str2 != null && !str.contains(str2)) {
                str = str2 + ' ' + str;
            }
            jSONObject.put("device_model", str);
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            jSONObject.put("cpu_abi", h());
            Context contextF = g.f();
            String packageName = contextF.getPackageName();
            jSONObject.put("package", packageName);
            PackageInfo packageInfo = PackageUtils.getPackageInfo(contextF, packageName);
            if (packageInfo.applicationInfo != null) {
                int i = packageInfo.applicationInfo.labelRes;
                jSONObject.put("display_name", i > 0 ? contextF.getString(i) : contextF.getPackageManager().getApplicationLabel(packageInfo.applicationInfo));
            }
            jSONObject.put("is_harmony_os", ToolUtils.isHarmonyOs() ? "1" : "0");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        d.a(jSONObject);
    }

    public static void addRuntimeHeader(JSONObject jSONObject) throws JSONException {
        i(jSONObject);
        if (NetworkUtils.isTelephonyEnable()) {
            j(jSONObject);
        }
    }

    public static Header b(Context context) throws JSONException {
        Header headerA = a(context);
        a(headerA);
        b(headerA);
        headerA.c();
        headerA.d();
        headerA.e();
        return headerA;
    }

    public static void b(Header header) throws JSONException {
        if (header == null) {
            return;
        }
        addOtherHeader(header.g());
    }

    public static boolean b() {
        if (f == -1) {
            f = h().contains("86") ? 1 : 0;
        }
        return f == 1;
    }

    public static boolean b(JSONObject jSONObject) {
        return jSONObject.optInt("unauthentic_version", 0) == 1;
    }

    public static boolean c(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() == 0 || (jSONObject.opt("app_version") == null && jSONObject.opt(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME) == null) || jSONObject.opt("version_code") == null || jSONObject.opt("update_version_code") == null;
    }

    public static boolean d(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            String strOptString = jSONObject.optString("aid");
            if (TextUtils.isEmpty(strOptString)) {
                return true;
            }
            try {
                return Integer.parseInt(strOptString) <= 0;
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    private void e(JSONObject jSONObject) throws JSONException {
        try {
            jSONObject.put("sdk_version", 1050790);
            jSONObject.put("sdk_version_name", "1.5.7.oversea");
        } catch (Exception unused) {
        }
    }

    private static void f(JSONObject jSONObject) throws JSONException {
        try {
            DisplayMetrics displayMetrics = g.f().getResources().getDisplayMetrics();
            int i = displayMetrics.densityDpi;
            String str = i < 160 ? "ldpi" : i < 240 ? "mdpi" : i < 320 ? "hdpi" : i < 480 ? "xhdpi" : i < 640 ? "xxhdpi" : "xxxhdpi";
            jSONObject.put("density_dpi", i);
            jSONObject.put("display_density", str);
            jSONObject.put("resolution", displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        } catch (Exception unused) {
        }
    }

    private static void g(JSONObject jSONObject) throws JSONException {
        try {
            String language = g.f().getResources().getConfiguration().locale.getLanguage();
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

    private static String h() {
        if (d == null) {
            try {
                StringBuilder sb = new StringBuilder();
                if (Build.VERSION.SDK_INT < 21 || Build.SUPPORTED_ABIS.length <= 0) {
                    sb = new StringBuilder(Build.CPU_ABI);
                } else {
                    for (int i = 0; i < Build.SUPPORTED_ABIS.length; i++) {
                        sb.append(Build.SUPPORTED_ABIS[i]);
                        if (i != Build.SUPPORTED_ABIS.length - 1) {
                            sb.append(", ");
                        }
                    }
                }
                if (TextUtils.isEmpty(sb.toString())) {
                    d = "unknown";
                }
                d = sb.toString();
            } catch (Exception e2) {
                q.b((Throwable) e2);
                d = "unknown";
            }
        }
        return d;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0043 A[Catch: all -> 0x0057, TryCatch #0 {all -> 0x0057, blocks: (B:3:0x0005, B:6:0x000d, B:16:0x0038, B:18:0x0043, B:19:0x004d, B:7:0x0011, B:10:0x001a, B:12:0x0024, B:13:0x0029, B:15:0x002f), top: B:22:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void h(org.json.JSONObject r3) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            boolean r1 = com.apm.insight.o.d.c()     // Catch: java.lang.Throwable -> L57
            if (r1 == 0) goto L11
            java.lang.String r1 = "MIUI-"
        Ld:
            r0.append(r1)     // Catch: java.lang.Throwable -> L57
            goto L38
        L11:
            boolean r1 = com.apm.insight.o.d.d()     // Catch: java.lang.Throwable -> L57
            if (r1 == 0) goto L1a
            java.lang.String r1 = "FLYME-"
            goto Ld
        L1a:
            java.lang.String r1 = com.apm.insight.o.d.a()     // Catch: java.lang.Throwable -> L57
            boolean r2 = com.apm.insight.o.d.a(r1)     // Catch: java.lang.Throwable -> L57
            if (r2 == 0) goto L29
            java.lang.String r2 = "EMUI-"
            r0.append(r2)     // Catch: java.lang.Throwable -> L57
        L29:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L57
            if (r2 != 0) goto L38
            java.lang.StringBuilder r1 = r0.append(r1)     // Catch: java.lang.Throwable -> L57
            java.lang.String r2 = "-"
            r1.append(r2)     // Catch: java.lang.Throwable -> L57
        L38:
            java.lang.String r1 = android.os.Build.VERSION.INCREMENTAL     // Catch: java.lang.Throwable -> L57
            r0.append(r1)     // Catch: java.lang.Throwable -> L57
            int r1 = r0.length()     // Catch: java.lang.Throwable -> L57
            if (r1 <= 0) goto L4d
            java.lang.String r1 = "rom"
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L57
            r3.put(r1, r0)     // Catch: java.lang.Throwable -> L57
        L4d:
            java.lang.String r0 = "rom_version"
            java.lang.String r1 = com.apm.insight.o.t.a()     // Catch: java.lang.Throwable -> L57
            r3.put(r0, r1)     // Catch: java.lang.Throwable -> L57
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.entity.Header.h(org.json.JSONObject):void");
    }

    private static String i() {
        String str = Build.VERSION.RELEASE;
        return str.contains(".") ? str : str + ".0";
    }

    private static void i(JSONObject jSONObject) throws JSONException {
        try {
            jSONObject.put("access", NetworkUtils.getNetworkAccessType(NetworkUtils.getNetworkTypeFast(g.f())));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void j(JSONObject jSONObject) throws JSONException {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) g.f().getSystemService("phone");
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
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public JSONObject a(Map<String, Object> map) {
        if (map == null) {
            return this.c;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!this.c.has(entry.getKey())) {
                this.c.put(entry.getKey(), entry.getValue());
            }
        }
        for (String str : a) {
            if (map.containsKey(str)) {
                try {
                    this.c.put(str, Integer.parseInt(String.valueOf(map.get(str))));
                } catch (Throwable unused) {
                    this.c.put(str, map.get(str));
                }
            }
        }
        if (map.containsKey("version_code") && !map.containsKey("manifest_version_code")) {
            try {
                this.c.put("manifest_version_code", Integer.parseInt(String.valueOf(map.get("version_code"))));
            } catch (Throwable unused2) {
            }
        }
        if (map.containsKey(Config.IID)) {
            this.c.put("udid", map.get(Config.IID));
            this.c.remove(Config.IID);
        }
        if (map.containsKey(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME)) {
            this.c.put("app_version", map.get(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME));
            this.c.remove(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
        }
        return this.c;
    }

    public JSONObject a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return this.c;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                this.c.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return this.c;
    }

    public JSONObject c() {
        return a(g.a().a());
    }

    public JSONObject d() throws JSONException {
        try {
            this.c.put(com.baidu.mobads.upgrade.remote.gray.c.l, g.c().a());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return this.c;
    }

    public JSONObject e() throws JSONException {
        try {
            long jF = g.a().f();
            if (jF > 0) {
                this.c.put("user_id", jF);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return this.c;
    }

    public JSONObject f() throws JSONException {
        try {
            String strC = f.c(this.c.optString("aid"));
            if (!TextUtils.isEmpty(strC)) {
                this.c.put("x-auth-token", strC);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return this.c;
    }

    public JSONObject g() {
        return this.c;
    }
}

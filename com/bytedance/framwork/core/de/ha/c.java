package com.bytedance.framwork.core.de.ha;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.framwork.core.de.ha.h;
import com.kwai.middleware.azeroth.utils.NetworkUtils;
import com.pandora.common.Constants;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Header.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    private static long a = -1;
    private static String b = null;
    private static int c = -1;
    private static int d = -1;

    public static void a(JSONObject jSONObject, Context context) throws JSONException {
        c(jSONObject, context);
        d(jSONObject, context);
    }

    private static void c(JSONObject jSONObject, Context context) throws JSONException {
        try {
            jSONObject.put("access", a(h.a(context)));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* compiled from: Header.java */
    /* renamed from: com.bytedance.framwork.core.de.ha.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[h.a.values().length];
            a = iArr;
            try {
                iArr[h.a.WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[h.a.MOBILE_2G.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[h.a.MOBILE_3G.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[h.a.MOBILE_4G.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[h.a.MOBILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static String a(h.a aVar) {
        String str;
        try {
            int i = AnonymousClass1.a[aVar.ordinal()];
            if (i == 1) {
                str = com.baidu.mobads.container.util.e.a.a;
            } else if (i == 2) {
                str = NetworkUtils.MOBILE_NETWORK_2G;
            } else if (i == 3) {
                str = NetworkUtils.MOBILE_NETWORK_3G;
            } else if (i == 4) {
                str = NetworkUtils.MOBILE_NETWORK_4G;
            } else {
                if (i != 5) {
                    return "";
                }
                str = "mobile";
            }
            return str;
        } catch (Exception unused) {
            return "";
        }
    }

    private static void d(JSONObject jSONObject, Context context) throws JSONException {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
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
            e.printStackTrace();
        }
    }

    public static void b(JSONObject jSONObject, Context context) throws JSONException {
        int i;
        if (jSONObject == null) {
            return;
        }
        b(jSONObject);
        c(jSONObject);
        f(jSONObject, context);
        g(jSONObject, context);
        a(jSONObject);
        e(jSONObject, context);
        try {
            jSONObject.put("os", "Android");
            jSONObject.put("os_version", c());
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
            jSONObject.put("cpu_abi", b());
            String packageName = context.getPackageName();
            jSONObject.put("package", packageName);
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            if (packageInfo.applicationInfo == null || (i = packageInfo.applicationInfo.labelRes) <= 0) {
                return;
            }
            jSONObject.put("display_name", context.getString(i));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static long a() {
        if (a == -1) {
            try {
                a = Runtime.getRuntime().maxMemory();
            } catch (Exception unused) {
            }
        }
        return a;
    }

    private static void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("max_memory", a() / 1024);
        } catch (Exception unused) {
        }
    }

    private static void e(JSONObject jSONObject, Context context) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("identifier", k.a(context));
        } catch (Exception unused) {
        }
    }

    private static String b() {
        if (b == null) {
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
                if (TextUtils.isEmpty(sb.toString())) {
                    b = "unknown";
                }
                b = sb.toString();
            } catch (Exception unused) {
                b = "unknown";
            }
        }
        return b;
    }

    private static String c() {
        String str = Build.VERSION.RELEASE;
        return str.contains(".") ? str : str + ".0";
    }

    private static void f(JSONObject jSONObject, Context context) throws JSONException {
        try {
            DisplayMetrics displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
            int i = displayMetrics.densityDpi;
            String str = i != 120 ? i != 240 ? i != 320 ? "mdpi" : "xhdpi" : "hdpi" : "ldpi";
            jSONObject.put("density_dpi", i);
            jSONObject.put("display_density", str);
            jSONObject.put("resolution", displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        } catch (Exception unused) {
        }
    }

    private static void g(JSONObject jSONObject, Context context) throws JSONException {
        try {
            String language = context.getApplicationContext().getResources().getConfiguration().locale.getLanguage();
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

    private static void b(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(Build.VERSION.INCREMENTAL);
            if (sb.length() > 0) {
                jSONObject.put(Config.ROM, sb.toString());
            }
            jSONObject.put("rom_version", j.a());
        } catch (Throwable unused) {
        }
    }

    private static void c(JSONObject jSONObject) {
        try {
            String strA = b.a();
            if (TextUtils.isEmpty(strA)) {
                strA = "";
            }
            jSONObject.put("cpu_model", strA);
        } catch (Throwable unused) {
        }
    }
}

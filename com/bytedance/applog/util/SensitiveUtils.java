package com.bytedance.applog.util;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Process;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.g;
import com.bytedance.applog.ISensitiveInfoProvider;
import com.bytedance.applog.Level;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.bdtracker.f4;
import com.bytedance.bdtracker.l0;
import com.bytedance.bdtracker.o3;
import com.bytedance.bdtracker.q3;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class SensitiveUtils {
    public static final String CHANNEL_APP_KEY = "UMENG_APPKEY";
    public static final String KEY_ALIYUN_UUID = "aliyun_uuid";
    public static final String KEY_BUILD_SERIAL = "build_serial";
    public static final String KEY_MAC = "mac_address";
    public static final String KEY_MC = "mc";
    public static final List<String> a = Collections.singletonList("SensitiveUtils");

    public static class a implements f4.a {
        public final /* synthetic */ Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // com.bytedance.bdtracker.f4.a
        public String a() {
            if (!SensitiveUtils.hasReadPhoneStatePermission(this.a)) {
                return null;
            }
            LoggerImpl.global().debug(SensitiveUtils.a, "[DeviceMeta&READ_PHONE_STATE] Try to get device id.", new Object[0]);
            try {
                TelephonyManager telephonyManager = (TelephonyManager) this.a.getSystemService("phone");
                return telephonyManager == null ? "" : telephonyManager.getDeviceId();
            } catch (Throwable th) {
                LoggerImpl.global().error(SensitiveUtils.a, "Get device id failed", th, new Object[0]);
                return null;
            }
        }
    }

    public static class b implements f4.a {
        public final /* synthetic */ Context a;

        public b(Context context) {
            this.a = context;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00b2  */
        /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r3v3 */
        /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.String[]] */
        @Override // com.bytedance.bdtracker.f4.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String a() {
            /*
                r8 = this;
                r0 = 0
                r1 = 0
                int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> La0
                r3 = 22
                if (r2 < r3) goto L61
                android.content.Context r2 = r8.a     // Catch: java.lang.Throwable -> La0
                boolean r2 = com.bytedance.applog.util.SensitiveUtils.hasReadPhoneStatePermission(r2)     // Catch: java.lang.Throwable -> La0
                if (r2 == 0) goto L5f
                android.content.Context r2 = r8.a     // Catch: java.lang.Throwable -> La0
                android.telephony.SubscriptionManager r2 = android.telephony.SubscriptionManager.from(r2)     // Catch: java.lang.Throwable -> La0
                com.bytedance.applog.log.IAppLogLogger r3 = com.bytedance.applog.log.LoggerImpl.global()     // Catch: java.lang.Throwable -> L4f
                java.util.List<java.lang.String> r4 = com.bytedance.applog.util.SensitiveUtils.a     // Catch: java.lang.Throwable -> L4f
                java.lang.String r5 = "[DeviceMeta&READ_PHONE_STATE] Try to get active subscription info list."
                java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L4f
                r3.debug(r4, r5, r6)     // Catch: java.lang.Throwable -> L4f
                java.util.List r2 = r2.getActiveSubscriptionInfoList()     // Catch: java.lang.Throwable -> L4f
                if (r2 == 0) goto L4e
                boolean r3 = r2.isEmpty()     // Catch: java.lang.Throwable -> L4f
                if (r3 == 0) goto L30
                goto L4e
            L30:
                int r3 = r2.size()     // Catch: java.lang.Throwable -> L4f
                java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L4f
                r4 = r1
            L37:
                int r5 = r2.size()     // Catch: java.lang.Throwable -> L4c
                if (r4 >= r5) goto Laf
                java.lang.Object r5 = r2.get(r4)     // Catch: java.lang.Throwable -> L4c
                android.telephony.SubscriptionInfo r5 = (android.telephony.SubscriptionInfo) r5     // Catch: java.lang.Throwable -> L4c
                java.lang.String r5 = r5.getIccId()     // Catch: java.lang.Throwable -> L4c
                r3[r4] = r5     // Catch: java.lang.Throwable -> L4c
                int r4 = r4 + 1
                goto L37
            L4c:
                r2 = move-exception
                goto L51
            L4e:
                return r0
            L4f:
                r2 = move-exception
                r3 = r0
            L51:
                com.bytedance.applog.log.IAppLogLogger r4 = com.bytedance.applog.log.LoggerImpl.global()     // Catch: java.lang.Throwable -> L9e
                java.util.List<java.lang.String> r5 = com.bytedance.applog.util.SensitiveUtils.a     // Catch: java.lang.Throwable -> L9e
                java.lang.String r6 = "Get iccid failed"
                java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L9e
                r4.error(r5, r6, r2, r7)     // Catch: java.lang.Throwable -> L9e
                goto Laf
            L5f:
                r3 = r0
                goto Laf
            L61:
                r2 = 1
                java.lang.String[] r3 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> La0
                android.content.Context r2 = r8.a     // Catch: java.lang.Throwable -> L9e
                boolean r2 = com.bytedance.applog.util.SensitiveUtils.hasReadPhoneStatePermission(r2)     // Catch: java.lang.Throwable -> L9e
                if (r2 == 0) goto Laf
                com.bytedance.applog.log.IAppLogLogger r2 = com.bytedance.applog.log.LoggerImpl.global()     // Catch: java.lang.Throwable -> L9e
                java.util.List<java.lang.String> r4 = com.bytedance.applog.util.SensitiveUtils.a     // Catch: java.lang.Throwable -> L9e
                java.lang.String r5 = "[DeviceMeta&READ_PHONE_STATE] Try to get sim serial number."
                java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L9e
                r2.debug(r4, r5, r6)     // Catch: java.lang.Throwable -> L9e
                android.content.Context r2 = r8.a     // Catch: java.lang.Throwable -> L9e
                java.lang.String r4 = "phone"
                java.lang.Object r2 = r2.getSystemService(r4)     // Catch: java.lang.Throwable -> L9e
                android.telephony.TelephonyManager r2 = (android.telephony.TelephonyManager) r2     // Catch: java.lang.Throwable -> L9e
                if (r2 != 0) goto L88
                java.lang.String r2 = ""
                goto L8c
            L88:
                java.lang.String r2 = r2.getSimSerialNumber()     // Catch: java.lang.Throwable -> L8f
            L8c:
                r3[r1] = r2     // Catch: java.lang.Throwable -> L8f
                goto Laf
            L8f:
                r2 = move-exception
                com.bytedance.applog.log.IAppLogLogger r4 = com.bytedance.applog.log.LoggerImpl.global()     // Catch: java.lang.Throwable -> L9e
                java.util.List<java.lang.String> r5 = com.bytedance.applog.util.SensitiveUtils.a     // Catch: java.lang.Throwable -> L9e
                java.lang.String r6 = "Get sim serial number failed"
                java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L9e
                r4.error(r5, r6, r2, r7)     // Catch: java.lang.Throwable -> L9e
                goto Laf
            L9e:
                r2 = move-exception
                goto La2
            La0:
                r2 = move-exception
                r3 = r0
            La2:
                com.bytedance.applog.log.IAppLogLogger r4 = com.bytedance.applog.log.LoggerImpl.global()
                java.util.List<java.lang.String> r5 = com.bytedance.applog.util.SensitiveUtils.a
                java.lang.Object[] r1 = new java.lang.Object[r1]
                java.lang.String r6 = "Get accId failed"
                r4.error(r5, r6, r2, r1)
            Laf:
                if (r3 != 0) goto Lb2
                goto Lb8
            Lb2:
                java.lang.String r0 = ","
                java.lang.String r0 = android.text.TextUtils.join(r0, r3)
            Lb8:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.applog.util.SensitiveUtils.b.a():java.lang.String");
        }
    }

    public static class c implements f4.a {
        @Override // com.bytedance.bdtracker.f4.a
        public String a() throws SocketException {
            if (Build.VERSION.SDK_INT < 23) {
                return "";
            }
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces != null && networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if ("wlan0".equals(networkInterfaceNextElement.getName())) {
                    LoggerImpl.global().debug(SensitiveUtils.a, com.bytedance.bdtracker.a.a("[DeviceMeta] Try to get hardware address from ").append(networkInterfaceNextElement.getName()).append(".").toString(), new Object[0]);
                    byte[] hardwareAddress = networkInterfaceNextElement.getHardwareAddress();
                    if (hardwareAddress != null && hardwareAddress.length > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (byte b : hardwareAddress) {
                            sb.append(String.format("%02X:", Byte.valueOf(b)));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        return sb.toString();
                    }
                }
            }
            return "";
        }
    }

    public static class d implements f4.a {
        public final /* synthetic */ Context a;

        public d(Context context) {
            this.a = context;
        }

        @Override // com.bytedance.bdtracker.f4.a
        public String a() {
            if (Build.VERSION.SDK_INT < 26 || !SensitiveUtils.hasReadPhoneStatePermission(this.a)) {
                return null;
            }
            LoggerImpl.global().debug(SensitiveUtils.a, "[DeviceMeta&READ_PHONE_STATE] Try to get imei and meid info", new Object[0]);
            int activeSubscriptionInfoCount = SubscriptionManager.from(this.a).getActiveSubscriptionInfoCount();
            JSONArray jSONArray = new JSONArray();
            TelephonyManager telephonyManager = (TelephonyManager) this.a.getSystemService("phone");
            for (int i = 0; i < activeSubscriptionInfoCount; i++) {
                String imei = "";
                try {
                    jSONArray.put(SensitiveUtils.a(telephonyManager == null ? "" : telephonyManager.getMeid(i), i, "meid"));
                } catch (Throwable unused) {
                }
                if (telephonyManager == null) {
                    jSONArray.put(SensitiveUtils.a(imei, i, g.z));
                } else {
                    try {
                        imei = telephonyManager.getImei(i);
                        jSONArray.put(SensitiveUtils.a(imei, i, g.z));
                    } catch (Throwable unused2) {
                    }
                }
            }
            return jSONArray.toString();
        }
    }

    public static class e implements f4.a {
        public final /* synthetic */ Context a;

        public e(Context context) {
            this.a = context;
        }

        @Override // com.bytedance.bdtracker.f4.a
        public String a() {
            if (Build.VERSION.SDK_INT < 26 || this.a.getApplicationInfo().targetSdkVersion < 26 || !SensitiveUtils.hasReadPhoneStatePermission(this.a)) {
                return "";
            }
            LoggerImpl.global().debug(SensitiveUtils.a, "[DeviceMeta&READ_PHONE_STATE] Try to get build serial.", new Object[0]);
            return Build.getSerial();
        }
    }

    public static String a(Context context, int i) {
        Object objInvoke = null;
        if (!hasReadPhoneStatePermission(context)) {
            return null;
        }
        LoggerImpl.global().debug(a, "[READ_PHONE_STATE] Try to get device id.", new Object[0]);
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null && Build.VERSION.SDK_INT >= 21) {
                Method method = telephonyManager.getClass().getMethod("getDeviceId", a("getDeviceId"));
                if (i >= 0) {
                    objInvoke = method.invoke(telephonyManager, Integer.valueOf(i));
                }
            }
        } catch (Throwable th) {
            LoggerImpl.global().error(a, "Read phone info failed.", th, new Object[0]);
        }
        return (String) objInvoke;
    }

    public static JSONObject a(String str, int i, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("id", str);
            jSONObject.put("slot_index", i);
            jSONObject.put("type", str2);
        }
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
    
        com.bytedance.applog.log.LoggerImpl.global().debug(com.bytedance.applog.util.SensitiveUtils.a, "params length:" + r2.length, new java.lang.Object[0]);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Class[] a(java.lang.String r8) throws java.lang.SecurityException {
        /*
            r0 = 0
            r1 = 1
            r2 = 0
            java.lang.Class<android.telephony.TelephonyManager> r3 = android.telephony.TelephonyManager.class
            java.lang.reflect.Method[] r3 = r3.getDeclaredMethods()     // Catch: java.lang.Exception -> L43
            int r4 = r3.length     // Catch: java.lang.Exception -> L43
            r5 = r0
        Lb:
            if (r5 >= r4) goto L53
            r6 = r3[r5]     // Catch: java.lang.Exception -> L43
            java.lang.String r7 = r6.getName()     // Catch: java.lang.Exception -> L43
            boolean r7 = r8.equals(r7)     // Catch: java.lang.Exception -> L43
            if (r7 == 0) goto L40
            java.lang.Class[] r2 = r6.getParameterTypes()     // Catch: java.lang.Exception -> L43
            int r6 = r2.length     // Catch: java.lang.Exception -> L43
            if (r6 < r1) goto L40
            com.bytedance.applog.log.IAppLogLogger r3 = com.bytedance.applog.log.LoggerImpl.global()     // Catch: java.lang.Exception -> L43
            java.util.List<java.lang.String> r4 = com.bytedance.applog.util.SensitiveUtils.a     // Catch: java.lang.Exception -> L43
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L43
            r5.<init>()     // Catch: java.lang.Exception -> L43
            java.lang.String r6 = "params length:"
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Exception -> L43
            int r6 = r2.length     // Catch: java.lang.Exception -> L43
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Exception -> L43
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L43
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch: java.lang.Exception -> L43
            r3.debug(r4, r5, r6)     // Catch: java.lang.Exception -> L43
            goto L53
        L40:
            int r5 = r5 + 1
            goto Lb
        L43:
            r3 = move-exception
            com.bytedance.applog.log.IAppLogLogger r4 = com.bytedance.applog.log.LoggerImpl.global()
            java.util.List<java.lang.String> r5 = com.bytedance.applog.util.SensitiveUtils.a
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r0] = r8
            java.lang.String r8 = "TelephonyManager reflect method:{} failed"
            r4.error(r5, r8, r3, r1)
        L53:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.applog.util.SensitiveUtils.a(java.lang.String):java.lang.Class[]");
    }

    public static void addSensitiveParamsForUrlQuery(q3 q3Var, StringBuilder sb, JSONObject jSONObject) {
        o3.a(sb, KEY_BUILD_SERIAL, (String) q3Var.a(jSONObject, KEY_BUILD_SERIAL, (String) null, (Class<String>) String.class));
        JSONArray jSONArray = (JSONArray) q3Var.a(jSONObject, "sim_serial_number", (String) null, (Class<String>) JSONArray.class);
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        try {
            StringBuilder sb2 = new StringBuilder(((JSONObject) jSONArray.get(0)).optString("sim_serial_number"));
            for (int i = 1; i < jSONArray.length(); i++) {
                sb2.append(",").append(((JSONObject) jSONArray.get(i)).optString("sim_serial_number"));
            }
            o3.a(sb, "sim_serial_number", sb2.toString());
        } catch (JSONException e2) {
            LoggerImpl.global().error(a, "failed to get sim_serial_number", e2, new Object[0]);
        }
    }

    public static void appendSensitiveParams(q3 q3Var, JSONObject jSONObject, Map<String, String> map, boolean z, Level level) {
        if (level == Level.L0) {
            if (z) {
                String str = (String) q3Var.a(jSONObject, "mc", (String) null, (Class<String>) String.class);
                String str2 = (String) q3Var.a(jSONObject, "udid", (String) null, (Class<String>) String.class);
                if (!TextUtils.isEmpty(str)) {
                    map.put(KEY_MAC, str);
                }
                if (l0.b.a(str2)) {
                    map.put("uuid", str2);
                }
            }
            String str3 = (String) q3Var.a(jSONObject, KEY_ALIYUN_UUID, (String) null, (Class<String>) String.class);
            if (!TextUtils.isEmpty(str3)) {
                map.put(KEY_ALIYUN_UUID, str3);
            }
        }
        String str4 = (String) q3Var.a(jSONObject, KEY_BUILD_SERIAL, (String) null, (Class<String>) String.class);
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        map.put(KEY_BUILD_SERIAL, str4);
    }

    public static String getDeviceId(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return f4.a(context).a("TelephonyManager.getDeviceId", new a(context));
        } catch (Throwable th) {
            LoggerImpl.global().error(a, "Get device id failed", th, new Object[0]);
            return null;
        }
    }

    public static String getMacAddress(ISensitiveInfoProvider iSensitiveInfoProvider, Context context) {
        return iSensitiveInfoProvider != null ? iSensitiveInfoProvider.getMac() : getMacAddressFromSystem(context);
    }

    public static String getMacAddressFromSystem(Context context) {
        String strA;
        try {
            strA = f4.a(context).a("NetworkInterface.getHardwareAddress", new c());
        } catch (Throwable th) {
            LoggerImpl.global().error(a, "Get HardwareAddress failed", th, new Object[0]);
            strA = null;
        }
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService(com.baidu.mobads.container.util.e.a.a);
            return (wifiManager == null || wifiManager.getConnectionInfo() == null) ? strA : wifiManager.getConnectionInfo().getMacAddress();
        } catch (Throwable th2) {
            LoggerImpl.global().error(a, "Get MacAddress failed", th2, new Object[0]);
            return strA;
        }
    }

    public static JSONArray getMultiImeiFallback(Context context) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(a(a(context, 0), 0, "unknown"));
        jSONArray.put(a(a(context, 1), 1, "unknown"));
        return jSONArray;
    }

    public static JSONArray getMultiImeiFromSystem(Context context) {
        try {
            String strA = f4.a(context).a("TelephonyManager.getMultiImei", new d(context));
            return TextUtils.isEmpty(strA) ? new JSONArray() : new JSONArray(strA);
        } catch (Throwable th) {
            LoggerImpl.global().error(a, "Failed to get meid 0", th, new Object[0]);
            return null;
        }
    }

    public static String getSerialNumber(Context context) {
        String strA = null;
        if (context == null) {
            return null;
        }
        try {
            strA = f4.a(context).a("Build.getSerial", new e(context));
        } catch (Throwable th) {
            LoggerImpl.global().error(a, "Build getSerial failed.", th, new Object[0]);
        }
        if (TextUtils.isEmpty(strA) || TextUtils.equals(strA, "unknown")) {
            strA = Build.SERIAL;
        }
        return (TextUtils.isEmpty(strA) || TextUtils.equals(strA, "unknown")) ? "" : strA;
    }

    public static String[] getSimSerialNumbers(Context context) {
        if (context == null) {
            return new String[0];
        }
        try {
            String strA = f4.a(context).a("SubscriptionInfo.getIccid", new b(context));
            if (!TextUtils.isEmpty(strA)) {
                return strA.split(",");
            }
        } catch (Throwable th) {
            LoggerImpl.global().error(a, "getSimSerialNumbers failed", th, new Object[0]);
        }
        return new String[0];
    }

    public static boolean hasPermission(Context context, String str) {
        if (str == null) {
            return false;
        }
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        } catch (Throwable th) {
            LoggerImpl.global().error(a, "check has permission failed.", th, new Object[0]);
            return false;
        }
    }

    public static boolean hasReadPhoneStatePermission(Context context) {
        return hasPermission(context, Build.VERSION.SDK_INT > 28 ? "android.permission.READ_PRECISE_PHONE_STATE" : "android.permission.READ_PHONE_STATE");
    }

    public static boolean validMultiImei(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return validMultiImei(new JSONArray(str));
            } catch (JSONException e2) {
                LoggerImpl.global().error(a, "JSON handle failed", e2, new Object[0]);
            }
        }
        return false;
    }

    public static boolean validMultiImei(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) <= 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null && !TextUtils.isEmpty(jSONObjectOptJSONObject.optString("id"))) {
                return true;
            }
        }
        return false;
    }
}

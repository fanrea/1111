package com.pandora.common.globalsettings;

import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import com.baidu.mobads.upgrade.remote.gray.c;
import com.pandora.common.env.Env;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class GlobalSdkParamsUtil {
    public static final String CN_HOST = "";
    public static final String GLOBAL_HOST = "";
    public static final String REGION_CN = "CN";
    public static final String REGION_GLOBAL = "GLOBAL";
    public static final String TAG = "GlobalSdkParamsUtil";

    public static String getAppVersionCode() {
        return null;
    }

    public static String getProjectKey() {
        return "ttsdk";
    }

    public static String settingURLString() {
        if (TextUtils.isEmpty("")) {
            return null;
        }
        HashMap map = new HashMap();
        map.put("device_platform", "android");
        map.put("aid", getAppID());
        map.put(c.l, getDeviceId());
        map.put("user_id", getUserId());
        map.put("device_type", getSystemModel());
        map.put("os_version", getSystemVersion());
        map.put("sdk_version", getSdkVersion());
        map.put("app_version_code", getAppVersionCode());
        map.put("project_key", getProjectKey());
        StringBuilder sb = new StringBuilder();
        try {
            for (String str : map.keySet()) {
                if (!TextUtils.isEmpty((CharSequence) map.get(str))) {
                    sb.append(a.n).append(str).append("=").append(URLEncoder.encode((String) map.get(str), "UTF-8"));
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (sb.length() == 0) {
            return null;
        }
        return String.format("%s/neptune/platform/v2/external/sched_config/GetGlobalSdkParams?%s", "", sb.substring(1));
    }

    public static String getAppID() {
        return Env.getAppID();
    }

    public static String getDeviceId() {
        return Env.getAppLogClient() == null ? "" : Env.getAppLogClient().getDeviceID();
    }

    public static String getUserId() {
        return Env.getAppLogClient() == null ? "" : Env.getAppLogClient().getUUID();
    }

    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getSystemModel() {
        return Build.MODEL;
    }

    public static String getSdkVersion() {
        return Env.getVersion();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0033 A[PHI: r1 r5
  0x0033: PHI (r1v3 java.lang.String) = (r1v8 java.lang.String), (r1v4 java.lang.String) binds: [B:19:0x0059, B:8:0x0031] A[DONT_GENERATE, DONT_INLINE]
  0x0033: PHI (r5v3 java.net.HttpURLConnection) = (r5v2 java.net.HttpURLConnection), (r5v5 java.net.HttpURLConnection) binds: [B:19:0x0059, B:8:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String get(java.lang.String r5) throws java.lang.Throwable {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r1 = 0
            if (r0 != 0) goto L64
            java.net.URL r0 = new java.net.URL     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            java.net.URLConnection r5 = r0.openConnection()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            java.lang.String r0 = "GET"
            r5.setRequestMethod(r0)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5c
            r0 = 5000(0x1388, float:7.006E-42)
            r5.setReadTimeout(r0)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5c
            r0 = 10000(0x2710, float:1.4013E-41)
            r5.setConnectTimeout(r0)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5c
            int r0 = r5.getResponseCode()     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5c
            r2 = 200(0xc8, float:2.8E-43)
            if (r0 != r2) goto L37
            java.io.InputStream r0 = r5.getInputStream()     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5c
            java.lang.String r1 = getStringFromInputStream(r0)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5c
            if (r5 == 0) goto L64
        L33:
            r5.disconnect()
            goto L64
        L37:
            android.accounts.NetworkErrorException r2 = new android.accounts.NetworkErrorException     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5c
            r3.<init>()     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5c
            java.lang.String r4 = "response status is "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5c
            java.lang.StringBuilder r0 = r3.append(r0)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5c
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5c
            r2.<init>(r0)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5c
            throw r2     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> L5c
        L50:
            r0 = move-exception
            goto L56
        L52:
            r0 = move-exception
            goto L5e
        L54:
            r0 = move-exception
            r5 = r1
        L56:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L5c
            if (r5 == 0) goto L64
            goto L33
        L5c:
            r0 = move-exception
            r1 = r5
        L5e:
            if (r1 == 0) goto L63
            r1.disconnect()
        L63:
            throw r0
        L64:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pandora.common.globalsettings.GlobalSdkParamsUtil.get(java.lang.String):java.lang.String");
    }

    private static String getStringFromInputStream(InputStream is) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = is.read(bArr);
            if (i != -1) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                is.close();
                String string = byteArrayOutputStream.toString();
                byteArrayOutputStream.close();
                return string;
            }
        }
    }
}

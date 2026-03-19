package net.security.device.api;

import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.m.p.e;
import com.alipay.sdk.m.s.a;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.SimpleTimeZone;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class SecurityUtil {
    private static final int MAX_TIME_OUT_CONNECT = 20;
    private static final int MAX_TIME_OUT_READ = 20;
    private static final int MAX_TIME_OUT_WRITE = 20;
    public static final int NET_EXCEPTION_CODE = -1;
    public static Field artMethodField;

    public static String sendPopRequest(String str, Map<String, String> map, Map<String, String> map2) {
        HashMap map3 = new HashMap();
        map3.put("TimestampKeep", formatIso8601Date(new Date()));
        map3.put("SignatureNonce", UUID.randomUUID().toString());
        if (map2 != null) {
            map2.remove("Signature");
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                    map3.put(key, value);
                }
            }
            String str2 = map2.get(e.g);
            if (str2 != null && !str2.isEmpty() && str2.equals("2020-04-25")) {
                map3.put("Timestamp", formatIso8601Date(new Date()));
            }
        }
        try {
            map3.put("Signature", computeSignature(map3, "UTF-8"));
        } catch (Throwable unused) {
            map3.put("Signature", ILogConst.CACHE_PLAY_REASON_NULL);
        }
        return httpPost(str, map, map3);
    }

    private static String formatIso8601Date(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        return simpleDateFormat.format(date);
    }

    public static String computeSignature(Map<String, String> map, String str) throws Exception {
        String[] strArr = (String[]) map.keySet().toArray(new String[0]);
        Arrays.sort(strArr);
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str2 : strArr) {
            if (z) {
                z = false;
            } else {
                sb.append(a.n);
            }
            sb.append(encode(str2, str)).append("=").append(encode(map.get(str2), str));
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("POST").append(a.n);
        sb2.append(encode("/", str)).append(a.n);
        sb2.append(encode(sb.toString(), str));
        return SecurityDevice.gs(sb2.toString());
    }

    private static String encode(String str, String str2) throws UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return URLEncoder.encode(str, str2).replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
    }

    private static String httpPost(String str, Map<String, String> map, Map<String, String> map2) {
        OkHttpClient okHttpClientBuild = new OkHttpClient.Builder().connectTimeout(20L, TimeUnit.SECONDS).readTimeout(20L, TimeUnit.SECONDS).writeTimeout(20L, TimeUnit.SECONDS).build();
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            builder.add(entry.getKey(), entry.getValue());
        }
        Request.Builder builder2 = new Request.Builder();
        for (Map.Entry<String, String> entry2 : map.entrySet()) {
            builder2 = builder2.addHeader(entry2.getKey(), entry2.getValue());
        }
        try {
            Response responseExecute = okHttpClientBuild.newCall(builder2.url(str).post(builder.build()).build()).execute();
            ResponseBody responseBodyBody = responseExecute.body();
            return responseExecute.code() + "#" + Base64.encodeToString((responseBodyBody != null ? responseBodyBody.string() : "").getBytes(), 2);
        } catch (Exception e) {
            return "-1#" + Base64.encodeToString(e.getMessage().getBytes(), 2);
        }
    }

    public static boolean isExeFileExist(String str) throws InterruptedException, IOException {
        try {
            Process processExec = Runtime.getRuntime().exec(str);
            if (processExec == null) {
                return false;
            }
            processExec.destroy();
            processExec.waitFor();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int downloadFile(java.lang.String r6, java.lang.String r7) throws java.lang.Throwable {
        /*
            boolean r0 = r6.isEmpty()
            r1 = -1
            if (r0 != 0) goto Ld7
            boolean r0 = r7.isEmpty()
            if (r0 == 0) goto Lf
            goto Ld7
        Lf:
            java.io.File r0 = new java.io.File
            r0.<init>(r7)
            boolean r2 = r0.exists()
            if (r2 != 0) goto L4d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "savePath not exists, start mkdir, savePath: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r7)
            java.lang.String r2 = r2.toString()
            net.security.device.api.LogUtil.d(r2)
            boolean r0 = r0.mkdir()
            if (r0 != 0) goto L4d
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "mkdir savePath error, savaPath: "
            java.lang.StringBuilder r6 = r6.append(r0)
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            net.security.device.api.LogUtil.d(r6)
            return r1
        L4d:
            okhttp3.OkHttpClient r0 = new okhttp3.OkHttpClient
            r0.<init>()
            okhttp3.Request$Builder r2 = new okhttp3.Request$Builder
            r2.<init>()
            okhttp3.Request$Builder r2 = r2.url(r6)
            java.lang.String r3 = "Connection"
            java.lang.String r4 = "close"
            okhttp3.Request$Builder r2 = r2.addHeader(r3, r4)
            okhttp3.Request r2 = r2.build()
            r3 = 4096(0x1000, float:5.74E-42)
            r4 = 0
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> Lb8 java.lang.Exception -> Lbb
            okhttp3.Call r0 = r0.newCall(r2)     // Catch: java.lang.Throwable -> Lb8 java.lang.Exception -> Lbb
            okhttp3.Response r0 = r0.execute()     // Catch: java.lang.Throwable -> Lb8 java.lang.Exception -> Lbb
            okhttp3.ResponseBody r0 = r0.body()     // Catch: java.lang.Throwable -> Lb8 java.lang.Exception -> Lbb
            if (r0 != 0) goto L7b
            return r1
        L7b:
            java.io.InputStream r0 = r0.byteStream()     // Catch: java.lang.Throwable -> Lb8 java.lang.Exception -> Lbb
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb4
            java.lang.String r5 = "/"
            int r5 = r6.lastIndexOf(r5)     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb4
            int r5 = r5 + 1
            java.lang.String r6 = r6.substring(r5)     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb4
            r2.<init>(r7, r6)     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb4
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb4
            r6.<init>(r2)     // Catch: java.lang.Throwable -> Lb0 java.lang.Exception -> Lb4
        L95:
            int r7 = r0.read(r3)     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            r2 = 0
            if (r7 == r1) goto La0
            r6.write(r3, r2, r7)     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            goto L95
        La0:
            r6.flush()     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            if (r0 == 0) goto La8
            r0.close()     // Catch: java.io.IOException -> La8
        La8:
            r6.close()     // Catch: java.io.IOException -> Lab
        Lab:
            return r2
        Lac:
            r7 = move-exception
            goto Lb2
        Lae:
            r7 = move-exception
            goto Lb6
        Lb0:
            r7 = move-exception
            r6 = r4
        Lb2:
            r4 = r0
            goto Lcc
        Lb4:
            r7 = move-exception
            r6 = r4
        Lb6:
            r4 = r0
            goto Lbd
        Lb8:
            r7 = move-exception
            r6 = r4
            goto Lcc
        Lbb:
            r7 = move-exception
            r6 = r4
        Lbd:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> Lcb
            if (r4 == 0) goto Lc5
            r4.close()     // Catch: java.io.IOException -> Lc5
        Lc5:
            if (r6 == 0) goto Lca
            r6.close()     // Catch: java.io.IOException -> Lca
        Lca:
            return r1
        Lcb:
            r7 = move-exception
        Lcc:
            if (r4 == 0) goto Ld1
            r4.close()     // Catch: java.io.IOException -> Ld1
        Ld1:
            if (r6 == 0) goto Ld6
            r6.close()     // Catch: java.io.IOException -> Ld6
        Ld6:
            throw r7
        Ld7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.security.device.api.SecurityUtil.downloadFile(java.lang.String, java.lang.String):int");
    }

    public static String generateSessionId(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        String string = UUID.randomUUID().toString();
        if (string.isEmpty()) {
            return "";
        }
        String str2 = String.format("%s-%s-%d-%s", str, "h", Long.valueOf(System.currentTimeMillis()), string.replace("-", ""));
        String strSubstring = str2.substring(0, str2.length() - 4);
        StringBuilder sb = new StringBuilder();
        sb.append(strSubstring).append("7849478494");
        int iAbs = Math.abs(sb.toString().hashCode());
        String strValueOf = String.valueOf(iAbs);
        if (strValueOf.length() > 4) {
            strValueOf = strValueOf.substring(strValueOf.length() - 4);
        } else if (strValueOf.length() < 4) {
            strValueOf = String.format("%4d", Integer.valueOf(iAbs));
        }
        return strSubstring + strValueOf;
    }

    public static void utilInit() {
        try {
            artMethodField = getField(Method.class, "artMethod");
        } catch (Exception unused) {
        }
    }

    public static Field getField(Class cls, String str) throws NoSuchFieldException {
        while (cls != null && cls != Object.class) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (Exception unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static long getArtMethod(Member member) {
        Field field = artMethodField;
        if (field == null) {
            return 0L;
        }
        try {
            return ((Long) field.get(member)).longValue();
        } catch (IllegalAccessException unused) {
            return 0L;
        }
    }
}

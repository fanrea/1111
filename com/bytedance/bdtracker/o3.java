package com.bytedance.bdtracker;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.applog.InitConfig;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.bdtracker.l0;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class o3 {
    public static JSONObject d;
    public String a = "https://databyterangers.com.cn";
    public final d b;
    public final o4 c;

    public class a implements EventBus.DataFetcher {
        public final /* synthetic */ JSONObject a;

        public a(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // com.bytedance.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            l0.b.b(this.a, jSONObject);
            try {
                jSONObject.put("appId", o3.this.b.m);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    public class b implements EventBus.DataFetcher {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ byte[] c;
        public final /* synthetic */ String d;
        public final /* synthetic */ long e;
        public final /* synthetic */ HttpURLConnection f;

        public b(String str, int i, byte[] bArr, String str2, long j, HttpURLConnection httpURLConnection) {
            this.a = str;
            this.b = i;
            this.c = bArr;
            this.d = str2;
            this.e = j;
            this.f = httpURLConnection;
        }

        @Override // com.bytedance.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appId", o3.this.b.m);
                jSONObject.put("nid", this.a);
                jSONObject.put("statusCode", this.b);
                jSONObject.put("responseByte", this.c);
                jSONObject.put("responseString", this.d);
                jSONObject.put("time", this.e);
                jSONObject.put("header", o3.this.a(this.f));
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    public o3(d dVar) {
        this.b = dVar;
        this.c = new o4(dVar);
    }

    public static String a(String str, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Uri uri = Uri.parse(str);
        HashMap map = new HashMap(strArr.length);
        for (String str2 : strArr) {
            String queryParameter = uri.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                map.put(str2, queryParameter);
            }
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.clearQuery();
        for (String str3 : map.keySet()) {
            builderBuildUpon.appendQueryParameter(str3, (String) map.get(str3));
        }
        return builderBuildUpon.build().toString();
    }

    public static JSONObject a(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("aid", str);
        jSONObject.put("os", "Android");
        jSONObject.put("os_version", String.valueOf(Build.VERSION.SDK_INT));
        jSONObject.put("sdk_version", "6.15.5");
        jSONObject.put("app_version", str2);
        return jSONObject;
    }

    public static void a(StringBuilder sb, String str, String str2) {
        if (sb == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        sb.append(sb.toString().indexOf(63) < 0 ? "?" : com.alipay.sdk.m.s.a.n);
        sb.append(str).append("=").append(Uri.encode(str2));
    }

    public static JSONObject b(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("magic_tag", "ss_app_log");
        jSONObject2.put("header", jSONObject);
        jSONObject2.put("_gen_time", System.currentTimeMillis());
        return jSONObject2;
    }

    public final HashMap<String, String> a() {
        Map<String, String> httpHeaders;
        HashMap map = new HashMap(2);
        InitConfig initConfig = this.b.getInitConfig();
        if (initConfig != null && (httpHeaders = initConfig.getHttpHeaders()) != null && !httpHeaders.isEmpty()) {
            map.putAll(httpHeaders);
        }
        return o4.a((HashMap<String, String>) map, this.b);
    }

    public final JSONObject a(String str) {
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            a(jSONObject);
            return jSONObject;
        } catch (Throwable th) {
            this.b.D.error(11, "JSON handle failed", th, new Object[0]);
            return null;
        }
    }

    public final JSONObject a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return null;
        }
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields.isEmpty()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : headerFields.keySet()) {
            if (l0.b.d(str)) {
                try {
                    jSONObject.put(str, httpURLConnection.getHeaderField(str));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONObject;
    }

    public final void a(String str, int i, byte[] bArr, String str2, long j, HttpURLConnection httpURLConnection) {
        LogUtils.sendJsonFetcher("do_request_end", new b(str, i, bArr, str2, j, httpURLConnection));
    }

    public final void a(JSONObject jSONObject) throws JSONException {
        try {
            long jOptLong = jSONObject.optLong("server_time");
            if (jOptLong > 0) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("server_time", jOptLong);
                jSONObject2.put("local_time", System.currentTimeMillis() / 1000);
                d = jSONObject2;
                LogUtils.sendJsonFetcher("server_time_sync", new a(jSONObject2));
            }
        } catch (Exception unused) {
        }
    }

    public JSONObject b(String str, JSONObject jSONObject) {
        String str2;
        this.b.D.debug(11, "Start to report oaid to uri:{} with request:{}...", str, jSONObject);
        try {
            str2 = new String(this.b.getNetClient().execute((byte) 1, this.c.a(str), jSONObject, a(), (byte) 0, true, 60000));
            try {
                this.b.D.debug(11, "reportOaid success: {}", str2);
            } catch (Exception e) {
                e = e;
                this.b.D.error(11, "reportOaid error", e, new Object[0]);
                return a(str2);
            }
        } catch (Exception e2) {
            e = e2;
            str2 = null;
        }
        return a(str2);
    }

    public JSONObject a(String str, JSONObject jSONObject) {
        String str2;
        this.b.D.debug(11, "Start to register to uri:{} with request:{}...", str, jSONObject);
        try {
            str2 = new String(this.b.getNetClient().execute((byte) 1, this.c.a(str), jSONObject, a(), (byte) 0, true, 60000));
        } catch (Throwable th) {
            th = th;
            str2 = null;
        }
        try {
            this.b.D.debug(11, "request register success: {}", str2);
        } catch (Throwable th2) {
            th = th2;
            this.b.D.error(11, "request register error", th, new Object[0]);
            return a(str2);
        }
        return a(str2);
    }

    public final String a(JSONObject jSONObject, String str, Map<String, String> map, int i) throws Throwable {
        GZIPInputStream gZIPInputStream;
        ByteArrayInputStream byteArrayInputStream;
        byte[] byteArray;
        String strOptString = jSONObject.optString("key");
        String strOptString2 = jSONObject.optString("iv");
        boolean z = true;
        byte b2 = (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) ? (byte) 0 : (byte) 1;
        byte[] bArrExecute = this.b.getNetClient().execute((byte) 1, str, jSONObject, map, b2, true, i);
        if (b2 == 0) {
            return new String(bArrExecute);
        }
        String str2 = null;
        str2 = null;
        ByteArrayInputStream byteArrayInputStream2 = null;
        if (bArrExecute != null) {
            byte[] bArrA = o4.a(bArrExecute, strOptString, strOptString2);
            if (bArrA != null) {
                if (bArrA.length <= 0) {
                    byteArray = null;
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byteArrayInputStream = new ByteArrayInputStream(bArrA);
                        try {
                            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i2 = gZIPInputStream.read(bArr);
                                    if (i2 < 0) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr, 0, i2);
                                }
                            } catch (IOException unused) {
                            } catch (Throwable th) {
                                th = th;
                                byteArrayInputStream2 = byteArrayInputStream;
                                l0.b.a((Closeable) gZIPInputStream);
                                l0.b.a((Closeable) byteArrayInputStream2);
                                throw th;
                            }
                        } catch (IOException unused2) {
                            gZIPInputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                            gZIPInputStream = null;
                        }
                    } catch (IOException unused3) {
                        gZIPInputStream = null;
                        byteArrayInputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        gZIPInputStream = null;
                    }
                    l0.b.a((Closeable) gZIPInputStream);
                    l0.b.a((Closeable) byteArrayInputStream);
                    byteArray = byteArrayOutputStream.toByteArray();
                }
                if (byteArray != null) {
                    str2 = new String(byteArray);
                }
            } else {
                str2 = new String(bArrExecute);
            }
            z = false;
        }
        return z ? new String(this.b.getNetClient().execute((byte) 1, str, jSONObject, map, (byte) 0, true, 60000)) : str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int a(java.lang.String[] r22, org.json.JSONObject r23, com.bytedance.bdtracker.q1 r24) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.o3.a(java.lang.String[], org.json.JSONObject, com.bytedance.bdtracker.q1):int");
    }

    public boolean a(JSONObject jSONObject, String str) {
        this.b.D.debug(11, "Start to send event:{} with cookie:{} to et...", jSONObject, str);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("header", this.b.getHeader());
            if (jSONObject != null) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                jSONObject2.put("event_v3", jSONArray);
            }
        } catch (Throwable th) {
            this.b.D.error(11, "JSON handle failed", th, new Object[0]);
        }
        HashMap<String, String> mapA = a();
        mapA.put(com.sigmob.sdk.base.e.b, str);
        try {
            String str2 = new String(this.b.getNetClient().execute((byte) 1, this.a + "/simulator/mobile/log", jSONObject2, mapA, (byte) 0, true, 60000));
            if (!new JSONObject(str2).getJSONObject("data").optBoolean("keep", false)) {
                this.b.setRangersEventVerifyEnable(false, str);
            }
            this.b.D.debug(11, "Send event to et with response:{}", str2);
            return true;
        } catch (Throwable th2) {
            this.b.D.error(11, "Post to event verify failed", th2, new Object[0]);
            return false;
        }
    }
}

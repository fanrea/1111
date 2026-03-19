package ca.da.ca.ba;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.apm.applog.AppLog;
import com.baidu.mobads.upgrade.remote.gray.c;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.sigmob.sdk.base.e;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Api.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a {
    public static JSONObject b;
    public static final String[] a = {"GET", "POST"};
    public static final String[] c = {"aid", "app_version", "tt_data", c.l};
    public static final String[] d = {"aid", "version_code", "ab_version", Config.IID, "device_platform"};

    static {
        new String[]{"tt_data", "device_platform"};
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str) || !AppLog.getEncryptAndCompress()) {
            return str;
        }
        Uri uri = Uri.parse(str);
        String query = uri.getQuery();
        ArrayList<Pair> arrayList = new ArrayList();
        for (String str2 : c) {
            String queryParameter = uri.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                arrayList.add(new Pair(str2, queryParameter));
            }
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.clearQuery();
        for (Pair pair : arrayList) {
            builderBuildUpon.appendQueryParameter((String) pair.first, (String) pair.second);
        }
        builderBuildUpon.appendQueryParameter("tt_info", new String(Base64.encode(ca.da.ca.ha.b.a(query), 8)));
        return builderBuildUpon.build().toString();
    }

    public static boolean a(int i) {
        return i >= 500 && i < 600;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ca A[Catch: all -> 0x01cd, TRY_ENTER, TryCatch #3 {all -> 0x01cd, blocks: (B:74:0x01b6, B:78:0x01ca, B:79:0x01cc), top: B:89:0x01b6 }] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(int r7, java.lang.String r8, java.util.HashMap<java.lang.String, java.lang.String> r9, byte[] r10) throws ca.da.ca.ga.b, java.io.IOException {
        /*
            Method dump skipped, instructions count: 475
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ca.da.ca.ba.a.a(int, java.lang.String, java.util.HashMap, byte[]):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(java.lang.String[] r11, byte[] r12, ca.da.ca.fa.g r13) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ca.da.ca.ba.a.a(java.lang.String[], byte[], ca.da.ca.fa.g):int");
    }

    public static void a(JSONObject jSONObject) throws JSONException {
        try {
            long jOptLong = jSONObject.optLong("server_time");
            if (jOptLong > 0) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("server_time", jOptLong);
                jSONObject2.put("local_time", System.currentTimeMillis() / 1000);
                b = jSONObject2;
            }
        } catch (Exception unused) {
        }
    }

    public static HashMap<String, String> a() {
        HashMap<String, String> map = new HashMap<>(4);
        if (AppLog.getEncryptAndCompress()) {
            map.put("Content-Type", "application/octet-stream;tt-data=a");
            map.put("Content-Encoding", "gzip");
        } else {
            map.put("Content-Type", MediaTypeUtils.APPLICATION_JSON);
        }
        return map;
    }

    public static boolean a(ca.da.ca.da.b bVar, JSONObject jSONObject, String str) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("header", bVar.f.d());
            JSONArray jSONArray = new JSONArray();
            if (jSONObject != null) {
                jSONArray.put(jSONObject);
            }
            jSONObject2.put("event_v3", jSONArray);
        } catch (JSONException unused) {
        }
        HashMap<String, String> mapA = a();
        mapA.put(e.b, str);
        try {
            if (!new JSONObject(a(1, "https://databyterangers.com.cn/simulator/mobile/log", mapA, ca.da.ca.ha.b.a(jSONObject2.toString()))).getJSONObject("data").getBoolean("keep")) {
                AppLog.getInstance(bVar.f.a()).setRangersEventVerifyEnable(false, str);
            }
            return true;
        } catch (Exception unused2) {
            return false;
        }
    }
}

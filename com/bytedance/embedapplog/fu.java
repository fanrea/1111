package com.bytedance.embedapplog;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.baidu.mobads.container.util.cm;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class fu {
    public static JSONObject d;
    private static final String[] c = {"GET", "POST"};
    private static final String[] u = {"aid", "app_version", "tt_data"};
    static final String[] hc = {"aid", "version_code", "ab_client", "ab_version", "ab_feature", "ab_group", Config.IID, "device_platform"};
    public static final String[] b = {"tt_data", "device_platform"};

    public static boolean d(int i) {
        return i >= 500 && i < 600;
    }

    private static String d(String str) {
        if (TextUtils.isEmpty(str) || !d.h()) {
            return str;
        }
        Uri uri = Uri.parse(str);
        String query = uri.getQuery();
        ArrayList<Pair> arrayList = new ArrayList();
        for (String str2 : u) {
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
        builderBuildUpon.appendQueryParameter("tt_info", new String(Base64.encode(t.d(query), 8)));
        return builderBuildUpon.build().toString();
    }

    public static String d(String str, String[] strArr) {
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

    /* JADX WARN: Removed duplicated region for block: B:101:0x01c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String d(int r7, java.lang.String r8, java.util.HashMap<java.lang.String, java.lang.String> r9, byte[] r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 489
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.fu.d(int, java.lang.String, java.util.HashMap, byte[]):java.lang.String");
    }

    public static JSONObject d(String str, JSONObject jSONObject) {
        HashMap map = new HashMap(2);
        if (d.h()) {
            map.put("Content-Type", "application/octet-stream;tt-data=a");
        } else {
            map.put("Content-Type", MediaTypeUtils.APPLICATION_JSON);
        }
        String strD = d(1, d(str), map, t.d(jSONObject.toString()));
        if (strD == null) {
            return null;
        }
        try {
            return new JSONObject(strD);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int d(java.lang.String[] r8, byte[] r9, com.bytedance.embedapplog.fs r10) throws org.json.JSONException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.fu.d(java.lang.String[], byte[], com.bytedance.embedapplog.fs):int");
    }

    public static JSONObject hc(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        HashMap map = new HashMap(2);
        if (d.h()) {
            map.put("Content-Type", "application/octet-stream;tt-data=a");
        } else {
            map.put("Content-Type", MediaTypeUtils.APPLICATION_JSON);
        }
        String strD = d(1, str, map, t.d(jSONObject.toString()));
        if (strD != null) {
            try {
                jSONObject2 = new JSONObject(strD);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
        } else {
            jSONObject2 = null;
        }
        if (jSONObject2 != null && "ss_app_log".equals(jSONObject2.optString("magic_tag", ""))) {
            return jSONObject2.optJSONObject("config");
        }
        return null;
    }

    public static JSONObject b(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        String strD = d(1, str, null, t.d(jSONObject.toString()));
        if (strD != null) {
            try {
                jSONObject2 = new JSONObject(strD);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
        } else {
            jSONObject2 = null;
        }
        if (jSONObject2 != null && "success".equals(jSONObject2.optString(cm.V, ""))) {
            return jSONObject2.optJSONObject("data");
        }
        return null;
    }
}

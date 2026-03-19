package com.qq.e.comm.plugin;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class jn {
    private JSONObject a;

    public jn() {
        this.a = new JSONObject();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0021 A[Catch: JSONException -> 0x0029, TryCatch #0 {JSONException -> 0x0029, blocks: (B:4:0x0005, B:6:0x000f, B:8:0x001b, B:10:0x0026, B:9:0x0021), top: B:15:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public jn(java.lang.String r3) {
        /*
            r2 = this;
            r2.<init>()
            if (r3 == 0) goto L21
            java.lang.String r0 = r3.trim()     // Catch: org.json.JSONException -> L29
            boolean r0 = r0.isEmpty()     // Catch: org.json.JSONException -> L29
            if (r0 != 0) goto L21
            java.lang.String r0 = r3.toLowerCase()     // Catch: org.json.JSONException -> L29
            java.lang.String r1 = "null"
            boolean r0 = r0.equals(r1)     // Catch: org.json.JSONException -> L29
            if (r0 != 0) goto L21
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L29
            r0.<init>(r3)     // Catch: org.json.JSONException -> L29
            goto L26
        L21:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L29
            r0.<init>()     // Catch: org.json.JSONException -> L29
        L26:
            r2.a = r0     // Catch: org.json.JSONException -> L29
            goto L34
        L29:
            r3 = move-exception
            r3.getMessage()
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            r2.a = r3
        L34:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.jn.<init>(java.lang.String):void");
    }

    public jn a(String str, double d) throws JSONException {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.a.put(str, d);
            }
        } catch (JSONException e) {
            e.getMessage();
        }
        return this;
    }

    public jn(JSONObject jSONObject) {
        if (jSONObject == null) {
            this.a = new JSONObject();
        } else {
            this.a = jSONObject;
        }
    }

    public jn a(String str, int i) throws JSONException {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.a.put(str, i);
            }
        } catch (JSONException e) {
            e.getMessage();
        }
        return this;
    }

    public String toString() {
        return this.a.toString();
    }

    public jn a(String str, long j) throws JSONException {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.a.put(str, j);
            }
        } catch (JSONException e) {
            e.getMessage();
        }
        return this;
    }

    public jn a(String str, Object obj) throws JSONException {
        try {
            if (!TextUtils.isEmpty(str) && obj != null) {
                this.a.put(str, obj);
            }
        } catch (JSONException e) {
            e.getMessage();
        }
        return this;
    }

    public jn a(String str, String str2) throws JSONException {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                this.a.put(str, str2);
            }
        } catch (JSONException e) {
            e.getMessage();
        }
        return this;
    }

    public jn a(String str, boolean z) throws JSONException {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.a.put(str, z);
            }
        } catch (JSONException e) {
            e.getMessage();
        }
        return this;
    }

    public JSONObject a() {
        return this.a;
    }

    public static jn a(String str) {
        return new jn(str);
    }
}

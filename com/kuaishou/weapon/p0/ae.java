package com.kuaishou.weapon.p0;

import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ae {
    public boolean a(String str) {
        return new File(File.separator + "proc" + File.separator + str).canWrite();
    }

    public boolean b(String str) {
        return a(str, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(java.lang.String r4, boolean r5) throws java.io.IOException {
        /*
            r3 = this;
            java.lang.String r0 = ""
            if (r5 == 0) goto L30
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L54
            r0.<init>()     // Catch: java.lang.Throwable -> L54
            java.lang.StringBuilder r4 = r0.append(r4)     // Catch: java.lang.Throwable -> L54
            java.lang.String r0 = "/-"
            java.lang.StringBuilder r4 = r4.append(r0)     // Catch: java.lang.Throwable -> L54
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L54
            java.lang.StringBuilder r4 = r4.append(r0)     // Catch: java.lang.Throwable -> L54
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L54
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L54
            r0.<init>()     // Catch: java.lang.Throwable -> L54
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L54
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L54
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L54
        L30:
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L54
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L54
            r1.exists()     // Catch: java.lang.Throwable -> L54
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L54
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L54
            byte[] r0 = r0.getBytes()     // Catch: java.lang.Throwable -> L55
            r4.write(r0)     // Catch: java.lang.Throwable -> L55
            r4.flush()     // Catch: java.lang.Throwable -> L55
            r4.close()     // Catch: java.lang.Throwable -> L55
            if (r5 == 0) goto L4f
            r1.delete()     // Catch: java.lang.Throwable -> L55
        L4f:
            r4.close()     // Catch: java.lang.Exception -> L52
        L52:
            r4 = 1
            return r4
        L54:
            r4 = 0
        L55:
            if (r4 == 0) goto L5a
            r4.close()     // Catch: java.lang.Exception -> L5a
        L5a:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.ae.a(java.lang.String, boolean):boolean");
    }

    public JSONObject a() throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            int i = 1;
            jSONObject.put("0", a("/data", true) ? 1 : 0);
            jSONObject.put("1", a("/system/bin", true) ? 1 : 0);
            if (!a("/system/lib", true)) {
                i = 0;
            }
            jSONObject.put("2", i);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject b() throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            int i = 1;
            jSONObject.put("0", a("/sys", true) ? 1 : 0);
            jSONObject.put("1", a("/sbin", true) ? 1 : 0);
            jSONObject.put("2", a("/etc", true) ? 1 : 0);
            if (!a("/dev", true)) {
                i = 0;
            }
            jSONObject.put("3", i);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}

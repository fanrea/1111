package com.qq.e.comm.plugin;

import android.content.Context;
import android.view.View;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class z2 {
    /* JADX WARN: Removed duplicated region for block: B:22:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void a(android.content.Context r7, java.lang.String r8) throws org.json.JSONException {
        /*
            java.lang.String r0 = "cas"
            java.lang.String r1 = "as"
            java.lang.String r2 = ""
            if (r7 == 0) goto L7c
            boolean r3 = android.text.TextUtils.isEmpty(r8)
            if (r3 == 0) goto L10
            goto L7c
        L10:
            r3 = 0
            r4 = 0
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Exception -> L46
            r5.<init>(r8)     // Catch: java.lang.Exception -> L46
            java.lang.String r8 = r5.optString(r1)     // Catch: java.lang.Exception -> L46
            java.lang.String r5 = r5.optString(r0)     // Catch: java.lang.Exception -> L41
            boolean r6 = r8.equals(r5)     // Catch: java.lang.Exception -> L3e
            if (r6 == 0) goto L26
            return
        L26:
            android.content.Context r6 = r7.getApplicationContext()     // Catch: java.lang.Exception -> L3e
            android.content.pm.PackageManager r6 = r6.getPackageManager()     // Catch: java.lang.Exception -> L3e
            java.lang.String r7 = r7.getPackageName()     // Catch: java.lang.Exception -> L3e
            android.content.pm.ApplicationInfo r7 = r6.getApplicationInfo(r7, r4)     // Catch: java.lang.Exception -> L3e
            java.lang.String r2 = r7.sourceDir     // Catch: java.lang.Exception -> L3e
            java.io.File r7 = new java.io.File     // Catch: java.lang.Exception -> L3e
            r7.<init>(r2)     // Catch: java.lang.Exception -> L3e
            goto L4c
        L3e:
            r7 = r2
            goto L44
        L41:
            r7 = r2
            r5 = r7
        L44:
            r2 = r8
            goto L49
        L46:
            r7 = r2
            r5 = r7
        L49:
            r8 = r2
            r2 = r7
            r7 = r3
        L4c:
            com.qq.e.comm.plugin.ja r6 = new com.qq.e.comm.plugin.ja
            r6.<init>()
            r6.a(r1, r8)
            r6.a(r0, r5)
            java.lang.String r8 = "dir"
            r6.a(r8, r2)
            if (r7 != 0) goto L61
            java.lang.String r7 = "null"
            goto L69
        L61:
            boolean r7 = r7.isDirectory()
            java.lang.String r7 = java.lang.String.valueOf(r7)
        L69:
            java.lang.String r8 = "isDir"
            r6.a(r8, r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)
            r0 = 11300011(0xac6cab, float:1.5834688E-38)
            com.qq.e.comm.plugin.b10.a(r0, r3, r7, r8, r6)
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.z2.a(android.content.Context, java.lang.String):void");
    }

    static void a(h4 h4Var) {
        b10.a(1130008, f5.a(h4Var));
    }

    static void a(View view, h4 h4Var) {
        Context context = view.getContext();
        if (context != null && context.hashCode() == b1.b().a()) {
            qm$h$$ExternalSyntheticBackport0.m(context);
            b10.a(9120010, f5.a(h4Var));
        }
    }

    static void a(ja jaVar) {
        b10.a(1130016, null, 0, 0, jaVar);
    }

    static void a(int i, int i2) {
        b10.a(11300010, null, Integer.valueOf(i), Integer.valueOf(i2), null);
    }
}

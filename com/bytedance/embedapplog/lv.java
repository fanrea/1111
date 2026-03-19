package com.bytedance.embedapplog;

import android.content.Context;
import android.os.SystemProperties;
import com.bytedance.embedapplog.ic;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class lv implements ic {
    private static final gv<Boolean> d = new gv<Boolean>() { // from class: com.bytedance.embedapplog.lv.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.gv
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean d(Object... objArr) {
            return Boolean.valueOf("1".equals(lv.hc(com.alipay.sdk.m.p0.c.c, "0")));
        }
    };

    lv(Context context) {
    }

    static boolean d() {
        return d.hc(new Object[0]).booleanValue();
    }

    @Override // com.bytedance.embedapplog.ic
    public boolean d(Context context) {
        return d();
    }

    @Override // com.bytedance.embedapplog.ic
    public ic.d hc(Context context) {
        ic.d dVar = new ic.d();
        dVar.hc = d(context, 0, null);
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String hc(String str, String str2) {
        try {
            return SystemProperties.get(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String d(android.content.Context r7, int r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            r0 = 0
            if (r8 == 0) goto L29
            r1 = 1
            if (r8 == r1) goto L1a
            r1 = 2
            if (r8 == r1) goto Lb
            r2 = r0
            goto L30
        Lb:
            java.lang.String r8 = java.lang.String.valueOf(r9)
            java.lang.String r9 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_"
            java.lang.String r8 = r9.concat(r8)
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L2f
        L1a:
            java.lang.String r8 = java.lang.String.valueOf(r9)
            java.lang.String r9 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_"
            java.lang.String r8 = r9.concat(r8)
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L2f
        L29:
            java.lang.String r8 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID"
            android.net.Uri r8 = android.net.Uri.parse(r8)
        L2f:
            r2 = r8
        L30:
            if (r2 == 0) goto L66
            android.content.ContentResolver r1 = r7.getContentResolver()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5a
            if (r7 == 0) goto L54
            boolean r8 = r7.moveToNext()     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L60
            if (r8 == 0) goto L54
            java.lang.String r8 = "value"
            int r8 = r7.getColumnIndex(r8)     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L60
            java.lang.String r8 = r7.getString(r8)     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> L60
            r0 = r8
            goto L54
        L52:
            r8 = move-exception
            goto L5c
        L54:
            com.bytedance.embedapplog.fv.d(r7)
            goto L66
        L58:
            r8 = move-exception
            goto L62
        L5a:
            r8 = move-exception
            r7 = r0
        L5c:
            com.bytedance.embedapplog.um.d(r8)     // Catch: java.lang.Throwable -> L60
            goto L54
        L60:
            r8 = move-exception
            r0 = r7
        L62:
            com.bytedance.embedapplog.fv.d(r0)
            throw r8
        L66:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.lv.d(android.content.Context, int, java.lang.String):java.lang.String");
    }
}

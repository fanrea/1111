package com.baidu.mobads.container.c;

import android.text.TextUtils;
import com.baidu.mobads.container.util.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c {
    public static final String a = "error_message";
    public static final String b = "error_code";
    public static final String c = "error_uniqueid";
    protected final bq d = bq.a();

    public void a(a aVar, String str) {
        this.d.c(b(aVar, str));
    }

    public void a(String str, String str2, String str3) {
        this.d.c(b(str, str2, str3));
    }

    public String b(a aVar, String str) {
        return aVar == null ? "" : b(aVar.b() + "", aVar.c(), str);
    }

    public String b(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append("ErrorCode: [");
            sb.append(str);
            sb.append("];");
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append("ErrorDesc: [");
            sb.append(str2);
            sb.append("];");
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(" Extra: [");
            sb.append(str3);
            sb.append("];");
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(java.util.Map<java.lang.String, java.lang.Object> r5) {
        /*
            r4 = this;
            java.lang.String r0 = "error_message"
            java.lang.String r1 = "msg"
            java.lang.String r2 = ""
            if (r5 == 0) goto L29
            boolean r3 = r5.containsKey(r1)     // Catch: java.lang.Exception -> L26
            if (r3 == 0) goto L19
            java.lang.Object r5 = r5.get(r1)     // Catch: java.lang.Exception -> L26
            com.baidu.mobads.container.c.a r5 = (com.baidu.mobads.container.c.a) r5     // Catch: java.lang.Exception -> L26
            java.lang.String r5 = r4.b(r5, r2)     // Catch: java.lang.Exception -> L26
            goto L2a
        L19:
            boolean r1 = r5.containsKey(r0)     // Catch: java.lang.Exception -> L26
            if (r1 == 0) goto L29
            java.lang.Object r5 = r5.get(r0)     // Catch: java.lang.Exception -> L26
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> L26
            goto L2a
        L26:
            r5 = move-exception
            r5 = r2
            goto L2b
        L29:
            r5 = r2
        L2a:
        L2b:
            if (r5 != 0) goto L2e
            goto L2f
        L2e:
            r2 = r5
        L2f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.container.c.c.a(java.util.Map):java.lang.String");
    }
}

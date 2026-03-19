package com.baidu.mobads.container.util.f;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class t {
    /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a() {
        /*
            r0 = 0
            com.baidu.mobads.container.util.DeviceUtils r1 = com.baidu.mobads.container.util.DeviceUtils.getInstance()     // Catch: java.lang.Throwable -> L41
            java.lang.String r1 = r1.b()     // Catch: java.lang.Throwable -> L41
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L41
            if (r2 != 0) goto L2d
            java.lang.String r2 = "oppo"
            boolean r2 = r1.equalsIgnoreCase(r2)     // Catch: java.lang.Throwable -> L41
            if (r2 != 0) goto L2b
            java.lang.String r2 = "realme"
            boolean r2 = r1.equalsIgnoreCase(r2)     // Catch: java.lang.Throwable -> L41
            if (r2 != 0) goto L2b
            java.lang.String r2 = "oneplus"
            boolean r1 = r1.equalsIgnoreCase(r2)     // Catch: java.lang.Throwable -> L41
            if (r1 == 0) goto L29
            goto L2b
        L29:
            r1 = 0
            goto L2e
        L2b:
            r1 = 1
            goto L2e
        L2d:
            r1 = 0
        L2e:
            r2 = 0
            com.baidu.mobads.container.util.x r2 = com.baidu.mobads.container.util.x.a(r2)     // Catch: java.lang.Throwable -> L3e
            int r2 = r2.a()     // Catch: java.lang.Throwable -> L3e
            r3 = 23
            if (r2 >= r3) goto L3c
            goto L3d
        L3c:
            r0 = r1
        L3d:
            goto L42
        L3e:
            r0 = move-exception
            r0 = r1
            goto L42
        L41:
            r1 = move-exception
        L42:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.container.util.f.t.a():boolean");
    }

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        z.a(context, "oppo-start", "");
        try {
            com.baidu.mobads.container.d.b.a().a(new v(context, new u(context)));
        } catch (Throwable th) {
            z.a(context, "oppo-error" + th.getMessage(), "");
        }
    }
}

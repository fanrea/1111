package com.bytedance.sdk.component.tt.c;

import android.content.Context;
import com.bytedance.sdk.component.tt.b.h;
import java.util.LinkedHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    public static void d(Context context, int i, String str, int i2) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (i == 1) {
                linkedHashMap.put(d(i2), str);
            }
            b.hc("MultiProcessFileUtils", "saveData = ".concat(String.valueOf(str)));
            if (h.d().d(i2).c() != null) {
                h.d().d(i2).c().d(context, linkedHashMap);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String d(android.content.Context r2, int r3, int r4) {
        /*
            java.lang.String r0 = ""
            r1 = 1
            if (r3 == r1) goto L6
            goto L29
        L6:
            com.bytedance.sdk.component.tt.b.h r3 = com.bytedance.sdk.component.tt.b.h.d()     // Catch: java.lang.Exception -> L29
            com.bytedance.sdk.component.tt.b.u r3 = r3.d(r4)     // Catch: java.lang.Exception -> L29
            com.bytedance.sdk.component.tt.b.hc r3 = r3.c()     // Catch: java.lang.Exception -> L29
            if (r3 == 0) goto L29
            com.bytedance.sdk.component.tt.b.h r3 = com.bytedance.sdk.component.tt.b.h.d()     // Catch: java.lang.Exception -> L29
            com.bytedance.sdk.component.tt.b.u r3 = r3.d(r4)     // Catch: java.lang.Exception -> L29
            com.bytedance.sdk.component.tt.b.hc r3 = r3.c()     // Catch: java.lang.Exception -> L29
            java.lang.String r4 = d(r4)     // Catch: java.lang.Exception -> L29
            java.lang.String r2 = r3.d(r2, r4, r0)     // Catch: java.lang.Exception -> L29
            goto L2a
        L29:
            r2 = r0
        L2a:
            boolean r3 = r2 instanceof java.lang.String
            if (r3 == 0) goto L32
            java.lang.String r0 = java.lang.String.valueOf(r2)
        L32:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.tt.c.c.d(android.content.Context, int, int):java.lang.String");
    }

    private static String d(int i) {
        return "tnc_config".concat(String.valueOf(i));
    }
}

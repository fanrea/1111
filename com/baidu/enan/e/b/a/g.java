package com.baidu.enan.e.b.a;

import android.os.Build;
import io.netty.util.internal.StringUtil;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class g {
    public static String a() {
        try {
            String[] strArr = Build.VERSION.SDK_INT >= 21 ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2};
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {
                sb.append(str);
                sb.append(StringUtil.COMMA);
            }
            String string = sb.toString();
            return string.substring(0, string.length() - 1);
        } catch (Throwable th) {
            com.baidu.enan.f.b.a(th);
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0057, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0058, code lost:
    
        com.baidu.enan.f.b.a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005b, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b() {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 22
            if (r0 <= r1) goto Lb
            boolean r0 = android.os.Process.is64Bit()
            return r0
        Lb:
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L83
            r1.<init>()     // Catch: java.lang.Throwable -> L83
            java.lang.String r2 = "/proc/"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L83
            int r2 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L83
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L83
            java.lang.String r2 = "/maps"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L83
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L83
            java.lang.String r2 = "/system/lib64/libc.so"
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L83
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L83
            boolean r1 = r3.exists()     // Catch: java.lang.Throwable -> L83
            if (r1 == 0) goto L82
            boolean r1 = r3.isDirectory()     // Catch: java.lang.Throwable -> L83
            if (r1 == 0) goto L3d
            goto L82
        L3d:
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L65
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L65
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L65
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L65
        L47:
            java.lang.String r3 = r1.readLine()     // Catch: java.lang.Throwable -> L63
            if (r3 == 0) goto L5d
            boolean r3 = r3.contains(r2)     // Catch: java.lang.Throwable -> L63
            if (r3 == 0) goto L47
            r1.close()     // Catch: java.io.IOException -> L57 java.lang.Throwable -> L83
            goto L5b
        L57:
            r1 = move-exception
            com.baidu.enan.f.b.a(r1)     // Catch: java.lang.Throwable -> L83
        L5b:
            r0 = 1
            return r0
        L5d:
            r1.close()     // Catch: java.io.IOException -> L61 java.lang.Throwable -> L83
            goto L87
        L61:
            r1 = move-exception
            goto L72
        L63:
            r2 = move-exception
            goto L68
        L65:
            r1 = move-exception
            r2 = r1
            r1 = 0
        L68:
            com.baidu.enan.f.b.a(r2)     // Catch: java.lang.Throwable -> L76
            if (r1 == 0) goto L87
            r1.close()     // Catch: java.io.IOException -> L71 java.lang.Throwable -> L83
            goto L87
        L71:
            r1 = move-exception
        L72:
            com.baidu.enan.f.b.a(r1)     // Catch: java.lang.Throwable -> L83
            goto L87
        L76:
            r2 = move-exception
            if (r1 == 0) goto L81
            r1.close()     // Catch: java.io.IOException -> L7d java.lang.Throwable -> L83
            goto L81
        L7d:
            r1 = move-exception
            com.baidu.enan.f.b.a(r1)     // Catch: java.lang.Throwable -> L83
        L81:
            throw r2     // Catch: java.lang.Throwable -> L83
        L82:
            return r0
        L83:
            r1 = move-exception
            com.baidu.enan.f.b.a(r1)
        L87:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.enan.e.b.a.g.b():boolean");
    }
}

package com.kuaishou.weapon.p0;

import java.io.BufferedInputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class aa {
    private static volatile aa a;

    private aa() {
    }

    public static synchronized aa a() {
        if (a == null) {
            synchronized (aa.class) {
                if (a == null) {
                    a = new aa();
                }
            }
        }
        return a;
    }

    public String a(String str) {
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
            if (objInvoke != null) {
                return (String) objInvoke;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String b(java.lang.String r6) throws java.lang.Throwable {
        /*
            r5 = this;
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L62
            java.lang.String r2 = "sh"
            java.lang.Process r1 = r1.exec(r2)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L62
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
            java.io.OutputStream r3 = r1.getOutputStream()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L48
            java.io.InputStream r4 = r1.getInputStream()     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L48
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L48
            byte[] r6 = r6.getBytes()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L65
            r2.write(r6)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L65
            r6 = 10
            r2.write(r6)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L65
            r2.flush()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L65
            r2.close()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L65
            r1.waitFor()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L65
            java.lang.String r6 = a(r3)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L65
            r2.close()     // Catch: java.io.IOException -> L39
        L39:
            r3.close()     // Catch: java.io.IOException -> L3c
        L3c:
            if (r1 == 0) goto L41
            r1.destroy()
        L41:
            return r6
        L42:
            r6 = move-exception
            goto L46
        L44:
            r6 = move-exception
            r3 = r0
        L46:
            r0 = r2
            goto L52
        L48:
            r3 = r0
            goto L65
        L4a:
            r6 = move-exception
            r3 = r0
            goto L52
        L4d:
            r2 = r0
            goto L64
        L4f:
            r6 = move-exception
            r1 = r0
            r3 = r1
        L52:
            if (r0 == 0) goto L57
            r0.close()     // Catch: java.io.IOException -> L57
        L57:
            if (r3 == 0) goto L5c
            r3.close()     // Catch: java.io.IOException -> L5c
        L5c:
            if (r1 == 0) goto L61
            r1.destroy()
        L61:
            throw r6
        L62:
            r1 = r0
            r2 = r1
        L64:
            r3 = r2
        L65:
            if (r2 == 0) goto L6a
            r2.close()     // Catch: java.io.IOException -> L6a
        L6a:
            if (r3 == 0) goto L6f
            r3.close()     // Catch: java.io.IOException -> L6f
        L6f:
            if (r1 == 0) goto L74
            r1.destroy()
        L74:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.aa.b(java.lang.String):java.lang.String");
    }

    private static String a(BufferedInputStream bufferedInputStream) {
        int i;
        if (bufferedInputStream == null) {
            return "";
        }
        byte[] bArr = new byte[512];
        StringBuilder sb = new StringBuilder();
        do {
            try {
                i = bufferedInputStream.read(bArr);
                if (i > 0) {
                    sb.append(new String(bArr, 0, i));
                }
            } catch (Exception unused) {
            }
        } while (i >= 512);
        return sb.toString();
    }
}

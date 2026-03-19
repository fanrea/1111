package lkxssdk.l;

import java.io.BufferedInputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class c {

    public static class a {
        public static final c a = new c();
    }

    public static String a(BufferedInputStream bufferedInputStream) {
        int i;
        byte[] bArr = new byte[512];
        StringBuilder sb = new StringBuilder();
        do {
            try {
                i = bufferedInputStream.read(bArr);
                if (i > 0) {
                    sb.append(new String(bArr, 0, i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (i >= 512);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(java.lang.String r6) throws java.lang.Throwable {
        /*
            r5 = this;
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L71
            java.lang.String r2 = "sh"
            java.lang.Process r1 = r1.exec(r2)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L71
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L72
            java.io.OutputStream r3 = r1.getOutputStream()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L72
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L72
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L50
            java.io.InputStream r4 = r1.getInputStream()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L50
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L50
            byte[] r6 = r6.getBytes()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L74
            r2.write(r6)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L74
            r6 = 10
            r2.write(r6)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L74
            r2.flush()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L74
            r2.close()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L74
            r1.waitFor()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L74
            java.lang.String r6 = a(r3)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L74
            r2.close()     // Catch: java.io.IOException -> L3a
            goto L3e
        L3a:
            r0 = move-exception
            r0.printStackTrace()
        L3e:
            r3.close()     // Catch: java.io.IOException -> L42
            goto L46
        L42:
            r0 = move-exception
            r0.printStackTrace()
        L46:
            r1.destroy()
            return r6
        L4a:
            r6 = move-exception
            goto L4e
        L4c:
            r6 = move-exception
            r3 = r0
        L4e:
            r0 = r2
            goto L57
        L50:
            r3 = r0
            goto L74
        L52:
            r6 = move-exception
            goto L56
        L54:
            r6 = move-exception
            r1 = r0
        L56:
            r3 = r0
        L57:
            if (r0 == 0) goto L61
            r0.close()     // Catch: java.io.IOException -> L5d
            goto L61
        L5d:
            r0 = move-exception
            r0.printStackTrace()
        L61:
            if (r3 == 0) goto L6b
            r3.close()     // Catch: java.io.IOException -> L67
            goto L6b
        L67:
            r0 = move-exception
            r0.printStackTrace()
        L6b:
            if (r1 == 0) goto L70
            r1.destroy()
        L70:
            throw r6
        L71:
            r1 = r0
        L72:
            r2 = r0
            r3 = r2
        L74:
            if (r2 == 0) goto L7e
            r2.close()     // Catch: java.io.IOException -> L7a
            goto L7e
        L7a:
            r6 = move-exception
            r6.printStackTrace()
        L7e:
            if (r3 == 0) goto L88
            r3.close()     // Catch: java.io.IOException -> L84
            goto L88
        L84:
            r6 = move-exception
            r6.printStackTrace()
        L88:
            if (r1 == 0) goto L8d
            r1.destroy()
        L8d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: lkxssdk.l.c.a(java.lang.String):java.lang.String");
    }
}

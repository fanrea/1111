package com.baidu.enan.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b {
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a A[Catch: Exception -> 0x0086, TRY_LEAVE, TryCatch #8 {Exception -> 0x0086, blocks: (B:44:0x0082, B:48:0x008a), top: B:80:0x0082 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a3 A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[DONT_GENERATE, FINALLY_INSNS, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.lang.String r6, java.lang.String r7, java.io.File r8) throws java.io.IOException {
        /*
            r0 = 0
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch: java.lang.Throwable -> L79
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L79
            java.net.URLConnection r6 = r2.openConnection()     // Catch: java.lang.Throwable -> L79
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch: java.lang.Throwable -> L79
            r2 = 15000(0x3a98, float:2.102E-41)
            r6.setConnectTimeout(r2)     // Catch: java.lang.Throwable -> L77
            r6.setReadTimeout(r2)     // Catch: java.lang.Throwable -> L77
            r6.connect()     // Catch: java.lang.Throwable -> L77
            int r2 = r6.getResponseCode()     // Catch: java.lang.Throwable -> L77
            r3 = 200(0xc8, float:2.8E-43)
            if (r2 == r3) goto L26
            if (r6 == 0) goto L25
            r6.disconnect()
        L25:
            return r0
        L26:
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L77
            java.io.InputStream r3 = r6.getInputStream()     // Catch: java.lang.Throwable -> L77
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L77
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L75
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L75
            r4.<init>(r8)     // Catch: java.lang.Throwable -> L75
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L75
            r1 = 4096(0x1000, float:5.74E-42)
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> L72
        L3d:
            int r4 = r2.read(r1)     // Catch: java.lang.Throwable -> L72
            r5 = -1
            if (r4 == r5) goto L48
            r3.write(r1, r0, r4)     // Catch: java.lang.Throwable -> L72
            goto L3d
        L48:
            r3.flush()     // Catch: java.lang.Throwable -> L72
            java.lang.String r8 = com.baidu.enan.b.c.a(r8)     // Catch: java.lang.Throwable -> L72
            boolean r7 = r7.equals(r8)     // Catch: java.lang.Throwable -> L72
            if (r7 == 0) goto L64
            r3.close()     // Catch: java.lang.Exception -> L5c
            r2.close()     // Catch: java.lang.Exception -> L5c
            goto L5d
        L5c:
            r7 = move-exception
        L5d:
            if (r6 == 0) goto L62
            r6.disconnect()
        L62:
            r6 = 1
            return r6
        L64:
            r3.close()     // Catch: java.lang.Exception -> L6b
            r2.close()     // Catch: java.lang.Exception -> L6b
            goto L6c
        L6b:
            r7 = move-exception
        L6c:
            if (r6 == 0) goto L71
            r6.disconnect()
        L71:
            return r0
        L72:
            r7 = move-exception
            r1 = r3
            goto L7d
        L75:
            r7 = move-exception
            goto L7d
        L77:
            r7 = move-exception
            goto L7c
        L79:
            r6 = move-exception
            r7 = r6
            r6 = r1
        L7c:
            r2 = r1
        L7d:
            com.baidu.enan.f.a.a(r7)     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L88
            r1.close()     // Catch: java.lang.Exception -> L86
            goto L88
        L86:
            r7 = move-exception
            goto L8d
        L88:
            if (r2 == 0) goto L8d
            r2.close()     // Catch: java.lang.Exception -> L86
        L8d:
            if (r6 == 0) goto L92
            r6.disconnect()
        L92:
            return r0
        L93:
            r7 = move-exception
            if (r1 == 0) goto L9c
            r1.close()     // Catch: java.lang.Exception -> L9a
            goto L9c
        L9a:
            r8 = move-exception
            goto La1
        L9c:
            if (r2 == 0) goto La1
            r2.close()     // Catch: java.lang.Exception -> L9a
        La1:
            if (r6 == 0) goto La6
            r6.disconnect()
        La6:
            goto La8
        La7:
            throw r7
        La8:
            goto La7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.enan.a.b.a(java.lang.String, java.lang.String, java.io.File):boolean");
    }
}

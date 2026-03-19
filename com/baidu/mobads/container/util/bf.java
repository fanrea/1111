package com.baidu.mobads.container.util;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class bf {
    private static final int a = 5000;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008d A[Catch: all -> 0x0089, TryCatch #2 {all -> 0x0089, blocks: (B:35:0x0085, B:39:0x008d, B:41:0x0092), top: B:50:0x0085 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0092 A[Catch: all -> 0x0089, TRY_LEAVE, TryCatch #2 {all -> 0x0089, blocks: (B:35:0x0085, B:39:0x008d, B:41:0x0092), top: B:50:0x0085 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r6) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L7f
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L7f
            java.net.URLConnection r6 = r1.openConnection()     // Catch: java.lang.Throwable -> L7f
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch: java.lang.Throwable -> L7f
            r1 = 5000(0x1388, float:7.006E-42)
            r6.setReadTimeout(r1)     // Catch: java.lang.Throwable -> L7c
            r6.setConnectTimeout(r1)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r1 = "GET"
            r6.setRequestMethod(r1)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r1 = "accept"
        */
        //  java.lang.String r2 = "*/*"
        /*
            r6.setRequestProperty(r1, r2)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r1 = "connection"
            java.lang.String r2 = "Keep-Alive"
            r6.setRequestProperty(r1, r2)     // Catch: java.lang.Throwable -> L7c
            int r1 = r6.getResponseCode()     // Catch: java.lang.Throwable -> L7c
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 != r2) goto L74
            java.io.InputStream r1 = r6.getInputStream()     // Catch: java.lang.Throwable -> L7c
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L71
            int r3 = r6.getContentLength()     // Catch: java.lang.Throwable -> L71
            r4 = 128(0x80, float:1.8E-43)
            int r3 = java.lang.Math.max(r3, r4)     // Catch: java.lang.Throwable -> L71
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L71
            byte[] r3 = new byte[r4]     // Catch: java.lang.Throwable -> L6f
        L49:
            int r4 = r1.read(r3)     // Catch: java.lang.Throwable -> L6f
            r5 = -1
            if (r4 == r5) goto L55
            r5 = 0
            r2.write(r3, r5, r4)     // Catch: java.lang.Throwable -> L6f
            goto L49
        L55:
            r2.flush()     // Catch: java.lang.Throwable -> L6f
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L6f
            if (r1 == 0) goto L64
            r1.close()     // Catch: java.lang.Throwable -> L62
            goto L64
        L62:
            r6 = move-exception
            goto L6e
        L64:
            r2.close()     // Catch: java.lang.Throwable -> L62
            if (r6 == 0) goto L6d
            r6.disconnect()     // Catch: java.lang.Throwable -> L62
        L6d:
        L6e:
            return r0
        L6f:
            r3 = move-exception
            goto L83
        L71:
            r2 = move-exception
            r2 = r0
            goto L83
        L74:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L7c
            java.lang.String r2 = " responseCode is not 200 ... "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L7c
            throw r1     // Catch: java.lang.Throwable -> L7c
        L7c:
            r1 = move-exception
            r1 = r0
            goto L82
        L7f:
            r6 = move-exception
            r6 = r0
            r1 = r6
        L82:
            r2 = r1
        L83:
            if (r1 == 0) goto L8b
            r1.close()     // Catch: java.lang.Throwable -> L89
            goto L8b
        L89:
            r6 = move-exception
            goto L96
        L8b:
            if (r2 == 0) goto L90
            r2.close()     // Catch: java.lang.Throwable -> L89
        L90:
            if (r6 == 0) goto L97
            r6.disconnect()     // Catch: java.lang.Throwable -> L89
            goto L97
        L96:
            goto L98
        L97:
        L98:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.container.util.bf.a(java.lang.String):java.lang.String");
    }
}

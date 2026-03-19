package com.kwad.sdk.api.loader;

import com.kwad.sdk.api.core.TLSConnectionUtils;
import java.io.Closeable;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class k {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0053  */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(java.lang.String r6, java.io.File r7) throws java.lang.Throwable {
        /*
            r0 = 0
            boolean r1 = r7.exists()     // Catch: java.lang.Throwable -> L48
            if (r1 == 0) goto La
            com.kwad.sdk.api.loader.j.j(r7)     // Catch: java.lang.Throwable -> L48
        La:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L48
            r2 = 0
            r1.<init>(r7, r2)     // Catch: java.lang.Throwable -> L48
            java.net.HttpURLConnection r6 = createUrlConnection(r6)     // Catch: java.lang.Throwable -> L44
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L3d
            java.io.InputStream r3 = r6.getInputStream()     // Catch: java.lang.Throwable -> L3d
            r7.<init>(r3)     // Catch: java.lang.Throwable -> L3d
            r0 = 10240(0x2800, float:1.4349E-41)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L38
        L21:
            int r3 = r7.read(r0)     // Catch: java.lang.Throwable -> L38
            r4 = -1
            if (r3 == r4) goto L2c
            r1.write(r0, r2, r3)     // Catch: java.lang.Throwable -> L38
            goto L21
        L2c:
            closeQuietly(r1)
            closeQuietly(r7)
            if (r6 == 0) goto L37
            r6.disconnect()
        L37:
            return
        L38:
            r0 = move-exception
            r5 = r1
            r1 = r6
            r6 = r0
            goto L42
        L3d:
            r7 = move-exception
            r5 = r1
            r1 = r6
            r6 = r7
            r7 = r0
        L42:
            r0 = r5
            goto L4b
        L44:
            r6 = move-exception
            r7 = r0
            r0 = r1
            goto L4a
        L48:
            r6 = move-exception
            r7 = r0
        L4a:
            r1 = r7
        L4b:
            closeQuietly(r0)
            closeQuietly(r7)
            if (r1 == 0) goto L56
            r1.disconnect()
        L56:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.api.loader.k.c(java.lang.String, java.io.File):void");
    }

    private static HttpURLConnection createUrlConnection(String str) throws NoSuchAlgorithmException, KeyManagementException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        TLSConnectionUtils.wrapHttpURLConnection(httpURLConnection);
        httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(120000);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty("Connection", "keep-alive");
        httpURLConnection.setRequestProperty("Charset", "UTF-8");
        return httpURLConnection;
    }

    private static void closeQuietly(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}

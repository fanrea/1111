package com.tencent.turingfd.sdk.ams.au;

import com.netease.htprotect.p010Ooo.p014o0o0.O8oO888;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Virgo {
    /* JADX WARN: Can't wrap try/catch for region: R(7:0|(2:15|2)|(2:13|3)|17|4|11|(1:(0))) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r2, java.lang.String r3) {
        /*
            android.content.pm.PackageManager r0 = r2.getPackageManager()     // Catch: java.lang.Throwable -> L42
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch: java.lang.Throwable -> L42
            r1 = 0
            android.content.pm.ApplicationInfo r2 = r2.getApplicationInfo(r3, r1)     // Catch: java.lang.Throwable -> L42
            int r2 = r2.uid     // Catch: java.lang.Throwable -> L42
            java.lang.String[] r2 = r0.getPackagesForUid(r2)     // Catch: java.lang.Throwable -> L42
            r2 = r2[r1]     // Catch: java.lang.Throwable -> L42
            r3 = 64
            android.content.pm.PackageInfo r2 = r0.getPackageInfo(r2, r3)     // Catch: java.lang.Throwable -> L42
            android.content.pm.Signature[] r2 = r2.signatures     // Catch: java.lang.Throwable -> L42
            r2 = r2[r1]     // Catch: java.lang.Throwable -> L42
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L42
            byte[] r2 = r2.toByteArray()     // Catch: java.lang.Throwable -> L42
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L42
            java.lang.String r2 = "X.509"
            java.security.cert.CertificateFactory r2 = java.security.cert.CertificateFactory.getInstance(r2)     // Catch: java.lang.Throwable -> L40
            java.security.cert.Certificate r2 = r2.generateCertificate(r3)     // Catch: java.lang.Throwable -> L40
            java.security.cert.X509Certificate r2 = (java.security.cert.X509Certificate) r2     // Catch: java.lang.Throwable -> L40
            byte[] r2 = r2.getEncoded()     // Catch: java.lang.Throwable -> L40
            java.lang.String r2 = com.tencent.turingfd.sdk.ams.au.Octans.a(r2)     // Catch: java.lang.Throwable -> L40
        L3c:
            r3.close()     // Catch: java.lang.Throwable -> L48
            goto L48
        L40:
            goto L43
        L42:
            r3 = 0
        L43:
            java.lang.String r2 = ""
            if (r3 == 0) goto L48
            goto L3c
        L48:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.Virgo.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public static List<String> a(File file) throws IOException {
        ArrayList arrayList = new ArrayList();
        JarFile jarFile = new JarFile(file);
        try {
            Certificate[] certificateArrA = a(jarFile, jarFile.getJarEntry(O8oO888.f344Ooo), new byte[8192]);
            if (certificateArrA != null) {
                for (Certificate certificate : certificateArrA) {
                    arrayList.add(Octans.a(certificate.getEncoded()));
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            jarFile.close();
            throw th;
        }
        jarFile.close();
        return arrayList;
    }

    public static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) throws Throwable {
        InputStream inputStream;
        InputStream inputStream2 = null;
        try {
            inputStream = jarFile.getInputStream(jarEntry);
            do {
                try {
                } catch (IOException unused) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } while (inputStream.read(bArr, 0, bArr.length) != -1);
            Certificate[] certificates = jarEntry != null ? jarEntry.getCertificates() : null;
            try {
                inputStream.close();
            } catch (IOException unused4) {
            }
            return certificates;
        } catch (IOException unused5) {
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}

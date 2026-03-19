package com.baidu.enan.e.b.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.provider.Settings;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c {
    public static int a(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "screen_off_timeout") / 1000;
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return -1;
        }
    }

    public static String b(Context context) {
        PackageInfo packageInfo;
        byte[] encoded;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
        }
        if (packageInfo == null) {
            return "";
        }
        Signature[] signatureArr = packageInfo.signatures;
        PublicKey publicKeyA = (signatureArr == null || signatureArr.length <= 0 || signatureArr[0] == null) ? null : a(signatureArr[0]);
        if (publicKeyA != null && (encoded = publicKeyA.getEncoded()) != null) {
            return com.baidu.enan.b.c.a(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", ""));
        }
        return "";
    }

    private static PublicKey a(Signature signature) throws IOException {
        ByteArrayInputStream byteArrayInputStream;
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            byteArrayInputStream = new ByteArrayInputStream(signature.toByteArray());
            try {
                PublicKey publicKey = certificateFactory.generateCertificate(byteArrayInputStream).getPublicKey();
                try {
                    byteArrayInputStream.close();
                } catch (IOException e) {
                }
                return publicKey;
            } catch (Throwable th) {
                th = th;
                try {
                    com.baidu.enan.f.a.a(th);
                    return null;
                } finally {
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayInputStream = null;
        }
    }
}

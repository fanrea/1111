package com.qq.e.comm.plugin;

import android.content.pm.Signature;
import com.qq.e.comm.plugin.g3;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Map;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class lh {
    private static volatile String a;

    public static String a() {
        return (String) pro.getobjresult(305, 1, new Object[0]);
    }

    private static Signature[] a(Certificate[][] certificateArr) throws CertificateEncodingException {
        Signature[] signatureArr = new Signature[certificateArr.length];
        for (int i = 0; i < certificateArr.length; i++) {
            signatureArr[i] = new Signature(certificateArr[i][0].getEncoded());
        }
        return signatureArr;
    }

    /* compiled from: A */
    static class a {
        public final X509Certificate[] a;
        public final g3.a b;
        public final byte[] c;
        public final Map<Integer, byte[]> d;
        public final int e;

        public a(X509Certificate[] x509CertificateArr, g3.a aVar, byte[] bArr, Map<Integer, byte[]> map, int i) {
            this.a = x509CertificateArr;
            this.b = aVar;
            this.c = bArr;
            this.d = map;
            this.e = i;
        }
    }
}

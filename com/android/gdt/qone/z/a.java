package com.android.gdt.qone.z;

import com.alipay.sdk.m.u.i;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class a {
    public static String a = "";
    public static Certificate[] b;

    public static synchronized void a(Certificate[] certificateArr) {
        String strSubstring;
        b = certificateArr;
        if (certificateArr == null) {
            strSubstring = "";
        } else {
            StringBuilder sb = new StringBuilder();
            for (Certificate certificate : b) {
                if (certificate instanceof X509Certificate) {
                    X509Certificate x509Certificate = (X509Certificate) certificate;
                    String name = x509Certificate.getIssuerX500Principal() != null ? x509Certificate.getIssuerX500Principal().getName() : "";
                    if (!name.isEmpty()) {
                        sb.append(name);
                        sb.append(i.b);
                    }
                }
            }
            strSubstring = sb.length() > 0 ? sb.substring(0, sb.length() - 1) : sb.toString();
        }
        a = strSubstring;
    }

    @com.android.gdt.qone.q.b
    public static synchronized String getCertificateChains() {
        return a;
    }
}

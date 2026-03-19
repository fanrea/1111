package com.bytedance.sdk.component.b.hc.d.tt;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class u implements HostnameVerifier {
    public static final u d = new u();

    private u() {
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return d(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    public boolean d(String str, X509Certificate x509Certificate) {
        if (com.bytedance.sdk.component.b.hc.d.b.b(str)) {
            return hc(str, x509Certificate);
        }
        return b(str, x509Certificate);
    }

    private boolean hc(String str, X509Certificate x509Certificate) throws CertificateParsingException {
        List<String> listD = d(x509Certificate, 7);
        int size = listD.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(listD.get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean b(String str, X509Certificate x509Certificate) throws CertificateParsingException {
        String strD;
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> listD = d(x509Certificate, 2);
        int size = listD.size();
        int i = 0;
        boolean z = false;
        while (i < size) {
            if (d(lowerCase, listD.get(i))) {
                return true;
            }
            i++;
            z = true;
        }
        if (z || (strD = new c(x509Certificate.getSubjectX500Principal()).d("cn")) == null) {
            return false;
        }
        return d(lowerCase, strD);
    }

    public static List<String> d(X509Certificate x509Certificate) throws CertificateParsingException {
        List<String> listD = d(x509Certificate, 7);
        List<String> listD2 = d(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(listD.size() + listD2.size());
        arrayList.addAll(listD);
        arrayList.addAll(listD2);
        return arrayList;
    }

    private static List<String> d(X509Certificate x509Certificate, int i) throws CertificateParsingException {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    public boolean d(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(".") && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(".") && !str2.endsWith("..")) {
            if (!str.endsWith(".")) {
                str = str + '.';
            }
            if (!str2.endsWith(".")) {
                str2 = str2 + '.';
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (!lowerCase.contains("*")) {
                return str.equals(lowerCase);
            }
            if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                return false;
            }
            String strSubstring = lowerCase.substring(1);
            if (!str.endsWith(strSubstring)) {
                return false;
            }
            int length = str.length() - strSubstring.length();
            return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
        }
        return false;
    }
}

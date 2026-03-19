package okhttp3.internal.f;

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

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class d implements HostnameVerifier {
    public static final d DP = new d();

    private d() {
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        try {
            return a(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    private boolean a(String str, X509Certificate x509Certificate) {
        if (okhttp3.internal.c.o(str)) {
            return b(str, x509Certificate);
        }
        return c(str, x509Certificate);
    }

    private static boolean b(String str, X509Certificate x509Certificate) throws CertificateParsingException {
        List<String> listA = a(x509Certificate, 7);
        int size = listA.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(listA.get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean c(String str, X509Certificate x509Certificate) throws CertificateParsingException {
        String strG;
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> listA = a(x509Certificate, 2);
        int size = listA.size();
        int i = 0;
        boolean z = false;
        while (i < size) {
            if (b(lowerCase, listA.get(i))) {
                return true;
            }
            i++;
            z = true;
        }
        if (z || (strG = new c(x509Certificate.getSubjectX500Principal()).G("cn")) == null) {
            return false;
        }
        return b(lowerCase, strG);
    }

    public static List<String> a(X509Certificate x509Certificate) throws CertificateParsingException {
        List<String> listA = a(x509Certificate, 7);
        List<String> listA2 = a(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(listA.size() + listA2.size());
        arrayList.addAll(listA);
        arrayList.addAll(listA2);
        return arrayList;
    }

    private static List<String> a(X509Certificate x509Certificate, int i) throws CertificateParsingException {
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

    private static boolean b(String str, String str2) {
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

package okhttp3.internal.f;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class e {
    public abstract X509Certificate b(X509Certificate x509Certificate);

    public static e c(X509TrustManager x509TrustManager) throws NoSuchMethodException, SecurityException {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new a(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return a(x509TrustManager.getAcceptedIssuers());
        }
    }

    private static e a(X509Certificate... x509CertificateArr) {
        return new b(x509CertificateArr);
    }

    static final class a extends e {
        private final X509TrustManager DQ;
        private final Method DR;

        a(X509TrustManager x509TrustManager, Method method) {
            this.DR = method;
            this.DQ = x509TrustManager;
        }

        @Override // okhttp3.internal.f.e
        public final X509Certificate b(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.DR.invoke(this.DQ, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException unused2) {
            }
            return null;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.DQ.equals(aVar.DQ) && this.DR.equals(aVar.DR);
        }

        public final int hashCode() {
            return this.DQ.hashCode() + (this.DR.hashCode() * 31);
        }
    }

    static final class b extends e {
        private final Map<X500Principal, Set<X509Certificate>> DS = new LinkedHashMap();

        public b(X509Certificate... x509CertificateArr) {
            for (X509Certificate x509Certificate : x509CertificateArr) {
                X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
                Set<X509Certificate> linkedHashSet = this.DS.get(subjectX500Principal);
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet<>(1);
                    this.DS.put(subjectX500Principal, linkedHashSet);
                }
                linkedHashSet.add(x509Certificate);
            }
        }

        @Override // okhttp3.internal.f.e
        public final X509Certificate b(X509Certificate x509Certificate) {
            Set<X509Certificate> set = this.DS.get(x509Certificate.getIssuerX500Principal());
            if (set == null) {
                return null;
            }
            for (X509Certificate x509Certificate2 : set) {
                try {
                    x509Certificate.verify(x509Certificate2.getPublicKey());
                    return x509Certificate2;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return (obj instanceof b) && ((b) obj).DS.equals(this.DS);
        }

        public final int hashCode() {
            return this.DS.hashCode();
        }
    }
}

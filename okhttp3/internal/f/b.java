package okhttp3.internal.f;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.X509TrustManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class b {
    public abstract List<Certificate> a(List<Certificate> list, String str);

    public static b b(X509TrustManager x509TrustManager) {
        return okhttp3.internal.e.e.hl().a(x509TrustManager);
    }
}

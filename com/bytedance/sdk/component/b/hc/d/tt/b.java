package com.bytedance.sdk.component.b.hc.d.tt;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class b {
    public abstract List<Certificate> d(List<Certificate> list, String str) throws SSLPeerUnverifiedException;

    public static b d(X509TrustManager x509TrustManager) {
        return com.bytedance.sdk.component.b.hc.d.h.u.hc().d(x509TrustManager);
    }
}

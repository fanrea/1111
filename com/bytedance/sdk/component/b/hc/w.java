package com.bytedance.sdk.component.b.hc;

import com.baidu.mobads.container.util.bu;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class w {
    private final List<Certificate> b;
    private final List<Certificate> c;
    private final z d;
    private final gb hc;

    private w(z zVar, gb gbVar, List<Certificate> list, List<Certificate> list2) {
        this.d = zVar;
        this.hc = gbVar;
        this.b = list;
        this.c = list2;
    }

    public static w d(SSLSession sSLSession) throws SSLPeerUnverifiedException {
        String cipherSuite;
        List listEmptyList;
        List listEmptyList2;
        Certificate[] peerCertificates = null;
        try {
            cipherSuite = sSLSession.getCipherSuite();
        } catch (Exception unused) {
            cipherSuite = null;
        }
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        gb gbVarD = gb.d(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        z zVarD = z.d(protocol);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused2) {
        }
        if (peerCertificates != null) {
            listEmptyList = com.bytedance.sdk.component.b.hc.d.b.d(peerCertificates);
        } else {
            listEmptyList = Collections.emptyList();
        }
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        if (localCertificates != null) {
            listEmptyList2 = com.bytedance.sdk.component.b.hc.d.b.d(localCertificates);
        } else {
            listEmptyList2 = Collections.emptyList();
        }
        return new w(zVarD, gbVarD, listEmptyList, listEmptyList2);
    }

    public z d() {
        return this.d;
    }

    public gb hc() {
        return this.hc;
    }

    public List<Certificate> b() {
        return this.b;
    }

    public List<Certificate> c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.d.equals(wVar.d) && this.hc.equals(wVar.hc) && this.b.equals(wVar.b) && this.c.equals(wVar.c);
    }

    public int hashCode() {
        return ((((((this.d.hashCode() + bu.g) * 31) + this.hc.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }
}

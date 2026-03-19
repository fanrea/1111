package com.bytedance.sdk.component.b.hc;

import com.baidu.mobads.container.util.bu;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class h {
    public static final h d = new d().d();
    private final com.bytedance.sdk.component.b.hc.d.tt.b b;
    private final Set<hc> hc;

    h(Set<hc> set, com.bytedance.sdk.component.b.hc.d.tt.b bVar) {
        this.hc = set;
        this.b = bVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return com.bytedance.sdk.component.b.hc.d.b.d(this.b, hVar.b) && this.hc.equals(hVar.hc);
    }

    public int hashCode() {
        com.bytedance.sdk.component.b.hc.d.tt.b bVar = this.b;
        return ((bVar != null ? bVar.hashCode() : 0) * 31) + this.hc.hashCode();
    }

    public void d(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<hc> listD = d(str);
        if (listD.isEmpty()) {
            return;
        }
        com.bytedance.sdk.component.b.hc.d.tt.b bVar = this.b;
        if (bVar != null) {
            list = bVar.d(list, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i);
            int size2 = listD.size();
            com.bytedance.sdk.component.b.d.an anVarHc = null;
            com.bytedance.sdk.component.b.d.an anVarD = null;
            for (int i2 = 0; i2 < size2; i2++) {
                hc hcVar = listD.get(i2);
                if (hcVar.b.equals("sha256/")) {
                    if (anVarHc == null) {
                        anVarHc = hc(x509Certificate);
                    }
                    if (hcVar.c.equals(anVarHc)) {
                        return;
                    }
                } else if (hcVar.b.equals("sha1/")) {
                    if (anVarD == null) {
                        anVarD = d(x509Certificate);
                    }
                    if (hcVar.c.equals(anVarD)) {
                        return;
                    }
                } else {
                    throw new AssertionError("unsupported hashAlgorithm: " + hcVar.b);
                }
            }
        }
        StringBuilder sb = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
            sb.append("\n    ").append(d((Certificate) x509Certificate2)).append(": ").append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ").append(str).append(":");
        int size4 = listD.size();
        for (int i4 = 0; i4 < size4; i4++) {
            sb.append("\n    ").append(listD.get(i4));
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    List<hc> d(String str) {
        List<hc> listEmptyList = Collections.emptyList();
        for (hc hcVar : this.hc) {
            if (hcVar.d(str)) {
                if (listEmptyList.isEmpty()) {
                    listEmptyList = new ArrayList<>();
                }
                listEmptyList.add(hcVar);
            }
        }
        return listEmptyList;
    }

    h d(com.bytedance.sdk.component.b.hc.d.tt.b bVar) {
        return com.bytedance.sdk.component.b.hc.d.b.d(this.b, bVar) ? this : new h(this.hc, bVar);
    }

    public static String d(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + hc((X509Certificate) certificate).hc();
    }

    static com.bytedance.sdk.component.b.d.an d(X509Certificate x509Certificate) {
        return com.bytedance.sdk.component.b.d.an.d(x509Certificate.getPublicKey().getEncoded()).b();
    }

    static com.bytedance.sdk.component.b.d.an hc(X509Certificate x509Certificate) {
        return com.bytedance.sdk.component.b.d.an.d(x509Certificate.getPublicKey().getEncoded()).c();
    }

    static final class hc {
        final String b;
        final com.bytedance.sdk.component.b.d.an c;
        final String d;
        final String hc;

        boolean d(String str) {
            if (this.d.startsWith("*.")) {
                int iIndexOf = str.indexOf(46);
                if ((str.length() - iIndexOf) - 1 != this.hc.length()) {
                    return false;
                }
                String str2 = this.hc;
                return str.regionMatches(false, iIndexOf + 1, str2, 0, str2.length());
            }
            return str.equals(this.hc);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof hc)) {
                return false;
            }
            hc hcVar = (hc) obj;
            return this.d.equals(hcVar.d) && this.b.equals(hcVar.b) && this.c.equals(hcVar.c);
        }

        public int hashCode() {
            return ((((this.d.hashCode() + bu.g) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return this.b + this.c.hc();
        }
    }

    public static final class d {
        private final List<hc> d = new ArrayList();

        public h d() {
            return new h(new LinkedHashSet(this.d), null);
        }
    }
}

package com.qq.e.comm.plugin;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class x30 extends x50 {
    private final byte[] b;
    private int c;

    x30(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.c = -1;
        this.b = bArr;
    }

    @Override // java.security.cert.Certificate
    public byte[] getEncoded() throws CertificateEncodingException {
        return this.b;
    }

    @Override // java.security.cert.Certificate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x30)) {
            return false;
        }
        try {
            return Arrays.equals(getEncoded(), ((x30) obj).getEncoded());
        } catch (CertificateEncodingException unused) {
            return false;
        }
    }

    @Override // java.security.cert.Certificate
    public int hashCode() {
        if (this.c == -1) {
            try {
                this.c = Arrays.hashCode(getEncoded());
            } catch (CertificateEncodingException unused) {
                this.c = 0;
            }
        }
        return this.c;
    }
}

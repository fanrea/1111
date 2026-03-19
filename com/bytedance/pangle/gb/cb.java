package com.bytedance.pangle.gb;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class cb extends yo {
    private final byte[] d;
    private int hc;

    cb(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.hc = -1;
        this.d = bArr;
    }

    @Override // com.bytedance.pangle.gb.yo, java.security.cert.Certificate
    public byte[] getEncoded() throws CertificateEncodingException {
        return this.d;
    }

    @Override // java.security.cert.Certificate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cb)) {
            return false;
        }
        try {
            return Arrays.equals(getEncoded(), ((cb) obj).getEncoded());
        } catch (CertificateEncodingException unused) {
            return false;
        }
    }

    @Override // java.security.cert.Certificate
    public int hashCode() {
        if (this.hc == -1) {
            try {
                this.hc = Arrays.hashCode(getEncoded());
            } catch (CertificateEncodingException unused) {
                this.hc = 0;
            }
        }
        return this.hc;
    }
}

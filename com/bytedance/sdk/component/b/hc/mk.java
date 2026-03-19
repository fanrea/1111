package com.bytedance.sdk.component.b.hc;

import com.baidu.mobads.container.util.bu;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class mk {
    public static final mk b;
    public static final mk d;
    private static final gb[] gb;
    public static final mk hc;
    final String[] an;
    final boolean c;
    final String[] h;
    final boolean u;

    static {
        gb[] gbVarArr = {gb.mk, gb.uo, gb.mq, gb.k, gb.cb, gb.e, gb.h, gb.tt, gb.gb, gb.tc, gb.u, gb.an, gb.b, gb.c, gb.hc};
        gb = gbVarArr;
        mk mkVarD = new d(true).d(gbVarArr).d(z.TLS_1_3, z.TLS_1_2, z.TLS_1_1, z.TLS_1_0).d(true).d();
        d = mkVarD;
        hc = new d(mkVarD).d(z.TLS_1_0).d(true).d();
        b = new d(false).d();
    }

    mk(d dVar) {
        this.c = dVar.d;
        this.an = dVar.hc;
        this.h = dVar.b;
        this.u = dVar.c;
    }

    public boolean d() {
        return this.c;
    }

    public List<gb> hc() {
        String[] strArr = this.an;
        if (strArr != null) {
            return gb.d(strArr);
        }
        return null;
    }

    public List<z> b() {
        String[] strArr = this.h;
        if (strArr != null) {
            return z.d(strArr);
        }
        return null;
    }

    public boolean c() {
        return this.u;
    }

    void d(SSLSocket sSLSocket, boolean z) {
        mk mkVarHc = hc(sSLSocket, z);
        String[] strArr = mkVarHc.h;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = mkVarHc.an;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    private mk hc(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.an != null) {
            enabledCipherSuites = com.bytedance.sdk.component.b.hc.d.b.d(gb.d, sSLSocket.getEnabledCipherSuites(), this.an);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.h != null) {
            enabledProtocols = com.bytedance.sdk.component.b.hc.d.b.d(com.bytedance.sdk.component.b.hc.d.b.gb, sSLSocket.getEnabledProtocols(), this.h);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int iD = com.bytedance.sdk.component.b.hc.d.b.d(gb.d, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && iD != -1) {
            enabledCipherSuites = com.bytedance.sdk.component.b.hc.d.b.d(enabledCipherSuites, supportedCipherSuites[iD]);
        }
        return new d(this).d(enabledCipherSuites).hc(enabledProtocols).d();
    }

    public boolean d(SSLSocket sSLSocket) {
        if (!this.c) {
            return false;
        }
        if (this.h == null || com.bytedance.sdk.component.b.hc.d.b.hc(com.bytedance.sdk.component.b.hc.d.b.gb, this.h, sSLSocket.getEnabledProtocols())) {
            return this.an == null || com.bytedance.sdk.component.b.hc.d.b.hc(gb.d, this.an, sSLSocket.getEnabledCipherSuites());
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof mk)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        mk mkVar = (mk) obj;
        boolean z = this.c;
        if (z != mkVar.c) {
            return false;
        }
        return !z || (Arrays.equals(this.an, mkVar.an) && Arrays.equals(this.h, mkVar.h) && this.u == mkVar.u);
    }

    public int hashCode() {
        if (this.c) {
            return ((((Arrays.hashCode(this.an) + bu.g) * 31) + Arrays.hashCode(this.h)) * 31) + (!this.u ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.c) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.an != null ? hc().toString() : "[all enabled]") + ", tlsVersions=" + (this.h != null ? b().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.u + ")";
    }

    public static final class d {
        String[] b;
        boolean c;
        boolean d;
        String[] hc;

        d(boolean z) {
            this.d = z;
        }

        public d(mk mkVar) {
            this.d = mkVar.c;
            this.hc = mkVar.an;
            this.b = mkVar.h;
            this.c = mkVar.u;
        }

        public d d(gb... gbVarArr) {
            if (!this.d) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[gbVarArr.length];
            for (int i = 0; i < gbVarArr.length; i++) {
                strArr[i] = gbVarArr[i].w;
            }
            return d(strArr);
        }

        public d d(String... strArr) {
            if (!this.d) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.hc = (String[]) strArr.clone();
            return this;
        }

        public d d(z... zVarArr) {
            if (!this.d) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[zVarArr.length];
            for (int i = 0; i < zVarArr.length; i++) {
                strArr[i] = zVarArr[i].an;
            }
            return hc(strArr);
        }

        public d hc(String... strArr) {
            if (!this.d) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.b = (String[]) strArr.clone();
            return this;
        }

        public d d(boolean z) {
            if (!this.d) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.c = z;
            return this;
        }

        public mk d() {
            return new mk(this);
        }
    }
}

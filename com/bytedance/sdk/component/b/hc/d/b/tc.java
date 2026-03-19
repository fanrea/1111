package com.bytedance.sdk.component.b.hc.d.b;

import com.bytedance.sdk.component.b.hc.he;
import com.bytedance.sdk.component.b.hc.j;
import com.bytedance.sdk.component.b.hc.jh;
import com.bytedance.sdk.component.b.hc.rf;
import com.bytedance.sdk.component.b.hc.us;
import com.bytedance.sdk.component.b.hc.v;
import com.bytedance.sdk.component.b.hc.vv;
import com.just.agentweb.AgentWebPermissions;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class tc implements jh {
    private com.bytedance.sdk.component.b.hc.d.hc.h b;
    private Object c;
    private final v d;
    private final boolean hc;
    private volatile boolean u;

    public tc(v vVar, boolean z) {
        this.d = vVar;
        this.hc = z;
    }

    public void d() {
        this.u = true;
        com.bytedance.sdk.component.b.hc.d.hc.h hVar = this.b;
        if (hVar != null) {
            hVar.u();
        }
    }

    public boolean hc() {
        return this.u;
    }

    public void d(Object obj) {
        this.c = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x006e  */
    @Override // com.bytedance.sdk.component.b.hc.jh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.sdk.component.b.hc.j d(com.bytedance.sdk.component.b.hc.jh.d r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 659
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.b.hc.d.b.tc.d(com.bytedance.sdk.component.b.hc.jh$d):com.bytedance.sdk.component.b.hc.j");
    }

    private com.bytedance.sdk.component.b.hc.d d(rf rfVar) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifierMk;
        com.bytedance.sdk.component.b.hc.h hVarMq;
        if (rfVar.c()) {
            SSLSocketFactory sSLSocketFactoryTc = this.d.tc();
            hostnameVerifierMk = this.d.mk();
            sSLSocketFactory = sSLSocketFactoryTc;
            hVarMq = this.d.mq();
        } else {
            sSLSocketFactory = null;
            hostnameVerifierMk = null;
            hVarMq = null;
        }
        return new com.bytedance.sdk.component.b.hc.d(rfVar.h(), rfVar.gb(), this.d.gb(), this.d.tt(), sSLSocketFactory, hostnameVerifierMk, hVarMq, this.d.k(), this.d.c(), this.d.jh(), this.d.sy(), this.d.u());
    }

    private boolean d(IOException iOException, boolean z, he heVar) throws IOException {
        this.b.d(iOException);
        if (this.d.yo()) {
            return !(z && (heVar.c() instanceof mq)) && d(iOException, z) && this.b.an();
        }
        return false;
    }

    private boolean d(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private he d(j jVar) throws IOException {
        String strD;
        rf rfVarB;
        Proxy proxyC;
        if (jVar == null) {
            throw new IllegalStateException();
        }
        com.bytedance.sdk.component.b.hc.d.hc.b bVarHc = this.b.hc();
        us usVarD = bVarHc != null ? bVarHc.d() : null;
        int iB = jVar.b();
        String strHc = jVar.d().hc();
        if (iB == 307 || iB == 308) {
            if (!strHc.equals("GET") && !strHc.equals("HEAD")) {
                return null;
            }
        } else {
            if (iB == 401) {
                return this.d.uo().d(usVarD, jVar);
            }
            if (iB == 407) {
                if (usVarD != null) {
                    proxyC = usVarD.hc();
                } else {
                    proxyC = this.d.c();
                }
                if (proxyC.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                return this.d.k().d(usVarD, jVar);
            }
            if (iB == 408) {
                if (!this.d.yo() || (jVar.d().c() instanceof mq)) {
                    return null;
                }
                if (jVar.mk() == null || jVar.mk().b() != 408) {
                    return jVar.d();
                }
                return null;
            }
            switch (iB) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        if (!this.d.w() || (strD = jVar.d(AgentWebPermissions.ACTION_LOCATION)) == null || (rfVarB = jVar.d().d().b(strD)) == null) {
            return null;
        }
        if (!rfVarB.b().equals(jVar.d().d().b()) && !this.d.cb()) {
            return null;
        }
        he.d dVarAn = jVar.d().an();
        if (an.b(strHc)) {
            boolean zC = an.c(strHc);
            if (an.u(strHc)) {
                dVarAn.d("GET", (vv) null);
            } else {
                dVarAn.d(strHc, zC ? jVar.d().c() : null);
            }
            if (!zC) {
                dVarAn.hc("Transfer-Encoding");
                dVarAn.hc("Content-Length");
                dVarAn.hc("Content-Type");
            }
        }
        if (!d(jVar, rfVarB)) {
            dVarAn.hc("Authorization");
        }
        return dVarAn.d(rfVarB).d();
    }

    private boolean d(j jVar, rf rfVar) {
        rf rfVarD = jVar.d().d();
        return rfVarD.h().equals(rfVar.h()) && rfVarD.gb() == rfVar.gb() && rfVarD.b().equals(rfVar.b());
    }
}

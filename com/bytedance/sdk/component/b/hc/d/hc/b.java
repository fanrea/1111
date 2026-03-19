package com.bytedance.sdk.component.b.hc.d.hc;

import androidx.core.location.LocationRequestCompat;
import com.bytedance.sdk.component.b.d.mq;
import com.bytedance.sdk.component.b.hc.cb;
import com.bytedance.sdk.component.b.hc.d.u.h;
import com.bytedance.sdk.component.b.hc.he;
import com.bytedance.sdk.component.b.hc.j;
import com.bytedance.sdk.component.b.hc.jh;
import com.bytedance.sdk.component.b.hc.mk;
import com.bytedance.sdk.component.b.hc.np;
import com.bytedance.sdk.component.b.hc.rf;
import com.bytedance.sdk.component.b.hc.tc;
import com.bytedance.sdk.component.b.hc.tt;
import com.bytedance.sdk.component.b.hc.us;
import com.bytedance.sdk.component.b.hc.v;
import com.bytedance.sdk.component.b.hc.w;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class b extends h.hc implements tt {
    public boolean d;
    private com.bytedance.sdk.component.b.d.c e;
    private final us gb;
    private final tc h;
    public int hc;
    private com.bytedance.sdk.component.b.d.u k;
    private w mk;
    private np mq;
    private Socket tc;
    private Socket tt;
    private com.bytedance.sdk.component.b.hc.d.u.h uo;
    public int b = 1;
    public final List<Reference<h>> c = new ArrayList();
    public long u = LocationRequestCompat.PASSIVE_INTERVAL;

    public b(tc tcVar, us usVar) {
        this.h = tcVar;
        this.gb = usVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cc A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(int r16, int r17, int r18, boolean r19, com.bytedance.sdk.component.b.hc.u r20, com.bytedance.sdk.component.b.hc.cb r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.b.hc.d.hc.b.d(int, int, int, boolean, com.bytedance.sdk.component.b.hc.u, com.bytedance.sdk.component.b.hc.cb):void");
    }

    private void d(int i, int i2, int i3, com.bytedance.sdk.component.b.hc.u uVar, cb cbVar) throws IOException {
        he heVarAn = an();
        rf rfVarD = heVarAn.d();
        for (int i4 = 0; i4 < 21; i4++) {
            d(i, i2, uVar, cbVar);
            heVarAn = d(i2, i3, heVarAn, rfVarD);
            if (heVarAn == null) {
                return;
            }
            com.bytedance.sdk.component.b.hc.d.b.d(this.tt);
            this.tt = null;
            this.e = null;
            this.k = null;
        }
    }

    private void d(int i, int i2, com.bytedance.sdk.component.b.hc.u uVar, cb cbVar) throws IOException {
        Proxy proxyHc = this.gb.hc();
        Socket socketCreateSocket = (proxyHc.type() == Proxy.Type.DIRECT || proxyHc.type() == Proxy.Type.HTTP) ? this.gb.d().b().createSocket() : new Socket(proxyHc);
        this.tt = socketCreateSocket;
        socketCreateSocket.setSoTimeout(i2);
        try {
            com.bytedance.sdk.component.b.hc.d.h.u.hc().d(this.tt, this.gb.b(), i);
            try {
                this.k = mq.d(mq.hc(this.tt));
                this.e = mq.d(mq.d(this.tt));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.gb.b());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private void d(hc hcVar, com.bytedance.sdk.component.b.hc.u uVar, cb cbVar) throws Throwable {
        if (this.gb.d().tt() == null) {
            this.mq = np.HTTP_1_1;
            this.tc = this.tt;
            return;
        }
        d(hcVar);
        try {
            if (this.mq == np.HTTP_2) {
                this.tc.setSoTimeout(0);
                com.bytedance.sdk.component.b.hc.d.u.h hVarD = new h.d(true).d(this.tc, this.gb.d().d().h(), this.k, this.e).d(this).d();
                this.uo = hVarD;
                hVarD.b();
            }
        } catch (Throwable unused) {
        }
    }

    private void d(hc hcVar) throws Throwable {
        com.bytedance.sdk.component.b.hc.d dVarD = this.gb.d();
        SSLSocket sSLSocket = null;
        try {
            try {
                SSLSocket sSLSocket2 = (SSLSocket) dVarD.tt().createSocket(this.tt, dVarD.d().h(), dVarD.d().gb(), true);
                try {
                    mk mkVarD = hcVar.d(sSLSocket2);
                    if (mkVarD.c()) {
                        com.bytedance.sdk.component.b.hc.d.h.u.hc().d(sSLSocket2, dVarD.d().h(), dVarD.u());
                    }
                    try {
                        sSLSocket2.startHandshake();
                    } catch (Throwable unused) {
                    }
                    w wVarD = w.d(sSLSocket2.getSession());
                    if (!dVarD.tc().verify(dVarD.d().h(), sSLSocket2.getSession())) {
                        X509Certificate x509Certificate = (X509Certificate) wVarD.b().get(0);
                        throw new SSLPeerUnverifiedException("Hostname " + dVarD.d().h() + " not verified:\n    certificate: " + com.bytedance.sdk.component.b.hc.h.d((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + com.bytedance.sdk.component.b.hc.d.tt.u.d(x509Certificate));
                    }
                    dVarD.mk().d(dVarD.d().h(), wVarD.b());
                    String strD = mkVarD.c() ? com.bytedance.sdk.component.b.hc.d.h.u.hc().d(sSLSocket2) : null;
                    this.tc = sSLSocket2;
                    this.k = mq.d(mq.hc(sSLSocket2));
                    this.e = mq.d(mq.d(this.tc));
                    this.mk = wVarD;
                    this.mq = strD != null ? np.d(strD) : np.HTTP_1_1;
                    if (sSLSocket2 != null) {
                        com.bytedance.sdk.component.b.hc.d.h.u.hc().hc(sSLSocket2);
                    }
                } catch (AssertionError e) {
                    e = e;
                    if (!com.bytedance.sdk.component.b.hc.d.b.d(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    sSLSocket = sSLSocket2;
                    if (sSLSocket != null) {
                        com.bytedance.sdk.component.b.hc.d.h.u.hc().hc(sSLSocket);
                    }
                    com.bytedance.sdk.component.b.hc.d.b.d((Socket) sSLSocket);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (AssertionError e2) {
            e = e2;
        }
    }

    private he d(int i, int i2, he heVar, rf rfVar) throws IOException {
        String str = "CONNECT " + com.bytedance.sdk.component.b.hc.d.b.d(rfVar, true) + " HTTP/1.1";
        while (true) {
            com.bytedance.sdk.component.b.hc.d.c.d dVar = new com.bytedance.sdk.component.b.hc.d.c.d(null, null, this.k, this.e);
            this.k.d().d(i, TimeUnit.MILLISECONDS);
            this.e.d().d(i2, TimeUnit.MILLISECONDS);
            dVar.d(heVar.b(), str);
            dVar.hc();
            j jVarD = dVar.d(false).d(heVar).d();
            long jD = com.bytedance.sdk.component.b.hc.d.b.u.d(jVarD);
            if (jD == -1) {
                jD = 0;
            }
            com.bytedance.sdk.component.b.d.rf rfVarHc = dVar.hc(jD);
            com.bytedance.sdk.component.b.hc.d.b.hc(rfVarHc, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            rfVarHc.close();
            int iB = jVarD.b();
            if (iB == 200) {
                if (this.k.b().u() && this.e.b().u()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (iB == 407) {
                he heVarD = this.gb.d().c().d(this.gb, jVarD);
                if (heVarD == null) {
                    throw new IOException("Failed to authenticate with proxy");
                }
                if ("close".equalsIgnoreCase(jVarD.d("Connection"))) {
                    return heVarD;
                }
                heVar = heVarD;
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + jVarD.b());
            }
        }
    }

    private he an() {
        return new he.d().d(this.gb.d().d()).d("Host", com.bytedance.sdk.component.b.hc.d.b.d(this.gb.d().d(), true)).d("Proxy-Connection", "Keep-Alive").d("User-Agent", com.bytedance.sdk.component.b.hc.d.c.d()).d();
    }

    public boolean d(com.bytedance.sdk.component.b.hc.d dVar, us usVar) {
        if (this.c.size() >= this.b || this.d || !com.bytedance.sdk.component.b.hc.d.d.d.d(this.gb.d(), dVar)) {
            return false;
        }
        if (dVar.d().h().equals(d().d().d().h())) {
            return true;
        }
        if (this.uo == null || usVar == null || usVar.hc().type() != Proxy.Type.DIRECT || this.gb.hc().type() != Proxy.Type.DIRECT || !this.gb.b().equals(usVar.b()) || usVar.d().tc() != com.bytedance.sdk.component.b.hc.d.tt.u.d || !d(dVar.d())) {
            return false;
        }
        try {
            dVar.mk().d(dVar.d().h(), c().b());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean d(rf rfVar) {
        if (rfVar.gb() != this.gb.d().d().gb()) {
            return false;
        }
        if (rfVar.h().equals(this.gb.d().d().h())) {
            return true;
        }
        return this.mk != null && com.bytedance.sdk.component.b.hc.d.tt.u.d.d(rfVar.h(), (X509Certificate) this.mk.b().get(0));
    }

    public com.bytedance.sdk.component.b.hc.d.b.b d(v vVar, jh.d dVar, h hVar) throws SocketException {
        if (this.uo != null) {
            return new com.bytedance.sdk.component.b.hc.d.u.an(vVar, dVar, hVar, this.uo);
        }
        this.tc.setSoTimeout(dVar.b());
        this.k.d().d(dVar.b(), TimeUnit.MILLISECONDS);
        this.e.d().d(dVar.c(), TimeUnit.MILLISECONDS);
        return new com.bytedance.sdk.component.b.hc.d.c.d(vVar, hVar, this.k, this.e);
    }

    @Override // com.bytedance.sdk.component.b.hc.tt
    public us d() {
        return this.gb;
    }

    public void hc() throws IOException {
        com.bytedance.sdk.component.b.hc.d.b.d(this.tt);
    }

    public Socket b() {
        return this.tc;
    }

    public boolean d(boolean z) throws SocketException {
        if (this.tc.isClosed() || this.tc.isInputShutdown() || this.tc.isOutputShutdown()) {
            return false;
        }
        com.bytedance.sdk.component.b.hc.d.u.h hVar = this.uo;
        if (hVar != null) {
            return !hVar.c();
        }
        if (z) {
            try {
                int soTimeout = this.tc.getSoTimeout();
                try {
                    this.tc.setSoTimeout(1);
                    return !this.k.u();
                } finally {
                    this.tc.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.b.hc.d.u.h.hc
    public void d(com.bytedance.sdk.component.b.hc.d.u.tt ttVar) throws IOException {
        ttVar.d(com.bytedance.sdk.component.b.hc.d.u.hc.REFUSED_STREAM);
    }

    @Override // com.bytedance.sdk.component.b.hc.d.u.h.hc
    public void d(com.bytedance.sdk.component.b.hc.d.u.h hVar) {
        synchronized (this.h) {
            this.b = hVar.d();
        }
    }

    public w c() {
        return this.mk;
    }

    public boolean u() {
        return this.uo != null;
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("Connection{").append(this.gb.d().d().h()).append(":").append(this.gb.d().d().gb()).append(", proxy=").append(this.gb.hc()).append(" hostAddress=").append(this.gb.b()).append(" cipherSuite=");
        w wVar = this.mk;
        return sbAppend.append(wVar != null ? wVar.hc() : "none").append(" protocol=").append(this.mq).append('}').toString();
    }
}

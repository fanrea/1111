package com.bytedance.sdk.component.b.hc.d.hc;

import com.bytedance.sdk.component.b.hc.mk;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class hc {
    private boolean b;
    private boolean c;
    private final List<mk> d;
    private int hc = 0;

    public hc(List<mk> list) {
        this.d = list;
    }

    public mk d(SSLSocket sSLSocket) throws IOException {
        mk mkVar;
        int i = this.hc;
        int size = this.d.size();
        while (true) {
            if (i >= size) {
                mkVar = null;
                break;
            }
            mkVar = this.d.get(i);
            if (mkVar.d(sSLSocket)) {
                this.hc = i + 1;
                break;
            }
            i++;
        }
        if (mkVar == null) {
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.c + ", modes=" + this.d + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        this.b = hc(sSLSocket);
        com.bytedance.sdk.component.b.hc.d.d.d.d(mkVar, sSLSocket, this.c);
        return mkVar;
    }

    public boolean d(IOException iOException) {
        this.c = true;
        if (!this.b || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z || (iOException instanceof SSLProtocolException);
    }

    private boolean hc(SSLSocket sSLSocket) {
        for (int i = this.hc; i < this.d.size(); i++) {
            if (this.d.get(i).d(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}

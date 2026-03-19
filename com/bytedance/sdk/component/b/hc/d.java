package com.bytedance.sdk.component.b.hc;

import com.alipay.sdk.m.l.a;
import com.alipay.sdk.m.u.i;
import com.baidu.mobads.container.util.bu;
import com.bytedance.sdk.component.b.hc.rf;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class d {
    final List<mk> an;
    final SocketFactory b;
    final hc c;
    final rf d;
    final Proxy gb;
    final ProxySelector h;
    final e hc;
    final h mk;
    final HostnameVerifier tc;
    final SSLSocketFactory tt;
    final List<np> u;

    public d(String str, int i, e eVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, h hVar, hc hcVar, Proxy proxy, List<np> list, List<mk> list2, ProxySelector proxySelector) {
        this.d = new rf.d().d(sSLSocketFactory != null ? "https" : a.r).c(str).d(i).b();
        if (eVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.hc = eVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.b = socketFactory;
        if (hcVar == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.c = hcVar;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.u = com.bytedance.sdk.component.b.hc.d.b.d(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.an = com.bytedance.sdk.component.b.hc.d.b.d(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.h = proxySelector;
        this.gb = proxy;
        this.tt = sSLSocketFactory;
        this.tc = hostnameVerifier;
        this.mk = hVar;
    }

    public rf d() {
        return this.d;
    }

    public e hc() {
        return this.hc;
    }

    public SocketFactory b() {
        return this.b;
    }

    public hc c() {
        return this.c;
    }

    public List<np> u() {
        return this.u;
    }

    public List<mk> an() {
        return this.an;
    }

    public ProxySelector h() {
        return this.h;
    }

    public Proxy gb() {
        return this.gb;
    }

    public SSLSocketFactory tt() {
        return this.tt;
    }

    public HostnameVerifier tc() {
        return this.tc;
    }

    public h mk() {
        return this.mk;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.d.equals(dVar.d) && d(dVar);
    }

    public int hashCode() {
        int iHashCode = (((((((((((this.d.hashCode() + bu.g) * 31) + this.hc.hashCode()) * 31) + this.c.hashCode()) * 31) + this.u.hashCode()) * 31) + this.an.hashCode()) * 31) + this.h.hashCode()) * 31;
        Proxy proxy = this.gb;
        int iHashCode2 = (iHashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.tt;
        int iHashCode3 = (iHashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.tc;
        int iHashCode4 = (iHashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        h hVar = this.mk;
        return iHashCode4 + (hVar != null ? hVar.hashCode() : 0);
    }

    boolean d(d dVar) {
        return this.hc.equals(dVar.hc) && this.c.equals(dVar.c) && this.u.equals(dVar.u) && this.an.equals(dVar.an) && this.h.equals(dVar.h) && com.bytedance.sdk.component.b.hc.d.b.d(this.gb, dVar.gb) && com.bytedance.sdk.component.b.hc.d.b.d(this.tt, dVar.tt) && com.bytedance.sdk.component.b.hc.d.b.d(this.tc, dVar.tc) && com.bytedance.sdk.component.b.hc.d.b.d(this.mk, dVar.mk) && d().gb() == dVar.d().gb();
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("Address{").append(this.d.h()).append(":").append(this.d.gb());
        if (this.gb != null) {
            sbAppend.append(", proxy=").append(this.gb);
        } else {
            sbAppend.append(", proxySelector=").append(this.h);
        }
        sbAppend.append(i.d);
        return sbAppend.toString();
    }
}

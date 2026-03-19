package com.bytedance.sdk.component.b.hc;

import android.os.Bundle;
import com.bytedance.sdk.component.b.hc.cb;
import com.bytedance.sdk.component.b.hc.j;
import com.bytedance.sdk.component.b.hc.yo;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class v implements Cloneable {
    static final List<np> d = com.bytedance.sdk.component.b.hc.d.b.d(np.HTTP_2, np.HTTP_1_1);
    static final List<mk> hc = com.bytedance.sdk.component.b.hc.d.b.d(mk.d, mk.b);
    final List<mk> an;
    final k b;
    final Proxy c;
    final com.bytedance.sdk.component.b.hc.d.tt.b cb;
    final e de;
    final SSLSocketFactory e;
    final List<jh> gb;
    final List<jh> h;
    final int he;
    final int j;
    final hc jh;
    final SocketFactory k;
    final uo mk;
    final b mq;
    final boolean np;
    final hc rf;
    public Set<String> s;
    final tc sy;
    final ProxySelector tc;
    final cb.d tt;
    final List<np> u;
    final com.bytedance.sdk.component.b.hc.d.d.an uo;
    final boolean v;
    final int vv;
    final HostnameVerifier w;
    final boolean yi;
    final h yo;
    final int zw;

    static {
        com.bytedance.sdk.component.b.hc.d.d.d = new com.bytedance.sdk.component.b.hc.d.d() { // from class: com.bytedance.sdk.component.b.hc.v.1
            @Override // com.bytedance.sdk.component.b.hc.d.d
            public void d(yo.d dVar, String str) {
                dVar.d(str);
            }

            @Override // com.bytedance.sdk.component.b.hc.d.d
            public void d(yo.d dVar, String str, String str2) {
                dVar.hc(str, str2);
            }

            @Override // com.bytedance.sdk.component.b.hc.d.d
            public boolean d(tc tcVar, com.bytedance.sdk.component.b.hc.d.hc.b bVar) {
                return tcVar.hc(bVar);
            }

            @Override // com.bytedance.sdk.component.b.hc.d.d
            public com.bytedance.sdk.component.b.hc.d.hc.b d(tc tcVar, com.bytedance.sdk.component.b.hc.d dVar, com.bytedance.sdk.component.b.hc.d.hc.h hVar, us usVar) {
                return tcVar.d(dVar, hVar, usVar);
            }

            @Override // com.bytedance.sdk.component.b.hc.d.d
            public boolean d(com.bytedance.sdk.component.b.hc.d dVar, com.bytedance.sdk.component.b.hc.d dVar2) {
                return dVar.d(dVar2);
            }

            @Override // com.bytedance.sdk.component.b.hc.d.d
            public Socket d(tc tcVar, com.bytedance.sdk.component.b.hc.d dVar, com.bytedance.sdk.component.b.hc.d.hc.h hVar) {
                return tcVar.d(dVar, hVar);
            }

            @Override // com.bytedance.sdk.component.b.hc.d.d
            public void hc(tc tcVar, com.bytedance.sdk.component.b.hc.d.hc.b bVar) {
                tcVar.d(bVar);
            }

            @Override // com.bytedance.sdk.component.b.hc.d.d
            public com.bytedance.sdk.component.b.hc.d.hc.c d(tc tcVar) {
                return tcVar.d;
            }

            @Override // com.bytedance.sdk.component.b.hc.d.d
            public int d(j.d dVar) {
                return dVar.b;
            }

            @Override // com.bytedance.sdk.component.b.hc.d.d
            public void d(mk mkVar, SSLSocket sSLSocket, boolean z) {
                mkVar.d(sSLSocket, z);
            }
        };
    }

    public v() {
        this(new d());
    }

    v(d dVar) throws NoSuchAlgorithmException, KeyStoreException {
        boolean z;
        this.b = dVar.d;
        this.c = dVar.hc;
        this.u = dVar.b;
        List<mk> list = dVar.c;
        this.an = list;
        this.h = com.bytedance.sdk.component.b.hc.d.b.d(dVar.u);
        this.gb = com.bytedance.sdk.component.b.hc.d.b.d(dVar.an);
        this.tt = dVar.h;
        this.tc = dVar.gb;
        this.mk = dVar.tt;
        this.mq = dVar.tc;
        this.uo = dVar.mk;
        this.k = dVar.mq;
        this.s = dVar.j;
        Iterator<mk> it = list.iterator();
        loop0: while (true) {
            z = false;
            while (it.hasNext()) {
                z = (z || it.next().d()) ? true : z;
            }
        }
        if (dVar.uo != null || !z) {
            this.e = dVar.uo;
            this.cb = dVar.k;
        } else {
            X509TrustManager x509TrustManagerYi = yi();
            this.e = d(x509TrustManagerYi);
            this.cb = com.bytedance.sdk.component.b.hc.d.tt.b.d(x509TrustManagerYi);
        }
        this.w = dVar.e;
        this.yo = dVar.cb.d(this.cb);
        this.rf = dVar.w;
        this.jh = dVar.yo;
        tc tcVar = dVar.rf;
        this.sy = tcVar;
        if (tcVar != null) {
            tcVar.d(dVar.zw);
        }
        this.de = dVar.jh;
        this.v = dVar.sy;
        this.np = dVar.de;
        this.yi = dVar.v;
        this.he = dVar.np;
        this.vv = dVar.yi;
        this.zw = dVar.he;
        this.j = dVar.vv;
        if (this.h.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.h);
        }
        if (this.gb.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.gb);
        }
    }

    private X509TrustManager yi() throws NoSuchAlgorithmException, KeyStoreException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e) {
            throw com.bytedance.sdk.component.b.hc.d.b.d("No System TLS", (Exception) e);
        }
    }

    private SSLSocketFactory d(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw com.bytedance.sdk.component.b.hc.d.b.d("No System TLS", (Exception) e);
        }
    }

    public int d() {
        return this.he;
    }

    public int hc() {
        return this.vv;
    }

    public int b() {
        return this.zw;
    }

    public Proxy c() {
        return this.c;
    }

    public ProxySelector u() {
        return this.tc;
    }

    public uo an() {
        return this.mk;
    }

    com.bytedance.sdk.component.b.hc.d.d.an h() {
        b bVar = this.mq;
        return bVar != null ? bVar.d : this.uo;
    }

    public e gb() {
        return this.de;
    }

    public SocketFactory tt() {
        return this.k;
    }

    public SSLSocketFactory tc() {
        return this.e;
    }

    public HostnameVerifier mk() {
        return this.w;
    }

    public h mq() {
        return this.yo;
    }

    public hc uo() {
        return this.jh;
    }

    public hc k() {
        return this.rf;
    }

    public tc e() {
        return this.sy;
    }

    public boolean cb() {
        return this.v;
    }

    public boolean w() {
        return this.np;
    }

    public boolean yo() {
        return this.yi;
    }

    public k rf() {
        return this.b;
    }

    public List<np> jh() {
        return this.u;
    }

    public List<mk> sy() {
        return this.an;
    }

    public List<jh> de() {
        return this.h;
    }

    public List<jh> v() {
        return this.gb;
    }

    public cb.d np() {
        return this.tt;
    }

    public u d(he heVar) {
        return yi.d(this, heVar, false);
    }

    public static final class d {
        final List<jh> an;
        public List<np> b;
        List<mk> c;
        h cb;
        k d;
        boolean de;
        HostnameVerifier e;
        ProxySelector gb;
        cb.d h;
        Proxy hc;
        public int he;
        public Set<String> j;
        e jh;
        com.bytedance.sdk.component.b.hc.d.tt.b k;
        com.bytedance.sdk.component.b.hc.d.d.an mk;
        SocketFactory mq;
        public int np;
        tc rf;
        public TimeUnit s;
        boolean sy;
        b tc;
        uo tt;
        public final List<jh> u;
        SSLSocketFactory uo;
        public TimeUnit us;
        boolean v;
        int vv;
        hc w;
        public int yi;
        hc yo;
        public TimeUnit z;
        public Bundle zw;

        public d() {
            this("");
        }

        public d(String str) {
            this.u = new ArrayList();
            this.an = new ArrayList();
            this.s = TimeUnit.MILLISECONDS;
            this.us = TimeUnit.MILLISECONDS;
            this.z = TimeUnit.MILLISECONDS;
            this.d = new k(str);
            this.b = v.d;
            this.c = v.hc;
            this.h = cb.d(cb.d);
            this.gb = ProxySelector.getDefault();
            this.tt = uo.d;
            this.mq = SocketFactory.getDefault();
            this.e = com.bytedance.sdk.component.b.hc.d.tt.u.d;
            this.cb = h.d;
            this.w = hc.d;
            this.yo = hc.d;
            this.rf = new tc();
            this.jh = e.d;
            this.sy = true;
            this.de = true;
            this.v = true;
            this.np = 10000;
            this.yi = 10000;
            this.he = 10000;
            this.vv = 0;
        }

        public d d(long j, TimeUnit timeUnit) {
            this.np = com.bytedance.sdk.component.b.hc.d.b.d("timeout", j, timeUnit);
            return this;
        }

        public d hc(long j, TimeUnit timeUnit) {
            this.yi = com.bytedance.sdk.component.b.hc.d.b.d("timeout", j, timeUnit);
            return this;
        }

        public d b(long j, TimeUnit timeUnit) {
            this.he = com.bytedance.sdk.component.b.hc.d.b.d("timeout", j, timeUnit);
            return this;
        }

        public d d(jh jhVar) {
            if (jhVar == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.u.add(jhVar);
            return this;
        }

        public d d(cb cbVar) {
            if (cbVar == null) {
                throw new NullPointerException("eventListener == null");
            }
            this.h = cb.d(cbVar);
            return this;
        }

        public d d(Set<String> set) {
            this.j = set;
            return this;
        }

        public v d() {
            return new v(this);
        }
    }
}

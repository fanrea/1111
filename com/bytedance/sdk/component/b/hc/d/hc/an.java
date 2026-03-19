package com.bytedance.sdk.component.b.hc.d.hc;

import com.bytedance.sdk.component.b.hc.cb;
import com.bytedance.sdk.component.b.hc.rf;
import com.bytedance.sdk.component.b.hc.us;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class an {
    private int an;
    private final com.bytedance.sdk.component.b.hc.u b;
    private final cb c;
    private final com.bytedance.sdk.component.b.hc.d d;
    private final c hc;
    private List<Proxy> u = Collections.emptyList();
    private List<InetSocketAddress> h = Collections.emptyList();
    private final List<us> gb = new ArrayList();

    public an(com.bytedance.sdk.component.b.hc.d dVar, c cVar, com.bytedance.sdk.component.b.hc.u uVar, cb cbVar) throws IOException {
        this.d = dVar;
        this.hc = cVar;
        this.b = uVar;
        this.c = cbVar;
        d(dVar.d(), dVar.gb());
    }

    public boolean d() {
        return b() || !this.gb.isEmpty();
    }

    public d hc() throws IOException {
        if (!d()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (b()) {
            Proxy proxyC = c();
            int size = this.h.size();
            for (int i = 0; i < size; i++) {
                us usVar = new us(this.d, proxyC, this.h.get(i));
                if (this.hc.b(usVar)) {
                    this.gb.add(usVar);
                } else {
                    arrayList.add(usVar);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.gb);
            this.gb.clear();
        }
        return new d(arrayList);
    }

    public void d(us usVar, IOException iOException) {
        if (usVar.hc().type() != Proxy.Type.DIRECT && this.d.h() != null) {
            this.d.h().connectFailed(this.d.d().hc(), usVar.hc().address(), iOException);
        }
        this.hc.d(usVar);
    }

    private void d(rf rfVar, Proxy proxy) throws IOException {
        List<Proxy> listD;
        if (proxy != null) {
            this.u = Collections.singletonList(proxy);
        } else {
            try {
                List<Proxy> listSelect = this.d.h().select(rfVar.hc());
                if (listSelect != null && !listSelect.isEmpty()) {
                    listD = com.bytedance.sdk.component.b.hc.d.b.d(listSelect);
                } else {
                    listD = com.bytedance.sdk.component.b.hc.d.b.d(Proxy.NO_PROXY);
                }
                this.u = listD;
            } catch (IllegalArgumentException unused) {
                throw new IOException();
            }
        }
        this.an = 0;
    }

    private boolean b() {
        return this.an < this.u.size();
    }

    private Proxy c() throws IOException {
        if (!b()) {
            throw new SocketException("No route to " + this.d.d().h() + "; exhausted proxy configurations: " + this.u);
        }
        List<Proxy> list = this.u;
        int i = this.an;
        this.an = i + 1;
        Proxy proxy = list.get(i);
        d(proxy);
        return proxy;
    }

    private void d(Proxy proxy) throws IOException {
        String strH;
        int iGb;
        this.h = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            strH = this.d.d().h();
            iGb = this.d.d().gb();
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            strH = d(inetSocketAddress);
            iGb = inetSocketAddress.getPort();
        }
        if (iGb <= 0 || iGb > 65535) {
            throw new SocketException("No route to " + strH + ":" + iGb + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.h.add(InetSocketAddress.createUnresolved(strH, iGb));
            return;
        }
        List<InetAddress> listD = this.d.hc().d(strH);
        if (listD.isEmpty()) {
            return;
        }
        int size = listD.size();
        for (int i = 0; i < size; i++) {
            this.h.add(new InetSocketAddress(listD.get(i), iGb));
        }
    }

    static String d(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    public static final class d {
        private final List<us> d;
        private int hc = 0;

        d(List<us> list) {
            this.d = list;
        }

        public boolean d() {
            return this.hc < this.d.size();
        }

        public us hc() {
            if (!d()) {
                throw new NoSuchElementException();
            }
            List<us> list = this.d;
            int i = this.hc;
            this.hc = i + 1;
            return list.get(i);
        }

        public List<us> b() {
            return new ArrayList(this.d);
        }
    }
}

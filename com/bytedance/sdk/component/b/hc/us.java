package com.bytedance.sdk.component.b.hc;

import com.alipay.sdk.m.u.i;
import com.baidu.mobads.container.util.bu;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class us {
    final InetSocketAddress b;
    final d d;
    final Proxy hc;

    public us(d dVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (dVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.d = dVar;
        this.hc = proxy;
        this.b = inetSocketAddress;
    }

    public d d() {
        return this.d;
    }

    public Proxy hc() {
        return this.hc;
    }

    public InetSocketAddress b() {
        return this.b;
    }

    public boolean c() {
        return this.d.tt != null && this.hc.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof us)) {
            return false;
        }
        us usVar = (us) obj;
        return usVar.d.equals(this.d) && usVar.hc.equals(this.hc) && usVar.b.equals(this.b);
    }

    public int hashCode() {
        return ((((this.d.hashCode() + bu.g) * 31) + this.hc.hashCode()) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "Route{" + this.b + i.d;
    }
}

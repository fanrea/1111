package com.qq.e.comm.plugin;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class lm extends ProxySelector {
    private static final List<Proxy> d = Arrays.asList(Proxy.NO_PROXY);
    private final ProxySelector a;
    private final String b;
    private final int c;

    static void a(String str, int i) {
        ProxySelector.setDefault(new lm(ProxySelector.getDefault(), str, i));
    }

    lm(ProxySelector proxySelector, String str, int i) {
        this.a = proxySelector;
        this.b = str;
        this.c = i;
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        boolean z = this.b.equals(uri.getHost()) && this.c == uri.getPort();
        List<Proxy> list = d;
        if (z) {
            return list;
        }
        try {
            return this.a.select(uri);
        } catch (Throwable unused) {
            return list;
        }
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.a.connectFailed(uri, socketAddress, iOException);
    }
}

package com.sigmob.sdk.videocache;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class k extends ProxySelector {
    private static final List<Proxy> a = Arrays.asList(Proxy.NO_PROXY);
    private final ProxySelector b;
    private final String c;
    private final int d;

    k(ProxySelector defaultProxySelector, String hostToIgnore, int portToIgnore) {
        this.b = (ProxySelector) o.a(defaultProxySelector);
        this.c = (String) o.a(hostToIgnore);
        this.d = portToIgnore;
    }

    static void a(String hostToIgnore, int portToIgnore) {
        ProxySelector.setDefault(new k(ProxySelector.getDefault(), hostToIgnore, portToIgnore));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress address, IOException failure) {
        this.b.connectFailed(uri, address, failure);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        return this.c.equals(uri.getHost()) && this.d == uri.getPort() ? a : this.b.select(uri);
    }
}

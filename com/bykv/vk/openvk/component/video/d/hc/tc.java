package com.bykv.vk.openvk.component.video.d.hc;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class tc extends ProxySelector {
    private static final List<Proxy> d = Collections.singletonList(Proxy.NO_PROXY);
    private final String b;
    private final int c;
    private final ProxySelector hc = ProxySelector.getDefault();

    private tc(String str, int i) {
        this.b = str;
        this.c = i;
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        if (uri != null) {
            return (this.b.equalsIgnoreCase(uri.getHost()) && this.c == uri.getPort()) ? d : this.hc.select(uri);
        }
        throw new IllegalArgumentException("URI can't be null");
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.hc.connectFailed(uri, socketAddress, iOException);
    }

    static void d(String str, int i) {
        ProxySelector.setDefault(new tc(str, i));
    }
}

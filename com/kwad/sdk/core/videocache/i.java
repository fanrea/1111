package com.kwad.sdk.core.videocache;

import com.kwad.sdk.utils.ax;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class i extends ProxySelector {
    private static final List<Proxy> bJx = Arrays.asList(Proxy.NO_PROXY);
    private final int bJA;
    private final ProxySelector bJy;
    private final String bJz;

    private i(ProxySelector proxySelector, String str, int i) {
        this.bJy = (ProxySelector) ax.checkNotNull(proxySelector);
        this.bJz = ax.iA(str);
        this.bJA = i;
    }

    static void install(String str, int i) {
        ProxySelector.setDefault(new i(ProxySelector.getDefault(), str, i));
    }

    @Override // java.net.ProxySelector
    public final List<Proxy> select(URI uri) {
        return this.bJz.equals(uri.getHost()) && this.bJA == uri.getPort() ? bJx : this.bJy.select(uri);
    }

    @Override // java.net.ProxySelector
    public final void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.bJy.connectFailed(uri, socketAddress, iOException);
    }
}

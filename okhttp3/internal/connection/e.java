package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.Address;
import okhttp3.HttpUrl;
import okhttp3.Route;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class e {
    private Proxy AM;
    private InetSocketAddress AN;
    private int AP;
    private int AR;
    private final Address address;
    private final d routeDatabase;
    private List<Proxy> AO = Collections.emptyList();
    private List<InetSocketAddress> AQ = Collections.emptyList();
    private final List<Route> AS = new ArrayList();

    public e(Address address, d dVar) {
        this.address = address;
        this.routeDatabase = dVar;
        a(address.url(), address.proxy());
    }

    public final boolean hasNext() {
        return gs() || gq() || gu();
    }

    public final Route gp() {
        while (true) {
            if (!gs()) {
                if (!gq()) {
                    if (!gu()) {
                        throw new NoSuchElementException();
                    }
                    return gv();
                }
                this.AM = gr();
            }
            this.AN = gt();
            Route route = new Route(this.address, this.AM, this.AN);
            if (!this.routeDatabase.c(route)) {
                return route;
            }
            this.AS.add(route);
        }
    }

    public final void a(Route route, IOException iOException) {
        if (route.proxy().type() != Proxy.Type.DIRECT && this.address.proxySelector() != null) {
            this.address.proxySelector().connectFailed(this.address.url().uri(), route.proxy().address(), iOException);
        }
        this.routeDatabase.a(route);
    }

    private void a(HttpUrl httpUrl, Proxy proxy) {
        List<Proxy> listB;
        if (proxy != null) {
            listB = Collections.singletonList(proxy);
        } else {
            List<Proxy> listSelect = this.address.proxySelector().select(httpUrl.uri());
            if (listSelect != null && !listSelect.isEmpty()) {
                listB = okhttp3.internal.c.g(listSelect);
            } else {
                listB = okhttp3.internal.c.b(Proxy.NO_PROXY);
            }
        }
        this.AO = listB;
        this.AP = 0;
    }

    private boolean gq() {
        return this.AP < this.AO.size();
    }

    private Proxy gr() throws SocketException, UnknownHostException {
        if (!gq()) {
            throw new SocketException("No route to " + this.address.url().host() + "; exhausted proxy configurations: " + this.AO);
        }
        List<Proxy> list = this.AO;
        int i = this.AP;
        this.AP = i + 1;
        Proxy proxy = list.get(i);
        a(proxy);
        return proxy;
    }

    private void a(Proxy proxy) throws SocketException, UnknownHostException {
        String strHost;
        int iPort;
        this.AQ = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            strHost = this.address.url().host();
            iPort = this.address.url().port();
        } else {
            SocketAddress socketAddressAddress = proxy.address();
            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
            strHost = a(inetSocketAddress);
            iPort = inetSocketAddress.getPort();
        }
        if (iPort <= 0 || iPort > 65535) {
            throw new SocketException("No route to " + strHost + ":" + iPort + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.AQ.add(InetSocketAddress.createUnresolved(strHost, iPort));
        } else {
            List<InetAddress> listLookup = this.address.dns().lookup(strHost);
            int size = listLookup.size();
            for (int i = 0; i < size; i++) {
                this.AQ.add(new InetSocketAddress(listLookup.get(i), iPort));
            }
        }
        this.AR = 0;
    }

    private static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    private boolean gs() {
        return this.AR < this.AQ.size();
    }

    private InetSocketAddress gt() throws SocketException {
        if (!gs()) {
            throw new SocketException("No route to " + this.address.url().host() + "; exhausted inet socket addresses: " + this.AQ);
        }
        List<InetSocketAddress> list = this.AQ;
        int i = this.AR;
        this.AR = i + 1;
        return list.get(i);
    }

    private boolean gu() {
        return !this.AS.isEmpty();
    }

    private Route gv() {
        return this.AS.remove(0);
    }
}

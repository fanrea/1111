package okhttp3.internal.connection;

import androidx.core.location.LocationRequestCompat;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.g.a;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.e;
import okhttp3.internal.http2.g;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class c extends e.b implements Connection {
    private final Route AA;
    private Socket AB;
    private okhttp3.internal.http2.e AC;
    private BufferedSink AD;
    public boolean AE;
    public int AF = 1;
    public final List<Reference<f>> AG = new ArrayList();
    public long AH = LocationRequestCompat.PASSIVE_INTERVAL;
    private final ConnectionPool connectionPool;
    private Handshake handshake;
    private Protocol protocol;
    private Socket socket;
    private BufferedSource source;
    public int successCount;

    public c(ConnectionPool connectionPool, Route route) {
        this.connectionPool = connectionPool;
        this.AA = route;
    }

    public final void b(int i, int i2, int i3, boolean z) throws Throwable {
        if (this.protocol != null) {
            throw new IllegalStateException("already connected");
        }
        List<ConnectionSpec> listConnectionSpecs = this.AA.address().connectionSpecs();
        b bVar = new b(listConnectionSpecs);
        if (this.AA.address().sslSocketFactory() == null) {
            if (!listConnectionSpecs.contains(ConnectionSpec.CLEARTEXT)) {
                throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String strHost = this.AA.address().url().host();
            if (!okhttp3.internal.e.e.hl().isCleartextTrafficPermitted(strHost)) {
                throw new RouteException(new UnknownServiceException("CLEARTEXT communication to " + strHost + " not permitted by network security policy"));
            }
        }
        RouteException routeException = null;
        do {
            try {
                if (this.AA.requiresTunnel()) {
                    i(i, i2, i3);
                } else {
                    X(i, i2);
                }
                a(bVar);
                if (this.AC != null) {
                    synchronized (this.connectionPool) {
                        this.AF = this.AC.gR();
                    }
                    return;
                }
                return;
            } catch (IOException e) {
                okhttp3.internal.c.a(this.socket);
                okhttp3.internal.c.a(this.AB);
                this.socket = null;
                this.AB = null;
                this.source = null;
                this.AD = null;
                this.handshake = null;
                this.protocol = null;
                this.AC = null;
                if (routeException == null) {
                    routeException = new RouteException(e);
                } else {
                    routeException.addConnectException(e);
                }
                if (!z) {
                    throw routeException;
                }
            }
        } while (bVar.a(e));
        throw routeException;
    }

    private void i(int i, int i2, int i3) throws IOException {
        Request requestGn = gn();
        HttpUrl httpUrlUrl = requestGn.url();
        int i4 = 0;
        while (true) {
            i4++;
            if (i4 > 21) {
                throw new ProtocolException("Too many tunnel connections attempted: 21");
            }
            X(i, i2);
            requestGn = a(i2, i3, requestGn, httpUrlUrl);
            if (requestGn == null) {
                return;
            }
            okhttp3.internal.c.a(this.AB);
            this.AB = null;
            this.AD = null;
            this.source = null;
        }
    }

    private void X(int i, int i2) throws IOException {
        Proxy proxy = this.AA.proxy();
        this.AB = (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.HTTP) ? this.AA.address().socketFactory().createSocket() : new Socket(proxy);
        this.AB.setSoTimeout(i2);
        try {
            okhttp3.internal.e.e.hl().a(this.AB, this.AA.socketAddress(), i);
            this.source = Okio.buffer(Okio.source(this.AB));
            this.AD = Okio.buffer(Okio.sink(this.AB));
        } catch (ConnectException e) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.AA.socketAddress());
            connectException.initCause(e);
            throw connectException;
        }
    }

    private void a(b bVar) throws Throwable {
        if (this.AA.address().sslSocketFactory() == null) {
            this.protocol = Protocol.HTTP_1_1;
            this.socket = this.AB;
            return;
        }
        b(bVar);
        if (this.protocol == Protocol.HTTP_2) {
            this.socket.setSoTimeout(0);
            this.AC = new e.a(true).a(this.socket, this.AA.address().url().host(), this.source, this.AD).a(this).gS();
            this.AC.start();
        }
    }

    private void b(b bVar) throws Throwable {
        SSLSocket sSLSocket;
        Address address = this.AA.address();
        try {
            try {
                sSLSocket = (SSLSocket) address.sslSocketFactory().createSocket(this.AB, address.url().host(), address.url().port(), true);
                try {
                    ConnectionSpec connectionSpecA = bVar.a(sSLSocket);
                    if (connectionSpecA.supportsTlsExtensions()) {
                        okhttp3.internal.e.e.hl().a(sSLSocket, address.url().host(), address.protocols());
                    }
                    sSLSocket.startHandshake();
                    Handshake handshake = Handshake.get(sSLSocket.getSession());
                    if (!address.hostnameVerifier().verify(address.url().host(), sSLSocket.getSession())) {
                        X509Certificate x509Certificate = (X509Certificate) handshake.peerCertificates().get(0);
                        throw new SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified:\n    certificate: " + CertificatePinner.pin(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + okhttp3.internal.f.d.a(x509Certificate));
                    }
                    address.certificatePinner().check(address.url().host(), handshake.peerCertificates());
                    String strC = connectionSpecA.supportsTlsExtensions() ? okhttp3.internal.e.e.hl().c(sSLSocket) : null;
                    this.socket = sSLSocket;
                    this.source = Okio.buffer(Okio.source(this.socket));
                    this.AD = Okio.buffer(Okio.sink(this.socket));
                    this.handshake = handshake;
                    this.protocol = strC != null ? Protocol.get(strC) : Protocol.HTTP_1_1;
                    if (sSLSocket != null) {
                        okhttp3.internal.e.e.hl().d(sSLSocket);
                    }
                } catch (AssertionError e) {
                    e = e;
                    if (!okhttp3.internal.c.a(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    if (sSLSocket != null) {
                        okhttp3.internal.e.e.hl().d(sSLSocket);
                    }
                    okhttp3.internal.c.a(sSLSocket);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                sSLSocket = null;
            }
        } catch (AssertionError e2) {
            e = e2;
        }
    }

    private Request a(int i, int i2, Request request, HttpUrl httpUrl) throws IOException {
        String str = "CONNECT " + okhttp3.internal.c.a(httpUrl, true) + " HTTP/1.1";
        while (true) {
            okhttp3.internal.c.a aVar = new okhttp3.internal.c.a(null, null, this.source, this.AD);
            this.source.getTimeout().timeout(i, TimeUnit.MILLISECONDS);
            this.AD.getTimeout().timeout(i2, TimeUnit.MILLISECONDS);
            aVar.b(request.headers(), str);
            aVar.gC();
            Response responseBuild = aVar.I(false).request(request).build();
            long jC = okhttp3.internal.b.e.c(responseBuild);
            if (jC == -1) {
                jC = 0;
            }
            Source sourceL = aVar.l(jC);
            okhttp3.internal.c.a(sourceL, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            sourceL.close();
            int iCode = responseBuild.code();
            if (iCode == 200) {
                if (this.source.getBufferField().exhausted() && this.AD.getBufferField().exhausted()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (iCode == 407) {
                Request requestAuthenticate = this.AA.address().proxyAuthenticator().authenticate(this.AA, responseBuild);
                if (requestAuthenticate == null) {
                    throw new IOException("Failed to authenticate with proxy");
                }
                if ("close".equalsIgnoreCase(responseBuild.header("Connection"))) {
                    return requestAuthenticate;
                }
                request = requestAuthenticate;
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + responseBuild.code());
            }
        }
    }

    private Request gn() {
        return new Request.Builder().url(this.AA.address().url()).header("Host", okhttp3.internal.c.a(this.AA.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", okhttp3.internal.d.fW()).build();
    }

    public final boolean a(Address address) {
        return this.AG.size() < this.AF && address.equals(getRoute().address()) && !this.AE;
    }

    public final okhttp3.internal.b.c a(OkHttpClient okHttpClient, f fVar) throws SocketException {
        okhttp3.internal.http2.e eVar = this.AC;
        if (eVar != null) {
            return new okhttp3.internal.http2.d(okHttpClient, fVar, eVar);
        }
        this.socket.setSoTimeout(okHttpClient.readTimeoutMillis());
        this.source.getTimeout().timeout(okHttpClient.readTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.AD.getTimeout().timeout(okHttpClient.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        return new okhttp3.internal.c.a(okHttpClient, fVar, this.source, this.AD);
    }

    public final a.e a(f fVar) {
        return new a.e(true, this.source, this.AD, fVar) { // from class: okhttp3.internal.connection.c.1
            final /* synthetic */ f AJ;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(true, bufferedSource, bufferedSink);
                this.AJ = fVar;
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                f fVar2 = this.AJ;
                fVar2.a(true, fVar2.gw());
            }
        };
    }

    @Override // okhttp3.Connection
    /* renamed from: route */
    public final Route getRoute() {
        return this.AA;
    }

    public final void cancel() throws IOException {
        okhttp3.internal.c.a(this.AB);
    }

    @Override // okhttp3.Connection
    public final Socket socket() {
        return this.socket;
    }

    public final boolean H(boolean z) throws SocketException {
        if (this.socket.isClosed() || this.socket.isInputShutdown() || this.socket.isOutputShutdown()) {
            return false;
        }
        okhttp3.internal.http2.e eVar = this.AC;
        if (eVar != null) {
            return !eVar.isShutdown();
        }
        if (z) {
            try {
                int soTimeout = this.socket.getSoTimeout();
                try {
                    this.socket.setSoTimeout(1);
                    return !this.source.exhausted();
                } finally {
                    this.socket.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // okhttp3.internal.http2.e.b
    public final void a(g gVar) {
        gVar.b(ErrorCode.REFUSED_STREAM);
    }

    @Override // okhttp3.internal.http2.e.b
    public final void a(okhttp3.internal.http2.e eVar) {
        synchronized (this.connectionPool) {
            this.AF = eVar.gR();
        }
    }

    @Override // okhttp3.Connection
    /* renamed from: handshake */
    public final Handshake getHandshake() {
        return this.handshake;
    }

    public final boolean go() {
        return this.AC != null;
    }

    @Override // okhttp3.Connection
    public final Protocol protocol() {
        return this.protocol;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Connection{");
        sb.append(this.AA.address().url().host());
        sb.append(":");
        sb.append(this.AA.address().url().port());
        sb.append(", proxy=");
        sb.append(this.AA.proxy());
        sb.append(" hostAddress=");
        sb.append(this.AA.socketAddress());
        sb.append(" cipherSuite=");
        Handshake handshake = this.handshake;
        sb.append(handshake != null ? handshake.cipherSuite() : "none");
        sb.append(" protocol=");
        sb.append(this.protocol);
        sb.append('}');
        return sb.toString();
    }
}

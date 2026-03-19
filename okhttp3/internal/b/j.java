package okhttp3.internal.b;

import com.just.agentweb.AgentWebPermissions;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class j implements Interceptor {
    private Object AT;
    private volatile boolean AY;
    private okhttp3.internal.connection.f Bd;
    private final OkHttpClient client;
    private final boolean forWebSocket;

    public j(OkHttpClient okHttpClient, boolean z) {
        this.client = okHttpClient;
        this.forWebSocket = z;
    }

    public final void cancel() {
        this.AY = true;
        okhttp3.internal.connection.f fVar = this.Bd;
        if (fVar != null) {
            fVar.cancel();
        }
    }

    public final boolean isCanceled() {
        return this.AY;
    }

    public final void q(Object obj) {
        this.AT = obj;
    }

    public final okhttp3.internal.connection.f streamAllocation() {
        return this.Bd;
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        this.Bd = new okhttp3.internal.connection.f(this.client.connectionPool(), c(request.url()), this.AT);
        Response response = null;
        int i = 0;
        while (!this.AY) {
            try {
                try {
                    Response responseA = ((g) chain).a(request, this.Bd, null, null);
                    if (response != null) {
                        responseA = responseA.newBuilder().priorResponse(response.newBuilder().body(null).build()).build();
                    }
                    response = responseA;
                    request = h(response);
                } catch (IOException e) {
                    if (!a(e, !(e instanceof ConnectionShutdownException), request)) {
                        throw e;
                    }
                } catch (RouteException e2) {
                    if (!a(e2.getLastConnectException(), false, request)) {
                        throw e2.getLastConnectException();
                    }
                }
                if (request == null) {
                    if (!this.forWebSocket) {
                        this.Bd.release();
                    }
                    return response;
                }
                okhttp3.internal.c.closeQuietly(response.body());
                i++;
                if (i > 20) {
                    this.Bd.release();
                    throw new ProtocolException("Too many follow-up requests: " + i);
                }
                if (request.body() instanceof l) {
                    this.Bd.release();
                    throw new HttpRetryException("Cannot retry streamed HTTP body", response.code());
                }
                if (!a(response, request.url())) {
                    this.Bd.release();
                    this.Bd = new okhttp3.internal.connection.f(this.client.connectionPool(), c(request.url()), this.AT);
                } else if (this.Bd.gw() != null) {
                    throw new IllegalStateException("Closing the body of " + response + " didn't close its backing stream. Bad interceptor?");
                }
            } catch (Throwable th) {
                this.Bd.b((IOException) null);
                this.Bd.release();
                throw th;
            }
        }
        this.Bd.release();
        throw new IOException("Canceled");
    }

    private Address c(HttpUrl httpUrl) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        if (httpUrl.getIsHttps()) {
            SSLSocketFactory sslSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            sSLSocketFactory = sslSocketFactory;
            certificatePinner = this.client.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(httpUrl.host(), httpUrl.port(), this.client.dns(), this.client.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }

    private boolean a(IOException iOException, boolean z, Request request) throws IOException {
        this.Bd.b(iOException);
        if (this.client.retryOnConnectionFailure()) {
            return !(z && (request.body() instanceof l)) && a(iOException, z) && this.Bd.gA();
        }
        return false;
    }

    private static boolean a(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private Request h(Response response) throws ProtocolException {
        String strHeader;
        HttpUrl httpUrlResolve;
        Proxy proxy;
        if (response == null) {
            throw new IllegalStateException();
        }
        okhttp3.internal.connection.c cVarGy = this.Bd.gy();
        Route route = cVarGy != null ? cVarGy.getRoute() : null;
        int iCode = response.code();
        String strMethod = response.request().method();
        if (iCode == 307 || iCode == 308) {
            if (!strMethod.equals("GET") && !strMethod.equals("HEAD")) {
                return null;
            }
        } else {
            if (iCode == 401) {
                return this.client.authenticator().authenticate(route, response);
            }
            if (iCode == 407) {
                if (route != null) {
                    proxy = route.proxy();
                } else {
                    proxy = this.client.proxy();
                }
                if (proxy.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                return this.client.proxyAuthenticator().authenticate(route, response);
            }
            if (iCode == 408) {
                if (response.request().body() instanceof l) {
                    return null;
                }
                return response.request();
            }
            switch (iCode) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        if (!this.client.followRedirects() || (strHeader = response.header(AgentWebPermissions.ACTION_LOCATION)) == null || (httpUrlResolve = response.request().url().resolve(strHeader)) == null) {
            return null;
        }
        if (!httpUrlResolve.scheme().equals(response.request().url().scheme()) && !this.client.followSslRedirects()) {
            return null;
        }
        Request.Builder builderNewBuilder = response.request().newBuilder();
        if (f.A(strMethod)) {
            boolean zB = f.B(strMethod);
            if (f.C(strMethod)) {
                builderNewBuilder.method("GET", null);
            } else {
                builderNewBuilder.method(strMethod, zB ? response.request().body() : null);
            }
            if (!zB) {
                builderNewBuilder.removeHeader("Transfer-Encoding");
                builderNewBuilder.removeHeader("Content-Length");
                builderNewBuilder.removeHeader("Content-Type");
            }
        }
        if (!a(response, httpUrlResolve)) {
            builderNewBuilder.removeHeader("Authorization");
        }
        return builderNewBuilder.url(httpUrlResolve).build();
    }

    private static boolean a(Response response, HttpUrl httpUrl) {
        HttpUrl httpUrlUrl = response.request().url();
        return httpUrlUrl.host().equals(httpUrl.host()) && httpUrlUrl.port() == httpUrl.port() && httpUrlUrl.scheme().equals(httpUrl.scheme());
    }
}

package okhttp3.internal.b;

import java.io.IOException;
import java.util.List;
import okhttp3.Connection;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class g implements Interceptor.Chain {
    private final okhttp3.internal.connection.f Bd;
    private final c Be;
    private final Connection Bf;
    private int Bg;
    private final int index;
    private final List<Interceptor> interceptors;
    private final Request request;

    public g(List<Interceptor> list, okhttp3.internal.connection.f fVar, c cVar, Connection connection, int i, Request request) {
        this.interceptors = list;
        this.Bf = connection;
        this.Bd = fVar;
        this.Be = cVar;
        this.index = i;
        this.request = request;
    }

    @Override // okhttp3.Interceptor.Chain
    public final Connection connection() {
        return this.Bf;
    }

    public final okhttp3.internal.connection.f streamAllocation() {
        return this.Bd;
    }

    public final c gE() {
        return this.Be;
    }

    @Override // okhttp3.Interceptor.Chain
    public final Request request() {
        return this.request;
    }

    @Override // okhttp3.Interceptor.Chain
    public final Response proceed(Request request) {
        return a(request, this.Bd, this.Be, this.Bf);
    }

    public final Response a(Request request, okhttp3.internal.connection.f fVar, c cVar, Connection connection) throws IOException {
        if (this.index >= this.interceptors.size()) {
            throw new AssertionError();
        }
        this.Bg++;
        if (this.Be != null && !a(request.url())) {
            throw new IllegalStateException("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port");
        }
        if (this.Be != null && this.Bg > 1) {
            throw new IllegalStateException("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once");
        }
        g gVar = new g(this.interceptors, fVar, cVar, connection, this.index + 1, request);
        Interceptor interceptor = this.interceptors.get(this.index);
        Response responseIntercept = interceptor.intercept(gVar);
        if (cVar != null && this.index + 1 < this.interceptors.size() && gVar.Bg != 1) {
            throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
        }
        if (responseIntercept != null) {
            return responseIntercept;
        }
        throw new NullPointerException("interceptor " + interceptor + " returned null");
    }

    private boolean a(HttpUrl httpUrl) {
        return httpUrl.host().equals(this.Bf.getRoute().address().url().host()) && httpUrl.port() == this.Bf.getRoute().address().url().port();
    }
}

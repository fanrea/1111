package okhttp3.internal.a;

import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.a.c;
import okhttp3.internal.b.h;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class a implements Interceptor {
    final f zI;

    public a(f fVar) {
        this.zI = fVar;
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) throws NumberFormatException, IOException {
        f fVar = this.zI;
        Response response = fVar != null ? fVar.get(chain.request()) : null;
        c cVarFX = new c.a(System.currentTimeMillis(), chain.request(), response).fX();
        Request request = cVarFX.zN;
        Response response2 = cVarFX.cacheResponse;
        f fVar2 = this.zI;
        if (fVar2 != null) {
            fVar2.trackResponse(cVarFX);
        }
        if (response != null && response2 == null) {
            okhttp3.internal.c.closeQuietly(response.body());
        }
        if (request == null && response2 == null) {
            return new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(okhttp3.internal.c.zu).sentRequestAtMillis(-1L).receivedResponseAtMillis(System.currentTimeMillis()).build();
        }
        if (request == null) {
            return response2.newBuilder().cacheResponse(a(response2)).build();
        }
        try {
            Response responseProceed = chain.proceed(request);
            if (responseProceed == null && response != null) {
            }
            if (response2 != null) {
                if (responseProceed.code() == 304) {
                    Response responseBuild = response2.newBuilder().headers(a(response2.headers(), responseProceed.headers())).sentRequestAtMillis(responseProceed.sentRequestAtMillis()).receivedResponseAtMillis(responseProceed.receivedResponseAtMillis()).cacheResponse(a(response2)).networkResponse(a(responseProceed)).build();
                    responseProceed.body().close();
                    this.zI.trackConditionalCacheHit();
                    this.zI.update(response2, responseBuild);
                    return responseBuild;
                }
                okhttp3.internal.c.closeQuietly(response2.body());
            }
            Response responseBuild2 = responseProceed.newBuilder().cacheResponse(a(response2)).networkResponse(a(responseProceed)).build();
            return okhttp3.internal.b.e.g(responseBuild2) ? a(a(responseBuild2, responseProceed.request(), this.zI), responseBuild2) : responseBuild2;
        } finally {
            if (response != null) {
                okhttp3.internal.c.closeQuietly(response.body());
            }
        }
    }

    private static Response a(Response response) {
        return (response == null || response.body() == null) ? response : response.newBuilder().body(null).build();
    }

    private static b a(Response response, Request request, f fVar) {
        if (fVar == null) {
            return null;
        }
        if (!c.a(response, request)) {
            if (okhttp3.internal.b.f.y(request.method())) {
                try {
                    fVar.remove(request);
                } catch (IOException unused) {
                }
            }
            return null;
        }
        return fVar.put(response);
    }

    private Response a(final b bVar, Response response) {
        Sink sinkBody;
        if (bVar == null || (sinkBody = bVar.body()) == null) {
            return response;
        }
        final BufferedSource source = response.body().getSource();
        final BufferedSink bufferedSinkBuffer = Okio.buffer(sinkBody);
        return response.newBuilder().body(new h(response.headers(), Okio.buffer(new Source() { // from class: okhttp3.internal.a.a.1
        }))).build();
    }

    private static Headers a(Headers headers, Headers headers2) {
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String strName = headers.name(i);
            String strValue = headers.value(i);
            if ((!"Warning".equalsIgnoreCase(strName) || !strValue.startsWith("1")) && (!p(strName) || headers2.get(strName) == null)) {
                okhttp3.internal.a.instance.addLenient(builder, strName, strValue);
            }
        }
        int size2 = headers2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            String strName2 = headers2.name(i2);
            if (!"Content-Length".equalsIgnoreCase(strName2) && p(strName2)) {
                okhttp3.internal.a.instance.addLenient(builder, strName2, headers2.value(i2));
            }
        }
        return builder.build();
    }

    private static boolean p(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }
}

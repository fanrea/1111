package okhttp3.internal.b;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okio.BufferedSink;
import okio.Okio;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class b implements Interceptor {
    private final boolean forWebSocket;

    public b(boolean z) {
        this.forWebSocket = z;
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) throws IOException {
        Response responseBuild;
        g gVar = (g) chain;
        c cVarGE = gVar.gE();
        okhttp3.internal.connection.f fVarStreamAllocation = gVar.streamAllocation();
        Request request = chain.request();
        long jCurrentTimeMillis = System.currentTimeMillis();
        cVarGE.b(request);
        Response.Builder builderI = null;
        if (f.A(request.method()) && request.body() != null) {
            if ("100-continue".equalsIgnoreCase(request.header("Expect"))) {
                cVarGE.gB();
                builderI = cVarGE.I(true);
            }
            if (builderI == null) {
                BufferedSink bufferedSinkBuffer = Okio.buffer(cVarGE.a(request, request.body().contentLength()));
                request.body().writeTo(bufferedSinkBuffer);
                bufferedSinkBuffer.close();
            }
        }
        cVarGE.gC();
        if (builderI == null) {
            builderI = cVarGE.I(false);
        }
        Response responseBuild2 = builderI.request(request).handshake(fVarStreamAllocation.gy().getHandshake()).sentRequestAtMillis(jCurrentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
        int iCode = responseBuild2.code();
        if (this.forWebSocket && iCode == 101) {
            responseBuild = responseBuild2.newBuilder().body(okhttp3.internal.c.zu).build();
        } else {
            responseBuild = responseBuild2.newBuilder().body(cVarGE.b(responseBuild2)).build();
        }
        if ("close".equalsIgnoreCase(responseBuild.request().header("Connection")) || "close".equalsIgnoreCase(responseBuild.header("Connection"))) {
            fVarStreamAllocation.gz();
        }
        if ((iCode != 204 && iCode != 205) || responseBuild.body().getContentLength() <= 0) {
            return responseBuild;
        }
        throw new ProtocolException("HTTP " + iCode + " had non-zero Content-Length: " + responseBuild.body().getContentLength());
    }
}

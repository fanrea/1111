package okhttp3.internal.http2;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class d implements okhttp3.internal.b.c {
    private static final ByteString BM = ByteString.encodeUtf8("connection");
    private static final ByteString BN = ByteString.encodeUtf8("host");
    private static final ByteString BO = ByteString.encodeUtf8("keep-alive");
    private static final ByteString BP = ByteString.encodeUtf8("proxy-connection");
    private static final ByteString BQ = ByteString.encodeUtf8("transfer-encoding");
    private static final ByteString BR = ByteString.encodeUtf8("te");
    private static final ByteString BS = ByteString.encodeUtf8("encoding");
    private static final ByteString BT = ByteString.encodeUtf8("upgrade");
    private static final List<ByteString> BU = okhttp3.internal.c.b(BM, BN, BO, BP, BR, BQ, BS, BT, okhttp3.internal.http2.a.Bo, okhttp3.internal.http2.a.Bp, okhttp3.internal.http2.a.Bq, okhttp3.internal.http2.a.Br);
    private static final List<ByteString> BV = okhttp3.internal.c.b(BM, BN, BO, BP, BR, BQ, BS, BT);
    private final e BW;
    private g BX;
    final okhttp3.internal.connection.f Bd;
    private final OkHttpClient client;

    public d(OkHttpClient okHttpClient, okhttp3.internal.connection.f fVar, e eVar) {
        this.client = okHttpClient;
        this.Bd = fVar;
        this.BW = eVar;
    }

    @Override // okhttp3.internal.b.c
    public final Sink a(Request request, long j) {
        return this.BX.gY();
    }

    @Override // okhttp3.internal.b.c
    public final void b(Request request) {
        if (this.BX != null) {
            return;
        }
        this.BX = this.BW.a(c(request), request.body() != null);
        this.BX.gV().timeout(this.client.readTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.BX.gW().timeout(this.client.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    @Override // okhttp3.internal.b.c
    public final void gB() {
        this.BW.flush();
    }

    @Override // okhttp3.internal.b.c
    public final void gC() throws IOException {
        this.BX.gY().close();
    }

    @Override // okhttp3.internal.b.c
    public final Response.Builder I(boolean z) throws ProtocolException, NumberFormatException {
        Response.Builder builderJ = j(this.BX.gU());
        if (z && okhttp3.internal.a.instance.code(builderJ) == 100) {
            return null;
        }
        return builderJ;
    }

    private static List<okhttp3.internal.http2.a> c(Request request) {
        Headers headers = request.headers();
        ArrayList arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new okhttp3.internal.http2.a(okhttp3.internal.http2.a.Bo, request.method()));
        arrayList.add(new okhttp3.internal.http2.a(okhttp3.internal.http2.a.Bp, okhttp3.internal.b.i.b(request.url())));
        String strHeader = request.header("Host");
        if (strHeader != null) {
            arrayList.add(new okhttp3.internal.http2.a(okhttp3.internal.http2.a.Br, strHeader));
        }
        arrayList.add(new okhttp3.internal.http2.a(okhttp3.internal.http2.a.Bq, request.url().scheme()));
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            ByteString byteStringEncodeUtf8 = ByteString.encodeUtf8(headers.name(i).toLowerCase(Locale.US));
            if (!BU.contains(byteStringEncodeUtf8)) {
                arrayList.add(new okhttp3.internal.http2.a(byteStringEncodeUtf8, headers.value(i)));
            }
        }
        return arrayList;
    }

    private static Response.Builder j(List<okhttp3.internal.http2.a> list) throws ProtocolException, NumberFormatException {
        Headers.Builder builder = new Headers.Builder();
        int size = list.size();
        Headers.Builder builder2 = builder;
        okhttp3.internal.b.k kVarD = null;
        for (int i = 0; i < size; i++) {
            okhttp3.internal.http2.a aVar = list.get(i);
            if (aVar == null) {
                if (kVarD != null && kVarD.code == 100) {
                    builder2 = new Headers.Builder();
                    kVarD = null;
                }
            } else {
                ByteString byteString = aVar.Bs;
                String strUtf8 = aVar.Bt.utf8();
                if (byteString.equals(okhttp3.internal.http2.a.Bn)) {
                    kVarD = okhttp3.internal.b.k.D("HTTP/1.1 " + strUtf8);
                } else if (!BV.contains(byteString)) {
                    okhttp3.internal.a.instance.addLenient(builder2, byteString.utf8(), strUtf8);
                }
            }
        }
        if (kVarD == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        return new Response.Builder().protocol(Protocol.HTTP_2).code(kVarD.code).message(kVarD.message).headers(builder2.build());
    }

    @Override // okhttp3.internal.b.c
    public final ResponseBody b(Response response) {
        return new okhttp3.internal.b.h(response.headers(), Okio.buffer(new a(this.BX.gX())));
    }

    @Override // okhttp3.internal.b.c
    public final void cancel() {
        g gVar = this.BX;
        if (gVar != null) {
            gVar.c(ErrorCode.CANCEL);
        }
    }

    class a extends ForwardingSource {
        public a(Source source) {
            super(source);
        }
    }
}

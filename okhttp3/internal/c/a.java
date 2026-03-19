package okhttp3.internal.c;

import java.io.EOFException;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.b.h;
import okhttp3.internal.b.i;
import okhttp3.internal.b.k;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class a implements okhttp3.internal.b.c {
    final BufferedSink AD;
    final okhttp3.internal.connection.f Bd;
    final OkHttpClient client;
    final BufferedSource source;
    int state = 0;

    public a(OkHttpClient okHttpClient, okhttp3.internal.connection.f fVar, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.client = okHttpClient;
        this.Bd = fVar;
        this.source = bufferedSource;
        this.AD = bufferedSink;
    }

    @Override // okhttp3.internal.b.c
    public final Sink a(Request request, long j) {
        if ("chunked".equalsIgnoreCase(request.header("Transfer-Encoding"))) {
            return gG();
        }
        if (j != -1) {
            return k(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // okhttp3.internal.b.c
    public final void cancel() throws IOException {
        okhttp3.internal.connection.c cVarGy = this.Bd.gy();
        if (cVarGy != null) {
            cVarGy.cancel();
        }
    }

    @Override // okhttp3.internal.b.c
    public final void b(Request request) {
        b(request.headers(), i.a(request, this.Bd.gy().getRoute().proxy().type()));
    }

    @Override // okhttp3.internal.b.c
    public final ResponseBody b(Response response) {
        return new h(response.headers(), Okio.buffer(i(response)));
    }

    private Source i(Response response) {
        if (!okhttp3.internal.b.e.g(response)) {
            return l(0L);
        }
        if ("chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return d(response.request().url());
        }
        long jC = okhttp3.internal.b.e.c(response);
        if (jC != -1) {
            return l(jC);
        }
        return gH();
    }

    @Override // okhttp3.internal.b.c
    public final void gB() throws IOException {
        this.AD.flush();
    }

    @Override // okhttp3.internal.b.c
    public final void gC() {
        this.AD.flush();
    }

    public final void b(Headers headers, String str) {
        if (this.state != 0) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.AD.writeUtf8(str).writeUtf8("\r\n");
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            this.AD.writeUtf8(headers.name(i)).writeUtf8(": ").writeUtf8(headers.value(i)).writeUtf8("\r\n");
        }
        this.AD.writeUtf8("\r\n");
        this.state = 1;
    }

    @Override // okhttp3.internal.b.c
    public final Response.Builder I(boolean z) throws NumberFormatException, IOException {
        int i = this.state;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.state);
        }
        try {
            k kVarD = k.D(this.source.readUtf8LineStrict());
            Response.Builder builderHeaders = new Response.Builder().protocol(kVarD.protocol).code(kVarD.code).message(kVarD.message).headers(gF());
            if (z && kVarD.code == 100) {
                return null;
            }
            this.state = 4;
            return builderHeaders;
        } catch (EOFException e2) {
            IOException iOException = new IOException("unexpected end of stream on " + this.Bd);
            iOException.initCause(e2);
            throw iOException;
        }
    }

    private Headers gF() throws IOException {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String utf8LineStrict = this.source.readUtf8LineStrict();
            if (utf8LineStrict.length() != 0) {
                okhttp3.internal.a.instance.addLenient(builder, utf8LineStrict);
            } else {
                return builder.build();
            }
        }
    }

    private Sink gG() {
        if (this.state != 1) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.state = 2;
        return new b();
    }

    private Sink k(long j) {
        if (this.state != 1) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.state = 2;
        return new d(j);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [okhttp3.internal.c.a$e, okio.Source] */
    public final Source l(long j) {
        if (this.state != 4) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.state = 5;
        return new e(j);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [okhttp3.internal.c.a$c, okio.Source] */
    private Source d(HttpUrl httpUrl) {
        if (this.state != 4) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.state = 5;
        return new c(httpUrl);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [okhttp3.internal.c.a$f, okio.Source] */
    private Source gH() throws IOException {
        if (this.state != 4) {
            throw new IllegalStateException("state: " + this.state);
        }
        okhttp3.internal.connection.f fVar = this.Bd;
        if (fVar == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.state = 5;
        fVar.gz();
        return new f();
    }

    static void a(ForwardingTimeout forwardingTimeout) {
        Timeout delegate = forwardingTimeout.getDelegate();
        forwardingTimeout.setDelegate(Timeout.NONE);
        delegate.clearDeadline();
        delegate.clearTimeout();
    }

    final class d implements Sink {
        private final ForwardingTimeout Bh;
        private long Bl;

        d(long j) {
            this.Bh = new ForwardingTimeout(a.this.AD.getTimeout());
            this.Bl = j;
        }
    }

    final class b implements Sink {
        private final ForwardingTimeout Bh;

        b() {
            this.Bh = new ForwardingTimeout(a.this.AD.getTimeout());
        }
    }

    /* renamed from: okhttp3.internal.c.a$a, reason: collision with other inner class name */
    abstract class AbstractC0852a {
        protected final ForwardingTimeout Bh;

        private AbstractC0852a() {
            this.Bh = new ForwardingTimeout(a.this.source.getTimeout());
        }

        /* synthetic */ AbstractC0852a(a aVar, byte b) {
            this();
        }

        protected final void J(boolean z) {
            if (a.this.state == 6) {
                return;
            }
            if (a.this.state != 5) {
                throw new IllegalStateException("state: " + a.this.state);
            }
            a.a(this.Bh);
            a aVar = a.this;
            aVar.state = 6;
            if (aVar.Bd != null) {
                a.this.Bd.a(false, (okhttp3.internal.b.c) a.this);
            }
        }
    }

    class e extends AbstractC0852a {
        private long Bl;

        public e(long j) {
            super(a.this, (byte) 0);
            this.Bl = j;
            if (this.Bl == 0) {
                J(true);
            }
        }
    }

    class c extends AbstractC0852a {
        private long Bj;
        private boolean Bk;
        private final HttpUrl url;

        c(HttpUrl httpUrl) {
            super(a.this, (byte) 0);
            this.Bj = -1L;
            this.Bk = true;
            this.url = httpUrl;
        }
    }

    class f extends AbstractC0852a {
        f() {
            super(a.this, (byte) 0);
        }
    }
}

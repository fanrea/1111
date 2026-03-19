package okhttp3.internal.g;

import com.sigmob.sdk.base.mta.PointType;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.connection.f;
import okhttp3.internal.g.c;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class a implements WebSocket, c.a {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final List<Protocol> DT = Collections.singletonList(Protocol.HTTP_1_1);
    final WebSocketListener DU;
    private final Random DV;
    private Call DW;
    private final Runnable DX;
    private okhttp3.internal.g.c DY;
    private okhttp3.internal.g.d DZ;
    private e Ea;
    private long Ed;
    private boolean Ee;
    private ScheduledFuture<?> Ef;
    private String Eh;
    private boolean Ei;
    int Ej;
    int Ek;
    private ScheduledExecutorService executor;
    private final String key;
    private final Request originalRequest;
    private final ArrayDeque<ByteString> Eb = new ArrayDeque<>();
    private final ArrayDeque<Object> Ec = new ArrayDeque<>();
    private int Eg = -1;

    public a(Request request, WebSocketListener webSocketListener, Random random) {
        if (!"GET".equals(request.method())) {
            throw new IllegalArgumentException("Request must be GET: " + request.method());
        }
        this.originalRequest = request;
        this.DU = webSocketListener;
        this.DV = random;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.key = ByteString.of(bArr).base64();
        this.DX = new Runnable() { // from class: okhttp3.internal.g.a.1
            @Override // java.lang.Runnable
            public final void run() {
                do {
                    try {
                    } catch (IOException e2) {
                        a.this.a(e2, (Response) null);
                        return;
                    }
                } while (a.this.hw());
            }
        };
    }

    @Override // okhttp3.WebSocket
    /* renamed from: request */
    public final Request getOriginalRequest() {
        return this.originalRequest;
    }

    @Override // okhttp3.WebSocket
    public final synchronized long queueSize() {
        return this.Ed;
    }

    @Override // okhttp3.WebSocket
    public final void cancel() {
        this.DW.cancel();
    }

    public final void a(OkHttpClient okHttpClient) {
        OkHttpClient okHttpClientBuild = okHttpClient.newBuilder().protocols(DT).build();
        final int iPingIntervalMillis = okHttpClientBuild.pingIntervalMillis();
        final Request requestBuild = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", PointType.SIGMOB_REPORT_TRACKING).build();
        this.DW = okhttp3.internal.a.instance.newWebSocketCall(okHttpClientBuild, requestBuild);
        this.DW.enqueue(new Callback() { // from class: okhttp3.internal.g.a.2
            @Override // okhttp3.Callback
            public final void onResponse(Call call, Response response) throws IOException {
                try {
                    a.this.j(response);
                    f fVarStreamAllocation = okhttp3.internal.a.instance.streamAllocation(call);
                    fVarStreamAllocation.gz();
                    e eVarA = fVarStreamAllocation.gy().a(fVarStreamAllocation);
                    try {
                        a.this.DU.onOpen(a.this, response);
                        a.this.a("OkHttp WebSocket " + requestBuild.url().redact(), iPingIntervalMillis, eVarA);
                        fVarStreamAllocation.gy().socket().setSoTimeout(0);
                        a.this.ht();
                    } catch (Exception e2) {
                        a.this.a(e2, (Response) null);
                    }
                } catch (ProtocolException e3) {
                    a.this.a(e3, response);
                    okhttp3.internal.c.closeQuietly(response);
                }
            }

            @Override // okhttp3.Callback
            public final void onFailure(Call call, IOException iOException) {
                a.this.a(iOException, (Response) null);
            }
        });
    }

    final void j(Response response) throws ProtocolException {
        if (response.code() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + " " + response.message() + "'");
        }
        String strHeader = response.header("Connection");
        if (!"Upgrade".equalsIgnoreCase(strHeader)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + strHeader + "'");
        }
        String strHeader2 = response.header("Upgrade");
        if (!"websocket".equalsIgnoreCase(strHeader2)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + strHeader2 + "'");
        }
        String strHeader3 = response.header("Sec-WebSocket-Accept");
        String strBase64 = ByteString.encodeUtf8(this.key + WebSocketProtocol.ACCEPT_MAGIC).sha1().base64();
        if (strBase64.equals(strHeader3)) {
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strBase64 + "' but was '" + strHeader3 + "'");
    }

    public final void a(String str, long j, e eVar) {
        synchronized (this) {
            this.Ea = eVar;
            this.DZ = new okhttp3.internal.g.d(eVar.BZ, eVar.AD, this.DV);
            this.executor = new ScheduledThreadPoolExecutor(1, okhttp3.internal.c.a(str, false));
            if (j != 0) {
                this.executor.scheduleAtFixedRate(new d(), j, j, TimeUnit.MILLISECONDS);
            }
            if (!this.Ec.isEmpty()) {
                hv();
            }
        }
        this.DY = new okhttp3.internal.g.c(eVar.BZ, eVar.source, this);
    }

    public final void ht() throws IOException {
        while (this.Eg == -1) {
            this.DY.hy();
        }
    }

    @Override // okhttp3.internal.g.c.a
    public final void H(String str) {
        this.DU.onMessage(this, str);
    }

    @Override // okhttp3.internal.g.c.a
    public final void d(ByteString byteString) {
        this.DU.onMessage(this, byteString);
    }

    @Override // okhttp3.internal.g.c.a
    public final synchronized void e(ByteString byteString) {
        if (!this.Ei && (!this.Ee || !this.Ec.isEmpty())) {
            this.Eb.add(byteString);
            hv();
            this.Ej++;
        }
    }

    @Override // okhttp3.internal.g.c.a
    public final synchronized void hu() {
        this.Ek++;
    }

    @Override // okhttp3.internal.g.c.a
    public final void b(int i, String str) {
        e eVar;
        if (i == -1) {
            throw new IllegalArgumentException();
        }
        synchronized (this) {
            if (this.Eg != -1) {
                throw new IllegalStateException("already closed");
            }
            this.Eg = i;
            this.Eh = str;
            if (this.Ee && this.Ec.isEmpty()) {
                eVar = this.Ea;
                this.Ea = null;
                if (this.Ef != null) {
                    this.Ef.cancel(false);
                }
                this.executor.shutdown();
            } else {
                eVar = null;
            }
        }
        try {
            this.DU.onClosing(this, i, str);
            if (eVar != null) {
                this.DU.onClosed(this, i, str);
            }
        } finally {
            okhttp3.internal.c.closeQuietly(eVar);
        }
    }

    @Override // okhttp3.WebSocket
    public final boolean send(String str) {
        if (str == null) {
            throw new NullPointerException("text == null");
        }
        return a(ByteString.encodeUtf8(str), 1);
    }

    @Override // okhttp3.WebSocket
    public final boolean send(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException("bytes == null");
        }
        return a(byteString, 2);
    }

    private synchronized boolean a(ByteString byteString, int i) {
        if (!this.Ei && !this.Ee) {
            if (this.Ed + byteString.size() > 16777216) {
                close(1001, null);
                return false;
            }
            this.Ed += byteString.size();
            this.Ec.add(new c(i, byteString));
            hv();
            return true;
        }
        return false;
    }

    @Override // okhttp3.WebSocket
    public final boolean close(int i, String str) {
        return a(i, str, 60000L);
    }

    private synchronized boolean a(int i, String str, long j) {
        okhttp3.internal.g.b.bK(i);
        ByteString byteStringEncodeUtf8 = null;
        if (str != null) {
            byteStringEncodeUtf8 = ByteString.encodeUtf8(str);
            if (byteStringEncodeUtf8.size() > 123) {
                throw new IllegalArgumentException("reason.size() > 123: " + str);
            }
        }
        if (!this.Ei && !this.Ee) {
            this.Ee = true;
            this.Ec.add(new b(i, byteStringEncodeUtf8, 60000L));
            hv();
            return true;
        }
        return false;
    }

    private void hv() {
        ScheduledExecutorService scheduledExecutorService = this.executor;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(this.DX);
        }
    }

    final boolean hw() {
        Object objPoll;
        String str;
        synchronized (this) {
            int i = 0;
            if (this.Ei) {
                return false;
            }
            okhttp3.internal.g.d dVar = this.DZ;
            ByteString byteStringPoll = this.Eb.poll();
            e eVar = null;
            if (byteStringPoll == null) {
                objPoll = this.Ec.poll();
                if (objPoll instanceof b) {
                    i = this.Eg;
                    str = this.Eh;
                    if (i != -1) {
                        e eVar2 = this.Ea;
                        this.Ea = null;
                        this.executor.shutdown();
                        eVar = eVar2;
                    } else {
                        this.Ef = this.executor.schedule(new RunnableC0854a(), ((b) objPoll).Ep, TimeUnit.MILLISECONDS);
                    }
                } else {
                    if (objPoll == null) {
                        return false;
                    }
                    str = null;
                }
            } else {
                objPoll = null;
                str = null;
            }
            try {
                if (byteStringPoll != null) {
                    dVar.g(byteStringPoll);
                } else if (objPoll instanceof c) {
                    ByteString byteString = ((c) objPoll).Er;
                    BufferedSink bufferedSinkBuffer = Okio.buffer(dVar.e(((c) objPoll).Eq, byteString.size()));
                    bufferedSinkBuffer.write(byteString);
                    bufferedSinkBuffer.close();
                    synchronized (this) {
                        this.Ed -= byteString.size();
                    }
                } else if (objPoll instanceof b) {
                    b bVar = (b) objPoll;
                    dVar.b(bVar.code, bVar.Eo);
                    if (eVar != null) {
                        this.DU.onClosed(this, i, str);
                    }
                } else {
                    throw new AssertionError();
                }
                okhttp3.internal.c.closeQuietly(eVar);
                return true;
            } catch (Throwable th) {
                okhttp3.internal.c.closeQuietly(eVar);
                throw th;
            }
        }
    }

    final class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.hx();
        }
    }

    final void hx() {
        synchronized (this) {
            if (this.Ei) {
                return;
            }
            okhttp3.internal.g.d dVar = this.DZ;
            try {
                dVar.f(ByteString.EMPTY);
            } catch (IOException e2) {
                a(e2, (Response) null);
            }
        }
    }

    public final void a(Exception exc, Response response) {
        synchronized (this) {
            if (this.Ei) {
                return;
            }
            this.Ei = true;
            e eVar = this.Ea;
            this.Ea = null;
            if (this.Ef != null) {
                this.Ef.cancel(false);
            }
            if (this.executor != null) {
                this.executor.shutdown();
            }
            try {
                this.DU.onFailure(this, exc, response);
            } finally {
                okhttp3.internal.c.closeQuietly(eVar);
            }
        }
    }

    static final class c {
        final int Eq;
        final ByteString Er;

        c(int i, ByteString byteString) {
            this.Eq = i;
            this.Er = byteString;
        }
    }

    static final class b {
        final ByteString Eo;
        final long Ep;
        final int code;

        b(int i, ByteString byteString, long j) {
            this.code = i;
            this.Eo = byteString;
            this.Ep = j;
        }
    }

    public static abstract class e implements Closeable {
        public final BufferedSink AD;
        public final boolean BZ;
        public final BufferedSource source;

        public e(boolean z, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.BZ = z;
            this.source = bufferedSource;
            this.AD = bufferedSink;
        }
    }

    /* renamed from: okhttp3.internal.g.a$a, reason: collision with other inner class name */
    final class RunnableC0854a implements Runnable {
        RunnableC0854a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.cancel();
        }
    }
}

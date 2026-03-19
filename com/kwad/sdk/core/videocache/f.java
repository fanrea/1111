package com.kwad.sdk.core.videocache;

import android.content.Context;
import android.net.Uri;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.utils.ax;
import com.kwai.video.player.KsMediaMeta;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class f {
    private final Object bJi;
    private final ExecutorService bJj;
    private final Map<String, g> bJk;
    private final ServerSocket bJl;
    private final Thread bJm;
    private final com.kwad.sdk.core.videocache.c bJn;
    private final int port;

    /* synthetic */ f(com.kwad.sdk.core.videocache.c cVar, byte b2) {
        this(cVar);
    }

    private f(com.kwad.sdk.core.videocache.c cVar) throws InterruptedException {
        this.bJi = new Object();
        this.bJj = GlobalThreadPools.ack();
        this.bJk = new ConcurrentHashMap();
        this.bJn = (com.kwad.sdk.core.videocache.c) ax.checkNotNull(cVar);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.bJl = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.port = localPort;
            i.install("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new c(countDownLatch));
            this.bJm = thread;
            thread.start();
            countDownLatch.await();
        } catch (IOException | InterruptedException e) {
            this.bJj.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    public final String ga(String str) {
        return str == null ? "" : i(str, true);
    }

    private String i(String str, boolean z) {
        if (ac(str).exists()) {
            File fileAc = ac(str);
            r(fileAc);
            return Uri.fromFile(fileAc).toString();
        }
        return ge(str);
    }

    public final boolean w(String str, int i) {
        return a(str, i, null, null);
    }

    public final boolean a(String str, long j, a.C0589a c0589a, AdHttpResponseListener adHttpResponseListener) {
        com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "preloadSync preloadUrl " + str);
        if (gb(str)) {
            return true;
        }
        return com.kwad.sdk.core.network.a.a.a(ge(str), null, c0589a, j, false, adHttpResponseListener);
    }

    public final boolean gb(String str) {
        ax.aD(str, "Url can't be null!");
        return ac(str).exists();
    }

    public final boolean gc(String str) {
        ax.aD(str, "Url can't be null!");
        return gf(str).exists() || ac(str).exists();
    }

    public final boolean gd(String str) {
        g gVar = this.bJk.get(str);
        if (gVar == null) {
            return false;
        }
        gVar.shutdown();
        this.bJk.remove(str);
        return true;
    }

    private String ge(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", "127.0.0.1", Integer.valueOf(this.port), l.encode(str));
    }

    private File ac(String str) {
        return new File(this.bJn.bIT, this.bJn.bIU.gi(str));
    }

    private File gf(String str) {
        return new File(this.bJn.bIT, this.bJn.bIU.gi(str) + ".download");
    }

    private void r(File file) {
        try {
            this.bJn.bIV.s(file);
        } catch (IOException unused) {
            com.kwad.sdk.core.d.c.e("HttpProxyCacheServer", "Error touching file " + file);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acV() throws IOException {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket socketAccept = this.bJl.accept();
                com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "Accept new socket " + socketAccept);
                this.bJj.submit(new b(socketAccept));
            } catch (IOException e) {
                onError(new ProxyCacheException("Error during waiting connection", e));
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.kwad.sdk.core.videocache.f] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.lang.String] */
    public void a(Socket socket) throws IOException {
        ?? sb;
        ?? AcW = "Opened connections: ";
        try {
            try {
                d dVarC = d.c(socket.getInputStream());
                com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "Request to cache proxy:" + dVarC);
                gg(l.decode(dVarC.bJc)).a(dVarC, socket);
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            } catch (ProxyCacheException e) {
                e = e;
                onError(new ProxyCacheException("Error processing request", e));
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            } catch (SocketException e2) {
                com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "Closing socket… Socket is closed by client.");
                e2.printStackTrace();
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            } catch (IOException e3) {
                e = e3;
                onError(new ProxyCacheException("Error processing request", e));
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            }
            AcW = acW();
            socket = sb.append(AcW).toString();
            com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", (String) socket);
        } catch (Throwable th) {
            b(socket);
            com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", ((String) AcW) + acW());
            throw th;
        }
    }

    private g gg(String str) {
        g gVar;
        synchronized (this.bJi) {
            gVar = this.bJk.get(str);
            if (gVar == null) {
                gVar = new g(str, this.bJn);
                this.bJk.put(str, gVar);
            }
        }
        return gVar;
    }

    private int acW() {
        int iAcW;
        synchronized (this.bJi) {
            iAcW = 0;
            Iterator<g> it = this.bJk.values().iterator();
            while (it.hasNext()) {
                iAcW += it.next().acW();
            }
        }
        return iAcW;
    }

    private void b(Socket socket) throws IOException {
        c(socket);
        d(socket);
        e(socket);
    }

    private void c(Socket socket) throws IOException {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException unused) {
            com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "Releasing input stream… Socket is closed by client.");
        } catch (IOException e) {
            onError(new ProxyCacheException("Error closing socket input stream", e));
        }
    }

    private static void d(Socket socket) throws IOException {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException unused) {
            com.kwad.sdk.core.d.c.w("HttpProxyCacheServer", "Failed to close socket on proxy side: {}. It seems client have already closed connection.");
        }
    }

    private void e(Socket socket) throws IOException {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e) {
            onError(new ProxyCacheException("Error closing socket", e));
        }
    }

    private static void onError(Throwable th) {
        com.kwad.sdk.core.d.c.printStackTraceOnly(th);
    }

    final class c implements Runnable {
        private final CountDownLatch bJq;

        public c(CountDownLatch countDownLatch) {
            this.bJq = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.bJq.countDown();
                f.this.acV();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
            }
        }
    }

    final class b implements Runnable {
        private final Socket bJo;

        public b(Socket socket) {
            this.bJo = socket;
        }

        @Override // java.lang.Runnable
        public final void run() throws IOException {
            com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "schedule SocketProcessorRunnable run");
            f.this.a(this.bJo);
        }
    }

    public static final class a {
        private File bIT;
        private com.kwad.sdk.core.videocache.d.c bIW;
        private int bIY;
        private Context dR;
        private int bIZ = 0;
        private com.kwad.sdk.core.videocache.a.a bIV = new com.kwad.sdk.core.videocache.a.g(KsMediaMeta.AV_CH_STEREO_LEFT);
        private com.kwad.sdk.core.videocache.a.c bIU = new com.kwad.sdk.core.videocache.a.f();
        private com.kwad.sdk.core.videocache.b.b bIX = new com.kwad.sdk.core.videocache.b.a();

        public a(Context context) {
            this.dR = context;
            this.bIT = o.cg(context);
        }

        public final a bi(long j) {
            this.bIV = new com.kwad.sdk.core.videocache.a.g(KsMediaMeta.AV_CH_STEREO_LEFT);
            return this;
        }

        public final a fD(int i) {
            this.bIY = i;
            return this;
        }

        public final a fE(int i) {
            this.bIZ = i;
            return this;
        }

        public final f acX() {
            this.bIW = com.kwad.sdk.core.videocache.d.d.n(this.dR, this.bIZ);
            return new f(acY(), (byte) 0);
        }

        private com.kwad.sdk.core.videocache.c acY() {
            return new com.kwad.sdk.core.videocache.c(this.bIT, this.bIU, this.bIV, this.bIW, this.bIX, this.bIY, this.bIZ);
        }
    }
}

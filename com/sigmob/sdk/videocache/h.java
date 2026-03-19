package com.sigmob.sdk.videocache;

import android.content.Context;
import android.net.Uri;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.StringUtil;
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
public class h {
    private static final String a = "127.0.0.1";
    private final Object b;
    private final ExecutorService c;
    private final Map<String, i> d;
    private final ServerSocket e;
    private final int f;
    private final Thread g;
    private final e h;
    private final n i;
    private InetAddress j;

    public static final class a {
        private static final long a = 536870912;
        private File b;
        private com.sigmob.sdk.videocache.sourcestorage.c e;
        private com.sigmob.sdk.videocache.file.a d = new com.sigmob.sdk.videocache.file.h(536870912);
        private com.sigmob.sdk.videocache.file.c c = new com.sigmob.sdk.videocache.file.f();
        private com.sigmob.sdk.videocache.headers.b f = new com.sigmob.sdk.videocache.headers.a();

        public a(Context context) {
            this.e = com.sigmob.sdk.videocache.sourcestorage.d.a(context);
            this.b = w.a(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public e b() {
            return new e(this.b, this.c, this.d, this.e, this.f);
        }

        public a a(int count) {
            this.d = new com.sigmob.sdk.videocache.file.g(count);
            return this;
        }

        public a a(long maxSize) {
            this.d = new com.sigmob.sdk.videocache.file.h(maxSize);
            return this;
        }

        public a a(com.sigmob.sdk.videocache.file.a diskUsage) {
            this.d = (com.sigmob.sdk.videocache.file.a) o.a(diskUsage);
            return this;
        }

        public a a(com.sigmob.sdk.videocache.file.c fileNameGenerator) {
            this.c = (com.sigmob.sdk.videocache.file.c) o.a(fileNameGenerator);
            return this;
        }

        public a a(com.sigmob.sdk.videocache.headers.b headerInjector) {
            this.f = (com.sigmob.sdk.videocache.headers.b) o.a(headerInjector);
            return this;
        }

        public a a(File file) {
            this.b = (File) o.a(file);
            return this;
        }

        public h a() {
            return new h(b());
        }
    }

    private final class b implements Runnable {
        private final Socket b;

        public b(Socket socket) {
            this.b = socket;
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            h.this.a(this.b);
        }
    }

    private final class c implements Runnable {
        private final CountDownLatch b;

        public c(CountDownLatch startSignal) {
            this.b = startSignal;
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            this.b.countDown();
            h.this.d();
        }
    }

    public h(Context context) {
        this(new a(context).b());
    }

    private h(e config) throws InterruptedException {
        this.b = new Object();
        this.c = ThreadPoolFactory.getFixIOExecutor();
        this.d = new ConcurrentHashMap();
        this.h = (e) o.a(config);
        try {
            this.j = InetAddress.getByName(a);
            ServerSocket serverSocket = new ServerSocket(0, 8, this.j);
            this.e = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.f = localPort;
            k.a(a, localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            SigmobLog.d("Thread create ,current thread num :" + Thread.activeCount());
            Thread thread = new Thread(new c(countDownLatch));
            this.g = thread;
            thread.start();
            countDownLatch.await();
            this.i = new n(a, localPort);
        } catch (IOException | InterruptedException e) {
            this.c.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    private void a(File cacheFile) {
        try {
            this.h.c.a(cacheFile);
        } catch (IOException e) {
            SigmobLog.e("Error touching file " + cacheFile, e);
        }
    }

    private void a(Throwable e) {
        SigmobLog.e("HttpProxyCacheServer error", e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Socket socket) throws IOException {
        StringBuilder sb;
        try {
            try {
                f fVarA = f.a(socket.getInputStream());
                SigmobLog.d("Request to cache proxy:" + fVarA);
                String strC = r.c(fVarA.a);
                if (this.i.a(strC)) {
                    this.i.a(socket);
                } else {
                    f(strC).a(fVarA, socket);
                }
                b(socket);
                sb = new StringBuilder();
            } catch (q e) {
                e = e;
                a(new q("Error processing request", e));
                b(socket);
                sb = new StringBuilder();
            } catch (SocketException unused) {
                SigmobLog.d("Closing socket… Socket is closed by client.");
                b(socket);
                sb = new StringBuilder();
            } catch (IOException e2) {
                e = e2;
                a(new q("Error processing request", e));
                b(socket);
                sb = new StringBuilder();
            }
            SigmobLog.d(sb.append("Opened connections: ").append(e()).toString());
        } catch (Throwable th) {
            b(socket);
            SigmobLog.d("Opened connections: " + e());
            throw th;
        }
    }

    private void b(Socket socket) throws IOException {
        c(socket);
        d(socket);
        e(socket);
    }

    private boolean b() {
        return this.i.a(1, 70);
    }

    private void c() {
        synchronized (this.b) {
            Iterator<i> it = this.d.values().iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.d.clear();
        }
    }

    private void c(Socket socket) throws IOException {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException unused) {
            SigmobLog.d("Releasing input stream… Socket is closed by client.");
        } catch (IOException unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() throws IOException {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                this.c.submit(new b(this.e.accept()));
            } catch (IOException e) {
                a(new q("Error during waiting connection", e));
                return;
            }
        }
    }

    private void d(Socket socket) throws IOException {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException unused) {
        }
    }

    private int e() {
        int iB;
        synchronized (this.b) {
            iB = 0;
            Iterator<i> it = this.d.values().iterator();
            while (it.hasNext()) {
                iB += it.next().b();
            }
        }
        return iB;
    }

    private String e(String url) {
        return String.format(Locale.US, "http://%s:%d/%s", a, Integer.valueOf(this.f), r.b(url));
    }

    private void e(Socket socket) throws IOException {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException unused) {
        }
    }

    private i f(String url) throws q {
        i iVar;
        synchronized (this.b) {
            iVar = this.d.get(url);
            if (iVar == null) {
                iVar = new i(url, this.h);
                this.d.put(url, iVar);
            }
        }
        return iVar;
    }

    public String a(String url) {
        return a(StringUtil.getUrl(url), true);
    }

    public String a(String url, boolean allowCachedFileUri) {
        if (!allowCachedFileUri || !b(url)) {
            return b() ? e(url) : url;
        }
        File fileC = c(url);
        a(fileC);
        return Uri.fromFile(fileC).toString();
    }

    public void a() throws IOException {
        SigmobLog.i("Shutdown proxy server");
        c();
        this.h.d.a();
        this.g.interrupt();
        try {
            if (this.e.isClosed()) {
                return;
            }
            this.e.close();
        } catch (IOException e) {
            a(new q("Error shutting down proxy server", e));
        }
    }

    public void a(d cacheListener) {
        o.a(cacheListener);
        synchronized (this.b) {
            Iterator<i> it = this.d.values().iterator();
            while (it.hasNext()) {
                it.next().b(cacheListener);
            }
        }
    }

    public void a(d cacheListener, String url) {
        o.a(cacheListener, url);
        synchronized (this.b) {
            try {
                f(url).a(cacheListener);
            } catch (q e) {
                SigmobLog.w("Error registering cache listener", e);
            }
        }
    }

    public void b(d cacheListener, String url) {
        o.a(cacheListener, url);
        synchronized (this.b) {
            try {
                f(url).b(cacheListener);
            } catch (q e) {
                SigmobLog.w("Error registering cache listener", e);
            }
        }
    }

    public boolean b(String url) {
        o.a(url, "Url can't be null!");
        return c(url).exists();
    }

    public File c(String url) {
        return new File(this.h.a, this.h.b.a(url));
    }

    public void d(String url) {
        synchronized (this.b) {
            i iVar = this.d.get(url);
            if (iVar != null) {
                iVar.a();
            }
        }
    }
}

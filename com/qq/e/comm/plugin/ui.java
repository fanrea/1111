package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ui {
    private ServerSocket a;
    private int b;
    private Thread c;
    private Object d;
    private LinkedHashMap<String, ti> e;
    private au f;
    private boolean g;
    private AtomicInteger h;

    /* compiled from: A */
    private static final class d {
        private static ui a = new ui(null);
    }

    /* compiled from: A */
    class a extends LinkedHashMap<String, ti> {
        a() {
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, ti> entry) {
            return size() > 30;
        }
    }

    private ui() {
        this.d = new Object();
        this.e = new a();
        this.h = new AtomicInteger(0);
    }

    /* synthetic */ ui(a aVar) {
        this();
    }

    /* compiled from: A */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ui.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032 A[Catch: all -> 0x0029, TRY_LEAVE, TryCatch #2 {all -> 0x0029, blocks: (B:3:0x0003, B:5:0x0019, B:6:0x001f, B:13:0x002e, B:15:0x0032, B:18:0x004a), top: B:23:0x0003, inners: #4, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(java.net.Socket r6) throws java.io.IOException {
        /*
            r5 = this;
            java.lang.String r0 = "e"
            r1 = 0
            java.io.InputStream r2 = r6.getInputStream()     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b com.qq.e.comm.plugin.vu -> L2d java.net.SocketException -> L49
            com.qq.e.comm.plugin.vh r2 = com.qq.e.comm.plugin.vh.a(r2)     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b com.qq.e.comm.plugin.vu -> L2d java.net.SocketException -> L49
            java.lang.String r3 = r2.a     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b com.qq.e.comm.plugin.vu -> L2d java.net.SocketException -> L49
            java.lang.String r3 = com.qq.e.comm.plugin.wu.a(r3)     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b com.qq.e.comm.plugin.vu -> L2d java.net.SocketException -> L49
            com.qq.e.comm.plugin.au r4 = r5.f     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b com.qq.e.comm.plugin.vu -> L2d java.net.SocketException -> L49
            boolean r4 = r4.a(r3)     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b com.qq.e.comm.plugin.vu -> L2d java.net.SocketException -> L49
            if (r4 == 0) goto L1f
            com.qq.e.comm.plugin.au r2 = r5.f     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b com.qq.e.comm.plugin.vu -> L2d java.net.SocketException -> L49
            r2.a(r6)     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b com.qq.e.comm.plugin.vu -> L2d java.net.SocketException -> L49
            goto L45
        L1f:
            int r4 = r2.d     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b com.qq.e.comm.plugin.vu -> L2d java.net.SocketException -> L49
            com.qq.e.comm.plugin.ti r3 = r5.b(r3, r4)     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b com.qq.e.comm.plugin.vu -> L2d java.net.SocketException -> L49
            r3.a(r2, r6)     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2b com.qq.e.comm.plugin.vu -> L2d java.net.SocketException -> L49
            goto L45
        L29:
            r0 = move-exception
            goto L61
        L2b:
            r2 = move-exception
            goto L2e
        L2d:
            r2 = move-exception
        L2e:
            boolean r3 = r2 instanceof java.io.IOException     // Catch: java.lang.Throwable -> L29
            if (r3 == 0) goto L45
            com.qq.e.comm.plugin.ja r3 = new com.qq.e.comm.plugin.ja     // Catch: java.lang.Throwable -> L29
            r3.<init>()     // Catch: java.lang.Throwable -> L29
            java.lang.String r2 = r2.getMessage()     // Catch: java.lang.Throwable -> L29
            com.qq.e.comm.plugin.ja r0 = r3.a(r0, r2)     // Catch: java.lang.Throwable -> L29
            r2 = 1130118(0x113e86, float:1.583633E-39)
            com.qq.e.comm.plugin.b10.a(r2, r1, r1, r1, r0)     // Catch: java.lang.Throwable -> L29
        L45:
            r5.e(r6)
            goto L60
        L49:
            r2 = move-exception
            com.qq.e.comm.plugin.ja r3 = new com.qq.e.comm.plugin.ja     // Catch: java.lang.Throwable -> L29
            r3.<init>()     // Catch: java.lang.Throwable -> L29
            java.lang.String r2 = r2.getMessage()     // Catch: java.lang.Throwable -> L29
            com.qq.e.comm.plugin.ja r0 = r3.a(r0, r2)     // Catch: java.lang.Throwable -> L29
            r2 = 1130122(0x113e8a, float:1.583638E-39)
            com.qq.e.comm.plugin.b10.a(r2, r1, r1, r1, r0)     // Catch: java.lang.Throwable -> L29
            r5.e(r6)
        L60:
            return
        L61:
            r5.e(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.ui.d(java.net.Socket):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, String str2) {
        try {
            b(str, i).a(str2);
        } catch (vu e2) {
            e2.printStackTrace();
        }
    }

    private void e(Socket socket) throws IOException {
        b(socket);
        c(socket);
        a(socket);
    }

    private void b(Socket socket) throws IOException {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException unused) {
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void c(Socket socket) throws IOException {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException unused) {
        }
    }

    /* compiled from: A */
    private final class f implements Runnable {
        private final CountDownLatch a;

        public f(CountDownLatch countDownLatch) {
            this.a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.countDown();
            ui.this.d();
        }
    }

    /* compiled from: A */
    private final class e implements Runnable {
        private final Socket a;

        public e(Socket socket) {
            this.a = socket;
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            ui.this.d(this.a);
        }
    }

    /* compiled from: A */
    private final class c implements Runnable {
        private final String a;
        private final int b;
        private final String c;

        public c(String str, int i, String str2) {
            this.a = str;
            this.b = i;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ui.this.a(this.a, this.b, this.c);
        }
    }

    public String c(String str, int i) {
        if (TextUtils.isEmpty(str) || !this.g) {
            return null;
        }
        if (c()) {
            return a(str, i);
        }
        b10.b(1130120, null, Integer.valueOf(this.f == null ? 1 : 2));
        qg.b.submit(new b());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                qg.b.submit(new e(this.a.accept()));
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
    }

    private ti b(String str, int i) throws vu {
        ti tiVar;
        synchronized (this.d) {
            String str2 = i + str;
            tiVar = this.e.get(str2);
            if (tiVar == null) {
                tiVar = new ti(str, i);
                this.e.put(str2, tiVar);
            }
        }
        return tiVar;
    }

    private void a(Socket socket) throws IOException {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException unused) {
        }
    }

    public void b() {
        int iIncrementAndGet = this.h.incrementAndGet();
        if (iIncrementAndGet > 10) {
            if (iIncrementAndGet == 11) {
                b10.a(1130121, (f5) null);
                return;
            }
            return;
        }
        try {
            boolean z = GlobalSetting.isEnableVideoDownloadingCache() && r1.d().f().a("viCaE", 1) == 1;
            this.g = z;
            if (!z) {
                this.a = null;
                this.b = 0;
                this.c = null;
                this.f = null;
                return;
            }
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.a = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.b = localPort;
            lm.a("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new f(countDownLatch), "GDT_VIDEO_CACHE");
            this.c = thread;
            thread.start();
            countDownLatch.await();
            this.f = new au("127.0.0.1", this.b);
        } catch (Throwable th) {
            ja jaVar = new ja();
            jaVar.a("msg", th.getMessage());
            b10.a(1130123, null, Integer.valueOf(iIncrementAndGet), jaVar);
        }
    }

    public void b(String str, int i, String str2) {
        qg.b.submit(new c(str, i, str2));
    }

    public String a(String str) {
        return c(str, 0);
    }

    public static ui a() {
        return d.a;
    }

    private String a(String str, int i) {
        return String.format(Locale.US, "http://%s:%d/%s", "127.0.0.1", Integer.valueOf(this.b), wu.b(str) + "%26sdk_ad_type%3D" + i + "%26video_view_hashcode%3D12345567");
    }

    private boolean c() {
        au auVar = this.f;
        if (auVar != null) {
            return auVar.a(3, 70);
        }
        return false;
    }
}

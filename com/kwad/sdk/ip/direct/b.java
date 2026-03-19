package com.kwad.sdk.ip.direct;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.kwad.sdk.utils.bx;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b {
    private static Handler cbB = new Handler(Looper.getMainLooper());
    static int cbL = 80;
    static int port = 80;

    public static c h(String str, long j) {
        a aVar;
        long j2 = j / 5;
        com.kwad.sdk.core.d.c.d("IpDirect_Ping", "ping:" + str);
        c cVar = new c(str);
        try {
            aVar = new a();
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar == null) {
            return cVar;
        }
        try {
            aVar.start();
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < cVar.akC(); i++) {
                C0616b c0616b = new C0616b(str);
                c0616b.cbV = j + j2;
                linkedList.add(c0616b);
                try {
                    aVar.a(c0616b);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            try {
                Thread.sleep(j + j2);
                try {
                    aVar.shutdown();
                    aVar.join();
                    float f = 0.0f;
                    Iterator it = linkedList.iterator();
                    boolean z = true;
                    while (it.hasNext()) {
                        C0616b c0616b2 = (C0616b) it.next();
                        c0616b2.akB();
                        z &= c0616b2.success;
                        cVar.dd(z);
                        f += c0616b2.cbU;
                    }
                    com.kwad.sdk.core.d.c.d("IpDirect_Ping", "sum:" + f + "*size:" + linkedList.size());
                    cVar.R(f / linkedList.size());
                    return cVar;
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    return cVar;
                }
            } catch (Throwable th4) {
                th4.printStackTrace();
                return cVar;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            return cVar;
        }
    }

    /* renamed from: com.kwad.sdk.ip.direct.b$b, reason: collision with other inner class name */
    static class C0616b {
        InetSocketAddress cbR;
        SocketChannel cbS;
        Throwable cbT;
        private float cbU;
        long cbV;
        long cbW;
        long cbX = 0;
        boolean cbY = false;
        private boolean success;

        C0616b(String str) {
            try {
                this.cbR = new InetSocketAddress(InetAddress.getByName(str), b.port);
            } catch (Throwable th) {
                this.cbT = th;
            }
        }

        final void akB() {
            String string;
            if (this.cbX != 0) {
                string = Long.toString(this.cbX - this.cbW) + "ms";
                this.cbU = this.cbX - this.cbW;
                this.success = true;
            } else {
                Throwable th = this.cbT;
                if (th != null) {
                    string = th.toString();
                    this.success = false;
                } else {
                    this.success = false;
                    string = "Timed out";
                }
            }
            com.kwad.sdk.core.d.c.d("IpDirect_Ping", this.cbR + " : " + string);
            this.cbY = true;
        }
    }

    static class a extends Thread {
        LinkedList cbN = new LinkedList();
        volatile boolean cbO = false;
        Selector cbM = Selector.open();

        a() {
            setName("Connector");
        }

        final void a(C0616b c0616b) {
            final SocketChannel socketChannelOpen;
            try {
                socketChannelOpen = SocketChannel.open();
            } catch (Throwable th) {
                th = th;
                socketChannelOpen = null;
            }
            try {
                socketChannelOpen.configureBlocking(false);
                boolean zConnect = socketChannelOpen.connect(c0616b.cbR);
                c0616b.cbS = socketChannelOpen;
                c0616b.cbW = SystemClock.elapsedRealtime();
                if (zConnect) {
                    c0616b.cbX = c0616b.cbW;
                    bx.c(socketChannelOpen);
                } else {
                    synchronized (this.cbN) {
                        this.cbN.add(c0616b);
                    }
                    Selector selector = this.cbM;
                    if (selector != null) {
                        try {
                            selector.wakeup();
                        } catch (Throwable unused) {
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    bx.c(socketChannelOpen);
                    c0616b.cbT = th;
                    try {
                        b.cbB.postDelayed(new Runnable() { // from class: com.kwad.sdk.ip.direct.b.a.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                bx.c(socketChannelOpen);
                            }
                        }, c0616b.cbV);
                    } catch (Throwable unused2) {
                    }
                } finally {
                    try {
                        b.cbB.postDelayed(new Runnable() { // from class: com.kwad.sdk.ip.direct.b.a.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                bx.c(socketChannelOpen);
                            }
                        }, c0616b.cbV);
                    } catch (Throwable unused3) {
                    }
                }
            }
        }

        private void akz() {
            synchronized (this.cbN) {
                while (this.cbN.size() > 0) {
                    C0616b c0616b = (C0616b) this.cbN.removeFirst();
                    try {
                        c0616b.cbS.register(this.cbM, 8, c0616b);
                    } catch (Throwable th) {
                        c0616b.cbS.close();
                        c0616b.cbT = th;
                    }
                }
            }
        }

        private void akA() {
            Iterator<SelectionKey> it = this.cbM.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey next = it.next();
                it.remove();
                C0616b c0616b = (C0616b) next.attachment();
                SocketChannel socketChannel = (SocketChannel) next.channel();
                try {
                    if (socketChannel.finishConnect()) {
                        next.cancel();
                        c0616b.cbX = SystemClock.elapsedRealtime();
                        socketChannel.close();
                    }
                } catch (Throwable th) {
                    bx.c(socketChannel);
                    c0616b.cbT = th;
                }
            }
        }

        final void shutdown() {
            this.cbO = true;
            Selector selector = this.cbM;
            if (selector != null) {
                try {
                    selector.wakeup();
                } catch (Throwable unused) {
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            while (true) {
                try {
                    if (this.cbM.select() > 0) {
                        akA();
                    }
                    akz();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (this.cbO) {
                    Selector selector = this.cbM;
                    if (selector != null) {
                        try {
                            selector.close();
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    return;
                }
                continue;
            }
        }
    }
}

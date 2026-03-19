package com.sigmob.sdk.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class i {
    private static final int a = 1;
    private static final int b = 2;
    private final AtomicInteger c = new AtomicInteger(0);
    private final String d;
    private volatile g e;
    private final List<d> f;
    private final d g;
    private final e h;

    private static final class a extends Handler implements d {
        private final String a;
        private final List<d> b;

        public a(String url, List<d> listeners) {
            super(Looper.getMainLooper());
            this.a = url;
            this.b = listeners;
        }

        @Override // com.sigmob.sdk.videocache.d
        public void a(File file, String url, int percentsAvailable) {
            Message messageObtainMessage = obtainMessage();
            messageObtainMessage.arg1 = percentsAvailable;
            messageObtainMessage.obj = file;
            messageObtainMessage.what = 1;
            sendMessage(messageObtainMessage);
        }

        @Override // com.sigmob.sdk.videocache.d
        public void a(String url, Throwable throwable) {
            Message messageObtainMessage = obtainMessage();
            messageObtainMessage.obj = throwable;
            messageObtainMessage.what = 2;
            sendMessage(messageObtainMessage);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            for (d dVar : this.b) {
                int i = msg.what;
                if (i == 1) {
                    dVar.a((File) msg.obj, this.a, msg.arg1);
                } else if (i == 2) {
                    dVar.a(this.a, (Throwable) msg.obj);
                }
            }
        }
    }

    public i(String url, e config) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f = copyOnWriteArrayList;
        this.d = (String) o.a(url);
        this.h = (e) o.a(config);
        this.g = new a(url, copyOnWriteArrayList);
    }

    private synchronized void c() throws q {
        this.e = this.e == null ? e() : this.e;
    }

    private synchronized void d() {
        if (this.c.decrementAndGet() <= 0) {
            this.e.a();
            this.e = null;
        }
    }

    private g e() throws q {
        g gVar = new g(t.a(this.d, this.h.d, this.h.e), new com.sigmob.sdk.videocache.file.b(this.h.a(this.d), this.h.c));
        gVar.a(this.g);
        return gVar;
    }

    public void a() {
        this.f.clear();
        if (this.e != null) {
            this.e.a((d) null);
            this.e.a();
            this.e = null;
        }
        this.c.set(0);
    }

    public void a(d cacheListener) {
        this.f.add(cacheListener);
    }

    public void a(f request, Socket socket) throws IOException, q {
        c();
        try {
            this.c.incrementAndGet();
            this.e.a(request, socket);
        } finally {
            try {
            } finally {
            }
        }
    }

    public int b() {
        return this.c.get();
    }

    public void b(d cacheListener) {
        this.f.remove(cacheListener);
    }
}

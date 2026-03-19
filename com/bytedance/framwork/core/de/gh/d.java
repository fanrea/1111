package com.bytedance.framwork.core.de.gh;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.framwork.core.de.ha.f;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: ThreadWithHandler.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    static final f.a<c, Runnable> a = new f.a<c, Runnable>() { // from class: com.bytedance.framwork.core.de.gh.d.1
        @Override // com.bytedance.framwork.core.de.ha.f.a
        public boolean a(c cVar, Runnable runnable) {
            return runnable == null ? cVar == null || cVar.a == null || cVar.a.getCallback() == null : (cVar == null || cVar.a == null || !runnable.equals(cVar.a.getCallback())) ? false : true;
        }
    };
    static final f.a<Message, Runnable> b = new f.a<Message, Runnable>() { // from class: com.bytedance.framwork.core.de.gh.d.2
        @Override // com.bytedance.framwork.core.de.ha.f.a
        public boolean a(Message message, Runnable runnable) {
            return runnable == null ? message == null || message.getCallback() == null : message != null && runnable.equals(message.getCallback());
        }
    };
    private final HandlerThread c;
    private volatile Handler f;
    private final Queue<c> d = new ConcurrentLinkedQueue();
    private final Queue<Message> e = new ConcurrentLinkedQueue();
    private final Object g = new Object();

    public d(String str) {
        this.c = new b(str);
    }

    public void a() {
        this.c.start();
    }

    private Message c(Runnable runnable) {
        return Message.obtain(this.f, runnable);
    }

    public final boolean a(Runnable runnable) {
        return a(c(runnable), 0L);
    }

    public final boolean a(Runnable runnable, long j) {
        return a(c(runnable), j);
    }

    public final void b(Runnable runnable) {
        if (!this.d.isEmpty() || !this.e.isEmpty()) {
            f.a(this.d, runnable, a);
            f.a(this.e, runnable, b);
        }
        if (this.f != null) {
            this.f.removeCallbacks(runnable);
        }
    }

    public final boolean a(Message message, long j) {
        if (j < 0) {
            j = 0;
        }
        return b(message, SystemClock.uptimeMillis() + j);
    }

    public final boolean b(Message message, long j) {
        if (this.f == null) {
            synchronized (this.g) {
                if (this.f == null) {
                    this.d.add(new c(message, j));
                    return true;
                }
            }
        }
        return this.f.sendMessageAtTime(message, j);
    }

    /* compiled from: ThreadWithHandler.java */
    class b extends HandlerThread {
        b(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            synchronized (d.this.g) {
                d.this.f = new Handler();
            }
            d.this.f.post(d.this.new a());
            while (true) {
                try {
                    Looper.loop();
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* compiled from: ThreadWithHandler.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b();
            a();
        }

        void a() {
            while (!d.this.d.isEmpty()) {
                c cVar = (c) d.this.d.poll();
                if (d.this.f != null) {
                    d.this.f.sendMessageAtTime(cVar.a, cVar.b);
                }
            }
        }

        void b() {
            while (!d.this.e.isEmpty()) {
                if (d.this.f != null) {
                    d.this.f.sendMessageAtFrontOfQueue((Message) d.this.e.poll());
                }
            }
        }
    }

    /* compiled from: ThreadWithHandler.java */
    static class c {
        Message a;
        long b;

        c(Message message, long j) {
            this.a = message;
            this.b = j;
        }
    }
}

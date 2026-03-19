package com.qq.e.comm.plugin;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class xo {
    private static final Looper a = Looper.getMainLooper();
    private static Handler b;

    private static Handler a() {
        if (b == null) {
            b = new Handler(a);
        }
        return b;
    }

    public static final boolean b(Runnable runnable) {
        if (Thread.currentThread() != a.getThread()) {
            return a().postAtFrontOfQueue(runnable);
        }
        runnable.run();
        return true;
    }

    public static final boolean c(Runnable runnable) {
        return a().post(new a(runnable));
    }

    public static final boolean a(Runnable runnable) {
        return a().post(runnable);
    }

    public static final boolean a(Runnable runnable, long j) {
        return a().postDelayed(runnable, j);
    }

    public static final void a(Object obj) {
        a().removeCallbacksAndMessages(obj);
    }

    public static boolean d(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        if (Thread.currentThread() == a.getThread()) {
            runnable.run();
            return true;
        }
        return a(runnable);
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ Runnable a;

        @Override // java.lang.Runnable
        public void run() {
            Looper.myQueue().addIdleHandler(new C0725a());
        }

        a(Runnable runnable) {
            this.a = runnable;
        }

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.xo$a$a, reason: collision with other inner class name */
        class C0725a implements MessageQueue.IdleHandler {
            C0725a() {
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                try {
                    a.this.a.run();
                    return false;
                } catch (Throwable unused) {
                    return false;
                }
            }
        }
    }

    public static final void e(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        a().removeCallbacks(runnable);
    }
}

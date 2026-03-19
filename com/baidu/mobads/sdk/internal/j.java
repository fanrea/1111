package com.baidu.mobads.sdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.util.concurrent.Future;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class j<T> implements Runnable {
    private static final String b = "BaseTask";
    private static final int c = 1;
    private static final int d = 2;
    private static final int e = 3;
    private static b j;
    protected Future<T> a;
    private String f;
    private long g;
    private long h;
    private long i;

    protected void a(T t) {
    }

    protected void a(Throwable th) {
    }

    protected abstract T i();

    protected void j() {
    }

    public j() {
        this.f = ILogConst.PLAY_SOURCE_DEFAULT;
    }

    public j(String str) {
        this.f = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        h();
    }

    public String a() {
        return this.f;
    }

    public void a(Future future) {
        this.a = future;
    }

    public void a(long j2) {
        this.g = j2;
    }

    public void a(boolean z) {
        Future<T> future = this.a;
        if (future != null) {
            future.cancel(z);
            k().obtainMessage(3, new a(this, null)).sendToTarget();
        }
    }

    public void b() {
        a(false);
    }

    public boolean c() {
        Future<T> future = this.a;
        if (future != null) {
            return future.isCancelled();
        }
        return false;
    }

    public boolean d() {
        Future<T> future = this.a;
        if (future != null) {
            return future.isDone();
        }
        return false;
    }

    public long e() {
        return this.h - this.g;
    }

    public long f() {
        return this.i - this.g;
    }

    public long g() {
        return this.i - this.h;
    }

    public j h() {
        try {
            this.h = System.currentTimeMillis();
            k().obtainMessage(1, new a(this, i())).sendToTarget();
        } finally {
            try {
                return this;
            } finally {
            }
        }
        return this;
    }

    private static Handler k() {
        b bVar;
        synchronized (j.class) {
            if (j == null) {
                j = new b(Looper.getMainLooper());
            }
            bVar = j;
        }
        return bVar;
    }

    private static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            int i = message.what;
            if (i == 1) {
                aVar.a.a((j) aVar.b);
            } else if (i == 2) {
                aVar.a.a((Throwable) aVar.b);
            } else {
                if (i != 3) {
                    return;
                }
                aVar.a.j();
            }
        }
    }

    private static class a<T> {
        final j a;
        final T b;

        a(j jVar, T t) {
            this.a = jVar;
            this.b = t;
        }
    }
}

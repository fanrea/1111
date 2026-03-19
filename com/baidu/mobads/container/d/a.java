package com.baidu.mobads.container.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.util.concurrent.Future;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public abstract class a<T> implements Runnable {
    private static final String a = "BaseTask";
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    private static b i;
    private String e;
    private long f;
    private long g;
    private long h;
    protected Future<T> l;

    protected abstract T a();

    public a() {
        this.e = ILogConst.PLAY_SOURCE_DEFAULT;
    }

    public a(String str) {
        this.e = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        m();
    }

    public String g() {
        return this.e;
    }

    public void a(Future future) {
        this.l = future;
    }

    public void b(long j) {
        this.f = j;
    }

    public void b(boolean z) {
        if (this.l != null) {
            this.l.cancel(z);
            c().obtainMessage(3, new C0125a(this, null)).sendToTarget();
        }
    }

    public void a_() {
        b(false);
    }

    public boolean h() {
        if (this.l != null) {
            return this.l.isCancelled();
        }
        return false;
    }

    public boolean i() {
        if (this.l != null) {
            return this.l.isDone();
        }
        return false;
    }

    public long j() {
        return this.g - this.f;
    }

    public long k() {
        return this.h - this.f;
    }

    public long l() {
        return this.h - this.g;
    }

    public a m() {
        try {
            this.g = System.currentTimeMillis();
            c().obtainMessage(1, new C0125a(this, a())).sendToTarget();
        } finally {
            try {
                return this;
            } finally {
            }
        }
        return this;
    }

    private static Handler c() {
        b bVar;
        synchronized (a.class) {
            if (i == null) {
                i = new b(Looper.getMainLooper());
            }
            bVar = i;
        }
        return bVar;
    }

    private static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C0125a c0125a = (C0125a) message.obj;
            switch (message.what) {
                case 1:
                    c0125a.a.a((a) c0125a.b);
                    break;
                case 2:
                    c0125a.a.a((Throwable) c0125a.b);
                    break;
                case 3:
                    c0125a.a.n();
                    break;
            }
        }
    }

    /* renamed from: com.baidu.mobads.container.d.a$a, reason: collision with other inner class name */
    private static class C0125a<T> {
        final a a;
        final T b;

        C0125a(a aVar, T t) {
            this.a = aVar;
            this.b = t;
        }
    }

    protected void a(T t) {
    }

    protected void a(Throwable th) {
    }

    protected void n() {
    }
}

package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class t1 {
    private static volatile t1 g;
    private SharedPreferences a;
    private final int b;
    private long c;
    private Map<Integer, b> d;
    private volatile SharedPreferences.Editor e;
    private final HashMap<String, Integer> f = new HashMap<>();

    static /* synthetic */ int a(t1 t1Var) {
        return pro.getIresult(613, 1, t1Var);
    }

    private long a(String str) {
        return pro.getJresult(614, 0, this, str);
    }

    private SharedPreferences a(Context context) {
        return (SharedPreferences) pro.getobjresult(615, 0, this, context);
    }

    private String a(int i, long j) {
        return (String) pro.getobjresult(616, 0, this, Integer.valueOf(i), Long.valueOf(j));
    }

    static /* synthetic */ String a(t1 t1Var, int i, long j) {
        return (String) pro.getobjresult(617, 1, t1Var, Integer.valueOf(i), Long.valueOf(j));
    }

    private synchronized void a() {
        pro.getVresult(618, 0, this);
    }

    static /* synthetic */ void a(t1 t1Var, String str, int i) {
        pro.getVresult(619, 1, t1Var, str, Integer.valueOf(i));
    }

    private synchronized void a(String str, int i) {
        pro.getVresult(620, 0, this, str, Integer.valueOf(i));
    }

    static /* synthetic */ SharedPreferences b(t1 t1Var) {
        return (SharedPreferences) pro.getobjresult(621, 1, t1Var);
    }

    private b b(int i) {
        return (b) pro.getobjresult(622, 0, this, Integer.valueOf(i));
    }

    private void b() {
        pro.getVresult(623, 0, this);
    }

    static /* synthetic */ long c(t1 t1Var) {
        return pro.getJresult(624, 1, t1Var);
    }

    public static t1 c() {
        return (t1) pro.getobjresult(625, 1, new Object[0]);
    }

    private boolean d() {
        return pro.getZresult(626, 0, this);
    }

    Pair<Integer, Integer> a(int i) {
        return (Pair) pro.getobjresult(627, 0, this, Integer.valueOf(i));
    }

    public synchronized int b(String str) {
        return pro.getIresult(628, 0, this, str);
    }

    private t1() {
        r1 r1VarD = r1.d();
        int iA = r1VarD.f().a("rfrtw", 3);
        this.b = iA;
        if (iA > 0) {
            this.d = new ConcurrentHashMap();
            this.a = a(r1VarD.a());
            b();
            this.c = r1.a("rfrst", 1) * 1000;
        }
    }

    /* compiled from: A */
    private class b {
        private final int a;
        private String b;
        private long c;
        private final ReentrantReadWriteLock d;
        private final AtomicLong e;
        private final AtomicInteger f;
        private final AtomicInteger g;

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            if (System.currentTimeMillis() < this.c) {
                return;
            }
            ReentrantReadWriteLock.WriteLock writeLock = null;
            try {
                writeLock = this.d.writeLock();
                if (writeLock != null) {
                    writeLock.lock();
                }
            } catch (Throwable th) {
                try {
                    th.getMessage();
                    if (writeLock == null) {
                        return;
                    }
                } finally {
                    if (writeLock != null) {
                        writeLock.unlock();
                    }
                }
            }
            if (System.currentTimeMillis() < this.c) {
                if (writeLock != null) {
                    return;
                } else {
                    return;
                }
            }
            this.e.set(0L);
            this.g.set(0);
            b();
            if (writeLock == null) {
                return;
            }
            writeLock.unlock();
        }

        private b(int i) {
            this.e = new AtomicLong(0L);
            this.f = new AtomicInteger(0);
            this.g = new AtomicInteger(0);
            this.a = i;
            this.d = new ReentrantReadWriteLock(true);
            b();
        }

        private void b() {
            for (int i = 0; i < t1.a(t1.this); i++) {
                String strA = t1.a(t1.this, this.a, k20.a(-i));
                int i2 = t1.b(t1.this).getInt(strA, 0);
                if (i == 0) {
                    this.b = strA;
                    this.f.set(i2);
                } else {
                    this.g.addAndGet(i2);
                }
            }
            this.c = k20.a(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int a() {
            int andIncrement;
            ReentrantReadWriteLock.ReadLock lock = null;
            try {
                lock = this.d.readLock();
                if (lock != null) {
                    lock.lock();
                }
                long j = this.e.get();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - j > t1.c(t1.this) && this.e.compareAndSet(j, jCurrentTimeMillis)) {
                    andIncrement = this.f.getAndIncrement();
                    t1.a(t1.this, this.b, this.f.get());
                } else {
                    andIncrement = this.f.get();
                }
                return andIncrement + this.g.get();
            } catch (Throwable th) {
                try {
                    th.getMessage();
                    if (lock == null) {
                        return 0;
                    }
                    lock.unlock();
                    return 0;
                } finally {
                    if (lock != null) {
                        lock.unlock();
                    }
                }
            }
        }
    }
}

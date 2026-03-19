package com.tk.core.bridge;

import android.os.Build;
import android.text.TextUtils;
import com.tk.core.o.ac;
import com.tk.core.o.p;
import com.tkruntime.v8.V8;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class IsolatePool {
    private static int Yp = 3;
    private static final List<b> Yq = new CopyOnWriteArrayList();
    private static final Map<b, Executor> Yr = new ConcurrentHashMap();
    private static final Map<b, Executor> Ys = new ConcurrentHashMap();
    private static final List<Executor> Yt = new CopyOnWriteArrayList();
    private static final Random Yu = new Random();

    public static class a {
        public long Yv;
        public int Yw;
        public long Yx;
        public AtomicInteger Yy;
        public b mIsolateRef;
    }

    public static b a(boolean z, String str) {
        b bVarAY;
        if (!z) {
            return new b(0L);
        }
        synchronized (Yq) {
            bVarAY = aY(str);
            if (bVarAY == null) {
                bVarAY = new b(0L);
                Yq.add(bVarAY);
            }
            if (!TextUtils.isEmpty(str)) {
                bVarAY.YB.add(str);
            }
        }
        return bVarAY;
    }

    private static b aY(String str) {
        if (!TextUtils.isEmpty(str) && Yq.size() > 0) {
            for (b bVar : Yq) {
                if (bVar.YB.contains(str)) {
                    return bVar;
                }
            }
            for (b bVar2 : Yq) {
                if (bVar2.YC.containsKey(str)) {
                    return bVar2;
                }
            }
        }
        for (b bVar3 : Yq) {
            if (bVar3.YB.isEmpty()) {
                return bVar3;
            }
        }
        if (Yq.size() < Yp) {
            return null;
        }
        b bVar4 = Yq.get(0);
        if (Yq.size() == 1) {
            return bVar4;
        }
        for (int i = 1; i < Yq.size(); i++) {
            b bVar5 = Yq.get(i);
            if (bVar4.Yy.get() > bVar5.Yy.get()) {
                bVar4 = bVar5;
            }
        }
        return bVar4;
    }

    public static Executor a(boolean z, b bVar) {
        Executor executorP;
        int iNextInt;
        if (z) {
            synchronized (Yr) {
                executorP = Yr.get(bVar);
                if (executorP == null && Yr.size() < Yp) {
                    executorP = p.p("tk-share-isolate-thread", 1);
                    Yr.put(bVar, executorP);
                }
            }
        } else {
            synchronized (Ys) {
                executorP = Ys.get(bVar);
                if (executorP == null && Yt.size() < 3) {
                    executorP = p.p("tk-unShared-isolate-thread", 1);
                    Yt.add(executorP);
                    Ys.put(bVar, executorP);
                }
            }
            if (executorP == null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    iNextInt = ThreadLocalRandom.current().nextInt(Yt.size());
                } else {
                    iNextInt = Yu.nextInt(Yt.size());
                }
                executorP = Yt.get(iNextInt);
                Ys.put(bVar, executorP);
            }
        }
        if (executorP != null) {
            return executorP;
        }
        ThreadPoolExecutor threadPoolExecutorP = p.p("tk-unShared-isolate-thread", 1);
        com.tk.core.exception.a.a((com.tk.core.bridge.b) null, new Throwable("getIsolateExecutor result is null, useSharedIsolate: " + z));
        return threadPoolExecutorP;
    }

    public static class b {
        public volatile long Yz;
        private final CopyOnWriteArrayList<com.tk.core.bridge.a> YA = new CopyOnWriteArrayList<>();
        public AtomicInteger Yy = new AtomicInteger(0);
        public final CopyOnWriteArraySet<String> YB = new CopyOnWriteArraySet<>();
        public final ConcurrentHashMap<String, a> YC = new ConcurrentHashMap<>();
        public final CopyOnWriteArrayList<a> YD = new CopyOnWriteArrayList<>();
        public AtomicBoolean YE = new AtomicBoolean(false);
        private boolean YF = false;
        public AtomicLong YG = new AtomicLong(0);
        private final CompileResLRU YH = new CompileResLRU(this, this.YG);

        public b(long j) {
            this.Yz = 0L;
            this.Yz = 0L;
        }

        public final synchronized com.tk.core.bridge.a pd() {
            com.tk.core.bridge.a aVarRemove;
            aVarRemove = this.YA.isEmpty() ? null : this.YA.remove(this.YA.size() - 1);
            if (this.YA.isEmpty()) {
                if (ac.sX()) {
                    ac.a(new Runnable() { // from class: com.tk.core.bridge.IsolatePool.b.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.this.pe();
                        }
                    }, 0L);
                } else {
                    pf();
                }
            }
            return aVarRemove;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void pe() {
            if (this.YA.isEmpty()) {
                if (this.YF) {
                    ac.a(new Runnable() { // from class: com.tk.core.bridge.IsolatePool.b.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.this.pe();
                        }
                    }, 2L);
                } else {
                    pf();
                }
            }
        }

        private void pf() {
            IsolatePool.a(true, this).execute(new Runnable() { // from class: com.tk.core.bridge.IsolatePool.b.3
                @Override // java.lang.Runnable
                public final void run() {
                    if (!b.this.YF && b.this.YA.isEmpty()) {
                        b bVar = b.this;
                        bVar.a(com.tk.core.bridge.a.b(true, bVar, ""));
                    }
                }
            });
        }

        public final void a(com.tk.core.bridge.a aVar) {
            this.YA.add(aVar);
        }

        public final a aZ(String str) {
            return this.YC.get(str);
        }

        public static void a(a aVar) {
            if (aVar == null) {
                return;
            }
            aVar.Yy.incrementAndGet();
        }

        public static void b(a aVar) {
            if (aVar != null) {
                aVar.Yy.decrementAndGet();
            }
        }

        public final void a(final boolean z, final V8 v8) {
            this.Yy.decrementAndGet();
            Executor executor = z ? (Executor) IsolatePool.Yr.get(this) : (Executor) IsolatePool.Ys.remove(this);
            if (executor != null) {
                executor.execute(new Runnable() { // from class: com.tk.core.bridge.IsolatePool.b.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.b(z, v8);
                    }
                });
            } else {
                b(z, v8);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(boolean z, V8 v8) {
            v8.releaseRuntime();
            Iterator<a> it = this.YD.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && next.Yy.get() <= 0) {
                    V8.destroyCodeCache(next.Yv);
                    this.YD.remove(next);
                }
            }
            if (z) {
                return;
            }
            release();
        }

        private void release() {
            if (this.Yz == 0) {
                return;
            }
            if (IsolatePool.Yq.contains(this)) {
                try {
                    throw new RuntimeException("shared isolate can not be released");
                } catch (Throwable th) {
                    com.tk.core.exception.a.a((com.tk.core.bridge.b) null, th);
                    return;
                }
            }
            this.YA.clear();
            this.YB.clear();
            for (a aVar : this.YC.values()) {
                if (aVar != null) {
                    V8.destroyCodeCache(aVar.Yv);
                }
            }
            this.YC.clear();
            this.YH.clear();
            V8._releaseIsolatePtr(this.Yz);
            this.Yy.set(0);
            this.Yz = 0L;
        }

        public final void an(boolean z) {
            this.YF = z;
        }

        public final String toString() {
            return super.toString() + "# mRef = " + this.Yy + " , mPtr = " + this.Yz + " , mCompileRes size = " + this.YC.size();
        }
    }

    static class CompileResLRU extends LinkedHashMap<String, a> {
        private static final long MAX_COMPILE_SIZE = 3145728;
        private static Long sCompileResSizeCacheSize;
        private final AtomicLong mCompileResSize;
        private final b mIsolateRef;

        public CompileResLRU(b bVar, AtomicLong atomicLong) {
            this.mIsolateRef = bVar;
            this.mCompileResSize = atomicLong;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, a> entry) {
            try {
                boolean z = this.mCompileResSize.get() > getCompileResCacheSize();
                if (z && this.mIsolateRef != null && entry != null) {
                    String key = entry.getKey();
                    a value = entry.getValue();
                    this.mIsolateRef.YC.remove(key);
                    this.mIsolateRef.YD.add(value);
                    this.mIsolateRef.YG.addAndGet(-value.Yx);
                }
                return z;
            } catch (Throwable th) {
                com.tk.core.exception.a.a((com.tk.core.bridge.b) null, th);
                return false;
            }
        }

        private static long getCompileResCacheSize() {
            if (sCompileResSizeCacheSize == null && com.tk.core.a.oP().getTKSwitch() != null) {
                sCompileResSizeCacheSize = Long.valueOf(com.tk.core.a.oP().getTKSwitch().oX());
            }
            Long l = sCompileResSizeCacheSize;
            return l != null ? l.longValue() : MAX_COMPILE_SIZE;
        }
    }
}

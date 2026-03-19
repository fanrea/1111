package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.rr;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class sr implements rr {
    private static final rr c = new sr();
    private PriorityBlockingQueue<Runnable> b = new PriorityBlockingQueue<>(15);
    private final ExecutorService a = new ThreadPoolExecutor(5, 10, 180, TimeUnit.SECONDS, this.b, new a());

    /* compiled from: A */
    private static class c implements Callable<hw> {
        final aw a;
        final qr b;

        private hw b() throws Exception {
            ArrayList arrayList = new ArrayList();
            if (n3.a()) {
                arrayList.add(new o20());
            }
            if (this.a.a()) {
                if (s20.a().c()) {
                    arrayList.add(new ev());
                    t20.a(9130015);
                } else {
                    this.a.e(false);
                }
            }
            Map<String, String> mapP = this.a.p();
            if (mapP != null && mapP.get("IAS_REQ_TYPE") != null) {
                arrayList.add(new bj());
            }
            Map<String, String> mapP2 = this.a.p();
            if (mapP2 != null && mapP2.get("NET_STRATEGY") != null) {
                arrayList.add(new yr());
            }
            arrayList.add(new ew());
            return new b6(0, arrayList, this.a).a(this.a);
        }

        public c(aw awVar) {
            this(awVar, null);
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public hw call() throws Exception {
            hw hwVarB;
            Exception exc = null;
            try {
                hwVarB = b();
            } catch (Exception e) {
                hwVarB = null;
                exc = e;
            }
            if (exc == null) {
                qr qrVar = this.b;
                if (qrVar != null) {
                    qrVar.a(this.a, hwVarB);
                }
                if (hwVarB != null && this.a.n()) {
                    hwVarB.close();
                }
            } else {
                if (hwVarB != null) {
                    hwVarB.close();
                }
                qr qrVar2 = this.b;
                if (qrVar2 != null) {
                    qrVar2.a(this.a, exc);
                } else {
                    throw exc;
                }
            }
            return hwVarB;
        }

        public c(aw awVar, qr qrVar) {
            this.a = awVar;
            this.b = qrVar;
        }
    }

    /* compiled from: A */
    private static class b<T> extends FutureTask<T> implements Comparable<b<T>> {
        private final rr.a a;

        public b(Callable<T> callable, rr.a aVar) {
            super(callable);
            this.a = aVar;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b<T> bVar) {
            if (bVar == null) {
                return 1;
            }
            return this.a.b() - bVar.a.b();
        }
    }

    private sr() {
    }

    /* compiled from: A */
    class a implements ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "GDT_NET_THREAD");
        }

        a() {
        }
    }

    @Override // com.qq.e.comm.plugin.rr
    public Future<hw> a(aw awVar) {
        return a(awVar, rr.a.Mid);
    }

    @Override // com.qq.e.comm.plugin.rr
    public Future<hw> a(aw awVar, rr.a aVar, qr qrVar) {
        return a(awVar, aVar, qrVar, this.a);
    }

    public static rr a() {
        return c;
    }

    @Override // com.qq.e.comm.plugin.rr
    public Future<hw> a(aw awVar, rr.a aVar) {
        b bVar = new b(new c(awVar), aVar);
        this.a.execute(bVar);
        this.b.size();
        return bVar;
    }

    public Future<hw> a(aw awVar, rr.a aVar, qr qrVar, Executor executor) {
        b bVar = new b(new c(awVar, qrVar), aVar);
        executor.execute(bVar);
        this.b.size();
        return bVar;
    }
}

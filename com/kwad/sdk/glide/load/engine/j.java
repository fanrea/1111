package com.kwad.sdk.glide.load.engine;

import androidx.core.util.Pools;
import com.kwad.sdk.glide.e.a.a;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.engine.DecodeJob;
import com.kwad.sdk.utils.ax;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class j<R> implements a.c, DecodeJob.a<R> {
    private static final c bTN = new c();
    private final com.kwad.sdk.glide.load.engine.b.a bPJ;
    private final com.kwad.sdk.glide.load.engine.b.a bPK;
    private final com.kwad.sdk.glide.load.engine.b.a bPP;
    private volatile boolean bRS;
    private final com.kwad.sdk.glide.e.a.b bSK;
    private final Pools.Pool<j<?>> bSL;
    private boolean bST;
    private boolean bSk;
    private s<?> bSl;
    private final com.kwad.sdk.glide.load.engine.b.a bTF;
    private final k bTG;
    final e bTO;
    private final c bTP;
    private final AtomicInteger bTQ;
    private boolean bTR;
    private boolean bTS;
    private boolean bTT;
    GlideException bTU;
    private boolean bTV;
    n<?> bTW;
    private DecodeJob<R> bTX;
    DataSource dataSource;
    private com.kwad.sdk.glide.load.c key;

    j(com.kwad.sdk.glide.load.engine.b.a aVar, com.kwad.sdk.glide.load.engine.b.a aVar2, com.kwad.sdk.glide.load.engine.b.a aVar3, com.kwad.sdk.glide.load.engine.b.a aVar4, k kVar, Pools.Pool<j<?>> pool) {
        this(aVar, aVar2, aVar3, aVar4, kVar, pool, bTN);
    }

    private j(com.kwad.sdk.glide.load.engine.b.a aVar, com.kwad.sdk.glide.load.engine.b.a aVar2, com.kwad.sdk.glide.load.engine.b.a aVar3, com.kwad.sdk.glide.load.engine.b.a aVar4, k kVar, Pools.Pool<j<?>> pool, c cVar) {
        this.bTO = new e();
        this.bSK = com.kwad.sdk.glide.e.a.b.ajI();
        this.bTQ = new AtomicInteger();
        this.bPK = aVar;
        this.bPJ = aVar2;
        this.bTF = aVar3;
        this.bPP = aVar4;
        this.bTG = kVar;
        this.bSL = pool;
        this.bTP = cVar;
    }

    final synchronized j<R> b(com.kwad.sdk.glide.load.c cVar, boolean z, boolean z2, boolean z3, boolean z4) {
        this.key = cVar;
        this.bSk = z;
        this.bTR = z2;
        this.bTS = z3;
        this.bST = z4;
        return this;
    }

    public final synchronized void c(DecodeJob<R> decodeJob) {
        com.kwad.sdk.glide.load.engine.b.a aVarAgI;
        this.bTX = decodeJob;
        if (decodeJob.agp()) {
            aVarAgI = this.bPK;
        } else {
            aVarAgI = agI();
        }
        aVarAgI.execute(decodeJob);
    }

    final synchronized void a(com.kwad.sdk.glide.request.j jVar, Executor executor) {
        this.bSK.ajJ();
        this.bTO.b(jVar, executor);
        boolean z = true;
        if (this.bTT) {
            gd(1);
            executor.execute(new b(jVar));
        } else if (this.bTV) {
            gd(1);
            executor.execute(new a(jVar));
        } else {
            if (this.bRS) {
                z = false;
            }
            ax.checkArgument(z, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    final synchronized void a(com.kwad.sdk.glide.request.j jVar) {
        try {
            jVar.c(this.bTW, this.dataSource);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    final synchronized void b(com.kwad.sdk.glide.request.j jVar) {
        try {
            jVar.b(this.bTU);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    final synchronized void c(com.kwad.sdk.glide.request.j jVar) {
        this.bSK.ajJ();
        this.bTO.d(jVar);
        if (this.bTO.isEmpty()) {
            cancel();
            if ((this.bTT || this.bTV) && this.bTQ.get() == 0) {
                release();
            }
        }
    }

    final boolean agH() {
        return this.bST;
    }

    private com.kwad.sdk.glide.load.engine.b.a agI() {
        if (this.bTR) {
            return this.bTF;
        }
        return this.bTS ? this.bPP : this.bPJ;
    }

    private void cancel() {
        if (isDone()) {
            return;
        }
        this.bRS = true;
        this.bTX.cancel();
        this.bTG.a(this, this.key);
    }

    private boolean isDone() {
        return this.bTV || this.bTT || this.bRS;
    }

    private void agJ() {
        synchronized (this) {
            this.bSK.ajJ();
            if (this.bRS) {
                this.bSl.recycle();
                release();
                return;
            }
            if (this.bTO.isEmpty()) {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            }
            if (this.bTT) {
                throw new IllegalStateException("Already have resource");
            }
            this.bTW = c.a(this.bSl, this.bSk);
            this.bTT = true;
            e eVarAgM = this.bTO.agM();
            gd(eVarAgM.size() + 1);
            this.bTG.a(this, this.key, this.bTW);
            Iterator<d> it = eVarAgM.iterator();
            while (it.hasNext()) {
                d next = it.next();
                next.bTZ.execute(new b(next.bTL));
            }
            agK();
        }
    }

    private synchronized void gd(int i) {
        n<?> nVar;
        ax.checkArgument(isDone(), "Not yet complete!");
        if (this.bTQ.getAndAdd(i) == 0 && (nVar = this.bTW) != null) {
            nVar.acquire();
        }
    }

    final synchronized void agK() {
        this.bSK.ajJ();
        ax.checkArgument(isDone(), "Not yet complete!");
        int iDecrementAndGet = this.bTQ.decrementAndGet();
        ax.checkArgument(iDecrementAndGet >= 0, "Can't decrement below 0");
        if (iDecrementAndGet == 0) {
            n<?> nVar = this.bTW;
            if (nVar != null) {
                nVar.release();
            }
            release();
        }
    }

    private synchronized void release() {
        if (this.key == null) {
            throw new IllegalArgumentException();
        }
        this.bTO.clear();
        this.key = null;
        this.bTW = null;
        this.bSl = null;
        this.bTV = false;
        this.bRS = false;
        this.bTT = false;
        this.bTX.bZ(false);
        this.bTX = null;
        this.bTU = null;
        this.dataSource = null;
        this.bSL.release(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.glide.load.engine.DecodeJob.a
    public final void c(s<R> sVar, DataSource dataSource) {
        synchronized (this) {
            this.bSl = sVar;
            this.dataSource = dataSource;
        }
        agJ();
    }

    @Override // com.kwad.sdk.glide.load.engine.DecodeJob.a
    public final void b(GlideException glideException) {
        synchronized (this) {
            this.bTU = glideException;
        }
        agL();
    }

    @Override // com.kwad.sdk.glide.load.engine.DecodeJob.a
    public final void b(DecodeJob<?> decodeJob) {
        agI().execute(decodeJob);
    }

    private void agL() {
        synchronized (this) {
            this.bSK.ajJ();
            if (this.bRS) {
                release();
                return;
            }
            if (this.bTO.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
            if (this.bTV) {
                throw new IllegalStateException("Already failed once");
            }
            this.bTV = true;
            com.kwad.sdk.glide.load.c cVar = this.key;
            e eVarAgM = this.bTO.agM();
            gd(eVarAgM.size() + 1);
            this.bTG.a(this, cVar, null);
            Iterator<d> it = eVarAgM.iterator();
            while (it.hasNext()) {
                d next = it.next();
                next.bTZ.execute(new a(next.bTL));
            }
            agK();
        }
    }

    @Override // com.kwad.sdk.glide.e.a.a.c
    public final com.kwad.sdk.glide.e.a.b agy() {
        return this.bSK;
    }

    class a implements Runnable {
        private final com.kwad.sdk.glide.request.j bTL;

        a(com.kwad.sdk.glide.request.j jVar) {
            this.bTL = jVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (j.this) {
                if (j.this.bTO.e(this.bTL)) {
                    j.this.b(this.bTL);
                }
                j.this.agK();
            }
        }
    }

    class b implements Runnable {
        private final com.kwad.sdk.glide.request.j bTL;

        b(com.kwad.sdk.glide.request.j jVar) {
            this.bTL = jVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (j.this) {
                if (j.this.bTO.e(this.bTL)) {
                    j.this.bTW.acquire();
                    j.this.a(this.bTL);
                    j.this.c(this.bTL);
                }
                j.this.agK();
            }
        }
    }

    static final class e implements Iterable<d> {
        private final List<d> bUa;

        e() {
            this(new ArrayList(2));
        }

        private e(List<d> list) {
            this.bUa = list;
        }

        final void b(com.kwad.sdk.glide.request.j jVar, Executor executor) {
            this.bUa.add(new d(jVar, executor));
        }

        final void d(com.kwad.sdk.glide.request.j jVar) {
            this.bUa.remove(f(jVar));
        }

        final boolean e(com.kwad.sdk.glide.request.j jVar) {
            return this.bUa.contains(f(jVar));
        }

        final boolean isEmpty() {
            return this.bUa.isEmpty();
        }

        final int size() {
            return this.bUa.size();
        }

        final void clear() {
            this.bUa.clear();
        }

        final e agM() {
            return new e(new ArrayList(this.bUa));
        }

        private static d f(com.kwad.sdk.glide.request.j jVar) {
            return new d(jVar, com.kwad.sdk.glide.e.e.ajz());
        }

        @Override // java.lang.Iterable
        public final Iterator<d> iterator() {
            return this.bUa.iterator();
        }
    }

    static final class d {
        final com.kwad.sdk.glide.request.j bTL;
        final Executor bTZ;

        d(com.kwad.sdk.glide.request.j jVar, Executor executor) {
            this.bTL = jVar;
            this.bTZ = executor;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.bTL.equals(((d) obj).bTL);
            }
            return false;
        }

        public final int hashCode() {
            return this.bTL.hashCode();
        }
    }

    static class c {
        c() {
        }

        public static <R> n<R> a(s<R> sVar, boolean z) {
            return new n<>(sVar, z, true);
        }
    }
}

package com.kwad.sdk.glide.load.engine;

import android.os.Process;
import com.kwad.sdk.glide.load.engine.n;
import com.kwad.sdk.utils.ax;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class a {
    private final boolean bPQ;
    private final Executor bSc;
    final Map<com.kwad.sdk.glide.load.c, b> bSd;
    private final ReferenceQueue<n<?>> bSe;
    private n.a bSf;
    private volatile boolean bSg;
    private volatile InterfaceC0609a bSh;

    /* renamed from: com.kwad.sdk.glide.load.engine.a$a, reason: collision with other inner class name */
    interface InterfaceC0609a {
    }

    a(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.kwad.sdk.glide.load.engine.a.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(final Runnable runnable) {
                return new Thread(new Runnable() { // from class: com.kwad.sdk.glide.load.engine.a.1.1
                    @Override // java.lang.Runnable
                    public final void run() throws SecurityException, IllegalArgumentException {
                        Process.setThreadPriority(10);
                        runnable.run();
                    }
                }, "ksad-glide-active-resources");
            }
        }));
    }

    private a(boolean z, Executor executor) {
        this.bSd = new HashMap();
        this.bSe = new ReferenceQueue<>();
        this.bPQ = z;
        this.bSc = executor;
        executor.execute(new Runnable() { // from class: com.kwad.sdk.glide.load.engine.a.2
            @Override // java.lang.Runnable
            public final void run() {
                a.this.aga();
            }
        });
    }

    final void a(n.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.bSf = aVar;
            }
        }
    }

    final synchronized void a(com.kwad.sdk.glide.load.c cVar, n<?> nVar) {
        b bVarPut = this.bSd.put(cVar, new b(cVar, nVar, this.bSe, this.bPQ));
        if (bVarPut != null) {
            bVarPut.reset();
        }
    }

    final synchronized void a(com.kwad.sdk.glide.load.c cVar) {
        b bVarRemove = this.bSd.remove(cVar);
        if (bVarRemove != null) {
            bVarRemove.reset();
        }
    }

    final synchronized n<?> b(com.kwad.sdk.glide.load.c cVar) {
        b bVar = this.bSd.get(cVar);
        if (bVar == null) {
            return null;
        }
        n<?> nVar = (n) bVar.get();
        if (nVar == null) {
            a(bVar);
        }
        return nVar;
    }

    private void a(b bVar) {
        synchronized (this.bSf) {
            synchronized (this) {
                this.bSd.remove(bVar.key);
                if (bVar.bSk && bVar.bSl != null) {
                    n<?> nVar = new n<>(bVar.bSl, true, false);
                    nVar.a(bVar.key, this.bSf);
                    this.bSf.b(bVar.key, nVar);
                }
            }
        }
    }

    final void aga() {
        while (!this.bSg) {
            try {
                a((b) this.bSe.remove());
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static final class b extends WeakReference<n<?>> {
        final boolean bSk;
        s<?> bSl;
        final com.kwad.sdk.glide.load.c key;

        b(com.kwad.sdk.glide.load.c cVar, n<?> nVar, ReferenceQueue<? super n<?>> referenceQueue, boolean z) {
            super(nVar, referenceQueue);
            this.key = (com.kwad.sdk.glide.load.c) ax.checkNotNull(cVar);
            this.bSl = (nVar.agO() && z) ? (s) ax.checkNotNull(nVar.agN()) : null;
            this.bSk = nVar.agO();
        }

        final void reset() {
            this.bSl = null;
            clear();
        }
    }
}

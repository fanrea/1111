package com.kwad.sdk.glide.load.engine;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.core.util.Pools;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.e.a.a;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.engine.DecodeJob;
import com.kwad.sdk.glide.load.engine.a.a;
import com.kwad.sdk.glide.load.engine.a.h;
import com.kwad.sdk.glide.load.engine.n;
import com.kwad.sdk.utils.ax;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class i implements h.a, k, n.a {
    private static final boolean bTu = Log.isLoggable("Engine", 2);
    private final c bTA;
    private final a bTB;
    private final com.kwad.sdk.glide.load.engine.a bTC;
    private final p bTv;
    private final m bTw;
    private final com.kwad.sdk.glide.load.engine.a.h bTx;
    private final b bTy;
    private final v bTz;

    public i(com.kwad.sdk.glide.load.engine.a.h hVar, a.InterfaceC0610a interfaceC0610a, com.kwad.sdk.glide.load.engine.b.a aVar, com.kwad.sdk.glide.load.engine.b.a aVar2, com.kwad.sdk.glide.load.engine.b.a aVar3, com.kwad.sdk.glide.load.engine.b.a aVar4, boolean z) {
        this(hVar, interfaceC0610a, aVar, aVar2, aVar3, aVar4, null, null, null, null, null, null, z);
    }

    private i(com.kwad.sdk.glide.load.engine.a.h hVar, a.InterfaceC0610a interfaceC0610a, com.kwad.sdk.glide.load.engine.b.a aVar, com.kwad.sdk.glide.load.engine.b.a aVar2, com.kwad.sdk.glide.load.engine.b.a aVar3, com.kwad.sdk.glide.load.engine.b.a aVar4, p pVar, m mVar, com.kwad.sdk.glide.load.engine.a aVar5, b bVar, a aVar6, v vVar, boolean z) {
        this.bTx = hVar;
        c cVar = new c(interfaceC0610a);
        this.bTA = cVar;
        com.kwad.sdk.glide.load.engine.a aVar7 = new com.kwad.sdk.glide.load.engine.a(z);
        this.bTC = aVar7;
        aVar7.a(this);
        this.bTw = new m();
        this.bTv = new p();
        this.bTy = new b(aVar, aVar2, aVar3, aVar4, this);
        this.bTB = new a(cVar);
        this.bTz = new v();
        hVar.a(this);
    }

    public final synchronized <R> d a(com.kwad.sdk.glide.e eVar, Object obj, com.kwad.sdk.glide.load.c cVar, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, h hVar, Map<Class<?>, com.kwad.sdk.glide.load.i<?>> map, boolean z, boolean z2, com.kwad.sdk.glide.load.f fVar, boolean z3, boolean z4, boolean z5, boolean z6, com.kwad.sdk.glide.request.j jVar, Executor executor) {
        boolean z7 = bTu;
        long jAjA = z7 ? com.kwad.sdk.glide.e.f.ajA() : 0L;
        l lVarA = m.a(obj, cVar, i, i2, map, cls, cls2, fVar);
        n<?> nVarA = a(lVarA, z3);
        if (nVarA != null && a(nVarA)) {
            jVar.c(nVarA, DataSource.MEMORY_CACHE);
            if (z7) {
                a("Loaded resource from active resources", jAjA, lVarA);
            }
            return null;
        }
        s<?> sVarB = b(lVarA, z3);
        if (sVarB != null) {
            jVar.c(sVarB, DataSource.MEMORY_CACHE);
            if (z7) {
                a("Loaded resource from cache", jAjA, lVarA);
            }
            return null;
        }
        j<?> jVarC = this.bTv.c(lVarA, z6);
        if (jVarC != null) {
            jVarC.a(jVar, executor);
            if (z7) {
                a("Added to existing load", jAjA, lVarA);
            }
            return new d(jVar, jVarC);
        }
        j<R> jVarA = this.bTy.a(lVarA, z3, z4, z5, z6);
        DecodeJob<R> decodeJobA = this.bTB.a(eVar, obj, lVarA, cVar, i, i2, cls, cls2, priority, hVar, map, z, z2, z6, fVar, jVarA);
        this.bTv.a(lVarA, jVarA);
        jVarA.a(jVar, executor);
        jVarA.c(decodeJobA);
        if (z7) {
            a("Started new load", jAjA, lVarA);
        }
        return new d(jVar, jVarA);
    }

    private static boolean a(n nVar) {
        if (nVar.agN() == null) {
            return false;
        }
        return ((nVar.get() instanceof Bitmap) && ((Bitmap) nVar.get()).isRecycled()) ? false : true;
    }

    private static void a(String str, long j, com.kwad.sdk.glide.load.c cVar) {
        Log.v("Engine", str + " in " + com.kwad.sdk.glide.e.f.bq(j) + "ms, key: " + cVar);
    }

    private n<?> a(com.kwad.sdk.glide.load.c cVar, boolean z) {
        if (!z) {
            return null;
        }
        n<?> nVarB = this.bTC.b(cVar);
        if (nVarB != null) {
            nVarB.acquire();
        }
        return nVarB;
    }

    private n<?> b(com.kwad.sdk.glide.load.c cVar, boolean z) {
        if (!z) {
            return null;
        }
        n<?> nVarD = d(cVar);
        if (nVarD != null) {
            nVarD.acquire();
            this.bTC.a(cVar, nVarD);
        }
        return nVarD;
    }

    private n<?> d(com.kwad.sdk.glide.load.c cVar) {
        s<?> sVarF = this.bTx.f(cVar);
        if (sVarF == null) {
            return null;
        }
        if (sVarF instanceof n) {
            return (n) sVarF;
        }
        return new n<>(sVarF, true, true);
    }

    public static void d(s<?> sVar) {
        if (sVar instanceof n) {
            ((n) sVar).release();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    @Override // com.kwad.sdk.glide.load.engine.k
    public final synchronized void a(j<?> jVar, com.kwad.sdk.glide.load.c cVar, n<?> nVar) {
        if (nVar != null) {
            nVar.a(cVar, this);
            if (nVar.agO()) {
                this.bTC.a(cVar, nVar);
            }
            this.bTv.b(cVar, jVar);
        } else {
            this.bTv.b(cVar, jVar);
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.k
    public final synchronized void a(j<?> jVar, com.kwad.sdk.glide.load.c cVar) {
        this.bTv.b(cVar, jVar);
    }

    @Override // com.kwad.sdk.glide.load.engine.a.h.a
    public final void e(s<?> sVar) {
        this.bTz.h(sVar);
    }

    @Override // com.kwad.sdk.glide.load.engine.n.a
    public final synchronized void b(com.kwad.sdk.glide.load.c cVar, n<?> nVar) {
        this.bTC.a(cVar);
        if (nVar.agO()) {
            this.bTx.a(cVar, nVar);
        } else {
            this.bTz.h(nVar);
        }
    }

    public class d {
        private final j<?> bTK;
        private final com.kwad.sdk.glide.request.j bTL;

        d(com.kwad.sdk.glide.request.j jVar, j<?> jVar2) {
            this.bTL = jVar;
            this.bTK = jVar2;
        }

        public final void cancel() {
            synchronized (i.this) {
                this.bTK.c(this.bTL);
            }
        }
    }

    static class c implements DecodeJob.d {
        private final a.InterfaceC0610a bTI;
        private volatile com.kwad.sdk.glide.load.engine.a.a bTJ;

        c(a.InterfaceC0610a interfaceC0610a) {
            this.bTI = interfaceC0610a;
        }

        @Override // com.kwad.sdk.glide.load.engine.DecodeJob.d
        public final com.kwad.sdk.glide.load.engine.a.a age() {
            if (this.bTJ == null) {
                synchronized (this) {
                    if (this.bTJ == null) {
                        this.bTJ = this.bTI.ahd();
                    }
                    if (this.bTJ == null) {
                        this.bTJ = new com.kwad.sdk.glide.load.engine.a.b();
                    }
                }
            }
            return this.bTJ;
        }
    }

    static class a {
        final DecodeJob.d bSA;
        final Pools.Pool<DecodeJob<?>> bSL = com.kwad.sdk.glide.e.a.a.a(150, new a.InterfaceC0602a<DecodeJob<?>>() { // from class: com.kwad.sdk.glide.load.engine.i.a.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.glide.e.a.a.InterfaceC0602a
            /* renamed from: agE, reason: merged with bridge method [inline-methods] */
            public DecodeJob<?> agF() {
                return new DecodeJob<>(a.this.bSA, a.this.bSL);
            }
        });
        private int bTD;

        a(DecodeJob.d dVar) {
            this.bSA = dVar;
        }

        final <R> DecodeJob<R> a(com.kwad.sdk.glide.e eVar, Object obj, l lVar, com.kwad.sdk.glide.load.c cVar, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, h hVar, Map<Class<?>, com.kwad.sdk.glide.load.i<?>> map, boolean z, boolean z2, boolean z3, com.kwad.sdk.glide.load.f fVar, DecodeJob.a<R> aVar) {
            DecodeJob decodeJob = (DecodeJob) ax.checkNotNull(this.bSL.acquire());
            int i3 = this.bTD;
            this.bTD = i3 + 1;
            return decodeJob.a(eVar, obj, lVar, cVar, i, i2, cls, cls2, priority, hVar, map, z, z2, z3, fVar, aVar, i3);
        }
    }

    static class b {
        final com.kwad.sdk.glide.load.engine.b.a bPJ;
        final com.kwad.sdk.glide.load.engine.b.a bPK;
        final com.kwad.sdk.glide.load.engine.b.a bPP;
        final Pools.Pool<j<?>> bSL = com.kwad.sdk.glide.e.a.a.a(150, new a.InterfaceC0602a<j<?>>() { // from class: com.kwad.sdk.glide.load.engine.i.b.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.glide.e.a.a.InterfaceC0602a
            /* renamed from: agG, reason: merged with bridge method [inline-methods] */
            public j<?> agF() {
                return new j<>(b.this.bPK, b.this.bPJ, b.this.bTF, b.this.bPP, b.this.bTG, b.this.bSL);
            }
        });
        final com.kwad.sdk.glide.load.engine.b.a bTF;
        final k bTG;

        b(com.kwad.sdk.glide.load.engine.b.a aVar, com.kwad.sdk.glide.load.engine.b.a aVar2, com.kwad.sdk.glide.load.engine.b.a aVar3, com.kwad.sdk.glide.load.engine.b.a aVar4, k kVar) {
            this.bPK = aVar;
            this.bPJ = aVar2;
            this.bTF = aVar3;
            this.bPP = aVar4;
            this.bTG = kVar;
        }

        final <R> j<R> a(com.kwad.sdk.glide.load.c cVar, boolean z, boolean z2, boolean z3, boolean z4) {
            return ((j) ax.checkNotNull(this.bSL.acquire())).b(cVar, z, z2, z3, z4);
        }
    }
}

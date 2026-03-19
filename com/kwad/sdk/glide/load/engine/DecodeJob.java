package com.kwad.sdk.glide.load.engine;

import android.os.Build;
import android.util.Log;
import androidx.core.util.Pools;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.Registry;
import com.kwad.sdk.glide.e.a.a;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.EncodeStrategy;
import com.kwad.sdk.glide.load.engine.e;
import com.kwad.sdk.glide.load.engine.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class DecodeJob<R> implements a.c, e.a, Comparable<DecodeJob<?>>, Runnable {
    private com.kwad.sdk.glide.e bPB;
    private Object bQj;
    private volatile boolean bRS;
    private final d bSA;
    private Priority bSE;
    private h bSF;
    private final Pools.Pool<DecodeJob<?>> bSL;
    private l bSO;
    private a<R> bSP;
    private Stage bSQ;
    private RunReason bSR;
    private long bSS;
    private boolean bST;
    private Thread bSU;
    private com.kwad.sdk.glide.load.c bSV;
    private com.kwad.sdk.glide.load.c bSW;
    private Object bSX;
    private DataSource bSY;
    private com.kwad.sdk.glide.load.a.d<?> bSZ;
    private com.kwad.sdk.glide.load.c bSv;
    private com.kwad.sdk.glide.load.f bSx;
    private volatile com.kwad.sdk.glide.load.engine.e bTa;
    private volatile boolean bTb;
    private int height;
    private int order;
    private int width;
    private final f<R> bSI = new f<>();
    private final List<Throwable> bSJ = new ArrayList();
    private final com.kwad.sdk.glide.e.a.b bSK = com.kwad.sdk.glide.e.a.b.ajI();
    private final c<?> bSM = new c<>();
    private final e bSN = new e();

    enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    interface a<R> {
        void b(DecodeJob<?> decodeJob);

        void b(GlideException glideException);

        void c(s<R> sVar, DataSource dataSource);
    }

    interface d {
        com.kwad.sdk.glide.load.engine.a.a age();
    }

    DecodeJob(d dVar, Pools.Pool<DecodeJob<?>> pool) {
        this.bSA = dVar;
        this.bSL = pool;
    }

    final DecodeJob<R> a(com.kwad.sdk.glide.e eVar, Object obj, l lVar, com.kwad.sdk.glide.load.c cVar, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, h hVar, Map<Class<?>, com.kwad.sdk.glide.load.i<?>> map, boolean z, boolean z2, boolean z3, com.kwad.sdk.glide.load.f fVar, a<R> aVar, int i3) {
        this.bSI.a(eVar, obj, cVar, i, i2, hVar, cls, cls2, priority, fVar, map, z, z2, this.bSA);
        this.bPB = eVar;
        this.bSv = cVar;
        this.bSE = priority;
        this.bSO = lVar;
        this.width = i;
        this.height = i2;
        this.bSF = hVar;
        this.bST = z3;
        this.bSx = fVar;
        this.bSP = aVar;
        this.order = i3;
        this.bSR = RunReason.INITIALIZE;
        this.bQj = obj;
        return this;
    }

    final boolean agp() {
        Stage stageA = a(Stage.INITIALIZE);
        return stageA == Stage.RESOURCE_CACHE || stageA == Stage.DATA_CACHE;
    }

    final void bZ(boolean z) {
        if (this.bSN.cP(false)) {
            releaseInternal();
        }
    }

    private void agq() {
        if (this.bSN.agA()) {
            releaseInternal();
        }
    }

    private void agr() {
        if (this.bSN.agB()) {
            releaseInternal();
        }
    }

    private void releaseInternal() {
        this.bSN.reset();
        this.bSM.clear();
        this.bSI.clear();
        this.bTb = false;
        this.bPB = null;
        this.bSv = null;
        this.bSx = null;
        this.bSE = null;
        this.bSO = null;
        this.bSP = null;
        this.bSQ = null;
        this.bTa = null;
        this.bSU = null;
        this.bSV = null;
        this.bSX = null;
        this.bSY = null;
        this.bSZ = null;
        this.bSS = 0L;
        this.bRS = false;
        this.bQj = null;
        this.bSJ.clear();
        this.bSL.release(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(DecodeJob<?> decodeJob) {
        int priority = getPriority() - decodeJob.getPriority();
        return priority == 0 ? this.order - decodeJob.order : priority;
    }

    private int getPriority() {
        return this.bSE.ordinal();
    }

    public final void cancel() {
        this.bRS = true;
        com.kwad.sdk.glide.load.engine.e eVar = this.bTa;
        if (eVar != null) {
            eVar.cancel();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.kwad.sdk.glide.load.a.d<?> dVar = this.bSZ;
        try {
            try {
                try {
                    if (this.bRS) {
                        agv();
                        if (dVar != null) {
                            dVar.afU();
                            return;
                        }
                        return;
                    }
                    ags();
                    if (dVar != null) {
                        dVar.afU();
                    }
                } catch (Throwable th) {
                    if (Log.isLoggable("DecodeJob", 3)) {
                        Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.bRS + ", stage: " + this.bSQ, th);
                    }
                    if (this.bSQ != Stage.ENCODE) {
                        this.bSJ.add(th);
                        agv();
                    }
                    if (!this.bRS) {
                        throw th;
                    }
                    throw th;
                }
            } catch (CallbackException e2) {
                throw e2;
            }
        } catch (Throwable th2) {
            if (dVar != null) {
                dVar.afU();
            }
            throw th2;
        }
    }

    private void ags() {
        int i = AnonymousClass1.bTc[this.bSR.ordinal()];
        if (i == 1) {
            this.bSQ = a(Stage.INITIALIZE);
            this.bTa = agt();
            agu();
        } else if (i == 2) {
            agu();
        } else {
            if (i == 3) {
                agx();
                return;
            }
            throw new IllegalStateException("Unrecognized run reason: " + this.bSR);
        }
    }

    private com.kwad.sdk.glide.load.engine.e agt() {
        int i = AnonymousClass1.bTd[this.bSQ.ordinal()];
        if (i == 1) {
            return new t(this.bSI, this);
        }
        if (i == 2) {
            return new com.kwad.sdk.glide.load.engine.b(this.bSI, this);
        }
        if (i == 3) {
            return new w(this.bSI, this);
        }
        if (i == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.bSQ);
    }

    private void agu() {
        this.bSU = Thread.currentThread();
        this.bSS = com.kwad.sdk.glide.e.f.ajA();
        boolean zAgb = false;
        while (!this.bRS && this.bTa != null && !(zAgb = this.bTa.agb())) {
            this.bSQ = a(this.bSQ);
            this.bTa = agt();
            if (this.bSQ == Stage.SOURCE) {
                agd();
                return;
            }
        }
        if ((this.bSQ == Stage.FINISHED || this.bRS) && !zAgb) {
            agv();
        }
    }

    private void agv() {
        agw();
        this.bSP.b(new GlideException("Failed to load resource", new ArrayList(this.bSJ)));
        agr();
    }

    private void a(s<R> sVar, DataSource dataSource) {
        agw();
        this.bSP.c(sVar, dataSource);
    }

    private void agw() {
        Throwable th;
        this.bSK.ajJ();
        if (this.bTb) {
            if (this.bSJ.isEmpty()) {
                th = null;
            } else {
                List<Throwable> list = this.bSJ;
                th = list.get(list.size() - 1);
            }
            throw new IllegalStateException("Already notified", th);
        }
        this.bTb = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        return com.kwad.sdk.glide.load.engine.DecodeJob.Stage.FINISHED;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.kwad.sdk.glide.load.engine.DecodeJob.Stage a(com.kwad.sdk.glide.load.engine.DecodeJob.Stage r4) {
        /*
            r3 = this;
        L0:
            int[] r0 = com.kwad.sdk.glide.load.engine.DecodeJob.AnonymousClass1.bTd
            int r1 = r4.ordinal()
            r0 = r0[r1]
            r1 = 1
            if (r0 == r1) goto L47
            r1 = 2
            if (r0 == r1) goto L3d
            r1 = 3
            if (r0 == r1) goto L3a
            r1 = 4
            if (r0 == r1) goto L3a
            r1 = 5
            if (r0 != r1) goto L25
            com.kwad.sdk.glide.load.engine.h r4 = r3.bSF
            boolean r4 = r4.agC()
            if (r4 == 0) goto L22
            com.kwad.sdk.glide.load.engine.DecodeJob$Stage r4 = com.kwad.sdk.glide.load.engine.DecodeJob.Stage.RESOURCE_CACHE
            return r4
        L22:
            com.kwad.sdk.glide.load.engine.DecodeJob$Stage r4 = com.kwad.sdk.glide.load.engine.DecodeJob.Stage.RESOURCE_CACHE
            goto L0
        L25:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unrecognized stage: "
            r1.<init>(r2)
            java.lang.StringBuilder r4 = r1.append(r4)
            java.lang.String r4 = r4.toString()
            r0.<init>(r4)
            throw r0
        L3a:
            com.kwad.sdk.glide.load.engine.DecodeJob$Stage r4 = com.kwad.sdk.glide.load.engine.DecodeJob.Stage.FINISHED
            return r4
        L3d:
            boolean r4 = r3.bST
            if (r4 == 0) goto L44
            com.kwad.sdk.glide.load.engine.DecodeJob$Stage r4 = com.kwad.sdk.glide.load.engine.DecodeJob.Stage.FINISHED
            return r4
        L44:
            com.kwad.sdk.glide.load.engine.DecodeJob$Stage r4 = com.kwad.sdk.glide.load.engine.DecodeJob.Stage.SOURCE
            return r4
        L47:
            com.kwad.sdk.glide.load.engine.h r4 = r3.bSF
            boolean r4 = r4.agD()
            if (r4 == 0) goto L52
            com.kwad.sdk.glide.load.engine.DecodeJob$Stage r4 = com.kwad.sdk.glide.load.engine.DecodeJob.Stage.DATA_CACHE
            return r4
        L52:
            com.kwad.sdk.glide.load.engine.DecodeJob$Stage r4 = com.kwad.sdk.glide.load.engine.DecodeJob.Stage.DATA_CACHE
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.glide.load.engine.DecodeJob.a(com.kwad.sdk.glide.load.engine.DecodeJob$Stage):com.kwad.sdk.glide.load.engine.DecodeJob$Stage");
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public final void agd() {
        this.bSR = RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.bSP.b((DecodeJob<?>) this);
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public final void a(com.kwad.sdk.glide.load.c cVar, Object obj, com.kwad.sdk.glide.load.a.d<?> dVar, DataSource dataSource, com.kwad.sdk.glide.load.c cVar2) {
        this.bSV = cVar;
        this.bSX = obj;
        this.bSZ = dVar;
        this.bSY = dataSource;
        this.bSW = cVar2;
        if (Thread.currentThread() != this.bSU) {
            this.bSR = RunReason.DECODE_DATA;
            this.bSP.b((DecodeJob<?>) this);
        } else {
            agx();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public final void a(com.kwad.sdk.glide.load.c cVar, Exception exc, com.kwad.sdk.glide.load.a.d<?> dVar, DataSource dataSource) {
        dVar.afU();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        glideException.setLoggingDetails(cVar, dataSource, dVar.afT());
        this.bSJ.add(glideException);
        if (Thread.currentThread() != this.bSU) {
            this.bSR = RunReason.SWITCH_TO_SOURCE_SERVICE;
            this.bSP.b((DecodeJob<?>) this);
        } else {
            agu();
        }
    }

    private void agx() {
        if (Log.isLoggable("DecodeJob", 2)) {
            e("Retrieved data", this.bSS, "data: " + this.bSX + ", cache key: " + this.bSV + ", fetcher: " + this.bSZ);
        }
        s<R> sVarA = null;
        try {
            sVarA = a(this.bSZ, (com.kwad.sdk.glide.load.a.d<?>) this.bSX, this.bSY);
        } catch (GlideException e2) {
            e2.setLoggingDetails(this.bSW, this.bSY);
            this.bSJ.add(e2);
        }
        if (sVarA != null) {
            b(sVarA, this.bSY);
        } else {
            agu();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(s<R> sVar, DataSource dataSource) {
        if (sVar instanceof o) {
            ((o) sVar).initialize();
        }
        r rVar = 0;
        if (this.bSM.agz()) {
            sVar = r.f(sVar);
            rVar = sVar;
        }
        a((s) sVar, dataSource);
        this.bSQ = Stage.ENCODE;
        try {
            if (this.bSM.agz()) {
                this.bSM.a(this.bSA, this.bSx);
            }
            agq();
        } finally {
            if (rVar != 0) {
                rVar.unlock();
            }
        }
    }

    private <Data> s<R> a(com.kwad.sdk.glide.load.a.d<?> dVar, Data data, DataSource dataSource) {
        if (data != null) {
            try {
                long jAjA = com.kwad.sdk.glide.e.f.ajA();
                s<R> sVarA = a((DecodeJob<R>) data, dataSource);
                if (Log.isLoggable("DecodeJob", 2)) {
                    g("Decoded result " + sVarA, jAjA);
                }
                return sVarA;
            } finally {
                dVar.afU();
            }
        }
        dVar.afU();
        return null;
    }

    private <Data> s<R> a(Data data, DataSource dataSource) {
        return a((DecodeJob<R>) data, dataSource, (q<DecodeJob<R>, ResourceType, R>) this.bSI.k(data.getClass()));
    }

    private com.kwad.sdk.glide.load.f a(DataSource dataSource) {
        com.kwad.sdk.glide.load.f fVar = this.bSx;
        if (Build.VERSION.SDK_INT < 26) {
            return fVar;
        }
        boolean z = dataSource == DataSource.RESOURCE_DISK_CACHE || this.bSI.agm();
        Boolean bool = (Boolean) fVar.a(com.kwad.sdk.glide.load.resource.bitmap.k.bXu);
        if (bool != null && (!bool.booleanValue() || z)) {
            return fVar;
        }
        com.kwad.sdk.glide.load.f fVar2 = new com.kwad.sdk.glide.load.f();
        fVar2.a(this.bSx);
        fVar2.a(com.kwad.sdk.glide.load.resource.bitmap.k.bXu, Boolean.valueOf(z));
        return fVar2;
    }

    private <Data, ResourceType> s<R> a(Data data, DataSource dataSource, q<Data, ResourceType, R> qVar) {
        com.kwad.sdk.glide.load.f fVarA = a(dataSource);
        com.kwad.sdk.glide.load.a.e<Data> eVarS = this.bPB.afe().s(data);
        try {
            return qVar.a(eVarS, fVarA, this.width, this.height, new b(dataSource));
        } finally {
            eVarS.afU();
        }
    }

    private void g(String str, long j) {
        e(str, j, null);
    }

    private void e(String str, long j, String str2) {
        Log.v("DecodeJob", str + " in " + com.kwad.sdk.glide.e.f.bq(j) + ", load key: " + this.bSO + (str2 != null ? ", " + str2 : "") + ", thread: " + Thread.currentThread().getName());
    }

    @Override // com.kwad.sdk.glide.e.a.a.c
    public final com.kwad.sdk.glide.e.a.b agy() {
        return this.bSK;
    }

    final <Z> s<Z> a(DataSource dataSource, s<Z> sVar) {
        s<Z> sVarTransform;
        com.kwad.sdk.glide.load.i<Z> iVar;
        EncodeStrategy encodeStrategyB;
        com.kwad.sdk.glide.load.c cVar;
        Class<?> cls = sVar.get().getClass();
        com.kwad.sdk.glide.load.h<Z> hVarB = null;
        if (dataSource != DataSource.RESOURCE_DISK_CACHE) {
            com.kwad.sdk.glide.load.i<Z> iVarL = this.bSI.l(cls);
            iVar = iVarL;
            sVarTransform = iVarL.transform(this.bPB, sVar, this.width, this.height);
        } else {
            sVarTransform = sVar;
            iVar = null;
        }
        if (!sVar.equals(sVarTransform)) {
            sVar.recycle();
        }
        if (this.bSI.a(sVarTransform)) {
            hVarB = this.bSI.b(sVarTransform);
            encodeStrategyB = hVarB.b(this.bSx);
        } else {
            encodeStrategyB = EncodeStrategy.NONE;
        }
        com.kwad.sdk.glide.load.h hVar = hVarB;
        if (!this.bSF.a(!this.bSI.c(this.bSV), dataSource, encodeStrategyB)) {
            return sVarTransform;
        }
        if (hVar == null) {
            throw new Registry.NoResultEncoderAvailableException(sVarTransform.get().getClass());
        }
        int i = AnonymousClass1.bTe[encodeStrategyB.ordinal()];
        if (i == 1) {
            cVar = new com.kwad.sdk.glide.load.engine.c(this.bSV, this.bSv);
        } else if (i == 2) {
            cVar = new u(this.bSI.afa(), this.bSV, this.bSv, this.width, this.height, iVar, cls, this.bSx);
        } else {
            throw new IllegalArgumentException("Unknown strategy: " + encodeStrategyB);
        }
        r rVarF = r.f(sVarTransform);
        this.bSM.a(cVar, hVar, rVarF);
        return rVarF;
    }

    /* renamed from: com.kwad.sdk.glide.load.engine.DecodeJob$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] bTc;
        static final /* synthetic */ int[] bTd;
        static final /* synthetic */ int[] bTe;

        static {
            int[] iArr = new int[EncodeStrategy.values().length];
            bTe = iArr;
            try {
                iArr[EncodeStrategy.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                bTe[EncodeStrategy.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Stage.values().length];
            bTd = iArr2;
            try {
                iArr2[Stage.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                bTd[Stage.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                bTd[Stage.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                bTd[Stage.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                bTd[Stage.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[RunReason.values().length];
            bTc = iArr3;
            try {
                iArr3[RunReason.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                bTc[RunReason.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                bTc[RunReason.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    final class b<Z> implements g.a<Z> {
        private final DataSource dataSource;

        b(DataSource dataSource) {
            this.dataSource = dataSource;
        }

        @Override // com.kwad.sdk.glide.load.engine.g.a
        public final s<Z> c(s<Z> sVar) {
            return DecodeJob.this.a(this.dataSource, sVar);
        }
    }

    static class e {
        private boolean bTi;
        private boolean bTj;
        private boolean bTk;

        e() {
        }

        final synchronized boolean cP(boolean z) {
            this.bTi = true;
            return cQ(z);
        }

        final synchronized boolean agA() {
            this.bTj = true;
            return cQ(false);
        }

        final synchronized boolean agB() {
            this.bTk = true;
            return cQ(false);
        }

        final synchronized void reset() {
            this.bTj = false;
            this.bTi = false;
            this.bTk = false;
        }

        private boolean cQ(boolean z) {
            return (this.bTk || z || this.bTj) && this.bTi;
        }
    }

    static class c<Z> {
        private com.kwad.sdk.glide.load.h<Z> bTg;
        private r<Z> bTh;
        private com.kwad.sdk.glide.load.c key;

        c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        final <X> void a(com.kwad.sdk.glide.load.c cVar, com.kwad.sdk.glide.load.h<X> hVar, r<X> rVar) {
            this.key = cVar;
            this.bTg = hVar;
            this.bTh = rVar;
        }

        final void a(d dVar, com.kwad.sdk.glide.load.f fVar) {
            try {
                dVar.age().a(this.key, new com.kwad.sdk.glide.load.engine.d(this.bTg, this.bTh, fVar));
            } finally {
                this.bTh.unlock();
            }
        }

        final boolean agz() {
            return this.bTh != null;
        }

        final void clear() {
            this.key = null;
            this.bTg = null;
            this.bTh = null;
        }
    }
}

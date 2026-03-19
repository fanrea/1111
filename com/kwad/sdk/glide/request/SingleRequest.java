package com.kwad.sdk.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.core.util.Pools;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.e.a.a;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.engine.GlideException;
import com.kwad.sdk.glide.load.engine.i;
import com.kwad.sdk.glide.load.engine.s;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class SingleRequest<R> implements a.c, com.kwad.sdk.glide.request.a.i, e, j {
    private static final Pools.Pool<SingleRequest<?>> bUk = com.kwad.sdk.glide.e.a.a.a(150, new a.InterfaceC0602a<SingleRequest<?>>() { // from class: com.kwad.sdk.glide.request.SingleRequest.1
        @Override // com.kwad.sdk.glide.e.a.a.InterfaceC0602a
        public final /* synthetic */ SingleRequest<?> agF() {
            return ajp();
        }

        private static SingleRequest<?> ajp() {
            return new SingleRequest<>();
        }
    });
    private static final boolean bZG = Log.isLoggable("Request", 2);
    private com.kwad.sdk.glide.e bPB;
    private com.kwad.sdk.glide.load.engine.i bPx;
    private Class<R> bQh;
    private Object bQj;
    private List<h<R>> bQk;
    private Priority bSE;
    private final com.kwad.sdk.glide.e.a.b bSK;
    private s<R> bSl;
    private boolean bZF;
    private h<R> bZH;
    private f bZI;
    private b<?> bZJ;
    private com.kwad.sdk.glide.request.a.j<R> bZK;
    private com.kwad.sdk.glide.request.b.c<? super R> bZL;
    private Executor bZM;
    private i.d bZN;
    private Status bZO;
    private Drawable bZP;
    private RuntimeException bZQ;
    private Drawable bZm;
    private int bZo;
    private int bZp;
    private Drawable bZr;
    private Context dR;
    private int height;
    private long startTime;
    private final String tag;
    private int width;

    enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public static <R> SingleRequest<R> a(Context context, com.kwad.sdk.glide.e eVar, Object obj, Class<R> cls, b<?> bVar, int i, int i2, Priority priority, com.kwad.sdk.glide.request.a.j<R> jVar, h<R> hVar, List<h<R>> list, f fVar, com.kwad.sdk.glide.load.engine.i iVar, com.kwad.sdk.glide.request.b.c<? super R> cVar, Executor executor) {
        SingleRequest<R> singleRequest = (SingleRequest) bUk.acquire();
        if (singleRequest == null) {
            singleRequest = new SingleRequest<>();
        }
        singleRequest.b(context, eVar, obj, cls, bVar, i, i2, priority, jVar, hVar, list, fVar, iVar, cVar, executor);
        return singleRequest;
    }

    SingleRequest() {
        this.tag = bZG ? String.valueOf(super.hashCode()) : null;
        this.bSK = com.kwad.sdk.glide.e.a.b.ajI();
    }

    private synchronized void b(Context context, com.kwad.sdk.glide.e eVar, Object obj, Class<R> cls, b<?> bVar, int i, int i2, Priority priority, com.kwad.sdk.glide.request.a.j<R> jVar, h<R> hVar, List<h<R>> list, f fVar, com.kwad.sdk.glide.load.engine.i iVar, com.kwad.sdk.glide.request.b.c<? super R> cVar, Executor executor) {
        this.dR = context;
        this.bPB = eVar;
        this.bQj = obj;
        this.bQh = cls;
        this.bZJ = bVar;
        this.bZp = i;
        this.bZo = i2;
        this.bSE = priority;
        this.bZK = jVar;
        this.bZH = hVar;
        this.bQk = list;
        this.bZI = fVar;
        this.bPx = iVar;
        this.bZL = cVar;
        this.bZM = executor;
        this.bZO = Status.PENDING;
        if (this.bZQ == null && eVar.afi()) {
            this.bZQ = new RuntimeException("Glide request origin trace");
        }
    }

    @Override // com.kwad.sdk.glide.e.a.a.c
    public final com.kwad.sdk.glide.e.a.b agy() {
        return this.bSK;
    }

    @Override // com.kwad.sdk.glide.request.e
    public final synchronized void recycle() {
        ajh();
        this.dR = null;
        this.bPB = null;
        this.bQj = null;
        this.bQh = null;
        this.bZJ = null;
        this.bZp = -1;
        this.bZo = -1;
        this.bZK = null;
        this.bQk = null;
        this.bZH = null;
        this.bZI = null;
        this.bZL = null;
        this.bZN = null;
        this.bZP = null;
        this.bZm = null;
        this.bZr = null;
        this.width = -1;
        this.height = -1;
        this.bZQ = null;
        bUk.release(this);
    }

    @Override // com.kwad.sdk.glide.request.e
    public final synchronized void begin() {
        ajh();
        this.bSK.ajJ();
        this.startTime = com.kwad.sdk.glide.e.f.ajA();
        if (this.bQj == null) {
            if (com.kwad.sdk.glide.e.j.Y(this.bZp, this.bZo)) {
                this.width = this.bZp;
                this.height = this.bZo;
            }
            a(new GlideException("Received null model"), aiP() == null ? 5 : 3);
            return;
        }
        if (this.bZO == Status.RUNNING) {
            throw new IllegalArgumentException("Cannot restart a running request");
        }
        if (this.bZO == Status.COMPLETE) {
            c(this.bSl, DataSource.MEMORY_CACHE);
            return;
        }
        this.bZO = Status.WAITING_FOR_SIZE;
        if (com.kwad.sdk.glide.e.j.Y(this.bZp, this.bZo)) {
            V(this.bZp, this.bZo);
        } else {
            this.bZK.getSize(this);
        }
        if ((this.bZO == Status.RUNNING || this.bZO == Status.WAITING_FOR_SIZE) && ajm()) {
            this.bZK.onLoadStarted(aiN());
        }
        if (bZG) {
            hr("finished run method in " + com.kwad.sdk.glide.e.f.bq(this.startTime));
        }
    }

    private void cancel() {
        ajh();
        this.bSK.ajJ();
        this.bZK.removeCallback(this);
        i.d dVar = this.bZN;
        if (dVar != null) {
            dVar.cancel();
            this.bZN = null;
        }
    }

    private void ajh() {
        if (this.bZF) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @Override // com.kwad.sdk.glide.request.e
    public final synchronized void clear() {
        ajh();
        this.bSK.ajJ();
        if (this.bZO == Status.CLEARED) {
            return;
        }
        cancel();
        s<R> sVar = this.bSl;
        if (sVar != null) {
            l(sVar);
        }
        if (ajl()) {
            this.bZK.onLoadCleared(aiN());
        }
        this.bZO = Status.CLEARED;
    }

    private void l(s<?> sVar) {
        com.kwad.sdk.glide.load.engine.i.d(sVar);
        this.bSl = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0011  */
    @Override // com.kwad.sdk.glide.request.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized boolean isRunning() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.kwad.sdk.glide.request.SingleRequest$Status r0 = r2.bZO     // Catch: java.lang.Throwable -> L13
            com.kwad.sdk.glide.request.SingleRequest$Status r1 = com.kwad.sdk.glide.request.SingleRequest.Status.RUNNING     // Catch: java.lang.Throwable -> L13
            if (r0 == r1) goto L11
            com.kwad.sdk.glide.request.SingleRequest$Status r0 = r2.bZO     // Catch: java.lang.Throwable -> L13
            com.kwad.sdk.glide.request.SingleRequest$Status r1 = com.kwad.sdk.glide.request.SingleRequest.Status.WAITING_FOR_SIZE     // Catch: java.lang.Throwable -> L13
            if (r0 != r1) goto Le
            goto L11
        Le:
            r0 = 0
        Lf:
            monitor-exit(r2)
            return r0
        L11:
            r0 = 1
            goto Lf
        L13:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.glide.request.SingleRequest.isRunning():boolean");
    }

    @Override // com.kwad.sdk.glide.request.e
    public final synchronized boolean isComplete() {
        return this.bZO == Status.COMPLETE;
    }

    @Override // com.kwad.sdk.glide.request.e
    public final synchronized boolean aja() {
        return isComplete();
    }

    @Override // com.kwad.sdk.glide.request.e
    public final synchronized boolean ajb() {
        return this.bZO == Status.CLEARED;
    }

    @Override // com.kwad.sdk.glide.request.e
    public final synchronized boolean isFailed() {
        return this.bZO == Status.FAILED;
    }

    private Drawable aji() {
        if (this.bZP == null) {
            Drawable drawableAiK = this.bZJ.aiK();
            this.bZP = drawableAiK;
            if (drawableAiK == null && this.bZJ.aiL() > 0) {
                this.bZP = gp(this.bZJ.aiL());
            }
        }
        return this.bZP;
    }

    private Drawable aiN() {
        if (this.bZm == null) {
            Drawable drawableAiN = this.bZJ.aiN();
            this.bZm = drawableAiN;
            if (drawableAiN == null && this.bZJ.aiM() > 0) {
                this.bZm = gp(this.bZJ.aiM());
            }
        }
        return this.bZm;
    }

    private Drawable aiP() {
        if (this.bZr == null) {
            Drawable drawableAiP = this.bZJ.aiP();
            this.bZr = drawableAiP;
            if (drawableAiP == null && this.bZJ.aiO() > 0) {
                this.bZr = gp(this.bZJ.aiO());
            }
        }
        return this.bZr;
    }

    private Drawable gp(int i) {
        return com.kwad.sdk.glide.load.resource.b.a.a(this.bPB, i, this.bZJ.getTheme() != null ? this.bZJ.getTheme() : this.dR.getTheme());
    }

    private synchronized void ajj() {
        if (ajm()) {
            Drawable drawableAiP = this.bQj == null ? aiP() : null;
            if (drawableAiP == null) {
                drawableAiP = aji();
            }
            if (drawableAiP == null) {
                drawableAiP = aiN();
            }
            this.bZK.onLoadFailed(drawableAiP);
        }
    }

    @Override // com.kwad.sdk.glide.request.a.i
    public final synchronized void V(int i, int i2) throws Throwable {
        try {
            this.bSK.ajJ();
            boolean z = bZG;
            if (z) {
                hr("Got onSizeReady in " + com.kwad.sdk.glide.e.f.bq(this.startTime));
            }
            if (this.bZO != Status.WAITING_FOR_SIZE) {
                return;
            }
            this.bZO = Status.RUNNING;
            float fAiV = this.bZJ.aiV();
            this.width = b(i, fAiV);
            this.height = b(i2, fAiV);
            if (z) {
                hr("finished setup for calling load in " + com.kwad.sdk.glide.e.f.bq(this.startTime));
            }
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.bZN = this.bPx.a(this.bPB, this.bQj, this.bZJ.agi(), this.width, this.height, this.bZJ.afv(), this.bQh, this.bSE, this.bZJ.agf(), this.bZJ.aiI(), this.bZJ.aiJ(), this.bZJ.agm(), this.bZJ.agh(), this.bZJ.aiQ(), this.bZJ.aiW(), this.bZJ.aiX(), this.bZJ.aiY(), this, this.bZM);
                if (this.bZO != Status.RUNNING) {
                    this.bZN = null;
                }
                if (z) {
                    hr("finished onSizeReady in " + com.kwad.sdk.glide.e.f.bq(this.startTime));
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static int b(int i, float f) {
        return i == Integer.MIN_VALUE ? i : Math.round(f * i);
    }

    private boolean ajk() {
        f fVar = this.bZI;
        return fVar == null || fVar.d(this);
    }

    private boolean ajl() {
        f fVar = this.bZI;
        return fVar == null || fVar.f(this);
    }

    private boolean ajm() {
        f fVar = this.bZI;
        return fVar == null || fVar.e(this);
    }

    private boolean ajn() {
        f fVar = this.bZI;
        return fVar == null || !fVar.ajf();
    }

    private void vs() {
        f fVar = this.bZI;
        if (fVar != null) {
            fVar.h(this);
        }
    }

    private void ajo() {
        f fVar = this.bZI;
        if (fVar != null) {
            fVar.i(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.glide.request.j
    public final synchronized void c(s<?> sVar, DataSource dataSource) {
        this.bSK.ajJ();
        this.bZN = null;
        if (sVar == null) {
            b(new GlideException("Expected to receive a Resource<R> with an object of " + this.bQh + " inside, but instead got null."));
            return;
        }
        Object obj = sVar.get();
        if (obj != null && this.bQh.isAssignableFrom(obj.getClass())) {
            if (!ajk()) {
                l(sVar);
                this.bZO = Status.COMPLETE;
                return;
            } else {
                a(sVar, obj, dataSource);
                return;
            }
        }
        l(sVar);
        b(new GlideException("Expected to receive an object of " + this.bQh + " but instead got " + (obj != null ? obj.getClass() : "") + "{" + obj + "} inside Resource{" + sVar + "}." + (obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.")));
    }

    private synchronized void a(s<R> sVar, R r, DataSource dataSource) {
        boolean zA;
        boolean zAjn = ajn();
        this.bZO = Status.COMPLETE;
        this.bSl = sVar;
        if (this.bPB.getLogLevel() <= 3) {
            Log.d("Glide", "Finished loading " + r.getClass().getSimpleName() + " from " + dataSource + " for " + this.bQj + " with size [" + this.width + "x" + this.height + "] in " + com.kwad.sdk.glide.e.f.bq(this.startTime) + " ms");
        }
        boolean z = true;
        this.bZF = true;
        try {
            List<h<R>> list = this.bQk;
            if (list != null) {
                Iterator<h<R>> it = list.iterator();
                zA = false;
                while (it.hasNext()) {
                    zA |= it.next().a(r, this.bQj, this.bZK, dataSource, zAjn);
                }
            } else {
                zA = false;
            }
            h<R> hVar = this.bZH;
            if (hVar == null || !hVar.a(r, this.bQj, this.bZK, dataSource, zAjn)) {
                z = false;
            }
            if (!(z | zA)) {
                this.bZK.onResourceReady(r, this.bZL.ajv());
            }
            this.bZF = false;
            vs();
        } catch (Throwable th) {
            this.bZF = false;
            throw th;
        }
    }

    @Override // com.kwad.sdk.glide.request.j
    public final synchronized void b(GlideException glideException) {
        a(glideException, 5);
    }

    private synchronized void a(GlideException glideException, int i) {
        this.bSK.ajJ();
        glideException.setOrigin(this.bZQ);
        int logLevel = this.bPB.getLogLevel();
        if (logLevel <= i) {
            Log.w("Glide", "Load failed for " + this.bQj + " with size [" + this.width + "x" + this.height + "]", glideException);
            if (logLevel <= 4) {
                glideException.logRootCauses("Glide");
            }
        }
        this.bZN = null;
        this.bZO = Status.FAILED;
        this.bZF = true;
        try {
            List<h<R>> list = this.bQk;
            if (list != null) {
                for (h<R> hVar : list) {
                    ajn();
                    hVar.a(glideException);
                }
            }
            h<R> hVar2 = this.bZH;
            if (hVar2 != null) {
                ajn();
                hVar2.a(glideException);
            }
            ajj();
            this.bZF = false;
            ajo();
        } catch (Throwable th) {
            this.bZF = false;
            throw th;
        }
    }

    @Override // com.kwad.sdk.glide.request.e
    public final synchronized boolean c(e eVar) {
        boolean z = false;
        if (!(eVar instanceof SingleRequest)) {
            return false;
        }
        SingleRequest<?> singleRequest = (SingleRequest) eVar;
        synchronized (singleRequest) {
            if (this.bZp == singleRequest.bZp && this.bZo == singleRequest.bZo && com.kwad.sdk.glide.e.j.d(this.bQj, singleRequest.bQj) && this.bQh.equals(singleRequest.bQh) && this.bZJ.equals(singleRequest.bZJ) && this.bSE == singleRequest.bSE && a(singleRequest)) {
                z = true;
            }
        }
        return z;
    }

    private synchronized boolean a(SingleRequest<?> singleRequest) {
        boolean z;
        synchronized (singleRequest) {
            List<h<R>> list = this.bQk;
            int size = list == null ? 0 : list.size();
            List<h<?>> list2 = singleRequest.bQk;
            z = size == (list2 == null ? 0 : list2.size());
        }
        return z;
    }

    private void hr(String str) {
        Log.v("Request", str + " this: " + this.tag);
    }
}

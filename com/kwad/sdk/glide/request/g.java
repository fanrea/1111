package com.kwad.sdk.glide.request;

import android.graphics.drawable.Drawable;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.engine.GlideException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class g<R> implements d<R>, h<R> {
    private static final a bZz = new a();
    private boolean bRS;
    private GlideException bTU;
    private R bWV;
    private final boolean bZA;
    private final a bZB;
    private boolean bZC;
    private boolean bZD;
    private final int height;
    private e request;
    private final int width;

    @Override // com.kwad.sdk.glide.a.i
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public final void onLoadCleared(Drawable drawable) {
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public final void onLoadStarted(Drawable drawable) {
    }

    @Override // com.kwad.sdk.glide.a.i
    public final void onStart() {
    }

    @Override // com.kwad.sdk.glide.a.i
    public final void onStop() {
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public final void removeCallback(com.kwad.sdk.glide.request.a.i iVar) {
    }

    public g(int i, int i2) {
        this(i, i2, true, bZz);
    }

    private g(int i, int i2, boolean z, a aVar) {
        this.width = i;
        this.height = i2;
        this.bZA = true;
        this.bZB = aVar;
    }

    @Override // java.util.concurrent.Future
    public final synchronized boolean cancel(boolean z) {
        e eVar;
        if (isDone()) {
            return false;
        }
        this.bRS = true;
        a.G(this);
        if (z && (eVar = this.request) != null) {
            eVar.clear();
            this.request = null;
        }
        return true;
    }

    @Override // java.util.concurrent.Future
    public final synchronized boolean isCancelled() {
        return this.bRS;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0011  */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized boolean isDone() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.bRS     // Catch: java.lang.Throwable -> L13
            if (r0 != 0) goto L11
            boolean r0 = r1.bZC     // Catch: java.lang.Throwable -> L13
            if (r0 != 0) goto L11
            boolean r0 = r1.bZD     // Catch: java.lang.Throwable -> L13
            if (r0 == 0) goto Le
            goto L11
        Le:
            r0 = 0
        Lf:
            monitor-exit(r1)
            return r0
        L11:
            r0 = 1
            goto Lf
        L13:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.glide.request.g.isDone():boolean");
    }

    @Override // java.util.concurrent.Future
    public final R get() {
        try {
            return a((Long) null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.util.concurrent.Future
    public final R get(long j, TimeUnit timeUnit) {
        return a(Long.valueOf(timeUnit.toMillis(j)));
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public final void getSize(com.kwad.sdk.glide.request.a.i iVar) {
        iVar.V(this.width, this.height);
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public final synchronized void setRequest(e eVar) {
        this.request = eVar;
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public final synchronized e getRequest() {
        return this.request;
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public final synchronized void onLoadFailed(Drawable drawable) {
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public final synchronized void onResourceReady(R r, com.kwad.sdk.glide.request.b.b<? super R> bVar) {
    }

    private synchronized R a(Long l) {
        if (this.bZA && !isDone()) {
            com.kwad.sdk.glide.e.j.ajC();
        }
        if (this.bRS) {
            throw new CancellationException();
        }
        if (this.bZD) {
            throw new ExecutionException(this.bTU);
        }
        if (this.bZC) {
            return this.bWV;
        }
        if (l == null) {
            a.a(this, 0L);
        } else if (l.longValue() > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jLongValue = l.longValue() + jCurrentTimeMillis;
            while (!isDone() && jCurrentTimeMillis < jLongValue) {
                a.a(this, jLongValue - jCurrentTimeMillis);
                jCurrentTimeMillis = System.currentTimeMillis();
            }
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (this.bZD) {
            throw new ExecutionException(this.bTU);
        }
        if (this.bRS) {
            throw new CancellationException();
        }
        if (!this.bZC) {
            throw new TimeoutException();
        }
        return this.bWV;
    }

    @Override // com.kwad.sdk.glide.request.h
    public final synchronized boolean a(GlideException glideException) {
        this.bZD = true;
        this.bTU = glideException;
        a.G(this);
        return false;
    }

    @Override // com.kwad.sdk.glide.request.h
    public final synchronized boolean a(R r, Object obj, com.kwad.sdk.glide.request.a.j<R> jVar, DataSource dataSource, boolean z) {
        this.bZC = true;
        this.bWV = r;
        a.G(this);
        return false;
    }

    static class a {
        a() {
        }

        static void a(Object obj, long j) throws InterruptedException {
            obj.wait(j);
        }

        static void G(Object obj) {
            obj.notifyAll();
        }
    }
}

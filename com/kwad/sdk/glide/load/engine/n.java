package com.kwad.sdk.glide.load.engine;

import com.kwad.sdk.utils.ax;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class n<Z> implements s<Z> {
    private a bSf;
    private final boolean bSk;
    private final s<Z> bSl;
    private final boolean bUc;
    private int bUd;
    private boolean bUe;
    private com.kwad.sdk.glide.load.c key;

    interface a {
        void b(com.kwad.sdk.glide.load.c cVar, n<?> nVar);
    }

    n(s<Z> sVar, boolean z, boolean z2) {
        this.bSl = (s) ax.checkNotNull(sVar);
        this.bSk = z;
        this.bUc = z2;
    }

    final synchronized void a(com.kwad.sdk.glide.load.c cVar, a aVar) {
        this.key = cVar;
        this.bSf = aVar;
    }

    final s<Z> agN() {
        return this.bSl;
    }

    final boolean agO() {
        return this.bSk;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final Class<Z> afv() {
        return this.bSl.afv();
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final Z get() {
        return this.bSl.get();
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final int getSize() {
        return this.bSl.getSize();
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final synchronized void recycle() {
        if (this.bUd > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.bUe) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.bUe = true;
        if (this.bUc) {
            this.bSl.recycle();
        }
    }

    final synchronized void acquire() {
        if (this.bUe) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.bUd++;
    }

    final void release() {
        synchronized (this.bSf) {
            synchronized (this) {
                int i = this.bUd;
                if (i <= 0) {
                    throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
                }
                int i2 = i - 1;
                this.bUd = i2;
                if (i2 == 0) {
                    this.bSf.b(this.key, this);
                }
            }
        }
    }

    public final synchronized String toString() {
        return "EngineResource{isCacheable=" + this.bSk + ", listener=" + this.bSf + ", key=" + this.key + ", acquired=" + this.bUd + ", isRecycled=" + this.bUe + ", resource=" + this.bSl + '}';
    }
}

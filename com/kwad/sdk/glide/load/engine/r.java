package com.kwad.sdk.glide.load.engine;

import androidx.core.util.Pools;
import com.kwad.sdk.glide.e.a.a;
import com.kwad.sdk.utils.ax;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class r<Z> implements a.c, s<Z> {
    private static final Pools.Pool<r<?>> bUk = com.kwad.sdk.glide.e.a.a.a(20, new a.InterfaceC0602a<r<?>>() { // from class: com.kwad.sdk.glide.load.engine.r.1
        @Override // com.kwad.sdk.glide.e.a.a.InterfaceC0602a
        public final /* synthetic */ r<?> agF() {
            return agP();
        }

        private static r<?> agP() {
            return new r<>();
        }
    });
    private final com.kwad.sdk.glide.e.a.b bSK = com.kwad.sdk.glide.e.a.b.ajI();
    private boolean bUe;
    private s<Z> bUl;
    private boolean bUm;

    static <Z> r<Z> f(s<Z> sVar) {
        r<Z> rVar = (r) ax.checkNotNull(bUk.acquire());
        rVar.g(sVar);
        return rVar;
    }

    r() {
    }

    private void g(s<Z> sVar) {
        this.bUe = false;
        this.bUm = true;
        this.bUl = sVar;
    }

    private void release() {
        this.bUl = null;
        bUk.release(this);
    }

    final synchronized void unlock() {
        this.bSK.ajJ();
        if (!this.bUm) {
            throw new IllegalStateException("Already unlocked");
        }
        this.bUm = false;
        if (this.bUe) {
            recycle();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final Class<Z> afv() {
        return this.bUl.afv();
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final Z get() {
        return this.bUl.get();
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final int getSize() {
        return this.bUl.getSize();
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final synchronized void recycle() {
        this.bSK.ajJ();
        this.bUe = true;
        if (!this.bUm) {
            this.bUl.recycle();
            release();
        }
    }

    @Override // com.kwad.sdk.glide.e.a.a.c
    public final com.kwad.sdk.glide.e.a.b agy() {
        return this.bSK;
    }
}

package com.kwad.sdk.glide.load.engine;

import android.util.Log;
import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.a.d;
import com.kwad.sdk.glide.load.c.n;
import com.kwad.sdk.glide.load.engine.e;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class w implements d.a<Object>, e, e.a {
    private final f<?> bSn;
    private final e.a bSo;
    private volatile n.a<?> bSt;
    private int bUt;
    private b bUu;
    private Object bUv;
    private c bUw;

    w(f<?> fVar, e.a aVar) {
        this.bSn = fVar;
        this.bSo = aVar;
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public final boolean agb() {
        Object obj = this.bUv;
        if (obj != null) {
            this.bUv = null;
            z(obj);
        }
        b bVar = this.bUu;
        if (bVar != null && bVar.agb()) {
            return true;
        }
        this.bUu = null;
        this.bSt = null;
        boolean z = false;
        while (!z && agc()) {
            List<n.a<?>> listAgn = this.bSn.agn();
            int i = this.bUt;
            this.bUt = i + 1;
            this.bSt = listAgn.get(i);
            if (this.bSt != null && (this.bSn.agf().b(this.bSt.bWC.afV()) || this.bSn.j(this.bSt.bWC.afT()))) {
                this.bSt.bWC.a(this.bSn.agg(), this);
                z = true;
            }
        }
        return z;
    }

    private boolean agc() {
        return this.bUt < this.bSn.agn().size();
    }

    private void z(Object obj) {
        long jAjA = com.kwad.sdk.glide.e.f.ajA();
        try {
            com.kwad.sdk.glide.load.a<X> aVarR = this.bSn.r(obj);
            d dVar = new d(aVarR, obj, this.bSn.agh());
            this.bUw = new c(this.bSt.bSq, this.bSn.agi());
            this.bSn.age().a(this.bUw, dVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.bUw + ", data: " + obj + ", encoder: " + aVarR + ", duration: " + com.kwad.sdk.glide.e.f.bq(jAjA));
            }
            this.bSt.bWC.afU();
            this.bUu = new b(Collections.singletonList(this.bSt.bSq), this.bSn, this);
        } catch (Throwable th) {
            this.bSt.bWC.afU();
            throw th;
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.e
    public final void cancel() {
        n.a<?> aVar = this.bSt;
        if (aVar != null) {
            aVar.bWC.cancel();
        }
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public final void x(Object obj) {
        h hVarAgf = this.bSn.agf();
        if (obj != null && hVarAgf.b(this.bSt.bWC.afV())) {
            this.bUv = obj;
            this.bSo.agd();
        } else {
            this.bSo.a(this.bSt.bSq, obj, this.bSt.bWC, this.bSt.bWC.afV(), this.bUw);
        }
    }

    @Override // com.kwad.sdk.glide.load.a.d.a
    public final void g(Exception exc) {
        this.bSo.a(this.bUw, exc, this.bSt.bWC, this.bSt.bWC.afV());
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public final void agd() {
        throw new UnsupportedOperationException();
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public final void a(com.kwad.sdk.glide.load.c cVar, Object obj, com.kwad.sdk.glide.load.a.d<?> dVar, DataSource dataSource, com.kwad.sdk.glide.load.c cVar2) {
        this.bSo.a(cVar, obj, dVar, this.bSt.bWC.afV(), cVar);
    }

    @Override // com.kwad.sdk.glide.load.engine.e.a
    public final void a(com.kwad.sdk.glide.load.c cVar, Exception exc, com.kwad.sdk.glide.load.a.d<?> dVar, DataSource dataSource) {
        this.bSo.a(cVar, exc, dVar, this.bSt.bWC.afV());
    }
}

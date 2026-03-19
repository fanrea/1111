package com.kwad.sdk.glide.request;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c implements e, f {
    private final f bZw;
    private e bZx;
    private e bZy;

    public c(f fVar) {
        this.bZw = fVar;
    }

    public final void a(e eVar, e eVar2) {
        this.bZx = eVar;
        this.bZy = eVar2;
    }

    @Override // com.kwad.sdk.glide.request.e
    public final void begin() {
        if (this.bZx.isRunning()) {
            return;
        }
        this.bZx.begin();
    }

    @Override // com.kwad.sdk.glide.request.e
    public final void clear() {
        this.bZx.clear();
        if (this.bZy.isRunning()) {
            this.bZy.clear();
        }
    }

    @Override // com.kwad.sdk.glide.request.e
    public final boolean isRunning() {
        return (this.bZx.isFailed() ? this.bZy : this.bZx).isRunning();
    }

    @Override // com.kwad.sdk.glide.request.e
    public final boolean isComplete() {
        return (this.bZx.isFailed() ? this.bZy : this.bZx).isComplete();
    }

    @Override // com.kwad.sdk.glide.request.e
    public final boolean aja() {
        return (this.bZx.isFailed() ? this.bZy : this.bZx).aja();
    }

    @Override // com.kwad.sdk.glide.request.e
    public final boolean ajb() {
        return (this.bZx.isFailed() ? this.bZy : this.bZx).ajb();
    }

    @Override // com.kwad.sdk.glide.request.e
    public final boolean isFailed() {
        return this.bZx.isFailed() && this.bZy.isFailed();
    }

    @Override // com.kwad.sdk.glide.request.e
    public final void recycle() {
        this.bZx.recycle();
        this.bZy.recycle();
    }

    @Override // com.kwad.sdk.glide.request.e
    public final boolean c(e eVar) {
        if (eVar instanceof c) {
            c cVar = (c) eVar;
            if (this.bZx.c(cVar.bZx) && this.bZy.c(cVar.bZy)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.kwad.sdk.glide.request.f
    public final boolean d(e eVar) {
        return ajc() && g(eVar);
    }

    private boolean ajc() {
        f fVar = this.bZw;
        return fVar == null || fVar.d(this);
    }

    @Override // com.kwad.sdk.glide.request.f
    public final boolean e(e eVar) {
        return aje() && g(eVar);
    }

    @Override // com.kwad.sdk.glide.request.f
    public final boolean f(e eVar) {
        return ajd() && g(eVar);
    }

    private boolean ajd() {
        f fVar = this.bZw;
        return fVar == null || fVar.f(this);
    }

    private boolean aje() {
        f fVar = this.bZw;
        return fVar == null || fVar.e(this);
    }

    private boolean g(e eVar) {
        if (eVar.equals(this.bZx)) {
            return true;
        }
        return this.bZx.isFailed() && eVar.equals(this.bZy);
    }

    @Override // com.kwad.sdk.glide.request.f
    public final boolean ajf() {
        return ajg() || aja();
    }

    private boolean ajg() {
        f fVar = this.bZw;
        return fVar != null && fVar.ajf();
    }

    @Override // com.kwad.sdk.glide.request.f
    public final void h(e eVar) {
        f fVar = this.bZw;
        if (fVar != null) {
            fVar.h(this);
        }
    }

    @Override // com.kwad.sdk.glide.request.f
    public final void i(e eVar) {
        if (!eVar.equals(this.bZy)) {
            if (this.bZy.isRunning()) {
                return;
            }
            this.bZy.begin();
        } else {
            f fVar = this.bZw;
            if (fVar != null) {
                fVar.i(this);
            }
        }
    }
}

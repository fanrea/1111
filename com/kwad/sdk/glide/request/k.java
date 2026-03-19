package com.kwad.sdk.glide.request;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class k implements e, f {
    private e bZR;
    private e bZS;
    private final f bZw;
    private boolean isRunning;

    k() {
        this(null);
    }

    public k(f fVar) {
        this.bZw = fVar;
    }

    public final void a(e eVar, e eVar2) {
        this.bZR = eVar;
        this.bZS = eVar2;
    }

    @Override // com.kwad.sdk.glide.request.f
    public final boolean d(e eVar) {
        if (ajc()) {
            return eVar.equals(this.bZR) || !this.bZR.aja();
        }
        return false;
    }

    private boolean ajc() {
        f fVar = this.bZw;
        return fVar == null || fVar.d(this);
    }

    @Override // com.kwad.sdk.glide.request.f
    public final boolean e(e eVar) {
        return aje() && eVar.equals(this.bZR) && !ajf();
    }

    @Override // com.kwad.sdk.glide.request.f
    public final boolean f(e eVar) {
        return ajd() && eVar.equals(this.bZR);
    }

    private boolean ajd() {
        f fVar = this.bZw;
        return fVar == null || fVar.f(this);
    }

    private boolean aje() {
        f fVar = this.bZw;
        return fVar == null || fVar.e(this);
    }

    @Override // com.kwad.sdk.glide.request.f
    public final boolean ajf() {
        return ajg() || aja();
    }

    @Override // com.kwad.sdk.glide.request.f
    public final void h(e eVar) {
        if (eVar.equals(this.bZS)) {
            return;
        }
        f fVar = this.bZw;
        if (fVar != null) {
            fVar.h(this);
        }
        if (this.bZS.isComplete()) {
            return;
        }
        this.bZS.clear();
    }

    @Override // com.kwad.sdk.glide.request.f
    public final void i(e eVar) {
        f fVar;
        if (eVar.equals(this.bZR) && (fVar = this.bZw) != null) {
            fVar.i(this);
        }
    }

    private boolean ajg() {
        f fVar = this.bZw;
        return fVar != null && fVar.ajf();
    }

    @Override // com.kwad.sdk.glide.request.e
    public final void begin() {
        this.isRunning = true;
        if (!this.bZR.isComplete() && !this.bZS.isRunning()) {
            this.bZS.begin();
        }
        if (!this.isRunning || this.bZR.isRunning()) {
            return;
        }
        this.bZR.begin();
    }

    @Override // com.kwad.sdk.glide.request.e
    public final void clear() {
        this.isRunning = false;
        this.bZS.clear();
        this.bZR.clear();
    }

    @Override // com.kwad.sdk.glide.request.e
    public final boolean isRunning() {
        return this.bZR.isRunning();
    }

    @Override // com.kwad.sdk.glide.request.e
    public final boolean isComplete() {
        return this.bZR.isComplete() || this.bZS.isComplete();
    }

    @Override // com.kwad.sdk.glide.request.e
    public final boolean aja() {
        return this.bZR.aja() || this.bZS.aja();
    }

    @Override // com.kwad.sdk.glide.request.e
    public final boolean ajb() {
        return this.bZR.ajb();
    }

    @Override // com.kwad.sdk.glide.request.e
    public final boolean isFailed() {
        return this.bZR.isFailed();
    }

    @Override // com.kwad.sdk.glide.request.e
    public final void recycle() {
        this.bZR.recycle();
        this.bZS.recycle();
    }

    @Override // com.kwad.sdk.glide.request.e
    public final boolean c(e eVar) {
        if (eVar instanceof k) {
            k kVar = (k) eVar;
            e eVar2 = this.bZR;
            if (eVar2 != null ? eVar2.c(kVar.bZR) : kVar.bZR == null) {
                e eVar3 = this.bZS;
                e eVar4 = kVar.bZS;
                if (eVar3 == null) {
                    if (eVar4 == null) {
                        return true;
                    }
                } else if (eVar3.c(eVar4)) {
                    return true;
                }
            }
        }
        return false;
    }
}

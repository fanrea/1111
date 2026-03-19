package com.kwad.sdk.glide.load.engine.a;

import com.kwad.sdk.glide.load.engine.a.h;
import com.kwad.sdk.glide.load.engine.s;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class g extends com.kwad.sdk.glide.e.g<com.kwad.sdk.glide.load.c, s<?>> implements h {
    private h.a bVr;

    @Override // com.kwad.sdk.glide.load.engine.a.h
    public final /* synthetic */ s a(com.kwad.sdk.glide.load.c cVar, s sVar) {
        return (s) super.put(cVar, sVar);
    }

    @Override // com.kwad.sdk.glide.e.g
    public final /* synthetic */ void b(com.kwad.sdk.glide.load.c cVar, s<?> sVar) {
        i(sVar);
    }

    @Override // com.kwad.sdk.glide.load.engine.a.h
    public final /* synthetic */ s f(com.kwad.sdk.glide.load.c cVar) {
        return (s) super.remove(cVar);
    }

    public g(long j) {
        super(j);
    }

    @Override // com.kwad.sdk.glide.load.engine.a.h
    public final void a(h.a aVar) {
        this.bVr = aVar;
    }

    private void i(s<?> sVar) {
        h.a aVar = this.bVr;
        if (aVar == null || sVar == null) {
            return;
        }
        aVar.e(sVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.glide.e.g
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public int D(s<?> sVar) {
        if (sVar == null) {
            return super.D(null);
        }
        return sVar.getSize();
    }

    @Override // com.kwad.sdk.glide.load.engine.a.h
    public final void fV(int i) {
        if (i >= 40) {
            clearMemory();
        } else if (i >= 20 || i == 15) {
            bp(getMaxSize() / 2);
        }
    }
}

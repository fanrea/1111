package com.kwad.sdk.glide.load.resource.d;

import com.kwad.sdk.glide.load.engine.o;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class e extends com.kwad.sdk.glide.load.resource.b.b<c> implements o {
    public e(c cVar) {
        super(cVar);
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final Class<c> afv() {
        return c.class;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final int getSize() {
        return ((c) this.bXV).getSize();
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final void recycle() {
        ((c) this.bXV).stop();
        ((c) this.bXV).recycle();
    }

    @Override // com.kwad.sdk.glide.load.resource.b.b, com.kwad.sdk.glide.load.engine.o
    public final void initialize() {
        ((c) this.bXV).ahZ().prepareToDraw();
    }
}

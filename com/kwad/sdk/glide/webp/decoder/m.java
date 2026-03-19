package com.kwad.sdk.glide.webp.decoder;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class m extends com.kwad.sdk.glide.load.resource.b.b<k> implements com.kwad.sdk.glide.load.engine.o {
    public m(k kVar) {
        super(kVar);
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final Class<k> afv() {
        return k.class;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final int getSize() {
        return ((k) this.bXV).getSize();
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final void recycle() {
        ((k) this.bXV).stop();
        ((k) this.bXV).recycle();
    }

    @Override // com.kwad.sdk.glide.load.resource.b.b, com.kwad.sdk.glide.load.engine.o
    public final void initialize() {
        ((k) this.bXV).ahZ().prepareToDraw();
    }
}

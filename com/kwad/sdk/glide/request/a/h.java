package com.kwad.sdk.glide.request.a;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class h<Z> extends a<Z> {
    private final int height;
    private final int width;

    @Override // com.kwad.sdk.glide.request.a.j
    public void removeCallback(i iVar) {
    }

    public h() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public h(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public final void getSize(i iVar) {
        if (!com.kwad.sdk.glide.e.j.Y(this.width, this.height)) {
            throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.width + " and height: " + this.height + ", either provide dimensions in the constructor or call override()");
        }
        iVar.V(this.width, this.height);
    }
}

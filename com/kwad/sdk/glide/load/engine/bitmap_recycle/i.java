package com.kwad.sdk.glide.load.engine.bitmap_recycle;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class i implements a<int[]> {
    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.a
    public final int agR() {
        return 4;
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.a
    public final String getTag() {
        return "IntegerArrayPool";
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.a
    public final /* synthetic */ int A(int[] iArr) {
        return c(iArr);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.a
    public final /* synthetic */ int[] ge(int i) {
        return gg(i);
    }

    private static int c(int[] iArr) {
        return iArr.length;
    }

    private static int[] gg(int i) {
        return new int[i];
    }
}

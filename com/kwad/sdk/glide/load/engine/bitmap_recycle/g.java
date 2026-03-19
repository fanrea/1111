package com.kwad.sdk.glide.load.engine.bitmap_recycle;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class g implements a<byte[]> {
    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.a
    public final int agR() {
        return 1;
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.a
    public final String getTag() {
        return "ByteArrayPool";
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.a
    public final /* synthetic */ int A(byte[] bArr) {
        return i(bArr);
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.a
    public final /* synthetic */ byte[] ge(int i) {
        return gf(i);
    }

    private static int i(byte[] bArr) {
        return bArr.length;
    }

    private static byte[] gf(int i) {
        return new byte[i];
    }
}

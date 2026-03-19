package com.kwad.sdk.glide.load.b;

import androidx.core.view.MotionEventCompat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b implements c {
    private final ByteBuffer bVV;

    public b(ByteBuffer byteBuffer) {
        this.bVV = byteBuffer;
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
    }

    @Override // com.kwad.sdk.glide.load.b.c
    public final int ahu() {
        return ((ahw() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (ahw() & 255);
    }

    @Override // com.kwad.sdk.glide.load.b.c
    public final short ahv() {
        return (short) (ahw() & 255);
    }

    @Override // com.kwad.sdk.glide.load.b.c
    public final long skip(long j) {
        int iMin = (int) Math.min(this.bVV.remaining(), j);
        ByteBuffer byteBuffer = this.bVV;
        byteBuffer.position(byteBuffer.position() + iMin);
        return iMin;
    }

    @Override // com.kwad.sdk.glide.load.b.c
    public final int e(byte[] bArr, int i) {
        int iMin = Math.min(i, this.bVV.remaining());
        if (iMin == 0) {
            return -1;
        }
        this.bVV.get(bArr, 0, iMin);
        return iMin;
    }

    @Override // com.kwad.sdk.glide.load.b.c
    public final int ahw() {
        if (this.bVV.remaining() <= 0) {
            return -1;
        }
        return this.bVV.get();
    }
}

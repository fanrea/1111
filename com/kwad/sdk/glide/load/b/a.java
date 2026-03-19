package com.kwad.sdk.glide.load.b;

import androidx.core.view.MotionEventCompat;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a implements c {
    private final byte[] data;
    private final int offset;
    private int pos;
    private final int size;

    public a(byte[] bArr, int i, int i2) {
        this.data = bArr;
        this.offset = i;
        this.size = i2;
        this.pos = i;
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
        int iMin = (int) Math.min((this.offset + this.size) - this.pos, j);
        this.pos += iMin;
        return iMin;
    }

    @Override // com.kwad.sdk.glide.load.b.c
    public final int e(byte[] bArr, int i) {
        int iMin = Math.min((this.offset + this.size) - this.pos, i);
        if (iMin == 0) {
            return -1;
        }
        System.arraycopy(this.data, this.pos, bArr, 0, iMin);
        return iMin;
    }

    @Override // com.kwad.sdk.glide.load.b.c
    public final int ahw() {
        int i = this.pos;
        if (i >= this.offset + this.size) {
            return -1;
        }
        byte[] bArr = this.data;
        this.pos = i + 1;
        return bArr[i];
    }
}

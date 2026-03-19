package com.kwad.sdk.glide.load.b;

import androidx.core.view.MotionEventCompat;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d implements c {
    private final InputStream bVW;

    public d(InputStream inputStream) {
        this.bVW = inputStream;
    }

    @Override // com.kwad.sdk.glide.load.b.c
    public final int ahu() {
        return ((this.bVW.read() << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (this.bVW.read() & 255);
    }

    @Override // com.kwad.sdk.glide.load.b.c
    public final short ahv() {
        return (short) (this.bVW.read() & 255);
    }

    @Override // com.kwad.sdk.glide.load.b.c
    public final long skip(long j) throws IOException {
        if (j < 0) {
            return 0L;
        }
        long j2 = j;
        while (j2 > 0) {
            long jSkip = this.bVW.skip(j2);
            if (jSkip <= 0) {
                if (this.bVW.read() == -1) {
                    break;
                }
                jSkip = 1;
            }
            j2 -= jSkip;
        }
        return j - j2;
    }

    @Override // com.kwad.sdk.glide.load.b.c
    public final int e(byte[] bArr, int i) throws IOException {
        int i2 = i;
        while (i2 > 0) {
            int i3 = this.bVW.read(bArr, i - i2, i2);
            if (i3 == -1) {
                break;
            }
            i2 -= i3;
        }
        return i - i2;
    }

    @Override // com.kwad.sdk.glide.load.b.c
    public final int ahw() {
        return this.bVW.read();
    }
}

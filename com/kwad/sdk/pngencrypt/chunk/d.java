package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
import java.util.zip.CRC32;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d {
    public final byte[] ciD;
    private CRC32 ciG;
    public final String id;
    public final int len;
    public byte[] data = null;
    private long ciE = 0;
    public byte[] ciF = new byte[4];

    public d(int i, String str, boolean z) {
        this.len = i;
        this.id = str;
        this.ciD = b.hV(str);
        for (int i2 = 0; i2 < 4; i2++) {
            byte b = this.ciD[i2];
            if (b < 65 || b > 122 || (b > 90 && b < 97)) {
                new PngjException("Bad id chunk: must be ascii letters " + str);
            }
        }
        if (z) {
            amS();
        }
    }

    private void amS() {
        byte[] bArr = this.data;
        if (bArr == null || bArr.length < this.len) {
            this.data = new byte[this.len];
        }
    }

    public final void dp(boolean z) {
        int value = (int) this.ciG.getValue();
        int i = com.kwad.sdk.pngencrypt.n.i(this.ciF, 0);
        if (value != i) {
            String str = String.format("Bad CRC in chunk: %s (offset:%d). Expected:%x Got:%x", this.id, Long.valueOf(this.ciE), Integer.valueOf(i), Integer.valueOf(value));
            if (z) {
                new PngjException(str);
            }
        }
    }

    public final void f(byte[] bArr, int i, int i2) {
        if (this.ciG == null) {
            this.ciG = new CRC32();
        }
        this.ciG.update(bArr, i, i2);
    }

    final ByteArrayInputStream amT() {
        return new ByteArrayInputStream(this.data);
    }

    public final long amU() {
        return this.ciE;
    }

    public final void bx(long j) {
        this.ciE = j;
    }

    public final String toString() {
        return "chunkid=" + b.q(this.ciD) + " len=" + this.len;
    }

    public final int hashCode() {
        String str = this.id;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j = this.ciE;
        return ((iHashCode + 31) * 31) + ((int) (j ^ (j >>> 32)));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.id;
        if (str == null) {
            if (dVar.id != null) {
                return false;
            }
        } else if (!str.equals(dVar.id)) {
            return false;
        }
        return this.ciE == dVar.ciE;
    }
}

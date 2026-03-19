package com.kwad.sdk.pngencrypt;

import com.kuaishou.socket.nano.SocketMessages;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class k {
    public final int chQ;
    public final int chR;
    public final boolean chS;
    public final boolean chT;
    public final boolean chU;
    public final boolean chV;
    public final int chW;
    public final int chX;
    public final int chY;
    public final int chZ;
    public final int chx;
    public final int chy;
    public final int cia;
    private long cib = -1;
    private long cic = -1;

    public k(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        this.chy = i;
        this.chx = i2;
        this.chS = z;
        this.chU = z3;
        this.chT = z2;
        if (z2 && z3) {
            throw new PngjException("palette and greyscale are mutually exclusive");
        }
        int i4 = (z2 || z3) ? z ? 2 : 1 : z ? 4 : 3;
        this.chR = i4;
        this.chQ = i3;
        boolean z4 = i3 < 8;
        this.chV = z4;
        int i5 = i4 * i3;
        this.chW = i5;
        this.chX = (i5 + 7) / 8;
        int i6 = ((i5 * i) + 7) / 8;
        this.chY = i6;
        int i7 = i4 * i;
        this.chZ = i7;
        this.cia = z4 ? i6 : i7;
        if (i3 == 1 || i3 == 2 || i3 == 4) {
            if (!z3 && !z2) {
                throw new PngjException("only indexed or grayscale can have bitdepth=" + i3);
            }
        } else if (i3 != 8) {
            if (i3 != 16) {
                throw new PngjException("invalid bitdepth=" + i3);
            }
            if (z3) {
                throw new PngjException("indexed can't have bitdepth=" + i3);
            }
        }
        if (i <= 0 || i > 16777216) {
            throw new PngjException("invalid cols=" + i + " ???");
        }
        if (i2 <= 0 || i2 > 16777216) {
            throw new PngjException("invalid rows=" + i2 + " ???");
        }
        if (i7 <= 0) {
            throw new PngjException("invalid image parameters (overflow?)");
        }
    }

    public final String toString() {
        return "ImageInfo [cols=" + this.chy + ", rows=" + this.chx + ", bitDepth=" + this.chQ + ", channels=" + this.chR + ", alpha=" + this.chS + ", greyscale=" + this.chT + ", indexed=" + this.chU + "]";
    }

    public final int hashCode() {
        boolean z = this.chS;
        int i = SocketMessages.PayloadType.SC_LIVE_QUIZ3_PARTICIPATE_WINNER_CALCULATION;
        int i2 = ((((((((z ? 1231 : 1237) + 31) * 31) + this.chQ) * 31) + this.chy) * 31) + (this.chT ? 1231 : 1237)) * 31;
        if (!this.chU) {
            i = 1237;
        }
        return ((i2 + i) * 31) + this.chx;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.chS == kVar.chS && this.chQ == kVar.chQ && this.chy == kVar.chy && this.chT == kVar.chT && this.chU == kVar.chU && this.chx == kVar.chx;
    }
}

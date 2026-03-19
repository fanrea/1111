package com.kwad.sdk.pngencrypt;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class e {
    int chA;
    int chB;
    int chC;
    int chD;
    int chE;
    final k chv;
    private int chx;
    private int chy;
    int chz;
    private int chw = 0;
    private int chF = -1;
    private int chG = -1;
    private int chH = 0;
    private boolean chJ = false;
    int chI = 0;

    public e(k kVar) {
        this.chv = kVar;
        gW(1);
        gV(0);
    }

    private void gV(int i) {
        this.chF = i;
        int i2 = (i * this.chz) + this.chB;
        this.chG = i2;
        if (i2 < 0 || i2 >= this.chv.chx) {
            throw new PngjException("bad row - this should not happen");
        }
    }

    final boolean amz() {
        int i;
        while (true) {
            this.chH++;
            int i2 = this.chx;
            if (i2 == 0 || (i = this.chF) >= i2 - 1) {
                int i3 = this.chw;
                if (i3 == 7) {
                    this.chJ = true;
                    return false;
                }
                gW(i3 + 1);
                if (this.chx == 0) {
                    this.chH--;
                } else {
                    gV(0);
                    break;
                }
            } else {
                gV(i + 1);
                break;
            }
        }
        return true;
    }

    private void gW(int i) {
        int i2;
        int i3;
        if (this.chw == i) {
            return;
        }
        this.chw = i;
        byte[] bArrGX = gX(i);
        this.chA = bArrGX[0];
        this.chz = bArrGX[1];
        this.chC = bArrGX[2];
        this.chB = bArrGX[3];
        if (this.chv.chx > this.chB) {
            int i4 = this.chv.chx;
            int i5 = this.chz;
            i2 = (((i4 + i5) - 1) - this.chB) / i5;
        } else {
            i2 = 0;
        }
        this.chx = i2;
        if (this.chv.chy > this.chC) {
            int i6 = this.chv.chy;
            int i7 = this.chA;
            i3 = (((i6 + i7) - 1) - this.chC) / i7;
        } else {
            i3 = 0;
        }
        this.chy = i3;
        if (i3 == 0) {
            this.chx = 0;
        }
        this.chE = this.chA * this.chv.chR;
        this.chD = this.chC * this.chv.chR;
    }

    private static byte[] gX(int i) {
        switch (i) {
            case 1:
                return new byte[]{8, 8, 0, 0};
            case 2:
                return new byte[]{8, 8, 4, 0};
            case 3:
                return new byte[]{4, 8, 0, 4};
            case 4:
                return new byte[]{4, 4, 2, 0};
            case 5:
                return new byte[]{2, 4, 0, 2};
            case 6:
                return new byte[]{2, 2, 1, 0};
            case 7:
                return new byte[]{1, 2, 0, 1};
            default:
                throw new PngjException("bad interlace pass" + i);
        }
    }

    final int amA() {
        return this.chF;
    }

    final int amB() {
        return this.chG;
    }

    final int amC() {
        return this.chw;
    }

    final int amD() {
        return this.chx;
    }

    final int amE() {
        return this.chy;
    }

    private int amF() {
        return amE();
    }

    public final int amG() {
        return ((this.chv.chW * amF()) + 7) / 8;
    }
}

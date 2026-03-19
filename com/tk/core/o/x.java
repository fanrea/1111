package com.tk.core.o;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class x {
    private int ajA;
    private final float ajB;
    private boolean ajC;
    private final float[] ajz;
    private static final int[] ajy = {1, 2, 4, 8, 16, 32, 64, 128, 256};
    private static float UNDEFINED = 1.0E21f;

    public x() {
        this(0.0f);
    }

    private x(float f) {
        this.ajA = 0;
        this.ajB = 0.0f;
        this.ajz = sT();
    }

    private static boolean isUndefined(float f) {
        return Float.compare(f, UNDEFINED) == 0;
    }

    public final boolean d(int i, float f) {
        if (v.r(this.ajz[i], f)) {
            return false;
        }
        this.ajz[i] = f;
        if (isUndefined(f)) {
            this.ajA = (ajy[i] ^ (-1)) & this.ajA;
        } else {
            this.ajA = ajy[i] | this.ajA;
        }
        int i2 = this.ajA;
        int[] iArr = ajy;
        this.ajC = ((iArr[8] & i2) == 0 && (iArr[7] & i2) == 0 && (i2 & iArr[6]) == 0) ? false : true;
        return true;
    }

    public final float get(int i) {
        float f = (i == 4 || i == 5) ? UNDEFINED : this.ajB;
        int i2 = this.ajA;
        if (i2 == 0) {
            return f;
        }
        if ((i2 & ajy[i]) != 0) {
            return this.ajz[i];
        }
        if (this.ajC) {
            char c = (i == 1 || i == 3) ? (char) 7 : (char) 6;
            int i3 = this.ajA;
            int[] iArr = ajy;
            if ((iArr[c] & i3) != 0) {
                return this.ajz[c];
            }
            if ((i3 & iArr[8]) != 0) {
                return this.ajz[8];
            }
        }
        return f;
    }

    public final float ef(int i) {
        return this.ajz[i];
    }

    private static float[] sT() {
        float f = UNDEFINED;
        return new float[]{f, f, f, f, f, f, f, f, f};
    }
}

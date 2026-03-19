package com.bytedance.pangle.h.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class b {
    private int b;
    private int[] d = new int[32];
    private int hc;

    public final void d() {
        this.hc = 0;
        this.b = 0;
    }

    public final int hc() {
        int i = this.hc;
        if (i == 0) {
            return 0;
        }
        return this.d[i - 1];
    }

    public final void d(int i, int i2) {
        if (this.b == 0) {
            u();
        }
        h();
        int i3 = this.hc;
        int i4 = i3 - 1;
        int[] iArr = this.d;
        int i5 = iArr[i4];
        int i6 = (i4 - 1) - (i5 * 2);
        int i7 = i5 + 1;
        iArr[i6] = i7;
        iArr[i4] = i;
        iArr[i4 + 1] = i2;
        iArr[i4 + 2] = i7;
        this.hc = i3 + 2;
    }

    public final void b() {
        int i;
        int[] iArr;
        int i2;
        int i3 = this.hc;
        if (i3 == 0 || (i2 = (iArr = this.d)[i3 - 1]) == 0) {
            return;
        }
        int i4 = i2 - 1;
        int i5 = i - 2;
        iArr[i5] = i4;
        iArr[i5 - ((i4 * 2) + 1)] = i4;
        this.hc = i3 - 2;
    }

    public final int c() {
        return this.b;
    }

    public final void u() {
        h();
        int i = this.hc;
        int[] iArr = this.d;
        iArr[i] = 0;
        iArr[i + 1] = 0;
        this.hc = i + 2;
        this.b++;
    }

    public final void an() {
        int i = this.hc;
        if (i != 0) {
            int i2 = i - 1;
            int i3 = this.d[i2] * 2;
            if ((i2 - 1) - i3 != 0) {
                this.hc = i - (i3 + 2);
                this.b--;
            }
        }
    }

    private void h() {
        int[] iArr = this.d;
        int length = iArr.length;
        int i = this.hc;
        int i2 = length - i;
        if (i2 <= 2) {
            int[] iArr2 = new int[(iArr.length + i2) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            this.d = iArr2;
        }
    }
}

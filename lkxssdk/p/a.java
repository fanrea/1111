package lkxssdk.p;

import io.netty.util.internal.StringUtil;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class a {
    public static final a a;
    public static final a b;
    public static final a c;
    public final int[] d;
    public final int[] e;
    public final b f;
    public final b g;
    public final int h;
    public final int i;
    public final int j;

    static {
        new a(4201, 4096, 1);
        new a(1033, 1024, 1);
        a = new a(67, 64, 1);
        new a(19, 16, 1);
        b = new a(285, 256, 0);
        c = new a(301, 256, 1);
    }

    public a(int i, int i2, int i3) {
        this.i = i;
        this.h = i2;
        this.j = i3;
        this.d = new int[i2];
        this.e = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.d[i5] = i4;
            i4 *= 2;
            if (i4 >= i2) {
                i4 = (i4 ^ i) & (i2 - 1);
            }
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.e[this.d[i6]] = i6;
        }
        this.f = new b(this, new int[]{0});
        this.g = new b(this, new int[]{1});
    }

    public int a(int i) {
        if (i != 0) {
            return this.d[(this.h - this.e[i]) - 1];
        }
        throw new ArithmeticException();
    }

    public b a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.f;
        }
        int[] iArr = new int[i + 1];
        iArr[0] = i2;
        return new b(this, iArr);
    }

    public int b(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.d;
        int[] iArr2 = this.e;
        return iArr[(iArr2[i] + iArr2[i2]) % (this.h - 1)];
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.i) + StringUtil.COMMA + this.h + ')';
    }
}

package lkxssdk.s;

import java.util.ArrayList;
import java.util.List;
import lkxssdk.n.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class b {
    public final lkxssdk.o.a a;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final float g;
    public final m i;
    public final List<a> b = new ArrayList(5);
    public final int[] h = new int[3];

    public b(lkxssdk.o.a aVar, int i, int i2, int i3, int i4, float f, m mVar) {
        this.a = aVar;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = f;
        this.i = mVar;
    }

    public static float a(int[] iArr, int i) {
        return (i - iArr[2]) - (iArr[1] / 2.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final lkxssdk.s.a a(int[] r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: lkxssdk.s.b.a(int[], int, int):lkxssdk.s.a");
    }

    public final boolean a(int[] iArr) {
        float f = this.g;
        float f2 = f / 2.0f;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(f - iArr[i]) >= f2) {
                return false;
            }
        }
        return true;
    }
}

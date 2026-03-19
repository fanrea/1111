package com.qq.e.comm.plugin;

import android.graphics.Color;
import android.util.TimingLogger;
import com.qq.e.comm.plugin.kt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
final class t6 {
    private static final Comparator<b> g = new a();
    final int[] a;
    final int[] b;
    final List<kt.d> c;
    final kt.c[] e;
    private final float[] f = new float[3];
    final TimingLogger d = null;

    private static int b(int i, int i2, int i3) {
        return (i3 > i2 ? i << (i3 - i2) : i >> (i2 - i3)) & ((1 << i3) - 1);
    }

    static int d(int i) {
        return i & 31;
    }

    static int e(int i) {
        return (i >> 5) & 31;
    }

    static int f(int i) {
        return (i >> 10) & 31;
    }

    t6(int[] iArr, int i, kt.c[] cVarArr) {
        this.e = cVarArr;
        int[] iArr2 = new int[32768];
        this.b = iArr2;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int iB = b(iArr[i2]);
            iArr[i2] = iB;
            iArr2[iB] = iArr2[iB] + 1;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < 32768; i4++) {
            if (iArr2[i4] > 0 && g(i4)) {
                iArr2[i4] = 0;
            }
            if (iArr2[i4] > 0) {
                i3++;
            }
        }
        int[] iArr3 = new int[i3];
        this.a = iArr3;
        int i5 = 0;
        for (int i6 = 0; i6 < 32768; i6++) {
            if (iArr2[i6] > 0) {
                iArr3[i5] = i6;
                i5++;
            }
        }
        if (i3 <= i) {
            this.c = new ArrayList();
            for (int i7 = 0; i7 < i3; i7++) {
                int i8 = iArr3[i7];
                this.c.add(new kt.d(a(i8), iArr2[i8]));
            }
            return;
        }
        this.c = c(i);
    }

    private List<kt.d> c(int i) {
        PriorityQueue<b> priorityQueue = new PriorityQueue<>(i, g);
        priorityQueue.offer(new b(0, this.a.length - 1));
        a(priorityQueue, i);
        return a(priorityQueue);
    }

    /* compiled from: A */
    private class b {
        private int a;
        private int b;
        private int c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;

        b(int i, int i2) {
            this.a = i;
            this.b = i2;
            c();
        }

        final int g() {
            return ((this.e - this.d) + 1) * ((this.g - this.f) + 1) * ((this.i - this.h) + 1);
        }

        final boolean a() {
            return e() > 1;
        }

        final int e() {
            return (this.b + 1) - this.a;
        }

        final void c() {
            t6 t6Var = t6.this;
            int[] iArr = t6Var.a;
            int[] iArr2 = t6Var.b;
            int i = Integer.MAX_VALUE;
            int i2 = Integer.MAX_VALUE;
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MIN_VALUE;
            int i7 = 0;
            for (int i8 = this.a; i8 <= this.b; i8++) {
                int i9 = iArr[i8];
                i7 += iArr2[i9];
                int iF = t6.f(i9);
                int iE = t6.e(i9);
                int iD = t6.d(i9);
                if (iF > i4) {
                    i4 = iF;
                }
                if (iF < i) {
                    i = iF;
                }
                if (iE > i5) {
                    i5 = iE;
                }
                if (iE < i2) {
                    i2 = iE;
                }
                if (iD > i6) {
                    i6 = iD;
                }
                if (iD < i3) {
                    i3 = iD;
                }
            }
            this.d = i;
            this.e = i4;
            this.f = i2;
            this.g = i5;
            this.h = i3;
            this.i = i6;
            this.c = i7;
        }

        final b h() {
            if (a()) {
                int iB = b();
                b bVar = t6.this.new b(iB + 1, this.b);
                this.b = iB;
                c();
                return bVar;
            }
            throw new IllegalStateException("Can not split a box with only 1 color");
        }

        final int f() {
            int i = this.e - this.d;
            int i2 = this.g - this.f;
            int i3 = this.i - this.h;
            if (i < i2 || i < i3) {
                return (i2 < i || i2 < i3) ? -1 : -2;
            }
            return -3;
        }

        final int b() {
            int iF = f();
            t6 t6Var = t6.this;
            int[] iArr = t6Var.a;
            int[] iArr2 = t6Var.b;
            t6.a(iArr, iF, this.a, this.b);
            Arrays.sort(iArr, this.a, this.b + 1);
            t6.a(iArr, iF, this.a, this.b);
            int i = this.c / 2;
            int i2 = this.a;
            int i3 = 0;
            while (true) {
                int i4 = this.b;
                if (i2 <= i4) {
                    i3 += iArr2[iArr[i2]];
                    if (i3 >= i) {
                        return Math.min(i4 - 1, i2);
                    }
                    i2++;
                } else {
                    return this.a;
                }
            }
        }

        final kt.d d() {
            t6 t6Var = t6.this;
            int[] iArr = t6Var.a;
            int[] iArr2 = t6Var.b;
            int iD = 0;
            int iE = 0;
            int iF = 0;
            int i = 0;
            for (int i2 = this.a; i2 <= this.b; i2++) {
                int i3 = iArr[i2];
                int i4 = iArr2[i3];
                i += i4;
                iF += t6.f(i3) * i4;
                iE += t6.e(i3) * i4;
                iD += i4 * t6.d(i3);
            }
            float f = i;
            return new kt.d(t6.a(Math.round(iF / f), Math.round(iE / f), Math.round(iD / f)), i);
        }
    }

    private boolean g(int i) {
        int iA = a(i);
        v6.a(iA, this.f);
        return a(iA, this.f);
    }

    /* compiled from: A */
    class a implements Comparator<b> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            return bVar2.g() - bVar.g();
        }
    }

    private static int b(int i) {
        return b(Color.blue(i), 8, 5) | (b(Color.red(i), 8, 5) << 10) | (b(Color.green(i), 8, 5) << 5);
    }

    private static int a(int i) {
        return a(f(i), e(i), d(i));
    }

    static int a(int i, int i2, int i3) {
        return Color.rgb(b(i, 5, 8), b(i2, 5, 8), b(i3, 5, 8));
    }

    private List<kt.d> a(Collection<b> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<b> it = collection.iterator();
        while (it.hasNext()) {
            kt.d dVarD = it.next().d();
            if (!a(dVarD)) {
                arrayList.add(dVarD);
            }
        }
        return arrayList;
    }

    List<kt.d> a() {
        return this.c;
    }

    static void a(int[] iArr, int i, int i2, int i3) {
        if (i == -2) {
            while (i2 <= i3) {
                int i4 = iArr[i2];
                iArr[i2] = d(i4) | (e(i4) << 10) | (f(i4) << 5);
                i2++;
            }
            return;
        }
        if (i != -1) {
            return;
        }
        while (i2 <= i3) {
            int i5 = iArr[i2];
            iArr[i2] = f(i5) | (d(i5) << 10) | (e(i5) << 5);
            i2++;
        }
    }

    private boolean a(int i, float[] fArr) {
        kt.c[] cVarArr = this.e;
        if (cVarArr != null && cVarArr.length > 0) {
            int length = cVarArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (!this.e[i2].a(i, fArr)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean a(kt.d dVar) {
        return a(dVar.e(), dVar.c());
    }

    private void a(PriorityQueue<b> priorityQueue, int i) {
        b bVarPoll;
        while (priorityQueue.size() < i && (bVarPoll = priorityQueue.poll()) != null && bVarPoll.a()) {
            priorityQueue.offer(bVarPoll.h());
            priorityQueue.offer(bVarPoll);
        }
    }
}

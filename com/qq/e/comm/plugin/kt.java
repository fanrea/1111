package com.qq.e.comm.plugin;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.ArrayMap;
import android.util.SparseBooleanArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class kt {
    static final c f = new a();
    private final List<d> a;
    private final List<u10> b;
    private final SparseBooleanArray d = new SparseBooleanArray();
    private final Map<u10, d> c = new ArrayMap();
    private final d e = a();

    /* compiled from: A */
    public interface c {
        boolean a(int i, float[] fArr);
    }

    kt(List<d> list, List<u10> list2) {
        this.a = list;
        this.b = list2;
    }

    public d h() {
        return c(u10.f);
    }

    public d f() {
        return c(u10.e);
    }

    public d d() {
        return c(u10.g);
    }

    public d g() {
        return c(u10.i);
    }

    public d e() {
        return c(u10.h);
    }

    public d c() {
        return c(u10.j);
    }

    void b() {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            u10 u10Var = this.b.get(i);
            u10Var.k();
            this.c.put(u10Var, a(u10Var));
        }
        this.d.clear();
    }

    private d a() {
        int size = this.a.size();
        int iD = Integer.MIN_VALUE;
        d dVar = null;
        for (int i = 0; i < size; i++) {
            d dVar2 = this.a.get(i);
            if (dVar2.d() > iD) {
                iD = dVar2.d();
                dVar = dVar2;
            }
        }
        return dVar;
    }

    /* compiled from: A */
    public static final class d {
        private final int a;
        private final int b;
        private final int c;
        private final int d;
        private final int e;
        private boolean f;
        private int g;
        private int h;
        private float[] i;

        public String toString() {
            return d.class.getSimpleName() + " [RGB: #" + Integer.toHexString(e()) + "] [HSL: " + Arrays.toString(c()) + "] [Population: " + this.e + "] [Title Text: #" + Integer.toHexString(f()) + "] [Body Text: #" + Integer.toHexString(b()) + ']';
        }

        public d(int i, int i2) {
            this.a = Color.red(i);
            this.b = Color.green(i);
            this.c = Color.blue(i);
            this.d = i;
            this.e = i2;
        }

        public int e() {
            return this.d;
        }

        public float[] c() {
            if (this.i == null) {
                this.i = new float[3];
            }
            v6.a(this.a, this.b, this.c, this.i);
            return this.i;
        }

        public int d() {
            return this.e;
        }

        public int f() {
            a();
            return this.g;
        }

        public int b() {
            a();
            return this.h;
        }

        private void a() {
            int iD;
            int iD2;
            if (this.f) {
                return;
            }
            int iA = v6.a(-1, this.d, 4.5f);
            int iA2 = v6.a(-1, this.d, 3.0f);
            if (iA != -1 && iA2 != -1) {
                this.h = v6.d(-1, iA);
                this.g = v6.d(-1, iA2);
                this.f = true;
                return;
            }
            int iA3 = v6.a(-16777216, this.d, 4.5f);
            int iA4 = v6.a(-16777216, this.d, 3.0f);
            if (iA3 != -1 && iA4 != -1) {
                this.h = v6.d(-16777216, iA3);
                this.g = v6.d(-16777216, iA4);
                this.f = true;
                return;
            }
            if (iA != -1) {
                iD = v6.d(-1, iA);
            } else {
                iD = v6.d(-16777216, iA3);
            }
            this.h = iD;
            if (iA2 != -1) {
                iD2 = v6.d(-1, iA2);
            } else {
                iD2 = v6.d(-16777216, iA4);
            }
            this.g = iD2;
            this.f = true;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.e == dVar.e && this.d == dVar.d;
        }

        public int hashCode() {
            return (this.d * 31) + this.e;
        }
    }

    public d c(u10 u10Var) {
        return this.c.get(u10Var);
    }

    /* compiled from: A */
    public static final class b {
        private final List<d> a;
        private final Bitmap b;
        private final List<u10> c;
        private int d;
        private int e;
        private int f;
        private final List<c> g;
        private Rect h;

        public b(Bitmap bitmap) {
            ArrayList arrayList = new ArrayList();
            this.c = arrayList;
            this.d = 16;
            this.e = 12544;
            this.f = -1;
            ArrayList arrayList2 = new ArrayList();
            this.g = arrayList2;
            if (bitmap != null && !bitmap.isRecycled()) {
                arrayList2.add(kt.f);
                this.b = bitmap;
                this.a = null;
                arrayList.add(u10.e);
                arrayList.add(u10.f);
                arrayList.add(u10.g);
                arrayList.add(u10.h);
                arrayList.add(u10.i);
                arrayList.add(u10.j);
                return;
            }
            throw new IllegalArgumentException("Bitmap is not valid");
        }

        public kt a() {
            List<d> listA;
            c[] cVarArr;
            Bitmap bitmap = this.b;
            if (bitmap != null) {
                Bitmap bitmapB = b(bitmap);
                Rect rect = this.h;
                if (bitmapB != this.b && rect != null) {
                    double width = bitmapB.getWidth();
                    double width2 = this.b.getWidth();
                    Double.isNaN(width);
                    Double.isNaN(width2);
                    double d = width / width2;
                    double d2 = rect.left;
                    Double.isNaN(d2);
                    rect.left = (int) Math.floor(d2 * d);
                    double d3 = rect.top;
                    Double.isNaN(d3);
                    rect.top = (int) Math.floor(d3 * d);
                    double d4 = rect.right;
                    Double.isNaN(d4);
                    rect.right = Math.min((int) Math.ceil(d4 * d), bitmapB.getWidth());
                    double d5 = rect.bottom;
                    Double.isNaN(d5);
                    rect.bottom = Math.min((int) Math.ceil(d5 * d), bitmapB.getHeight());
                }
                int[] iArrA = a(bitmapB);
                int i = this.d;
                if (this.g.isEmpty()) {
                    cVarArr = null;
                } else {
                    List<c> list = this.g;
                    cVarArr = (c[]) list.toArray(new c[list.size()]);
                }
                t6 t6Var = new t6(iArrA, i, cVarArr);
                if (bitmapB != this.b) {
                    bitmapB.recycle();
                }
                listA = t6Var.a();
            } else {
                listA = this.a;
                if (listA == null) {
                    throw new AssertionError();
                }
            }
            kt ktVar = new kt(listA, this.c);
            ktVar.b();
            return ktVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x003f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private android.graphics.Bitmap b(android.graphics.Bitmap r6) {
            /*
                r5 = this;
                int r0 = r5.e
                if (r0 <= 0) goto L20
                int r0 = r6.getWidth()
                int r1 = r6.getHeight()
                int r0 = r0 * r1
                int r1 = r5.e
                if (r0 <= r1) goto L3f
                double r1 = (double) r1
                double r3 = (double) r0
                java.lang.Double.isNaN(r1)
                java.lang.Double.isNaN(r3)
                double r1 = r1 / r3
                double r0 = java.lang.Math.sqrt(r1)
                goto L41
            L20:
                int r0 = r5.f
                if (r0 <= 0) goto L3f
                int r0 = r6.getWidth()
                int r1 = r6.getHeight()
                int r0 = java.lang.Math.max(r0, r1)
                int r1 = r5.f
                if (r0 <= r1) goto L3f
                double r1 = (double) r1
                double r3 = (double) r0
                java.lang.Double.isNaN(r1)
                java.lang.Double.isNaN(r3)
                double r0 = r1 / r3
                goto L41
            L3f:
                r0 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            L41:
                r2 = 0
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 > 0) goto L48
                return r6
            L48:
                int r2 = r6.getWidth()
                double r2 = (double) r2
                java.lang.Double.isNaN(r2)
                double r2 = r2 * r0
                double r2 = java.lang.Math.ceil(r2)
                int r2 = (int) r2
                int r3 = r6.getHeight()
                double r3 = (double) r3
                java.lang.Double.isNaN(r3)
                double r3 = r3 * r0
                double r0 = java.lang.Math.ceil(r3)
                int r0 = (int) r0
                r1 = 0
                android.graphics.Bitmap r6 = android.graphics.Bitmap.createScaledBitmap(r6, r2, r0, r1)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.kt.b.b(android.graphics.Bitmap):android.graphics.Bitmap");
        }

        private int[] a(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            Rect rect = this.h;
            if (rect == null) {
                return iArr;
            }
            int iWidth = rect.width();
            int iHeight = this.h.height();
            int[] iArr2 = new int[iWidth * iHeight];
            for (int i = 0; i < iHeight; i++) {
                Rect rect2 = this.h;
                System.arraycopy(iArr, ((rect2.top + i) * width) + rect2.left, iArr2, i * iWidth, iWidth);
            }
            return iArr2;
        }
    }

    private d b(u10 u10Var) {
        int size = this.a.size();
        float f2 = 0.0f;
        d dVar = null;
        for (int i = 0; i < size; i++) {
            d dVar2 = this.a.get(i);
            if (b(dVar2, u10Var)) {
                float fA = a(dVar2, u10Var);
                if (dVar == null || fA > f2) {
                    dVar = dVar2;
                    f2 = fA;
                }
            }
        }
        return dVar;
    }

    private float a(d dVar, u10 u10Var) {
        float[] fArrC = dVar.c();
        d dVar2 = this.e;
        return (u10Var.g() > 0.0f ? u10Var.g() * (1.0f - Math.abs(fArrC[1] - u10Var.i())) : 0.0f) + (u10Var.a() > 0.0f ? u10Var.a() * (1.0f - Math.abs(fArrC[2] - u10Var.h())) : 0.0f) + (u10Var.f() > 0.0f ? u10Var.f() * (dVar.d() / (dVar2 != null ? dVar2.d() : 1)) : 0.0f);
    }

    /* compiled from: A */
    class a implements c {
        a() {
        }

        @Override // com.qq.e.comm.plugin.kt.c
        public boolean a(int i, float[] fArr) {
            return (c(fArr) || a(fArr) || b(fArr)) ? false : true;
        }

        private boolean c(float[] fArr) {
            return fArr[2] >= 0.95f;
        }

        private boolean b(float[] fArr) {
            float f = fArr[0];
            return f >= 10.0f && f <= 37.0f && fArr[1] <= 0.82f;
        }

        private boolean a(float[] fArr) {
            return fArr[2] <= 0.05f;
        }
    }

    private boolean b(d dVar, u10 u10Var) {
        float[] fArrC = dVar.c();
        return fArrC[1] >= u10Var.e() && fArrC[1] <= u10Var.c() && fArrC[2] >= u10Var.d() && fArrC[2] <= u10Var.b() && !this.d.get(dVar.e());
    }

    private d a(u10 u10Var) {
        d dVarB = b(u10Var);
        if (dVarB != null && u10Var.j()) {
            this.d.append(dVarB.e(), true);
        }
        return dVarB;
    }
}

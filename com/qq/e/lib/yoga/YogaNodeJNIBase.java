package com.qq.e.lib.yoga;

import com.qq.e.comm.plugin.a60;
import com.qq.e.comm.plugin.b60;
import com.qq.e.comm.plugin.c60;
import com.qq.e.comm.plugin.d60;
import com.qq.e.comm.plugin.e60;
import com.qq.e.comm.plugin.f60;
import com.qq.e.comm.plugin.g60;
import com.qq.e.comm.plugin.k60;
import com.qq.e.comm.plugin.l60;
import com.qq.e.comm.plugin.o60;
import com.qq.e.comm.plugin.p60;
import com.qq.e.comm.plugin.r60;
import com.qq.e.lib.yoga.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class YogaNodeJNIBase extends com.qq.e.lib.yoga.a implements Cloneable {
    private YogaNodeJNIBase a;
    private float[] arr;
    private List<YogaNodeJNIBase> b;
    private k60 c;
    protected long d;
    private Object e;
    private boolean f;
    private int mLayoutDirection;

    /* compiled from: A */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d60.values().length];
            a = iArr;
            try {
                iArr[d60.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d60.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[d60.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[d60.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[d60.START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[d60.END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private YogaNodeJNIBase(long j) {
        this.arr = null;
        this.mLayoutDirection = 0;
        this.f = true;
        if (j == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
        this.d = j;
    }

    private final long replaceChild(YogaNodeJNIBase yogaNodeJNIBase, int i) {
        List<YogaNodeJNIBase> list = this.b;
        if (list == null) {
            throw new IllegalStateException("Cannot replace child. YogaNode does not have children");
        }
        list.remove(i);
        this.b.add(i, yogaNodeJNIBase);
        yogaNodeJNIBase.a = this;
        return yogaNodeJNIBase.d;
    }

    public final float baseline(float f, float f2) {
        throw null;
    }

    @Override // com.qq.e.lib.yoga.a
    public void h(float f) {
        YogaNative.jni_YGNodeStyleSetMaxHeightJNI(this.d, f);
    }

    @Override // com.qq.e.lib.yoga.a
    public c j() {
        return a(YogaNative.jni_YGNodeStyleGetWidthJNI(this.d));
    }

    @Override // com.qq.e.lib.yoga.a
    public boolean k() {
        return YogaNative.jni_YGNodeIsDirtyJNI(this.d);
    }

    @Override // com.qq.e.lib.yoga.a
    public void l() {
        YogaNative.jni_YGNodeStyleSetHeightAutoJNI(this.d);
    }

    @Override // com.qq.e.lib.yoga.a
    public void m() {
        YogaNative.jni_YGNodeStyleSetWidthAutoJNI(this.d);
    }

    public final long measure(float f, int i, float f2, int i2) {
        if (p()) {
            return this.c.a(this, f, l60.a(i), f2, l60.a(i2));
        }
        throw new RuntimeException("Measure function isn't defined!");
    }

    @Override // com.qq.e.lib.yoga.a
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase i() {
        return this.a;
    }

    @Override // com.qq.e.lib.yoga.a
    public void p(float f) {
        YogaNative.jni_YGNodeStyleSetWidthJNI(this.d, f);
    }

    @Override // com.qq.e.lib.yoga.a
    public void q(float f) {
        YogaNative.jni_YGNodeStyleSetWidthPercentJNI(this.d, f);
    }

    @Override // com.qq.e.lib.yoga.a
    public float h() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[4];
        }
        return 0.0f;
    }

    @Override // com.qq.e.lib.yoga.a
    public void i(float f) {
        YogaNative.jni_YGNodeStyleSetMaxHeightPercentJNI(this.d, f);
    }

    @Override // com.qq.e.lib.yoga.a
    public void j(float f) {
        YogaNative.jni_YGNodeStyleSetMaxWidthJNI(this.d, f);
    }

    @Override // com.qq.e.lib.yoga.a
    public void k(float f) {
        YogaNative.jni_YGNodeStyleSetMaxWidthPercentJNI(this.d, f);
    }

    @Override // com.qq.e.lib.yoga.a
    public void l(float f) {
        YogaNative.jni_YGNodeStyleSetMinHeightJNI(this.d, f);
    }

    @Override // com.qq.e.lib.yoga.a
    public void m(float f) {
        YogaNative.jni_YGNodeStyleSetMinHeightPercentJNI(this.d, f);
    }

    @Override // com.qq.e.lib.yoga.a
    public void o(float f) {
        YogaNative.jni_YGNodeStyleSetMinWidthPercentJNI(this.d, f);
    }

    public boolean p() {
        return this.c != null;
    }

    YogaNodeJNIBase() {
        this(YogaNative.jni_YGNodeNewJNI());
    }

    @Override // com.qq.e.lib.yoga.a
    public void b(a60 a60Var) {
        YogaNative.jni_YGNodeStyleSetAlignItemsJNI(this.d, a60Var.b());
    }

    @Override // com.qq.e.lib.yoga.a
    public void c(a60 a60Var) {
        YogaNative.jni_YGNodeStyleSetAlignSelfJNI(this.d, a60Var.b());
    }

    @Override // com.qq.e.lib.yoga.a
    public void d(d60 d60Var, float f) {
        YogaNative.jni_YGNodeStyleSetPaddingJNI(this.d, d60Var.b(), f);
    }

    @Override // com.qq.e.lib.yoga.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase b(int i) {
        List<YogaNodeJNIBase> list = this.b;
        if (list != null) {
            YogaNodeJNIBase yogaNodeJNIBaseRemove = list.remove(i);
            yogaNodeJNIBaseRemove.a = null;
            YogaNative.jni_YGNodeRemoveChildJNI(this.d, yogaNodeJNIBaseRemove.d);
            return yogaNodeJNIBaseRemove;
        }
        throw new IllegalStateException("Trying to remove a child of a YogaNode that does not have children");
    }

    @Override // com.qq.e.lib.yoga.a
    public void e(d60 d60Var, float f) {
        YogaNative.jni_YGNodeStyleSetPaddingPercentJNI(this.d, d60Var.b(), f);
    }

    @Override // com.qq.e.lib.yoga.a
    public void e(float f) {
        YogaNative.jni_YGNodeStyleSetFlexShrinkJNI(this.d, f);
    }

    @Override // com.qq.e.lib.yoga.a
    public float e() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[2];
        }
        return 0.0f;
    }

    @Override // com.qq.e.lib.yoga.a
    public void d(float f) {
        YogaNative.jni_YGNodeStyleSetFlexGrowJNI(this.d, f);
    }

    @Override // com.qq.e.lib.yoga.a
    public c d() {
        return a(YogaNative.jni_YGNodeStyleGetHeightJNI(this.d));
    }

    @Override // com.qq.e.lib.yoga.a
    public void f(d60 d60Var, float f) {
        YogaNative.jni_YGNodeStyleSetPositionJNI(this.d, d60Var.b(), f);
    }

    @Override // com.qq.e.lib.yoga.a
    public void f(float f) {
        YogaNative.jni_YGNodeStyleSetHeightJNI(this.d, f);
    }

    @Override // com.qq.e.lib.yoga.a
    public float f() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[1];
        }
        return 0.0f;
    }

    @Override // com.qq.e.lib.yoga.a
    public void g(d60 d60Var, float f) {
        YogaNative.jni_YGNodeStyleSetPositionPercentJNI(this.d, d60Var.b(), f);
    }

    @Override // com.qq.e.lib.yoga.a
    public void g(float f) {
        YogaNative.jni_YGNodeStyleSetHeightPercentJNI(this.d, f);
    }

    @Override // com.qq.e.lib.yoga.a
    public float g() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[3];
        }
        return 0.0f;
    }

    @Override // com.qq.e.lib.yoga.a
    public float a(d60 d60Var) {
        float[] fArr = this.arr;
        if (fArr == null || (((int) fArr[0]) & 1) != 1) {
            return 0.0f;
        }
        switch (a.a[d60Var.ordinal()]) {
            case 1:
                return this.arr[6];
            case 2:
                return this.arr[7];
            case 3:
                return this.arr[8];
            case 4:
                return this.arr[9];
            case 5:
                if (n() == b60.RTL) {
                    return this.arr[8];
                }
                return this.arr[6];
            case 6:
                if (n() == b60.RTL) {
                    return this.arr[6];
                }
                return this.arr[8];
            default:
                throw new IllegalArgumentException("Cannot get layout margins of multi-edge shorthands");
        }
    }

    @Override // com.qq.e.lib.yoga.a
    public void b(d60 d60Var, float f) {
        YogaNative.jni_YGNodeStyleSetMarginJNI(this.d, d60Var.b(), f);
    }

    @Override // com.qq.e.lib.yoga.a
    public void c(d60 d60Var, float f) {
        YogaNative.jni_YGNodeStyleSetMarginPercentJNI(this.d, d60Var.b(), f);
    }

    @Override // com.qq.e.lib.yoga.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase a(int i) {
        List<YogaNodeJNIBase> list = this.b;
        if (list != null) {
            return list.get(i);
        }
        throw new IllegalStateException("YogaNode does not have children");
    }

    @Override // com.qq.e.lib.yoga.a
    public void c(float f) {
        YogaNative.jni_YGNodeStyleSetFlexBasisJNI(this.d, f);
    }

    @Override // com.qq.e.lib.yoga.a
    public Object c() {
        return this.e;
    }

    public b60 n() {
        float[] fArr = this.arr;
        return b60.a(fArr != null ? (int) fArr[5] : this.mLayoutDirection);
    }

    @Override // com.qq.e.lib.yoga.a
    public void n(float f) {
        YogaNative.jni_YGNodeStyleSetMinWidthJNI(this.d, f);
    }

    @Override // com.qq.e.lib.yoga.a
    public void a(a60 a60Var) {
        YogaNative.jni_YGNodeStyleSetAlignContentJNI(this.d, a60Var.b());
    }

    @Override // com.qq.e.lib.yoga.a
    public void b(d60 d60Var) {
        YogaNative.jni_YGNodeStyleSetMarginAutoJNI(this.d, d60Var.b());
    }

    @Override // com.qq.e.lib.yoga.a
    public int b() {
        List<YogaNodeJNIBase> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.qq.e.lib.yoga.a
    public void b(float f) {
        YogaNative.jni_YGNodeStyleSetFlexJNI(this.d, f);
    }

    @Override // com.qq.e.lib.yoga.a
    public void a(d60 d60Var, float f) {
        YogaNative.jni_YGNodeStyleSetBorderJNI(this.d, d60Var.b(), f);
    }

    @Override // com.qq.e.lib.yoga.a
    public void a(b60 b60Var) {
        YogaNative.jni_YGNodeStyleSetDirectionJNI(this.d, b60Var.b());
    }

    @Override // com.qq.e.lib.yoga.a
    public void a(c60 c60Var) {
        YogaNative.jni_YGNodeStyleSetDisplayJNI(this.d, c60Var.b());
    }

    @Override // com.qq.e.lib.yoga.a
    public void a(e60 e60Var) {
        YogaNative.jni_YGNodeStyleSetFlexDirectionJNI(this.d, e60Var.b());
    }

    @Override // com.qq.e.lib.yoga.a
    public void a(f60 f60Var, float f) {
        YogaNative.jni_YGNodeStyleSetGapJNI(this.d, f60Var.b(), f);
    }

    @Override // com.qq.e.lib.yoga.a
    public void a(g60 g60Var) {
        YogaNative.jni_YGNodeStyleSetJustifyContentJNI(this.d, g60Var.b());
    }

    @Override // com.qq.e.lib.yoga.a
    public void a(k60 k60Var) {
        this.c = k60Var;
        YogaNative.jni_YGNodeSetHasMeasureFuncJNI(this.d, k60Var != null);
    }

    @Override // com.qq.e.lib.yoga.a
    public void a(o60 o60Var) {
        YogaNative.jni_YGNodeStyleSetOverflowJNI(this.d, o60Var.b());
    }

    @Override // com.qq.e.lib.yoga.a
    public void a(p60 p60Var) {
        YogaNative.jni_YGNodeStyleSetPositionTypeJNI(this.d, p60Var.b());
    }

    @Override // com.qq.e.lib.yoga.a
    public void a(r60 r60Var) {
        YogaNative.jni_YGNodeStyleSetFlexWrapJNI(this.d, r60Var.b());
    }

    @Override // com.qq.e.lib.yoga.a
    public void a(com.qq.e.lib.yoga.a aVar, int i) {
        if (aVar instanceof YogaNodeJNIBase) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) aVar;
            if (yogaNodeJNIBase.a == null) {
                if (this.b == null) {
                    this.b = new ArrayList(4);
                }
                this.b.add(i, yogaNodeJNIBase);
                yogaNodeJNIBase.a = this;
                YogaNative.jni_YGNodeInsertChildJNI(this.d, yogaNodeJNIBase.d, i);
                return;
            }
            throw new IllegalStateException("Child already has a parent, it must be removed first.");
        }
    }

    @Override // com.qq.e.lib.yoga.a
    public void a(float f, float f2) {
        a((com.qq.e.lib.yoga.a) null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        for (int i = 0; i < arrayList.size(); i++) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) arrayList.get(i);
            List<YogaNodeJNIBase> list = yogaNodeJNIBase.b;
            if (list != null) {
                for (YogaNodeJNIBase yogaNodeJNIBase2 : list) {
                    yogaNodeJNIBase2.a((com.qq.e.lib.yoga.a) yogaNodeJNIBase);
                    arrayList.add(yogaNodeJNIBase2);
                }
            }
        }
        YogaNodeJNIBase[] yogaNodeJNIBaseArr = (YogaNodeJNIBase[]) arrayList.toArray(new YogaNodeJNIBase[arrayList.size()]);
        long[] jArr = new long[yogaNodeJNIBaseArr.length];
        for (int i2 = 0; i2 < yogaNodeJNIBaseArr.length; i2++) {
            jArr[i2] = yogaNodeJNIBaseArr[i2].d;
        }
        YogaNative.jni_YGNodeCalculateLayoutJNI(this.d, f, f2, jArr, yogaNodeJNIBaseArr);
    }

    private void a(com.qq.e.lib.yoga.a aVar) {
        Object objC = c();
        if (objC instanceof a.InterfaceC0726a) {
            ((a.InterfaceC0726a) objC).a(this, aVar);
        }
    }

    @Override // com.qq.e.lib.yoga.a
    public void a() {
        YogaNative.jni_YGNodeMarkDirtyJNI(this.d);
    }

    @Override // com.qq.e.lib.yoga.a
    public void a(float f) {
        YogaNative.jni_YGNodeStyleSetAspectRatioJNI(this.d, f);
    }

    @Override // com.qq.e.lib.yoga.a
    public void a(Object obj) {
        this.e = obj;
    }

    private static c a(long j) {
        return new c(Float.intBitsToFloat((int) j), (int) (j >> 32));
    }
}

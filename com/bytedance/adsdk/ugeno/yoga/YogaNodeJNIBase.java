package com.bytedance.adsdk.ugeno.yoga;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class YogaNodeJNIBase extends tc implements Cloneable {
    private Object an;
    private float[] arr;
    private List<YogaNodeJNIBase> b;
    private h c;
    protected long d;
    private boolean h;
    private YogaNodeJNIBase hc;
    private int mLayoutDirection;
    private hc u;

    private YogaNodeJNIBase(long j) {
        this.arr = null;
        this.mLayoutDirection = 0;
        this.h = true;
        if (j == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
        this.d = j;
    }

    YogaNodeJNIBase() {
        this(YogaNative.jni_YGNodeNewJNI());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public int d() {
        List<YogaNodeJNIBase> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase d(int i) {
        List<YogaNodeJNIBase> list = this.b;
        if (list == null) {
            throw new IllegalStateException("YogaNode does not have children");
        }
        return list.get(i);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public void d(tc tcVar, int i) {
        if (tcVar instanceof YogaNodeJNIBase) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) tcVar;
            if (yogaNodeJNIBase.hc != null) {
                throw new IllegalStateException("Child already has a parent, it must be removed first.");
            }
            if (this.b == null) {
                this.b = new ArrayList(4);
            }
            this.b.add(i, yogaNodeJNIBase);
            yogaNodeJNIBase.hc = this;
            YogaNative.jni_YGNodeInsertChildJNI(this.d, yogaNodeJNIBase.d, i);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase hc(int i) {
        List<YogaNodeJNIBase> list = this.b;
        if (list == null) {
            throw new IllegalStateException("Trying to remove a child of a YogaNode that does not have children");
        }
        YogaNodeJNIBase yogaNodeJNIBaseRemove = list.remove(i);
        yogaNodeJNIBaseRemove.hc = null;
        YogaNative.jni_YGNodeRemoveChildJNI(this.d, yogaNodeJNIBaseRemove.d);
        return yogaNodeJNIBaseRemove;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    /* renamed from: mk, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase hc() {
        return this.hc;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public int d(tc tcVar) {
        List<YogaNodeJNIBase> list = this.b;
        if (list == null) {
            return -1;
        }
        return list.indexOf(tcVar);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public void d(float f, float f2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        for (int i = 0; i < arrayList.size(); i++) {
            List<YogaNodeJNIBase> list = ((YogaNodeJNIBase) arrayList.get(i)).b;
            if (list != null) {
                Iterator<YogaNodeJNIBase> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
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

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public void d(b bVar) {
        YogaNative.jni_YGNodeStyleSetDirectionJNI(this.d, bVar.d());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public void d(u uVar) {
        YogaNative.jni_YGNodeStyleSetFlexDirectionJNI(this.d, uVar.d());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public void d(an anVar) {
        YogaNative.jni_YGNodeStyleSetJustifyContentJNI(this.d, anVar.d());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public void d(d dVar) {
        YogaNative.jni_YGNodeStyleSetAlignItemsJNI(this.d, dVar.d());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public void hc(d dVar) {
        YogaNative.jni_YGNodeStyleSetAlignSelfJNI(this.d, dVar.d());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public void b(d dVar) {
        YogaNative.jni_YGNodeStyleSetAlignContentJNI(this.d, dVar.d());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public void d(uo uoVar) {
        YogaNative.jni_YGNodeStyleSetPositionTypeJNI(this.d, uoVar.d());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public void d(k kVar) {
        YogaNative.jni_YGNodeStyleSetFlexWrapJNI(this.d, kVar.d());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public void d(float f) {
        YogaNative.jni_YGNodeStyleSetFlexGrowJNI(this.d, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public void hc(float f) {
        YogaNative.jni_YGNodeStyleSetFlexShrinkJNI(this.d, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public void b(float f) {
        YogaNative.jni_YGNodeStyleSetFlexBasisJNI(this.d, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public void b() {
        YogaNative.jni_YGNodeStyleSetFlexBasisAutoJNI(this.d);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public void d(c cVar, float f) {
        YogaNative.jni_YGNodeStyleSetMarginJNI(this.d, cVar.d(), f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public void hc(c cVar, float f) {
        YogaNative.jni_YGNodeStyleSetPaddingJNI(this.d, cVar.d(), f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public void b(c cVar, float f) {
        YogaNative.jni_YGNodeStyleSetPositionJNI(this.d, cVar.d(), f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public void c(float f) {
        YogaNative.jni_YGNodeStyleSetWidthJNI(this.d, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public void u(float f) {
        YogaNative.jni_YGNodeStyleSetWidthPercentJNI(this.d, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public void c() {
        YogaNative.jni_YGNodeStyleSetWidthAutoJNI(this.d);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public void an(float f) {
        YogaNative.jni_YGNodeStyleSetHeightJNI(this.d, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public void h(float f) {
        YogaNative.jni_YGNodeStyleSetHeightPercentJNI(this.d, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public void u() {
        YogaNative.jni_YGNodeStyleSetHeightAutoJNI(this.d);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public void gb(float f) {
        YogaNative.jni_YGNodeStyleSetMinWidthJNI(this.d, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public void tt(float f) {
        YogaNative.jni_YGNodeStyleSetMinHeightJNI(this.d, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public void tc(float f) {
        YogaNative.jni_YGNodeStyleSetMaxWidthJNI(this.d, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public void mk(float f) {
        YogaNative.jni_YGNodeStyleSetMaxHeightJNI(this.d, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public void mq(float f) {
        YogaNative.jni_YGNodeStyleSetAspectRatioJNI(this.d, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public void d(h hVar) {
        this.c = hVar;
        YogaNative.jni_YGNodeSetHasMeasureFuncJNI(this.d, hVar != null);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public void d(boolean z) {
        YogaNative.jni_YGNodeSetAlwaysFormsContainingBlockJNI(this.d, z);
    }

    public final long measure(float f, int i, float f2, int i2) {
        if (!mq()) {
            throw new RuntimeException("Measure function isn't defined!");
        }
        return this.c.d(this, f, gb.d(i), f2, gb.d(i2));
    }

    public final float baseline(float f, float f2) {
        return this.u.d(this, f, f2);
    }

    public boolean mq() {
        return this.c != null;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public void d(Object obj) {
        this.an = obj;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public Object tc() {
        return this.an;
    }

    private final long replaceChild(YogaNodeJNIBase yogaNodeJNIBase, int i) {
        List<YogaNodeJNIBase> list = this.b;
        if (list == null) {
            throw new IllegalStateException("Cannot replace child. YogaNode does not have children");
        }
        list.remove(i);
        this.b.add(i, yogaNodeJNIBase);
        yogaNodeJNIBase.hc = this;
        return yogaNodeJNIBase.d;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public float an() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[3];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public float h() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[4];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public float gb() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[1];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.tc
    public float tt() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[2];
        }
        return 0.0f;
    }
}

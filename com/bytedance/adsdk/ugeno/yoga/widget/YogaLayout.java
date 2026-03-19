package com.bytedance.adsdk.ugeno.yoga.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.b;
import com.bytedance.adsdk.ugeno.d.gb;
import com.bytedance.adsdk.ugeno.d.h;
import com.bytedance.adsdk.ugeno.yoga.an;
import com.bytedance.adsdk.ugeno.yoga.c;
import com.bytedance.adsdk.ugeno.yoga.k;
import com.bytedance.adsdk.ugeno.yoga.mk;
import com.bytedance.adsdk.ugeno.yoga.tc;
import com.bytedance.adsdk.ugeno.yoga.tt;
import com.bytedance.adsdk.ugeno.yoga.u;
import com.bytedance.adsdk.ugeno.yoga.uo;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class YogaLayout extends ViewGroup implements h, com.bytedance.adsdk.ugeno.hc.hc {
    private b b;
    private gb c;
    private final Map<View, tc> d;
    private final tc hc;

    public YogaLayout(Context context) {
        this(context, null, 0);
    }

    public YogaLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new gb(this);
        tc tcVarD = mk.d();
        this.hc = tcVarD;
        this.d = new HashMap();
        tcVarD.d(this);
        tcVarD.d((com.bytedance.adsdk.ugeno.yoga.h) new hc());
        d((d) generateDefaultLayoutParams(), tcVarD, this);
    }

    public tc getYogaNode() {
        return this.hc;
    }

    public tc d(View view) {
        return this.d.get(view);
    }

    @Override // com.bytedance.adsdk.ugeno.hc.hc
    public void d(int i) {
        tc tcVar = this.hc;
        if (tcVar != null) {
            d(tcVar, i);
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hc.hc
    public void hc(int i) {
        tc tcVar = this.hc;
        if (tcVar != null) {
            hc(tcVar, i);
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hc.hc
    public void d(View view, int i) {
        tc tcVarD;
        if (view == null || (tcVarD = d(view)) == null) {
            return;
        }
        d(tcVarD, i);
        view.requestLayout();
    }

    @Override // com.bytedance.adsdk.ugeno.hc.hc
    public void hc(View view, int i) {
        tc tcVarD;
        if (view == null || (tcVarD = d(view)) == null) {
            return;
        }
        hc(tcVarD, i);
        view.requestLayout();
    }

    private void d(tc tcVar, int i) {
        if (i == -1) {
            tcVar.u(100.0f);
        } else if (i == -2) {
            tcVar.c();
        } else {
            tcVar.c(i);
        }
    }

    private void hc(tc tcVar, int i) {
        if (i == -1) {
            tcVar.h(100.0f);
        } else if (i == -2) {
            tcVar.u();
        } else {
            tcVar.an(i);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hc.hc
    public void b(View view, int i) {
        c(view, i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        tc tcVarD;
        this.hc.d((com.bytedance.adsdk.ugeno.yoga.h) null);
        if (view instanceof VirtualYogaLayout) {
            VirtualYogaLayout virtualYogaLayout = (VirtualYogaLayout) view;
            virtualYogaLayout.d(this);
            tc yogaNode = virtualYogaLayout.getYogaNode();
            tc tcVar = this.hc;
            tcVar.d(yogaNode, tcVar.d());
            return;
        }
        super.addView(view, i, layoutParams);
        if (this.d.containsKey(view)) {
            return;
        }
        if (view instanceof YogaLayout) {
            tcVarD = ((YogaLayout) view).getYogaNode();
        } else {
            if (this.d.containsKey(view)) {
                tcVarD = this.d.get(view);
            } else {
                tcVarD = mk.d();
            }
            tcVarD.d(view);
            tcVarD.d((com.bytedance.adsdk.ugeno.yoga.h) new hc());
        }
        d((d) view.getLayoutParams(), tcVarD, view);
        this.d.put(view, tcVarD);
        if (view.getVisibility() == 8) {
            view.setTag(151060224, Integer.valueOf(this.hc.d()));
        } else {
            tc tcVar2 = this.hc;
            tcVar2.d(tcVarD, tcVar2.d());
        }
    }

    public void c(View view, int i) {
        int iD;
        view.setVisibility(i);
        try {
            tc tcVar = this.d.get(view);
            Object tag = view.getTag(151060224);
            if (i != 0) {
                if (i != 8 || (iD = this.hc.d(tcVar)) == -1) {
                    return;
                }
                this.hc.hc(iD);
                view.setTag(151060224, Integer.valueOf(iD));
                d(this.hc);
                return;
            }
            if (tag == null || this.hc.d(tcVar) != -1) {
                return;
            }
            int iIntValue = ((Integer) tag).intValue();
            if (iIntValue < this.hc.d()) {
                this.hc.d(this.d.get(view), iIntValue);
            } else {
                this.hc.d(this.d.get(view), this.hc.d());
            }
            d(this.hc);
        } catch (Throwable unused) {
        }
    }

    private void d(tc tcVar) {
        if (tcVar.hc() != null) {
            d(tcVar.hc());
        } else {
            tcVar.d(Float.NaN, Float.NaN);
        }
    }

    public void d(View view, tc tcVar) {
        this.d.put(view, tcVar);
        addView(view);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        d(view, false);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        d(getChildAt(i), false);
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        d(view, true);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            d(getChildAt(i3), false);
        }
        super.removeViews(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            d(getChildAt(i3), true);
        }
        super.removeViewsInLayout(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            d(getChildAt(i), false);
        }
        super.removeAllViews();
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            d(getChildAt(i), true);
        }
        super.removeAllViewsInLayout();
    }

    private void d(View view, boolean z) {
        tc tcVar = this.d.get(view);
        if (tcVar == null) {
            return;
        }
        tc tcVarHc = tcVar.hc();
        int i = 0;
        while (true) {
            if (i >= tcVarHc.d()) {
                break;
            }
            if (tcVarHc.d(i).equals(tcVar)) {
                tcVarHc.hc(i);
                break;
            }
            i++;
        }
        tcVar.d((Object) null);
        this.d.remove(view);
        if (z) {
            this.hc.d(Float.NaN, Float.NaN);
        }
    }

    private void d(tc tcVar, float f, float f2) {
        View view = (View) tcVar.tc();
        if (view != null && view != this) {
            if (view.getVisibility() == 8) {
                return;
            }
            int iRound = Math.round(tcVar.an() + f);
            int iRound2 = Math.round(tcVar.h() + f2);
            view.measure(View.MeasureSpec.makeMeasureSpec(Math.round(tcVar.gb()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(tcVar.tt()), 1073741824));
            view.layout(iRound, iRound2, view.getMeasuredWidth() + iRound, view.getMeasuredHeight() + iRound2);
        }
        int iD = tcVar.d();
        for (int i = 0; i < iD; i++) {
            if (equals(view)) {
                d(tcVar.d(i), f, f2);
            } else if (!(view instanceof YogaLayout)) {
                d(tcVar.d(i), tcVar.an() + f, tcVar.h() + f2);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        b bVar = this.b;
        if (bVar != null) {
            bVar.d(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.c();
        }
        if (!(getParent() instanceof YogaLayout)) {
            d(View.MeasureSpec.makeMeasureSpec(i3 - i, 1073741824), View.MeasureSpec.makeMeasureSpec(i4 - i2, 1073741824));
        }
        d(this.hc, 0.0f, 0.0f);
        b bVar2 = this.b;
        if (bVar2 != null) {
            bVar2.d(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (!(getParent() instanceof YogaLayout)) {
            d(i, i2);
        }
        b bVar = this.b;
        if (bVar != null) {
            int[] iArrD = bVar.d(i, i2);
            setMeasuredDimension(iArrD[0], iArrD[1]);
        } else {
            setMeasuredDimension(Math.round(this.hc.gb()), Math.round(this.hc.tt()));
        }
        b bVar2 = this.b;
        if (bVar2 != null) {
            bVar2.b();
        }
    }

    private void d(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 == 1073741824) {
            this.hc.an(size2);
        }
        if (mode == 1073741824) {
            this.hc.c(size);
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.hc.mk(size2);
        }
        if (mode == Integer.MIN_VALUE) {
            this.hc.tc(size);
        }
        this.hc.d(Float.NaN, Float.NaN);
    }

    protected static void d(d dVar, tc tcVar, View view) {
        if (Build.VERSION.SDK_INT >= 17 && view.getResources().getConfiguration().getLayoutDirection() == 1) {
            tcVar.d(com.bytedance.adsdk.ugeno.yoga.b.RTL);
        }
        Drawable background = view.getBackground();
        if (background != null) {
            if (background.getPadding(new Rect())) {
                tcVar.hc(c.LEFT, r0.left);
                tcVar.hc(c.TOP, r0.top);
                tcVar.hc(c.RIGHT, r0.right);
                tcVar.hc(c.BOTTOM, r0.bottom);
            }
        }
        for (int i = 0; i < dVar.d.size(); i++) {
            int iKeyAt = dVar.d.keyAt(i);
            float fFloatValue = dVar.d.valueAt(i).floatValue();
            if (iKeyAt == 4) {
                tcVar.b(com.bytedance.adsdk.ugeno.yoga.d.d(Math.round(fFloatValue)));
            } else if (iKeyAt == 0) {
                tcVar.d(com.bytedance.adsdk.ugeno.yoga.d.d(Math.round(fFloatValue)));
            } else if (iKeyAt == 9) {
                tcVar.hc(com.bytedance.adsdk.ugeno.yoga.d.d(Math.round(fFloatValue)));
            } else if (iKeyAt == 25) {
                tcVar.mq(fFloatValue);
            } else if (iKeyAt == 8) {
                if (fFloatValue < 0.0f) {
                    tcVar.b();
                } else {
                    tcVar.b(fFloatValue);
                }
            } else if (iKeyAt == 1) {
                tcVar.d(u.d(Math.round(fFloatValue)));
            } else if (iKeyAt == 6) {
                tcVar.d(fFloatValue);
            } else if (iKeyAt == 7) {
                tcVar.hc(fFloatValue);
            } else if (iKeyAt == 16) {
                if (fFloatValue == -1.0f) {
                    tcVar.h(100.0f);
                } else if (fFloatValue == -2.0f) {
                    tcVar.u();
                } else {
                    tcVar.an(fFloatValue);
                }
            } else if (iKeyAt == 18) {
                tcVar.d(c.LEFT, fFloatValue);
            } else if (iKeyAt == 3) {
                tcVar.d(an.d(Math.round(fFloatValue)));
            } else if (iKeyAt == 17) {
                tcVar.d(c.TOP, fFloatValue);
            } else if (iKeyAt == 20) {
                tcVar.d(c.RIGHT, fFloatValue);
            } else if (iKeyAt == 19) {
                tcVar.d(c.BOTTOM, fFloatValue);
            } else if (iKeyAt == 28) {
                tcVar.tt(fFloatValue);
            } else if (iKeyAt == 27) {
                tcVar.gb(fFloatValue);
            } else if (iKeyAt == 22) {
                tcVar.hc(c.LEFT, fFloatValue);
            } else if (iKeyAt == 21) {
                tcVar.hc(c.TOP, fFloatValue);
            } else if (iKeyAt == 24) {
                tcVar.hc(c.RIGHT, fFloatValue);
            } else if (iKeyAt == 23) {
                tcVar.hc(c.BOTTOM, fFloatValue);
            } else if (iKeyAt == 11) {
                tcVar.b(c.LEFT, fFloatValue);
            } else if (iKeyAt == 10) {
                tcVar.b(c.TOP, fFloatValue);
            } else if (iKeyAt == 13) {
                tcVar.b(c.RIGHT, fFloatValue);
            } else if (iKeyAt == 12) {
                tcVar.b(c.BOTTOM, fFloatValue);
            } else if (iKeyAt == 14) {
                tcVar.d(uo.d(Math.round(fFloatValue)));
            } else if (iKeyAt == 15) {
                if (fFloatValue == -1.0f) {
                    tcVar.u(100.0f);
                } else if (fFloatValue == -2.0f) {
                    tcVar.c();
                } else {
                    tcVar.c(fFloatValue);
                }
            } else if (iKeyAt == 2) {
                tcVar.d(k.d(Math.round(fFloatValue)));
            }
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new d(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new d(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof d;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.b;
        if (bVar != null) {
            bVar.u();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.b;
        if (bVar != null) {
            bVar.an();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        b bVar = this.b;
        if (bVar != null) {
            bVar.d(z);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        b bVar = this.b;
        if (bVar != null) {
            bVar.hc(i, i2, i3, i4);
        }
    }

    public void d(com.bytedance.adsdk.ugeno.hc.b bVar) {
        this.b = bVar;
    }

    public void setBorderRadius(float f) {
        this.c.d(f);
    }

    public float getBorderRadius() {
        return this.c.d();
    }

    public void setRipple(float f) {
        gb gbVar = this.c;
        if (gbVar != null) {
            gbVar.hc(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.d.h
    public float getRipple() {
        return this.c.getRipple();
    }

    public void setShine(float f) {
        gb gbVar = this.c;
        if (gbVar != null) {
            gbVar.b(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.d.h
    public float getShine() {
        return this.c.getShine();
    }

    public void setStretch(float f) {
        gb gbVar = this.c;
        if (gbVar != null) {
            gbVar.c(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.d.h
    public float getStretch() {
        return this.c.getStretch();
    }

    public void setRubIn(float f) {
        gb gbVar = this.c;
        if (gbVar != null) {
            gbVar.u(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.d.h
    public float getRubIn() {
        return this.c.getRubIn();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.c.d(i);
    }

    public static class d extends ViewGroup.LayoutParams {
        private float an;
        private float b;
        private float c;
        private float cb;
        SparseArray<Float> d;
        private float e;
        private float gb;
        private float h;
        SparseArray<String> hc;
        private float k;
        private float mk;
        private float mq;
        private float rf;
        private float tc;
        private float tt;
        private float u;
        private float uo;
        private float w;
        private float yo;

        public d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            if (layoutParams instanceof d) {
                d dVar = (d) layoutParams;
                this.d = dVar.d.clone();
                this.hc = dVar.hc.clone();
                return;
            }
            this.d = new SparseArray<>();
            this.hc = new SparseArray<>();
            if (layoutParams.width >= 0) {
                this.d.put(15, Float.valueOf(this.width));
            }
            if (layoutParams.height >= 0) {
                this.d.put(16, Float.valueOf(this.height));
            }
        }

        public d(int i, int i2) {
            super(i, i2);
            this.d = new SparseArray<>();
            this.hc = new SparseArray<>();
            if (i == -2 || i == -1 || i >= 0) {
                this.d.put(15, Float.valueOf(i));
            }
            if (i2 == -2 || i2 == -1 || i2 >= 0) {
                this.d.put(16, Float.valueOf(i2));
            }
        }

        public void d(float f) {
            this.h = f;
            this.d.put(5, Float.valueOf(f));
        }

        public void hc(float f) {
            this.gb = f;
            this.d.put(6, Float.valueOf(f));
        }

        public void b(float f) {
            this.tt = f;
            this.d.put(7, Float.valueOf(f));
        }

        public void c(float f) {
            this.tc = f;
            this.d.put(8, Float.valueOf(f));
        }

        public void u(float f) {
            this.mk = f;
            this.d.put(9, Float.valueOf(f));
        }

        public void an(float f) {
            this.mq = f;
            this.d.put(14, Float.valueOf(f));
        }

        public void h(float f) {
            this.uo = f;
            this.d.put(10, Float.valueOf(f));
        }

        public void gb(float f) {
            this.k = f;
            this.d.put(11, Float.valueOf(f));
        }

        public void tt(float f) {
            this.e = f;
            this.d.put(12, Float.valueOf(f));
        }

        public void tc(float f) {
            this.cb = f;
            this.d.put(13, Float.valueOf(f));
        }

        public void mk(float f) {
            this.b = f;
            this.d.put(17, Float.valueOf(f));
        }

        public void mq(float f) {
            this.c = f;
            this.d.put(18, Float.valueOf(f));
        }

        public void uo(float f) {
            this.u = f;
            this.d.put(19, Float.valueOf(f));
        }

        public void k(float f) {
            this.an = f;
            this.d.put(20, Float.valueOf(f));
        }

        public void e(float f) {
            this.w = f;
            this.d.put(25, Float.valueOf(f));
        }

        public void cb(float f) {
            this.yo = f;
            this.d.put(27, Float.valueOf(f));
        }

        public void w(float f) {
            this.rf = f;
            this.d.put(28, Float.valueOf(f));
        }
    }

    public static class hc implements com.bytedance.adsdk.ugeno.yoga.h {
        @Override // com.bytedance.adsdk.ugeno.yoga.h
        public long d(tc tcVar, float f, com.bytedance.adsdk.ugeno.yoga.gb gbVar, float f2, com.bytedance.adsdk.ugeno.yoga.gb gbVar2) {
            View view = (View) tcVar.tc();
            if (view == null || (view instanceof YogaLayout)) {
                return tt.d(0, 0);
            }
            view.measure(View.MeasureSpec.makeMeasureSpec((int) f, d(gbVar)), View.MeasureSpec.makeMeasureSpec((int) f2, d(gbVar2)));
            return tt.d(view.getMeasuredWidth(), view.getMeasuredHeight());
        }

        private int d(com.bytedance.adsdk.ugeno.yoga.gb gbVar) {
            if (gbVar == com.bytedance.adsdk.ugeno.yoga.gb.AT_MOST) {
                return Integer.MIN_VALUE;
            }
            return gbVar == com.bytedance.adsdk.ugeno.yoga.gb.EXACTLY ? 1073741824 : 0;
        }
    }
}

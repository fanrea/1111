package com.qq.e.comm.plugin;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class h60 extends ViewGroup {
    protected final Map<View, com.qq.e.lib.yoga.a> a;
    private com.qq.e.lib.yoga.a b;

    public h60(Context context) {
        super(context);
        this.a = new HashMap();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.a.containsKey(view)) {
            super.addView(view, i, layoutParams);
        }
    }

    public void a(View view, com.qq.e.lib.yoga.a aVar) {
        a(view, aVar, -1);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        a(view, false);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        a(getChildAt(i), false);
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        a(view, true);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            a(getChildAt(i3), false);
        }
        super.removeViews(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            a(getChildAt(i3), true);
        }
        super.removeViewsInLayout(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            a(getChildAt(i), false);
        }
        super.removeAllViews();
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            a(getChildAt(i), true);
        }
        super.removeAllViewsInLayout();
    }

    public void a(View view, com.qq.e.lib.yoga.a aVar, int i) {
        this.b.a((k60) null);
        this.a.put(view, aVar);
        com.qq.e.lib.yoga.a aVar2 = this.b;
        aVar2.a(aVar, aVar2.b());
        addView(view, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!(getParent() instanceof h60)) {
            a(View.MeasureSpec.makeMeasureSpec(i3 - i, 1073741824), View.MeasureSpec.makeMeasureSpec(i4 - i2, 1073741824));
        }
        a(this.b, 0.0f, 0.0f);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (!(getParent() instanceof h60)) {
            a(i, i2);
        }
        setMeasuredDimension(Math.round(this.b.f()), Math.round(this.b.e()));
    }

    /* compiled from: A */
    public static class a implements k60 {
        @Override // com.qq.e.comm.plugin.k60
        public long a(com.qq.e.lib.yoga.a aVar, float f, l60 l60Var, float f2, l60 l60Var2) {
            View view = (View) aVar.c();
            if (view != null && !(view instanceof h60)) {
                view.measure(View.MeasureSpec.makeMeasureSpec((int) f, a(l60Var)), View.MeasureSpec.makeMeasureSpec((int) f2, a(l60Var2)));
                return m60.a(view.getMeasuredWidth(), view.getMeasuredHeight());
            }
            return m60.a(0, 0);
        }

        private int a(l60 l60Var) {
            if (l60Var == l60.AT_MOST) {
                return Integer.MIN_VALUE;
            }
            return l60Var == l60.EXACTLY ? 1073741824 : 0;
        }
    }

    private void a(com.qq.e.lib.yoga.a aVar, float f, float f2) {
        View view = (View) aVar.c();
        if (view != null && view != this) {
            if (view.getVisibility() == 8) {
                return;
            }
            int iRound = Math.round(aVar.g() + f);
            int iRound2 = Math.round(aVar.h() + f2);
            view.measure(View.MeasureSpec.makeMeasureSpec(Math.round(aVar.f()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(aVar.e()), 1073741824));
            view.layout(iRound, iRound2, view.getMeasuredWidth() + iRound, view.getMeasuredHeight() + iRound2);
        }
        int iB = aVar.b();
        for (int i = 0; i < iB; i++) {
            if (equals(view)) {
                a(aVar.a(i), f, f2);
            } else if (!(view instanceof h60)) {
                a(aVar.a(i), aVar.g() + f, aVar.h() + f2);
            }
        }
    }

    private void a(int i, int i2) {
        this.b.a(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
    }

    public com.qq.e.lib.yoga.a a() {
        return this.b;
    }

    private void a(View view, boolean z) {
        com.qq.e.lib.yoga.a aVar = this.a.get(view);
        if (aVar == null) {
            return;
        }
        com.qq.e.lib.yoga.a aVarI = aVar.i();
        int i = 0;
        while (true) {
            if (i >= aVarI.b()) {
                break;
            }
            if (aVarI.a(i).equals(aVar)) {
                aVarI.b(i);
                break;
            }
            i++;
        }
        aVar.a((Object) null);
        this.a.remove(view);
        if (z) {
            this.b.a(Float.NaN, Float.NaN);
        }
    }

    public void a(com.qq.e.lib.yoga.a aVar) {
        this.b = aVar;
    }
}

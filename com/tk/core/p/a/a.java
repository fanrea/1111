package com.tk.core.p.a;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.kwad.yoga.YogaDirection;
import com.kwad.yoga.YogaEdge;
import com.kwad.yoga.YogaMeasureFunction;
import com.kwad.yoga.YogaMeasureMode;
import com.kwad.yoga.YogaUnit;
import com.kwad.yoga.b;
import com.kwad.yoga.c;
import com.kwad.yoga.e;
import com.tk.core.component.d;
import com.tk.core.component.g;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class a extends ViewGroup implements d {
    private static final e ajL = new e(-2.1474836E9f, YogaUnit.UNDEFINED);
    private e aen;
    private e aeo;
    private final g ajM;
    private final Map<View, c> ajN;
    private final c ajO;
    private e ajP;
    private e ajQ;

    static {
        if (com.tk.core.a.oP().oR() != null) {
            try {
                com.tk.core.a.oP().oR().loadLibrary("yoga");
            } catch (Throwable th) {
                com.tk.core.exception.a.a(th, -1);
                com.tk.core.i.a.a("YogaLayout", "load yoga exception", th);
            }
        }
    }

    public a(Context context) {
        super(context, null, 0);
        e eVar = ajL;
        this.aen = eVar;
        this.aeo = eVar;
        this.ajP = eVar;
        this.ajQ = eVar;
        this.ajM = new g(this);
        this.ajO = new com.kwad.yoga.d();
        this.ajN = new HashMap();
        this.ajO.setData(this);
        this.ajO.setMeasureFunction(new C0828a());
        a(this.ajO, this);
    }

    public c getYogaNode() {
        return this.ajO;
    }

    public final void a(View view, c cVar, int i) {
        b(view, cVar, i);
        addView(view, i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        this.ajM.aQ(view);
        setChildrenDrawingOrderEnabled(this.ajM.qG());
        super.addView(view, i, layoutParams);
    }

    private void b(View view, c cVar, int i) {
        this.ajO.setMeasureFunction(null);
        cVar.setData(view);
        this.ajN.put(view, cVar);
        this.ajO.addChildAt(cVar, i);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        d(view, false);
        this.ajM.aR(view);
        setChildrenDrawingOrderEnabled(this.ajM.qG());
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        d(getChildAt(i), false);
        this.ajM.aR(getChildAt(i));
        setChildrenDrawingOrderEnabled(this.ajM.qG());
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        return this.ajM.getChildDrawingOrder(i, i2);
    }

    public final int eg(int i) {
        return this.ajM.qG() ? this.ajM.getChildDrawingOrder(getChildCount(), i) : i;
    }

    @Override // com.tk.core.component.d
    public final void pK() {
        this.ajM.update();
        setChildrenDrawingOrderEnabled(this.ajM.qG());
        invalidate();
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
        c cVar = this.ajN.get(view);
        if (cVar == null) {
            return;
        }
        c owner = cVar.getOwner();
        int i = 0;
        while (true) {
            if (i >= owner.getChildCount()) {
                break;
            }
            if (owner.getChildAt(i).equals(cVar)) {
                owner.removeChildAt(i);
                break;
            }
            i++;
        }
        cVar.setData(null);
        this.ajN.remove(view);
        if (z) {
            this.ajO.calculateLayout(Float.NaN, Float.NaN);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(c cVar, float f, float f2) {
        View view = (View) cVar.getData();
        if (view == 0) {
            return;
        }
        if (view != this) {
            if (view.getVisibility() == 8) {
                return;
            }
            int iRound = Math.round(cVar.getLayoutX() + f);
            int iRound2 = Math.round(cVar.getLayoutY() + f2);
            view.measure(View.MeasureSpec.makeMeasureSpec(Math.round(cVar.getLayoutWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(cVar.getLayoutHeight()), 1073741824));
            view.layout(iRound, iRound2, view.getMeasuredWidth() + iRound, view.getMeasuredHeight() + iRound2);
        }
        int childCount = cVar.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (equals(view)) {
                a(cVar.getChildAt(i), f, f2);
            } else if (!(view instanceof a) && (!(view instanceof com.tk.core.component.c) || !((com.tk.core.component.c) view).nO())) {
                a(cVar.getChildAt(i), cVar.getLayoutX() + f, cVar.getLayoutY() + f2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ViewParent parent = getParent();
        if (!(parent instanceof a) && (!(parent instanceof com.tk.core.component.c) || !((com.tk.core.component.c) parent).nO())) {
            aS(View.MeasureSpec.makeMeasureSpec(i3 - i, 1073741824), View.MeasureSpec.makeMeasureSpec(i4 - i2, 1073741824));
        }
        a(this.ajO, 0.0f, 0.0f);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ViewParent parent = getParent();
        if (!(parent instanceof a) && (!(parent instanceof com.tk.core.component.c) || !((com.tk.core.component.c) parent).nO())) {
            if (this.ajP != ajL) {
                e width = this.ajO.getWidth();
                if (this.ajP.equals(width)) {
                    a(this.ajO, this.aen);
                } else if (this.aen != width) {
                    this.aen = width;
                }
                this.ajP = ajL;
            }
            if (this.ajQ != ajL) {
                e height = this.ajO.getHeight();
                if (this.ajQ.equals(height)) {
                    b(this.ajO, this.aeo);
                } else if (this.aeo != height) {
                    this.aeo = height;
                }
                this.ajQ = ajL;
            }
            aS(i, i2);
        }
        setMeasuredDimension(Math.round(this.ajO.getLayoutWidth()), Math.round(this.ajO.getLayoutHeight()));
    }

    private static void a(c cVar, e eVar) {
        if (eVar.Gg == YogaUnit.AUTO) {
            cVar.setWidthAuto();
            return;
        }
        if (eVar.Gg == YogaUnit.POINT) {
            cVar.setWidth(eVar.value);
        } else if (eVar.Gg == YogaUnit.PERCENT) {
            cVar.setWidthPercent(eVar.value);
        } else if (eVar.Gg == YogaUnit.UNDEFINED) {
            cVar.setWidth(Float.NaN);
        }
    }

    private static void b(c cVar, e eVar) {
        if (eVar.Gg == YogaUnit.AUTO) {
            cVar.setHeightAuto();
            return;
        }
        if (eVar.Gg == YogaUnit.POINT) {
            cVar.setHeight(eVar.value);
        } else if (eVar.Gg == YogaUnit.PERCENT) {
            cVar.setHeightPercent(eVar.value);
        } else if (eVar.Gg == YogaUnit.UNDEFINED) {
            cVar.setHeight(Float.NaN);
        }
    }

    private void aS(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 == 1073741824) {
            if (this.aeo == ajL) {
                this.aeo = this.ajO.getHeight();
            }
            this.ajO.setHeight(size2);
            this.ajQ = this.ajO.getHeight();
        }
        if (mode == 1073741824) {
            if (this.aen == ajL) {
                this.aen = this.ajO.getWidth();
            }
            this.ajO.setWidth(size);
            this.ajP = this.ajO.getWidth();
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.ajO.setMaxHeight(size2);
        }
        if (mode == Integer.MIN_VALUE) {
            this.ajO.setMaxWidth(size);
        }
        this.ajO.calculateLayout(Float.NaN, Float.NaN);
    }

    private static void a(c cVar, View view) {
        if (Build.VERSION.SDK_INT >= 17 && view.getResources().getConfiguration().getLayoutDirection() == 1) {
            cVar.setDirection(YogaDirection.RTL);
        }
        Drawable background = view.getBackground();
        if (background != null) {
            if (background.getPadding(new Rect())) {
                cVar.setPadding(YogaEdge.LEFT, r0.left);
                cVar.setPadding(YogaEdge.TOP, r0.top);
                cVar.setPadding(YogaEdge.RIGHT, r0.right);
                cVar.setPadding(YogaEdge.BOTTOM, r0.bottom);
            }
        }
    }

    /* renamed from: com.tk.core.p.a.a$a, reason: collision with other inner class name */
    public static class C0828a implements YogaMeasureFunction {
        @Override // com.kwad.yoga.YogaMeasureFunction
        public final long measure(c cVar, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2) {
            View view = (View) cVar.getData();
            if (view == null || (view instanceof a)) {
                return b.az(0, 0);
            }
            view.measure(View.MeasureSpec.makeMeasureSpec((int) f, a(yogaMeasureMode)), View.MeasureSpec.makeMeasureSpec((int) f2, a(yogaMeasureMode2)));
            return b.az(view.getMeasuredWidth(), view.getMeasuredHeight());
        }

        private static int a(YogaMeasureMode yogaMeasureMode) {
            if (yogaMeasureMode == YogaMeasureMode.AT_MOST) {
                return Integer.MIN_VALUE;
            }
            return yogaMeasureMode == YogaMeasureMode.EXACTLY ? 1073741824 : 0;
        }
    }
}

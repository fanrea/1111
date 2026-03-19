package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.g;
import android.support.v7.view.menu.m;
import android.support.v7.widget.ac;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class ActionMenuView extends ac implements g.b, android.support.v7.view.menu.n {
    private android.support.v7.view.menu.g ha;
    private Context jr;
    private int kH;
    private int kV;
    private android.support.v7.widget.c kW;
    private m.a kX;
    g.a kY;
    private boolean kZ;
    private boolean ky;
    private int la;
    private int lb;
    e lc;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public interface a {
        boolean aW();

        boolean aX();
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public int getWindowAnimations() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.ac
    /* renamed from: cg */
    public final /* synthetic */ ac.a generateDefaultLayoutParams() {
        return cd();
    }

    @Override // android.support.v7.widget.ac, android.view.ViewGroup
    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return cd();
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.kH = (int) (56.0f * f);
        this.lb = (int) (f * 4.0f);
        this.jr = context;
        this.kV = 0;
    }

    public void setPopupTheme(int i) {
        if (this.kV != i) {
            this.kV = i;
            if (i == 0) {
                this.jr = getContext();
            } else {
                this.jr = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.kV;
    }

    public void setPresenter(android.support.v7.widget.c cVar) {
        this.kW = cVar;
        this.kW.a(this);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        android.support.v7.widget.c cVar = this.kW;
        if (cVar != null) {
            cVar.l(false);
            if (this.kW.isOverflowMenuShowing()) {
                this.kW.hideOverflowMenu();
                this.kW.showOverflowMenu();
            }
        }
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.lc = eVar;
    }

    @Override // android.support.v7.widget.ac, android.view.View
    protected void onMeasure(int i, int i2) {
        android.support.v7.view.menu.g gVar;
        boolean z = this.kZ;
        this.kZ = View.MeasureSpec.getMode(i) == 1073741824;
        if (z != this.kZ) {
            this.la = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.kZ && (gVar = this.ha) != null && size != this.la) {
            this.la = size;
            gVar.q(true);
        }
        int childCount = getChildCount();
        if (this.kZ && childCount > 0) {
            n(i, i2);
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            c cVar = (c) getChildAt(i3).getLayoutParams();
            cVar.rightMargin = 0;
            cVar.leftMargin = 0;
        }
        super.onMeasure(i, i2);
    }

    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v16 */
    private void n(int i, int i2) {
        int i3;
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7;
        int i8;
        ?? r13;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i9 = size - paddingLeft;
        int i10 = this.kH;
        int i11 = i9 / i10;
        int i12 = i9 % i10;
        if (i11 == 0) {
            setMeasuredDimension(i9, 0);
            return;
        }
        int i13 = i10 + (i12 / i11);
        int childCount = getChildCount();
        int i14 = i11;
        int i15 = 0;
        int iMax = 0;
        boolean z2 = false;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        long j = 0;
        while (i15 < childCount) {
            View childAt = getChildAt(i15);
            int i19 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z3 = childAt instanceof ActionMenuItemView;
                int i20 = i16 + 1;
                if (z3) {
                    int i21 = this.lb;
                    i8 = i20;
                    r13 = 0;
                    childAt.setPadding(i21, 0, i21, 0);
                } else {
                    i8 = i20;
                    r13 = 0;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.li = r13;
                cVar.lf = r13;
                cVar.le = r13;
                cVar.lg = r13;
                cVar.leftMargin = r13;
                cVar.rightMargin = r13;
                cVar.lh = z3 && ((ActionMenuItemView) childAt).hasText();
                int iA = a(childAt, i13, cVar.ld ? 1 : i14, childMeasureSpec, paddingTop);
                int iMax2 = Math.max(i17, iA);
                if (cVar.lg) {
                    i18++;
                }
                if (cVar.ld) {
                    z2 = true;
                }
                i14 -= iA;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (iA == 1) {
                    j |= 1 << i15;
                    iMax = iMax;
                }
                i17 = iMax2;
                i16 = i8;
            }
            i15++;
            size2 = i19;
        }
        int i22 = size2;
        boolean z4 = z2 && i16 == 2;
        boolean z5 = false;
        while (i18 > 0 && i14 > 0) {
            int i23 = Integer.MAX_VALUE;
            int i24 = 0;
            int i25 = 0;
            long j2 = 0;
            while (i24 < childCount) {
                boolean z6 = z5;
                c cVar2 = (c) getChildAt(i24).getLayoutParams();
                int i26 = iMax;
                if (cVar2.lg) {
                    if (cVar2.le < i23) {
                        i23 = cVar2.le;
                        j2 = 1 << i24;
                        i25 = 1;
                    } else if (cVar2.le == i23) {
                        j2 |= 1 << i24;
                        i25++;
                    }
                }
                i24++;
                iMax = i26;
                z5 = z6;
            }
            z = z5;
            i5 = iMax;
            j |= j2;
            if (i25 > i14) {
                i3 = mode;
                i4 = i9;
                break;
            }
            int i27 = i23 + 1;
            int i28 = 0;
            while (i28 < childCount) {
                View childAt2 = getChildAt(i28);
                c cVar3 = (c) childAt2.getLayoutParams();
                int i29 = i9;
                int i30 = mode;
                long j3 = 1 << i28;
                if ((j2 & j3) == 0) {
                    if (cVar3.le == i27) {
                        j |= j3;
                    }
                    i7 = i27;
                } else {
                    if (z4 && cVar3.lh && i14 == 1) {
                        int i31 = this.lb;
                        i7 = i27;
                        childAt2.setPadding(i31 + i13, 0, i31, 0);
                    } else {
                        i7 = i27;
                    }
                    cVar3.le++;
                    cVar3.li = true;
                    i14--;
                }
                i28++;
                mode = i30;
                i27 = i7;
                i9 = i29;
            }
            iMax = i5;
            z5 = true;
        }
        i3 = mode;
        i4 = i9;
        z = z5;
        i5 = iMax;
        boolean z7 = !z2 && i16 == 1;
        if (i14 <= 0 || j == 0 || (i14 >= i16 - 1 && !z7 && i17 <= 1)) {
            i6 = 0;
        } else {
            float fBitCount = Long.bitCount(j);
            if (z7) {
                i6 = 0;
            } else {
                i6 = 0;
                if ((j & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).lh) {
                    fBitCount -= 0.5f;
                }
                int i32 = childCount - 1;
                if ((j & (1 << i32)) != 0 && !((c) getChildAt(i32).getLayoutParams()).lh) {
                    fBitCount -= 0.5f;
                }
            }
            int i33 = fBitCount > 0.0f ? (int) ((i14 * i13) / fBitCount) : 0;
            for (int i34 = 0; i34 < childCount; i34++) {
                if ((j & (1 << i34)) != 0) {
                    View childAt3 = getChildAt(i34);
                    c cVar4 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar4.lf = i33;
                        cVar4.li = true;
                        if (i34 == 0 && !cVar4.lh) {
                            cVar4.leftMargin = (-i33) / 2;
                        }
                    } else if (cVar4.ld) {
                        cVar4.lf = i33;
                        cVar4.li = true;
                        cVar4.rightMargin = (-i33) / 2;
                    } else {
                        if (i34 != 0) {
                            cVar4.leftMargin = i33 / 2;
                        }
                        if (i34 != childCount - 1) {
                            cVar4.rightMargin = i33 / 2;
                        }
                    }
                    z = true;
                }
            }
        }
        if (z) {
            while (i6 < childCount) {
                View childAt4 = getChildAt(i6);
                c cVar5 = (c) childAt4.getLayoutParams();
                if (cVar5.li) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar5.le * i13) + cVar5.lf, 1073741824), childMeasureSpec);
                }
                i6++;
            }
        }
        setMeasuredDimension(i4, i3 != 1073741824 ? i5 : i22);
    }

    static int a(View view, int i, int i2, int i3, int i4) {
        c cVar = (c) view.getLayoutParams();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = actionMenuItemView != null && actionMenuItemView.hasText();
        int i5 = 2;
        if (i2 <= 0 || (z && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i, Integer.MIN_VALUE), iMakeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i6 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i6++;
            }
            if (!z || i6 >= 2) {
                i5 = i6;
            }
        }
        cVar.lg = !cVar.ld && z;
        cVar.le = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i * i5, 1073741824), iMakeMeasureSpec);
        return i5;
    }

    @Override // android.support.v7.widget.ac, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int width;
        int paddingLeft;
        if (!this.kZ) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i7 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i8 = i3 - i;
        int paddingRight = (i8 - getPaddingRight()) - getPaddingLeft();
        boolean zAh = bd.ah(this);
        int measuredWidth = paddingRight;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.ld) {
                    int measuredWidth2 = childAt.getMeasuredWidth();
                    if (P(i11)) {
                        measuredWidth2 += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zAh) {
                        paddingLeft = getPaddingLeft() + cVar.leftMargin;
                        width = paddingLeft + measuredWidth2;
                    } else {
                        width = (getWidth() - getPaddingRight()) - cVar.rightMargin;
                        paddingLeft = width - measuredWidth2;
                    }
                    int i12 = i7 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i12, width, measuredHeight + i12);
                    measuredWidth -= measuredWidth2;
                    i9 = 1;
                } else {
                    measuredWidth -= (childAt.getMeasuredWidth() + cVar.leftMargin) + cVar.rightMargin;
                    P(i11);
                    i10++;
                }
            }
        }
        if (childCount == 1 && i9 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth3 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i13 = (i8 / 2) - (measuredWidth3 / 2);
            int i14 = i7 - (measuredHeight2 / 2);
            childAt2.layout(i13, i14, measuredWidth3 + i13, measuredHeight2 + i14);
            return;
        }
        int i15 = i10 - (i9 ^ 1);
        if (i15 > 0) {
            i6 = measuredWidth / i15;
            i5 = 0;
        } else {
            i5 = 0;
            i6 = 0;
        }
        int iMax = Math.max(i5, i6);
        if (zAh) {
            int width2 = getWidth() - getPaddingRight();
            while (i5 < childCount) {
                View childAt3 = getChildAt(i5);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.ld) {
                    int i16 = width2 - cVar2.rightMargin;
                    int measuredWidth4 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i17 = i7 - (measuredHeight3 / 2);
                    childAt3.layout(i16 - measuredWidth4, i17, i16, measuredHeight3 + i17);
                    width2 = i16 - ((measuredWidth4 + cVar2.leftMargin) + iMax);
                }
                i5++;
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        while (i5 < childCount) {
            View childAt4 = getChildAt(i5);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.ld) {
                int i18 = paddingLeft2 + cVar3.leftMargin;
                int measuredWidth5 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i19 = i7 - (measuredHeight4 / 2);
                childAt4.layout(i18, i19, i18 + measuredWidth5, measuredHeight4 + i19);
                paddingLeft2 = i18 + measuredWidth5 + cVar3.rightMargin + iMax;
            }
            i5++;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissPopupMenus();
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.kW.setOverflowIcon(drawable);
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.kW.getOverflowIcon();
    }

    public void setOverflowReserved(boolean z) {
        this.ky = z;
    }

    private static c cd() {
        c cVar = new c(-2, -2);
        cVar.gravity = 16;
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.support.v7.widget.ac, android.view.ViewGroup
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.ac, android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams != null) {
            c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
            if (cVar.gravity <= 0) {
                cVar.gravity = 16;
            }
            return cVar;
        }
        return cd();
    }

    @Override // android.support.v7.widget.ac, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof c);
    }

    public final c ce() {
        c cVarCd = cd();
        cVarCd.ld = true;
        return cVarCd;
    }

    @Override // android.support.v7.view.menu.g.b
    public final boolean d(android.support.v7.view.menu.h hVar) {
        return this.ha.a(hVar, 0);
    }

    public final void f(android.support.v7.view.menu.g gVar) {
        this.ha = gVar;
    }

    public Menu getMenu() {
        if (this.ha == null) {
            Context context = getContext();
            this.ha = new android.support.v7.view.menu.g(context);
            this.ha.a(new d());
            this.kW = new android.support.v7.widget.c(context);
            this.kW.w(true);
            android.support.v7.widget.c cVar = this.kW;
            m.a bVar = this.kX;
            if (bVar == null) {
                bVar = new b();
            }
            cVar.a(bVar);
            this.ha.a(this.kW, this.jr);
            this.kW.a(this);
        }
        return this.ha;
    }

    public final void a(m.a aVar, g.a aVar2) {
        this.kX = aVar;
        this.kY = aVar2;
    }

    public final android.support.v7.view.menu.g cf() {
        return this.ha;
    }

    public final boolean showOverflowMenu() {
        android.support.v7.widget.c cVar = this.kW;
        return cVar != null && cVar.showOverflowMenu();
    }

    public final boolean isOverflowMenuShowing() {
        android.support.v7.widget.c cVar = this.kW;
        return cVar != null && cVar.isOverflowMenuShowing();
    }

    private void dismissPopupMenus() {
        android.support.v7.widget.c cVar = this.kW;
        if (cVar != null) {
            cVar.ca();
        }
    }

    private boolean P(int i) {
        boolean zAX = false;
        if (i == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i - 1);
        KeyEvent.Callback childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof a)) {
            zAX = false | ((a) childAt).aX();
        }
        return (i <= 0 || !(childAt2 instanceof a)) ? zAX : zAX | ((a) childAt2).aW();
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.kW.setExpandedActionViewsExclusive(z);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    class d implements g.a {
        d() {
        }

        @Override // android.support.v7.view.menu.g.a
        public final boolean d(MenuItem menuItem) {
            return ActionMenuView.this.lc != null && ActionMenuView.this.lc.onMenuItemClick(menuItem);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static class b implements m.a {
        @Override // android.support.v7.view.menu.m.a
        public final void a(android.support.v7.view.menu.g gVar, boolean z) {
        }

        @Override // android.support.v7.view.menu.m.a
        public final boolean e(android.support.v7.view.menu.g gVar) {
            return false;
        }

        b() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public static class c extends ac.a {

        @ViewDebug.ExportedProperty
        public boolean ld;

        @ViewDebug.ExportedProperty
        public int le;

        @ViewDebug.ExportedProperty
        public int lf;

        @ViewDebug.ExportedProperty
        public boolean lg;

        @ViewDebug.ExportedProperty
        public boolean lh;
        boolean li;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super(cVar);
            this.ld = cVar.ld;
        }

        public c(int i, int i2) {
            super(-2, -2);
            this.ld = false;
        }
    }
}

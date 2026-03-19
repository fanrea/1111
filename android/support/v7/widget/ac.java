package android.support.v7.widget;

import aegon.chrome.net.NetError;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.GravityCompat;
import com.google.android.material.badge.BadgeDrawable;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class ac extends ViewGroup {
    private int mOrientation;
    private boolean pZ;
    private int qa;
    private int qb;
    private int qc;
    private int qe;
    private float qf;
    private boolean qg;
    private int[] qh;
    private int[] qi;
    private Drawable qj;
    private int qk;
    private int ql;
    private int qm;
    private int qn;

    private static int getChildrenSkipCount$5359dca7() {
        return 0;
    }

    private static int getLocationOffset$3c7ec8d0() {
        return 0;
    }

    private static int getNextLocationOffset$3c7ec8d0() {
        return 0;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ac(Context context) {
        this(context, null);
    }

    public ac(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ac(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pZ = true;
        this.qa = -1;
        this.qb = 0;
        this.qc = BadgeDrawable.TOP_START;
        av avVarA = av.a(context, attributeSet, a.j.LinearLayoutCompat, i, 0);
        int i2 = avVarA.getInt(a.j.LinearLayoutCompat_android_orientation, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        int i3 = avVarA.getInt(a.j.LinearLayoutCompat_android_gravity, -1);
        if (i3 >= 0) {
            setGravity(i3);
        }
        boolean z = avVarA.getBoolean(a.j.LinearLayoutCompat_android_baselineAligned, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.qf = avVarA.getFloat(a.j.LinearLayoutCompat_android_weightSum, -1.0f);
        this.qa = avVarA.getInt(a.j.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.qg = avVarA.getBoolean(a.j.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(avVarA.getDrawable(a.j.LinearLayoutCompat_divider));
        this.qm = avVarA.getInt(a.j.LinearLayoutCompat_showDividers, 0);
        this.qn = avVarA.getDimensionPixelSize(a.j.LinearLayoutCompat_dividerPadding, 0);
        avVarA.recycle();
    }

    public void setShowDividers(int i) {
        if (i != this.qm) {
            requestLayout();
        }
        this.qm = i;
    }

    public int getShowDividers() {
        return this.qm;
    }

    public Drawable getDividerDrawable() {
        return this.qj;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.qj) {
            return;
        }
        this.qj = drawable;
        if (drawable != null) {
            this.qk = drawable.getIntrinsicWidth();
            this.ql = drawable.getIntrinsicHeight();
        } else {
            this.qk = 0;
            this.ql = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.qn = i;
    }

    public int getDividerPadding() {
        return this.qn;
    }

    public int getDividerWidth() {
        return this.qk;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.qj == null) {
            return;
        }
        if (this.mOrientation == 1) {
            d(canvas);
        } else {
            e(canvas);
        }
    }

    private void d(Canvas canvas) {
        int bottom;
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View virtualChildAt = getVirtualChildAt(i);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && an(i)) {
                a(canvas, (virtualChildAt.getTop() - ((a) virtualChildAt.getLayoutParams()).topMargin) - this.ql);
            }
        }
        if (an(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.ql;
            } else {
                bottom = virtualChildAt2.getBottom() + ((a) virtualChildAt2.getLayoutParams()).bottomMargin;
            }
            a(canvas, bottom);
        }
    }

    private void e(Canvas canvas) {
        int right;
        int left;
        int i;
        int left2;
        int virtualChildCount = getVirtualChildCount();
        boolean zAh = bd.ah(this);
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View virtualChildAt = getVirtualChildAt(i2);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && an(i2)) {
                a aVar = (a) virtualChildAt.getLayoutParams();
                if (zAh) {
                    left2 = virtualChildAt.getRight() + aVar.rightMargin;
                } else {
                    left2 = (virtualChildAt.getLeft() - aVar.leftMargin) - this.qk;
                }
                b(canvas, left2);
            }
        }
        if (an(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 != null) {
                a aVar2 = (a) virtualChildAt2.getLayoutParams();
                if (zAh) {
                    left = virtualChildAt2.getLeft() - aVar2.leftMargin;
                    i = this.qk;
                    right = left - i;
                } else {
                    right = virtualChildAt2.getRight() + aVar2.rightMargin;
                }
            } else if (zAh) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i = this.qk;
                right = left - i;
            }
            b(canvas, right);
        }
    }

    private void a(Canvas canvas, int i) {
        this.qj.setBounds(getPaddingLeft() + this.qn, i, (getWidth() - getPaddingRight()) - this.qn, this.ql + i);
        this.qj.draw(canvas);
    }

    private void b(Canvas canvas, int i) {
        this.qj.setBounds(i, getPaddingTop() + this.qn, this.qk + i, (getHeight() - getPaddingBottom()) - this.qn);
        this.qj.draw(canvas);
    }

    public void setBaselineAligned(boolean z) {
        this.pZ = z;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.qg = z;
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.qa < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.qa;
        if (childCount <= i2) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i2);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.qa == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.qb;
        if (this.mOrientation == 1 && (i = this.qc & 112) != 48) {
            if (i == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.qe) / 2;
            } else if (i == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.qe;
            }
        }
        return bottom + ((a) childAt.getLayoutParams()).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.qa;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.qa = i;
    }

    private View getVirtualChildAt(int i) {
        return getChildAt(i);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.qf;
    }

    public void setWeightSum(float f) {
        this.qf = Math.max(0.0f, f);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mOrientation == 1) {
            F(i, i2);
        } else {
            G(i, i2);
        }
    }

    protected final boolean an(int i) {
        if (i == 0) {
            return (this.qm & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.qm & 4) != 0;
        }
        if ((this.qm & 2) == 0) {
            return false;
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (getChildAt(i2).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:146:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x014f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void F(int r31, int r32) {
        /*
            Method dump skipped, instructions count: 875
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ac.F(int, int):void");
    }

    private void x(int i, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                a aVar = (a) virtualChildAt.getLayoutParams();
                if (aVar.width == -1) {
                    int i4 = aVar.height;
                    aVar.height = virtualChildAt.getMeasuredHeight();
                    measureChildWithMargins(virtualChildAt, iMakeMeasureSpec, 0, i2, 0);
                    aVar.height = i4;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:160:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void G(int r39, int r40) {
        /*
            Method dump skipped, instructions count: 1253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ac.G(int, int):void");
    }

    private void H(int i, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                a aVar = (a) virtualChildAt.getLayoutParams();
                if (aVar.height == -1) {
                    int i4 = aVar.width;
                    aVar.width = virtualChildAt.getMeasuredWidth();
                    measureChildWithMargins(virtualChildAt, i2, 0, iMakeMeasureSpec, 0);
                    aVar.width = i4;
                }
            }
        }
    }

    private void c(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mOrientation == 1) {
            a(i, i2, i3, i4);
        } else {
            b(i, i2, i3, i4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r12, int r13, int r14, int r15) {
        /*
            r11 = this;
            int r0 = r11.getPaddingLeft()
            int r14 = r14 - r12
            int r12 = r11.getPaddingRight()
            int r12 = r14 - r12
            int r14 = r14 - r0
            int r1 = r11.getPaddingRight()
            int r14 = r14 - r1
            int r1 = r11.getVirtualChildCount()
            int r2 = r11.qc
            r3 = r2 & 112(0x70, float:1.57E-43)
            r4 = 8388615(0x800007, float:1.1754953E-38)
            r2 = r2 & r4
            r4 = 16
            if (r3 == r4) goto L35
            r4 = 80
            if (r3 == r4) goto L2a
            int r13 = r11.getPaddingTop()
            goto L41
        L2a:
            int r3 = r11.getPaddingTop()
            int r3 = r3 + r15
            int r3 = r3 - r13
            int r13 = r11.qe
            int r13 = r3 - r13
            goto L41
        L35:
            int r3 = r11.getPaddingTop()
            int r15 = r15 - r13
            int r13 = r11.qe
            int r15 = r15 - r13
            int r15 = r15 / 2
            int r13 = r3 + r15
        L41:
            r15 = 0
            r3 = r13
            r13 = 0
        L44:
            if (r13 >= r1) goto La8
            android.view.View r4 = r11.getVirtualChildAt(r13)
            r5 = 1
            if (r4 != 0) goto L50
            int r3 = r3 + 0
            goto La6
        L50:
            int r6 = r4.getVisibility()
            r7 = 8
            if (r6 == r7) goto La6
            int r6 = r4.getMeasuredWidth()
            int r7 = r4.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r8 = r4.getLayoutParams()
            android.support.v7.widget.ac$a r8 = (android.support.v7.widget.ac.a) r8
            int r9 = r8.gravity
            if (r9 >= 0) goto L6b
            r9 = r2
        L6b:
            int r10 = android.support.v4.e.o.g(r11)
            int r9 = android.support.v4.e.d.getAbsoluteGravity(r9, r10)
            r9 = r9 & 7
            if (r9 == r5) goto L83
            r10 = 5
            if (r9 == r10) goto L7e
            int r9 = r8.leftMargin
            int r9 = r9 + r0
            goto L8e
        L7e:
            int r9 = r12 - r6
            int r10 = r8.rightMargin
            goto L8d
        L83:
            int r9 = r14 - r6
            int r9 = r9 / 2
            int r9 = r9 + r0
            int r10 = r8.leftMargin
            int r9 = r9 + r10
            int r10 = r8.rightMargin
        L8d:
            int r9 = r9 - r10
        L8e:
            boolean r10 = r11.an(r13)
            if (r10 == 0) goto L97
            int r10 = r11.ql
            int r3 = r3 + r10
        L97:
            int r10 = r8.topMargin
            int r3 = r3 + r10
            int r10 = r3 + 0
            b(r4, r9, r10, r6, r7)
            int r4 = r8.bottomMargin
            int r7 = r7 + r4
            int r7 = r7 + r15
            int r3 = r3 + r7
            int r13 = r13 + 0
        La6:
            int r13 = r13 + r5
            goto L44
        La8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ac.a(int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e7 A[PHI: r6
  0x00e7: PHI (r6v15 int) = (r6v14 int), (r6v17 int) binds: [B:40:0x00dc, B:37:0x00c8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(int r24, int r25, int r26, int r27) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ac.b(int, int, int, int):void");
    }

    private static void b(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setGravity(int i) {
        if (this.qc != i) {
            if ((8388615 & i) == 0) {
                i |= GravityCompat.START;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.qc = i;
            requestLayout();
        }
    }

    public int getGravity() {
        return this.qc;
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int i3 = this.qc;
        if ((8388615 & i3) != i2) {
            this.qc = i2 | ((-8388616) & i3);
            requestLayout();
        }
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        int i3 = this.qc;
        if ((i3 & 112) != i2) {
            this.qc = i2 | (i3 & NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: cg, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        int i = this.mOrientation;
        if (i == 0) {
            return new a(-2, -2);
        }
        if (i == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ac.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ac.class.getName());
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public static class a extends ViewGroup.MarginLayoutParams {
        public int gravity;
        public float weight;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.LinearLayoutCompat_Layout);
            this.weight = typedArrayObtainStyledAttributes.getFloat(a.j.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.gravity = typedArrayObtainStyledAttributes.getInt(a.j.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            typedArrayObtainStyledAttributes.recycle();
        }

        public a(int i, int i2) {
            super(i, i2);
            this.gravity = -1;
            this.weight = 0.0f;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
        }
    }
}

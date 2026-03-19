package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.a.a;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
class w extends ListView {
    private boolean oA;
    private boolean oB;
    private boolean oC;
    private android.support.v4.e.r oD;
    private android.support.v4.widget.g oE;
    b oF;
    private final Rect or;
    private int ot;
    private int ou;
    private int ov;
    private int ow;
    private int ox;
    private Field oy;
    private a oz;

    w(Context context, boolean z) {
        super(context, null, a.C0010a.dropDownListViewStyle);
        this.or = new Rect();
        this.ot = 0;
        this.ou = 0;
        this.ov = 0;
        this.ow = 0;
        this.oB = z;
        setCacheColorHint(0);
        try {
            this.oy = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.oy.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.oB && this.oA) || super.isInTouchMode();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.oB || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.oB || super.isFocused();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.oB || super.hasFocus();
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        this.oz = drawable != null ? new a(drawable) : null;
        super.setSelector(this.oz);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.ot = rect.left;
        this.ou = rect.top;
        this.ov = rect.right;
        this.ow = rect.bottom;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.oF != null) {
            return;
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        da();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        a(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.ox = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        b bVar = this.oF;
        if (bVar != null) {
            bVar.cancel();
        }
        return super.onTouchEvent(motionEvent);
    }

    public int b(int i, int i2, int i3, int i4, int i5) {
        int iMakeMeasureSpec;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i6 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int measuredHeight = i6;
        View view = null;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < count) {
            int itemViewType = adapter.getItemViewType(i7);
            if (itemViewType != i8) {
                view = null;
                i8 = itemViewType;
            }
            view = adapter.getView(i7, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            if (layoutParams.height > 0) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            } else {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, iMakeMeasureSpec);
            view.forceLayout();
            if (i7 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i4) {
                return (i5 < 0 || i7 <= i5 || i9 <= 0 || measuredHeight == i4) ? i4 : i9;
            }
            if (i5 >= 0 && i7 >= i5) {
                i9 = measuredHeight;
            }
            i7++;
        }
        return measuredHeight;
    }

    private void setSelectorEnabled(boolean z) {
        a aVar = this.oz;
        if (aVar != null) {
            aVar.setEnabled(z);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static class a extends android.support.v7.c.a.c {
        private boolean de;

        a(Drawable drawable) {
            super(drawable);
            this.de = true;
        }

        final void setEnabled(boolean z) {
            this.de = z;
        }

        @Override // android.support.v7.c.a.c, android.graphics.drawable.Drawable
        public final boolean setState(int[] iArr) {
            if (this.de) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // android.support.v7.c.a.c, android.graphics.drawable.Drawable
        public final void draw(Canvas canvas) {
            if (this.de) {
                super.draw(canvas);
            }
        }

        @Override // android.support.v7.c.a.c, android.graphics.drawable.Drawable
        public final void setHotspot(float f, float f2) {
            if (this.de) {
                super.setHotspot(f, f2);
            }
        }

        @Override // android.support.v7.c.a.c, android.graphics.drawable.Drawable
        public final void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.de) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        @Override // android.support.v7.c.a.c, android.graphics.drawable.Drawable
        public final boolean setVisible(boolean z, boolean z2) {
            if (this.de) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.oF == null) {
            this.oF = new b();
            this.oF.dd();
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                }
                da();
            }
        } else {
            setSelection(-1);
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.oF = null;
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(android.view.MotionEvent r8, int r9) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L14
            r9 = 3
            if (r0 == r9) goto L11
        Le:
            r9 = 0
            r3 = 1
            goto L46
        L11:
            r9 = 0
            r3 = 0
            goto L46
        L14:
            r3 = 1
            goto L17
        L16:
            r3 = 0
        L17:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L1e
            goto L11
        L1e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L31
            r9 = 1
            goto L46
        L31:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.a(r3, r5, r4, r9)
            if (r0 != r2) goto Le
            r7.f(r3, r5)
            goto Le
        L46:
            if (r3 == 0) goto L4a
            if (r9 == 0) goto L4d
        L4a:
            r7.db()
        L4d:
            if (r3 == 0) goto L65
            android.support.v4.widget.g r9 = r7.oE
            if (r9 != 0) goto L5a
            android.support.v4.widget.g r9 = new android.support.v4.widget.g
            r9.<init>(r7)
            r7.oE = r9
        L5a:
            android.support.v4.widget.g r9 = r7.oE
            r9.j(r2)
            android.support.v4.widget.g r9 = r7.oE
            r9.onTouch(r7, r8)
            goto L6c
        L65:
            android.support.v4.widget.g r8 = r7.oE
            if (r8 == 0) goto L6c
            r8.j(r1)
        L6c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.w.b(android.view.MotionEvent, int):boolean");
    }

    private void f(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    void setListSelectionHidden(boolean z) {
        this.oA = z;
    }

    private void da() {
        Drawable selector = getSelector();
        if (selector != null && dc() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    private void a(Canvas canvas) {
        Drawable selector;
        if (this.or.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.or);
        selector.draw(canvas);
    }

    private void a(int i, View view, float f, float f2) throws IllegalAccessException, IllegalArgumentException {
        a(i, view);
        Drawable selector = getSelector();
        if (selector == null || i == -1) {
            return;
        }
        android.support.v4.graphics.drawable.a.a(selector, f, f2);
    }

    private void a(int i, View view) throws IllegalAccessException, IllegalArgumentException {
        Drawable selector = getSelector();
        boolean z = (selector == null || i == -1) ? false : true;
        if (z) {
            selector.setVisible(false, false);
        }
        b(i, view);
        if (z) {
            Rect rect = this.or;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            android.support.v4.graphics.drawable.a.a(selector, fExactCenterX, fExactCenterY);
        }
    }

    private void b(int i, View view) throws IllegalAccessException, IllegalArgumentException {
        Rect rect = this.or;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.ot;
        rect.top -= this.ou;
        rect.right += this.ov;
        rect.bottom += this.ow;
        try {
            boolean z = this.oy.getBoolean(this);
            if (view.isEnabled() != z) {
                this.oy.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void db() {
        this.oC = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.ox - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        android.support.v4.e.r rVar = this.oD;
        if (rVar != null) {
            rVar.cancel();
            this.oD = null;
        }
    }

    private void a(View view, int i, float f, float f2) throws IllegalAccessException, IllegalArgumentException {
        View childAt;
        this.oC = true;
        if (Build.VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i2 = this.ox;
        if (i2 != -1 && (childAt = getChildAt(i2 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.ox = i;
        float left = f - view.getLeft();
        float top = f2 - view.getTop();
        if (Build.VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        a(i, view, f, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    private boolean dc() {
        return this.oC;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            w wVar = w.this;
            wVar.oF = null;
            wVar.drawableStateChanged();
        }

        public final void cancel() {
            w wVar = w.this;
            wVar.oF = null;
            wVar.removeCallbacks(this);
        }

        public final void dd() {
            w.this.post(this);
        }
    }
}

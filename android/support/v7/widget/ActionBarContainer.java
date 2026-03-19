package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class ActionBarContainer extends FrameLayout {
    Drawable ia;
    private boolean jC;
    private View jD;
    private View jE;
    private View jF;
    Drawable jG;
    Drawable jH;
    boolean jI;
    boolean jJ;
    private int mHeight;

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        android.support.v4.e.o.a(this, new b(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.ActionBar);
        this.ia = typedArrayObtainStyledAttributes.getDrawable(a.j.ActionBar_background);
        this.jG = typedArrayObtainStyledAttributes.getDrawable(a.j.ActionBar_backgroundStacked);
        this.mHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(a.j.ActionBar_height, -1);
        if (getId() == a.f.split_action_bar) {
            this.jI = true;
            this.jH = typedArrayObtainStyledAttributes.getDrawable(a.j.ActionBar_backgroundSplit);
        }
        typedArrayObtainStyledAttributes.recycle();
        boolean z = false;
        if (!this.jI ? !(this.ia != null || this.jG != null) : this.jH == null) {
            z = true;
        }
        setWillNotDraw(z);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.jE = findViewById(a.f.action_bar);
        this.jF = findViewById(a.f.action_context_bar);
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.ia;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.ia);
        }
        this.ia = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.jE;
            if (view != null) {
                this.ia.setBounds(view.getLeft(), this.jE.getTop(), this.jE.getRight(), this.jE.getBottom());
            }
        }
        boolean z = true;
        if (!this.jI ? this.ia != null || this.jG != null : this.jH != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.jG;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.jG);
        }
        this.jG = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.jJ && (drawable2 = this.jG) != null) {
                drawable2.setBounds(this.jD.getLeft(), this.jD.getTop(), this.jD.getRight(), this.jD.getBottom());
            }
        }
        boolean z = true;
        if (!this.jI ? this.ia != null || this.jG != null : this.jH != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.jH;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.jH);
        }
        this.jH = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.jI && (drawable2 = this.jH) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.jI ? !(this.ia != null || this.jG != null) : this.jH == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.ia;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.jG;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.jH;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (drawable == this.ia && !this.jI) {
            return true;
        }
        if (drawable == this.jG && this.jJ) {
            return true;
        }
        return (drawable == this.jH && this.jI) || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.ia;
        if (drawable != null && drawable.isStateful()) {
            this.ia.setState(getDrawableState());
        }
        Drawable drawable2 = this.jG;
        if (drawable2 != null && drawable2.isStateful()) {
            this.jG.setState(getDrawableState());
        }
        Drawable drawable3 = this.jH;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.jH.setState(getDrawableState());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.ia;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.jG;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.jH;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public void setTransitioning(boolean z) {
        this.jC = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.jC || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public void setTabContainer(ao aoVar) {
        View view = this.jD;
        if (view != null) {
            removeView(view);
        }
        this.jD = aoVar;
        if (aoVar != null) {
            addView(aoVar);
            ViewGroup.LayoutParams layoutParams = aoVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            aoVar.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.jD;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    private static boolean x(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private static int y(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int iY;
        int i3;
        if (this.jE == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && (i3 = this.mHeight) >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i3, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.jE == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        View view = this.jD;
        if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        if (!x(this.jE)) {
            iY = y(this.jE);
        } else {
            iY = !x(this.jF) ? y(this.jF) : 0;
        }
        setMeasuredDimension(getMeasuredWidth(), Math.min(iY + y(this.jD), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Drawable drawable;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.jD;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (this.jI) {
            Drawable drawable2 = this.jH;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.ia != null) {
                if (this.jE.getVisibility() == 0) {
                    this.ia.setBounds(this.jE.getLeft(), this.jE.getTop(), this.jE.getRight(), this.jE.getBottom());
                } else {
                    View view2 = this.jF;
                    if (view2 != null && view2.getVisibility() == 0) {
                        this.ia.setBounds(this.jF.getLeft(), this.jF.getTop(), this.jF.getRight(), this.jF.getBottom());
                    } else {
                        this.ia.setBounds(0, 0, 0, 0);
                    }
                }
                z3 = true;
            }
            this.jJ = z4;
            if (!z4 || (drawable = this.jG) == null) {
                z2 = z3;
            } else {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z2) {
            invalidate();
        }
    }
}

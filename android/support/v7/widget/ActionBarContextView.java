package android.support.v7.widget;

import android.content.Context;
import android.support.v7.a.a;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class ActionBarContextView extends a {
    private CharSequence gz;
    private TextView hU;
    private CharSequence jK;
    private View jL;
    private View jM;
    private LinearLayout jN;
    private TextView jO;
    private int jP;
    private int jQ;
    private boolean jR;
    private int jS;

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.support.v7.widget.a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // android.support.v7.widget.a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    @Override // android.support.v7.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.support.v7.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.support.v7.widget.a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0010a.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        av avVarA = av.a(context, attributeSet, a.j.ActionMode, i, 0);
        android.support.v4.e.o.a(this, avVarA.getDrawable(a.j.ActionMode_background));
        this.jP = avVarA.getResourceId(a.j.ActionMode_titleTextStyle, 0);
        this.jQ = avVarA.getResourceId(a.j.ActionMode_subtitleTextStyle, 0);
        this.ju = avVarA.getLayoutDimension(a.j.ActionMode_height, 0);
        this.jS = avVarA.getResourceId(a.j.ActionMode_closeItemLayout, a.g.abc_action_mode_close_item_material);
        avVarA.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.jt != null) {
            this.jt.hideOverflowMenu();
            this.jt.cb();
        }
    }

    @Override // android.support.v7.widget.a
    public void setContentHeight(int i) {
        this.ju = i;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.jM;
        if (view2 != null) {
            removeView(view2);
        }
        this.jM = view;
        if (view != null && (linearLayout = this.jN) != null) {
            removeView(linearLayout);
            this.jN = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence charSequence) {
        this.gz = charSequence;
        bR();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.jK = charSequence;
        bR();
    }

    public CharSequence getTitle() {
        return this.gz;
    }

    public CharSequence getSubtitle() {
        return this.jK;
    }

    private void bR() {
        if (this.jN == null) {
            LayoutInflater.from(getContext()).inflate(a.g.abc_action_bar_title_item, this);
            this.jN = (LinearLayout) getChildAt(getChildCount() - 1);
            this.hU = (TextView) this.jN.findViewById(a.f.action_bar_title);
            this.jO = (TextView) this.jN.findViewById(a.f.action_bar_subtitle);
            if (this.jP != 0) {
                this.hU.setTextAppearance(getContext(), this.jP);
            }
            if (this.jQ != 0) {
                this.jO.setTextAppearance(getContext(), this.jQ);
            }
        }
        this.hU.setText(this.gz);
        this.jO.setText(this.jK);
        boolean z = !TextUtils.isEmpty(this.gz);
        boolean z2 = !TextUtils.isEmpty(this.jK);
        int i = 0;
        this.jO.setVisibility(z2 ? 0 : 8);
        LinearLayout linearLayout = this.jN;
        if (!z && !z2) {
            i = 8;
        }
        linearLayout.setVisibility(i);
        if (this.jN.getParent() == null) {
            addView(this.jN);
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = this.ju > 0 ? this.ju : View.MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingTop;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.jL;
        if (view != null) {
            int iA = a(view, paddingLeft, iMakeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jL.getLayoutParams();
            paddingLeft = iA - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        if (this.js != null && this.js.getParent() == this) {
            paddingLeft = a(this.js, paddingLeft, iMakeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.jN;
        if (linearLayout != null && this.jM == null) {
            if (this.jR) {
                this.jN.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.jN.getMeasuredWidth();
                boolean z = measuredWidth <= paddingLeft;
                if (z) {
                    paddingLeft -= measuredWidth;
                }
                this.jN.setVisibility(z ? 0 : 8);
            } else {
                paddingLeft = a(linearLayout, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        View view2 = this.jM;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i3 = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (layoutParams.width >= 0) {
                paddingLeft = Math.min(layoutParams.width, paddingLeft);
            }
            int i4 = layoutParams.height == -2 ? Integer.MIN_VALUE : 1073741824;
            if (layoutParams.height >= 0) {
                iMin = Math.min(layoutParams.height, iMin);
            }
            this.jM.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i3), View.MeasureSpec.makeMeasureSpec(iMin, i4));
        }
        if (this.ju <= 0) {
            int childCount = getChildCount();
            int i5 = 0;
            for (int i6 = 0; i6 < childCount; i6++) {
                int measuredHeight = getChildAt(i6).getMeasuredHeight() + paddingTop;
                if (measuredHeight > i5) {
                    i5 = measuredHeight;
                }
            }
            setMeasuredDimension(size, i5);
            return;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean zAh = bd.ah(this);
        int paddingRight = zAh ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        View view = this.jL;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jL.getLayoutParams();
            int i5 = zAh ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = zAh ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iA = a(paddingRight, i5, zAh);
            paddingRight = a(iA + a(this.jL, iA, paddingTop, paddingTop2, zAh), i6, zAh);
        }
        LinearLayout linearLayout = this.jN;
        if (linearLayout != null && this.jM == null && linearLayout.getVisibility() != 8) {
            paddingRight += a(this.jN, paddingRight, paddingTop, paddingTop2, zAh);
        }
        View view2 = this.jM;
        if (view2 != null) {
            a(view2, paddingRight, paddingTop, paddingTop2, zAh);
        }
        int paddingLeft = zAh ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.js != null) {
            a(this.js, paddingLeft, paddingTop, paddingTop2, !zAh);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.gz);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.jR) {
            requestLayout();
        }
        this.jR = z;
    }
}

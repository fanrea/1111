package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class WrapChildLinearLayout extends LinearLayout {
    private View cqh;

    public WrapChildLinearLayout(Context context) {
        super(context);
    }

    public WrapChildLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WrapChildLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setWrapChildView(View view) {
        this.cqh = view;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int paddingLeft;
        int paddingRight;
        super.onMeasure(i, i2);
        View view = this.cqh;
        if (view == null) {
            return;
        }
        boolean z = getOrientation() == 1;
        int mode = z ? View.MeasureSpec.getMode(i2) : View.MeasureSpec.getMode(i);
        if (mode == 1073741824 || mode == Integer.MIN_VALUE) {
            if (z) {
                paddingLeft = getPaddingTop();
                paddingRight = getPaddingBottom();
            } else {
                paddingLeft = getPaddingLeft();
                paddingRight = getPaddingRight();
            }
            int childTotalLength = getChildTotalLength() + paddingLeft + paddingRight;
            int measuredHeight = z ? getMeasuredHeight() : getMeasuredWidth();
            if (childTotalLength > measuredHeight) {
                int iN = measuredHeight - n(view, z);
                measureChildWithMargins(view, i, z ? 0 : iN, i2, z ? iN : 0);
            }
        }
    }

    private int getChildTotalLength() {
        int childCount = getChildCount();
        boolean z = getOrientation() == 1;
        int iN = 0;
        for (int i = 0; i < childCount; i++) {
            iN += n(getChildAt(i), z);
        }
        return iN;
    }

    private static int n(View view, boolean z) {
        int i;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        int measuredWidth = 0;
        boolean z2 = view.getVisibility() == 8;
        if (z) {
            i = layoutParams.topMargin + layoutParams.bottomMargin;
            if (!z2) {
                measuredWidth = view.getMeasuredHeight();
            }
        } else {
            i = layoutParams.leftMargin + layoutParams.rightMargin;
            if (!z2) {
                measuredWidth = view.getMeasuredWidth();
            }
        }
        return i + measuredWidth;
    }
}

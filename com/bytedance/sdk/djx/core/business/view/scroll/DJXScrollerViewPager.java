package com.bytedance.sdk.djx.core.business.view.scroll;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXScrollerViewPager extends ViewPager implements IScroller {
    private int mAdjustHeight;

    public DJXScrollerViewPager(Context context) {
        super(context);
    }

    public DJXScrollerViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    protected void onMeasure(int i, int i2) throws Resources.NotFoundException {
        if (isConsecutiveParentAndBottom() && this.mAdjustHeight > 0) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getDefaultSize(0, i2) - this.mAdjustHeight, View.MeasureSpec.getMode(i2)));
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (ScrollUtils.isConsecutiveScrollerChild(this)) {
            disableChildScroll(view);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).setClipToPadding(false);
            }
        }
    }

    private void disableChildScroll(View view) {
        view.setVerticalScrollBarEnabled(false);
        view.setHorizontalScrollBarEnabled(false);
        view.setOverScrollMode(2);
        ViewCompat.setNestedScrollingEnabled(view, false);
    }

    private boolean isConsecutiveParentAndBottom() {
        ViewParent parent = getParent();
        if (!(parent instanceof DJXScrollerLayout)) {
            return false;
        }
        DJXScrollerLayout dJXScrollerLayout = (DJXScrollerLayout) parent;
        return dJXScrollerLayout.indexOfChild(this) == dJXScrollerLayout.getChildCount() - 1;
    }

    public int getAdjustHeight() {
        return this.mAdjustHeight;
    }

    public void setAdjustHeight(int i) {
        if (this.mAdjustHeight != i) {
            this.mAdjustHeight = i;
            requestLayout();
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.view.scroll.IScroller
    public View getCurrentScrollerView() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getX() == getScrollX() + getPaddingLeft()) {
                return childAt;
            }
        }
        return this;
    }

    @Override // com.bytedance.sdk.djx.core.business.view.scroll.IScroller
    public List<View> getScrolledViews() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                arrayList.add(getChildAt(i));
            }
        }
        return arrayList;
    }
}

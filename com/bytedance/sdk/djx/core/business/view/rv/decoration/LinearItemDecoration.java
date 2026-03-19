package com.bytedance.sdk.djx.core.business.view.rv.decoration;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class LinearItemDecoration extends RecyclerView.ItemDecoration {
    public static final String COLOR_DEF = "#000000";
    public static final int HORIZONTAL = 0;
    public static final int SPACING_DEF = 1;
    public static final int VERTICAL = 1;
    private Drawable mDrawable;
    private int mOrientation;
    private int mSpacing;
    private final Rect mTemp1 = new Rect();
    private final Rect mTemp2 = new Rect();
    private int mMarginLeft = 0;
    private int mMarginRight = 0;
    private boolean mStartDraw = false;
    private boolean mEndDraw = false;

    public LinearItemDecoration(int i) {
        setOrientation(i);
        this.mSpacing = 1;
        this.mDrawable = new ColorDrawable(Color.parseColor("#000000"));
    }

    public LinearItemDecoration(int i, int i2, int i3) {
        this.mSpacing = i2;
        this.mDrawable = new ColorDrawable(i3);
        setOrientation(i);
    }

    public void setOrientation(int i) {
        if (i == 0 || i == 1) {
            this.mOrientation = i;
        }
    }

    public void setColor(int i) {
        this.mDrawable = new ColorDrawable(i);
    }

    public void setSpacing(int i) {
        this.mSpacing = i;
    }

    public void setStartDraw(boolean z) {
        this.mStartDraw = z;
    }

    public void setEndDraw(boolean z) {
        this.mEndDraw = z;
    }

    public void setMarginLeft(int i) {
        this.mMarginLeft = i;
    }

    public void setMarginRight(int i) {
        this.mMarginRight = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getChildCount() == 0 || recyclerView.getLayoutManager() == null || this.mDrawable == null) {
            return;
        }
        canvas.save();
        boolean clipToPadding = recyclerView.getClipToPadding();
        int width = recyclerView.getWidth();
        int height = recyclerView.getHeight();
        int paddingRight = recyclerView.getPaddingRight();
        int paddingTop = recyclerView.getPaddingTop();
        int paddingBottom = recyclerView.getPaddingBottom();
        int paddingLeft = recyclerView.getPaddingLeft();
        int childCount = recyclerView.getChildCount();
        int i = 0;
        if (this.mOrientation == 1) {
            int i2 = this.mMarginLeft;
            int i3 = (width - this.mMarginRight) + (clipToPadding ? -paddingRight : 0);
            if (clipToPadding) {
                canvas.clipRect(i2, paddingTop, i3, height - paddingBottom);
            }
            if (this.mStartDraw) {
                View childAt = recyclerView.getChildAt(0);
                recyclerView.getDecoratedBoundsWithMargins(childAt, this.mTemp1);
                this.mTemp2.left = i2;
                this.mTemp2.top = (int) (this.mTemp1.top + childAt.getTranslationY());
                this.mTemp2.right = i3;
                this.mTemp2.bottom += this.mSpacing;
                this.mDrawable.setBounds(this.mTemp2);
                this.mDrawable.draw(canvas);
            }
            if (!this.mEndDraw) {
                childCount--;
            }
            while (i < childCount) {
                View childAt2 = recyclerView.getChildAt(i);
                recyclerView.getDecoratedBoundsWithMargins(childAt2, this.mTemp1);
                this.mTemp2.left = i2;
                this.mTemp2.top = (int) ((this.mTemp1.bottom + childAt2.getTranslationY()) - this.mSpacing);
                this.mTemp2.right = i3;
                this.mTemp2.bottom += this.mSpacing;
                this.mDrawable.setBounds(this.mTemp2);
                this.mDrawable.draw(canvas);
                i++;
            }
        } else {
            if (!clipToPadding) {
                paddingTop = 0;
            }
            int i4 = height + (clipToPadding ? -paddingBottom : 0);
            if (clipToPadding) {
                canvas.clipRect(paddingLeft, paddingTop, width - paddingRight, i4);
            }
            if (this.mStartDraw) {
                View childAt3 = recyclerView.getChildAt(0);
                recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt3, this.mTemp1);
                this.mTemp2.left = (int) (this.mTemp1.left + childAt3.getTranslationX());
                this.mTemp2.top = paddingTop;
                Rect rect = this.mTemp2;
                rect.right = rect.left + this.mSpacing;
                this.mTemp2.bottom = i4;
                this.mDrawable.setBounds(this.mTemp2);
                this.mDrawable.draw(canvas);
            }
            if (!this.mEndDraw) {
                childCount--;
            }
            while (i < childCount) {
                View childAt4 = recyclerView.getChildAt(i);
                recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt4, this.mTemp1);
                this.mTemp2.left = (int) ((this.mTemp1.right + childAt4.getTranslationX()) - this.mSpacing);
                this.mTemp2.top = paddingTop;
                Rect rect2 = this.mTemp2;
                rect2.right = rect2.left + this.mSpacing;
                this.mTemp2.bottom = i4;
                this.mDrawable.setBounds(this.mTemp2);
                this.mDrawable.draw(canvas);
                i++;
            }
        }
        canvas.restore();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            rect.set(0, 0, 0, this.mSpacing);
        } else {
            rect.set(0, 0, this.mSpacing, 0);
        }
    }
}

package com.kwad.components.ct.horizontal.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends RecyclerView.ItemDecoration {
    private int aPq;
    private final Rect aPr = new Rect();
    private boolean aPs;
    private boolean aPt;
    private Drawable aPu;

    public a(int i, boolean z, boolean z2) {
        this.aPs = true;
        this.aPt = true;
        setOrientation(1);
        this.aPs = z;
        this.aPt = false;
    }

    public final void setDrawable(Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Drawable cannot be null.");
        }
        this.aPu = drawable;
    }

    private void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
        }
        this.aPq = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getLayoutManager() == null || this.aPu == null) {
            return;
        }
        if (this.aPq == 1) {
            a(canvas, recyclerView);
        } else {
            b(canvas, recyclerView);
        }
    }

    private void a(Canvas canvas, RecyclerView recyclerView) {
        int width;
        int paddingLeft;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            paddingLeft = recyclerView.getPaddingLeft();
            width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(paddingLeft, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            width = recyclerView.getWidth();
            paddingLeft = 0;
        }
        int childCount = recyclerView.getChildCount();
        if (!this.aPt) {
            childCount--;
        }
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            recyclerView.getDecoratedBoundsWithMargins(childAt, this.aPr);
            int iRound = this.aPr.bottom + Math.round(childAt.getTranslationY());
            this.aPu.setBounds(paddingLeft, iRound - this.aPu.getIntrinsicHeight(), width, iRound);
            this.aPu.draw(canvas);
        }
        canvas.restore();
    }

    private void b(Canvas canvas, RecyclerView recyclerView) {
        int height;
        int paddingTop;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            paddingTop = recyclerView.getPaddingTop();
            height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), paddingTop, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
        } else {
            height = recyclerView.getHeight();
            paddingTop = 0;
        }
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt, this.aPr);
            int iRound = this.aPr.right + Math.round(childAt.getTranslationX());
            this.aPu.setBounds(iRound - this.aPu.getIntrinsicWidth(), paddingTop, iRound, height);
            this.aPu.draw(canvas);
        }
        canvas.restore();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.aPu == null) {
            rect.set(0, 0, 0, 0);
            return;
        }
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        if (!this.aPs && childLayoutPosition == 0) {
            rect.set(0, 0, 0, 0);
        } else if (this.aPq == 1) {
            rect.set(0, 0, 0, this.aPu.getIntrinsicHeight());
        } else {
            rect.set(0, 0, this.aPu.getIntrinsicWidth(), 0);
        }
    }
}

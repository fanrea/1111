package com.fendasz.moku.planet.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class FlowLayoutView extends ViewGroup {
    private Row curRow;
    private int horizontalPadding;
    private List<Row> rows;
    private int usedWidth;
    private int verticalPadding;

    public FlowLayoutView(Context context) {
        super(context);
        this.rows = new ArrayList();
        this.verticalPadding = 30;
        this.horizontalPadding = 40;
    }

    public FlowLayoutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rows = new ArrayList();
        this.verticalPadding = 30;
        this.horizontalPadding = 40;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        restoreLine();
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            childAt.measure(View.MeasureSpec.makeMeasureSpec(size, mode == 1073741824 ? Integer.MIN_VALUE : mode), View.MeasureSpec.makeMeasureSpec(size2, mode2 != 1073741824 ? mode2 : Integer.MIN_VALUE));
            if (this.curRow == null) {
                this.curRow = new Row();
            }
            if (childAt.getMeasuredWidth() + this.horizontalPadding > size - this.usedWidth) {
                nextLine();
            }
            this.usedWidth += childAt.getMeasuredWidth() + this.horizontalPadding;
            this.curRow.addView(childAt);
        }
        this.rows.add(this.curRow);
        Iterator<Row> it = this.rows.iterator();
        while (it.hasNext()) {
            i3 += it.next().height + this.verticalPadding;
        }
        setMeasuredDimension(size, i3);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 0;
        for (Row row : this.rows) {
            row.layout(i5);
            i5 = i5 + row.height + this.verticalPadding;
        }
    }

    private void nextLine() {
        this.rows.add(this.curRow);
        this.curRow = new Row();
        this.usedWidth = 0;
    }

    private void restoreLine() {
        this.rows.clear();
        this.curRow = new Row();
        this.usedWidth = 0;
    }

    class Row {
        private List<View> childViews = new ArrayList();
        private int height;

        Row() {
        }

        public void addView(View view) {
            this.childViews.add(view);
            int measuredHeight = view.getMeasuredHeight();
            int measuredHeight2 = this.height;
            if (measuredHeight > measuredHeight2) {
                measuredHeight2 = view.getMeasuredHeight();
            }
            this.height = measuredHeight2;
        }

        public int getSize() {
            return this.childViews.size();
        }

        public void layout(int i) {
            int measuredWidth = 0;
            for (int i2 = 0; i2 < this.childViews.size(); i2++) {
                View view = this.childViews.get(i2);
                view.layout(measuredWidth, i, view.getMeasuredWidth() + measuredWidth, view.getMeasuredHeight() + i);
                measuredWidth = measuredWidth + view.getMeasuredWidth() + FlowLayoutView.this.horizontalPadding;
            }
        }
    }
}

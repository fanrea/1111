package com.fendasz.moku.planet.common;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {
    private static final String TAG = "GridSpaceItemDecoration==>";
    private int bottomSpace;
    private int size;
    private int space;

    public GridSpaceItemDecoration(int i) {
        this.space = i;
        this.size = 2;
        this.bottomSpace = 0;
    }

    public GridSpaceItemDecoration(int i, int i2) {
        this.space = i;
        this.size = i2;
    }

    public GridSpaceItemDecoration(int i, int i2, int i3) {
        this.space = i;
        this.size = i2;
        this.bottomSpace = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        Log.d(TAG, "POSITION=>" + childAdapterPosition);
        int i = this.size;
        if (childAdapterPosition < i - 1) {
            if (childAdapterPosition == 0) {
                rect.right = this.space;
            } else {
                rect.left = this.space;
                rect.right = this.space;
            }
        } else if (childAdapterPosition == i - 1) {
            rect.left = this.space;
        } else if (childAdapterPosition % i == 0) {
            rect.right = this.space;
        } else if ((childAdapterPosition + 1) % i == 0) {
            rect.left = this.space;
        } else {
            rect.left = this.space;
            rect.right = this.space;
        }
        rect.bottom = this.bottomSpace;
    }
}

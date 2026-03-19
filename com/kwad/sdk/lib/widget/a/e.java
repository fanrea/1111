package com.kwad.sdk.lib.widget.a;

import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class e {

    public interface a {
        void v(float f);
    }

    public static int e(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager;
        int[] iArrFindFirstVisibleItemPositions;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return -1;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        if (!(layoutManager instanceof StaggeredGridLayoutManager) || (iArrFindFirstVisibleItemPositions = ((StaggeredGridLayoutManager) layoutManager).findFirstVisibleItemPositions(null)) == null || iArrFindFirstVisibleItemPositions.length <= 0) {
            return -1;
        }
        int iMin = iArrFindFirstVisibleItemPositions[0];
        for (int i : iArrFindFirstVisibleItemPositions) {
            iMin = Math.min(i, iMin);
        }
        return iMin;
    }

    public static int f(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager;
        int[] iArrFindLastVisibleItemPositions;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return -1;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        }
        if (!(layoutManager instanceof StaggeredGridLayoutManager) || (iArrFindLastVisibleItemPositions = ((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(null)) == null || iArrFindLastVisibleItemPositions.length <= 0) {
            return -1;
        }
        int iMax = iArrFindLastVisibleItemPositions[0];
        for (int i : iArrFindLastVisibleItemPositions) {
            iMax = Math.max(i, iMax);
        }
        return iMax;
    }

    public static void a(RecyclerView recyclerView, int i) {
        if (recyclerView == null || i < 0) {
            return;
        }
        int childLayoutPosition = recyclerView.getChildLayoutPosition(recyclerView.getChildAt(0));
        int childLayoutPosition2 = recyclerView.getChildLayoutPosition(recyclerView.getChildAt(recyclerView.getChildCount() - 1));
        if (i < childLayoutPosition) {
            recyclerView.smoothScrollToPosition(i);
            return;
        }
        if (i <= childLayoutPosition2) {
            int i2 = i - childLayoutPosition;
            if (i2 < 0 || i2 >= recyclerView.getChildCount()) {
                return;
            }
            recyclerView.smoothScrollBy(0, recyclerView.getChildAt(i2).getTop(), new AccelerateDecelerateInterpolator());
            return;
        }
        int i3 = i - childLayoutPosition;
        if (i3 < 0 || i3 >= recyclerView.getChildCount()) {
            return;
        }
        recyclerView.smoothScrollBy(0, recyclerView.getChildAt(i3).getTop(), new AccelerateDecelerateInterpolator());
    }
}

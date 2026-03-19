package com.bytedance.sdk.djx.core.business.view.rv;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.sdk.djx.utils.LG;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXRVExposeUtil {
    public static final String TAG = "DJXRVExposeUtil";
    private int mFirstVisiblePos;
    private OnItemExposeListener mItemOnExposeListener;
    private int mLastVisiblePos;
    private RecyclerView mRecyclerView;
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.bytedance.sdk.djx.core.business.view.rv.DJXRVExposeUtil.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0 || i == 1 || i == 2) {
                DJXRVExposeUtil dJXRVExposeUtil = DJXRVExposeUtil.this;
                dJXRVExposeUtil.handleCurrentVisibleItems(dJXRVExposeUtil.mXOffset, DJXRVExposeUtil.this.mYOffset);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            DJXRVExposeUtil.this.mXOffset = i;
            DJXRVExposeUtil.this.mYOffset = i2;
            DJXRVExposeUtil.this.handleCurrentVisibleItems(i, i2);
        }
    };
    private int mXOffset;
    private int mYOffset;

    public interface OnItemExposeListener {
        void onItemViewVisible(boolean z, int i);
    }

    public void setRecyclerItemExposeListener(RecyclerView recyclerView, OnItemExposeListener onItemExposeListener) {
        this.mItemOnExposeListener = onItemExposeListener;
        this.mRecyclerView = recyclerView;
        if (recyclerView == null) {
            return;
        }
        recyclerView.addOnScrollListener(this.mScrollListener);
    }

    public RecyclerView.OnScrollListener getScrollListener() {
        return this.mScrollListener;
    }

    public void handleCurrentVisibleItems(int i, int i2) {
        int[] iArrFindRangeStaggeredGrid;
        int spanCount;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || recyclerView.getVisibility() != 0 || !this.mRecyclerView.isShown() || !this.mRecyclerView.getGlobalVisibleRect(new Rect())) {
            return;
        }
        int orientation = -1;
        try {
            int[] iArrFindRangeLinear = new int[2];
            RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                int[] iArrFindRangeGrid = findRangeGrid(gridLayoutManager);
                spanCount = gridLayoutManager.getSpanCount();
                orientation = gridLayoutManager.getOrientation();
                iArrFindRangeStaggeredGrid = iArrFindRangeGrid;
            } else {
                if (layoutManager instanceof LinearLayoutManager) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                    iArrFindRangeLinear = findRangeLinear(linearLayoutManager);
                    orientation = linearLayoutManager.getOrientation();
                } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                    StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                    int spanCount2 = staggeredGridLayoutManager.getSpanCount();
                    int orientation2 = staggeredGridLayoutManager.getOrientation();
                    iArrFindRangeStaggeredGrid = findRangeStaggeredGrid(staggeredGridLayoutManager);
                    spanCount = spanCount2;
                    orientation = orientation2;
                }
                iArrFindRangeStaggeredGrid = iArrFindRangeLinear;
                spanCount = 1;
            }
            if (iArrFindRangeStaggeredGrid.length < 2) {
                return;
            }
            if (orientation == 1) {
                int i3 = iArrFindRangeStaggeredGrid[0];
                while (true) {
                    int i4 = iArrFindRangeStaggeredGrid[1];
                    if (i3 > i4) {
                        return;
                    }
                    setCallbackForLogicVisibleView(iArrFindRangeStaggeredGrid[0], i3, i4, spanCount, i2);
                    i3++;
                }
            } else {
                int i5 = iArrFindRangeStaggeredGrid[0];
                while (true) {
                    int i6 = iArrFindRangeStaggeredGrid[1];
                    if (i5 > i6) {
                        return;
                    }
                    setCallbackForLogicVisibleView(iArrFindRangeStaggeredGrid[0], i5, i6, spanCount, i);
                    i5++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LG.d(TAG, "handle rv item expose error = " + e.getMessage());
        }
    }

    private void setCallbackForLogicVisibleView(View view, int i, int i2) {
        if (view != null && view.getVisibility() == 0 && view.isShown() && view.getGlobalVisibleRect(new Rect())) {
            Rect rect = new Rect();
            boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
            boolean z = false;
            boolean z2 = (i2 == 1 && rect.height() > view.getMeasuredHeight() / 2) || (i2 == 0 && rect.width() > view.getMeasuredWidth() / 2);
            OnItemExposeListener onItemExposeListener = this.mItemOnExposeListener;
            if (globalVisibleRect && z2) {
                z = true;
            }
            onItemExposeListener.onItemViewVisible(z, i);
        }
    }

    private void setCallbackForLogicVisibleView(int i, int i2, int i3, int i4, int i5) {
        if (this.mFirstVisiblePos != i && i5 > 0) {
            for (int i6 = 0; i6 < i4; i6++) {
                this.mItemOnExposeListener.onItemViewVisible(false, this.mFirstVisiblePos + i6);
            }
        }
        this.mFirstVisiblePos = i;
        if (this.mLastVisiblePos == 0) {
            this.mLastVisiblePos = i3;
        }
        if (this.mLastVisiblePos != i3 && i5 < 0) {
            for (int i7 = 0; i7 < i4; i7++) {
                this.mItemOnExposeListener.onItemViewVisible(false, this.mLastVisiblePos - i7);
            }
        }
        this.mLastVisiblePos = i3;
        this.mItemOnExposeListener.onItemViewVisible(true, i2);
    }

    private int[] findRangeLinear(LinearLayoutManager linearLayoutManager) {
        return new int[]{linearLayoutManager.findFirstVisibleItemPosition(), linearLayoutManager.findLastVisibleItemPosition()};
    }

    private int[] findRangeGrid(GridLayoutManager gridLayoutManager) {
        return new int[]{gridLayoutManager.findFirstVisibleItemPosition(), gridLayoutManager.findLastVisibleItemPosition()};
    }

    public static int[] findRangeStaggeredGrid(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
        int[] iArr2 = new int[staggeredGridLayoutManager.getSpanCount()];
        staggeredGridLayoutManager.findFirstVisibleItemPositions(iArr);
        staggeredGridLayoutManager.findLastVisibleItemPositions(iArr2);
        return findRange(iArr, iArr2);
    }

    public static int[] findRange(int[] iArr, int[] iArr2) {
        int i = iArr[0];
        int i2 = iArr2[0];
        for (int i3 = 1; i3 < iArr.length; i3++) {
            int i4 = iArr[i3];
            if (i > i4) {
                i = i4;
            }
        }
        for (int i5 = 1; i5 < iArr2.length; i5++) {
            int i6 = iArr2[i5];
            if (i2 < i6) {
                i2 = i6;
            }
        }
        return new int[]{i, i2};
    }
}

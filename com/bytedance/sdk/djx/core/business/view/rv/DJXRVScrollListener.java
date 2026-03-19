package com.bytedance.sdk.djx.core.business.view.rv;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.sdk.djx.utils.LG;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class DJXRVScrollListener extends RecyclerView.OnScrollListener {
    private static final int DEFAULT_PRELOAD_NUM = 2;
    private static final String TAG = "DJXRVScrollListener";
    private int mDx;
    private int mDy;
    private int mFirstVisibleItemPos;
    private int mLastVisibleItemPos;
    private RecyclerView.LayoutManager mLayoutManager;
    private int mNewState;

    protected int getPreloadNum() {
        return 2;
    }

    protected void onItemViewVisible(boolean z, int i) {
    }

    protected void onLastItemScroll(int i, boolean z) {
    }

    protected void onScrollStopped() {
    }

    protected void onScrollTop() {
    }

    protected void onBottomScrolled() {
        LG.d(TAG, "onBottomScrolled");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
        this.mDy = i2;
        this.mDx = i;
        if (this.mLayoutManager == null) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            this.mLayoutManager = layoutManager;
            if (layoutManager == null) {
                return;
            }
        }
        int iFindFirstCompletelyVisibleItemPosition = -1;
        RecyclerView.LayoutManager layoutManager2 = this.mLayoutManager;
        if (layoutManager2 instanceof LinearLayoutManager) {
            this.mLastVisibleItemPos = ((LinearLayoutManager) layoutManager2).findLastVisibleItemPosition();
            iFindFirstCompletelyVisibleItemPosition = ((LinearLayoutManager) this.mLayoutManager).findFirstCompletelyVisibleItemPosition();
        } else if (layoutManager2 instanceof StaggeredGridLayoutManager) {
            try {
                this.mLastVisibleItemPos = DJXRVExposeUtil.findRangeStaggeredGrid((StaggeredGridLayoutManager) layoutManager2)[1];
                iFindFirstCompletelyVisibleItemPosition = DJXRVExposeUtil.findRangeStaggeredGrid((StaggeredGridLayoutManager) this.mLayoutManager)[2];
            } catch (Exception unused) {
            }
        }
        if (this.mLastVisibleItemPos == this.mLayoutManager.getItemCount() - 1) {
            if (this.mNewState != 2 || i <= 0) {
                if (!(iFindFirstCompletelyVisibleItemPosition == 0 && recyclerView.getChildAt(iFindFirstCompletelyVisibleItemPosition).getLeft() == 0) && this.mNewState == 1) {
                    lastItemScroll(false);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        this.mNewState = i;
        if (this.mLayoutManager == null) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            this.mLayoutManager = layoutManager;
            if (layoutManager == null) {
                return;
            }
        }
        int childCount = this.mLayoutManager.getChildCount();
        int itemCount = this.mLayoutManager.getItemCount();
        if (childCount > 0 && i == 0 && this.mLastVisibleItemPos >= itemCount - getPreloadNum() && this.mDy > 0) {
            onBottomScrolled();
        }
        if (i == 0) {
            onScrollStopped();
            RecyclerView.LayoutManager layoutManager2 = this.mLayoutManager;
            if (layoutManager2 instanceof LinearLayoutManager) {
                this.mFirstVisibleItemPos = ((LinearLayoutManager) layoutManager2).findFirstVisibleItemPosition();
            } else if (layoutManager2 instanceof StaggeredGridLayoutManager) {
                try {
                    this.mFirstVisibleItemPos = DJXRVExposeUtil.findRangeStaggeredGrid((StaggeredGridLayoutManager) layoutManager2)[0];
                } catch (Exception unused) {
                }
            }
            if (this.mFirstVisibleItemPos == 0 && !recyclerView.canScrollVertically(-1)) {
                onScrollTop();
            }
            if (this.mFirstVisibleItemPos + 2 == this.mLayoutManager.getItemCount() - 1 || this.mLastVisibleItemPos == this.mLayoutManager.getItemCount() - 1) {
                lastItemScroll(true);
            } else if (this.mDx > 0) {
                setCallbackForLogicVisibleView(this.mLayoutManager.findViewByPosition(this.mFirstVisibleItemPos + 1), this.mFirstVisibleItemPos + 1, 0);
            } else {
                setCallbackForLogicVisibleView(this.mLayoutManager.findViewByPosition(this.mFirstVisibleItemPos), this.mFirstVisibleItemPos, 0);
            }
        }
    }

    private void setCallbackForLogicVisibleView(View view, int i, int i2) {
        if (view != null && view.getVisibility() == 0 && view.isShown() && view.getGlobalVisibleRect(new Rect())) {
            Rect rectComputeVisibleView = computeVisibleView(view);
            if ((i2 == 1 && rectComputeVisibleView.height() > view.getMeasuredHeight() / 5) || (i2 == 0 && rectComputeVisibleView.width() > view.getMeasuredWidth() / 5)) {
                onItemViewVisible(true, i);
            } else {
                onItemViewVisible(false, i);
            }
        }
    }

    private Rect computeVisibleView(View view) {
        Rect rect = new Rect();
        if (view != null && view.getVisibility() == 0 && view.isShown() && view.getGlobalVisibleRect(rect)) {
            view.getGlobalVisibleRect(rect);
        }
        return rect;
    }

    private void lastItemScroll(boolean z) {
        Rect rect = new Rect();
        View viewFindViewByPosition = this.mLayoutManager.findViewByPosition(this.mLastVisibleItemPos);
        if (viewFindViewByPosition == null) {
            return;
        }
        this.mLayoutManager.getDecoratedBoundsWithMargins(viewFindViewByPosition, rect);
        onLastItemScroll(rect.left, z);
    }
}

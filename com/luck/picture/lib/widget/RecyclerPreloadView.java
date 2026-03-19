package com.luck.picture.lib.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.interfaces.OnRecyclerViewPreloadMoreListener;
import com.luck.picture.lib.interfaces.OnRecyclerViewScrollListener;
import com.luck.picture.lib.interfaces.OnRecyclerViewScrollStateListener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class RecyclerPreloadView extends RecyclerView {
    private static final int BOTTOM_DEFAULT = 1;
    public static final int BOTTOM_PRELOAD = 2;
    private static final int LIMIT = 150;
    private static final String TAG = "RecyclerPreloadView";
    private boolean isEnabledLoadMore;
    private boolean isInTheBottom;
    private int mFirstVisiblePosition;
    private int mLastVisiblePosition;
    private OnRecyclerViewPreloadMoreListener onRecyclerViewPreloadListener;
    private OnRecyclerViewScrollListener onRecyclerViewScrollListener;
    private OnRecyclerViewScrollStateListener onRecyclerViewScrollStateListener;
    private int reachBottomRow;

    public RecyclerPreloadView(Context context) {
        super(context);
        this.isInTheBottom = false;
        this.isEnabledLoadMore = false;
        this.reachBottomRow = 1;
    }

    public RecyclerPreloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isInTheBottom = false;
        this.isEnabledLoadMore = false;
        this.reachBottomRow = 1;
    }

    public RecyclerPreloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isInTheBottom = false;
        this.isEnabledLoadMore = false;
        this.reachBottomRow = 1;
    }

    public void setReachBottomRow(int i) {
        if (i < 1) {
            i = 1;
        }
        this.reachBottomRow = i;
    }

    public void setEnabledLoadMore(boolean z) {
        this.isEnabledLoadMore = z;
    }

    public boolean isEnabledLoadMore() {
        return this.isEnabledLoadMore;
    }

    public int getFirstVisiblePosition() {
        return this.mFirstVisiblePosition;
    }

    public int getLastVisiblePosition() {
        return this.mLastVisiblePosition;
    }

    public void setLastVisiblePosition(int i) {
        this.mLastVisiblePosition = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
    @Override // androidx.recyclerview.widget.RecyclerView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onScrolled(int r6, int r7) {
        /*
            r5 = this;
            super.onScrolled(r6, r7)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r5.getLayoutManager()
            if (r0 == 0) goto L7b
            r5.setLayoutManagerPosition(r0)
            com.luck.picture.lib.interfaces.OnRecyclerViewPreloadMoreListener r1 = r5.onRecyclerViewPreloadListener
            if (r1 == 0) goto L5c
            boolean r1 = r5.isEnabledLoadMore
            if (r1 == 0) goto L5c
            androidx.recyclerview.widget.RecyclerView$Adapter r1 = r5.getAdapter()
            if (r1 == 0) goto L54
            boolean r2 = r0 instanceof androidx.recyclerview.widget.GridLayoutManager
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3b
            androidx.recyclerview.widget.GridLayoutManager r0 = (androidx.recyclerview.widget.GridLayoutManager) r0
            int r1 = r1.getItemCount()
            int r2 = r0.getSpanCount()
            int r1 = r1 / r2
            int r2 = r0.findLastVisibleItemPosition()
            int r0 = r0.getSpanCount()
            int r2 = r2 / r0
            int r0 = r5.reachBottomRow
            int r1 = r1 - r0
            if (r2 < r1) goto L3b
            r0 = r3
            goto L3c
        L3b:
            r0 = r4
        L3c:
            if (r0 != 0) goto L41
            r5.isInTheBottom = r4
            goto L5c
        L41:
            boolean r0 = r5.isInTheBottom
            if (r0 != 0) goto L4f
            com.luck.picture.lib.interfaces.OnRecyclerViewPreloadMoreListener r0 = r5.onRecyclerViewPreloadListener
            r0.onRecyclerViewPreloadMore()
            if (r7 <= 0) goto L5c
            r5.isInTheBottom = r3
            goto L5c
        L4f:
            if (r7 != 0) goto L5c
            r5.isInTheBottom = r4
            goto L5c
        L54:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            java.lang.String r7 = "Adapter is null,Please check it!"
            r6.<init>(r7)
            throw r6
        L5c:
            com.luck.picture.lib.interfaces.OnRecyclerViewScrollListener r0 = r5.onRecyclerViewScrollListener
            if (r0 == 0) goto L63
            r0.onScrolled(r6, r7)
        L63:
            com.luck.picture.lib.interfaces.OnRecyclerViewScrollStateListener r6 = r5.onRecyclerViewScrollStateListener
            if (r6 == 0) goto L7a
            int r6 = java.lang.Math.abs(r7)
            r7 = 150(0x96, float:2.1E-43)
            if (r6 >= r7) goto L75
            com.luck.picture.lib.interfaces.OnRecyclerViewScrollStateListener r6 = r5.onRecyclerViewScrollStateListener
            r6.onScrollSlow()
            goto L7a
        L75:
            com.luck.picture.lib.interfaces.OnRecyclerViewScrollStateListener r6 = r5.onRecyclerViewScrollStateListener
            r6.onScrollFast()
        L7a:
            return
        L7b:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            java.lang.String r7 = "LayoutManager is null,Please check it!"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.widget.RecyclerPreloadView.onScrolled(int, int):void");
    }

    private void setLayoutManagerPosition(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            this.mFirstVisiblePosition = gridLayoutManager.findFirstVisibleItemPosition();
            this.mLastVisiblePosition = gridLayoutManager.findLastVisibleItemPosition();
        } else if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            this.mFirstVisiblePosition = linearLayoutManager.findFirstVisibleItemPosition();
            this.mLastVisiblePosition = linearLayoutManager.findLastVisibleItemPosition();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i) {
        OnRecyclerViewScrollStateListener onRecyclerViewScrollStateListener;
        super.onScrollStateChanged(i);
        if (i == 0 || i == 1) {
            setLayoutManagerPosition(getLayoutManager());
        }
        OnRecyclerViewScrollListener onRecyclerViewScrollListener = this.onRecyclerViewScrollListener;
        if (onRecyclerViewScrollListener != null) {
            onRecyclerViewScrollListener.onScrollStateChanged(i);
        }
        if (i != 0 || (onRecyclerViewScrollStateListener = this.onRecyclerViewScrollStateListener) == null) {
            return;
        }
        onRecyclerViewScrollStateListener.onScrollSlow();
    }

    public void setOnRecyclerViewPreloadListener(OnRecyclerViewPreloadMoreListener onRecyclerViewPreloadMoreListener) {
        this.onRecyclerViewPreloadListener = onRecyclerViewPreloadMoreListener;
    }

    public void setOnRecyclerViewScrollStateListener(OnRecyclerViewScrollStateListener onRecyclerViewScrollStateListener) {
        this.onRecyclerViewScrollStateListener = onRecyclerViewScrollStateListener;
    }

    public void setOnRecyclerViewScrollListener(OnRecyclerViewScrollListener onRecyclerViewScrollListener) {
        this.onRecyclerViewScrollListener = onRecyclerViewScrollListener;
    }
}

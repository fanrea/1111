package com.bytedance.sdk.djx.core.business.view.rv.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.sdk.djx.utils.UIUtil;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class StaggeredItemDecoration extends RecyclerView.ItemDecoration {
    private final int mDividerWidth;
    private final int mSideWidth;

    public StaggeredItemDecoration(int i, int i2) {
        this.mDividerWidth = i;
        this.mSideWidth = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        int spanCount = ((StaggeredGridLayoutManager) recyclerView.getLayoutManager()).getSpanCount();
        int spanIndex = ((StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams()).getSpanIndex();
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition == 0 || childAdapterPosition == 1) {
            rect.top = UIUtil.dp2px(14.0f);
        }
        if (spanIndex == 0) {
            rect.right = this.mDividerWidth / 2;
            rect.left = this.mSideWidth;
        } else if (spanIndex == spanCount - 1) {
            rect.left = this.mDividerWidth / 2;
            rect.right = this.mSideWidth;
        } else {
            rect.right = this.mDividerWidth / 2;
            rect.left = this.mDividerWidth / 2;
        }
        rect.bottom = this.mDividerWidth;
    }
}

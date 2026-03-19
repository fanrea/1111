package com.bytedance.sdk.djx.core.business.budrama.home;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.UIUtil;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DramaGridItemDecoration extends RecyclerView.ItemDecoration {
    private static final String TAG = "GridSpaceItemDecoration";
    private final int mColumnSpacing;
    private final int mRowSpacing;
    private final int mSpanCount;

    public DramaGridItemDecoration(int i, int i2, int i3, int i4) {
        this.mSpanCount = i;
        this.mRowSpacing = UIUtil.dp2px(i2);
        this.mColumnSpacing = (i3 - (i4 * i)) / (i - 1);
    }

    public DramaGridItemDecoration(int i, int i2, int i3) {
        this.mSpanCount = i;
        this.mRowSpacing = UIUtil.dp2px(i2);
        this.mColumnSpacing = UIUtil.dp2px(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i = this.mSpanCount;
        int i2 = childAdapterPosition % i;
        int i3 = this.mColumnSpacing;
        if (i3 != 0) {
            rect.left = (i3 * i2) / i;
            int i4 = this.mColumnSpacing;
            rect.right = i4 - (((i2 + 1) * i4) / this.mSpanCount);
            LG.d(TAG, "position:" + childAdapterPosition + ", columnIndex: " + i2 + ", left/right: " + rect.left + "/" + rect.right);
        }
        if (childAdapterPosition >= this.mSpanCount) {
            rect.top = this.mRowSpacing;
        }
    }
}

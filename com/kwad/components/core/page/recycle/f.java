package com.kwad.components.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.utils.ax;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f {
    final RecyclerView WN;
    final RecyclerView.LayoutManager WO;

    private f(RecyclerView recyclerView) {
        this.WN = recyclerView;
        this.WO = recyclerView.getLayoutManager();
    }

    public static f b(RecyclerView recyclerView) {
        ax.checkNotNull(recyclerView);
        return new f(recyclerView);
    }

    public final int findFirstVisibleItemPosition() {
        View viewA = a(0, this.WO.getChildCount(), false, true);
        if (viewA == null) {
            return -1;
        }
        return this.WN.getChildAdapterPosition(viewA);
    }

    public final int findFirstCompletelyVisibleItemPosition() {
        View viewA = a(0, this.WO.getChildCount(), true, false);
        if (viewA == null) {
            return -1;
        }
        return this.WN.getChildAdapterPosition(viewA);
    }

    public final int findLastVisibleItemPosition() {
        View viewA = a(this.WO.getChildCount() - 1, -1, false, true);
        if (viewA == null) {
            return -1;
        }
        return this.WN.getChildAdapterPosition(viewA);
    }

    private View a(int i, int i2, boolean z, boolean z2) {
        OrientationHelper orientationHelperCreateHorizontalHelper;
        if (this.WO.canScrollVertically()) {
            orientationHelperCreateHorizontalHelper = OrientationHelper.createVerticalHelper(this.WO);
        } else {
            orientationHelperCreateHorizontalHelper = OrientationHelper.createHorizontalHelper(this.WO);
        }
        int startAfterPadding = orientationHelperCreateHorizontalHelper.getStartAfterPadding();
        int endAfterPadding = orientationHelperCreateHorizontalHelper.getEndAfterPadding();
        int i3 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View childAt = this.WO.getChildAt(i);
            int decoratedStart = orientationHelperCreateHorizontalHelper.getDecoratedStart(childAt);
            int decoratedEnd = orientationHelperCreateHorizontalHelper.getDecoratedEnd(childAt);
            if (decoratedStart < endAfterPadding && decoratedEnd > startAfterPadding) {
                if (!z) {
                    return childAt;
                }
                if (decoratedStart >= startAfterPadding && decoratedEnd <= endAfterPadding) {
                    return childAt;
                }
                if (z2 && view == null) {
                    view = childAt;
                }
            }
            i += i3;
        }
        return view;
    }
}

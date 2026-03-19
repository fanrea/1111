package com.kwad.components.ct.detail.photo.related;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends RecyclerView.ItemDecoration {
    private final int awd;
    private final int awe;
    private final int awf;
    private final int awg;
    private int awh;

    public d(int i, int i2) {
        this(2, 0, 0, i2);
    }

    private d(int i, int i2, int i3, int i4) {
        this.awg = i;
        this.awd = 0;
        this.awe = 0;
        this.awf = i4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int itemCount = recyclerView.getAdapter().getItemCount();
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i = this.awg;
        int i2 = this.awh;
        boolean z = childAdapterPosition < i + i2;
        if (view instanceof com.kwad.components.core.widget.c) {
            if (z) {
                this.awh = i2 + 1;
                return;
            }
            return;
        }
        rect.left = this.awf / 2;
        rect.right = this.awf / 2;
        rect.top = this.awf;
        rect.bottom = 0;
        int spanIndex = ((StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams()).getSpanIndex();
        int i3 = this.awg;
        boolean z2 = (itemCount - 1) / i3 == childAdapterPosition / i3;
        if (spanIndex == 0) {
            rect.left = this.awe;
        } else if (spanIndex == i3 - 1) {
            rect.right = this.awe;
        }
        if (z) {
            rect.top = this.awd;
        } else if (z2) {
            rect.bottom = this.awd;
        }
    }
}

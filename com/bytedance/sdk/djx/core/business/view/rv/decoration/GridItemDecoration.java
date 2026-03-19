package com.bytedance.sdk.djx.core.business.view.rv.decoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.pangle.cn.pangrowth.base.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class GridItemDecoration extends RecyclerView.ItemDecoration {
    private final GradientDrawable mDivider;
    private final int mDividerWidth;
    private final Rect mTemp = new Rect();

    public GridItemDecoration(Context context) {
        this.mDivider = (GradientDrawable) (context == null ? InnerManager.getContext() : context).getResources().getDrawable(R.drawable.djx_gird_divider);
        this.mDividerWidth = UIUtil.dp2px(1.0f);
    }

    public GridItemDecoration(Context context, int i, int i2) {
        GradientDrawable gradientDrawable = (GradientDrawable) (context == null ? InnerManager.getContext() : context).getResources().getDrawable(R.drawable.djx_gird_divider);
        this.mDivider = gradientDrawable;
        gradientDrawable.setColor(i);
        this.mDividerWidth = UIUtil.dp2px(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int childCount = recyclerView.getChildCount();
        if (this.mDivider == null) {
            return;
        }
        int spanCount = -1;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            spanCount = ((GridLayoutManager) layoutManager).getSpanCount();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            spanCount = ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
        }
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            this.mTemp.left = childAt.getLeft() - layoutParams.leftMargin;
            this.mTemp.right = childAt.getRight() + layoutParams.rightMargin + this.mDividerWidth;
            this.mTemp.top = childAt.getBottom() + layoutParams.bottomMargin;
            Rect rect = this.mTemp;
            rect.bottom = rect.top + this.mDividerWidth;
            this.mDivider.setBounds(this.mTemp);
            this.mDivider.draw(canvas);
            this.mTemp.top = childAt.getTop() - layoutParams.topMargin;
            this.mTemp.bottom = childAt.getBottom() + layoutParams.bottomMargin;
            this.mTemp.left = childAt.getRight() + layoutParams.rightMargin;
            Rect rect2 = this.mTemp;
            rect2.right = rect2.left + this.mDividerWidth;
            if ((recyclerView.getChildAdapterPosition(childAt) + 1) % spanCount == 0) {
                Rect rect3 = this.mTemp;
                rect3.right = rect3.left;
            }
            this.mDivider.setBounds(this.mTemp);
            this.mDivider.draw(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003c A[PHI: r8
  0x003c: PHI (r8v11 boolean) = (r8v5 boolean), (r8v8 boolean), (r8v13 boolean) binds: [B:36:0x0060, B:28:0x0051, B:17:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void getItemOffsets(android.graphics.Rect r6, int r7, androidx.recyclerview.widget.RecyclerView r8) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r8.getAdapter()
            if (r0 != 0) goto L7
            return
        L7:
            r0 = -1
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r8.getLayoutManager()
            boolean r2 = r1 instanceof androidx.recyclerview.widget.GridLayoutManager
            if (r2 == 0) goto L18
            r0 = r1
            androidx.recyclerview.widget.GridLayoutManager r0 = (androidx.recyclerview.widget.GridLayoutManager) r0
            int r0 = r0.getSpanCount()
            goto L23
        L18:
            boolean r3 = r1 instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager
            if (r3 == 0) goto L23
            r0 = r1
            androidx.recyclerview.widget.StaggeredGridLayoutManager r0 = (androidx.recyclerview.widget.StaggeredGridLayoutManager) r0
            int r0 = r0.getSpanCount()
        L23:
            androidx.recyclerview.widget.RecyclerView$Adapter r8 = r8.getAdapter()
            int r8 = r8.getItemCount()
            int r3 = r8 % r0
            int r8 = r8 - r3
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3e
            if (r7 < r8) goto L36
            r8 = r3
            goto L37
        L36:
            r8 = r4
        L37:
            int r7 = r7 + r3
            int r7 = r7 % r0
            if (r7 != 0) goto L3c
            goto L64
        L3c:
            r3 = r4
            goto L64
        L3e:
            boolean r2 = r1 instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager
            if (r2 == 0) goto L62
            androidx.recyclerview.widget.StaggeredGridLayoutManager r1 = (androidx.recyclerview.widget.StaggeredGridLayoutManager) r1
            int r1 = r1.getOrientation()
            if (r1 != r3) goto L54
            if (r7 < r8) goto L4e
            r8 = r3
            goto L4f
        L4e:
            r8 = r4
        L4f:
            int r7 = r7 + r3
            int r7 = r7 % r0
            if (r7 != 0) goto L3c
            goto L64
        L54:
            int r1 = r7 + 1
            int r1 = r1 % r0
            if (r1 != 0) goto L5b
            r0 = r3
            goto L5c
        L5b:
            r0 = r4
        L5c:
            if (r7 < r8) goto L60
            r8 = r0
            goto L64
        L60:
            r8 = r0
            goto L3c
        L62:
            r8 = r4
            r3 = r8
        L64:
            if (r8 == 0) goto L6c
            int r7 = r5.mDividerWidth
            r6.set(r4, r4, r7, r4)
            goto L79
        L6c:
            if (r3 == 0) goto L74
            int r7 = r5.mDividerWidth
            r6.set(r4, r4, r4, r7)
            goto L79
        L74:
            int r7 = r5.mDividerWidth
            r6.set(r4, r4, r7, r7)
        L79:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.djx.core.business.view.rv.decoration.GridItemDecoration.getItemOffsets(android.graphics.Rect, int, androidx.recyclerview.widget.RecyclerView):void");
    }
}

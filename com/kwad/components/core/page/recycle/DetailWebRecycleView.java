package com.kwad.components.core.page.recycle;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.kwad.components.core.u.s;
import com.kwad.sdk.utils.z;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DetailWebRecycleView extends b {
    private Runnable WA;
    private s WB;
    private int Wt;
    private boolean Wu;
    private boolean Wv;
    private int Ww;
    private int Wx;
    private boolean Wy;
    a Wz;
    private int qu;

    public interface a {
        boolean rR();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public DetailWebRecycleView(Context context) {
        this(context, null);
    }

    public DetailWebRecycleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DetailWebRecycleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Wt = 1000;
        this.Wu = false;
        this.Wv = false;
        this.WA = new Runnable() { // from class: com.kwad.components.core.page.recycle.DetailWebRecycleView.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Object field = z.getField(DetailWebRecycleView.this, "mGapWorker");
                    if (field != null) {
                        z.callMethod(field, "postFromTraversal", DetailWebRecycleView.this, 0, Integer.valueOf(DetailWebRecycleView.this.Wt));
                    }
                } catch (RuntimeException e) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                }
            }
        };
        this.WB = new s(this.WA);
        if (context instanceof Activity) {
            this.qu = com.kwad.sdk.c.a.a.p((Activity) context);
        } else {
            this.qu = com.kwad.sdk.c.a.a.getScreenHeight(context);
        }
    }

    public void setTopViewHeight(int i) {
        this.Ww = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        postDelayed(this.WB, 50L);
    }

    @Override // com.kwad.components.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.WB);
    }

    public void setInterceptRequestFocusForWeb(boolean z) {
        this.Wu = z;
    }

    public void setInterceptRequestFocusForWebFiredOnce(boolean z) {
        this.Wv = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.Wv) {
            this.Wv = false;
        } else {
            if (this.Wu) {
                return;
            }
            super.requestChildFocus(view, view2);
        }
    }

    @Override // com.kwad.components.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a aVar = this.Wz;
        if (aVar != null && aVar.rR()) {
            return true;
        }
        this.Wx = computeVerticalScrollOffset();
        if (motionEvent.getY() <= this.Ww - this.Wx) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        int iComputeVerticalScrollOffset = computeVerticalScrollOffset();
        this.Wx = iComputeVerticalScrollOffset;
        if ((i2 > 0 && iComputeVerticalScrollOffset < this.Ww) && !this.Wy && iComputeVerticalScrollOffset < this.qu) {
            scrollBy(0, i2);
            iArr[1] = i2;
        }
        if (i2 < 0 && this.Wx > 0 && !ViewCompat.canScrollVertically(view, -1)) {
            scrollBy(0, i2);
            iArr[1] = i2;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        int iComputeVerticalScrollOffset = computeVerticalScrollOffset();
        this.Wx = iComputeVerticalScrollOffset;
        if (iComputeVerticalScrollOffset >= this.Ww) {
            return false;
        }
        fling((int) f, (int) f2);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i) {
        super.onScrollStateChanged(i);
        if (i == 0) {
            View childAt = getLayoutManager().getChildAt(getLayoutManager().getChildCount() - 1);
            if (childAt != null) {
                int bottom = childAt.getBottom();
                int bottom2 = getBottom() - getPaddingBottom();
                int position = getLayoutManager().getPosition(childAt);
                if (bottom == bottom2 && position == getLayoutManager().getItemCount() - 1) {
                    this.Wy = true;
                    return;
                }
            }
            this.Wy = false;
        }
    }

    public void setInterceptTouchListener(a aVar) {
        this.Wz = aVar;
    }
}

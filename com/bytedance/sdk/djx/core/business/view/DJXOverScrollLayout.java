package com.bytedance.sdk.djx.core.business.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXOverScrollLayout extends LinearLayout {
    private static final int ANIM_TIME = 400;
    private static final float DAMPING_COEFFICIENT = 0.3f;
    private static final String TAG = "DJXOverScrollLayout";
    private RecyclerView childView;
    private boolean isMoved;
    private boolean isSuccess;
    private float mLastX;
    private float mLastY;
    private ScrollListener mScrollListener;
    private final Rect original;
    private float startXpos;

    public interface ScrollListener {
        void onScroll(int i, boolean z);
    }

    public DJXOverScrollLayout(Context context) {
        this(context, null);
    }

    public DJXOverScrollLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DJXOverScrollLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.original = new Rect();
        this.isMoved = false;
        this.isSuccess = false;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.childView = (RecyclerView) getChildAt(0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.original.set(this.childView.getLeft(), this.childView.getTop(), this.childView.getRight(), this.childView.getBottom());
    }

    public void setScrollListener(ScrollListener scrollListener) {
        this.mScrollListener = scrollListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        if (x >= this.original.right || x <= this.original.left) {
            if (this.isMoved) {
                recoverLayout();
            }
            return true;
        }
        float x2 = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.startXpos = motionEvent.getX();
        } else {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return true;
                    }
                }
            }
            ScrollListener scrollListener = this.mScrollListener;
            if (scrollListener != null) {
                scrollListener.onScroll(this.childView.getLeft() - this.original.left, true);
            }
            if (this.isMoved) {
                recoverLayout();
            }
            return !this.isSuccess || super.dispatchTouchEvent(motionEvent);
        }
        float f = this.mLastX;
        if (f >= 0.0f) {
            float f2 = this.mLastY;
            if (f2 >= 0.0f && Math.abs(x2 - f) > Math.abs(y - f2)) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        }
        int x3 = (int) (motionEvent.getX() - this.startXpos);
        boolean z = x3 > 0 && canPullRight();
        boolean z2 = x3 < 0 && canPullLeft();
        if (z || z2) {
            cancelChild(motionEvent);
            int i = (int) (x3 * DAMPING_COEFFICIENT);
            this.childView.layout(this.original.left + i, this.original.top, this.original.right + i, this.original.bottom);
            ScrollListener scrollListener2 = this.mScrollListener;
            if (scrollListener2 != null) {
                scrollListener2.onScroll(i, false);
            }
            this.isMoved = true;
            this.isSuccess = false;
            return true;
        }
        this.startXpos = motionEvent.getX();
        this.isMoved = false;
        this.isSuccess = true;
        return super.dispatchTouchEvent(motionEvent);
    }

    private void cancelChild(MotionEvent motionEvent) {
        motionEvent.setAction(3);
        super.dispatchTouchEvent(motionEvent);
    }

    private void recoverLayout() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.childView.getLeft() - this.original.left, 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(400L);
        this.childView.startAnimation(translateAnimation);
        this.childView.layout(this.original.left, this.original.top, this.original.right, this.original.bottom);
        this.isMoved = false;
    }

    private boolean canPullRight() {
        if (((LinearLayoutManager) this.childView.getLayoutManager()).findFirstVisibleItemPosition() != 0 && this.childView.getAdapter().getItemCount() != 0) {
            return false;
        }
        if (this.childView.getChildCount() <= 0) {
            return true;
        }
        View childAt = this.childView.getChildAt(0);
        return childAt.getLeft() >= ((RecyclerView.LayoutParams) childAt.getLayoutParams()).leftMargin + this.childView.getPaddingLeft();
    }

    private boolean canPullLeft() {
        int itemCount = this.childView.getAdapter().getItemCount() - 1;
        int iFindLastVisibleItemPosition = ((LinearLayoutManager) this.childView.getLayoutManager()).findLastVisibleItemPosition();
        if (iFindLastVisibleItemPosition >= itemCount) {
            View childAt = this.childView.getChildAt(Math.min(iFindLastVisibleItemPosition - ((LinearLayoutManager) this.childView.getLayoutManager()).findFirstVisibleItemPosition(), this.childView.getChildCount() - 1));
            if (childAt != null) {
                return childAt.getRight() <= ((this.childView.getRight() - this.childView.getLeft()) - this.childView.getPaddingRight()) - ((RecyclerView.LayoutParams) childAt.getLayoutParams()).rightMargin;
            }
        }
        return false;
    }
}

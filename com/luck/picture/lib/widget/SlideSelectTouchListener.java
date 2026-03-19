package com.luck.picture.lib.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.ct.api.tube.KSTubeParamInner;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class SlideSelectTouchListener implements RecyclerView.OnItemTouchListener {
    private boolean isActive;
    private int mBottomBoundFrom;
    private int mBottomBoundTo;
    private int mEnd;
    private int mHeaderViewCount;
    private boolean mInBottomSpot;
    private boolean mInTopSpot;
    private int mLastEnd;
    private int mLastStart;
    private float mLastX;
    private float mLastY;
    private RecyclerView mRecyclerView;
    private int mScrollDistance;
    private OverScroller mScroller;
    private OnSlideSelectListener mSelectListener;
    private int mStart;
    private int mTopBoundFrom;
    private int mTopBoundTo;
    private final Runnable mScrollRunnable = new Runnable() { // from class: com.luck.picture.lib.widget.SlideSelectTouchListener.1
        @Override // java.lang.Runnable
        public void run() {
            if (SlideSelectTouchListener.this.mScroller == null || !SlideSelectTouchListener.this.mScroller.computeScrollOffset()) {
                return;
            }
            SlideSelectTouchListener slideSelectTouchListener = SlideSelectTouchListener.this;
            slideSelectTouchListener.scrollBy(slideSelectTouchListener.mScrollDistance);
            ViewCompat.postOnAnimation(SlideSelectTouchListener.this.mRecyclerView, SlideSelectTouchListener.this.mScrollRunnable);
        }
    };
    private int mMaxScrollDistance = 16;
    private int mAutoScrollDistance = (int) (Resources.getSystem().getDisplayMetrics().density * 56.0f);
    private int mTouchRegionTopOffset = 0;
    private int mTouchRegionBottomOffset = 0;
    private boolean mScrollAboveTopRegion = true;
    private boolean mScrollBelowTopRegion = true;

    public interface OnAdvancedSlideSelectListener extends OnSlideSelectListener {
        void onSelectionFinished(int i);

        void onSelectionStarted(int i);
    }

    public interface OnSlideSelectListener {
        void onSelectChange(int i, int i2, boolean z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    public SlideSelectTouchListener() {
        reset();
    }

    public SlideSelectTouchListener setRecyclerViewHeaderCount(int i) {
        this.mHeaderViewCount = i;
        return this;
    }

    public SlideSelectTouchListener withSelectListener(OnSlideSelectListener onSlideSelectListener) {
        this.mSelectListener = onSlideSelectListener;
        return this;
    }

    public SlideSelectTouchListener withMaxScrollDistance(int i) {
        this.mMaxScrollDistance = i;
        return this;
    }

    public SlideSelectTouchListener withTouchRegion(int i) {
        this.mAutoScrollDistance = i;
        return this;
    }

    public SlideSelectTouchListener withTopOffset(int i) {
        this.mTouchRegionTopOffset = i;
        return this;
    }

    public SlideSelectTouchListener withBottomOffset(int i) {
        this.mTouchRegionBottomOffset = i;
        return this;
    }

    public SlideSelectTouchListener withScrollAboveTopRegion(boolean z) {
        this.mScrollAboveTopRegion = z;
        return this;
    }

    public SlideSelectTouchListener withScrollBelowTopRegion(boolean z) {
        this.mScrollBelowTopRegion = z;
        return this;
    }

    public void startSlideSelection(int i) {
        setActive(true);
        this.mStart = i;
        this.mEnd = i;
        this.mLastStart = i;
        this.mLastEnd = i;
        OnSlideSelectListener onSlideSelectListener = this.mSelectListener;
        if (onSlideSelectListener == null || !(onSlideSelectListener instanceof OnAdvancedSlideSelectListener)) {
            return;
        }
        ((OnAdvancedSlideSelectListener) onSlideSelectListener).onSelectionStarted(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (!this.isActive || recyclerView.getAdapter() == null || recyclerView.getAdapter().getItemCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0 || action == 5) {
            reset();
        }
        this.mRecyclerView = recyclerView;
        int height = recyclerView.getHeight();
        int i = this.mTouchRegionTopOffset;
        this.mTopBoundFrom = i;
        int i2 = this.mAutoScrollDistance;
        this.mTopBoundTo = i + i2;
        int i3 = this.mTouchRegionBottomOffset;
        this.mBottomBoundFrom = (height + i3) - i2;
        this.mBottomBoundTo = height + i3;
        return true;
    }

    public void startAutoScroll() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return;
        }
        initScroller(recyclerView.getContext());
        if (this.mScroller.isFinished()) {
            this.mRecyclerView.removeCallbacks(this.mScrollRunnable);
            OverScroller overScroller = this.mScroller;
            overScroller.startScroll(0, overScroller.getCurrY(), 0, 5000, KSTubeParamInner.FREE_ALL);
            ViewCompat.postOnAnimation(this.mRecyclerView, this.mScrollRunnable);
        }
    }

    private void initScroller(Context context) {
        if (this.mScroller == null) {
            this.mScroller = new OverScroller(context, new LinearInterpolator());
        }
    }

    public void stopAutoScroll() {
        try {
            OverScroller overScroller = this.mScroller;
            if (overScroller == null || overScroller.isFinished()) {
                return;
            }
            this.mRecyclerView.removeCallbacks(this.mScrollRunnable);
            this.mScroller.abortAnimation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (!this.isActive) {
            reset();
            return;
        }
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                if (!this.mInTopSpot && !this.mInBottomSpot) {
                    changeSelectedRange(recyclerView, motionEvent);
                }
                processAutoScroll(motionEvent);
                return;
            }
            if (action != 3 && action != 6) {
                return;
            }
        }
        reset();
    }

    private void changeSelectedRange(RecyclerView recyclerView, MotionEvent motionEvent) {
        changeSelectedRange(recyclerView, motionEvent.getX(), motionEvent.getY());
    }

    private void changeSelectedRange(RecyclerView recyclerView, float f, float f2) {
        int childAdapterPosition;
        View viewFindChildViewUnder = recyclerView.findChildViewUnder(f, f2);
        if (viewFindChildViewUnder == null || (childAdapterPosition = recyclerView.getChildAdapterPosition(viewFindChildViewUnder) - this.mHeaderViewCount) == -1 || this.mEnd == childAdapterPosition) {
            return;
        }
        this.mEnd = childAdapterPosition;
        notifySelectRangeChange();
    }

    private void processAutoScroll(MotionEvent motionEvent) {
        int y = (int) motionEvent.getY();
        int i = this.mTopBoundFrom;
        if (y >= i && y <= this.mTopBoundTo) {
            this.mLastX = motionEvent.getX();
            this.mLastY = motionEvent.getY();
            int i2 = this.mTopBoundTo;
            int i3 = this.mTopBoundFrom;
            this.mScrollDistance = (int) (this.mMaxScrollDistance * (((i2 - i3) - (y - i3)) / (i2 - i3)) * (-1.0f));
            if (this.mInTopSpot) {
                return;
            }
            this.mInTopSpot = true;
            startAutoScroll();
            return;
        }
        if (this.mScrollAboveTopRegion && y < i) {
            this.mLastX = motionEvent.getX();
            this.mLastY = motionEvent.getY();
            this.mScrollDistance = this.mMaxScrollDistance * (-1);
            if (this.mInTopSpot) {
                return;
            }
            this.mInTopSpot = true;
            startAutoScroll();
            return;
        }
        if (y >= this.mBottomBoundFrom && y <= this.mBottomBoundTo) {
            this.mLastX = motionEvent.getX();
            this.mLastY = motionEvent.getY();
            float f = y;
            int i4 = this.mBottomBoundFrom;
            this.mScrollDistance = (int) (this.mMaxScrollDistance * ((f - i4) / (this.mBottomBoundTo - i4)));
            if (this.mInBottomSpot) {
                return;
            }
            this.mInBottomSpot = true;
            startAutoScroll();
            return;
        }
        if (this.mScrollBelowTopRegion && y > this.mBottomBoundTo) {
            this.mLastX = motionEvent.getX();
            this.mLastY = motionEvent.getY();
            this.mScrollDistance = this.mMaxScrollDistance;
            if (this.mInTopSpot) {
                return;
            }
            this.mInTopSpot = true;
            startAutoScroll();
            return;
        }
        this.mInBottomSpot = false;
        this.mInTopSpot = false;
        this.mLastX = Float.MIN_VALUE;
        this.mLastY = Float.MIN_VALUE;
        stopAutoScroll();
    }

    private void notifySelectRangeChange() {
        int i;
        int i2;
        if (this.mSelectListener == null || (i = this.mStart) == -1 || (i2 = this.mEnd) == -1) {
            return;
        }
        int iMin = Math.min(i, i2);
        int iMax = Math.max(this.mStart, this.mEnd);
        if (iMin < 0) {
            return;
        }
        int i3 = this.mLastStart;
        if (i3 != -1 && this.mLastEnd != -1) {
            if (iMin > i3) {
                this.mSelectListener.onSelectChange(i3, iMin - 1, false);
            } else if (iMin < i3) {
                this.mSelectListener.onSelectChange(iMin, i3 - 1, true);
            }
            int i4 = this.mLastEnd;
            if (iMax > i4) {
                this.mSelectListener.onSelectChange(i4 + 1, iMax, true);
            } else if (iMax < i4) {
                this.mSelectListener.onSelectChange(iMax + 1, i4, false);
            }
        } else if (iMax - iMin == 1) {
            this.mSelectListener.onSelectChange(iMin, iMin, true);
        } else {
            this.mSelectListener.onSelectChange(iMin, iMax, true);
        }
        this.mLastStart = iMin;
        this.mLastEnd = iMax;
    }

    private void reset() {
        setActive(false);
        OnSlideSelectListener onSlideSelectListener = this.mSelectListener;
        if (onSlideSelectListener != null && (onSlideSelectListener instanceof OnAdvancedSlideSelectListener)) {
            ((OnAdvancedSlideSelectListener) onSlideSelectListener).onSelectionFinished(this.mEnd);
        }
        this.mStart = -1;
        this.mEnd = -1;
        this.mLastStart = -1;
        this.mLastEnd = -1;
        this.mInTopSpot = false;
        this.mInBottomSpot = false;
        this.mLastX = Float.MIN_VALUE;
        this.mLastY = Float.MIN_VALUE;
        stopAutoScroll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollBy(int i) {
        int iMax;
        if (i > 0) {
            iMax = Math.min(i, this.mMaxScrollDistance);
        } else {
            iMax = Math.max(i, -this.mMaxScrollDistance);
        }
        this.mRecyclerView.scrollBy(0, iMax);
        float f = this.mLastX;
        if (f != Float.MIN_VALUE) {
            float f2 = this.mLastY;
            if (f2 != Float.MIN_VALUE) {
                changeSelectedRange(this.mRecyclerView, f, f2);
            }
        }
    }

    public void setActive(boolean z) {
        this.isActive = z;
    }
}

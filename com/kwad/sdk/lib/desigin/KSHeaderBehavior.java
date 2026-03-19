package com.kwad.sdk.lib.desigin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class KSHeaderBehavior<V extends View> extends KSViewOffsetBehavior<V> {
    private static final int INVALID_POINTER = -1;
    private int mActivePointerId;
    private Runnable mFlingRunnable;
    private boolean mIsBeingDragged;
    private int mLastMotionY;
    OverScroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    boolean canDragView(V v) {
        return false;
    }

    void onFlingFinished(KSCoordinatorLayout kSCoordinatorLayout, V v) {
    }

    public KSHeaderBehavior() {
        this.mActivePointerId = -1;
        this.mTouchSlop = -1;
    }

    public KSHeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.mTouchSlop = -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(com.kwad.sdk.lib.desigin.KSCoordinatorLayout r5, V r6, android.view.MotionEvent r7) {
        /*
            r4 = this;
            int r0 = r4.mTouchSlop
            if (r0 >= 0) goto L12
            android.content.Context r0 = r5.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r4.mTouchSlop = r0
        L12:
            int r0 = r7.getAction()
            r1 = 2
            r2 = 1
            if (r0 != r1) goto L1f
            boolean r0 = r4.mIsBeingDragged
            if (r0 == 0) goto L1f
            return r2
        L1f:
            int r0 = r7.getActionMasked()
            r3 = 0
            if (r0 == 0) goto L5e
            r5 = -1
            if (r0 == r2) goto L4f
            if (r0 == r1) goto L2f
            r6 = 3
            if (r0 == r6) goto L4f
            goto L81
        L2f:
            int r6 = r4.mActivePointerId
            if (r6 == r5) goto L81
            int r6 = r7.findPointerIndex(r6)
            if (r6 == r5) goto L81
            float r5 = r7.getY(r6)
            int r5 = (int) r5
            int r6 = r4.mLastMotionY
            int r6 = r5 - r6
            int r6 = java.lang.Math.abs(r6)
            int r0 = r4.mTouchSlop
            if (r6 <= r0) goto L81
            r4.mIsBeingDragged = r2
            r4.mLastMotionY = r5
            goto L81
        L4f:
            r4.mIsBeingDragged = r3
            r4.mActivePointerId = r5
            android.view.VelocityTracker r5 = r4.mVelocityTracker
            if (r5 == 0) goto L81
            r5.recycle()
            r5 = 0
            r4.mVelocityTracker = r5
            goto L81
        L5e:
            r4.mIsBeingDragged = r3
            float r0 = r7.getX()
            int r0 = (int) r0
            float r1 = r7.getY()
            int r1 = (int) r1
            boolean r2 = r4.canDragView(r6)
            if (r2 == 0) goto L81
            boolean r5 = r5.isPointInChildBounds(r6, r0, r1)
            if (r5 == 0) goto L81
            r4.mLastMotionY = r1
            int r5 = r7.getPointerId(r3)
            r4.mActivePointerId = r5
            r4.ensureVelocityTracker()
        L81:
            android.view.VelocityTracker r5 = r4.mVelocityTracker
            if (r5 == 0) goto L88
            r5.addMovement(r7)
        L88:
            boolean r5 = r4.mIsBeingDragged
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.lib.desigin.KSHeaderBehavior.onInterceptTouchEvent(com.kwad.sdk.lib.desigin.KSCoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public boolean onTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.mTouchSlop < 0) {
            this.mTouchSlop = ViewConfiguration.get(kSCoordinatorLayout.getContext()).getScaledTouchSlop();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (!kSCoordinatorLayout.isPointInChildBounds(v, x, y) || !canDragView(v)) {
                return false;
            }
            this.mLastMotionY = y;
            this.mActivePointerId = motionEvent.getPointerId(0);
            ensureVelocityTracker();
        } else {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    fling(kSCoordinatorLayout, v, -getScrollRangeForDragFling(v), 0, this.mVelocityTracker.getYVelocity(this.mActivePointerId));
                }
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (iFindPointerIndex == -1) {
                    return false;
                }
                int y2 = (int) motionEvent.getY(iFindPointerIndex);
                int i = this.mLastMotionY - y2;
                if (!this.mIsBeingDragged) {
                    int iAbs = Math.abs(i);
                    int i2 = this.mTouchSlop;
                    if (iAbs > i2) {
                        this.mIsBeingDragged = true;
                        i = i > 0 ? i - i2 : i + i2;
                    }
                }
                int i3 = i;
                if (this.mIsBeingDragged) {
                    this.mLastMotionY = y2;
                    scroll(kSCoordinatorLayout, v, i3, getMaxDragOffset(v), 0);
                }
            } else if (actionMasked == 3) {
            }
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            VelocityTracker velocityTracker2 = this.mVelocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.mVelocityTracker = null;
            }
        }
        VelocityTracker velocityTracker3 = this.mVelocityTracker;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
        }
        return true;
    }

    public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, V v, int i) {
        return setHeaderTopBottomOffset(kSCoordinatorLayout, v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, V v, int i, int i2, int i3) {
        int iClamp;
        int topAndBottomOffset = getTopAndBottomOffset();
        if (i2 == 0 || topAndBottomOffset < i2 || topAndBottomOffset > i3 || topAndBottomOffset == (iClamp = MathUtils.clamp(i, i2, i3))) {
            return 0;
        }
        setTopAndBottomOffset(iClamp);
        return topAndBottomOffset - iClamp;
    }

    int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset();
    }

    public final int scroll(KSCoordinatorLayout kSCoordinatorLayout, V v, int i, int i2, int i3) {
        return setHeaderTopBottomOffset(kSCoordinatorLayout, v, getTopBottomOffsetForScrollingSibling() - i, i2, i3);
    }

    final boolean fling(KSCoordinatorLayout kSCoordinatorLayout, V v, int i, int i2, float f) {
        Runnable runnable = this.mFlingRunnable;
        if (runnable != null) {
            v.removeCallbacks(runnable);
            this.mFlingRunnable = null;
        }
        if (this.mScroller == null) {
            this.mScroller = new OverScroller(v.getContext());
        }
        this.mScroller.fling(0, getTopAndBottomOffset(), 0, Math.round(f), 0, 0, i, i2);
        if (this.mScroller.computeScrollOffset()) {
            FlingRunnable flingRunnable = new FlingRunnable(kSCoordinatorLayout, v);
            this.mFlingRunnable = flingRunnable;
            ViewCompat.postOnAnimation(v, flingRunnable);
            return true;
        }
        onFlingFinished(kSCoordinatorLayout, v);
        return false;
    }

    public int getMaxDragOffset(V v) {
        return -v.getHeight();
    }

    int getScrollRangeForDragFling(V v) {
        return v.getHeight();
    }

    private void ensureVelocityTracker() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    class FlingRunnable implements Runnable {
        private final V mLayout;
        private final KSCoordinatorLayout mParent;

        FlingRunnable(KSCoordinatorLayout kSCoordinatorLayout, V v) {
            this.mParent = kSCoordinatorLayout;
            this.mLayout = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mLayout == null || KSHeaderBehavior.this.mScroller == null) {
                return;
            }
            if (KSHeaderBehavior.this.mScroller.computeScrollOffset()) {
                KSHeaderBehavior kSHeaderBehavior = KSHeaderBehavior.this;
                kSHeaderBehavior.setHeaderTopBottomOffset(this.mParent, this.mLayout, kSHeaderBehavior.mScroller.getCurrY());
                ViewCompat.postOnAnimation(this.mLayout, this);
                return;
            }
            KSHeaderBehavior.this.onFlingFinished(this.mParent, this.mLayout);
        }
    }
}

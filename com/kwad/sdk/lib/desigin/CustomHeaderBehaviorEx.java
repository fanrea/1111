package com.kwad.sdk.lib.desigin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;
import com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer;
import com.kwad.sdk.lib.desigin.KSAppBarLayout;
import com.kwad.sdk.lib.desigin.KSAppBarLayout.KSBehavior;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class CustomHeaderBehaviorEx<V extends KSAppBarLayout, B extends KSAppBarLayout.KSBehavior & CustomAppBarFlingConsumer> extends KSViewOffsetBehavior<V> {
    private static final int FLING_MAX_VELOCITY = 10000;
    private static final int INVALID_POINTER = -1;
    private static final String TAG = CustomHeaderBehaviorEx.class.toString();
    private int mActivePointerId;
    private B mBehavior;
    private boolean mEnabled;
    private int mExtraFixedSize;
    private Runnable mFlingRunnable;
    private boolean mIsBeingDragged;
    private int mLastMotionY;
    private OverScroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    public CustomHeaderBehaviorEx(B b) {
        this.mActivePointerId = -1;
        this.mTouchSlop = -1;
        this.mBehavior = b;
    }

    public CustomHeaderBehaviorEx(Context context, AttributeSet attributeSet, B b) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.mTouchSlop = -1;
        this.mBehavior = b;
    }

    public final boolean isEnabled() {
        return this.mEnabled;
    }

    public final void setEnabled(boolean z) {
        this.mEnabled = z;
    }

    public final void setExtraFixedSize(int i) {
        this.mExtraFixedSize = i;
    }

    public final void stopFling() {
        OverScroller overScroller;
        if (this.mFlingRunnable == null || (overScroller = this.mScroller) == null || !overScroller.computeScrollOffset()) {
            return;
        }
        this.mScroller.abortAnimation();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0059  */
    @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onInterceptTouchEvent(com.kwad.sdk.lib.desigin.KSCoordinatorLayout r7, V r8, android.view.MotionEvent r9) {
        /*
            r6 = this;
            int r0 = r6.mTouchSlop
            if (r0 >= 0) goto L12
            android.content.Context r0 = r7.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r6.mTouchSlop = r0
        L12:
            int r0 = r9.getAction()
            r1 = 2
            r2 = 1
            if (r0 != r1) goto L1f
            boolean r0 = r6.mIsBeingDragged
            if (r0 == 0) goto L1f
            return r2
        L1f:
            float r0 = r9.getX()
            int r0 = (int) r0
            float r3 = r9.getY()
            int r3 = (int) r3
            int r4 = r9.getActionMasked()
            r5 = 0
            if (r4 == 0) goto L68
            r7 = -1
            if (r4 == r2) goto L59
            if (r4 == r1) goto L39
            r8 = 3
            if (r4 == r8) goto L59
            goto L8d
        L39:
            int r8 = r6.mActivePointerId
            if (r8 == r7) goto L8d
            int r8 = r9.findPointerIndex(r8)
            if (r8 == r7) goto L8d
            float r7 = r9.getY(r8)
            int r7 = (int) r7
            int r8 = r6.mLastMotionY
            int r8 = r7 - r8
            int r8 = java.lang.Math.abs(r8)
            int r0 = r6.mTouchSlop
            if (r8 <= r0) goto L8d
            r6.mIsBeingDragged = r2
            r6.mLastMotionY = r7
            goto L8d
        L59:
            r6.mIsBeingDragged = r5
            r6.mActivePointerId = r7
            android.view.VelocityTracker r7 = r6.mVelocityTracker
            if (r7 == 0) goto L8d
            r7.recycle()
            r7 = 0
            r6.mVelocityTracker = r7
            goto L8d
        L68:
            r6.mIsBeingDragged = r5
            r6.stopFling()
            B extends com.kwad.sdk.lib.desigin.KSAppBarLayout$KSBehavior & com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer r1 = r6.mBehavior
            boolean r1 = r1.canDragView(r8)
            if (r1 == 0) goto L8d
            boolean r7 = r7.isPointInChildBounds(r8, r0, r3)
            if (r7 == 0) goto L8d
            r6.mLastMotionY = r3
            int r7 = r9.getPointerId(r5)
            r6.mActivePointerId = r7
            r6.ensureVelocityTracker()
            B extends com.kwad.sdk.lib.desigin.KSAppBarLayout$KSBehavior & com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer r7 = r6.mBehavior
            com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer r7 = (com.kwad.sdk.lib.desigin.CustomAppBarFlingConsumer) r7
            r7.onAppBarTouchDown()
        L8d:
            android.view.VelocityTracker r7 = r6.mVelocityTracker
            if (r7 == 0) goto L94
            r7.addMovement(r9)
        L94:
            boolean r7 = r6.mIsBeingDragged
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.lib.desigin.CustomHeaderBehaviorEx.onInterceptTouchEvent(com.kwad.sdk.lib.desigin.KSCoordinatorLayout, com.kwad.sdk.lib.desigin.KSAppBarLayout, android.view.MotionEvent):boolean");
    }

    @Override // com.kwad.sdk.lib.desigin.KSCoordinatorLayout.Behavior
    public final boolean onTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.mTouchSlop < 0) {
            this.mTouchSlop = ViewConfiguration.get(kSCoordinatorLayout.getContext()).getScaledTouchSlop();
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            if (!kSCoordinatorLayout.isPointInChildBounds(v, x, y) || !this.mBehavior.canDragView(v)) {
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
                    float yVelocity = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
                    fling(kSCoordinatorLayout, v, yVelocity < 0.0f ? -10000 : 0, yVelocity < 0.0f ? 0 : -v.getTop(), yVelocity);
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
                    B b = this.mBehavior;
                    b.scroll(kSCoordinatorLayout, v, i3, b.getMaxDragOffset(v), 0);
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

    private boolean fling(KSCoordinatorLayout kSCoordinatorLayout, V v, int i, int i2, float f) {
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
            FlingRunnable flingRunnable = new FlingRunnable(kSCoordinatorLayout, v, this.mScroller.getCurrY());
            this.mFlingRunnable = flingRunnable;
            ViewCompat.postOnAnimation(v, flingRunnable);
            return true;
        }
        this.mBehavior.onFlingFinished(kSCoordinatorLayout, v);
        return false;
    }

    private void ensureVelocityTracker() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    class FlingRunnable implements Runnable {
        private int mLastScrollY;
        private final V mLayout;
        private final KSCoordinatorLayout mParent;

        FlingRunnable(KSCoordinatorLayout kSCoordinatorLayout, V v, int i) {
            this.mParent = kSCoordinatorLayout;
            this.mLayout = v;
            this.mLastScrollY = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mLayout == null || CustomHeaderBehaviorEx.this.mScroller == null) {
                return;
            }
            if (CustomHeaderBehaviorEx.this.mScroller.computeScrollOffset()) {
                int currY = CustomHeaderBehaviorEx.this.mScroller.getCurrY();
                int i = currY - this.mLastScrollY;
                int bottom = this.mLayout.getBottom();
                int measuredHeight = (this.mLayout.getMeasuredHeight() - this.mLayout.getTotalScrollRange()) + CustomHeaderBehaviorEx.this.mExtraFixedSize;
                if (bottom == measuredHeight) {
                    ((CustomAppBarFlingConsumer) CustomHeaderBehaviorEx.this.mBehavior).consumeAppBarFling(0, -i);
                } else if (bottom <= 0 || bottom + i >= measuredHeight) {
                    KSAppBarLayout.KSBehavior kSBehavior = CustomHeaderBehaviorEx.this.mBehavior;
                    KSCoordinatorLayout kSCoordinatorLayout = this.mParent;
                    V v = this.mLayout;
                    kSBehavior.setHeaderTopBottomOffset(kSCoordinatorLayout, v, v.getTop() + i);
                } else {
                    KSAppBarLayout.KSBehavior kSBehavior2 = CustomHeaderBehaviorEx.this.mBehavior;
                    KSCoordinatorLayout kSCoordinatorLayout2 = this.mParent;
                    V v2 = this.mLayout;
                    kSBehavior2.setHeaderTopBottomOffset(kSCoordinatorLayout2, v2, (v2.getTop() - bottom) + measuredHeight);
                }
                ViewCompat.postOnAnimation(this.mLayout, this);
                this.mLastScrollY = currY;
                return;
            }
            CustomHeaderBehaviorEx.this.mBehavior.onFlingFinished(this.mParent, (KSAppBarLayout) this.mLayout);
        }
    }
}

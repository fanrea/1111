package com.bytedance.sdk.djx.core.business.view.scroll;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.pangle.cn.pangrowth.base.R;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXTabPinnedLayout extends LinearLayout implements NestedScrollingChild, NestedScrollingParent {
    private static final int INVALID_POINTER = -1;
    private int activePointerId;
    private int ceilingChildIndex;
    private int ceilingHeight;
    private CeilingListener ceilingListener;
    private int ceilingOffset;
    private NestedScrollingChildHelper childHelper;
    private boolean isBeingDragged;
    private int lastScrollerY;
    private int lastTouchY;
    private float maximumFlingVelocity;
    private float minimumFlingVelocity;
    private NestedScroller nestedScroller;
    private View nestedTarget;
    private int nestedYOffset;
    private NestedScrollingParentHelper parentHelper;
    private final int[] scrollConsumed;
    private ScrollListener scrollListener;
    private final int[] scrollOffset;
    private int scrollRange;
    private OverScroller scroller;
    private int touchSlop;
    private VelocityTracker velocityTracker;

    public interface CeilingListener {
        void scroll(boolean z, float f);
    }

    public interface ScrollListener {
        void onScroll(int i);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return i == 2;
    }

    public DJXTabPinnedLayout(Context context) {
        this(context, null);
    }

    public DJXTabPinnedLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DJXTabPinnedLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.scrollOffset = new int[2];
        this.scrollConsumed = new int[2];
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DJXTabPinnedLayout);
        this.ceilingChildIndex = typedArrayObtainStyledAttributes.getInt(R.styleable.DJXTabPinnedLayout_djx_pinnedChildIndex, -1);
        typedArrayObtainStyledAttributes.recycle();
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        this.parentHelper = new NestedScrollingParentHelper(this);
        this.childHelper = new NestedScrollingChildHelper(this);
        this.nestedScroller = new NestedScroller(context);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.minimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.maximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.touchSlop = viewConfiguration.getScaledTouchSlop();
        this.scroller = new OverScroller(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof NestedScrollingParent) {
                setNestedScrollingEnabled(true);
                return;
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int size = View.MeasureSpec.getSize(i2);
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, 1073741824));
        int measuredWidth = getMeasuredWidth();
        int childCount = getChildCount();
        int i4 = this.ceilingChildIndex;
        if (i4 < 0 || i4 >= childCount) {
            throw new IllegalStateException("吸顶子View位置索引错误,DJXTabPinnedLayout没有索引为" + this.ceilingChildIndex + "的子View");
        }
        if (i4 == 0) {
            throw new IllegalStateException("吸顶子View位置索引不能为0,最顶层子View吸顶无任何意义");
        }
        if (i4 + 2 == childCount) {
            int i5 = 0;
            this.ceilingHeight = 0;
            while (true) {
                i3 = this.ceilingChildIndex;
                if (i5 >= i3) {
                    break;
                }
                View childAt = getChildAt(i5);
                if (childAt.getVisibility() != 8) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                    this.ceilingHeight += childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
                }
                i5++;
            }
            int i6 = this.ceilingHeight - this.ceilingOffset;
            this.scrollRange = i6;
            if (i6 < 0) {
                throw new IllegalStateException("DJXTabPinnedLayout偏移高度不能大于吸顶高度");
            }
            View childAt2 = getChildAt(i3);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) childAt2.getLayoutParams();
            setMeasuredDimension(measuredWidth, Math.max(this.ceilingHeight + childAt2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin, size));
            getChildAt(this.ceilingChildIndex + 1).measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec((((getMeasuredHeight() - childAt2.getMeasuredHeight()) - layoutParams2.topMargin) - layoutParams2.bottomMargin) - this.ceilingOffset, 1073741824));
            return;
        }
        throw new IllegalStateException("在DJXTabPinnedLayout里,吸顶子View下面只能配置一个子View");
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        CeilingListener ceilingListener = this.ceilingListener;
        if (ceilingListener != null && this.ceilingChildIndex != -1) {
            int i5 = this.scrollRange;
            if (i2 == i5) {
                ceilingListener.scroll(true, 1.0f);
            } else {
                ceilingListener.scroll(false, i2 / i5);
            }
        }
        ScrollListener scrollListener = this.scrollListener;
        if (scrollListener != null) {
            scrollListener.onScroll(i2);
        }
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return getMeasuredHeight() + this.scrollRange;
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.nestedScroller.computeScrollOffset()) {
            int currY = this.nestedScroller.getCurrY();
            int scrollFinal = this.nestedScroller.getScrollFinal();
            int scrollSelf = this.nestedScroller.getScrollSelf();
            boolean zIsUpScroll = this.nestedScroller.isUpScroll();
            if (zIsUpScroll && currY >= scrollSelf) {
                scrollTo(0, Math.min(currY, scrollFinal));
            } else if (!zIsUpScroll && currY <= scrollSelf) {
                scrollTo(0, Math.max(currY, scrollFinal));
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
        if (this.scroller.computeScrollOffset()) {
            int currY2 = this.scroller.getCurrY();
            int i = currY2 - this.lastScrollerY;
            if (i != 0) {
                int scrollY = getScrollY();
                overScroll(i, scrollY, this.scrollRange);
                int scrollY2 = getScrollY() - scrollY;
                dispatchNestedScroll(0, scrollY2, 0, i - scrollY2, null);
            }
            this.lastScrollerY = currY2;
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }
        if (hasNestedScrollingParent()) {
            stopNestedScroll();
        }
        this.lastScrollerY = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x007e  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            r1 = 2
            r2 = 1
            if (r0 != r1) goto Ld
            boolean r3 = r6.isBeingDragged
            if (r3 == 0) goto Ld
            return r2
        Ld:
            r3 = 0
            if (r0 == 0) goto L89
            r4 = -1
            if (r0 == r2) goto L7e
            if (r0 == r1) goto L42
            r1 = 3
            if (r0 == r1) goto L7e
            r1 = 6
            if (r0 == r1) goto L1d
            goto Laf
        L1d:
            int r0 = r7.getActionIndex()
            int r1 = r7.getPointerId(r0)
            int r4 = r6.activePointerId
            if (r1 != r4) goto Laf
            if (r0 != 0) goto L2c
            goto L2d
        L2c:
            r2 = r3
        L2d:
            float r0 = r7.getY(r2)
            int r0 = (int) r0
            r6.lastTouchY = r0
            int r7 = r7.getPointerId(r2)
            r6.activePointerId = r7
            android.view.VelocityTracker r7 = r6.velocityTracker
            if (r7 == 0) goto Laf
            r7.clear()
            goto Laf
        L42:
            int r0 = r6.activePointerId
            if (r0 != r4) goto L47
            goto Laf
        L47:
            int r0 = r7.findPointerIndex(r0)
            if (r0 != r4) goto L4e
            goto Laf
        L4e:
            float r0 = r7.getY(r0)
            int r0 = (int) r0
            int r4 = r6.lastTouchY
            int r4 = r0 - r4
            int r4 = java.lang.Math.abs(r4)
            int r5 = r6.touchSlop
            if (r4 <= r5) goto Laf
            int r4 = r6.getNestedScrollAxes()
            r1 = r1 & r4
            if (r1 != 0) goto Laf
            r6.isBeingDragged = r2
            r6.lastTouchY = r0
            r6.initVelocityTrackerIfNotExists()
            android.view.VelocityTracker r0 = r6.velocityTracker
            r0.addMovement(r7)
            r6.nestedYOffset = r3
            android.view.ViewParent r7 = r6.getParent()
            if (r7 == 0) goto Laf
            r7.requestDisallowInterceptTouchEvent(r2)
            goto Laf
        L7e:
            r6.isBeingDragged = r3
            r6.activePointerId = r4
            r6.recycleVelocityTracker()
            r6.stopNestedScroll()
            goto Laf
        L89:
            float r0 = r7.getY()
            int r0 = (int) r0
            r6.lastTouchY = r0
            int r0 = r7.getPointerId(r3)
            r6.activePointerId = r0
            r6.initOrResetVelocityTracker()
            android.view.VelocityTracker r0 = r6.velocityTracker
            r0.addMovement(r7)
            android.widget.OverScroller r7 = r6.scroller
            r7.computeScrollOffset()
            android.widget.OverScroller r7 = r6.scroller
            boolean r7 = r7.isFinished()
            r7 = r7 ^ r2
            r6.isBeingDragged = r7
            r6.startNestedScroll(r1)
        Laf:
            boolean r7 = r6.isBeingDragged
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.djx.core.business.view.scroll.DJXTabPinnedLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        initVelocityTrackerIfNotExists();
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.nestedYOffset = 0;
        }
        motionEventObtain.offsetLocation(0.0f, this.nestedYOffset);
        if (actionMasked == 0) {
            boolean z = !this.scroller.isFinished();
            this.isBeingDragged = z;
            if (z && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.scroller.isFinished()) {
                this.scroller.abortAnimation();
            }
            this.lastTouchY = (int) motionEvent.getY();
            this.activePointerId = motionEvent.getPointerId(0);
            startNestedScroll(2);
        } else if (actionMasked == 1) {
            this.velocityTracker.computeCurrentVelocity(1000, this.maximumFlingVelocity);
            int yVelocity = (int) this.velocityTracker.getYVelocity(this.activePointerId);
            if (Math.abs(yVelocity) > this.minimumFlingVelocity) {
                flingWithNestedDispatch(-yVelocity);
            }
            this.activePointerId = -1;
            this.isBeingDragged = false;
            recycleVelocityTracker();
            stopNestedScroll();
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.activePointerId);
            if (iFindPointerIndex != -1) {
                int y = (int) motionEvent.getY(iFindPointerIndex);
                int i = this.lastTouchY - y;
                if (dispatchNestedPreScroll(0, i, this.scrollConsumed, this.scrollOffset)) {
                    i -= this.scrollConsumed[1];
                    motionEventObtain.offsetLocation(0.0f, this.scrollOffset[1]);
                    this.nestedYOffset += this.scrollOffset[1];
                }
                if (!this.isBeingDragged && Math.abs(i) > this.touchSlop) {
                    ViewParent parent2 = getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(true);
                    }
                    this.isBeingDragged = true;
                    if (i > 0) {
                        i -= this.touchSlop;
                    } else {
                        i += this.touchSlop;
                    }
                }
                if (this.isBeingDragged) {
                    this.lastTouchY = y - this.scrollOffset[1];
                    int scrollY = getScrollY();
                    if (overScroll(i, getScrollY(), this.scrollRange) && !hasNestedScrollingParent()) {
                        this.velocityTracker.clear();
                    }
                    int scrollY2 = getScrollY() - scrollY;
                    if (dispatchNestedScroll(0, scrollY2, 0, i - scrollY2, this.scrollOffset)) {
                        int i2 = this.lastTouchY;
                        int i3 = this.scrollOffset[1];
                        this.lastTouchY = i2 - i3;
                        motionEventObtain.offsetLocation(0.0f, i3);
                        this.nestedYOffset += this.scrollOffset[1];
                    }
                }
            }
        } else if (actionMasked == 3) {
            this.activePointerId = -1;
            this.isBeingDragged = false;
            recycleVelocityTracker();
            stopNestedScroll();
        } else if (actionMasked == 5) {
            int actionIndex = motionEvent.getActionIndex();
            this.lastTouchY = (int) motionEvent.getY(actionIndex);
            this.activePointerId = motionEvent.getPointerId(actionIndex);
        } else if (actionMasked == 6) {
            int actionIndex2 = motionEvent.getActionIndex();
            if (motionEvent.getPointerId(actionIndex2) == this.activePointerId) {
                int i4 = actionIndex2 == 0 ? 1 : 0;
                this.lastTouchY = (int) motionEvent.getY(i4);
                this.activePointerId = motionEvent.getPointerId(i4);
                VelocityTracker velocityTracker = this.velocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
            }
            this.lastTouchY = (int) motionEvent.getY(motionEvent.findPointerIndex(this.activePointerId));
        }
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    private void flingWithNestedDispatch(int i) {
        boolean z = (getScrollY() > 0 || i > 0) && i < 0;
        float f = i;
        if (dispatchNestedPreFling(0.0f, f)) {
            return;
        }
        dispatchNestedFling(0.0f, f, z);
        fling(i);
    }

    private void fling(int i) {
        startNestedScroll(2);
        this.scroller.fling(0, getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
        this.lastScrollerY = getScrollY();
        ViewCompat.postInvalidateOnAnimation(this);
    }

    private boolean overScroll(int i, int i2, int i3) {
        int i4 = i + i2;
        boolean z = true;
        if (i4 <= i3) {
            if (i4 < 0) {
                i3 = 0;
            } else {
                i3 = i4;
                z = false;
            }
        }
        scrollTo(0, i3);
        return z;
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.velocityTracker = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.nestedScroller.forceFinished(true);
            this.scroller.forceFinished(true);
            ViewCompat.postInvalidateOnAnimation(this);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.childHelper.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.childHelper.isNestedScrollingEnabled();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.childHelper.startNestedScroll(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.childHelper.stopNestedScroll();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.childHelper.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.childHelper.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.childHelper.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.childHelper.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.childHelper.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.parentHelper.getNestedScrollAxes();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.parentHelper.onNestedScrollAccepted(view, view2, i);
        this.childHelper.startNestedScroll(i);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        this.parentHelper.onStopNestedScroll(view);
        this.childHelper.stopNestedScroll();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.childHelper.dispatchNestedScroll(i, i2, i3, i4, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0 && getScrollY() < this.scrollRange) {
            int scrollY = getScrollY() + i2;
            int i3 = this.scrollRange;
            if (scrollY > i3) {
                i2 = i3 - getScrollY();
            }
            scrollBy(0, i2);
            iArr[1] = i2;
        } else if (i2 < 0 && getScrollY() > 0 && (view instanceof NestedScrollingChild) && getVerticalScrollOffset(view) <= 0) {
            if (getScrollY() + i2 < 0) {
                i2 = -getScrollY();
            }
            scrollBy(0, i2);
            iArr[1] = i2;
        }
        this.childHelper.dispatchNestedPreScroll(i, i2, iArr, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return this.childHelper.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        if (scrollSelfIsConsumed(view, f2)) {
            return true;
        }
        return this.childHelper.dispatchNestedPreFling(f, f2);
    }

    private boolean scrollSelfIsConsumed(View view, float f) {
        if (Math.abs(f) < this.minimumFlingVelocity) {
            return false;
        }
        float fAbs = Math.abs(f);
        float f2 = this.maximumFlingVelocity;
        if (fAbs > f2) {
            f = f > 0.0f ? f2 : -f2;
        }
        int i = (int) f;
        int verticalScrollOffset = getVerticalScrollOffset(view);
        int iComputeVerticalScrollOffset = computeVerticalScrollOffset();
        int i2 = this.scrollRange;
        int i3 = i2 - iComputeVerticalScrollOffset;
        if ((i <= 0 || i3 <= 0) && (i >= 0 || i3 >= i2)) {
            return false;
        }
        this.nestedScroller.fling(i, verticalScrollOffset, iComputeVerticalScrollOffset, i2);
        ViewCompat.postInvalidateOnAnimation(this);
        return this.nestedScroller.isUpScroll() && this.nestedScroller.getFinalY() <= this.nestedScroller.getScrollFinal();
    }

    private int getVerticalScrollOffset(View view) {
        View view2 = this.nestedTarget;
        if (view2 == null) {
            View nestedTarget = getNestedTarget(view);
            this.nestedTarget = nestedTarget;
            if (nestedTarget != null) {
                nestedTarget.setTag(view);
            }
        } else if (!((View) view2.getTag()).equals(view)) {
            View nestedTarget2 = getNestedTarget(view);
            this.nestedTarget = nestedTarget2;
            if (nestedTarget2 != null) {
                nestedTarget2.setTag(view);
            }
        }
        View view3 = this.nestedTarget;
        if (view3 == null) {
            return 0;
        }
        int scrollY = view3.getScrollY();
        View view4 = this.nestedTarget;
        return view4 instanceof RecyclerView ? ((RecyclerView) view4).computeVerticalScrollOffset() : scrollY;
    }

    private View getNestedTarget(View view) {
        if (view instanceof NestedScrollingChild) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View nestedTarget = getNestedTarget(viewGroup.getChildAt(i));
            if (nestedTarget != null) {
                return nestedTarget;
            }
        }
        return null;
    }

    public void setCeilingOffset(int i) {
        this.ceilingOffset = i;
        requestLayout();
    }

    public void setCeilingChildIndex(int i) {
        this.ceilingChildIndex = i;
        requestLayout();
    }

    public void setCeilingListener(CeilingListener ceilingListener) {
        this.ceilingListener = ceilingListener;
    }

    public void setScrollListener(ScrollListener scrollListener) {
        this.scrollListener = scrollListener;
    }

    public static class NestedScroller extends OverScroller {
        private boolean isUpScroll;
        private int scrollFinal;
        private int scrollSelf;

        public NestedScroller(Context context) {
            super(context);
        }

        public void fling(int i, int i2, int i3, int i4) {
            if (i > 0) {
                this.scrollSelf = 0;
                this.scrollFinal = i4;
                this.isUpScroll = true;
                fling(0, i3, 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
                return;
            }
            this.scrollSelf = i3;
            this.scrollFinal = 0;
            this.isUpScroll = false;
            fling(0, i2 + i3, 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        public int getScrollSelf() {
            return this.scrollSelf;
        }

        public int getScrollFinal() {
            return this.scrollFinal;
        }

        public boolean isUpScroll() {
            return this.isUpScroll;
        }
    }
}

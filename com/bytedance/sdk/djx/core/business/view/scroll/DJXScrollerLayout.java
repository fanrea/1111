package com.bytedance.sdk.djx.core.business.view.scroll;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.pangle.cn.pangrowth.base.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXScrollerLayout extends ViewGroup implements NestedScrollingChild2, NestedScrollingParent2, ScrollingView {
    private static final int SCROLL_HORIZONTAL = 2;
    private static final int SCROLL_NONE = 0;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final int SCROLL_VERTICAL = 1;
    static final Interpolator sQuinticInterpolator = new Interpolator() { // from class: com.bytedance.sdk.djx.core.business.view.scroll.DJXScrollerLayout.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private int SCROLL_ORIENTATION;
    private boolean isBrake;
    private boolean isPermanent;
    private boolean isTouchNotTriggerScrollStick;
    private int mActivePointerId;
    private int mAdjust;
    private int mAdjustHeightOffset;
    private VelocityTracker mAdjustVelocityTracker;
    private boolean mAutoAdjustHeightAtBottomView;
    private final NestedScrollingChildHelper mChildHelper;
    private View mCurrentStickyView;
    private final List<View> mCurrentStickyViews;
    private final int[] mDownLocation;
    private EdgeEffect mEdgeGlowBottom;
    private EdgeEffect mEdgeGlowTop;
    private int mEventX;
    private int mEventY;
    private float mFixedY;
    private int mLastScrollerY;
    private final int mMaximumVelocity;
    private final int mMinimumVelocity;
    private int mNestedYOffset;
    private int mOldScrollY;
    private OnPermanentStickyChangeListener mOnPermanentStickyChangeListener;
    protected OnScrollChangeListener mOnScrollChangeListener;
    private OnStickyChangeListener mOnStickyChangeListener;
    private final NestedScrollingParentHelper mParentHelper;
    private final int[] mScrollConsumed;
    private final int[] mScrollOffset;
    int mScrollRange;
    private int mScrollState;
    private int mScrollToIndex;
    private int mScrollToIndexWithOffset;
    private View mScrollToTopView;
    private final OverScroller mScroller;
    private int mSecondScrollY;
    private int mSmoothScrollOffset;
    private int mStickyOffset;
    private final List<View> mTempStickyViews;
    private final int mTouchSlop;
    private int mTouchY;
    private boolean mTouching;
    private VelocityTracker mVelocityTracker;
    private final List<View> mViews;

    public interface OnPermanentStickyChangeListener {
        void onStickyChange(List<View> list);
    }

    public interface OnScrollChangeListener {
        void onScrollChange(View view, int i, int i2, int i3);
    }

    public interface OnStickyChangeListener {
        void onStickyChange(View view, View view2);
    }

    @Override // android.view.View
    @Deprecated
    public void setOnScrollChangeListener(View.OnScrollChangeListener onScrollChangeListener) {
    }

    public DJXScrollerLayout(Context context) {
        this(context, null);
    }

    public DJXScrollerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DJXScrollerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDownLocation = new int[2];
        this.mTouching = false;
        this.SCROLL_ORIENTATION = 0;
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        this.mScrollToIndex = -1;
        this.mSmoothScrollOffset = 0;
        this.mScrollToIndexWithOffset = 0;
        this.mAdjustHeightOffset = 0;
        this.mStickyOffset = 0;
        this.mCurrentStickyViews = new ArrayList();
        this.mTempStickyViews = new ArrayList();
        this.mOldScrollY = 0;
        this.mViews = new ArrayList();
        this.mNestedYOffset = 0;
        this.mScrollState = 0;
        this.isTouchNotTriggerScrollStick = false;
        this.isBrake = false;
        TypedArray typedArrayObtainStyledAttributes = null;
        try {
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DJXScrollerLayout);
            this.isPermanent = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DJXScrollerLayout_djx_isPermanent, false);
            this.mStickyOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.DJXScrollerLayout_djx_stickyOffset, 0);
            this.mAutoAdjustHeightAtBottomView = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DJXScrollerLayout_djx_autoAdjustHeightAtBottomView, false);
            this.mAdjustHeightOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.DJXScrollerLayout_djx_adjustHeightOffset, 0);
        } catch (Throwable unused) {
            if (typedArrayObtainStyledAttributes != null) {
            }
        }
        if (typedArrayObtainStyledAttributes != null) {
            typedArrayObtainStyledAttributes.recycle();
        }
        this.mScroller = new OverScroller(getContext(), sQuinticInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mTouchSlop = ViewConfiguration.getTouchSlop();
        setWillNotDraw(false);
        setVerticalScrollBarEnabled(true);
        this.mParentHelper = new NestedScrollingParentHelper(this);
        this.mChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        setChildrenDrawingOrderEnabled(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        List<View> scrolledViews;
        if (layoutParams instanceof LayoutParams) {
            LayoutParamsUtils.invalidTopAndBottomMargin((LayoutParams) layoutParams);
        }
        super.addView(view, i, layoutParams);
        if (ScrollUtils.isConsecutiveScrollerChild(view)) {
            View scrollChild = ScrollUtils.getScrollChild(view);
            disableChildScroll(scrollChild);
            if ((scrollChild instanceof IScroller) && (scrolledViews = ((IScroller) scrollChild).getScrolledViews()) != null && !scrolledViews.isEmpty()) {
                int size = scrolledViews.size();
                for (int i2 = 0; i2 < size; i2++) {
                    disableChildScroll(scrolledViews.get(i2));
                }
            }
        }
        if (view instanceof ViewGroup) {
            ((ViewGroup) view).setClipToPadding(false);
        }
    }

    private void disableChildScroll(View view) {
        view.setVerticalScrollBarEnabled(false);
        view.setHorizontalScrollBarEnabled(false);
        view.setOverScrollMode(2);
        ViewCompat.setNestedScrollingEnabled(view, false);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        resetScrollToTopView();
        List<View> nonGoneChildren = getNonGoneChildren();
        int size = nonGoneChildren.size();
        int iMax = 0;
        int measuredHeight = 0;
        for (int i3 = 0; i3 < size; i3++) {
            View view = nonGoneChildren.get(i3);
            measureChildWithMargins(view, i, 0, i2, getAdjustHeightForChild(view));
            iMax = Math.max(iMax, getContentWidth(view));
            measuredHeight += view.getMeasuredHeight();
        }
        setMeasuredDimension(measureSize(i, iMax + getPaddingLeft() + getPaddingRight()), measureSize(i2, measuredHeight + getPaddingTop() + getPaddingBottom()));
    }

    private int getAdjustHeightForChild(View view) {
        try {
            if (this.mAutoAdjustHeightAtBottomView && view == getChildAt(getChildCount() - 1)) {
                return getAdjustHeight();
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    private int getAdjustHeight() {
        List<View> stickyChildren = getStickyChildren();
        int measuredHeight = this.mAdjustHeightOffset;
        int size = stickyChildren.size();
        if (this.isPermanent) {
            for (int i = 0; i < size; i++) {
                View view = stickyChildren.get(i);
                if (!isSink(view)) {
                    measuredHeight += view.getMeasuredHeight();
                }
            }
            return measuredHeight;
        }
        for (int i2 = size - 1; i2 >= 0; i2--) {
            View view2 = stickyChildren.get(i2);
            if (!isSink(view2)) {
                return measuredHeight + view2.getMeasuredHeight();
            }
        }
        return measuredHeight;
    }

    private int getContentWidth(View view) {
        int measuredWidth = view.getMeasuredWidth();
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
    }

    private int measureSize(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            i2 = size;
        } else if (mode == Integer.MIN_VALUE) {
            i2 = Math.min(i2, size);
        }
        return resolveSizeAndState(Math.max(i2, getSuggestedMinimumWidth()), i, 0);
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        LayoutParamsUtils.invalidTopAndBottomMargin((LayoutParams) view.getLayoutParams());
        super.measureChildWithMargins(view, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mScrollRange = 0;
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int measuredWidth = getMeasuredWidth();
        List<View> nonGoneChildren = getNonGoneChildren();
        int size = nonGoneChildren.size();
        int i5 = 0;
        while (i5 < size) {
            View view = nonGoneChildren.get(i5);
            int measuredHeight = view.getMeasuredHeight() + paddingTop;
            int childLeft = getChildLeft(view, measuredWidth, paddingLeft, paddingRight);
            view.layout(childLeft, paddingTop, view.getMeasuredWidth() + childLeft, measuredHeight);
            this.mScrollRange += view.getHeight();
            i5++;
            paddingTop = measuredHeight;
        }
        int measuredHeight2 = this.mScrollRange - ((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        this.mScrollRange = measuredHeight2;
        if (measuredHeight2 < 0) {
            this.mScrollRange = 0;
        }
        checkLayoutChange(z, false);
        sortViews();
    }

    private void sortViews() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (!isStickyView(childAt) || isSink(childAt)) {
                arrayList.add(childAt);
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt2 = getChildAt(i2);
            if (isStickyView(childAt2) && !isSink(childAt2)) {
                arrayList.add(childAt2);
            }
        }
        this.mViews.clear();
        this.mViews.addAll(arrayList);
    }

    /* renamed from: com.bytedance.sdk.djx.core.business.view.scroll.DJXScrollerLayout$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$sdk$djx$core$business$view$scroll$DJXScrollerLayout$LayoutParams$Align;

        static {
            int[] iArr = new int[LayoutParams.Align.values().length];
            $SwitchMap$com$bytedance$sdk$djx$core$business$view$scroll$DJXScrollerLayout$LayoutParams$Align = iArr;
            try {
                iArr[LayoutParams.Align.RIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$sdk$djx$core$business$view$scroll$DJXScrollerLayout$LayoutParams$Align[LayoutParams.Align.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$sdk$djx$core$business$view$scroll$DJXScrollerLayout$LayoutParams$Align[LayoutParams.Align.LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private int getChildLeft(View view, int i, int i2, int i3) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i4 = AnonymousClass3.$SwitchMap$com$bytedance$sdk$djx$core$business$view$scroll$DJXScrollerLayout$LayoutParams$Align[layoutParams.align.ordinal()];
        if (i4 == 1) {
            return ((i - view.getMeasuredWidth()) - i3) - layoutParams.rightMargin;
        }
        if (i4 == 2) {
            return layoutParams.leftMargin + i2 + ((((((i - view.getMeasuredWidth()) - i2) - layoutParams.leftMargin) - i3) - layoutParams.rightMargin) / 2);
        }
        return i2 + layoutParams.leftMargin;
    }

    private void resetScrollToTopView() {
        View viewFindFirstVisibleView = findFirstVisibleView();
        this.mScrollToTopView = viewFindFirstVisibleView;
        if (viewFindFirstVisibleView != null) {
            this.mAdjust = getScrollY() - this.mScrollToTopView.getTop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00fd A[Catch: all -> 0x0223, TryCatch #0 {all -> 0x0223, blocks: (B:3:0x0001, B:5:0x000a, B:6:0x0013, B:8:0x001d, B:9:0x001f, B:78:0x0202, B:82:0x0212, B:84:0x021f, B:19:0x003c, B:24:0x0049, B:25:0x0079, B:26:0x0083, B:27:0x00c0, B:29:0x00c8, B:32:0x00cf, B:34:0x00eb, B:36:0x00f1, B:38:0x00fd, B:40:0x0107, B:42:0x010f, B:46:0x0125, B:48:0x0129, B:43:0x011b, B:45:0x0123, B:50:0x012d, B:51:0x013d, B:53:0x0141, B:55:0x0145, B:58:0x0172, B:60:0x017a, B:62:0x0180, B:63:0x0183, B:65:0x0187, B:67:0x018d, B:69:0x0193, B:71:0x019b, B:72:0x019f, B:73:0x01ae, B:77:0x01b5), top: B:87:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0141 A[Catch: all -> 0x0223, TryCatch #0 {all -> 0x0223, blocks: (B:3:0x0001, B:5:0x000a, B:6:0x0013, B:8:0x001d, B:9:0x001f, B:78:0x0202, B:82:0x0212, B:84:0x021f, B:19:0x003c, B:24:0x0049, B:25:0x0079, B:26:0x0083, B:27:0x00c0, B:29:0x00c8, B:32:0x00cf, B:34:0x00eb, B:36:0x00f1, B:38:0x00fd, B:40:0x0107, B:42:0x010f, B:46:0x0125, B:48:0x0129, B:43:0x011b, B:45:0x0123, B:50:0x012d, B:51:0x013d, B:53:0x0141, B:55:0x0145, B:58:0x0172, B:60:0x017a, B:62:0x0180, B:63:0x0183, B:65:0x0187, B:67:0x018d, B:69:0x0193, B:71:0x019b, B:72:0x019f, B:73:0x01ae, B:77:0x01b5), top: B:87:0x0001 }] */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r11) {
        /*
            Method dump skipped, instructions count: 548
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.djx.core.business.view.scroll.DJXScrollerLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0025, code lost:
    
        if (isIntercept(r0[0], r0[1]) != false) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0028 A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:2:0x0000, B:11:0x0011, B:13:0x0015, B:15:0x001b, B:18:0x0028, B:20:0x002f, B:23:0x0034), top: B:28:0x0000 }] */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            int r0 = r5.getActionMasked()     // Catch: java.lang.Throwable -> L3c
            if (r0 == 0) goto L34
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L28
            r3 = 2
            if (r0 == r3) goto L11
            r3 = 3
            if (r0 == r3) goto L28
            goto L3c
        L11:
            int r0 = r4.SCROLL_ORIENTATION     // Catch: java.lang.Throwable -> L3c
            if (r0 == r3) goto L3c
            boolean r0 = r4.isIntercept(r5)     // Catch: java.lang.Throwable -> L3c
            if (r0 != 0) goto L27
            int[] r0 = r4.mDownLocation     // Catch: java.lang.Throwable -> L3c
            r1 = r0[r1]     // Catch: java.lang.Throwable -> L3c
            r0 = r0[r2]     // Catch: java.lang.Throwable -> L3c
            boolean r0 = r4.isIntercept(r1, r0)     // Catch: java.lang.Throwable -> L3c
            if (r0 == 0) goto L3c
        L27:
            return r2
        L28:
            r4.stopNestedScroll(r1)     // Catch: java.lang.Throwable -> L3c
            boolean r0 = r4.isBrake     // Catch: java.lang.Throwable -> L3c
            if (r0 == 0) goto L3c
            int r0 = r4.SCROLL_ORIENTATION     // Catch: java.lang.Throwable -> L3c
            if (r0 != 0) goto L3c
            return r2
        L34:
            r4.initOrResetVelocityTracker()     // Catch: java.lang.Throwable -> L3c
            android.view.VelocityTracker r0 = r4.mVelocityTracker     // Catch: java.lang.Throwable -> L3c
            r0.addMovement(r5)     // Catch: java.lang.Throwable -> L3c
        L3c:
            boolean r5 = super.onInterceptTouchEvent(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.djx.core.business.view.scroll.DJXScrollerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x01b9 A[Catch: all -> 0x01c9, TryCatch #0 {all -> 0x01c9, blocks: (B:3:0x0005, B:5:0x000b, B:8:0x0011, B:10:0x001b, B:11:0x001d, B:13:0x002c, B:16:0x0034, B:83:0x01b5, B:85:0x01b9, B:86:0x01bc, B:82:0x01ae, B:27:0x004b, B:28:0x0058, B:30:0x005c, B:32:0x0067, B:34:0x0085, B:35:0x00a7, B:37:0x00ad, B:39:0x00b3, B:44:0x00be, B:45:0x00c1, B:47:0x00c5, B:48:0x00c8, B:50:0x00ce, B:51:0x00d5, B:53:0x00e5, B:54:0x00ff, B:62:0x0113, B:64:0x0119, B:66:0x0137, B:71:0x0165, B:73:0x0169, B:75:0x016f, B:77:0x0177, B:68:0x013f, B:70:0x0160, B:78:0x017b, B:80:0x0184, B:81:0x01ab, B:88:0x01c0, B:90:0x01c4), top: B:93:0x0005 }] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 458
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.djx.core.business.view.scroll.DJXScrollerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private boolean canScrollVertically() {
        return (isScrollTop() && isScrollBottom()) ? false : true;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        if (this.mViews.size() > i2) {
            return indexOfChild(this.mViews.get(i2));
        }
        return super.getChildDrawingOrder(i, i2);
    }

    int getDrawingPosition(View view) {
        return this.mViews.indexOf(view);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int paddingLeft;
        int paddingTop;
        super.draw(canvas);
        if (this.mOldScrollY != getScrollY()) {
            this.mOldScrollY = getScrollY();
            resetSticky();
        }
        if (this.mEdgeGlowTop != null) {
            int scrollY = getScrollY();
            int paddingLeft2 = 0;
            if (!this.mEdgeGlowTop.isFinished()) {
                int iSave = canvas.save();
                int width = getWidth();
                int height = getHeight();
                if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    paddingLeft = getPaddingLeft() + 0;
                } else {
                    paddingLeft = 0;
                }
                if (Build.VERSION.SDK_INT < 21 || !getClipToPadding()) {
                    paddingTop = scrollY;
                } else {
                    height -= getPaddingTop() + getPaddingBottom();
                    paddingTop = getPaddingTop() + scrollY;
                }
                canvas.translate(paddingLeft, paddingTop);
                this.mEdgeGlowTop.setSize(width, height);
                if (this.mEdgeGlowTop.draw(canvas)) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                canvas.restoreToCount(iSave);
            }
            if (this.mEdgeGlowBottom.isFinished()) {
                return;
            }
            int iSave2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int paddingBottom = scrollY + height2;
            if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                width2 -= getPaddingLeft() + getPaddingRight();
                paddingLeft2 = 0 + getPaddingLeft();
            }
            if (Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                height2 -= getPaddingTop() + getPaddingBottom();
                paddingBottom -= getPaddingBottom();
            }
            canvas.translate(paddingLeft2 - width2, paddingBottom);
            canvas.rotate(180.0f, width2, 0.0f);
            this.mEdgeGlowBottom.setSize(width2, height2);
            if (this.mEdgeGlowBottom.draw(canvas)) {
                ViewCompat.postInvalidateOnAnimation(this);
            }
            canvas.restoreToCount(iSave2);
        }
    }

    private int getScrollRange() {
        if (getChildCount() > 0) {
            return Math.max(0, computeVerticalScrollRange() - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
        }
        return 0;
    }

    private void fling(int i) {
        if (Math.abs(i) > this.mMinimumVelocity) {
            float f = i;
            if (dispatchNestedPreFling(0.0f, f)) {
                return;
            }
            dispatchNestedFling(0.0f, f, (i < 0 && !isScrollTop()) || (i > 0 && !isScrollBottom()));
            this.mScroller.fling(0, this.mSecondScrollY, 1, i, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            startNestedScroll(2, 1);
            setScrollState(2);
            this.mLastScrollerY = this.mSecondScrollY;
            invalidate();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        int i;
        if (this.mScrollToIndex != -1 && (i = this.mSmoothScrollOffset) != 0) {
            dispatchScroll(i);
            invalidate();
            return;
        }
        if (this.mScroller.computeScrollOffset()) {
            int currY = this.mScroller.getCurrY();
            int i2 = currY - this.mLastScrollerY;
            this.mLastScrollerY = currY;
            int[] iArr = this.mScrollConsumed;
            iArr[1] = 0;
            dispatchNestedPreScroll(0, i2, iArr, null, 1);
            int i3 = i2 - this.mScrollConsumed[1];
            int i4 = this.mSecondScrollY;
            dispatchScroll(i3);
            int i5 = this.mSecondScrollY - i4;
            int i6 = i3 - i5;
            if ((i6 < 0 && isScrollTop()) || (i6 > 0 && isScrollBottom())) {
                dispatchNestedScroll(0, i5, 0, i6, this.mScrollOffset, 1);
                i6 += this.mScrollOffset[1];
            }
            if ((i6 < 0 && isScrollTop()) || (i6 > 0 && isScrollBottom())) {
                int overScrollMode = getOverScrollMode();
                if (overScrollMode == 0 || (overScrollMode == 1 && getScrollRange() > 0)) {
                    ensureGlows();
                    if (i6 < 0) {
                        if (this.mEdgeGlowTop.isFinished()) {
                            this.mEdgeGlowTop.onAbsorb((int) this.mScroller.getCurrVelocity());
                        }
                    } else if (this.mEdgeGlowBottom.isFinished()) {
                        this.mEdgeGlowBottom.onAbsorb((int) this.mScroller.getCurrVelocity());
                    }
                }
                stopScroll();
            }
            invalidate();
        }
        if (this.mScrollState == 2 && this.mScroller.isFinished()) {
            stopNestedScroll(1);
            checkTargetsScroll(false, false);
            setScrollState(0);
        }
    }

    private void endDrag() {
        EdgeEffect edgeEffect = this.mEdgeGlowTop;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.mEdgeGlowBottom.onRelease();
        }
    }

    private void ensureGlows() {
        if (getOverScrollMode() != 2) {
            if (this.mEdgeGlowTop == null) {
                Context context = getContext();
                this.mEdgeGlowTop = new EdgeEffect(context);
                this.mEdgeGlowBottom = new EdgeEffect(context);
                return;
            }
            return;
        }
        this.mEdgeGlowTop = null;
        this.mEdgeGlowBottom = null;
    }

    private void dispatchScroll(int i) {
        if (i > 0) {
            scrollUp(i);
        } else if (i < 0) {
            scrollDown(i);
        }
    }

    private void scrollUp(int i) {
        int viewsScrollOffset;
        int top;
        View bottomView;
        int iComputeVerticalScrollOffset = computeVerticalScrollOffset();
        do {
            int i2 = this.mScrollToIndex;
            int iMin = 0;
            if (i2 != -1) {
                View childAt = getChildAt(i2);
                top = (childAt.getTop() - this.mScrollToIndexWithOffset) - getAdjustHeightForChild(childAt);
                viewsScrollOffset = this.mScrollToIndexWithOffset < 0 ? getViewsScrollOffset(this.mScrollToIndex) : 0;
                if (getScrollY() + getPaddingTop() + viewsScrollOffset >= top || isScrollBottom()) {
                    this.mScrollToIndex = -1;
                    this.mSmoothScrollOffset = 0;
                    this.mScrollToIndexWithOffset = 0;
                    setScrollState(0);
                    break;
                }
            } else {
                viewsScrollOffset = 0;
                top = 0;
            }
            if (!isScrollBottom()) {
                if (getScrollY() < this.mScrollRange) {
                    bottomView = findFirstVisibleView();
                } else {
                    bottomView = getBottomView();
                }
                if (bottomView != null) {
                    awakenScrollBars();
                    int scrollBottomOffset = ScrollUtils.getScrollBottomOffset(bottomView);
                    if (scrollBottomOffset > 0) {
                        iMin = Math.min(i, scrollBottomOffset);
                        if (this.mScrollToIndex != -1) {
                            iMin = Math.min(iMin, top - ((getScrollY() + getPaddingTop()) + viewsScrollOffset));
                        }
                        scrollChild(bottomView, iMin);
                    } else {
                        iMin = Math.min(i, (bottomView.getBottom() - getPaddingTop()) - getScrollY());
                        if (this.mScrollToIndex != -1) {
                            iMin = Math.min(iMin, top - ((getScrollY() + getPaddingTop()) + viewsScrollOffset));
                        }
                        scrollSelf(getScrollY() + iMin);
                    }
                    this.mSecondScrollY += iMin;
                    i -= iMin;
                }
            }
            if (iMin <= 0) {
                break;
            }
        } while (i > 0);
        int iComputeVerticalScrollOffset2 = computeVerticalScrollOffset();
        if (iComputeVerticalScrollOffset != iComputeVerticalScrollOffset2) {
            scrollChange(iComputeVerticalScrollOffset2, iComputeVerticalScrollOffset);
        }
    }

    private void scrollDown(int i) {
        int viewsScrollOffset;
        int top;
        View bottomView;
        int iComputeVerticalScrollOffset = computeVerticalScrollOffset();
        do {
            int i2 = this.mScrollToIndex;
            int iMax = 0;
            if (i2 != -1) {
                View childAt = getChildAt(i2);
                top = (childAt.getTop() - this.mScrollToIndexWithOffset) - getAdjustHeightForChild(childAt);
                viewsScrollOffset = getViewsScrollOffset(this.mScrollToIndex);
                if (getScrollY() + getPaddingTop() + viewsScrollOffset <= top || isScrollTop()) {
                    this.mScrollToIndex = -1;
                    this.mSmoothScrollOffset = 0;
                    this.mScrollToIndexWithOffset = 0;
                    setScrollState(0);
                    break;
                }
            } else {
                viewsScrollOffset = 0;
                top = 0;
            }
            if (!isScrollTop()) {
                if (getScrollY() < this.mScrollRange) {
                    bottomView = findLastVisibleView();
                } else {
                    bottomView = getBottomView();
                }
                if (bottomView != null) {
                    awakenScrollBars();
                    int scrollTopOffset = ScrollUtils.getScrollTopOffset(bottomView);
                    if (scrollTopOffset < 0) {
                        iMax = Math.max(i, scrollTopOffset);
                        if (this.mScrollToIndex != -1) {
                            iMax = Math.max(iMax, top - ((getScrollY() + getPaddingTop()) + viewsScrollOffset));
                        }
                        scrollChild(bottomView, iMax);
                    } else {
                        int scrollY = getScrollY();
                        int iMax2 = Math.max(Math.max(i, ((bottomView.getTop() + getPaddingBottom()) - scrollY) - getHeight()), -scrollY);
                        if (this.mScrollToIndex != -1) {
                            iMax2 = Math.max(iMax2, top - ((getScrollY() + getPaddingTop()) + viewsScrollOffset));
                        }
                        scrollSelf(scrollY + iMax2);
                        iMax = iMax2;
                    }
                    this.mSecondScrollY += iMax;
                    i -= iMax;
                }
            }
            if (iMax >= 0) {
                break;
            }
        } while (i < 0);
        int iComputeVerticalScrollOffset2 = computeVerticalScrollOffset();
        if (iComputeVerticalScrollOffset != iComputeVerticalScrollOffset2) {
            scrollChange(iComputeVerticalScrollOffset2, iComputeVerticalScrollOffset);
        }
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        scrollTo(0, this.mSecondScrollY + i2);
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        dispatchScroll(i2 - this.mSecondScrollY);
    }

    private void scrollChange(int i, int i2) {
        OnScrollChangeListener onScrollChangeListener = this.mOnScrollChangeListener;
        if (onScrollChangeListener != null) {
            onScrollChangeListener.onScrollChange(this, i, i2, this.mScrollState);
        }
    }

    private void stickyChange(View view, View view2) {
        OnStickyChangeListener onStickyChangeListener = this.mOnStickyChangeListener;
        if (onStickyChangeListener != null) {
            onStickyChangeListener.onStickyChange(view, view2);
        }
    }

    private void permanentStickyChange(List<View> list) {
        OnPermanentStickyChangeListener onPermanentStickyChangeListener = this.mOnPermanentStickyChangeListener;
        if (onPermanentStickyChangeListener != null) {
            onPermanentStickyChangeListener.onStickyChange(list);
        }
    }

    private void scrollSelf(int i) {
        if (i < 0) {
            i = 0;
        } else {
            int i2 = this.mScrollRange;
            if (i > i2) {
                i = i2;
            }
        }
        super.scrollTo(0, i);
    }

    private void scrollChild(View view, int i) {
        View scrolledView = ScrollUtils.getScrolledView(view);
        if (scrolledView instanceof AbsListView) {
            AbsListView absListView = (AbsListView) scrolledView;
            if (Build.VERSION.SDK_INT >= 19) {
                absListView.scrollListBy(i);
                return;
            }
            return;
        }
        boolean zStartInterceptRequestLayout = scrolledView instanceof RecyclerView ? ScrollUtils.startInterceptRequestLayout((RecyclerView) scrolledView) : false;
        scrolledView.scrollBy(0, i);
        if (zStartInterceptRequestLayout) {
            final RecyclerView recyclerView = (RecyclerView) scrolledView;
            recyclerView.postDelayed(new Runnable() { // from class: com.bytedance.sdk.djx.core.business.view.scroll.DJXScrollerLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    ScrollUtils.stopInterceptRequestLayout(recyclerView);
                }
            }, 0L);
        }
    }

    public void checkLayoutChange() {
        checkLayoutChange(false, true);
    }

    private void checkLayoutChange(boolean z, boolean z2) {
        int i = this.mSecondScrollY;
        View view = this.mScrollToTopView;
        if (view != null && z) {
            if (indexOfChild(view) != -1) {
                scrollSelf(this.mScrollToTopView.getTop() + this.mAdjust);
            }
        } else {
            scrollSelf(getScrollY());
        }
        checkTargetsScroll(true, z2);
        if (i != this.mSecondScrollY && this.mScrollToTopView != findFirstVisibleView()) {
            scrollTo(0, i);
        }
        this.mScrollToTopView = null;
        this.mAdjust = 0;
        resetChildren();
        resetSticky();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void checkTargetsScroll(boolean z, boolean z2) {
        int iComputeVerticalScrollOffset;
        if (z2 || (!this.mTouching && this.mScroller.isFinished() && this.mScrollToIndex == -1)) {
            int iComputeVerticalScrollOffset2 = computeVerticalScrollOffset();
            View viewFindFirstVisibleView = findFirstVisibleView();
            if (viewFindFirstVisibleView == null) {
                return;
            }
            int iIndexOfChild = indexOfChild(viewFindFirstVisibleView);
            if (z) {
                while (true) {
                    int scrollBottomOffset = ScrollUtils.getScrollBottomOffset(viewFindFirstVisibleView);
                    int top = viewFindFirstVisibleView.getTop() - getScrollY();
                    if (scrollBottomOffset <= 0 || top >= 0) {
                        break;
                    }
                    int iMin = Math.min(scrollBottomOffset, -top);
                    scrollSelf(getScrollY() - iMin);
                    scrollChild(viewFindFirstVisibleView, iMin);
                }
            }
            for (int i = 0; i < iIndexOfChild; i++) {
                View childAt = getChildAt(i);
                if (childAt.getVisibility() != 8 && ScrollUtils.isConsecutiveScrollerChild(childAt)) {
                    View scrollChild = ScrollUtils.getScrollChild(childAt);
                    if (scrollChild instanceof IScroller) {
                        List<View> scrolledViews = ((IScroller) scrollChild).getScrolledViews();
                        if (scrolledViews != null && !scrolledViews.isEmpty()) {
                            int size = scrolledViews.size();
                            for (int i2 = 0; i2 < size; i2++) {
                                scrollChildContentToBottom(scrolledViews.get(i2));
                            }
                        }
                    } else {
                        scrollChildContentToBottom(scrollChild);
                    }
                }
            }
            while (true) {
                iIndexOfChild++;
                if (iIndexOfChild >= getChildCount()) {
                    break;
                }
                View childAt2 = getChildAt(iIndexOfChild);
                if (childAt2.getVisibility() != 8 && ScrollUtils.isConsecutiveScrollerChild(childAt2) && (iIndexOfChild != getChildCount() - 1 || childAt2.getHeight() >= getHeight() || getScrollY() < this.mScrollRange)) {
                    View scrollChild2 = ScrollUtils.getScrollChild(childAt2);
                    if (scrollChild2 instanceof IScroller) {
                        List<View> scrolledViews2 = ((IScroller) scrollChild2).getScrolledViews();
                        if (scrolledViews2 != null && !scrolledViews2.isEmpty()) {
                            int size2 = scrolledViews2.size();
                            for (int i3 = 0; i3 < size2; i3++) {
                                scrollChildContentToTop(scrolledViews2.get(i3));
                            }
                        }
                    } else {
                        scrollChildContentToTop(scrollChild2);
                    }
                }
            }
            computeOwnScrollOffset();
            if (z && iComputeVerticalScrollOffset2 != (iComputeVerticalScrollOffset = computeVerticalScrollOffset())) {
                scrollChange(iComputeVerticalScrollOffset, iComputeVerticalScrollOffset2);
            }
            resetSticky();
        }
    }

    void scrollChildContentToTop(View view) {
        int iComputeVerticalScrollOffset;
        do {
            iComputeVerticalScrollOffset = 0;
            int scrollTopOffset = ScrollUtils.getScrollTopOffset(view);
            if (scrollTopOffset < 0) {
                int iComputeVerticalScrollOffset2 = ScrollUtils.computeVerticalScrollOffset(view);
                scrollChild(view, scrollTopOffset);
                iComputeVerticalScrollOffset = iComputeVerticalScrollOffset2 - ScrollUtils.computeVerticalScrollOffset(view);
            }
        } while (iComputeVerticalScrollOffset != 0);
    }

    void scrollChildContentToBottom(View view) {
        int iComputeVerticalScrollOffset;
        do {
            iComputeVerticalScrollOffset = 0;
            int scrollBottomOffset = ScrollUtils.getScrollBottomOffset(view);
            if (scrollBottomOffset > 0) {
                int iComputeVerticalScrollOffset2 = ScrollUtils.computeVerticalScrollOffset(view);
                scrollChild(view, scrollBottomOffset);
                iComputeVerticalScrollOffset = iComputeVerticalScrollOffset2 - ScrollUtils.computeVerticalScrollOffset(view);
            }
        } while (iComputeVerticalScrollOffset != 0);
    }

    private void computeOwnScrollOffset() {
        this.mSecondScrollY = computeVerticalScrollOffset();
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void initOrResetAdjustVelocityTracker() {
        VelocityTracker velocityTracker = this.mAdjustVelocityTracker;
        if (velocityTracker == null) {
            this.mAdjustVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void initAdjustVelocityTrackerIfNotExists() {
        if (this.mAdjustVelocityTracker == null) {
            this.mAdjustVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void recycleAdjustVelocityTracker() {
        VelocityTracker velocityTracker = this.mAdjustVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mAdjustVelocityTracker = null;
        }
    }

    public void stopScroll() {
        if (this.mScroller.isFinished()) {
            return;
        }
        this.mScroller.abortAnimation();
        stopNestedScroll(1);
        if (this.mScrollToIndex == -1) {
            setScrollState(0);
        }
    }

    private View getBottomView() {
        List<View> effectiveChildren = getEffectiveChildren();
        if (effectiveChildren.isEmpty()) {
            return null;
        }
        return effectiveChildren.get(effectiveChildren.size() - 1);
    }

    private List<View> getNonGoneChildren() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                arrayList.add(childAt);
            }
        }
        return arrayList;
    }

    private List<View> getEffectiveChildren() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8 && childAt.getHeight() > 0) {
                arrayList.add(childAt);
            }
        }
        return arrayList;
    }

    private List<View> getStickyChildren() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8 && isStickyView(childAt)) {
                arrayList.add(childAt);
            }
        }
        return arrayList;
    }

    public boolean isStickyView(View view) {
        if (view == null) {
            return false;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            return ((LayoutParams) layoutParams).isSticky;
        }
        return false;
    }

    public boolean isSink(View view) {
        if (view == null) {
            return false;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            return ((LayoutParams) layoutParams).isSink;
        }
        return false;
    }

    private void resetChildren() {
        Iterator<View> it = getNonGoneChildren().iterator();
        while (it.hasNext()) {
            it.next().setTranslationY(0.0f);
        }
    }

    private void resetSticky() {
        View view;
        View view2;
        List<View> stickyChildren = getStickyChildren();
        if (!stickyChildren.isEmpty()) {
            int size = stickyChildren.size();
            int iMax = 0;
            for (int i = 0; i < size; i++) {
                stickyChildren.get(i).setTranslationY(0.0f);
            }
            if (this.isPermanent) {
                clearCurrentStickyView();
                permanentStickyChild(stickyChildren);
                return;
            }
            clearCurrentStickyViews();
            int i2 = size - 1;
            int i3 = i2;
            while (true) {
                if (i3 < 0) {
                    view2 = null;
                    break;
                }
                View view3 = stickyChildren.get(i3);
                if (view3.getTop() <= getStickyY()) {
                    view2 = i3 != i2 ? stickyChildren.get(i3 + 1) : null;
                    view = view3;
                } else {
                    i3--;
                }
            }
            View view4 = this.mCurrentStickyView;
            if (view != null) {
                if (view2 != null && !isSink(view)) {
                    iMax = Math.max(0, view.getHeight() - (view2.getTop() - getStickyY()));
                }
                stickyChild(view, iMax);
            }
            if (view4 != view) {
                this.mCurrentStickyView = view;
                stickyChange(view4, view);
                return;
            }
            return;
        }
        clearCurrentStickyView();
        clearCurrentStickyViews();
    }

    private void clearCurrentStickyView() {
        View view = this.mCurrentStickyView;
        if (view != null) {
            this.mCurrentStickyView = null;
            stickyChange(view, null);
        }
    }

    private void clearCurrentStickyViews() {
        if (this.mCurrentStickyViews.isEmpty()) {
            return;
        }
        this.mCurrentStickyViews.clear();
        permanentStickyChange(this.mCurrentStickyViews);
    }

    private void stickyChild(View view, int i) {
        view.setY(getStickyY() - i);
        view.setClickable(true);
    }

    private int getStickyY() {
        return getScrollY() + getPaddingTop() + this.mStickyOffset;
    }

    private void permanentStickyChild(List<View> list) {
        this.mTempStickyViews.clear();
        for (int i = 0; i < list.size(); i++) {
            View view = list.get(i);
            if (view.getTop() <= getStickyY() + getPermanentHeight(list, i)) {
                view.setY(getStickyY() + r2);
                view.setClickable(true);
                this.mTempStickyViews.add(view);
            }
        }
        if (isListEqual()) {
            return;
        }
        this.mCurrentStickyViews.clear();
        this.mCurrentStickyViews.addAll(this.mTempStickyViews);
        this.mTempStickyViews.clear();
        permanentStickyChange(this.mCurrentStickyViews);
    }

    private int getPermanentHeight(List<View> list, int i) {
        int measuredHeight = 0;
        for (int i2 = 0; i2 < i; i2++) {
            View view = list.get(i2);
            if (!isSink(view)) {
                measuredHeight += view.getMeasuredHeight();
            }
        }
        return measuredHeight;
    }

    private boolean isListEqual() {
        if (this.mTempStickyViews.size() != this.mCurrentStickyViews.size()) {
            return false;
        }
        int size = this.mTempStickyViews.size();
        for (int i = 0; i < size; i++) {
            if (this.mTempStickyViews.get(i) != this.mCurrentStickyViews.get(i)) {
                return false;
            }
        }
        return true;
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    void setScrollState(int i) {
        if (i == this.mScrollState) {
            return;
        }
        this.mScrollState = i;
        int iComputeVerticalScrollOffset = computeVerticalScrollOffset();
        scrollChange(iComputeVerticalScrollOffset, iComputeVerticalScrollOffset);
    }

    public int getOwnScrollY() {
        return computeVerticalScrollOffset();
    }

    public View findFirstVisibleView() {
        int scrollY = getScrollY() + getPaddingTop();
        List<View> effectiveChildren = getEffectiveChildren();
        int size = effectiveChildren.size();
        for (int i = 0; i < size; i++) {
            View view = effectiveChildren.get(i);
            if (view.getTop() <= scrollY && view.getBottom() > scrollY) {
                return view;
            }
        }
        return null;
    }

    public View findLastVisibleView() {
        int height = (getHeight() - getPaddingBottom()) + getScrollY();
        List<View> effectiveChildren = getEffectiveChildren();
        int size = effectiveChildren.size();
        for (int i = 0; i < size; i++) {
            View view = effectiveChildren.get(i);
            if (view.getTop() < height && view.getBottom() >= height) {
                return view;
            }
        }
        return null;
    }

    public boolean isScrollTop() {
        List<View> effectiveChildren = getEffectiveChildren();
        int size = effectiveChildren.size();
        if (size <= 0) {
            return true;
        }
        boolean z = getScrollY() <= 0 && !ScrollUtils.canScrollVertically(effectiveChildren.get(0), -1);
        if (z) {
            for (int i = size - 1; i >= 0; i--) {
                View view = effectiveChildren.get(i);
                if (ScrollUtils.isConsecutiveScrollerChild(view) && ScrollUtils.canScrollVertically(view, -1)) {
                    return false;
                }
            }
        }
        return z;
    }

    public boolean isScrollBottom() {
        List<View> effectiveChildren = getEffectiveChildren();
        if (effectiveChildren.size() > 0) {
            return getScrollY() >= this.mScrollRange && !ScrollUtils.canScrollVertically(effectiveChildren.get(effectiveChildren.size() - 1), 1);
        }
        return true;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        if (i > 0) {
            return !isScrollBottom();
        }
        return !isScrollTop();
    }

    public void setOnVerticalScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        this.mOnScrollChangeListener = onScrollChangeListener;
    }

    public OnScrollChangeListener getOnVerticalScrollChangeListener() {
        return this.mOnScrollChangeListener;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        List<View> nonGoneChildren = getNonGoneChildren();
        int size = nonGoneChildren.size();
        int iComputeVerticalScrollRange = 0;
        for (int i = 0; i < size; i++) {
            View view = nonGoneChildren.get(i);
            if (ScrollUtils.isConsecutiveScrollerChild(view) && ScrollUtils.canScrollVertically(view)) {
                View scrolledView = ScrollUtils.getScrolledView(view);
                iComputeVerticalScrollRange += ScrollUtils.computeVerticalScrollRange(scrolledView) + scrolledView.getPaddingTop() + scrolledView.getPaddingBottom();
            } else {
                int height = view.getHeight();
                iComputeVerticalScrollRange += height;
            }
        }
        return iComputeVerticalScrollRange;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollOffset() {
        int scrollY = getScrollY();
        List<View> nonGoneChildren = getNonGoneChildren();
        int size = nonGoneChildren.size();
        for (int i = 0; i < size; i++) {
            View view = nonGoneChildren.get(i);
            if (ScrollUtils.isConsecutiveScrollerChild(view)) {
                scrollY += ScrollUtils.computeVerticalScrollOffset(view);
            }
        }
        return scrollY;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollExtent() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private View getTouchTarget(int i, int i2) {
        for (View view : getNonGoneChildren()) {
            if (ScrollUtils.isTouchPointInView(view, i, i2)) {
                return view;
            }
        }
        return null;
    }

    private boolean isIntercept(MotionEvent motionEvent) {
        int iFindPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
        if (iFindPointerIndex < 0 || iFindPointerIndex >= motionEvent.getPointerCount()) {
            return true;
        }
        return isIntercept(ScrollUtils.getRawX(this, motionEvent, iFindPointerIndex), ScrollUtils.getRawY(this, motionEvent, iFindPointerIndex));
    }

    private boolean isIntercept(int i, int i2) {
        View touchTarget = getTouchTarget(i, i2);
        if (touchTarget != null) {
            return ScrollUtils.isConsecutiveScrollerChild(touchTarget);
        }
        return false;
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public Align align;
        public boolean isConsecutive;
        public boolean isNestedScroll;
        public boolean isSink;
        public boolean isSticky;
        public boolean isTriggerScroll;
        public int scrollChild;

        public enum Align {
            LEFT(1),
            RIGHT(2),
            CENTER(3);

            int value;

            Align(int i) {
                this.value = i;
            }

            static Align get(int i) {
                if (i == 1) {
                    return LEFT;
                }
                if (i == 2) {
                    return RIGHT;
                }
                if (i == 3) {
                    return CENTER;
                }
                return LEFT;
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.isConsecutive = true;
            this.isNestedScroll = true;
            this.isSticky = false;
            this.isTriggerScroll = false;
            this.isSink = false;
            this.align = Align.LEFT;
            TypedArray typedArrayObtainStyledAttributes = null;
            try {
                typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DJXScrollerLayout_LP);
                this.isConsecutive = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DJXScrollerLayout_LP_djx_lp_isConsecutive, true);
                this.isNestedScroll = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DJXScrollerLayout_LP_djx_lp_isNestedScroll, true);
                this.isSticky = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DJXScrollerLayout_LP_djx_lp_isSticky, false);
                this.isTriggerScroll = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DJXScrollerLayout_LP_djx_lp_isTriggerScroll, false);
                this.isSink = typedArrayObtainStyledAttributes.getBoolean(R.styleable.DJXScrollerLayout_LP_djx_lp_isSink, false);
                this.align = Align.get(typedArrayObtainStyledAttributes.getInt(R.styleable.DJXScrollerLayout_LP_djx_lp_align, 1));
                this.scrollChild = typedArrayObtainStyledAttributes.getResourceId(R.styleable.DJXScrollerLayout_LP_djx_lp_scrollChild, 0);
                if (typedArrayObtainStyledAttributes == null) {
                    return;
                }
            } catch (Throwable unused) {
                if (typedArrayObtainStyledAttributes == null) {
                    return;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.isConsecutive = true;
            this.isNestedScroll = true;
            this.isSticky = false;
            this.isTriggerScroll = false;
            this.isSink = false;
            this.align = Align.LEFT;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.isConsecutive = true;
            this.isNestedScroll = true;
            this.isSticky = false;
            this.isTriggerScroll = false;
            this.isSink = false;
            this.align = Align.LEFT;
        }
    }

    public void scrollToChild(View view) {
        scrollToChildWithOffset(view, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void scrollToChildWithOffset(android.view.View r8, int r9) {
        /*
            r7 = this;
            int r0 = r7.indexOfChild(r8)
            r1 = -1
            if (r0 == r1) goto L71
            int r2 = r8.getTop()
            int r2 = r2 - r9
            int r3 = r7.getAdjustHeightForChild(r8)
            int r2 = r2 - r3
            r3 = 0
            r4 = 1
            if (r9 < 0) goto L34
            int r5 = r7.getScrollY()
            int r6 = r7.getPaddingTop()
            int r5 = r5 + r6
            if (r5 <= r2) goto L21
            goto L44
        L21:
            int r5 = r7.getScrollY()
            int r6 = r7.getPaddingTop()
            int r5 = r5 + r6
            if (r5 >= r2) goto L2d
            goto L52
        L2d:
            boolean r8 = com.bytedance.sdk.djx.core.business.view.scroll.ScrollUtils.canScrollVertically(r8, r1)
            if (r8 == 0) goto L53
            goto L44
        L34:
            int r8 = r7.getViewsScrollOffset(r0)
            int r5 = r7.getScrollY()
            int r6 = r7.getPaddingTop()
            int r5 = r5 + r6
            int r5 = r5 + r8
            if (r5 <= r2) goto L46
        L44:
            r3 = r1
            goto L53
        L46:
            int r5 = r7.getScrollY()
            int r6 = r7.getPaddingTop()
            int r5 = r5 + r6
            int r5 = r5 + r8
            if (r5 >= r2) goto L53
        L52:
            r3 = r4
        L53:
            if (r3 == 0) goto L71
            r7.mScrollToIndex = r0
            r7.stopScroll()
            r7.mScrollToIndexWithOffset = r9
            r8 = 2
            r7.setScrollState(r8)
        L60:
            if (r3 >= 0) goto L68
            r8 = -200(0xffffffffffffff38, float:NaN)
            r7.dispatchScroll(r8)
            goto L6d
        L68:
            r8 = 200(0xc8, float:2.8E-43)
            r7.dispatchScroll(r8)
        L6d:
            int r8 = r7.mScrollToIndex
            if (r8 != r1) goto L60
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.djx.core.business.view.scroll.DJXScrollerLayout.scrollToChildWithOffset(android.view.View, int):void");
    }

    public void smoothScrollToChild(View view) {
        smoothScrollToChildWithOffset(view, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void smoothScrollToChildWithOffset(android.view.View r8, int r9) {
        /*
            r7 = this;
            int r0 = r7.indexOfChild(r8)
            r1 = -1
            if (r0 == r1) goto L6f
            int r2 = r8.getTop()
            int r2 = r2 - r9
            int r3 = r7.getAdjustHeightForChild(r8)
            int r2 = r2 - r3
            r3 = 0
            r4 = 1
            if (r9 < 0) goto L34
            int r5 = r7.getScrollY()
            int r6 = r7.getPaddingTop()
            int r5 = r5 + r6
            if (r5 <= r2) goto L21
            goto L54
        L21:
            int r5 = r7.getScrollY()
            int r6 = r7.getPaddingTop()
            int r5 = r5 + r6
            if (r5 >= r2) goto L2d
            goto L51
        L2d:
            boolean r8 = com.bytedance.sdk.djx.core.business.view.scroll.ScrollUtils.canScrollVertically(r8, r1)
            if (r8 == 0) goto L53
            goto L54
        L34:
            int r8 = r7.getViewsScrollOffset(r0)
            int r5 = r7.getScrollY()
            int r6 = r7.getPaddingTop()
            int r5 = r5 + r6
            int r5 = r5 + r8
            if (r5 <= r2) goto L45
            goto L54
        L45:
            int r1 = r7.getScrollY()
            int r5 = r7.getPaddingTop()
            int r1 = r1 + r5
            int r1 = r1 + r8
            if (r1 >= r2) goto L53
        L51:
            r1 = r4
            goto L54
        L53:
            r1 = r3
        L54:
            if (r1 == 0) goto L6f
            r7.mScrollToIndex = r0
            r7.stopScroll()
            r7.mScrollToIndexWithOffset = r9
            r8 = 2
            r7.setScrollState(r8)
            if (r1 >= 0) goto L68
            r8 = -200(0xffffffffffffff38, float:NaN)
            r7.mSmoothScrollOffset = r8
            goto L6c
        L68:
            r8 = 200(0xc8, float:2.8E-43)
            r7.mSmoothScrollOffset = r8
        L6c:
            r7.invalidate()
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.djx.core.business.view.scroll.DJXScrollerLayout.smoothScrollToChildWithOffset(android.view.View, int):void");
    }

    private int getViewsScrollOffset(int i) {
        int childCount = getChildCount();
        int iComputeVerticalScrollOffset = 0;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8 && ScrollUtils.isConsecutiveScrollerChild(childAt)) {
                iComputeVerticalScrollOffset += ScrollUtils.computeVerticalScrollOffset(childAt);
            }
            i++;
        }
        return iComputeVerticalScrollOffset;
    }

    public boolean isAutoAdjustHeightAtBottomView() {
        return this.mAutoAdjustHeightAtBottomView;
    }

    public void setAutoAdjustHeightAtBottomView(boolean z) {
        if (this.mAutoAdjustHeightAtBottomView != z) {
            this.mAutoAdjustHeightAtBottomView = z;
            requestLayout();
        }
    }

    public int getAdjustHeightOffset() {
        return this.mAdjustHeightOffset;
    }

    public void setAdjustHeightOffset(int i) {
        if (this.mAdjustHeightOffset != i) {
            this.mAdjustHeightOffset = i;
            requestLayout();
        }
    }

    public void setPermanent(boolean z) {
        if (this.isPermanent != z) {
            this.isPermanent = z;
            if (this.mAutoAdjustHeightAtBottomView) {
                requestLayout();
            } else {
                resetSticky();
            }
        }
    }

    public boolean isPermanent() {
        return this.isPermanent;
    }

    public void setStickyOffset(int i) {
        if (this.mStickyOffset != i) {
            this.mStickyOffset = i;
            resetSticky();
        }
    }

    public int getStickyOffset() {
        return this.mStickyOffset;
    }

    public View getCurrentStickyView() {
        return this.mCurrentStickyView;
    }

    public List<View> getCurrentStickyViews() {
        return this.mCurrentStickyViews;
    }

    public boolean theChildIsStick(View view) {
        boolean z = this.isPermanent;
        return (!z && this.mCurrentStickyView == view) || (z && this.mCurrentStickyViews.contains(view));
    }

    public OnStickyChangeListener getOnStickyChangeListener() {
        return this.mOnStickyChangeListener;
    }

    public void setOnStickyChangeListener(OnStickyChangeListener onStickyChangeListener) {
        this.mOnStickyChangeListener = onStickyChangeListener;
    }

    public OnPermanentStickyChangeListener getOnPermanentStickyChangeListener() {
        return this.mOnPermanentStickyChangeListener;
    }

    public void setOnPermanentStickyChangeListener(OnPermanentStickyChangeListener onPermanentStickyChangeListener) {
        this.mOnPermanentStickyChangeListener = onPermanentStickyChangeListener;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.mChildHelper.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.mChildHelper.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.mChildHelper.dispatchNestedPreFling(f, f2);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i, int i2) {
        return this.mChildHelper.startNestedScroll(i, i2);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i) {
        this.mChildHelper.stopNestedScroll(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i) {
        return this.mChildHelper.hasNestedScrollingParent(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.mChildHelper.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return this.mChildHelper.dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return dispatchNestedPreScroll(i, i2, iArr, iArr2, 0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.mChildHelper.dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return (layoutParams instanceof LayoutParams ? ((LayoutParams) layoutParams).isNestedScroll : false) && (i & 2) != 0;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        this.mParentHelper.onNestedScrollAccepted(view, view2, i, i2);
        checkTargetsScroll(false, false);
        startNestedScroll(2, i2);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i) {
        this.mParentHelper.onStopNestedScroll(view, i);
        stopNestedScroll(i);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        onNestedScrollInternal(i4, i5);
    }

    private void onNestedScrollInternal(int i, int i2) {
        int i3 = this.mSecondScrollY;
        dispatchScroll(i);
        int i4 = this.mSecondScrollY - i3;
        this.mChildHelper.dispatchNestedScroll(0, i4, 0, i - i4, null, i2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        onNestedScrollInternal(i4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        dispatchNestedPreScroll(i, i2, iArr, null, i3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        dispatchNestedFling(0.0f, f2, true);
        fling((int) f2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }
}

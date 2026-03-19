package com.bytedance.sdk.djx.core.business.view.refresh;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ListViewCompat;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXRefreshLayout extends ViewGroup {
    private static final int L_DOWN = 4;
    private static final int N_DOWN = 1;
    private static final int N_UP = 2;
    private static final int R_UP = 3;
    private final int animateDuration;
    ValueAnimator animatorToFirstFloor;
    ValueAnimator animatorToLoad;
    ValueAnimator animatorToLoadReset;
    ValueAnimator animatorToRefresh;
    ValueAnimator animatorToRefreshReset;
    ValueAnimator animatorToSecondFloor;
    private int dragMode;
    private final float dragRate;
    private boolean forceStopIntercept;
    private boolean isAnimating;
    private boolean isAutoLoad;
    private boolean isCanSecondFloor;
    private boolean isCustom;
    private boolean isInSecondFloor;
    private boolean isLoadEnable;
    private boolean isLoadFixedContent;
    private boolean isLoading;
    private boolean isNestedScrolling;
    private boolean isPullingUp;
    private boolean isRefreshEnable;
    private boolean isRefreshFixedContent;
    private boolean isRefreshing;
    private boolean isTouchDown;
    private float lastMoveY;
    private ListScrollListener listScrollListener;
    private int loadHeight;
    private OnLoadListener loadListener;
    private int loadMidHeight;
    private int loadOffset;
    private final int[] mParentOffsetInWindow;
    private final int[] mParentScrollConsumed;
    private boolean needRequestDisallowIntercept;
    private boolean needStopIntercept;
    private float nestedOverScroll;
    private float overScroll;
    private int refreshHeight;
    private OnRefreshListener refreshListener;
    private int refreshMidHeight;
    private int refreshOffset;
    private int secondFloorHeight;
    private int viewContentHeight;
    private DJXBaseLoadView viewLoad;
    private final RelativeLayout viewLoadContainer;
    private DJXBaseRefreshView viewRefresh;
    private final RelativeLayout viewRefreshContainer;
    private View viewTarget;

    public interface ListScrollListener {
        void onScroll(AbsListView absListView, int i, int i2, int i3);

        void onScrollStateChanged(AbsListView absListView, int i);
    }

    public interface OnLoadListener {
        void onLoad();
    }

    public interface OnRefreshListener {
        void onRefresh();
    }

    protected float getDragRate() {
        return 0.5f;
    }

    public DJXRefreshLayout(Context context) {
        this(context, null);
    }

    public DJXRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.needStopIntercept = false;
        this.forceStopIntercept = false;
        this.needRequestDisallowIntercept = false;
        this.dragRate = 0.5f;
        this.viewContentHeight = 2000;
        this.refreshMidHeight = 170;
        this.loadMidHeight = 170;
        this.secondFloorHeight = 500;
        this.refreshHeight = 150;
        this.loadHeight = 110;
        this.animateDuration = 100;
        this.isCustom = false;
        this.refreshOffset = 0;
        this.loadOffset = 0;
        this.mParentScrollConsumed = new int[2];
        this.mParentOffsetInWindow = new int[2];
        if (Build.VERSION.SDK_INT >= 21) {
            setNestedScrollingEnabled(true);
        }
        this.viewRefresh = new DJXRefreshView(context);
        this.viewLoad = new DJXLoadMoreView(context);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.viewRefreshContainer = relativeLayout;
        relativeLayout.setGravity(17);
        relativeLayout.addView(this.viewRefresh);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        this.viewLoadContainer = relativeLayout2;
        relativeLayout2.setGravity(17);
        relativeLayout2.addView(this.viewLoad);
        relativeLayout2.setVisibility(8);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        ensureTarget();
        ensureRefreshAndLoadContainer();
    }

    public void setNeedRequestDisallowIntercept(boolean z) {
        this.needRequestDisallowIntercept = z;
    }

    public void setPullToRefreshHeight(int i) {
        this.refreshMidHeight = i;
    }

    public void setLoadToRefreshHeight(int i) {
        this.loadMidHeight = i;
    }

    public void setRefreshHeight(int i) {
        this.refreshHeight = i;
    }

    public void setLoadHeight(int i) {
        this.loadHeight = i;
    }

    public void setPullToSecondFloorHeight(int i) {
        this.secondFloorHeight = i;
    }

    public void setBackToFirstFloor() {
        animateToFirstFloor();
    }

    public boolean isSecondFloor() {
        return this.isInSecondFloor;
    }

    public void setIsCanSecondFloor(boolean z) {
        this.isCanSecondFloor = z;
    }

    public void setRefreshFixedContent(boolean z) {
        this.isRefreshFixedContent = z;
    }

    public void setLoadFixedContent(boolean z) {
        this.isLoadFixedContent = z;
    }

    public void setCustom(boolean z) {
        this.isCustom = z;
    }

    public void setRefreshOffset(int i) {
        this.refreshOffset = i;
    }

    public void setLoadOffset(int i) {
        this.loadOffset = i;
    }

    public void setSecondFloorView(View view) {
        DJXBaseRefreshView dJXBaseRefreshView = this.viewRefresh;
        if (dJXBaseRefreshView instanceof DJXRefreshView) {
            ((DJXRefreshView) dJXBaseRefreshView).setSecondFloorView(view);
        } else {
            Log.d("QRefreshLayout", "no DefaultRefreshView, please set secondFloorView by yourself");
        }
    }

    public void setLoadEnable(boolean z) {
        this.isLoadEnable = z;
        if (z) {
            this.viewLoadContainer.setVisibility(0);
        } else {
            this.viewLoadContainer.setVisibility(8);
        }
    }

    public void setRefreshEnable(boolean z) {
        this.isRefreshEnable = z;
        if (z) {
            this.viewRefreshContainer.setVisibility(0);
        } else {
            this.viewRefreshContainer.setVisibility(8);
        }
    }

    public void setAutoLoad(boolean z) {
        this.isAutoLoad = z;
    }

    public void setRefreshView(DJXBaseRefreshView dJXBaseRefreshView) {
        this.viewRefresh = dJXBaseRefreshView;
        this.viewRefreshContainer.removeAllViews();
        this.viewRefreshContainer.addView(this.viewRefresh);
    }

    public void setLoadView(DJXBaseLoadView dJXBaseLoadView) {
        this.viewLoad = dJXBaseLoadView;
        this.viewLoadContainer.removeAllViews();
        this.viewLoadContainer.addView(this.viewLoad);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = ContextCompat.getColor(context, iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setColorSchemeColors(int... iArr) {
        DJXBaseRefreshView dJXBaseRefreshView = this.viewRefresh;
        if (dJXBaseRefreshView instanceof DJXRefreshView) {
            ((DJXRefreshView) dJXBaseRefreshView).setColorSchemeColors(iArr);
        }
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(ContextCompat.getColor(getContext(), i));
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        DJXBaseRefreshView dJXBaseRefreshView = this.viewRefresh;
        if (dJXBaseRefreshView instanceof DJXRefreshView) {
            dJXBaseRefreshView.setBackgroundColor(i);
        }
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.refreshListener = onRefreshListener;
        this.isRefreshEnable = true;
        this.viewRefreshContainer.setVisibility(0);
    }

    public void setOnLoadListener(OnLoadListener onLoadListener) {
        this.loadListener = onLoadListener;
        this.isLoadEnable = true;
        setAutoLoad(true);
        this.viewLoadContainer.setVisibility(0);
    }

    public void setRefreshing(boolean z) {
        if (this.isRefreshEnable) {
            ensureTarget();
            if (z) {
                boolean z2 = this.isRefreshing;
                if (z2 || this.isLoading || this.dragMode != 0 || z2) {
                    return;
                }
                animateToRefresh();
                return;
            }
            this.isRefreshing = false;
            if (this.overScroll >= 0.0f) {
                animateToRefreshReset();
            }
        }
    }

    public boolean isRefreshing() {
        return this.isRefreshing;
    }

    public void setLoading(boolean z) {
        if (this.isLoadEnable) {
            ensureTarget();
            if (z) {
                boolean z2 = this.isLoading;
                if (z2 || this.isRefreshing || this.dragMode != 0 || z2) {
                    return;
                }
                animateToLoad();
                return;
            }
            this.isLoading = false;
            if (this.overScroll <= 0.0f) {
                animateToLoadReset();
            }
        }
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public void setListViewScrollListener(ListScrollListener listScrollListener) {
        this.listScrollListener = listScrollListener;
    }

    public int getRefreshMidHeight() {
        return this.refreshMidHeight;
    }

    public int getLoadMidHeight() {
        return this.loadMidHeight;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.viewContentHeight = measuredHeight;
        if (getChildCount() == 0) {
            return;
        }
        ensureTarget();
        View view = this.viewTarget;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        RelativeLayout relativeLayout = this.viewRefreshContainer;
        int i5 = -this.viewContentHeight;
        int i6 = this.refreshOffset;
        relativeLayout.layout(0, i5 + i6, measuredWidth, i6);
        RelativeLayout relativeLayout2 = this.viewLoadContainer;
        int i7 = this.viewContentHeight;
        int i8 = this.loadOffset;
        relativeLayout2.layout(0, (measuredHeight - (i7 / 2)) + i8, measuredWidth, measuredHeight + (i7 / 2) + i8);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.viewContentHeight = getMeasuredHeight();
        ensureTarget();
        View view = this.viewTarget;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.viewRefreshContainer.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.viewContentHeight, 1073741824));
        this.viewLoadContainer.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.viewContentHeight, 1073741824));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onScroll() {
        if (canChildScrollUp() || !this.isAutoLoad || !this.isLoadEnable || this.isLoading || !this.isPullingUp || this.isTouchDown) {
            return;
        }
        animateToLoad();
    }

    private void ensureTarget() {
        if (this.viewTarget == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (!childAt.equals(this.viewRefreshContainer) && !childAt.equals(this.viewLoadContainer)) {
                    this.viewTarget = childAt;
                    childAt.setClickable(true);
                    setScrollListener();
                    return;
                }
            }
        }
    }

    private void ensureRefreshAndLoadContainer() {
        if (this.viewLoadContainer.getParent() == null) {
            addView(this.viewLoadContainer, 0);
        }
        if (this.viewRefreshContainer.getParent() == null) {
            addView(this.viewRefreshContainer, 0);
        }
    }

    private void setScrollListener() {
        View view = this.viewTarget;
        if (view instanceof ListView) {
            ((ListView) view).setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.bytedance.sdk.djx.core.business.view.refresh.DJXRefreshLayout.1
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                    if (DJXRefreshLayout.this.listScrollListener != null) {
                        DJXRefreshLayout.this.listScrollListener.onScrollStateChanged(absListView, i);
                    }
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (DJXRefreshLayout.this.listScrollListener != null) {
                        DJXRefreshLayout.this.listScrollListener.onScroll(absListView, i, i2, i3);
                    }
                    DJXRefreshLayout.this.onScroll();
                }
            });
        } else if (view instanceof RecyclerView) {
            ((RecyclerView) view).addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.bytedance.sdk.djx.core.business.view.refresh.DJXRefreshLayout.2
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                    DJXRefreshLayout.this.onScroll();
                }
            });
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || this.isAnimating || this.isNestedScrolling || this.isInSecondFloor) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.isTouchDown = true;
            this.lastMoveY = motionEvent.getY();
            this.dragMode = 0;
            if (this.needRequestDisallowIntercept) {
                requestDisallowInterceptTouchEvent(true);
            }
        } else if (actionMasked == 1) {
            this.isTouchDown = false;
        } else if (actionMasked == 2) {
            float y = motionEvent.getY() - this.lastMoveY;
            if (y == 0.0f) {
                return false;
            }
            if (y < 0.0f) {
                this.isPullingUp = true;
            }
            if (y > 0.0f) {
                if (this.overScroll < 0.0f && this.isLoading) {
                    this.dragMode = 4;
                } else if (!canChildScrollDown() && this.isRefreshEnable) {
                    this.dragMode = 1;
                }
            } else if (this.overScroll > 0.0f && this.isRefreshing) {
                this.dragMode = 3;
            } else if (!canChildScrollUp() && this.isLoadEnable) {
                this.dragMode = 2;
            }
            if (this.dragMode != 0) {
                this.lastMoveY = motionEvent.getY();
            }
        }
        return this.dragMode != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0022, code lost:
    
        if (r0 != 3) goto L95;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.djx.core.business.view.refresh.DJXRefreshLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        View view;
        if ((Build.VERSION.SDK_INT < 21 && (this.viewTarget instanceof AbsListView)) || ((view = this.viewTarget) != null && !ViewCompat.isNestedScrollingEnabled(view))) {
            if (this.needStopIntercept || this.forceStopIntercept) {
                super.requestDisallowInterceptTouchEvent(z);
                this.needStopIntercept = false;
                return;
            }
            return;
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (!isEnabled() || this.isRefreshing || this.isLoading || (i & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        super.onNestedScrollAccepted(view, view2, i);
        this.isTouchDown = true;
        startNestedScroll(i & 2);
        this.nestedOverScroll = 0.0f;
        this.isNestedScrolling = true;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return super.getNestedScrollAxes();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        super.onStopNestedScroll(view);
        this.isNestedScrolling = false;
        this.isTouchDown = false;
        onTouchUp();
        this.nestedOverScroll = 0.0f;
        stopNestedScroll();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0) {
            this.isPullingUp = true;
        }
        float f = this.nestedOverScroll;
        if ((f > 0.0f && i2 > 0) || (f < 0.0f && i2 < 0)) {
            float f2 = f - i2;
            this.nestedOverScroll = f2;
            iArr[1] = i2;
            onNestedDraging(f2);
        }
        int[] iArr2 = this.mParentScrollConsumed;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.mParentOffsetInWindow);
        int i5 = i4 + this.mParentOffsetInWindow[1];
        if (i5 > 0 && !canChildScrollUp()) {
            if (i5 > 50) {
                i5 = 50;
            }
            this.nestedOverScroll -= i5;
        }
        if (i5 < 0 && !canChildScrollDown()) {
            if (i5 < -50) {
                i5 = -50;
            }
            this.nestedOverScroll -= i5;
        }
        onNestedDraging(this.nestedOverScroll);
    }

    private void onNestedDraging(float f) {
        float f2 = f * 0.5f * 0.7f;
        this.overScroll = f2;
        if (f2 > 0.0f) {
            if (this.isRefreshEnable) {
                int i = this.viewContentHeight;
                if (f2 > i / 2) {
                    this.overScroll = i / 2;
                }
                this.viewRefreshContainer.setTranslationY(this.overScroll / 2.0f);
                if (!this.isRefreshFixedContent) {
                    this.viewTarget.setTranslationY(this.overScroll);
                }
                this.viewRefresh.setHeight(this.overScroll, this.refreshMidHeight, this.viewContentHeight);
                float f3 = this.overScroll;
                if (f3 <= this.refreshMidHeight) {
                    this.viewRefresh.setPullToRefresh();
                    return;
                } else if (f3 > this.secondFloorHeight && this.isCanSecondFloor && !this.isRefreshing) {
                    this.viewRefresh.setReleaseToSecondFloor();
                    return;
                } else {
                    this.viewRefresh.setReleaseToRefresh();
                    return;
                }
            }
            return;
        }
        if (this.isLoadEnable) {
            int i2 = this.viewContentHeight;
            if (f2 < (-i2) / 2) {
                this.overScroll = (-i2) / 2;
            }
            this.viewLoadContainer.setTranslationY(this.overScroll / 2.0f);
            if (!this.isLoadFixedContent) {
                this.viewTarget.setTranslationY(this.overScroll);
            }
            this.viewLoad.setHeight(Math.abs(this.overScroll), this.loadMidHeight, this.viewContentHeight);
            if (this.overScroll < (-this.loadMidHeight)) {
                this.viewLoad.setReleaseToRefresh();
            } else {
                this.viewLoad.setPullToRefresh();
            }
        }
    }

    private void onTouchUp() {
        float f = this.overScroll;
        if (f == 0.0f) {
            return;
        }
        if (f > 0.0f) {
            if (this.isRefreshEnable) {
                if (f <= this.refreshMidHeight) {
                    if (this.isRefreshing) {
                        return;
                    }
                    animateToRefreshReset();
                    return;
                } else if (f > this.secondFloorHeight && this.isCanSecondFloor && !this.isRefreshing) {
                    animateToSecondFloor();
                    return;
                } else {
                    animateToRefresh();
                    return;
                }
            }
            return;
        }
        if (this.isLoadEnable) {
            if (f < (-this.loadMidHeight)) {
                animateToLoad();
            } else {
                if (this.isLoading) {
                    return;
                }
                animateToLoadReset();
            }
        }
    }

    private void animateToRefresh() {
        if (this.isAnimating) {
            return;
        }
        this.isAnimating = true;
        ValueAnimator valueAnimator = this.animatorToRefresh;
        if (valueAnimator == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(Math.abs(this.overScroll), this.refreshHeight);
            this.animatorToRefresh = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.djx.core.business.view.refresh.DJXRefreshLayout.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float fFloatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    DJXRefreshLayout.this.overScroll = fFloatValue;
                    DJXRefreshLayout.this.viewRefreshContainer.setTranslationY(DJXRefreshLayout.this.overScroll / 2.0f);
                    if (!DJXRefreshLayout.this.isRefreshing) {
                        DJXRefreshLayout.this.viewRefresh.setHeight(DJXRefreshLayout.this.overScroll, DJXRefreshLayout.this.refreshMidHeight, DJXRefreshLayout.this.viewContentHeight);
                    }
                    if (!DJXRefreshLayout.this.isRefreshFixedContent) {
                        DJXRefreshLayout.this.viewTarget.setTranslationY(DJXRefreshLayout.this.overScroll);
                    }
                    if (fFloatValue == DJXRefreshLayout.this.refreshHeight) {
                        DJXRefreshLayout.this.isAnimating = false;
                        if (DJXRefreshLayout.this.isRefreshing) {
                            return;
                        }
                        DJXRefreshLayout.this.viewRefresh.setRefresh();
                        DJXRefreshLayout.this.isRefreshing = true;
                        if (DJXRefreshLayout.this.refreshListener != null) {
                            DJXRefreshLayout.this.refreshListener.onRefresh();
                        }
                    }
                }
            });
            this.animatorToRefresh.setDuration(100L);
        } else {
            valueAnimator.setFloatValues(Math.abs(this.overScroll), this.refreshHeight);
        }
        this.animatorToRefresh.start();
    }

    private void animateToLoad() {
        if (this.isAnimating) {
            return;
        }
        this.isAnimating = true;
        ValueAnimator valueAnimator = this.animatorToLoad;
        if (valueAnimator == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.overScroll, -this.loadHeight);
            this.animatorToLoad = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.djx.core.business.view.refresh.DJXRefreshLayout.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float fFloatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    DJXRefreshLayout.this.overScroll = fFloatValue;
                    DJXRefreshLayout.this.viewLoadContainer.setTranslationY(DJXRefreshLayout.this.overScroll / 2.0f);
                    if (!DJXRefreshLayout.this.isLoading) {
                        DJXRefreshLayout.this.viewLoad.setHeight(Math.abs(DJXRefreshLayout.this.overScroll), DJXRefreshLayout.this.loadMidHeight, DJXRefreshLayout.this.viewContentHeight);
                    }
                    if (!DJXRefreshLayout.this.isLoadFixedContent) {
                        DJXRefreshLayout.this.viewTarget.setTranslationY(DJXRefreshLayout.this.overScroll);
                    }
                    if (fFloatValue == (-DJXRefreshLayout.this.loadHeight)) {
                        if (!DJXRefreshLayout.this.isLoading) {
                            DJXRefreshLayout.this.viewLoad.setRefresh();
                            DJXRefreshLayout.this.isLoading = true;
                            if (DJXRefreshLayout.this.loadListener != null) {
                                DJXRefreshLayout.this.loadListener.onLoad();
                            }
                        }
                        DJXRefreshLayout.this.isAnimating = false;
                    }
                }
            });
            this.animatorToLoad.setDuration(100L);
        } else {
            valueAnimator.setFloatValues(this.overScroll, -this.loadHeight);
        }
        this.animatorToLoad.start();
        this.isPullingUp = false;
    }

    private void animateToRefreshReset() {
        float f = this.overScroll;
        if (f == 0.0f) {
            this.isRefreshing = false;
            return;
        }
        if (this.isAnimating) {
            return;
        }
        this.isAnimating = true;
        ValueAnimator valueAnimator = this.animatorToRefreshReset;
        if (valueAnimator == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(Math.abs(f), 0.0f);
            this.animatorToRefreshReset = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.djx.core.business.view.refresh.DJXRefreshLayout.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float fFloatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    DJXRefreshLayout.this.overScroll = fFloatValue;
                    DJXRefreshLayout.this.viewRefreshContainer.setTranslationY(DJXRefreshLayout.this.overScroll / 2.0f);
                    DJXRefreshLayout.this.viewRefresh.setHeight(DJXRefreshLayout.this.overScroll, DJXRefreshLayout.this.refreshMidHeight, DJXRefreshLayout.this.viewContentHeight);
                    if (!DJXRefreshLayout.this.isRefreshFixedContent) {
                        DJXRefreshLayout.this.viewTarget.setTranslationY(DJXRefreshLayout.this.overScroll);
                    }
                    DJXRefreshLayout.this.isRefreshing = false;
                    if (fFloatValue == 0.0f) {
                        DJXRefreshLayout.this.isAnimating = false;
                    }
                }
            });
            this.animatorToRefreshReset.setDuration(100L);
        } else {
            valueAnimator.setFloatValues(Math.abs(f), 0.0f);
        }
        this.animatorToRefreshReset.start();
    }

    private void animateToLoadReset() {
        float f = this.overScroll;
        if (f == 0.0f) {
            this.isLoading = false;
            return;
        }
        if (this.isAnimating) {
            return;
        }
        this.isAnimating = true;
        ValueAnimator valueAnimator = this.animatorToLoadReset;
        if (valueAnimator == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, 0.0f);
            this.animatorToLoadReset = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.djx.core.business.view.refresh.DJXRefreshLayout.6
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float fFloatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    DJXRefreshLayout.this.overScroll = fFloatValue;
                    DJXRefreshLayout.this.viewLoadContainer.setTranslationY(DJXRefreshLayout.this.overScroll / 2.0f);
                    DJXRefreshLayout.this.viewLoad.setHeight(Math.abs(DJXRefreshLayout.this.overScroll), DJXRefreshLayout.this.loadMidHeight, DJXRefreshLayout.this.viewContentHeight);
                    if (!DJXRefreshLayout.this.isLoadFixedContent) {
                        DJXRefreshLayout.this.viewTarget.setTranslationY(DJXRefreshLayout.this.overScroll);
                    }
                    DJXRefreshLayout.this.isLoading = false;
                    if (fFloatValue == 0.0f) {
                        DJXRefreshLayout.this.isAnimating = false;
                    }
                }
            });
            this.animatorToLoadReset.setDuration(100L);
        } else {
            valueAnimator.setFloatValues(f, 0.0f);
        }
        this.animatorToLoadReset.start();
    }

    private void animateToSecondFloor() {
        if (this.isAnimating) {
            return;
        }
        this.isAnimating = true;
        ValueAnimator valueAnimator = this.animatorToSecondFloor;
        if (valueAnimator == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.overScroll, this.viewContentHeight);
            this.animatorToSecondFloor = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.djx.core.business.view.refresh.DJXRefreshLayout.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float fFloatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    DJXRefreshLayout.this.overScroll = fFloatValue;
                    DJXRefreshLayout.this.viewRefreshContainer.setTranslationY(DJXRefreshLayout.this.overScroll);
                    DJXRefreshLayout.this.viewLoadContainer.setTranslationY(DJXRefreshLayout.this.overScroll);
                    DJXRefreshLayout.this.viewRefresh.setHeight(Math.abs(DJXRefreshLayout.this.overScroll), DJXRefreshLayout.this.loadMidHeight, DJXRefreshLayout.this.viewContentHeight);
                    if (!DJXRefreshLayout.this.isRefreshFixedContent) {
                        DJXRefreshLayout.this.viewTarget.setTranslationY(DJXRefreshLayout.this.overScroll);
                    }
                    if (fFloatValue == DJXRefreshLayout.this.viewContentHeight) {
                        DJXRefreshLayout.this.isAnimating = false;
                        DJXRefreshLayout.this.isInSecondFloor = true;
                        DJXRefreshLayout.this.viewRefresh.setToSecondFloor();
                    }
                }
            });
            this.animatorToSecondFloor.setDuration(100L);
        } else {
            valueAnimator.setFloatValues(this.overScroll, this.viewContentHeight);
        }
        this.animatorToSecondFloor.start();
    }

    private void animateToFirstFloor() {
        if (this.isAnimating) {
            return;
        }
        this.isAnimating = true;
        ValueAnimator valueAnimator = this.animatorToFirstFloor;
        if (valueAnimator == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.viewContentHeight, 0.0f);
            this.animatorToFirstFloor = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.djx.core.business.view.refresh.DJXRefreshLayout.8
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float fFloatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    DJXRefreshLayout.this.overScroll = fFloatValue;
                    DJXRefreshLayout.this.viewRefreshContainer.setTranslationY(DJXRefreshLayout.this.overScroll);
                    DJXRefreshLayout.this.viewLoadContainer.setTranslationY(DJXRefreshLayout.this.overScroll);
                    DJXRefreshLayout.this.viewRefresh.setHeight(Math.abs(DJXRefreshLayout.this.overScroll), DJXRefreshLayout.this.loadMidHeight, DJXRefreshLayout.this.viewContentHeight);
                    if (!DJXRefreshLayout.this.isRefreshFixedContent) {
                        DJXRefreshLayout.this.viewTarget.setTranslationY(DJXRefreshLayout.this.overScroll);
                    }
                    if (fFloatValue == 0.0f) {
                        DJXRefreshLayout.this.isAnimating = false;
                        DJXRefreshLayout.this.isInSecondFloor = false;
                        DJXRefreshLayout.this.viewRefresh.setToFirstFloor();
                    }
                }
            });
        } else {
            valueAnimator.setFloatValues(this.overScroll, 0.0f);
        }
        this.animatorToFirstFloor.start();
    }

    private void reset() {
        ValueAnimator valueAnimator = this.animatorToRefresh;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.animatorToRefreshReset;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        ValueAnimator valueAnimator3 = this.animatorToLoad;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
        }
        ValueAnimator valueAnimator4 = this.animatorToLoadReset;
        if (valueAnimator4 != null) {
            valueAnimator4.cancel();
        }
        ValueAnimator valueAnimator5 = this.animatorToSecondFloor;
        if (valueAnimator5 != null) {
            valueAnimator5.cancel();
        }
        RelativeLayout relativeLayout = this.viewRefreshContainer;
        if (relativeLayout != null) {
            relativeLayout.setTranslationY(0.0f);
        }
        RelativeLayout relativeLayout2 = this.viewLoadContainer;
        if (relativeLayout2 != null) {
            relativeLayout2.setTranslationY(0.0f);
        }
        View view = this.viewTarget;
        if (view != null) {
            view.setTranslationY(0.0f);
        }
    }

    private boolean canChildScrollDown() {
        View view = this.viewTarget;
        if (view instanceof ListView) {
            return ListViewCompat.canScrollList((ListView) view, -1);
        }
        return view.canScrollVertically(-1);
    }

    public void setNeedStopIntercept(boolean z) {
        this.needStopIntercept = z;
    }

    public void setForceStopIntercept(boolean z) {
        this.forceStopIntercept = z;
    }

    private boolean canChildScrollUp() {
        View view = this.viewTarget;
        if (view instanceof ListView) {
            return ListViewCompat.canScrollList((ListView) view, 1);
        }
        return view.canScrollVertically(1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }
}

package com.kwad.components.ct.refreshview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.kwad.sdk.utils.ax;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class RefreshLayout extends ViewGroup implements NestedScrollingChild, NestedScrollingParent {
    private final String TAG;
    private b aKD;
    private View aSA;
    private boolean aSB;
    private boolean aSC;
    private boolean aSD;
    private RefreshStyle aSE;
    private View aSF;
    private ValueAnimator aSG;
    private com.kwad.components.ct.refreshview.b aSH;
    private final Animation.AnimationListener aSI;
    private d aSJ;
    private c aSK;
    private List<c> aSL;
    protected final Animation.AnimationListener aSM;
    private Interpolator aSN;
    private Interpolator aSO;
    private boolean aSP;
    private boolean aSQ;
    private final Animation aSR;
    private final Animation aSS;
    private boolean aST;
    private final int[] aSc;
    private final int[] aSd;
    private final NestedScrollingChildHelper aSe;
    protected int aSf;
    protected float aSg;
    protected float aSh;
    public View aSi;
    public com.kwad.components.ct.refreshview.d aSj;
    private float aSk;
    private boolean aSl;
    private boolean aSm;
    private boolean aSn;
    private boolean aSo;
    private boolean aSp;
    private boolean aSq;
    private int aSr;
    private int aSs;
    private int aSt;
    private float aSu;
    private float aSv;
    private float aSw;
    private float aSx;
    private float aSy;
    private float aSz;
    private float jo;
    private int mActivePointerId;
    private int mFrom;
    private boolean mIsBeingDragged;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;
    private int mTouchSlop;

    public enum RefreshStyle {
        NORMAL,
        PINNED,
        FLOAT
    }

    public interface b {
        void onRefresh();
    }

    public interface c {
    }

    public interface d {
        boolean JG();
    }

    protected abstract com.kwad.components.ct.refreshview.b GR();

    protected abstract View IE();

    @Override // android.view.ViewGroup
    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return JF();
    }

    @Override // android.view.ViewGroup
    protected /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return b(layoutParams);
    }

    /* renamed from: com.kwad.components.ct.refreshview.RefreshLayout$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] aSV;

        static {
            int[] iArr = new int[RefreshStyle.values().length];
            aSV = iArr;
            try {
                iArr[RefreshStyle.FLOAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                aSV[RefreshStyle.PINNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public RefreshLayout(Context context) {
        this(context, null);
    }

    public RefreshLayout(Context context, AttributeSet attributeSet) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super(context, attributeSet);
        this.TAG = "RefreshLayout";
        this.aSc = new int[2];
        this.aSd = new int[2];
        this.aSr = -1;
        this.mActivePointerId = -1;
        this.aSs = 300;
        this.aSt = 500;
        this.aSB = false;
        this.aSC = false;
        this.aSD = false;
        this.aSE = RefreshStyle.NORMAL;
        this.aSG = null;
        this.aSI = new Animation.AnimationListener() { // from class: com.kwad.components.ct.refreshview.RefreshLayout.1
            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationStart(Animation animation) {
                RefreshLayout.this.aSm = true;
                RefreshLayout.this.aSj.GT();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation) {
                if (RefreshLayout.this.aSp && RefreshLayout.this.aKD != null) {
                    RefreshLayout.this.aKD.onRefresh();
                }
                RefreshLayout.this.aSm = false;
            }
        };
        this.aSM = new Animation.AnimationListener() { // from class: com.kwad.components.ct.refreshview.RefreshLayout.2
            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationStart(Animation animation) {
                RefreshLayout.this.aSm = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation) {
                RefreshLayout.this.reset();
                if (RefreshLayout.this.aSK != null) {
                    c unused = RefreshLayout.this.aSK;
                }
                if (RefreshLayout.this.aSL != null) {
                    for (int i = 0; i < RefreshLayout.this.aSL.size(); i++) {
                        RefreshLayout.this.aSL.get(i);
                    }
                }
            }
        };
        this.aSN = new DecelerateInterpolator(2.0f);
        this.aSO = new DecelerateInterpolator(2.0f);
        this.aSQ = true;
        this.aSR = new Animation() { // from class: com.kwad.components.ct.refreshview.RefreshLayout.3
            @Override // android.view.animation.Animation
            protected final void applyTransformation(float f, Transformation transformation) {
                if (RefreshLayout.this.aSF == null) {
                    return;
                }
                if (AnonymousClass6.aSV[RefreshLayout.this.aSE.ordinal()] == 1) {
                    float f2 = RefreshLayout.this.aSh + RefreshLayout.this.aSx;
                    RefreshLayout.this.b(f2, r0.aSi.getTop(), f);
                } else {
                    RefreshLayout refreshLayout = RefreshLayout.this;
                    refreshLayout.b(refreshLayout.aSh, RefreshLayout.this.aSF.getTop(), f);
                }
            }
        };
        this.aSS = new Animation() { // from class: com.kwad.components.ct.refreshview.RefreshLayout.4
            @Override // android.view.animation.Animation
            protected final void applyTransformation(float f, Transformation transformation) {
                if (RefreshLayout.this.aSF == null) {
                    return;
                }
                if (AnonymousClass6.aSV[RefreshLayout.this.aSE.ordinal()] == 1) {
                    RefreshLayout refreshLayout = RefreshLayout.this;
                    refreshLayout.b(refreshLayout.aSx, RefreshLayout.this.aSi.getTop(), f);
                } else {
                    RefreshLayout.this.b(0.0f, r4.aSF.getTop(), f);
                }
            }
        };
        this.aST = true;
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.aSf = (int) (displayMetrics.density * 70.0f);
        this.aSh = displayMetrics.density * 70.0f;
        this.aSg = 0.0f;
        com.kwad.sdk.core.d.c.i("RefreshLayout", "constructor: " + this.aSg);
        this.aSx = 0.0f;
        this.aSy = 1.0f;
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        this.aSe = new NestedScrollingChildHelper(this);
        a(attributeSet);
        Jx();
        setNestedScrollingEnabled(true);
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f, float f2, float f3) {
        int i = this.mFrom;
        setTargetOrRefreshViewOffsetY((int) (((int) (i + ((f - i) * f3))) - f2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        reset();
        this.aKD = null;
        clearAnimation();
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        Jw();
        this.aSw = 0.0f;
        this.aSz = 0.0f;
        this.aSj.reset();
        this.aSi.setVisibility(8);
        this.aSn = false;
        this.aSm = false;
        com.kwad.sdk.core.d.c.i("RefreshLayout", "reset");
    }

    private void Jw() {
        if (AnonymousClass6.aSV[this.aSE.ordinal()] == 1) {
            setTargetOrRefreshViewOffsetY((int) (this.aSx - this.aSg));
        } else {
            setTargetOrRefreshViewOffsetY((int) (0.0f - this.aSg));
        }
    }

    protected void a(AttributeSet attributeSet) {
        View viewIE = IE();
        this.aSi = viewIE;
        viewIE.setVisibility(8);
        KeyEvent.Callback callback = this.aSi;
        if (callback instanceof com.kwad.components.ct.refreshview.d) {
            this.aSj = (com.kwad.components.ct.refreshview.d) callback;
            int i = this.aSf;
            addView(this.aSi, new a(i, i));
            return;
        }
        throw new ClassCastException("the refreshView must implement the interface IRefreshStatus");
    }

    private void Jx() {
        this.aSH = GR();
    }

    public void setDragDistanceConverter(com.kwad.components.ct.refreshview.b bVar) {
        ax.checkNotNull(bVar);
        this.aSH = bVar;
    }

    public void setAnimateToStartInterpolator(Interpolator interpolator) {
        this.aSN = interpolator;
    }

    public void setAnimateToRefreshInterpolator(Interpolator interpolator) {
        this.aSO = interpolator;
    }

    public void setAnimateToStartDuration(int i) {
        this.aSs = i;
    }

    public void setAnimateToRefreshDuration(int i) {
        this.aSt = i;
    }

    public float getRefreshTargetOffset() {
        return this.aSh;
    }

    public void setRefreshTargetOffset(float f) {
        this.aSh = f;
        this.aSB = true;
        requestLayout();
    }

    public void setRefreshInitialOffset(float f) {
        this.aSx = f;
        this.aSC = true;
        requestLayout();
    }

    public void setIsStopNestScrollWhenUpOrCancel(boolean z) {
        this.aST = z;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        if (AnonymousClass6.aSV[this.aSE.ordinal()] == 1) {
            int i3 = this.aSr;
            return i3 < 0 ? i2 : i2 == i - 1 ? i3 : i2 >= i3 ? i2 + 1 : i2;
        }
        int i4 = this.aSr;
        return i4 < 0 ? i2 : i2 == 0 ? i4 : i2 <= i4 ? i2 - 1 : i2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.aSF instanceof AbsListView)) {
            View view = this.aSF;
            if (view == null || ViewCompat.isNestedScrollingEnabled(view)) {
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return AnonymousClass6.aSV[this.aSE.ordinal()] != 1 ? isEnabled() && T(this.aSF) && (i & 2) != 0 : isEnabled() && T(this.aSF) && !this.aSn && (i & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(view, view2, i);
        startNestedScroll(i & 2);
        this.aSk = 0.0f;
        this.aSl = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0) {
            float f = this.aSk;
            if (f > 0.0f) {
                float f2 = i2;
                if (f2 > f) {
                    iArr[1] = i2 - ((int) f);
                    this.aSk = 0.0f;
                } else {
                    this.aSk = f - f2;
                    iArr[1] = i2;
                }
                com.kwad.sdk.core.d.c.i("RefreshLayout", "pre scroll");
                a(this.aSk, false);
            }
        }
        int[] iArr2 = this.aSc;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(view);
        this.aSl = false;
        if (this.aSk > 0.0f) {
            JA();
            this.aSk = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.aSd);
        if (i4 + this.aSd[1] < 0) {
            this.aSk += Math.abs(r11);
            com.kwad.sdk.core.d.c.i("RefreshLayout", "nested scroll");
            a(this.aSk, true);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.aSe.isNestedScrollingEnabled();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.aSe.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.aSe.startNestedScroll(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.aSe.stopNestedScroll();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.aSe.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.aSe.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.aSe.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.aSe.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.aSe.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view;
        if (getChildCount() == 0) {
            return;
        }
        JD();
        if (this.aSF == null) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (this.aSF.getVisibility() != 8 || ((view = this.aSA) != null && view.getVisibility() != 8)) {
            int iCI = cI(getPaddingTop());
            int paddingLeft = getPaddingLeft();
            int paddingLeft2 = ((paddingLeft + measuredWidth) - getPaddingLeft()) - getPaddingRight();
            int paddingTop = ((measuredHeight + iCI) - getPaddingTop()) - getPaddingBottom();
            if (this.aSF.getVisibility() != 8) {
                this.aSF.layout(paddingLeft, iCI, paddingLeft2, paddingTop);
            }
            View view2 = this.aSA;
            if (view2 != null && view2.getVisibility() != 8) {
                this.aSA.layout(paddingLeft, iCI, paddingLeft2, paddingTop);
            }
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.aSi.getLayoutParams();
        int measuredWidth2 = (measuredWidth - this.aSi.getMeasuredWidth()) / 2;
        int iCt = (ct((int) this.aSx) + marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin;
        this.aSi.layout(measuredWidth2, iCt, (measuredWidth + this.aSi.getMeasuredWidth()) / 2, this.aSi.getMeasuredHeight() + iCt);
    }

    private int cI(int i) {
        float f;
        int i2 = AnonymousClass6.aSV[this.aSE.ordinal()];
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            f = this.aSg;
        } else {
            f = this.aSg;
        }
        return i + ((int) f);
    }

    protected int ct(int i) {
        int i2 = AnonymousClass6.aSV[this.aSE.ordinal()];
        if (i2 != 1 && i2 == 2) {
            return i;
        }
        float f = this.aSg;
        return i + ((int) f);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        JD();
        if (this.aSF == null) {
            return;
        }
        Jy();
        JC();
        B(i, i2);
        if (!this.aSD && !this.aSC) {
            int i3 = AnonymousClass6.aSV[this.aSE.ordinal()];
            if (i3 == 1) {
                float f = -this.aSi.getMeasuredHeight();
                this.aSx = f;
                this.aSg = f;
            } else if (i3 == 2) {
                this.aSx = 0.0f;
                this.aSg = 0.0f;
            } else {
                this.aSg = 0.0f;
                this.aSx = -this.aSi.getMeasuredHeight();
            }
        }
        if (!this.aSD && !this.aSB && this.aSh < this.aSi.getMeasuredHeight()) {
            this.aSh = this.aSi.getMeasuredHeight();
        }
        this.aSD = true;
        this.aSr = -1;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if (getChildAt(i4) == this.aSi) {
                this.aSr = i4;
                return;
            }
        }
    }

    private void Jy() {
        this.aSF.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
    }

    private void B(int i, int i2) {
        int childMeasureSpec;
        int childMeasureSpec2;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.aSi.getLayoutParams();
        if (marginLayoutParams.width == -1) {
            childMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin), 1073741824);
        } else {
            childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width);
        }
        if (marginLayoutParams.height == -1) {
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin), 1073741824);
        } else {
            childMeasureSpec2 = getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
        }
        this.aSi.measure(childMeasureSpec, childMeasureSpec2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked;
        if (this.aST && ((actionMasked = MotionEventCompat.getActionMasked(motionEvent)) == 1 || actionMasked == 3)) {
            onStopNestedScroll(this);
        }
        com.kwad.sdk.core.d.c.i("RefreshLayout", "dispatch " + this.aSq + " isRefreshing" + this.aSn);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0095  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            r5.JD()
            android.view.View r0 = r5.aSF
            r1 = 0
            if (r0 != 0) goto L9
            return r1
        L9:
            boolean r2 = r0 instanceof com.kwad.components.ct.refreshview.c
            if (r2 == 0) goto L16
            com.kwad.components.ct.refreshview.c r0 = (com.kwad.components.ct.refreshview.c) r0
            boolean r0 = r0.Jv()
            if (r0 != 0) goto L16
            return r1
        L16:
            int[] r0 = com.kwad.components.ct.refreshview.RefreshLayout.AnonymousClass6.aSV
            com.kwad.components.ct.refreshview.RefreshLayout$RefreshStyle r2 = r5.aSE
            int r2 = r2.ordinal()
            r0 = r0[r2]
            r2 = 1
            if (r0 == r2) goto L36
            boolean r0 = r5.isEnabled()
            if (r0 == 0) goto L35
            android.view.View r0 = r5.aSF
            boolean r0 = r5.T(r0)
            if (r0 == 0) goto L4e
            boolean r0 = r5.aSq
            if (r0 != 0) goto L4e
        L35:
            return r1
        L36:
            boolean r0 = r5.isEnabled()
            if (r0 == 0) goto Lc8
            android.view.View r0 = r5.aSF
            boolean r0 = r5.T(r0)
            if (r0 != 0) goto Lc8
            boolean r0 = r5.aSn
            if (r0 != 0) goto Lc8
            boolean r0 = r5.aSl
            if (r0 == 0) goto L4e
            goto Lc8
        L4e:
            int r0 = androidx.core.view.MotionEventCompat.getActionMasked(r6)
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r0 == 0) goto L9a
            r4 = -1
            if (r0 == r2) goto L95
            r2 = 2
            if (r0 == r2) goto L67
            r2 = 3
            if (r0 == r2) goto L95
            r1 = 6
            if (r0 == r1) goto L63
            goto Lc5
        L63:
            r5.g(r6)
            goto Lc5
        L67:
            int r0 = r5.mActivePointerId
            if (r0 != r4) goto L6c
            return r1
        L6c:
            float r6 = a(r6, r0)
            int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r0 != 0) goto L75
            return r1
        L75:
            r5.z(r6)
            android.animation.ValueAnimator r6 = r5.aSG
            if (r6 == 0) goto Lc5
            boolean r6 = r6.isRunning()
            if (r6 == 0) goto Lc5
            android.animation.ValueAnimator r6 = r5.aSG
            r6.cancel()
            com.kwad.components.ct.refreshview.d r6 = r5.aSj
            r6.GU()
            float r6 = r5.aSg
            int r6 = (int) r6
            android.view.animation.Animation$AnimationListener r0 = r5.aSM
            r5.a(r6, r0)
            goto Lc5
        L95:
            r5.mIsBeingDragged = r1
            r5.mActivePointerId = r4
            goto Lc5
        L9a:
            int r0 = r6.getPointerId(r1)
            r5.mActivePointerId = r0
            r5.mIsBeingDragged = r1
            float r6 = a(r6, r0)
            int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r0 != 0) goto Lab
            return r1
        Lab:
            android.view.animation.Animation r0 = r5.aSR
            boolean r0 = r0.hasEnded()
            if (r0 == 0) goto Lbd
            android.view.animation.Animation r0 = r5.aSS
            boolean r0 = r0.hasEnded()
            if (r0 == 0) goto Lbd
            r5.aSm = r1
        Lbd:
            r5.aSu = r6
            float r6 = r5.aSg
            r5.aSv = r6
            r5.aSq = r1
        Lc5:
            boolean r6 = r5.mIsBeingDragged
            return r6
        Lc8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ct.refreshview.RefreshLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float targetOrRefreshViewTop;
        JD();
        if (this.aSF == null) {
            return false;
        }
        if (AnonymousClass6.aSV[this.aSE.ordinal()] == 1) {
            if (!isEnabled() || T(this.aSF) || this.aSl) {
                return false;
            }
        } else if (!isEnabled() || (T(this.aSF) && !this.aSq)) {
            return false;
        }
        if (this.aSE == RefreshStyle.FLOAT && (T(this.aSF) || this.aSl)) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            this.mIsBeingDragged = false;
        } else {
            if (action != 1) {
                if (action == 2) {
                    int i = this.mActivePointerId;
                    if (i == -1) {
                        return false;
                    }
                    float fA = a(motionEvent, i);
                    if (fA == -1.0f) {
                        return false;
                    }
                    if (this.aSm) {
                        targetOrRefreshViewTop = getTargetOrRefreshViewTop();
                        this.jo = fA;
                        this.aSv = targetOrRefreshViewTop;
                        com.kwad.sdk.core.d.c.i("RefreshLayout", "animatetostart overscrolly " + targetOrRefreshViewTop + " -- " + this.jo);
                    } else {
                        targetOrRefreshViewTop = (fA - this.jo) + this.aSv;
                        com.kwad.sdk.core.d.c.i("RefreshLayout", "overscrolly " + targetOrRefreshViewTop + " --" + this.jo + " -- " + this.aSv);
                    }
                    if (this.aSn) {
                        if (targetOrRefreshViewTop <= 0.0f) {
                            if (this.aSq) {
                                this.aSF.dispatchTouchEvent(motionEvent);
                            } else {
                                MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                                motionEventObtain.setAction(0);
                                this.aSq = true;
                                this.aSF.dispatchTouchEvent(motionEventObtain);
                            }
                        } else if (targetOrRefreshViewTop > 0.0f && targetOrRefreshViewTop < this.aSh && this.aSq) {
                            MotionEvent motionEventObtain2 = MotionEvent.obtain(motionEvent);
                            motionEventObtain2.setAction(3);
                            this.aSq = false;
                            this.aSF.dispatchTouchEvent(motionEventObtain2);
                        }
                        com.kwad.sdk.core.d.c.i("RefreshLayout", "moveSpinner refreshing -- " + this.aSv + " -- " + (fA - this.jo));
                        a(targetOrRefreshViewTop, true);
                    } else if (!this.mIsBeingDragged) {
                        com.kwad.sdk.core.d.c.i("RefreshLayout", "is not Being Dragged, init drag status");
                        z(fA);
                    } else if (targetOrRefreshViewTop > 0.0f) {
                        a(targetOrRefreshViewTop, true);
                        com.kwad.sdk.core.d.c.i("RefreshLayout", "moveSpinner not refreshing -- " + this.aSv + " -- " + (fA - this.jo));
                    } else {
                        com.kwad.sdk.core.d.c.i("RefreshLayout", "is Being Dragged, but over scroll Y < 0");
                        return false;
                    }
                } else if (action != 3) {
                    if (action == 5) {
                        h(motionEvent);
                    } else if (action == 6) {
                        g(motionEvent);
                    }
                }
            }
            int i2 = this.mActivePointerId;
            if (i2 == -1 || a(motionEvent, i2) == -1.0f) {
                Jz();
                return false;
            }
            if (this.aSn || this.aSm) {
                if (this.aSq) {
                    this.aSF.dispatchTouchEvent(motionEvent);
                }
                Jz();
                return false;
            }
            Jz();
            JA();
            return false;
        }
        return true;
    }

    private void Jz() {
        this.aSv = 0.0f;
        this.mIsBeingDragged = false;
        this.aSq = false;
        this.mActivePointerId = -1;
    }

    private void q(boolean z, boolean z2) {
        if (this.aSn != z) {
            this.aSp = z2;
            this.aSn = z;
            if (z) {
                b((int) this.aSg, this.aSI);
            } else {
                this.aSj.GU();
                postDelayed(new Runnable() { // from class: com.kwad.components.ct.refreshview.RefreshLayout.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        RefreshLayout refreshLayout = RefreshLayout.this;
                        refreshLayout.a((int) refreshLayout.aSg, RefreshLayout.this.aSM);
                    }
                }, this.aSj.GV());
            }
        }
    }

    public void setOnlySupportPull(boolean z) {
        this.aSP = z;
    }

    private void z(float f) {
        float f2 = this.aSu;
        float f3 = f - f2;
        if (this.aSn) {
            int i = this.mTouchSlop;
            if (f3 > i || this.aSg > 0.0f) {
                this.mIsBeingDragged = true;
                this.jo = f2 + i;
                return;
            }
        }
        if (this.mIsBeingDragged) {
            return;
        }
        int i2 = this.mTouchSlop;
        if (f3 > i2) {
            this.jo = f2 + i2;
            this.mIsBeingDragged = true;
        }
    }

    protected void a(int i, Animation.AnimationListener animationListener) {
        clearAnimation();
        if (B(i) <= 0) {
            animationListener.onAnimationStart(null);
            animationListener.onAnimationEnd(null);
            return;
        }
        this.mFrom = i;
        this.aSS.reset();
        this.aSS.setDuration(B(r0));
        this.aSS.setInterpolator(this.aSN);
        if (animationListener != null) {
            this.aSS.setAnimationListener(animationListener);
        }
        startAnimation(this.aSS);
    }

    private void b(int i, Animation.AnimationListener animationListener) {
        clearAnimation();
        if (A(i) <= 0) {
            animationListener.onAnimationStart(null);
            animationListener.onAnimationEnd(null);
            return;
        }
        this.mFrom = i;
        this.aSR.reset();
        this.aSR.setDuration(A(r0));
        this.aSR.setInterpolator(this.aSO);
        if (animationListener != null) {
            this.aSR.setAnimationListener(animationListener);
        }
        startAnimation(this.aSR);
    }

    private int A(float f) {
        float fMax;
        int i;
        com.kwad.sdk.core.d.c.i("RefreshLayout", "from -- refreshing " + f);
        if (AnonymousClass6.aSV[this.aSE.ordinal()] == 1) {
            fMax = Math.max(0.0f, Math.min(1.0f, Math.abs((f - this.aSx) - this.aSh) / this.aSh));
            i = this.aSt;
        } else {
            fMax = Math.max(0.0f, Math.min(1.0f, Math.abs(f - this.aSh) / this.aSh));
            i = this.aSt;
        }
        return (int) (fMax * i);
    }

    private int B(float f) {
        float fMax;
        int i;
        com.kwad.sdk.core.d.c.i("RefreshLayout", "from -- start " + f);
        if (f < this.aSx) {
            return 0;
        }
        if (AnonymousClass6.aSV[this.aSE.ordinal()] == 1) {
            fMax = Math.max(0.0f, Math.min(1.0f, Math.abs(f - this.aSx) / this.aSh));
            i = this.aSs;
        } else {
            fMax = Math.max(0.0f, Math.min(1.0f, Math.abs(f) / this.aSh));
            i = this.aSs;
        }
        return (int) (fMax * i);
    }

    private void a(float f, boolean z) {
        this.aSw = f;
        d dVar = this.aSJ;
        if (dVar == null || !dVar.JG()) {
            float fW = 0.0f;
            if (!this.aSn) {
                if (AnonymousClass6.aSV[this.aSE.ordinal()] == 1) {
                    fW = this.aSH.w(f) + this.aSx;
                } else {
                    fW = this.aSH.w(f);
                }
            } else {
                float f2 = this.aSh;
                if (f <= f2) {
                    f2 = f;
                }
                if (f2 >= 0.0f) {
                    fW = f2;
                }
            }
            float f3 = this.aSh;
            if (!this.aSn) {
                int i = 0;
                if (fW > f3 && !this.aSo) {
                    this.aSo = true;
                    if (this.aSL != null) {
                        while (i < this.aSL.size()) {
                            this.aSL.get(i);
                            i++;
                        }
                    }
                } else if (fW <= f3 && this.aSo) {
                    this.aSo = false;
                    if (this.aSL != null) {
                        while (i < this.aSL.size()) {
                            this.aSL.get(i);
                            i++;
                        }
                    }
                }
            }
            com.kwad.sdk.core.d.c.i("RefreshLayout", f + " -- " + f3 + " -- " + fW + " -- " + this.aSg + " -- " + this.aSh);
            j((int) (fW - this.aSg), z);
        }
    }

    private void JA() {
        if (this.aSn || this.aSm) {
            return;
        }
        d dVar = this.aSJ;
        if (dVar == null || !dVar.JG()) {
            if (JB()) {
                q(true, true);
            } else {
                this.aSn = false;
                a((int) this.aSg, this.aSM);
            }
        }
    }

    private boolean JB() {
        return !this.aSP && ((float) getTargetOrRefreshViewOffset()) > this.aSh;
    }

    private void h(MotionEvent motionEvent) {
        int pointerId = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
        this.mActivePointerId = pointerId;
        this.jo = a(motionEvent, pointerId) - this.aSw;
        com.kwad.sdk.core.d.c.i("RefreshLayout", " onDown " + this.jo);
    }

    private void g(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.mActivePointerId) {
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex == 0 ? 1 : 0);
        }
        this.jo = a(motionEvent, this.mActivePointerId) - this.aSw;
        com.kwad.sdk.core.d.c.i("RefreshLayout", " onUp " + this.jo);
    }

    private void JC() {
        View view = this.aSA;
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        }
    }

    public View getStateView() {
        return this.aSA;
    }

    public void setShowRefreshView(boolean z) {
        setOnlySupportPull(!z);
        this.aSQ = z;
    }

    public void setTargetOrRefreshViewOffsetY(int i) {
        j(i, false);
    }

    private void j(int i, boolean z) {
        if (this.aSF == null) {
            return;
        }
        int i2 = AnonymousClass6.aSV[this.aSE.ordinal()];
        if (i2 == 1) {
            this.aSi.offsetTopAndBottom(i);
            this.aSg = this.aSi.getTop();
        } else if (i2 == 2) {
            this.aSF.offsetTopAndBottom(i);
            View view = this.aSA;
            if (view != null) {
                view.offsetTopAndBottom(i);
            }
            this.aSg = this.aSF.getTop();
        } else {
            this.aSF.offsetTopAndBottom(i);
            View view2 = this.aSA;
            if (view2 != null) {
                view2.offsetTopAndBottom(i);
            } else {
                float f = (i / this.aSy) + this.aSz;
                int i3 = (int) f;
                this.aSz = f - i3;
                this.aSi.offsetTopAndBottom(i3);
            }
            this.aSg = this.aSF.getTop();
            com.kwad.sdk.core.d.c.i("RefreshLayout", "refresh style" + this.aSg);
        }
        com.kwad.sdk.core.d.c.i("RefreshLayout", "current offset" + this.aSg);
        if (AnonymousClass6.aSV[this.aSE.ordinal()] == 1) {
            this.aSj.x(this.aSg);
            if (this.aSL != null) {
                for (int i4 = 0; i4 < this.aSL.size(); i4++) {
                    this.aSL.get(i4);
                }
            }
        } else {
            this.aSj.x(this.aSg);
            if (this.aSL != null) {
                for (int i5 = 0; i5 < this.aSL.size(); i5++) {
                    this.aSL.get(i5);
                }
            }
        }
        if (this.aSQ && this.aSi.getVisibility() != 0) {
            this.aSi.setVisibility(0);
        }
        invalidate();
    }

    private int getTargetOrRefreshViewTop() {
        if (AnonymousClass6.aSV[this.aSE.ordinal()] == 1) {
            return this.aSi.getTop();
        }
        return this.aSF.getTop();
    }

    public int getTargetOrRefreshViewOffset() {
        if (AnonymousClass6.aSV[this.aSE.ordinal()] == 1) {
            return (int) (this.aSi.getTop() - this.aSx);
        }
        View view = this.aSF;
        if (view == null) {
            return 0;
        }
        return view.getTop();
    }

    private static float a(MotionEvent motionEvent, int i) {
        int iFindPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (iFindPointerIndex < 0) {
            return -1.0f;
        }
        return MotionEventCompat.getY(motionEvent, iFindPointerIndex);
    }

    private boolean T(View view) {
        if (view == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 14 && (view instanceof AbsListView)) {
            AbsListView absListView = (AbsListView) view;
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (T(viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return ViewCompat.canScrollVertically(view, -1);
    }

    private void JD() {
        if (JE()) {
            return;
        }
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (!childAt.equals(this.aSi) && !childAt.equals(this.aSA)) {
                this.aSF = childAt;
                return;
            }
        }
    }

    private boolean JE() {
        for (int i = 0; i < getChildCount(); i++) {
            if (this.aSF == getChildAt(i)) {
                return true;
            }
        }
        return false;
    }

    public final boolean isRefreshing() {
        return this.aSn;
    }

    public void setRefreshing(boolean z) {
        if (this.aSn == z) {
            return;
        }
        if (z) {
            if (getAnimation() != null && !getAnimation().hasEnded()) {
                getAnimation().setAnimationListener(null);
                clearAnimation();
                reset();
            }
            this.aSn = z;
            this.aSp = false;
            b((int) this.aSg, this.aSI);
            return;
        }
        q(z, false);
    }

    public void setRefreshStyle(RefreshStyle refreshStyle) {
        this.aSE = refreshStyle;
    }

    public void setOnRefreshListener(b bVar) {
        this.aKD = bVar;
    }

    public void setOnRefreshStatusListener(c cVar) {
        this.aSK = cVar;
    }

    public void setOnScrollInterceptor(d dVar) {
        this.aSJ = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.view.ViewGroup
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    private static a b(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    private static a JF() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public static class a extends ViewGroup.MarginLayoutParams {
        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public a(int i, int i2) {
            super(i, i2);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}

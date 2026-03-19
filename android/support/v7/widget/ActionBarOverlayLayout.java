package android.support.v7.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.OverScroller;
import java.lang.reflect.InvocationTargetException;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class ActionBarOverlayLayout extends ViewGroup implements android.support.v4.e.k {
    static final int[] kt = {a.C0010a.actionBarSize, R.attr.windowContentOverlay};
    private final android.support.v4.e.m dZ;
    private int jT;
    private int jU;
    private ContentFrameLayout jV;
    ActionBarContainer jW;
    private t jX;
    private Drawable jY;
    private boolean jZ;
    private boolean ka;
    private boolean kb;
    private boolean kc;
    boolean kd;
    private int ke;
    private int kf;
    private final Rect kg;
    private final Rect kh;
    private final Rect ki;
    private final Rect kj;
    private final Rect kk;
    private final Rect kl;
    private final Rect km;
    private a kn;
    private OverScroller ko;
    ViewPropertyAnimator kp;
    final AnimatorListenerAdapter kq;
    private final Runnable kr;
    private final Runnable ks;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public interface a {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.e.k
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.e.k
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return bS();
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jU = 0;
        this.kg = new Rect();
        this.kh = new Rect();
        this.ki = new Rect();
        this.kj = new Rect();
        this.kk = new Rect();
        this.kl = new Rect();
        this.km = new Rect();
        this.kq = new AnimatorListenerAdapter() { // from class: android.support.v7.widget.ActionBarOverlayLayout.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.kp = null;
                actionBarOverlayLayout.kd = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.kp = null;
                actionBarOverlayLayout.kd = false;
            }
        };
        this.kr = new Runnable() { // from class: android.support.v7.widget.ActionBarOverlayLayout.2
            @Override // java.lang.Runnable
            public final void run() {
                ActionBarOverlayLayout.this.bU();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.kp = actionBarOverlayLayout.jW.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.kq);
            }
        };
        this.ks = new Runnable() { // from class: android.support.v7.widget.ActionBarOverlayLayout.3
            @Override // java.lang.Runnable
            public final void run() {
                ActionBarOverlayLayout.this.bU();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.kp = actionBarOverlayLayout.jW.animate().translationY(-ActionBarOverlayLayout.this.jW.getHeight()).setListener(ActionBarOverlayLayout.this.kq);
            }
        };
        init(context);
        this.dZ = new android.support.v4.e.m(this);
    }

    private void init(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(kt);
        this.jT = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.jY = typedArrayObtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.jY == null);
        typedArrayObtainStyledAttributes.recycle();
        this.jZ = context.getApplicationInfo().targetSdkVersion < 19;
        this.ko = new OverScroller(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bU();
    }

    public void setActionBarVisibilityCallback(a aVar) {
        int i;
        this.kn = aVar;
        if (getWindowToken() == null || (i = this.kf) == 0) {
            return;
        }
        onWindowSystemUiVisibilityChanged(i);
        android.support.v4.e.o.m(this);
    }

    public void setOverlayMode(boolean z) {
        this.ka = z;
        this.jZ = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.kb = z;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        init(getContext());
        android.support.v4.e.o.m(this);
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        bT();
        int i2 = this.kf ^ i;
        this.kf = i;
        if ((i2 & 256) == 0 || this.kn == null) {
            return;
        }
        android.support.v4.e.o.m(this);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.jU = i;
    }

    private static boolean a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        b bVar = (b) view.getLayoutParams();
        if (bVar.leftMargin != rect.left) {
            bVar.leftMargin = rect.left;
            z5 = true;
        } else {
            z5 = false;
        }
        if (bVar.topMargin != rect.top) {
            bVar.topMargin = rect.top;
            z5 = true;
        }
        if (bVar.rightMargin != rect.right) {
            bVar.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || bVar.bottomMargin == rect.bottom) {
            return z5;
        }
        bVar.bottomMargin = rect.bottom;
        return true;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        bT();
        android.support.v4.e.o.l(this);
        boolean zA = a(this.jW, rect, true, true, false, true);
        this.kj.set(rect);
        bd.a(this, this.kj, this.kg);
        if (!this.kk.equals(this.kj)) {
            this.kk.set(this.kj);
            zA = true;
        }
        if (!this.kh.equals(this.kg)) {
            this.kh.set(this.kg);
            zA = true;
        }
        if (zA) {
            requestLayout();
        }
        return true;
    }

    private static b bS() {
        return new b(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.view.ViewGroup
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredHeight;
        bT();
        measureChildWithMargins(this.jW, i, 0, i2, 0);
        b bVar = (b) this.jW.getLayoutParams();
        int iMax = Math.max(0, this.jW.getMeasuredWidth() + bVar.leftMargin + bVar.rightMargin);
        int iMax2 = Math.max(0, this.jW.getMeasuredHeight() + bVar.topMargin + bVar.bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.jW.getMeasuredState());
        boolean z = (android.support.v4.e.o.l(this) & 256) != 0;
        if (z) {
            measuredHeight = this.jT;
            if (this.kb && this.jW.getTabContainer() != null) {
                measuredHeight += this.jT;
            }
        } else {
            measuredHeight = this.jW.getVisibility() != 8 ? this.jW.getMeasuredHeight() : 0;
        }
        this.ki.set(this.kg);
        this.kl.set(this.kj);
        if (!this.ka && !z) {
            this.ki.top += measuredHeight;
            this.ki.bottom += 0;
        } else {
            this.kl.top += measuredHeight;
            this.kl.bottom += 0;
        }
        a(this.jV, this.ki, true, true, true, true);
        if (!this.km.equals(this.kl)) {
            this.km.set(this.kl);
            this.jV.a(this.kl);
        }
        measureChildWithMargins(this.jV, i, 0, i2, 0);
        b bVar2 = (b) this.jV.getLayoutParams();
        int iMax3 = Math.max(iMax, this.jV.getMeasuredWidth() + bVar2.leftMargin + bVar2.rightMargin);
        int iMax4 = Math.max(iMax2, this.jV.getMeasuredHeight() + bVar2.topMargin + bVar2.bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.jV.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(iMax4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                b bVar = (b) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = bVar.leftMargin + paddingLeft;
                int i7 = bVar.topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.jY == null || this.jZ) {
            return;
        }
        int bottom = this.jW.getVisibility() == 0 ? (int) (this.jW.getBottom() + this.jW.getTranslationY() + 0.5f) : 0;
        this.jY.setBounds(0, bottom, getWidth(), this.jY.getIntrinsicHeight() + bottom);
        this.jY.draw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.e.k
    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.jW.getVisibility() != 0) {
            return false;
        }
        return this.kc;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.e.k
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.dZ.onNestedScrollAccepted(view, view2, i);
        this.ke = getActionBarHideOffset();
        bU();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.e.k
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.ke += i2;
        setActionBarHideOffset(this.ke);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.e.k
    public void onStopNestedScroll(View view) {
        if (!this.kc || this.kd) {
            return;
        }
        if (this.ke <= this.jW.getHeight()) {
            bV();
        } else {
            bW();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.e.k
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.kc || !z) {
            return false;
        }
        if (b(f2)) {
            bY();
        } else {
            bX();
        }
        this.kd = true;
        return true;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.dZ.getNestedScrollAxes();
    }

    private void bT() {
        if (this.jV == null) {
            this.jV = (ContentFrameLayout) findViewById(a.f.action_bar_activity_content);
            this.jW = (ActionBarContainer) findViewById(a.f.action_bar_container);
            this.jX = z(findViewById(a.f.action_bar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static t z(View view) {
        if (view instanceof t) {
            return (t) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.kc) {
            this.kc = z;
            if (z) {
                return;
            }
            bU();
            setActionBarHideOffset(0);
        }
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.jW;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    public void setActionBarHideOffset(int i) {
        bU();
        this.jW.setTranslationY(-Math.max(0, Math.min(i, this.jW.getHeight())));
    }

    final void bU() {
        removeCallbacks(this.kr);
        removeCallbacks(this.ks);
        ViewPropertyAnimator viewPropertyAnimator = this.kp;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    private void bV() {
        bU();
        postDelayed(this.kr, 600L);
    }

    private void bW() {
        bU();
        postDelayed(this.ks, 600L);
    }

    private void bX() {
        bU();
        this.kr.run();
    }

    private void bY() {
        bU();
        this.ks.run();
    }

    private boolean b(float f) {
        this.ko.fling(0, 0, 0, (int) f, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.ko.getFinalY() > this.jW.getHeight();
    }

    public void setWindowCallback(Window.Callback callback) {
        bT();
        this.jX.setWindowCallback(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        bT();
        this.jX.setWindowTitle(charSequence);
    }

    public CharSequence getTitle() {
        bT();
        return this.jX.getTitle();
    }

    public void setIcon(int i) {
        bT();
        this.jX.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        bT();
        this.jX.setIcon(drawable);
    }

    public void setLogo(int i) {
        bT();
        this.jX.setLogo(i);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public static class b extends ViewGroup.MarginLayoutParams {
        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(int i, int i2) {
            super(-1, -1);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}

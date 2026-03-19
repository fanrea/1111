package com.tk.component.scroll;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import com.tk.core.o.ac;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b extends HorizontalScrollView implements ViewTreeObserver.OnGlobalLayoutListener, a, com.tk.core.component.c {
    private volatile boolean TA;
    private boolean TD;
    protected long TN;
    private long TO;
    private float UA;
    private float UB;
    private int UC;
    private int UD;
    private boolean UE;
    private boolean UF;
    private boolean UG;
    private boolean UH;
    private int UI;
    private int UJ;
    private int UK;
    private final com.tk.component.scroll.a.b UL;
    private final com.tk.component.scroll.a.a UM;
    boolean UN;
    boolean UO;
    private final Runnable UP;
    private Runnable UQ;
    private boolean Ux;
    private float Uy;
    private float Uz;
    private Handler mHandler;

    @Override // com.tk.component.scroll.a
    public final FrameLayout getView() {
        return this;
    }

    static /* synthetic */ boolean a(b bVar, boolean z) {
        bVar.Ux = true;
        return true;
    }

    static /* synthetic */ boolean b(b bVar, boolean z) {
        bVar.UG = false;
        return false;
    }

    public b(Context context) {
        super(context);
        this.UE = false;
        this.UF = true;
        this.UG = false;
        this.UH = false;
        this.UK = 0;
        this.TN = 400L;
        this.TO = -1L;
        this.TA = false;
        this.mHandler = new Handler();
        this.UN = true;
        this.UO = true;
        this.UP = new Runnable() { // from class: com.tk.component.scroll.b.1
            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.TA) {
                    return;
                }
                b.this.UL.aD(b.this.UC, b.this.UD);
            }
        };
        this.UQ = new Runnable() { // from class: com.tk.component.scroll.b.6
            @Override // java.lang.Runnable
            public final void run() {
                if (b.this.TA) {
                    return;
                }
                if (!b.this.TD && !b.this.UG) {
                    b.this.setScrollState(0);
                } else {
                    b.b(b.this, false);
                    b.this.postOnAnimationDelayed(this, 60L);
                }
            }
        };
        setClipToPadding(false);
        setImportantForAccessibility(2);
        setVerticalScrollBarEnabled(false);
        this.UM = new com.tk.component.scroll.a.a();
        this.UL = new com.tk.component.scroll.a.b();
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.UF) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.UB = 0.0f;
            this.UA = 0.0f;
            this.Uz = motionEvent.getX();
            this.Uy = motionEvent.getY();
        } else if (actionMasked == 2) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.UA += Math.abs(x - this.Uz);
            this.UB += Math.abs(y - this.Uy);
            this.Uz = x;
            this.Uy = y;
        }
        if (!super.onInterceptTouchEvent(motionEvent)) {
            return false;
        }
        if (motionEvent.getActionMasked() == 2 && this.UA < this.UB) {
            return false;
        }
        this.UL.a(this, this.UI, this.UJ);
        setScrollState(1);
        this.TD = true;
        return true;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (!this.TD && actionMasked == 0) {
            this.TD = true;
            this.UL.a(this, this.UI, this.UJ);
            setScrollState(1);
            setParentScrollableIfNeed(false);
        } else if (this.TD && (actionMasked == 1 || actionMasked == 3)) {
            this.TD = false;
            this.UL.b(this, this.UI, this.UJ);
            postOnAnimationDelayed(this.UQ, 60L);
            setParentScrollableIfNeed(true);
        }
        return this.UF && super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.HorizontalScrollView
    public final void fling(int i) {
        if (this.UE) {
            dg(i);
        } else {
            super.fling(i);
        }
        this.UL.e(this, this.UI, this.UJ);
        setScrollState(2);
        postOnAnimationDelayed(new Runnable() { // from class: com.tk.component.scroll.b.2
            private boolean US = false;

            @Override // java.lang.Runnable
            public final void run() {
                boolean z = true;
                if (b.this.Ux) {
                    if (b.this.UE && !this.US) {
                        this.US = true;
                        b.this.dg(0);
                        z = false;
                    }
                    if (z) {
                        com.tk.component.scroll.a.b bVar = b.this.UL;
                        b bVar2 = b.this;
                        bVar.f(bVar2, bVar2.UI, b.this.UJ);
                        b.this.setScrollState(0);
                        return;
                    }
                    b.this.postOnAnimationDelayed(this, 50L);
                    return;
                }
                b.a(b.this, true);
                b.this.postOnAnimationDelayed(this, 50L);
            }
        }, 50L);
    }

    @Override // android.view.View
    protected final void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        this.UC = i;
        this.UD = i2;
        this.Ux = false;
        this.mHandler.removeCallbacks(this.UP);
        this.mHandler.postDelayed(this.UP, 200L);
        View childAt = getChildAt(0);
        if (getScrollX() == 0) {
            this.UL.c(this, this.UI, this.UJ);
        } else if (childAt != null && ((getScrollX() + getWidth()) - getPaddingLeft()) - getPaddingRight() == childAt.getWidth()) {
            this.UL.d(this, this.UI, this.UJ);
        }
        this.UG = true;
        if (this.UM.aO(i, i2) && this.UH) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.TO >= this.TN) {
                this.TO = jCurrentTimeMillis;
                this.UL.aD(i, i2);
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        nN();
    }

    @Override // com.tk.component.scroll.a
    public final void setContainerView(View view) {
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        removeAllViews();
        addView(view);
    }

    @Override // com.tk.component.scroll.a
    public final void nM() {
        this.UH = true;
    }

    @Override // com.tk.component.scroll.a
    public final void a(com.tk.component.b.b bVar) {
        this.UL.b(bVar);
    }

    @Override // com.tk.component.scroll.a
    public final void a(com.tk.component.b.a aVar) {
        this.UL.b(aVar);
    }

    @Override // com.tk.component.scroll.a
    public final void af(boolean z) {
        this.UF = z;
    }

    @Override // com.tk.component.scroll.a
    public final void ag(boolean z) {
        setHorizontalScrollBarEnabled(z);
    }

    @Override // com.tk.component.scroll.a
    public final void ah(boolean z) {
        this.UE = z;
    }

    @Override // com.tk.component.scroll.a
    public final void df(int i) {
        setOverScrollMode(i);
    }

    @Override // com.tk.component.scroll.a
    public final void m(long j) {
        this.TN = j;
    }

    @Override // com.tk.component.scroll.a
    public final void a(int i, final int i2, long j) {
        if (j <= 0) {
            if (j == 0) {
                scrollTo(i, i2);
                return;
            }
            setScrollState(2);
            smoothScrollTo(i, i2);
            postOnAnimationDelayed(this.UQ, 60L);
            return;
        }
        if (i == getScrollX()) {
            return;
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(getScrollX(), i);
        valueAnimatorOfInt.setDuration(j);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tk.component.scroll.b.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), i2);
            }
        });
        valueAnimatorOfInt.addListener(new Animator.AnimatorListener() { // from class: com.tk.component.scroll.b.4
            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (b.this.TA) {
                    return;
                }
                b bVar = b.this;
                bVar.postOnAnimationDelayed(bVar.UQ, 60L);
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                if (b.this.TA) {
                    return;
                }
                b bVar = b.this;
                bVar.postOnAnimationDelayed(bVar.UQ, 60L);
            }
        });
        valueAnimatorOfInt.start();
        setScrollState(2);
    }

    @Override // com.tk.component.scroll.a
    public final void aM(int i, int i2) {
        smoothScrollBy(i, i2);
    }

    @Override // com.tk.component.scroll.a
    public final int getOffsetX() {
        return computeHorizontalScrollOffset();
    }

    @Override // com.tk.component.scroll.a
    public final int getOffsetY() {
        return computeVerticalScrollOffset();
    }

    @Override // com.tk.component.scroll.a
    public final void ai(boolean z) {
        this.TA = true;
        if (z) {
            mN();
        } else {
            ac.runOnUiThread(new Runnable() { // from class: com.tk.component.scroll.b.5
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.mN();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mN() {
        this.mHandler.removeCallbacks(this.UP);
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.UL.onDestroy();
    }

    private void setParentScrollableIfNeed(boolean z) {
        if (this.UO) {
            return;
        }
        if (canScrollHorizontally(-1) || canScrollHorizontally(1)) {
            getParent().requestDisallowInterceptTouchEvent(!z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dg(int i) {
        int width = getWidth();
        int scrollX = getScrollX();
        int i2 = i + scrollX;
        int i3 = width != 0 ? scrollX / width : 0;
        if (i2 > (i3 * width) + (width / 2.0f)) {
            i3++;
        }
        smoothScrollTo(i3 * width, getScrollX());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollState(int i) {
        if (i == this.UK) {
            return;
        }
        this.UK = i;
        this.UL.aB(this.UK);
    }

    private void nN() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return;
        }
        int width = childAt.getWidth();
        int height = childAt.getHeight();
        if (width == this.UI && height == this.UJ) {
            return;
        }
        this.UI = width;
        this.UJ = height;
        this.UL.aC(width, height);
    }

    @Override // com.tk.component.scroll.a
    public final int getScrollState() {
        return this.UK;
    }

    @Override // com.tk.component.scroll.a
    public final void setEnableAuto(boolean z) {
        this.UN = z;
    }

    @Override // com.tk.component.scroll.a
    public final void setEnableRemoveDisallowInterceptEventLogic(boolean z) {
        this.UO = z;
    }

    @Override // com.tk.core.component.c
    public final boolean nO() {
        return this.UN;
    }
}

package com.tk.component.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v4.e.l;
import android.support.v4.e.m;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.tk.core.o.o;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends FrameLayout implements l {
    private final int Pc;
    private boolean Pd;
    private boolean Pe;
    private ValueAnimator Pf;
    private InterfaceC0809a Pg;
    private boolean Ph;
    private float Pi;
    private final m Pj;

    /* renamed from: com.tk.component.b.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0809a {
        void cJ(int i);
    }

    @Override // android.view.ViewGroup
    public final int getNestedScrollAxes() {
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.e.k
    public final boolean onNestedFling(View view, float f, float f2, boolean z) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.e.k
    public final boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public a(Context context) {
        super(context);
        this.Pc = o.eb(6);
        this.Pd = false;
        this.Pe = false;
        this.Ph = false;
        this.Pi = 2.0f;
        this.Pj = new m(this);
    }

    public final void setIsHorizontal(boolean z) {
        this.Ph = z;
        if (this.Ph) {
            this.Pi = 2.0f;
        } else {
            this.Pi = 4.0f;
        }
    }

    public final void setOnTargetViewOffsetListener(InterfaceC0809a interfaceC0809a) {
        this.Pg = interfaceC0809a;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mI();
    }

    private void mI() {
        ValueAnimator valueAnimator = this.Pf;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.Pf.removeAllListeners();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.e.k
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        return f(i, 0);
    }

    public final boolean f(int i, int i2) {
        this.Pd = this.Pd || i2 == 0;
        this.Pe = this.Pe || i2 == 1;
        return this.Ph ? (i & 1) != 0 : (i & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.e.k
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        a(view, view2, i, 0);
    }

    @Override // android.support.v4.e.l
    public final void a(View view, View view2, int i, int i2) {
        this.Pj.p(i);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.e.k
    public final void onStopNestedScroll(View view) {
        a(view, 0);
    }

    @Override // android.support.v4.e.l
    public final void a(View view, int i) {
        float translationY;
        this.Pj.K();
        if (i == 0) {
            this.Pd = false;
        }
        if (i == 1) {
            this.Pe = false;
        }
        if (this.Ph) {
            translationY = view.getTranslationX();
        } else {
            translationY = view.getTranslationY();
        }
        int i2 = (int) translationY;
        if (this.Pd || this.Pe || i2 == 0) {
            return;
        }
        aH(view);
    }

    private void aH(final View view) {
        float translationY;
        if (this.Ph) {
            translationY = view.getTranslationX();
        } else {
            translationY = view.getTranslationY();
        }
        mI();
        final boolean z = translationY < 0.0f;
        this.Pf = ValueAnimator.ofFloat(b(view, translationY), 0.0f);
        this.Pf.setDuration(300L);
        this.Pf.setInterpolator(new DecelerateInterpolator());
        this.Pf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tk.component.b.a.a.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Float f = (Float) valueAnimator.getAnimatedValue();
                a aVar = a.this;
                View view2 = view;
                aVar.o(view2, aVar.a(view2, f.floatValue()) * (z ? -1 : 1));
            }
        });
        this.Pf.addListener(new AnimatorListenerAdapter() { // from class: com.tk.component.b.a.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                a.this.o(view, 0);
            }
        });
        this.Pf.start();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.e.k
    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        a(view, i, i2, iArr, 0);
    }

    public final void a(View view, int i, int i2, int[] iArr, int i3) {
        int translationY;
        if (this.Ph) {
            i2 = i;
            translationY = (int) view.getTranslationX();
        } else {
            translationY = (int) view.getTranslationY();
        }
        if (translationY > 0 && i2 > 0) {
            if (translationY - i2 <= 0) {
                i2 = translationY;
            }
            if (this.Ph) {
                iArr[0] = i2;
            } else {
                iArr[1] = i2;
            }
            o(view, translationY - i2);
            return;
        }
        if (translationY >= 0 || i2 >= 0) {
            return;
        }
        if (translationY - i2 >= 0) {
            i2 = translationY;
        }
        if (this.Ph) {
            iArr[0] = i2;
        } else {
            iArr[1] = i2;
        }
        o(view, translationY - i2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.e.k
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        a(view, i, i2, i3, i4, 0);
    }

    public final void a(View view, int i, int i2, int i3, int i4, int i5) {
        a(view, i3, i4, i5, new int[2]);
    }

    private void a(View view, int i, int i2, int i3, int[] iArr) {
        int translationY;
        int i4;
        float translationY2;
        int iA;
        if (this.Ph) {
            i2 = i;
            translationY = (int) view.getTranslationX();
        } else {
            translationY = (int) view.getTranslationY();
        }
        if (translationY >= 0 && i2 < 0) {
            if (this.Ph) {
                iArr[0] = i2;
            } else {
                iArr[1] = i2;
            }
            float f = translationY;
            if (i3 == 1) {
                f *= 1.7f;
            }
            float f2 = -b(view, f);
            if (i3 == 1) {
                iA = (int) (a(view, f2 + i2) / 1.7f);
            } else {
                iA = a(view, f2 + i2);
            }
            o(view, iA);
        } else if (translationY <= 0 && i2 > 0) {
            if (this.Ph) {
                iArr[0] = i2;
            } else {
                iArr[1] = i2;
            }
            float f3 = translationY;
            if (i3 == 1) {
                f3 *= 1.7f;
            }
            float fB = b(view, f3);
            if (i3 == 1) {
                i4 = (int) ((-a(view, fB + i2)) / 1.7f);
            } else {
                i4 = -a(view, fB + i2);
            }
            o(view, i4);
        }
        if (this.Ph) {
            translationY2 = view.getTranslationX();
        } else {
            translationY2 = view.getTranslationY();
        }
        int i5 = (int) translationY2;
        if (translationY == 0 || Math.abs(translationY - i5) > this.Pc || i3 != 1) {
            return;
        }
        if (this.Ph) {
            iArr[0] = 0;
        } else {
            iArr[1] = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(View view, float f) {
        int height;
        if (this.Ph) {
            height = view.getWidth();
        } else {
            height = view.getHeight();
        }
        float f2 = height;
        return (int) (f2 - (((this.Pi * f2) * f2) / (Math.abs(f) + (this.Pi * f2))));
    }

    private int b(View view, float f) {
        int height;
        if (this.Ph) {
            height = view.getWidth();
        } else {
            height = view.getHeight();
        }
        float f2 = height;
        return (int) ((((this.Pi * f2) * f2) / (f2 - Math.abs(f))) - (this.Pi * f2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(View view, int i) {
        if (this.Ph) {
            view.setTranslationX(i);
        } else {
            view.setTranslationY(i);
        }
        InterfaceC0809a interfaceC0809a = this.Pg;
        if (interfaceC0809a != null) {
            interfaceC0809a.cJ(-i);
        }
    }
}

package com.qq.e.comm.plugin;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class ep extends LinearLayout implements el {
    protected w40 a;
    private boolean b;
    private final float c;
    private int d;
    private int e;
    private ValueAnimator f;

    @Override // com.qq.e.comm.plugin.el
    public void a(ao aoVar) {
    }

    public ep(Context context) {
        super(context);
        this.b = true;
        this.d = 0;
        this.e = 0;
        this.c = (zu.a() * 30.0f) / 1000.0f;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.a.f(i);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        v40 v40VarV;
        w40 w40Var = this.a;
        if (w40Var != null && (v40VarV = w40Var.v()) != null) {
            Pair<Integer, Integer> pairB = v40VarV.b(i, i2);
            super.onMeasure(((Integer) pairB.first).intValue(), ((Integer) pairB.second).intValue());
            Pair<Integer, Integer> pairA = v40VarV.a(i, i2);
            if (pairA != null) {
                super.onMeasure(((Integer) pairA.first).intValue(), ((Integer) pairA.second).intValue());
                return;
            }
            return;
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int width;
        int height;
        w40 w40Var = this.a;
        xj xjVarS = w40Var == null ? null : w40Var.s();
        if (xjVarS != null) {
            width = getWidth();
            height = getHeight();
            xjVarS.a(canvas, width, height);
        } else {
            width = 0;
            height = 0;
        }
        super.draw(canvas);
        if (xjVarS != null) {
            xjVarS.b(canvas, width, height);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int height;
        if (!c()) {
            super.dispatchDraw(canvas);
            return;
        }
        int iSave = canvas.save();
        int width = -this.d;
        while (width < getWidth()) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i2 = marginLayoutParams.leftMargin;
                    i3 = marginLayoutParams.rightMargin;
                    height = marginLayoutParams.topMargin;
                    i = marginLayoutParams.bottomMargin;
                } else {
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                    height = 0;
                }
                int i5 = (layoutParams instanceof LinearLayout.LayoutParams ? ((LinearLayout.LayoutParams) layoutParams).gravity : -1) & 112;
                if (i5 == 16) {
                    height += (((getHeight() - childAt.getMeasuredHeight()) - height) - i) / 2;
                } else if (i5 == 80) {
                    height = (getHeight() - childAt.getMeasuredHeight()) - i;
                }
                if (childAt.getWidth() + width + i2 + i3 > 0 && width < getWidth()) {
                    canvas.save();
                    canvas.translate(width + i2, height);
                    childAt.draw(canvas);
                    canvas.restore();
                }
                width += childAt.getWidth() + i2 + i3;
                if (width >= this.e + getWidth()) {
                    break;
                }
            }
        }
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        w40 w40Var = this.a;
        if (w40Var != null) {
            w40Var.a(view, i);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.e = a();
    }

    /* compiled from: A */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ep.this.d = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (ep.this.d >= ep.this.e) {
                ep.this.d = 0;
            }
            ep.this.invalidate();
        }
    }

    public void d() {
        if (this.f != null) {
            return;
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, this.e);
        this.f = valueAnimatorOfInt;
        Double.isNaN(this.e);
        Double.isNaN(this.c);
        valueAnimatorOfInt.setDuration((int) ((r1 * 1.0d) / r3));
        this.f.setInterpolator(new LinearInterpolator());
        this.f.setRepeatCount(-1);
        this.f.addUpdateListener(new a());
        this.f.start();
    }

    private int a() {
        int i;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            int measuredWidth = childAt.getMeasuredWidth();
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                i2 = marginLayoutParams.leftMargin;
                i = marginLayoutParams.rightMargin;
            } else {
                i = 0;
                i2 = 0;
            }
            i3 += measuredWidth + i2 + i;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator == null) {
            if (c()) {
                d();
            }
        } else if (valueAnimator.isPaused()) {
            this.f.resume();
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ boolean a;

        b(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.a || !ep.this.isAttachedToWindow()) {
                ep.this.b();
            } else {
                ep.this.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f.pause();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(true);
    }

    private boolean c() {
        int i;
        return (getChildCount() > 0 && (i = this.e) > 0 && i <= getWidth() && this.b) || this.e > getWidth();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a(false);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        a(z);
    }

    @Override // com.qq.e.comm.plugin.dl
    public void a(w40 w40Var) {
        this.a = w40Var;
    }

    private void a(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            post(new b(z));
        }
    }

    public void b(boolean z) {
        this.b = z;
    }
}

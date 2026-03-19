package com.sigmob.sdk.base.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.czhj.sdk.common.utils.Dips;
import java.util.Objects;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class aa extends View {
    private Paint a;
    private Paint b;
    private Paint c;
    private Paint d;
    private String description;
    private Paint e;
    private RectF f;
    private RectF g;
    private RectF h;
    private Path i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private final Handler p;
    private int q;
    private int r;
    private String title;

    /* renamed from: com.sigmob.sdk.base.views.aa$3, reason: invalid class name */
    class AnonymousClass3 implements Animator.AnimatorListener {
        AnonymousClass3() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(final Animator animator) {
            Handler handler = aa.this.p;
            Objects.requireNonNull(animator);
            handler.postDelayed(new Runnable() { // from class: com.sigmob.sdk.base.views.aa$3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    animator.start();
                }
            }, 300L);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public aa(Context context) {
        super(context);
        this.p = new Handler(Looper.getMainLooper());
        this.q = Color.parseColor("#FF5A57");
        c();
    }

    public aa(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.p = new Handler(Looper.getMainLooper());
        this.q = Color.parseColor("#FF5A57");
        c();
    }

    public aa(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.p = new Handler(Looper.getMainLooper());
        this.q = Color.parseColor("#FF5A57");
        c();
    }

    private Animator a(final RectF rect, final Paint paint, int duration, int delayTime) {
        AnimatorSet animatorSet = new AnimatorSet();
        final RectF rectF = new RectF(rect.left, rect.top, rect.right, rect.bottom);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, Dips.dipsToIntPixels(20.0f, getContext()));
        long j = delayTime;
        valueAnimatorOfFloat.setStartDelay(j);
        valueAnimatorOfFloat.setDuration(duration);
        valueAnimatorOfFloat.setInterpolator(new AccelerateInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.base.views.aa.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                aa.this.a(rectF, rect, ((Float) valueAnimator.getAnimatedValue()).floatValue());
                aa.this.invalidate();
            }
        });
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(255, 0);
        valueAnimatorOfInt.setStartDelay(j);
        valueAnimatorOfInt.setDuration((long) (duration * 0.8f));
        valueAnimatorOfInt.setInterpolator(new AccelerateInterpolator());
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.base.views.aa.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                paint.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                aa.this.invalidate();
            }
        });
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfInt);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(RectF source, RectF dest, float factor) {
        dest.left = source.left - factor;
        dest.top = source.top - factor;
        dest.right = source.right + factor;
        dest.bottom = source.bottom + factor;
    }

    private void c() {
        this.r = Dips.dipsToIntPixels(2.0f, getContext());
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setStyle(Paint.Style.FILL);
        this.a.setStrokeWidth(this.r);
        this.a.setColor(-1);
        this.n = Dips.dipsToIntPixels(20.0f, getContext());
        this.b = new Paint(this.a);
        Paint paint2 = new Paint(this.a);
        this.c = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.c.setColor(this.q);
        Paint paint3 = new Paint(1);
        this.d = paint3;
        paint3.setColor(-1);
        this.d.setTypeface(Typeface.DEFAULT);
        this.d.setTextSize(TypedValue.applyDimension(2, 20.0f, getResources().getDisplayMetrics()));
        Paint paint4 = new Paint(1);
        this.e = paint4;
        paint4.setColor(-1);
        this.e.setAlpha(127);
        this.e.setStyle(Paint.Style.FILL);
        this.i = new Path();
        this.f = new RectF();
        this.g = new RectF();
        this.h = new RectF();
    }

    private void d() {
        this.i.reset();
        this.i.moveTo(0.0f, 0.0f);
        this.i.lineTo(0.0f, this.o);
        Path path = this.i;
        float f = this.o;
        path.lineTo(f / 2.0f, f / 2.0f);
        this.i.close();
    }

    public void a() {
        Animator animatorA = a(this.f, this.a, 1000, 0);
        Animator animatorA2 = a(this.g, this.b, 800, 400);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animatorA, animatorA2);
        animatorSet.addListener(new AnonymousClass3());
        animatorSet.start();
    }

    public void a(String title, String description) {
        this.title = title;
        this.description = description;
        invalidate();
    }

    public void b() {
        this.f.set(0.0f, 0.0f, getWidth(), getHeight());
        this.g.set(0.0f, 0.0f, getWidth(), getHeight());
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Handler handler = this.p;
        if (handler == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.f;
        canvas.drawRoundRect(rectF, rectF.height() / 2.0f, this.f.height() / 2.0f, this.a);
        RectF rectF2 = this.g;
        canvas.drawRoundRect(rectF2, rectF2.height() / 2.0f, this.g.height() / 2.0f, this.b);
        RectF rectF3 = this.h;
        canvas.drawRoundRect(rectF3, rectF3.height() / 2.0f, this.h.height() / 2.0f, this.c);
        float width = (getWidth() / 2.0f) + (this.l / 2.0f) + (this.r * 2);
        if (!TextUtils.isEmpty(this.title)) {
            float width2 = (getWidth() / 2.0f) - (this.l / 2.0f);
            canvas.drawText(this.title, width2, ((getHeight() / 2.0f) - (this.m / 2.0f)) - this.d.ascent(), this.d);
            width = width2 + this.d.measureText(this.title) + (this.r * 2);
        }
        float height = (getHeight() / 2.0f) - (this.o / 2.0f);
        canvas.save();
        canvas.translate(width, height);
        canvas.drawPath(this.i, this.e);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        float f = w;
        float f2 = f / 4.0f;
        this.j = f2;
        float f3 = h;
        float f4 = f3 / 3.0f;
        this.k = f4;
        this.f.set(f2 / 2.0f, f4 / 2.0f, f - (f2 / 2.0f), f3 - (f4 / 2.0f));
        RectF rectF = this.g;
        float f5 = this.j;
        float f6 = this.k;
        rectF.set(f5 / 2.0f, f6 / 2.0f, f - (f5 / 2.0f), f3 - (f6 / 2.0f));
        RectF rectF2 = this.h;
        float f7 = this.j;
        float f8 = this.k;
        rectF2.set(f7 / 2.0f, f8 / 2.0f, f - (f7 / 2.0f), f3 - (f8 / 2.0f));
        if (!TextUtils.isEmpty(this.title)) {
            int i = 5;
            while (true) {
                if (i >= this.title.length()) {
                    break;
                }
                if (this.d.measureText(this.title, 0, i) > (this.f.right - this.f.left) - (this.n * 4.0f)) {
                    this.title = this.title.substring(0, i - 2) + "...";
                    break;
                }
                i++;
            }
            this.l = this.d.measureText(this.title);
            this.m = this.d.descent() - this.d.ascent();
        }
        this.o = this.m * 0.6f;
        d();
        a();
    }

    public void setButtonColor(int color) {
        this.q = color;
    }
}

package com.qq.e.comm.plugin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import com.baidu.mobstat.forbes.Config;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class y20 extends View implements am {
    private final RectF A;
    private final RectF B;
    private final RectF C;
    private final RectF D;
    private final RectF E;
    private final RectF F;
    private final RectF G;
    private final RectF H;
    private final RectF I;
    private final RectF J;

    /* renamed from: K, reason: collision with root package name */
    private float f786K;
    private float L;
    private float M;
    private AnimatorSet N;
    private boolean O;
    private final Paint a;
    private final Camera b;
    private final float c;
    private float d;
    private final float e;
    private final float f;
    private final float g;
    private final float h;
    private final float i;
    private final float j;
    private final float m;
    private final float n;
    private final float o;
    private final float p;
    private final float q;
    private final float r;
    private final float s;
    private final float t;
    private final float u;
    private final float v;
    private final float w;
    private final float x;
    private final float y;
    private final float z;

    @Override // com.qq.e.comm.plugin.ts
    public void a() {
    }

    public y20(Context context, int i) {
        super(context);
        this.O = true;
        setLayerType(1, null);
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        paint.setDither(true);
        this.b = new Camera();
        float f = i;
        this.c = f;
        this.e = (-f) / 72.0f;
        this.f = 0.009803922f * f;
        float f2 = 0.014705882f * f;
        this.g = f2;
        float f3 = 0.029411765f * f;
        this.h = f3;
        this.i = 0.039215688f * f;
        float f4 = 0.20588236f * f;
        this.j = f4;
        float f5 = 0.32352942f * f;
        this.m = f5;
        float f6 = 0.4117647f * f;
        this.n = f6;
        this.o = 0.46078432f * f;
        this.p = 0.47058824f * f;
        this.q = 0.4852941f * f;
        float f7 = 0.5f * f;
        this.r = f7;
        this.s = 0.5392157f * f;
        this.t = 0.5882353f * f;
        float f8 = 0.64705884f * f;
        this.u = f8;
        float f9 = 0.6764706f * f;
        this.v = f9;
        this.w = 0.6960784f * f;
        float f10 = 0.7941176f * f;
        this.x = f10;
        float f11 = 0.9705882f * f;
        this.y = f11;
        float f12 = f * 0.9852941f;
        this.z = f12;
        this.A = new RectF(f2, f2, f12, f12);
        float f13 = (f6 - f3) / 2.0f;
        float f14 = (f8 - f3) / 2.0f;
        this.B = new RectF(f7 - f13, f7 - f14, f13 + f7, f14 + f7);
        this.C = new RectF(f5, f4, f9, f10);
        this.D = new RectF(f3, f7, f11, f11);
        this.E = new RectF(f7, f3, f11, f11);
        this.F = new RectF(f3, f3, f11, f7);
        this.G = new RectF(f3, f3, f7, f11);
        this.H = new RectF();
        this.I = new RectF();
        this.J = new RectF();
        post(new a());
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            y20.this.c();
        }
    }

    public void setPx(float f) {
        this.d = Math.abs(f);
        this.f786K = f * 45.0f;
        invalidate();
    }

    public void setPy(float f) {
        this.d = Math.abs(f);
        this.L = f * 45.0f;
        invalidate();
    }

    public void setPz(float f) {
        this.d = Math.abs(f);
        this.M = f * 45.0f;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "px", 0.0f, -0.7f);
        objectAnimatorOfFloat.setDuration(400L);
        objectAnimatorOfFloat.setStartDelay(600L);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, "px", -0.7f, 0.0f);
        objectAnimatorOfFloat2.setDuration(400L);
        objectAnimatorOfFloat2.setStartDelay(200L);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this, Config.PY, 0.0f, -0.7f);
        objectAnimatorOfFloat3.setDuration(400L);
        objectAnimatorOfFloat3.setStartDelay(600L);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this, Config.PY, -0.7f, 0.0f);
        objectAnimatorOfFloat4.setDuration(400L);
        objectAnimatorOfFloat4.setStartDelay(200L);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this, "pz", 0.0f, 0.7f);
        objectAnimatorOfFloat5.setDuration(400L);
        objectAnimatorOfFloat5.setStartDelay(600L);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this, "pz", 0.7f, 0.0f);
        objectAnimatorOfFloat6.setDuration(400L);
        objectAnimatorOfFloat6.setStartDelay(200L);
        AnimatorSet animatorSet = new AnimatorSet();
        this.N = animatorSet;
        animatorSet.playSequentially(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4, objectAnimatorOfFloat5, objectAnimatorOfFloat6);
        this.N.addListener(new b(null));
        this.N.start();
    }

    @Override // com.qq.e.comm.plugin.ts
    public void a(int i, int i2, int i3, int i4, float f) {
        AnimatorSet animatorSet;
        if (this.O && (animatorSet = this.N) != null && f > 0.1f) {
            this.O = false;
            animatorSet.cancel();
        }
        if (this.O) {
            return;
        }
        float f2 = i4;
        this.f786K = Math.min(i / f2, 1.0f) * 45.0f;
        this.L = Math.min(i2 / f2, 1.0f) * 45.0f;
        this.M = Math.min(i3 / f2, 1.0f) * 45.0f;
        if (Math.abs(this.d - f) > 0.01f) {
            this.d = f;
            invalidate();
        }
    }

    @Override // com.qq.e.comm.plugin.ts
    public void b() {
        this.d = 0.0f;
        this.f786K = 0.0f;
        this.L = 0.0f;
        this.M = 0.0f;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float fSin = this.r * ((float) Math.sin(Math.toRadians(this.f786K)));
        float fSin2 = this.r * ((float) Math.sin(Math.toRadians(this.L)));
        canvas.save();
        this.a.setColor(-4933701);
        Paint paint = this.a;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.a.setStrokeWidth(this.h);
        float f = this.r;
        canvas.drawCircle(f, f, this.q, this.a);
        if (!this.O) {
            this.a.setColor(-1);
            this.a.setStyle(style);
            this.a.setStrokeCap(Paint.Cap.ROUND);
            this.a.setStrokeWidth(this.h);
            RectF rectF = this.A;
            float f2 = this.d * 180.0f;
            canvas.drawArc(rectF, (-90.0f) - f2, 2.0f * f2, false, this.a);
        }
        this.a.setColor(1090519039);
        Paint paint2 = this.a;
        Paint.Style style2 = Paint.Style.FILL;
        paint2.setStyle(style2);
        float f3 = this.r;
        canvas.drawCircle(f3, f3, this.p, this.a);
        canvas.restore();
        this.a.setColor(Integer.MAX_VALUE);
        this.a.setStyle(style);
        this.a.setStrokeWidth(this.f);
        RectF rectF2 = this.H;
        float f4 = this.h;
        rectF2.left = f4;
        float f5 = this.r;
        rectF2.top = f5 - fSin;
        rectF2.right = this.y;
        rectF2.bottom = f5 + fSin;
        RectF rectF3 = this.I;
        rectF3.left = f5 - fSin2;
        rectF3.top = f4;
        rectF3.right = f5 + fSin2;
        rectF3.bottom = f5 + this.p;
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            if (Math.abs(fSin) >= this.f) {
                canvas.save();
                float f6 = -this.M;
                float f7 = this.r;
                canvas.rotate(f6, f7, f7);
                canvas.clipRect(fSin > 0.0f ? this.F : this.D);
                canvas.drawOval(this.H, this.a);
                canvas.restore();
            }
            if (Math.abs(fSin2) >= this.f) {
                canvas.save();
                float f8 = -this.M;
                float f9 = this.r;
                canvas.rotate(f8, f9, f9);
                canvas.clipRect(fSin2 > 0.0f ? this.G : this.E);
                canvas.drawOval(this.I, this.a);
                canvas.restore();
            }
        }
        canvas.save();
        float f10 = this.r;
        canvas.translate(f10, f10);
        this.b.save();
        this.b.rotateX(-this.f786K);
        this.b.rotateY(this.L);
        this.b.rotateZ(this.M);
        this.b.setLocation(0.0f, 0.0f, this.e);
        this.b.applyToCanvas(canvas);
        this.b.restore();
        float f11 = -this.r;
        canvas.translate(f11, f11);
        this.a.setColor(-1);
        this.a.setStyle(style);
        this.a.setStrokeWidth(this.h);
        RectF rectF4 = this.B;
        float f12 = this.h + this.g;
        canvas.drawRoundRect(rectF4, f12, f12, this.a);
        this.a.setColor(-4933701);
        this.a.setStyle(style2);
        RectF rectF5 = this.C;
        float f13 = this.h;
        canvas.drawRoundRect(rectF5, f13, f13, this.a);
        this.a.setColor(Integer.MAX_VALUE);
        this.a.setStyle(style2);
        RectF rectF6 = this.J;
        rectF6.left = this.m;
        float f14 = this.x;
        rectF6.top = f14 - (this.d * this.t);
        rectF6.right = this.v;
        rectF6.bottom = f14;
        canvas.drawRoundRect(rectF6, 0.0f, 0.0f, this.a);
        this.a.setColor(-1);
        this.a.setStyle(style);
        this.a.setStrokeCap(Paint.Cap.ROUND);
        this.a.setStrokeWidth(this.i);
        float f15 = this.o;
        float f16 = this.w;
        canvas.drawLine(f15, f16, this.s, f16, this.a);
        canvas.restore();
        this.a.setColor(Integer.MAX_VALUE);
        this.a.setStyle(style);
        this.a.setStrokeWidth(this.f);
        if (Math.abs(fSin) >= this.f) {
            canvas.save();
            float f17 = -this.M;
            float f18 = this.r;
            canvas.rotate(f17, f18, f18);
            if (i >= 26) {
                canvas.clipRect(fSin > 0.0f ? this.D : this.F);
            }
            canvas.drawOval(this.H, this.a);
            canvas.restore();
        }
        if (Math.abs(fSin2) >= this.f) {
            canvas.save();
            float f19 = -this.M;
            float f20 = this.r;
            canvas.rotate(f19, f20, f20);
            if (i >= 26) {
                canvas.clipRect(fSin2 > 0.0f ? this.E : this.G);
            }
            canvas.drawOval(this.I, this.a);
            canvas.restore();
        }
        canvas.save();
        float f21 = -this.M;
        float f22 = this.r;
        canvas.rotate(f21, f22, f22);
        this.a.setColor(Integer.MAX_VALUE);
        this.a.setStyle(style);
        this.a.setStrokeWidth(this.f);
        if (Math.abs(fSin2) < this.f) {
            float f23 = this.r;
            canvas.drawLine(f23, this.h, f23, this.y, this.a);
        }
        if (Math.abs(fSin) < this.f) {
            float f24 = this.h;
            float f25 = this.r;
            canvas.drawLine(f24, f25, this.y, f25, this.a);
        }
        canvas.restore();
    }

    /* compiled from: A */
    private static class b extends AnimatorListenerAdapter {
        private boolean a;

        private b() {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                animator.start();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = false;
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    @Override // com.qq.e.comm.plugin.ts
    public void a(int i, int i2, int i3, int i4, long j) {
        this.d = 1.0f;
        float f = i4;
        this.f786K = Math.min(i / f, 1.0f) * 45.0f;
        this.L = Math.min(i2 / f, 1.0f) * 45.0f;
        this.M = Math.min(i3 / f, 1.0f) * 45.0f;
        invalidate();
    }
}

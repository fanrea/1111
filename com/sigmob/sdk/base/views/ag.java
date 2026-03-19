package com.sigmob.sdk.base.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ag extends View {
    private Paint a;
    private RectF b;
    private float c;
    private String d;
    private Paint e;
    private Path f;
    private Paint g;
    private Path h;
    private int i;
    private int j;
    private int k;
    private float l;
    private int m;
    private int n;
    private int o;
    private int p;
    private ValueAnimator q;
    private ValueAnimator r;
    private String title;

    public ag(Context context) {
        super(context);
        this.l = 1.0f;
        a();
    }

    public ag(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.l = 1.0f;
        a();
    }

    public ag(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.l = 1.0f;
        a();
    }

    private int a(int color, float alpha) {
        return Color.argb((int) (Color.alpha(color) * alpha), Color.red(color), Color.green(color), Color.blue(color));
    }

    private void a() {
        setBackgroundColor(SupportMenu.CATEGORY_MASK);
        this.a = new Paint(1);
        this.e = new Paint(1);
        this.b = new RectF();
        this.h = new Path();
        this.c = Dips.dipsToIntPixels(2.0f, getContext());
        setBackgroundColor(0);
    }

    private void b() {
        ValueAnimator valueAnimator = this.q;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(-this.k, this.m + this.n);
        this.q = valueAnimatorOfInt;
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.base.views.ag.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                ag.this.i = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                ag.this.d();
                ag.this.invalidate();
            }
        });
        this.q.setDuration(800L);
        this.q.setRepeatCount(-1);
        this.q.setRepeatMode(1);
        this.q.start();
        ValueAnimator valueAnimator2 = this.r;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 1.15f);
        this.r = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.sigmob.sdk.base.views.ag.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                ag.this.l = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
            }
        });
        this.r.setDuration(1000L);
        this.r.setRepeatCount(-1);
        this.r.setRepeatMode(2);
        this.r.start();
    }

    private void c() {
        this.f = new Path();
        this.g = new Paint();
        this.j = this.n;
        this.k = Dips.dipsToIntPixels(60.0f, getContext());
        this.g.setShader(new LinearGradient(0.0f, this.j, this.k, 0.0f, new int[]{a(-1, 0.2f), a(-1, 0.5f), a(-1, 0.2f)}, new float[]{0.2f, 0.8f, 1.0f}, Shader.TileMode.MIRROR));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.f.reset();
        this.f.moveTo((this.k / 2.0f) + this.i, 0.0f);
        this.f.lineTo(this.k + this.i, 0.0f);
        this.f.lineTo((this.k / 2.0f) + this.i, this.j);
        this.f.lineTo(this.i + 0.0f, this.j);
        this.f.close();
    }

    public void a(String title, String desc) {
        this.title = title;
        this.d = desc;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.q;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.r;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setColor(-1);
        this.a.setAlpha(204);
        this.a.setStrokeWidth(this.c);
        RectF rectF = this.b;
        float f2 = this.c;
        rectF.set(f2, f2, this.m - (f2 * 2.0f), this.n - (f2 * 2.0f));
        Path path = this.h;
        RectF rectF2 = this.b;
        int i = this.p;
        path.addRoundRect(rectF2, i, i, Path.Direction.CCW);
        canvas.drawPath(this.h, this.a);
        this.a.setStyle(Paint.Style.FILL);
        this.a.setColor(-16777216);
        this.a.setAlpha(76);
        this.h.reset();
        Path path2 = this.h;
        RectF rectF3 = this.b;
        path2.addRoundRect(rectF3, rectF3.height() / 2.0f, this.b.height() / 2.0f, Path.Direction.CCW);
        canvas.drawPath(this.h, this.a);
        int i2 = this.n;
        float f3 = i2 * 0.3f * this.l;
        float f4 = this.m - ((i2 * 0.3f) * 2.0f);
        this.a.setColor(-1);
        this.a.setStyle(Paint.Style.FILL);
        canvas.drawCircle(f4, this.n / 2.0f, f3, this.a);
        this.a.setColor(-16777216);
        this.a.setTextSize(TypedValue.applyDimension(2, this.l * 16.0f, getResources().getDisplayMetrics()));
        this.a.setTypeface(Typeface.DEFAULT_BOLD);
        float fMeasureText = f4 - (this.a.measureText("GO") / 1.5f);
        canvas.drawText("GO", fMeasureText, ((this.n / 2.0f) + ((this.a.getFontMetrics().bottom - this.a.getFontMetrics().top) / 2.0f)) - this.a.getFontMetrics().bottom, this.a);
        float fMeasureText2 = this.a.measureText("GO") * 0.4f;
        Path path3 = new Path();
        float f5 = fMeasureText2 / 4.0f;
        float f6 = fMeasureText2 / 2.0f;
        path3.moveTo(this.a.measureText("GO") + fMeasureText + f5, (this.n / 2.0f) - f6);
        path3.lineTo(this.a.measureText("GO") + fMeasureText + fMeasureText2, this.n / 2.0f);
        path3.lineTo(fMeasureText + this.a.measureText("GO") + f5, (this.n / 2.0f) + f6);
        path3.close();
        canvas.drawPath(path3, this.a);
        this.e.setStyle(Paint.Style.FILL);
        this.e.setColor(-1);
        if (TextUtils.isEmpty(this.title)) {
            f = 0.0f;
        } else {
            this.e.setTextSize(TypedValue.applyDimension(2, 20.0f, getResources().getDisplayMetrics()));
            this.e.setTypeface(Typeface.DEFAULT_BOLD);
            String str = this.title;
            f = (this.e.getFontMetrics().bottom - this.e.getFontMetrics().top) * 1.5f;
            int i3 = 5;
            while (true) {
                if (i3 >= this.title.length()) {
                    break;
                }
                if (this.e.measureText(this.title, 0, i3) + f > ((this.b.right - this.b.left) - f) - f3) {
                    str = this.title.substring(0, i3 - 2) + "...";
                    break;
                }
                i3++;
            }
            canvas.drawText(str, f, ((this.n / 2.0f) - (this.e.getFontMetrics().bottom - this.e.getFontMetrics().top)) - this.e.getFontMetrics().top, this.e);
        }
        if (!TextUtils.isEmpty(this.d)) {
            this.e.setTextSize(TypedValue.applyDimension(2, 16.0f, getResources().getDisplayMetrics()));
            this.e.setTypeface(Typeface.DEFAULT);
            float f7 = f > 0.0f ? f : (this.e.getFontMetrics().bottom - this.e.getFontMetrics().top) * 1.5f;
            String str2 = this.d;
            int i4 = 5;
            while (true) {
                if (i4 >= this.d.length()) {
                    break;
                }
                if (this.e.measureText(this.d, 0, i4) + f > ((this.b.right - this.b.left) - f) - f3) {
                    str2 = this.d.substring(0, i4 - 2) + "...";
                    break;
                }
                i4++;
            }
            canvas.drawText(str2, f7, (this.n / 2.0f) + (this.e.getFontMetrics().bottom - this.e.getFontMetrics().top), this.e);
        }
        canvas.clipPath(this.h);
        canvas.drawPath(this.f, this.g);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.m = w;
        this.n = (int) (h * 0.8f);
        this.o = w / 2;
        this.p = h / 2;
        c();
        b();
    }
}

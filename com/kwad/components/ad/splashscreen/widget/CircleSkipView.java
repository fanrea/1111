package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class CircleSkipView extends KSFrameLayout implements b {
    private float Lq;
    private float Lr;
    private int Ls;
    private ValueAnimator Lt;
    private boolean Lu;
    private SkipView.a Lv;
    private long Lw;
    private float Lx;
    private Paint mPaint;
    private RectF mRectF;
    private int padding;
    private int radius;
    private boolean xO;

    static /* synthetic */ boolean a(CircleSkipView circleSkipView, boolean z) {
        circleSkipView.Lu = true;
        return true;
    }

    public CircleSkipView(Context context) {
        this(context, null, 0);
    }

    public CircleSkipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleSkipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.Lq = 270.0f;
        this.Lr = 360.0f;
        this.radius = 0;
        this.Ls = 0;
        this.Lu = false;
        this.Lw = 0L;
        this.Lx = 0.0f;
        this.padding = 0;
        this.xO = true;
        O(context);
    }

    private void O(Context context) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        af(context);
        addView(ag(context), layoutParams);
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (CircleSkipView.this.Lv != null) {
                    CircleSkipView.this.Lv.mi();
                }
            }
        });
    }

    private void af(Context context) {
        this.Ls = com.kwad.sdk.c.a.a.a(context, 2.0f);
        int iA = com.kwad.sdk.c.a.a.a(context, 32.0f);
        int i = this.Ls;
        this.radius = iA - i;
        this.padding = i / 2;
        int i2 = this.padding;
        int i3 = this.radius;
        this.mRectF = new RectF(i2, i2, i3 + i2, i3 + i2);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        setBgCirclePaint(this.mPaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, (Math.min(getWidth(), getHeight()) / 2.0f) - this.Ls, this.mPaint);
        setOuterCirclePaint(this.mPaint);
        canvas.drawArc(this.mRectF, 0.0f, 360.0f, false, this.mPaint);
        if (this.Lu) {
            setAnimationPaint(this.mPaint);
            canvas.drawArc(this.mRectF, this.Lq, -this.Lr, false, this.mPaint);
        }
        super.dispatchDraw(canvas);
    }

    private void setOuterCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.Ls);
        paint.setColor(Color.parseColor("#33FFFFFF"));
        paint.setAntiAlias(true);
    }

    private void setBgCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#4D000000"));
        paint.setAntiAlias(true);
    }

    private void setAnimationPaint(Paint paint) {
        paint.reset();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.Ls);
        paint.setColor(-1);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void A(AdInfo adInfo) {
        bx.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.2
            @Override // java.lang.Runnable
            public final void run() {
                CircleSkipView.this.nq();
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void B(AdInfo adInfo) {
        np();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public void setOnViewListener(SkipView.a aVar) {
        this.Lv = aVar;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void a(SplashSkipViewModel splashSkipViewModel, AdInfo adInfo) {
        this.xO = com.kwad.sdk.core.response.b.a.cR(adInfo);
        boolean zCS = com.kwad.sdk.core.response.b.a.cS(adInfo);
        if (this.xO) {
            setVisibility(0);
        }
        c(splashSkipViewModel.skipSecond * 1000, zCS);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void cv() {
        nq();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final int ao(int i) {
        getLayoutParams().height = com.kwad.sdk.c.a.a.a(getContext(), 35.0f);
        return getWidth();
    }

    private static TextView ag(Context context) {
        TextView textView = new TextView(context);
        textView.setText(context.getString(R.string.ksad_skip_text));
        textView.setTextColor(-1);
        textView.setTextSize(12.0f);
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(int i) {
        SkipView.a aVar = this.Lv;
        if (aVar != null) {
            aVar.am(i);
        }
    }

    private void c(final int i, final boolean z) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.Lt = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(i);
        this.Lt.setInterpolator(new LinearInterpolator());
        this.Lt.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (CircleSkipView.this.Lx != 1.0f || CircleSkipView.this.Lv == null) {
                    return;
                }
                CircleSkipView.this.Lv.mj();
            }
        });
        this.Lt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircleSkipView.this.Lx = fFloatValue;
                CircleSkipView circleSkipView = CircleSkipView.this;
                circleSkipView.al((int) ((i / 1000) * circleSkipView.Lx));
                if (z) {
                    CircleSkipView.a(CircleSkipView.this, true);
                    float f = fFloatValue * 360.0f;
                    CircleSkipView.this.Lq = 270.0f - f;
                    CircleSkipView.this.Lr = 360.0f - f;
                    CircleSkipView.this.invalidate();
                }
            }
        });
    }

    private void np() {
        this.Lu = true;
        ValueAnimator valueAnimator = this.Lt;
        if (valueAnimator != null) {
            valueAnimator.setCurrentPlayTime(this.Lw);
            this.Lt.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nq() {
        this.Lu = false;
        ValueAnimator valueAnimator = this.Lt;
        if (valueAnimator != null) {
            this.Lw = valueAnimator.getCurrentPlayTime();
            this.Lt.cancel();
        }
    }
}

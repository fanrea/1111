package com.style.widget.viewpager2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.util.ab;
import com.bytedance.applog.aggregation.MetricsSQLiteCacheKt;
import com.component.a.c.c;
import com.component.a.f.e;
import com.component.a.i.f;
import com.component.a.i.n;
import com.style.widget.viewpager2.ViewPager2;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class PagerIndicatorView extends View implements c {
    private Interpolator accelerateInterpolator;
    private final AutoBannerHelper bannerHelper;
    private int currentPage;
    private float currentProgress;
    private final Paint indicatorPaint;
    private float indicatorRadius;
    private float indicatorRatio;
    private float indicatorSelectedRadius;
    private float indicatorSelectedRatio;
    private float indicatorSpacing;
    private int indicatorStyle;
    private final Interpolator interpolator;
    private f mLifeCycle;
    private float offset;
    private int pagerCount;
    private RelativeLayout.LayoutParams params;
    private Path path;
    private boolean progressMode;
    private final RectF rectF;
    private int selectedColor;
    private int selectedPage;
    private float uIndicatorRadius;
    private float uIndicatorRatio;
    private float uIndicatorSelectedRadius;
    private float uIndicatorSelectedRatio;
    private float uIndicatorSpacing;
    private int unColor;

    @Retention(RetentionPolicy.SOURCE)
    public @interface IndicatorStyle {
        public static final int INDICATOR_BEZIER = 2;
        public static final int INDICATOR_BIG_CIRCLE = 4;
        public static final int INDICATOR_CIRCLE = 0;
        public static final int INDICATOR_CIRCLE_RECT = 1;
        public static final int INDICATOR_DASH = 3;
    }

    public PagerIndicatorView(Context context, e eVar) {
        this(context);
        if (eVar != null) {
            this.mLifeCycle = new f(eVar);
            switchViewStyle(eVar);
        }
    }

    public PagerIndicatorView(Context context) {
        this(context, null, 0);
    }

    public PagerIndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerIndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.interpolator = new DecelerateInterpolator();
        this.currentProgress = 1.0f;
        this.pagerCount = 0;
        this.unColor = -7829368;
        this.selectedColor = -1;
        this.progressMode = false;
        this.uIndicatorRadius = dip2px(10.0f);
        this.uIndicatorRatio = -1.0f;
        this.uIndicatorSelectedRadius = dip2px(10.0f);
        this.uIndicatorSelectedRatio = -1.0f;
        this.uIndicatorSpacing = dip2px(10.0f);
        this.indicatorRadius = dip2px(10.0f);
        this.indicatorRatio = -1.0f;
        this.indicatorSelectedRadius = dip2px(10.0f);
        this.indicatorSelectedRatio = -1.0f;
        this.indicatorSpacing = dip2px(10.0f);
        this.rectF = new RectF();
        this.indicatorPaint = new Paint(1);
        this.bannerHelper = new AutoBannerHelper();
        this.bannerHelper.bindWithIndicator(this);
    }

    @Override // com.component.a.c.c
    public void setLifeCycle(f fVar) {
        this.mLifeCycle = fVar;
    }

    @Override // com.component.a.c.c
    public f getLifeCycle() {
        return this.mLifeCycle;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.mLifeCycle != null) {
            this.mLifeCycle.a(this, z);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.mLifeCycle != null) {
            this.mLifeCycle.a((View) this, i);
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mLifeCycle != null) {
            this.mLifeCycle.e(this);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mLifeCycle != null) {
            this.mLifeCycle.f(this);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.mLifeCycle != null) {
            this.mLifeCycle.b(view, i);
        }
    }

    @Override // com.component.a.c.c
    public void switchViewStyle(e eVar) {
        if (eVar != null) {
            JSONObject jSONObjectC = eVar.c();
            setIndicatorColor(n.a(jSONObjectC, "normal_color", Color.parseColor("#6A6E74")));
            setIndicatorSelectorColor(n.a(jSONObjectC, "foreground_color", -1));
            this.bannerHelper.setAutoScrollInterval(jSONObjectC.optInt(MetricsSQLiteCacheKt.METRICS_INTERVAL, 5000));
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (this.mLifeCycle != null) {
            this.mLifeCycle.a(motionEvent, zDispatchTouchEvent);
        }
        return zDispatchTouchEvent;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        if (this.mLifeCycle != null) {
            this.mLifeCycle.b(motionEvent, zOnTouchEvent);
        }
        return zOnTouchEvent;
    }

    public AutoBannerHelper getBannerHelper() {
        return this.bannerHelper;
    }

    public PagerIndicatorView setupWithViewPager2(ViewPager2 viewPager2) {
        if (viewPager2 != null) {
            viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.style.widget.viewpager2.PagerIndicatorView.1
                @Override // com.style.widget.viewpager2.ViewPager2.OnPageChangeCallback
                public void onPageScrolled(int i, float f, int i2) {
                    PagerIndicatorView.this.selectedPage = i;
                    PagerIndicatorView.this.offset = f;
                    PagerIndicatorView.this.invalidate();
                }

                @Override // com.style.widget.viewpager2.ViewPager2.OnPageChangeCallback
                public void onPageSelected(int i) {
                    PagerIndicatorView.this.currentPage = i;
                }
            });
            final RVAdapter<?> adapter = viewPager2.getAdapter();
            if (adapter != null) {
                this.pagerCount = adapter.getItemCount();
            }
            if (adapter instanceof PageItemAdapter) {
                ((PageItemAdapter) adapter).registerAdapterDataObserver(new ViewPager2.DataSetChangeObserver() { // from class: com.style.widget.viewpager2.PagerIndicatorView.2
                    @Override // com.style.widget.viewpager2.ViewPager2.DataSetChangeObserver
                    public void onChanged() {
                        PagerIndicatorView.this.pagerCount = adapter.getItemCount();
                    }
                });
            }
            setVisibility(this.pagerCount > 1 ? 0 : 8);
            requestLayout();
        }
        return this;
    }

    public RelativeLayout.LayoutParams getParams() {
        if (this.params == null) {
            this.params = new RelativeLayout.LayoutParams(-1, -2);
            this.params.addRule(12);
            this.params.addRule(14);
            this.params.bottomMargin = dip2px(10.0f);
            this.params.leftMargin = dip2px(10.0f);
            this.params.rightMargin = dip2px(10.0f);
        }
        return this.params;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
        invalidateDimensions();
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 0:
                float ratioSelectedRadius = getRatioSelectedRadius();
                float ratioRadius = getRatioRadius();
                return (int) ((Math.max(ratioSelectedRadius, ratioRadius) * 2.0f * this.pagerCount) + ((this.pagerCount - 1) * this.indicatorSpacing) + (ratioSelectedRadius - ratioRadius) + getPaddingLeft() + getPaddingRight());
            case 1073741824:
                return size;
            default:
                return 0;
        }
    }

    private int measureHeight(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 0:
                return (int) ((Math.max(getRatioSelectedRadius(), getRatioRadius()) * 2.0f) + getPaddingTop() + getPaddingBottom());
            case 1073741824:
                return size;
            default:
                return 0;
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    private void invalidateDimensions() {
        int iMax = Math.max(0, (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        float fMin = Math.min(iMax, Math.max(0, (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom())) / 2.0f;
        this.indicatorSelectedRadius = Math.max(0.0f, Math.min(fMin, this.uIndicatorSelectedRadius));
        this.indicatorRadius = Math.max(0.0f, Math.min(fMin, this.uIndicatorRadius));
        if (this.pagerCount > 0 && this.indicatorStyle == 3) {
            boolean z = this.uIndicatorRatio <= 0.0f;
            boolean z2 = this.uIndicatorSelectedRatio <= 0.0f;
            float f = iMax;
            float f2 = f - (this.uIndicatorSpacing * (this.pagerCount - 1));
            float f3 = this.indicatorRadius * 2.0f;
            float f4 = this.indicatorSelectedRadius * 2.0f;
            float f5 = ((this.pagerCount - 1) * f3) + f4;
            if (f2 < f5) {
                this.indicatorRatio = 1.0f;
                this.indicatorSelectedRatio = 1.0f;
                this.indicatorSpacing = (f - f5) / (this.pagerCount - 1);
            } else if (z && z2) {
                float f6 = f2 / this.pagerCount;
                this.indicatorRatio = f6 / f3;
                this.indicatorSelectedRatio = f6 / f4;
            } else if (z) {
                this.indicatorSelectedRatio = Math.min((f2 - ((this.pagerCount - 1) * f3)) / f4, this.indicatorSelectedRatio);
                this.indicatorRatio = Math.max(((f2 - (this.indicatorSelectedRatio * f4)) / (this.pagerCount - 1)) / f3, this.indicatorRatio);
            }
        }
    }

    private static boolean between(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.pagerCount == 0) {
            return;
        }
        float height = (getHeight() / 2.0f) + 0.5f;
        if (this.indicatorStyle == 0) {
            drawCircle(canvas, height);
            return;
        }
        if (this.indicatorStyle == 1) {
            drawCircleRect(canvas, height);
            return;
        }
        if (this.indicatorStyle == 2) {
            drawBezier(canvas, height);
        } else if (this.indicatorStyle == 3) {
            drawDash(canvas, height);
        } else if (this.indicatorStyle == 4) {
            drawBigCircle(canvas, height);
        }
    }

    private void drawCircle(Canvas canvas, float f) {
        drawPagerCountCircle(canvas, f);
        float fIndicatorStartX = indicatorStartX(this.selectedPage);
        float fIndicatorStartX2 = indicatorStartX((this.selectedPage + 1) % this.pagerCount);
        float ratioSelectedRadius = getRatioSelectedRadius();
        float f2 = fIndicatorStartX - ratioSelectedRadius;
        float f3 = fIndicatorStartX + ratioSelectedRadius;
        float f4 = fIndicatorStartX2 - ratioSelectedRadius;
        this.rectF.set(f2 + ((f4 - f2) * interpolatedOffset()), f - this.indicatorSelectedRadius, f3 + (((fIndicatorStartX2 + ratioSelectedRadius) - f3) * interpolatedOffset()), f + this.indicatorSelectedRadius);
        this.indicatorPaint.setColor(this.selectedColor);
        canvas.drawRoundRect(this.rectF, this.indicatorSelectedRadius, this.indicatorSelectedRadius, this.indicatorPaint);
    }

    private void drawCircleRect(Canvas canvas, float f) {
        float fMax;
        float fMin;
        drawPagerCountCircle(canvas, f);
        float fIndicatorStartX = indicatorStartX(this.selectedPage);
        float ratioSelectedRadius = getRatioSelectedRadius();
        float f2 = fIndicatorStartX - ratioSelectedRadius;
        float f3 = fIndicatorStartX + ratioSelectedRadius;
        float fInterpolatedOffset = interpolatedOffset();
        float fMax2 = this.indicatorSpacing + (Math.max(getRatioRadius(), ratioSelectedRadius) * 2.0f);
        if ((this.selectedPage + 1) % this.pagerCount == 0) {
            float f4 = fMax2 * (-this.selectedPage);
            fMax = f2 + Math.max(f4 * fInterpolatedOffset * 2.0f, f4);
            fMin = f3 + Math.min(f4 * (fInterpolatedOffset - 0.5f) * 2.0f, 0.0f);
        } else {
            fMax = f2 + Math.max((fInterpolatedOffset - 0.5f) * fMax2 * 2.0f, 0.0f);
            fMin = f3 + Math.min(fInterpolatedOffset * fMax2 * 2.0f, fMax2);
        }
        this.rectF.set(fMax, f - this.indicatorSelectedRadius, fMin, f + this.indicatorSelectedRadius);
        this.indicatorPaint.setColor(this.selectedColor);
        canvas.drawRoundRect(this.rectF, this.indicatorSelectedRadius, this.indicatorSelectedRadius, this.indicatorPaint);
    }

    private void drawBezier(Canvas canvas, float f) {
        drawPagerCountCircle(canvas, f);
        if (this.path == null) {
            this.path = new Path();
        }
        if (this.accelerateInterpolator == null) {
            this.accelerateInterpolator = new AccelerateInterpolator();
        }
        float fIndicatorStartX = indicatorStartX(this.selectedPage);
        float fIndicatorStartX2 = indicatorStartX((this.selectedPage + 1) % this.pagerCount) - fIndicatorStartX;
        float interpolation = (this.accelerateInterpolator.getInterpolation(this.offset) * fIndicatorStartX2) + fIndicatorStartX;
        float fInterpolatedOffset = fIndicatorStartX + (fIndicatorStartX2 * interpolatedOffset());
        float ratioSelectedRadius = getRatioSelectedRadius();
        float f2 = this.indicatorSelectedRadius * 0.57f;
        float f3 = this.indicatorSelectedRatio * f2;
        float fInterpolatedOffset2 = ((f3 - ratioSelectedRadius) * interpolatedOffset()) + ratioSelectedRadius;
        float interpolation2 = f3 + ((ratioSelectedRadius - f3) * this.accelerateInterpolator.getInterpolation(this.offset));
        float fInterpolatedOffset3 = (this.indicatorSelectedRadius - f2) * interpolatedOffset();
        float interpolation3 = (this.indicatorSelectedRadius - f2) * this.accelerateInterpolator.getInterpolation(this.offset);
        this.indicatorPaint.setColor(this.selectedColor);
        this.rectF.set(interpolation - fInterpolatedOffset2, (f - this.indicatorSelectedRadius) + fInterpolatedOffset3, interpolation + fInterpolatedOffset2, (this.indicatorSelectedRadius + f) - fInterpolatedOffset3);
        canvas.drawRoundRect(this.rectF, fInterpolatedOffset2, fInterpolatedOffset2, this.indicatorPaint);
        float f4 = (f - f2) - interpolation3;
        float f5 = f2 + f + interpolation3;
        this.rectF.set(fInterpolatedOffset - interpolation2, f4, fInterpolatedOffset + interpolation2, f5);
        canvas.drawRoundRect(this.rectF, interpolation2, interpolation2, this.indicatorPaint);
        this.path.reset();
        this.path.moveTo(fInterpolatedOffset, f);
        this.path.lineTo(fInterpolatedOffset, f4);
        float f6 = ((interpolation - fInterpolatedOffset) / 2.0f) + fInterpolatedOffset;
        this.path.quadTo(f6, f, interpolation, (f - this.indicatorSelectedRadius) + fInterpolatedOffset3);
        this.path.lineTo(interpolation, (this.indicatorSelectedRadius + f) - fInterpolatedOffset3);
        this.path.quadTo(f6, f, fInterpolatedOffset, f5);
        this.path.close();
        canvas.drawPath(this.path, this.indicatorPaint);
    }

    private void drawDash(Canvas canvas, float f) {
        float fInterpolatedOffset = interpolatedOffset();
        float ratioSelectedRadius = getRatioSelectedRadius();
        float ratioRadius = getRatioRadius();
        float f2 = ratioSelectedRadius - ratioRadius;
        float f3 = f2 * fInterpolatedOffset;
        int i = (this.selectedPage + 1) % this.pagerCount;
        boolean z = i == 0;
        this.indicatorPaint.setColor(this.unColor);
        for (int i2 = 0; i2 < this.pagerCount; i2++) {
            drawDashUnit(canvas, getDashMidX(i2, z, f2, f3), f, ratioRadius, this.indicatorRadius);
        }
        this.indicatorPaint.setColor(this.selectedColor);
        if (this.progressMode) {
            for (int i3 = 0; i3 < this.currentPage; i3++) {
                drawDashUnit(canvas, getDashMidX(i3, z, f2, f3), f, ratioRadius, this.indicatorRadius);
            }
            float fIndicatorStartX = indicatorStartX(this.currentPage) - ratioSelectedRadius;
            if (z) {
                fIndicatorStartX += f3;
            }
            drawDashUnit(canvas, ((fIndicatorStartX + ratioSelectedRadius) + ((f2 - f3) / 2.0f)) - ((1.0f - this.currentProgress) * ratioSelectedRadius), f, ratioSelectedRadius * this.currentProgress, this.indicatorSelectedRadius);
            return;
        }
        if (fInterpolatedOffset < 0.99f) {
            float fIndicatorStartX2 = indicatorStartX(this.selectedPage) - ratioSelectedRadius;
            if (z) {
                fIndicatorStartX2 += f3;
            }
            this.rectF.set(fIndicatorStartX2, f - this.indicatorSelectedRadius, (((ratioSelectedRadius * 2.0f) + fIndicatorStartX2) + f2) - f3, f + this.indicatorSelectedRadius);
            canvas.drawRoundRect(this.rectF, this.indicatorSelectedRadius, this.indicatorSelectedRadius, this.indicatorPaint);
        }
        if (fInterpolatedOffset > 0.1f) {
            float fIndicatorStartX3 = indicatorStartX(i) + ratioSelectedRadius;
            if (z) {
                f2 = f3;
            }
            float f4 = fIndicatorStartX3 + f2;
            this.rectF.set((f4 - (ratioSelectedRadius * 2.0f)) - f3, f - this.indicatorSelectedRadius, f4, f + this.indicatorSelectedRadius);
            canvas.drawRoundRect(this.rectF, this.indicatorSelectedRadius, this.indicatorSelectedRadius, this.indicatorPaint);
        }
    }

    private float getDashMidX(int i, boolean z, float f, float f2) {
        float fIndicatorStartX = indicatorStartX(i);
        if (z) {
            fIndicatorStartX += f2;
        }
        if (this.selectedPage + 1 <= i) {
            return fIndicatorStartX + f;
        }
        return fIndicatorStartX;
    }

    private void drawDashUnit(Canvas canvas, float f, float f2, float f3, float f4) {
        this.rectF.set(f - f3, f2 - f4, f + f3, f2 + f4);
        canvas.drawRoundRect(this.rectF, f4, f4, this.indicatorPaint);
    }

    private void drawBigCircle(Canvas canvas, float f) {
        drawPagerCountCircle(canvas, f);
        float fInterpolatedOffset = interpolatedOffset();
        float fIndicatorStartX = indicatorStartX(this.selectedPage);
        float fIndicatorStartX2 = indicatorStartX((this.selectedPage + 1) % this.pagerCount);
        float ratioRadius = getRatioRadius();
        float f2 = this.indicatorSelectedRadius;
        float f3 = this.indicatorSelectedRatio * f2;
        float f4 = (f3 - ratioRadius) * fInterpolatedOffset;
        float f5 = f3 - f4;
        float f6 = ratioRadius + f4;
        float f7 = (f2 - this.indicatorRadius) * fInterpolatedOffset;
        this.indicatorPaint.setColor(this.selectedColor);
        if (fInterpolatedOffset < 0.99f) {
            RectF rectF = this.rectF;
            rectF.set(fIndicatorStartX - f5, (f - f2) + f7, fIndicatorStartX + f5, (f2 + f) - f7);
            canvas.drawRoundRect(this.rectF, f5, f5, this.indicatorPaint);
        }
        if (fInterpolatedOffset > 0.1f) {
            float f8 = f + this.indicatorRadius + f7;
            RectF rectF2 = this.rectF;
            rectF2.set(fIndicatorStartX2 - f6, (f - this.indicatorRadius) - f7, fIndicatorStartX2 + f6, f8);
            canvas.drawRoundRect(this.rectF, f6, f6, this.indicatorPaint);
        }
    }

    private void drawPagerCountCircle(Canvas canvas, float f) {
        this.indicatorPaint.setColor(this.unColor);
        for (int i = 0; i < this.pagerCount; i++) {
            float fIndicatorStartX = indicatorStartX(i);
            float ratioRadius = getRatioRadius();
            this.rectF.set(fIndicatorStartX - ratioRadius, f - this.indicatorRadius, fIndicatorStartX + ratioRadius, this.indicatorRadius + f);
            canvas.drawRoundRect(this.rectF, this.indicatorRadius, this.indicatorRadius, this.indicatorPaint);
        }
    }

    private float indicatorStartX(int i) {
        float ratioRadius = getRatioRadius();
        float fMax = Math.max(ratioRadius, getRatioSelectedRadius());
        return getPaddingLeft() + fMax + (((fMax * 2.0f) + this.indicatorSpacing) * i) + (this.indicatorStyle == 3 ? 0.0f : (fMax - ratioRadius) / 2.0f);
    }

    private float getRatioRadius() {
        return this.indicatorRadius * this.indicatorRatio;
    }

    private float getRatioSelectedRadius() {
        return this.indicatorSelectedRadius * this.indicatorSelectedRatio;
    }

    private float interpolatedOffset() {
        return this.interpolator.getInterpolation(this.offset);
    }

    private int dip2px(float f) {
        return ab.a(getContext(), f);
    }

    public PagerIndicatorView setIndicatorRadius(float f) {
        int iDip2px = dip2px(f);
        if (this.indicatorRadius == this.indicatorSelectedRadius) {
            setIndicatorSelectedRadius(f);
        }
        float f2 = iDip2px;
        this.uIndicatorRadius = f2;
        this.indicatorRadius = f2;
        return this;
    }

    public PagerIndicatorView setIndicatorRatio(float f) {
        if (this.uIndicatorRatio == this.uIndicatorSelectedRatio) {
            setIndicatorSelectedRatio(f);
        }
        this.uIndicatorRatio = f;
        this.indicatorRatio = f;
        return this;
    }

    public PagerIndicatorView setIndicatorSelectedRadius(float f) {
        this.uIndicatorSelectedRadius = dip2px(f);
        this.indicatorSelectedRadius = dip2px(f);
        return this;
    }

    public PagerIndicatorView setIndicatorSelectedRatio(float f) {
        this.uIndicatorSelectedRatio = f;
        this.indicatorSelectedRatio = f;
        return this;
    }

    public PagerIndicatorView setIndicatorSpacing(float f) {
        this.uIndicatorSpacing = dip2px(f);
        this.indicatorSpacing = dip2px(f);
        return this;
    }

    public PagerIndicatorView setIndicatorStyle(int i) {
        this.indicatorStyle = i;
        return this;
    }

    public PagerIndicatorView setProgressMode(boolean z) {
        this.progressMode = z;
        return this;
    }

    public PagerIndicatorView setIndicatorColor(int i) {
        this.unColor = i;
        return this;
    }

    public PagerIndicatorView setIndicatorSelectorColor(int i) {
        this.selectedColor = i;
        return this;
    }

    public PagerIndicatorView setParams(RelativeLayout.LayoutParams layoutParams) {
        this.params = layoutParams;
        return this;
    }

    public boolean getProgressMode() {
        return this.progressMode;
    }

    public void setCurrentProgress(float f) {
        this.currentProgress = f;
        invalidate();
    }
}

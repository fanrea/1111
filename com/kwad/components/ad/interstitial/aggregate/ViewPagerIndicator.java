package com.kwad.components.ad.interstitial.aggregate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ViewPagerIndicator extends View {
    private final Context mContext;
    private ValueAnimator nA;
    private int ni;
    private int nn;
    private int no;
    private int np;
    private float nq;
    private float nr;
    private Paint ns;
    private float nt;
    private float nu;
    private float nv;
    private int nw;
    private Paint nx;
    private float ny;
    private a nz;

    public interface a {
        void I(int i);
    }

    public ViewPagerIndicator(Context context) {
        this(context, null);
    }

    public ViewPagerIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewPagerIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        setWillNotDraw(false);
        a(context, attributeSet, i);
        dJ();
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_ViewPagerIndicator, i, 0);
        this.nr = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_distance, com.kwad.sdk.c.a.a.a(this.mContext, 5.0f));
        this.nt = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_height, com.kwad.sdk.c.a.a.a(this.mContext, 6.0f));
        this.nu = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_selected_width, com.kwad.sdk.c.a.a.a(this.mContext, 50.0f));
        this.nv = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_unselected_width, com.kwad.sdk.c.a.a.a(this.mContext, 6.0f));
        this.no = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_ViewPagerIndicator_ksad_default_color, getResources().getColor(R.color.ksad_88_white));
        this.nn = typedArrayObtainStyledAttributes.getColor(R.styleable.ksad_ViewPagerIndicator_ksad_height_color, getResources().getColor(R.color.ksad_white));
        typedArrayObtainStyledAttributes.recycle();
    }

    private void dJ() {
        Paint paint = new Paint(1);
        this.ns = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.ns.setStrokeWidth(1.0f);
        this.ns.setColor(this.no);
        Paint paint2 = new Paint(1);
        this.nx = paint2;
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        this.nx.setStrokeWidth(1.0f);
        this.nx.setColor(this.nn);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 != 1073741824) {
            size2 = mode2 == Integer.MIN_VALUE ? (int) this.nt : 0;
        }
        if (mode != 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                if (this.np > 1) {
                    size = (int) (this.nu + ((r6 - 1) * (this.nr + this.nv)));
                } else {
                    size = (int) this.nu;
                }
            } else {
                size = 0;
            }
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        b(canvas);
    }

    private void a(Canvas canvas) {
        RectF rectF = new RectF();
        for (int i = 0; i < this.np; i++) {
            int i2 = this.ni;
            if (i < i2 && i != i2 - 1) {
                rectF.left = i * (this.nr + this.nv);
                rectF.right = rectF.left + this.nv;
                this.ns.setColor(this.no);
            } else if (i == i2 - 1) {
                rectF.left = i * (this.nr + this.nv);
                float f = rectF.left;
                float f2 = this.nv;
                rectF.right = f + f2 + ((this.nu - f2) * (1.0f - this.nq));
                this.ns.setColor(this.no);
            } else if (i == i2) {
                float f3 = i2 != 0 ? this.nq : 1.0f;
                float f4 = this.nr;
                float f5 = this.nv;
                rectF.left = ((i - 1) * (f4 + f5)) + f5 + ((this.nu - f5) * (1.0f - f3)) + f4;
                float f6 = rectF.left;
                float f7 = this.nu;
                float f8 = this.nv;
                rectF.right = f6 + (f3 * (f7 - f8)) + f8;
                this.ns.setColor(this.no);
            } else {
                float f9 = this.nr;
                rectF.left = ((i - 1) * (this.nv + f9)) + f9 + this.nu;
                rectF.right = rectF.left + this.nv;
                this.ns.setColor(this.no);
            }
            rectF.top = 0.0f;
            rectF.bottom = rectF.top + this.nt;
            float f10 = this.nt;
            canvas.drawRoundRect(rectF, f10 / 2.0f, f10 / 2.0f, this.ns);
        }
    }

    private void b(Canvas canvas) {
        if (this.ny > 0.0f) {
            int i = this.ni;
            float f = this.nr;
            float f2 = this.nv;
            RectF rectF = new RectF(i * (f + f2), 0.0f, (i * (f + f2)) + this.ny, this.nt);
            float f3 = this.nt;
            canvas.drawRoundRect(rectF, f3 / 2.0f, f3 / 2.0f, this.nx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(final int i) {
        if (this.nw <= 0) {
            setVisibility(8);
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.nv, this.nu);
        this.nA = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.nw * 1000);
        this.nA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewPagerIndicator.this.ny = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewPagerIndicator.this.invalidate();
            }
        });
        this.nA.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (ViewPagerIndicator.this.nz != null) {
                    ViewPagerIndicator.this.nz.I(i);
                }
            }
        });
        this.nA.start();
    }

    public final void dK() {
        ValueAnimator valueAnimator = this.nA;
        if (valueAnimator != null) {
            valueAnimator.pause();
        }
    }

    public final void dL() {
        ValueAnimator valueAnimator = this.nA;
        if (valueAnimator != null) {
            valueAnimator.resume();
        }
    }

    public void setViewPager(ViewPager viewPager) {
        PagerAdapter adapter = viewPager.getAdapter();
        if (adapter == null) {
            return;
        }
        int count = adapter.getCount();
        this.np = count;
        if (count <= 1) {
            return;
        }
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.3
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i, float f, int i2) {
                ViewPagerIndicator.this.ny = 0.0f;
                ViewPagerIndicator.this.ni = i;
                ViewPagerIndicator.this.nq = f;
                ViewPagerIndicator.this.invalidate();
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i) {
                ViewPagerIndicator.this.ni = i;
                ViewPagerIndicator.this.nq = 1.0f;
                ViewPagerIndicator.this.invalidate();
                if (i < ViewPagerIndicator.this.np - 1) {
                    ViewPagerIndicator.this.K(i);
                }
            }
        });
        K(this.ni);
    }

    public void setAdShowTime(int i) {
        this.nw = i;
    }

    public void setPlayProgressListener(a aVar) {
        this.nz = aVar;
    }
}

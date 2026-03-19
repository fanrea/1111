package com.kwad.components.ct.entry.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.kwad.components.ct.widget.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class EntryViewPager extends FrameLayout implements a.InterfaceC0545a {
    private com.kwad.components.ct.widget.a aEQ;
    private View aER;
    private b aES;
    private boolean aET;
    private boolean aEU;
    private c aEV;
    private int aEW;

    public interface c {
        void EC();

        void ED();
    }

    public EntryViewPager(Context context) {
        super(context);
        this.aEW = 0;
        init();
    }

    public EntryViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEW = 0;
        init();
    }

    private void init() {
        com.kwad.components.ct.widget.a aVar = new com.kwad.components.ct.widget.a(getContext());
        this.aEQ = aVar;
        addView(aVar);
        this.aER = new TextView(getContext());
        b bVar = new b();
        this.aES = bVar;
        bVar.u(0.0f);
    }

    public void setFooterView(View view) {
        this.aER = view;
    }

    public void setFooterSlideBgDrawable(Drawable drawable) {
        this.aES.setBackgroundDrawable(drawable);
    }

    public void setFooterSlideFrontColor(int i) {
        this.aES.setColor(i);
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        if (this.aEW > 0) {
            pagerAdapter = new a(pagerAdapter);
        }
        this.aEQ.setAdapter(pagerAdapter);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.aEQ.setOnPageChangeListener(onPageChangeListener);
    }

    public void setPageMargin(int i) {
        this.aEQ.setPageMargin(i);
    }

    public void setOnDragOpenListener(c cVar) {
        this.aEV = cVar;
    }

    public void setFooterType(int i) {
        this.aEW = i;
        com.kwad.components.ct.widget.a aVar = this.aEQ;
        if (aVar != null) {
            aVar.setDragListener(i == 2 ? this : null);
        }
    }

    public void setSlideBounceEnable(boolean z) {
        this.aEQ.setBounceSlideEnable(z);
    }

    public void setOffscreenPageLimit(int i) {
        this.aEQ.setOffscreenPageLimit(i);
    }

    @Override // com.kwad.components.ct.widget.a.InterfaceC0545a
    public final void a(boolean z, float f) {
        if (z || !this.aET) {
            return;
        }
        s(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(float f) {
        int width = getWidth();
        int top = this.aEQ.getTop();
        int bottom = this.aEQ.getBottom();
        this.aES.setWidth(this.aER.getWidth());
        this.aES.setBounds((int) ((width - f) - this.aER.getWidth()), top, width, bottom);
        this.aES.u(f);
    }

    @Override // com.kwad.components.ct.widget.a.InterfaceC0545a
    public final void t(float f) {
        b bVar = this.aES;
        final boolean z = bVar != null && bVar.EK();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, 0.0f);
        valueAnimatorOfFloat.setDuration(200L);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ct.entry.view.EntryViewPager.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                EntryViewPager.this.s(((Float) valueAnimator.getAnimatedValue()).floatValue());
                if (!z || valueAnimator.getAnimatedFraction() < 1.0f || EntryViewPager.this.aEV == null) {
                    return;
                }
                EntryViewPager.this.aEV.EC();
            }
        });
        valueAnimatorOfFloat.start();
    }

    @Override // com.kwad.components.ct.widget.a.InterfaceC0545a
    public final void ci(int i) {
        if (this.aER.getRight() <= 0) {
            this.aET = false;
            return;
        }
        if (i >= this.aER.getLeft() - this.aEQ.getMeasuredWidth()) {
            c cVar = this.aEV;
            if (cVar != null && !this.aEU) {
                this.aEU = true;
                cVar.ED();
            }
            this.aET = true;
            int width = getWidth();
            int measuredWidth = width - (this.aEQ.getMeasuredWidth() - (this.aER.getLeft() - i));
            int top = this.aEQ.getTop();
            int bottom = this.aEQ.getBottom();
            this.aES.setWidth(this.aER.getWidth());
            this.aES.setBounds(measuredWidth, top, width, bottom);
            return;
        }
        this.aET = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.aET) {
            this.aES.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    class b extends com.kwad.components.ct.widget.c {
        private float aFa;
        private float[] aFb = new float[8];
        private Path aFc;
        private RectF aFd;
        private boolean aFe;
        private Drawable aFf;
        private Rect aFg;
        private float aFh;

        public b() {
            this.aFa = com.kwad.sdk.c.a.a.a(EntryViewPager.this.getContext(), 4.0f);
            init();
        }

        private void init() {
            setColor(Color.parseColor("#FFF2F2F2"));
            setTextSize(com.kwad.sdk.c.a.a.a(EntryViewPager.this.getContext(), 12.0f));
            setTextColor(Color.parseColor("#9c9c9c"));
            this.aFc = new Path();
            this.aFd = new RectF();
            float[] fArr = this.aFb;
            float f = this.aFa;
            fArr[0] = f;
            fArr[1] = f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f;
            fArr[7] = f;
            setCornerRadii(fArr);
        }

        public final boolean EK() {
            return this.aFe;
        }

        public final void u(float f) {
            this.aFh = f;
            if (f <= 0.0f) {
                setText("左\n滑\n查\n看\n更\n多\n视\n频");
                float[] fArr = this.aFb;
                float f2 = this.aFa;
                fArr[0] = f2;
                fArr[1] = f2;
                fArr[2] = 0.0f;
                fArr[3] = 0.0f;
                fArr[4] = 0.0f;
                fArr[5] = 0.0f;
                fArr[6] = f2;
                fArr[7] = f2;
                setCornerRadii(fArr);
                this.aFe = false;
                return;
            }
            float f3 = f * 4.5f;
            float[] fArr2 = this.aFb;
            fArr2[0] = f3;
            fArr2[1] = f3;
            fArr2[2] = 0.0f;
            fArr2[3] = 0.0f;
            fArr2[4] = 0.0f;
            fArr2[5] = 0.0f;
            fArr2[6] = f3;
            fArr2[7] = f3;
            setCornerRadii(fArr2);
            this.aFe = false;
            if (f3 >= (getBounds().height() * 2) / 3) {
                setText("松\n开\n查\n看");
                this.aFe = true;
            }
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public final void setBounds(int i, int i2, int i3, int i4) {
            super.setBounds(i, i2, i3, i4);
            this.aFc.rewind();
            this.aFd.set(i, i2, i3, i4);
            this.aFc.addRoundRect(this.aFd, this.aFb, Path.Direction.CCW);
        }

        @Override // android.graphics.drawable.Drawable
        public final void setBounds(Rect rect) {
            super.setBounds(rect);
            this.aFc.rewind();
            this.aFd.set(rect);
            this.aFc.addRoundRect(this.aFd, this.aFb, Path.Direction.CCW);
        }

        public final void setBackgroundDrawable(Drawable drawable) {
            this.aFf = drawable;
        }

        @Override // com.kwad.components.ct.widget.c, android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
        public final void draw(Canvas canvas) {
            if (this.aFf != null) {
                if (this.aFg == null) {
                    this.aFg = new Rect();
                    Rect bounds = getBounds();
                    int i = bounds.right;
                    this.aFg.set(i - ((int) (((this.aFf.getIntrinsicWidth() * bounds.height()) * 1.0f) / this.aFf.getIntrinsicHeight())), bounds.top, i, bounds.bottom);
                }
                this.aFf.setBounds(this.aFg);
                canvas.save();
                canvas.clipPath(this.aFc);
                this.aFf.draw(canvas);
                canvas.restore();
            }
            super.draw(canvas);
        }
    }

    class a extends PagerAdapter {
        private PagerAdapter aEZ;

        a(PagerAdapter pagerAdapter) {
            this.aEZ = pagerAdapter;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getCount() {
            return this.aEZ.getCount() + 1;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final boolean isViewFromObject(View view, Object obj) {
            return this.aEZ.isViewFromObject(view, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final Object instantiateItem(ViewGroup viewGroup, int i) {
            if (i == getCount() - 1) {
                viewGroup.addView(EntryViewPager.this.aER);
                return EntryViewPager.this.aER;
            }
            return this.aEZ.instantiateItem(viewGroup, i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (obj == EntryViewPager.this.aER) {
                viewGroup.removeView(EntryViewPager.this.aER);
            } else {
                this.aEZ.destroyItem(viewGroup, i, obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final Object instantiateItem(View view, int i) {
            if (i == getCount() - 1) {
                ((ViewGroup) view).addView(EntryViewPager.this.aER);
                return EntryViewPager.this.aER;
            }
            return this.aEZ.instantiateItem(view, i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final void destroyItem(View view, int i, Object obj) {
            if (obj == EntryViewPager.this.aER) {
                ((ViewGroup) view).removeView(EntryViewPager.this.aER);
            } else {
                this.aEZ.destroyItem(view, i, obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final void startUpdate(ViewGroup viewGroup) {
            this.aEZ.startUpdate(viewGroup);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            this.aEZ.setPrimaryItem(viewGroup, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final void finishUpdate(ViewGroup viewGroup) {
            this.aEZ.finishUpdate(viewGroup);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final void startUpdate(View view) {
            this.aEZ.startUpdate(view);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final void setPrimaryItem(View view, int i, Object obj) {
            this.aEZ.setPrimaryItem(view, i, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final void finishUpdate(View view) {
            this.aEZ.finishUpdate(view);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final Parcelable saveState() {
            return this.aEZ.saveState();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final void restoreState(Parcelable parcelable, ClassLoader classLoader) {
            this.aEZ.restoreState(parcelable, classLoader);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getItemPosition(Object obj) {
            return this.aEZ.getItemPosition(obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final void notifyDataSetChanged() {
            this.aEZ.notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.aEZ.registerDataSetObserver(dataSetObserver);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.aEZ.unregisterDataSetObserver(dataSetObserver);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final CharSequence getPageTitle(int i) {
            return this.aEZ.getPageTitle(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final float getPageWidth(int i) {
            if (i != getCount() - 1 || EntryViewPager.this.aER == null) {
                return this.aEZ.getPageWidth(i);
            }
            return 0.12f;
        }
    }
}

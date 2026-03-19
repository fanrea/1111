package com.kwad.sdk.lib.widget.viewpager.tabstrip;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.lib.widget.a;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    private static final int[] cdW = {R.attr.textSize, R.attr.textColor, R.attr.gravity};
    private int FT;
    private LinearLayout.LayoutParams cdX;
    private final a cdY;
    private d cdZ;
    private int ceA;
    private int ceB;
    private int ceC;
    private int ceD;
    private boolean ceE;
    private int ceF;
    private c ceG;
    private int ceH;
    private int ceI;
    private boolean ceJ;
    private int ceK;
    public boolean ceL;
    private com.kwad.sdk.lib.widget.a ceM;
    private boolean ceN;
    private boolean ceO;
    private int ceP;
    private boolean ceQ;
    private float ceR;
    private float ceS;
    private float ceT;
    public ViewPager.OnPageChangeListener cea;
    LinearLayout ceb;
    ViewPager cec;
    private int ced;
    int cee;
    float cef;
    int ceg;
    private Paint ceh;
    private Paint cei;
    private int cej;
    private int cek;
    private boolean cel;
    private boolean cem;
    private boolean cen;
    private int ceo;
    private int cep;
    private int ceq;
    private int cer;
    private int ces;
    private int cet;
    private int ceu;
    private int cev;
    private int cew;
    private ColorStateList cex;
    private Typeface cey;
    private int cez;
    private int dividerPadding;
    private Locale locale;
    private int underlineColor;

    public interface d {
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cdY = new a();
        this.cee = 0;
        this.cef = 0.0f;
        this.ceg = -1;
        this.cej = -10066330;
        this.underlineColor = 436207616;
        this.cek = 436207616;
        this.cel = false;
        this.cem = false;
        this.cen = false;
        this.ceo = 52;
        this.cep = 8;
        this.ceq = 0;
        this.cer = 2;
        this.dividerPadding = 12;
        this.ces = 24;
        this.cet = 24;
        this.ceu = 24;
        this.cev = 1;
        this.cew = 12;
        this.cey = null;
        this.cez = 1;
        this.ceA = 1;
        this.ceB = 0;
        this.ceC = 0;
        this.ceF = 0;
        this.ceM = null;
        this.ceN = true;
        this.ceO = true;
        setFillViewport(true);
        setWillNotDraw(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.ceb = linearLayout;
        linearLayout.setOrientation(0);
        this.ceb.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.ceb.setGravity(this.ceF);
        this.ceb.setClipChildren(false);
        this.ceb.setClipToPadding(false);
        addView(this.ceb);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.ceo = (int) TypedValue.applyDimension(1, this.ceo, displayMetrics);
        this.cep = (int) TypedValue.applyDimension(1, this.cep, displayMetrics);
        this.cer = (int) TypedValue.applyDimension(1, this.cer, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.ces = (int) TypedValue.applyDimension(1, this.ces, displayMetrics);
        this.cet = (int) TypedValue.applyDimension(1, this.cet, displayMetrics);
        this.ceu = (int) TypedValue.applyDimension(1, this.ceu, displayMetrics);
        this.cev = (int) TypedValue.applyDimension(1, this.cev, displayMetrics);
        this.cew = (int) TypedValue.applyDimension(2, this.cew, displayMetrics);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cdW);
        this.cew = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, this.cew);
        this.cex = typedArrayObtainStyledAttributes.getColorStateList(1);
        this.ceF = typedArrayObtainStyledAttributes.getInt(2, this.ceF);
        typedArrayObtainStyledAttributes.recycle();
        int i2 = com.kwad.sdk.R.attr.ksad_pstsIndicatorColor;
        int i3 = com.kwad.sdk.R.attr.ksad_pstsUnderlineColor;
        int i4 = com.kwad.sdk.R.attr.ksad_pstsDividerColor;
        int i5 = com.kwad.sdk.R.attr.ksad_pstsIndicatorHeight;
        int i6 = com.kwad.sdk.R.attr.ksad_pstsUnderlineHeight;
        int i7 = com.kwad.sdk.R.attr.ksad_pstsDividerPadding;
        int i8 = com.kwad.sdk.R.attr.ksad_pstsTabPaddingLeftRight;
        int i9 = com.kwad.sdk.R.attr.ksad_pstsTabBackground;
        int i10 = com.kwad.sdk.R.attr.ksad_pstsShouldExpand;
        int i11 = com.kwad.sdk.R.attr.ksad_pstsScrollOffset;
        int i12 = com.kwad.sdk.R.attr.ksad_pstsTextAllCaps;
        int i13 = com.kwad.sdk.R.attr.ksad_pstsIndicatorPadding;
        int i14 = com.kwad.sdk.R.attr.ksad_pstsShouldOverScroll;
        int i15 = com.kwad.sdk.R.attr.ksad_pstsIndicatorWidth;
        int i16 = com.kwad.sdk.R.attr.ksad_pstsIndicatorWidthFitText;
        int i17 = com.kwad.sdk.R.attr.ksad_pstsIndicatorMarginBottom;
        int i18 = com.kwad.sdk.R.attr.ksad_pstsAverageWidth;
        int i19 = com.kwad.sdk.R.attr.ksad_pstsScrollSelectedTabToCenter;
        int i20 = com.kwad.sdk.R.attr.ksad_pstsIndicatorCorner;
        int i21 = com.kwad.sdk.R.attr.ksad_pstsTabPaddingLeft;
        int i22 = com.kwad.sdk.R.attr.ksad_pstsTabPaddingRight;
        int[] iArr = {i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22};
        Arrays.sort(iArr);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr);
        this.cej = typedArrayObtainStyledAttributes.getColor(Arrays.binarySearch(iArr, i2), this.cej);
        this.underlineColor = typedArrayObtainStyledAttributes.getColor(Arrays.binarySearch(iArr, i3), this.underlineColor);
        this.cek = typedArrayObtainStyledAttributes.getColor(Arrays.binarySearch(iArr, i4), this.cek);
        this.cep = typedArrayObtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i5), this.cep);
        this.cer = typedArrayObtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i6), this.cer);
        this.dividerPadding = typedArrayObtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i7), this.dividerPadding);
        this.ces = typedArrayObtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i8), this.ces);
        this.cet = typedArrayObtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i21), this.ces);
        this.ceu = typedArrayObtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i22), this.ces);
        this.ceD = typedArrayObtainStyledAttributes.getResourceId(Arrays.binarySearch(iArr, i9), this.ceD);
        this.cel = typedArrayObtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i10), this.cel);
        this.ceo = typedArrayObtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i11), this.ceo);
        this.cem = typedArrayObtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i12), this.cem);
        this.ceq = typedArrayObtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i13), 0);
        this.cen = typedArrayObtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i14), this.cen);
        this.ceI = typedArrayObtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i15), 0);
        this.ceJ = typedArrayObtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i16), false);
        this.ceP = typedArrayObtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i17), 0);
        this.ceO = typedArrayObtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i18), true);
        this.ceQ = typedArrayObtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i19), false);
        this.ceH = typedArrayObtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i20), com.kwad.sdk.c.a.a.a(getContext(), 15.0f));
        typedArrayObtainStyledAttributes2.recycle();
        Paint paint = new Paint();
        this.ceh = paint;
        paint.setAntiAlias(true);
        this.ceh.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.cei = paint2;
        paint2.setAntiAlias(true);
        this.cei.setStrokeWidth(this.cev);
        if (this.ceO) {
            this.cdX = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            this.cdX = new LinearLayout.LayoutParams(-2, -1);
        }
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    public void setScrollListener(d dVar) {
        this.cdZ = dVar;
    }

    private static ViewGroup.LayoutParams alk() {
        return new LinearLayout.LayoutParams(-2, -1);
    }

    private boolean all() {
        return this.ceN;
    }

    public void setIndicatorColor(int i) {
        this.cej = ResourcesCompat.getColor(getResources(), i, null);
    }

    public void setIndicatorColorInt(int i) {
        this.cej = i;
    }

    public void setIndicatorPadding(int i) {
        this.ceq = i;
    }

    public void setTextColor(int i) {
        this.cex = ResourcesCompat.getColorStateList(getResources(), i, null);
        alm();
    }

    public final void a(float f, float f2, float f3, int i) {
        this.ceR = 0.0f;
        this.ceS = 0.0f;
        this.ceT = 1.0f;
        this.FT = i;
    }

    public void setTabTypefaceStyle(int i) {
        this.cez = i;
        this.ceA = i;
        alm();
    }

    public void setScrollSelectedTabToCenter(boolean z) {
        this.ceQ = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.cec = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        viewPager.setOnPageChangeListener(this.cdY);
        notifyDataSetChanged();
    }

    public void setTabGravity(int i) {
        this.ceF = i;
        this.ceb.setGravity(i);
    }

    public void setTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.cdX = layoutParams;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.cea = onPageChangeListener;
    }

    public void setClickOnlyTabStrip(c cVar) {
        this.ceG = cVar;
    }

    public final void notifyDataSetChanged() {
        int i;
        c cVar;
        this.ceb.removeAllViews();
        this.ced = this.cec.getAdapter().getCount();
        int i2 = 0;
        while (true) {
            i = this.ced;
            if (i2 >= i) {
                break;
            }
            if (this.cec.getAdapter() instanceof c.a) {
                a(i2, ((c.a) this.cec.getAdapter()).gM(i2));
            } else {
                a(i2, new c(Integer.toString(i2), this.cec.getAdapter().getPageTitle(i2)));
            }
            i2++;
        }
        if (i > 0 && (cVar = this.ceG) != null) {
            a(i, cVar);
        }
        alm();
        this.ceE = false;
        gO(this.cec.getCurrentItem());
    }

    public LinearLayout getTabsContainer() {
        return this.ceb;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        alm();
        this.ceE = false;
        post(new Runnable() { // from class: com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip.1
            @Override // java.lang.Runnable
            public final void run() {
                PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip.ab(pagerSlidingTabStrip.ceg, 0);
            }
        });
    }

    public int getTabPadding() {
        return this.ces;
    }

    public void setTabPadding(int i) {
        if (this.ces != i) {
            this.ces = i;
            if (this.cet != i) {
                this.cet = i;
            }
            if (this.ceu != i) {
                this.ceu = i;
            }
            requestLayout();
        }
    }

    public void setTabLeftPadding(int i) {
        if (this.cet != i) {
            this.cet = i;
            requestLayout();
        }
    }

    public void setTabRightPadding(int i) {
        if (this.ceu != i) {
            this.ceu = i;
            requestLayout();
        }
    }

    private void a(int i, c cVar) {
        this.ceb.addView(cVar.a(getContext(), i, this.cec), i);
    }

    private void alm() {
        TextView textView;
        this.cec.getCurrentItem();
        for (int i = 0; i < this.ceb.getChildCount(); i++) {
            View childAt = this.ceb.getChildAt(i);
            if (childAt.getLayoutParams() == null || childAt.getLayoutParams().width < 0) {
                childAt.setLayoutParams(alk());
            }
            childAt.setBackgroundResource(this.ceD);
            childAt.setPadding(this.cet, 0, this.ceu, 0);
            if (childAt instanceof TextView) {
                textView = (TextView) childAt;
            } else {
                try {
                    textView = (TextView) childAt.findViewById(com.kwad.sdk.R.id.ksad_tab_text);
                } catch (Exception unused) {
                    textView = null;
                }
            }
            if (textView != null) {
                textView.setTextSize(0, this.cew);
                if (childAt.isSelected()) {
                    int i2 = this.ceA;
                    if (i2 == 1) {
                        textView.setTypeface(null);
                        textView.getPaint().setFakeBoldText(true);
                    } else {
                        textView.setTypeface(null, i2);
                    }
                } else {
                    int i3 = this.cez;
                    if (i3 == 1) {
                        textView.setTypeface(this.cey);
                        textView.getPaint().setFakeBoldText(true);
                    } else {
                        textView.setTypeface(this.cey, i3);
                    }
                }
                ColorStateList colorStateList = this.cex;
                if (colorStateList != null) {
                    textView.setTextColor(colorStateList);
                }
                int i4 = this.FT;
                if (i4 != 0) {
                    textView.setShadowLayer(this.ceR, this.ceS, this.ceT, i4);
                }
                if (this.cem) {
                    if (Build.VERSION.SDK_INT >= 14) {
                        textView.setAllCaps(true);
                    } else {
                        textView.setText(textView.getText().toString().toUpperCase(this.locale));
                    }
                }
            }
        }
    }

    public final void ab(int i, int i2) {
        if (this.ced == 0) {
            return;
        }
        int left = this.ceb.getChildAt(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            if (this.ceQ) {
                left = (left - (getWidth() / 2)) + (this.ceb.getChildAt(i).getWidth() / 2);
            } else {
                left -= this.ceo;
            }
        }
        int i3 = this.ceB;
        if (left != i3) {
            if (!this.cen) {
                this.ceB = left;
                scrollTo(left, 0);
                return;
            }
            if (left < i3) {
                this.ceB = left;
                this.ceC = getWidth() + left;
                scrollTo(left, 0);
                return;
            }
            int right = (this.ceb.getChildAt(i).getRight() - getWidth()) + i2;
            if (i > 0 || i2 > 0) {
                right += this.ceo;
            }
            if (getWidth() + right > this.ceC) {
                this.ceC = getWidth() + right;
                this.ceB = right;
                scrollTo(right, 0);
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (!this.cel || this.ceE || View.MeasureSpec.getMode(i) == 0) {
            super.onMeasure(i, i2);
            return;
        }
        if (!this.ceE) {
            super.onMeasure(i, i2);
        }
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = 0;
        for (int i3 = 0; i3 < this.ced; i3++) {
            measuredWidth2 += this.ceb.getChildAt(i3).getMeasuredWidth();
        }
        if (measuredWidth2 > 0 && measuredWidth > 0) {
            this.ceo = this.ceb.getChildAt(0).getMeasuredWidth();
            if (measuredWidth2 <= measuredWidth) {
                for (int i4 = 0; i4 < this.ced; i4++) {
                    View childAt = this.ceb.getChildAt(i4);
                    if (i4 == 0) {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.cdX.width, this.cdX.height);
                        layoutParams.gravity = this.cdX.gravity;
                        layoutParams.weight = this.cdX.weight;
                        layoutParams.rightMargin = this.cdX.rightMargin;
                        layoutParams.bottomMargin = this.cdX.bottomMargin;
                        layoutParams.topMargin = this.cdX.topMargin;
                        layoutParams.leftMargin = 0;
                        childAt.setLayoutParams(layoutParams);
                    } else {
                        childAt.setLayoutParams(this.cdX);
                    }
                    childAt.setPadding(this.cet, 0, this.ceu, 0);
                }
            }
            this.ceE = true;
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF;
        int i;
        super.onDraw(canvas);
        if (isInEditMode() || this.ced == 0) {
            return;
        }
        View childAt = this.ceb.getChildAt(this.cee);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.cef > 0.0f && (i = this.cee) < this.ced - 1) {
            View childAt2 = this.ceb.getChildAt(i + 1);
            float left2 = childAt2.getLeft();
            float right2 = childAt2.getRight();
            float f = this.cef;
            left = (left2 * f) + ((1.0f - f) * left);
            right = (right2 * f) + ((1.0f - f) * right);
        }
        int height = getHeight();
        this.ceh.setColor(this.cej);
        int i2 = this.ceI;
        if (i2 != 0) {
            int i3 = (int) (((right - left) - i2) / 2.0f);
            this.ceq = i3;
            float f2 = this.cef;
            float f3 = (((double) f2) < 0.5d ? i3 * f2 : i3 * (1.0f - f2)) / 3.0f;
            int i4 = this.ceq;
            int i5 = (height - this.cep) - 1;
            int i6 = this.ceP;
            rectF = new RectF((left + i4) - f3, i5 - i6, (right - i4) + f3, (height - 1) - i6);
        } else {
            if (this.ceJ) {
                aj(childAt);
            }
            int i7 = this.ceq;
            int i8 = height - this.cep;
            int i9 = this.ceP;
            rectF = new RectF(left + i7, i8 - i9, right - i7, height - i9);
        }
        if (all()) {
            if (Build.VERSION.SDK_INT > 19) {
                int i10 = this.ceH;
                canvas.drawRoundRect(rectF, i10, i10, this.ceh);
            } else {
                canvas.drawRect(rectF, this.ceh);
            }
        }
        this.ceh.setColor(this.underlineColor);
        canvas.drawRect(0.0f, height - this.cer, this.ceb.getWidth(), height, this.ceh);
        this.cei.setColor(this.cek);
        for (int i11 = 0; i11 < this.ced - 1; i11++) {
            View childAt3 = this.ceb.getChildAt(i11);
            canvas.drawLine(childAt3.getRight(), this.dividerPadding, childAt3.getRight(), height - this.dividerPadding, this.cei);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void aj(View view) {
        float fA;
        int i = this.cee;
        KeyEvent.Callback childAt = i < this.ced ? this.ceb.getChildAt(i + 1) : null;
        if (childAt == null) {
            childAt = view;
        }
        float fA2 = 0.0f;
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            TextView textView2 = (TextView) childAt;
            fA2 = a(textView, textView.getText(), textView.getPaint());
            fA = a(textView2, textView2.getText(), textView2.getPaint());
        } else if (view instanceof a.InterfaceC0620a) {
            a.InterfaceC0620a interfaceC0620a = (a.InterfaceC0620a) view;
            a.InterfaceC0620a interfaceC0620a2 = (a.InterfaceC0620a) childAt;
            fA2 = a((View) interfaceC0620a, interfaceC0620a.getText(), interfaceC0620a.getTextPaint());
            fA = a((View) interfaceC0620a2, interfaceC0620a2.getText(), interfaceC0620a2.getTextPaint());
        } else {
            fA = 0.0f;
        }
        if (this.ceL) {
            this.ceq = (int) (fA2 + ((fA - fA2) * this.cef));
        } else {
            this.ceq = (int) (fA2 - ((fA2 - fA) * this.cef));
        }
    }

    private float a(View view, CharSequence charSequence, TextPaint textPaint) {
        if (this.ceM == null) {
            this.ceM = new com.kwad.sdk.lib.widget.a();
        }
        return (view.getWidth() - com.kwad.sdk.lib.widget.a.a(charSequence, textPaint, this.cew)) / 2.0f;
    }

    final void gO(int i) {
        int i2 = this.ceg;
        if (i2 != i && i < this.ced && i >= 0) {
            View childAt = this.ceb.getChildAt(i2);
            if (childAt != null) {
                childAt.setSelected(false);
            }
            this.ceg = i;
            View childAt2 = this.ceb.getChildAt(i);
            if (childAt2 != null) {
                childAt2.setSelected(true);
            }
            alm();
        }
    }

    class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int i, float f, int i2) {
            if (i >= PagerSlidingTabStrip.this.ceb.getChildCount() - (PagerSlidingTabStrip.this.ceG != null ? 1 : 0)) {
                return;
            }
            PagerSlidingTabStrip.this.cee = i;
            PagerSlidingTabStrip.this.cef = f;
            if (PagerSlidingTabStrip.this.ceQ) {
                float width = PagerSlidingTabStrip.this.ceb.getChildAt(i).getWidth();
                if (i < PagerSlidingTabStrip.this.ceb.getChildCount() - 1) {
                    int i3 = i + 1;
                    width = (PagerSlidingTabStrip.this.ceb.getChildAt(i3).getLeft() + (PagerSlidingTabStrip.this.ceb.getChildAt(i3).getWidth() / 2)) - (PagerSlidingTabStrip.this.ceb.getChildAt(i).getLeft() + (PagerSlidingTabStrip.this.ceb.getChildAt(i).getWidth() / 2));
                }
                PagerSlidingTabStrip.this.ab(i, (int) (width * f));
            } else {
                PagerSlidingTabStrip.this.ab(i, (int) (r0.ceb.getChildAt(i).getWidth() * f));
            }
            PagerSlidingTabStrip.this.invalidate();
            if (PagerSlidingTabStrip.this.cea != null) {
                PagerSlidingTabStrip.this.cea.onPageScrolled(i, f, i2);
            }
            if (PagerSlidingTabStrip.this.ceK == i) {
                PagerSlidingTabStrip.this.ceL = true;
            } else {
                PagerSlidingTabStrip.this.ceL = false;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int i) {
            if (i == 0) {
                PagerSlidingTabStrip pagerSlidingTabStrip = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip.ab(pagerSlidingTabStrip.cec.getCurrentItem(), 0);
            }
            if (PagerSlidingTabStrip.this.cea != null) {
                PagerSlidingTabStrip.this.cea.onPageScrollStateChanged(i);
            }
            if (i == 1) {
                PagerSlidingTabStrip pagerSlidingTabStrip2 = PagerSlidingTabStrip.this;
                pagerSlidingTabStrip2.ceK = pagerSlidingTabStrip2.cec.getCurrentItem();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int i) {
            PagerSlidingTabStrip.this.gO(i);
            if (PagerSlidingTabStrip.this.cea != null) {
                PagerSlidingTabStrip.this.cea.onPageSelected(i);
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        this.cee = bVar.cee;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.cee = this.cee;
        return bVar;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }

    static class b extends View.BaseSavedState {
        public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip.b.1
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ b createFromParcel(Parcel parcel) {
                return e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ b[] newArray(int i) {
                return gP(i);
            }

            private static b e(Parcel parcel) {
                return new b(parcel);
            }

            private static b[] gP(int i) {
                return new b[i];
            }
        };
        int cee;

        public b(Parcelable parcelable) {
            super(parcelable);
        }

        b(Parcel parcel) {
            super(parcel);
            this.cee = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.cee);
        }
    }

    public static class c {
        private View ceV;
        private View ceW;
        private boolean ceX;
        private boolean ceY;
        View.OnClickListener ceZ;
        private String id;
        private int position;
        private CharSequence text;

        public interface a {
            c gM(int i);
        }

        private c(String str) {
            this.id = str;
        }

        public c(String str, CharSequence charSequence) {
            this(str);
            this.text = charSequence;
        }

        public final void a(View.OnClickListener onClickListener) {
            this.ceZ = onClickListener;
            this.ceY = false;
        }

        public final View a(Context context, final int i, final ViewPager viewPager) {
            this.position = i;
            View view = this.ceV;
            if (view != null) {
                this.ceW = view;
            } else {
                TextView textView = new TextView(context);
                this.ceW = textView;
                textView.setText(this.text);
                textView.setFocusable(true);
                textView.setGravity(17);
                textView.setSingleLine();
            }
            this.ceW.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip.c.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) throws Resources.NotFoundException {
                    if (c.this.ceZ != null) {
                        c.this.ceZ.onClick(view2);
                        if (c.this.ceY) {
                            return;
                        }
                    }
                    if (c.this.ceX) {
                        return;
                    }
                    viewPager.setCurrentItem(i);
                }
            });
            return this.ceW;
        }

        public final String getId() {
            return this.id;
        }
    }
}

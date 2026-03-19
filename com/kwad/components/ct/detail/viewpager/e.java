package com.kwad.components.ct.detail.viewpager;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.core.os.ParcelableCompat;
import androidx.core.os.ParcelableCompatCreatorCallbacks;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class e extends ViewGroup {
    private static final int[] aAj = {R.attr.layout_gravity};
    private static final Comparator<b> aAl = new Comparator<b>() { // from class: com.kwad.components.ct.detail.viewpager.e.1
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(b bVar, b bVar2) {
            return a(bVar, bVar2);
        }

        private static int a(b bVar, b bVar2) {
            return bVar.position - bVar2.position;
        }
    };
    private static final Interpolator aAm = new Interpolator() { // from class: com.kwad.components.ct.detail.viewpager.e.2
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    private static final i aBi = new i();
    private int WI;
    private int WJ;
    private float Xl;
    private int aAA;
    private Drawable aAB;
    private int aAC;
    private int aAD;
    private float aAE;
    private float aAF;
    private int aAG;
    private int aAH;
    private boolean aAI;
    private boolean aAJ;
    private boolean aAK;
    private int aAL;
    private boolean aAM;
    private int aAN;
    private int aAO;
    private float aAP;
    private int aAQ;
    private int aAR;
    private boolean aAS;
    private EdgeEffectCompat aAT;
    private EdgeEffectCompat aAU;
    private boolean aAV;
    private boolean aAW;
    private boolean aAX;
    private int aAY;
    private long aAZ;
    private int aAk;
    private final ArrayList<b> aAn;
    private final b aAo;
    private final Rect aAp;
    private PagerAdapter aAq;
    private int aAr;
    private int aAs;
    private int aAt;
    private int aAu;
    private Parcelable aAv;
    private ClassLoader aAw;
    private Scroller aAx;
    private g aAy;
    private List<DataSetObserver> aAz;
    private List<ViewPager.OnPageChangeListener> aBa;
    private ViewPager.OnPageChangeListener aBb;
    private InterfaceC0511e aBc;
    private f aBd;
    private ViewPager.PageTransformer aBe;
    private Method aBf;
    private int aBg;
    private ArrayList<View> aBh;
    private final Runnable aBj;
    private int aBk;
    private float jn;
    private float jo;
    private int mActivePointerId;
    private boolean mIsBeingDragged;
    protected int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    interface a {
    }

    public static class b {
        public Object aBm;
        boolean aBn;
        float aBo;
        float aBp;
        public int position;
    }

    /* renamed from: com.kwad.components.ct.detail.viewpager.e$e, reason: collision with other inner class name */
    interface InterfaceC0511e {
    }

    public interface f {
        void CW();
    }

    protected int bV(int i2) {
        return i2;
    }

    public e(Context context) {
        super(context);
        this.aAn = new ArrayList<>();
        this.aAo = new b();
        this.aAp = new Rect();
        this.aAs = -1;
        this.aAt = -1;
        this.aAu = -1;
        this.aAv = null;
        this.aAw = null;
        this.aAE = -3.4028235E38f;
        this.aAF = Float.MAX_VALUE;
        this.aAL = 1;
        this.mActivePointerId = -1;
        this.aAV = true;
        this.aAW = false;
        this.aBj = new Runnable() { // from class: com.kwad.components.ct.detail.viewpager.e.3
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                e.this.setScrollState(0);
                e.this.Di();
                e.this.CW();
            }
        };
        this.aBk = 0;
        Df();
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aAn = new ArrayList<>();
        this.aAo = new b();
        this.aAp = new Rect();
        this.aAs = -1;
        this.aAt = -1;
        this.aAu = -1;
        this.aAv = null;
        this.aAw = null;
        this.aAE = -3.4028235E38f;
        this.aAF = Float.MAX_VALUE;
        this.aAL = 1;
        this.mActivePointerId = -1;
        this.aAV = true;
        this.aAW = false;
        this.aBj = new Runnable() { // from class: com.kwad.components.ct.detail.viewpager.e.3
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                e.this.setScrollState(0);
                e.this.Di();
                e.this.CW();
            }
        };
        this.aBk = 0;
        Df();
    }

    private void Df() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.aAx = new Scroller(context, aAm);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        this.WI = (int) (400.0f * f2);
        this.WJ = viewConfiguration.getScaledMaximumFlingVelocity();
        this.aAT = new EdgeEffectCompat(context);
        this.aAU = new EdgeEffectCompat(context);
        this.aAQ = (int) (25.0f * f2);
        this.aAR = (int) (2.0f * f2);
        this.aAN = (int) (f2 * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new d());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        com.kwad.sdk.core.d.c.i("VerticalViewPager", "onDetachedFromWindow");
        removeCallbacks(this.aBj);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollState(int i2) {
        if (this.aBk == i2) {
            return;
        }
        this.aBk = i2;
        if (this.aBe != null) {
            bK(i2 != 0);
        }
        bZ(i2);
    }

    public void setInitStartPosition(int i2) {
        this.aAu = i2;
    }

    public void setAdapter(PagerAdapter pagerAdapter) throws Resources.NotFoundException {
        PagerAdapter pagerAdapter2 = this.aAq;
        byte b2 = 0;
        if (pagerAdapter2 != null) {
            pagerAdapter2.unregisterDataSetObserver(this.aAy);
            this.aAq.startUpdate((ViewGroup) this);
            for (int i2 = 0; i2 < this.aAn.size(); i2++) {
                b bVar = this.aAn.get(i2);
                this.aAq.destroyItem((ViewGroup) this, bVar.position, bVar.aBm);
            }
            this.aAq.finishUpdate((ViewGroup) this);
            this.aAn.clear();
            Dg();
            int i3 = this.aAr;
            if (i3 != 0) {
                this.aAs = i3;
            } else {
                this.aAs = -1;
            }
            this.aAr = 0;
            scrollTo(0, 0);
        }
        int i4 = this.aAu;
        if (i4 > 0) {
            this.aAs = -1;
            this.aAr = i4;
            this.aAu = -1;
        }
        this.aAq = pagerAdapter;
        this.aAk = 0;
        if (pagerAdapter != null) {
            if (this.aAy == null) {
                this.aAy = new g(this, b2);
            }
            this.aAq.registerDataSetObserver(this.aAy);
            this.aAK = false;
            boolean z = this.aAV;
            this.aAV = true;
            this.aAk = this.aAq.getCount();
            if (this.aAt < 0) {
                if (!z) {
                    Di();
                    return;
                } else {
                    requestLayout();
                    return;
                }
            }
            this.aAq.restoreState(this.aAv, this.aAw);
            a(this.aAt, false, true);
            this.aAt = -1;
            this.aAv = null;
            this.aAw = null;
        }
    }

    private void Dg() {
        int i2 = 0;
        while (i2 < getChildCount()) {
            if (!((c) getChildAt(i2).getLayoutParams()).isDecor) {
                removeViewAt(i2);
                i2--;
            }
            i2++;
        }
    }

    public PagerAdapter getAdapter() {
        return this.aAq;
    }

    void setOnAdapterChangeListener(InterfaceC0511e interfaceC0511e) {
        this.aBc = interfaceC0511e;
    }

    public void setOnPageScrollEndListener(f fVar) {
        this.aBd = fVar;
    }

    private int getClientHeight() {
        return (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
    }

    protected void setCurrentItem(int i2) throws Resources.NotFoundException {
        com.kwad.sdk.core.d.c.i("VerticalViewPager", "setCurrentItem item=" + i2);
        this.aAK = false;
        a(i2, !this.aAV, false);
    }

    public void setCurrentItem(int i2, boolean z) throws Resources.NotFoundException {
        com.kwad.sdk.core.d.c.i("VerticalViewPager", "setCurrentItem item=" + i2 + " smoothScroll=" + z);
        this.aAK = false;
        a(i2, z, false);
    }

    public int getCurrentItem() {
        return this.aAr;
    }

    public int getPreItem() {
        return this.aAs;
    }

    protected void a(int i2, boolean z, boolean z2) throws Resources.NotFoundException {
        a(i2, z, z2, 0);
    }

    private void a(int i2, boolean z, boolean z2, int i3) throws Resources.NotFoundException {
        a(i2, z, z2, 0, false);
    }

    private void a(int i2, boolean z, boolean z2, int i3, boolean z3) throws Resources.NotFoundException {
        int i4;
        PagerAdapter pagerAdapter = this.aAq;
        if (pagerAdapter == null || pagerAdapter.getCount() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z2 && this.aAr == i2 && this.aAn.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i2 < 0) {
            i4 = 0;
        } else {
            if (i2 >= this.aAq.getCount()) {
                i2 = this.aAq.getCount() - 1;
            }
            i4 = i2;
        }
        int i5 = this.aAL;
        int i6 = this.aAr;
        if (i4 > i6 + i5 || i4 < i6 - i5) {
            for (int i7 = 0; i7 < this.aAn.size(); i7++) {
                this.aAn.get(i7).aBn = true;
            }
        }
        boolean z4 = this.aAr != i4;
        if (this.aAV) {
            this.aAs = i4;
            this.aAr = i4;
            if (z4) {
                bY(i4);
            }
            requestLayout();
            return;
        }
        ca(i4);
        a(i4, z, i3, z4, z3);
    }

    private void a(int i2, boolean z, int i3, boolean z2, boolean z3) throws Resources.NotFoundException {
        b bVarCb = cb(i2);
        int clientHeight = bVarCb != null ? (int) (getClientHeight() * Math.max(this.aAE, Math.min(bVarCb.aBp, this.aAF))) : 0;
        if (z) {
            a(0, clientHeight, i3, z3);
            if (z2) {
                bY(i2);
                return;
            }
            return;
        }
        if (z2) {
            bY(i2);
        }
        bJ(false);
        scrollTo(0, clientHeight);
        cc(clientHeight);
        if (!z2 || this.aBk == 2) {
            return;
        }
        CW();
    }

    private void a(int i2, float f2, int i3) {
        List<ViewPager.OnPageChangeListener> list = this.aBa;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                ViewPager.OnPageChangeListener onPageChangeListener = this.aBa.get(i4);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrolled(i2, f2, i3);
                }
            }
        }
        ViewPager.OnPageChangeListener onPageChangeListener2 = this.aBb;
        if (onPageChangeListener2 != null) {
            onPageChangeListener2.onPageScrolled(i2, f2, i3);
        }
    }

    private void bY(int i2) {
        List<ViewPager.OnPageChangeListener> list = this.aBa;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                ViewPager.OnPageChangeListener onPageChangeListener = this.aBa.get(i3);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(i2);
                }
            }
        }
        ViewPager.OnPageChangeListener onPageChangeListener2 = this.aBb;
        if (onPageChangeListener2 != null) {
            onPageChangeListener2.onPageSelected(i2);
        }
    }

    private void bZ(int i2) {
        List<ViewPager.OnPageChangeListener> list = this.aBa;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                ViewPager.OnPageChangeListener onPageChangeListener = this.aBa.get(i3);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrollStateChanged(i2);
                }
            }
        }
        ViewPager.OnPageChangeListener onPageChangeListener2 = this.aBb;
        if (onPageChangeListener2 != null) {
            onPageChangeListener2.onPageScrollStateChanged(i2);
        }
    }

    public final void addOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.aBa == null) {
            this.aBa = new ArrayList();
        }
        this.aBa.add(onPageChangeListener);
    }

    public final void removeOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        List<ViewPager.OnPageChangeListener> list = this.aBa;
        if (list != null) {
            list.remove(onPageChangeListener);
        }
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 7) {
            if (this.aBf == null) {
                try {
                    this.aBf = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
                } catch (NoSuchMethodException e) {
                    com.kwad.sdk.core.d.c.e("VerticalViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.aBf.invoke(this, Boolean.valueOf(z));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.c.e("VerticalViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        if (this.aBg == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((c) this.aBh.get(i3).getLayoutParams()).aBr;
    }

    public int getOffscreenPageLimit() {
        return this.aAL;
    }

    public void setOffscreenPageLimit(int i2) throws Resources.NotFoundException {
        if (i2 <= 0) {
            com.kwad.sdk.core.d.c.d("VerticalViewPager", "Requested offscreen page limit " + i2 + " too small; defaulting to 1");
            i2 = 1;
        }
        if (i2 != this.aAL) {
            this.aAL = i2;
            Di();
        }
    }

    public void setPageMargin(int i2) {
        int i3 = this.aAA;
        this.aAA = i2;
        int height = getHeight();
        a(height, height, i2, i3);
        requestLayout();
    }

    public int getPageMargin() {
        return this.aAA;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.aAB = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i2));
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.aAB;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.aAB;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    private static float q(float f2) {
        return (float) Math.sin((float) ((f2 - 0.5f) * 0.4712389167638204d));
    }

    private void a(int i2, int i3, int i4, boolean z) throws Resources.NotFoundException {
        int iAbs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i5 = 0 - scrollX;
        int i6 = i3 - scrollY;
        if (i5 == 0 && i6 == 0) {
            bJ(false);
            Di();
            if (z) {
                CW();
            }
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientHeight = getClientHeight();
        int i7 = clientHeight / 2;
        float f2 = clientHeight;
        float f3 = i7;
        float fQ = f3 + (q(Math.min(1.0f, (Math.abs(i6) * 1.0f) / f2)) * f3);
        int iAbs2 = Math.abs(i4);
        if (iAbs2 > 0) {
            iAbs = Math.round(Math.abs(fQ / iAbs2) * 1000.0f) * 4;
        } else {
            iAbs = 2 * ((int) (((Math.abs(i6) / ((f2 * this.aAq.getPageWidth(this.aAr)) + this.aAA)) + 1.0f) * 100.0f));
        }
        this.aAx.startScroll(scrollX, scrollY, i5, i6, Math.min(iAbs, 600));
        ViewCompat.postInvalidateOnAnimation(this);
    }

    private b x(int i2, int i3) {
        b bVar = new b();
        bVar.position = i2;
        bVar.aBm = this.aAq.instantiateItem((ViewGroup) this, i2);
        bVar.aBo = this.aAq.getPageWidth(i2);
        if (i3 < 0 || i3 >= this.aAn.size()) {
            this.aAn.add(bVar);
        } else {
            this.aAn.add(i3, bVar);
        }
        return bVar;
    }

    final void Dh() throws Resources.NotFoundException {
        int count = this.aAq.getCount();
        this.aAk = count;
        boolean z = this.aAn.size() < (this.aAL * 2) + 1 && this.aAn.size() < count;
        int iMax = this.aAr;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < this.aAn.size()) {
            b bVar = this.aAn.get(i2);
            int itemPosition = this.aAq.getItemPosition(bVar);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.aAn.remove(i2);
                    i2--;
                    if (!z2) {
                        this.aAq.startUpdate((ViewGroup) this);
                        z2 = true;
                    }
                    this.aAq.destroyItem((ViewGroup) this, bVar.position, bVar.aBm);
                    if (this.aAr == bVar.position) {
                        iMax = Math.max(0, Math.min(this.aAr, count - 1));
                    }
                } else if (bVar.position != itemPosition) {
                    if (bVar.position == this.aAr) {
                        iMax = itemPosition;
                    }
                    bVar.position = itemPosition;
                }
                z = true;
            }
            i2++;
        }
        if (z2) {
            this.aAq.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.aAn, aAl);
        if (z) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                c cVar = (c) getChildAt(i3).getLayoutParams();
                if (!cVar.isDecor) {
                    cVar.aBo = 0.0f;
                }
            }
            a(iMax, false, true);
            requestLayout();
        }
    }

    final void Di() throws Resources.NotFoundException {
        ca(this.aAr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0078, code lost:
    
        r10 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0109 A[PHI: r1 r6 r9
  0x0109: PHI (r1v35 int) = (r1v27 int), (r1v34 int), (r1v38 int) binds: [B:68:0x00fe, B:65:0x00e8, B:59:0x00d2] A[DONT_GENERATE, DONT_INLINE]
  0x0109: PHI (r6v19 float) = (r6v17 float), (r6v18 float), (r6v10 float) binds: [B:68:0x00fe, B:65:0x00e8, B:59:0x00d2] A[DONT_GENERATE, DONT_INLINE]
  0x0109: PHI (r9v7 int) = (r9v6 int), (r9v5 int), (r9v10 int) binds: [B:68:0x00fe, B:65:0x00e8, B:59:0x00d2] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void ca(int r18) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 641
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ct.detail.viewpager.e.ca(int):void");
    }

    private void Dj() {
        if (this.aBg != 0) {
            ArrayList<View> arrayList = this.aBh;
            if (arrayList == null) {
                this.aBh = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.aBh.add(getChildAt(i2));
            }
            Collections.sort(this.aBh, aBi);
        }
    }

    private void a(b bVar, int i2, b bVar2) {
        b bVar3;
        b bVar4;
        int count = this.aAq.getCount();
        int clientHeight = getClientHeight();
        float f2 = clientHeight > 0 ? this.aAA / clientHeight : 0.0f;
        if (bVar2 != null) {
            int i3 = bVar2.position;
            if (i3 < bVar.position) {
                float pageWidth = bVar2.aBp + bVar2.aBo + f2;
                int i4 = i3 + 1;
                int i5 = 0;
                while (i4 <= bVar.position && i5 < this.aAn.size()) {
                    b bVar5 = this.aAn.get(i5);
                    while (true) {
                        bVar4 = bVar5;
                        if (i4 <= bVar4.position || i5 >= this.aAn.size() - 1) {
                            break;
                        }
                        i5++;
                        bVar5 = this.aAn.get(i5);
                    }
                    while (i4 < bVar4.position) {
                        pageWidth += this.aAq.getPageWidth(i4) + f2;
                        i4++;
                    }
                    bVar4.aBp = pageWidth;
                    pageWidth += bVar4.aBo + f2;
                    i4++;
                }
            } else if (i3 > bVar.position) {
                int size = this.aAn.size() - 1;
                float pageWidth2 = bVar2.aBp;
                while (true) {
                    i3--;
                    if (i3 < bVar.position || size < 0) {
                        break;
                    }
                    b bVar6 = this.aAn.get(size);
                    while (true) {
                        bVar3 = bVar6;
                        if (i3 >= bVar3.position || size <= 0) {
                            break;
                        }
                        size--;
                        bVar6 = this.aAn.get(size);
                    }
                    while (i3 > bVar3.position) {
                        pageWidth2 -= this.aAq.getPageWidth(i3) + f2;
                        i3--;
                    }
                    pageWidth2 -= bVar3.aBo + f2;
                    bVar3.aBp = pageWidth2;
                }
            }
        }
        int size2 = this.aAn.size();
        float pageWidth3 = bVar.aBp;
        int i6 = bVar.position - 1;
        this.aAE = bVar.position == 0 ? bVar.aBp : -3.4028235E38f;
        int i7 = count - 1;
        this.aAF = bVar.position == i7 ? (bVar.aBp + bVar.aBo) - 1.0f : Float.MAX_VALUE;
        int i8 = i2 - 1;
        while (i8 >= 0) {
            b bVar7 = this.aAn.get(i8);
            while (i6 > bVar7.position) {
                pageWidth3 -= this.aAq.getPageWidth(i6) + f2;
                i6--;
            }
            pageWidth3 -= bVar7.aBo + f2;
            bVar7.aBp = pageWidth3;
            if (bVar7.position == 0) {
                this.aAE = pageWidth3;
            }
            i8--;
            i6--;
        }
        float pageWidth4 = bVar.aBp + bVar.aBo + f2;
        int i9 = bVar.position + 1;
        int i10 = i2 + 1;
        while (i10 < size2) {
            b bVar8 = this.aAn.get(i10);
            while (i9 < bVar8.position) {
                pageWidth4 += this.aAq.getPageWidth(i9) + f2;
                i9++;
            }
            if (bVar8.position == i7) {
                this.aAF = (bVar8.aBo + pageWidth4) - 1.0f;
            }
            bVar8.aBp = pageWidth4;
            pageWidth4 += bVar8.aBo + f2;
            i10++;
            i9++;
        }
        this.aAW = false;
    }

    public static class h extends View.BaseSavedState {
        public static final Parcelable.Creator<h> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<h>() { // from class: com.kwad.components.ct.detail.viewpager.e.h.1
            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            public final /* synthetic */ h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return a(parcel, classLoader);
            }

            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            public final /* synthetic */ h[] newArray(int i) {
                return ce(i);
            }

            private static h a(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            private static h[] ce(int i) {
                return new h[i];
            }
        });
        Parcelable aBs;
        ClassLoader aBt;
        int position;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.aBs, i);
        }

        public final String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + com.alipay.sdk.m.u.i.d;
        }

        h(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.position = parcel.readInt();
            this.aBs = parcel.readParcelable(classLoader);
            this.aBt = classLoader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) throws Resources.NotFoundException {
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.getSuperState());
        PagerAdapter pagerAdapter = this.aAq;
        if (pagerAdapter != null) {
            pagerAdapter.restoreState(hVar.aBs, hVar.aBt);
            a(hVar.position, false, true);
        } else {
            this.aAt = hVar.position;
            this.aAv = hVar.aBs;
            this.aAw = hVar.aBt;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        c cVar = (c) layoutParams;
        cVar.isDecor |= view instanceof a;
        if (this.aAI) {
            if (cVar != null && cVar.isDecor) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            cVar.aBq = true;
            addViewInLayout(view, i2, layoutParams);
            return;
        }
        if (view.getParent() instanceof ViewGroup) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        super.addView(view, i2, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.aAI) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    private b O(View view) {
        for (int i2 = 0; i2 < this.aAn.size(); i2++) {
            b bVar = this.aAn.get(i2);
            if (this.aAq.isViewFromObject(view, bVar.aBm)) {
                return bVar;
            }
        }
        return null;
    }

    private b P(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return O(view);
            }
        }
    }

    private b cb(int i2) {
        for (int i3 = 0; i3 < this.aAn.size(); i3++) {
            b bVar = this.aAn.get(i3);
            if (bVar.position == i2) {
                return bVar;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.aAV = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) throws Resources.NotFoundException {
        c cVar;
        c cVar2;
        int i4;
        int i5;
        int i6;
        boolean z = false;
        setMeasuredDimension(getDefaultSize(0, i2), getDefaultSize(0, i3));
        int measuredHeight = getMeasuredHeight();
        this.aAO = Math.min(measuredHeight / 10, this.aAN);
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (measuredHeight - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i7 = 0;
        while (true) {
            boolean z2 = true;
            int i8 = 1073741824;
            if (i7 >= childCount) {
                break;
            }
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8 && (cVar2 = (c) childAt.getLayoutParams()) != null && cVar2.isDecor) {
                int i9 = cVar2.gravity & 7;
                int i10 = cVar2.gravity & 112;
                boolean z3 = (i10 == 48 || i10 == 80) ? true : z;
                if (i9 != 3 && i9 != 5) {
                    z2 = z;
                }
                int i11 = Integer.MIN_VALUE;
                if (z3) {
                    i4 = Integer.MIN_VALUE;
                    i11 = 1073741824;
                } else {
                    i4 = z2 ? 1073741824 : Integer.MIN_VALUE;
                }
                if (cVar2.width != -2) {
                    i5 = cVar2.width != -1 ? cVar2.width : measuredWidth;
                    i11 = 1073741824;
                } else {
                    i5 = measuredWidth;
                }
                if (cVar2.height != -2) {
                    i6 = cVar2.height != -1 ? cVar2.height : paddingTop;
                } else {
                    i6 = paddingTop;
                    i8 = i4;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i5, i11), View.MeasureSpec.makeMeasureSpec(i6, i8));
                if (z3) {
                    paddingTop -= childAt.getMeasuredHeight();
                } else if (z2) {
                    measuredWidth -= childAt.getMeasuredWidth();
                }
            }
            i7++;
            z = false;
        }
        this.aAG = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        this.aAH = View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
        this.aAI = true;
        Di();
        this.aAI = false;
        int childCount2 = getChildCount();
        for (int i12 = 0; i12 < childCount2; i12++) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8 && ((cVar = (c) childAt2.getLayoutParams()) == null || !cVar.isDecor)) {
                childAt2.measure(this.aAG, View.MeasureSpec.makeMeasureSpec((int) (paddingTop * cVar.aBo), 1073741824));
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i3 != i5) {
            int i6 = this.aAA;
            a(i3, i5, i6, i6);
        }
    }

    private void a(int i2, int i3, int i4, int i5) {
        if (i3 > 0 && !this.aAn.isEmpty()) {
            int scrollY = (int) ((getScrollY() / (((i3 - getPaddingTop()) - getPaddingBottom()) + i5)) * (((i2 - getPaddingTop()) - getPaddingBottom()) + i4));
            scrollTo(getScrollX(), scrollY);
            if (this.aAx.isFinished()) {
                return;
            }
            this.aAx.startScroll(0, scrollY, 0, (int) (cb(this.aAr).aBp * i2), this.aAx.getDuration() - this.aAx.timePassed());
            return;
        }
        b bVarCb = cb(this.aAr);
        int iMin = (int) ((bVarCb != null ? Math.min(bVarCb.aBp, this.aAF) : 0.0f) * ((i2 - getPaddingTop()) - getPaddingBottom()));
        if (iMin != getScrollY()) {
            bJ(false);
            scrollTo(getScrollX(), iMin);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0090  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onLayout(boolean r19, int r20, int r21, int r22, int r23) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ct.detail.viewpager.e.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.aAx.isFinished() && this.aAx.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.aAx.getCurrX();
            int currY = this.aAx.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!cc(currY)) {
                    this.aAx.abortAnimation();
                    scrollTo(currX, 0);
                }
            }
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }
        bJ(true);
    }

    private boolean cc(int i2) {
        if (this.aAn.size() == 0) {
            this.aAX = false;
            onPageScrolled(0, 0.0f, 0);
            if (this.aAX) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        b bVarDm = Dm();
        int clientHeight = getClientHeight();
        int i3 = this.aAA;
        int i4 = clientHeight + i3;
        float f2 = clientHeight;
        int i5 = bVarDm.position;
        float f3 = ((i2 / f2) - bVarDm.aBp) / (bVarDm.aBo + (i3 / f2));
        this.aAX = false;
        onPageScrolled(i5, f3, (int) (i4 * f3));
        if (this.aAX) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void onPageScrolled(int r12, float r13, int r14) {
        /*
            r11 = this;
            int r0 = r11.aAY
            r1 = 0
            if (r0 <= 0) goto L6d
            int r0 = r11.getScrollY()
            int r2 = r11.getPaddingTop()
            int r3 = r11.getPaddingBottom()
            int r4 = r11.getHeight()
            int r5 = r11.getChildCount()
            r6 = r1
        L1a:
            if (r6 >= r5) goto L6d
            android.view.View r7 = r11.getChildAt(r6)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            com.kwad.components.ct.detail.viewpager.e$c r8 = (com.kwad.components.ct.detail.viewpager.e.c) r8
            boolean r9 = r8.isDecor
            if (r9 == 0) goto L6a
            int r8 = r8.gravity
            r8 = r8 & 112(0x70, float:1.57E-43)
            r9 = 16
            if (r8 == r9) goto L4f
            r9 = 48
            if (r8 == r9) goto L49
            r9 = 80
            if (r8 == r9) goto L3c
            r8 = r2
            goto L5e
        L3c:
            int r8 = r4 - r3
            int r9 = r7.getMeasuredHeight()
            int r8 = r8 - r9
            int r9 = r7.getMeasuredHeight()
            int r3 = r3 + r9
            goto L5b
        L49:
            int r8 = r7.getHeight()
            int r8 = r8 + r2
            goto L5e
        L4f:
            int r8 = r7.getMeasuredHeight()
            int r8 = r4 - r8
            int r8 = r8 / 2
            int r8 = java.lang.Math.max(r8, r2)
        L5b:
            r10 = r8
            r8 = r2
            r2 = r10
        L5e:
            int r2 = r2 + r0
            int r9 = r7.getTop()
            int r2 = r2 - r9
            if (r2 == 0) goto L69
            r7.offsetTopAndBottom(r2)
        L69:
            r2 = r8
        L6a:
            int r6 = r6 + 1
            goto L1a
        L6d:
            r11.a(r12, r13, r14)
            androidx.viewpager.widget.ViewPager$PageTransformer r12 = r11.aBe
            if (r12 == 0) goto La0
            int r12 = r11.getScrollY()
            int r13 = r11.getChildCount()
        L7c:
            if (r1 >= r13) goto La0
            android.view.View r14 = r11.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r14.getLayoutParams()
            com.kwad.components.ct.detail.viewpager.e$c r0 = (com.kwad.components.ct.detail.viewpager.e.c) r0
            boolean r0 = r0.isDecor
            if (r0 != 0) goto L9d
            int r0 = r14.getTop()
            int r0 = r0 - r12
            float r0 = (float) r0
            int r2 = r11.getClientHeight()
            float r2 = (float) r2
            float r0 = r0 / r2
            androidx.viewpager.widget.ViewPager$PageTransformer r2 = r11.aBe
            r2.transformPage(r14, r0)
        L9d:
            int r1 = r1 + 1
            goto L7c
        La0:
            r12 = 1
            r11.aAX = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ct.detail.viewpager.e.onPageScrolled(int, float, int):void");
    }

    private void bJ(boolean z) {
        boolean z2 = this.aBk == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            this.aAx.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.aAx.getCurrX();
            int currY = this.aAx.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
            }
        }
        this.aAK = false;
        for (int i2 = 0; i2 < this.aAn.size(); i2++) {
            b bVar = this.aAn.get(i2);
            if (bVar.aBn) {
                bVar.aBn = false;
                z2 = true;
            }
        }
        if (z2) {
            if (z) {
                ViewCompat.postOnAnimation(this, this.aBj);
            } else {
                this.aBj.run();
            }
        }
    }

    private boolean h(float f2, float f3) {
        if (f2 >= this.aAO || f3 <= 0.0f) {
            return f2 > ((float) (getHeight() - this.aAO)) && f3 < 0.0f;
        }
        return true;
    }

    private void bK(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            ViewCompat.setLayerType(getChildAt(i2), z ? 2 : 0, null);
        }
    }

    protected void CW() {
        f fVar = this.aBd;
        if (fVar != null) {
            fVar.CW();
        }
    }

    public final void a(DataSetObserver dataSetObserver) {
        if (this.aAz == null) {
            this.aAz = new ArrayList();
        }
        this.aAz.add(dataSetObserver);
    }

    public final void b(DataSetObserver dataSetObserver) {
        List<DataSetObserver> list = this.aAz;
        if (list != null) {
            list.remove(dataSetObserver);
        }
    }

    public final void Dk() {
        List<DataSetObserver> list = this.aAz;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                DataSetObserver dataSetObserver = this.aAz.get(i2);
                if (dataSetObserver != null) {
                    dataSetObserver.onChanged();
                }
            }
        }
    }

    public final void Dl() {
        List<DataSetObserver> list = this.aAz;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                DataSetObserver dataSetObserver = this.aAz.get(i2);
                if (dataSetObserver != null) {
                    dataSetObserver.onInvalidated();
                }
            }
        }
    }

    private static float getX(MotionEvent motionEvent, int i2) {
        if (i2 != -1 && motionEvent.getPointerCount() > i2) {
            return MotionEventCompat.getX(motionEvent, i2);
        }
        return motionEvent.getX();
    }

    private static float getY(MotionEvent motionEvent, int i2) {
        if (i2 != -1 && motionEvent.getPointerCount() > i2) {
            return MotionEventCompat.getY(motionEvent, i2);
        }
        return motionEvent.getY();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.mIsBeingDragged = false;
            this.aAM = false;
            this.mActivePointerId = -1;
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.mVelocityTracker = null;
            }
            return false;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                return true;
            }
            if (this.aAM) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.jn = x;
            this.aAP = x;
            float y = motionEvent.getY();
            this.jo = y;
            this.Xl = y;
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            this.aAM = false;
            this.aAx.computeScrollOffset();
            if (this.aBk == 2 && Math.abs(this.aAx.getFinalY() - this.aAx.getCurrY()) > this.aAR) {
                this.aAx.abortAnimation();
                this.aAK = false;
                Di();
                this.mIsBeingDragged = true;
                bL(true);
                setScrollState(1);
            } else {
                bJ(false);
                this.mIsBeingDragged = false;
            }
        } else if (action == 2) {
            int i2 = this.mActivePointerId;
            if (i2 != -1) {
                int iFindPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i2);
                float y2 = getY(motionEvent, iFindPointerIndex);
                float f2 = y2 - this.Xl;
                float fAbs = Math.abs(f2);
                float x2 = getX(motionEvent, iFindPointerIndex);
                float fAbs2 = Math.abs(x2 - this.jn);
                boolean z = !h(this.Xl, f2);
                boolean zCanScroll = canScroll(this, false, (int) f2, (int) x2, (int) y2);
                if (f2 != 0.0f && z && zCanScroll) {
                    this.aAP = x2;
                    this.Xl = y2;
                    this.aAM = true;
                    return false;
                }
                int i3 = this.mTouchSlop;
                if (fAbs > i3 && fAbs > fAbs2) {
                    this.mIsBeingDragged = true;
                    bL(true);
                    setScrollState(1);
                    float f3 = this.jo;
                    this.Xl = f2 > 0.0f ? f3 + this.mTouchSlop : f3 - this.mTouchSlop;
                    this.aAP = x2;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > i3) {
                    this.aAM = true;
                }
                if (this.mIsBeingDragged && r(y2)) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
            }
        } else if (action == 6) {
            g(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        return this.mIsBeingDragged;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
        PagerAdapter pagerAdapter;
        float f2;
        if (this.aAS) {
            return true;
        }
        boolean zOnRelease = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (pagerAdapter = this.aAq) == null || pagerAdapter.getCount() == 0) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.aAx.abortAnimation();
            this.aAK = false;
            Di();
            float x = motionEvent.getX();
            this.jn = x;
            this.aAP = x;
            float y = motionEvent.getY();
            this.jo = y;
            this.Xl = y;
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
        } else if (action == 1) {
            if (this.mIsBeingDragged) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.WJ);
                int yVelocity = (int) VelocityTrackerCompat.getYVelocity(velocityTracker, this.mActivePointerId);
                this.aAK = true;
                int clientHeight = getClientHeight();
                int scrollY = getScrollY();
                b bVarDm = Dm();
                if (bVarDm != null) {
                    a(a(bVarDm.position, ((scrollY / clientHeight) - bVarDm.aBp) / bVarDm.aBo, yVelocity, (int) (getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId)) - this.jo)), true, true, yVelocity, true);
                    this.mActivePointerId = -1;
                    Dn();
                    zOnRelease = this.aAT.onRelease() | this.aAU.onRelease();
                }
            }
            this.aAZ = System.currentTimeMillis();
        } else if (action == 2) {
            if (!this.mIsBeingDragged) {
                int iFindPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId);
                float y2 = getY(motionEvent, iFindPointerIndex);
                float fAbs = Math.abs(y2 - this.Xl);
                float x2 = getX(motionEvent, iFindPointerIndex);
                float fAbs2 = Math.abs(x2 - this.aAP);
                if (fAbs > this.mTouchSlop && fAbs > fAbs2) {
                    this.mIsBeingDragged = true;
                    bL(true);
                    float f3 = this.jo;
                    if (y2 - f3 > 0.0f) {
                        f2 = f3 + this.mTouchSlop;
                    } else {
                        f2 = f3 - this.mTouchSlop;
                    }
                    this.Xl = f2;
                    this.aAP = x2;
                    setScrollState(1);
                    setScrollingCacheEnabled(true);
                    ViewParent parent = getParent();
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                }
            }
            if (this.mIsBeingDragged) {
                zOnRelease = false | r(getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId)));
            }
        } else if (action != 3) {
            if (action == 5) {
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.Xl = getY(motionEvent, actionIndex);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
            } else if (action == 6) {
                g(motionEvent);
                this.Xl = getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId));
            }
        } else if (this.mIsBeingDragged) {
            a(this.aAr, true, 0, false, false);
            this.mActivePointerId = -1;
            Dn();
            zOnRelease = this.aAT.onRelease() | this.aAU.onRelease();
        }
        if (zOnRelease) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        return true;
    }

    private void bL(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    private boolean r(float f2) {
        boolean z;
        boolean z2;
        float f3 = this.Xl - f2;
        this.Xl = f2;
        float scrollY = getScrollY() + f3;
        float clientHeight = getClientHeight();
        float f4 = this.aAE * clientHeight;
        float f5 = this.aAF * clientHeight;
        boolean z3 = true;
        if (this.aAn.size() > 0) {
            b bVar = this.aAn.get(0);
            ArrayList<b> arrayList = this.aAn;
            b bVar2 = arrayList.get(arrayList.size() - 1);
            if (bVar.position != 0) {
                f4 = bVar.aBp * clientHeight;
                z2 = false;
            } else {
                z2 = true;
            }
            if (bVar2.position != this.aAq.getCount() - 1) {
                f5 = bVar2.aBp * clientHeight;
                z3 = z2;
                z = false;
            } else {
                z3 = z2;
                z = true;
            }
        } else {
            z = true;
        }
        if (scrollY < f4) {
            zOnPull = z3 ? this.aAT.onPull(Math.abs(f4 - scrollY) / clientHeight) : false;
            scrollY = f4;
        } else if (scrollY > f5) {
            zOnPull = z ? this.aAU.onPull(Math.abs(scrollY - f5) / clientHeight) : false;
            scrollY = f5;
        }
        int i2 = (int) scrollY;
        this.aAP += scrollY - i2;
        int iBV = bV(i2);
        scrollTo(getScrollX(), iBV);
        cc(bV(iBV));
        return zOnPull;
    }

    private b Dm() {
        int i2;
        int clientHeight = getClientHeight();
        float f2 = 0.0f;
        float scrollY = clientHeight > 0 ? getScrollY() / clientHeight : 0.0f;
        float f3 = clientHeight > 0 ? this.aAA / clientHeight : 0.0f;
        b bVar = null;
        int i3 = 0;
        int i4 = -1;
        boolean z = true;
        float f4 = 0.0f;
        while (i3 < this.aAn.size()) {
            b bVar2 = this.aAn.get(i3);
            if (!z && bVar2.position != (i2 = i4 + 1)) {
                bVar2 = this.aAo;
                bVar2.aBp = f2 + f4 + f3;
                bVar2.position = i2;
                bVar2.aBo = this.aAq.getPageWidth(bVar2.position);
                i3--;
            }
            f2 = bVar2.aBp;
            float f5 = bVar2.aBo + f2 + f3;
            if (!z && scrollY < f2) {
                return bVar;
            }
            if (scrollY < f5 || i3 == this.aAn.size() - 1) {
                return bVar2;
            }
            i4 = bVar2.position;
            f4 = bVar2.aBo;
            i3++;
            z = false;
            bVar = bVar2;
        }
        return bVar;
    }

    protected int a(int i2, float f2, int i3, int i4) {
        if (Math.abs(i4) <= this.aAQ || Math.abs(i3) <= this.WI) {
            i2 = (int) (i2 + f2 + (i2 >= this.aAr ? 0.4f : 0.6f));
        } else if (i3 <= 0) {
            i2++;
        }
        if (this.aAn.size() <= 0) {
            return i2;
        }
        return Math.max(this.aAn.get(0).position, Math.min(i2, this.aAn.get(r4.size() - 1).position));
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        super.draw(canvas);
        int overScrollMode = ViewCompat.getOverScrollMode(this);
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (pagerAdapter = this.aAq) != null && pagerAdapter.getCount() > 1)) {
            if (!this.aAT.isFinished()) {
                int iSave = canvas.save();
                int height = getHeight();
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate(getPaddingLeft(), this.aAE * height);
                this.aAT.setSize(width, height);
                zDraw = false | this.aAT.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.aAU.isFinished()) {
                int iSave2 = canvas.save();
                int height2 = getHeight();
                int width2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.rotate(180.0f);
                canvas.translate((-width2) - getPaddingLeft(), (-(this.aAF + 1.0f)) * height2);
                this.aAU.setSize(width2, height2);
                zDraw |= this.aAU.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.aAT.finish();
            this.aAU.finish();
        }
        if (zDraw) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        super.onDraw(canvas);
        if (this.aAA <= 0 || this.aAB == null || this.aAn.size() <= 0 || this.aAq == null) {
            return;
        }
        int scrollY = getScrollY();
        float height = getHeight();
        float f5 = this.aAA / height;
        int i2 = 0;
        b bVar = this.aAn.get(0);
        float f6 = bVar.aBp;
        int size = this.aAn.size();
        int i3 = bVar.position;
        int i4 = this.aAn.get(size - 1).position;
        while (i3 < i4) {
            while (i3 > bVar.position && i2 < size) {
                i2++;
                bVar = this.aAn.get(i2);
            }
            if (i3 == bVar.position) {
                f3 = (bVar.aBp + bVar.aBo) * height;
                f2 = bVar.aBp + bVar.aBo + f5;
            } else {
                float pageWidth = this.aAq.getPageWidth(i3);
                float f7 = (f6 + pageWidth) * height;
                f2 = f6 + pageWidth + f5;
                f3 = f7;
            }
            int i5 = this.aAA;
            if (i5 + f3 > scrollY) {
                f4 = f5;
                this.aAB.setBounds(this.aAC, (int) f3, this.aAD, (int) (i5 + f3 + 0.5f));
                this.aAB.draw(canvas);
            } else {
                f4 = f5;
            }
            if (f3 > scrollY + r2) {
                return;
            }
            i3++;
            f6 = f2;
            f5 = f4;
        }
    }

    private void g(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.mActivePointerId) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.Xl = getY(motionEvent, i2);
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, i2);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void Dn() {
        this.mIsBeingDragged = false;
        this.aAM = false;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.aAJ != z) {
            this.aAJ = z;
        }
    }

    public final boolean cd(int i2) {
        if (this.aAq == null) {
            return false;
        }
        int clientHeight = getClientHeight();
        int scrollY = getScrollY();
        return i2 < 0 ? scrollY > ((int) (((float) clientHeight) * this.aAE)) : i2 > 0 && scrollY < ((int) (((float) clientHeight) * this.aAF));
    }

    private boolean canScroll(View view, boolean z, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt.isEnabled() && childAt.getVisibility() == 0 && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && (i6 = i3 + scrollX) >= childAt.getLeft() && i6 < childAt.getRight() && canScroll(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && ViewCompat.canScrollVertically(view, -i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    private boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                return arrowScroll(17);
            }
            if (keyCode == 22) {
                return arrowScroll(66);
            }
            if (keyCode == 61 && Build.VERSION.SDK_INT >= 11) {
                if (keyEvent.hasNoModifiers()) {
                    return arrowScroll(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return arrowScroll(1);
                }
            }
        }
        return false;
    }

    private boolean arrowScroll(int i2) throws Resources.NotFoundException {
        boolean z;
        View viewFindFocus = findFocus();
        boolean zDo = false;
        if (viewFindFocus == this) {
            viewFindFocus = null;
        } else if (viewFindFocus != null) {
            ViewParent parent = viewFindFocus.getParent();
            while (true) {
                if (!(parent instanceof ViewGroup)) {
                    z = false;
                    break;
                }
                if (parent == this) {
                    z = true;
                    break;
                }
                parent = parent.getParent();
            }
            if (!z) {
                StringBuilder sb = new StringBuilder();
                sb.append(viewFindFocus.getClass().getSimpleName());
                for (ViewParent parent2 = viewFindFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                    sb.append(" => ").append(parent2.getClass().getSimpleName());
                }
                com.kwad.sdk.core.d.c.d("VerticalViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                viewFindFocus = null;
            }
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i2);
        if (viewFindNextFocus == null || viewFindNextFocus == viewFindFocus) {
            if (i2 == 33 || i2 == 1) {
                zDo = Do();
            } else if (i2 == 130 || i2 == 2) {
                zDo = Dp();
            }
        } else if (i2 == 33) {
            int i3 = a(this.aAp, viewFindNextFocus).top;
            int i4 = a(this.aAp, viewFindFocus).top;
            if (viewFindFocus != null && i3 >= i4) {
                zDo = Do();
            } else {
                zDo = viewFindNextFocus.requestFocus();
            }
        } else if (i2 == 130) {
            int i5 = a(this.aAp, viewFindNextFocus).bottom;
            int i6 = a(this.aAp, viewFindFocus).bottom;
            if (viewFindFocus != null && i5 <= i6) {
                zDo = Dp();
            } else {
                zDo = viewFindNextFocus.requestFocus();
            }
        }
        if (zDo) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i2));
        }
        return zDo;
    }

    private Rect a(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private boolean Do() throws Resources.NotFoundException {
        int i2 = this.aAr;
        if (i2 <= 0) {
            return false;
        }
        setCurrentItem(i2 - 1, true);
        return true;
    }

    private boolean Dp() throws Resources.NotFoundException {
        PagerAdapter pagerAdapter = this.aAq;
        if (pagerAdapter == null || this.aAr >= pagerAdapter.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.aAr + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        b bVarO;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (bVarO = O(childAt)) != null && bVarO.position == this.aAr) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i3 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        b bVarO;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (bVarO = O(childAt)) != null && bVarO.position == this.aAr) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        b bVarO;
        int childCount = getChildCount();
        int i5 = -1;
        if ((i2 & 2) != 0) {
            i5 = childCount;
            i3 = 0;
            i4 = 1;
        } else {
            i3 = childCount - 1;
            i4 = -1;
        }
        while (i3 != i5) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (bVarO = O(childAt)) != null && bVarO.position == this.aAr && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i3 += i4;
        }
        return false;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        b bVarO;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (bVarO = O(childAt)) != null && bVarO.position == this.aAr && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof c) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    class d extends AccessibilityDelegateCompat {
        d() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            AccessibilityRecordCompat accessibilityRecordCompatObtain = AccessibilityRecordCompat.obtain();
            accessibilityRecordCompatObtain.setScrollable(Dr());
            if (accessibilityEvent.getEventType() != 4096 || e.this.aAq == null) {
                return;
            }
            accessibilityRecordCompatObtain.setItemCount(e.this.aAq.getCount());
            accessibilityRecordCompatObtain.setFromIndex(e.this.aAr);
            accessibilityRecordCompatObtain.setToIndex(e.this.aAr);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
            accessibilityNodeInfoCompat.setScrollable(Dr());
            if (e.this.cd(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
            }
            if (e.this.cd(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) throws Resources.NotFoundException {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (i == 4096) {
                if (!e.this.cd(1)) {
                    return false;
                }
                e eVar = e.this;
                eVar.setCurrentItem(eVar.aAr + 1);
                return true;
            }
            if (i != 8192 || !e.this.cd(-1)) {
                return false;
            }
            e eVar2 = e.this;
            eVar2.setCurrentItem(eVar2.aAr - 1);
            return true;
        }

        private boolean Dr() {
            return e.this.aAq != null && e.this.aAq.getCount() > 1;
        }
    }

    class g extends DataSetObserver {
        private g() {
        }

        /* synthetic */ g(e eVar, byte b) {
            this();
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() throws Resources.NotFoundException {
            e.this.Dh();
            e.this.Dk();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() throws Resources.NotFoundException {
            e.this.Dh();
            e.this.Dl();
        }
    }

    public static class c extends ViewGroup.LayoutParams {
        float aBo;
        boolean aBq;
        int aBr;
        public int gravity;
        public boolean isDecor;
        int position;

        public c() {
            super(-1, -1);
            this.aBo = 0.0f;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.aBo = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.aAj);
            this.gravity = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    static class i implements Comparator<View> {
        i() {
        }

        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(View view, View view2) {
            return compare2(view, view2);
        }

        /* renamed from: compare, reason: avoid collision after fix types in other method */
        private static int compare2(View view, View view2) {
            c cVar = (c) view.getLayoutParams();
            c cVar2 = (c) view2.getLayoutParams();
            if (cVar.isDecor != cVar2.isDecor) {
                return cVar.isDecor ? 1 : -1;
            }
            return cVar.position - cVar2.position;
        }
    }
}

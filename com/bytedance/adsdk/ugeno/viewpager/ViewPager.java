package com.bytedance.adsdk.ugeno.viewpager;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import com.alipay.sdk.m.u.i;
import com.bytedance.sdk.component.utils.mq;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ViewPager extends ViewGroup {
    private int ar;
    com.bytedance.adsdk.ugeno.viewpager.hc b;
    private float ba;
    private VelocityTracker bc;
    int c;
    private int cb;
    private int d;
    private int dc;
    private int de;
    private int dz;
    private an e;
    private float fs;
    private boolean fu;
    private final hc gb;
    private final ArrayList<hc> h;
    private boolean he;
    private int hv;
    private ArrayList<View> i;
    private List<Object> ia;
    private boolean j;
    private float jh;
    private boolean k;
    private boolean l;
    private Parcelable mk;
    private ClassLoader mq;
    private float mt;
    private boolean np;
    private int nr;
    private int nv;
    private u nw;
    private EdgeEffect q;
    private final Runnable qr;
    private float r;
    private c ra;
    private int rf;
    private EdgeEffect ru;
    private c rw;
    private int s;
    private float sy;
    private int tc;
    private List<c> to;
    private int tr;
    private final Rect tt;
    private Scroller uo;
    private int us;
    private int v;
    private int vv;
    private Drawable w;
    private boolean wl;
    private int xp;
    private int y;
    private boolean yi;
    private boolean yn;
    private int yo;
    private int z;
    private boolean zw;
    static final int[] hc = {R.attr.layout_gravity};
    private static final Comparator<hc> u = new Comparator<hc>() { // from class: com.bytedance.adsdk.ugeno.viewpager.ViewPager.1
        @Override // java.util.Comparator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compare(hc hcVar, hc hcVar2) {
            return hcVar.hc - hcVar2.hc;
        }
    };
    private static final Interpolator an = new Interpolator() { // from class: com.bytedance.adsdk.ugeno.viewpager.ViewPager.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private static final gb ey = new gb();

    public interface c {
        void d(int i, float f, int i2);

        void gb(int i);

        void tt(int i);
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface d {
    }

    public interface u {
        void d(View view, float f);
    }

    static class hc {
        boolean b;
        float c;
        Object d;
        int hc;
        float u;

        hc() {
        }
    }

    public ViewPager(Context context) {
        super(context);
        this.h = new ArrayList<>();
        this.gb = new hc();
        this.tt = new Rect();
        this.tc = -1;
        this.mk = null;
        this.mq = null;
        this.jh = -3.4028235E38f;
        this.sy = Float.MAX_VALUE;
        this.vv = 1;
        this.hv = -1;
        this.yn = true;
        this.l = false;
        this.qr = new Runnable() { // from class: com.bytedance.adsdk.ugeno.viewpager.ViewPager.3
            @Override // java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                ViewPager.this.setScrollState(0);
                ViewPager.this.b();
            }
        };
        this.ar = 0;
        d();
    }

    void d() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.uo = new Scroller(context, an);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.z = viewConfiguration.getScaledPagingTouchSlop();
        this.dc = (int) (400.0f * f);
        this.tr = viewConfiguration.getScaledMaximumFlingVelocity();
        this.q = new EdgeEffect(context);
        this.ru = new EdgeEffect(context);
        this.nv = (int) (25.0f * f);
        this.y = (int) (2.0f * f);
        this.s = (int) (f * 16.0f);
    }

    public void setScroller(Scroller scroller) {
        this.uo = scroller;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.qr);
        Scroller scroller = this.uo;
        if (scroller != null && !scroller.isFinished()) {
            this.uo.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    void setScrollState(int i) {
        if (this.ar == i) {
            return;
        }
        this.ar = i;
        if (this.nw != null) {
            hc(i != 0);
        }
        an(i);
    }

    public void setAdapter(com.bytedance.adsdk.ugeno.viewpager.hc hcVar) throws Resources.NotFoundException {
        com.bytedance.adsdk.ugeno.viewpager.hc hcVar2 = this.b;
        if (hcVar2 != null) {
            hcVar2.d((DataSetObserver) null);
            for (int i = 0; i < this.h.size(); i++) {
                hc hcVar3 = this.h.get(i);
                this.b.d((ViewGroup) this, hcVar3.hc, hcVar3.d);
            }
            this.h.clear();
            an();
            this.c = 0;
            scrollTo(0, 0);
        }
        this.b = hcVar;
        this.d = 0;
        if (hcVar != null) {
            if (this.e == null) {
                this.e = new an();
            }
            this.b.d((DataSetObserver) this.e);
            this.he = false;
            boolean z = this.yn;
            this.yn = true;
            this.d = this.b.d();
            int i2 = this.tc;
            if (i2 >= 0) {
                d(i2, false, true);
                this.tc = -1;
                this.mk = null;
                this.mq = null;
            } else if (!z) {
                b();
            } else {
                requestLayout();
            }
        }
        List<Object> list = this.ia;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.ia.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.ia.get(i3);
        }
    }

    private void an() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((b) getChildAt(i).getLayoutParams()).d) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public com.bytedance.adsdk.ugeno.viewpager.hc getAdapter() {
        return this.b;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) throws Resources.NotFoundException {
        this.he = false;
        d(i, !this.yn, false);
    }

    public void d(int i, boolean z) throws Resources.NotFoundException {
        this.he = false;
        d(i, z, false);
    }

    public int getCurrentItem() {
        return this.c;
    }

    void d(int i, boolean z, boolean z2) throws Resources.NotFoundException {
        d(i, z, z2, 0);
    }

    void d(int i, boolean z, boolean z2, int i2) throws Resources.NotFoundException {
        com.bytedance.adsdk.ugeno.viewpager.hc hcVar = this.b;
        if (hcVar == null || hcVar.d() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z2 && this.c == i && this.h.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i < 0) {
            i = 0;
        } else if (i >= this.b.d()) {
            i = this.b.d() - 1;
        }
        int i3 = this.vv;
        int i4 = this.c;
        if (i > i4 + i3 || i < i4 - i3) {
            for (int i5 = 0; i5 < this.h.size(); i5++) {
                this.h.get(i5).b = true;
            }
        }
        boolean z3 = this.c != i;
        if (this.yn) {
            this.c = i;
            if (z3) {
                u(i);
            }
            requestLayout();
            return;
        }
        d(i);
        d(i, z, i2, z3);
    }

    private void d(int i, boolean z, int i2, boolean z2) throws Resources.NotFoundException {
        hc hcVarHc = hc(i);
        int clientWidth = hcVarHc != null ? (int) (getClientWidth() * Math.max(this.jh, Math.min(hcVarHc.u, this.sy))) : 0;
        if (z) {
            d(clientWidth, 0, i2);
            if (z2) {
                u(i);
                return;
            }
            return;
        }
        if (z2) {
            u(i);
        }
        d(false);
        scrollTo(clientWidth, 0);
        c(clientWidth);
    }

    @Deprecated
    public void setOnPageChangeListener(c cVar) {
        this.ra = cVar;
    }

    public void d(c cVar) {
        if (this.to == null) {
            this.to = new ArrayList();
        }
        this.to.add(cVar);
    }

    public void d(boolean z, u uVar) throws Resources.NotFoundException {
        d(z, uVar, 2);
    }

    public void d(boolean z, u uVar, int i) throws Resources.NotFoundException {
        boolean z2 = uVar != null;
        boolean z3 = z2 != (this.nw != null);
        this.nw = uVar;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            this.nr = z ? 2 : 1;
            this.dz = i;
        } else {
            this.nr = 0;
        }
        if (z3) {
            b();
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        if (this.nr == 2) {
            i2 = (i - 1) - i2;
        }
        return ((b) this.i.get(i2).getLayoutParams()).an;
    }

    public int getOffscreenPageLimit() {
        return this.vv;
    }

    public void setOffscreenPageLimit(int i) throws Resources.NotFoundException {
        if (i <= 0) {
            mq.hc("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.vv) {
            this.vv = i;
            b();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.cb;
        this.cb = i;
        int width = getWidth();
        d(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.cb;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.w = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.w;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.w;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    float d(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    void d(int i, int i2, int i3) throws Resources.NotFoundException {
        int scrollX;
        int iAbs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.uo;
        if ((scroller == null || scroller.isFinished()) ? false : true) {
            scrollX = this.k ? this.uo.getCurrX() : this.uo.getStartX();
            this.uo.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i4 = scrollX;
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            d(false);
            b();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i7 = clientWidth / 2;
        float f = clientWidth;
        float f2 = i7;
        float fD = f2 + (d(Math.min(1.0f, (Math.abs(i5) * 1.0f) / f)) * f2);
        int iAbs2 = Math.abs(i3);
        if (iAbs2 > 0) {
            iAbs = Math.round(Math.abs(fD / iAbs2) * 1000.0f) * 4;
        } else {
            iAbs = (int) (((Math.abs(i5) / ((f * this.b.d(this.c)) + this.cb)) + 1.0f) * 100.0f);
        }
        int iMin = Math.min(iAbs, 600);
        this.k = false;
        this.uo.startScroll(i4, scrollY, i5, i6, iMin);
        postInvalidateOnAnimation();
    }

    hc d(int i, int i2) {
        hc hcVar = new hc();
        hcVar.hc = i;
        hcVar.d = this.b.d((ViewGroup) this, i);
        hcVar.c = this.b.d(i);
        if (i2 < 0 || i2 >= this.h.size()) {
            this.h.add(hcVar);
        } else {
            this.h.add(i2, hcVar);
        }
        return hcVar;
    }

    void hc() throws Resources.NotFoundException {
        int iD = this.b.d();
        this.d = iD;
        boolean z = this.h.size() < (this.vv * 2) + 1 && this.h.size() < iD;
        int iMax = this.c;
        int i = 0;
        while (i < this.h.size()) {
            hc hcVar = this.h.get(i);
            int iD2 = this.b.d(hcVar.d);
            if (iD2 != -1) {
                if (iD2 == -2) {
                    this.h.remove(i);
                    i--;
                    this.b.d((ViewGroup) this, hcVar.hc, hcVar.d);
                    if (this.c == hcVar.hc) {
                        iMax = Math.max(0, Math.min(this.c, iD - 1));
                    }
                } else if (hcVar.hc != iD2) {
                    if (hcVar.hc == this.c) {
                        iMax = iD2;
                    }
                    hcVar.hc = iD2;
                }
                z = true;
            }
            i++;
        }
        Collections.sort(this.h, u);
        if (z) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                b bVar = (b) getChildAt(i2).getLayoutParams();
                if (!bVar.d) {
                    bVar.b = 0.0f;
                }
            }
            d(iMax, false, true);
            requestLayout();
        }
    }

    void b() throws Resources.NotFoundException {
        d(this.c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0065, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f5 A[PHI: r7 r10 r15
  0x00f5: PHI (r7v6 int) = (r7v5 int), (r7v4 int), (r7v9 int) binds: [B:62:0x00ea, B:59:0x00d4, B:53:0x00be] A[DONT_GENERATE, DONT_INLINE]
  0x00f5: PHI (r10v9 int) = (r10v1 int), (r10v8 int), (r10v12 int) binds: [B:62:0x00ea, B:59:0x00d4, B:53:0x00be] A[DONT_GENERATE, DONT_INLINE]
  0x00f5: PHI (r15v7 float) = (r15v5 float), (r15v6 float), (r15v4 float) binds: [B:62:0x00ea, B:59:0x00d4, B:53:0x00be] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void d(int r18) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 602
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.viewpager.ViewPager.d(int):void");
    }

    private void h() {
        if (this.nr != 0) {
            ArrayList<View> arrayList = this.i;
            if (arrayList == null) {
                this.i = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.i.add(getChildAt(i));
            }
            Collections.sort(this.i, ey);
        }
    }

    private void d(hc hcVar, int i, hc hcVar2) {
        hc hcVar3;
        hc hcVar4;
        int iD = this.b.d();
        int clientWidth = getClientWidth();
        float f = clientWidth > 0 ? this.cb / clientWidth : 0.0f;
        if (hcVar2 != null) {
            int i2 = hcVar2.hc;
            if (i2 < hcVar.hc) {
                float fD = hcVar2.u + hcVar2.c + f;
                int i3 = i2 + 1;
                int i4 = 0;
                while (i3 <= hcVar.hc && i4 < this.h.size()) {
                    hc hcVar5 = this.h.get(i4);
                    while (true) {
                        hcVar4 = hcVar5;
                        if (i3 <= hcVar4.hc || i4 >= this.h.size() - 1) {
                            break;
                        }
                        i4++;
                        hcVar5 = this.h.get(i4);
                    }
                    while (i3 < hcVar4.hc) {
                        fD += this.b.d(i3) + f;
                        i3++;
                    }
                    hcVar4.u = fD;
                    fD += hcVar4.c + f;
                    i3++;
                }
            } else if (i2 > hcVar.hc) {
                int size = this.h.size() - 1;
                float fD2 = hcVar2.u;
                while (true) {
                    i2--;
                    if (i2 < hcVar.hc || size < 0) {
                        break;
                    }
                    hc hcVar6 = this.h.get(size);
                    while (true) {
                        hcVar3 = hcVar6;
                        if (i2 >= hcVar3.hc || size <= 0) {
                            break;
                        }
                        size--;
                        hcVar6 = this.h.get(size);
                    }
                    while (i2 > hcVar3.hc) {
                        fD2 -= this.b.d(i2) + f;
                        i2--;
                    }
                    fD2 -= hcVar3.c + f;
                    hcVar3.u = fD2;
                }
            }
        }
        int size2 = this.h.size();
        float fD3 = hcVar.u;
        int i5 = hcVar.hc - 1;
        this.jh = hcVar.hc == 0 ? hcVar.u : -3.4028235E38f;
        int i6 = iD - 1;
        this.sy = hcVar.hc == i6 ? (hcVar.u + hcVar.c) - 1.0f : Float.MAX_VALUE;
        int i7 = i - 1;
        while (i7 >= 0) {
            hc hcVar7 = this.h.get(i7);
            while (i5 > hcVar7.hc) {
                fD3 -= this.b.d(i5) + f;
                i5--;
            }
            fD3 -= hcVar7.c + f;
            hcVar7.u = fD3;
            if (hcVar7.hc == 0) {
                this.jh = fD3;
            }
            i7--;
            i5--;
        }
        float fD4 = hcVar.u + hcVar.c + f;
        int i8 = hcVar.hc + 1;
        int i9 = i + 1;
        while (i9 < size2) {
            hc hcVar8 = this.h.get(i9);
            while (i8 < hcVar8.hc) {
                fD4 += this.b.d(i8) + f;
                i8++;
            }
            if (hcVar8.hc == i6) {
                this.sy = (hcVar8.c + fD4) - 1.0f;
            }
            hcVar8.u = fD4;
            fD4 += hcVar8.c + f;
            i9++;
            i8++;
        }
        this.l = false;
    }

    public static class h extends com.bytedance.adsdk.ugeno.viewpager.d {
        public static final Parcelable.Creator<h> CREATOR = new Parcelable.ClassLoaderCreator<h>() { // from class: com.bytedance.adsdk.ugeno.viewpager.ViewPager.h.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public h[] newArray(int i) {
                return new h[i];
            }
        };
        Parcelable b;
        ClassLoader c;
        int hc;

        public h(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // com.bytedance.adsdk.ugeno.viewpager.d, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.hc);
            parcel.writeParcelable(this.b, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.hc + i.d;
        }

        h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.hc = parcel.readInt();
            this.b = parcel.readParcelable(classLoader);
            this.c = classLoader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        h hVar = new h(super.onSaveInstanceState());
        hVar.hc = this.c;
        com.bytedance.adsdk.ugeno.viewpager.hc hcVar = this.b;
        if (hcVar != null) {
            hVar.b = hcVar.hc();
        }
        return hVar;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) throws Resources.NotFoundException {
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.d());
        if (this.b != null) {
            d(hVar.hc, false, true);
            return;
        }
        this.tc = hVar.hc;
        this.mk = hVar.b;
        this.mq = hVar.c;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        b bVar = (b) layoutParams;
        bVar.d |= b(view);
        if (this.np) {
            if (bVar != null && bVar.d) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            bVar.c = true;
            addViewInLayout(view, i, layoutParams);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    private static boolean b(View view) {
        return view.getClass().getAnnotation(d.class) != null;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.np) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    hc d(View view) {
        for (int i = 0; i < this.h.size(); i++) {
            hc hcVar = this.h.get(i);
            if (this.b.d(view, hcVar.d)) {
                return hcVar;
            }
        }
        return null;
    }

    hc hc(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return d(view);
            }
        }
    }

    hc hc(int i) {
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            hc hcVar = this.h.get(i2);
            if (hcVar.hc == i) {
                return hcVar;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.yn = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) throws Resources.NotFoundException {
        b bVar;
        b bVar2;
        int i3;
        int i4;
        int i5;
        boolean z = false;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.us = Math.min(measuredWidth / 10, this.s);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            boolean z2 = true;
            int i7 = 1073741824;
            if (i6 >= childCount) {
                break;
            }
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8 && (bVar2 = (b) childAt.getLayoutParams()) != null && bVar2.d) {
                int i8 = bVar2.hc & 7;
                int i9 = bVar2.hc & 112;
                boolean z3 = (i9 == 48 || i9 == 80) ? true : z;
                if (i8 != 3 && i8 != 5) {
                    z2 = z;
                }
                int i10 = Integer.MIN_VALUE;
                if (z3) {
                    i3 = Integer.MIN_VALUE;
                    i10 = 1073741824;
                } else {
                    i3 = z2 ? 1073741824 : Integer.MIN_VALUE;
                }
                if (bVar2.width != -2) {
                    i4 = bVar2.width != -1 ? bVar2.width : paddingLeft;
                    i10 = 1073741824;
                } else {
                    i4 = paddingLeft;
                }
                if (bVar2.height != -2) {
                    i5 = bVar2.height != -1 ? bVar2.height : measuredHeight;
                } else {
                    i5 = measuredHeight;
                    i7 = i3;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i10), View.MeasureSpec.makeMeasureSpec(i5, i7));
                if (z3) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z2) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i6++;
            z = false;
        }
        this.de = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.v = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.np = true;
        b();
        this.np = false;
        int childCount2 = getChildCount();
        for (int i11 = 0; i11 < childCount2; i11++) {
            View childAt2 = getChildAt(i11);
            if (childAt2.getVisibility() != 8 && ((bVar = (b) childAt2.getLayoutParams()) == null || !bVar.d)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * bVar.b), 1073741824), this.v);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i5 = this.cb;
            d(i, i3, i5, i5);
        }
    }

    private void d(int i, int i2, int i3, int i4) {
        if (i2 > 0 && !this.h.isEmpty()) {
            if (!this.uo.isFinished()) {
                this.uo.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)) * (((i - getPaddingLeft()) - getPaddingRight()) + i3)), getScrollY());
                return;
            }
        }
        hc hcVarHc = hc(this.c);
        int iMin = (int) ((hcVarHc != null ? Math.min(hcVarHc.u, this.sy) : 0.0f) * ((i - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            d(false);
            scrollTo(iMin, getScrollY());
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
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.viewpager.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void computeScroll() {
        this.k = true;
        if (!this.uo.isFinished() && this.uo.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.uo.getCurrX();
            int currY = this.uo.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!c(currX)) {
                    this.uo.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            postInvalidateOnAnimation();
            return;
        }
        d(true);
    }

    private boolean c(int i) {
        if (this.h.size() == 0) {
            if (this.yn) {
                return false;
            }
            this.fu = false;
            d(0, 0.0f, 0);
            if (this.fu) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        hc hcVarTt = tt();
        int clientWidth = getClientWidth();
        int i2 = this.cb;
        int i3 = clientWidth + i2;
        float f = clientWidth;
        int i4 = hcVarTt.hc;
        float f2 = ((i / f) - hcVarTt.u) / (hcVarTt.c + (i2 / f));
        this.fu = false;
        d(i4, f2, (int) (i3 * f2));
        if (this.fu) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void d(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.xp
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L6a
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r1
        L1b:
            if (r7 >= r6) goto L6a
            android.view.View r8 = r12.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            com.bytedance.adsdk.ugeno.viewpager.ViewPager$b r9 = (com.bytedance.adsdk.ugeno.viewpager.ViewPager.b) r9
            boolean r10 = r9.d
            if (r10 == 0) goto L67
            int r9 = r9.hc
            r9 = r9 & 7
            if (r9 == r2) goto L4c
            r10 = 3
            if (r9 == r10) goto L46
            r10 = 5
            if (r9 == r10) goto L39
            r9 = r3
            goto L5b
        L39:
            int r9 = r5 - r4
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r4 = r4 + r10
            goto L58
        L46:
            int r9 = r8.getWidth()
            int r9 = r9 + r3
            goto L5b
        L4c:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r3)
        L58:
            r11 = r9
            r9 = r3
            r3 = r11
        L5b:
            int r3 = r3 + r0
            int r10 = r8.getLeft()
            int r3 = r3 - r10
            if (r3 == 0) goto L66
            r8.offsetLeftAndRight(r3)
        L66:
            r3 = r9
        L67:
            int r7 = r7 + 1
            goto L1b
        L6a:
            r12.hc(r13, r14, r15)
            com.bytedance.adsdk.ugeno.viewpager.ViewPager$u r13 = r12.nw
            if (r13 == 0) goto L9d
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L79:
            if (r1 >= r14) goto L9d
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            com.bytedance.adsdk.ugeno.viewpager.ViewPager$b r0 = (com.bytedance.adsdk.ugeno.viewpager.ViewPager.b) r0
            boolean r0 = r0.d
            if (r0 != 0) goto L9a
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            com.bytedance.adsdk.ugeno.viewpager.ViewPager$u r3 = r12.nw
            r3.d(r15, r0)
        L9a:
            int r1 = r1 + 1
            goto L79
        L9d:
            r12.fu = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.viewpager.ViewPager.d(int, float, int):void");
    }

    private void hc(int i, float f, int i2) {
        c cVar = this.ra;
        if (cVar != null) {
            cVar.d(i, f, i2);
        }
        List<c> list = this.to;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                c cVar2 = this.to.get(i3);
                if (cVar2 != null) {
                    cVar2.d(i, f, i2);
                }
            }
        }
        c cVar3 = this.rw;
        if (cVar3 != null) {
            cVar3.d(i, f, i2);
        }
    }

    private void u(int i) {
        c cVar = this.ra;
        if (cVar != null) {
            cVar.gb(i);
        }
        List<c> list = this.to;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                c cVar2 = this.to.get(i2);
                if (cVar2 != null) {
                    cVar2.gb(i);
                }
            }
        }
        c cVar3 = this.rw;
        if (cVar3 != null) {
            cVar3.gb(i);
        }
    }

    private void an(int i) {
        c cVar = this.ra;
        if (cVar != null) {
            cVar.tt(i);
        }
        List<c> list = this.to;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                c cVar2 = this.to.get(i2);
                if (cVar2 != null) {
                    cVar2.tt(i);
                }
            }
        }
        c cVar3 = this.rw;
        if (cVar3 != null) {
            cVar3.tt(i);
        }
    }

    private void d(boolean z) {
        boolean z2 = this.ar == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.uo.isFinished()) {
                this.uo.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.uo.getCurrX();
                int currY = this.uo.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        c(currX);
                    }
                }
            }
        }
        this.he = false;
        for (int i = 0; i < this.h.size(); i++) {
            hc hcVar = this.h.get(i);
            if (hcVar.b) {
                hcVar.b = false;
                z2 = true;
            }
        }
        if (z2) {
            if (z) {
                postOnAnimation(this.qr);
            } else {
                this.qr.run();
            }
        }
    }

    private boolean d(float f, float f2) {
        if (f >= this.us || f2 <= 0.0f) {
            return f > ((float) (getWidth() - this.us)) && f2 < 0.0f;
        }
        return true;
    }

    private void hc(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setLayerType(z ? this.dz : 0, null);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
        int iFindPointerIndex;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            gb();
            return false;
        }
        if (action != 0) {
            if (this.zw) {
                return true;
            }
            if (this.j) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.mt = x;
            this.fs = x;
            float y = motionEvent.getY();
            this.r = y;
            this.ba = y;
            this.hv = motionEvent.getPointerId(0);
            this.j = false;
            this.k = true;
            this.uo.computeScrollOffset();
            if (this.ar == 2 && Math.abs(this.uo.getFinalX() - this.uo.getCurrX()) > this.y) {
                this.uo.abortAnimation();
                this.he = false;
                b();
                this.zw = true;
                b(true);
                setScrollState(1);
            } else {
                d(false);
                this.zw = false;
            }
        } else if (action == 2) {
            int i = this.hv;
            if (i != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                float x2 = motionEvent.getX(iFindPointerIndex);
                float f = x2 - this.fs;
                float fAbs = Math.abs(f);
                float y2 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y2 - this.r);
                if (f != 0.0f && !d(this.fs, f) && d(this, false, (int) f, (int) x2, (int) y2)) {
                    this.fs = x2;
                    this.ba = y2;
                    this.j = true;
                    return false;
                }
                int i2 = this.z;
                if (fAbs > i2 && fAbs * 0.5f > fAbs2) {
                    this.zw = true;
                    b(true);
                    setScrollState(1);
                    this.fs = f > 0.0f ? this.mt + this.z : this.mt - this.z;
                    this.ba = y2;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > i2) {
                    this.j = true;
                }
                if (this.zw && hc(x2)) {
                    postInvalidateOnAnimation();
                }
            }
        } else if (action == 6) {
            d(motionEvent);
        }
        if (this.bc == null) {
            this.bc = VelocityTracker.obtain();
        }
        this.bc.addMovement(motionEvent);
        return this.zw;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
        com.bytedance.adsdk.ugeno.viewpager.hc hcVar;
        int iFindPointerIndex;
        if (this.wl) {
            return true;
        }
        boolean zGb = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (hcVar = this.b) == null || hcVar.d() == 0) {
            return false;
        }
        if (this.bc == null) {
            this.bc = VelocityTracker.obtain();
        }
        this.bc.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.uo.abortAnimation();
            this.he = false;
            b();
            float x = motionEvent.getX();
            this.mt = x;
            this.fs = x;
            float y = motionEvent.getY();
            this.r = y;
            this.ba = y;
            this.hv = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action != 2) {
                if (action != 3) {
                    if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        if (actionIndex != -1) {
                            this.fs = motionEvent.getX(actionIndex);
                            this.hv = motionEvent.getPointerId(actionIndex);
                        }
                    } else if (action == 6) {
                        d(motionEvent);
                        int iFindPointerIndex2 = motionEvent.findPointerIndex(this.hv);
                        if (iFindPointerIndex2 != -1) {
                            this.fs = motionEvent.getX(iFindPointerIndex2);
                        }
                    }
                } else if (this.zw) {
                    d(this.c, true, 0, false);
                    zGb = gb();
                }
            } else if (!this.zw) {
                int iFindPointerIndex3 = motionEvent.findPointerIndex(this.hv);
                if (iFindPointerIndex3 == -1) {
                    zGb = gb();
                } else {
                    float x2 = motionEvent.getX(iFindPointerIndex3);
                    float fAbs = Math.abs(x2 - this.fs);
                    float y2 = motionEvent.getY(iFindPointerIndex3);
                    float fAbs2 = Math.abs(y2 - this.ba);
                    if (fAbs > this.z && fAbs > fAbs2) {
                        this.zw = true;
                        b(true);
                        float f = this.mt;
                        this.fs = x2 - f > 0.0f ? f + this.z : f - this.z;
                        this.ba = y2;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (this.zw) {
                        zGb = false | hc(motionEvent.getX(iFindPointerIndex));
                    }
                }
            } else if (this.zw && (iFindPointerIndex = motionEvent.findPointerIndex(this.hv)) != -1) {
                zGb = false | hc(motionEvent.getX(iFindPointerIndex));
            }
        } else if (this.zw) {
            VelocityTracker velocityTracker = this.bc;
            velocityTracker.computeCurrentVelocity(1000, this.tr);
            int xVelocity = (int) velocityTracker.getXVelocity(this.hv);
            this.he = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            hc hcVarTt = tt();
            float f2 = clientWidth;
            int i = hcVarTt.hc;
            float f3 = ((scrollX / f2) - hcVarTt.u) / (hcVarTt.c + (this.cb / f2));
            int iFindPointerIndex4 = motionEvent.findPointerIndex(this.hv);
            if (iFindPointerIndex4 != -1) {
                d(d(i, f3, xVelocity, (int) (motionEvent.getX(iFindPointerIndex4) - this.mt)), true, true, xVelocity);
                zGb = gb();
            }
        }
        if (zGb) {
            postInvalidateOnAnimation();
        }
        return true;
    }

    private boolean gb() {
        this.hv = -1;
        tc();
        this.q.onRelease();
        this.ru.onRelease();
        return this.q.isFinished() || this.ru.isFinished();
    }

    private void b(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean hc(float f) {
        boolean z;
        boolean z2;
        float f2 = this.fs - f;
        this.fs = f;
        float scrollX = getScrollX() + f2;
        float clientWidth = getClientWidth();
        float f3 = this.jh * clientWidth;
        float f4 = this.sy * clientWidth;
        boolean z3 = false;
        hc hcVar = this.h.get(0);
        ArrayList<hc> arrayList = this.h;
        hc hcVar2 = arrayList.get(arrayList.size() - 1);
        if (hcVar.hc != 0) {
            f3 = hcVar.u * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (hcVar2.hc != this.b.d() - 1) {
            f4 = hcVar2.u * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f3) {
            if (z) {
                this.q.onPull(Math.abs(f3 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f3;
        } else if (scrollX > f4) {
            if (z2) {
                this.ru.onPull(Math.abs(scrollX - f4) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        }
        int i = (int) scrollX;
        this.fs += scrollX - i;
        scrollTo(i, getScrollY());
        c(i);
        return z3;
    }

    private hc tt() {
        int i;
        int clientWidth = getClientWidth();
        float f = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f2 = clientWidth > 0 ? this.cb / clientWidth : 0.0f;
        hc hcVar = null;
        int i2 = 0;
        int i3 = -1;
        boolean z = true;
        float f3 = 0.0f;
        while (i2 < this.h.size()) {
            hc hcVar2 = this.h.get(i2);
            if (!z && hcVar2.hc != (i = i3 + 1)) {
                hcVar2 = this.gb;
                hcVar2.u = f + f3 + f2;
                hcVar2.hc = i;
                hcVar2.c = this.b.d(hcVar2.hc);
                i2--;
            }
            f = hcVar2.u;
            float f4 = hcVar2.c + f + f2;
            if (!z && scrollX < f) {
                return hcVar;
            }
            if (scrollX < f4 || i2 == this.h.size() - 1) {
                return hcVar2;
            }
            i3 = hcVar2.hc;
            f3 = hcVar2.c;
            i2++;
            z = false;
            hcVar = hcVar2;
        }
        return hcVar;
    }

    private int d(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.nv || Math.abs(i2) <= this.dc) {
            i += (int) (f + (i >= this.c ? 0.4f : 0.6f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.h.size() <= 0) {
            return i;
        }
        return Math.max(this.h.get(0).hc, Math.min(i, this.h.get(r4.size() - 1).hc));
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        com.bytedance.adsdk.ugeno.viewpager.hc hcVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (hcVar = this.b) != null && hcVar.d() > 1)) {
            if (!this.q.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.jh * width);
                this.q.setSize(height, width);
                zDraw = false | this.q.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.ru.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.sy + 1.0f)) * width2);
                this.ru.setSize(height2, width2);
                zDraw |= this.ru.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.q.finish();
            this.ru.finish();
        }
        if (zDraw) {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        float f2;
        float f3;
        super.onDraw(canvas);
        if (this.cb <= 0 || this.w == null || this.h.size() <= 0 || this.b == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f4 = this.cb / width;
        int i = 0;
        hc hcVar = this.h.get(0);
        float f5 = hcVar.u;
        int size = this.h.size();
        int i2 = hcVar.hc;
        int i3 = this.h.get(size - 1).hc;
        while (i2 < i3) {
            while (i2 > hcVar.hc && i < size) {
                i++;
                hcVar = this.h.get(i);
            }
            if (i2 == hcVar.hc) {
                f2 = (hcVar.u + hcVar.c) * width;
                f = hcVar.u + hcVar.c + f4;
            } else {
                float fD = this.b.d(i2);
                float f6 = (f5 + fD) * width;
                f = f5 + fD + f4;
                f2 = f6;
            }
            if (this.cb + f2 > scrollX) {
                f3 = f4;
                this.w.setBounds(Math.round(f2), this.yo, Math.round(this.cb + f2), this.rf);
                this.w.draw(canvas);
            } else {
                f3 = f4;
            }
            if (f2 > scrollX + r2) {
                return;
            }
            i2++;
            f5 = f;
            f4 = f3;
        }
    }

    private void d(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.hv) {
            int i = actionIndex == 0 ? 1 : 0;
            this.fs = motionEvent.getX(i);
            this.hv = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.bc;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void tc() {
        this.zw = false;
        this.j = false;
        VelocityTracker velocityTracker = this.bc;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.bc = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.yi != z) {
            this.yi = z;
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.b == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i < 0 ? scrollX > ((int) (((float) clientWidth) * this.jh)) : i > 0 && scrollX < ((int) (((float) clientWidth) * this.sy));
    }

    protected boolean d(View view, boolean z, int i, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && d(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || d(keyEvent);
    }

    public boolean d(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                if (keyEvent.hasModifiers(2)) {
                    return c();
                }
                return b(17);
            }
            if (keyCode == 22) {
                if (keyEvent.hasModifiers(2)) {
                    return u();
                }
                return b(66);
            }
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return b(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return b(1);
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(int r8) throws android.content.res.Resources.NotFoundException {
        /*
            r7 = this;
            android.view.View r0 = r7.findFocus()
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != r7) goto Lb
        L9:
            r0 = r3
            goto L68
        Lb:
            if (r0 == 0) goto L68
            android.view.ViewParent r4 = r0.getParent()
        L11:
            boolean r5 = r4 instanceof android.view.ViewGroup
            if (r5 == 0) goto L1e
            if (r4 != r7) goto L19
            r4 = r1
            goto L1f
        L19:
            android.view.ViewParent r4 = r4.getParent()
            goto L11
        L1e:
            r4 = r2
        L1f:
            if (r4 != 0) goto L68
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
        L35:
            boolean r5 = r0 instanceof android.view.ViewGroup
            if (r5 == 0) goto L4f
            java.lang.String r5 = " => "
            java.lang.StringBuilder r5 = r4.append(r5)
            java.lang.Class r6 = r0.getClass()
            java.lang.String r6 = r6.getSimpleName()
            r5.append(r6)
            android.view.ViewParent r0 = r0.getParent()
            goto L35
        L4f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r5 = "arrowScroll tried to find focus based on non-child current focused view "
            r0.<init>(r5)
            java.lang.String r4 = r4.toString()
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = "ViewPager"
            com.bytedance.sdk.component.utils.mq.c(r4, r0)
            goto L9
        L68:
            android.view.FocusFinder r3 = android.view.FocusFinder.getInstance()
            android.view.View r3 = r3.findNextFocus(r7, r0, r8)
            r4 = 66
            r5 = 17
            if (r3 == 0) goto Lb3
            if (r3 == r0) goto Lb3
            if (r8 != r5) goto L98
            android.graphics.Rect r1 = r7.tt
            android.graphics.Rect r1 = r7.d(r1, r3)
            int r1 = r1.left
            android.graphics.Rect r2 = r7.tt
            android.graphics.Rect r2 = r7.d(r2, r0)
            int r2 = r2.left
            if (r0 == 0) goto L93
            if (r1 < r2) goto L93
            boolean r2 = r7.c()
            goto Lc6
        L93:
            boolean r2 = r3.requestFocus()
            goto Lc6
        L98:
            if (r8 != r4) goto Lc6
            android.graphics.Rect r1 = r7.tt
            android.graphics.Rect r1 = r7.d(r1, r3)
            int r1 = r1.left
            android.graphics.Rect r2 = r7.tt
            android.graphics.Rect r2 = r7.d(r2, r0)
            int r2 = r2.left
            if (r0 == 0) goto Lae
            if (r1 <= r2) goto Lbd
        Lae:
            boolean r2 = r3.requestFocus()
            goto Lc6
        Lb3:
            if (r8 == r5) goto Lc2
            if (r8 != r1) goto Lb8
            goto Lc2
        Lb8:
            if (r8 == r4) goto Lbd
            r0 = 2
            if (r8 != r0) goto Lc6
        Lbd:
            boolean r2 = r7.u()
            goto Lc6
        Lc2:
            boolean r2 = r7.c()
        Lc6:
            if (r2 == 0) goto Lcf
            int r8 = android.view.SoundEffectConstants.getContantForFocusDirection(r8)
            r7.playSoundEffect(r8)
        Lcf:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.viewpager.ViewPager.b(int):boolean");
    }

    private Rect d(Rect rect, View view) {
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

    boolean c() throws Resources.NotFoundException {
        int i = this.c;
        if (i <= 0) {
            return false;
        }
        d(i - 1, true);
        return true;
    }

    boolean u() throws Resources.NotFoundException {
        com.bytedance.adsdk.ugeno.viewpager.hc hcVar = this.b;
        if (hcVar == null || this.c >= hcVar.d() - 1) {
            return false;
        }
        d(this.c + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        hc hcVarD;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (hcVarD = d(childAt)) != null && hcVarD.hc == this.c) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i2 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        hc hcVarD;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (hcVarD = d(childAt)) != null && hcVarD.hc == this.c) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        hc hcVarD;
        int childCount = getChildCount();
        int i4 = -1;
        if ((i & 2) != 0) {
            i4 = childCount;
            i2 = 0;
            i3 = 1;
        } else {
            i2 = childCount - 1;
            i3 = -1;
        }
        while (i2 != i4) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (hcVarD = d(childAt)) != null && hcVarD.hc == this.c && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i3;
        }
        return false;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        hc hcVarD;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (hcVarD = d(childAt)) != null && hcVarD.hc == this.c && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new b();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof b) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    private class an extends DataSetObserver {
        an() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() throws Resources.NotFoundException {
            ViewPager.this.hc();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() throws Resources.NotFoundException {
            ViewPager.this.hc();
        }
    }

    public static class b extends ViewGroup.LayoutParams {
        int an;
        float b;
        boolean c;
        public boolean d;
        public int hc;
        int u;

        public b() {
            super(-1, -1);
            this.b = 0.0f;
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.hc);
            this.hc = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    static class gb implements Comparator<View> {
        gb() {
        }

        @Override // java.util.Comparator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            b bVar = (b) view.getLayoutParams();
            b bVar2 = (b) view2.getLayoutParams();
            if (bVar.d != bVar2.d) {
                return bVar.d ? 1 : -1;
            }
            return bVar.u - bVar2.u;
        }
    }
}

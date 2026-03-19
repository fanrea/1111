package com.tk.component.scroll.b.b;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.e.a.b;
import android.support.v4.e.o;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ak;
import android.support.v7.widget.al;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.badge.BadgeDrawable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class h extends ViewGroup {
    static boolean Wu = true;
    private LinearLayoutManager FE;
    private al.c WA;
    private int WB;
    private Parcelable WC;
    private ak WD;
    private com.tk.component.scroll.b.b.b WE;
    private com.tk.component.scroll.b.b.d WF;
    private com.tk.component.scroll.b.b.f WG;
    private al.f WH;
    private boolean WI;
    private boolean WJ;
    private int WK;
    a WL;
    com.tk.component.scroll.b.b.g We;
    private final Rect Wv;
    private final Rect Ww;
    private com.tk.component.scroll.b.b.b Wx;
    int Wy;
    boolean Wz;
    al pD;

    public static abstract class e {
        public void a(int i, float f, int i2) {
        }

        public void di(int i) {
        }

        public void dj(int i) {
        }
    }

    public interface g {
        void c(View view, float f);
    }

    public h(Context context) {
        super(context);
        this.Wv = new Rect();
        this.Ww = new Rect();
        this.Wx = new com.tk.component.scroll.b.b.b(3);
        this.Wz = false;
        this.WA = new c() { // from class: com.tk.component.scroll.b.b.h.1
            @Override // com.tk.component.scroll.b.b.h.c, android.support.v7.widget.al.c
            public final void onChanged() {
                h hVar = h.this;
                hVar.Wz = true;
                hVar.We.ol();
            }
        };
        this.WB = -1;
        this.WH = null;
        this.WI = false;
        this.WJ = true;
        this.WK = -1;
        b(context, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v18, types: [android.support.v7.widget.al, android.view.View] */
    /* JADX WARN: Type inference failed for: r3v8, types: [android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.al$i] */
    private void b(Context context, AttributeSet attributeSet) {
        this.WL = Wu ? new f() : new b();
        this.pD = new i(context);
        this.pD.setId(View.generateViewId());
        this.pD.setDescendantFocusability(131072);
        this.FE = new d(context);
        this.pD.setLayoutManager(this.FE);
        this.pD.setScrollingTouchSlop(1);
        os();
        this.pD.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.pD.a(or());
        this.We = new com.tk.component.scroll.b.b.g(this);
        this.WF = new com.tk.component.scroll.b.b.d(this, this.We, this.pD);
        this.WD = new C0815h();
        this.WD.a(this.pD);
        this.pD.a(this.We);
        this.WE = new com.tk.component.scroll.b.b.b(3);
        this.We.b(this.WE);
        e eVar = new e() { // from class: com.tk.component.scroll.b.b.h.2
            @Override // com.tk.component.scroll.b.b.h.e
            public final void di(int i2) {
                if (h.this.Wy != i2) {
                    h.this.Wy = i2;
                }
            }

            @Override // com.tk.component.scroll.b.b.h.e
            public final void dj(int i2) {
                if (i2 == 0) {
                    h.this.ou();
                }
            }
        };
        e eVar2 = new e() { // from class: com.tk.component.scroll.b.b.h.3
            @Override // com.tk.component.scroll.b.b.h.e
            public final void di(int i2) {
                h.this.clearFocus();
                if (h.this.hasFocus()) {
                    h.this.pD.requestFocus(2);
                }
            }
        };
        this.WE.a(eVar);
        this.WE.a(eVar2);
        this.WL.s(this.pD);
        this.WE.a(this.Wx);
        this.WG = new com.tk.component.scroll.b.b.f(this.FE);
        this.WE.a(this.WG);
        ?? r2 = this.pD;
        attachViewToParent(r2, 0, r2.getLayoutParams());
    }

    private al.k or() {
        return new al.k() { // from class: com.tk.component.scroll.b.b.h.4
            @Override // android.support.v7.widget.al.k
            public final void ar(View view) {
                al.j jVar = (al.j) view.getLayoutParams();
                if (jVar.width != -1 || jVar.height != -1) {
                    throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
                }
            }
        };
    }

    @Override // android.view.ViewGroup, android.view.View
    public final CharSequence getAccessibilityClassName() {
        if (this.WL.oz()) {
            return this.WL.oA();
        }
        return super.getAccessibilityClassName();
    }

    private void os() {
        setOrientation(0);
    }

    @Override // android.view.View
    protected final Parcelable onSaveInstanceState() {
        j jVar = new j(super.onSaveInstanceState());
        jVar.WP = this.pD.getId();
        int i2 = this.WB;
        if (i2 == -1) {
            i2 = this.Wy;
        }
        jVar.Wy = i2;
        Parcelable parcelable = this.WC;
        if (parcelable != null) {
            jVar.WQ = parcelable;
        } else {
            Object adapter = this.pD.getAdapter();
            if (adapter instanceof com.tk.component.scroll.b.a.a) {
                jVar.WQ = ((com.tk.component.scroll.b.a.a) adapter).oa();
            }
        }
        return jVar;
    }

    @Override // android.view.View
    protected final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof j)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        j jVar = (j) parcelable;
        super.onRestoreInstanceState(jVar.getSuperState());
        this.WB = jVar.Wy;
        this.WC = jVar.WQ;
    }

    private void ot() {
        al.a adapter;
        if (this.WB == -1 || (adapter = getAdapter()) == null) {
            return;
        }
        if (this.WC != null) {
            this.WC = null;
        }
        this.Wy = Math.max(0, Math.min(this.WB, adapter.getItemCount() - 1));
        this.WB = -1;
        this.pD.ar(this.Wy);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof j) {
            int i2 = ((j) parcelable).WP;
            sparseArray.put(this.pD.getId(), sparseArray.get(i2));
            sparseArray.remove(i2);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        ot();
    }

    static class j extends View.BaseSavedState {
        public static final Parcelable.Creator<j> CREATOR = new Parcelable.ClassLoaderCreator<j>() { // from class: com.tk.component.scroll.b.b.h.j.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final /* synthetic */ j createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return f(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Object[] newArray(int i) {
                return dq(i);
            }

            private static j f(Parcel parcel, ClassLoader classLoader) {
                return Build.VERSION.SDK_INT >= 24 ? new j(parcel, classLoader) : new j(parcel);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // android.os.Parcelable.Creator
            /* renamed from: k, reason: merged with bridge method [inline-methods] */
            public j createFromParcel(Parcel parcel) {
                return f(parcel, null);
            }

            private static j[] dq(int i) {
                return new j[i];
            }
        };
        int WP;
        Parcelable WQ;
        int Wy;

        j(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            e(parcel, classLoader);
        }

        j(Parcel parcel) {
            super(parcel);
            e(parcel, null);
        }

        j(Parcelable parcelable) {
            super(parcelable);
        }

        private void e(Parcel parcel, ClassLoader classLoader) {
            this.WP = parcel.readInt();
            this.Wy = parcel.readInt();
            this.WQ = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.WP);
            parcel.writeInt(this.Wy);
            parcel.writeParcelable(this.WQ, i);
        }
    }

    public final void setAdapter(al.a aVar) {
        al.a adapter = this.pD.getAdapter();
        this.WL.e(adapter);
        c((al.a<?>) adapter);
        this.pD.setAdapter(aVar);
        this.Wy = 0;
        ot();
        this.WL.d((al.a<?>) aVar);
        b(aVar);
    }

    private void b(al.a<?> aVar) {
        if (aVar != null) {
            aVar.a(this.WA);
        }
    }

    private void c(al.a<?> aVar) {
        if (aVar != null) {
            aVar.b(this.WA);
        }
    }

    public final al.a getAdapter() {
        return this.pD.getAdapter();
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        throw new IllegalStateException(getClass().getSimpleName() + " does not support direct child views");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.support.v7.widget.al, android.view.View] */
    @Override // android.view.View
    protected final void onMeasure(int i2, int i3) {
        measureChild(this.pD, i2, i3);
        int measuredWidth = this.pD.getMeasuredWidth();
        int measuredHeight = this.pD.getMeasuredHeight();
        int measuredState = this.pD.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i2, measuredState), resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i3, measuredState << 16));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth = this.pD.getMeasuredWidth();
        int measuredHeight = this.pD.getMeasuredHeight();
        this.Wv.left = getPaddingLeft();
        this.Wv.right = (i4 - i2) - getPaddingRight();
        this.Wv.top = getPaddingTop();
        this.Wv.bottom = (i5 - i3) - getPaddingBottom();
        Gravity.apply(BadgeDrawable.TOP_START, measuredWidth, measuredHeight, this.Wv, this.Ww);
        this.pD.layout(this.Ww.left, this.Ww.top, this.Ww.right, this.Ww.bottom);
        if (this.Wz) {
            ou();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.al$i] */
    final void ou() {
        ak akVar = this.WD;
        if (akVar == 0) {
            throw new IllegalStateException("Design assumption violated.");
        }
        View viewA = akVar.a((al.i) this.FE);
        if (viewA == null) {
            return;
        }
        int iAe = LinearLayoutManager.ae(viewA);
        if (iAe != this.Wy && getScrollState() == 0) {
            this.WE.di(iAe);
        }
        this.Wz = false;
    }

    final int getPageSize() {
        int height;
        int paddingBottom;
        al alVar = this.pD;
        if (getOrientation() == 0) {
            height = alVar.getWidth() - alVar.getPaddingLeft();
            paddingBottom = alVar.getPaddingRight();
        } else {
            height = alVar.getHeight() - alVar.getPaddingTop();
            paddingBottom = alVar.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public final void setOrientation(int i2) {
        this.FE.setOrientation(i2);
    }

    public final int getOrientation() {
        return this.FE.getOrientation();
    }

    final boolean ov() {
        return this.FE.getLayoutDirection() == 1;
    }

    public final void setCurrentItem(int i2) {
        h(i2, true);
    }

    public final void h(int i2, boolean z) {
        if (oe()) {
            throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        }
        i(i2, z);
    }

    final void i(int i2, boolean z) {
        al.a adapter = getAdapter();
        if (adapter == null) {
            if (this.WB != -1) {
                this.WB = Math.max(i2, 0);
                return;
            }
            return;
        }
        if (adapter.getItemCount() <= 0) {
            return;
        }
        int iMin = Math.min(Math.max(i2, 0), adapter.getItemCount() - 1);
        if (iMin == this.Wy && this.We.isIdle()) {
            return;
        }
        if (iMin == this.Wy && z) {
            return;
        }
        double dOq = this.Wy;
        this.Wy = iMin;
        if (!this.We.isIdle()) {
            dOq = this.We.oq();
        }
        this.We.g(iMin, z);
        if (!z) {
            this.pD.ar(iMin);
            return;
        }
        double d2 = iMin;
        Double.isNaN(d2);
        if (Math.abs(d2 - dOq) > 3.0d) {
            this.pD.ar(d2 > dOq ? iMin - 3 : iMin + 3);
            al alVar = this.pD;
            alVar.post(new k(iMin, alVar));
            return;
        }
        this.pD.smoothScrollToPosition(iMin);
    }

    public final int getCurrentItem() {
        return this.Wy;
    }

    public final int getScrollState() {
        return this.We.getScrollState();
    }

    public final boolean of() {
        return this.WF.of();
    }

    public final boolean s(float f2) {
        return this.WF.s(f2);
    }

    public final boolean og() {
        return this.WF.og();
    }

    public final boolean oe() {
        return this.WF.oe();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.al$i] */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.al$i] */
    final void ow() {
        View viewA = this.WD.a((al.i) this.FE);
        if (viewA == null) {
            return;
        }
        int[] iArrA = this.WD.a((al.i) this.FE, viewA);
        if (iArrA[0] == 0 && iArrA[1] == 0) {
            return;
        }
        this.pD.smoothScrollBy(iArrA[0], iArrA[1]);
    }

    public final void setUserInputEnabled(boolean z) {
        this.WJ = z;
        this.WL.oB();
    }

    public final boolean ox() {
        return this.WJ;
    }

    public final void setOffscreenPageLimit(int i2) {
        if (i2 <= 0 && i2 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.WK = i2;
        this.pD.requestLayout();
    }

    public final int getOffscreenPageLimit() {
        return this.WK;
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i2) {
        return this.pD.canScrollHorizontally(i2);
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int i2) {
        return this.pD.canScrollVertically(i2);
    }

    public final void c(e eVar) {
        this.Wx.a(eVar);
    }

    public final void setPageTransformer(g gVar) {
        if (gVar != null) {
            if (!this.WI) {
                this.WH = this.pD.getItemAnimator();
                this.WI = true;
            }
            this.pD.setItemAnimator(null);
        } else if (this.WI) {
            this.pD.setItemAnimator(this.WH);
            this.WH = null;
            this.WI = false;
        }
        if (gVar == this.WG.oi()) {
            return;
        }
        this.WG.setPageTransformer(gVar);
        oy();
    }

    public final void oy() {
        if (this.WG.oi() == null) {
            return;
        }
        double dOq = this.We.oq();
        int i2 = (int) dOq;
        double d2 = i2;
        Double.isNaN(d2);
        float f2 = (float) (dOq - d2);
        this.WG.a(i2, f2, Math.round(getPageSize() * f2));
    }

    @Override // android.view.View
    public final void setLayoutDirection(int i2) {
        super.setLayoutDirection(i2);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.WL.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
    }

    @Override // android.view.View
    public final boolean performAccessibilityAction(int i2, Bundle bundle) {
        if (this.WL.dm(i2)) {
            return this.WL.a(i2, bundle);
        }
        return super.performAccessibilityAction(i2, bundle);
    }

    class i extends al {
        i(Context context) {
            super(context);
        }

        public final CharSequence getAccessibilityClassName() {
            if (h.this.WL.oC()) {
                return h.this.WL.oD();
            }
            return super.getAccessibilityClassName();
        }

        public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(h.this.Wy);
            accessibilityEvent.setToIndex(h.this.Wy);
            h.this.WL.d(accessibilityEvent);
        }

        public final boolean onTouchEvent(MotionEvent motionEvent) {
            return h.this.ox() && super.onTouchEvent(motionEvent);
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return h.this.ox() && super.onInterceptTouchEvent(motionEvent);
        }
    }

    class d extends LinearLayoutManager {
        public final boolean a(al alVar, View view, Rect rect, boolean z, boolean z2) {
            return false;
        }

        d(Context context) {
            super(context);
        }

        public final boolean a(al.p pVar, al.u uVar, int i, Bundle bundle) {
            if (h.this.WL.dn(i)) {
                return h.this.WL.mo1514do(i);
            }
            return super.a(pVar, uVar, i, bundle);
        }

        public final void a(al.p pVar, al.u uVar, android.support.v4.e.a.b bVar) {
            super.a(pVar, uVar, bVar);
            h.this.WL.b(bVar);
        }
    }

    /* renamed from: com.tk.component.scroll.b.b.h$h, reason: collision with other inner class name */
    class C0815h extends ak {
        C0815h() {
        }

        public final View a(al.i iVar) {
            if (h.this.oe()) {
                return null;
            }
            return super.a(iVar);
        }
    }

    static class k implements Runnable {
        private final al pD;
        private final int rk;

        k(int i, al alVar) {
            this.rk = i;
            this.pD = alVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.pD.smoothScrollToPosition(this.rk);
        }
    }

    public final int getItemDecorationCount() {
        return this.pD.getItemDecorationCount();
    }

    abstract class a {
        void b(android.support.v4.e.a.b bVar) {
        }

        void d(al.a<?> aVar) {
        }

        void d(AccessibilityEvent accessibilityEvent) {
        }

        boolean dm(int i) {
            return false;
        }

        boolean dn(int i) {
            return false;
        }

        void e(al.a<?> aVar) {
        }

        void oB() {
        }

        boolean oC() {
            return false;
        }

        void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        boolean oz() {
            return false;
        }

        void s(al alVar) {
        }

        private a() {
        }

        /* synthetic */ a(h hVar, byte b) {
            this();
        }

        String oA() {
            throw new IllegalStateException("Not implemented.");
        }

        boolean a(int i, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        /* renamed from: do, reason: not valid java name */
        boolean mo1514do(int i) {
            throw new IllegalStateException("Not implemented.");
        }

        CharSequence oD() {
            throw new IllegalStateException("Not implemented.");
        }
    }

    class b extends a {
        @Override // com.tk.component.scroll.b.b.h.a
        public final boolean oC() {
            return true;
        }

        b() {
            super(h.this, (byte) 0);
        }

        @Override // com.tk.component.scroll.b.b.h.a
        public final boolean dn(int i) {
            return (i == 8192 || i == 4096) && !h.this.ox();
        }

        @Override // com.tk.component.scroll.b.b.h.a
        /* renamed from: do */
        public final boolean mo1514do(int i) {
            if (dn(i)) {
                return false;
            }
            throw new IllegalStateException();
        }

        @Override // com.tk.component.scroll.b.b.h.a
        public final void b(android.support.v4.e.a.b bVar) {
            if (h.this.ox()) {
                return;
            }
            bVar.a(b.a.cQ);
            bVar.a(b.a.cP);
            bVar.setScrollable(false);
        }

        @Override // com.tk.component.scroll.b.b.h.a
        public final CharSequence oD() {
            if (oC()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    class f extends a {
        private al.c WN;

        @Override // com.tk.component.scroll.b.b.h.a
        public final boolean dm(int i) {
            return i == 8192 || i == 4096;
        }

        @Override // com.tk.component.scroll.b.b.h.a
        public final boolean oz() {
            return true;
        }

        f() {
            super(h.this, (byte) 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tk.component.scroll.b.b.h.a
        public final void s(al alVar) {
            o.c(alVar, 2);
            this.WN = new c() { // from class: com.tk.component.scroll.b.b.h.f.1
                @Override // com.tk.component.scroll.b.b.h.c, android.support.v7.widget.al.c
                public final void onChanged() {
                }
            };
            if (o.f(h.this) == 0) {
                o.c(h.this, 1);
            }
        }

        @Override // com.tk.component.scroll.b.b.h.a
        public final String oA() {
            if (oz()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        @Override // com.tk.component.scroll.b.b.h.a
        public final void d(al.a<?> aVar) {
            if (aVar != null) {
                aVar.a(this.WN);
            }
        }

        @Override // com.tk.component.scroll.b.b.h.a
        public final void e(al.a<?> aVar) {
            if (aVar != null) {
                aVar.b(this.WN);
            }
        }

        @Override // com.tk.component.scroll.b.b.h.a
        public final void oB() {
            if (Build.VERSION.SDK_INT < 21) {
                h.this.sendAccessibilityEvent(2048);
            }
        }

        @Override // com.tk.component.scroll.b.b.h.a
        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            b(accessibilityNodeInfo);
            if (Build.VERSION.SDK_INT >= 16) {
                c(accessibilityNodeInfo);
            }
        }

        @Override // com.tk.component.scroll.b.b.h.a
        public final boolean a(int i, Bundle bundle) {
            int currentItem;
            if (!dm(i)) {
                throw new IllegalStateException();
            }
            if (i == 8192) {
                currentItem = h.this.getCurrentItem() - 1;
            } else {
                currentItem = h.this.getCurrentItem() + 1;
            }
            dp(currentItem);
            return true;
        }

        @Override // com.tk.component.scroll.b.b.h.a
        public final void d(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(h.this);
            accessibilityEvent.setClassName(oA());
        }

        private void dp(int i) {
            if (h.this.ox()) {
                h.this.i(i, true);
            }
        }

        private void b(AccessibilityNodeInfo accessibilityNodeInfo) {
            int itemCount;
            int itemCount2;
            if (h.this.getAdapter() == null) {
                itemCount = 0;
            } else if (h.this.getOrientation() == 1) {
                itemCount = h.this.getAdapter().getItemCount();
            } else {
                itemCount2 = h.this.getAdapter().getItemCount();
                itemCount = 0;
                android.support.v4.e.a.b.a(accessibilityNodeInfo).m(b.C0008b.a(itemCount, itemCount2, false, 0));
            }
            itemCount2 = 0;
            android.support.v4.e.a.b.a(accessibilityNodeInfo).m(b.C0008b.a(itemCount, itemCount2, false, 0));
        }

        private void c(AccessibilityNodeInfo accessibilityNodeInfo) {
            int itemCount;
            al.a adapter = h.this.getAdapter();
            if (adapter == null || (itemCount = adapter.getItemCount()) == 0 || !h.this.ox()) {
                return;
            }
            if (h.this.Wy > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
            if (h.this.Wy < itemCount - 1) {
                accessibilityNodeInfo.addAction(4096);
            }
            accessibilityNodeInfo.setScrollable(true);
        }
    }

    static abstract class c extends al.c {
        @Override // android.support.v7.widget.al.c
        public abstract void onChanged();

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        @Override // android.support.v7.widget.al.c
        public final void ad(int i, int i2) {
            onChanged();
        }

        @Override // android.support.v7.widget.al.c
        public final void e(int i, int i2, Object obj) {
            onChanged();
        }

        @Override // android.support.v7.widget.al.c
        public final void ae(int i, int i2) {
            onChanged();
        }

        @Override // android.support.v7.widget.al.c
        public final void af(int i, int i2) {
            onChanged();
        }

        @Override // android.support.v7.widget.al.c
        public final void e(int i, int i2, int i3) {
            onChanged();
        }
    }
}

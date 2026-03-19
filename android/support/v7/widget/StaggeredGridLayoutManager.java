package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.e.a.b;
import android.support.v7.widget.aj;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class StaggeredGridLayoutManager extends aj.i implements aj.t.b {
    private int mOrientation;
    e[] ug;
    ai uh;
    ai ui;
    private int uj;
    private final ab uk;
    private BitSet ul;
    private boolean uo;
    private boolean uq;
    private d ur;
    private int us;
    private int[] uv;
    private int pH = -1;
    boolean mReverseLayout = false;
    boolean mShouldReverseLayout = false;
    int mPendingScrollPosition = -1;
    int mPendingScrollPositionOffset = Integer.MIN_VALUE;
    c um = new c();
    private int un = 2;
    private final Rect ro = new Rect();
    private final a ut = new a();
    private boolean uu = false;
    private boolean mSmoothScrollbarEnabled = true;
    private final Runnable uw = new Runnable() { // from class: android.support.v7.widget.StaggeredGridLayoutManager.1
        @Override // java.lang.Runnable
        public final void run() {
            StaggeredGridLayoutManager.this.eO();
        }
    };

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        aj.i.b properties = getProperties(context, attributeSet, i, i2);
        setOrientation(properties.orientation);
        al(properties.spanCount);
        setReverseLayout(properties.rx);
        this.uk = new ab();
        eN();
    }

    @Override // android.support.v7.widget.aj.i
    public boolean isAutoMeasureEnabled() {
        return this.un != 0;
    }

    private void eN() {
        this.uh = ai.a(this, this.mOrientation);
        this.ui = ai.a(this, 1 - this.mOrientation);
    }

    final boolean eO() {
        int iEW;
        int iEV;
        if (getChildCount() == 0 || this.un == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.mShouldReverseLayout) {
            iEW = eV();
            iEV = eW();
        } else {
            iEW = eW();
            iEV = eV();
        }
        if (iEW == 0 && eP() != null) {
            this.um.clear();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
        if (!this.uu) {
            return false;
        }
        int i = this.mShouldReverseLayout ? -1 : 1;
        int i2 = iEV + 1;
        c.a aVarA = this.um.a(iEW, i2, i, true);
        if (aVarA == null) {
            this.uu = false;
            this.um.aT(i2);
            return false;
        }
        c.a aVarA2 = this.um.a(iEW, aVarA.mPosition, i * (-1), true);
        if (aVarA2 == null) {
            this.um.aT(aVarA.mPosition);
        } else {
            this.um.aT(aVarA2.mPosition + 1);
        }
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
    }

    @Override // android.support.v7.widget.aj.i
    public void onScrollStateChanged(int i) {
        if (i == 0) {
            eO();
        }
    }

    @Override // android.support.v7.widget.aj.i
    public void onDetachedFromWindow(aj ajVar, aj.p pVar) {
        super.onDetachedFromWindow(ajVar, pVar);
        removeCallbacks(this.uw);
        for (int i = 0; i < this.pH; i++) {
            this.ug[i].clear();
        }
        ajVar.requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.view.View eP() {
        /*
            r12 = this;
            int r0 = r12.getChildCount()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.pH
            r2.<init>(r3)
            int r3 = r12.pH
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.mOrientation
            r5 = -1
            if (r3 != r1) goto L20
            boolean r3 = r12.isLayoutRTL()
            if (r3 == 0) goto L20
            r3 = 1
            goto L21
        L20:
            r3 = -1
        L21:
            boolean r6 = r12.mShouldReverseLayout
            if (r6 == 0) goto L27
            r6 = -1
            goto L2b
        L27:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L2b:
            if (r0 >= r6) goto L2e
            r5 = 1
        L2e:
            if (r0 == r6) goto Laa
            android.view.View r7 = r12.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            android.support.v7.widget.StaggeredGridLayoutManager$b r8 = (android.support.v7.widget.StaggeredGridLayoutManager.b) r8
            android.support.v7.widget.StaggeredGridLayoutManager$e r9 = r8.uA
            int r9 = r9.mIndex
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L54
            android.support.v7.widget.StaggeredGridLayoutManager$e r9 = r8.uA
            boolean r9 = r12.a(r9)
            if (r9 == 0) goto L4d
            return r7
        L4d:
            android.support.v7.widget.StaggeredGridLayoutManager$e r9 = r8.uA
            int r9 = r9.mIndex
            r2.clear(r9)
        L54:
            boolean r9 = r8.uB
            if (r9 != 0) goto La8
            int r9 = r0 + r5
            if (r9 == r6) goto La8
            android.view.View r9 = r12.getChildAt(r9)
            boolean r10 = r12.mShouldReverseLayout
            if (r10 == 0) goto L76
            android.support.v7.widget.ai r10 = r12.uh
            int r10 = r10.N(r7)
            android.support.v7.widget.ai r11 = r12.uh
            int r11 = r11.N(r9)
            if (r10 >= r11) goto L73
            return r7
        L73:
            if (r10 != r11) goto L89
            goto L87
        L76:
            android.support.v7.widget.ai r10 = r12.uh
            int r10 = r10.M(r7)
            android.support.v7.widget.ai r11 = r12.uh
            int r11 = r11.M(r9)
            if (r10 <= r11) goto L85
            return r7
        L85:
            if (r10 != r11) goto L89
        L87:
            r10 = 1
            goto L8a
        L89:
            r10 = 0
        L8a:
            if (r10 == 0) goto La8
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            android.support.v7.widget.StaggeredGridLayoutManager$b r9 = (android.support.v7.widget.StaggeredGridLayoutManager.b) r9
            android.support.v7.widget.StaggeredGridLayoutManager$e r8 = r8.uA
            int r8 = r8.mIndex
            android.support.v7.widget.StaggeredGridLayoutManager$e r9 = r9.uA
            int r9 = r9.mIndex
            int r8 = r8 - r9
            if (r8 >= 0) goto L9f
            r8 = 1
            goto La0
        L9f:
            r8 = 0
        La0:
            if (r3 >= 0) goto La4
            r9 = 1
            goto La5
        La4:
            r9 = 0
        La5:
            if (r8 == r9) goto La8
            return r7
        La8:
            int r0 = r0 + r5
            goto L2e
        Laa:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.eP():android.view.View");
    }

    private boolean a(e eVar) {
        if (this.mShouldReverseLayout) {
            return eVar.fd() < this.uh.dF() && !e.ab(eVar.uL.get(eVar.uL.size() - 1)).uB;
        }
        if (eVar.fb() > this.uh.dE() && !e.ab(eVar.uL.get(0)).uB) {
            return true;
        }
        return false;
    }

    private void al(int i) {
        assertNotInLayoutOrScroll(null);
        if (i != this.pH) {
            eQ();
            this.pH = i;
            this.ul = new BitSet(this.pH);
            this.ug = new e[this.pH];
            for (int i2 = 0; i2 < this.pH; i2++) {
                this.ug[i2] = new e(i2);
            }
            requestLayout();
        }
    }

    private void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        assertNotInLayoutOrScroll(null);
        if (i == this.mOrientation) {
            return;
        }
        this.mOrientation = i;
        ai aiVar = this.uh;
        this.uh = this.ui;
        this.ui = aiVar;
        requestLayout();
    }

    private void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        d dVar = this.ur;
        if (dVar != null && dVar.mReverseLayout != z) {
            this.ur.mReverseLayout = z;
        }
        this.mReverseLayout = z;
        requestLayout();
    }

    @Override // android.support.v7.widget.aj.i
    public void assertNotInLayoutOrScroll(String str) {
        if (this.ur == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    private void eQ() {
        this.um.clear();
        requestLayout();
    }

    private void resolveShouldLayoutReverse() {
        boolean z = true;
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            z = this.mReverseLayout;
        } else if (this.mReverseLayout) {
            z = false;
        }
        this.mShouldReverseLayout = z;
    }

    private boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    @Override // android.support.v7.widget.aj.i
    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int iChooseSize;
        int iChooseSize2;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            iChooseSize2 = chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            iChooseSize = chooseSize(i, (this.uj * this.pH) + paddingLeft, getMinimumWidth());
        } else {
            iChooseSize = chooseSize(i, rect.width() + paddingLeft, getMinimumWidth());
            iChooseSize2 = chooseSize(i2, (this.uj * this.pH) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(iChooseSize, iChooseSize2);
    }

    @Override // android.support.v7.widget.aj.i
    public void onLayoutChildren(aj.p pVar, aj.u uVar) {
        a(pVar, uVar, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x0164  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.support.v7.widget.aj.p r9, android.support.v7.widget.aj.u r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 389
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.a(android.support.v7.widget.aj$p, android.support.v7.widget.aj$u, boolean):void");
    }

    @Override // android.support.v7.widget.aj.i
    public void onLayoutCompleted(aj.u uVar) {
        super.onLayoutCompleted(uVar);
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.ur = null;
        this.ut.reset();
    }

    private void eR() {
        if (this.ui.getMode() == 1073741824) {
            return;
        }
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            float fQ = this.ui.Q(childAt);
            if (fQ >= fMax) {
                if (((b) childAt.getLayoutParams()).eX()) {
                    fQ = (fQ * 1.0f) / this.pH;
                }
                fMax = Math.max(fMax, fQ);
            }
        }
        int i2 = this.uj;
        int iRound = Math.round(fMax * this.pH);
        if (this.ui.getMode() == Integer.MIN_VALUE) {
            iRound = Math.min(iRound, this.ui.dG());
        }
        aG(iRound);
        if (this.uj == i2) {
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = getChildAt(i3);
            b bVar = (b) childAt2.getLayoutParams();
            if (!bVar.uB) {
                if (isLayoutRTL() && this.mOrientation == 1) {
                    childAt2.offsetLeftAndRight(((-((this.pH - 1) - bVar.uA.mIndex)) * this.uj) - ((-((this.pH - 1) - bVar.uA.mIndex)) * i2));
                } else {
                    int i4 = bVar.uA.mIndex * this.uj;
                    int i5 = bVar.uA.mIndex * i2;
                    if (this.mOrientation == 1) {
                        childAt2.offsetLeftAndRight(i4 - i5);
                    } else {
                        childAt2.offsetTopAndBottom(i4 - i5);
                    }
                }
            }
        }
    }

    private void a(a aVar) {
        int iDE;
        if (this.ur.uH > 0) {
            if (this.ur.uH == this.pH) {
                for (int i = 0; i < this.pH; i++) {
                    this.ug[i].clear();
                    int i2 = this.ur.uI[i];
                    if (i2 != Integer.MIN_VALUE) {
                        if (this.ur.qD) {
                            iDE = this.uh.dF();
                        } else {
                            iDE = this.uh.dE();
                        }
                        i2 += iDE;
                    }
                    this.ug[i].bf(i2);
                }
            } else {
                this.ur.eY();
                d dVar = this.ur;
                dVar.qB = dVar.uG;
            }
        }
        this.uq = this.ur.uq;
        setReverseLayout(this.ur.mReverseLayout);
        resolveShouldLayoutReverse();
        if (this.ur.qB != -1) {
            this.mPendingScrollPosition = this.ur.qB;
            aVar.qp = this.ur.qD;
        } else {
            aVar.qp = this.mShouldReverseLayout;
        }
        if (this.ur.uJ > 1) {
            this.um.mData = this.ur.uK;
            this.um.uC = this.ur.uC;
        }
    }

    private void a(aj.u uVar, a aVar) {
        if (c(uVar, aVar)) {
            return;
        }
        b(uVar, aVar);
    }

    private boolean b(aj.u uVar, a aVar) {
        int iAQ;
        if (this.uo) {
            iAQ = aR(uVar.getItemCount());
        } else {
            iAQ = aQ(uVar.getItemCount());
        }
        aVar.mPosition = iAQ;
        aVar.bV = Integer.MIN_VALUE;
        return true;
    }

    private boolean c(aj.u uVar, a aVar) {
        int i;
        int iDE;
        if (!uVar.ef() && (i = this.mPendingScrollPosition) != -1) {
            if (i < 0 || i >= uVar.getItemCount()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            } else {
                d dVar = this.ur;
                if (dVar == null || dVar.qB == -1 || this.ur.uH <= 0) {
                    View viewFindViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                    if (viewFindViewByPosition != null) {
                        aVar.mPosition = this.mShouldReverseLayout ? eV() : eW();
                        if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
                            if (aVar.qp) {
                                aVar.bV = (this.uh.dF() - this.mPendingScrollPositionOffset) - this.uh.N(viewFindViewByPosition);
                            } else {
                                aVar.bV = (this.uh.dE() + this.mPendingScrollPositionOffset) - this.uh.M(viewFindViewByPosition);
                            }
                            return true;
                        }
                        if (this.uh.Q(viewFindViewByPosition) > this.uh.dG()) {
                            if (aVar.qp) {
                                iDE = this.uh.dF();
                            } else {
                                iDE = this.uh.dE();
                            }
                            aVar.bV = iDE;
                            return true;
                        }
                        int iM = this.uh.M(viewFindViewByPosition) - this.uh.dE();
                        if (iM < 0) {
                            aVar.bV = -iM;
                            return true;
                        }
                        int iDF = this.uh.dF() - this.uh.N(viewFindViewByPosition);
                        if (iDF < 0) {
                            aVar.bV = iDF;
                            return true;
                        }
                        aVar.bV = Integer.MIN_VALUE;
                    } else {
                        aVar.mPosition = this.mPendingScrollPosition;
                        int i2 = this.mPendingScrollPositionOffset;
                        if (i2 == Integer.MIN_VALUE) {
                            aVar.qp = aP(aVar.mPosition) == 1;
                            aVar.dv();
                        } else {
                            aVar.aS(i2);
                        }
                        aVar.uy = true;
                    }
                } else {
                    aVar.bV = Integer.MIN_VALUE;
                    aVar.mPosition = this.mPendingScrollPosition;
                }
                return true;
            }
        }
        return false;
    }

    private void aG(int i) {
        this.uj = i / this.pH;
        this.us = View.MeasureSpec.makeMeasureSpec(i, this.ui.getMode());
    }

    @Override // android.support.v7.widget.aj.i
    public boolean supportsPredictiveItemAnimations() {
        return this.ur == null;
    }

    @Override // android.support.v7.widget.aj.i
    public int computeHorizontalScrollOffset(aj.u uVar) {
        return computeScrollOffset(uVar);
    }

    private int computeScrollOffset(aj.u uVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return an.a(uVar, this.uh, E(!this.mSmoothScrollbarEnabled), F(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    @Override // android.support.v7.widget.aj.i
    public int computeVerticalScrollOffset(aj.u uVar) {
        return computeScrollOffset(uVar);
    }

    @Override // android.support.v7.widget.aj.i
    public int computeHorizontalScrollExtent(aj.u uVar) {
        return computeScrollExtent(uVar);
    }

    private int computeScrollExtent(aj.u uVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return an.a(uVar, this.uh, E(!this.mSmoothScrollbarEnabled), F(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled);
    }

    @Override // android.support.v7.widget.aj.i
    public int computeVerticalScrollExtent(aj.u uVar) {
        return computeScrollExtent(uVar);
    }

    @Override // android.support.v7.widget.aj.i
    public int computeHorizontalScrollRange(aj.u uVar) {
        return computeScrollRange(uVar);
    }

    private int computeScrollRange(aj.u uVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return an.b(uVar, this.uh, E(!this.mSmoothScrollbarEnabled), F(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled);
    }

    @Override // android.support.v7.widget.aj.i
    public int computeVerticalScrollRange(aj.u uVar) {
        return computeScrollRange(uVar);
    }

    private void a(View view, b bVar, boolean z) {
        if (bVar.uB) {
            if (this.mOrientation == 1) {
                a(view, this.us, getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), bVar.height, true), false);
                return;
            } else {
                a(view, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), bVar.width, true), this.us, false);
                return;
            }
        }
        if (this.mOrientation == 1) {
            a(view, getChildMeasureSpec(this.uj, getWidthMode(), 0, bVar.width, false), getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), bVar.height, true), false);
        } else {
            a(view, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), bVar.width, true), getChildMeasureSpec(this.uj, getHeightMode(), 0, bVar.height, false), false);
        }
    }

    private void a(View view, int i, int i2, boolean z) {
        boolean zShouldMeasureChild;
        calculateItemDecorationsForChild(view, this.ro);
        b bVar = (b) view.getLayoutParams();
        int iG = g(i, bVar.leftMargin + this.ro.left, bVar.rightMargin + this.ro.right);
        int iG2 = g(i2, bVar.topMargin + this.ro.top, bVar.bottomMargin + this.ro.bottom);
        if (z) {
            zShouldMeasureChild = shouldReMeasureChild(view, iG, iG2, bVar);
        } else {
            zShouldMeasureChild = shouldMeasureChild(view, iG, iG2, bVar);
        }
        if (zShouldMeasureChild) {
            view.measure(iG, iG2);
        }
    }

    private static int g(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    @Override // android.support.v7.widget.aj.i
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.ur = (d) parcelable;
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.aj.i
    public Parcelable onSaveInstanceState() {
        int iBd;
        int iDE;
        d dVar = this.ur;
        if (dVar != null) {
            return new d(dVar);
        }
        d dVar2 = new d();
        dVar2.mReverseLayout = this.mReverseLayout;
        dVar2.qD = this.uo;
        dVar2.uq = this.uq;
        c cVar = this.um;
        if (cVar != null && cVar.mData != null) {
            dVar2.uK = this.um.mData;
            dVar2.uJ = dVar2.uK.length;
            dVar2.uC = this.um.uC;
        } else {
            dVar2.uJ = 0;
        }
        if (getChildCount() > 0) {
            dVar2.qB = this.uo ? eV() : eW();
            dVar2.uG = eS();
            int i = this.pH;
            dVar2.uH = i;
            dVar2.uI = new int[i];
            for (int i2 = 0; i2 < this.pH; i2++) {
                if (this.uo) {
                    iBd = this.ug[i2].be(Integer.MIN_VALUE);
                    if (iBd != Integer.MIN_VALUE) {
                        iDE = this.uh.dF();
                        iBd -= iDE;
                    }
                } else {
                    iBd = this.ug[i2].bd(Integer.MIN_VALUE);
                    if (iBd != Integer.MIN_VALUE) {
                        iDE = this.uh.dE();
                        iBd -= iDE;
                    }
                }
                dVar2.uI[i2] = iBd;
            }
        } else {
            dVar2.qB = -1;
            dVar2.uG = -1;
            dVar2.uH = 0;
        }
        return dVar2;
    }

    @Override // android.support.v7.widget.aj.i
    public void onInitializeAccessibilityNodeInfoForItem(aj.p pVar, aj.u uVar, View view, android.support.v4.e.a.b bVar) {
        int i;
        int iDs;
        int i2;
        int i3;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, bVar);
            return;
        }
        b bVar2 = (b) layoutParams;
        if (this.mOrientation == 0) {
            iDs = bVar2.ds();
            i2 = bVar2.uB ? this.pH : 1;
            i = -1;
            i3 = -1;
        } else {
            int iDs2 = bVar2.ds();
            if (bVar2.uB) {
                i = iDs2;
                i3 = this.pH;
                iDs = -1;
                i2 = -1;
            } else {
                i = iDs2;
                iDs = -1;
                i2 = -1;
                i3 = 1;
            }
        }
        bVar.m(b.C0008b.a(iDs, i2, i, i3, bVar2.uB, false));
    }

    @Override // android.support.v7.widget.aj.i
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View viewE = E(false);
            View viewF = F(false);
            if (viewE == null || viewF == null) {
                return;
            }
            int position = getPosition(viewE);
            int position2 = getPosition(viewF);
            if (position < position2) {
                accessibilityEvent.setFromIndex(position);
                accessibilityEvent.setToIndex(position2);
            } else {
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    private int eS() {
        View viewF = this.mShouldReverseLayout ? F(true) : E(true);
        if (viewF == null) {
            return -1;
        }
        return getPosition(viewF);
    }

    @Override // android.support.v7.widget.aj.i
    public int getRowCountForAccessibility(aj.p pVar, aj.u uVar) {
        if (this.mOrientation == 0) {
            return this.pH;
        }
        return super.getRowCountForAccessibility(pVar, uVar);
    }

    @Override // android.support.v7.widget.aj.i
    public int getColumnCountForAccessibility(aj.p pVar, aj.u uVar) {
        if (this.mOrientation == 1) {
            return this.pH;
        }
        return super.getColumnCountForAccessibility(pVar, uVar);
    }

    private View E(boolean z) {
        int iDE = this.uh.dE();
        int iDF = this.uh.dF();
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int iM = this.uh.M(childAt);
            if (this.uh.N(childAt) > iDE && iM < iDF) {
                if (iM >= iDE || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    private View F(boolean z) {
        int iDE = this.uh.dE();
        int iDF = this.uh.dF();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int iM = this.uh.M(childAt);
            int iN = this.uh.N(childAt);
            if (iN > iDE && iM < iDF) {
                if (iN <= iDF || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    private void b(aj.p pVar, aj.u uVar, boolean z) {
        int iDF;
        int iAM = aM(Integer.MIN_VALUE);
        if (iAM != Integer.MIN_VALUE && (iDF = this.uh.dF() - iAM) > 0) {
            int i = iDF - (-scrollBy(-iDF, pVar, uVar));
            if (!z || i <= 0) {
                return;
            }
            this.uh.ap(i);
        }
    }

    private void c(aj.p pVar, aj.u uVar, boolean z) {
        int iDE;
        int iAL = aL(Integer.MAX_VALUE);
        if (iAL != Integer.MAX_VALUE && (iDE = iAL - this.uh.dE()) > 0) {
            int iScrollBy = iDE - scrollBy(iDE, pVar, uVar);
            if (!z || iScrollBy <= 0) {
                return;
            }
            this.uh.ap(-iScrollBy);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r5, android.support.v7.widget.aj.u r6) {
        /*
            r4 = this;
            android.support.v7.widget.ab r0 = r4.uk
            r1 = 0
            r0.pT = r1
            r0.mCurrentPosition = r5
            boolean r0 = r4.isSmoothScrolling()
            r2 = 1
            if (r0 == 0) goto L2e
            int r6 = r6.eh()
            r0 = -1
            if (r6 == r0) goto L2e
            boolean r0 = r4.mShouldReverseLayout
            if (r6 >= r5) goto L1b
            r5 = 1
            goto L1c
        L1b:
            r5 = 0
        L1c:
            if (r0 != r5) goto L25
            android.support.v7.widget.ai r5 = r4.uh
            int r5 = r5.dG()
            goto L2f
        L25:
            android.support.v7.widget.ai r5 = r4.uh
            int r5 = r5.dG()
            r6 = r5
            r5 = 0
            goto L30
        L2e:
            r5 = 0
        L2f:
            r6 = 0
        L30:
            boolean r0 = r4.getClipToPadding()
            if (r0 == 0) goto L4d
            android.support.v7.widget.ab r0 = r4.uk
            android.support.v7.widget.ai r3 = r4.uh
            int r3 = r3.dE()
            int r3 = r3 - r6
            r0.pV = r3
            android.support.v7.widget.ab r6 = r4.uk
            android.support.v7.widget.ai r0 = r4.uh
            int r0 = r0.dF()
            int r0 = r0 + r5
            r6.pW = r0
            goto L5d
        L4d:
            android.support.v7.widget.ab r0 = r4.uk
            android.support.v7.widget.ai r3 = r4.uh
            int r3 = r3.getEnd()
            int r3 = r3 + r5
            r0.pW = r3
            android.support.v7.widget.ab r5 = r4.uk
            int r6 = -r6
            r5.pV = r6
        L5d:
            android.support.v7.widget.ab r5 = r4.uk
            r5.pX = r1
            r5.pS = r2
            android.support.v7.widget.ai r6 = r4.uh
            int r6 = r6.getMode()
            if (r6 != 0) goto L74
            android.support.v7.widget.ai r6 = r4.uh
            int r6 = r6.getEnd()
            if (r6 != 0) goto L74
            r1 = 1
        L74:
            r5.pY = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.a(int, android.support.v7.widget.aj$u):void");
    }

    private void aH(int i) {
        ab abVar = this.uk;
        abVar.fx = i;
        abVar.pU = this.mShouldReverseLayout != (i == -1) ? -1 : 1;
    }

    @Override // android.support.v7.widget.aj.i
    public void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (int i2 = 0; i2 < this.pH; i2++) {
            this.ug[i2].bg(i);
        }
    }

    @Override // android.support.v7.widget.aj.i
    public void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (int i2 = 0; i2 < this.pH; i2++) {
            this.ug[i2].bg(i);
        }
    }

    @Override // android.support.v7.widget.aj.i
    public void onItemsRemoved(aj ajVar, int i, int i2) {
        h(i, i2, 2);
    }

    @Override // android.support.v7.widget.aj.i
    public void onItemsAdded(aj ajVar, int i, int i2) {
        h(i, i2, 1);
    }

    @Override // android.support.v7.widget.aj.i
    public void onItemsChanged(aj ajVar) {
        this.um.clear();
        requestLayout();
    }

    @Override // android.support.v7.widget.aj.i
    public void onItemsMoved(aj ajVar, int i, int i2, int i3) {
        h(i, i2, 8);
    }

    @Override // android.support.v7.widget.aj.i
    public void onItemsUpdated(aj ajVar, int i, int i2, Object obj) {
        h(i, i2, 4);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void h(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.mShouldReverseLayout
            if (r0 == 0) goto L9
            int r0 = r6.eV()
            goto Ld
        L9:
            int r0 = r6.eW()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1b
            if (r7 >= r8) goto L16
            int r2 = r8 + 1
            goto L1d
        L16:
            int r2 = r7 + 1
            r3 = r2
            r2 = r8
            goto L1f
        L1b:
            int r2 = r7 + r8
        L1d:
            r3 = r2
            r2 = r7
        L1f:
            android.support.v7.widget.StaggeredGridLayoutManager$c r4 = r6.um
            r4.aU(r2)
            r4 = 1
            if (r9 == r4) goto L3e
            r5 = 2
            if (r9 == r5) goto L38
            if (r9 == r1) goto L2d
            goto L43
        L2d:
            android.support.v7.widget.StaggeredGridLayoutManager$c r9 = r6.um
            r9.P(r7, r4)
            android.support.v7.widget.StaggeredGridLayoutManager$c r7 = r6.um
            r7.R(r8, r4)
            goto L43
        L38:
            android.support.v7.widget.StaggeredGridLayoutManager$c r9 = r6.um
            r9.P(r7, r8)
            goto L43
        L3e:
            android.support.v7.widget.StaggeredGridLayoutManager$c r9 = r6.um
            r9.R(r7, r8)
        L43:
            if (r3 > r0) goto L46
            return
        L46:
            boolean r7 = r6.mShouldReverseLayout
            if (r7 == 0) goto L4f
            int r7 = r6.eW()
            goto L53
        L4f:
            int r7 = r6.eV()
        L53:
            if (r2 > r7) goto L58
            r6.requestLayout()
        L58:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.h(int, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v5 */
    private int a(aj.p pVar, ab abVar, aj.u uVar) {
        int i;
        int i2;
        int iDE;
        int iAM;
        e eVarA;
        int iQ;
        int i3;
        int iQ2;
        int iQ3;
        boolean zEU;
        ?? r9 = 0;
        this.ul.set(0, this.pH, true);
        if (this.uk.pY) {
            i2 = abVar.fx == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            if (abVar.fx == 1) {
                i = abVar.pW + abVar.pT;
            } else {
                i = abVar.pV - abVar.pT;
            }
            i2 = i;
        }
        O(abVar.fx, i2);
        if (this.mShouldReverseLayout) {
            iDE = this.uh.dF();
        } else {
            iDE = this.uh.dE();
        }
        int i4 = iDE;
        boolean z = false;
        while (abVar.a(uVar) && (this.uk.pY || !this.ul.isEmpty())) {
            View viewA = abVar.a(pVar);
            b bVar = (b) viewA.getLayoutParams();
            int iDU = bVar.dU();
            int iAV = this.um.aV(iDU);
            boolean z2 = iAV == -1;
            if (z2) {
                eVarA = bVar.uB ? this.ug[r9] : a(abVar);
                this.um.a(iDU, eVarA);
            } else {
                eVarA = this.ug[iAV];
            }
            e eVar = eVarA;
            bVar.uA = eVar;
            if (abVar.fx == 1) {
                addView(viewA);
            } else {
                addView(viewA, r9);
            }
            a(viewA, bVar, (boolean) r9);
            if (abVar.fx == 1) {
                int iAM2 = bVar.uB ? aM(i4) : eVar.be(i4);
                int iQ4 = this.uh.Q(viewA) + iAM2;
                if (z2 && bVar.uB) {
                    c.a aVarAI = aI(iAM2);
                    aVarAI.uD = -1;
                    aVarAI.mPosition = iDU;
                    this.um.a(aVarAI);
                }
                i3 = iQ4;
                iQ = iAM2;
            } else {
                int iAL = bVar.uB ? aL(i4) : eVar.bd(i4);
                iQ = iAL - this.uh.Q(viewA);
                if (z2 && bVar.uB) {
                    c.a aVarAJ = aJ(iAL);
                    aVarAJ.uD = 1;
                    aVarAJ.mPosition = iDU;
                    this.um.a(aVarAJ);
                }
                i3 = iAL;
            }
            if (bVar.uB && abVar.pU == -1) {
                if (!z2) {
                    if (abVar.fx == 1) {
                        zEU = eT();
                    } else {
                        zEU = eU();
                    }
                    if (!zEU) {
                        c.a aVarAZ = this.um.aZ(iDU);
                        if (aVarAZ != null) {
                            aVarAZ.uF = true;
                        }
                        this.uu = true;
                    }
                } else {
                    this.uu = true;
                }
            }
            a(viewA, bVar, abVar);
            if (isLayoutRTL() && this.mOrientation == 1) {
                int iDF = bVar.uB ? this.ui.dF() : this.ui.dF() - (((this.pH - 1) - eVar.mIndex) * this.uj);
                iQ3 = iDF;
                iQ2 = iDF - this.ui.Q(viewA);
            } else {
                int iDE2 = bVar.uB ? this.ui.dE() : (eVar.mIndex * this.uj) + this.ui.dE();
                iQ2 = iDE2;
                iQ3 = this.ui.Q(viewA) + iDE2;
            }
            if (this.mOrientation == 1) {
                layoutDecoratedWithMargins(viewA, iQ2, iQ, iQ3, i3);
            } else {
                layoutDecoratedWithMargins(viewA, iQ, iQ2, i3, iQ3);
            }
            if (bVar.uB) {
                O(this.uk.fx, i2);
            } else {
                a(eVar, this.uk.fx, i2);
            }
            a(pVar, this.uk);
            if (this.uk.pX && viewA.hasFocusable()) {
                if (bVar.uB) {
                    this.ul.clear();
                } else {
                    this.ul.set(eVar.mIndex, false);
                }
            }
            z = true;
            r9 = 0;
        }
        if (!z) {
            a(pVar, this.uk);
        }
        if (this.uk.fx == -1) {
            iAM = this.uh.dE() - aL(this.uh.dE());
        } else {
            iAM = aM(this.uh.dF()) - this.uh.dF();
        }
        if (iAM > 0) {
            return Math.min(abVar.pT, iAM);
        }
        return 0;
    }

    private c.a aI(int i) {
        c.a aVar = new c.a();
        aVar.uE = new int[this.pH];
        for (int i2 = 0; i2 < this.pH; i2++) {
            aVar.uE[i2] = i - this.ug[i2].be(i);
        }
        return aVar;
    }

    private c.a aJ(int i) {
        c.a aVar = new c.a();
        aVar.uE = new int[this.pH];
        for (int i2 = 0; i2 < this.pH; i2++) {
            aVar.uE[i2] = this.ug[i2].bd(i) - i;
        }
        return aVar;
    }

    private void a(View view, b bVar, ab abVar) {
        if (abVar.fx == 1) {
            if (bVar.uB) {
                X(view);
                return;
            } else {
                bVar.uA.aa(view);
                return;
            }
        }
        if (bVar.uB) {
            Y(view);
        } else {
            bVar.uA.Z(view);
        }
    }

    private void a(aj.p pVar, ab abVar) {
        int iMin;
        int iMin2;
        if (!abVar.pS || abVar.pY) {
            return;
        }
        if (abVar.pT == 0) {
            if (abVar.fx == -1) {
                b(pVar, abVar.pW);
                return;
            } else {
                a(pVar, abVar.pV);
                return;
            }
        }
        if (abVar.fx == -1) {
            int iAK = abVar.pV - aK(abVar.pV);
            if (iAK < 0) {
                iMin2 = abVar.pW;
            } else {
                iMin2 = abVar.pW - Math.min(iAK, abVar.pT);
            }
            b(pVar, iMin2);
            return;
        }
        int iAN = aN(abVar.pW) - abVar.pW;
        if (iAN < 0) {
            iMin = abVar.pV;
        } else {
            iMin = Math.min(iAN, abVar.pT) + abVar.pV;
        }
        a(pVar, iMin);
    }

    private void X(View view) {
        for (int i = this.pH - 1; i >= 0; i--) {
            this.ug[i].aa(view);
        }
    }

    private void Y(View view) {
        for (int i = this.pH - 1; i >= 0; i--) {
            this.ug[i].Z(view);
        }
    }

    private void O(int i, int i2) {
        for (int i3 = 0; i3 < this.pH; i3++) {
            if (!this.ug[i3].uL.isEmpty()) {
                a(this.ug[i3], i, i2);
            }
        }
    }

    private void a(e eVar, int i, int i2) {
        int iFg = eVar.fg();
        if (i == -1) {
            if (eVar.fb() + iFg <= i2) {
                this.ul.set(eVar.mIndex, false);
            }
        } else if (eVar.fd() - iFg >= i2) {
            this.ul.set(eVar.mIndex, false);
        }
    }

    private int aK(int i) {
        int iBd = this.ug[0].bd(i);
        for (int i2 = 1; i2 < this.pH; i2++) {
            int iBd2 = this.ug[i2].bd(i);
            if (iBd2 > iBd) {
                iBd = iBd2;
            }
        }
        return iBd;
    }

    private int aL(int i) {
        int iBd = this.ug[0].bd(i);
        for (int i2 = 1; i2 < this.pH; i2++) {
            int iBd2 = this.ug[i2].bd(i);
            if (iBd2 < iBd) {
                iBd = iBd2;
            }
        }
        return iBd;
    }

    private boolean eT() {
        int iBe = this.ug[0].be(Integer.MIN_VALUE);
        for (int i = 1; i < this.pH; i++) {
            if (this.ug[i].be(Integer.MIN_VALUE) != iBe) {
                return false;
            }
        }
        return true;
    }

    private boolean eU() {
        int iBd = this.ug[0].bd(Integer.MIN_VALUE);
        for (int i = 1; i < this.pH; i++) {
            if (this.ug[i].bd(Integer.MIN_VALUE) != iBd) {
                return false;
            }
        }
        return true;
    }

    private int aM(int i) {
        int iBe = this.ug[0].be(i);
        for (int i2 = 1; i2 < this.pH; i2++) {
            int iBe2 = this.ug[i2].be(i);
            if (iBe2 > iBe) {
                iBe = iBe2;
            }
        }
        return iBe;
    }

    private int aN(int i) {
        int iBe = this.ug[0].be(i);
        for (int i2 = 1; i2 < this.pH; i2++) {
            int iBe2 = this.ug[i2].be(i);
            if (iBe2 < iBe) {
                iBe = iBe2;
            }
        }
        return iBe;
    }

    private void a(aj.p pVar, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.uh.N(childAt) > i || this.uh.O(childAt) > i) {
                return;
            }
            b bVar = (b) childAt.getLayoutParams();
            if (bVar.uB) {
                for (int i2 = 0; i2 < this.pH; i2++) {
                    if (this.ug[i2].uL.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.pH; i3++) {
                    this.ug[i3].ff();
                }
            } else if (bVar.uA.uL.size() == 1) {
                return;
            } else {
                bVar.uA.ff();
            }
            removeAndRecycleView(childAt, pVar);
        }
    }

    private void b(aj.p pVar, int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.uh.M(childAt) < i || this.uh.P(childAt) < i) {
                return;
            }
            b bVar = (b) childAt.getLayoutParams();
            if (bVar.uB) {
                for (int i2 = 0; i2 < this.pH; i2++) {
                    if (this.ug[i2].uL.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.pH; i3++) {
                    this.ug[i3].fe();
                }
            } else if (bVar.uA.uL.size() == 1) {
                return;
            } else {
                bVar.uA.fe();
            }
            removeAndRecycleView(childAt, pVar);
        }
    }

    private boolean aO(int i) {
        if (this.mOrientation == 0) {
            return (i == -1) != this.mShouldReverseLayout;
        }
        return ((i == -1) == this.mShouldReverseLayout) == isLayoutRTL();
    }

    private e a(ab abVar) {
        int i;
        int i2;
        int i3 = -1;
        if (aO(abVar.fx)) {
            i = this.pH - 1;
            i2 = -1;
        } else {
            i = 0;
            i3 = this.pH;
            i2 = 1;
        }
        e eVar = null;
        if (abVar.fx == 1) {
            int i4 = Integer.MAX_VALUE;
            int iDE = this.uh.dE();
            while (i != i3) {
                e eVar2 = this.ug[i];
                int iBe = eVar2.be(iDE);
                if (iBe < i4) {
                    eVar = eVar2;
                    i4 = iBe;
                }
                i += i2;
            }
            return eVar;
        }
        int i5 = Integer.MIN_VALUE;
        int iDF = this.uh.dF();
        while (i != i3) {
            e eVar3 = this.ug[i];
            int iBd = eVar3.bd(iDF);
            if (iBd > i5) {
                eVar = eVar3;
                i5 = iBd;
            }
            i += i2;
        }
        return eVar;
    }

    @Override // android.support.v7.widget.aj.i
    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    @Override // android.support.v7.widget.aj.i
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    @Override // android.support.v7.widget.aj.i
    public int scrollHorizontallyBy(int i, aj.p pVar, aj.u uVar) {
        return scrollBy(i, pVar, uVar);
    }

    @Override // android.support.v7.widget.aj.i
    public int scrollVerticallyBy(int i, aj.p pVar, aj.u uVar) {
        return scrollBy(i, pVar, uVar);
    }

    private int aP(int i) {
        if (getChildCount() == 0) {
            return this.mShouldReverseLayout ? 1 : -1;
        }
        return (i < eW()) != this.mShouldReverseLayout ? -1 : 1;
    }

    @Override // android.support.v7.widget.aj.t.b
    public PointF computeScrollVectorForPosition(int i) {
        int iAP = aP(i);
        PointF pointF = new PointF();
        if (iAP == 0) {
            return null;
        }
        if (this.mOrientation == 0) {
            pointF.x = iAP;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = iAP;
        }
        return pointF;
    }

    @Override // android.support.v7.widget.aj.i
    public void smoothScrollToPosition(aj ajVar, aj.u uVar, int i) {
        ad adVar = new ad(ajVar.getContext());
        adVar.setTargetPosition(i);
        startSmoothScroll(adVar);
    }

    @Override // android.support.v7.widget.aj.i
    public void scrollToPosition(int i) {
        d dVar = this.ur;
        if (dVar != null && dVar.qB != i) {
            this.ur.eZ();
        }
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        requestLayout();
    }

    @Override // android.support.v7.widget.aj.i
    public void collectAdjacentPrefetchPositions(int i, int i2, aj.u uVar, aj.i.a aVar) {
        int iBe;
        int iBd;
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (getChildCount() == 0 || i == 0) {
            return;
        }
        b(i, uVar);
        int[] iArr = this.uv;
        if (iArr == null || iArr.length < this.pH) {
            this.uv = new int[this.pH];
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.pH; i4++) {
            if (this.uk.pU == -1) {
                iBe = this.uk.pV;
                iBd = this.ug[i4].bd(this.uk.pV);
            } else {
                iBe = this.ug[i4].be(this.uk.pW);
                iBd = this.uk.pW;
            }
            int i5 = iBe - iBd;
            if (i5 >= 0) {
                this.uv[i3] = i5;
                i3++;
            }
        }
        Arrays.sort(this.uv, 0, i3);
        for (int i6 = 0; i6 < i3 && this.uk.a(uVar); i6++) {
            aVar.A(this.uk.mCurrentPosition, this.uv[i6]);
            this.uk.mCurrentPosition += this.uk.pU;
        }
    }

    private void b(int i, aj.u uVar) {
        int iEW;
        int i2;
        if (i > 0) {
            iEW = eV();
            i2 = 1;
        } else {
            iEW = eW();
            i2 = -1;
        }
        this.uk.pS = true;
        a(iEW, uVar);
        aH(i2);
        ab abVar = this.uk;
        abVar.mCurrentPosition = iEW + abVar.pU;
        this.uk.pT = Math.abs(i);
    }

    private int scrollBy(int i, aj.p pVar, aj.u uVar) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        b(i, uVar);
        int iA = a(pVar, this.uk, uVar);
        if (this.uk.pT >= iA) {
            i = i < 0 ? -iA : iA;
        }
        this.uh.ap(-i);
        this.uo = this.mShouldReverseLayout;
        ab abVar = this.uk;
        abVar.pT = 0;
        a(pVar, abVar);
        return i;
    }

    private int eV() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    private int eW() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    private int aQ(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            int position = getPosition(getChildAt(i2));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    private int aR(int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    @Override // android.support.v7.widget.aj.i
    public aj.j generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new b(-2, -1);
        }
        return new b(-1, -2);
    }

    @Override // android.support.v7.widget.aj.i
    public aj.j generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // android.support.v7.widget.aj.i
    public aj.j generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    @Override // android.support.v7.widget.aj.i
    public boolean checkLayoutParams(aj.j jVar) {
        return jVar instanceof b;
    }

    @Override // android.support.v7.widget.aj.i
    public View onFocusSearchFailed(View view, int i, aj.p pVar, aj.u uVar) {
        View viewFindContainingItemView;
        int iEW;
        int iFi;
        int iFi2;
        int iFi3;
        View viewT;
        if (getChildCount() == 0 || (viewFindContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        resolveShouldLayoutReverse();
        int iConvertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i);
        if (iConvertFocusDirectionToLayoutDirection == Integer.MIN_VALUE) {
            return null;
        }
        b bVar = (b) viewFindContainingItemView.getLayoutParams();
        boolean z = bVar.uB;
        e eVar = bVar.uA;
        if (iConvertFocusDirectionToLayoutDirection == 1) {
            iEW = eV();
        } else {
            iEW = eW();
        }
        a(iEW, uVar);
        aH(iConvertFocusDirectionToLayoutDirection);
        ab abVar = this.uk;
        abVar.mCurrentPosition = abVar.pU + iEW;
        this.uk.pT = (int) (this.uh.dG() * 0.33333334f);
        ab abVar2 = this.uk;
        abVar2.pX = true;
        abVar2.pS = false;
        a(pVar, abVar2, uVar);
        this.uo = this.mShouldReverseLayout;
        if (!z && (viewT = eVar.T(iEW, iConvertFocusDirectionToLayoutDirection)) != null && viewT != viewFindContainingItemView) {
            return viewT;
        }
        if (aO(iConvertFocusDirectionToLayoutDirection)) {
            for (int i2 = this.pH - 1; i2 >= 0; i2--) {
                View viewT2 = this.ug[i2].T(iEW, iConvertFocusDirectionToLayoutDirection);
                if (viewT2 != null && viewT2 != viewFindContainingItemView) {
                    return viewT2;
                }
            }
        } else {
            for (int i3 = 0; i3 < this.pH; i3++) {
                View viewT3 = this.ug[i3].T(iEW, iConvertFocusDirectionToLayoutDirection);
                if (viewT3 != null && viewT3 != viewFindContainingItemView) {
                    return viewT3;
                }
            }
        }
        boolean z2 = (this.mReverseLayout ^ true) == (iConvertFocusDirectionToLayoutDirection == -1);
        if (!z) {
            if (z2) {
                iFi3 = eVar.fh();
            } else {
                iFi3 = eVar.fi();
            }
            View viewFindViewByPosition = findViewByPosition(iFi3);
            if (viewFindViewByPosition != null && viewFindViewByPosition != viewFindContainingItemView) {
                return viewFindViewByPosition;
            }
        }
        if (aO(iConvertFocusDirectionToLayoutDirection)) {
            for (int i4 = this.pH - 1; i4 >= 0; i4--) {
                if (i4 != eVar.mIndex) {
                    if (z2) {
                        iFi2 = this.ug[i4].fh();
                    } else {
                        iFi2 = this.ug[i4].fi();
                    }
                    View viewFindViewByPosition2 = findViewByPosition(iFi2);
                    if (viewFindViewByPosition2 != null && viewFindViewByPosition2 != viewFindContainingItemView) {
                        return viewFindViewByPosition2;
                    }
                }
            }
        } else {
            for (int i5 = 0; i5 < this.pH; i5++) {
                if (z2) {
                    iFi = this.ug[i5].fh();
                } else {
                    iFi = this.ug[i5].fi();
                }
                View viewFindViewByPosition3 = findViewByPosition(iFi);
                if (viewFindViewByPosition3 != null && viewFindViewByPosition3 != viewFindContainingItemView) {
                    return viewFindViewByPosition3;
                }
            }
        }
        return null;
    }

    private int convertFocusDirectionToLayoutDirection(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.mOrientation == 1) ? 1 : Integer.MIN_VALUE : this.mOrientation == 0 ? 1 : Integer.MIN_VALUE : this.mOrientation == 1 ? -1 : Integer.MIN_VALUE : this.mOrientation == 0 ? -1 : Integer.MIN_VALUE : (this.mOrientation != 1 && isLayoutRTL()) ? -1 : 1 : (this.mOrientation != 1 && isLayoutRTL()) ? 1 : -1;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public static class b extends aj.j {
        e uA;
        boolean uB;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(int i, int i2) {
            super(i, i2);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public final boolean eX() {
            return this.uB;
        }

        public final int ds() {
            e eVar = this.uA;
            if (eVar == null) {
                return -1;
            }
            return eVar.mIndex;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    class e {
        final int mIndex;
        ArrayList<View> uL = new ArrayList<>();
        int uM = Integer.MIN_VALUE;
        int uN = Integer.MIN_VALUE;
        int uO = 0;

        e(int i) {
            this.mIndex = i;
        }

        final int bd(int i) {
            int i2 = this.uM;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.uL.size() == 0) {
                return i;
            }
            fa();
            return this.uM;
        }

        private void fa() {
            c.a aVarAZ;
            View view = this.uL.get(0);
            b bVarAb = ab(view);
            this.uM = StaggeredGridLayoutManager.this.uh.M(view);
            if (bVarAb.uB && (aVarAZ = StaggeredGridLayoutManager.this.um.aZ(bVarAb.dU())) != null && aVarAZ.uD == -1) {
                this.uM -= aVarAZ.ba(this.mIndex);
            }
        }

        final int fb() {
            int i = this.uM;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            fa();
            return this.uM;
        }

        final int be(int i) {
            int i2 = this.uN;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.uL.size() == 0) {
                return i;
            }
            fc();
            return this.uN;
        }

        private void fc() {
            c.a aVarAZ;
            ArrayList<View> arrayList = this.uL;
            View view = arrayList.get(arrayList.size() - 1);
            b bVarAb = ab(view);
            this.uN = StaggeredGridLayoutManager.this.uh.N(view);
            if (bVarAb.uB && (aVarAZ = StaggeredGridLayoutManager.this.um.aZ(bVarAb.dU())) != null && aVarAZ.uD == 1) {
                this.uN += aVarAZ.ba(this.mIndex);
            }
        }

        final int fd() {
            int i = this.uN;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            fc();
            return this.uN;
        }

        final void Z(View view) {
            b bVarAb = ab(view);
            bVarAb.uA = this;
            this.uL.add(0, view);
            this.uM = Integer.MIN_VALUE;
            if (this.uL.size() == 1) {
                this.uN = Integer.MIN_VALUE;
            }
            if (bVarAb.dS() || bVarAb.dT()) {
                this.uO += StaggeredGridLayoutManager.this.uh.Q(view);
            }
        }

        final void aa(View view) {
            b bVarAb = ab(view);
            bVarAb.uA = this;
            this.uL.add(view);
            this.uN = Integer.MIN_VALUE;
            if (this.uL.size() == 1) {
                this.uM = Integer.MIN_VALUE;
            }
            if (bVarAb.dS() || bVarAb.dT()) {
                this.uO += StaggeredGridLayoutManager.this.uh.Q(view);
            }
        }

        final void a(boolean z, int i) {
            int iBd;
            if (z) {
                iBd = be(Integer.MIN_VALUE);
            } else {
                iBd = bd(Integer.MIN_VALUE);
            }
            clear();
            if (iBd == Integer.MIN_VALUE) {
                return;
            }
            if (!z || iBd >= StaggeredGridLayoutManager.this.uh.dF()) {
                if (z || iBd <= StaggeredGridLayoutManager.this.uh.dE()) {
                    if (i != Integer.MIN_VALUE) {
                        iBd += i;
                    }
                    this.uN = iBd;
                    this.uM = iBd;
                }
            }
        }

        final void clear() {
            this.uL.clear();
            aB();
            this.uO = 0;
        }

        private void aB() {
            this.uM = Integer.MIN_VALUE;
            this.uN = Integer.MIN_VALUE;
        }

        final void bf(int i) {
            this.uM = i;
            this.uN = i;
        }

        final void fe() {
            int size = this.uL.size();
            View viewRemove = this.uL.remove(size - 1);
            b bVarAb = ab(viewRemove);
            bVarAb.uA = null;
            if (bVarAb.dS() || bVarAb.dT()) {
                this.uO -= StaggeredGridLayoutManager.this.uh.Q(viewRemove);
            }
            if (size == 1) {
                this.uM = Integer.MIN_VALUE;
            }
            this.uN = Integer.MIN_VALUE;
        }

        final void ff() {
            View viewRemove = this.uL.remove(0);
            b bVarAb = ab(viewRemove);
            bVarAb.uA = null;
            if (this.uL.size() == 0) {
                this.uN = Integer.MIN_VALUE;
            }
            if (bVarAb.dS() || bVarAb.dT()) {
                this.uO -= StaggeredGridLayoutManager.this.uh.Q(viewRemove);
            }
            this.uM = Integer.MIN_VALUE;
        }

        public final int fg() {
            return this.uO;
        }

        static b ab(View view) {
            return (b) view.getLayoutParams();
        }

        final void bg(int i) {
            int i2 = this.uM;
            if (i2 != Integer.MIN_VALUE) {
                this.uM = i2 + i;
            }
            int i3 = this.uN;
            if (i3 != Integer.MIN_VALUE) {
                this.uN = i3 + i;
            }
        }

        public final int fh() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return b(this.uL.size() - 1, -1, true);
            }
            return b(0, this.uL.size(), true);
        }

        public final int fi() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return b(0, this.uL.size(), true);
            }
            return b(this.uL.size() - 1, -1, true);
        }

        private int a(int i, int i2, boolean z, boolean z2, boolean z3) {
            int iDE = StaggeredGridLayoutManager.this.uh.dE();
            int iDF = StaggeredGridLayoutManager.this.uh.dF();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.uL.get(i);
                int iM = StaggeredGridLayoutManager.this.uh.M(view);
                int iN = StaggeredGridLayoutManager.this.uh.N(view);
                boolean z4 = false;
                boolean z5 = !z3 ? iM >= iDF : iM > iDF;
                if (!z3 ? iN > iDE : iN >= iDE) {
                    z4 = true;
                }
                if (z5 && z4 && (iM < iDE || iN > iDF)) {
                    return StaggeredGridLayoutManager.this.getPosition(view);
                }
                i += i3;
            }
            return -1;
        }

        private int b(int i, int i2, boolean z) {
            return a(i, i2, false, false, true);
        }

        public final View T(int i, int i2) {
            View view = null;
            if (i2 == -1) {
                int size = this.uL.size();
                int i3 = 0;
                while (i3 < size) {
                    View view2 = this.uL.get(i3);
                    if ((StaggeredGridLayoutManager.this.mReverseLayout && StaggeredGridLayoutManager.this.getPosition(view2) <= i) || ((!StaggeredGridLayoutManager.this.mReverseLayout && StaggeredGridLayoutManager.this.getPosition(view2) >= i) || !view2.hasFocusable())) {
                        break;
                    }
                    i3++;
                    view = view2;
                }
            } else {
                int size2 = this.uL.size() - 1;
                while (size2 >= 0) {
                    View view3 = this.uL.get(size2);
                    if ((StaggeredGridLayoutManager.this.mReverseLayout && StaggeredGridLayoutManager.this.getPosition(view3) >= i) || ((!StaggeredGridLayoutManager.this.mReverseLayout && StaggeredGridLayoutManager.this.getPosition(view3) <= i) || !view3.hasFocusable())) {
                        break;
                    }
                    size2--;
                    view = view3;
                }
            }
            return view;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static class c {
        int[] mData;
        List<a> uC;

        c() {
        }

        final int aT(int i) {
            List<a> list = this.uC;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.uC.get(size).mPosition >= i) {
                        this.uC.remove(size);
                    }
                }
            }
            return aU(i);
        }

        final int aU(int i) {
            int[] iArr = this.mData;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            int iAY = aY(i);
            if (iAY == -1) {
                int[] iArr2 = this.mData;
                Arrays.fill(iArr2, i, iArr2.length, -1);
                return this.mData.length;
            }
            int i2 = iAY + 1;
            Arrays.fill(this.mData, i, i2, -1);
            return i2;
        }

        final int aV(int i) {
            int[] iArr = this.mData;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            return iArr[i];
        }

        final void a(int i, e eVar) {
            aX(i);
            this.mData[i] = eVar.mIndex;
        }

        private int aW(int i) {
            int length = this.mData.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        private void aX(int i) {
            int[] iArr = this.mData;
            if (iArr == null) {
                this.mData = new int[Math.max(i, 10) + 1];
                Arrays.fill(this.mData, -1);
            } else if (i >= iArr.length) {
                this.mData = new int[aW(i)];
                System.arraycopy(iArr, 0, this.mData, 0, iArr.length);
                int[] iArr2 = this.mData;
                Arrays.fill(iArr2, iArr.length, iArr2.length, -1);
            }
        }

        final void clear() {
            int[] iArr = this.mData;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.uC = null;
        }

        final void P(int i, int i2) {
            int[] iArr = this.mData;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            aX(i3);
            int[] iArr2 = this.mData;
            System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
            int[] iArr3 = this.mData;
            Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
            Q(i, i2);
        }

        private void Q(int i, int i2) {
            List<a> list = this.uC;
            if (list == null) {
                return;
            }
            int i3 = i + i2;
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.uC.get(size);
                if (aVar.mPosition >= i) {
                    if (aVar.mPosition < i3) {
                        this.uC.remove(size);
                    } else {
                        aVar.mPosition -= i2;
                    }
                }
            }
        }

        final void R(int i, int i2) {
            int[] iArr = this.mData;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            aX(i3);
            int[] iArr2 = this.mData;
            System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
            Arrays.fill(this.mData, i, i3, -1);
            S(i, i2);
        }

        private void S(int i, int i2) {
            List<a> list = this.uC;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.uC.get(size);
                if (aVar.mPosition >= i) {
                    aVar.mPosition += i2;
                }
            }
        }

        private int aY(int i) {
            if (this.uC == null) {
                return -1;
            }
            a aVarAZ = aZ(i);
            if (aVarAZ != null) {
                this.uC.remove(aVarAZ);
            }
            int size = this.uC.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                }
                if (this.uC.get(i2).mPosition >= i) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return -1;
            }
            a aVar = this.uC.get(i2);
            this.uC.remove(i2);
            return aVar.mPosition;
        }

        public final void a(a aVar) {
            if (this.uC == null) {
                this.uC = new ArrayList();
            }
            int size = this.uC.size();
            for (int i = 0; i < size; i++) {
                a aVar2 = this.uC.get(i);
                if (aVar2.mPosition == aVar.mPosition) {
                    this.uC.remove(i);
                }
                if (aVar2.mPosition >= aVar.mPosition) {
                    this.uC.add(i, aVar);
                    return;
                }
            }
            this.uC.add(aVar);
        }

        public final a aZ(int i) {
            List<a> list = this.uC;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.uC.get(size);
                if (aVar.mPosition == i) {
                    return aVar;
                }
            }
            return null;
        }

        public final a a(int i, int i2, int i3, boolean z) {
            List<a> list = this.uC;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                a aVar = this.uC.get(i4);
                if (aVar.mPosition >= i2) {
                    return null;
                }
                if (aVar.mPosition >= i && (i3 == 0 || aVar.uD == i3 || aVar.uF)) {
                    return aVar;
                }
            }
            return null;
        }

        /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
        static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: android.support.v7.widget.StaggeredGridLayoutManager.c.a.1
                @Override // android.os.Parcelable.Creator
                public final /* synthetic */ a createFromParcel(Parcel parcel) {
                    return f(parcel);
                }

                @Override // android.os.Parcelable.Creator
                public final /* synthetic */ a[] newArray(int i) {
                    return bb(i);
                }

                private static a f(Parcel parcel) {
                    return new a(parcel);
                }

                private static a[] bb(int i) {
                    return new a[i];
                }
            };
            int mPosition;
            int uD;
            int[] uE;
            boolean uF;

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            a(Parcel parcel) {
                this.mPosition = parcel.readInt();
                this.uD = parcel.readInt();
                this.uF = parcel.readInt() == 1;
                int i = parcel.readInt();
                if (i > 0) {
                    this.uE = new int[i];
                    parcel.readIntArray(this.uE);
                }
            }

            a() {
            }

            final int ba(int i) {
                int[] iArr = this.uE;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i];
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.mPosition);
                parcel.writeInt(this.uD);
                parcel.writeInt(this.uF ? 1 : 0);
                int[] iArr = this.uE;
                if (iArr != null && iArr.length > 0) {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.uE);
                } else {
                    parcel.writeInt(0);
                }
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.uD + ", mHasUnwantedGapAfter=" + this.uF + ", mGapPerSpan=" + Arrays.toString(this.uE) + '}';
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() { // from class: android.support.v7.widget.StaggeredGridLayoutManager.d.1
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ d createFromParcel(Parcel parcel) {
                return g(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ d[] newArray(int i) {
                return bc(i);
            }

            private static d g(Parcel parcel) {
                return new d(parcel);
            }

            private static d[] bc(int i) {
                return new d[i];
            }
        };
        boolean mReverseLayout;
        int qB;
        boolean qD;
        List<c.a> uC;
        int uG;
        int uH;
        int[] uI;
        int uJ;
        int[] uK;
        boolean uq;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public d() {
        }

        d(Parcel parcel) {
            this.qB = parcel.readInt();
            this.uG = parcel.readInt();
            this.uH = parcel.readInt();
            int i = this.uH;
            if (i > 0) {
                this.uI = new int[i];
                parcel.readIntArray(this.uI);
            }
            this.uJ = parcel.readInt();
            int i2 = this.uJ;
            if (i2 > 0) {
                this.uK = new int[i2];
                parcel.readIntArray(this.uK);
            }
            this.mReverseLayout = parcel.readInt() == 1;
            this.qD = parcel.readInt() == 1;
            this.uq = parcel.readInt() == 1;
            this.uC = parcel.readArrayList(c.a.class.getClassLoader());
        }

        public d(d dVar) {
            this.uH = dVar.uH;
            this.qB = dVar.qB;
            this.uG = dVar.uG;
            this.uI = dVar.uI;
            this.uJ = dVar.uJ;
            this.uK = dVar.uK;
            this.mReverseLayout = dVar.mReverseLayout;
            this.qD = dVar.qD;
            this.uq = dVar.uq;
            this.uC = dVar.uC;
        }

        final void eY() {
            this.uI = null;
            this.uH = 0;
            this.uJ = 0;
            this.uK = null;
            this.uC = null;
        }

        final void eZ() {
            this.uI = null;
            this.uH = 0;
            this.qB = -1;
            this.uG = -1;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.qB);
            parcel.writeInt(this.uG);
            parcel.writeInt(this.uH);
            if (this.uH > 0) {
                parcel.writeIntArray(this.uI);
            }
            parcel.writeInt(this.uJ);
            if (this.uJ > 0) {
                parcel.writeIntArray(this.uK);
            }
            parcel.writeInt(this.mReverseLayout ? 1 : 0);
            parcel.writeInt(this.qD ? 1 : 0);
            parcel.writeInt(this.uq ? 1 : 0);
            parcel.writeList(this.uC);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    class a {
        int bV;
        int mPosition;
        boolean qp;
        boolean qq;
        boolean uy;
        int[] uz;

        a() {
            reset();
        }

        final void reset() {
            this.mPosition = -1;
            this.bV = Integer.MIN_VALUE;
            this.qp = false;
            this.uy = false;
            this.qq = false;
            int[] iArr = this.uz;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        final void a(e[] eVarArr) {
            int length = eVarArr.length;
            int[] iArr = this.uz;
            if (iArr == null || iArr.length < length) {
                this.uz = new int[StaggeredGridLayoutManager.this.ug.length];
            }
            for (int i = 0; i < length; i++) {
                this.uz[i] = eVarArr[i].bd(Integer.MIN_VALUE);
            }
        }

        final void dv() {
            this.bV = this.qp ? StaggeredGridLayoutManager.this.uh.dF() : StaggeredGridLayoutManager.this.uh.dE();
        }

        final void aS(int i) {
            if (this.qp) {
                this.bV = StaggeredGridLayoutManager.this.uh.dF() - i;
            } else {
                this.bV = StaggeredGridLayoutManager.this.uh.dE() + i;
            }
        }
    }
}

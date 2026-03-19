package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.e.a.b;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.aj;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class GridLayoutManager extends LinearLayoutManager {
    boolean pG;
    int pH;
    int[] pI;
    View[] pJ;
    final SparseIntArray pK;
    final SparseIntArray pL;
    c pM;
    final Rect pN;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.pG = false;
        this.pH = -1;
        this.pK = new SparseIntArray();
        this.pL = new SparseIntArray();
        this.pM = new a();
        this.pN = new Rect();
        al(getProperties(context, attributeSet, i, i2).spanCount);
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.setStackFromEnd(false);
    }

    @Override // android.support.v7.widget.aj.i
    public int getRowCountForAccessibility(aj.p pVar, aj.u uVar) {
        if (this.mOrientation == 0) {
            return this.pH;
        }
        if (uVar.getItemCount() <= 0) {
            return 0;
        }
        return a(pVar, uVar, uVar.getItemCount() - 1) + 1;
    }

    @Override // android.support.v7.widget.aj.i
    public int getColumnCountForAccessibility(aj.p pVar, aj.u uVar) {
        if (this.mOrientation == 1) {
            return this.pH;
        }
        if (uVar.getItemCount() <= 0) {
            return 0;
        }
        return a(pVar, uVar, uVar.getItemCount() - 1) + 1;
    }

    @Override // android.support.v7.widget.aj.i
    public void onInitializeAccessibilityNodeInfoForItem(aj.p pVar, aj.u uVar, View view, android.support.v4.e.a.b bVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, bVar);
            return;
        }
        b bVar2 = (b) layoutParams;
        int iA = a(pVar, uVar, bVar2.dU());
        if (this.mOrientation == 0) {
            bVar.m(b.C0008b.a(bVar2.ds(), bVar2.dt(), iA, 1, this.pH > 1 && bVar2.dt() == this.pH, false));
        } else {
            bVar.m(b.C0008b.a(iA, 1, bVar2.ds(), bVar2.dt(), this.pH > 1 && bVar2.dt() == this.pH, false));
        }
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.aj.i
    public void onLayoutChildren(aj.p pVar, aj.u uVar) {
        if (uVar.ef()) {
            dp();
        }
        super.onLayoutChildren(pVar, uVar);
        m0do();
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.aj.i
    public void onLayoutCompleted(aj.u uVar) {
        super.onLayoutCompleted(uVar);
        this.pG = false;
    }

    /* renamed from: do, reason: not valid java name */
    private void m0do() {
        this.pK.clear();
        this.pL.clear();
    }

    private void dp() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            b bVar = (b) getChildAt(i).getLayoutParams();
            int iDU = bVar.dU();
            this.pK.put(iDU, bVar.dt());
            this.pL.put(iDU, bVar.ds());
        }
    }

    @Override // android.support.v7.widget.aj.i
    public void onItemsAdded(aj ajVar, int i, int i2) {
        this.pM.du();
    }

    @Override // android.support.v7.widget.aj.i
    public void onItemsChanged(aj ajVar) {
        this.pM.du();
    }

    @Override // android.support.v7.widget.aj.i
    public void onItemsRemoved(aj ajVar, int i, int i2) {
        this.pM.du();
    }

    @Override // android.support.v7.widget.aj.i
    public void onItemsUpdated(aj ajVar, int i, int i2, Object obj) {
        this.pM.du();
    }

    @Override // android.support.v7.widget.aj.i
    public void onItemsMoved(aj ajVar, int i, int i2, int i3) {
        this.pM.du();
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.aj.i
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

    private void dq() {
        int height;
        int paddingTop;
        if (getOrientation() == 1) {
            height = getWidth() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        ak(height - paddingTop);
    }

    @Override // android.support.v7.widget.aj.i
    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int iChooseSize;
        int iChooseSize2;
        if (this.pI == null) {
            super.setMeasuredDimension(rect, i, i2);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            iChooseSize2 = chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            int[] iArr = this.pI;
            iChooseSize = chooseSize(i, iArr[iArr.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            iChooseSize = chooseSize(i, rect.width() + paddingLeft, getMinimumWidth());
            int[] iArr2 = this.pI;
            iChooseSize2 = chooseSize(i2, iArr2[iArr2.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(iChooseSize, iChooseSize2);
    }

    private void ak(int i) {
        this.pI = d(this.pI, this.pH, i);
    }

    private static int[] d(int[] iArr, int i, int i2) {
        int i3;
        if (iArr == null || iArr.length != i + 1 || iArr[iArr.length - 1] != i2) {
            iArr = new int[i + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    private int B(int i, int i2) {
        if (this.mOrientation == 1 && isLayoutRTL()) {
            int[] iArr = this.pI;
            int i3 = this.pH;
            return iArr[i3 - i] - iArr[(i3 - i) - i2];
        }
        int[] iArr2 = this.pI;
        return iArr2[i2 + i] - iArr2[i];
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    void onAnchorReady(aj.p pVar, aj.u uVar, LinearLayoutManager.a aVar, int i) {
        super.onAnchorReady(pVar, uVar, aVar, i);
        dq();
        if (uVar.getItemCount() > 0 && !uVar.ef()) {
            a(pVar, uVar, aVar, i);
        }
        dr();
    }

    private void dr() {
        View[] viewArr = this.pJ;
        if (viewArr == null || viewArr.length != this.pH) {
            this.pJ = new View[this.pH];
        }
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.aj.i
    public int scrollHorizontallyBy(int i, aj.p pVar, aj.u uVar) {
        dq();
        dr();
        return super.scrollHorizontallyBy(i, pVar, uVar);
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.aj.i
    public int scrollVerticallyBy(int i, aj.p pVar, aj.u uVar) {
        dq();
        dr();
        return super.scrollVerticallyBy(i, pVar, uVar);
    }

    private void a(aj.p pVar, aj.u uVar, LinearLayoutManager.a aVar, int i) {
        boolean z = i == 1;
        int iB = b(pVar, uVar, aVar.mPosition);
        if (z) {
            while (iB > 0 && aVar.mPosition > 0) {
                aVar.mPosition--;
                iB = b(pVar, uVar, aVar.mPosition);
            }
            return;
        }
        int itemCount = uVar.getItemCount() - 1;
        int i2 = aVar.mPosition;
        while (i2 < itemCount) {
            int i3 = i2 + 1;
            int iB2 = b(pVar, uVar, i3);
            if (iB2 <= iB) {
                break;
            }
            i2 = i3;
            iB = iB2;
        }
        aVar.mPosition = i2;
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    View findReferenceChild(aj.p pVar, aj.u uVar, int i, int i2, int i3) {
        ensureLayoutState();
        int iDE = this.mOrientationHelper.dE();
        int iDF = this.mOrientationHelper.dF();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3 && b(pVar, uVar, position) == 0) {
                if (((aj.j) childAt.getLayoutParams()).dS()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.mOrientationHelper.M(childAt) < iDF && this.mOrientationHelper.N(childAt) >= iDE) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    private int a(aj.p pVar, aj.u uVar, int i) {
        if (!uVar.ef()) {
            return this.pM.E(i, this.pH);
        }
        int iAt = pVar.at(i);
        if (iAt == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
            return 0;
        }
        return this.pM.E(iAt, this.pH);
    }

    private int b(aj.p pVar, aj.u uVar, int i) {
        if (!uVar.ef()) {
            return this.pM.D(i, this.pH);
        }
        int i2 = this.pL.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iAt = pVar.at(i);
        if (iAt == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
            return 0;
        }
        return this.pM.D(iAt, this.pH);
    }

    private int c(aj.p pVar, aj.u uVar, int i) {
        if (!uVar.ef()) {
            return 1;
        }
        int i2 = this.pK.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        if (pVar.at(i) == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        }
        return 1;
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    void collectPrefetchPositionsForLayoutState(aj.u uVar, LinearLayoutManager.c cVar, aj.i.a aVar) {
        int i = this.pH;
        for (int i2 = 0; i2 < this.pH && cVar.a(uVar) && i > 0; i2++) {
            aVar.A(cVar.mCurrentPosition, Math.max(0, cVar.qw));
            i--;
            cVar.mCurrentPosition += cVar.pU;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v27 */
    @Override // android.support.v7.widget.LinearLayoutManager
    void layoutChunk(aj.p pVar, aj.u uVar, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int iR;
        int i5;
        int iR2;
        int iR3;
        int childMeasureSpec;
        int childMeasureSpec2;
        View viewA;
        int iDH = this.mOrientationHelper.dH();
        ?? r5 = 0;
        boolean z = iDH != 1073741824;
        int i6 = getChildCount() > 0 ? this.pI[this.pH] : 0;
        if (z) {
            dq();
        }
        boolean z2 = cVar.pU == 1;
        int iB = this.pH;
        if (!z2) {
            iB = b(pVar, uVar, cVar.mCurrentPosition) + c(pVar, uVar, cVar.mCurrentPosition);
        }
        int i7 = iB;
        int i8 = 0;
        while (i8 < this.pH && cVar.a(uVar) && i7 > 0) {
            int i9 = cVar.mCurrentPosition;
            int iC = c(pVar, uVar, i9);
            if (iC > this.pH) {
                throw new IllegalArgumentException("Item at position " + i9 + " requires " + iC + " spans but GridLayoutManager has only " + this.pH + " spans.");
            }
            i7 -= iC;
            if (i7 < 0 || (viewA = cVar.a(pVar)) == null) {
                break;
            }
            this.pJ[i8] = viewA;
            i8++;
        }
        if (i8 == 0) {
            bVar.qt = true;
            return;
        }
        float f = 0.0f;
        a(pVar, uVar, i8, z2);
        int i10 = 0;
        int i11 = 0;
        while (i10 < i8) {
            View view = this.pJ[i10];
            if (cVar.qA == null) {
                if (z2) {
                    addView(view);
                } else {
                    addView(view, r5);
                }
            } else if (z2) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, r5);
            }
            calculateItemDecorationsForChild(view, this.pN);
            b(view, iDH, (boolean) r5);
            int iQ = this.mOrientationHelper.Q(view);
            if (iQ > i11) {
                i11 = iQ;
            }
            float fR = (this.mOrientationHelper.R(view) * 1.0f) / ((b) view.getLayoutParams()).pP;
            if (fR > f) {
                f = fR;
            }
            i10++;
            r5 = 0;
        }
        if (z) {
            a(f, i6);
            i11 = 0;
            for (int i12 = 0; i12 < i8; i12++) {
                View view2 = this.pJ[i12];
                b(view2, 1073741824, true);
                int iQ2 = this.mOrientationHelper.Q(view2);
                if (iQ2 > i11) {
                    i11 = iQ2;
                }
            }
        }
        for (int i13 = 0; i13 < i8; i13++) {
            View view3 = this.pJ[i13];
            if (this.mOrientationHelper.Q(view3) != i11) {
                b bVar2 = (b) view3.getLayoutParams();
                Rect rect = bVar2.pN;
                int i14 = rect.top + rect.bottom + bVar2.topMargin + bVar2.bottomMargin;
                int i15 = rect.left + rect.right + bVar2.leftMargin + bVar2.rightMargin;
                int iB2 = B(bVar2.pO, bVar2.pP);
                if (this.mOrientation == 1) {
                    childMeasureSpec2 = getChildMeasureSpec(iB2, 1073741824, i15, bVar2.width, false);
                    childMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11 - i14, 1073741824);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11 - i15, 1073741824);
                    childMeasureSpec = getChildMeasureSpec(iB2, 1073741824, i14, bVar2.height, false);
                    childMeasureSpec2 = iMakeMeasureSpec;
                }
                a(view3, childMeasureSpec2, childMeasureSpec, true);
            }
        }
        int i16 = 0;
        bVar.qr = i11;
        if (this.mOrientation == 1) {
            if (cVar.fx == -1) {
                int i17 = cVar.bV;
                int i18 = i17 - i11;
                i3 = i17;
                i2 = 0;
                i4 = i18;
                i = 0;
            } else {
                i4 = cVar.bV;
                i3 = i4 + i11;
                i = 0;
                i2 = 0;
            }
        } else {
            if (cVar.fx == -1) {
                int i19 = cVar.bV;
                i2 = i19 - i11;
                i = i19;
            } else {
                int i20 = cVar.bV;
                i = i20 + i11;
                i2 = i20;
            }
            i3 = 0;
            i4 = 0;
        }
        while (i16 < i8) {
            View view4 = this.pJ[i16];
            b bVar3 = (b) view4.getLayoutParams();
            if (this.mOrientation == 1) {
                if (isLayoutRTL()) {
                    int paddingLeft = getPaddingLeft() + this.pI[this.pH - bVar3.pO];
                    iR = paddingLeft;
                    iR3 = i3;
                    iR2 = paddingLeft - this.mOrientationHelper.R(view4);
                } else {
                    int paddingLeft2 = getPaddingLeft() + this.pI[bVar3.pO];
                    iR2 = paddingLeft2;
                    iR3 = i3;
                    iR = this.mOrientationHelper.R(view4) + paddingLeft2;
                }
                i5 = i4;
            } else {
                int paddingTop = getPaddingTop() + this.pI[bVar3.pO];
                iR = i;
                i5 = paddingTop;
                iR2 = i2;
                iR3 = this.mOrientationHelper.R(view4) + paddingTop;
            }
            layoutDecoratedWithMargins(view4, iR2, i5, iR, iR3);
            if (bVar3.dS() || bVar3.dT()) {
                bVar.qu = true;
            }
            bVar.qv |= view4.hasFocusable();
            i16++;
            i2 = iR2;
            i4 = i5;
            i = iR;
            i3 = iR3;
        }
        Arrays.fill(this.pJ, (Object) null);
    }

    private void b(View view, int i, boolean z) {
        int childMeasureSpec;
        int childMeasureSpec2;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.pN;
        int i2 = rect.top + rect.bottom + bVar.topMargin + bVar.bottomMargin;
        int i3 = rect.left + rect.right + bVar.leftMargin + bVar.rightMargin;
        int iB = B(bVar.pO, bVar.pP);
        if (this.mOrientation == 1) {
            childMeasureSpec2 = getChildMeasureSpec(iB, i, i3, bVar.width, false);
            childMeasureSpec = getChildMeasureSpec(this.mOrientationHelper.dG(), getHeightMode(), i2, bVar.height, true);
        } else {
            int childMeasureSpec3 = getChildMeasureSpec(iB, i, i2, bVar.height, false);
            int childMeasureSpec4 = getChildMeasureSpec(this.mOrientationHelper.dG(), getWidthMode(), i3, bVar.width, true);
            childMeasureSpec = childMeasureSpec3;
            childMeasureSpec2 = childMeasureSpec4;
        }
        a(view, childMeasureSpec2, childMeasureSpec, z);
    }

    private void a(float f, int i) {
        ak(Math.max(Math.round(f * this.pH), i));
    }

    private void a(View view, int i, int i2, boolean z) {
        boolean zShouldMeasureChild;
        aj.j jVar = (aj.j) view.getLayoutParams();
        if (z) {
            zShouldMeasureChild = shouldReMeasureChild(view, i, i2, jVar);
        } else {
            zShouldMeasureChild = shouldMeasureChild(view, i, i2, jVar);
        }
        if (zShouldMeasureChild) {
            view.measure(i, i2);
        }
    }

    private void a(aj.p pVar, aj.u uVar, int i, boolean z) {
        int i2;
        int i3;
        int i4 = 0;
        int i5 = -1;
        if (z) {
            i5 = i;
            i2 = 0;
            i3 = 1;
        } else {
            i2 = i - 1;
            i3 = -1;
        }
        while (i2 != i5) {
            View view = this.pJ[i2];
            b bVar = (b) view.getLayoutParams();
            bVar.pP = c(pVar, uVar, getPosition(view));
            bVar.pO = i4;
            i4 += bVar.pP;
            i2 += i3;
        }
    }

    private void al(int i) {
        if (i == this.pH) {
            return;
        }
        this.pG = true;
        if (i <= 0) {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
        }
        this.pH = i;
        this.pM.du();
        requestLayout();
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public static abstract class c {
        final SparseIntArray pQ = new SparseIntArray();
        private boolean pR = false;

        public final int E(int i, int i2) {
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                i3++;
                if (i3 == i2) {
                    i4++;
                    i3 = 0;
                } else if (i3 > i2) {
                    i4++;
                    i3 = 1;
                }
            }
            return i3 + 1 > i2 ? i4 + 1 : i4;
        }

        public final void du() {
            this.pQ.clear();
        }

        final int D(int i, int i2) {
            if (!this.pR) {
                return C(i, i2);
            }
            int i3 = this.pQ.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int iC = C(i, i2);
            this.pQ.put(i, iC);
            return iC;
        }

        public int C(int i, int i2) {
            int i3;
            int i4;
            int iAm;
            if (1 == i2) {
                return 0;
            }
            if (!this.pR || this.pQ.size() <= 0 || (iAm = am(i)) < 0) {
                i3 = 0;
                i4 = 0;
            } else {
                i4 = this.pQ.get(iAm) + 1;
                i3 = iAm + 1;
            }
            while (i3 < i) {
                i4++;
                if (i4 == i2) {
                    i4 = 0;
                } else if (i4 > i2) {
                    i4 = 1;
                }
                i3++;
            }
            if (i4 + 1 <= i2) {
                return i4;
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        protected int am(int i) {
            int size = this.pQ.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.pQ.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= this.pQ.size()) {
                return -1;
            }
            return this.pQ.keyAt(i4);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x00d5, code lost:
    
        if (r13 == (r2 > r8)) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0103  */
    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.aj.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View onFocusSearchFailed(android.view.View r23, int r24, android.support.v7.widget.aj.p r25, android.support.v7.widget.aj.u r26) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, android.support.v7.widget.aj$p, android.support.v7.widget.aj$u):android.view.View");
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.aj.i
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.pG;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public static final class a extends c {
        @Override // android.support.v7.widget.GridLayoutManager.c
        public final int C(int i, int i2) {
            return i % i2;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public static class b extends aj.j {
        int pO;
        int pP;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.pO = -1;
            this.pP = 0;
        }

        public b(int i, int i2) {
            super(i, i2);
            this.pO = -1;
            this.pP = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.pO = -1;
            this.pP = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.pO = -1;
            this.pP = 0;
        }

        public final int ds() {
            return this.pO;
        }

        public final int dt() {
            return this.pP;
        }
    }
}

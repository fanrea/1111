package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.aj;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.fragment.app.FragmentTransaction;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LinearLayoutManager extends aj.i implements aj.t.b {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final a mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final b mLayoutChunkResult;
    private c mLayoutState;
    int mOrientation;
    ai mOrientationHelper;
    d mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    @Override // android.support.v7.widget.aj.i
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    void onAnchorReady(aj.p pVar, aj.u uVar, a aVar, int i) {
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        setOrientation(i);
        setReverseLayout(z);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        aj.i.b properties = getProperties(context, attributeSet, i, i2);
        setOrientation(properties.orientation);
        setReverseLayout(properties.rx);
        setStackFromEnd(properties.ry);
    }

    @Override // android.support.v7.widget.aj.i
    public aj.j generateDefaultLayoutParams() {
        return new aj.j(-2, -2);
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.mRecycleChildrenOnDetach = z;
    }

    @Override // android.support.v7.widget.aj.i
    public void onDetachedFromWindow(aj ajVar, aj.p pVar) {
        super.onDetachedFromWindow(ajVar, pVar);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(pVar);
            pVar.clear();
        }
    }

    @Override // android.support.v7.widget.aj.i
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    @Override // android.support.v7.widget.aj.i
    public Parcelable onSaveInstanceState() {
        d dVar = this.mPendingSavedState;
        if (dVar != null) {
            return new d(dVar);
        }
        d dVar2 = new d();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            dVar2.qD = z;
            if (z) {
                View childClosestToEnd = getChildClosestToEnd();
                dVar2.qC = this.mOrientationHelper.dF() - this.mOrientationHelper.N(childClosestToEnd);
                dVar2.qB = getPosition(childClosestToEnd);
            } else {
                View childClosestToStart = getChildClosestToStart();
                dVar2.qB = getPosition(childClosestToStart);
                dVar2.qC = this.mOrientationHelper.M(childClosestToStart) - this.mOrientationHelper.dE();
            }
        } else {
            dVar2.dz();
        }
        return dVar2;
    }

    @Override // android.support.v7.widget.aj.i
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.mPendingSavedState = (d) parcelable;
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.aj.i
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    @Override // android.support.v7.widget.aj.i
    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    public void setStackFromEnd(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd == z) {
            return;
        }
        this.mStackFromEnd = z;
        requestLayout();
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        assertNotInLayoutOrScroll(null);
        if (i != this.mOrientation || this.mOrientationHelper == null) {
            this.mOrientationHelper = ai.a(this, i);
            this.mAnchorInfo.mOrientationHelper = this.mOrientationHelper;
            this.mOrientation = i;
            requestLayout();
        }
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

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (z == this.mReverseLayout) {
            return;
        }
        this.mReverseLayout = z;
        requestLayout();
    }

    @Override // android.support.v7.widget.aj.i
    public View findViewByPosition(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i) {
                return childAt;
            }
        }
        return super.findViewByPosition(i);
    }

    protected int getExtraLayoutSpace(aj.u uVar) {
        if (uVar.ei()) {
            return this.mOrientationHelper.dG();
        }
        return 0;
    }

    @Override // android.support.v7.widget.aj.i
    public void smoothScrollToPosition(aj ajVar, aj.u uVar, int i) {
        ad adVar = new ad(ajVar.getContext());
        adVar.setTargetPosition(i);
        startSmoothScroll(adVar);
    }

    @Override // android.support.v7.widget.aj.t.b
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = (i < getPosition(getChildAt(0))) != this.mShouldReverseLayout ? -1 : 1;
        if (this.mOrientation == 0) {
            return new PointF(i2, 0.0f);
        }
        return new PointF(0.0f, i2);
    }

    @Override // android.support.v7.widget.aj.i
    public void onLayoutChildren(aj.p pVar, aj.u uVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int iFixLayoutEndGap;
        int i6;
        View viewFindViewByPosition;
        int iM;
        int iDF;
        int i7 = -1;
        if ((this.mPendingSavedState != null || this.mPendingScrollPosition != -1) && uVar.getItemCount() == 0) {
            removeAndRecycleAllViews(pVar);
            return;
        }
        d dVar = this.mPendingSavedState;
        if (dVar != null && dVar.dy()) {
            this.mPendingScrollPosition = this.mPendingSavedState.qB;
        }
        ensureLayoutState();
        this.mLayoutState.pS = false;
        resolveShouldLayoutReverse();
        View focusedChild = getFocusedChild();
        if (!this.mAnchorInfo.qq || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            this.mAnchorInfo.reset();
            a aVar = this.mAnchorInfo;
            aVar.qp = this.mShouldReverseLayout ^ this.mStackFromEnd;
            updateAnchorInfoForLayout(pVar, uVar, aVar);
            this.mAnchorInfo.qq = true;
        } else if (focusedChild != null && (this.mOrientationHelper.M(focusedChild) >= this.mOrientationHelper.dF() || this.mOrientationHelper.N(focusedChild) <= this.mOrientationHelper.dE())) {
            this.mAnchorInfo.g(focusedChild, getPosition(focusedChild));
        }
        int extraLayoutSpace = getExtraLayoutSpace(uVar);
        if (this.mLayoutState.qz >= 0) {
            i = extraLayoutSpace;
            extraLayoutSpace = 0;
        } else {
            i = 0;
        }
        int iDE = extraLayoutSpace + this.mOrientationHelper.dE();
        int endPadding = i + this.mOrientationHelper.getEndPadding();
        if (uVar.ef() && (i6 = this.mPendingScrollPosition) != -1 && this.mPendingScrollPositionOffset != Integer.MIN_VALUE && (viewFindViewByPosition = findViewByPosition(i6)) != null) {
            if (this.mShouldReverseLayout) {
                iDF = this.mOrientationHelper.dF() - this.mOrientationHelper.N(viewFindViewByPosition);
                iM = this.mPendingScrollPositionOffset;
            } else {
                iM = this.mOrientationHelper.M(viewFindViewByPosition) - this.mOrientationHelper.dE();
                iDF = this.mPendingScrollPositionOffset;
            }
            int i8 = iDF - iM;
            if (i8 > 0) {
                iDE += i8;
            } else {
                endPadding -= i8;
            }
        }
        if (!this.mAnchorInfo.qp ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i7 = 1;
        }
        onAnchorReady(pVar, uVar, this.mAnchorInfo, i7);
        detachAndScrapAttachedViews(pVar);
        this.mLayoutState.pY = resolveIsInfinite();
        this.mLayoutState.qy = uVar.ef();
        if (this.mAnchorInfo.qp) {
            updateLayoutStateToFillStart(this.mAnchorInfo);
            c cVar = this.mLayoutState;
            cVar.qx = iDE;
            fill(pVar, cVar, uVar, false);
            i3 = this.mLayoutState.bV;
            int i9 = this.mLayoutState.mCurrentPosition;
            if (this.mLayoutState.pT > 0) {
                endPadding += this.mLayoutState.pT;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            c cVar2 = this.mLayoutState;
            cVar2.qx = endPadding;
            cVar2.mCurrentPosition += this.mLayoutState.pU;
            fill(pVar, this.mLayoutState, uVar, false);
            i2 = this.mLayoutState.bV;
            if (this.mLayoutState.pT > 0) {
                int i10 = this.mLayoutState.pT;
                updateLayoutStateToFillStart(i9, i3);
                c cVar3 = this.mLayoutState;
                cVar3.qx = i10;
                fill(pVar, cVar3, uVar, false);
                i3 = this.mLayoutState.bV;
            }
        } else {
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            c cVar4 = this.mLayoutState;
            cVar4.qx = endPadding;
            fill(pVar, cVar4, uVar, false);
            i2 = this.mLayoutState.bV;
            int i11 = this.mLayoutState.mCurrentPosition;
            if (this.mLayoutState.pT > 0) {
                iDE += this.mLayoutState.pT;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            c cVar5 = this.mLayoutState;
            cVar5.qx = iDE;
            cVar5.mCurrentPosition += this.mLayoutState.pU;
            fill(pVar, this.mLayoutState, uVar, false);
            i3 = this.mLayoutState.bV;
            if (this.mLayoutState.pT > 0) {
                int i12 = this.mLayoutState.pT;
                updateLayoutStateToFillEnd(i11, i2);
                c cVar6 = this.mLayoutState;
                cVar6.qx = i12;
                fill(pVar, cVar6, uVar, false);
                i2 = this.mLayoutState.bV;
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int iFixLayoutEndGap2 = fixLayoutEndGap(i2, pVar, uVar, true);
                i4 = i3 + iFixLayoutEndGap2;
                i5 = i2 + iFixLayoutEndGap2;
                iFixLayoutEndGap = fixLayoutStartGap(i4, pVar, uVar, false);
            } else {
                int iFixLayoutStartGap = fixLayoutStartGap(i3, pVar, uVar, true);
                i4 = i3 + iFixLayoutStartGap;
                i5 = i2 + iFixLayoutStartGap;
                iFixLayoutEndGap = fixLayoutEndGap(i5, pVar, uVar, false);
            }
            i3 = i4 + iFixLayoutEndGap;
            i2 = i5 + iFixLayoutEndGap;
        }
        layoutForPredictiveAnimations(pVar, uVar, i3, i2);
        if (!uVar.ef()) {
            this.mOrientationHelper.dC();
        } else {
            this.mAnchorInfo.reset();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    @Override // android.support.v7.widget.aj.i
    public void onLayoutCompleted(aj.u uVar) {
        super.onLayoutCompleted(uVar);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.reset();
    }

    private void layoutForPredictiveAnimations(aj.p pVar, aj.u uVar, int i, int i2) {
        if (!uVar.eg() || getChildCount() == 0 || uVar.ef() || !supportsPredictiveItemAnimations()) {
            return;
        }
        List<aj.x> listDY = pVar.dY();
        int size = listDY.size();
        int position = getPosition(getChildAt(0));
        int iQ = 0;
        int iQ2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            aj.x xVar = listDY.get(i3);
            if (!xVar.isRemoved()) {
                if (((xVar.getLayoutPosition() < position) != this.mShouldReverseLayout ? (char) 65535 : (char) 1) == 65535) {
                    iQ += this.mOrientationHelper.Q(xVar.itemView);
                } else {
                    iQ2 += this.mOrientationHelper.Q(xVar.itemView);
                }
            }
        }
        this.mLayoutState.qA = listDY;
        if (iQ > 0) {
            updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), i);
            c cVar = this.mLayoutState;
            cVar.qx = iQ;
            cVar.pT = 0;
            cVar.dx();
            fill(pVar, this.mLayoutState, uVar, false);
        }
        if (iQ2 > 0) {
            updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i2);
            c cVar2 = this.mLayoutState;
            cVar2.qx = iQ2;
            cVar2.pT = 0;
            cVar2.dx();
            fill(pVar, this.mLayoutState, uVar, false);
        }
        this.mLayoutState.qA = null;
    }

    private void updateAnchorInfoForLayout(aj.p pVar, aj.u uVar, a aVar) {
        if (updateAnchorFromPendingData(uVar, aVar) || updateAnchorFromChildren(pVar, uVar, aVar)) {
            return;
        }
        aVar.dv();
        aVar.mPosition = this.mStackFromEnd ? uVar.getItemCount() - 1 : 0;
    }

    private boolean updateAnchorFromChildren(aj.p pVar, aj.u uVar, a aVar) {
        View viewFindReferenceChildClosestToStart;
        int iDE;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && a.a(focusedChild, uVar)) {
            aVar.g(focusedChild, getPosition(focusedChild));
            return true;
        }
        if (this.mLastStackFromEnd != this.mStackFromEnd) {
            return false;
        }
        if (aVar.qp) {
            viewFindReferenceChildClosestToStart = findReferenceChildClosestToEnd(pVar, uVar);
        } else {
            viewFindReferenceChildClosestToStart = findReferenceChildClosestToStart(pVar, uVar);
        }
        if (viewFindReferenceChildClosestToStart == null) {
            return false;
        }
        aVar.h(viewFindReferenceChildClosestToStart, getPosition(viewFindReferenceChildClosestToStart));
        if (!uVar.ef() && supportsPredictiveItemAnimations()) {
            if (this.mOrientationHelper.M(viewFindReferenceChildClosestToStart) >= this.mOrientationHelper.dF() || this.mOrientationHelper.N(viewFindReferenceChildClosestToStart) < this.mOrientationHelper.dE()) {
                if (aVar.qp) {
                    iDE = this.mOrientationHelper.dF();
                } else {
                    iDE = this.mOrientationHelper.dE();
                }
                aVar.qo = iDE;
            }
        }
        return true;
    }

    private boolean updateAnchorFromPendingData(aj.u uVar, a aVar) {
        int i;
        int iM;
        if (!uVar.ef() && (i = this.mPendingScrollPosition) != -1) {
            if (i < 0 || i >= uVar.getItemCount()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            } else {
                aVar.mPosition = this.mPendingScrollPosition;
                d dVar = this.mPendingSavedState;
                if (dVar != null && dVar.dy()) {
                    aVar.qp = this.mPendingSavedState.qD;
                    if (aVar.qp) {
                        aVar.qo = this.mOrientationHelper.dF() - this.mPendingSavedState.qC;
                    } else {
                        aVar.qo = this.mOrientationHelper.dE() + this.mPendingSavedState.qC;
                    }
                    return true;
                }
                if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                    View viewFindViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                    if (viewFindViewByPosition != null) {
                        if (this.mOrientationHelper.Q(viewFindViewByPosition) > this.mOrientationHelper.dG()) {
                            aVar.dv();
                            return true;
                        }
                        if (this.mOrientationHelper.M(viewFindViewByPosition) - this.mOrientationHelper.dE() < 0) {
                            aVar.qo = this.mOrientationHelper.dE();
                            aVar.qp = false;
                            return true;
                        }
                        if (this.mOrientationHelper.dF() - this.mOrientationHelper.N(viewFindViewByPosition) < 0) {
                            aVar.qo = this.mOrientationHelper.dF();
                            aVar.qp = true;
                            return true;
                        }
                        if (aVar.qp) {
                            iM = this.mOrientationHelper.N(viewFindViewByPosition) + this.mOrientationHelper.dD();
                        } else {
                            iM = this.mOrientationHelper.M(viewFindViewByPosition);
                        }
                        aVar.qo = iM;
                    } else {
                        if (getChildCount() > 0) {
                            aVar.qp = (this.mPendingScrollPosition < getPosition(getChildAt(0))) == this.mShouldReverseLayout;
                        }
                        aVar.dv();
                    }
                    return true;
                }
                boolean z = this.mShouldReverseLayout;
                aVar.qp = z;
                if (z) {
                    aVar.qo = this.mOrientationHelper.dF() - this.mPendingScrollPositionOffset;
                } else {
                    aVar.qo = this.mOrientationHelper.dE() + this.mPendingScrollPositionOffset;
                }
                return true;
            }
        }
        return false;
    }

    private int fixLayoutEndGap(int i, aj.p pVar, aj.u uVar, boolean z) {
        int iDF;
        int iDF2 = this.mOrientationHelper.dF() - i;
        if (iDF2 <= 0) {
            return 0;
        }
        int i2 = -scrollBy(-iDF2, pVar, uVar);
        int i3 = i + i2;
        if (!z || (iDF = this.mOrientationHelper.dF() - i3) <= 0) {
            return i2;
        }
        this.mOrientationHelper.ap(iDF);
        return iDF + i2;
    }

    private int fixLayoutStartGap(int i, aj.p pVar, aj.u uVar, boolean z) {
        int iDE;
        int iDE2 = i - this.mOrientationHelper.dE();
        if (iDE2 <= 0) {
            return 0;
        }
        int i2 = -scrollBy(iDE2, pVar, uVar);
        int i3 = i + i2;
        if (!z || (iDE = i3 - this.mOrientationHelper.dE()) <= 0) {
            return i2;
        }
        this.mOrientationHelper.ap(-iDE);
        return i2 - iDE;
    }

    private void updateLayoutStateToFillEnd(a aVar) {
        updateLayoutStateToFillEnd(aVar.mPosition, aVar.qo);
    }

    private void updateLayoutStateToFillEnd(int i, int i2) {
        this.mLayoutState.pT = this.mOrientationHelper.dF() - i2;
        this.mLayoutState.pU = this.mShouldReverseLayout ? -1 : 1;
        c cVar = this.mLayoutState;
        cVar.mCurrentPosition = i;
        cVar.fx = 1;
        cVar.bV = i2;
        cVar.qw = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStart(a aVar) {
        updateLayoutStateToFillStart(aVar.mPosition, aVar.qo);
    }

    private void updateLayoutStateToFillStart(int i, int i2) {
        this.mLayoutState.pT = i2 - this.mOrientationHelper.dE();
        c cVar = this.mLayoutState;
        cVar.mCurrentPosition = i;
        cVar.pU = this.mShouldReverseLayout ? 1 : -1;
        c cVar2 = this.mLayoutState;
        cVar2.fx = -1;
        cVar2.bV = i2;
        cVar2.qw = Integer.MIN_VALUE;
    }

    protected boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    c createLayoutState() {
        return new c();
    }

    @Override // android.support.v7.widget.aj.i
    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        d dVar = this.mPendingSavedState;
        if (dVar != null) {
            dVar.dz();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = i2;
        d dVar = this.mPendingSavedState;
        if (dVar != null) {
            dVar.dz();
        }
        requestLayout();
    }

    @Override // android.support.v7.widget.aj.i
    public int scrollHorizontallyBy(int i, aj.p pVar, aj.u uVar) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i, pVar, uVar);
    }

    @Override // android.support.v7.widget.aj.i
    public int scrollVerticallyBy(int i, aj.p pVar, aj.u uVar) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i, pVar, uVar);
    }

    @Override // android.support.v7.widget.aj.i
    public int computeHorizontalScrollOffset(aj.u uVar) {
        return computeScrollOffset(uVar);
    }

    @Override // android.support.v7.widget.aj.i
    public int computeVerticalScrollOffset(aj.u uVar) {
        return computeScrollOffset(uVar);
    }

    @Override // android.support.v7.widget.aj.i
    public int computeHorizontalScrollExtent(aj.u uVar) {
        return computeScrollExtent(uVar);
    }

    @Override // android.support.v7.widget.aj.i
    public int computeVerticalScrollExtent(aj.u uVar) {
        return computeScrollExtent(uVar);
    }

    @Override // android.support.v7.widget.aj.i
    public int computeHorizontalScrollRange(aj.u uVar) {
        return computeScrollRange(uVar);
    }

    @Override // android.support.v7.widget.aj.i
    public int computeVerticalScrollRange(aj.u uVar) {
        return computeScrollRange(uVar);
    }

    private int computeScrollOffset(aj.u uVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return an.a(uVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollExtent(aj.u uVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return an.a(uVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollRange(aj.u uVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return an.b(uVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    private void updateLayoutState(int i, int i2, boolean z, aj.u uVar) {
        int iDE;
        this.mLayoutState.pY = resolveIsInfinite();
        this.mLayoutState.qx = getExtraLayoutSpace(uVar);
        c cVar = this.mLayoutState;
        cVar.fx = i;
        if (i == 1) {
            cVar.qx += this.mOrientationHelper.getEndPadding();
            View childClosestToEnd = getChildClosestToEnd();
            this.mLayoutState.pU = this.mShouldReverseLayout ? -1 : 1;
            this.mLayoutState.mCurrentPosition = getPosition(childClosestToEnd) + this.mLayoutState.pU;
            this.mLayoutState.bV = this.mOrientationHelper.N(childClosestToEnd);
            iDE = this.mOrientationHelper.N(childClosestToEnd) - this.mOrientationHelper.dF();
        } else {
            View childClosestToStart = getChildClosestToStart();
            this.mLayoutState.qx += this.mOrientationHelper.dE();
            this.mLayoutState.pU = this.mShouldReverseLayout ? 1 : -1;
            this.mLayoutState.mCurrentPosition = getPosition(childClosestToStart) + this.mLayoutState.pU;
            this.mLayoutState.bV = this.mOrientationHelper.M(childClosestToStart);
            iDE = (-this.mOrientationHelper.M(childClosestToStart)) + this.mOrientationHelper.dE();
        }
        c cVar2 = this.mLayoutState;
        cVar2.pT = i2;
        if (z) {
            cVar2.pT -= iDE;
        }
        this.mLayoutState.qw = iDE;
    }

    boolean resolveIsInfinite() {
        return this.mOrientationHelper.getMode() == 0 && this.mOrientationHelper.getEnd() == 0;
    }

    void collectPrefetchPositionsForLayoutState(aj.u uVar, c cVar, aj.i.a aVar) {
        int i = cVar.mCurrentPosition;
        if (i < 0 || i >= uVar.getItemCount()) {
            return;
        }
        aVar.A(i, Math.max(0, cVar.qw));
    }

    @Override // android.support.v7.widget.aj.i
    public void collectInitialPrefetchPositions(int i, aj.i.a aVar) {
        boolean z;
        int i2;
        d dVar = this.mPendingSavedState;
        if (dVar != null && dVar.dy()) {
            z = this.mPendingSavedState.qD;
            i2 = this.mPendingSavedState.qB;
        } else {
            resolveShouldLayoutReverse();
            z = this.mShouldReverseLayout;
            i2 = this.mPendingScrollPosition;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.mInitialPrefetchItemCount && i2 >= 0 && i2 < i; i4++) {
            aVar.A(i2, 0);
            i2 += i3;
        }
    }

    public void setInitialPrefetchItemCount(int i) {
        this.mInitialPrefetchItemCount = i;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    @Override // android.support.v7.widget.aj.i
    public void collectAdjacentPrefetchPositions(int i, int i2, aj.u uVar, aj.i.a aVar) {
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (getChildCount() == 0 || i == 0) {
            return;
        }
        ensureLayoutState();
        updateLayoutState(i > 0 ? 1 : -1, Math.abs(i), true, uVar);
        collectPrefetchPositionsForLayoutState(uVar, this.mLayoutState, aVar);
    }

    int scrollBy(int i, aj.p pVar, aj.u uVar) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        this.mLayoutState.pS = true;
        ensureLayoutState();
        int i2 = i > 0 ? 1 : -1;
        int iAbs = Math.abs(i);
        updateLayoutState(i2, iAbs, true, uVar);
        int iFill = this.mLayoutState.qw + fill(pVar, this.mLayoutState, uVar, false);
        if (iFill < 0) {
            return 0;
        }
        if (iAbs > iFill) {
            i = i2 * iFill;
        }
        this.mOrientationHelper.ap(-i);
        this.mLayoutState.qz = i;
        return i;
    }

    @Override // android.support.v7.widget.aj.i
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    private void recycleChildren(aj.p pVar, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                removeAndRecycleViewAt(i, pVar);
                i--;
            }
        } else {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                removeAndRecycleViewAt(i3, pVar);
            }
        }
    }

    private void recycleViewsFromStart(aj.p pVar, int i) {
        if (i < 0) {
            return;
        }
        int childCount = getChildCount();
        if (!this.mShouldReverseLayout) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (this.mOrientationHelper.N(childAt) > i || this.mOrientationHelper.O(childAt) > i) {
                    recycleChildren(pVar, 0, i2);
                    return;
                }
            }
            return;
        }
        int i3 = childCount - 1;
        for (int i4 = i3; i4 >= 0; i4--) {
            View childAt2 = getChildAt(i4);
            if (this.mOrientationHelper.N(childAt2) > i || this.mOrientationHelper.O(childAt2) > i) {
                recycleChildren(pVar, i3, i4);
                return;
            }
        }
    }

    private void recycleViewsFromEnd(aj.p pVar, int i) {
        int childCount = getChildCount();
        if (i < 0) {
            return;
        }
        int end = this.mOrientationHelper.getEnd() - i;
        if (this.mShouldReverseLayout) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (this.mOrientationHelper.M(childAt) < end || this.mOrientationHelper.P(childAt) < end) {
                    recycleChildren(pVar, 0, i2);
                    return;
                }
            }
            return;
        }
        int i3 = childCount - 1;
        for (int i4 = i3; i4 >= 0; i4--) {
            View childAt2 = getChildAt(i4);
            if (this.mOrientationHelper.M(childAt2) < end || this.mOrientationHelper.P(childAt2) < end) {
                recycleChildren(pVar, i3, i4);
                return;
            }
        }
    }

    private void recycleByLayoutState(aj.p pVar, c cVar) {
        if (!cVar.pS || cVar.pY) {
            return;
        }
        if (cVar.fx == -1) {
            recycleViewsFromEnd(pVar, cVar.qw);
        } else {
            recycleViewsFromStart(pVar, cVar.qw);
        }
    }

    int fill(aj.p pVar, c cVar, aj.u uVar, boolean z) {
        int i = cVar.pT;
        if (cVar.qw != Integer.MIN_VALUE) {
            if (cVar.pT < 0) {
                cVar.qw += cVar.pT;
            }
            recycleByLayoutState(pVar, cVar);
        }
        int i2 = cVar.pT + cVar.qx;
        b bVar = this.mLayoutChunkResult;
        while (true) {
            if ((!cVar.pY && i2 <= 0) || !cVar.a(uVar)) {
                break;
            }
            bVar.resetInternal();
            layoutChunk(pVar, uVar, cVar, bVar);
            if (!bVar.qt) {
                cVar.bV += bVar.qr * cVar.fx;
                if (!bVar.qu || this.mLayoutState.qA != null || !uVar.ef()) {
                    cVar.pT -= bVar.qr;
                    i2 -= bVar.qr;
                }
                if (cVar.qw != Integer.MIN_VALUE) {
                    cVar.qw += bVar.qr;
                    if (cVar.pT < 0) {
                        cVar.qw += cVar.pT;
                    }
                    recycleByLayoutState(pVar, cVar);
                }
                if (z && bVar.qv) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.pT;
    }

    void layoutChunk(aj.p pVar, aj.u uVar, c cVar, b bVar) {
        int i;
        int i2;
        int i3;
        int paddingLeft;
        int iR;
        View viewA = cVar.a(pVar);
        if (viewA == null) {
            bVar.qt = true;
            return;
        }
        aj.j jVar = (aj.j) viewA.getLayoutParams();
        if (cVar.qA == null) {
            if (this.mShouldReverseLayout == (cVar.fx == -1)) {
                addView(viewA);
            } else {
                addView(viewA, 0);
            }
        } else {
            if (this.mShouldReverseLayout == (cVar.fx == -1)) {
                addDisappearingView(viewA);
            } else {
                addDisappearingView(viewA, 0);
            }
        }
        measureChildWithMargins(viewA, 0, 0);
        bVar.qr = this.mOrientationHelper.Q(viewA);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                iR = getWidth() - getPaddingRight();
                paddingLeft = iR - this.mOrientationHelper.R(viewA);
            } else {
                paddingLeft = getPaddingLeft();
                iR = this.mOrientationHelper.R(viewA) + paddingLeft;
            }
            if (cVar.fx == -1) {
                int i4 = cVar.bV;
                i2 = cVar.bV - bVar.qr;
                i = iR;
                i3 = i4;
            } else {
                int i5 = cVar.bV;
                i3 = cVar.bV + bVar.qr;
                i = iR;
                i2 = i5;
            }
        } else {
            int paddingTop = getPaddingTop();
            int iR2 = this.mOrientationHelper.R(viewA) + paddingTop;
            if (cVar.fx == -1) {
                i2 = paddingTop;
                i = cVar.bV;
                i3 = iR2;
                paddingLeft = cVar.bV - bVar.qr;
            } else {
                int i6 = cVar.bV;
                i = cVar.bV + bVar.qr;
                i2 = paddingTop;
                i3 = iR2;
                paddingLeft = i6;
            }
        }
        layoutDecoratedWithMargins(viewA, paddingLeft, i2, i, i3);
        if (jVar.dS() || jVar.dT()) {
            bVar.qu = true;
        }
        bVar.qv = viewA.hasFocusable();
    }

    @Override // android.support.v7.widget.aj.i
    boolean shouldMeasureTwice() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) ? false : true;
    }

    int convertFocusDirectionToLayoutDirection(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.mOrientation == 1) ? 1 : Integer.MIN_VALUE : this.mOrientation == 0 ? 1 : Integer.MIN_VALUE : this.mOrientation == 1 ? -1 : Integer.MIN_VALUE : this.mOrientation == 0 ? -1 : Integer.MIN_VALUE : (this.mOrientation != 1 && isLayoutRTL()) ? -1 : 1 : (this.mOrientation != 1 && isLayoutRTL()) ? 1 : -1;
    }

    private View getChildClosestToStart() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : 0);
    }

    private View getChildClosestToEnd() {
        return getChildAt(this.mShouldReverseLayout ? 0 : getChildCount() - 1);
    }

    private View findFirstVisibleChildClosestToStart(boolean z, boolean z2) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(getChildCount() - 1, -1, z, z2);
        }
        return findOneVisibleChild(0, getChildCount(), z, z2);
    }

    private View findFirstVisibleChildClosestToEnd(boolean z, boolean z2) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(0, getChildCount(), z, z2);
        }
        return findOneVisibleChild(getChildCount() - 1, -1, z, z2);
    }

    private View findReferenceChildClosestToEnd(aj.p pVar, aj.u uVar) {
        return this.mShouldReverseLayout ? findFirstReferenceChild(pVar, uVar) : findLastReferenceChild(pVar, uVar);
    }

    private View findReferenceChildClosestToStart(aj.p pVar, aj.u uVar) {
        return this.mShouldReverseLayout ? findLastReferenceChild(pVar, uVar) : findFirstReferenceChild(pVar, uVar);
    }

    private View findFirstReferenceChild(aj.p pVar, aj.u uVar) {
        return findReferenceChild(pVar, uVar, 0, getChildCount(), uVar.getItemCount());
    }

    private View findLastReferenceChild(aj.p pVar, aj.u uVar) {
        return findReferenceChild(pVar, uVar, getChildCount() - 1, -1, uVar.getItemCount());
    }

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
            if (position >= 0 && position < i3) {
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

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd(aj.p pVar, aj.u uVar) {
        return this.mShouldReverseLayout ? findFirstPartiallyOrCompletelyInvisibleChild(pVar, uVar) : findLastPartiallyOrCompletelyInvisibleChild(pVar, uVar);
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart(aj.p pVar, aj.u uVar) {
        return this.mShouldReverseLayout ? findLastPartiallyOrCompletelyInvisibleChild(pVar, uVar) : findFirstPartiallyOrCompletelyInvisibleChild(pVar, uVar);
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild(aj.p pVar, aj.u uVar) {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild(aj.p pVar, aj.u uVar) {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    public int findFirstVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    View findOneVisibleChild(int i, int i2, boolean z, boolean z2) {
        ensureLayoutState();
        int i3 = z ? 24579 : 320;
        int i4 = z2 ? 320 : 0;
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.e(i, i2, i3, i4);
        }
        return this.mVerticalBoundCheck.e(i, i2, i3, i4);
    }

    View findOnePartiallyOrCompletelyInvisibleChild(int i, int i2) {
        int i3;
        int i4;
        ensureLayoutState();
        if ((i2 > i ? (char) 1 : i2 < i ? (char) 65535 : (char) 0) == 0) {
            return getChildAt(i);
        }
        if (this.mOrientationHelper.M(getChildAt(i)) < this.mOrientationHelper.dE()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.e(i, i2, i3, i4);
        }
        return this.mVerticalBoundCheck.e(i, i2, i3, i4);
    }

    @Override // android.support.v7.widget.aj.i
    public View onFocusSearchFailed(View view, int i, aj.p pVar, aj.u uVar) {
        int iConvertFocusDirectionToLayoutDirection;
        View viewFindPartiallyOrCompletelyInvisibleChildClosestToEnd;
        View childClosestToEnd;
        resolveShouldLayoutReverse();
        if (getChildCount() == 0 || (iConvertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        ensureLayoutState();
        updateLayoutState(iConvertFocusDirectionToLayoutDirection, (int) (this.mOrientationHelper.dG() * MAX_SCROLL_FACTOR), false, uVar);
        c cVar = this.mLayoutState;
        cVar.qw = Integer.MIN_VALUE;
        cVar.pS = false;
        fill(pVar, cVar, uVar, true);
        if (iConvertFocusDirectionToLayoutDirection == -1) {
            viewFindPartiallyOrCompletelyInvisibleChildClosestToEnd = findPartiallyOrCompletelyInvisibleChildClosestToStart(pVar, uVar);
        } else {
            viewFindPartiallyOrCompletelyInvisibleChildClosestToEnd = findPartiallyOrCompletelyInvisibleChildClosestToEnd(pVar, uVar);
        }
        if (iConvertFocusDirectionToLayoutDirection == -1) {
            childClosestToEnd = getChildClosestToStart();
        } else {
            childClosestToEnd = getChildClosestToEnd();
        }
        if (!childClosestToEnd.hasFocusable()) {
            return viewFindPartiallyOrCompletelyInvisibleChildClosestToEnd;
        }
        if (viewFindPartiallyOrCompletelyInvisibleChildClosestToEnd == null) {
            return null;
        }
        return childClosestToEnd;
    }

    private void logChildren() {
        Log.d(TAG, "internal representation of views on the screen");
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            Log.d(TAG, "item " + getPosition(childAt) + ", coord:" + this.mOrientationHelper.M(childAt));
        }
        Log.d(TAG, "==============");
    }

    void validateChildOrder() {
        Log.d(TAG, "validating child count " + getChildCount());
        if (getChildCount() <= 0) {
            return;
        }
        int position = getPosition(getChildAt(0));
        int iM = this.mOrientationHelper.M(getChildAt(0));
        if (this.mShouldReverseLayout) {
            for (int i = 1; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                int position2 = getPosition(childAt);
                int iM2 = this.mOrientationHelper.M(childAt);
                if (position2 < position) {
                    logChildren();
                    StringBuilder sb = new StringBuilder("detected invalid position. loc invalid? ");
                    sb.append(iM2 < iM);
                    throw new RuntimeException(sb.toString());
                }
                if (iM2 > iM) {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                }
            }
            return;
        }
        for (int i2 = 1; i2 < getChildCount(); i2++) {
            View childAt2 = getChildAt(i2);
            int position3 = getPosition(childAt2);
            int iM3 = this.mOrientationHelper.M(childAt2);
            if (position3 < position) {
                logChildren();
                StringBuilder sb2 = new StringBuilder("detected invalid position. loc invalid? ");
                sb2.append(iM3 < iM);
                throw new RuntimeException(sb2.toString());
            }
            if (iM3 < iM) {
                logChildren();
                throw new RuntimeException("detected invalid location");
            }
        }
    }

    @Override // android.support.v7.widget.aj.i
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }

    public void prepareForDrop(View view, View view2, int i, int i2) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        char c2 = position < position2 ? (char) 1 : (char) 65535;
        if (this.mShouldReverseLayout) {
            if (c2 == 1) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.dF() - (this.mOrientationHelper.M(view2) + this.mOrientationHelper.Q(view)));
                return;
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.dF() - this.mOrientationHelper.N(view2));
                return;
            }
        }
        if (c2 == 65535) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.M(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.N(view2) - this.mOrientationHelper.Q(view));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static class c {
        int bV;
        int fx;
        int mCurrentPosition;
        int pT;
        int pU;
        boolean pY;
        int qw;
        int qz;
        boolean pS = true;
        int qx = 0;
        boolean qy = false;
        List<aj.x> qA = null;

        c() {
        }

        final boolean a(aj.u uVar) {
            int i = this.mCurrentPosition;
            return i >= 0 && i < uVar.getItemCount();
        }

        final View a(aj.p pVar) {
            if (this.qA != null) {
                return dw();
            }
            View viewAu = pVar.au(this.mCurrentPosition);
            this.mCurrentPosition += this.pU;
            return viewAu;
        }

        private View dw() {
            int size = this.qA.size();
            for (int i = 0; i < size; i++) {
                View view = this.qA.get(i).itemView;
                aj.j jVar = (aj.j) view.getLayoutParams();
                if (!jVar.dS() && this.mCurrentPosition == jVar.dU()) {
                    K(view);
                    return view;
                }
            }
            return null;
        }

        public final void dx() {
            K(null);
        }

        private void K(View view) {
            View viewL = L(view);
            if (viewL == null) {
                this.mCurrentPosition = -1;
            } else {
                this.mCurrentPosition = ((aj.j) viewL.getLayoutParams()).dU();
            }
        }

        private View L(View view) {
            int iDU;
            int size = this.qA.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.qA.get(i2).itemView;
                aj.j jVar = (aj.j) view3.getLayoutParams();
                if (view3 != view && !jVar.dS() && (iDU = (jVar.dU() - this.mCurrentPosition) * this.pU) >= 0 && iDU < i) {
                    view2 = view3;
                    if (iDU == 0) {
                        break;
                    }
                    i = iDU;
                }
            }
            return view2;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new Parcelable.Creator<d>() { // from class: android.support.v7.widget.LinearLayoutManager.d.1
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ d createFromParcel(Parcel parcel) {
                return c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ d[] newArray(int i) {
                return ao(i);
            }

            private static d c(Parcel parcel) {
                return new d(parcel);
            }

            private static d[] ao(int i) {
                return new d[i];
            }
        };
        int qB;
        int qC;
        boolean qD;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public d() {
        }

        d(Parcel parcel) {
            this.qB = parcel.readInt();
            this.qC = parcel.readInt();
            this.qD = parcel.readInt() == 1;
        }

        public d(d dVar) {
            this.qB = dVar.qB;
            this.qC = dVar.qC;
            this.qD = dVar.qD;
        }

        final boolean dy() {
            return this.qB >= 0;
        }

        final void dz() {
            this.qB = -1;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.qB);
            parcel.writeInt(this.qC);
            parcel.writeInt(this.qD ? 1 : 0);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static class a {
        ai mOrientationHelper;
        int mPosition;
        int qo;
        boolean qp;
        boolean qq;

        a() {
            reset();
        }

        final void reset() {
            this.mPosition = -1;
            this.qo = Integer.MIN_VALUE;
            this.qp = false;
            this.qq = false;
        }

        final void dv() {
            int iDE;
            if (this.qp) {
                iDE = this.mOrientationHelper.dF();
            } else {
                iDE = this.mOrientationHelper.dE();
            }
            this.qo = iDE;
        }

        public final String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.qo + ", mLayoutFromEnd=" + this.qp + ", mValid=" + this.qq + '}';
        }

        static boolean a(View view, aj.u uVar) {
            aj.j jVar = (aj.j) view.getLayoutParams();
            return !jVar.dS() && jVar.dU() >= 0 && jVar.dU() < uVar.getItemCount();
        }

        public final void g(View view, int i) {
            int iDD = this.mOrientationHelper.dD();
            if (iDD >= 0) {
                h(view, i);
                return;
            }
            this.mPosition = i;
            if (this.qp) {
                int iDF = (this.mOrientationHelper.dF() - iDD) - this.mOrientationHelper.N(view);
                this.qo = this.mOrientationHelper.dF() - iDF;
                if (iDF > 0) {
                    int iQ = this.qo - this.mOrientationHelper.Q(view);
                    int iDE = this.mOrientationHelper.dE();
                    int iMin = iQ - (iDE + Math.min(this.mOrientationHelper.M(view) - iDE, 0));
                    if (iMin < 0) {
                        this.qo += Math.min(iDF, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iM = this.mOrientationHelper.M(view);
            int iDE2 = iM - this.mOrientationHelper.dE();
            this.qo = iM;
            if (iDE2 > 0) {
                int iDF2 = (this.mOrientationHelper.dF() - Math.min(0, (this.mOrientationHelper.dF() - iDD) - this.mOrientationHelper.N(view))) - (iM + this.mOrientationHelper.Q(view));
                if (iDF2 < 0) {
                    this.qo -= Math.min(iDE2, -iDF2);
                }
            }
        }

        public final void h(View view, int i) {
            if (this.qp) {
                this.qo = this.mOrientationHelper.N(view) + this.mOrientationHelper.dD();
            } else {
                this.qo = this.mOrientationHelper.M(view);
            }
            this.mPosition = i;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    protected static class b {
        public int qr;
        public boolean qt;
        public boolean qu;
        public boolean qv;

        protected b() {
        }

        final void resetInternal() {
            this.qr = 0;
            this.qt = false;
            this.qu = false;
            this.qv = false;
        }
    }
}

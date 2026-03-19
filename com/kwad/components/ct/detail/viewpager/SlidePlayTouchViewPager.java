package com.kwad.components.ct.detail.viewpager;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class SlidePlayTouchViewPager extends e {
    private int azR;
    protected boolean azS;
    protected boolean azT;
    protected com.kwad.components.ct.refreshview.e azU;
    private boolean azV;
    private boolean azW;
    private BitSet azX;
    private List<a> azY;
    private float jn;
    private float jo;
    protected boolean mEnabled;

    public enum TargetBoundUpdatedType {
        ON_SCROLL_END,
        ON_MOVE_TO_NEXT,
        ON_MOVE_TO_PRE,
        RESET
    }

    public interface a {
        void Cp();

        void Cq();
    }

    protected int getFirstValidItemPosition() {
        return 0;
    }

    public SlidePlayTouchViewPager(Context context) {
        this(context, null);
    }

    public SlidePlayTouchViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azX = new BitSet();
        this.mEnabled = true;
        this.azY = new ArrayList();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        h(z, 1);
    }

    public final boolean CU() {
        return !this.mEnabled;
    }

    public final void CV() {
        this.azX.clear();
        this.mEnabled = this.azX.cardinality() == 0;
    }

    public final void h(boolean z, int i) {
        com.kwad.sdk.core.d.c.d("SlidePlayTouchViewPager", "enable:" + z + ";flag:" + i);
        if (z) {
            this.azX.clear(i);
        } else {
            this.azX.set(i);
        }
        this.mEnabled = this.azX.cardinality() == 0;
    }

    public final void a(a aVar) {
        if (this.azY.contains(aVar)) {
            return;
        }
        this.azY.add(aVar);
    }

    public final void b(a aVar) {
        this.azY.remove(aVar);
    }

    public final void a(TargetBoundUpdatedType targetBoundUpdatedType) {
        if (targetBoundUpdatedType == TargetBoundUpdatedType.ON_SCROLL_END) {
            this.azR = getScrollY();
            return;
        }
        if (targetBoundUpdatedType == TargetBoundUpdatedType.RESET) {
            this.azR = 0;
        } else if (targetBoundUpdatedType == TargetBoundUpdatedType.ON_MOVE_TO_NEXT) {
            this.azR += getHeight();
        } else {
            this.azR -= getHeight();
        }
    }

    protected int getLastValidItemPosition() {
        return getAdapter().getCount() - 1;
    }

    @Override // com.kwad.components.ct.detail.viewpager.e
    protected final int bV(int i) {
        if (getCurrentItem() <= getFirstValidItemPosition()) {
            int i2 = this.azR;
            if (i - i2 < 0) {
                return i2;
            }
        }
        if (getCurrentItem() >= getLastValidItemPosition()) {
            int i3 = this.azR;
            if (i - i3 > 0) {
                return i3;
            }
        }
        return super.bV(i);
    }

    @Override // com.kwad.components.ct.detail.viewpager.e
    protected final int a(int i, float f, int i2, int i3) {
        return Math.max(Math.min(super.a(i, f, i2, i3), getLastValidItemPosition()), getFirstValidItemPosition());
    }

    @Override // com.kwad.components.ct.detail.viewpager.e
    protected final void CW() {
        super.CW();
        a(TargetBoundUpdatedType.ON_SCROLL_END);
    }

    @Override // com.kwad.components.ct.detail.viewpager.e
    public void setAdapter(PagerAdapter pagerAdapter) throws Resources.NotFoundException {
        super.setAdapter(pagerAdapter);
        a(TargetBoundUpdatedType.RESET);
    }

    @Override // com.kwad.components.ct.detail.viewpager.e
    protected final void a(int i, boolean z, boolean z2) throws Resources.NotFoundException {
        super.a(i, z, z2);
        a(TargetBoundUpdatedType.RESET);
    }

    @Override // com.kwad.components.ct.detail.viewpager.e, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (CY()) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        b(motionEvent);
        if (action == 2) {
            float fAbs = Math.abs(motionEvent.getX() - this.jn);
            float y = motionEvent.getY();
            float f = this.jo;
            float f2 = y - f;
            float fAbs2 = Math.abs(y - f);
            if (getCurrentItem() == getFirstValidItemPosition() && f2 > this.mTouchSlop && fAbs2 * 0.5f > fAbs) {
                this.azV = true;
                com.kwad.components.ct.refreshview.e eVar = this.azU;
                if (eVar != null && this.azS) {
                    eVar.i(motionEvent);
                }
                return true;
            }
            if (getCurrentItem() == getLastValidItemPosition() && f2 < (-this.mTouchSlop) && fAbs2 * 0.5f > fAbs) {
                this.azW = true;
                return true;
            }
        }
        com.kwad.components.ct.refreshview.e eVar2 = this.azU;
        if (eVar2 != null && this.azS) {
            eVar2.i(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009a  */
    @Override // com.kwad.components.ct.detail.viewpager.e, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r9) throws android.content.res.Resources.NotFoundException {
        /*
            r8 = this;
            boolean r0 = r8.CY()
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            int r0 = r9.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r8.b(r9)
            r2 = 1
            if (r0 == 0) goto L1e
            if (r0 == r2) goto L1a
            r1 = 2
            if (r0 == r1) goto L22
            goto L82
        L1a:
            r8.f(r9)
            goto L82
        L1e:
            r8.azW = r1
            r8.azV = r1
        L22:
            float r1 = r9.getX()
            float r3 = r8.jn
            float r1 = r1 - r3
            float r1 = java.lang.Math.abs(r1)
            float r3 = r9.getY()
            float r4 = r8.jo
            float r5 = r3 - r4
            float r3 = r3 - r4
            float r3 = java.lang.Math.abs(r3)
            int r4 = r8.getCurrentItem()
            int r6 = r8.getFirstValidItemPosition()
            r7 = 1056964608(0x3f000000, float:0.5)
            if (r4 != r6) goto L69
            int r4 = r8.mTouchSlop
            float r4 = (float) r4
            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r4 <= 0) goto L55
            float r4 = r3 * r7
            int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r4 <= 0) goto L55
            r8.azV = r2
        L55:
            boolean r4 = r8.azV
            if (r4 != 0) goto L69
            r4 = 0
            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r4 <= 0) goto L69
            com.kwad.components.ct.refreshview.e r4 = r8.azU
            if (r4 == 0) goto L69
            boolean r6 = r8.azS
            if (r6 == 0) goto L69
            r4.j(r9)
        L69:
            int r4 = r8.getCurrentItem()
            int r6 = r8.getLastValidItemPosition()
            if (r4 != r6) goto L82
            int r4 = r8.mTouchSlop
            int r4 = -r4
            float r4 = (float) r4
            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r4 >= 0) goto L82
            float r3 = r3 * r7
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 <= 0) goto L82
            r8.azW = r2
        L82:
            boolean r1 = r8.azV
            if (r1 == 0) goto L9a
            if (r0 == r2) goto L8b
            r1 = 3
            if (r0 != r1) goto L8e
        L8b:
            r8.CX()
        L8e:
            com.kwad.components.ct.refreshview.e r0 = r8.azU
            if (r0 == 0) goto L99
            boolean r1 = r8.azS
            if (r1 == 0) goto L99
            r0.j(r9)
        L99:
            return r2
        L9a:
            boolean r1 = r8.azW
            if (r1 == 0) goto La4
            if (r0 != r2) goto La3
            super.onTouchEvent(r9)
        La3:
            return r2
        La4:
            boolean r9 = super.onTouchEvent(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ct.detail.viewpager.SlidePlayTouchViewPager.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void b(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return;
        }
        this.jn = motionEvent.getX();
        this.jo = motionEvent.getY();
        this.azW = false;
        this.azV = false;
    }

    private void CX() {
        this.azV = false;
    }

    private void f(MotionEvent motionEvent) {
        if (this.azT) {
            float fAbs = Math.abs(motionEvent.getX() - this.jn);
            float y = motionEvent.getY();
            float fAbs2 = Math.abs(y - this.jo);
            if (fAbs2 <= this.mTouchSlop || fAbs2 * 0.5f <= fAbs) {
                return;
            }
            if (!this.azS && y > this.jo && getCurrentItem() == getFirstValidItemPosition()) {
                Iterator<a> it = this.azY.iterator();
                while (it.hasNext()) {
                    it.next().Cp();
                }
            } else {
                if (getCurrentItem() != getLastValidItemPosition() || y >= this.jo) {
                    return;
                }
                Iterator<a> it2 = this.azY.iterator();
                while (it2.hasNext()) {
                    it2.next().Cq();
                }
            }
        }
    }

    private boolean CY() {
        return !this.mEnabled || getAdapter() == null;
    }
}

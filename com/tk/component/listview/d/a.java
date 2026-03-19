package com.tk.component.listview.d;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.al;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.animation.LinearInterpolator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends al {
    private long TN;
    private long TO;
    private boolean TP;
    private boolean TQ;
    private boolean TR;
    private float TS;
    private float TT;
    private int TU;
    private float TV;
    private float TW;
    private int TX;
    private com.tk.component.listview.a TY;
    private com.tk.component.listview.b.a TZ;
    private int[] Ua;
    private al.i mLayoutManager;
    private LinearInterpolator rA;

    public a(Context context) {
        super(context);
        this.TN = 400L;
        this.TO = -1L;
        this.TP = true;
        this.TQ = false;
        this.TR = false;
        this.TX = 0;
        d(context);
    }

    private void d(Context context) {
        setOverScrollMode(2);
        setClipToPadding(false);
        this.TU = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public final void setLayoutManager(al.i iVar) {
        super.setLayoutManager(iVar);
        this.mLayoutManager = iVar;
        this.TV = 0.0f;
        this.TW = 0.0f;
    }

    public final void setItemDecoration(com.tk.component.listview.b.a aVar) {
        com.tk.component.listview.b.a aVar2 = this.TZ;
        if (aVar2 != null) {
            b(aVar2);
        }
        this.TZ = aVar;
        if (aVar != null) {
            a(aVar);
        }
    }

    public final com.tk.component.listview.b.a getItemDecoration() {
        return this.TZ;
    }

    public final void setScrollEnable(boolean z) {
        this.TP = z;
    }

    public final void setOnProgressUpdatedEventEnable(boolean z) {
        this.TQ = z;
    }

    public final void setOnScrolledEventEnable(boolean z) {
        this.TR = z;
    }

    public final void setScrollListener(com.tk.component.listview.a aVar) {
        this.TY = aVar;
    }

    public final void setScrollEventThrottle(long j) {
        this.TN = j;
    }

    public final int getScrollState() {
        return this.TX;
    }

    public final void X(int i, int i2) {
        if (this.TY == null) {
            return;
        }
        if (this.TR || this.TQ) {
            if (this.TR) {
                this.TV += i;
                this.TW += i2;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.TO < this.TN) {
                return;
            }
            if (this.TQ) {
                nH();
            }
            if (this.TR && (this.TV != 0.0f || this.TW != 0.0f)) {
                this.TY.q(this.TV, this.TW);
                this.TV = 0.0f;
                this.TW = 0.0f;
            }
            this.TO = jCurrentTimeMillis;
        }
    }

    public final void aB(int i) {
        super.aB(i);
        this.TX = i;
        if (i == 0) {
            nH();
            if (this.TY != null && this.TR && (this.TV != 0.0f || this.TW != 0.0f)) {
                this.TY.q(this.TV, this.TW);
                this.TV = 0.0f;
                this.TW = 0.0f;
            }
        }
        com.tk.component.listview.a aVar = this.TY;
        if (aVar != null) {
            aVar.aB(i);
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.TP) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.TP) {
            return false;
        }
        al.i iVar = this.mLayoutManager;
        if (iVar != null && iVar.dn()) {
            int action = motionEvent.getAction();
            float y = motionEvent.getY();
            float x = motionEvent.getX();
            if (action == 0) {
                this.TS = y;
                this.TT = x;
            } else if (action == 2 && Math.abs(x - this.TT) / Math.abs(y - this.TS) > 1.0f && Math.abs(x - this.TT) > this.TU) {
                return false;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        nH();
    }

    private int dd(int i) {
        if (getItemDecoration() != null) {
            return getItemDecoration().e(this, i);
        }
        return 0;
    }

    private int de(int i) {
        if (getItemDecoration() != null) {
            return getItemDecoration().q(this);
        }
        return 0;
    }

    public final void ar(int i) {
        N(i, 0);
    }

    public final void N(int i, int i2) {
        dX();
        Object obj = this.mLayoutManager;
        if (obj instanceof com.tk.component.listview.layoutmanager.a) {
            ((com.tk.component.listview.layoutmanager.a) obj).N(i, i2 - dd(i));
            awakenScrollBars();
        }
    }

    public final void smoothScrollToPosition(int i, int i2) {
        k(i, 0, i2);
    }

    public final void k(int i, int i2, int i3) {
        Object obj = this.mLayoutManager;
        if (obj instanceof com.tk.component.listview.layoutmanager.a) {
            ((com.tk.component.listview.layoutmanager.a) obj).bC(i2 - dd(i));
            ((com.tk.component.listview.layoutmanager.a) this.mLayoutManager).setDuration(i3);
        }
        super.smoothScrollToPosition(i);
    }

    public final void aL(int i, int i2) {
        if (this.mLayoutManager instanceof com.tk.component.listview.layoutmanager.a) {
            ((com.tk.component.listview.layoutmanager.a) this.mLayoutManager).bC(-((dd(i) - de(i)) / 2));
            ((com.tk.component.listview.layoutmanager.a) this.mLayoutManager).gO();
            ((com.tk.component.listview.layoutmanager.a) this.mLayoutManager).setDuration(i2);
        }
        super.smoothScrollToPosition(i);
    }

    public final void b(int i, int i2, int i3, boolean z) {
        dX();
        if (z && this.rA == null) {
            this.rA = new LinearInterpolator();
        }
        super.a(i, i2, z ? this.rA : null);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void nH() {
        /*
            r4 = this;
            boolean r0 = r4.TQ
            if (r0 == 0) goto L53
            com.tk.component.listview.a r0 = r4.TY
            if (r0 != 0) goto L9
            goto L53
        L9:
            android.support.v7.widget.al$i r0 = r4.mLayoutManager
            if (r0 != 0) goto Le
            return
        Le:
            boolean r0 = r0.dm()
            r1 = 0
            if (r0 == 0) goto L25
            int r0 = r4.computeHorizontalScrollOffset()
            float r0 = (float) r0
            int r2 = r4.computeHorizontalScrollRange()
            int r3 = r4.getWidth()
        L22:
            int r2 = r2 - r3
            float r2 = (float) r2
            goto L3d
        L25:
            android.support.v7.widget.al$i r0 = r4.mLayoutManager
            boolean r0 = r0.dn()
            if (r0 == 0) goto L3b
            int r0 = r4.computeVerticalScrollOffset()
            float r0 = (float) r0
            int r2 = r4.computeVerticalScrollRange()
            int r3 = r4.getHeight()
            goto L22
        L3b:
            r0 = 0
            r2 = 0
        L3d:
            int r3 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r3 != 0) goto L43
            r0 = 0
            goto L44
        L43:
            float r0 = r0 / r2
        L44:
            r2 = 1065353216(0x3f800000, float:1.0)
            float r0 = java.lang.Math.max(r1, r0)
            float r0 = java.lang.Math.min(r2, r0)
            com.tk.component.listview.a r1 = r4.TY
            r1.p(r0)
        L53:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.listview.d.a.nH():void");
    }

    private int[] getTempVisibleArray() {
        Object obj = this.mLayoutManager;
        if (!(obj instanceof StaggeredGridLayoutManager)) {
            return null;
        }
        int iDg = ((StaggeredGridLayoutManager) obj).dg();
        int[] iArr = this.Ua;
        if (iArr == null || iArr.length != iDg) {
            this.Ua = new int[iDg];
        }
        return this.Ua;
    }

    public final int nI() {
        Object obj = this.mLayoutManager;
        if (obj == null) {
            return -1;
        }
        if (obj instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) obj).dx();
        }
        if (!(obj instanceof StaggeredGridLayoutManager)) {
            return -1;
        }
        int i = -1;
        for (int i2 : ((StaggeredGridLayoutManager) obj).f(getTempVisibleArray())) {
            if (i == -1 || (i2 >= 0 && i2 < i)) {
                i = i2;
            }
        }
        return i;
    }

    public final int nJ() {
        Object obj = this.mLayoutManager;
        if (obj == null) {
            return -1;
        }
        if (obj instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) obj).dy();
        }
        if (!(obj instanceof StaggeredGridLayoutManager)) {
            return -1;
        }
        int i = -1;
        for (int i2 : ((StaggeredGridLayoutManager) obj).g(getTempVisibleArray())) {
            if (i == -1 || (i2 >= 0 && i2 > i)) {
                i = i2;
            }
        }
        return i;
    }
}

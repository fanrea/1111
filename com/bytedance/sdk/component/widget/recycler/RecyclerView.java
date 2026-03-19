package com.bytedance.sdk.component.widget.recycler;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.location.LocationRequestCompat;
import com.alipay.sdk.m.u.i;
import com.bytedance.sdk.component.widget.recycler.c;
import com.bytedance.sdk.component.widget.recycler.d;
import com.bytedance.sdk.component.widget.recycler.hc;
import com.bytedance.sdk.component.widget.recycler.k;
import com.bytedance.sdk.component.widget.recycler.uo;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ss.ttm.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class RecyclerView extends ViewGroup implements com.bytedance.sdk.component.widget.recycler.d.b.b {
    static final boolean b;
    static final boolean c;
    static final boolean d;
    private static final boolean dc;
    static final boolean hc;
    private static final Class<?>[] nv;
    static final Interpolator r;
    private static final boolean tr;
    com.bytedance.sdk.component.widget.recycler.d an;
    private VelocityTracker ar;
    final int[] ba;
    final ArrayList<gb> cb;
    boolean de;
    private EdgeEffect dz;
    w e;
    private int ey;
    private com.bytedance.sdk.component.widget.recycler.d.b.c f;
    final int[] fs;
    private int fu;
    private float fv;
    private final int fy;
    final com.bytedance.sdk.component.widget.recycler.k gb;
    private int gv;
    private mq gw;
    com.bytedance.sdk.component.widget.recycler.hc h;
    final de he;
    private EdgeEffect i;
    private u ia;
    final jh j;
    boolean jh;
    private List<k> js;
    tt k;
    private k kb;
    private boolean l;
    private c mb;
    final Rect mk;
    final RectF mq;
    final List<v> mt;
    private int nf;
    boolean np;
    private EdgeEffect nr;
    private EdgeEffect nw;
    private final int[] o;
    private final int[] oc;
    private final k.hc ox;
    private int ph;
    private boolean pq;
    private final ArrayList<uo> q;
    private int qr;
    private int qy;
    private int ra;
    boolean rf;
    private final int[] rs;
    private uo ru;
    private int rw;
    boolean s;
    boolean sy;
    private int t;
    final Runnable tc;
    private Runnable tj;
    private List<mk> to;
    boolean tt;
    final cb u;
    private float um;
    d uo;
    boolean us;
    boolean v;
    com.bytedance.sdk.component.widget.recycler.c vv;
    boolean w;
    private an.d wb;
    private final Rect wl;
    private final AccessibilityManager xp;
    private final yo y;
    an yi;
    private int yn;
    boolean yo;
    boolean z;
    private final int zv;
    c.d zw;
    private static final int[] hv = {R.attr.nestedScrollingEnabled};
    private static final int[] bc = {R.attr.clipToPadding};

    public static abstract class b {
        public void d() {
        }

        public void d(int i, int i2, Object obj) {
        }
    }

    public interface c {
        int d(int i, int i2);
    }

    public static abstract class k {
        public void d(RecyclerView recyclerView, int i) {
        }

        public void d(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public interface mk {
        void d(View view);

        void hc(View view);
    }

    public static abstract class mq {
        public abstract boolean d(int i, int i2);
    }

    public static abstract class sy {
        public abstract View d(cb cbVar, int i, int i2);
    }

    public interface uo {
        boolean d(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public interface w {
    }

    static {
        d = Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20;
        hc = Build.VERSION.SDK_INT >= 23;
        b = Build.VERSION.SDK_INT >= 16;
        c = Build.VERSION.SDK_INT >= 21;
        dc = Build.VERSION.SDK_INT <= 15;
        tr = Build.VERSION.SDK_INT <= 15;
        nv = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
        r = new Interpolator() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.6
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        };
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.y = new yo();
        this.u = new cb();
        this.gb = new com.bytedance.sdk.component.widget.recycler.k();
        this.tc = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!RecyclerView.this.rf || RecyclerView.this.isLayoutRequested()) {
                    return;
                }
                if (!RecyclerView.this.w) {
                    RecyclerView.this.requestLayout();
                } else if (RecyclerView.this.sy) {
                    RecyclerView.this.jh = true;
                } else {
                    RecyclerView.this.c();
                }
            }
        };
        this.mk = new Rect();
        this.wl = new Rect();
        this.mq = new RectF();
        this.cb = new ArrayList<>();
        this.q = new ArrayList<>();
        this.yn = 0;
        this.v = false;
        this.np = false;
        this.ra = 0;
        this.rw = 0;
        this.ia = new u();
        this.yi = new com.bytedance.sdk.component.widget.recycler.b();
        this.ey = 0;
        this.qr = -1;
        this.um = Float.MIN_VALUE;
        this.fv = Float.MIN_VALUE;
        this.pq = true;
        this.he = new de();
        this.zw = c ? new c.d() : null;
        this.j = new jh();
        this.s = false;
        this.us = false;
        this.wb = new h();
        this.z = false;
        this.o = new int[2];
        this.oc = new int[2];
        this.fs = new int[2];
        this.rs = new int[2];
        this.ba = new int[2];
        this.mt = new ArrayList();
        this.tj = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                if (RecyclerView.this.yi != null) {
                    RecyclerView.this.yi.d();
                }
                RecyclerView.this.z = false;
            }
        };
        this.ox = new k.hc() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.3
            @Override // com.bytedance.sdk.component.widget.recycler.k.hc
            public void d(v vVar, an.hc hcVar, an.hc hcVar2) {
                RecyclerView.this.u.b(vVar);
                RecyclerView.this.hc(vVar, hcVar, hcVar2);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.k.hc
            public void hc(v vVar, an.hc hcVar, an.hc hcVar2) {
                RecyclerView.this.d(vVar, hcVar, hcVar2);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.k.hc
            public void b(v vVar, an.hc hcVar, an.hc hcVar2) {
                vVar.d(false);
                if (RecyclerView.this.v) {
                    if (RecyclerView.this.yi.d(vVar, vVar, hcVar, hcVar2)) {
                        RecyclerView.this.e();
                    }
                } else if (RecyclerView.this.yi.b(vVar, hcVar, hcVar2)) {
                    RecyclerView.this.e();
                }
            }

            @Override // com.bytedance.sdk.component.widget.recycler.k.hc
            public void d(v vVar) {
                RecyclerView.this.k.d(vVar.d, RecyclerView.this.u);
            }
        };
        if (attributeSet != null) {
            try {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, bc, i, 0);
                this.tt = typedArrayObtainStyledAttributes.getBoolean(0, true);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Exception e2) {
                com.bytedance.sdk.component.utils.mq.d(e2);
            }
        } else {
            this.tt = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.nf = viewConfiguration.getScaledTouchSlop();
        this.um = com.bytedance.sdk.component.widget.recycler.d.b.h.d(viewConfiguration, context);
        this.fv = com.bytedance.sdk.component.widget.recycler.d.b.h.hc(viewConfiguration, context);
        this.fy = viewConfiguration.getScaledMinimumFlingVelocity();
        this.zv = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.yi.d(this.wb);
        hc();
        yi();
        np();
        if (com.bytedance.sdk.component.widget.recycler.d.b.h.hc(this) == 0) {
            com.bytedance.sdk.component.widget.recycler.d.b.h.d(this, 1);
        }
        this.xp = (AccessibilityManager) getContext().getSystemService("accessibility");
        try {
            if (attributeSet != null) {
                setDescendantFocusability(262144);
                int i2 = Build.VERSION.SDK_INT;
            } else {
                setDescendantFocusability(262144);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
        setNestedScrollingEnabled(true);
    }

    String d() {
        return " " + super.toString() + ", adapter:" + this.uo + ", layout:" + this.k + ", context:" + getContext();
    }

    private void np() {
        if (com.bytedance.sdk.component.widget.recycler.d.b.h.tt(this) == 0) {
            com.bytedance.sdk.component.widget.recycler.d.b.h.hc(this, 8);
        }
    }

    private void yi() {
        this.h = new com.bytedance.sdk.component.widget.recycler.hc(new hc.InterfaceC0290hc() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.4
            @Override // com.bytedance.sdk.component.widget.recycler.hc.InterfaceC0290hc
            public int d() {
                return RecyclerView.this.getChildCount();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.hc.InterfaceC0290hc
            public void d(View view, int i) {
                RecyclerView.this.addView(view, i);
                RecyclerView.this.mq(view);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.hc.InterfaceC0290hc
            public int d(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.hc.InterfaceC0290hc
            public void d(int i) {
                View childAt = RecyclerView.this.getChildAt(i);
                if (childAt != null) {
                    RecyclerView.this.mk(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.hc.InterfaceC0290hc
            public View hc(int i) {
                return RecyclerView.this.getChildAt(i);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.hc.InterfaceC0290hc
            public void hc() {
                int iD = d();
                for (int i = 0; i < iD; i++) {
                    View viewHc = hc(i);
                    RecyclerView.this.mk(viewHc);
                    viewHc.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            @Override // com.bytedance.sdk.component.widget.recycler.hc.InterfaceC0290hc
            public v hc(View view) {
                return RecyclerView.u(view);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.hc.InterfaceC0290hc
            public void d(View view, int i, ViewGroup.LayoutParams layoutParams) {
                v vVarU = RecyclerView.u(view);
                if (vVarU != null) {
                    if (!vVarU.yo() && !vVarU.L_()) {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + vVarU + RecyclerView.this.d());
                    }
                    vVarU.uo();
                }
                RecyclerView.this.attachViewToParent(view, i, layoutParams);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.hc.InterfaceC0290hc
            public void b(int i) {
                v vVarU;
                View viewHc = hc(i);
                if (viewHc != null && (vVarU = RecyclerView.u(viewHc)) != null) {
                    if (vVarU.yo() && !vVarU.L_()) {
                        throw new IllegalArgumentException("called detach on an already detached child " + vVarU + RecyclerView.this.d());
                    }
                    vVarU.hc(256);
                }
                RecyclerView.this.detachViewFromParent(i);
            }

            @Override // com.bytedance.sdk.component.widget.recycler.hc.InterfaceC0290hc
            public void b(View view) {
                v vVarU = RecyclerView.u(view);
                if (vVarU != null) {
                    vVarU.d(RecyclerView.this);
                }
            }

            @Override // com.bytedance.sdk.component.widget.recycler.hc.InterfaceC0290hc
            public void c(View view) {
                v vVarU = RecyclerView.u(view);
                if (vVarU != null) {
                    vVarU.hc(RecyclerView.this);
                }
            }
        });
    }

    void hc() {
        this.an = new com.bytedance.sdk.component.widget.recycler.d(new d.InterfaceC0289d() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.5
            @Override // com.bytedance.sdk.component.widget.recycler.d.InterfaceC0289d
            public v d(int i) {
                v vVarD = RecyclerView.this.d(i, true);
                if (vVarD == null || RecyclerView.this.h.b(vVarD.d)) {
                    return null;
                }
                return vVarD;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.d.InterfaceC0289d
            public void d(int i, int i2) {
                RecyclerView.this.d(i, i2, true);
                RecyclerView.this.s = true;
                RecyclerView.this.j.b += i2;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.d.InterfaceC0289d
            public void hc(int i, int i2) {
                RecyclerView.this.d(i, i2, false);
                RecyclerView.this.s = true;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.d.InterfaceC0289d
            public void d(int i, int i2, Object obj) {
                RecyclerView.this.d(i, i2, obj);
                RecyclerView.this.us = true;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.d.InterfaceC0289d
            public void b(int i, int i2) {
                RecyclerView.this.h(i, i2);
                RecyclerView.this.s = true;
            }

            @Override // com.bytedance.sdk.component.widget.recycler.d.InterfaceC0289d
            public void c(int i, int i2) {
                RecyclerView.this.an(i, i2);
                RecyclerView.this.s = true;
            }
        });
    }

    public void setHasFixedSize(boolean z) {
        this.yo = z;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.tt) {
            mk();
        }
        this.tt = z;
        super.setClipToPadding(z);
        if (this.rf) {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.tt;
    }

    public void setAdapter(d dVar) {
        setLayoutFrozen(false);
        d(dVar, false, true);
        b(false);
        requestLayout();
    }

    void b() {
        an anVar = this.yi;
        if (anVar != null) {
            anVar.c();
        }
        tt ttVar = this.k;
        if (ttVar != null) {
            ttVar.b(this.u);
            this.k.hc(this.u);
        }
        this.u.d();
    }

    private void d(d dVar, boolean z, boolean z2) {
        d dVar2 = this.uo;
        if (dVar2 != null) {
            dVar2.hc(this.y);
        }
        if (!z || z2) {
            b();
        }
        this.an.d();
        d dVar3 = this.uo;
        this.uo = dVar;
        if (dVar != null) {
            dVar.d(this.y);
        }
        this.u.d(dVar3, this.uo, z);
        this.j.an = true;
    }

    public d getAdapter() {
        return this.uo;
    }

    public void setRecyclerListener(w wVar) {
        this.e = wVar;
    }

    @Override // android.view.View
    public int getBaseline() {
        tt ttVar = this.k;
        return ttVar != null ? ttVar.yo() : super.getBaseline();
    }

    public void d(mk mkVar) {
        if (this.to == null) {
            this.to = new ArrayList();
        }
        this.to.add(mkVar);
    }

    public void setLayoutManager(tt ttVar) {
        if (ttVar != this.k) {
            an();
            if (this.k != null) {
                an anVar = this.yi;
                if (anVar != null) {
                    anVar.c();
                }
                this.k.b(this.u);
                this.k.hc(this.u);
                this.u.d();
                if (this.w) {
                    this.k.hc(this, this.u);
                }
                this.k.d((RecyclerView) null);
                this.k = null;
            } else {
                this.u.d();
            }
            this.h.d();
            this.k = ttVar;
            if (ttVar != null) {
                if (ttVar.tt != null) {
                    throw new IllegalArgumentException("LayoutManager " + ttVar + " is already attached to a RecyclerView:" + ttVar.tt.d());
                }
                this.k.d(this);
                if (this.w) {
                    this.k.hc(this);
                }
            }
            this.u.hc();
            requestLayout();
        }
    }

    public void setOnFlingListener(mq mqVar) {
        this.gw = mqVar;
    }

    public mq getOnFlingListener() {
        return this.gw;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void u(v vVar) {
        View view = vVar.d;
        boolean z = view.getParent() == this;
        this.u.b(hc(view));
        if (vVar.yo()) {
            this.h.d(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.h.d(view, true);
        } else {
            this.h.c(view);
        }
    }

    boolean d(View view) {
        u();
        boolean zAn = this.h.an(view);
        if (zAn) {
            v vVarU = u(view);
            this.u.b(vVarU);
            this.u.hc(vVarU);
        }
        d(!zAn);
        return zAn;
    }

    public tt getLayoutManager() {
        return this.k;
    }

    public e getRecycledViewPool() {
        return this.u.h();
    }

    public void setRecycledViewPool(e eVar) {
        this.u.d(eVar);
    }

    public void setViewCacheExtension(sy syVar) {
        this.u.d(syVar);
    }

    public void setItemViewCacheSize(int i) {
        this.u.d(i);
    }

    public int getScrollState() {
        return this.ey;
    }

    void setScrollState(int i) {
        if (i != this.ey) {
            this.ey = i;
            if (i != 2) {
                vv();
            }
            h(i);
        }
    }

    public void d(gb gbVar, int i) {
        tt ttVar = this.k;
        if (ttVar != null) {
            ttVar.d("Cannot add item decoration during a scroll  or layout");
        }
        if (this.cb.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.cb.add(gbVar);
        } else {
            this.cb.add(i, gbVar);
        }
        w();
        requestLayout();
    }

    public void d(gb gbVar) {
        d(gbVar, -1);
    }

    public int getItemDecorationCount() {
        return this.cb.size();
    }

    public void setChildDrawingOrderCallback(c cVar) {
        if (cVar != this.mb) {
            this.mb = cVar;
            setChildrenDrawingOrderEnabled(cVar != null);
        }
    }

    public void d(k kVar) {
        if (this.js == null) {
            this.js = new ArrayList();
        }
        this.js.add(kVar);
    }

    public void hc(k kVar) {
        List<k> list = this.js;
        if (list != null) {
            list.remove(kVar);
        }
    }

    void d(int i) {
        tt ttVar = this.k;
        if (ttVar != null) {
            ttVar.c(i);
            awakenScrollBars();
        }
    }

    public void hc(int i) {
        if (this.sy) {
            return;
        }
        tt ttVar = this.k;
        if (ttVar == null) {
            com.bytedance.sdk.component.utils.mq.c("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            ttVar.d(this, this.j, i);
        }
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        tt ttVar = this.k;
        if (ttVar == null) {
            com.bytedance.sdk.component.utils.mq.c("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.sy) {
            return;
        }
        boolean zB = ttVar.b();
        boolean zC = this.k.c();
        if (zB || zC) {
            if (!zB) {
                i = 0;
            }
            if (!zC) {
                i2 = 0;
            }
            d(i, i2, (MotionEvent) null);
        }
    }

    void d(int i, int i2, int[] iArr) {
        u();
        mq();
        com.bytedance.sdk.component.widget.recycler.d.d.d.d("RV Scroll");
        d(this.j);
        int iD = i != 0 ? this.k.d(i, this.u, this.j) : 0;
        int iHc = i2 != 0 ? this.k.hc(i2, this.u, this.j) : 0;
        com.bytedance.sdk.component.widget.recycler.d.d.d.d();
        de();
        uo();
        d(false);
        if (iArr != null) {
            iArr[0] = iD;
            iArr[1] = iHc;
        }
    }

    void c() {
        if (this.rf && !this.v) {
            if (!this.an.c()) {
                return;
            }
            if (this.an.d(4) && !this.an.d(11)) {
                com.bytedance.sdk.component.widget.recycler.d.d.d.d("RV PartialInvalidate");
                u();
                mq();
                this.an.hc();
                if (!this.jh) {
                    if (he()) {
                        cb();
                    } else {
                        this.an.b();
                    }
                }
                d(true);
                uo();
                com.bytedance.sdk.component.widget.recycler.d.d.d.d();
                return;
            }
            if (!this.an.c()) {
                return;
            }
        }
        com.bytedance.sdk.component.widget.recycler.d.d.d.d("RV FullInvalidate");
        cb();
        com.bytedance.sdk.component.widget.recycler.d.d.d.d();
    }

    private boolean he() {
        int iHc = this.h.hc();
        for (int i = 0; i < iHc; i++) {
            v vVarU = u(this.h.hc(i));
            if (vVarU != null && !vVarU.L_() && vVarU.he()) {
                return true;
            }
        }
        return false;
    }

    boolean d(int i, int i2, MotionEvent motionEvent) {
        int i3;
        int i4;
        int i5;
        int i6;
        c();
        if (this.uo != null) {
            d(i, i2, this.ba);
            int[] iArr = this.ba;
            int i7 = iArr[0];
            int i8 = iArr[1];
            i4 = i8;
            i5 = i7;
            i6 = i - i7;
            i3 = i2 - i8;
        } else {
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        if (!this.cb.isEmpty()) {
            invalidate();
        }
        int i9 = i3;
        if (d(i5, i4, i6, i3, this.oc, 0)) {
            int i10 = this.gv;
            int[] iArr2 = this.oc;
            int i11 = iArr2[0];
            this.gv = i10 - i11;
            int i12 = this.qy;
            int i13 = iArr2[1];
            this.qy = i12 - i13;
            if (motionEvent != null) {
                motionEvent.offsetLocation(i11, i13);
            }
            int[] iArr3 = this.rs;
            int i14 = iArr3[0];
            int[] iArr4 = this.oc;
            iArr3[0] = i14 + iArr4[0];
            iArr3[1] = iArr3[1] + iArr4[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null && !com.bytedance.sdk.component.widget.recycler.d.b.h.d(motionEvent, 8194)) {
                d(motionEvent.getX(), i6, motionEvent.getY(), i9);
            }
            b(i, i2);
        }
        if (i5 != 0 || i4 != 0) {
            gb(i5, i4);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i5 == 0 && i4 == 0) ? false : true;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        tt ttVar = this.k;
        if (ttVar != null && ttVar.b()) {
            return this.k.b(this.j);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        tt ttVar = this.k;
        if (ttVar != null && ttVar.b()) {
            return this.k.u(this.j);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        tt ttVar = this.k;
        if (ttVar != null && ttVar.b()) {
            return this.k.h(this.j);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        tt ttVar = this.k;
        if (ttVar != null && ttVar.c()) {
            return this.k.c(this.j);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        tt ttVar = this.k;
        if (ttVar != null && ttVar.c()) {
            return this.k.an(this.j);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        tt ttVar = this.k;
        if (ttVar != null && ttVar.c()) {
            return this.k.gb(this.j);
        }
        return 0;
    }

    void u() {
        int i = this.yn + 1;
        this.yn = i;
        if (i != 1 || this.sy) {
            return;
        }
        this.jh = false;
    }

    void d(boolean z) {
        if (this.yn <= 0) {
            this.yn = 1;
        }
        if (!z && !this.sy) {
            this.jh = false;
        }
        if (this.yn == 1) {
            if (z && this.jh && !this.sy && this.k != null && this.uo != null) {
                cb();
            }
            if (!this.sy) {
                this.jh = false;
            }
        }
        this.yn--;
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.sy) {
            d("Do not setLayoutFrozen in layout or scroll");
            if (!z) {
                this.sy = false;
                if (this.jh && this.k != null && this.uo != null) {
                    requestLayout();
                }
                this.jh = false;
                return;
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
            this.sy = true;
            this.l = true;
            an();
        }
    }

    public void d(int i, int i2) {
        d(i, i2, (Interpolator) null);
    }

    public void d(int i, int i2, Interpolator interpolator) {
        tt ttVar = this.k;
        if (ttVar == null) {
            com.bytedance.sdk.component.utils.mq.c("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.sy) {
            return;
        }
        if (!ttVar.b()) {
            i = 0;
        }
        if (!this.k.c()) {
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        this.he.d(i, i2, interpolator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public boolean hc(int i, int i2) {
        tt ttVar = this.k;
        if (ttVar == null) {
            com.bytedance.sdk.component.utils.mq.c("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.sy) {
            return false;
        }
        int iB = ttVar.b();
        boolean zC = this.k.c();
        if (iB == 0 || Math.abs(i) < this.fy) {
            i = 0;
        }
        if (!zC || Math.abs(i2) < this.fy) {
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return false;
        }
        float f = i;
        float f2 = i2;
        if (!dispatchNestedPreFling(f, f2)) {
            boolean z = iB != 0 || zC;
            dispatchNestedFling(f, f2, z);
            mq mqVar = this.gw;
            if (mqVar != null && mqVar.d(i, i2)) {
                return true;
            }
            if (z) {
                if (zC) {
                    iB = (iB == true ? 1 : 0) | 2;
                }
                tt(iB, 1);
                int i3 = this.zv;
                int iMax = Math.max(-i3, Math.min(i, i3));
                int i4 = this.zv;
                this.he.d(iMax, Math.max(-i4, Math.min(i2, i4)));
                return true;
            }
        }
        return false;
    }

    public void an() {
        setScrollState(0);
        vv();
    }

    private void vv() {
        this.he.hc();
        tt ttVar = this.k;
        if (ttVar != null) {
            ttVar.z();
        }
    }

    public int getMinFlingVelocity() {
        return this.fy;
    }

    public int getMaxFlingVelocity() {
        return this.zv;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 0
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 1
            if (r1 >= 0) goto L21
            r6.h()
            android.widget.EdgeEffect r1 = r6.nw
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r2 - r9
            com.bytedance.sdk.component.widget.recycler.d.b.d.d(r1, r4, r9)
        L1f:
            r9 = r3
            goto L3c
        L21:
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r1 <= 0) goto L3b
            r6.gb()
            android.widget.EdgeEffect r1 = r6.nr
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            com.bytedance.sdk.component.widget.recycler.d.b.d.d(r1, r4, r9)
            goto L1f
        L3b:
            r9 = 0
        L3c:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L56
            r6.tt()
            android.widget.EdgeEffect r9 = r6.dz
            float r1 = -r10
            int r2 = r6.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            int r2 = r6.getWidth()
            float r2 = (float) r2
            float r7 = r7 / r2
            com.bytedance.sdk.component.widget.recycler.d.b.d.d(r9, r1, r7)
            goto L72
        L56:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 <= 0) goto L71
            r6.tc()
            android.widget.EdgeEffect r9 = r6.i
            int r1 = r6.getHeight()
            float r1 = (float) r1
            float r1 = r10 / r1
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r2 = r2 - r7
            com.bytedance.sdk.component.widget.recycler.d.b.d.d(r9, r1, r2)
            goto L72
        L71:
            r3 = r9
        L72:
            if (r3 != 0) goto L7c
            int r7 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r7 != 0) goto L7c
            int r7 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r7 == 0) goto L7f
        L7c:
            com.bytedance.sdk.component.widget.recycler.d.b.h.b(r6)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.d(float, float, float, float):void");
    }

    private void zw() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.nw;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.nw.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.dz;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.dz.isFinished();
        }
        EdgeEffect edgeEffect3 = this.nr;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.nr.isFinished();
        }
        EdgeEffect edgeEffect4 = this.i;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.i.isFinished();
        }
        if (zIsFinished) {
            com.bytedance.sdk.component.widget.recycler.d.b.h.b(this);
        }
    }

    void b(int i, int i2) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.nw;
        if (edgeEffect == null || edgeEffect.isFinished() || i <= 0) {
            zIsFinished = false;
        } else {
            this.nw.onRelease();
            zIsFinished = this.nw.isFinished();
        }
        EdgeEffect edgeEffect2 = this.nr;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.nr.onRelease();
            zIsFinished |= this.nr.isFinished();
        }
        EdgeEffect edgeEffect3 = this.dz;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            this.dz.onRelease();
            zIsFinished |= this.dz.isFinished();
        }
        EdgeEffect edgeEffect4 = this.i;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i2 < 0) {
            this.i.onRelease();
            zIsFinished |= this.i.isFinished();
        }
        if (zIsFinished) {
            com.bytedance.sdk.component.widget.recycler.d.b.h.b(this);
        }
    }

    void c(int i, int i2) {
        if (i < 0) {
            h();
            this.nw.onAbsorb(-i);
        } else if (i > 0) {
            gb();
            this.nr.onAbsorb(i);
        }
        if (i2 < 0) {
            tt();
            this.dz.onAbsorb(-i2);
        } else if (i2 > 0) {
            tc();
            this.i.onAbsorb(i2);
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        com.bytedance.sdk.component.widget.recycler.d.b.h.b(this);
    }

    void h() {
        if (this.nw == null) {
            EdgeEffect edgeEffectD = this.ia.d(this, 0);
            this.nw = edgeEffectD;
            if (this.tt) {
                edgeEffectD.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                edgeEffectD.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void gb() {
        if (this.nr == null) {
            EdgeEffect edgeEffectD = this.ia.d(this, 2);
            this.nr = edgeEffectD;
            if (this.tt) {
                edgeEffectD.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                edgeEffectD.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    void tt() {
        if (this.dz == null) {
            EdgeEffect edgeEffectD = this.ia.d(this, 1);
            this.dz = edgeEffectD;
            if (this.tt) {
                edgeEffectD.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                edgeEffectD.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void tc() {
        if (this.i == null) {
            EdgeEffect edgeEffectD = this.ia.d(this, 3);
            this.i = edgeEffectD;
            if (this.tt) {
                edgeEffectD.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                edgeEffectD.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void mk() {
        this.i = null;
        this.dz = null;
        this.nr = null;
        this.nw = null;
    }

    public static <T> T d(T t) {
        t.getClass();
        return t;
    }

    public void setEdgeEffectFactory(u uVar) {
        d(uVar);
        this.ia = uVar;
        mk();
    }

    public u getEdgeEffectFactory() {
        return this.ia;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i) {
        View viewD;
        boolean z;
        View viewC = this.k.c(view, i);
        if (viewC != null) {
            return viewC;
        }
        boolean z2 = (this.uo == null || this.k == null || k() || this.sy) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z2 && (i == 2 || i == 1)) {
            if (this.k.c()) {
                int i2 = i == 2 ? 130 : 33;
                z = focusFinder.findNextFocus(this, view, i2) == null;
                if (dc) {
                    i = i2;
                }
            } else {
                z = false;
            }
            if (!z && this.k.b()) {
                int i3 = (this.k.w() == 1) ^ (i == 2) ? 66 : 17;
                boolean z3 = focusFinder.findNextFocus(this, view, i3) == null;
                if (dc) {
                    i = i3;
                }
                z = z3;
            }
            if (z) {
                c();
                if (b(view) == null) {
                    return null;
                }
                u();
                this.k.d(view, i, this.u, this.j);
                d(false);
            }
            viewD = focusFinder.findNextFocus(this, view, i);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i);
            if (viewFindNextFocus == null && z2) {
                c();
                if (b(view) == null) {
                    return null;
                }
                u();
                viewD = this.k.d(view, i, this.u, this.j);
                d(false);
            } else {
                viewD = viewFindNextFocus;
            }
        }
        if (viewD == null || viewD.hasFocusable()) {
            return d(view, viewD, i) ? viewD : super.focusSearch(view, i);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i);
        }
        d(viewD, (View) null);
        return view;
    }

    private boolean d(View view, View view2, int i) {
        int i2;
        if (view2 == null || view2 == this || b(view2) == null) {
            return false;
        }
        if (view == null || b(view) == null) {
            return true;
        }
        this.mk.set(0, 0, view.getWidth(), view.getHeight());
        this.wl.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mk);
        offsetDescendantRectToMyCoords(view2, this.wl);
        char c2 = 65535;
        int i3 = this.k.w() == 1 ? -1 : 1;
        if ((this.mk.left < this.wl.left || this.mk.right <= this.wl.left) && this.mk.right < this.wl.right) {
            i2 = 1;
        } else {
            i2 = ((this.mk.right > this.wl.right || this.mk.left >= this.wl.right) && this.mk.left > this.wl.left) ? -1 : 0;
        }
        if ((this.mk.top < this.wl.top || this.mk.bottom <= this.wl.top) && this.mk.bottom < this.wl.bottom) {
            c2 = 1;
        } else if ((this.mk.bottom <= this.wl.bottom && this.mk.top < this.wl.bottom) || this.mk.top <= this.wl.top) {
            c2 = 0;
        }
        if (i == 1) {
            return c2 < 0 || (c2 == 0 && i2 * i3 <= 0);
        }
        if (i == 2) {
            return c2 > 0 || (c2 == 0 && i2 * i3 >= 0);
        }
        if (i == 17) {
            return i2 < 0;
        }
        if (i == 33) {
            return c2 < 0;
        }
        if (i == 66) {
            return i2 > 0;
        }
        if (i == 130) {
            return c2 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i + d());
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.k.d(this, this.j, view, view2) && view2 != null) {
            d(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    private void d(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mk.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof tc) {
            tc tcVar = (tc) layoutParams;
            if (!tcVar.b) {
                Rect rect = tcVar.hc;
                this.mk.left -= rect.left;
                this.mk.right += rect.right;
                this.mk.top -= rect.top;
                this.mk.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mk);
            offsetRectIntoDescendantCoords(view, this.mk);
        }
        this.k.d(this, view, this.mk, !this.rf, view2 == null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.k.d(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        tt ttVar = this.k;
        if (ttVar == null || !ttVar.d(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (k()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.ra = 0;
        this.w = true;
        this.rf = this.rf && !isLayoutRequested();
        tt ttVar = this.k;
        if (ttVar != null) {
            ttVar.hc(this);
        }
        this.z = false;
        if (c) {
            com.bytedance.sdk.component.widget.recycler.c cVar = com.bytedance.sdk.component.widget.recycler.c.d.get();
            this.vv = cVar;
            if (cVar == null) {
                this.vv = new com.bytedance.sdk.component.widget.recycler.c();
                Display displayH = com.bytedance.sdk.component.widget.recycler.d.b.h.h(this);
                float f = 60.0f;
                if (!isInEditMode() && displayH != null) {
                    float refreshRate = displayH.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f = refreshRate;
                    }
                }
                this.vv.c = (long) (1.0E9f / f);
                com.bytedance.sdk.component.widget.recycler.c.d.set(this.vv);
            }
            this.vv.d(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        com.bytedance.sdk.component.widget.recycler.c cVar;
        super.onDetachedFromWindow();
        an anVar = this.yi;
        if (anVar != null) {
            anVar.c();
        }
        an();
        this.w = false;
        tt ttVar = this.k;
        if (ttVar != null) {
            ttVar.hc(this, this.u);
        }
        this.mt.clear();
        removeCallbacks(this.tj);
        this.gb.hc();
        if (!c || (cVar = this.vv) == null) {
            return;
        }
        cVar.hc(this);
        this.vv = null;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.w;
    }

    void d(String str) {
        if (k()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + d());
            }
            throw new IllegalStateException(str);
        }
        if (this.rw > 0) {
            com.bytedance.sdk.component.utils.mq.hc("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(d()));
        }
    }

    private boolean d(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.ru = null;
        }
        int size = this.q.size();
        for (int i = 0; i < size; i++) {
            uo uoVar = this.q.get(i);
            if (uoVar.d(this, motionEvent) && action != 3) {
                this.ru = uoVar;
                return true;
            }
        }
        return false;
    }

    private boolean hc(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.ru != null) {
            if (action != 0) {
                if (action == 3 || action == 1) {
                    this.ru = null;
                }
                return true;
            }
            this.ru = null;
        }
        if (action != 0) {
            int size = this.q.size();
            for (int i = 0; i < size; i++) {
                uo uoVar = this.q.get(i);
                if (uoVar.d(this, motionEvent)) {
                    this.ru = uoVar;
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.sy) {
            return false;
        }
        if (d(motionEvent)) {
            s();
            return true;
        }
        tt ttVar = this.k;
        if (ttVar == null) {
            return false;
        }
        boolean zB = ttVar.b();
        boolean zC = this.k.c();
        if (this.ar == null) {
            this.ar = VelocityTracker.obtain();
        }
        this.ar.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.l) {
                this.l = false;
            }
            this.qr = motionEvent.getPointerId(0);
            int x = (int) (motionEvent.getX() + 0.5f);
            this.gv = x;
            this.t = x;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.qy = y;
            this.ph = y;
            if (this.ey == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
            int[] iArr = this.rs;
            iArr[1] = 0;
            iArr[0] = 0;
            int i = zB;
            if (zC) {
                i = (zB ? 1 : 0) | 2;
            }
            tt(i, 0);
        } else if (actionMasked == 1) {
            this.ar.clear();
            gb(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.qr);
            if (iFindPointerIndex < 0) {
                com.bytedance.sdk.component.utils.mq.c("RecyclerView", "Error processing scroll; pointer index for id " + this.qr + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x2 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.ey != 1) {
                int i2 = x2 - this.t;
                int i3 = y2 - this.ph;
                if (zB == 0 || Math.abs(i2) <= this.nf) {
                    z = false;
                } else {
                    this.gv = x2;
                    z = true;
                }
                if (zC && Math.abs(i3) > this.nf) {
                    this.qy = y2;
                    z = true;
                }
                if (z) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            s();
        } else if (actionMasked == 5) {
            this.qr = motionEvent.getPointerId(actionIndex);
            int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.gv = x3;
            this.t = x3;
            int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.qy = y3;
            this.ph = y3;
        } else if (actionMasked == 6) {
            b(motionEvent);
        }
        return this.ey == 1;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.q.size();
        for (int i = 0; i < size; i++) {
            this.q.get(i);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0106  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void j() {
        VelocityTracker velocityTracker = this.ar;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        gb(0);
        zw();
    }

    private void s() {
        j();
        setScrollState(0);
    }

    private void b(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.qr) {
            int i = actionIndex == 0 ? 1 : 0;
            this.qr = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.gv = x;
            this.t = x;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.qy = y;
            this.ph = y;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            com.bytedance.sdk.component.widget.recycler.RecyclerView$tt r0 = r5.k
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.sy
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L75
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3c
            com.bytedance.sdk.component.widget.recycler.RecyclerView$tt r0 = r5.k
            boolean r0 = r0.c()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = r2
        L2d:
            com.bytedance.sdk.component.widget.recycler.RecyclerView$tt r3 = r5.k
            boolean r3 = r3.b()
            if (r3 == 0) goto L54
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L62
        L3c:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L60
            r0 = 26
            float r3 = r6.getAxisValue(r0)
            com.bytedance.sdk.component.widget.recycler.RecyclerView$tt r0 = r5.k
            boolean r0 = r0.c()
            if (r0 == 0) goto L56
            float r0 = -r3
        L54:
            r3 = r2
            goto L62
        L56:
            com.bytedance.sdk.component.widget.recycler.RecyclerView$tt r0 = r5.k
            boolean r0 = r0.b()
            if (r0 == 0) goto L60
            r0 = r2
            goto L62
        L60:
            r0 = r2
            r3 = r0
        L62:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6a
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L75
        L6a:
            float r2 = r5.um
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.fv
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.d(r2, r0, r6)
        L75:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        tt ttVar = this.k;
        if (ttVar == null) {
            u(i, i2);
            return;
        }
        boolean z = false;
        if (!ttVar.d()) {
            if (this.yo) {
                this.k.d(this.u, this.j, i, i2);
                return;
            }
            if (this.de) {
                u();
                mq();
                fs();
                uo();
                if (this.j.mk) {
                    this.j.h = true;
                } else {
                    this.an.u();
                    this.j.h = false;
                }
                this.de = false;
                d(false);
            } else if (this.j.mk) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            d dVar = this.uo;
            if (dVar != null) {
                this.j.u = dVar.d();
            } else {
                this.j.u = 0;
            }
            u();
            this.k.d(this.u, this.j, i, i2);
            d(false);
            this.j.h = false;
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        this.k.d(this.u, this.j, i, i2);
        if (mode == 1073741824 && mode2 == 1073741824) {
            z = true;
        }
        if (z || this.uo == null) {
            return;
        }
        if (this.j.c == 1) {
            bc();
        }
        this.k.hc(i, i2);
        this.j.tt = true;
        dc();
        this.k.b(i, i2);
        if (this.k.tt()) {
            this.k.hc(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
            this.j.tt = true;
            dc();
            this.k.b(i, i2);
        }
    }

    void u(int i, int i2) {
        setMeasuredDimension(tt.d(i, getPaddingLeft() + getPaddingRight(), com.bytedance.sdk.component.widget.recycler.d.b.h.c(this)), tt.d(i2, getPaddingTop() + getPaddingBottom(), com.bytedance.sdk.component.widget.recycler.d.b.h.u(this)));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i == i3 && i2 == i4) {
            return;
        }
        mk();
    }

    public void setItemAnimator(an anVar) {
        an anVar2 = this.yi;
        if (anVar2 != null) {
            anVar2.c();
            this.yi.d(null);
        }
        this.yi = anVar;
        if (anVar != null) {
            anVar.d(this.wb);
        }
    }

    void mq() {
        this.ra++;
    }

    void uo() {
        hc(true);
    }

    void hc(boolean z) {
        int i = this.ra - 1;
        this.ra = i;
        if (i <= 0) {
            this.ra = 0;
            if (z) {
                us();
                v();
            }
        }
    }

    private void us() {
        this.fu = 0;
    }

    public boolean k() {
        return this.ra > 0;
    }

    public an getItemAnimator() {
        return this.yi;
    }

    void e() {
        if (this.z || !this.w) {
            return;
        }
        com.bytedance.sdk.component.widget.recycler.d.b.h.d(this, this.tj);
        this.z = true;
    }

    private boolean z() {
        return this.yi != null && this.k.mq();
    }

    private void fs() {
        if (this.v) {
            this.an.d();
        }
        if (z()) {
            this.an.hc();
        } else {
            this.an.u();
        }
        boolean z = false;
        boolean z2 = this.s || this.us;
        this.j.tc = this.rf && this.yi != null && (this.v || z2 || this.k.uo) && (!this.v || this.uo.hc());
        jh jhVar = this.j;
        if (jhVar.tc && z2 && !this.v && z()) {
            z = true;
        }
        jhVar.mk = z;
    }

    void cb() {
        if (this.uo == null) {
            com.bytedance.sdk.component.utils.mq.c("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.k == null) {
            com.bytedance.sdk.component.utils.mq.c("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        this.j.tt = false;
        if (this.j.c == 1) {
            bc();
        } else {
            if (!this.an.an() && this.k.de() == getWidth() && this.k.v() == getHeight()) {
                this.k.c(this);
            }
            tr();
        }
        this.k.c(this);
        dc();
        tr();
    }

    private void ba() {
        View focusedChild = (this.pq && hasFocus() && this.uo != null) ? getFocusedChild() : null;
        v vVarC = focusedChild != null ? c(focusedChild) : null;
        if (vVarC == null) {
            mt();
            return;
        }
        this.j.uo = this.uo.hc() ? vVarC.h() : -1L;
        this.j.mq = this.v ? -1 : vVarC.w() ? vVarC.c : vVarC.u();
        this.j.k = uo(vVarC.d);
    }

    private void mt() {
        this.j.uo = -1L;
        this.j.mq = -1;
        this.j.k = -1;
    }

    private View r() {
        v vVarC;
        int i = this.j.mq != -1 ? this.j.mq : 0;
        int iC = this.j.c();
        for (int i2 = i; i2 < iC; i2++) {
            v vVarC2 = c(i2);
            if (vVarC2 == null) {
                break;
            }
            if (vVarC2.d.hasFocusable()) {
                return vVarC2.d;
            }
        }
        int iMin = Math.min(iC, i);
        do {
            iMin--;
            if (iMin < 0 || (vVarC = c(iMin)) == null) {
                return null;
            }
        } while (!vVarC.d.hasFocusable());
        return vVarC.d;
    }

    private void hv() {
        View viewFindViewById;
        if (!this.pq || this.uo == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (tr && (focusedChild.getParent() == null || !focusedChild.hasFocus())) {
                if (this.h.hc() == 0) {
                    requestFocus();
                    return;
                }
            } else if (!this.h.b(focusedChild)) {
                return;
            }
        }
        View viewR = null;
        v vVarD = (this.j.uo == -1 || !this.uo.hc()) ? null : d(this.j.uo);
        if (vVarD != null && !this.h.b(vVarD.d) && vVarD.d.hasFocusable()) {
            viewR = vVarD.d;
        } else if (this.h.hc() > 0) {
            viewR = r();
        }
        if (viewR != null) {
            if (this.j.k != -1 && (viewFindViewById = viewR.findViewById(this.j.k)) != null && viewFindViewById.isFocusable()) {
                viewR = viewFindViewById;
            }
            viewR.requestFocus();
        }
    }

    private int uo(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    final void d(jh jhVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.he.d;
            jhVar.e = overScroller.getFinalX() - overScroller.getCurrX();
            jhVar.cb = overScroller.getFinalY() - overScroller.getCurrY();
        } else {
            jhVar.e = 0;
            jhVar.cb = 0;
        }
    }

    private void bc() {
        this.j.d(1);
        d(this.j);
        this.j.tt = false;
        u();
        this.gb.d();
        mq();
        fs();
        ba();
        jh jhVar = this.j;
        jhVar.gb = jhVar.tc && this.us;
        this.us = false;
        this.s = false;
        jh jhVar2 = this.j;
        jhVar2.h = jhVar2.mk;
        this.j.u = this.uo.d();
        d(this.o);
        if (this.j.tc) {
            int iHc = this.h.hc();
            for (int i = 0; i < iHc; i++) {
                v vVarU = u(this.h.hc(i));
                if (!vVarU.L_() && (!vVarU.k() || this.uo.hc())) {
                    this.gb.d(vVarU, this.yi.d(this.j, vVarU, an.u(vVarU), vVarU.sy()));
                    if (this.j.gb && vVarU.he() && !vVarU.w() && !vVarU.L_() && !vVarU.k()) {
                        this.gb.d(d(vVarU), vVarU);
                    }
                }
            }
        }
        if (this.j.mk) {
            yo();
            boolean z = this.j.an;
            this.j.an = false;
            this.k.d(this.u, this.j);
            this.j.an = z;
            for (int i2 = 0; i2 < this.h.hc(); i2++) {
                v vVarU2 = u(this.h.hc(i2));
                if (!vVarU2.L_() && !this.gb.c(vVarU2)) {
                    int iU = an.u(vVarU2);
                    boolean zD = vVarU2.d(8192);
                    if (!zD) {
                        iU |= 4096;
                    }
                    an.hc hcVarD = this.yi.d(this.j, vVarU2, iU, vVarU2.sy());
                    if (zD) {
                        d(vVarU2, hcVarD);
                    } else {
                        this.gb.hc(vVarU2, hcVarD);
                    }
                }
            }
            rf();
        } else {
            rf();
        }
        uo();
        d(false);
        this.j.c = 2;
    }

    private void dc() {
        u();
        mq();
        this.j.d(6);
        this.an.u();
        this.j.u = this.uo.d();
        this.j.b = 0;
        this.j.h = false;
        this.k.d(this.u, this.j);
        this.j.an = false;
        jh jhVar = this.j;
        jhVar.tc = jhVar.tc && this.yi != null;
        this.j.c = 4;
        uo();
        d(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void tr() {
        /*
            Method dump skipped, instructions count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.tr():void");
    }

    private void d(long j, v vVar, v vVar2) {
        int iHc = this.h.hc();
        for (int i = 0; i < iHc; i++) {
            v vVarU = u(this.h.hc(i));
            if (vVarU != vVar && d(vVarU) == j) {
                d dVar = this.uo;
                if (dVar != null && dVar.hc()) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + vVarU + " \n View Holder 2:" + vVar + d());
                }
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + vVarU + " \n View Holder 2:" + vVar + d());
            }
        }
        com.bytedance.sdk.component.utils.mq.c("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + vVar2 + " cannot be found but it is necessary for " + vVar + d());
    }

    void d(v vVar, an.hc hcVar) {
        vVar.d(0, 8192);
        if (this.j.gb && vVar.he() && !vVar.w() && !vVar.L_()) {
            this.gb.d(d(vVar), vVar);
        }
        this.gb.d(vVar, hcVar);
    }

    private void d(int[] iArr) {
        int iHc = this.h.hc();
        if (iHc == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < iHc; i3++) {
            v vVarU = u(this.h.hc(i3));
            if (!vVarU.L_()) {
                int iC = vVarU.c();
                if (iC < i) {
                    i = iC;
                }
                if (iC > i2) {
                    i2 = iC;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    private boolean tc(int i, int i2) {
        d(this.o);
        int[] iArr = this.o;
        return (iArr[0] == i && iArr[1] == i2) ? false : true;
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z) {
        v vVarU = u(view);
        if (vVarU != null) {
            if (vVarU.yo()) {
                vVarU.uo();
            } else if (!vVarU.L_()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + vVarU + d());
            }
        }
        view.clearAnimation();
        mk(view);
        super.removeDetachedView(view, z);
    }

    long d(v vVar) {
        return this.uo.hc() ? vVar.h() : vVar.b;
    }

    void d(v vVar, an.hc hcVar, an.hc hcVar2) {
        vVar.d(false);
        if (this.yi.hc(vVar, hcVar, hcVar2)) {
            e();
        }
    }

    void hc(v vVar, an.hc hcVar, an.hc hcVar2) {
        u(vVar);
        vVar.d(false);
        if (this.yi.d(vVar, hcVar, hcVar2)) {
            e();
        }
    }

    private void d(v vVar, v vVar2, an.hc hcVar, an.hc hcVar2, boolean z, boolean z2) {
        vVar.d(false);
        if (z) {
            u(vVar);
        }
        if (vVar != vVar2) {
            if (z2) {
                u(vVar2);
            }
            vVar.gb = vVar2;
            u(vVar);
            this.u.b(vVar);
            vVar2.d(false);
            vVar2.tt = vVar;
        }
        if (this.yi.d(vVar, vVar2, hcVar, hcVar2)) {
            e();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.bytedance.sdk.component.widget.recycler.d.d.d.d("RV OnLayout");
        cb();
        com.bytedance.sdk.component.widget.recycler.d.d.d.d();
        this.rf = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.yn == 0 && !this.sy) {
            super.requestLayout();
        } else {
            this.jh = true;
        }
    }

    void w() {
        int iB = this.h.b();
        for (int i = 0; i < iB; i++) {
            ((tc) this.h.c(i).getLayoutParams()).b = true;
        }
        this.u.tc();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        super.draw(canvas);
        int size = this.cb.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            this.cb.get(i);
        }
        EdgeEffect edgeEffect = this.nw;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.tt ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.nw;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.dz;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.tt) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.dz;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.nr;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.tt ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.nr;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.i;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.tt) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.i;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z2 = true;
            }
            z |= z2;
            canvas.restoreToCount(iSave4);
        }
        if ((z || this.yi == null || this.cb.size() <= 0 || !this.yi.hc()) ? z : true) {
            com.bytedance.sdk.component.widget.recycler.d.b.h.b(this);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.cb.size();
        for (int i = 0; i < size; i++) {
            this.cb.get(i);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof tc) && this.k.d((tc) layoutParams);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        tt ttVar = this.k;
        if (ttVar == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + d());
        }
        return ttVar.hc();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        tt ttVar = this.k;
        if (ttVar == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + d());
        }
        return ttVar.d(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        tt ttVar = this.k;
        if (ttVar == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + d());
        }
        return ttVar.d(layoutParams);
    }

    void yo() {
        int iB = this.h.b();
        for (int i = 0; i < iB; i++) {
            v vVarU = u(this.h.c(i));
            if (!vVarU.L_()) {
                vVarU.hc();
            }
        }
    }

    void rf() {
        int iB = this.h.b();
        for (int i = 0; i < iB; i++) {
            v vVarU = u(this.h.c(i));
            if (!vVarU.L_()) {
                vVarU.d();
            }
        }
        this.u.tt();
    }

    void an(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int iB = this.h.b();
        if (i < i2) {
            i5 = -1;
            i4 = i;
            i3 = i2;
        } else {
            i3 = i;
            i4 = i2;
            i5 = 1;
        }
        for (int i6 = 0; i6 < iB; i6++) {
            v vVarU = u(this.h.c(i6));
            if (vVarU != null && vVarU.b >= i4 && vVarU.b <= i3) {
                if (vVarU.b == i) {
                    vVarU.d(i2 - i, false);
                } else {
                    vVarU.d(i5, false);
                }
                this.j.an = true;
            }
        }
        this.u.d(i, i2);
        requestLayout();
    }

    void h(int i, int i2) {
        int iB = this.h.b();
        for (int i3 = 0; i3 < iB; i3++) {
            v vVarU = u(this.h.c(i3));
            if (vVarU != null && !vVarU.L_() && vVarU.b >= i) {
                vVarU.d(i2, false);
                this.j.an = true;
            }
        }
        this.u.hc(i, i2);
        requestLayout();
    }

    void d(int i, int i2, boolean z) {
        int i3 = i + i2;
        int iB = this.h.b();
        for (int i4 = 0; i4 < iB; i4++) {
            v vVarU = u(this.h.c(i4));
            if (vVarU != null && !vVarU.L_()) {
                if (vVarU.b >= i3) {
                    vVarU.d(-i2, z);
                    this.j.an = true;
                } else if (vVarU.b >= i) {
                    vVarU.d(i - 1, -i2, z);
                    this.j.an = true;
                }
            }
        }
        this.u.d(i, i2, z);
        requestLayout();
    }

    void d(int i, int i2, Object obj) {
        int iB = this.h.b();
        int i3 = i + i2;
        for (int i4 = 0; i4 < iB; i4++) {
            View viewC = this.h.c(i4);
            v vVarU = u(viewC);
            if (vVarU != null && !vVarU.L_() && vVarU.b >= i && vVarU.b < i3) {
                vVarU.hc(2);
                vVarU.d(obj);
                ((tc) viewC.getLayoutParams()).b = true;
            }
        }
        this.u.b(i, i2);
    }

    boolean hc(v vVar) {
        an anVar = this.yi;
        return anVar == null || anVar.d(vVar, vVar.sy());
    }

    void b(boolean z) {
        this.np = z | this.np;
        this.v = true;
        jh();
    }

    void jh() {
        int iB = this.h.b();
        for (int i = 0; i < iB; i++) {
            v vVarU = u(this.h.c(i));
            if (vVarU != null && !vVarU.L_()) {
                vVarU.hc(6);
            }
        }
        w();
        this.u.gb();
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.pq;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.pq = z;
    }

    public v hc(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return u(view);
    }

    public View b(View view) {
        Object parent;
        while (true) {
            parent = view.getParent();
            if (parent == null || parent == this || !(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public v c(View view) {
        View viewB = b(view);
        if (viewB == null) {
            return null;
        }
        return hc(viewB);
    }

    static v u(View view) {
        if (view == null) {
            return null;
        }
        return ((tc) view.getLayoutParams()).d;
    }

    @Deprecated
    public int an(View view) {
        return h(view);
    }

    public int h(View view) {
        v vVarU = u(view);
        if (vVarU != null) {
            return vVarU.u();
        }
        return -1;
    }

    public int gb(View view) {
        v vVarU = u(view);
        if (vVarU != null) {
            return vVarU.c();
        }
        return -1;
    }

    public v b(int i) {
        return d(i, false);
    }

    public v c(int i) {
        v vVar = null;
        if (this.v) {
            return null;
        }
        int iB = this.h.b();
        for (int i2 = 0; i2 < iB; i2++) {
            v vVarU = u(this.h.c(i2));
            if (vVarU != null && !vVarU.w() && c(vVarU) == i) {
                if (!this.h.b(vVarU.d)) {
                    return vVarU;
                }
                vVar = vVarU;
            }
        }
        return vVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.bytedance.sdk.component.widget.recycler.RecyclerView.v d(int r6, boolean r7) {
        /*
            r5 = this;
            com.bytedance.sdk.component.widget.recycler.hc r0 = r5.h
            int r0 = r0.b()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L38
            com.bytedance.sdk.component.widget.recycler.hc r3 = r5.h
            android.view.View r3 = r3.c(r2)
            com.bytedance.sdk.component.widget.recycler.RecyclerView$v r3 = u(r3)
            if (r3 == 0) goto L35
            boolean r4 = r3.w()
            if (r4 != 0) goto L35
            if (r7 == 0) goto L23
            int r4 = r3.b
            if (r4 == r6) goto L29
            goto L35
        L23:
            int r4 = r3.c()
            if (r4 != r6) goto L35
        L29:
            com.bytedance.sdk.component.widget.recycler.hc r1 = r5.h
            android.view.View r4 = r3.d
            boolean r1 = r1.b(r4)
            if (r1 != 0) goto L34
            return r3
        L34:
            r1 = r3
        L35:
            int r2 = r2 + 1
            goto L8
        L38:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.d(int, boolean):com.bytedance.sdk.component.widget.recycler.RecyclerView$v");
    }

    public v d(long j) {
        d dVar = this.uo;
        v vVar = null;
        if (dVar != null && dVar.hc()) {
            int iB = this.h.b();
            for (int i = 0; i < iB; i++) {
                v vVarU = u(this.h.c(i));
                if (vVarU != null && !vVarU.w() && vVarU.h() == j) {
                    if (!this.h.b(vVarU.d)) {
                        return vVarU;
                    }
                    vVar = vVarU;
                }
            }
        }
        return vVar;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public void u(int i) {
        int iHc = this.h.hc();
        for (int i2 = 0; i2 < iHc; i2++) {
            this.h.hc(i2).offsetTopAndBottom(i);
        }
    }

    public void an(int i) {
        int iHc = this.h.hc();
        for (int i2 = 0; i2 < iHc; i2++) {
            this.h.hc(i2).offsetLeftAndRight(i);
        }
    }

    static void d(View view, Rect rect) {
        tc tcVar = (tc) view.getLayoutParams();
        Rect rect2 = tcVar.hc;
        rect.set((view.getLeft() - rect2.left) - tcVar.leftMargin, (view.getTop() - rect2.top) - tcVar.topMargin, view.getRight() + rect2.right + tcVar.rightMargin, view.getBottom() + rect2.bottom + tcVar.bottomMargin);
    }

    Rect tt(View view) {
        tc tcVar = (tc) view.getLayoutParams();
        if (!tcVar.b) {
            return tcVar.hc;
        }
        if (this.j.d() && (tcVar.b() || tcVar.d())) {
            return tcVar.hc;
        }
        Rect rect = tcVar.hc;
        rect.set(0, 0, 0, 0);
        int size = this.cb.size();
        for (int i = 0; i < size; i++) {
            this.mk.set(0, 0, 0, 0);
            this.cb.get(i).d(this.mk, view, this, this.j);
            rect.left += this.mk.left;
            rect.top += this.mk.top;
            rect.right += this.mk.right;
            rect.bottom += this.mk.bottom;
        }
        tcVar.b = false;
        return rect;
    }

    void gb(int i, int i2) {
        this.rw++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        k kVar = this.kb;
        if (kVar != null) {
            kVar.d(this, i, i2);
        }
        List<k> list = this.js;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.js.get(size).d(this, i, i2);
            }
        }
        this.rw--;
    }

    void h(int i) {
        tt ttVar = this.k;
        if (ttVar != null) {
            ttVar.mk(i);
        }
        k kVar = this.kb;
        if (kVar != null) {
            kVar.d(this, i);
        }
        List<k> list = this.js;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.js.get(size).d(this, i);
            }
        }
    }

    public boolean sy() {
        return !this.rf || this.v || this.an.c();
    }

    void de() {
        int iHc = this.h.hc();
        for (int i = 0; i < iHc; i++) {
            View viewHc = this.h.hc(i);
            v vVarHc = hc(viewHc);
            if (vVarHc != null && vVarHc.tt != null) {
                View view = vVarHc.tt.d;
                int left = viewHc.getLeft();
                int top = viewHc.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    static RecyclerView tc(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView recyclerViewTc = tc(viewGroup.getChildAt(i));
            if (recyclerViewTc != null) {
                return recyclerViewTc;
            }
        }
        return null;
    }

    static void b(v vVar) {
        if (vVar.hc != null) {
            RecyclerView recyclerView = vVar.hc.get();
            while (recyclerView != null) {
                if (recyclerView == vVar.d) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            vVar.hc = null;
        }
    }

    long getNanoTime() {
        if (c) {
            return System.nanoTime();
        }
        return 0L;
    }

    void mk(View view) {
        u(view);
        List<mk> list = this.to;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.to.get(size).hc(view);
            }
        }
    }

    void mq(View view) {
        u(view);
        List<mk> list = this.to;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.to.get(size).d(view);
            }
        }
    }

    boolean d(v vVar, int i) {
        if (k()) {
            vVar.e = i;
            this.mt.add(vVar);
            return false;
        }
        com.bytedance.sdk.component.widget.recycler.d.b.h.d(vVar.d, i);
        return true;
    }

    void v() {
        int i;
        for (int size = this.mt.size() - 1; size >= 0; size--) {
            v vVar = this.mt.get(size);
            if (vVar.d.getParent() == this && !vVar.L_() && (i = vVar.e) != -1) {
                com.bytedance.sdk.component.widget.recycler.d.b.h.d(vVar.d, i);
                vVar.e = -1;
            }
        }
        this.mt.clear();
    }

    int c(v vVar) {
        if (vVar.d(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_STREAM_DURATION) || !vVar.cb()) {
            return -1;
        }
        return this.an.b(vVar.b);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().d(z);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().d();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().hc(i);
    }

    public boolean tt(int i, int i2) {
        return getScrollingChildHelper().d(i, i2);
    }

    @Override // android.view.View, com.bytedance.sdk.component.widget.recycler.d.b.hc
    public void stopNestedScroll() {
        getScrollingChildHelper().b();
    }

    public void gb(int i) {
        getScrollingChildHelper().b(i);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hc();
    }

    public boolean tt(int i) {
        return getScrollingChildHelper().d(i);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().d(i, i2, i3, i4, iArr);
    }

    public boolean d(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().d(i, i2, i3, i4, iArr, i5);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().d(i, i2, iArr, iArr2);
    }

    public boolean d(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().d(i, i2, iArr, iArr2, i3);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().d(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().d(f, f2);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        c cVar = this.mb;
        return cVar == null ? super.getChildDrawingOrder(i, i2) : cVar.d(i, i2);
    }

    private com.bytedance.sdk.component.widget.recycler.d.b.c getScrollingChildHelper() {
        if (this.f == null) {
            this.f = new com.bytedance.sdk.component.widget.recycler.d.b.c(this);
        }
        return this.f;
    }

    public static abstract class an {
        private d d = null;
        private ArrayList<Object> hc = new ArrayList<>();
        private long b = 120;
        private long c = 120;
        private long u = 250;
        private long an = 250;

        interface d {
            void d(v vVar);
        }

        public abstract boolean b(v vVar, hc hcVar, hc hcVar2);

        public abstract void c();

        public abstract void c(v vVar);

        public abstract void d();

        public abstract boolean d(v vVar, hc hcVar, hc hcVar2);

        public abstract boolean d(v vVar, v vVar2, hc hcVar, hc hcVar2);

        public boolean h(v vVar) {
            return true;
        }

        public abstract boolean hc();

        public abstract boolean hc(v vVar, hc hcVar, hc hcVar2);

        public long u() {
            return this.u;
        }

        public long an() {
            return this.b;
        }

        public long h() {
            return this.c;
        }

        public long gb() {
            return this.an;
        }

        void d(d dVar) {
            this.d = dVar;
        }

        public hc d(jh jhVar, v vVar, int i, List<Object> list) {
            return tc().d(vVar);
        }

        public hc d(jh jhVar, v vVar) {
            return tc().d(vVar);
        }

        static int u(v vVar) {
            int i = vVar.tc & 14;
            if (vVar.k()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int iAn = vVar.an();
            int iU = vVar.u();
            return (iAn == -1 || iU == -1 || iAn == iU) ? i : i | 2048;
        }

        public final void an(v vVar) {
            d dVar = this.d;
            if (dVar != null) {
                dVar.d(vVar);
            }
        }

        public boolean d(v vVar, List<Object> list) {
            return h(vVar);
        }

        public final void tt() {
            int size = this.hc.size();
            for (int i = 0; i < size; i++) {
                this.hc.get(i);
            }
            this.hc.clear();
        }

        public hc tc() {
            return new hc();
        }

        public static class hc {
            public int b;
            public int c;
            public int d;
            public int hc;

            public hc d(v vVar) {
                return d(vVar, 0);
            }

            public hc d(v vVar, int i) {
                View view = vVar.d;
                this.d = view.getLeft();
                this.hc = view.getTop();
                this.b = view.getRight();
                this.c = view.getBottom();
                return this;
            }
        }
    }

    private class h implements an.d {
        h() {
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.an.d
        public void d(v vVar) {
            vVar.d(true);
            if (vVar.gb != null && vVar.tt == null) {
                vVar.gb = null;
            }
            vVar.tt = null;
            if (vVar.np() || RecyclerView.this.d(vVar.d) || !vVar.yo()) {
                return;
            }
            RecyclerView.this.removeDetachedView(vVar.d, false);
        }
    }

    public static class jh {
        int cb;
        int e;
        int k;
        int mq;
        long uo;
        private SparseArray<Object> w;
        int d = -1;
        int hc = 0;
        int b = 0;
        int c = 1;
        int u = 0;
        boolean an = false;
        boolean h = false;
        boolean gb = false;
        boolean tt = false;
        boolean tc = false;
        boolean mk = false;

        void d(int i) {
            if ((this.c & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.c));
            }
        }

        void d(d dVar) {
            this.c = 1;
            this.u = dVar.d();
            this.h = false;
            this.gb = false;
            this.tt = false;
        }

        public boolean d() {
            return this.h;
        }

        public boolean hc() {
            return this.mk;
        }

        public boolean b() {
            return this.d != -1;
        }

        public int c() {
            return this.h ? this.hc - this.b : this.u;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.d + ", mData=" + this.w + ", mItemCount=" + this.u + ", mIsMeasuring=" + this.tt + ", mPreviousLayoutItemCount=" + this.hc + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.b + ", mStructureChanged=" + this.an + ", mInPreLayout=" + this.h + ", mRunSimpleAnimations=" + this.tc + ", mRunPredictiveAnimations=" + this.mk + '}';
        }
    }

    static class hc extends Observable<b> {
        hc() {
        }

        public void d() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((b) this.mObservers.get(size)).d();
            }
        }

        public void d(int i, int i2) {
            d(i, i2, null);
        }

        public void d(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((b) this.mObservers.get(size)).d(i, i2, obj);
            }
        }
    }

    public static abstract class rf {
        private View an;
        private tt b;
        private boolean c;
        private boolean gb;
        private RecyclerView hc;
        private boolean u;
        private int d = -1;
        private final d h = new d(0, 0);

        public interface hc {
            PointF b(int i);
        }

        protected abstract void d();

        protected abstract void d(int i, int i2, jh jhVar, d dVar);

        protected abstract void d(View view, jh jhVar, d dVar);

        void d(RecyclerView recyclerView, tt ttVar) {
            if (this.gb) {
                com.bytedance.sdk.component.utils.mq.hc("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.hc = recyclerView;
            this.b = ttVar;
            if (this.d == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.j.d = this.d;
            this.u = true;
            this.c = true;
            this.an = u(gb());
            this.hc.he.d();
            this.gb = true;
        }

        public void b(int i) {
            this.d = i;
        }

        public PointF c(int i) {
            Object objC = c();
            if (objC instanceof hc) {
                return ((hc) objC).b(i);
            }
            com.bytedance.sdk.component.utils.mq.hc("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + hc.class.getCanonicalName());
            return null;
        }

        public tt c() {
            return this.b;
        }

        protected final void u() {
            if (this.u) {
                this.u = false;
                d();
                this.hc.j.d = -1;
                this.an = null;
                this.d = -1;
                this.c = false;
                this.b.hc(this);
                this.b = null;
                this.hc = null;
            }
        }

        public boolean an() {
            return this.c;
        }

        public boolean h() {
            return this.u;
        }

        public int gb() {
            return this.d;
        }

        void d(int i, int i2) {
            PointF pointFC;
            RecyclerView recyclerView = this.hc;
            if (!this.u || this.d == -1 || recyclerView == null) {
                u();
            }
            if (this.c && this.an == null && this.b != null && (pointFC = c(this.d)) != null && (pointFC.x != 0.0f || pointFC.y != 0.0f)) {
                recyclerView.d((int) Math.signum(pointFC.x), (int) Math.signum(pointFC.y), (int[]) null);
            }
            this.c = false;
            View view = this.an;
            if (view != null) {
                if (d(view) == this.d) {
                    d(this.an, recyclerView.j, this.h);
                    this.h.d(recyclerView);
                    u();
                } else {
                    com.bytedance.sdk.component.utils.mq.c("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.an = null;
                }
            }
            if (this.u) {
                d(i, i2, recyclerView.j, this.h);
                boolean zD = this.h.d();
                this.h.d(recyclerView);
                if (zD) {
                    if (this.u) {
                        this.c = true;
                        recyclerView.he.d();
                    } else {
                        u();
                    }
                }
            }
        }

        public int d(View view) {
            return this.hc.gb(view);
        }

        public int tt() {
            return this.hc.k.rf();
        }

        public View u(int i) {
            return this.hc.k.hc(i);
        }

        protected void hc(View view) {
            if (d(view) == gb()) {
                this.an = view;
            }
        }

        protected void d(PointF pointF) {
            float fSqrt = (float) Math.sqrt((pointF.x * pointF.x) + (pointF.y * pointF.y));
            pointF.x /= fSqrt;
            pointF.y /= fSqrt;
        }

        public static class d {
            private boolean an;
            private int b;
            private int c;
            private int d;
            private int h;
            private int hc;
            private Interpolator u;

            public d(int i, int i2) {
                this(i, i2, Integer.MIN_VALUE, null);
            }

            public d(int i, int i2, int i3, Interpolator interpolator) {
                this.c = -1;
                this.an = false;
                this.h = 0;
                this.d = i;
                this.hc = i2;
                this.b = i3;
                this.u = interpolator;
            }

            public void d(int i) {
                this.c = i;
            }

            boolean d() {
                return this.c >= 0;
            }

            void d(RecyclerView recyclerView) {
                int i = this.c;
                if (i >= 0) {
                    this.c = -1;
                    recyclerView.d(i);
                    this.an = false;
                } else {
                    if (this.an) {
                        hc();
                        if (this.u == null) {
                            if (this.b == Integer.MIN_VALUE) {
                                recyclerView.he.hc(this.d, this.hc);
                            } else {
                                recyclerView.he.d(this.d, this.hc, this.b);
                            }
                        } else {
                            recyclerView.he.d(this.d, this.hc, this.b, this.u);
                        }
                        int i2 = this.h + 1;
                        this.h = i2;
                        if (i2 > 10) {
                            com.bytedance.sdk.component.utils.mq.c("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                        }
                        this.an = false;
                        return;
                    }
                    this.h = 0;
                }
            }

            private void hc() {
                if (this.u != null && this.b <= 0) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.b <= 0) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public void update(int i, int i2, int i3, Interpolator interpolator) {
                this.d = i;
                this.hc = i2;
                this.b = i3;
                this.u = interpolator;
                this.an = true;
            }
        }
    }

    public static class tc extends ViewGroup.MarginLayoutParams {
        boolean b;
        boolean c;
        v d;
        final Rect hc;

        public tc(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.hc = new Rect();
            this.b = true;
            this.c = false;
        }

        public tc(int i, int i2) {
            super(i, i2);
            this.hc = new Rect();
            this.b = true;
            this.c = false;
        }

        public tc(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.hc = new Rect();
            this.b = true;
            this.c = false;
        }

        public tc(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.hc = new Rect();
            this.b = true;
            this.c = false;
        }

        public tc(tc tcVar) {
            super((ViewGroup.MarginLayoutParams) tcVar);
            this.hc = new Rect();
            this.b = true;
            this.c = false;
        }

        public boolean d() {
            return this.d.k();
        }

        public boolean hc() {
            return this.d.w();
        }

        public boolean b() {
            return this.d.he();
        }

        public int c() {
            return this.d.c();
        }
    }

    public static abstract class v {
        private static final List<Object> w = Collections.emptyList();
        RecyclerView cb;
        public final View d;
        WeakReference<RecyclerView> hc;
        int tc;
        int b = -1;
        int c = -1;
        long u = -1;
        int an = -1;
        int h = -1;
        v gb = null;
        v tt = null;
        List<Object> mk = null;
        List<Object> mq = null;
        private int yo = 0;
        cb uo = null;
        boolean k = false;
        private int rf = 0;
        int e = -1;

        public v(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.d = view;
        }

        void d(int i, int i2, boolean z) {
            hc(8);
            d(i2, z);
            this.b = i;
        }

        void d(int i, boolean z) {
            if (this.c == -1) {
                this.c = this.b;
            }
            if (this.h == -1) {
                this.h = this.b;
            }
            if (z) {
                this.h += i;
            }
            this.b += i;
            if (this.d.getLayoutParams() != null) {
                ((tc) this.d.getLayoutParams()).b = true;
            }
        }

        void d() {
            this.c = -1;
            this.h = -1;
        }

        void hc() {
            if (this.c == -1) {
                this.c = this.b;
            }
        }

        boolean L_() {
            return (this.tc & 128) != 0;
        }

        public final int c() {
            int i = this.h;
            return i == -1 ? this.b : i;
        }

        public final int u() {
            RecyclerView recyclerView = this.cb;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.c(this);
        }

        public final int an() {
            return this.c;
        }

        public final long h() {
            return this.u;
        }

        public final int gb() {
            return this.an;
        }

        boolean tt() {
            return this.uo != null;
        }

        void tc() {
            this.uo.b(this);
        }

        boolean mk() {
            return (this.tc & 32) != 0;
        }

        void mq() {
            this.tc &= -33;
        }

        void uo() {
            this.tc &= -257;
        }

        void d(cb cbVar, boolean z) {
            this.uo = cbVar;
            this.k = z;
        }

        boolean k() {
            return (this.tc & 4) != 0;
        }

        boolean e() {
            return (this.tc & 2) != 0;
        }

        boolean cb() {
            return (this.tc & 1) != 0;
        }

        boolean w() {
            return (this.tc & 8) != 0;
        }

        boolean d(int i) {
            return (i & this.tc) != 0;
        }

        boolean yo() {
            return (this.tc & 256) != 0;
        }

        boolean rf() {
            return (this.tc & 512) != 0 || k();
        }

        void d(int i, int i2) {
            this.tc = (i & i2) | (this.tc & (~i2));
        }

        void hc(int i) {
            this.tc = i | this.tc;
        }

        void d(Object obj) {
            if (obj == null) {
                hc(1024);
            } else if ((1024 & this.tc) == 0) {
                vv();
                this.mk.add(obj);
            }
        }

        private void vv() {
            if (this.mk == null) {
                ArrayList arrayList = new ArrayList();
                this.mk = arrayList;
                this.mq = Collections.unmodifiableList(arrayList);
            }
        }

        void jh() {
            List<Object> list = this.mk;
            if (list != null) {
                list.clear();
            }
            this.tc &= -1025;
        }

        List<Object> sy() {
            if ((this.tc & 1024) == 0) {
                List<Object> list = this.mk;
                return (list == null || list.size() == 0) ? w : this.mq;
            }
            return w;
        }

        void de() {
            this.tc = 0;
            this.b = -1;
            this.c = -1;
            this.u = -1L;
            this.h = -1;
            this.yo = 0;
            this.gb = null;
            this.tt = null;
            jh();
            this.rf = 0;
            this.e = -1;
            RecyclerView.b(this);
        }

        void d(RecyclerView recyclerView) {
            int i = this.e;
            if (i != -1) {
                this.rf = i;
            } else {
                this.rf = com.bytedance.sdk.component.widget.recycler.d.b.h.hc(this.d);
            }
            recyclerView.d(this, 4);
        }

        void hc(RecyclerView recyclerView) {
            recyclerView.d(this, this.rf);
            this.rf = 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.b + " id=" + this.u + ", oldPos=" + this.c + ", pLpos:" + this.h);
            if (tt()) {
                sb.append(" scrap ").append(this.k ? "[changeScrap]" : "[attachedScrap]");
            }
            if (k()) {
                sb.append(" invalid");
            }
            if (!cb()) {
                sb.append(" unbound");
            }
            if (e()) {
                sb.append(" update");
            }
            if (w()) {
                sb.append(" removed");
            }
            if (L_()) {
                sb.append(" ignored");
            }
            if (yo()) {
                sb.append(" tmpDetached");
            }
            if (!v()) {
                sb.append(" not recyclable(" + this.yo + ")");
            }
            if (rf()) {
                sb.append(" undefined adapter position");
            }
            if (this.d.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append(i.d);
            return sb.toString();
        }

        public final void d(boolean z) {
            int i = this.yo;
            int i2 = z ? i - 1 : i + 1;
            this.yo = i2;
            if (i2 < 0) {
                this.yo = 0;
                com.bytedance.sdk.component.utils.mq.c("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && i2 == 1) {
                this.tc |= 16;
            } else if (z && i2 == 0) {
                this.tc &= -17;
            }
        }

        public final boolean v() {
            return (this.tc & 16) == 0 && !com.bytedance.sdk.component.widget.recycler.d.b.h.an(this.d);
        }

        boolean np() {
            return (this.tc & 16) != 0;
        }

        boolean yi() {
            return (this.tc & 16) == 0 && com.bytedance.sdk.component.widget.recycler.d.b.h.an(this.d);
        }

        boolean he() {
            return (this.tc & 2) != 0;
        }
    }

    public static abstract class gb {
        @Deprecated
        public void d(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void d(Rect rect, View view, RecyclerView recyclerView, jh jhVar) {
            d(rect, ((tc) view.getLayoutParams()).c(), recyclerView);
        }
    }

    public static abstract class tt {
        private int an;
        private boolean b;
        private boolean c;
        int cb;
        private final uo.hc d;
        boolean e;
        com.bytedance.sdk.component.widget.recycler.hc gb;
        private int h;
        private final uo.hc hc;
        boolean k;
        com.bytedance.sdk.component.widget.recycler.uo mk;
        rf mq;
        com.bytedance.sdk.component.widget.recycler.uo tc;
        RecyclerView tt;
        private int u;
        boolean uo;
        boolean w;
        private int yo;

        public interface d {
            void hc(int i, int i2);
        }

        public int an(jh jhVar) {
            return 0;
        }

        public int b(jh jhVar) {
            return 0;
        }

        public void b(RecyclerView recyclerView) {
        }

        public boolean b() {
            return false;
        }

        public int c(jh jhVar) {
            return 0;
        }

        public View c(View view, int i) {
            return null;
        }

        public void c(int i) {
        }

        public boolean c() {
            return false;
        }

        public int d(int i, cb cbVar, jh jhVar) {
            return 0;
        }

        public View d(View view, int i, cb cbVar, jh jhVar) {
            return null;
        }

        public void d(int i, int i2, jh jhVar, d dVar) {
        }

        public void d(int i, d dVar) {
        }

        public void d(RecyclerView recyclerView, cb cbVar) {
        }

        public boolean d(tc tcVar) {
            return tcVar != null;
        }

        public boolean d(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public int gb(jh jhVar) {
            return 0;
        }

        public int h(jh jhVar) {
            return 0;
        }

        public int hc(int i, cb cbVar, jh jhVar) {
            return 0;
        }

        public abstract tc hc();

        public void hc(jh jhVar) {
        }

        public void mk(int i) {
        }

        public boolean mq() {
            return false;
        }

        boolean tt() {
            return false;
        }

        public int u(jh jhVar) {
            return 0;
        }

        public int yo() {
            return -1;
        }

        public tt() {
            uo.hc hcVar = new uo.hc() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.tt.1
                @Override // com.bytedance.sdk.component.widget.recycler.uo.hc
                public View d(int i) {
                    return tt.this.gb(i);
                }

                @Override // com.bytedance.sdk.component.widget.recycler.uo.hc
                public int d() {
                    return tt.this.np();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.uo.hc
                public int hc() {
                    return tt.this.de() - tt.this.he();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.uo.hc
                public int d(View view) {
                    return tt.this.h(view) - ((tc) view.getLayoutParams()).leftMargin;
                }

                @Override // com.bytedance.sdk.component.widget.recycler.uo.hc
                public int hc(View view) {
                    return tt.this.tt(view) + ((tc) view.getLayoutParams()).rightMargin;
                }
            };
            this.d = hcVar;
            uo.hc hcVar2 = new uo.hc() { // from class: com.bytedance.sdk.component.widget.recycler.RecyclerView.tt.2
                @Override // com.bytedance.sdk.component.widget.recycler.uo.hc
                public View d(int i) {
                    return tt.this.gb(i);
                }

                @Override // com.bytedance.sdk.component.widget.recycler.uo.hc
                public int d() {
                    return tt.this.yi();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.uo.hc
                public int hc() {
                    return tt.this.v() - tt.this.vv();
                }

                @Override // com.bytedance.sdk.component.widget.recycler.uo.hc
                public int d(View view) {
                    return tt.this.gb(view) - ((tc) view.getLayoutParams()).topMargin;
                }

                @Override // com.bytedance.sdk.component.widget.recycler.uo.hc
                public int hc(View view) {
                    return tt.this.tc(view) + ((tc) view.getLayoutParams()).bottomMargin;
                }
            };
            this.hc = hcVar2;
            this.tc = new com.bytedance.sdk.component.widget.recycler.uo(hcVar);
            this.mk = new com.bytedance.sdk.component.widget.recycler.uo(hcVar2);
            this.uo = false;
            this.k = false;
            this.e = false;
            this.b = true;
            this.c = true;
        }

        void d(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.tt = null;
                this.gb = null;
                this.h = 0;
                this.yo = 0;
            } else {
                this.tt = recyclerView;
                this.gb = recyclerView.h;
                this.h = recyclerView.getWidth();
                this.yo = recyclerView.getHeight();
            }
            this.u = 1073741824;
            this.an = 1073741824;
        }

        void hc(int i, int i2) {
            this.h = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.u = mode;
            if (mode == 0 && !RecyclerView.hc) {
                this.h = 0;
            }
            this.yo = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.an = mode2;
            if (mode2 != 0 || RecyclerView.hc) {
                return;
            }
            this.yo = 0;
        }

        void b(int i, int i2) {
            int iRf = rf();
            if (iRf == 0) {
                this.tt.u(i, i2);
                return;
            }
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MIN_VALUE;
            for (int i7 = 0; i7 < iRf; i7++) {
                View viewGb = gb(i7);
                Rect rect = this.tt.mk;
                d(viewGb, rect);
                if (rect.left < i4) {
                    i4 = rect.left;
                }
                if (rect.right > i3) {
                    i3 = rect.right;
                }
                if (rect.top < i5) {
                    i5 = rect.top;
                }
                if (rect.bottom > i6) {
                    i6 = rect.bottom;
                }
            }
            this.tt.mk.set(i4, i5, i3, i6);
            d(this.tt.mk, i, i2);
        }

        public void d(Rect rect, int i, int i2) {
            u(d(i, rect.width() + np() + he(), s()), d(i2, rect.height() + yi() + vv(), us()));
        }

        public void uo() {
            RecyclerView recyclerView = this.tt;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public static int d(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        public void d(String str) {
            RecyclerView recyclerView = this.tt;
            if (recyclerView != null) {
                recyclerView.d(str);
            }
        }

        public boolean d() {
            return this.e;
        }

        public final boolean k() {
            return this.c;
        }

        void hc(RecyclerView recyclerView) {
            this.k = true;
            b(recyclerView);
        }

        void hc(RecyclerView recyclerView, cb cbVar) {
            this.k = false;
            d(recyclerView, cbVar);
        }

        public boolean e() {
            RecyclerView recyclerView = this.tt;
            return recyclerView != null && recyclerView.tt;
        }

        public void d(cb cbVar, jh jhVar) {
            com.bytedance.sdk.component.utils.mq.c("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public tc d(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof tc) {
                return new tc((tc) layoutParams);
            }
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? new tc((ViewGroup.MarginLayoutParams) layoutParams) : new tc(layoutParams);
        }

        public tc d(Context context, AttributeSet attributeSet) {
            return new tc(context, attributeSet);
        }

        public void d(RecyclerView recyclerView, jh jhVar, int i) {
            com.bytedance.sdk.component.utils.mq.c("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void d(rf rfVar) {
            rf rfVar2 = this.mq;
            if (rfVar2 != null && rfVar != rfVar2 && rfVar2.h()) {
                this.mq.u();
            }
            this.mq = rfVar;
            rfVar.d(this.tt, this);
        }

        public boolean cb() {
            rf rfVar = this.mq;
            return rfVar != null && rfVar.h();
        }

        public int w() {
            return com.bytedance.sdk.component.widget.recycler.d.b.h.d(this.tt);
        }

        public void d(View view) {
            d(view, -1);
        }

        public void d(View view, int i) {
            d(view, i, true);
        }

        public void hc(View view) {
            hc(view, -1);
        }

        public void hc(View view, int i) {
            d(view, i, false);
        }

        private void d(View view, int i, boolean z) {
            v vVarU = RecyclerView.u(view);
            if (!z && !vVarU.w()) {
                this.tt.gb.an(vVarU);
            } else {
                this.tt.gb.u(vVarU);
            }
            tc tcVar = (tc) view.getLayoutParams();
            if (!vVarU.mk() && !vVarU.tt()) {
                if (view.getParent() == this.tt) {
                    int iHc = this.gb.hc(view);
                    if (i == -1) {
                        i = this.gb.hc();
                    }
                    if (iHc == -1) {
                        throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.tt.indexOfChild(view) + this.tt.d());
                    }
                    if (iHc != i) {
                        this.tt.k.c(iHc, i);
                    }
                } else {
                    this.gb.d(view, i, false);
                    tcVar.b = true;
                    rf rfVar = this.mq;
                    if (rfVar != null && rfVar.h()) {
                        this.mq.hc(view);
                    }
                }
            } else {
                if (vVarU.tt()) {
                    vVarU.tc();
                } else {
                    vVarU.mq();
                }
                this.gb.d(view, i, view.getLayoutParams(), false);
            }
            if (tcVar.c) {
                vVarU.d.invalidate();
                tcVar.c = false;
            }
        }

        public void b(View view) {
            this.gb.d(view);
        }

        public void an(int i) {
            if (gb(i) != null) {
                this.gb.d(i);
            }
        }

        public int c(View view) {
            return ((tc) view.getLayoutParams()).c();
        }

        public View hc(int i) {
            int iRf = rf();
            for (int i2 = 0; i2 < iRf; i2++) {
                View viewGb = gb(i2);
                v vVarU = RecyclerView.u(viewGb);
                if (vVarU != null && vVarU.c() == i && !vVarU.L_() && (this.tt.j.d() || !vVarU.w())) {
                    return viewGb;
                }
            }
            return null;
        }

        public void h(int i) {
            d(i, gb(i));
        }

        private void d(int i, View view) {
            this.gb.u(i);
        }

        public void d(View view, int i, tc tcVar) {
            v vVarU = RecyclerView.u(view);
            if (vVarU.w()) {
                this.tt.gb.u(vVarU);
            } else {
                this.tt.gb.an(vVarU);
            }
            this.gb.d(view, i, tcVar, vVarU.w());
        }

        public void b(View view, int i) {
            d(view, i, (tc) view.getLayoutParams());
        }

        public void c(int i, int i2) {
            View viewGb = gb(i);
            if (viewGb == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.tt.toString());
            }
            h(i);
            b(viewGb, i2);
        }

        public void d(View view, cb cbVar) {
            b(view);
            cbVar.d(view);
        }

        public void d(int i, cb cbVar) {
            View viewGb = gb(i);
            an(i);
            cbVar.d(viewGb);
        }

        public int rf() {
            com.bytedance.sdk.component.widget.recycler.hc hcVar = this.gb;
            if (hcVar != null) {
                return hcVar.hc();
            }
            return 0;
        }

        public View gb(int i) {
            com.bytedance.sdk.component.widget.recycler.hc hcVar = this.gb;
            if (hcVar != null) {
                return hcVar.hc(i);
            }
            return null;
        }

        public int jh() {
            return this.u;
        }

        public int sy() {
            return this.an;
        }

        public int de() {
            return this.h;
        }

        public int v() {
            return this.yo;
        }

        public int np() {
            RecyclerView recyclerView = this.tt;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int yi() {
            RecyclerView recyclerView = this.tt;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int he() {
            RecyclerView recyclerView = this.tt;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int vv() {
            RecyclerView recyclerView = this.tt;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public View zw() {
            View focusedChild;
            RecyclerView recyclerView = this.tt;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.gb.b(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int j() {
            RecyclerView recyclerView = this.tt;
            d adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.d();
            }
            return 0;
        }

        public void tt(int i) {
            RecyclerView recyclerView = this.tt;
            if (recyclerView != null) {
                recyclerView.an(i);
            }
        }

        public void tc(int i) {
            RecyclerView recyclerView = this.tt;
            if (recyclerView != null) {
                recyclerView.u(i);
            }
        }

        public void d(cb cbVar) {
            for (int iRf = rf() - 1; iRf >= 0; iRf--) {
                d(cbVar, iRf, gb(iRf));
            }
        }

        private void d(cb cbVar, int i, View view) {
            v vVarU = RecyclerView.u(view);
            if (vVarU.L_()) {
                return;
            }
            if (vVarU.k() && !vVarU.w() && !this.tt.uo.hc()) {
                an(i);
                cbVar.hc(vVarU);
            } else {
                h(i);
                cbVar.b(view);
                this.tt.gb.gb(vVarU);
            }
        }

        void hc(cb cbVar) {
            int iU = cbVar.u();
            for (int i = iU - 1; i >= 0; i--) {
                View viewC = cbVar.c(i);
                v vVarU = RecyclerView.u(viewC);
                if (!vVarU.L_()) {
                    vVarU.d(false);
                    if (vVarU.yo()) {
                        this.tt.removeDetachedView(viewC, false);
                    }
                    if (this.tt.yi != null) {
                        this.tt.yi.c(vVarU);
                    }
                    vVarU.d(true);
                    cbVar.hc(viewC);
                }
            }
            cbVar.an();
            if (iU > 0) {
                this.tt.invalidate();
            }
        }

        boolean d(View view, int i, int i2, tc tcVar) {
            return (!view.isLayoutRequested() && this.b && hc(view.getWidth(), i, tcVar.width) && hc(view.getHeight(), i2, tcVar.height)) ? false : true;
        }

        private static boolean hc(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        public void d(View view, int i, int i2) {
            tc tcVar = (tc) view.getLayoutParams();
            Rect rectTt = this.tt.tt(view);
            int i3 = i + rectTt.left + rectTt.right;
            int i4 = i2 + rectTt.top + rectTt.bottom;
            int iD = d(de(), jh(), np() + he() + tcVar.leftMargin + tcVar.rightMargin + i3, tcVar.width, b());
            int iD2 = d(v(), sy(), yi() + vv() + tcVar.topMargin + tcVar.bottomMargin + i4, tcVar.height, c());
            if (d(view, iD, iD2, tcVar)) {
                view.measure(iD, iD2);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x002c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int d(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L18
                if (r7 < 0) goto L11
                goto L1a
            L11:
                if (r7 != r1) goto L2c
                if (r5 == r2) goto L1e
                if (r5 == r3) goto L1e
                goto L2c
            L18:
                if (r7 < 0) goto L1c
            L1a:
                r5 = r3
                goto L2e
            L1c:
                if (r7 != r1) goto L20
            L1e:
                r7 = r4
                goto L2e
            L20:
                if (r7 != r0) goto L2c
                if (r5 == r2) goto L29
                if (r5 == r3) goto L29
                r7 = r4
                r5 = r6
                goto L2e
            L29:
                r7 = r4
                r5 = r2
                goto L2e
            L2c:
                r5 = r6
                r7 = r5
            L2e:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.tt.d(int, int, int, int, boolean):int");
        }

        public int u(View view) {
            Rect rect = ((tc) view.getLayoutParams()).hc;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int an(View view) {
            Rect rect = ((tc) view.getLayoutParams()).hc;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void d(View view, int i, int i2, int i3, int i4) {
            tc tcVar = (tc) view.getLayoutParams();
            Rect rect = tcVar.hc;
            view.layout(i + rect.left + tcVar.leftMargin, i2 + rect.top + tcVar.topMargin, (i3 - rect.right) - tcVar.rightMargin, (i4 - rect.bottom) - tcVar.bottomMargin);
        }

        public void d(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((tc) view.getLayoutParams()).hc;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.tt != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.tt.mq;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void d(View view, Rect rect) {
            RecyclerView.d(view, rect);
        }

        public int h(View view) {
            return view.getLeft() - uo(view);
        }

        public int gb(View view) {
            return view.getTop() - mk(view);
        }

        public int tt(View view) {
            return view.getRight() + k(view);
        }

        public int tc(View view) {
            return view.getBottom() + mq(view);
        }

        public int mk(View view) {
            return ((tc) view.getLayoutParams()).hc.top;
        }

        public int mq(View view) {
            return ((tc) view.getLayoutParams()).hc.bottom;
        }

        public int uo(View view) {
            return ((tc) view.getLayoutParams()).hc.left;
        }

        public int k(View view) {
            return ((tc) view.getLayoutParams()).hc.right;
        }

        private int[] hc(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int[] iArr = new int[2];
            int iNp = np();
            int iYi = yi();
            int iDe = de() - he();
            int iV = v() - vv();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i = left - iNp;
            int iMin = Math.min(0, i);
            int i2 = top - iYi;
            int iMin2 = Math.min(0, i2);
            int i3 = iWidth - iDe;
            int iMax = Math.max(0, i3);
            int iMax2 = Math.max(0, iHeight - iV);
            if (w() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i3);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i2, iMax2);
            }
            iArr[0] = iMax;
            iArr[1] = iMin2;
            return iArr;
        }

        public boolean d(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return d(recyclerView, view, rect, z, false);
        }

        public boolean d(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] iArrHc = hc(recyclerView, view, rect, z);
            int i = iArrHc[0];
            int i2 = iArrHc[1];
            if ((z2 && !d(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.d(i, i2);
            }
            return true;
        }

        private boolean d(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int iNp = np();
            int iYi = yi();
            int iDe = de() - he();
            int iV = v() - vv();
            Rect rect = this.tt.mk;
            d(focusedChild, rect);
            return rect.left - i < iDe && rect.right - i > iNp && rect.top - i2 < iV && rect.bottom - i2 > iYi;
        }

        @Deprecated
        public boolean d(RecyclerView recyclerView, View view, View view2) {
            return cb() || recyclerView.k();
        }

        public boolean d(RecyclerView recyclerView, jh jhVar, View view, View view2) {
            return d(recyclerView, view, view2);
        }

        public void d(cb cbVar, jh jhVar, int i, int i2) {
            this.tt.u(i, i2);
        }

        public void u(int i, int i2) {
            this.tt.setMeasuredDimension(i, i2);
        }

        public int s() {
            return com.bytedance.sdk.component.widget.recycler.d.b.h.c(this.tt);
        }

        public int us() {
            return com.bytedance.sdk.component.widget.recycler.d.b.h.u(this.tt);
        }

        void z() {
            rf rfVar = this.mq;
            if (rfVar != null) {
                rfVar.u();
            }
        }

        void hc(rf rfVar) {
            if (this.mq == rfVar) {
                this.mq = null;
            }
        }

        public void b(cb cbVar) {
            for (int iRf = rf() - 1; iRf >= 0; iRf--) {
                if (!RecyclerView.u(gb(iRf)).L_()) {
                    d(iRf, cbVar);
                }
            }
        }

        void c(RecyclerView recyclerView) {
            hc(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        boolean fs() {
            int iRf = rf();
            for (int i = 0; i < iRf; i++) {
                ViewGroup.LayoutParams layoutParams = gb(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    public static abstract class d<VH extends v> {
        private final hc d = new hc();
        private boolean hc = false;

        public abstract int d();

        public int d(int i) {
            return 0;
        }

        public abstract VH d(ViewGroup viewGroup, int i);

        public void d(VH vh) {
        }

        public abstract void d(VH vh, int i);

        public long hc(int i) {
            return -1L;
        }

        public boolean hc(VH vh) {
            return false;
        }

        public void d(VH vh, int i, List<Object> list) {
            d((d<VH>) vh, i);
        }

        public final VH hc(ViewGroup viewGroup, int i) {
            try {
                com.bytedance.sdk.component.widget.recycler.d.d.d.d("RV CreateView");
                VH vh = (VH) d(viewGroup, i);
                if (vh.d.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                vh.an = i;
                return vh;
            } finally {
                com.bytedance.sdk.component.widget.recycler.d.d.d.d();
            }
        }

        public final void hc(VH vh, int i) {
            vh.b = i;
            if (hc()) {
                vh.u = hc(i);
            }
            vh.d(1, 519);
            com.bytedance.sdk.component.widget.recycler.d.d.d.d("RV OnBindView");
            d(vh, i, vh.sy());
            vh.jh();
            ViewGroup.LayoutParams layoutParams = vh.d.getLayoutParams();
            if (layoutParams instanceof tc) {
                ((tc) layoutParams).b = true;
            }
            com.bytedance.sdk.component.widget.recycler.d.d.d.d();
        }

        public final boolean hc() {
            return this.hc;
        }

        public void d(b bVar) {
            this.d.registerObserver(bVar);
        }

        public void hc(b bVar) {
            this.d.unregisterObserver(bVar);
        }

        public final void b() {
            this.d.d();
        }

        public final void d(int i, Object obj) {
            this.d.d(i, 1, obj);
        }

        public final void d(int i, int i2) {
            this.d.d(i, i2);
        }
    }

    public final class cb {
        final ArrayList<v> b;
        int c;
        final ArrayList<v> d;
        private int gb;
        private final List<v> h;
        ArrayList<v> hc;
        private sy tt;
        e u;

        public cb() {
            ArrayList<v> arrayList = new ArrayList<>();
            this.d = arrayList;
            this.hc = null;
            this.b = new ArrayList<>();
            this.h = Collections.unmodifiableList(arrayList);
            this.gb = 2;
            this.c = 2;
        }

        public void d() {
            this.d.clear();
            c();
        }

        public void d(int i) {
            this.gb = i;
            hc();
        }

        void hc() {
            this.c = this.gb + (RecyclerView.this.k != null ? RecyclerView.this.k.cb : 0);
            for (int size = this.b.size() - 1; size >= 0 && this.b.size() > this.c; size--) {
                b(size);
            }
        }

        public List<v> b() {
            return this.h;
        }

        boolean d(v vVar) {
            if (vVar.w()) {
                return RecyclerView.this.j.d();
            }
            if (vVar.b >= 0 && vVar.b < RecyclerView.this.uo.d()) {
                if (RecyclerView.this.j.d() || RecyclerView.this.uo.d(vVar.b) == vVar.gb()) {
                    return !RecyclerView.this.uo.hc() || vVar.h() == RecyclerView.this.uo.hc(vVar.b);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + vVar + RecyclerView.this.d());
        }

        private boolean d(v vVar, int i, int i2, long j) {
            vVar.cb = RecyclerView.this;
            int iGb = vVar.gb();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != LocationRequestCompat.PASSIVE_INTERVAL && !this.u.hc(iGb, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.uo.hc((d) vVar, i);
            this.u.hc(vVar.gb(), RecyclerView.this.getNanoTime() - nanoTime);
            if (!RecyclerView.this.j.d()) {
                return true;
            }
            vVar.h = i2;
            return true;
        }

        public View hc(int i) {
            return d(i, false);
        }

        View d(int i, boolean z) {
            return d(i, z, LocationRequestCompat.PASSIVE_INTERVAL).d;
        }

        /* JADX WARN: Removed duplicated region for block: B:100:0x020f  */
        /* JADX WARN: Removed duplicated region for block: B:106:0x022b A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:108:0x022e  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0182 A[PHI: r1 r4
  0x0182: PHI (r1v18 com.bytedance.sdk.component.widget.recycler.RecyclerView$v) = 
  (r1v17 com.bytedance.sdk.component.widget.recycler.RecyclerView$v)
  (r1v43 com.bytedance.sdk.component.widget.recycler.RecyclerView$v)
 binds: [B:28:0x005d, B:59:0x00fe] A[DONT_GENERATE, DONT_INLINE]
  0x0182: PHI (r4v3 boolean) = (r4v2 boolean), (r4v7 boolean) binds: [B:28:0x005d, B:59:0x00fe] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:82:0x01a3  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x01d1  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x0201  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        com.bytedance.sdk.component.widget.recycler.RecyclerView.v d(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instructions count: 621
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.cb.d(int, boolean, long):com.bytedance.sdk.component.widget.recycler.RecyclerView$v");
        }

        private void u(v vVar) {
            if (vVar.d instanceof ViewGroup) {
                d((ViewGroup) vVar.d, false);
            }
        }

        private void d(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    d((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        public void d(View view) {
            v vVarU = RecyclerView.u(view);
            if (vVarU.yo()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (vVarU.tt()) {
                vVarU.tc();
            } else if (vVarU.mk()) {
                vVarU.mq();
            }
            hc(vVarU);
        }

        void c() {
            for (int size = this.b.size() - 1; size >= 0; size--) {
                b(size);
            }
            this.b.clear();
            if (RecyclerView.c) {
                RecyclerView.this.zw.d();
            }
        }

        void b(int i) {
            d(this.b.get(i), true);
            this.b.remove(i);
        }

        void hc(v vVar) {
            boolean z;
            boolean z2 = true;
            if (!vVar.tt() && vVar.d.getParent() == null) {
                if (vVar.yo()) {
                    throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + vVar + RecyclerView.this.d());
                }
                if (vVar.L_()) {
                    throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.d());
                }
                boolean zYi = vVar.yi();
                if ((RecyclerView.this.uo != null && zYi && RecyclerView.this.uo.hc((d) vVar)) || vVar.v()) {
                    if (this.c <= 0 || vVar.d(MediaPlayer.MEDIA_PLAYER_OPTION_AVOUTSYNC_MAX_DIFF)) {
                        z = false;
                    } else {
                        int size = this.b.size();
                        if (size >= this.c && size > 0) {
                            b(0);
                            size--;
                        }
                        if (RecyclerView.c && size > 0 && !RecyclerView.this.zw.d(vVar.b)) {
                            int i = size - 1;
                            while (i >= 0) {
                                if (!RecyclerView.this.zw.d(this.b.get(i).b)) {
                                    break;
                                } else {
                                    i--;
                                }
                            }
                            size = i + 1;
                        }
                        this.b.add(size, vVar);
                        z = true;
                    }
                    if (z) {
                        z2 = false;
                    } else {
                        d(vVar, true);
                    }
                    z = z;
                } else {
                    z2 = false;
                }
                RecyclerView.this.gb.h(vVar);
                if (z || z2 || !zYi) {
                    return;
                }
                vVar.cb = null;
                return;
            }
            throw new IllegalArgumentException("Scrapped or attached views may not be recycled. isScrap:" + vVar.tt() + " isAttached:" + (vVar.d.getParent() != null) + RecyclerView.this.d());
        }

        void d(v vVar, boolean z) {
            RecyclerView.b(vVar);
            if (vVar.d(16384)) {
                vVar.d(0, 16384);
            }
            if (z) {
                c(vVar);
            }
            vVar.cb = null;
            h().d(vVar);
        }

        void hc(View view) {
            v vVarU = RecyclerView.u(view);
            vVarU.uo = null;
            vVarU.k = false;
            vVarU.mq();
            hc(vVarU);
        }

        void b(View view) {
            v vVarU = RecyclerView.u(view);
            if (!vVarU.d(12) && vVarU.he() && !RecyclerView.this.hc(vVarU)) {
                if (this.hc == null) {
                    this.hc = new ArrayList<>();
                }
                vVarU.d(this, true);
                this.hc.add(vVarU);
                return;
            }
            if (vVarU.k() && !vVarU.w() && !RecyclerView.this.uo.hc()) {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.d());
            }
            vVarU.d(this, false);
            this.d.add(vVarU);
        }

        void b(v vVar) {
            if (vVar.k) {
                this.hc.remove(vVar);
            } else {
                this.d.remove(vVar);
            }
            vVar.uo = null;
            vVar.k = false;
            vVar.mq();
        }

        int u() {
            return this.d.size();
        }

        View c(int i) {
            return this.d.get(i).d;
        }

        void an() {
            this.d.clear();
            ArrayList<v> arrayList = this.hc;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        v u(int i) {
            int size;
            int iHc;
            ArrayList<v> arrayList = this.hc;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    v vVar = this.hc.get(i2);
                    if (!vVar.mk() && vVar.c() == i) {
                        vVar.hc(32);
                        return vVar;
                    }
                }
                if (RecyclerView.this.uo.hc() && (iHc = RecyclerView.this.an.hc(i)) > 0 && iHc < RecyclerView.this.uo.d()) {
                    long jHc = RecyclerView.this.uo.hc(iHc);
                    for (int i3 = 0; i3 < size; i3++) {
                        v vVar2 = this.hc.get(i3);
                        if (!vVar2.mk() && vVar2.h() == jHc) {
                            vVar2.hc(32);
                            return vVar2;
                        }
                    }
                }
            }
            return null;
        }

        v hc(int i, boolean z) {
            View viewB;
            int size = this.d.size();
            for (int i2 = 0; i2 < size; i2++) {
                v vVar = this.d.get(i2);
                if (!vVar.mk() && vVar.c() == i && !vVar.k() && (RecyclerView.this.j.h || !vVar.w())) {
                    vVar.hc(32);
                    return vVar;
                }
            }
            if (!z && (viewB = RecyclerView.this.h.b(i)) != null) {
                v vVarU = RecyclerView.u(viewB);
                RecyclerView.this.h.u(viewB);
                int iHc = RecyclerView.this.h.hc(viewB);
                if (iHc == -1) {
                    throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + vVarU + RecyclerView.this.d());
                }
                RecyclerView.this.h.u(iHc);
                b(viewB);
                vVarU.hc(AVMDLDataLoader.KeyIsEnableSpeedEngine);
                return vVarU;
            }
            int size2 = this.b.size();
            for (int i3 = 0; i3 < size2; i3++) {
                v vVar2 = this.b.get(i3);
                if (!vVar2.k() && vVar2.c() == i) {
                    if (!z) {
                        this.b.remove(i3);
                    }
                    return vVar2;
                }
            }
            return null;
        }

        v d(long j, int i, boolean z) {
            for (int size = this.d.size() - 1; size >= 0; size--) {
                v vVar = this.d.get(size);
                if (vVar.h() == j && !vVar.mk()) {
                    if (i == vVar.gb()) {
                        vVar.hc(32);
                        if (vVar.w() && !RecyclerView.this.j.d()) {
                            vVar.d(2, 14);
                        }
                        return vVar;
                    }
                    if (!z) {
                        this.d.remove(size);
                        RecyclerView.this.removeDetachedView(vVar.d, false);
                        hc(vVar.d);
                    }
                }
            }
            int size2 = this.b.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                v vVar2 = this.b.get(size2);
                if (vVar2.h() == j) {
                    if (i == vVar2.gb()) {
                        if (!z) {
                            this.b.remove(size2);
                        }
                        return vVar2;
                    }
                    if (!z) {
                        b(size2);
                        return null;
                    }
                }
            }
        }

        void c(v vVar) {
            if (RecyclerView.this.uo != null) {
                RecyclerView.this.uo.d((d) vVar);
            }
            if (RecyclerView.this.j != null) {
                RecyclerView.this.gb.h(vVar);
            }
        }

        void d(d dVar, d dVar2, boolean z) {
            d();
            h().d(dVar, dVar2, z);
        }

        void d(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (i < i2) {
                i3 = -1;
                i5 = i;
                i4 = i2;
            } else {
                i3 = 1;
                i4 = i;
                i5 = i2;
            }
            int size = this.b.size();
            for (int i6 = 0; i6 < size; i6++) {
                v vVar = this.b.get(i6);
                if (vVar != null && vVar.b >= i5 && vVar.b <= i4) {
                    if (vVar.b == i) {
                        vVar.d(i2 - i, false);
                    } else {
                        vVar.d(i3, false);
                    }
                }
            }
        }

        void hc(int i, int i2) {
            int size = this.b.size();
            for (int i3 = 0; i3 < size; i3++) {
                v vVar = this.b.get(i3);
                if (vVar != null && vVar.b >= i) {
                    vVar.d(i2, true);
                }
            }
        }

        void d(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.b.size() - 1; size >= 0; size--) {
                v vVar = this.b.get(size);
                if (vVar != null) {
                    if (vVar.b >= i3) {
                        vVar.d(-i2, z);
                    } else if (vVar.b >= i) {
                        vVar.hc(8);
                        b(size);
                    }
                }
            }
        }

        void d(sy syVar) {
            this.tt = syVar;
        }

        void d(e eVar) {
            e eVar2 = this.u;
            if (eVar2 != null) {
                eVar2.b();
            }
            this.u = eVar;
            if (eVar == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.u.hc();
        }

        e h() {
            if (this.u == null) {
                this.u = new e();
            }
            return this.u;
        }

        void b(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.b.size() - 1; size >= 0; size--) {
                v vVar = this.b.get(size);
                if (vVar != null && (i3 = vVar.b) >= i && i3 < i4) {
                    vVar.hc(2);
                    b(size);
                }
            }
        }

        void gb() {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                v vVar = this.b.get(i);
                if (vVar != null) {
                    vVar.hc(6);
                    vVar.d((Object) null);
                }
            }
            if (RecyclerView.this.uo == null || !RecyclerView.this.uo.hc()) {
                c();
            }
        }

        void tt() {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                this.b.get(i).d();
            }
            int size2 = this.d.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.d.get(i2).d();
            }
            ArrayList<v> arrayList = this.hc;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.hc.get(i3).d();
                }
            }
        }

        void tc() {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                tc tcVar = (tc) this.b.get(i).d.getLayoutParams();
                if (tcVar != null) {
                    tcVar.b = true;
                }
            }
        }
    }

    public static class e {
        SparseArray<d> d = new SparseArray<>();
        private int hc = 0;

        public void d() {
            for (int i = 0; i < this.d.size(); i++) {
                this.d.valueAt(i).d.clear();
            }
        }

        public v d(int i) {
            d dVar = this.d.get(i);
            if (dVar == null || dVar.d.isEmpty()) {
                return null;
            }
            return dVar.d.remove(r2.size() - 1);
        }

        public void d(v vVar) {
            int iGb = vVar.gb();
            ArrayList<v> arrayList = hc(iGb).d;
            if (this.d.get(iGb).hc > arrayList.size()) {
                vVar.de();
                arrayList.add(vVar);
            }
        }

        long d(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        void d(int i, long j) {
            d dVarHc = hc(i);
            dVarHc.b = d(dVarHc.b, j);
        }

        void hc(int i, long j) {
            d dVarHc = hc(i);
            dVarHc.c = d(dVarHc.c, j);
        }

        boolean d(int i, long j, long j2) {
            long j3 = hc(i).b;
            return j3 == 0 || j + j3 < j2;
        }

        boolean hc(int i, long j, long j2) {
            long j3 = hc(i).c;
            return j3 == 0 || j + j3 < j2;
        }

        void hc() {
            this.hc++;
        }

        void b() {
            this.hc--;
        }

        void d(d dVar, d dVar2, boolean z) {
            if (dVar != null) {
                b();
            }
            if (!z && this.hc == 0) {
                d();
            }
            if (dVar2 != null) {
                hc();
            }
        }

        private d hc(int i) {
            d dVar = this.d.get(i);
            if (dVar != null) {
                return dVar;
            }
            d dVar2 = new d();
            this.d.put(i, dVar2);
            return dVar2;
        }

        static class d {
            final ArrayList<v> d = new ArrayList<>();
            int hc = 5;
            long b = 0;
            long c = 0;

            d() {
            }
        }
    }

    public static class u {
        protected EdgeEffect d(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    private class yo extends b {
        yo() {
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.b
        public void d() {
            RecyclerView.this.d((String) null);
            RecyclerView.this.j.an = true;
            RecyclerView.this.b(true);
            if (RecyclerView.this.an.c()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.b
        public void d(int i, int i2, Object obj) {
            RecyclerView.this.d((String) null);
            if (RecyclerView.this.an.d(i, i2, obj)) {
                hc();
            }
        }

        void hc() {
            if (RecyclerView.b && RecyclerView.this.yo && RecyclerView.this.w) {
                RecyclerView recyclerView = RecyclerView.this;
                com.bytedance.sdk.component.widget.recycler.d.b.h.d(recyclerView, recyclerView.tc);
            } else {
                RecyclerView.this.de = true;
                RecyclerView.this.requestLayout();
            }
        }
    }

    class de implements Runnable {
        private int c;
        OverScroller d;
        private int u;
        Interpolator hc = RecyclerView.r;
        private boolean an = false;
        private boolean h = false;

        de() {
            this.d = new OverScroller(RecyclerView.this.getContext(), RecyclerView.r);
        }

        /* JADX WARN: Removed duplicated region for block: B:43:0x00e2  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00e5  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00ec  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00f5  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 422
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.recycler.RecyclerView.de.run():void");
        }

        private void b() {
            this.h = false;
            this.an = true;
        }

        private void c() {
            this.an = false;
            if (this.h) {
                d();
            }
        }

        void d() {
            if (this.an) {
                this.h = true;
            } else {
                RecyclerView.this.removeCallbacks(this);
                com.bytedance.sdk.component.widget.recycler.d.b.h.d(RecyclerView.this, this);
            }
        }

        public void d(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.u = 0;
            this.c = 0;
            this.d.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            d();
        }

        public void hc(int i, int i2) {
            d(i, i2, 0, 0);
        }

        public void d(int i, int i2, int i3, int i4) {
            d(i, i2, hc(i, i2, i3, i4));
        }

        private float d(float f) {
            return (float) Math.sin((f - 0.5f) * 0.47123894f);
        }

        private int hc(int i, int i2, int i3, int i4) {
            int iRound;
            int iAbs = Math.abs(i);
            int iAbs2 = Math.abs(i2);
            boolean z = iAbs > iAbs2;
            int iSqrt = (int) Math.sqrt((i3 * i3) + (i4 * i4));
            int iSqrt2 = (int) Math.sqrt((i * i) + (i2 * i2));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            int i5 = width / 2;
            float f = width;
            float f2 = i5;
            float fD = f2 + (d(Math.min(1.0f, (iSqrt2 * 1.0f) / f)) * f2);
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(fD / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, 2000);
        }

        public void d(int i, int i2, int i3) {
            d(i, i2, i3, RecyclerView.r);
        }

        public void d(int i, int i2, Interpolator interpolator) {
            int iHc = hc(i, i2, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.r;
            }
            d(i, i2, iHc, interpolator);
        }

        public void d(int i, int i2, int i3, Interpolator interpolator) {
            if (this.hc != interpolator) {
                this.hc = interpolator;
                this.d = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.u = 0;
            this.c = 0;
            this.d.startScroll(0, 0, i, i2, i3);
            if (Build.VERSION.SDK_INT < 23) {
                this.d.computeScrollOffset();
            }
            d();
        }

        public void hc() {
            RecyclerView.this.removeCallbacks(this);
            this.d.abortAnimation();
        }
    }
}

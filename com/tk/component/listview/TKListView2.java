package com.tk.component.listview;

import android.content.Context;
import android.support.v7.widget.TKStaggeredGridLayoutManager;
import android.support.v7.widget.al;
import android.support.v7.widget.as;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.component.listview.layoutmanager.TKGridLayoutManger;
import com.tk.component.listview.layoutmanager.TKLinearLayoutManger;
import com.tk.component.scroll.constants.OverScrollMode;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.component.e;
import com.tk.core.component.view.TKView;
import com.tk.core.o.aa;
import com.tk.core.o.ac;
import com.tk.core.o.ad;
import com.tk.core.o.o;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.V8Object;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class TKListView2 extends e<al> implements View.OnAttachStateChangeListener, a, com.tk.component.listview.c.b {
    private boolean Ph;
    public List SA;
    public int SB;
    public HashMap SC;
    private float SD;
    private float SE;
    private int SF;
    public V8Function SG;
    private JsValueRef<V8Function> SH;
    public String SI;
    public boolean SJ;
    public long SK;
    public boolean SL;
    private TKView SM;
    private TKView SN;
    public V8Function SO;
    private JsValueRef<V8Function> SP;
    public V8Function SQ;
    private JsValueRef<V8Function> SR;
    public V8Function SS;
    private JsValueRef<V8Function> ST;
    public V8Function SU;
    private JsValueRef<V8Function> SV;
    public V8Function SW;
    public V8Function SX;
    private JsValueRef<V8Function> SY;
    public V8Function SZ;
    private com.tk.component.listview.a.a Sk;
    private com.tk.core.component.e.b Sl;
    private com.tk.component.listview.d.a Sm;
    private com.tk.component.listview.c.a Sn;
    private LayoutMode So;
    private boolean Sp;
    private boolean Sq;
    private int Sr;
    private int Ss;
    private boolean St;
    private int Su;
    private int Sv;
    private boolean Sw;
    private boolean Sx;
    private Runnable Sy;
    public List Sz;
    private JsValueRef<V8Function> Ta;
    public V8Function Tb;
    private JsValueRef<V8Function> Tc;
    public V8Function Td;
    public JsValueRef<V8Function> Te;
    public V8Function Tf;
    public JsValueRef<V8Function> Tg;
    private al.i mLayoutManager;
    private int qo;

    enum LayoutMode {
        LIST,
        GRID,
        WATERFALL
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }

    public TKListView2(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.So = LayoutMode.LIST;
        this.qo = 2;
        this.Sq = true;
        this.Sr = -1;
        this.Ss = -1;
        this.SB = 0;
        this.SD = 0.5f;
        this.SE = 0.0f;
        this.SF = 0;
        this.SI = OverScrollMode.never.name();
        this.SJ = true;
        this.SK = 400L;
        this.SL = false;
        getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tk.core.component.e
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public al n(Context context) {
        Object[] objArr = this.ZX.args;
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.Ph = ((Boolean) objArr[0]).booleanValue();
        }
        D(context);
        return this.Sm;
    }

    private void D(Context context) {
        com.tk.component.listview.d.a aVar = new com.tk.component.listview.d.a(context);
        this.Sk = new com.tk.component.listview.a.a(pO(), this.Ph);
        this.Sl = new com.tk.core.component.e.b(this.Sk);
        aVar.setAdapter(this.Sl);
        aVar.setScrollListener(this);
        aVar.setItemAnimator(null);
        this.Sm = aVar;
        this.Sm.a(new al.n() { // from class: com.tk.component.listview.TKListView2.1
            @Override // android.support.v7.widget.al.n
            public final void a(al alVar, int i, int i2) {
                super.a(alVar, i, i2);
                TKListView2.this.nC();
            }
        });
    }

    @Override // com.tk.core.component.e
    public final void a(HashMap map) {
        super.a(map);
        ns();
        c((HashMap<?, ?>) map);
    }

    private void c(HashMap<?, ?> map) {
        if (TextUtils.isEmpty(aa.t(map))) {
            return;
        }
        setClipChildren(!aa.db(r2));
    }

    private void setClipChildren(boolean z) {
        com.tk.component.listview.d.a aVar = this.Sm;
        if (aVar == null) {
            return;
        }
        aVar.setClipChildren(z);
    }

    private void ns() {
        nt();
        if (!this.Sq) {
            this.Sq = true;
            nv();
        }
        nu();
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [android.support.v7.widget.TKStaggeredGridLayoutManager, android.support.v7.widget.al$i] */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.support.v7.widget.al$i, com.tk.component.listview.layoutmanager.TKLinearLayoutManger] */
    /* JADX WARN: Type inference failed for: r0v8, types: [android.support.v7.widget.al$i, com.tk.component.listview.layoutmanager.TKGridLayoutManger] */
    private void nt() {
        if (this.Sp) {
            return;
        }
        this.Sp = true;
        int i = !this.Ph ? 1 : 0;
        int i2 = AnonymousClass4.Ti[this.So.ordinal()];
        if (i2 == 1) {
            this.mLayoutManager = new TKLinearLayoutManger(getContext(), i, false);
        } else if (i2 == 2) {
            this.mLayoutManager = new TKGridLayoutManger(getContext(), this.qo, i, false);
        } else if (i2 == 3) {
            ?? tKStaggeredGridLayoutManager = new TKStaggeredGridLayoutManager(this.qo, i);
            tKStaggeredGridLayoutManager.o(this.Sm);
            this.mLayoutManager = tKStaggeredGridLayoutManager;
        }
        this.Sm.setLayoutManager(this.mLayoutManager);
        this.Sl.t(this.Sm);
        this.Sl.at(this.mLayoutManager instanceof TKStaggeredGridLayoutManager);
        this.Sk.setIsHorizontal(this.Ph);
    }

    /* renamed from: com.tk.component.listview.TKListView2$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] Ti = new int[LayoutMode.values().length];

        static {
            try {
                Ti[LayoutMode.LIST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Ti[LayoutMode.GRID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Ti[LayoutMode.WATERFALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void nu() {
        if (this.St) {
            return;
        }
        this.St = true;
        com.tk.component.listview.b.a cVar = null;
        if (this.Ss >= 0 || this.Sr >= 0) {
            int i = AnonymousClass4.Ti[this.So.ordinal()];
            if (i == 1) {
                cVar = new com.tk.component.listview.b.c(this.Ss, this.Sr, false);
            } else if (i == 2) {
                cVar = new com.tk.component.listview.b.b(this.qo, this.Ss, this.Sr, false);
            } else if (i == 3) {
                cVar = new com.tk.component.listview.b.d(this.qo, this.Ss, this.Sr, false);
            }
        }
        this.Sm.setItemDecoration(cVar);
        if (cVar != null) {
            cVar.db(this.Sl.re());
            cVar.dc(this.Sl.rf());
        }
    }

    public final void setLayoutMode(int i) {
        LayoutMode layoutMode;
        if (i == 1) {
            layoutMode = LayoutMode.GRID;
        } else if (i != 2) {
            layoutMode = LayoutMode.LIST;
        } else {
            layoutMode = LayoutMode.WATERFALL;
        }
        if (this.So != layoutMode) {
            this.So = layoutMode;
            this.Sp = false;
        }
    }

    public final void al(int i) {
        if (this.qo == i || i <= 0) {
            return;
        }
        this.qo = i;
        this.Sp = false;
        this.St = false;
    }

    public final void setOrientation(int i) {
        boolean z = i == 1;
        if (this.Ph != z) {
            this.Ph = z;
            this.Sp = false;
            this.Sq = false;
        }
    }

    public final void cP(int i) {
        int iEb = o.eb(i);
        if (this.Sr != iEb) {
            this.Sr = iEb;
            this.St = false;
        }
    }

    public final void cQ(int i) {
        int iEb = o.eb(i);
        if (this.Ss != iEb) {
            this.Ss = iEb;
            this.St = false;
        }
    }

    public final void k(List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!(it.next() instanceof Integer)) {
                com.tk.core.exception.a.a(pO(), new IllegalArgumentException("The element in repeatedItemTypes must be integer"));
                return;
            }
        }
        this.Sz = list;
        this.Sk.k(this.Sz);
    }

    public final void cR(int i) {
        if (this.SB == i || this.Sm == null) {
            return;
        }
        this.SB = i;
        if (this.SC != null) {
            return;
        }
        this.SF = i;
        cS(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void cS(int i) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        as asVar;
        com.tk.component.listview.d.a aVar = this.Sm;
        if (aVar == null) {
            return;
        }
        if (i == 1) {
            com.tk.component.listview.c.c cVar = new com.tk.component.listview.c.c(1);
            d.d(this.Sm, 4000);
            asVar = cVar;
        } else if (i == 2) {
            com.tk.component.listview.c.c cVar2 = new com.tk.component.listview.c.c(2);
            d.d(this.Sm, 4000);
            asVar = cVar2;
        } else if (i == 3) {
            com.tk.component.listview.c.c cVar3 = new com.tk.component.listview.c.c(3);
            d.d(this.Sm, 4000);
            asVar = cVar3;
        } else {
            if (this.Sn != null) {
                d.p(aVar);
                this.Sn.onDestroy();
                return;
            }
            return;
        }
        com.tk.component.listview.c.a aVar2 = this.Sn;
        if (aVar2 != null) {
            aVar2.onDestroy();
        }
        this.Sn = asVar;
        this.Sn.a(this);
        this.Sn.q(this.SD);
        this.Sn.r(this.SE);
        asVar.a(this.Sm);
    }

    public final void d(HashMap map) {
        com.tk.component.listview.c.a aVar;
        if (map == null || map.isEmpty()) {
            this.SD = 0.5f;
            this.SE = 0.0f;
            this.SF = 0;
            this.SB = 0;
            this.SC = null;
            cS(0);
            return;
        }
        this.SC = map;
        if (this.Sm != null && map.containsKey("snapType")) {
            int iIntValue = ((Number) map.get("snapType")).intValue();
            boolean z = iIntValue != this.SF;
            float fFloatValue = map.containsKey("triggerThreshold") ? ((Number) map.get("triggerThreshold")).floatValue() : 0.5f;
            boolean z2 = z || fFloatValue != this.SD;
            this.SD = fFloatValue;
            float fP = map.containsKey("offsetToBaseLine") ? o.P(((Number) map.get("offsetToBaseLine")).floatValue()) : 0.0f;
            boolean z3 = z2 || fP != this.SE;
            this.SE = fP;
            if (z3) {
                if (this.SF == iIntValue && (aVar = this.Sn) != null) {
                    aVar.q(fFloatValue);
                    this.Sn.r(fP);
                } else {
                    this.SF = iIntValue;
                    cS(iIntValue);
                }
            }
        }
    }

    public final void ah(V8Function v8Function) {
        ad.unRetainJsValue(this.SH);
        this.SH = ad.retainJsValue(v8Function, this);
        this.SG = this.SH.get();
    }

    public final void aS(String str) {
        OverScrollMode overScrollModeValueOf = OverScrollMode.valueOf(str);
        this.SI = overScrollModeValueOf.name();
        com.tk.component.listview.d.a aVar = this.Sm;
        if (aVar != null) {
            aVar.setOverScrollMode(overScrollModeValueOf.mode);
        }
    }

    public final void N(boolean z) {
        this.SJ = z;
        com.tk.component.listview.d.a aVar = this.Sm;
        if (aVar != null) {
            aVar.setScrollEnable(z);
        }
    }

    public final void setScrollEventThrottle(long j) {
        this.SK = j;
        com.tk.component.listview.d.a aVar = this.Sm;
        if (aVar != null) {
            aVar.setScrollEventThrottle(j);
        }
    }

    public final void ac(boolean z) {
        this.SL = z;
        com.tk.component.listview.d.a aVar = this.Sm;
        if (aVar == null) {
            return;
        }
        if (this.Ph) {
            aVar.setHorizontalScrollBarEnabled(z);
        } else {
            aVar.setVerticalScrollBarEnabled(z);
        }
    }

    public final V8Object cT(int i) {
        if (this.Sm == null) {
            com.tk.core.i.a.y("TKListView2", "getVisibleItemViewByIndex mRecyclerView is null");
            return null;
        }
        int iRe = i + this.Sl.re();
        if (iRe < 0 || iRe >= this.Sl.getItemCount()) {
            com.tk.core.i.a.y("TKListView2", "getVisibleItemViewByIndex position is invalid");
            return null;
        }
        al.i layoutManager = this.Sm.getLayoutManager();
        if (layoutManager == null) {
            com.tk.core.i.a.y("TKListView2", "getVisibleItemViewByIndex layoutManager is null");
            return null;
        }
        View viewAp = layoutManager.ap(iRe);
        if (viewAp == null) {
            com.tk.core.i.a.y("TKListView2", "getVisibleItemViewByIndex itemView in position " + iRe + " is null");
            return null;
        }
        e eVarAN = e.aN(viewAp);
        if (eVarAN == null) {
            com.tk.core.i.a.y("TKListView2", "getVisibleItemViewByIndex baseView is null");
            return null;
        }
        return eVarAN.getJsObj();
    }

    public final void u(V8Object v8Object) {
        al.j jVar;
        TKView tKView = this.SM;
        if (tKView != null) {
            this.Sl.removeHeaderView(tKView.getView());
            this.SM.pM();
            this.SM.detachToRoot();
        }
        if (v8Object == null) {
            this.SM = null;
            if (getItemDecoration() != null) {
                getItemDecoration().db(0);
                return;
            }
            return;
        }
        this.SM = (TKView) getNativeModule(v8Object);
        TKView tKView2 = this.SM;
        if (tKView2 == null) {
            if (getItemDecoration() != null) {
                getItemDecoration().db(0);
                return;
            }
            return;
        }
        tKView2.pL();
        isAttachedToRoot();
        if (this.Ph) {
            jVar = new al.j(-2, -1);
        } else {
            jVar = new al.j(-1, -2);
        }
        this.Sl.a(this.SM.getView(), jVar);
        nB();
        if (getItemDecoration() != null) {
            getItemDecoration().db(this.Sl.re());
        }
    }

    public final void v(V8Object v8Object) {
        al.j jVar;
        TKView tKView = this.SN;
        if (tKView != null) {
            this.Sl.removeFooterView(tKView.getView());
            this.SN.pM();
            this.SN.detachToRoot();
        }
        if (v8Object == null) {
            this.SN = null;
            if (getItemDecoration() != null) {
                getItemDecoration().dc(0);
                return;
            }
            return;
        }
        this.SN = (TKView) getNativeModule(v8Object);
        TKView tKView2 = this.SN;
        if (tKView2 == null) {
            if (getItemDecoration() != null) {
                getItemDecoration().dc(0);
                return;
            }
            return;
        }
        tKView2.pL();
        isAttachedToRoot();
        if (this.Ph) {
            jVar = new al.j(-2, -1);
        } else {
            jVar = new al.j(-1, -2);
        }
        this.Sl.b(this.SN.getView(), jVar);
        nB();
        if (getItemDecoration() != null) {
            getItemDecoration().dc(this.Sl.rf());
        }
    }

    private com.tk.component.listview.b.a getItemDecoration() {
        com.tk.component.listview.d.a aVar = this.Sm;
        if (aVar == null) {
            return null;
        }
        return aVar.getItemDecoration();
    }

    private void nv() {
        TKView tKView = this.SM;
        if (tKView != null) {
            aI(tKView.getView());
        }
        TKView tKView2 = this.SN;
        if (tKView2 != null) {
            aI(tKView2.getView());
        }
    }

    private void aI(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (this.Ph) {
            if (layoutParams == null) {
                layoutParams = new al.j(-2, -1);
            } else {
                layoutParams.width = -2;
                layoutParams.height = -1;
            }
        } else if (layoutParams == null) {
            layoutParams = new al.j(-1, -2);
        } else {
            layoutParams.width = -1;
            layoutParams.height = -2;
        }
        try {
            view.setLayoutParams(layoutParams);
        } catch (Exception e) {
            com.tk.core.i.a.a("TKListView2", "updateLayoutParams error", e);
        }
    }

    public final void nw() {
        if (this.SM != null) {
            try {
                this.Sl.aD(0);
            } catch (Exception e) {
                com.tk.core.i.a.a("TKListView2", "notifyHeaderChanged error", e);
            }
        }
    }

    public final void nx() {
        if (this.SN != null) {
            try {
                this.Sl.aD(Math.max(0, this.Sl.getItemCount() - 1));
            } catch (Exception e) {
                com.tk.core.i.a.a("TKListView2", "notifyFooterChanged error", e);
            }
        }
    }

    public final void ai(V8Function v8Function) {
        ad.unRetainJsValue(this.SP);
        this.SP = ad.retainJsValue(v8Function, this);
        this.SO = this.SP.get();
    }

    public final void aj(V8Function v8Function) {
        ad.unRetainJsValue(this.SR);
        this.SR = ad.retainJsValue(v8Function, this);
        this.SQ = this.SR.get();
    }

    public final void ak(V8Function v8Function) {
        ad.unRetainJsValue(this.ST);
        this.ST = ad.retainJsValue(v8Function, this);
        this.SS = this.ST.get();
        this.Sk.f(this.ST);
    }

    public final void al(V8Function v8Function) {
        ad.unRetainJsValue(this.SV);
        this.SV = ad.retainJsValue(v8Function, this);
        this.SU = this.SV.get();
        this.Sk.d(this.SV);
    }

    public final void am(V8Function v8Function) {
        ad.unRetainJsValue(this.SY);
        this.SY = ad.retainJsValue(v8Function, this);
        this.SX = this.SY.get();
        this.Sk.e(this.SY);
    }

    public final void an(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.Ta);
        this.Ta = jsValueRefRetainJsValue;
        this.SZ = this.Ta.get();
    }

    public final void ao(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.Tc);
        this.Tc = jsValueRefRetainJsValue;
        this.Tb = v8Function;
        com.tk.component.listview.d.a aVar = this.Sm;
        if (aVar == null) {
            return;
        }
        JsValueRef<V8Function> jsValueRef = this.Tc;
        aVar.setOnProgressUpdatedEventEnable(jsValueRef != null && ad.isV8Valid(jsValueRef.get()));
    }

    public final void ap(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.Te);
        this.Te = jsValueRefRetainJsValue;
        this.Td = this.Te.get();
    }

    public final void aq(V8Function v8Function) {
        ad.unRetainJsValue(this.Tg);
        this.Tg = ad.retainJsValue(v8Function, this);
        this.Tf = v8Function;
        com.tk.component.listview.d.a aVar = this.Sm;
        if (aVar == null) {
            return;
        }
        JsValueRef<V8Function> jsValueRef = this.Tg;
        aVar.setOnScrolledEventEnable(jsValueRef != null && ad.isV8Valid(jsValueRef.get()));
    }

    public final void a(int i, boolean z, int i2) {
        int iCU = cU(i);
        com.tk.component.listview.d.a aVar = this.Sm;
        if (aVar == null) {
            return;
        }
        if (z) {
            aVar.smoothScrollToPosition(iCU, i2);
        } else {
            aVar.ar(iCU);
            nB();
        }
    }

    public final void aF(int i, int i2) {
        if (this.Sm == null) {
            return;
        }
        this.Sm.aL(cU(i), i2);
    }

    public final void a(int i, boolean z, int i2, int i3) {
        if (this.Sm == null) {
            return;
        }
        int iCU = cU(i);
        if (z) {
            this.Sm.k(iCU, o.eb(i2), i3);
        } else {
            this.Sm.N(iCU, o.eb(i2));
            nB();
        }
    }

    private int cU(int i) {
        if (this.SM != null) {
            i++;
        }
        return Math.min(this.Sl.getItemCount() - 1, Math.max(0, i));
    }

    public final void a(int i, int i2, boolean z, int i3, boolean z2) {
        if (this.Sm == null) {
            return;
        }
        int iEb = o.eb(i);
        int iEb2 = o.eb(i2);
        if (z) {
            this.Sm.b(iEb, iEb2, i3, z2);
        } else {
            this.Sm.scrollBy(iEb, iEb2);
        }
    }

    public final void dX() {
        com.tk.component.listview.d.a aVar = this.Sm;
        if (aVar == null) {
            return;
        }
        aVar.dX();
    }

    public final void cV(int i) {
        this.Sk.cX(i);
        nB();
    }

    public final void aE(int i) {
        this.Sk.cY(i);
        nB();
    }

    public final void ab(int i, int i2) {
        this.Sk.aH(i, i2);
        nB();
    }

    public final void aF(int i) {
        this.Sk.cZ(i);
        nB();
    }

    public final void ac(int i, int i2) {
        this.Sk.aI(i, i2);
        nB();
    }

    public final void aa(int i, int i2) {
        this.Sk.aJ(i, i2);
        nB();
    }

    public final void ny() {
        this.Sk.nD();
        nB();
    }

    public final void aD(int i) {
        this.Sk.da(i);
        nB();
    }

    public final void Z(int i, int i2) {
        this.Sk.aK(i, i2);
        nB();
    }

    @Override // com.tk.component.listview.a
    public final void p(float f) {
        if (ad.isV8Valid(this.Tb)) {
            try {
                this.Tb.call(null, Float.valueOf(f));
            } catch (Throwable th) {
                com.tk.core.exception.a.a(pO(), th);
            }
        }
    }

    @Override // com.tk.component.listview.a
    public final void q(float f, float f2) {
        JsValueRef<V8Function> jsValueRef = this.Tg;
        if (jsValueRef == null || !ad.isV8Valid(jsValueRef.get())) {
            return;
        }
        if (f == 0.0f && f2 == 0.0f) {
            return;
        }
        try {
            this.Tg.get().call(null, Float.valueOf(o.R(f)), Float.valueOf(o.R(f2)));
        } catch (Throwable th) {
            com.tk.core.exception.a.a(pO(), th);
        }
    }

    @Override // com.tk.component.listview.a
    public final void aB(int i) {
        if (ad.isV8Valid(this.Td)) {
            try {
                this.Td.call(null, i != 1 ? i != 2 ? "idle" : "settling" : "dragging");
            } catch (Throwable th) {
                com.tk.core.exception.a.a(pO(), th);
            }
        }
    }

    private void aG(int i, int i2) {
        if (ad.isV8Valid(this.SZ)) {
            try {
                this.SZ.call(null, Integer.valueOf(i), Integer.valueOf(i2));
            } catch (Throwable th) {
                com.tk.core.exception.a.a(pO(), th);
            }
        }
    }

    private void nz() {
        if (ad.isV8Valid(this.SO)) {
            try {
                this.SO.call(null, new Object[0]);
            } catch (Throwable th) {
                com.tk.core.exception.a.a(pO(), th);
            }
        }
    }

    private void nA() {
        if (ad.isV8Valid(this.SQ)) {
            try {
                this.SQ.call(null, new Object[0]);
            } catch (Throwable th) {
                com.tk.core.exception.a.a(pO(), th);
            }
        }
    }

    @Override // com.tk.component.listview.c.b
    public final void cW(int i) {
        JsValueRef<V8Function> jsValueRef = this.SH;
        if (jsValueRef == null || !ad.isV8Valid(jsValueRef.get())) {
            return;
        }
        int i2 = i - (this.SM != null ? 1 : 0);
        if (this.SN != null && i2 >= this.Sk.getItemCount()) {
            i2 = -2;
        }
        try {
            this.SH.get().call(null, Integer.valueOf(i2));
        } catch (Throwable th) {
            com.tk.core.exception.a.a(pO(), th);
        }
    }

    private void nB() {
        if (this.SZ == null && this.SQ == null && this.SO == null) {
            return;
        }
        if (this.Sy == null) {
            this.Sy = new Runnable() { // from class: com.tk.component.listview.TKListView2.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (TKListView2.this.pN()) {
                        return;
                    }
                    TKListView2.this.nC();
                }
            };
        }
        getView().post(this.Sy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nC() {
        int i;
        if (this.Sm == null) {
            return;
        }
        if (this.SZ == null && this.SQ == null && this.SO == null) {
            return;
        }
        int iRe = this.Sl.re();
        int iMax = Math.max(this.Sk.getItemCount() - 1, 0);
        int iNI = this.Sm.nI();
        int iNJ = this.Sm.nJ();
        if (iNI == -1 || iNJ == -1) {
            return;
        }
        if (iNI == 0) {
            if (!this.Sw && iRe > 0) {
                this.Sw = true;
                nz();
            }
        } else {
            this.Sw = false;
        }
        int iMax2 = Math.max(0, iNI - iRe);
        if (iMax2 <= iMax && (i = iNJ - iRe) >= 0) {
            if (i > iMax) {
                if (!this.Sx && this.SN != null) {
                    this.Sx = true;
                    nA();
                }
            } else {
                this.Sx = false;
            }
            int iMin = Math.min(Math.max(iMax2, i), iMax);
            if (iMax2 == this.Su && iMin == this.Sv) {
                return;
            }
            aG(iMax2, iMin);
            this.Su = iMax2;
            this.Sv = iMin;
        }
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void ih() {
        super.ih();
        ad.unRetainJsValue(this.Ta);
        ad.unRetainJsValue(this.Tc);
        ad.unRetainJsValue(this.SP);
        ad.unRetainJsValue(this.SR);
        ad.unRetainJsValue(this.Te);
        ad.unRetainJsValue(this.SH);
        ad.unRetainJsValue(this.Tg);
        this.Sk.nG();
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void a(TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        this.Sk.onDestroy();
        if (z) {
            mN();
        } else {
            ac.runOnUiThread(new Runnable() { // from class: com.tk.component.listview.TKListView2.3
                @Override // java.lang.Runnable
                public final void run() {
                    TKListView2.this.mN();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mN() {
        if (pQ()) {
            getView().removeOnAttachStateChangeListener(this);
        }
        if (this.SM != null) {
            this.SM = null;
        }
        if (this.SN != null) {
            this.SN = null;
        }
        com.tk.component.listview.c.a aVar = this.Sn;
        if (aVar != null) {
            aVar.onDestroy();
        }
        com.tk.component.listview.d.a aVar2 = this.Sm;
        if (aVar2 != null) {
            aVar2.setScrollListener(null);
            this.Sm = null;
        }
        this.mLayoutManager = null;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        com.tk.component.listview.d.a aVar = this.Sm;
        if (aVar != null) {
            aB(aVar.getScrollState());
        }
    }
}

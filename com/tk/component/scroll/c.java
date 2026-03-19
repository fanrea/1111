package com.tk.component.scroll;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.kuaishou.weapon.p0.t;
import com.tk.component.scroll.constants.OverScrollMode;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.component.view.TKView;
import com.tk.core.o.ac;
import com.tk.core.o.ad;
import com.tk.core.o.o;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.V8Object;
import com.tkruntime.v8.V8ObjectProxy;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class c extends com.tk.core.component.e<FrameLayout> implements View.OnAttachStateChangeListener, com.tk.component.b.a, com.tk.component.b.b {
    private static Boolean UU;
    private boolean Ph;
    private TKView Pn;
    private V8Object Po;
    public String SI;
    public boolean SJ;
    public long SK;
    public boolean SL;
    public V8Function Td;
    public JsValueRef<V8Function> Te;
    private a UV;
    private f UW;
    public boolean UX;
    public V8Function UY;
    public JsValueRef<V8Function> UZ;
    public V8Function Va;
    public JsValueRef<V8Function> Vb;
    public V8Function Vc;
    private JsValueRef<V8Function> Vd;
    public V8Function Ve;
    private JsValueRef<V8Function> Vf;
    public V8Function Vg;
    private JsValueRef<V8Function> Vh;
    public V8Function Vi;
    private JsValueRef<V8Function> Vj;
    public V8Function Vk;
    private JsValueRef<V8Function> Vl;
    public V8Function Vm;
    private JsValueRef<V8Function> Vn;
    public int Vo;
    public int Vp;
    public String Vq;

    @Override // com.tk.core.component.e, com.tkruntime.v8.DomExecutor
    public final void attachToRoot() {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }

    @Override // com.tk.core.component.e
    public final /* synthetic */ View n(Context context) {
        return nP();
    }

    public c(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.SJ = true;
        this.UX = false;
        this.SL = false;
        this.SI = OverScrollMode.never.name();
        this.Vq = null;
        getView();
        aj(this.Ph);
    }

    private FrameLayout nP() {
        Object[] objArr = this.ZX.args;
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.Ph = ((Boolean) objArr[0]).booleanValue();
        }
        if (this.Ph) {
            this.UV = new b(getContext());
        } else {
            this.UV = new e(getContext());
        }
        this.UV.setEnableAuto(pO().pu());
        this.UV.setEnableRemoveDisallowInterceptEventLogic(nT());
        this.UV.ag(false);
        this.UV.a((com.tk.component.b.b) this);
        this.UV.a((com.tk.component.b.a) this);
        FrameLayout view = this.UV.getView();
        view.addOnAttachStateChangeListener(this);
        return view;
    }

    private void aj(boolean z) {
        V8ObjectProxy v8ObjectProxy = new V8ObjectProxy(pP().pi(), "TKScrollView-container");
        this.Pn = new TKView(new NativeModuleInitParams.Builder(getTKContext(), v8ObjectProxy).build());
        v8ObjectProxy.setNativeObject(this.Pn);
        this.Po = v8ObjectProxy;
        if (z) {
            nR();
        } else {
            nS();
        }
        this.UV.setContainerView(this.Pn.getView());
        if (pO().pu()) {
            com.kwad.yoga.c yogaNode = pR().getYogaNode();
            yogaNode.setMeasureFunction(null);
            yogaNode.addChildAt(this.Pn.pR().getYogaNode(), 0);
        }
    }

    public final void N(boolean z) {
        this.SJ = z;
        a aVar = this.UV;
        if (aVar != null) {
            aVar.af(z);
        }
    }

    public final void ak(boolean z) {
        this.UX = z;
        a aVar = this.UV;
        if (aVar != null) {
            aVar.ah(z);
        }
    }

    public final void ac(boolean z) {
        this.SL = z;
        a aVar = this.UV;
        if (aVar != null) {
            aVar.ag(z);
        }
    }

    public final void aS(String str) {
        OverScrollMode overScrollModeValueOf = OverScrollMode.valueOf(str);
        this.SI = overScrollModeValueOf.name();
        a aVar = this.UV;
        if (aVar != null) {
            aVar.df(overScrollModeValueOf.mode);
        }
    }

    public final void setScrollEventThrottle(long j) {
        this.SK = j;
        a aVar = this.UV;
        if (aVar != null) {
            aVar.m(j);
        }
    }

    @Override // com.tk.core.component.e
    public final void a(HashMap map) {
        boolean z;
        boolean zStartsWith;
        if (map.containsKey("overflow")) {
            map.remove("overflow");
        }
        HashMap map2 = new HashMap();
        for (String str : com.tk.core.c.b.ZK) {
            if (map.containsKey(str)) {
                if (TextUtils.equals(str, "flexDirection")) {
                    Object obj = map.get(str);
                    if (obj instanceof String) {
                        if (this.Ph) {
                            zStartsWith = ((String) obj).startsWith(t.k);
                        } else {
                            zStartsWith = ((String) obj).startsWith("c");
                        }
                        z = !zStartsWith;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (com.tk.core.o.t.isDebug()) {
                            com.tk.core.exception.a.a(pO(), new IllegalArgumentException("flex-Direction 的赋值，必须与 ScrollView 主轴同向"));
                        }
                    } else {
                        map2.put(str, map.get(str));
                    }
                } else {
                    map2.put(str, map.get(str));
                }
                map.remove(str);
            }
        }
        super.a(map);
        this.Pn.a(map2);
    }

    public final void at(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.UZ);
        this.UZ = jsValueRefRetainJsValue;
        this.UY = this.UZ.get();
        a aVar = this.UV;
        if (aVar != null) {
            aVar.nM();
        }
    }

    public final void au(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.Vb);
        this.Vb = jsValueRefRetainJsValue;
        this.Va = this.Vb.get();
    }

    public final void av(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.Vd);
        this.Vd = jsValueRefRetainJsValue;
        this.Vc = this.Vd.get();
    }

    public final void aw(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.Vf);
        this.Vf = jsValueRefRetainJsValue;
        this.Ve = this.Vf.get();
    }

    public final void ax(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.Vh);
        this.Vh = jsValueRefRetainJsValue;
        this.Vg = this.Vh.get();
    }

    public final void ay(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.Vj);
        this.Vj = jsValueRefRetainJsValue;
        this.Vi = this.Vj.get();
    }

    public final void az(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.Vl);
        this.Vl = jsValueRefRetainJsValue;
        this.Vk = this.Vl.get();
    }

    public final void ap(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.Te);
        this.Te = jsValueRefRetainJsValue;
        this.Td = this.Te.get();
    }

    public final void aA(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.Vn);
        this.Vn = jsValueRefRetainJsValue;
        this.Vm = this.Vn.get();
    }

    public final int getOffsetX() {
        a aVar = this.UV;
        if (aVar == null) {
            return 0;
        }
        return o.ec(aVar.getOffsetX());
    }

    public final int getOffsetY() {
        a aVar = this.UV;
        if (aVar == null) {
            return 0;
        }
        return o.ec(aVar.getOffsetY());
    }

    public final void b(int i, int i2, long j) {
        if (this.UV != null) {
            this.UV.a(o.eb(i), o.eb(i2), j);
        }
    }

    public final void a(V8Object v8Object, int i, int i2, long j) {
        if (v8Object == null || this.UV == null) {
            return;
        }
        int iEb = o.eb(i);
        int iEb2 = o.eb(i2);
        try {
            com.tk.core.component.e eVar = (com.tk.core.component.e) getNativeModule(v8Object);
            int[] iArrA = a(eVar);
            if (iArrA != null && iArrA.length >= 2) {
                int i3 = 0;
                int width = iArrA[0];
                int height = iArrA[1];
                View view = eVar.getView();
                if (this.Ph) {
                    if (iEb >= 0) {
                        width -= iEb;
                    } else if (iEb2 >= 0) {
                        width = (width - getView().getWidth()) + view.getWidth() + iEb2;
                    }
                    i3 = width;
                    height = 0;
                } else if (iEb >= 0) {
                    height -= iEb;
                } else if (iEb2 >= 0) {
                    height = (height - getView().getHeight()) + view.getHeight() + iEb2;
                }
                this.UV.a(i3, height, j);
            }
        } catch (Exception e) {
            com.tk.core.exception.a.b(e, pO().hashCode());
        }
    }

    public final void a(V8Object v8Object, long j) {
        if (v8Object == null || this.UV == null) {
            return;
        }
        try {
            com.tk.core.component.e eVar = (com.tk.core.component.e) getNativeModule(v8Object);
            int[] iArrA = a(eVar);
            if (iArrA != null && iArrA.length >= 2) {
                int width = iArrA[0];
                int height = iArrA[1];
                View view = eVar.getView();
                if (this.Ph) {
                    width = (int) (width + (((int) (view.getWidth() / 2.0f)) - (getView().getWidth() / 2.0f)));
                } else {
                    height = (int) (height + (((int) (view.getHeight() / 2.0f)) - (getView().getHeight() / 2.0f)));
                }
                this.UV.a(width, height, j);
            }
        } catch (Exception e) {
            com.tk.core.exception.a.b(e, pO().hashCode());
        }
    }

    private int[] a(com.tk.core.component.e eVar) {
        if (eVar == null) {
            return null;
        }
        int[] iArr = new int[2];
        View view = eVar.getView();
        if (eVar.qq() == this.Pn) {
            iArr[0] = view.getLeft();
            iArr[1] = view.getTop();
        } else {
            int[] iArr2 = new int[2];
            view.getLocationOnScreen(iArr2);
            int[] iArr3 = new int[2];
            getView().getLocationOnScreen(iArr3);
            iArr[0] = this.UV.getOffsetX() + (iArr2[0] - iArr3[0]);
            iArr[1] = this.UV.getOffsetY() + (iArr2[1] - iArr3[1]);
        }
        return iArr;
    }

    public final void d(V8Object v8Object) {
        this.Pn.d(v8Object);
    }

    public final void e(V8Object v8Object) {
        this.Pn.e(v8Object);
    }

    public final void removeAll() {
        this.Pn.removeAll();
    }

    public final void b(V8Object v8Object, V8Object v8Object2) {
        this.Pn.b(v8Object, v8Object2);
    }

    public final void c(V8Object v8Object, V8Object v8Object2) {
        this.Pn.c(v8Object, v8Object2);
    }

    @Override // com.tk.core.component.e
    public final void nQ() {
        this.Pn.nQ();
    }

    public final V8Object aV(String str) {
        return this.Pn.aV(str);
    }

    private void nR() {
        HashMap map = new HashMap();
        map.put("flexDirection", "row");
        map.put("overflow", "hidden");
        this.Pn.a(map);
        HashMap map2 = new HashMap();
        map2.put("flexDirection", "row");
        super.a(map2);
    }

    private void nS() {
        HashMap map = new HashMap();
        map.put("flexDirection", "column");
        map.put("overflow", "hidden");
        this.Pn.a(map);
        HashMap map2 = new HashMap();
        map2.put("flexDirection", "column");
        super.a(map2);
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void ih() {
        super.ih();
        ad.unRetainJsValue(this.UZ);
        ad.unRetainJsValue(this.Vb);
        ad.unRetainJsValue(this.Vd);
        ad.unRetainJsValue(this.Vf);
        ad.unRetainJsValue(this.Vh);
        ad.unRetainJsValue(this.Vj);
        ad.unRetainJsValue(this.Vl);
        ad.unRetainJsValue(this.Vn);
        ad.unRetainJsValue(this.Te);
        V8Object v8Object = this.Po;
        if (v8Object == null || v8Object.isReleased()) {
            return;
        }
        try {
            this.Po.setWeak();
        } catch (Throwable th) {
            com.tk.core.exception.a.a(pO(), th);
        }
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void a(TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        a aVar = this.UV;
        if (aVar != null) {
            aVar.ai(z);
            this.UV = null;
        }
        ac.c(new Runnable() { // from class: com.tk.component.scroll.c.1
            @Override // java.lang.Runnable
            public final void run() {
                if (c.this.UW != null) {
                    c.this.UW.destroy();
                }
            }
        });
    }

    @Override // com.tk.component.b.b
    public final void aD(int i, int i2) {
        if (ad.isV8Valid(this.UY)) {
            try {
                this.UY.call(null, Integer.valueOf(o.ec(i)), Integer.valueOf(o.ec(i2)));
            } catch (Throwable th) {
                com.tk.core.exception.a.a(pO(), th);
            }
        }
    }

    @Override // com.tk.component.b.b
    public final void f(int i, int i2, int i3, int i4) {
        if (ad.isV8Valid(this.Vi)) {
            try {
                this.Vi.call(null, Integer.valueOf(o.ec(i)), Integer.valueOf(o.ec(i2)), Integer.valueOf(o.ec(i3)), Integer.valueOf(o.ec(i4)));
            } catch (Throwable th) {
                com.tk.core.exception.a.a(pO(), th);
            }
        }
    }

    @Override // com.tk.component.b.b
    public final void g(int i, int i2, int i3, int i4) {
        if (ad.isV8Valid(this.Vk)) {
            try {
                this.Vk.call(null, Integer.valueOf(o.ec(i)), Integer.valueOf(o.ec(i2)), Integer.valueOf(o.ec(i3)), Integer.valueOf(o.ec(i4)));
            } catch (Throwable th) {
                com.tk.core.exception.a.a(pO(), th);
            }
        }
    }

    @Override // com.tk.component.b.b
    public final void h(int i, int i2, int i3, int i4) {
        if (ad.isV8Valid(this.Va)) {
            try {
                this.Va.call(null, Integer.valueOf(o.ec(i)), Integer.valueOf(o.ec(i2)), Integer.valueOf(o.ec(i3)), Integer.valueOf(o.ec(i4)));
            } catch (Throwable th) {
                com.tk.core.exception.a.a(pO(), th);
            }
        }
    }

    @Override // com.tk.component.b.b
    public final void i(int i, int i2, int i3, int i4) {
        if (ad.isV8Valid(this.Vc)) {
            try {
                this.Vc.call(null, Integer.valueOf(o.ec(i)), Integer.valueOf(o.ec(i2)), Integer.valueOf(o.ec(i3)), Integer.valueOf(o.ec(i4)));
            } catch (Throwable th) {
                com.tk.core.exception.a.a(pO(), th);
            }
        }
    }

    @Override // com.tk.component.b.b
    public final void j(int i, int i2, int i3, int i4) {
        if (ad.isV8Valid(this.Ve)) {
            try {
                this.Ve.call(null, Integer.valueOf(o.ec(i)), Integer.valueOf(o.ec(i2)), Integer.valueOf(o.ec(i3)), Integer.valueOf(o.ec(i4)));
            } catch (Throwable th) {
                com.tk.core.exception.a.a(pO(), th);
            }
        }
    }

    @Override // com.tk.component.b.b
    public final void k(int i, int i2, int i3, int i4) {
        if (ad.isV8Valid(this.Vg)) {
            try {
                this.Vg.call(null, Integer.valueOf(o.ec(i)), Integer.valueOf(o.ec(i2)), Integer.valueOf(o.ec(i3)), Integer.valueOf(o.ec(i4)));
            } catch (Throwable th) {
                com.tk.core.exception.a.a(pO(), th);
            }
        }
    }

    @Override // com.tk.component.b.b
    public final void aB(int i) {
        if (ad.isV8Valid(this.Td)) {
            try {
                this.Td.call(null, i != 1 ? i != 2 ? "idle" : "settling" : "dragging");
            } catch (Throwable th) {
                com.tk.core.exception.a.a(pO(), th);
            }
        }
    }

    @Override // com.tk.component.b.a
    public final void aC(int i, int i2) {
        if (ad.isV8Valid(this.Vm)) {
            try {
                this.Vm.call(null, Integer.valueOf(o.ec(i)), Integer.valueOf(o.ec(i2)));
            } catch (Throwable th) {
                com.tk.core.exception.a.a(pO(), th);
            }
        }
    }

    @Override // com.tk.core.component.e, com.tkruntime.v8.DomExecutor
    public final void detachToRoot() {
        TKView tKView = this.Pn;
        if (tKView != null) {
            tKView.aaW = false;
        }
        super.detachToRoot();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        a aVar = this.UV;
        if (aVar != null) {
            aB(aVar.getScrollState());
        }
    }

    public final void aW(String str) {
        a aVar;
        if (str == null || str.equals(this.Vq) || (aVar = this.UV) == null || aVar.getView() == null || this.Ph) {
            return;
        }
        if (!(getContext() instanceof Activity)) {
            com.tk.core.i.a.a("TKScrollView", "setSoftInputMode failed: context type is not activity", null);
            return;
        }
        this.Vq = str;
        Activity activity = (Activity) getContext();
        if ("center".equals(this.Vq)) {
            if (!a(activity)) {
                com.tk.core.i.a.a("TKScrollView", "softInputMode is effective only when the activity's softInputMode is AdjustResize", null);
                return;
            } else {
                if (this.UW == null) {
                    this.UW = new f(activity, this, this.Pn, pO());
                    return;
                }
                return;
            }
        }
        f fVar = this.UW;
        if (fVar != null) {
            fVar.destroy();
            this.UW = null;
        }
    }

    public final void smoothScrollBy(int i, int i2) {
        a aVar = this.UV;
        if (aVar != null) {
            aVar.aM(i, i2);
        }
    }

    private static boolean a(Activity activity) {
        return (activity.getWindow().getAttributes().softInputMode & 16) == 16;
    }

    private static boolean nT() {
        if (UU == null && com.tk.core.a.oP().getTKSwitch() != null) {
            UU = Boolean.valueOf(com.tk.core.a.oP().getTKSwitch().oY());
        }
        Boolean bool = UU;
        return bool == null || bool.booleanValue();
    }
}

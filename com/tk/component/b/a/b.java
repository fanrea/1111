package com.tk.component.b.a;

import android.content.Context;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.component.b.a.a;
import com.tk.core.component.e;
import com.tk.core.component.view.TKView;
import com.tk.core.o.ad;
import com.tk.core.o.o;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.V8Object;
import com.tkruntime.v8.V8ObjectProxy;
import java.util.HashMap;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b extends e<a> implements a.InterfaceC0809a {
    private TKView Pn;
    private V8Object Po;
    private Boolean Pp;
    public V8Function Pq;
    public JsValueRef<V8Function> Pr;

    @Override // com.tk.core.component.e, com.tkruntime.v8.DomExecutor
    public final void attachToRoot() {
    }

    @Override // com.tk.core.component.e
    public final boolean mJ() {
        return false;
    }

    public b(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tk.core.component.e
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public a n(Context context) {
        Object[] objArr = this.ZX.args;
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.Pp = (Boolean) objArr[0];
        }
        V8ObjectProxy v8ObjectProxy = new V8ObjectProxy(pP().pi(), "ReboundView-container");
        this.Pn = new TKView(new NativeModuleInitParams.Builder(getTKContext(), v8ObjectProxy).build());
        this.Po = v8ObjectProxy;
        a aVar = new a(context);
        aVar.addView(this.Pn.getView());
        aVar.setIsHorizontal(this.Pp.booleanValue());
        aVar.setOnTargetViewOffsetListener(this);
        return aVar;
    }

    @Override // com.tk.core.component.e
    public final void a(HashMap map) {
        HashMap map2 = new HashMap();
        for (String str : com.tk.core.c.b.ZK) {
            if (map.containsKey(str)) {
                map2.put(str, map.get(str));
                map.remove(str);
            }
        }
        super.a(map);
        this.Pn.a(map2);
        if (map2.isEmpty()) {
            return;
        }
        mK();
    }

    public final void M(V8Function v8Function) {
        ad.unRetainJsValue(this.Pr);
        this.Pr = ad.retainJsValue(v8Function, this);
        JsValueRef<V8Function> jsValueRef = this.Pr;
        if (jsValueRef == null) {
            return;
        }
        this.Pq = jsValueRef.get();
    }

    public final void r(V8Object v8Object) {
        this.Pn.d(v8Object);
        mK();
    }

    private void mK() {
        if (this.Pp.booleanValue()) {
            this.Pn.pR().getYogaNode().setWidthAuto();
        } else {
            this.Pn.pR().getYogaNode().setHeightAuto();
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

    @Override // com.tk.component.b.a.a.InterfaceC0809a
    public final void cJ(int i) {
        JsValueRef<V8Function> jsValueRef = this.Pr;
        if (jsValueRef == null || !ad.isV8Valid(jsValueRef.get())) {
            return;
        }
        try {
            this.Pr.get().call(null, Integer.valueOf(o.ec(i)));
        } catch (Throwable th) {
            com.tk.core.exception.a.a(pO(), th);
        }
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void ih() {
        super.ih();
        ad.unRetainJsValue(this.Pr);
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
}

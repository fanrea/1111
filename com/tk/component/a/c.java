package com.tk.component.a;

import android.content.Context;
import android.graphics.Canvas;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.component.a.b.a;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.o.ac;
import com.tk.core.o.ad;
import com.tk.core.o.o;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.V8ObjectProxy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class c extends com.tk.core.component.e<com.tk.component.a.b.a> implements a.InterfaceC0808a {
    private volatile boolean NZ;
    private JsValueRef<?> Ob;
    private a Oc;
    private int Od;
    private int Oe;
    public V8Function Of;
    private JsValueRef<V8Function> Og;
    public V8Function Oh;
    private JsValueRef<V8Function> Oi;
    boolean Oj;
    int layerType;

    public c(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.layerType = 0;
        this.Oj = true;
        getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tk.core.component.e
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public com.tk.component.a.b.a n(Context context) {
        com.tk.component.a.b.a aVar = new com.tk.component.a.b.a(context);
        V8ObjectProxy v8ObjectProxy = new V8ObjectProxy(pP().pi(), "Canvas2D");
        this.Oc = new a(new NativeModuleInitParams.Builder(getTKContext(), v8ObjectProxy).build());
        v8ObjectProxy.setNativeObject(this.Oc);
        this.Ob = ad.retainJsValue(v8ObjectProxy, this);
        aVar.setCallback(this);
        return aVar;
    }

    public final void K(V8Function v8Function) {
        ad.unRetainJsValue(this.Og);
        this.Og = ad.retainJsValue(v8Function, this);
        this.Of = this.Og.get();
    }

    public final void L(V8Function v8Function) {
        ad.unRetainJsValue(this.Oi);
        this.Oi = ad.retainJsValue(v8Function, this);
        this.Oh = this.Oi.get();
    }

    public final void cz(int i) {
        this.layerType = i;
        getView().setLayerType(com.tk.component.a.a.a.cE(i), null);
    }

    public final void setCheckVisiblePreDraw(boolean z) {
        this.Oj = z;
        getView().setCheckVisiblePreDraw(z);
    }

    public final void mm() {
        if (this.NZ) {
            return;
        }
        getView().mm();
    }

    @Override // com.tk.component.a.b.a.InterfaceC0808a
    public final void aB(int i, int i2) {
        if (!this.NZ && ad.isV8Valid(this.Of)) {
            if (this.Od == i && this.Oe == i2) {
                return;
            }
            this.Od = i;
            this.Oe = i2;
            try {
                this.Of.call(null, Integer.valueOf(o.ec(i)), Integer.valueOf(o.ec(i2)));
            } catch (Throwable th) {
                com.tk.core.exception.a.a(pO(), th);
            }
        }
    }

    @Override // com.tk.component.a.b.a.InterfaceC0808a
    public final void i(Canvas canvas) {
        if (!this.NZ && ad.isV8Valid(this.Oh)) {
            this.Oc.h(canvas);
            try {
                this.Oh.call(null, this.Oc.getJsObj());
            } catch (Throwable th) {
                com.tk.core.exception.a.a(pO(), th);
            }
        }
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void ih() {
        super.ih();
        ad.unRetainJsValue(this.Ob);
        ad.unRetainJsValue(this.Oi);
        ad.unRetainJsValue(this.Og);
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void a(final TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        this.NZ = true;
        a aVar = this.Oc;
        if (aVar != null) {
            aVar.ml();
        }
        if (z) {
            a(destroyReason);
        } else {
            ac.runOnUiThread(new Runnable() { // from class: com.tk.component.a.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.a(destroyReason);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TKBaseNativeModule.DestroyReason destroyReason) {
        if (pQ()) {
            getView().onDestroy();
        }
        a aVar = this.Oc;
        if (aVar != null) {
            aVar.a(destroyReason, true);
        }
    }
}

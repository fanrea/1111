package com.tk.component.g.a;

import android.view.View;
import com.tk.component.scroll.b.b.h;
import com.tk.core.o.ad;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.V8Object;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a implements h.g {
    private volatile boolean AQ;
    private com.tk.core.bridge.b EW;
    private JsValueRef<V8Function> XJ;

    public a(com.tk.core.bridge.b bVar) {
        this.EW = bVar;
    }

    public final void j(JsValueRef<V8Function> jsValueRef) {
        ad.unRetainJsValue(this.XJ);
        this.XJ = jsValueRef;
    }

    @Override // com.tk.component.scroll.b.b.h.g
    public final void c(View view, float f) {
        JsValueRef<V8Function> jsValueRef;
        V8Object v8Object;
        if (this.AQ || (jsValueRef = this.XJ) == null) {
            return;
        }
        V8Function v8Function = jsValueRef.get();
        if (ad.isV8Valid(v8Function)) {
            try {
                v8Object = (V8Object) v8Function.call(null, Float.valueOf(f));
            } catch (Throwable th) {
                com.tk.core.exception.a.a(this.EW, th);
                v8Object = null;
            }
            if (v8Object != null) {
                c.a(view, v8Object.getAll());
                try {
                    v8Object.setWeak();
                } catch (Throwable th2) {
                    com.tk.core.exception.a.a(this.EW, th2);
                }
            }
        }
    }

    public final void nG() {
        ad.unRetainJsValue(this.XJ);
    }

    public final void onDestroy() {
        this.AQ = true;
        this.EW = null;
    }
}

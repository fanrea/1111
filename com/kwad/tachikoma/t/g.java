package com.kwad.tachikoma.t;

import com.tk.core.o.ad;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.V8Object;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class g {
    private JsValueRef<V8Function> EV;
    private com.tk.core.bridge.b EW;

    public g(V8Function v8Function, com.tk.core.bridge.b bVar) {
        this.EV = ad.retainJsValue(v8Function, this);
        this.EW = bVar;
    }

    public final Object call(V8Object v8Object, Object... objArr) {
        if (b.b(this.EV)) {
            try {
                return this.EV.get().call(null, objArr);
            } catch (Throwable th) {
                com.tk.core.exception.a.a(this.EW, th);
            }
        }
        return null;
    }

    public final V8 getRuntime() {
        if (b.b(this.EV)) {
            return this.EV.get().getRuntime();
        }
        return null;
    }

    public final void destroy() {
        if (b.b(this.EV)) {
            ad.unRetainJsValue(this.EV);
        }
        this.EW = null;
    }
}

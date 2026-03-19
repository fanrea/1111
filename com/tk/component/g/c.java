package com.tk.component.g;

import com.tk.component.scroll.b.b.h;
import com.tk.core.o.ad;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
final class c extends h.e {
    private long SK = 400;
    private volatile boolean TA;
    private JsValueRef<V8Function> Xb;
    private JsValueRef<V8Function> Xc;
    private JsValueRef<V8Function> Xd;
    private a Xe;
    private b Xf;
    private long Xg;
    private boolean Xh;
    private com.tk.core.bridge.b mTKJSContext;

    c(a aVar, com.tk.core.bridge.b bVar) {
        this.Xe = aVar;
        this.mTKJSContext = bVar;
    }

    public final void setScrollEventThrottle(long j) {
        this.SK = j;
    }

    public final void a(b bVar) {
        this.Xf = bVar;
    }

    public final void g(JsValueRef<V8Function> jsValueRef) {
        ad.unRetainJsValue(this.Xc);
        this.Xc = jsValueRef;
    }

    public final void h(JsValueRef<V8Function> jsValueRef) {
        ad.unRetainJsValue(this.Xb);
        this.Xb = jsValueRef;
    }

    public final void i(JsValueRef<V8Function> jsValueRef) {
        ad.unRetainJsValue(this.Xd);
        this.Xd = jsValueRef;
    }

    @Override // com.tk.component.scroll.b.b.h.e
    public final void di(int i) {
        if (this.TA) {
            return;
        }
        b bVar = this.Xf;
        if (bVar != null) {
            bVar.oF();
        }
        JsValueRef<V8Function> jsValueRef = this.Xb;
        if (jsValueRef == null) {
            return;
        }
        V8Function v8Function = jsValueRef.get();
        if (ad.isV8Valid(v8Function)) {
            try {
                v8Function.call(null, Integer.valueOf(cU(i)));
            } catch (Throwable th) {
                com.tk.core.exception.a.a(this.mTKJSContext, th);
            }
        }
    }

    @Override // com.tk.component.scroll.b.b.h.e
    public final void a(int i, float f, int i2) {
        JsValueRef<V8Function> jsValueRef;
        if (this.TA || (jsValueRef = this.Xc) == null) {
            return;
        }
        V8Function v8Function = jsValueRef.get();
        if (ad.isV8Valid(v8Function)) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (f == 0.0f || f == 1.0f || jCurrentTimeMillis - this.Xg > this.SK) {
                this.Xg = jCurrentTimeMillis;
                try {
                    v8Function.call(null, Integer.valueOf(cU(i)), Float.valueOf(f));
                } catch (Throwable th) {
                    com.tk.core.exception.a.a(this.mTKJSContext, th);
                }
            }
        }
    }

    @Override // com.tk.component.scroll.b.b.h.e
    public final void dj(int i) {
        if (this.TA) {
            return;
        }
        b bVar = this.Xf;
        if (bVar != null) {
            bVar.oG();
        }
        JsValueRef<V8Function> jsValueRef = this.Xd;
        if (jsValueRef == null) {
            return;
        }
        V8Function v8Function = jsValueRef.get();
        if (ad.isV8Valid(v8Function)) {
            String str = "settling";
            if (i != 1) {
                if (i != 2) {
                    str = "idle";
                }
            } else if (!this.Xh) {
                str = "dragging";
            }
            try {
                v8Function.call(null, str);
            } catch (Throwable th) {
                com.tk.core.exception.a.a(this.mTKJSContext, th);
            }
        }
    }

    public final void am(boolean z) {
        this.Xh = z;
    }

    private int cU(int i) {
        a aVar = this.Xe;
        return aVar == null ? i : aVar.cU(i);
    }

    public final void oH() {
        this.TA = true;
    }

    public final void onDestroy() {
        oH();
        this.Xe = null;
        this.Xf = null;
        this.mTKJSContext = null;
    }

    public final void nG() {
        ad.unRetainJsValue(this.Xb);
        ad.unRetainJsValue(this.Xc);
        ad.unRetainJsValue(this.Xd);
    }
}

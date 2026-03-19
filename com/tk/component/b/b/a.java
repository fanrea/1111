package com.tk.component.b.b;

import android.graphics.Bitmap;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.o.ac;
import com.tk.core.o.ad;
import com.tk.core.o.o;
import com.tk.core.o.q;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends TKBaseNativeModule {
    private Bitmap BF;
    private JsValueRef<V8Function> PA;
    private String Ps;
    private int Pt;
    private int Pu;
    private int Pv;
    private int Pw;
    public V8Function Px;
    private JsValueRef<V8Function> Py;
    public V8Function Pz;
    private int km;
    private int us;

    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.Pv = Integer.MAX_VALUE;
        this.Pw = Integer.MAX_VALUE;
        Object[] objArr = this.ZX.args;
        if (objArr == null) {
            return;
        }
        if (objArr.length > 0 && (objArr[0] instanceof String)) {
            this.Ps = (String) objArr[0];
        }
        if (objArr.length > 1 && (objArr[1] instanceof Number)) {
            this.Pv = o.eb(((Number) objArr[1]).intValue());
            if (this.Pv <= 0) {
                this.Pv = Integer.MAX_VALUE;
            }
        }
        if (objArr.length <= 2 || !(objArr[2] instanceof Number)) {
            return;
        }
        this.Pw = o.eb(((Number) objArr[2]).intValue());
        if (this.Pw <= 0) {
            this.Pw = Integer.MAX_VALUE;
        }
    }

    public final void N(V8Function v8Function) {
        ad.unRetainJsValue(this.Py);
        this.Py = ad.retainJsValue(v8Function, this);
        this.Px = this.Py.get();
    }

    public final void O(V8Function v8Function) {
        ad.unRetainJsValue(this.PA);
        this.PA = ad.retainJsValue(v8Function, this);
        this.Pz = this.PA.get();
    }

    public final void mL() {
        q.a(getContext(), this.Ps, pn(), this.Pv, this.Pw, new com.tk.core.a.a() { // from class: com.tk.component.b.b.a.1
            @Override // com.tk.core.a.a
            public final void a(final Bitmap bitmap) {
                ac.runOnUiThread(new Runnable() { // from class: com.tk.component.b.b.a.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (bitmap == null) {
                            a.this.ao("Load failed.");
                            return;
                        }
                        a.this.Pt = bitmap.getWidth();
                        a.this.Pu = bitmap.getHeight();
                        a.this.us = o.ec(a.this.Pt);
                        a.this.km = o.ec(a.this.Pu);
                        a.this.BF = bitmap;
                        a.this.aE(a.this.us, a.this.km);
                    }
                });
            }
        });
    }

    public final Map<String, Object> mM() {
        HashMap map = new HashMap();
        map.put("width", Integer.valueOf(this.us));
        map.put("height", Integer.valueOf(this.km));
        return map;
    }

    public final Bitmap getBitmap() {
        return this.BF;
    }

    public final int getWidth() {
        return this.Pt;
    }

    public final int getHeight() {
        return this.Pu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(String str) {
        if (ad.isV8Valid(this.Pz)) {
            try {
                this.Pz.call(null, str);
            } catch (Throwable th) {
                com.tk.core.exception.a.a(pO(), th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(int i, int i2) {
        if (ad.isV8Valid(this.Px)) {
            try {
                this.Px.call(null, Integer.valueOf(i), Integer.valueOf(i2));
            } catch (Throwable th) {
                com.tk.core.exception.a.a(pO(), th);
            }
        }
    }

    @Override // com.tk.core.component.TKBaseNativeModule
    public final void ih() {
        super.ih();
        ad.unRetainJsValue(this.Py);
        ad.unRetainJsValue(this.PA);
    }

    @Override // com.tk.core.component.TKBaseNativeModule
    public final void a(TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        if (z) {
            mN();
        } else {
            ac.runOnUiThread(new Runnable() { // from class: com.tk.component.b.b.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.mN();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mN() {
        this.BF = null;
    }
}

package com.tk.core.b;

import android.text.TextUtils;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.o.ac;
import com.tk.core.o.ad;
import com.tk.core.o.p;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends TKBaseNativeModule {
    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
    }

    public static void set(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null || com.tk.core.a.oP().oT() == null) {
            return;
        }
        com.tk.core.a.oP().oT().set(str, obj);
    }

    public static Object get(String str) {
        if (com.tk.core.a.oP().oT() == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return com.tk.core.a.oP().oT().get(str);
    }

    public final void k(final String str, V8Function v8Function) {
        final JsValueRef jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        if (jsValueRefRetainJsValue == null) {
            return;
        }
        final V8Function v8Function2 = (V8Function) jsValueRefRetainJsValue.get();
        p.execute(new Runnable() { // from class: com.tk.core.b.a.1
            @Override // java.lang.Runnable
            public final void run() {
                final Object obj = null;
                try {
                    if (com.tk.core.a.oP().oT() != null && !TextUtils.isEmpty(str)) {
                        obj = com.tk.core.a.oP().oT().get(str);
                    }
                    ac.runOnUiThread(new Runnable() { // from class: com.tk.core.b.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                if (ad.isV8Valid(v8Function2)) {
                                    try {
                                        v8Function2.call(null, obj);
                                    } catch (Exception e) {
                                        com.tk.core.exception.a.b(e, a.this.pO().hashCode());
                                    }
                                }
                            } finally {
                                ad.unRetainJsValue(jsValueRefRetainJsValue);
                            }
                        }
                    });
                } catch (Throwable th) {
                    com.tk.core.exception.a.b(th, a.this.pO().hashCode());
                }
            }
        });
    }

    public static void remove(String str) {
        if (com.tk.core.a.oP().oT() == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.tk.core.a.oP().oT().remove(str);
    }

    public static boolean exist(String str) {
        if (com.tk.core.a.oP().oT() == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return com.tk.core.a.oP().oT().exist(str);
    }

    public final void l(final String str, V8Function v8Function) {
        final JsValueRef jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        if (jsValueRefRetainJsValue == null) {
            return;
        }
        final V8Function v8Function2 = (V8Function) jsValueRefRetainJsValue.get();
        p.execute(new Runnable() { // from class: com.tk.core.b.a.2
            @Override // java.lang.Runnable
            public final void run() {
                final boolean zExist = false;
                try {
                    if (com.tk.core.a.oP().oT() != null && !TextUtils.isEmpty(str)) {
                        zExist = com.tk.core.a.oP().oT().exist(str);
                    }
                    ac.runOnUiThread(new Runnable() { // from class: com.tk.core.b.a.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                if (ad.isV8Valid(v8Function2)) {
                                    try {
                                        v8Function2.call(null, Boolean.valueOf(zExist));
                                    } catch (Exception e) {
                                        com.tk.core.exception.a.b(e, a.this.pO().hashCode());
                                    }
                                }
                            } finally {
                                ad.unRetainJsValue(jsValueRefRetainJsValue);
                            }
                        }
                    });
                } catch (Throwable th) {
                    com.tk.core.exception.a.b(th, a.this.pO().hashCode());
                }
            }
        });
    }
}

package com.kwad.tachikoma.c;

import com.kuaishou.tk.api.export.sdk.V8Proxy;
import com.kwad.tachikoma.t.i;
import com.tkruntime.v8.JavaCallback;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8;
import com.tkruntime.v8.V8Array;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.V8Object;
import com.tkruntime.v8.V8Value;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class d {
    public static Object a(V8 v8, Object obj, V8Object v8Object) {
        if (i.u(obj)) {
            return obj;
        }
        if (obj instanceof V8Value) {
            return a(v8, (V8Value) obj, v8Object);
        }
        return null;
    }

    public static V8Value a(final V8 v8, V8Value v8Value, final V8Object v8Object) {
        if (v8 == null) {
            return null;
        }
        if (v8.equals(v8Value.v8)) {
            return v8Value;
        }
        if (v8Value instanceof V8Function) {
            final V8Function v8Function = (V8Function) v8Value;
            return new V8Function(v8, new JavaCallback() { // from class: com.kwad.tachikoma.c.d.1
                @Override // com.tkruntime.v8.JavaCallback
                public final Object invoke(V8Object v8Object2, Object[] objArr) throws Throwable {
                    if (!V8Proxy.isV8Valid(v8Function)) {
                        return null;
                    }
                    Object[] objArr2 = new Object[objArr.length];
                    if (objArr != null) {
                        for (int i = 0; i < objArr.length; i++) {
                            objArr2[i] = d.a(v8Function.v8, objArr[i], (V8Object) null);
                        }
                    }
                    return d.a(v8, v8Function.call(v8Object, objArr2), (V8Object) null);
                }
            });
        }
        if (v8Value instanceof V8Array) {
            V8Array v8Array = (V8Array) v8Value;
            V8Array v8Array2 = new V8Array(v8);
            for (int i = 0; i < v8Array.length(); i++) {
                Object objA = a(v8, v8Array.get(i), v8Object);
                if (objA != null) {
                    v8Array2.push(objA);
                } else {
                    v8Array2.pushNull();
                }
            }
            return v8Array2;
        }
        if (v8Value instanceof V8Object) {
            return com.kwad.tachikoma.q.c.a(v8, new a((V8Object) v8Value));
        }
        return null;
    }

    public static class a implements com.kwad.tachikoma.q.b {
        private final JsValueRef<V8Object> BQ;
        private WeakReference<V8> BR;

        public a(V8Object v8Object) {
            this.BQ = com.kwad.tachikoma.t.b.a(v8Object, this);
        }

        @Override // com.kwad.tachikoma.q.b
        public final Object get(String str) {
            if (!com.kwad.tachikoma.t.b.c(this.BQ) || this.BR == null) {
                return null;
            }
            return d.a(this.BR.get(), this.BQ.get().get(str), this.BQ.get());
        }

        @Override // com.kwad.tachikoma.q.b
        public final void set(String str, Object obj) {
            if (com.kwad.tachikoma.t.b.c(this.BQ)) {
                if (obj instanceof String) {
                    this.BQ.get().add(str, (String) obj);
                    return;
                }
                if (obj instanceof Boolean) {
                    this.BQ.get().add(str, ((Boolean) obj).booleanValue());
                    return;
                }
                if (obj instanceof Double) {
                    this.BQ.get().add(str, ((Double) obj).doubleValue());
                    return;
                }
                if (obj instanceof Float) {
                    this.BQ.get().add(str, ((Float) obj).floatValue());
                    return;
                }
                if (obj instanceof Long) {
                    this.BQ.get().add(str, ((Long) obj).longValue());
                    return;
                }
                if (obj instanceof Integer) {
                    this.BQ.get().add(str, ((Integer) obj).intValue());
                } else if (obj instanceof V8Value) {
                    V8Value v8Value = (V8Value) obj;
                    WeakReference<V8> weakReference = this.BR;
                    this.BQ.get().add(str, d.a(weakReference != null ? weakReference.get() : null, v8Value, this.BQ.get()));
                }
            }
        }

        @Override // com.kwad.tachikoma.q.b
        public final void a(V8 v8) {
            this.BR = new WeakReference<>(v8);
        }
    }
}

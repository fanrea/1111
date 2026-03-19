package com.kwad.tachikoma.t;

import com.kuaishou.tk.api.export.sdk.V8Proxy;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.V8Object;
import com.tkruntime.v8.V8Value;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b {
    public static boolean b(JsValueRef<V8Function> jsValueRef) {
        return (jsValueRef == null || jsValueRef.get() == null || jsValueRef.get().isReleased()) ? false : true;
    }

    public static boolean c(JsValueRef<V8Object> jsValueRef) {
        return (jsValueRef == null || jsValueRef.get() == null || jsValueRef.get().isReleased()) ? false : true;
    }

    public static JsValueRef a(V8Value v8Value, Object obj) {
        return V8Proxy.retainJsValue(v8Value, obj);
    }
}

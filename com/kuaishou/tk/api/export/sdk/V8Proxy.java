package com.kuaishou.tk.api.export.sdk;

import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Object;
import com.tkruntime.v8.V8Value;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class V8Proxy {
    public static boolean isV8Valid(V8Object v8Object) {
        return (v8Object == null || v8Object.isUndefined() || v8Object.isReleased()) ? false : true;
    }

    public static JsValueRef retainJsValue(V8Value v8Value, Object obj) {
        if (v8Value == null || v8Value.isReleased()) {
            return null;
        }
        return v8Value.clearWeak(obj);
    }

    public static void unRetainJsValue(JsValueRef<?> jsValueRef) {
        if (jsValueRef != null) {
            jsValueRef.setWeak();
        }
    }
}

package com.kwad.tachikoma.c;

import com.kuaishou.tk.api.TKContext;
import com.kwad.tachikoma.c.d;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.V8Object;
import com.tkruntime.v8.V8Value;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b {
    private Map<String, Map<String, JsValueRef<V8Object>>> BK = new HashMap();
    private Map<String, Map<String, JsValueRef<V8Function>>> BL = new HashMap();

    static class a {
        private static final b BM = new b();
    }

    public static b id() {
        return a.BM;
    }

    public final void a(String str, String str2, V8Object v8Object) {
        Map<String, JsValueRef<V8Object>> map = this.BK.get(str);
        if (map == null) {
            map = new HashMap<>();
            this.BK.put(str, map);
        }
        map.put(str2, com.kwad.tachikoma.t.b.a(v8Object, this));
    }

    public final void a(String str, String str2, V8Function v8Function) {
        Map<String, JsValueRef<V8Function>> map = this.BL.get(str);
        if (map == null) {
            map = new HashMap<>();
            this.BL.put(str, map);
        }
        map.put(str2, com.kwad.tachikoma.t.b.a(v8Function, this));
    }

    public final V8Value a(TKContext tKContext, String str, String str2, Object obj) throws Throwable {
        Map<String, JsValueRef<V8Object>> map = this.BK.get(str);
        if (map != null) {
            JsValueRef<V8Object> jsValueRef = map.get(str2);
            if (com.kwad.tachikoma.t.b.c(jsValueRef)) {
                return com.kwad.tachikoma.q.c.a(tKContext.getV8Context(), new d.a(jsValueRef.get()));
            }
        }
        Map<String, JsValueRef<V8Function>> map2 = this.BL.get(str);
        if (map2 != null) {
            JsValueRef<V8Function> jsValueRef2 = map2.get(str2);
            if (com.kwad.tachikoma.t.b.b(jsValueRef2)) {
                Object objCall = jsValueRef2.get().call(null, obj);
                if (objCall instanceof V8Object) {
                    return com.kwad.tachikoma.q.c.a(tKContext.getV8Context(), new d.a((V8Object) objCall));
                }
            }
        }
        return null;
    }

    public final void unloadBundle(String str) {
        this.BL.remove(str);
        this.BK.remove(str);
    }
}

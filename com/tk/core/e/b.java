package com.tk.core.e;

import com.tk.core.manager.d;
import com.tk.core.o.ad;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;
import java.util.List;
import java.util.Map;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b {

    public interface a {
        void a(com.tk.core.e.a.b bVar);
    }

    public static Object a(List<JsValueRef<V8Function>> list, String str, com.tk.core.bridge.a aVar, a aVar2) {
        com.tk.core.e.a.rC();
        String strCx = com.tk.core.e.a.cx(str);
        com.tk.core.manager.a.a aVarCN = d.rZ().cN(strCx);
        if (aVarCN == null) {
            return null;
        }
        com.tk.core.e.a.b bVar = (com.tk.core.e.a.b) aVarCN.b(null);
        aVar2.a(bVar);
        Map<String, Object> mapB = d.rZ().b(strCx, bVar);
        try {
            for (JsValueRef<V8Function> jsValueRef : list) {
                if (jsValueRef != null && jsValueRef.get() != null && ad.isV8Valid(jsValueRef.get())) {
                    jsValueRef.get().call(null, mapB);
                }
            }
        } catch (Throwable th) {
            com.tk.core.exception.a.b(th, aVar.pg());
        }
        return null;
    }
}

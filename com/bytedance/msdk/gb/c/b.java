package com.bytedance.msdk.gb.c;

import com.alipay.sdk.m.l.a;
import com.bytedance.sdk.component.b.hc.he;
import com.bytedance.sdk.component.hc.d.cb;
import com.bytedance.sdk.component.hc.d.k;
import com.bytedance.sdk.component.hc.d.tt;
import com.bytedance.sdk.component.utils.mq;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    public static Map<String, Object> d;

    public static void d(Map map) {
        d = map;
    }

    public static boolean d() {
        return com.bytedance.msdk.core.d.mk().yi();
    }

    public static class d implements tt {
        @Override // com.bytedance.sdk.component.hc.d.tt
        public cb d(tt.d dVar) throws IOException {
            k kVarD = dVar.d();
            String string = kVarD.hc().toString();
            if (string.contains("/api/ad/union/mediation/config") || string.contains("/api/ad/union/mediation/exchange")) {
                kVarD = hc(dVar);
            }
            return dVar.d(kVarD);
        }

        private k hc(tt.d dVar) {
            try {
                Field field = dVar.getClass().getDeclaredFields()[0];
                field.setAccessible(true);
                Object obj = field.get(dVar);
                Field declaredField = obj.getClass().getDeclaredField("request");
                declaredField.setAccessible(true);
                he heVar = (he) declaredField.get(obj);
                declaredField.set(obj, heVar.an().d(String.valueOf(dVar.d().hc().h().hc("b4oil169.fn.bytedance.net").d(a.r).hc())).hc("case-id", (String) b.d.get("case_id")).d());
                return dVar.d();
            } catch (Throwable th) {
                mq.d(th);
                return dVar.d();
            }
        }
    }
}

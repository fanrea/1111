package com.kwad.sdk.p;

import android.content.Context;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.bh;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class l {
    private static a cqJ;
    private static final AtomicBoolean mHasInit = new AtomicBoolean(false);

    public static class a extends com.kwad.sdk.core.response.a.a {
        public List<String> cqL;
        public List<C0631a> cqM;

        /* renamed from: com.kwad.sdk.p.l$a$a, reason: collision with other inner class name */
        public static class C0631a extends com.kwad.sdk.core.response.a.a {
            public String cqN;
            public String cqO;
        }
    }

    public static boolean fa(Context context) {
        a aVar = cqJ;
        if (aVar == null || ap.aF(aVar.cqL) || ap.aF(cqJ.cqM) || !a(context, cqJ)) {
            return false;
        }
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (a(stackTraceElement, cqJ)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(Context context, a aVar) {
        String name = context.getClass().getName();
        Iterator it = new CopyOnWriteArrayList(aVar.cqL).iterator();
        while (it.hasNext()) {
            if (ap.a((String) it.next(), name)) {
                com.kwad.sdk.core.d.c.d("WrapperBlackHelper", "isBlackClass");
                return true;
            }
        }
        return false;
    }

    private static boolean a(StackTraceElement stackTraceElement, a aVar) {
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        for (a.C0631a c0631a : new CopyOnWriteArrayList(aVar.cqM)) {
            String str = c0631a.cqN;
            String str2 = c0631a.cqO;
            if (ap.a(str, className) && ap.a(str2, methodName)) {
                com.kwad.sdk.core.d.c.d("WrapperBlackHelper", "isBlackMethod");
                return true;
            }
        }
        return false;
    }

    public static void acs() {
        if (mHasInit.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.utils.h.execute(new bh() { // from class: com.kwad.sdk.p.l.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                a unused = l.cqJ = new a();
                try {
                    l.cqJ.parseJson((JSONObject) ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getAppConfigData(null, new com.kwad.sdk.g.b<JSONObject, JSONObject>() { // from class: com.kwad.sdk.p.l.1.1
                        @Override // com.kwad.sdk.g.b
                        public final /* synthetic */ JSONObject apply(JSONObject jSONObject) {
                            return r(jSONObject);
                        }

                        private static JSONObject r(JSONObject jSONObject) {
                            if (jSONObject == null) {
                                return null;
                            }
                            jSONObject.optJSONObject("wrapperBlackConfig");
                            return null;
                        }
                    }));
                } catch (Throwable unused2) {
                }
            }
        });
    }
}

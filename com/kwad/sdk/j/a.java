package com.kwad.sdk.j;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.z;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* renamed from: com.kwad.sdk.j.a$a, reason: collision with other inner class name */
    public static class C0617a extends com.kwad.sdk.commercial.c.a {
        public String bMW;
        public int cgi;
        public String sdkVersion;
    }

    public static class b extends com.kwad.sdk.commercial.c.a {
        public int cgj;
        public String cgk;
        public String cgl;
        public String cgm;
        public String cgn;
        public String cgo;
    }

    public static void amb() {
        h.execute(new bh() { // from class: com.kwad.sdk.j.a.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                a.amc();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void amc() {
        C0617a c0617aA;
        JSONObject jSONObject = (JSONObject) e.Yi().getAppConfigData(null, new com.kwad.sdk.g.b<JSONObject, JSONObject>() { // from class: com.kwad.sdk.j.a.2
            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ JSONObject apply(JSONObject jSONObject2) {
                return r(jSONObject2);
            }

            private static JSONObject r(JSONObject jSONObject2) {
                return jSONObject2.optJSONObject("sdkTTPerfMonitor");
            }
        });
        if (jSONObject == null) {
            return;
        }
        b bVar = new b();
        try {
            bVar.parseJson(jSONObject);
            if (bVar.cgj == 1 && (c0617aA = a(ServiceProvider.getContext().getClassLoader(), bVar)) != null) {
                com.kwad.sdk.commercial.b.d(c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(0.01d).V("ad_sdk_tt_sdk_info", "sv").w(c0617aA).a(com.kwai.adclient.kscommerciallogger.model.a.crg));
            }
        } catch (Throwable unused) {
        }
    }

    private static C0617a a(ClassLoader classLoader, b bVar) {
        Class<?> clsA = z.a(bVar.cgk, classLoader);
        if (clsA == null) {
            return null;
        }
        C0617a c0617a = new C0617a();
        c0617a.cgi = z.classExists(bVar.cgl) ? 1 : 0;
        Object objCallStaticMethod = z.callStaticMethod(clsA, bVar.cgm, new Object[0]);
        c0617a.sdkVersion = (String) z.callMethod(objCallStaticMethod, bVar.cgn, new Object[0]);
        c0617a.bMW = (String) z.callMethod(objCallStaticMethod, bVar.cgo, new Object[0]);
        return c0617a;
    }
}

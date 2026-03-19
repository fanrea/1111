package com.kwad.sdk.core.adlog;

import com.kwad.components.ad.reward.monitor.FraudVerifyCode;
import com.kwad.components.ct.api.tube.KSTubeParamInner;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.g;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b {
    public static void a(final com.kwad.sdk.core.adlog.c.a aVar) {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.sdk.core.adlog.b.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                a aVar2 = new a(aVar);
                b.a(aVar2.getUrl(), aVar2.getBody(), aVar, null);
            }
        });
    }

    public static void Xf() {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.sdk.core.adlog.b.2
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                com.kwad.sdk.core.adlog.a.a aVarXl = com.kwad.sdk.core.adlog.a.b.Xi().Xl();
                if (aVarXl != null) {
                    JSONObject jSONObject = aVarXl.bvE;
                    aa.putValue(jSONObject, "retryCount", aVarXl.retryCount);
                    aa.putValue(jSONObject, "cacheType", 1);
                    b.a(aVarXl.url, jSONObject, aVarXl.bvF, aVarXl);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.a aVar, com.kwad.sdk.core.adlog.a.a aVar2) {
        AdTemplate adTemplate = aVar.adTemplate;
        int i = aVar.buM;
        try {
            com.kwad.sdk.core.adlog.b.c.a(adTemplate, i, aVar2);
            if (!ao.isNetworkConnected(ServiceProvider.getContext())) {
                com.kwad.sdk.core.d.c.w("AdLogRequestManager", "no network while report log");
                com.kwad.sdk.core.adlog.b.c.a(adTemplate, i, str, 100004, "no network", aVar2);
                com.kwad.sdk.core.adlog.a.b.Xi().a(aVar2, str, jSONObject, aVar, 100004, "no network");
                return;
            }
            if (bx.iV(str)) {
                com.kwad.sdk.core.adlog.b.c.b(adTemplate, i, str, FraudVerifyCode.RerwardFraudUnknown, "", aVar2);
                return;
            }
            com.kwad.sdk.core.network.c cVarDoPost = g.ST().doPost(str, (Map<String, String>) null, jSONObject);
            AdLogRequestResult adLogRequestResult = new AdLogRequestResult();
            adLogRequestResult.parseResult(cVarDoPost.bCs);
            if (cVarDoPost.code != 200) {
                int iEg = d.eg(cVarDoPost.code);
                String str2 = cVarDoPost.bCs;
                com.kwad.sdk.core.adlog.b.c.d(adTemplate, i, str, iEg, str2, aVar2);
                com.kwad.sdk.core.adlog.a.b.Xi().a(aVar2, str, jSONObject, aVar, iEg, str2);
                return;
            }
            if (adLogRequestResult.isResultOk()) {
                com.kwad.sdk.core.adlog.b.c.b(adTemplate, i, aVar2);
                b(aVar);
                com.kwad.sdk.core.adlog.a.b.Xi().Xj();
            } else {
                if (adLogRequestResult.isCheatingFlow()) {
                    adTemplate.setCheatingFlow(adLogRequestResult.isCheatingFlow());
                    com.kwad.sdk.core.adlog.b.c.c(adTemplate, i, str, adLogRequestResult.result, adLogRequestResult.errorMsg, aVar2);
                    return;
                }
                int i2 = adLogRequestResult.result;
                String str3 = adLogRequestResult.errorMsg;
                com.kwad.sdk.core.d.c.w("AdLogRequestManager", "request fail code:" + i2 + ", errorMsg:" + str3 + ", url=" + str);
                com.kwad.sdk.core.adlog.b.c.c(adTemplate, i, str, i2, str3, aVar2);
                com.kwad.sdk.core.adlog.a.b.Xi().a(aVar2, str, jSONObject, aVar, i2, str3);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.adlog.b.c.b(adTemplate, i, "", KSTubeParamInner.FREE_ALL, bx.A(th), aVar2);
            com.kwad.sdk.core.d.c.printStackTrace(th);
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void b(com.kwad.sdk.core.adlog.c.a aVar) {
        try {
            com.kwad.sdk.core.track.a.e(aVar);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}

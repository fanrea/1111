package com.kwad.components.ad.draw.a;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    public static void h(AdTemplate adTemplate) {
        AdInfo adInfoEP = e.eP(adTemplate);
        a(d.aS().y(1).z(com.kwad.sdk.core.response.b.a.bk(adInfoEP)).q(com.kwad.sdk.core.response.b.a.bh(adInfoEP)).setAdTemplate(adTemplate), false);
    }

    public static void a(AdTemplate adTemplate, long j) {
        AdInfo adInfoEP = e.eP(adTemplate);
        a(d.aS().y(2).z(com.kwad.sdk.core.response.b.a.bk(adInfoEP)).q(com.kwad.sdk.core.response.b.a.bh(adInfoEP)).h(j).setAdTemplate(adTemplate), false);
    }

    public static void a(AdTemplate adTemplate, long j, String str) {
        AdInfo adInfoEP = e.eP(adTemplate);
        a(d.aS().y(3).z(com.kwad.sdk.core.response.b.a.bk(adInfoEP)).q(com.kwad.sdk.core.response.b.a.bh(adInfoEP)).h(j).setAdTemplate(adTemplate).setErrorMsg(str), true);
    }

    private static void a(com.kwad.sdk.commercial.c.a aVar, boolean z) {
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Wz().dW(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).l(z ? 1.0d : 0.001d).b(BusinessType.AD_DRAW).V("ad_sdk_draw_material_load", "status").w(aVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}

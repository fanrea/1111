package com.kwad.components.ad.splashscreen.monitor;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {

    /* renamed from: com.kwad.components.ad.splashscreen.monitor.a$a, reason: collision with other inner class name */
    static class C0445a {
        private static final a HK = new a();
    }

    public static a mb() {
        return C0445a.HK;
    }

    private static void d(com.kwad.sdk.commercial.c.a aVar) {
        if (l.UL().TT()) {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(0.01d).V("ad_sdk_splash_callback", "callback_type").b(BusinessType.AD_SPLASH).w(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.crg));
        }
    }

    private static void e(com.kwad.sdk.commercial.c.a aVar) {
        if (l.UL().TT()) {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(0.01d).V("ad_sdk_splash_action", "action_type").b(BusinessType.AD_SPLASH).w(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.crg));
        }
    }

    private static SplashMonitorInfo ae(AdTemplate adTemplate) {
        AdInfo adInfoEP = e.eP(adTemplate);
        return new SplashMonitorInfo().setPreloadId(com.kwad.sdk.core.response.b.a.bf(adInfoEP)).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setMaterialType(com.kwad.sdk.core.response.b.a.bi(adInfoEP) ? 1 : 2).setAdTemplate(adTemplate);
    }

    public final void w(AdTemplate adTemplate) {
        d(ae(adTemplate).setCallbackType(1));
    }

    public final void af(AdTemplate adTemplate) {
        d(ae(adTemplate).setCallbackType(2));
    }

    public final void x(AdTemplate adTemplate) {
        d(ae(adTemplate).setCallbackType(3));
    }

    public final void t(long j) {
        d(new SplashMonitorInfo().setCallbackType(4).setPosId(j));
    }

    public final void ag(AdTemplate adTemplate) {
        d(ae(adTemplate).setCallbackType(5));
    }

    public final void ah(AdTemplate adTemplate) {
        e(ae(adTemplate).setActionType(1));
    }

    public final void ai(AdTemplate adTemplate) {
        e(ae(adTemplate).setActionType(2));
    }
}

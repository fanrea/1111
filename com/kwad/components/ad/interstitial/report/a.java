package com.kwad.components.ad.interstitial.report;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {

    /* renamed from: com.kwad.components.ad.interstitial.report.a$a, reason: collision with other inner class name */
    static class C0421a {
        private static final a pE = new a();
    }

    public static a eT() {
        return C0421a.pE;
    }

    private static void a(String str, com.kwad.sdk.commercial.c.a aVar) {
        if (l.UL().TT()) {
            try {
                com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(0.01d).V("ad_sdk_interstitial_callback", str).b(BusinessType.AD_INTERSTITIAL).w(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.crg));
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    public final void a(AdTemplate adTemplate, long j, long j2) {
        a("action_type", new InterstitialReportInfo().setActionType(1L).setClickSceneType(j).setItemClickType(j2).setAdTemplate(adTemplate));
    }

    public final void a(AdTemplate adTemplate, double d) {
        a("action_type", new InterstitialReportInfo().setActionType(2L).setVisiblePercent(d).setAdTemplate(adTemplate));
    }

    public final void w(AdTemplate adTemplate) {
        a("callback_type", new InterstitialReportInfo().setCallbackType(1L).setAdTemplate(adTemplate));
    }

    public final void b(AdTemplate adTemplate, long j, long j2) {
        a("callback_type", new InterstitialReportInfo().setCallbackType(2L).setClickSceneType(j).setItemClickType(j2).setAdTemplate(adTemplate));
    }

    public final void x(AdTemplate adTemplate) {
        a("callback_type", new InterstitialReportInfo().setCallbackType(3L).setAdTemplate(adTemplate));
    }
}

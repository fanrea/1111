package com.kwad.components.ad.interstitial.report;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d {

    static class a {
        private static final d pH = new d();
    }

    public static d eZ() {
        return a.pH;
    }

    private static void a(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(z ? 1.0d : 0.01d).V("ad_sdk_interstitial_play", "status").b(BusinessType.AD_INTERSTITIAL).w(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.crg));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void F(AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(1).setAdTemplate(adTemplate));
    }

    public final void b(AdTemplate adTemplate, long j) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(3).setCreativeId(e.eV(adTemplate)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(e.eP(adTemplate))).setVideoDuration(com.kwad.sdk.core.response.b.a.M(r0) * 1000).setPlayStartedDuration(j).setAdTemplate(adTemplate));
    }

    public final void b(AdTemplate adTemplate, int i, String str) {
        AdInfo adInfoEP = e.eP(adTemplate);
        a(true, new InterstitialReportInfo(adTemplate).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(adInfoEP)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setVideoDuration(com.kwad.sdk.core.response.b.a.M(adInfoEP) * 1000).setStatus(2).setErrorMsg(str).setErrorCode(i).setAdTemplate(adTemplate));
    }
}

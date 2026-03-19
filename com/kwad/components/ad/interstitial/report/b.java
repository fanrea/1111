package com.kwad.components.ad.interstitial.report;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {

    static class a {
        private static final b pF = new b();
    }

    public static b eV() {
        return a.pF;
    }

    private static void a(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(z ? 1.0d : 0.01d).V("ad_sdk_interstitial_download_error", "status").b(BusinessType.AD_INTERSTITIAL).w(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.crz));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void y(AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo().setDownloadType(adTemplate.getDownloadType()).setStatus(1).setAdTemplate(adTemplate));
    }

    public final void b(AdTemplate adTemplate, String str) {
        AdInfo adInfoEP = e.eP(adTemplate);
        a(true, new InterstitialReportInfo().setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(adInfoEP)).setDownloadSize(adTemplate.getDownloadSize()).setDownloadType(adTemplate.getDownloadType()).setVideoDuration(com.kwad.sdk.core.response.b.a.M(adInfoEP) * 1000).setStatus(2).setErrorMsg(str).setAdTemplate(adTemplate));
    }
}

package com.kwad.sdk.commercial.a;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    private static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.c.a aVar) {
        a(adTemplate, false, aVar);
    }

    private static void a(AdTemplate adTemplate, boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            com.kwad.sdk.commercial.b.d(c.Wz().dW(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).l(z ? 1.0d : 0.1d).b(d.bt(adTemplate)).V("ad_sdk_download_performance", "status").w(aVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void y(AdTemplate adTemplate) {
        a(adTemplate, b.WA().eh(1).setAdTemplate(adTemplate));
    }

    public static void k(AdTemplate adTemplate, long j) {
        a(adTemplate, b.WA().eh(2).aQ(j).setAdTemplate(adTemplate));
    }

    public static void bv(AdTemplate adTemplate) {
        a(adTemplate, b.WA().eh(3).setAdTemplate(adTemplate));
    }

    public static void bw(AdTemplate adTemplate) {
        a(adTemplate, b.WA().eh(4).setAdTemplate(adTemplate));
    }

    public static void bx(AdTemplate adTemplate) {
        a(adTemplate, b.WA().eh(5).setAdTemplate(adTemplate));
    }

    public static void h(AdTemplate adTemplate, int i, String str) {
        a(adTemplate, true, b.WA().eh(6).setAdTemplate(adTemplate).setErrorCode(i).setErrorMsg(str));
    }

    public static void by(AdTemplate adTemplate) {
        h(adTemplate, 100002, "");
    }

    public static void bz(AdTemplate adTemplate) {
        a(adTemplate, b.WA().eh(7).ei(adTemplate.mInstallApkFormUser ? 1 : 2).setAdTemplate(adTemplate));
    }

    public static void bA(AdTemplate adTemplate) {
        int i = 1;
        b bVarEi = b.WA().eh(8).ei(adTemplate.mInstallApkFormUser ? 1 : 2);
        if (!adTemplate.mInstallApkFromSDK) {
            i = adTemplate.mClickOpenAppStore ? 2 : 0;
        }
        a(adTemplate, bVarEi.ej(i).setAdTemplate(adTemplate));
    }

    public static void bB(AdTemplate adTemplate) {
        int i;
        b bVarEh = b.WA().eh(10);
        if (adTemplate.mInstallApkFromSDK) {
            i = 1;
        } else {
            i = adTemplate.mClickOpenAppStore ? 2 : 0;
        }
        a(adTemplate, bVarEh.ej(i).setAdTemplate(adTemplate));
    }

    public static void i(AdTemplate adTemplate, int i, String str) {
        a(adTemplate, true, b.WA().eh(9).ei(adTemplate.mInstallApkFormUser ? 1 : 2).setAdTemplate(adTemplate).setErrorCode(100003).setErrorMsg(str));
    }
}

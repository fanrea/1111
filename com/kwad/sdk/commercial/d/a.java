package com.kwad.sdk.commercial.d;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    private static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.c.a aVar) {
        aVar.setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(0.001d).b(com.kwad.sdk.commercial.d.bt(adTemplate)).V("ad_convert_method_call", "method_name").w(aVar));
    }

    public static void f(AdTemplate adTemplate, boolean z) {
        try {
            a(adTemplate, b.WC().ea("adUserClick").ct(z));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bD(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.WC().ea("adClick"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bE(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.WC().ea("startH5Page"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bF(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.WC().ea("dplinkStart"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bG(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.WC().ea("smallAppSuccess"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bH(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.WC().ea("appstoreStart"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bI(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.WC().ea("disableClick"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bJ(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.WC().ea("toVideoH5Web"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bK(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.WC().ea("toDownload"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bL(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.WC().ea("toOpenApp"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bM(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.WC().ea("toInstallApp"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bN(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.WC().ea("toDownloadDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bO(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.WC().ea("toDownloadThirdDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bP(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.WC().ea("toDownloadPage"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bQ(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.WC().ea("toDownloadPause"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bR(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.WC().ea("toDownloadResume"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bS(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.WC().ea("toDownloadNoNet"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bT(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.WC().ea("toDoNoting"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bU(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.WC().ea("toOpenAppDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bV(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.WC().ea("toOpenDeeplinkDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bW(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.WC().ea("toH5PageDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bX(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.WC().ea("toMiddlePageDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bY(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.WC().ea("toSmallAppDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}

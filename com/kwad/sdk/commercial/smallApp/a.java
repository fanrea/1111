package com.kwad.sdk.commercial.smallApp;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    private static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.c.a aVar) {
        a(adTemplate, false, aVar);
    }

    private static void a(AdTemplate adTemplate, boolean z, com.kwad.sdk.commercial.c.a aVar) {
        aVar.setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.b.d(c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(z ? 0.1d : 0.01d).b(d.bt(adTemplate)).V("ad_sdk_small_app_performance", "status").w(aVar));
    }

    public static void a(AdTemplate adTemplate, JumpFrom jumpFrom, AdInfo.SmallAppJumpInfo smallAppJumpInfo) {
        if (adTemplate == null || smallAppJumpInfo == null) {
            return;
        }
        try {
            a(adTemplate, b.a(jumpFrom).er(1).ep(smallAppJumpInfo.mediaSmallAppId).eo(smallAppJumpInfo.originId).en(smallAppJumpInfo.smallAppJumpUrl));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(AdTemplate adTemplate, JumpFrom jumpFrom, AdInfo.SmallAppJumpInfo smallAppJumpInfo) {
        if (adTemplate == null || smallAppJumpInfo == null) {
            return;
        }
        try {
            a(adTemplate, b.a(jumpFrom).er(2).ep(smallAppJumpInfo.mediaSmallAppId).eo(smallAppJumpInfo.originId).en(smallAppJumpInfo.smallAppJumpUrl));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, JumpFrom jumpFrom, String str, String str2, String str3) {
        try {
            a(adTemplate, b.a(jumpFrom).er(3).ep(str).eo(str2).en(str3));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, JumpFrom jumpFrom, AdInfo.SmallAppJumpInfo smallAppJumpInfo, String str) {
        if (adTemplate == null) {
            return;
        }
        try {
            String str2 = "";
            b bVarEo = b.a(jumpFrom).er(4).ep(smallAppJumpInfo == null ? "" : smallAppJumpInfo.mediaSmallAppId).eo(smallAppJumpInfo == null ? "" : smallAppJumpInfo.originId);
            if (smallAppJumpInfo != null) {
                str2 = smallAppJumpInfo.smallAppJumpUrl;
            }
            a(adTemplate, true, bVarEo.en(str2).setErrorCode(100008).setErrorMsg(str));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}

package com.kwad.sdk.commercial.e;

import android.text.TextUtils;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bx;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    public static void c(AdTemplate adTemplate, String str, String str2) {
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Wz().dW(ILoggerReporter.Category.ERROR_LOG).l(0.01d).b(d.bt(adTemplate)).V("ad_sdk_ad_data_performance", "error_name").w(b.WD().ed(str).ee(str2).setAdTemplate(adTemplate)));
    }

    public static void a(SceneImpl sceneImpl, long j, String str) {
        if (sceneImpl == null) {
            return;
        }
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Wz().dW(ILoggerReporter.Category.ERROR_LOG).l(0.01d).b(d.ef(sceneImpl.getAdStyle())).V("ad_sdk_ad_parse_performance", ILogConst.PLAY_SOURCE_DEFAULT).w(c.WE().ef(str).setPosId(sceneImpl.posId).setLlsid(j)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(SceneImpl sceneImpl, long j, String str, String str2) {
        if (sceneImpl == null) {
            return;
        }
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Wz().dW(ILoggerReporter.Category.ERROR_LOG).l(0.01d).b(d.ef(sceneImpl.getAdStyle())).V("ad_sdk_ad_parse_performance", ILogConst.PLAY_SOURCE_DEFAULT).w(c.WE().ef(str).eg(str2).setErrorCode(100013).setPosId(sceneImpl.posId).setLlsid(j)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void cb(AdTemplate adTemplate) {
        try {
            if (adTemplate.llsid == 0) {
                c(adTemplate, "llsid", "");
            }
            if (e.eV(adTemplate) == 0) {
                c(adTemplate, "create_id", "");
            }
            AdInfo adInfoEP = e.eP(adTemplate);
            int i = adInfoEP.adBaseInfo.adOperationType;
            if (i == 1) {
                String strDi = com.kwad.sdk.core.response.b.a.di(adInfoEP);
                if (bx.iV(strDi)) {
                    c(adTemplate, "download_url", strDi);
                }
            } else if (i == 2) {
                String strAW = com.kwad.sdk.core.response.b.a.aW(adInfoEP);
                if (bx.iV(strAW)) {
                    c(adTemplate, "h5_url", strAW);
                }
            }
            AdInfo.AdMaterialInfo.MaterialFeature materialFeatureO = com.kwad.sdk.core.response.b.a.O(adInfoEP);
            int i2 = materialFeatureO.featureType;
            String str = materialFeatureO.materialUrl;
            if (i2 == 1) {
                if (bx.iV(str)) {
                    c(adTemplate, "video_url", str);
                    return;
                }
                return;
            }
            if (i2 == 2) {
                if (bx.iV(str)) {
                    c(adTemplate, "image_url", str);
                }
            } else if (i2 == 3) {
                long jCD = com.kwad.sdk.core.response.b.a.cD(adInfoEP);
                String strBn = com.kwad.sdk.core.response.b.a.bn(adInfoEP);
                if (jCD == 0) {
                    c(adTemplate, "live_author_id", "");
                } else if (TextUtils.isEmpty(strBn)) {
                    c(adTemplate, "live_stream_id", strBn);
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void e(AdTemplate adTemplate, String str) {
        c(adTemplate, "tk_template_id", str);
    }
}

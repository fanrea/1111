package com.kwad.components.ad.splashscreen;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d {
    public static int Ha;
    private String Hb;
    private int Hc = 2;

    public static d a(AdTemplate adTemplate, AdInfo adInfo, com.kwad.components.core.e.d.c cVar, int i) {
        d dVar = new d();
        Ha = i;
        if (adInfo != null && cVar != null) {
            if (i == 1 || i == 4) {
                dVar.ab(a(adTemplate, adInfo, cVar));
            } else if (i == 10) {
                if (com.kwad.sdk.core.response.b.a.aJ(adInfo)) {
                    int iPK = cVar.pK();
                    if (iPK == 2) {
                        dVar.ab(a(adTemplate, adInfo, iPK, 0));
                    } else {
                        dVar.ab("扭动或点击" + a(adTemplate, adInfo, iPK, 0));
                    }
                } else {
                    try {
                        String strDV = com.kwad.sdk.core.response.b.b.dV(adInfo);
                        if (!TextUtils.isEmpty(strDV)) {
                            dVar.ab("扭动或点击" + strDV);
                        } else {
                            dVar.ab("或点击跳转详情页或第三方应用");
                        }
                    } catch (Exception unused) {
                        dVar.ab("或点击跳转详情页或第三方应用");
                    }
                }
            } else if (com.kwad.sdk.core.response.b.a.aJ(adInfo)) {
                dVar.ab("或点击" + a(adTemplate, adInfo, cVar.pK(), 0));
            } else {
                String strA = com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.HG);
                if (TextUtils.isEmpty(strA)) {
                    strA = "点击跳转详情页或第三方应用";
                }
                dVar.ab("或" + strA);
            }
        }
        dVar.aj(com.kwad.sdk.core.response.b.b.dY(adInfo));
        return dVar;
    }

    public static String a(AdTemplate adTemplate, AdInfo adInfo, int i, int i2) {
        String strAH = com.kwad.sdk.core.response.b.a.aH(adInfo);
        if (i == 2) {
            return i2 + "%";
        }
        if (i == 4) {
            return "继续下载";
        }
        if (i != 8) {
            return i != 12 ? strAH : com.kwad.sdk.core.response.b.a.ae(adInfo);
        }
        return com.kwad.sdk.core.response.b.a.cB(adTemplate);
    }

    private static String a(AdInfo adInfo, int i) {
        return i == 1 ? com.kwad.sdk.core.response.b.b.dV(adInfo) != null ? com.kwad.sdk.core.response.b.b.dV(adInfo) : "" : (i != 4 || com.kwad.sdk.core.response.b.b.dW(adInfo) == null) ? "" : com.kwad.sdk.core.response.b.b.dW(adInfo);
    }

    private static String a(AdTemplate adTemplate, AdInfo adInfo, com.kwad.components.core.e.d.c cVar) {
        if (com.kwad.sdk.core.response.b.a.aJ(adInfo)) {
            return a(adTemplate, adInfo, cVar.pK(), 0);
        }
        String strA = a(adInfo, Ha);
        return TextUtils.isEmpty(strA) ? "点击跳转详情页或第三方应用" : strA;
    }

    public final String lE() {
        return this.Hb;
    }

    private void ab(String str) {
        this.Hb = str;
    }

    public final int lF() {
        return this.Hc;
    }

    private void aj(int i) {
        this.Hc = i;
    }
}

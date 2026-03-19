package com.kwad.sdk.core.track;

import com.kwad.components.ad.reward.monitor.FraudVerifyCode;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.g;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.bx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    private static boolean fA(int i) {
        return i >= 200 && i < 300;
    }

    public static void e(com.kwad.sdk.core.adlog.c.a aVar) {
        AdTemplate adTemplate = aVar.adTemplate;
        AdInfo adInfoEP = e.eP(adTemplate);
        int i = aVar.buM;
        List<String> listA = a(adTemplate, i, aVar);
        if (ap.aF(listA)) {
            return;
        }
        boolean zDK = com.kwad.sdk.core.response.b.a.dK(adInfoEP);
        boolean zDL = com.kwad.sdk.core.response.b.a.dL(adInfoEP);
        for (String str : listA) {
            com.kwad.sdk.commercial.j.a.o(adTemplate, i, str);
            if (adTemplate.isCheatingFlow()) {
                com.kwad.sdk.commercial.j.a.n(adTemplate, i, str);
                return;
            }
            if (bx.iV(str)) {
                com.kwad.sdk.commercial.j.a.a(adTemplate, i, str, "", FraudVerifyCode.RerwardFraudUnknown, "", 0);
                return;
            }
            HashMap map = null;
            String strA = ai.a(ServiceProvider.getContext(), str, i == 2 ? aVar.oB : null, com.kwad.sdk.core.response.b.a.aE(e.eP(adTemplate)));
            ai.f(adTemplate, str, strA);
            AdHttpProxy adHttpProxyST = g.ST();
            int i2 = adHttpProxyST instanceof com.kwad.sdk.core.network.c.a ? 2 : 1;
            c.d("AdTrackUtil", "handleTrackUrl useKwaiUA: " + zDK);
            if (zDK) {
                com.kwad.sdk.core.i.c cVarR = com.kwad.sdk.core.i.a.r(zDK, zDL);
                c.d("AdTrackUtil", "handleTrackUrl uaGetter: " + cVarR);
                if (cVarR != null) {
                    map = new HashMap();
                    map.put("User-Agent", cVarR.acz());
                }
            }
            com.kwad.sdk.core.network.c cVarDoGetWithoutResponse = adHttpProxyST.doGetWithoutResponse(strA, map, !zDK);
            if (fA(cVarDoGetWithoutResponse.code)) {
                c.d("AdTrackUtil", "trackUrl request success actionType: " + i);
                com.kwad.sdk.commercial.j.a.a(adTemplate, i, str, cVarDoGetWithoutResponse.code, i2);
            } else {
                com.kwad.sdk.commercial.j.a.a(adTemplate, i, str, strA, d.eg(cVarDoGetWithoutResponse.code), cVarDoGetWithoutResponse.bCs, i2);
            }
        }
    }

    private static List<String> a(AdTemplate adTemplate, int i, com.kwad.sdk.core.adlog.c.a aVar) {
        ArrayList arrayList = new ArrayList();
        AdInfo adInfoEP = e.eP(adTemplate);
        List<AdInfo.AdTrackInfo> list = adInfoEP.adTrackInfoList;
        if (ap.aF(list)) {
            return arrayList;
        }
        List<String> listA = a(i, aVar, arrayList, adInfoEP, list);
        if (listA != null) {
            return listA;
        }
        Iterator<AdInfo.AdTrackInfo> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdInfo.AdTrackInfo next = it.next();
            if (next.type == i && next.urls != null) {
                arrayList.addAll(next.urls);
                break;
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
    
        r4.addAll(r6.urls);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<java.lang.String> a(int r2, com.kwad.sdk.core.adlog.c.a r3, java.util.List<java.lang.String> r4, com.kwad.sdk.core.response.model.AdInfo r5, java.util.List<com.kwad.sdk.core.response.model.AdInfo.AdTrackInfo> r6) {
        /*
            r0 = 402(0x192, float:5.63E-43)
            if (r2 != r0) goto L51
            boolean r2 = com.kwad.sdk.core.response.b.a.bu(r5)
            if (r2 == 0) goto L51
            java.lang.String r2 = r3.QX     // Catch: java.lang.Throwable -> L50
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L50
            if (r2 != 0) goto L20
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L50
            java.lang.String r3 = r3.QX     // Catch: java.lang.Throwable -> L50
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L50
            java.lang.String r3 = "photoPlaySecond"
            int r2 = r2.optInt(r3)     // Catch: java.lang.Throwable -> L50
            goto L22
        L20:
            int r2 = r3.bvX     // Catch: java.lang.Throwable -> L50
        L22:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L50
            com.kwad.sdk.core.response.model.AdInfo$AdBaseInfo r5 = r5.adBaseInfo     // Catch: java.lang.Throwable -> L50
            java.lang.String r5 = r5.videoPlayedNSConfig     // Catch: java.lang.Throwable -> L50
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L50
            java.util.Iterator r5 = r6.iterator()     // Catch: java.lang.Throwable -> L50
        L2f:
            boolean r6 = r5.hasNext()     // Catch: java.lang.Throwable -> L50
            if (r6 == 0) goto L50
            java.lang.Object r6 = r5.next()     // Catch: java.lang.Throwable -> L50
            com.kwad.sdk.core.response.model.AdInfo$AdTrackInfo r6 = (com.kwad.sdk.core.response.model.AdInfo.AdTrackInfo) r6     // Catch: java.lang.Throwable -> L50
            int r0 = r6.type     // Catch: java.lang.Throwable -> L50
            java.lang.String r1 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L50
            int r1 = r3.optInt(r1)     // Catch: java.lang.Throwable -> L50
            if (r0 != r1) goto L2f
            java.util.List<java.lang.String> r0 = r6.urls     // Catch: java.lang.Throwable -> L50
            if (r0 == 0) goto L2f
            java.util.List<java.lang.String> r2 = r6.urls     // Catch: java.lang.Throwable -> L50
            r4.addAll(r2)     // Catch: java.lang.Throwable -> L50
        L50:
            return r4
        L51:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.track.a.a(int, com.kwad.sdk.core.adlog.c.a, java.util.List, com.kwad.sdk.core.response.model.AdInfo, java.util.List):java.util.List");
    }
}

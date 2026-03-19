package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class i {
    public static boolean z(com.kwad.components.ad.reward.g gVar) {
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        if ((com.kwad.sdk.core.response.b.a.bT(adInfoEP) && gVar.tv != null && gVar.tv.sf()) || com.kwad.components.ad.reward.a.b.k(adInfoEP) || adTemplate.mXiaomiAppStoreDetailViewOpen) {
            return false;
        }
        if (com.kwad.components.ad.reward.a.b.hP()) {
            return true;
        }
        return com.kwad.sdk.core.response.b.a.aJ(adInfoEP) && com.kwad.sdk.core.response.b.a.av(adInfoEP);
    }
}

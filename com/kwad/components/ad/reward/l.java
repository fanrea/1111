package com.kwad.components.ad.reward;

import android.content.Context;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class l {
    public static void j(g gVar) {
        AdTemplate adTemplate = gVar.mAdTemplate;
        Context context = gVar.mContext;
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        if ((com.kwad.sdk.core.response.b.a.bT(adInfoEP) && gVar.tv != null && gVar.tv.sf()) || com.kwad.components.ad.reward.a.b.k(adInfoEP) || adTemplate.mXiaomiAppStoreDetailViewOpen || !com.kwad.sdk.core.response.b.a.aJ(adInfoEP) || !com.kwad.sdk.core.response.b.a.av(adInfoEP) || adTemplate.hasEnterAdWebViewLandPageActivity) {
            return;
        }
        gVar.mAdTemplate.hasEnterAdWebViewLandPageActivity = true;
        DownloadLandPageActivity.launch(context, adTemplate, true);
    }
}

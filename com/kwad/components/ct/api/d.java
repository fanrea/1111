package com.kwad.components.ct.api;

import com.kwad.sdk.api.KsContentAllianceAd;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.api.KsScene;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface d extends com.kwad.sdk.components.b {
    @Deprecated
    KsContentAllianceAd loadContentAllianceAd(KsScene ksScene);

    KsContentPage loadContentPage(KsScene ksScene);

    KsContentPage loadContentPageByPush(KsScene ksScene, String str);

    KsContentPage loadContentPageBySchema(KsScene ksScene, String str);

    com.kwad.components.ct.api.a.a xa();
}

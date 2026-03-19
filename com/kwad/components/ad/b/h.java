package com.kwad.components.ad.b;

import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface h extends com.kwad.sdk.components.b {

    public interface a {
        KsRewardVideoAd a(AdTemplate adTemplate);

        void a(KsRewardVideoAd ksRewardVideoAd, int i);

        boolean a(KsRewardVideoAd ksRewardVideoAd);

        AdInfo b(KsRewardVideoAd ksRewardVideoAd);
    }

    a V();

    List<KsRewardVideoAd> c(List<AdTemplate> list);

    void loadRewardVideoAd(KsScene ksScene, KsLoadManager.RewardVideoAdListener rewardVideoAdListener);

    void notifyRewardVerify();
}

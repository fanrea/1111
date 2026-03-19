package com.kwad.components.ad.reward.g;

import android.content.Context;
import com.kwad.components.ad.b.h;
import com.kwad.components.ad.reward.KsRewardVideoAdControl;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends e implements h {
    private h.a wy;

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return h.class;
    }

    @Override // com.kwad.components.ad.b.h
    public final void loadRewardVideoAd(KsScene ksScene, KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        if (!l.UL().Vn()) {
            rewardVideoAdListener.onError(com.kwad.sdk.core.network.e.bCH.errorCode, com.kwad.sdk.core.network.e.bCH.msg);
        } else {
            b.a(ksScene, new c(ksScene.getPosId(), rewardVideoAdListener));
        }
    }

    @Override // com.kwad.components.ad.b.h
    public final void notifyRewardVerify() {
        com.kwad.components.ad.reward.b.gp().notifyRewardVerify();
    }

    @Override // com.kwad.components.ad.b.h
    public final List<KsRewardVideoAd> c(List<AdTemplate> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<AdTemplate> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new KsRewardVideoAdControl(it.next(), null));
        }
        return arrayList;
    }

    @Override // com.kwad.components.ad.b.h
    public final h.a V() {
        if (this.wy == null) {
            this.wy = new h.a() { // from class: com.kwad.components.ad.reward.g.a.1
                @Override // com.kwad.components.ad.b.h.a
                public final KsRewardVideoAd a(AdTemplate adTemplate) {
                    return new KsRewardVideoAdControl(adTemplate, null);
                }

                @Override // com.kwad.components.ad.b.h.a
                public final boolean a(KsRewardVideoAd ksRewardVideoAd) {
                    return ksRewardVideoAd instanceof KsRewardVideoAdControl;
                }

                @Override // com.kwad.components.ad.b.h.a
                public final AdInfo b(KsRewardVideoAd ksRewardVideoAd) {
                    if (ksRewardVideoAd instanceof KsRewardVideoAdControl) {
                        return ((KsRewardVideoAdControl) ksRewardVideoAd).cZ();
                    }
                    return null;
                }

                @Override // com.kwad.components.ad.b.h.a
                public final void a(KsRewardVideoAd ksRewardVideoAd, int i) {
                    if (ksRewardVideoAd instanceof KsRewardVideoAdControl) {
                        ((KsRewardVideoAdControl) ksRewardVideoAd).rewardType = 2;
                    }
                }
            };
        }
        return this.wy;
    }
}

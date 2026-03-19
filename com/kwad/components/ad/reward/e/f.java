package com.kwad.components.ad.reward.e;

import com.kwad.sdk.api.KsRewardVideoAd;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f {
    private static final HashMap<String, f> wh = new HashMap<>();
    private KsRewardVideoAd.RewardAdInteractionListener mInteractionListener;
    private com.kwad.components.core.j.d tj;
    private KsRewardVideoAd.RewardAdInteractionListener wi;

    private static f O(String str) {
        return wh.get(str);
    }

    public static void a(String str, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, com.kwad.components.core.j.d dVar) {
        f fVar = new f();
        fVar.mInteractionListener = rewardAdInteractionListener;
        fVar.tj = dVar;
        fVar.wi = rewardAdInteractionListener;
        wh.put(str, fVar);
    }

    public static KsRewardVideoAd.RewardAdInteractionListener P(String str) {
        f fVarO = O(str);
        if (fVarO != null) {
            return fVarO.wi;
        }
        return null;
    }

    public static void Q(String str) {
        f fVarO = O(str);
        if (fVarO != null) {
            fVarO.wi = fVarO.mInteractionListener;
        }
    }

    public static com.kwad.components.core.j.d R(String str) {
        f fVarO = O(str);
        if (fVarO != null) {
            return fVarO.tj;
        }
        return null;
    }

    public static void S(String str) {
        f fVarO = O(str);
        if (fVarO != null) {
            fVarO.destroy();
            wh.put(str, null);
        }
    }

    private void destroy() {
        this.mInteractionListener = null;
        this.wi = null;
        com.kwad.components.core.j.d dVar = this.tj;
        if (dVar != null) {
            dVar.destroy();
            this.tj = null;
        }
    }
}

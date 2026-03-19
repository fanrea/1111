package com.kwad.components.ad.reward.e;

import com.kwad.components.ad.reward.monitor.RewardInteractionCallbackType;
import com.kwad.components.ad.reward.monitor.RewardMonitorInfo;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class i extends c {
    private static String wm = "IS_FRAUD";
    private static String wn = "IS_FRAUD_ERROR_CODE";
    private AdTemplate mAdTemplate;
    private com.kwad.components.ad.reward.g vb;
    private String wk;
    private Map<String, Object> wl = new HashMap();

    public final void setCallerContext(com.kwad.components.ad.reward.g gVar) {
        this.vb = gVar;
    }

    public final void T(String str) {
        this.wk = str;
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public void db() {
        super.db();
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListenerIg = ig();
        if (rewardAdInteractionListenerIg != null) {
            rewardAdInteractionListenerIg.onAdClicked();
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.AD_CLICK, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayStart() {
        super.onVideoPlayStart();
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListenerIg = ig();
        if (rewardAdInteractionListenerIg != null) {
            rewardAdInteractionListenerIg.onVideoPlayStart();
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_START, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayError(int i, int i2) {
        super.onVideoPlayError(i, i2);
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListenerIg = ig();
        if (rewardAdInteractionListenerIg != null) {
            rewardAdInteractionListenerIg.onVideoPlayError(i, i2);
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_ERROR, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayEnd() {
        super.onVideoPlayEnd();
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListenerIg = ig();
        if (rewardAdInteractionListenerIg != null) {
            rewardAdInteractionListenerIg.onVideoPlayEnd();
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_END, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoSkipToEnd(long j) {
        super.onVideoSkipToEnd(j);
        try {
            KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListenerIg = ig();
            if (rewardAdInteractionListenerIg != null) {
                rewardAdInteractionListenerIg.onVideoSkipToEnd(j);
            }
            com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_SKIP_TO_END, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public void onRewardVerify() {
        super.onRewardVerify();
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public void i(boolean z) {
        super.i(z);
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListenerIg = ig();
        if (rewardAdInteractionListenerIg != null) {
            rewardAdInteractionListenerIg.onPageDismiss();
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.PAGE_DISMISS, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    /* renamed from: if, reason: not valid java name */
    public final boolean m453if() {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListenerIg = ig();
        if (rewardAdInteractionListenerIg != null) {
            if (com.kwad.sdk.core.response.b.a.dv(com.kwad.sdk.core.response.b.e.eP(this.vb.mAdTemplate))) {
                this.wl.put(wm, Boolean.valueOf(this.vb.tQ == 3));
                this.wl.put(wn, Integer.valueOf(this.vb.tR));
                com.kwad.components.ad.reward.monitor.c.d(this.vb.mAdTemplate, this.vb.tQ, this.vb.tR);
            }
            try {
                rewardAdInteractionListenerIg.onRewardVerify(this.wl);
            } catch (Throwable unused) {
            }
            rewardAdInteractionListenerIg.onRewardVerify();
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.REWARD_VERIFY, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
        return rewardAdInteractionListenerIg != null;
    }

    public final boolean j(final int i, final int i2) {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListenerIg = ig();
        if (rewardAdInteractionListenerIg != null) {
            rewardAdInteractionListenerIg.onRewardStepVerify(i, i2);
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.REWARD_STEP_VERIFY, this.mAdTemplate, new com.kwad.sdk.g.a<RewardMonitorInfo>() { // from class: com.kwad.components.ad.reward.e.i.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(RewardMonitorInfo rewardMonitorInfo) {
                rewardMonitorInfo.setTaskType(i).setTaskStep(i2);
            }
        });
        return rewardAdInteractionListenerIg != null;
    }

    private KsRewardVideoAd.RewardAdInteractionListener ig() {
        return f.P(getUniqueId());
    }

    private String getUniqueId() {
        return this.wk;
    }
}

package com.kwad.components.ad.fullscreen;

import com.kwad.components.ad.reward.monitor.RewardInteractionCallbackType;
import com.kwad.components.ad.reward.monitor.RewardMonitorInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class d extends com.kwad.components.ad.reward.e.c {
    private boolean ld = false;
    private AdTemplate mAdTemplate;
    private c mInteractionListener;

    public final void a(c cVar) {
        this.mInteractionListener = cVar;
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void db() {
        c cVar = this.mInteractionListener;
        if (cVar != null) {
            cVar.onAdClicked();
        }
        com.kwad.components.ad.reward.monitor.c.a(false, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.AD_CLICK, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoSkipToEnd(long j) {
        c cVar = this.mInteractionListener;
        if (cVar != null) {
            cVar.onSkippedVideo();
        }
        com.kwad.components.ad.reward.monitor.c.a(false, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_SKIP_TO_END, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayStart() {
        c cVar = this.mInteractionListener;
        if (cVar != null) {
            cVar.onVideoPlayStart();
        }
        if (!this.ld) {
            this.ld = true;
            onAdShow();
        }
        com.kwad.components.ad.reward.monitor.c.a(false, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_START, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayError(int i, int i2) {
        c cVar = this.mInteractionListener;
        if (cVar != null) {
            cVar.onVideoPlayError(i, i2);
        }
        com.kwad.components.ad.reward.monitor.c.a(false, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_ERROR, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayEnd() {
        c cVar = this.mInteractionListener;
        if (cVar != null) {
            cVar.onVideoPlayEnd();
        }
        com.kwad.components.ad.reward.monitor.c.a(false, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_END, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public void i(boolean z) {
        onAdClosed();
        c cVar = this.mInteractionListener;
        if (cVar != null) {
            cVar.onPageDismiss();
        }
        com.kwad.components.ad.reward.monitor.c.a(false, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.PAGE_DISMISS, this.mAdTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) null);
    }

    private void onAdShow() {
        c cVar = this.mInteractionListener;
        if (cVar != null) {
            cVar.onAdShow();
        }
    }

    private void onAdClosed() {
        c cVar = this.mInteractionListener;
        if (cVar != null) {
            cVar.onAdClosed();
        }
    }
}

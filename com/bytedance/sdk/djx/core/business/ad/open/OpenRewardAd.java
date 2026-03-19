package com.bytedance.sdk.djx.core.business.ad.open;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.djx.core.business.ad.AdKey;
import com.bytedance.sdk.djx.core.business.ad.AdLog;
import com.bytedance.sdk.djx.core.business.ad.DJXBaseAd;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class OpenRewardAd extends DJXBaseAd {
    private static final String TAG = "OpenRewardAd";
    private long mAdCacheTime;
    private final AdKey mAdKey;
    private final TTRewardVideoAd mRewardVideoAd;

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public int getAdTypeName() {
        return 1;
    }

    OpenRewardAd(TTRewardVideoAd tTRewardVideoAd, AdKey adKey, long j) {
        this.mRewardVideoAd = tTRewardVideoAd;
        this.mAdKey = adKey;
        this.mAdCacheTime = j;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public long getAdCacheTime() {
        return this.mAdCacheTime;
    }

    public void setAdCacheTime(long j) {
        this.mAdCacheTime = j;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public String getRequestId() {
        return OpenAdUtils.getAdRequestId(this.mRewardVideoAd);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public Map<String, Object> getMediaExtraInfo() {
        return OpenAdUtils.getMediaExtraInfo(this.mRewardVideoAd);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public int getInteractionType() {
        return this.mRewardVideoAd.getInteractionType();
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void setRewardVideoListener(final IDJXAd.RewardVideoListener rewardVideoListener) {
        TTRewardVideoAd tTRewardVideoAd = this.mRewardVideoAd;
        if (tTRewardVideoAd == null) {
            return;
        }
        tTRewardVideoAd.setRewardAdInteractionListener(new TTRewardVideoAd.RewardAdInteractionListener() { // from class: com.bytedance.sdk.djx.core.business.ad.open.OpenRewardAd.1
            public void onAdClose() {
            }

            public void onRewardArrived(boolean z, int i, Bundle bundle) {
            }

            public void onAdShow() {
                IDJXAd.RewardVideoListener rewardVideoListener2 = rewardVideoListener;
                if (rewardVideoListener2 != null) {
                    rewardVideoListener2.onAdShow(OpenRewardAd.this);
                }
                AdLog.getInstance().sendAdShow(OpenRewardAd.this.mAdKey, null, false, -1);
                LG.d("AdLog-OpenRewardAd", "draw ad show");
            }

            public void onAdVideoBarClick() {
                IDJXAd.RewardVideoListener rewardVideoListener2 = rewardVideoListener;
                if (rewardVideoListener2 != null) {
                    rewardVideoListener2.onAdClicked(null, OpenRewardAd.this);
                }
                AdLog.getInstance().sendAdClick(OpenRewardAd.this.mAdKey, null, false, -1, null);
                LG.d("AdLog-OpenRewardAd", "draw ad clicked");
            }

            public void onVideoComplete() {
                IDJXAd.RewardVideoListener rewardVideoListener2 = rewardVideoListener;
                if (rewardVideoListener2 != null) {
                    rewardVideoListener2.onVideoAdComplete(0L);
                }
            }

            public void onVideoError() {
                IDJXAd.RewardVideoListener rewardVideoListener2 = rewardVideoListener;
                if (rewardVideoListener2 != null) {
                    rewardVideoListener2.onVideoError(-1, -1);
                }
            }

            public void onRewardVerify(boolean z, int i, String str, int i2, String str2) {
                IDJXAd.RewardVideoListener rewardVideoListener2 = rewardVideoListener;
                if (rewardVideoListener2 != null) {
                    rewardVideoListener2.onRewardVerify(z, i, str, i2, str2);
                }
            }

            public void onRewardVerify(boolean z, int i, String str) {
                IDJXAd.RewardVideoListener rewardVideoListener2 = rewardVideoListener;
                if (rewardVideoListener2 != null) {
                    rewardVideoListener2.onRewardVerify(z, i, str, -1, "default msg");
                }
            }

            public void onSkippedVideo() {
                IDJXAd.RewardVideoListener rewardVideoListener2 = rewardVideoListener;
                if (rewardVideoListener2 != null) {
                    rewardVideoListener2.onSkippedVideo();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void show(Context context) {
        TTRewardVideoAd tTRewardVideoAd;
        boolean z = context instanceof Activity;
        LG.d("AdLog-OpenRewardAd", "show reward: " + z);
        if (!z || (tTRewardVideoAd = this.mRewardVideoAd) == null) {
            return;
        }
        tTRewardVideoAd.showRewardVideoAd((Activity) context);
    }
}

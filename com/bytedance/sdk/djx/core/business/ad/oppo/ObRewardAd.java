package com.bytedance.sdk.djx.core.business.ad.oppo;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.djx.core.business.ad.AdKey;
import com.bytedance.sdk.djx.core.business.ad.AdLog;
import com.bytedance.sdk.djx.core.business.ad.DJXBaseAd;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.bytedance.sdk.djx.utils.LG;
import com.ttshell.sdk.api.TTRewardVideoOb;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class ObRewardAd extends DJXBaseAd {
    private static final String TAG = "OBRewardAd";
    private final AdKey mAdKey;
    private final TTRewardVideoOb mRewardVideoAd;

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public int getAdTypeName() {
        return 1;
    }

    ObRewardAd(TTRewardVideoOb tTRewardVideoOb, AdKey adKey) {
        this.mRewardVideoAd = tTRewardVideoOb;
        this.mAdKey = adKey;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public String getRequestId() {
        return OppoObUtils.getAdRequestId(this.mRewardVideoAd);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public Map<String, Object> getMediaExtraInfo() {
        return OppoObUtils.getMediaExtraInfo(this.mRewardVideoAd);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void setRewardVideoListener(final IDJXAd.RewardVideoListener rewardVideoListener) {
        TTRewardVideoOb tTRewardVideoOb = this.mRewardVideoAd;
        if (tTRewardVideoOb == null) {
            return;
        }
        tTRewardVideoOb.setRewardObInteractionListener(new TTRewardVideoOb.RewardObInteractionListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo.ObRewardAd.1
            public void onObClose() {
            }

            public void onObShow() {
                IDJXAd.RewardVideoListener rewardVideoListener2 = rewardVideoListener;
                if (rewardVideoListener2 != null) {
                    rewardVideoListener2.onAdShow(ObRewardAd.this);
                }
                AdLog.getInstance().sendAdShow(ObRewardAd.this.mAdKey, null, false, -1);
                LG.d("AdLog-OBRewardAd", "draw ad show");
            }

            public void onObVideoBarClick() {
                IDJXAd.RewardVideoListener rewardVideoListener2 = rewardVideoListener;
                if (rewardVideoListener2 != null) {
                    rewardVideoListener2.onAdClicked(null, ObRewardAd.this);
                }
                AdLog.getInstance().sendAdClick(ObRewardAd.this.mAdKey, null, false, -1, null);
                LG.d("AdLog-OBRewardAd", "draw ad clicked");
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
        TTRewardVideoOb tTRewardVideoOb;
        boolean z = context instanceof Activity;
        LG.d("AdLog-OBRewardAd", "show reward: " + z);
        if (!z || (tTRewardVideoOb = this.mRewardVideoAd) == null) {
            return;
        }
        tTRewardVideoOb.showRewardVideoOb((Activity) context);
    }
}

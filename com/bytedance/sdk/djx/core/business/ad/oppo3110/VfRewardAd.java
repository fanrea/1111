package com.bytedance.sdk.djx.core.business.ad.oppo3110;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bykv.vk.openvk.TTRdVideoObject;
import com.bytedance.sdk.djx.core.business.ad.AdKey;
import com.bytedance.sdk.djx.core.business.ad.AdLog;
import com.bytedance.sdk.djx.core.business.ad.DJXBaseAd;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.bytedance.sdk.djx.utils.LG;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class VfRewardAd extends DJXBaseAd {
    private static final String TAG = "VfRewardAd";
    private final long mAdCacheTime;
    private final AdKey mAdKey;
    private final TTRdVideoObject mRewardVideoAd;

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public int getAdTypeName() {
        return 1;
    }

    VfRewardAd(TTRdVideoObject tTRdVideoObject, AdKey adKey, long j) {
        this.mRewardVideoAd = tTRdVideoObject;
        this.mAdKey = adKey;
        this.mAdCacheTime = j;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public long getAdCacheTime() {
        return this.mAdCacheTime;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public String getRequestId() {
        return OppoVfUtils.getAdRequestId(this.mRewardVideoAd);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public Map<String, Object> getMediaExtraInfo() {
        return OppoVfUtils.getMediaExtraInfo(this.mRewardVideoAd);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void setRewardVideoListener(final IDJXAd.RewardVideoListener rewardVideoListener) {
        TTRdVideoObject tTRdVideoObject = this.mRewardVideoAd;
        if (tTRdVideoObject == null) {
            return;
        }
        tTRdVideoObject.setRdVrInteractionListener(new TTRdVideoObject.RdVrInteractionListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo3110.VfRewardAd.1
            public void onClose() {
            }

            public void onRewardArrived(boolean z, int i, Bundle bundle) {
            }

            public void onShow() {
                IDJXAd.RewardVideoListener rewardVideoListener2 = rewardVideoListener;
                if (rewardVideoListener2 != null) {
                    rewardVideoListener2.onAdShow(VfRewardAd.this);
                }
                AdLog.getInstance().sendAdShow(VfRewardAd.this.mAdKey, null, false, -1);
                LG.d("AdLog-VfRewardAd", "draw ad show");
            }

            public void onVideoBarClick() {
                IDJXAd.RewardVideoListener rewardVideoListener2 = rewardVideoListener;
                if (rewardVideoListener2 != null) {
                    rewardVideoListener2.onAdClicked(null, VfRewardAd.this);
                }
                AdLog.getInstance().sendAdClick(VfRewardAd.this.mAdKey, null, false, -1, null);
                LG.d("AdLog-VfRewardAd", "draw ad clicked");
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

            public void onRdVerify(boolean z, int i, String str, int i2, String str2) {
                IDJXAd.RewardVideoListener rewardVideoListener2 = rewardVideoListener;
                if (rewardVideoListener2 != null) {
                    rewardVideoListener2.onRewardVerify(z, i, str, i2, str2);
                }
            }

            public void onRdVerify(boolean z, int i, String str) {
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
        TTRdVideoObject tTRdVideoObject;
        boolean z = context instanceof Activity;
        LG.d("AdLog-VfRewardAd", "show reward: " + z);
        if (!z || (tTRdVideoObject = this.mRewardVideoAd) == null) {
            return;
        }
        tTRdVideoObject.showRdVideoVr((Activity) context);
    }
}

package com.alliance.ssp.ad.api.reward;

import com.alliance.ssp.ad.bean.RewardInfo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface SARewardVideoAdInteractionListener {
    void onAdClick();

    void onAdClose();

    void onAdShow();

    void onRewardVerify(RewardInfo rewardInfo);

    void onVideoComplete();

    void onVideoError();
}

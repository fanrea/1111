package com.alliance.ssp.adapter.tobid.custom;

import android.app.Activity;
import android.util.Log;
import com.alliance.ssp.ad.api.SAAllianceAd;
import com.alliance.ssp.ad.api.SAAllianceAdParams;
import com.alliance.ssp.ad.api.SAAllianceAdSdk;
import com.alliance.ssp.ad.api.reward.SARewardVideoAd;
import com.alliance.ssp.ad.api.reward.SARewardVideoAdInteractionListener;
import com.alliance.ssp.ad.api.reward.SARewardVideoAdLoadListener;
import com.alliance.ssp.ad.bean.RewardInfo;
import com.alliance.ssp.adapter.tobid.utils.YThreadUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.custom.WMCustomRewardAdapter;
import com.windmill.sdk.models.BidPrice;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class YCustomerRewardAdapter extends WMCustomRewardAdapter {
    private static final String TAG = "YCustomerReward: ";
    private String ecpm;
    private SARewardVideoAd rewardVideoAd;
    private SAAllianceAd saAllianceAd;

    public void loadAd(Activity activity, Map<String, Object> map, Map<String, Object> map2) {
        if (activity == null) {
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "activity is null"));
        } else {
            YThreadUtils.runOnThreadPool((Runnable) new AnonymousClass1(map2, activity));
        }
    }

    /* renamed from: com.alliance.ssp.adapter.tobid.custom.YCustomerRewardAdapter$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ Map val$serverExtra;

        AnonymousClass1(Map map, Activity activity) {
            this.val$serverExtra = map;
            this.val$activity = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            SAAllianceAdParams sAAllianceAdParams = new SAAllianceAdParams();
            String str = (String) this.val$serverExtra.get("placementId");
            if (str == null || str.isEmpty()) {
                YCustomerRewardAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "placementId is null"));
                return;
            }
            Log.i("Adapter", "加载优推激励广告 -- placementId：" + str + "--");
            sAAllianceAdParams.setPosId(str);
            YCustomerRewardAdapter.this.saAllianceAd = SAAllianceAdSdk.getSAAllianceAdManager().createSAAllianceAd(this.val$activity);
            if (YCustomerRewardAdapter.this.saAllianceAd != null) {
                YCustomerRewardAdapter.this.saAllianceAd.loadSARewardAd(sAAllianceAdParams, new SARewardVideoAdLoadListener() { // from class: com.alliance.ssp.adapter.tobid.custom.YCustomerRewardAdapter.1.1
                    @Override // com.alliance.ssp.ad.api.BaseAdLoadListener
                    public void onResourceLoad() {
                    }

                    @Override // com.alliance.ssp.ad.api.reward.SARewardVideoAdLoadListener
                    public void onRewardVideoAdLoad(SARewardVideoAd sARewardVideoAd) {
                        if (sARewardVideoAd != null) {
                            YCustomerRewardAdapter.this.rewardVideoAd = sARewardVideoAd;
                            YCustomerRewardAdapter.this.ecpm = YCustomerRewardAdapter.this.rewardVideoAd.getECPM();
                            YCustomerRewardAdapter.this.callLoadBiddingSuccess(new BidPrice(YCustomerRewardAdapter.this.ecpm));
                            YCustomerRewardAdapter.this.rewardVideoAd.setRewardVideoAdInteractionListener(new SARewardVideoAdInteractionListener() { // from class: com.alliance.ssp.adapter.tobid.custom.YCustomerRewardAdapter.1.1.1
                                @Override // com.alliance.ssp.ad.api.reward.SARewardVideoAdInteractionListener
                                public void onAdShow() {
                                    Log.i(YCustomerRewardAdapter.TAG, "onAdShow");
                                    YCustomerRewardAdapter.this.callVideoAdShow();
                                }

                                @Override // com.alliance.ssp.ad.api.reward.SARewardVideoAdInteractionListener
                                public void onAdClose() {
                                    Log.i(YCustomerRewardAdapter.TAG, "onAdClose");
                                    YCustomerRewardAdapter.this.callVideoAdClosed();
                                }

                                @Override // com.alliance.ssp.ad.api.reward.SARewardVideoAdInteractionListener
                                public void onVideoComplete() {
                                    Log.i(YCustomerRewardAdapter.TAG, "onVideoComplete");
                                    YCustomerRewardAdapter.this.callVideoAdPlayComplete();
                                }

                                @Override // com.alliance.ssp.ad.api.reward.SARewardVideoAdInteractionListener
                                public void onVideoError() {
                                    Log.e(YCustomerRewardAdapter.TAG, "on video Error");
                                    YCustomerRewardAdapter.this.callVideoAdPlayError(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), "reward video play error"));
                                }

                                @Override // com.alliance.ssp.ad.api.reward.SARewardVideoAdInteractionListener
                                public void onAdClick() {
                                    Log.i(YCustomerRewardAdapter.TAG, IAdInterListener.AdCommandType.AD_CLICK);
                                    YCustomerRewardAdapter.this.callVideoAdClick();
                                }

                                @Override // com.alliance.ssp.ad.api.reward.SARewardVideoAdInteractionListener
                                public void onRewardVerify(RewardInfo rewardInfo) {
                                    Log.i(YCustomerRewardAdapter.TAG, "onRewardVerify");
                                    YCustomerRewardAdapter.this.callVideoAdReward(true);
                                }
                            });
                            YCustomerRewardAdapter.this.callLoadSuccess();
                            return;
                        }
                        YCustomerRewardAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "load interstitial ad time out"));
                    }

                    @Override // com.alliance.ssp.ad.api.BaseAdLoadListener
                    public void onError(int i, String str2) {
                        Log.e(YCustomerRewardAdapter.TAG, "onAdError, error code = " + i + ", error msg = " + str2);
                        YCustomerRewardAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "onAdError, error code = " + i + ", error msg = " + str2));
                    }
                });
            } else {
                YCustomerRewardAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "create SAAllianceAd fail"));
            }
        }
    }

    public void showAd(final Activity activity, HashMap<String, String> map, Map<String, Object> map2) {
        YThreadUtils.runOnUIThreadByThreadPool(new Runnable() { // from class: com.alliance.ssp.adapter.tobid.custom.YCustomerRewardAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                if (YCustomerRewardAdapter.this.saAllianceAd == null || activity == null) {
                    return;
                }
                YCustomerRewardAdapter.this.saAllianceAd.showRewardAd(activity);
            }
        });
    }

    public boolean isReady() {
        return this.rewardVideoAd != null;
    }

    public void destroyAd() {
        YThreadUtils.runOnUIThread(new Runnable() { // from class: com.alliance.ssp.adapter.tobid.custom.YCustomerRewardAdapter.3
            @Override // java.lang.Runnable
            public void run() {
                if (YCustomerRewardAdapter.this.rewardVideoAd != null) {
                    YCustomerRewardAdapter.this.rewardVideoAd.destroy();
                    YCustomerRewardAdapter.this.rewardVideoAd = null;
                }
            }
        });
    }
}

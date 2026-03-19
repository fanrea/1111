package com.alliance.ssp.adapter.tobid.custom;

import android.app.Activity;
import android.util.Log;
import com.alliance.ssp.ad.api.SAAllianceAd;
import com.alliance.ssp.ad.api.SAAllianceAdParams;
import com.alliance.ssp.ad.api.SAAllianceAdSdk;
import com.alliance.ssp.ad.api.interstitial.SAInterstitialAd;
import com.alliance.ssp.ad.api.interstitial.SAInterstitialAdInteractionListener;
import com.alliance.ssp.ad.api.interstitial.SAInterstitialAdLoadListener;
import com.alliance.ssp.ad.api.interstitial.SAInterstitialAdVideoListener;
import com.alliance.ssp.adapter.tobid.utils.YThreadUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.custom.WMCustomInterstitialAdapter;
import com.windmill.sdk.models.BidPrice;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class YCustomerInterstitialAdapter extends WMCustomInterstitialAdapter {
    private static final String TAG = "YCustomerInterstitial: ";
    private String ecpm;
    private SAInterstitialAd interstitialAd;
    private SAAllianceAd saAllianceAd;

    public void loadAd(Activity activity, Map<String, Object> map, Map<String, Object> map2) {
        if (activity == null) {
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "activity is null"));
        } else {
            YThreadUtils.runOnThreadPool((Runnable) new AnonymousClass1(map2, activity));
        }
    }

    /* renamed from: com.alliance.ssp.adapter.tobid.custom.YCustomerInterstitialAdapter$1, reason: invalid class name */
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
                YCustomerInterstitialAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "placementId is null"));
                return;
            }
            Log.i("Adapter", "加载优推插屏广告 -- placementId：" + str + "--");
            sAAllianceAdParams.setPosId(str);
            YCustomerInterstitialAdapter.this.saAllianceAd = SAAllianceAdSdk.getSAAllianceAdManager().createSAAllianceAd(this.val$activity);
            if (YCustomerInterstitialAdapter.this.saAllianceAd != null) {
                YCustomerInterstitialAdapter.this.saAllianceAd.loadSAInterstitialAd(sAAllianceAdParams, new SAInterstitialAdLoadListener() { // from class: com.alliance.ssp.adapter.tobid.custom.YCustomerInterstitialAdapter.1.1
                    @Override // com.alliance.ssp.ad.api.BaseAdLoadListener
                    public void onResourceLoad() {
                    }

                    @Override // com.alliance.ssp.ad.api.interstitial.SAInterstitialAdLoadListener
                    public void onInterstitialAdLoad(SAInterstitialAd sAInterstitialAd) {
                        if (sAInterstitialAd != null) {
                            YCustomerInterstitialAdapter.this.interstitialAd = sAInterstitialAd;
                            YCustomerInterstitialAdapter.this.ecpm = YCustomerInterstitialAdapter.this.interstitialAd.getECPM();
                            YCustomerInterstitialAdapter.this.callLoadBiddingSuccess(new BidPrice(YCustomerInterstitialAdapter.this.ecpm));
                            YCustomerInterstitialAdapter.this.interstitialAd.setInterstitialAdInteractionListener(new SAInterstitialAdInteractionListener() { // from class: com.alliance.ssp.adapter.tobid.custom.YCustomerInterstitialAdapter.1.1.1
                                @Override // com.alliance.ssp.ad.api.interstitial.SAInterstitialAdInteractionListener
                                public void onAdShow() {
                                    Log.i(YCustomerInterstitialAdapter.TAG, "onAdShow");
                                    YCustomerInterstitialAdapter.this.callVideoAdShow();
                                }

                                @Override // com.alliance.ssp.ad.api.interstitial.SAInterstitialAdInteractionListener
                                public void onAdClick() {
                                    Log.i(YCustomerInterstitialAdapter.TAG, IAdInterListener.AdCommandType.AD_CLICK);
                                    YCustomerInterstitialAdapter.this.callVideoAdClick();
                                }

                                @Override // com.alliance.ssp.ad.api.interstitial.SAInterstitialAdInteractionListener
                                public void onAdDismiss() {
                                    Log.i(YCustomerInterstitialAdapter.TAG, "onAdDismiss");
                                    YCustomerInterstitialAdapter.this.callVideoAdClosed();
                                }

                                @Override // com.alliance.ssp.ad.api.interstitial.SAInterstitialAdInteractionListener
                                public void onAdError(int i, String str2) {
                                    Log.e(YCustomerInterstitialAdapter.TAG, "onAdError, error code = " + i + ", error msg = " + str2);
                                    YCustomerInterstitialAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), "onAdError, error code = " + i + ", error msg = " + str2));
                                }

                                @Override // com.alliance.ssp.ad.api.interstitial.SAInterstitialAdInteractionListener
                                public void onSkippedVideo() {
                                    Log.i(YCustomerInterstitialAdapter.TAG, "onSkippedVideo");
                                    YCustomerInterstitialAdapter.this.callVideoAdSkipped();
                                }
                            });
                            YCustomerInterstitialAdapter.this.interstitialAd.setInterstitialAdVideoListener(new SAInterstitialAdVideoListener() { // from class: com.alliance.ssp.adapter.tobid.custom.YCustomerInterstitialAdapter.1.1.2
                                @Override // com.alliance.ssp.ad.api.BaseAdVideoListener
                                public void onVideoError(int i, String str2) {
                                    Log.e(YCustomerInterstitialAdapter.TAG, "onAdError, error code = " + i + ", error msg = " + str2);
                                    YCustomerInterstitialAdapter.this.callVideoAdPlayError(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), "onAdError, error code = " + i + ", error msg = " + str2));
                                }

                                @Override // com.alliance.ssp.ad.api.BaseAdVideoListener
                                public void onVideoLoad() {
                                    Log.i(YCustomerInterstitialAdapter.TAG, "onVideoLoad");
                                }

                                @Override // com.alliance.ssp.ad.api.BaseAdVideoListener
                                public void onVideoStartPlay() {
                                    Log.i(YCustomerInterstitialAdapter.TAG, "onVideoStartPlay");
                                }

                                @Override // com.alliance.ssp.ad.api.BaseAdVideoListener
                                public void onVideoPause() {
                                    Log.i(YCustomerInterstitialAdapter.TAG, "onVideoPause");
                                }

                                @Override // com.alliance.ssp.ad.api.BaseAdVideoListener
                                public void onVideoComplete() {
                                    Log.i(YCustomerInterstitialAdapter.TAG, "onVideoComplete");
                                    YCustomerInterstitialAdapter.this.callVideoAdPlayComplete();
                                }
                            });
                            YCustomerInterstitialAdapter.this.callLoadSuccess();
                            return;
                        }
                        YCustomerInterstitialAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "load interstitial ad time out"));
                    }

                    @Override // com.alliance.ssp.ad.api.BaseAdLoadListener
                    public void onError(int i, String str2) {
                        Log.e(YCustomerInterstitialAdapter.TAG, "onAdError, error code = " + i + ", error msg = " + str2);
                        YCustomerInterstitialAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "onAdError, error code = " + i + ", error msg = " + str2));
                    }
                });
            } else {
                YCustomerInterstitialAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "create SAAllianceAd fail"));
            }
        }
    }

    public void showAd(final Activity activity, HashMap<String, String> map, Map<String, Object> map2) {
        YThreadUtils.runOnUIThreadByThreadPool(new Runnable() { // from class: com.alliance.ssp.adapter.tobid.custom.YCustomerInterstitialAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                if (YCustomerInterstitialAdapter.this.saAllianceAd == null || activity == null) {
                    return;
                }
                YCustomerInterstitialAdapter.this.saAllianceAd.showInterstitial(activity);
            }
        });
    }

    public boolean isReady() {
        return this.interstitialAd != null;
    }

    public void destroyAd() {
        YThreadUtils.runOnUIThread(new Runnable() { // from class: com.alliance.ssp.adapter.tobid.custom.YCustomerInterstitialAdapter.3
            @Override // java.lang.Runnable
            public void run() {
                if (YCustomerInterstitialAdapter.this.interstitialAd != null) {
                    YCustomerInterstitialAdapter.this.interstitialAd.destroy();
                    YCustomerInterstitialAdapter.this.interstitialAd = null;
                }
            }
        });
    }
}

package com.alliance.ssp.adapter.tobid.custom;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.alliance.ssp.ad.api.SAAllianceAd;
import com.alliance.ssp.ad.api.SAAllianceAdParams;
import com.alliance.ssp.ad.api.SAAllianceAdSdk;
import com.alliance.ssp.ad.api.banner.SABannerAd;
import com.alliance.ssp.ad.api.banner.SABannerAdInteractionListener;
import com.alliance.ssp.ad.api.banner.SABannerAdLoadListener;
import com.alliance.ssp.adapter.tobid.utils.YThreadUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.custom.WMCustomBannerAdapter;
import com.windmill.sdk.models.BidPrice;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class YCustomerBannerAdapter extends WMCustomBannerAdapter {
    private static final String TAG = "YCustomerBanner: ";
    private SABannerAd bannerAd;
    private View bannerView;
    private String ecpm;
    private SAAllianceAd saAllianceAd;

    public void loadAd(Activity activity, Map<String, Object> map, Map<String, Object> map2) {
        if (activity == null) {
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "activity is null"));
        } else {
            YThreadUtils.runOnThreadPool((Runnable) new AnonymousClass1(map2, activity));
        }
    }

    /* renamed from: com.alliance.ssp.adapter.tobid.custom.YCustomerBannerAdapter$1, reason: invalid class name */
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
                YCustomerBannerAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "placementId is null"));
                return;
            }
            Log.i("Adapter", "加载优推横幅广告 -- placementId：" + str + "--");
            sAAllianceAdParams.setPosId(str);
            YCustomerBannerAdapter.this.saAllianceAd = SAAllianceAdSdk.getSAAllianceAdManager().createSAAllianceAd(this.val$activity);
            if (YCustomerBannerAdapter.this.saAllianceAd != null) {
                YCustomerBannerAdapter.this.saAllianceAd.loadSABannerAd(sAAllianceAdParams, null, new SABannerAdLoadListener() { // from class: com.alliance.ssp.adapter.tobid.custom.YCustomerBannerAdapter.1.1
                    @Override // com.alliance.ssp.ad.api.BaseAdLoadListener
                    public void onResourceLoad() {
                    }

                    @Override // com.alliance.ssp.ad.api.banner.SABannerAdLoadListener
                    public void onBannerAdLoad(SABannerAd sABannerAd, View view) {
                        if (sABannerAd != null) {
                            YCustomerBannerAdapter.this.bannerAd = sABannerAd;
                            YCustomerBannerAdapter.this.ecpm = sABannerAd.getECPM();
                            YCustomerBannerAdapter.this.callLoadBiddingSuccess(new BidPrice(YCustomerBannerAdapter.this.ecpm));
                            YCustomerBannerAdapter.this.bannerAd.setBannerAdInteractionListener(new SABannerAdInteractionListener() { // from class: com.alliance.ssp.adapter.tobid.custom.YCustomerBannerAdapter.1.1.1
                                @Override // com.alliance.ssp.ad.api.banner.SABannerAdInteractionListener
                                public void onAdError(int i, String str2) {
                                    Log.e(YCustomerBannerAdapter.TAG, "onAdError, error code = " + i + ", error msg = " + str2);
                                    YCustomerBannerAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), "onAdError, error code = " + i + ", error msg = " + str2));
                                }

                                @Override // com.alliance.ssp.ad.api.banner.SABannerAdInteractionListener
                                public void onAdShow() {
                                    Log.i(YCustomerBannerAdapter.TAG, "onAdShow");
                                    YCustomerBannerAdapter.this.callBannerAdShow();
                                }

                                @Override // com.alliance.ssp.ad.api.banner.SABannerAdInteractionListener
                                public void onAdClick() {
                                    Log.i(YCustomerBannerAdapter.TAG, IAdInterListener.AdCommandType.AD_CLICK);
                                    YCustomerBannerAdapter.this.callBannerAdClick();
                                }

                                @Override // com.alliance.ssp.ad.api.banner.SABannerAdInteractionListener
                                public void onAdClose() {
                                    Log.i(YCustomerBannerAdapter.TAG, "onAdClose: ");
                                    YCustomerBannerAdapter.this.callBannerAdClosed();
                                }
                            });
                            if (view != null) {
                                YCustomerBannerAdapter.this.bannerView = view;
                            } else {
                                FrameLayout frameLayout = new FrameLayout(AnonymousClass1.this.val$activity);
                                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                                YCustomerBannerAdapter.this.saAllianceAd.showBanner(frameLayout);
                                YCustomerBannerAdapter.this.bannerView = frameLayout;
                            }
                            YCustomerBannerAdapter.this.callLoadSuccess();
                            return;
                        }
                        YCustomerBannerAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "load fail, saBannerAd is null"));
                    }

                    @Override // com.alliance.ssp.ad.api.BaseAdLoadListener
                    public void onError(int i, String str2) {
                        Log.e(YCustomerBannerAdapter.TAG, "onAdError, error code = " + i + ", error msg = " + str2);
                        YCustomerBannerAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "onAdError, error code = " + i + ", error msg = " + str2));
                    }
                });
            } else {
                YCustomerBannerAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "create SAAllianceAd fail"));
            }
        }
    }

    public boolean isReady() {
        return this.bannerView != null;
    }

    public void destroyAd() {
        YThreadUtils.runOnUIThread(new Runnable() { // from class: com.alliance.ssp.adapter.tobid.custom.YCustomerBannerAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                if (YCustomerBannerAdapter.this.bannerAd != null) {
                    YCustomerBannerAdapter.this.bannerAd.destroy();
                    YCustomerBannerAdapter.this.bannerAd = null;
                }
            }
        });
    }

    public View getBannerView() {
        View view = this.bannerView;
        if (view != null) {
            return view;
        }
        Log.e(TAG, "ad view is null, please check if load finish");
        return null;
    }
}

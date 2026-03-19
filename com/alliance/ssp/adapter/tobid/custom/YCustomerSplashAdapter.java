package com.alliance.ssp.adapter.tobid.custom;

import android.app.Activity;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.alliance.ssp.ad.api.SAAllianceAd;
import com.alliance.ssp.ad.api.SAAllianceAdParams;
import com.alliance.ssp.ad.api.SAAllianceAdSdk;
import com.alliance.ssp.ad.api.splash.SASplashAd;
import com.alliance.ssp.ad.api.splash.SASplashAdInteractionListener;
import com.alliance.ssp.ad.api.splash.SASplashAdLoadListener;
import com.alliance.ssp.adapter.tobid.utils.YThreadUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.custom.WMCustomSplashAdapter;
import com.windmill.sdk.models.BidPrice;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class YCustomerSplashAdapter extends WMCustomSplashAdapter {
    private static final String TAG = "YCustomerSplash";
    private String ecpm;
    private SAAllianceAd saAllianceAd;
    private SASplashAd splashAd;

    public void loadAd(Activity activity, ViewGroup viewGroup, Map<String, Object> map, Map<String, Object> map2) {
        if (activity == null) {
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "activity is null"));
        } else {
            YThreadUtils.runOnThreadPool((Runnable) new AnonymousClass1(map2, activity));
        }
    }

    /* renamed from: com.alliance.ssp.adapter.tobid.custom.YCustomerSplashAdapter$1, reason: invalid class name */
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
                YCustomerSplashAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "placementId is null"));
                return;
            }
            Log.i("Adapter", "加载优推开屏广告 -- placementId：" + str + "--");
            sAAllianceAdParams.setPosId(str);
            YCustomerSplashAdapter.this.saAllianceAd = SAAllianceAdSdk.getSAAllianceAdManager().createSAAllianceAd(this.val$activity);
            if (YCustomerSplashAdapter.this.saAllianceAd != null) {
                YCustomerSplashAdapter.this.saAllianceAd.loadSASplashAd(sAAllianceAdParams, null, 3000, new SASplashAdLoadListener() { // from class: com.alliance.ssp.adapter.tobid.custom.YCustomerSplashAdapter.1.1
                    @Override // com.alliance.ssp.ad.api.BaseAdLoadListener
                    public void onResourceLoad() {
                    }

                    @Override // com.alliance.ssp.ad.api.splash.SASplashAdLoadListener
                    public void onTimeOut() {
                        YCustomerSplashAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "load splash ad time out"));
                    }

                    @Override // com.alliance.ssp.ad.api.splash.SASplashAdLoadListener
                    public void onSplashAdLoad(SASplashAd sASplashAd) {
                        if (sASplashAd != null) {
                            YCustomerSplashAdapter.this.splashAd = sASplashAd;
                            YCustomerSplashAdapter.this.ecpm = YCustomerSplashAdapter.this.splashAd.getECPM();
                            YCustomerSplashAdapter.this.callLoadBiddingSuccess(new BidPrice(YCustomerSplashAdapter.this.ecpm));
                            YCustomerSplashAdapter.this.splashAd.setSplashAdInteractionListener(new SASplashAdInteractionListener() { // from class: com.alliance.ssp.adapter.tobid.custom.YCustomerSplashAdapter.1.1.1
                                @Override // com.alliance.ssp.ad.api.splash.SASplashAdInteractionListener
                                public void onAdClick() {
                                    Log.i(YCustomerSplashAdapter.TAG, IAdInterListener.AdCommandType.AD_CLICK);
                                    YCustomerSplashAdapter.this.callSplashAdClick();
                                }

                                @Override // com.alliance.ssp.ad.api.splash.SASplashAdInteractionListener
                                public void onAdShow() {
                                    Log.i(YCustomerSplashAdapter.TAG, "onAdShow");
                                    YCustomerSplashAdapter.this.callSplashAdShow();
                                }

                                @Override // com.alliance.ssp.ad.api.splash.SASplashAdInteractionListener
                                public void onAdTimeOver() {
                                    Log.i(YCustomerSplashAdapter.TAG, "onAdTimeOver");
                                    YCustomerSplashAdapter.this.callSplashAdClosed();
                                }

                                @Override // com.alliance.ssp.ad.api.splash.SASplashAdInteractionListener
                                public void onAdSkip() {
                                    Log.i(YCustomerSplashAdapter.TAG, "onAdSkip");
                                    YCustomerSplashAdapter.this.callSplashAdSkipped();
                                }
                            });
                            YCustomerSplashAdapter.this.callLoadSuccess();
                            return;
                        }
                        YCustomerSplashAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "load fail, saSplashAd is null"));
                    }

                    @Override // com.alliance.ssp.ad.api.BaseAdLoadListener
                    public void onError(int i, String str2) {
                        Log.e(YCustomerSplashAdapter.TAG, "onAdError, error code = " + i + ", error msg = " + str2);
                        YCustomerSplashAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "onAdError, error code = " + i + ", error msg = " + str2));
                    }
                });
            } else {
                YCustomerSplashAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "create SAAllianceAd fail"));
            }
        }
    }

    public void showAd(final Activity activity, final ViewGroup viewGroup, Map<String, Object> map) {
        YThreadUtils.runOnUIThreadByThreadPool(new Runnable() { // from class: com.alliance.ssp.adapter.tobid.custom.YCustomerSplashAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup viewGroup2;
                if (YCustomerSplashAdapter.this.saAllianceAd == null || (viewGroup2 = viewGroup) == null) {
                    return;
                }
                viewGroup2.removeAllViews();
                FrameLayout frameLayout = new FrameLayout(activity);
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                YCustomerSplashAdapter.this.saAllianceAd.showSplash(frameLayout);
                viewGroup.addView(frameLayout);
            }
        });
    }

    public boolean isReady() {
        return this.splashAd != null;
    }

    public void destroyAd() {
        YThreadUtils.runOnUIThread(new Runnable() { // from class: com.alliance.ssp.adapter.tobid.custom.YCustomerSplashAdapter.3
            @Override // java.lang.Runnable
            public void run() {
                if (YCustomerSplashAdapter.this.splashAd != null) {
                    YCustomerSplashAdapter.this.splashAd.destroy();
                    YCustomerSplashAdapter.this.splashAd = null;
                }
            }
        });
    }
}

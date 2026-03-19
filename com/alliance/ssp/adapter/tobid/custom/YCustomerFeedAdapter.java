package com.alliance.ssp.adapter.tobid.custom;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.alliance.ssp.ad.api.SAAllianceAd;
import com.alliance.ssp.ad.api.SAAllianceAdParams;
import com.alliance.ssp.ad.api.SAAllianceAdSdk;
import com.alliance.ssp.ad.api.SAAllianceNativeFeedAdData;
import com.alliance.ssp.ad.api.expressfeed.SAExpressFeedAd;
import com.alliance.ssp.ad.api.expressfeed.SAExpressFeedAdLoadListener;
import com.alliance.ssp.ad.api.nativead.SANativeFeedAdLoadListener;
import com.alliance.ssp.adapter.tobid.utils.YThreadUtils;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.custom.WMCustomNativeAdapter;
import com.windmill.sdk.models.BidPrice;
import com.windmill.sdk.natives.WMNativeAdData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class YCustomerFeedAdapter extends WMCustomNativeAdapter {
    private static final String AD_WIDTH = "ad_width";
    private static final String TAG = "YCustomerNative: ";
    WMCustomNativeAdapter adapter;
    private WMNativeAdData nativeAd;
    private List<WMNativeAdData> nativeAdDataList = new ArrayList();
    private SAAllianceAd saAllianceAd;

    public void loadAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        this.nativeAdDataList.clear();
        if (context == null || !(context instanceof Activity)) {
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "activity is null"));
            return;
        }
        this.adapter = this;
        try {
            JSONObject jSONObject = new JSONObject((String) map2.get(GlobalSetting.CUSTOM_INFO_KEY));
            boolean zOptBoolean = jSONObject.optBoolean("isExpressAd");
            if (map != null && map.containsKey("isExpressAd")) {
                zOptBoolean = ((Boolean) map.get("isExpressAd")).booleanValue();
            }
            String str = (String) map2.get("placementId");
            Log.i("Adapter", "load native ad, placementId = " + str + ", isExpressAd ?= " + zOptBoolean);
            if (zOptBoolean) {
                String string = (String) jSONObject.get("width");
                if (map != null && map.containsKey("ad_key_width") && !map.get("ad_key_width").toString().isEmpty()) {
                    string = map.get("ad_key_width").toString();
                }
                if (string != null && !string.isEmpty()) {
                    loadExpressAd(context, str, Integer.parseInt(string));
                    return;
                } else {
                    Log.e("Adapter", "width 获取失败，请检查平台或客户端配置");
                    return;
                }
            }
            loadNativeAd(context, str);
        } catch (Exception e) {
            Log.e("Adapter", "load native ad fail, error = " + e.getMessage());
        }
    }

    private void loadExpressAd(final Context context, final String str, final int i) {
        YThreadUtils.runOnThreadPool(new Runnable() { // from class: com.alliance.ssp.adapter.tobid.custom.YCustomerFeedAdapter$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m336xcc12102e(str, i, context);
            }
        });
    }

    /* renamed from: lambda$loadExpressAd$0$com-alliance-ssp-adapter-tobid-custom-YCustomerFeedAdapter, reason: not valid java name */
    /* synthetic */ void m336xcc12102e(String str, int i, final Context context) {
        SAAllianceAdParams sAAllianceAdParams = new SAAllianceAdParams();
        sAAllianceAdParams.setPosId(str);
        sAAllianceAdParams.setImageAcceptedWidth(i);
        sAAllianceAdParams.setImageAcceptedHeight(0);
        SAAllianceAd sAAllianceAdCreateSAAllianceAd = SAAllianceAdSdk.getSAAllianceAdManager().createSAAllianceAd((Activity) context);
        this.saAllianceAd = sAAllianceAdCreateSAAllianceAd;
        if (sAAllianceAdCreateSAAllianceAd == null) {
            Log.e(TAG, "saAllianceAd 构建失败");
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "create SAAllianceAd fail"));
        } else {
            sAAllianceAdCreateSAAllianceAd.loadSAExpressFeedAd(sAAllianceAdParams, null, new SAExpressFeedAdLoadListener() { // from class: com.alliance.ssp.adapter.tobid.custom.YCustomerFeedAdapter.1
                @Override // com.alliance.ssp.ad.api.BaseAdLoadListener
                public void onResourceLoad() {
                }

                @Override // com.alliance.ssp.ad.api.expressfeed.SAExpressFeedAdLoadListener
                public void onExpressFeedAdLoad(List<SAExpressFeedAd> list) {
                    if (list == null || list.isEmpty()) {
                        YCustomerFeedAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "load fail, ad list is null"));
                        return;
                    }
                    Log.i("Adapter", "模版广告加载成功，开始构建ToBid模版实例");
                    for (SAExpressFeedAd sAExpressFeedAd : list) {
                        YCustomerFeedAdapter.this.nativeAd = new YExpressAd((Activity) context, sAExpressFeedAd, YCustomerFeedAdapter.this.adapter);
                        YCustomerFeedAdapter.this.nativeAdDataList.add(YCustomerFeedAdapter.this.nativeAd);
                        YCustomerFeedAdapter.this.callLoadBiddingSuccess(new BidPrice(sAExpressFeedAd.getECPM()));
                        YCustomerFeedAdapter yCustomerFeedAdapter = YCustomerFeedAdapter.this;
                        yCustomerFeedAdapter.callLoadSuccess(yCustomerFeedAdapter.nativeAdDataList);
                    }
                }

                @Override // com.alliance.ssp.ad.api.BaseAdLoadListener
                public void onError(int i2, String str2) {
                    Log.e(YCustomerFeedAdapter.TAG, "onAdError, error code = " + i2 + ", error msg = " + str2);
                    YCustomerFeedAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "onAdError, error code = " + i2 + ", error msg = " + str2));
                }
            });
        }
    }

    private void loadNativeAd(final Context context, final String str) {
        Log.i("Adapter", "加载优推自渲染广告， placementId = " + str);
        YThreadUtils.runOnThreadPool(new Runnable() { // from class: com.alliance.ssp.adapter.tobid.custom.YCustomerFeedAdapter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m337xadda42a0(str, context);
            }
        });
    }

    /* renamed from: lambda$loadNativeAd$1$com-alliance-ssp-adapter-tobid-custom-YCustomerFeedAdapter, reason: not valid java name */
    /* synthetic */ void m337xadda42a0(String str, final Context context) {
        SAAllianceAdParams sAAllianceAdParams = new SAAllianceAdParams();
        sAAllianceAdParams.setPosId(str);
        sAAllianceAdParams.setImageAcceptedWidth(360);
        sAAllianceAdParams.setImageAcceptedHeight(0);
        SAAllianceAd sAAllianceAdCreateSAAllianceAd = SAAllianceAdSdk.getSAAllianceAdManager().createSAAllianceAd((Activity) context);
        this.saAllianceAd = sAAllianceAdCreateSAAllianceAd;
        if (sAAllianceAdCreateSAAllianceAd == null) {
            callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "create SAAllianceAd fail"));
        } else {
            sAAllianceAdCreateSAAllianceAd.loadSANativeFeedAd(sAAllianceAdParams, new SANativeFeedAdLoadListener() { // from class: com.alliance.ssp.adapter.tobid.custom.YCustomerFeedAdapter.2
                @Override // com.alliance.ssp.ad.api.BaseAdLoadListener
                public void onResourceLoad() {
                }

                @Override // com.alliance.ssp.ad.api.nativead.SANativeFeedAdLoadListener
                public void onNativeFeedAdLoad(SAAllianceNativeFeedAdData sAAllianceNativeFeedAdData) {
                    if (sAAllianceNativeFeedAdData == null) {
                        YCustomerFeedAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "load fail, ad list is null"));
                        return;
                    }
                    Log.i("Adapter", "优推自渲染广告加载成功，开始创建ToBid实例");
                    YCustomerFeedAdapter.this.nativeAd = new YNativeAd((Activity) context, sAAllianceNativeFeedAdData, YCustomerFeedAdapter.this.adapter);
                    YCustomerFeedAdapter.this.nativeAdDataList.add(YCustomerFeedAdapter.this.nativeAd);
                    YCustomerFeedAdapter.this.callLoadBiddingSuccess(new BidPrice(sAAllianceNativeFeedAdData.getECPM()));
                    YCustomerFeedAdapter yCustomerFeedAdapter = YCustomerFeedAdapter.this;
                    yCustomerFeedAdapter.callLoadSuccess(yCustomerFeedAdapter.nativeAdDataList);
                }

                @Override // com.alliance.ssp.ad.api.BaseAdLoadListener
                public void onError(int i, String str2) {
                    Log.i("Adapter", "优推自渲染广告加载失败, error msg = " + str2);
                    Log.e(YCustomerFeedAdapter.TAG, "onAdError, error code = " + i + ", error msg = " + str2);
                    YCustomerFeedAdapter.this.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "onAdError, error code = " + i + ", error msg = " + str2));
                }
            });
        }
    }

    public boolean isReady() {
        return !this.nativeAdDataList.isEmpty();
    }

    public void destroyAd() {
        Iterator<WMNativeAdData> it = this.nativeAdDataList.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
    }

    public List<WMNativeAdData> getNativeAdDataList() {
        return this.nativeAdDataList;
    }
}

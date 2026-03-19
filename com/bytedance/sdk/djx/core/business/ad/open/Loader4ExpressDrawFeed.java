package com.bytedance.sdk.djx.core.business.ad.open;

import android.view.View;
import com.bytedance.sdk.djx.core.business.ad.AdKey;
import com.bytedance.sdk.djx.core.business.ad.AdLog;
import com.bytedance.sdk.djx.core.business.ad.AdManager;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.bytedance.sdk.djx.interfaces.listener.IDJXAdListener;
import com.bytedance.sdk.djx.model.ev.BEAdCome;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class Loader4ExpressDrawFeed extends OpenLoaderAbs {
    private static final int MAX_LOAD_NUM = 3;
    private static final String TAG = "Loader4ExpressDrawFeed";
    private boolean mHasParseReqId;
    private String mRequestId;

    public Loader4ExpressDrawFeed(AdKey adKey) {
        super(adKey);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.open.OpenLoaderAbs
    protected AdSlot.Builder buildAdSlot() {
        int width;
        int height;
        if (this.mAdKey.getWidth() != 0 || this.mAdKey.getHeight() != 0) {
            width = this.mAdKey.getWidth();
            height = this.mAdKey.getHeight();
        } else {
            width = UIUtil.px2dp(UIUtil.getScreenWidth(InnerManager.getContext()));
            height = UIUtil.px2dp(UIUtil.getScreenHeight(InnerManager.getContext()));
        }
        return OpenAdUtils.createAdSlotBuilder(this.mAdKey.getCategoryFeature(), this.mAdKey).setCodeId(this.mAdKey.getCodeId()).setSupportDeepLink(true).setExpressViewAcceptedSize(width, height).setAdCount(3);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected void doLoad() {
        this.mTTAdNative.loadExpressDrawFeedAd(buildAdSlot().build(), new TTAdNative.NativeExpressAdListener() { // from class: com.bytedance.sdk.djx.core.business.ad.open.Loader4ExpressDrawFeed.1
            public void onError(int i, String str) {
                Loader4ExpressDrawFeed.this.mIsLoading = false;
                AdLog.getInstance().sendAdFailed(Loader4ExpressDrawFeed.this.mAdKey, i, str, null, false);
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4ExpressDrawFeed.this.mAdKey.getCodeId());
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4ExpressDrawFeed.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestFail(i, str, map);
                    }
                }
                LG.d("AdLog-Loader4ExpressDrawFeed", "load ad error rit: " + Loader4ExpressDrawFeed.this.mAdKey.getCodeId() + ", code = " + i + ", msg = " + str);
            }

            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                Loader4ExpressDrawFeed.this.mIsLoading = false;
                Loader4ExpressDrawFeed.this.mHasParseReqId = false;
                if (list == null) {
                    AdLog.getInstance().sendAdSuccess(Loader4ExpressDrawFeed.this.mAdKey, 0, null, false);
                    return;
                }
                AdLog.getInstance().sendAdSuccess(Loader4ExpressDrawFeed.this.mAdKey, list.size(), null, false);
                LG.d("AdLog-Loader4ExpressDrawFeed", "load ad rit: " + Loader4ExpressDrawFeed.this.mAdKey.getCodeId() + ", size = " + list.size());
                for (final TTNativeExpressAd tTNativeExpressAd : list) {
                    if (!Loader4ExpressDrawFeed.this.mHasParseReqId) {
                        Loader4ExpressDrawFeed.this.mRequestId = OpenAdUtils.getAdRequestId(tTNativeExpressAd);
                        Loader4ExpressDrawFeed.this.mHasParseReqId = true;
                    }
                    final Map<String, Object> mediaExtraInfo = OpenAdUtils.getMediaExtraInfo(tTNativeExpressAd);
                    final OpenExpressAd openExpressAd = new OpenExpressAd(tTNativeExpressAd, System.currentTimeMillis());
                    AdManager.inst().saveAd(Loader4ExpressDrawFeed.this.mAdKey, openExpressAd);
                    tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.sdk.djx.core.business.ad.open.Loader4ExpressDrawFeed.1.1
                        public void onAdClicked(View view, int i) {
                            AdLog.getInstance().sendAdClick(Loader4ExpressDrawFeed.this.mAdKey, null, false, -1, null);
                            LG.d("AdLog-Loader4ExpressDrawFeed", "draw ad clicked");
                            if (openExpressAd.getInnerAdExpressListener() != null) {
                                openExpressAd.getInnerAdExpressListener().onAdClicked(view, openExpressAd);
                            }
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, Loader4ExpressDrawFeed.this.mAdKey.getCodeId());
                                map.put("request_id", OpenAdUtils.getAdRequestId(tTNativeExpressAd));
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4ExpressDrawFeed.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdClicked(map);
                                }
                            }
                        }

                        public void onAdShow(View view, int i) {
                            AdLog.getInstance().sendAdShow(Loader4ExpressDrawFeed.this.mAdKey, null, false, -1);
                            LG.d("AdLog-Loader4ExpressDrawFeed", "draw ad show");
                            if (openExpressAd.getInnerAdExpressListener() != null) {
                                openExpressAd.getInnerAdExpressListener().onAdShow(openExpressAd);
                            }
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, Loader4ExpressDrawFeed.this.mAdKey.getCodeId());
                                map.put("request_id", OpenAdUtils.getAdRequestId(tTNativeExpressAd));
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4ExpressDrawFeed.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdShow(map);
                                }
                            }
                        }

                        public void onRenderFail(View view, String str, int i) {
                            LG.d("AdLog-Loader4ExpressDrawFeed", "draw ad render fail code = " + i + ", msg = " + str);
                            if (openExpressAd.getInnerAdExpressListener() != null) {
                                openExpressAd.getInnerAdExpressListener().onRenderFail(openExpressAd, str, i);
                            }
                        }

                        public void onRenderSuccess(View view, float f, float f2) {
                            LG.d("AdLog-Loader4ExpressDrawFeed", "draw ad render success");
                            if (openExpressAd.getInnerAdExpressListener() != null) {
                                openExpressAd.getInnerAdExpressListener().onRenderSuccess(openExpressAd, f, f2);
                            }
                        }
                    });
                    tTNativeExpressAd.render();
                }
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4ExpressDrawFeed.this.mAdKey.getCodeId());
                    map.put(PointParamKey.AD_COUNT, Integer.valueOf(list.size()));
                    map.put("request_id", Loader4ExpressDrawFeed.this.mRequestId);
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4ExpressDrawFeed.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestSuccess(map);
                    }
                }
                BEAdCome.build().setCodeId(Loader4ExpressDrawFeed.this.mAdKey.getCodeId()).send();
            }
        });
    }
}

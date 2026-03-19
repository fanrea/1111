package com.bytedance.sdk.djx.core.business.ad.open;

import android.text.TextUtils;
import com.bytedance.sdk.djx.core.business.ad.AdKey;
import com.bytedance.sdk.djx.core.business.ad.AdLog;
import com.bytedance.sdk.djx.core.business.ad.AdManager;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.bytedance.sdk.djx.core.business.ad.LoaderAbs;
import com.bytedance.sdk.djx.core.business.ad.LoaderModel;
import com.bytedance.sdk.djx.interfaces.listener.IDJXAdListener;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class LoaderMix4InteractionExpressNew extends OpenLoaderAbs {
    private static final int MAX_LOAD_NUM = 1;
    private static final String TAG = "Loader4InteractionExpressNew";
    private String mRequestId;

    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected void doLoad() {
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.open.OpenLoaderAbs, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    public void load() {
    }

    public LoaderMix4InteractionExpressNew(AdKey adKey) {
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
        return OpenAdUtils.createAdSlotBuilder(this.mAdKey.getCategoryFeature(), this.mAdKey).setCodeId(this.mAdKey.getCodeId()).setSupportDeepLink(true).setOrientation(1).setExpressViewAcceptedSize(width, height).setAdCount(1);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    public String getToken() {
        return TTAdSdk.getAdManager().getBiddingToken(buildAdSlot().build(), true, 8);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.open.OpenLoaderAbs, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected void doLoad(final LoaderModel loaderModel, final LoaderAbs.Callback callback) {
        if (loaderModel == null || TextUtils.isEmpty(loaderModel.mAdm)) {
            onErrorResponse(loaderModel, callback, 0, "adm is null");
            LG.d("AdLog-Loader4InteractionExpressNew", "load ad error rit: " + this.mAdKey.getCodeId() + ", code = 0, msg = adm is null");
        } else {
            this.mTTAdNative.loadFullScreenVideoAd(buildAdSlot().withBid(loaderModel.mAdm).build(), new TTAdNative.FullScreenVideoAdListener() { // from class: com.bytedance.sdk.djx.core.business.ad.open.LoaderMix4InteractionExpressNew.1
                public void onFullScreenVideoCached() {
                }

                public void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
                }

                public void onError(int i, String str) {
                    LoaderMix4InteractionExpressNew.this.onErrorResponse(loaderModel, callback, i, str);
                    LG.d("AdLog-Loader4InteractionExpressNew", "load ad error rit: " + LoaderMix4InteractionExpressNew.this.mAdKey.getCodeId() + ", code = " + i + ", msg = " + str);
                }

                public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
                    if (tTFullScreenVideoAd == null) {
                        AdLog.getInstance().sendAdSuccess(LoaderMix4InteractionExpressNew.this.mAdKey, 0, loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true);
                        return;
                    }
                    AdLog.getInstance().sendAdSuccess(LoaderMix4InteractionExpressNew.this.mAdKey, 1, loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true);
                    LG.d("AdLog-Loader4InteractionExpressNew", "load ad rit: " + LoaderMix4InteractionExpressNew.this.mAdKey.getCodeId() + ", size = 1");
                    LoaderMix4InteractionExpressNew.this.mRequestId = OpenAdUtils.getAdRequestId(tTFullScreenVideoAd);
                    final Map<String, Object> mediaExtraInfo = OpenAdUtils.getMediaExtraInfo(tTFullScreenVideoAd);
                    final OpenExpressInteractionAdNew openExpressInteractionAdNew = new OpenExpressInteractionAdNew(tTFullScreenVideoAd, System.currentTimeMillis());
                    openExpressInteractionAdNew.setFeed(loaderModel.mFeed);
                    tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(new TTFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: com.bytedance.sdk.djx.core.business.ad.open.LoaderMix4InteractionExpressNew.1.1
                        public void onAdShow() {
                            AdLog.getInstance().sendAdShow(LoaderMix4InteractionExpressNew.this.mAdKey, loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true, -1);
                            LG.d("AdLog-Loader4InteractionExpressNew", "interaction ad show");
                            if (openExpressInteractionAdNew.getFullVideoListener() != null) {
                                openExpressInteractionAdNew.getFullVideoListener().onAdShow(openExpressInteractionAdNew);
                            }
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, LoaderMix4InteractionExpressNew.this.mAdKey.getCodeId());
                                map.put("request_id", LoaderMix4InteractionExpressNew.this.mRequestId);
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(LoaderMix4InteractionExpressNew.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdShow(map);
                                }
                            }
                        }

                        public void onAdVideoBarClick() {
                            AdLog.getInstance().sendAdClick(LoaderMix4InteractionExpressNew.this.mAdKey, loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true, -1, null);
                            LG.d("AdLog-Loader4InteractionExpressNew", "interaction ad clicked");
                            if (openExpressInteractionAdNew.getFullVideoListener() != null) {
                                openExpressInteractionAdNew.getFullVideoListener().onAdVideoBarClick(openExpressInteractionAdNew);
                            }
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, LoaderMix4InteractionExpressNew.this.mAdKey.getCodeId());
                                map.put("request_id", LoaderMix4InteractionExpressNew.this.mRequestId);
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(LoaderMix4InteractionExpressNew.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdClicked(map);
                                }
                            }
                        }

                        public void onAdClose() {
                            LG.d("AdLog-Loader4InteractionExpressNew", "interaction ad ad close");
                            if (openExpressInteractionAdNew.getFullVideoListener() != null) {
                                openExpressInteractionAdNew.getFullVideoListener().onAdClose(openExpressInteractionAdNew);
                            }
                        }

                        public void onVideoComplete() {
                            AdLog.getInstance().sendAdComplete(LoaderMix4InteractionExpressNew.this.mAdKey, loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true, -1);
                            LG.d("AdLog-Loader4InteractionExpressNew", "interaction ad video complete");
                            if (openExpressInteractionAdNew.getFullVideoListener() != null) {
                                openExpressInteractionAdNew.getFullVideoListener().onVideoComplete(openExpressInteractionAdNew);
                            }
                        }

                        public void onSkippedVideo() {
                            LG.d("AdLog-Loader4InteractionExpressNew", "interaction ad skip video");
                            if (openExpressInteractionAdNew.getFullVideoListener() != null) {
                                openExpressInteractionAdNew.getFullVideoListener().onSkippedVideo(openExpressInteractionAdNew);
                            }
                        }
                    });
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(openExpressInteractionAdNew);
                    LoaderAbs.Callback callback2 = callback;
                    if (callback2 != null) {
                        callback2.onAdLoadSuccess(arrayList);
                    }
                    if (AdManager.inst().mAdListenerMap != null) {
                        HashMap map = new HashMap();
                        map.put(IDJXAd.AD_CODE_ID, LoaderMix4InteractionExpressNew.this.mAdKey.getCodeId());
                        map.put(PointParamKey.AD_COUNT, 1);
                        map.put("request_id", LoaderMix4InteractionExpressNew.this.mRequestId);
                        IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(LoaderMix4InteractionExpressNew.this.mAdKey.getParamsCode()));
                        if (iDJXAdListener != null) {
                            iDJXAdListener.onDJXAdRequestSuccess(map);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onErrorResponse(LoaderModel loaderModel, LoaderAbs.Callback callback, int i, String str) {
        if (callback != null) {
            callback.onAdLoadError(i, str);
        }
        AdLog.getInstance().sendAdFailed(this.mAdKey, i, str, loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true);
        if (AdManager.inst().mAdListenerMap != null) {
            HashMap map = new HashMap();
            map.put(IDJXAd.AD_CODE_ID, this.mAdKey.getCodeId());
            IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(this.mAdKey.getParamsCode()));
            if (iDJXAdListener != null) {
                iDJXAdListener.onDJXAdRequestFail(i, str, map);
            }
        }
    }
}

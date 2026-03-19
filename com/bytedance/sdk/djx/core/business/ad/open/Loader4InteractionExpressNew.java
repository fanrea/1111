package com.bytedance.sdk.djx.core.business.ad.open;

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
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class Loader4InteractionExpressNew extends OpenLoaderAbs {
    private static final int MAX_LOAD_NUM = 1;
    private static final String TAG = "Loader4InteractionExpressNew";
    private boolean mHasParseReqId;
    private String mRequestId;

    public Loader4InteractionExpressNew(AdKey adKey) {
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
            width = UIUtil.px2dp(UIUtil.getScreenWidth(InnerManager.getContext())) / 2;
            height = UIUtil.px2dp(UIUtil.getScreenHeight(InnerManager.getContext())) / 2;
        }
        return OpenAdUtils.createAdSlotBuilder(this.mAdKey.getCategoryFeature(), this.mAdKey).setCodeId(this.mAdKey.getCodeId()).setSupportDeepLink(true).setOrientation(1).setExpressViewAcceptedSize(width, height).setAdCount(1);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected void doLoad() {
        this.mTTAdNative.loadFullScreenVideoAd(buildAdSlot().build(), new TTAdNative.FullScreenVideoAdListener() { // from class: com.bytedance.sdk.djx.core.business.ad.open.Loader4InteractionExpressNew.1
            public void onFullScreenVideoCached() {
            }

            public void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
            }

            public void onError(int i, String str) {
                Loader4InteractionExpressNew.this.mIsLoading = false;
                AdLog.getInstance().sendAdFailed(Loader4InteractionExpressNew.this.mAdKey, i, str, null, false);
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4InteractionExpressNew.this.mAdKey.getCodeId());
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4InteractionExpressNew.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestFail(i, str, map);
                    }
                }
                LG.d("AdLog-Loader4InteractionExpressNew", "load ad error rit: " + Loader4InteractionExpressNew.this.mAdKey.getCodeId() + ", code = " + i + ", msg = " + str);
            }

            public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
                Loader4InteractionExpressNew.this.mIsLoading = false;
                Loader4InteractionExpressNew.this.mHasParseReqId = false;
                if (tTFullScreenVideoAd == null) {
                    AdLog.getInstance().sendAdSuccess(Loader4InteractionExpressNew.this.mAdKey, 0, null, false);
                    return;
                }
                AdLog.getInstance().sendAdSuccess(Loader4InteractionExpressNew.this.mAdKey, 1, null, false);
                LG.d("AdLog-Loader4InteractionExpressNew", "load ad rit: " + Loader4InteractionExpressNew.this.mAdKey.getCodeId() + ", size = 1");
                if (!Loader4InteractionExpressNew.this.mHasParseReqId) {
                    Loader4InteractionExpressNew.this.mRequestId = OpenAdUtils.getAdRequestId(tTFullScreenVideoAd);
                    Loader4InteractionExpressNew.this.mHasParseReqId = true;
                }
                final Map<String, Object> mediaExtraInfo = OpenAdUtils.getMediaExtraInfo(tTFullScreenVideoAd);
                final OpenExpressInteractionAdNew openExpressInteractionAdNew = new OpenExpressInteractionAdNew(tTFullScreenVideoAd, System.currentTimeMillis());
                AdManager.inst().saveAd(Loader4InteractionExpressNew.this.mAdKey, openExpressInteractionAdNew);
                tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(new TTFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: com.bytedance.sdk.djx.core.business.ad.open.Loader4InteractionExpressNew.1.1
                    public void onAdShow() {
                        AdLog.getInstance().sendAdShow(Loader4InteractionExpressNew.this.mAdKey, null, false, -1);
                        LG.d("AdLog-Loader4InteractionExpressNew", "interaction ad show");
                        if (openExpressInteractionAdNew.getFullVideoListener() != null) {
                            openExpressInteractionAdNew.getFullVideoListener().onAdShow(openExpressInteractionAdNew);
                        }
                        if (AdManager.inst().mAdListenerMap != null) {
                            HashMap map = new HashMap();
                            map.put(IDJXAd.AD_CODE_ID, Loader4InteractionExpressNew.this.mAdKey.getCodeId());
                            map.put("request_id", Loader4InteractionExpressNew.this.mRequestId);
                            Map map2 = mediaExtraInfo;
                            if (map2 != null) {
                                map.putAll(map2);
                            }
                            IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4InteractionExpressNew.this.mAdKey.getParamsCode()));
                            if (iDJXAdListener != null) {
                                iDJXAdListener.onDJXAdShow(map);
                            }
                        }
                    }

                    public void onAdVideoBarClick() {
                        AdLog.getInstance().sendAdClick(Loader4InteractionExpressNew.this.mAdKey, null, false, -1, null);
                        LG.d("AdLog-Loader4InteractionExpressNew", "interaction ad clicked");
                        if (openExpressInteractionAdNew.getFullVideoListener() != null) {
                            openExpressInteractionAdNew.getFullVideoListener().onAdVideoBarClick(openExpressInteractionAdNew);
                        }
                        if (AdManager.inst().mAdListenerMap != null) {
                            HashMap map = new HashMap();
                            map.put(IDJXAd.AD_CODE_ID, Loader4InteractionExpressNew.this.mAdKey.getCodeId());
                            map.put("request_id", Loader4InteractionExpressNew.this.mRequestId);
                            Map map2 = mediaExtraInfo;
                            if (map2 != null) {
                                map.putAll(map2);
                            }
                            IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4InteractionExpressNew.this.mAdKey.getParamsCode()));
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
                        AdLog.getInstance().sendAdComplete(Loader4InteractionExpressNew.this.mAdKey, null, false, -1);
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
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4InteractionExpressNew.this.mAdKey.getCodeId());
                    map.put(PointParamKey.AD_COUNT, 1);
                    map.put("request_id", Loader4InteractionExpressNew.this.mRequestId);
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4InteractionExpressNew.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestSuccess(map);
                    }
                }
                BEAdCome.build().setCodeId(Loader4InteractionExpressNew.this.mAdKey.getCodeId()).send();
            }
        });
    }
}

package com.bytedance.sdk.djx.core.business.ad.oppo3110;

import com.bykv.vk.openvk.TTFullVideoObject;
import com.bykv.vk.openvk.TTVfNative;
import com.bykv.vk.openvk.VfSlot;
import com.bytedance.sdk.djx.core.business.ad.AdKey;
import com.bytedance.sdk.djx.core.business.ad.AdLog;
import com.bytedance.sdk.djx.core.business.ad.AdManager;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.bytedance.sdk.djx.core.business.ad.LoaderAbs;
import com.bytedance.sdk.djx.core.business.ad.LoaderModel;
import com.bytedance.sdk.djx.interfaces.listener.IDJXAdListener;
import com.bytedance.sdk.djx.model.ev.BEAdCome;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class Loader4VfInteractionExpressNew extends VfLoaderAbs {
    private static final int MAX_LOAD_NUM = 1;
    private static final String TAG = "Loader4VfInteractionExpress";
    private boolean mHasParseReqId;
    private String mRequestId;

    @Override // com.bytedance.sdk.djx.core.business.ad.oppo3110.VfLoaderAbs, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    public /* bridge */ /* synthetic */ void load() {
        super.load();
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.oppo3110.VfLoaderAbs, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    public /* bridge */ /* synthetic */ void load(LoaderModel loaderModel, LoaderAbs.Callback callback) {
        super.load(loaderModel, callback);
    }

    public Loader4VfInteractionExpressNew(AdKey adKey) {
        super(adKey);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.oppo3110.VfLoaderAbs
    protected VfSlot.Builder buildAdSlot() {
        int width;
        int height;
        if (this.mAdKey.getWidth() != 0 || this.mAdKey.getHeight() != 0) {
            width = this.mAdKey.getWidth();
            height = this.mAdKey.getHeight();
        } else {
            width = UIUtil.px2dp(UIUtil.getScreenWidth(InnerManager.getContext())) / 2;
            height = UIUtil.px2dp(UIUtil.getScreenHeight(InnerManager.getContext())) / 2;
        }
        return OppoVfUtils.createVfSlotBuilder().setCodeId(this.mAdKey.getCodeId()).setSupportDeepLink(true).setAdCount(1).setOrientation(1).setExpressViewAcceptedSize(width, height).setImageAcceptedSize(300, 300);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected void doLoad() {
        this.mTTAdNative.loadFullVideoVs(buildAdSlot().build(), new TTVfNative.FullScreenVideoAdListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo3110.Loader4VfInteractionExpressNew.1
            public void onFullVideoCached() {
            }

            public void onFullVideoCached(TTFullVideoObject tTFullVideoObject) {
            }

            public void onError(int i, String str) {
                Loader4VfInteractionExpressNew.this.mIsLoading = false;
                AdLog.getInstance().sendAdFailed(Loader4VfInteractionExpressNew.this.mAdKey, i, str, null, false);
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4VfInteractionExpressNew.this.mAdKey.getCodeId());
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4VfInteractionExpressNew.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestFail(i, str, map);
                    }
                }
                LG.d("AdLog-Loader4VfInteractionExpress", "load ad error rit: " + Loader4VfInteractionExpressNew.this.mAdKey.getCodeId() + ", code = " + i + ", msg = " + str);
            }

            public void onFullVideoVsLoad(TTFullVideoObject tTFullVideoObject) {
                Loader4VfInteractionExpressNew.this.mIsLoading = false;
                Loader4VfInteractionExpressNew.this.mHasParseReqId = false;
                if (tTFullVideoObject == null) {
                    AdLog.getInstance().sendAdSuccess(Loader4VfInteractionExpressNew.this.mAdKey, 0, null, false);
                    return;
                }
                AdLog.getInstance().sendAdSuccess(Loader4VfInteractionExpressNew.this.mAdKey, 1, null, false);
                LG.d("AdLog-Loader4VfInteractionExpress", "load ad rit: " + Loader4VfInteractionExpressNew.this.mAdKey.getCodeId() + ", size = 1");
                if (!Loader4VfInteractionExpressNew.this.mHasParseReqId) {
                    Loader4VfInteractionExpressNew.this.mRequestId = OppoVfUtils.getAdRequestId(tTFullVideoObject);
                    Loader4VfInteractionExpressNew.this.mHasParseReqId = true;
                }
                final Map<String, Object> mediaExtraInfo = OppoVfUtils.getMediaExtraInfo(tTFullVideoObject);
                final VfExpressInteractionAdNew vfExpressInteractionAdNew = new VfExpressInteractionAdNew(tTFullVideoObject, System.currentTimeMillis());
                AdManager.inst().saveAd(Loader4VfInteractionExpressNew.this.mAdKey, vfExpressInteractionAdNew);
                tTFullVideoObject.setFullScreenVideoAdInteractionListener(new TTFullVideoObject.FullVideoVsInteractionListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo3110.Loader4VfInteractionExpressNew.1.1
                    public void onShow() {
                        AdLog.getInstance().sendAdShow(Loader4VfInteractionExpressNew.this.mAdKey, null, false, -1);
                        LG.d("AdLog-Loader4VfInteractionExpress", "interaction ad show");
                        if (vfExpressInteractionAdNew.getFullVideoListener() != null) {
                            vfExpressInteractionAdNew.getFullVideoListener().onAdShow(vfExpressInteractionAdNew);
                        }
                        if (AdManager.inst().mAdListenerMap != null) {
                            HashMap map = new HashMap();
                            map.put(IDJXAd.AD_CODE_ID, Loader4VfInteractionExpressNew.this.mAdKey.getCodeId());
                            map.put("request_id", Loader4VfInteractionExpressNew.this.mRequestId);
                            Map map2 = mediaExtraInfo;
                            if (map2 != null) {
                                map.putAll(map2);
                            }
                            IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4VfInteractionExpressNew.this.mAdKey.getParamsCode()));
                            if (iDJXAdListener != null) {
                                iDJXAdListener.onDJXAdShow(map);
                            }
                        }
                    }

                    public void onVideoBarClick() {
                        AdLog.getInstance().sendAdClick(Loader4VfInteractionExpressNew.this.mAdKey, null, false, -1, null);
                        LG.d("AdLog-Loader4VfInteractionExpress", "interaction ad clicked");
                        if (vfExpressInteractionAdNew.getFullVideoListener() != null) {
                            vfExpressInteractionAdNew.getFullVideoListener().onAdVideoBarClick(vfExpressInteractionAdNew);
                        }
                        if (AdManager.inst().mAdListenerMap != null) {
                            HashMap map = new HashMap();
                            map.put(IDJXAd.AD_CODE_ID, Loader4VfInteractionExpressNew.this.mAdKey.getCodeId());
                            map.put("request_id", Loader4VfInteractionExpressNew.this.mRequestId);
                            Map map2 = mediaExtraInfo;
                            if (map2 != null) {
                                map.putAll(map2);
                            }
                            IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4VfInteractionExpressNew.this.mAdKey.getParamsCode()));
                            if (iDJXAdListener != null) {
                                iDJXAdListener.onDJXAdClicked(map);
                            }
                        }
                    }

                    public void onClose() {
                        LG.d("AdLog-Loader4VfInteractionExpress", "interaction ad ad close");
                        if (vfExpressInteractionAdNew.getFullVideoListener() != null) {
                            vfExpressInteractionAdNew.getFullVideoListener().onAdClose(vfExpressInteractionAdNew);
                        }
                    }

                    public void onVideoComplete() {
                        AdLog.getInstance().sendAdComplete(Loader4VfInteractionExpressNew.this.mAdKey, null, false, -1);
                        LG.d("AdLog-Loader4VfInteractionExpress", "interaction ad video complete");
                        if (vfExpressInteractionAdNew.getFullVideoListener() != null) {
                            vfExpressInteractionAdNew.getFullVideoListener().onVideoComplete(vfExpressInteractionAdNew);
                        }
                    }

                    public void onSkippedVideo() {
                        LG.d("AdLog-Loader4VfInteractionExpress", "interaction ad skip video");
                        if (vfExpressInteractionAdNew.getFullVideoListener() != null) {
                            vfExpressInteractionAdNew.getFullVideoListener().onSkippedVideo(vfExpressInteractionAdNew);
                        }
                    }
                });
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4VfInteractionExpressNew.this.mAdKey.getCodeId());
                    map.put(PointParamKey.AD_COUNT, 1);
                    map.put("request_id", Loader4VfInteractionExpressNew.this.mRequestId);
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4VfInteractionExpressNew.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestSuccess(map);
                    }
                }
                BEAdCome.build().setCodeId(Loader4VfInteractionExpressNew.this.mAdKey.getCodeId()).send();
            }
        });
    }
}

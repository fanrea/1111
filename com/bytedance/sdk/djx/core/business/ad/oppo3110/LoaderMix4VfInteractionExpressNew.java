package com.bytedance.sdk.djx.core.business.ad.oppo3110;

import android.text.TextUtils;
import com.bykv.vk.openvk.TTFullVideoObject;
import com.bykv.vk.openvk.TTVfNative;
import com.bykv.vk.openvk.TTVfSdk;
import com.bykv.vk.openvk.VfSlot;
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
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class LoaderMix4VfInteractionExpressNew extends VfLoaderAbs {
    private static final int MAX_LOAD_NUM = 1;
    private static final String TAG = "Loader4VfInteractionExpress";
    private String mRequestId;

    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected void doLoad() {
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.oppo3110.VfLoaderAbs, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    public void load() {
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.oppo3110.VfLoaderAbs, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    public /* bridge */ /* synthetic */ void load(LoaderModel loaderModel, LoaderAbs.Callback callback) {
        super.load(loaderModel, callback);
    }

    public LoaderMix4VfInteractionExpressNew(AdKey adKey) {
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
            width = UIUtil.px2dp(UIUtil.getScreenWidth(InnerManager.getContext()));
            height = UIUtil.px2dp(UIUtil.getScreenHeight(InnerManager.getContext()));
        }
        return OppoVfUtils.createVfSlotBuilder().setCodeId(this.mAdKey.getCodeId()).setSupportDeepLink(true).setAdCount(1).setOrientation(1).setExpressViewAcceptedSize(width, height).setImageAcceptedSize(300, 300);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    public String getToken() {
        return TTVfSdk.getVfManager().getBiddingToken(buildAdSlot().build(), true, 8);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.oppo3110.VfLoaderAbs, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected void doLoad(final LoaderModel loaderModel, final LoaderAbs.Callback callback) {
        if (loaderModel == null || TextUtils.isEmpty(loaderModel.mAdm)) {
            onErrorResponse(loaderModel, callback, 0, "adm is null");
            LG.d("AdLog-Loader4VfInteractionExpress", "load ad error rit: " + this.mAdKey.getCodeId() + ", code = 0, msg = adm is null");
        } else {
            this.mTTAdNative.loadFullVideoVs(buildAdSlot().withBid(loaderModel.mAdm).build(), new TTVfNative.FullScreenVideoAdListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo3110.LoaderMix4VfInteractionExpressNew.1
                public void onFullVideoCached() {
                }

                public void onFullVideoCached(TTFullVideoObject tTFullVideoObject) {
                }

                public void onError(int i, String str) {
                    LoaderMix4VfInteractionExpressNew.this.onErrorResponse(loaderModel, callback, i, str);
                    LG.d("AdLog-Loader4VfInteractionExpress", "load ad error rit: " + LoaderMix4VfInteractionExpressNew.this.mAdKey.getCodeId() + ", code = " + i + ", msg = " + str);
                }

                public void onFullVideoVsLoad(TTFullVideoObject tTFullVideoObject) {
                    LoaderMix4VfInteractionExpressNew.this.mIsLoading = false;
                    if (tTFullVideoObject == null) {
                        AdLog.getInstance().sendAdSuccess(LoaderMix4VfInteractionExpressNew.this.mAdKey, 0, loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true);
                        return;
                    }
                    AdLog.getInstance().sendAdSuccess(LoaderMix4VfInteractionExpressNew.this.mAdKey, 1, loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true);
                    LG.d("AdLog-Loader4VfInteractionExpress", "load ad rit: " + LoaderMix4VfInteractionExpressNew.this.mAdKey.getCodeId() + ", size = 1");
                    LoaderMix4VfInteractionExpressNew.this.mRequestId = OppoVfUtils.getAdRequestId(tTFullVideoObject);
                    final Map<String, Object> mediaExtraInfo = OppoVfUtils.getMediaExtraInfo(tTFullVideoObject);
                    final VfExpressInteractionAdNew vfExpressInteractionAdNew = new VfExpressInteractionAdNew(tTFullVideoObject, System.currentTimeMillis());
                    vfExpressInteractionAdNew.setFeed(loaderModel.mFeed);
                    tTFullVideoObject.setFullScreenVideoAdInteractionListener(new TTFullVideoObject.FullVideoVsInteractionListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo3110.LoaderMix4VfInteractionExpressNew.1.1
                        public void onShow() {
                            AdLog.getInstance().sendAdShow(LoaderMix4VfInteractionExpressNew.this.mAdKey, loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true, -1);
                            LG.d("AdLog-Loader4VfInteractionExpress", "interaction ad show");
                            if (vfExpressInteractionAdNew.getFullVideoListener() != null) {
                                vfExpressInteractionAdNew.getFullVideoListener().onAdShow(vfExpressInteractionAdNew);
                            }
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, LoaderMix4VfInteractionExpressNew.this.mAdKey.getCodeId());
                                map.put("request_id", LoaderMix4VfInteractionExpressNew.this.mRequestId);
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(LoaderMix4VfInteractionExpressNew.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdShow(map);
                                }
                            }
                        }

                        public void onVideoBarClick() {
                            AdLog.getInstance().sendAdClick(LoaderMix4VfInteractionExpressNew.this.mAdKey, loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true, -1, null);
                            LG.d("AdLog-Loader4VfInteractionExpress", "interaction ad clicked");
                            if (vfExpressInteractionAdNew.getFullVideoListener() != null) {
                                vfExpressInteractionAdNew.getFullVideoListener().onAdVideoBarClick(vfExpressInteractionAdNew);
                            }
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, LoaderMix4VfInteractionExpressNew.this.mAdKey.getCodeId());
                                map.put("request_id", LoaderMix4VfInteractionExpressNew.this.mRequestId);
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(LoaderMix4VfInteractionExpressNew.this.mAdKey.getParamsCode()));
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
                            AdLog.getInstance().sendAdComplete(LoaderMix4VfInteractionExpressNew.this.mAdKey, loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true, -1);
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
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(vfExpressInteractionAdNew);
                    LoaderAbs.Callback callback2 = callback;
                    if (callback2 != null) {
                        callback2.onAdLoadSuccess(arrayList);
                    }
                    if (AdManager.inst().mAdListenerMap != null) {
                        HashMap map = new HashMap();
                        map.put(IDJXAd.AD_CODE_ID, LoaderMix4VfInteractionExpressNew.this.mAdKey.getCodeId());
                        map.put(PointParamKey.AD_COUNT, 1);
                        map.put("request_id", LoaderMix4VfInteractionExpressNew.this.mRequestId);
                        IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(LoaderMix4VfInteractionExpressNew.this.mAdKey.getParamsCode()));
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

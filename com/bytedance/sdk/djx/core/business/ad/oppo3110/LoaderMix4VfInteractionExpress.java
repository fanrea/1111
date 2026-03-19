package com.bytedance.sdk.djx.core.business.ad.oppo3110;

import android.text.TextUtils;
import android.view.View;
import com.bykv.vk.openvk.TTNtExpressObject;
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
import com.bytedance.sdk.djx.utils.LG;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class LoaderMix4VfInteractionExpress extends VfLoaderAbs {
    private static final int MAX_LOAD_NUM = 1;
    private static final String TAG = "LoaderMix4InteractionExpress";

    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected void doLoad() {
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.oppo3110.VfLoaderAbs, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    public void load() {
    }

    public LoaderMix4VfInteractionExpress(AdKey adKey) {
        super(adKey);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.oppo3110.VfLoaderAbs
    protected VfSlot.Builder buildAdSlot() {
        int width;
        int height;
        if (this.mAdKey.getWidth() == 0 && this.mAdKey.getHeight() == 0) {
            width = 300;
            height = 300;
        } else {
            width = this.mAdKey.getWidth();
            height = this.mAdKey.getHeight();
        }
        return OppoVfUtils.createVfSlotBuilder().setCodeId(this.mAdKey.getCodeId()).setSupportDeepLink(true).setAdCount(1).setExpressViewAcceptedSize(width, height).setImageAcceptedSize(300, 300);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    public String getToken() {
        return TTVfSdk.getVfManager().getBiddingToken(buildAdSlot().build(), true, 2);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.oppo3110.VfLoaderAbs, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected void doLoad(final LoaderModel loaderModel, final LoaderAbs.Callback callback) {
        if (loaderModel == null || TextUtils.isEmpty(loaderModel.mAdm)) {
            onErrorResponse(loaderModel, callback, 0, "adm is null");
            LG.d("AdLog-LoaderMix4InteractionExpress", "load ad error rit: " + this.mAdKey.getCodeId() + ", code = 0, msg = adm is null");
        } else {
            this.mTTAdNative.loadItExpressVi(buildAdSlot().withBid(loaderModel.mAdm).build(), new TTVfNative.NtExpressVfListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo3110.LoaderMix4VfInteractionExpress.1
                public void onError(int i, String str) {
                    LoaderMix4VfInteractionExpress.this.onErrorResponse(loaderModel, callback, i, str);
                    LG.d("AdLog-LoaderMix4InteractionExpress", "load ad error rit: " + LoaderMix4VfInteractionExpress.this.mAdKey.getCodeId() + ", code = " + i + ", msg = " + str);
                }

                public void onNtExpressVnLoad(List<TTNtExpressObject> list) {
                    if (list == null) {
                        AdLog.getInstance().sendAdSuccess(LoaderMix4VfInteractionExpress.this.mAdKey, 0, loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true);
                        return;
                    }
                    AdLog.getInstance().sendAdSuccess(LoaderMix4VfInteractionExpress.this.mAdKey, list.size(), loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true);
                    LG.d("AdLog-LoaderMix4InteractionExpress", "load ad rit: " + LoaderMix4VfInteractionExpress.this.mAdKey.getCodeId() + ", size = " + list.size());
                    ArrayList arrayList = new ArrayList();
                    String str = "";
                    for (final TTNtExpressObject tTNtExpressObject : list) {
                        final VfExpressInteractionAd vfExpressInteractionAd = new VfExpressInteractionAd(tTNtExpressObject, System.currentTimeMillis());
                        vfExpressInteractionAd.setFeed(loaderModel.mFeed);
                        arrayList.add(vfExpressInteractionAd);
                        String adRequestId = OppoVfUtils.getAdRequestId(tTNtExpressObject);
                        final Map<String, Object> mediaExtraInfo = OppoVfUtils.getMediaExtraInfo(tTNtExpressObject);
                        tTNtExpressObject.setExpressInteractionListener(new TTNtExpressObject.NtInteractionListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo3110.LoaderMix4VfInteractionExpress.1.1
                            public void onDismiss() {
                                LG.d("AdLog-LoaderMix4InteractionExpress", "interaction ad dismiss");
                                if (vfExpressInteractionAd.getInnerAdExpressListener() != null) {
                                    vfExpressInteractionAd.getInnerAdExpressListener().onAdDismiss();
                                }
                            }

                            public void onClicked(View view, int i) {
                                AdLog.getInstance().sendAdClick(LoaderMix4VfInteractionExpress.this.mAdKey, loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true, -1, null);
                                LG.d("AdLog-LoaderMix4InteractionExpress", "interaction ad clicked");
                                if (vfExpressInteractionAd.getInnerAdExpressListener() != null) {
                                    vfExpressInteractionAd.getInnerAdExpressListener().onAdClicked(view, vfExpressInteractionAd);
                                }
                                if (AdManager.inst().mAdListenerMap != null) {
                                    HashMap map = new HashMap();
                                    map.put(IDJXAd.AD_CODE_ID, LoaderMix4VfInteractionExpress.this.mAdKey.getCodeId());
                                    map.put("request_id", OppoVfUtils.getAdRequestId(tTNtExpressObject));
                                    Map map2 = mediaExtraInfo;
                                    if (map2 != null) {
                                        map.putAll(map2);
                                    }
                                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(LoaderMix4VfInteractionExpress.this.mAdKey.getParamsCode()));
                                    if (iDJXAdListener != null) {
                                        iDJXAdListener.onDJXAdClicked(map);
                                    }
                                }
                            }

                            public void onShow(View view, int i) {
                                AdLog.getInstance().sendAdShow(LoaderMix4VfInteractionExpress.this.mAdKey, loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true, -1);
                                LG.d("AdLog-LoaderMix4InteractionExpress", "interaction ad show");
                                if (vfExpressInteractionAd.getInnerAdExpressListener() != null) {
                                    vfExpressInteractionAd.getInnerAdExpressListener().onAdShow(vfExpressInteractionAd);
                                }
                                if (AdManager.inst().mAdListenerMap != null) {
                                    HashMap map = new HashMap();
                                    map.put(IDJXAd.AD_CODE_ID, LoaderMix4VfInteractionExpress.this.mAdKey.getCodeId());
                                    map.put("request_id", OppoVfUtils.getAdRequestId(tTNtExpressObject));
                                    Map map2 = mediaExtraInfo;
                                    if (map2 != null) {
                                        map.putAll(map2);
                                    }
                                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(LoaderMix4VfInteractionExpress.this.mAdKey.getParamsCode()));
                                    if (iDJXAdListener != null) {
                                        iDJXAdListener.onDJXAdShow(map);
                                    }
                                }
                            }

                            public void onRenderFail(View view, String str2, int i) {
                                LG.d("AdLog-LoaderMix4InteractionExpress", "interaction ad render fail code = " + i + ", msg = " + str2);
                                if (vfExpressInteractionAd.getInnerAdExpressListener() != null) {
                                    vfExpressInteractionAd.getInnerAdExpressListener().onRenderFail(vfExpressInteractionAd, str2, i);
                                }
                            }

                            public void onRenderSuccess(View view, float f, float f2) {
                                LG.d("AdLog-LoaderMix4InteractionExpress", "interaction ad render success");
                                if (vfExpressInteractionAd.getInnerAdExpressListener() != null) {
                                    vfExpressInteractionAd.getInnerAdExpressListener().onRenderSuccess(vfExpressInteractionAd, f, f2);
                                }
                            }
                        });
                        tTNtExpressObject.render();
                        str = adRequestId;
                    }
                    LoaderAbs.Callback callback2 = callback;
                    if (callback2 != null) {
                        callback2.onAdLoadSuccess(arrayList);
                    }
                    if (AdManager.inst().mAdListenerMap != null) {
                        HashMap map = new HashMap();
                        map.put(IDJXAd.AD_CODE_ID, LoaderMix4VfInteractionExpress.this.mAdKey.getCodeId());
                        map.put(PointParamKey.AD_COUNT, Integer.valueOf(list.size()));
                        map.put("request_id", str);
                        IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(LoaderMix4VfInteractionExpress.this.mAdKey.getParamsCode()));
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

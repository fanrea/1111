package com.bytedance.sdk.djx.core.business.ad.oppo3110;

import android.text.TextUtils;
import android.view.View;
import com.bykv.vk.openvk.TTNtExpressObject;
import com.bykv.vk.openvk.TTVfNative;
import com.bykv.vk.openvk.TTVfSdk;
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
class LoaderMix4VfExpressDrawFeed extends Loader4VfExpressDrawFeed {
    private static final String TAG = "LoaderMix4VfExpressDrawFeed";

    @Override // com.bytedance.sdk.djx.core.business.ad.oppo3110.Loader4VfExpressDrawFeed, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected void doLoad() {
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.oppo3110.VfLoaderAbs, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    public void load() {
    }

    public LoaderMix4VfExpressDrawFeed(AdKey adKey) {
        super(adKey);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    public String getToken() {
        return TTVfSdk.getVfManager().getBiddingToken(buildAdSlot().build(), true, 9);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.oppo3110.VfLoaderAbs, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected void doLoad(final LoaderModel loaderModel, final LoaderAbs.Callback callback) {
        if (loaderModel == null || TextUtils.isEmpty(loaderModel.mAdm)) {
            onErrorResponse(loaderModel, callback, 0, "adm is null");
            LG.d("AdLog-LoaderMix4VfExpressDrawFeed", "load ad error rit: " + this.mAdKey.getCodeId() + ", code = 0, msg = adm is null");
        } else {
            this.mTTAdNative.loadExpressDrawVf(buildAdSlot().withBid(loaderModel.mAdm).build(), new TTVfNative.NtExpressVfListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo3110.LoaderMix4VfExpressDrawFeed.1
                public void onError(int i, String str) {
                    LoaderMix4VfExpressDrawFeed.this.onErrorResponse(loaderModel, callback, i, str);
                    LG.d("AdLog-LoaderMix4VfExpressDrawFeed", "load ad error rit: " + LoaderMix4VfExpressDrawFeed.this.mAdKey.getCodeId() + ", code = " + i + ", msg = " + str);
                }

                public void onNtExpressVnLoad(List<TTNtExpressObject> list) {
                    if (list == null) {
                        AdLog.getInstance().sendAdSuccess(LoaderMix4VfExpressDrawFeed.this.mAdKey, 0, loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true);
                        return;
                    }
                    AdLog.getInstance().sendAdSuccess(LoaderMix4VfExpressDrawFeed.this.mAdKey, list.size(), loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true);
                    LG.d("AdLog-LoaderMix4VfExpressDrawFeed", "load ad rit: " + LoaderMix4VfExpressDrawFeed.this.mAdKey.getCodeId() + ", size = " + list.size());
                    ArrayList arrayList = new ArrayList();
                    String str = "";
                    for (final TTNtExpressObject tTNtExpressObject : list) {
                        final VfExpressAd vfExpressAd = new VfExpressAd(tTNtExpressObject, System.currentTimeMillis());
                        arrayList.add(vfExpressAd);
                        String adRequestId = OppoVfUtils.getAdRequestId(tTNtExpressObject);
                        final Map<String, Object> mediaExtraInfo = OppoVfUtils.getMediaExtraInfo(tTNtExpressObject);
                        tTNtExpressObject.setExpressInteractionListener(new TTNtExpressObject.ExpressNtInteractionListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo3110.LoaderMix4VfExpressDrawFeed.1.1
                            public void onClicked(View view, int i) {
                                AdLog.getInstance().sendAdClick(LoaderMix4VfExpressDrawFeed.this.mAdKey, loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true, -1, null);
                                LG.d("AdLog-LoaderMix4VfExpressDrawFeed", "draw ad clicked");
                                if (vfExpressAd.getInnerAdExpressListener() != null) {
                                    vfExpressAd.getInnerAdExpressListener().onAdClicked(view, vfExpressAd);
                                }
                                if (AdManager.inst().mAdListenerMap != null) {
                                    HashMap map = new HashMap();
                                    map.put(IDJXAd.AD_CODE_ID, LoaderMix4VfExpressDrawFeed.this.mAdKey.getCodeId());
                                    map.put("request_id", OppoVfUtils.getAdRequestId(tTNtExpressObject));
                                    Map map2 = mediaExtraInfo;
                                    if (map2 != null) {
                                        map.putAll(map2);
                                    }
                                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(LoaderMix4VfExpressDrawFeed.this.mAdKey.getParamsCode()));
                                    if (iDJXAdListener != null) {
                                        iDJXAdListener.onDJXAdClicked(map);
                                    }
                                }
                            }

                            public void onShow(View view, int i) {
                                AdLog.getInstance().sendAdShow(LoaderMix4VfExpressDrawFeed.this.mAdKey, loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true, -1);
                                LG.d("AdLog-LoaderMix4VfExpressDrawFeed", "draw ad show");
                                if (vfExpressAd.getInnerAdExpressListener() != null) {
                                    vfExpressAd.getInnerAdExpressListener().onAdShow(vfExpressAd);
                                }
                                if (AdManager.inst().mAdListenerMap != null) {
                                    HashMap map = new HashMap();
                                    map.put(IDJXAd.AD_CODE_ID, LoaderMix4VfExpressDrawFeed.this.mAdKey.getCodeId());
                                    map.put("request_id", OppoVfUtils.getAdRequestId(tTNtExpressObject));
                                    Map map2 = mediaExtraInfo;
                                    if (map2 != null) {
                                        map.putAll(map2);
                                    }
                                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(LoaderMix4VfExpressDrawFeed.this.mAdKey.getParamsCode()));
                                    if (iDJXAdListener != null) {
                                        iDJXAdListener.onDJXAdShow(map);
                                    }
                                }
                            }

                            public void onRenderFail(View view, String str2, int i) {
                                LG.d("AdLog-LoaderMix4VfExpressDrawFeed", "draw ad render fail code = " + i + ", msg = " + str2);
                                if (vfExpressAd.getInnerAdExpressListener() != null) {
                                    vfExpressAd.getInnerAdExpressListener().onRenderFail(vfExpressAd, str2, i);
                                }
                            }

                            public void onRenderSuccess(View view, float f, float f2) {
                                LG.d("AdLog-LoaderMix4VfExpressDrawFeed", "draw ad render success");
                                if (vfExpressAd.getInnerAdExpressListener() != null) {
                                    vfExpressAd.getInnerAdExpressListener().onRenderSuccess(vfExpressAd, f, f2);
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
                        map.put(IDJXAd.AD_CODE_ID, LoaderMix4VfExpressDrawFeed.this.mAdKey.getCodeId());
                        map.put(PointParamKey.AD_COUNT, Integer.valueOf(list.size()));
                        map.put("request_id", str);
                        IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(LoaderMix4VfExpressDrawFeed.this.mAdKey.getParamsCode()));
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

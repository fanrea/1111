package com.bytedance.sdk.djx.core.business.ad.oppo3110;

import android.text.TextUtils;
import com.bykv.vk.openvk.TTDrawVfObject;
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

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class LoaderMix4VfNativeDrawFeed extends Loader4VfNativeDrawFeed {
    private static final String TAG = "LoaderMix4VfNativeDrawFeed";

    @Override // com.bytedance.sdk.djx.core.business.ad.oppo3110.Loader4VfNativeDrawFeed, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected void doLoad() {
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.oppo3110.VfLoaderAbs, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    public void load() {
    }

    public LoaderMix4VfNativeDrawFeed(AdKey adKey) {
        super(adKey);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    public String getToken() {
        return TTVfSdk.getVfManager().getBiddingToken(buildAdSlot().build(), false, 9);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.oppo3110.VfLoaderAbs, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected void doLoad(final LoaderModel loaderModel, final LoaderAbs.Callback callback) {
        if (loaderModel == null || TextUtils.isEmpty(loaderModel.mAdm)) {
            onErrorResponse(loaderModel, callback, 0, "adm is null");
            LG.d("AdLog-LoaderMix4VfNativeDrawFeed", "load ad error rit: " + this.mAdKey.getCodeId() + ", code = 0, msg = adm is null");
        } else {
            this.mTTAdNative.loadDrawVfList(buildAdSlot().withBid(loaderModel.mAdm).build(), new TTVfNative.DrawVfListListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo3110.LoaderMix4VfNativeDrawFeed.1
                public void onError(int i, String str) {
                    LoaderMix4VfNativeDrawFeed.this.onErrorResponse(loaderModel, callback, i, str);
                    LG.d("AdLog-LoaderMix4VfNativeDrawFeed", "load ad error rit: " + LoaderMix4VfNativeDrawFeed.this.mAdKey.getCodeId() + ", code = " + i + ", msg = " + str);
                }

                public void onDrawFeedAdLoad(List<TTDrawVfObject> list) {
                    if (list == null || list.isEmpty()) {
                        AdLog.getInstance().sendAdSuccess(LoaderMix4VfNativeDrawFeed.this.mAdKey, 0, loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true);
                        LG.d("AdLog-LoaderMix4VfNativeDrawFeed", "load ad success rit: " + LoaderMix4VfNativeDrawFeed.this.mAdKey.getCodeId() + ", ads is null or isEmpty ");
                        return;
                    }
                    AdLog.getInstance().sendAdSuccess(LoaderMix4VfNativeDrawFeed.this.mAdKey, list.size(), loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true);
                    LG.d("AdLog-LoaderMix4VfNativeDrawFeed", "load ad rit: " + LoaderMix4VfNativeDrawFeed.this.mAdKey.getCodeId() + ", size = " + list.size());
                    ArrayList arrayList = new ArrayList();
                    String adRequestId = "";
                    for (TTDrawVfObject tTDrawVfObject : list) {
                        if (tTDrawVfObject != null) {
                            tTDrawVfObject.setCanInterruptVideoPlay(true);
                            if (OppoVfUtils.isSupportTTSdkPlayer(tTDrawVfObject)) {
                                OppoVfUtils.preloadAd(tTDrawVfObject);
                            }
                        }
                        arrayList.add(new VfDrawFeedAd(tTDrawVfObject, System.currentTimeMillis()));
                        adRequestId = OppoVfUtils.getAdRequestId(tTDrawVfObject);
                    }
                    LoaderAbs.Callback callback2 = callback;
                    if (callback2 != null) {
                        callback2.onAdLoadSuccess(arrayList);
                    }
                    if (AdManager.inst().mAdListenerMap != null) {
                        HashMap map = new HashMap();
                        map.put(IDJXAd.AD_CODE_ID, LoaderMix4VfNativeDrawFeed.this.mAdKey.getCodeId());
                        map.put(PointParamKey.AD_COUNT, Integer.valueOf(list.size()));
                        map.put("request_id", adRequestId);
                        IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(LoaderMix4VfNativeDrawFeed.this.mAdKey.getParamsCode()));
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

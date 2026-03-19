package com.bytedance.sdk.djx.core.business.ad.oppo3110;

import com.bykv.vk.openvk.TTDrawVfObject;
import com.bykv.vk.openvk.TTVfNative;
import com.bykv.vk.openvk.VfSlot;
import com.bytedance.sdk.djx.core.business.ad.AdKey;
import com.bytedance.sdk.djx.core.business.ad.AdLog;
import com.bytedance.sdk.djx.core.business.ad.AdManager;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.bytedance.sdk.djx.interfaces.listener.IDJXAdListener;
import com.bytedance.sdk.djx.model.ev.BEAdCome;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class Loader4VfNativeDrawFeed extends VfLoaderAbs {
    private static final int MAX_LOAD_NUM = 3;
    private static final String TAG = "Loader4VfNativeDrawFeed";
    private boolean mHasParseReqId;
    private String mRequestId;

    public Loader4VfNativeDrawFeed(AdKey adKey) {
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
        return OppoVfUtils.createVfSlotBuilder().setCodeId(this.mAdKey.getCodeId()).setSupportDeepLink(true).setExpressViewAcceptedSize(width, height).setAdCount(3);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected void doLoad() {
        this.mTTAdNative.loadDrawVfList(buildAdSlot().build(), new TTVfNative.DrawVfListListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo3110.Loader4VfNativeDrawFeed.1
            public void onError(int i, String str) {
                Loader4VfNativeDrawFeed.this.mIsLoading = false;
                AdLog.getInstance().sendAdFailed(Loader4VfNativeDrawFeed.this.mAdKey, i, str, null, false);
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4VfNativeDrawFeed.this.mAdKey.getCodeId());
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4VfNativeDrawFeed.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestFail(i, str, map);
                    }
                }
                LG.d("AdLog-Loader4VfNativeDrawFeed", "load ad error rit: " + Loader4VfNativeDrawFeed.this.mAdKey.getCodeId() + ", code = " + i + ", msg = " + str);
            }

            public void onDrawFeedAdLoad(List<TTDrawVfObject> list) {
                if (list == null || list.isEmpty()) {
                    AdLog.getInstance().sendAdSuccess(Loader4VfNativeDrawFeed.this.mAdKey, 0, null, false);
                    LG.d("AdLog-Loader4VfNativeDrawFeed", "load ad success rit: " + Loader4VfNativeDrawFeed.this.mAdKey.getCodeId() + ", ads is null or isEmpty ");
                    return;
                }
                AdLog.getInstance().sendAdSuccess(Loader4VfNativeDrawFeed.this.mAdKey, list.size(), null, false);
                Loader4VfNativeDrawFeed.this.mIsLoading = false;
                Loader4VfNativeDrawFeed.this.mHasParseReqId = false;
                LG.d("AdLog-Loader4VfNativeDrawFeed", "load ad rit: " + Loader4VfNativeDrawFeed.this.mAdKey.getCodeId() + ", size = " + list.size());
                for (TTDrawVfObject tTDrawVfObject : list) {
                    if (tTDrawVfObject != null) {
                        tTDrawVfObject.setCanInterruptVideoPlay(true);
                        if (OppoVfUtils.isSupportTTSdkPlayer(tTDrawVfObject)) {
                            OppoVfUtils.preloadAd(tTDrawVfObject);
                        }
                    }
                    if (!Loader4VfNativeDrawFeed.this.mHasParseReqId) {
                        Loader4VfNativeDrawFeed.this.mRequestId = OppoVfUtils.getAdRequestId(tTDrawVfObject);
                        Loader4VfNativeDrawFeed.this.mHasParseReqId = true;
                    }
                    AdManager.inst().saveAd(Loader4VfNativeDrawFeed.this.mAdKey, new VfDrawFeedAd(tTDrawVfObject, System.currentTimeMillis()));
                }
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4VfNativeDrawFeed.this.mAdKey.getCodeId());
                    map.put(PointParamKey.AD_COUNT, Integer.valueOf(list.size()));
                    map.put("request_id", Loader4VfNativeDrawFeed.this.mRequestId);
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4VfNativeDrawFeed.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestSuccess(map);
                    }
                }
                BEAdCome.build().setCodeId(Loader4VfNativeDrawFeed.this.mAdKey.getCodeId()).send();
            }
        });
    }
}

package com.bytedance.sdk.djx.core.business.ad.oppo3110;

import com.bykv.vk.openvk.TTVfNative;
import com.bykv.vk.openvk.TTVfObject;
import com.bytedance.sdk.djx.core.business.ad.AdKey;
import com.bytedance.sdk.djx.core.business.ad.AdLog;
import com.bytedance.sdk.djx.core.business.ad.AdManager;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.bytedance.sdk.djx.interfaces.listener.IDJXAdListener;
import com.bytedance.sdk.djx.model.ev.BEAdCome;
import com.bytedance.sdk.djx.utils.LG;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class Loader4VfFeed extends VfLoaderAbs {
    private static final int MAX_LOAD_NUM = 3;
    private static final String TAG = "Loader4VfFeed";
    private boolean mHasParseReqId;
    private String mRequestId;

    public Loader4VfFeed(AdKey adKey) {
        super(adKey);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected void doLoad() {
        int width;
        int height;
        if (this.mAdKey.getWidth() == 0 && this.mAdKey.getHeight() == 0) {
            width = 375;
            height = 211;
        } else {
            width = this.mAdKey.getWidth();
            height = this.mAdKey.getHeight();
        }
        this.mTTAdNative.loadVfList(OppoVfUtils.createVfSlotBuilder().setCodeId(this.mAdKey.getCodeId()).setSupportDeepLink(true).setImageAcceptedSize(width, height).setAdCount(3).build(), new TTVfNative.VfListListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo3110.Loader4VfFeed.1
            public void onError(int i, String str) {
                Loader4VfFeed.this.mIsLoading = false;
                AdLog.getInstance().sendAdFailed(Loader4VfFeed.this.mAdKey, i, str, null, false);
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4VfFeed.this.mAdKey.getCodeId());
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4VfFeed.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestFail(i, str, map);
                    }
                }
                LG.d("AdLog-Loader4VfFeed", "vf load ad error rit: " + Loader4VfFeed.this.mAdKey.getCodeId() + ", code = " + i + ", msg = " + str);
            }

            public void onVfListLoad(List<TTVfObject> list) {
                if (list == null || list.isEmpty()) {
                    AdLog.getInstance().sendAdSuccess(Loader4VfFeed.this.mAdKey, 0, null, false);
                    LG.d("AdLog-Loader4VfFeed", "vf load ad success rit: " + Loader4VfFeed.this.mAdKey.getCodeId() + ", ads is null or isEmpty ");
                    return;
                }
                AdLog.getInstance().sendAdSuccess(Loader4VfFeed.this.mAdKey, list.size(), null, false);
                Loader4VfFeed.this.mIsLoading = false;
                Loader4VfFeed.this.mHasParseReqId = false;
                LG.d("AdLog-Loader4VfFeed", "vf load ad rit: " + Loader4VfFeed.this.mAdKey.getCodeId() + ", size = " + list.size());
                for (TTVfObject tTVfObject : list) {
                    if (!Loader4VfFeed.this.mHasParseReqId) {
                        Loader4VfFeed.this.mRequestId = OppoVfUtils.getAdRequestId(tTVfObject);
                        Loader4VfFeed.this.mHasParseReqId = true;
                    }
                    AdManager.inst().saveAd(Loader4VfFeed.this.mAdKey, new VfFeedAd(tTVfObject, System.currentTimeMillis()));
                }
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4VfFeed.this.mAdKey.getCodeId());
                    map.put(PointParamKey.AD_COUNT, Integer.valueOf(list.size()));
                    map.put("request_id", Loader4VfFeed.this.mRequestId);
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4VfFeed.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestSuccess(map);
                    }
                }
                BEAdCome.build().setCodeId(Loader4VfFeed.this.mAdKey.getCodeId()).send();
            }
        });
    }
}

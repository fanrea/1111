package com.bytedance.sdk.djx.core.business.ad.open;

import com.bytedance.sdk.djx.core.business.ad.AdKey;
import com.bytedance.sdk.djx.core.business.ad.AdLog;
import com.bytedance.sdk.djx.core.business.ad.AdManager;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.bytedance.sdk.djx.interfaces.listener.IDJXAdListener;
import com.bytedance.sdk.djx.model.ev.BEAdCome;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class Loader4Feed extends OpenLoaderAbs {
    private static final int MAX_LOAD_NUM = 3;
    private static final String TAG = "Loader4Feed";
    private boolean mHasParseReqId;
    private String mRequestId;

    public Loader4Feed(AdKey adKey) {
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
        this.mTTAdNative.loadFeedAd(OpenAdUtils.createAdSlotBuilder(this.mAdKey.getCategoryFeature(), this.mAdKey).setCodeId(this.mAdKey.getCodeId()).setSupportDeepLink(true).setImageAcceptedSize(width, height).setAdCount(3).build(), new TTAdNative.FeedAdListener() { // from class: com.bytedance.sdk.djx.core.business.ad.open.Loader4Feed.1
            public void onError(int i, String str) {
                Loader4Feed.this.mIsLoading = false;
                AdLog.getInstance().sendAdFailed(Loader4Feed.this.mAdKey, i, str, null, false);
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4Feed.this.mAdKey.getCodeId());
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4Feed.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestFail(i, str, map);
                    }
                }
                LG.d("AdLog-Loader4Feed", "load ad error rit: " + Loader4Feed.this.mAdKey.getCodeId() + ", code = " + i + ", msg = " + str);
            }

            public void onFeedAdLoad(List<TTFeedAd> list) {
                if (list == null || list.isEmpty()) {
                    AdLog.getInstance().sendAdSuccess(Loader4Feed.this.mAdKey, 0, null, false);
                    LG.d("AdLog-Loader4Feed", "load ad success rit: " + Loader4Feed.this.mAdKey.getCodeId() + ", ads is null or isEmpty ");
                    return;
                }
                AdLog.getInstance().sendAdSuccess(Loader4Feed.this.mAdKey, list.size(), null, false);
                Loader4Feed.this.mIsLoading = false;
                Loader4Feed.this.mHasParseReqId = false;
                LG.d("AdLog-Loader4Feed", "load ad rit: " + Loader4Feed.this.mAdKey.getCodeId() + ", size = " + list.size());
                for (TTFeedAd tTFeedAd : list) {
                    if (!Loader4Feed.this.mHasParseReqId) {
                        Loader4Feed.this.mRequestId = OpenAdUtils.getAdRequestId(tTFeedAd);
                        Loader4Feed.this.mHasParseReqId = true;
                    }
                    AdManager.inst().saveAd(Loader4Feed.this.mAdKey, new OpenFeedAd(tTFeedAd, System.currentTimeMillis()));
                }
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4Feed.this.mAdKey.getCodeId());
                    map.put(PointParamKey.AD_COUNT, Integer.valueOf(list.size()));
                    map.put("request_id", Loader4Feed.this.mRequestId);
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4Feed.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestSuccess(map);
                    }
                }
                BEAdCome.build().setCodeId(Loader4Feed.this.mAdKey.getCodeId()).send();
            }
        });
    }
}

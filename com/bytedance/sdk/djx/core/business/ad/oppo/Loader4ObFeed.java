package com.bytedance.sdk.djx.core.business.ad.oppo;

import com.bytedance.sdk.djx.core.business.ad.AdKey;
import com.bytedance.sdk.djx.core.business.ad.AdLog;
import com.bytedance.sdk.djx.core.business.ad.AdManager;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.bytedance.sdk.djx.interfaces.listener.IDJXAdListener;
import com.bytedance.sdk.djx.model.ev.BEAdCome;
import com.bytedance.sdk.djx.utils.LG;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.ttshell.sdk.api.TTFeedOb;
import com.ttshell.sdk.api.TTObNative;
import com.ttshell.sdk.api.model.TTObSlot;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class Loader4ObFeed extends ObLoaderAbs {
    private static final int MAX_LOAD_NUM = 3;
    private static final String TAG = "Loader4ObFeed";
    private boolean mHasParseReqId;
    private String mRequestId;

    public Loader4ObFeed(AdKey adKey) {
        super(adKey);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.oppo.ObLoaderAbs, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
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
        this.mTTAdNative.loadFeedOb(new TTObSlot.Builder().setCodeId(this.mAdKey.getCodeId()).setSupportDeepLink(true).setImageAcceptedSize(width, height).setObCount(3).build(), new TTObNative.FeedObListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo.Loader4ObFeed.1
            public void onError(int i, String str) {
                Loader4ObFeed.this.mIsLoading = false;
                AdLog.getInstance().sendAdFailed(Loader4ObFeed.this.mAdKey, i, str, null, false);
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4ObFeed.this.mAdKey.getCodeId());
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4ObFeed.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestFail(i, str, map);
                    }
                }
                LG.d("AdLog-Loader4ObFeed", "ob load ad error rit: " + Loader4ObFeed.this.mAdKey.getCodeId() + ", code = " + i + ", msg = " + str);
            }

            public void onFeedObLoad(List<TTFeedOb> list) {
                if (list == null || list.isEmpty()) {
                    AdLog.getInstance().sendAdSuccess(Loader4ObFeed.this.mAdKey, 0, null, false);
                    LG.d("AdLog-Loader4ObFeed", "ob load ad success rit: " + Loader4ObFeed.this.mAdKey.getCodeId() + ", ads is null or isEmpty ");
                    return;
                }
                AdLog.getInstance().sendAdSuccess(Loader4ObFeed.this.mAdKey, list.size(), null, false);
                Loader4ObFeed.this.mIsLoading = false;
                Loader4ObFeed.this.mHasParseReqId = false;
                LG.d("AdLog-Loader4ObFeed", "ob load ad rit: " + Loader4ObFeed.this.mAdKey.getCodeId() + ", size = " + list.size());
                for (TTFeedOb tTFeedOb : list) {
                    if (!Loader4ObFeed.this.mHasParseReqId) {
                        Loader4ObFeed.this.mRequestId = OppoObUtils.getAdRequestId(tTFeedOb);
                        Loader4ObFeed.this.mHasParseReqId = true;
                    }
                    AdManager.inst().saveAd(Loader4ObFeed.this.mAdKey, new ObFeedAd(tTFeedOb, System.currentTimeMillis()));
                }
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4ObFeed.this.mAdKey.getCodeId());
                    map.put(PointParamKey.AD_COUNT, Integer.valueOf(list.size()));
                    map.put("request_id", Loader4ObFeed.this.mRequestId);
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4ObFeed.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestSuccess(map);
                    }
                }
                BEAdCome.build().setCodeId(Loader4ObFeed.this.mAdKey.getCodeId()).send();
            }
        });
    }
}

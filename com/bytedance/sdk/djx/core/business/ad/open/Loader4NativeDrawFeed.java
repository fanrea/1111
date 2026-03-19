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
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class Loader4NativeDrawFeed extends OpenLoaderAbs {
    private static final int MAX_LOAD_NUM = 3;
    private static final String TAG = "Loader4NativeDrawFeed";
    private boolean mHasParseReqId;
    private String mRequestId;

    public Loader4NativeDrawFeed(AdKey adKey) {
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
            width = UIUtil.px2dp(UIUtil.getScreenWidth(InnerManager.getContext()));
            height = UIUtil.px2dp(UIUtil.getScreenHeight(InnerManager.getContext()));
        }
        return OpenAdUtils.createAdSlotBuilder(this.mAdKey.getCategoryFeature(), this.mAdKey).setCodeId(this.mAdKey.getCodeId()).setSupportDeepLink(true).setExpressViewAcceptedSize(width, height).setAdCount(3);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected void doLoad() {
        this.mTTAdNative.loadDrawFeedAd(buildAdSlot().build(), new TTAdNative.DrawFeedAdListener() { // from class: com.bytedance.sdk.djx.core.business.ad.open.Loader4NativeDrawFeed.1
            public void onError(int i, String str) {
                Loader4NativeDrawFeed.this.mIsLoading = false;
                AdLog.getInstance().sendAdFailed(Loader4NativeDrawFeed.this.mAdKey, i, str, null, false);
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4NativeDrawFeed.this.mAdKey.getCodeId());
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4NativeDrawFeed.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestFail(i, str, map);
                    }
                }
                LG.d("AdLog-Loader4NativeDrawFeed", "load ad error rit: " + Loader4NativeDrawFeed.this.mAdKey.getCodeId() + ", code = " + i + ", msg = " + str);
            }

            public void onDrawFeedAdLoad(List<TTDrawFeedAd> list) {
                if (list == null || list.isEmpty()) {
                    AdLog.getInstance().sendAdSuccess(Loader4NativeDrawFeed.this.mAdKey, 0, null, false);
                    LG.d("AdLog-Loader4NativeDrawFeed", "load ad success rit: " + Loader4NativeDrawFeed.this.mAdKey.getCodeId() + ", ads is null or isEmpty ");
                    return;
                }
                AdLog.getInstance().sendAdSuccess(Loader4NativeDrawFeed.this.mAdKey, list.size(), null, false);
                Loader4NativeDrawFeed.this.mIsLoading = false;
                Loader4NativeDrawFeed.this.mHasParseReqId = false;
                LG.d("AdLog-Loader4NativeDrawFeed", "load ad rit: " + Loader4NativeDrawFeed.this.mAdKey.getCodeId() + ", size = " + list.size());
                for (TTDrawFeedAd tTDrawFeedAd : list) {
                    if (tTDrawFeedAd != null) {
                        tTDrawFeedAd.setCanInterruptVideoPlay(true);
                        if (OpenAdUtils.isSupportTTSdkPlayer(tTDrawFeedAd)) {
                            OpenAdUtils.preloadAd(tTDrawFeedAd);
                        }
                    }
                    if (!Loader4NativeDrawFeed.this.mHasParseReqId) {
                        Loader4NativeDrawFeed.this.mRequestId = OpenAdUtils.getAdRequestId(tTDrawFeedAd);
                        Loader4NativeDrawFeed.this.mHasParseReqId = true;
                    }
                    AdManager.inst().saveAd(Loader4NativeDrawFeed.this.mAdKey, new OpenDrawFeedAd(tTDrawFeedAd, System.currentTimeMillis()));
                }
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4NativeDrawFeed.this.mAdKey.getCodeId());
                    map.put(PointParamKey.AD_COUNT, Integer.valueOf(list.size()));
                    map.put("request_id", Loader4NativeDrawFeed.this.mRequestId);
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4NativeDrawFeed.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestSuccess(map);
                    }
                }
                BEAdCome.build().setCodeId(Loader4NativeDrawFeed.this.mAdKey.getCodeId()).send();
            }
        });
    }
}

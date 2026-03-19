package com.bytedance.sdk.djx.core.business.ad.open;

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
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class Loader4ExpressReward extends OpenLoaderAbs {
    private static final String TAG = "Loader4ExpressReward";
    private boolean mHasParseReqId;
    private String mRequestId;

    @Override // com.bytedance.sdk.djx.core.business.ad.open.OpenLoaderAbs, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    public /* bridge */ /* synthetic */ void load() {
        super.load();
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.open.OpenLoaderAbs, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    public /* bridge */ /* synthetic */ void load(LoaderModel loaderModel, LoaderAbs.Callback callback) {
        super.load(loaderModel, callback);
    }

    public Loader4ExpressReward(AdKey adKey) {
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
        return OpenAdUtils.createAdSlotBuilder(this.mAdKey.getCategoryFeature(), this.mAdKey).setCodeId(this.mAdKey.getCodeId()).setSupportDeepLink(true).setExpressViewAcceptedSize(width, height);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected void doLoad() {
        this.mTTAdNative.loadRewardVideoAd(buildAdSlot().build(), new TTAdNative.RewardVideoAdListener() { // from class: com.bytedance.sdk.djx.core.business.ad.open.Loader4ExpressReward.1
            public void onRewardVideoCached() {
            }

            public void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
            }

            public void onError(int i, String str) {
                Loader4ExpressReward.this.mIsLoading = false;
                AdLog.getInstance().sendAdFailed(Loader4ExpressReward.this.mAdKey, i, str, null, false);
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4ExpressReward.this.mAdKey.getCodeId());
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4ExpressReward.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestFail(i, str, map);
                    }
                }
                BEAdCome.build().setCodeId(Loader4ExpressReward.this.mAdKey.getCodeId()).setReward().setLoadSuccess(false).send();
                LG.d("AdLog-Loader4ExpressReward", "load ad error rit: " + Loader4ExpressReward.this.mAdKey.getCodeId() + ", code = " + i + ", msg = " + str);
            }

            public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
                Loader4ExpressReward.this.mIsLoading = false;
                Loader4ExpressReward.this.mHasParseReqId = false;
                if (tTRewardVideoAd == null) {
                    AdLog.getInstance().sendAdSuccess(Loader4ExpressReward.this.mAdKey, 0, null, false);
                    return;
                }
                AdLog.getInstance().sendAdSuccess(Loader4ExpressReward.this.mAdKey, 1, null, false);
                LG.d("AdLog-Loader4ExpressReward", "load ad rit: " + Loader4ExpressReward.this.mAdKey.getCodeId() + ", size = 1");
                if (!Loader4ExpressReward.this.mHasParseReqId) {
                    Loader4ExpressReward.this.mRequestId = OpenAdUtils.getAdRequestId(tTRewardVideoAd);
                    Loader4ExpressReward.this.mHasParseReqId = true;
                }
                AdManager.inst().saveAd(Loader4ExpressReward.this.mAdKey, new OpenRewardAd(tTRewardVideoAd, Loader4ExpressReward.this.mAdKey, System.currentTimeMillis()));
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4ExpressReward.this.mAdKey.getCodeId());
                    map.put(PointParamKey.AD_COUNT, 1);
                    map.put("request_id", Loader4ExpressReward.this.mRequestId);
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4ExpressReward.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestSuccess(map);
                    }
                }
                BEAdCome.build().setCodeId(Loader4ExpressReward.this.mAdKey.getCodeId()).setReward().setLoadSuccess(true).send();
            }
        });
    }
}

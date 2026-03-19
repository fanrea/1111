package com.bytedance.sdk.djx.core.business.ad.oppo;

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
import com.ttshell.sdk.api.TTObNative;
import com.ttshell.sdk.api.TTRewardVideoOb;
import com.ttshell.sdk.api.model.TTObSlot;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class Loader4ObExpressReward extends ObLoaderAbs {
    private static final String TAG = "Loader4ObExpressReward";
    private boolean mHasParseReqId;
    private String mRequestId;

    @Override // com.bytedance.sdk.djx.core.business.ad.oppo.ObLoaderAbs, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    public /* bridge */ /* synthetic */ void load() {
        super.load();
    }

    public Loader4ObExpressReward(AdKey adKey) {
        super(adKey);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.oppo.ObLoaderAbs
    protected TTObSlot.Builder buildAdSlot() {
        int width;
        int height;
        if (this.mAdKey.getWidth() != 0 || this.mAdKey.getHeight() != 0) {
            width = this.mAdKey.getWidth();
            height = this.mAdKey.getHeight();
        } else {
            width = UIUtil.px2dp(UIUtil.getScreenWidth(InnerManager.getContext()));
            height = UIUtil.px2dp(UIUtil.getScreenHeight(InnerManager.getContext()));
        }
        return new TTObSlot.Builder().setCodeId(this.mAdKey.getCodeId()).setSupportDeepLink(true).setExpressViewAcceptedSize(width, height);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.oppo.ObLoaderAbs, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected void doLoad() {
        this.mTTAdNative.loadRewardVideoOb(buildAdSlot().build(), new TTObNative.RewardVideoObListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo.Loader4ObExpressReward.1
            public void onRewardVideoCached() {
            }

            public void onError(int i, String str) {
                Loader4ObExpressReward.this.mIsLoading = false;
                AdLog.getInstance().sendAdFailed(Loader4ObExpressReward.this.mAdKey, i, str, null, false);
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4ObExpressReward.this.mAdKey.getCodeId());
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4ObExpressReward.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestFail(i, str, map);
                    }
                }
                LG.d("AdLog-Loader4ObExpressReward", "load ad error rit: " + Loader4ObExpressReward.this.mAdKey.getCodeId() + ", code = " + i + ", msg = " + str);
            }

            public void onRewardVideoObLoad(TTRewardVideoOb tTRewardVideoOb) {
                Loader4ObExpressReward.this.mIsLoading = false;
                Loader4ObExpressReward.this.mHasParseReqId = false;
                if (tTRewardVideoOb == null) {
                    AdLog.getInstance().sendAdSuccess(Loader4ObExpressReward.this.mAdKey, 0, null, false);
                    return;
                }
                AdLog.getInstance().sendAdSuccess(Loader4ObExpressReward.this.mAdKey, 1, null, false);
                LG.d("AdLog-Loader4ObExpressReward", "load ad rit: " + Loader4ObExpressReward.this.mAdKey.getCodeId() + ", size = 1");
                if (!Loader4ObExpressReward.this.mHasParseReqId) {
                    Loader4ObExpressReward.this.mRequestId = OppoObUtils.getAdRequestId(tTRewardVideoOb);
                    Loader4ObExpressReward.this.mHasParseReqId = true;
                }
                AdManager.inst().saveAd(Loader4ObExpressReward.this.mAdKey, new ObRewardAd(tTRewardVideoOb, Loader4ObExpressReward.this.mAdKey));
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4ObExpressReward.this.mAdKey.getCodeId());
                    map.put(PointParamKey.AD_COUNT, 1);
                    map.put("request_id", Loader4ObExpressReward.this.mRequestId);
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4ObExpressReward.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestSuccess(map);
                    }
                }
                BEAdCome.build().setCodeId(Loader4ObExpressReward.this.mAdKey.getCodeId()).setReward().send();
            }
        });
    }
}

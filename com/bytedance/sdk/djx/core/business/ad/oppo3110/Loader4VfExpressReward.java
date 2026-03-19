package com.bytedance.sdk.djx.core.business.ad.oppo3110;

import com.bykv.vk.openvk.TTRdVideoObject;
import com.bykv.vk.openvk.TTVfNative;
import com.bykv.vk.openvk.VfSlot;
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
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class Loader4VfExpressReward extends VfLoaderAbs {
    private static final String TAG = "Loader4VfExpressReward";
    private boolean mHasParseReqId;
    private String mRequestId;

    @Override // com.bytedance.sdk.djx.core.business.ad.oppo3110.VfLoaderAbs, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    public /* bridge */ /* synthetic */ void load() {
        super.load();
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.oppo3110.VfLoaderAbs, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    public /* bridge */ /* synthetic */ void load(LoaderModel loaderModel, LoaderAbs.Callback callback) {
        super.load(loaderModel, callback);
    }

    public Loader4VfExpressReward(AdKey adKey) {
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
        return OppoVfUtils.createVfSlotBuilder().setCodeId(this.mAdKey.getCodeId()).setSupportDeepLink(true).setExpressViewAcceptedSize(width, height);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected void doLoad() {
        this.mTTAdNative.loadRdVideoVr(buildAdSlot().build(), new TTVfNative.RdVideoVfListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo3110.Loader4VfExpressReward.1
            public void onRdVideoCached() {
            }

            public void onRdVideoCached(TTRdVideoObject tTRdVideoObject) {
            }

            public void onError(int i, String str) {
                Loader4VfExpressReward.this.mIsLoading = false;
                AdLog.getInstance().sendAdFailed(Loader4VfExpressReward.this.mAdKey, i, str, null, false);
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4VfExpressReward.this.mAdKey.getCodeId());
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4VfExpressReward.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestFail(i, str, map);
                    }
                }
                LG.d("AdLog-Loader4VfExpressReward", "load ad error rit: " + Loader4VfExpressReward.this.mAdKey.getCodeId() + ", code = " + i + ", msg = " + str);
            }

            public void onRdVideoVrLoad(TTRdVideoObject tTRdVideoObject) {
                Loader4VfExpressReward.this.mIsLoading = false;
                Loader4VfExpressReward.this.mHasParseReqId = false;
                if (tTRdVideoObject == null) {
                    AdLog.getInstance().sendAdSuccess(Loader4VfExpressReward.this.mAdKey, 0, null, false);
                    return;
                }
                AdLog.getInstance().sendAdSuccess(Loader4VfExpressReward.this.mAdKey, 1, null, false);
                LG.d("AdLog-Loader4VfExpressReward", "load ad rit: " + Loader4VfExpressReward.this.mAdKey.getCodeId() + ", size = 1");
                if (!Loader4VfExpressReward.this.mHasParseReqId) {
                    Loader4VfExpressReward.this.mRequestId = OppoVfUtils.getAdRequestId(tTRdVideoObject);
                    Loader4VfExpressReward.this.mHasParseReqId = true;
                }
                AdManager.inst().saveAd(Loader4VfExpressReward.this.mAdKey, new VfRewardAd(tTRdVideoObject, Loader4VfExpressReward.this.mAdKey, System.currentTimeMillis()));
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4VfExpressReward.this.mAdKey.getCodeId());
                    map.put(PointParamKey.AD_COUNT, 1);
                    map.put("request_id", Loader4VfExpressReward.this.mRequestId);
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4VfExpressReward.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestSuccess(map);
                    }
                }
                BEAdCome.build().setCodeId(Loader4VfExpressReward.this.mAdKey.getCodeId()).setReward().send();
            }
        });
    }
}

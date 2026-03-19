package com.bytedance.sdk.djx.core.business.ad.oppo3110;

import android.view.View;
import com.bykv.vk.openvk.TTNtExpressObject;
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
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class Loader4VfExpressDrawFeed extends VfLoaderAbs {
    private static final int MAX_LOAD_NUM = 3;
    private static final String TAG = "Loader4VfExpressDrawFeed";
    private boolean mHasParseReqId;
    private String mRequestId;

    public Loader4VfExpressDrawFeed(AdKey adKey) {
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
        this.mTTAdNative.loadExpressDrawVf(buildAdSlot().build(), new TTVfNative.NtExpressVfListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo3110.Loader4VfExpressDrawFeed.1
            public void onError(int i, String str) {
                Loader4VfExpressDrawFeed.this.mIsLoading = false;
                AdLog.getInstance().sendAdFailed(Loader4VfExpressDrawFeed.this.mAdKey, i, str, null, false);
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4VfExpressDrawFeed.this.mAdKey.getCodeId());
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4VfExpressDrawFeed.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestFail(i, str, map);
                    }
                }
                LG.d("AdLog-Loader4VfExpressDrawFeed", "vf load ad error rit: " + Loader4VfExpressDrawFeed.this.mAdKey.getCodeId() + ", code = " + i + ", msg = " + str);
            }

            public void onNtExpressVnLoad(List<TTNtExpressObject> list) {
                Loader4VfExpressDrawFeed.this.mIsLoading = false;
                Loader4VfExpressDrawFeed.this.mHasParseReqId = false;
                if (list == null) {
                    AdLog.getInstance().sendAdSuccess(Loader4VfExpressDrawFeed.this.mAdKey, 0, null, false);
                    return;
                }
                AdLog.getInstance().sendAdSuccess(Loader4VfExpressDrawFeed.this.mAdKey, list.size(), null, false);
                LG.d("AdLog-Loader4VfExpressDrawFeed", "vf load ad rit: " + Loader4VfExpressDrawFeed.this.mAdKey.getCodeId() + ", size = " + list.size());
                for (final TTNtExpressObject tTNtExpressObject : list) {
                    if (!Loader4VfExpressDrawFeed.this.mHasParseReqId) {
                        Loader4VfExpressDrawFeed.this.mRequestId = OppoVfUtils.getAdRequestId(tTNtExpressObject);
                        Loader4VfExpressDrawFeed.this.mHasParseReqId = true;
                    }
                    final Map<String, Object> mediaExtraInfo = OppoVfUtils.getMediaExtraInfo(tTNtExpressObject);
                    final VfExpressAd vfExpressAd = new VfExpressAd(tTNtExpressObject, System.currentTimeMillis());
                    AdManager.inst().saveAd(Loader4VfExpressDrawFeed.this.mAdKey, vfExpressAd);
                    tTNtExpressObject.setExpressInteractionListener(new TTNtExpressObject.ExpressNtInteractionListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo3110.Loader4VfExpressDrawFeed.1.1
                        public void onClicked(View view, int i) {
                            AdLog.getInstance().sendAdClick(Loader4VfExpressDrawFeed.this.mAdKey, null, false, -1, null);
                            LG.d("AdLog-Loader4VfExpressDrawFeed", "vf draw ad clicked");
                            if (vfExpressAd.getInnerAdExpressListener() != null) {
                                vfExpressAd.getInnerAdExpressListener().onAdClicked(view, vfExpressAd);
                            }
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, Loader4VfExpressDrawFeed.this.mAdKey.getCodeId());
                                map.put("request_id", OppoVfUtils.getAdRequestId(tTNtExpressObject));
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4VfExpressDrawFeed.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdClicked(map);
                                }
                            }
                        }

                        public void onShow(View view, int i) {
                            AdLog.getInstance().sendAdShow(Loader4VfExpressDrawFeed.this.mAdKey, null, false, -1);
                            LG.d("AdLog-Loader4VfExpressDrawFeed", "vf draw ad show");
                            if (vfExpressAd.getInnerAdExpressListener() != null) {
                                vfExpressAd.getInnerAdExpressListener().onAdShow(vfExpressAd);
                            }
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, Loader4VfExpressDrawFeed.this.mAdKey.getCodeId());
                                map.put("request_id", OppoVfUtils.getAdRequestId(tTNtExpressObject));
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4VfExpressDrawFeed.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdShow(map);
                                }
                            }
                        }

                        public void onRenderFail(View view, String str, int i) {
                            LG.d("AdLog-Loader4VfExpressDrawFeed", "vf draw ad render fail code = " + i + ", msg = " + str);
                            if (vfExpressAd.getInnerAdExpressListener() != null) {
                                vfExpressAd.getInnerAdExpressListener().onRenderFail(vfExpressAd, str, i);
                            }
                        }

                        public void onRenderSuccess(View view, float f, float f2) {
                            LG.d("AdLog-Loader4VfExpressDrawFeed", "vf draw ad render success");
                            if (vfExpressAd.getInnerAdExpressListener() != null) {
                                vfExpressAd.getInnerAdExpressListener().onRenderSuccess(vfExpressAd, f, f2);
                            }
                        }
                    });
                    tTNtExpressObject.render();
                }
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4VfExpressDrawFeed.this.mAdKey.getCodeId());
                    map.put(PointParamKey.AD_COUNT, Integer.valueOf(list.size()));
                    map.put("request_id", Loader4VfExpressDrawFeed.this.mRequestId);
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4VfExpressDrawFeed.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestSuccess(map);
                    }
                }
                BEAdCome.build().setCodeId(Loader4VfExpressDrawFeed.this.mAdKey.getCodeId()).send();
            }
        });
    }
}

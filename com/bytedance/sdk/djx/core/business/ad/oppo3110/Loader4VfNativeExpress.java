package com.bytedance.sdk.djx.core.business.ad.oppo3110;

import android.view.View;
import com.bykv.vk.openvk.TTNtExpressObject;
import com.bykv.vk.openvk.TTVfNative;
import com.bykv.vk.openvk.VfSlot;
import com.bytedance.sdk.djx.core.business.ad.AdKey;
import com.bytedance.sdk.djx.core.business.ad.AdLog;
import com.bytedance.sdk.djx.core.business.ad.AdManager;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.bytedance.sdk.djx.core.util.AdVideoCallbackUtil;
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
class Loader4VfNativeExpress extends VfLoaderAbs {
    private static final int MAX_LOAD_NUM = 3;
    private static final String TAG = "Loader4VfNativeExpress";
    private long mCurrentDuration;
    private boolean mHasParseReqId;
    private String mRequestId;
    private long mTotalDuration;

    public Loader4VfNativeExpress(AdKey adKey) {
        super(adKey);
        this.mCurrentDuration = 0L;
        this.mTotalDuration = 0L;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected void doLoad() {
        for (int i = 0; i < this.mAdKey.getLoadCount(); i++) {
            loadAd();
        }
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
            height = 0;
        }
        return OppoVfUtils.createVfSlotBuilder().setCodeId(this.mAdKey.getCodeId()).setSupportDeepLink(true).setAdCount(3).setExpressViewAcceptedSize(width, height).setImageAcceptedSize(640, 320);
    }

    private void loadAd() {
        this.mTTAdNative.loadNtExpressVn(buildAdSlot().build(), new TTVfNative.NtExpressVfListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo3110.Loader4VfNativeExpress.1
            public void onError(int i, String str) {
                Loader4VfNativeExpress.this.mIsLoading = false;
                AdLog.getInstance().sendAdFailed(Loader4VfNativeExpress.this.mAdKey, i, str, null, false);
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4VfNativeExpress.this.mAdKey.getCodeId());
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4VfNativeExpress.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestFail(i, str, map);
                    }
                }
                LG.d("AdLog-Loader4VfNativeExpress", "vf load ad error rit: " + Loader4VfNativeExpress.this.mAdKey.getCodeId() + ", code = " + i + ", msg = " + str);
            }

            public void onNtExpressVnLoad(List<TTNtExpressObject> list) {
                Loader4VfNativeExpress.this.mIsLoading = false;
                Loader4VfNativeExpress.this.mHasParseReqId = false;
                if (list == null) {
                    AdLog.getInstance().sendAdSuccess(Loader4VfNativeExpress.this.mAdKey, 0, null, false);
                    return;
                }
                AdLog.getInstance().sendAdSuccess(Loader4VfNativeExpress.this.mAdKey, list.size(), null, false);
                LG.d("AdLog-Loader4VfNativeExpress", "vf load ad rit: " + Loader4VfNativeExpress.this.mAdKey.getCodeId() + ", size = " + list.size());
                for (final TTNtExpressObject tTNtExpressObject : list) {
                    if (!Loader4VfNativeExpress.this.mHasParseReqId) {
                        Loader4VfNativeExpress.this.mRequestId = OppoVfUtils.getAdRequestId(tTNtExpressObject);
                        Loader4VfNativeExpress.this.mHasParseReqId = true;
                    }
                    final Map<String, Object> mediaExtraInfo = OppoVfUtils.getMediaExtraInfo(tTNtExpressObject);
                    final VfExpressAd vfExpressAd = new VfExpressAd(tTNtExpressObject, System.currentTimeMillis());
                    AdManager.inst().saveAd(Loader4VfNativeExpress.this.mAdKey, vfExpressAd);
                    tTNtExpressObject.setExpressInteractionListener(new TTNtExpressObject.ExpressNtInteractionListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo3110.Loader4VfNativeExpress.1.1
                        public void onClicked(View view, int i) {
                            AdLog.getInstance().sendAdClick(Loader4VfNativeExpress.this.mAdKey, null, false, -1, null);
                            LG.d("AdLog-Loader4VfNativeExpress", "vf native express ad clicked");
                            if (vfExpressAd.getInnerAdExpressListener() != null) {
                                vfExpressAd.getInnerAdExpressListener().onAdClicked(view, vfExpressAd);
                            }
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, Loader4VfNativeExpress.this.mAdKey.getCodeId());
                                map.put("request_id", OppoVfUtils.getAdRequestId(tTNtExpressObject));
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4VfNativeExpress.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdClicked(map);
                                }
                            }
                        }

                        public void onShow(View view, int i) {
                            AdLog.getInstance().sendAdShow(Loader4VfNativeExpress.this.mAdKey, null, false, -1);
                            LG.d("AdLog-Loader4VfNativeExpress", "vf native express ad show");
                            if (vfExpressAd.getInnerAdExpressListener() != null) {
                                vfExpressAd.getInnerAdExpressListener().onAdShow(vfExpressAd);
                            }
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, Loader4VfNativeExpress.this.mAdKey.getCodeId());
                                map.put("request_id", OppoVfUtils.getAdRequestId(tTNtExpressObject));
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4VfNativeExpress.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdShow(map);
                                }
                            }
                        }

                        public void onRenderFail(View view, String str, int i) {
                            LG.d("AdLog-Loader4VfNativeExpress", "vf native express ad render fail code = " + i + ", msg = " + str);
                            if (vfExpressAd.getInnerAdExpressListener() != null) {
                                vfExpressAd.getInnerAdExpressListener().onRenderFail(vfExpressAd, str, i);
                            }
                        }

                        public void onRenderSuccess(View view, float f, float f2) {
                            LG.d("AdLog-Loader4VfNativeExpress", "vf native express ad render success");
                            if (vfExpressAd.getInnerAdExpressListener() != null) {
                                vfExpressAd.getInnerAdExpressListener().onRenderSuccess(vfExpressAd, f, f2);
                            }
                        }
                    });
                    tTNtExpressObject.render();
                    tTNtExpressObject.setVideoListener(new TTNtExpressObject.ExpressVideoListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo3110.Loader4VfNativeExpress.1.2
                        public void onClickRetry() {
                        }

                        public void onVideoLoad() {
                        }

                        public void onVideoError(int i, int i2) {
                            AdLog.getInstance().sendAdPlayFail(Loader4VfNativeExpress.this.mAdKey, null, false, -1);
                        }

                        public void onVideoStartPlay() {
                            AdLog.getInstance().sendAdPlay(Loader4VfNativeExpress.this.mAdKey, null, false, -1);
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, Loader4VfNativeExpress.this.mAdKey.getCodeId());
                                map.put("request_id", OppoVfUtils.getAdRequestId(tTNtExpressObject));
                                AdVideoCallbackUtil.addTotalDuration(Loader4VfNativeExpress.this.mTotalDuration, map);
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4VfNativeExpress.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdPlayStart(map);
                                }
                            }
                        }

                        public void onVideoPaused() {
                            AdLog.getInstance().sendAdPause(Loader4VfNativeExpress.this.mAdKey, null, false, -1);
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, Loader4VfNativeExpress.this.mAdKey.getCodeId());
                                map.put("request_id", OppoVfUtils.getAdRequestId(tTNtExpressObject));
                                AdVideoCallbackUtil.addTotalDuration(Loader4VfNativeExpress.this.mTotalDuration, map);
                                AdVideoCallbackUtil.addCurrentDuration(Loader4VfNativeExpress.this.mCurrentDuration, map);
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4VfNativeExpress.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdPlayPause(map);
                                }
                            }
                        }

                        public void onVideoContinuePlay() {
                            AdLog.getInstance().sendAdContinue(Loader4VfNativeExpress.this.mAdKey, null, false, -1);
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, Loader4VfNativeExpress.this.mAdKey.getCodeId());
                                map.put("request_id", OppoVfUtils.getAdRequestId(tTNtExpressObject));
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4VfNativeExpress.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdPlayContinue(map);
                                }
                            }
                        }

                        public void onProgressUpdate(long j, long j2) {
                            Loader4VfNativeExpress.this.mCurrentDuration = j;
                            Loader4VfNativeExpress.this.mTotalDuration = j2;
                        }

                        public void onVideoComplete() {
                            AdLog.getInstance().sendAdComplete(Loader4VfNativeExpress.this.mAdKey, null, false, -1);
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, Loader4VfNativeExpress.this.mAdKey.getCodeId());
                                map.put("request_id", OppoVfUtils.getAdRequestId(tTNtExpressObject));
                                AdVideoCallbackUtil.addTotalDuration(Loader4VfNativeExpress.this.mTotalDuration, map);
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4VfNativeExpress.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdPlayComplete(map);
                                }
                            }
                        }
                    });
                }
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4VfNativeExpress.this.mAdKey.getCodeId());
                    map.put(PointParamKey.AD_COUNT, Integer.valueOf(list.size()));
                    map.put("request_id", Loader4VfNativeExpress.this.mRequestId);
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4VfNativeExpress.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestSuccess(map);
                    }
                }
                BEAdCome.build().setCodeId(Loader4VfNativeExpress.this.mAdKey.getCodeId()).send();
            }
        });
    }
}

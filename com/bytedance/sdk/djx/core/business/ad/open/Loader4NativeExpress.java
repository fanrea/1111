package com.bytedance.sdk.djx.core.business.ad.open;

import android.view.View;
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
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class Loader4NativeExpress extends OpenLoaderAbs {
    private static final int MAX_LOAD_NUM = 3;
    private static final String TAG = "Loader4NativeExpress";
    private long mCurrentPlayPosition;
    private boolean mHasParseReqId;
    private String mRequestId;
    private long mTotalDuration;

    public Loader4NativeExpress(AdKey adKey) {
        super(adKey);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected void doLoad() {
        for (int i = 0; i < this.mAdKey.getLoadCount(); i++) {
            loadAd();
        }
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
            height = 0;
        }
        return OpenAdUtils.createAdSlotBuilder(this.mAdKey.getCategoryFeature(), this.mAdKey).setCodeId(this.mAdKey.getCodeId()).setSupportDeepLink(true).setAdCount(3).setExpressViewAcceptedSize(width, height).setImageAcceptedSize(640, 320);
    }

    private void loadAd() {
        this.mTTAdNative.loadNativeExpressAd(buildAdSlot().build(), new TTAdNative.NativeExpressAdListener() { // from class: com.bytedance.sdk.djx.core.business.ad.open.Loader4NativeExpress.1
            public void onError(int i, String str) {
                Loader4NativeExpress.this.mIsLoading = false;
                AdLog.getInstance().sendAdFailed(Loader4NativeExpress.this.mAdKey, i, str, null, false);
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4NativeExpress.this.mAdKey.getCodeId());
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4NativeExpress.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestFail(i, str, map);
                    }
                }
                LG.d("AdLog-Loader4NativeExpress", "load ad error rit: " + Loader4NativeExpress.this.mAdKey.getCodeId() + ", code = " + i + ", msg = " + str);
                BEAdCome.build().setCodeId(Loader4NativeExpress.this.mAdKey.getCodeId()).setLoadSuccess(false).send();
            }

            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                Loader4NativeExpress.this.mIsLoading = false;
                Loader4NativeExpress.this.mHasParseReqId = false;
                if (list == null) {
                    AdLog.getInstance().sendAdSuccess(Loader4NativeExpress.this.mAdKey, 0, null, false);
                    return;
                }
                AdLog.getInstance().sendAdSuccess(Loader4NativeExpress.this.mAdKey, list.size(), null, false);
                LG.d("AdLog-Loader4NativeExpress", "load ad rit: " + Loader4NativeExpress.this.mAdKey.getCodeId() + ", size = " + list.size());
                for (final TTNativeExpressAd tTNativeExpressAd : list) {
                    if (!Loader4NativeExpress.this.mHasParseReqId) {
                        Loader4NativeExpress.this.mRequestId = OpenAdUtils.getAdRequestId(tTNativeExpressAd);
                        Loader4NativeExpress.this.mHasParseReqId = true;
                    }
                    final Map<String, Object> mediaExtraInfo = OpenAdUtils.getMediaExtraInfo(tTNativeExpressAd);
                    final OpenExpressAd openExpressAd = new OpenExpressAd(tTNativeExpressAd, System.currentTimeMillis());
                    AdManager.inst().saveAd(Loader4NativeExpress.this.mAdKey, openExpressAd);
                    tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.sdk.djx.core.business.ad.open.Loader4NativeExpress.1.1
                        public void onAdClicked(View view, int i) {
                            AdLog.getInstance().sendAdClick(Loader4NativeExpress.this.mAdKey, null, false, -1, null);
                            LG.d("AdLog-Loader4NativeExpress", "native express ad clicked");
                            if (openExpressAd.getInnerAdExpressListener() != null) {
                                openExpressAd.getInnerAdExpressListener().onAdClicked(view, openExpressAd);
                            }
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, Loader4NativeExpress.this.mAdKey.getCodeId());
                                map.put("request_id", OpenAdUtils.getAdRequestId(tTNativeExpressAd));
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4NativeExpress.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdClicked(map);
                                }
                            }
                        }

                        public void onAdShow(View view, int i) {
                            AdLog.getInstance().sendAdShow(Loader4NativeExpress.this.mAdKey, null, false, -1);
                            LG.d("AdLog-Loader4NativeExpress", "native express ad show");
                            if (openExpressAd.getInnerAdExpressListener() != null) {
                                openExpressAd.getInnerAdExpressListener().onAdShow(openExpressAd);
                            }
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, Loader4NativeExpress.this.mAdKey.getCodeId());
                                map.put("request_id", OpenAdUtils.getAdRequestId(tTNativeExpressAd));
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4NativeExpress.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdShow(map);
                                }
                            }
                        }

                        public void onRenderFail(View view, String str, int i) {
                            LG.d("AdLog-Loader4NativeExpress", "native express ad render fail code = " + i + ", msg = " + str);
                            if (openExpressAd.getInnerAdExpressListener() != null) {
                                openExpressAd.getInnerAdExpressListener().onRenderFail(openExpressAd, str, i);
                            }
                        }

                        public void onRenderSuccess(View view, float f, float f2) {
                            LG.d("AdLog-Loader4NativeExpress", "native express ad render success " + Loader4NativeExpress.this.mAdKey.getCodeId());
                            if (openExpressAd.getInnerAdExpressListener() != null) {
                                openExpressAd.getInnerAdExpressListener().onRenderSuccess(openExpressAd, f, f2);
                            }
                        }
                    });
                    tTNativeExpressAd.render();
                    tTNativeExpressAd.setVideoAdListener(new TTNativeExpressAd.ExpressVideoAdListener() { // from class: com.bytedance.sdk.djx.core.business.ad.open.Loader4NativeExpress.1.2
                        public void onClickRetry() {
                        }

                        public void onVideoLoad() {
                        }

                        public void onVideoError(int i, int i2) {
                            AdLog.getInstance().sendAdPlayFail(Loader4NativeExpress.this.mAdKey, null, false, -1);
                        }

                        public void onVideoAdStartPlay() {
                            AdLog.getInstance().sendAdPlay(Loader4NativeExpress.this.mAdKey, null, false, -1);
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, Loader4NativeExpress.this.mAdKey.getCodeId());
                                map.put("request_id", OpenAdUtils.getAdRequestId(tTNativeExpressAd));
                                AdVideoCallbackUtil.addTotalDuration(0L, map);
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4NativeExpress.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdPlayStart(map);
                                }
                            }
                        }

                        public void onVideoAdPaused() {
                            AdLog.getInstance().sendAdPause(Loader4NativeExpress.this.mAdKey, null, false, -1);
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, Loader4NativeExpress.this.mAdKey.getCodeId());
                                map.put("request_id", OpenAdUtils.getAdRequestId(tTNativeExpressAd));
                                AdVideoCallbackUtil.addTotalDuration(Loader4NativeExpress.this.mTotalDuration, map);
                                AdVideoCallbackUtil.addCurrentDuration(Loader4NativeExpress.this.mCurrentPlayPosition, map);
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4NativeExpress.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdPlayPause(map);
                                }
                            }
                        }

                        public void onVideoAdContinuePlay() {
                            AdLog.getInstance().sendAdContinue(Loader4NativeExpress.this.mAdKey, null, false, -1);
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, Loader4NativeExpress.this.mAdKey.getCodeId());
                                map.put("request_id", OpenAdUtils.getAdRequestId(tTNativeExpressAd));
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4NativeExpress.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdPlayContinue(map);
                                }
                            }
                        }

                        public void onProgressUpdate(long j, long j2) {
                            Loader4NativeExpress.this.mCurrentPlayPosition = j;
                            Loader4NativeExpress.this.mTotalDuration = j2;
                        }

                        public void onVideoAdComplete() {
                            AdLog.getInstance().sendAdComplete(Loader4NativeExpress.this.mAdKey, null, false, -1);
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, Loader4NativeExpress.this.mAdKey.getCodeId());
                                map.put("request_id", OpenAdUtils.getAdRequestId(tTNativeExpressAd));
                                AdVideoCallbackUtil.addTotalDuration(Loader4NativeExpress.this.mTotalDuration, map);
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4NativeExpress.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdPlayComplete(map);
                                }
                            }
                        }
                    });
                }
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4NativeExpress.this.mAdKey.getCodeId());
                    map.put(PointParamKey.AD_COUNT, Integer.valueOf(list.size()));
                    map.put("request_id", Loader4NativeExpress.this.mRequestId);
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4NativeExpress.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestSuccess(map);
                    }
                }
                BEAdCome.build().setCodeId(Loader4NativeExpress.this.mAdKey.getCodeId()).setLoadSuccess(true).send();
            }
        });
    }
}

package com.bytedance.sdk.djx.core.business.ad.oppo;

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
import com.sigmob.sdk.base.mta.PointParamKey;
import com.ttshell.sdk.api.TTNativeExpressOb;
import com.ttshell.sdk.api.TTObNative;
import com.ttshell.sdk.api.model.TTObSlot;
import com.ttshell.sdk.api.model.VideoControllerDataModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class Loader4ObNativeExpress extends ObLoaderAbs {
    private static final int MAX_LOAD_NUM = 3;
    private static final String TAG = "Loader4ObNativeExpress";
    private boolean mHasParseReqId;
    private String mRequestId;

    public Loader4ObNativeExpress(AdKey adKey) {
        super(adKey);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.oppo.ObLoaderAbs, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected void doLoad() {
        for (int i = 0; i < this.mAdKey.getLoadCount(); i++) {
            loadAd();
        }
    }

    private void loadAd() {
        int width;
        int height;
        if (this.mAdKey.getWidth() != 0 || this.mAdKey.getHeight() != 0) {
            width = this.mAdKey.getWidth();
            height = this.mAdKey.getHeight();
        } else {
            width = UIUtil.px2dp(UIUtil.getScreenWidth(InnerManager.getContext()));
            height = 0;
        }
        this.mTTAdNative.loadNativeExpressOb(new TTObSlot.Builder().setCodeId(this.mAdKey.getCodeId()).setSupportDeepLink(true).setObCount(3).setExpressViewAcceptedSize(width, height).setImageAcceptedSize(640, 320).build(), new TTObNative.NativeExpressObListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo.Loader4ObNativeExpress.1
            public void onError(int i, String str) {
                Loader4ObNativeExpress.this.mIsLoading = false;
                AdLog.getInstance().sendAdFailed(Loader4ObNativeExpress.this.mAdKey, i, str, null, false);
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4ObNativeExpress.this.mAdKey.getCodeId());
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4ObNativeExpress.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestFail(i, str, map);
                    }
                }
                LG.d("AdLog-Loader4ObNativeExpress", "ob load ad error rit: " + Loader4ObNativeExpress.this.mAdKey.getCodeId() + ", code = " + i + ", msg = " + str);
            }

            public void onNativeExpressObLoad(List<TTNativeExpressOb> list) {
                Loader4ObNativeExpress.this.mIsLoading = false;
                Loader4ObNativeExpress.this.mHasParseReqId = false;
                if (list == null) {
                    AdLog.getInstance().sendAdSuccess(Loader4ObNativeExpress.this.mAdKey, 0, null, false);
                    return;
                }
                AdLog.getInstance().sendAdSuccess(Loader4ObNativeExpress.this.mAdKey, list.size(), null, false);
                LG.d("AdLog-Loader4ObNativeExpress", "ob load ad rit: " + Loader4ObNativeExpress.this.mAdKey.getCodeId() + ", size = " + list.size());
                for (final TTNativeExpressOb tTNativeExpressOb : list) {
                    if (!Loader4ObNativeExpress.this.mHasParseReqId) {
                        Loader4ObNativeExpress.this.mRequestId = OppoObUtils.getAdRequestId(tTNativeExpressOb);
                        Loader4ObNativeExpress.this.mHasParseReqId = true;
                    }
                    final Map<String, Object> mediaExtraInfo = OppoObUtils.getMediaExtraInfo(tTNativeExpressOb);
                    AdManager.inst().saveAd(Loader4ObNativeExpress.this.mAdKey, new ObExpressAd(tTNativeExpressOb, System.currentTimeMillis()));
                    tTNativeExpressOb.setExpressInteractionListener(new TTNativeExpressOb.ExpressObInteractionListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo.Loader4ObNativeExpress.1.1
                        public void onObClicked(View view, int i) {
                            AdLog.getInstance().sendAdClick(Loader4ObNativeExpress.this.mAdKey, null, false, -1, null);
                            LG.d("AdLog-Loader4ObNativeExpress", "ob native express ad clicked");
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, Loader4ObNativeExpress.this.mAdKey.getCodeId());
                                map.put("request_id", OppoObUtils.getAdRequestId(tTNativeExpressOb));
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4ObNativeExpress.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdClicked(map);
                                }
                            }
                        }

                        public void onObShow(View view, int i) {
                            AdLog.getInstance().sendAdShow(Loader4ObNativeExpress.this.mAdKey, null, false, -1);
                            LG.d("AdLog-Loader4ObNativeExpress", "ob native express ad show");
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, Loader4ObNativeExpress.this.mAdKey.getCodeId());
                                map.put("request_id", OppoObUtils.getAdRequestId(tTNativeExpressOb));
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4ObNativeExpress.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdShow(map);
                                }
                            }
                        }

                        public void onRenderFail(View view, String str, int i) {
                            LG.d("AdLog-Loader4ObNativeExpress", "ob native express ad render fail code = " + i + ", msg = " + str);
                        }

                        public void onRenderSuccess(View view, float f, float f2) {
                            LG.d("AdLog-Loader4ObNativeExpress", "ob native express ad render success");
                        }
                    });
                    tTNativeExpressOb.render();
                    tTNativeExpressOb.setVideoObListener(new TTNativeExpressOb.ExpressVideoObListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo.Loader4ObNativeExpress.1.2
                        public void onClickRetry() {
                        }

                        public void onProgressUpdate(long j, long j2) {
                        }

                        public void onVideoLoad() {
                        }

                        public void onVideoError(int i, int i2) {
                            AdLog.getInstance().sendAdPlayFail(Loader4ObNativeExpress.this.mAdKey, null, false, -1);
                        }

                        public void onVideoObStartPlay() {
                            AdLog.getInstance().sendAdPlay(Loader4ObNativeExpress.this.mAdKey, null, false, -1);
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, Loader4ObNativeExpress.this.mAdKey.getCodeId());
                                map.put("request_id", OppoObUtils.getAdRequestId(tTNativeExpressOb));
                                AdVideoCallbackUtil.addTotalDuration(Loader4ObNativeExpress.this.getTotalDuration(tTNativeExpressOb), map);
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4ObNativeExpress.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdPlayStart(map);
                                }
                            }
                        }

                        public void onVideoObPaused() {
                            AdLog.getInstance().sendAdPause(Loader4ObNativeExpress.this.mAdKey, null, false, -1);
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, Loader4ObNativeExpress.this.mAdKey.getCodeId());
                                map.put("request_id", OppoObUtils.getAdRequestId(tTNativeExpressOb));
                                long[] duration = Loader4ObNativeExpress.this.getDuration(tTNativeExpressOb);
                                AdVideoCallbackUtil.addCurrentDuration(duration[0], map);
                                AdVideoCallbackUtil.addTotalDuration(duration[1], map);
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4ObNativeExpress.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdPlayPause(map);
                                }
                            }
                        }

                        public void onVideoObContinuePlay() {
                            AdLog.getInstance().sendAdContinue(Loader4ObNativeExpress.this.mAdKey, null, false, -1);
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, Loader4ObNativeExpress.this.mAdKey.getCodeId());
                                map.put("request_id", OppoObUtils.getAdRequestId(tTNativeExpressOb));
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4ObNativeExpress.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdPlayContinue(map);
                                }
                            }
                        }

                        public void onVideoObComplete() {
                            AdLog.getInstance().sendAdComplete(Loader4ObNativeExpress.this.mAdKey, null, false, -1);
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, Loader4ObNativeExpress.this.mAdKey.getCodeId());
                                map.put("request_id", OppoObUtils.getAdRequestId(tTNativeExpressOb));
                                AdVideoCallbackUtil.addTotalDuration(Loader4ObNativeExpress.this.getTotalDuration(tTNativeExpressOb), map);
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4ObNativeExpress.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdPlayComplete(map);
                                }
                            }
                        }
                    });
                }
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4ObNativeExpress.this.mAdKey.getCodeId());
                    map.put(PointParamKey.AD_COUNT, Integer.valueOf(list.size()));
                    map.put("request_id", Loader4ObNativeExpress.this.mRequestId);
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4ObNativeExpress.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestSuccess(map);
                    }
                }
                BEAdCome.build().setCodeId(Loader4ObNativeExpress.this.mAdKey.getCodeId()).send();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long[] getDuration(TTNativeExpressOb tTNativeExpressOb) {
        VideoControllerDataModel videoModel;
        long[] jArr = {0, 0};
        if (tTNativeExpressOb != null && (videoModel = tTNativeExpressOb.getVideoModel()) != null) {
            jArr[0] = videoModel.currentPlayPosition;
            jArr[1] = videoModel.duration;
        }
        return jArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getTotalDuration(TTNativeExpressOb tTNativeExpressOb) {
        VideoControllerDataModel videoModel;
        if (tTNativeExpressOb == null || (videoModel = tTNativeExpressOb.getVideoModel()) == null) {
            return 0L;
        }
        return videoModel.duration;
    }
}

package com.bytedance.sdk.djx.core.business.ad.open;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.djx.core.business.ad.AdKey;
import com.bytedance.sdk.djx.core.business.ad.AdLog;
import com.bytedance.sdk.djx.core.business.ad.AdManager;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.bytedance.sdk.djx.core.business.ad.LoaderAbs;
import com.bytedance.sdk.djx.core.business.ad.LoaderModel;
import com.bytedance.sdk.djx.core.util.AdVideoCallbackUtil;
import com.bytedance.sdk.djx.interfaces.listener.IDJXAdListener;
import com.bytedance.sdk.djx.model.ev.BEAdCome;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class Loader4Banner extends OpenLoaderAbs {
    private static final int LOAD_AMOUNT = 1;
    private static final String TAG = "Loader4Banner";
    private final Context mContext;
    private long mCurrentPlayPosition;
    private boolean mHasParseReqId;
    private String mRequestId;
    private long mTotalDuration;

    @Override // com.bytedance.sdk.djx.core.business.ad.open.OpenLoaderAbs, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    public /* bridge */ /* synthetic */ void load() {
        super.load();
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.open.OpenLoaderAbs, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    public /* bridge */ /* synthetic */ void load(LoaderModel loaderModel, LoaderAbs.Callback callback) {
        super.load(loaderModel, callback);
    }

    public Loader4Banner(AdKey adKey) {
        super(adKey);
        this.mContext = InnerManager.getContext();
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected void doLoad() {
        int width;
        int height = 0;
        if (this.mAdKey.getWidth() != 0 || this.mAdKey.getHeight() != 0) {
            width = this.mAdKey.getWidth();
            height = this.mAdKey.getHeight();
        } else {
            Context context = this.mContext;
            width = context != null ? UIUtil.getScreenWidth(context) : 0;
        }
        LG.i(TAG, "ad code = " + this.mAdKey.getCodeId() + " , width = " + width + " ,height = " + height);
        loadAd(OpenAdUtils.createAdSlotBuilder(this.mAdKey.getCategoryFeature(), this.mAdKey).setCodeId(this.mAdKey.getCodeId()).setSupportDeepLink(true).setExpressViewAcceptedSize(width, height).setAdCount(1).setAdLoadType(TTAdLoadType.PRELOAD).build());
    }

    private void loadAd(AdSlot adSlot) {
        this.mTTAdNative.loadBannerExpressAd(adSlot, new TTAdNative.NativeExpressAdListener() { // from class: com.bytedance.sdk.djx.core.business.ad.open.Loader4Banner.1
            public void onError(int i, String str) {
                Loader4Banner.this.mIsLoading = false;
                AdLog.getInstance().sendAdFailed(Loader4Banner.this.mAdKey, i, str, null, false);
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4Banner.this.mAdKey.getCodeId());
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4Banner.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestFail(i, str, map);
                    }
                }
                LG.d("AdLog-Loader4Banner", "load banner ad error rit: " + Loader4Banner.this.mAdKey.getCodeId() + ", code = " + i + ", msg = " + str);
            }

            public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                Loader4Banner.this.mIsLoading = false;
                Loader4Banner.this.mHasParseReqId = false;
                if (list == null) {
                    AdLog.getInstance().sendAdSuccess(Loader4Banner.this.mAdKey, 0, null, false);
                    return;
                }
                AdLog.getInstance().sendAdSuccess(Loader4Banner.this.mAdKey, list.size(), null, false);
                LG.d("AdLog-Loader4Banner", "load banner ad rit: " + Loader4Banner.this.mAdKey.getCodeId() + ", size = " + list.size());
                for (final TTNativeExpressAd tTNativeExpressAd : list) {
                    if (!Loader4Banner.this.mHasParseReqId) {
                        Loader4Banner.this.mRequestId = OpenAdUtils.getAdRequestId(tTNativeExpressAd);
                        Loader4Banner.this.mHasParseReqId = true;
                    }
                    final Map<String, Object> mediaExtraInfo = OpenAdUtils.getMediaExtraInfo(tTNativeExpressAd);
                    final OpenBannerAd openBannerAd = new OpenBannerAd(tTNativeExpressAd, System.currentTimeMillis());
                    AdManager.inst().saveAd(Loader4Banner.this.mAdKey, openBannerAd);
                    tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.sdk.djx.core.business.ad.open.Loader4Banner.1.1
                        public void onAdClicked(View view, int i) {
                            AdLog.getInstance().sendAdClick(Loader4Banner.this.mAdKey, null, false, -1, null);
                            LG.d("AdLog-Loader4Banner", "banner native express ad clicked");
                            if (openBannerAd.getInnerAdExpressListener() != null) {
                                openBannerAd.getInnerAdExpressListener().onAdClicked(view, openBannerAd);
                            }
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, Loader4Banner.this.mAdKey.getCodeId());
                                map.put("request_id", OpenAdUtils.getAdRequestId(tTNativeExpressAd));
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4Banner.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdClicked(map);
                                }
                            }
                        }

                        public void onAdShow(View view, int i) {
                            AdLog.getInstance().sendAdShow(Loader4Banner.this.mAdKey, null, false, -1);
                            LG.d("AdLog-Loader4Banner", "banner native express ad show");
                            if (openBannerAd.getInnerAdExpressListener() != null) {
                                openBannerAd.getInnerAdExpressListener().onAdShow(openBannerAd);
                            }
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, Loader4Banner.this.mAdKey.getCodeId());
                                map.put("request_id", OpenAdUtils.getAdRequestId(tTNativeExpressAd));
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4Banner.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdShow(map);
                                }
                            }
                        }

                        public void onRenderFail(View view, String str, int i) {
                            LG.d("AdLog-Loader4Banner", "banner native express ad render fail code = " + i + ", msg = " + str);
                            if (openBannerAd.getInnerAdExpressListener() != null) {
                                openBannerAd.getInnerAdExpressListener().onRenderFail(openBannerAd, str, i);
                            }
                        }

                        public void onRenderSuccess(View view, float f, float f2) {
                            LG.d("AdLog-Loader4Banner", "banner native express ad render success " + Loader4Banner.this.mAdKey.getCodeId());
                            if (openBannerAd.getInnerAdExpressListener() != null) {
                                openBannerAd.getInnerAdExpressListener().onRenderSuccess(openBannerAd, f, f2);
                            }
                        }
                    });
                    tTNativeExpressAd.render();
                    tTNativeExpressAd.setVideoAdListener(new TTNativeExpressAd.ExpressVideoAdListener() { // from class: com.bytedance.sdk.djx.core.business.ad.open.Loader4Banner.1.2
                        public void onClickRetry() {
                        }

                        public void onVideoLoad() {
                        }

                        public void onVideoError(int i, int i2) {
                            AdLog.getInstance().sendAdPlayFail(Loader4Banner.this.mAdKey, null, false, -1);
                        }

                        public void onVideoAdStartPlay() {
                            AdLog.getInstance().sendAdPlay(Loader4Banner.this.mAdKey, null, false, -1);
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, Loader4Banner.this.mAdKey.getCodeId());
                                map.put("request_id", OpenAdUtils.getAdRequestId(tTNativeExpressAd));
                                AdVideoCallbackUtil.addTotalDuration(0L, map);
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4Banner.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdPlayStart(map);
                                }
                            }
                        }

                        public void onVideoAdPaused() {
                            AdLog.getInstance().sendAdPause(Loader4Banner.this.mAdKey, null, false, -1);
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, Loader4Banner.this.mAdKey.getCodeId());
                                map.put("request_id", OpenAdUtils.getAdRequestId(tTNativeExpressAd));
                                AdVideoCallbackUtil.addTotalDuration(Loader4Banner.this.mTotalDuration, map);
                                AdVideoCallbackUtil.addCurrentDuration(Loader4Banner.this.mCurrentPlayPosition, map);
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4Banner.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdPlayPause(map);
                                }
                            }
                        }

                        public void onVideoAdContinuePlay() {
                            AdLog.getInstance().sendAdContinue(Loader4Banner.this.mAdKey, null, false, -1);
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, Loader4Banner.this.mAdKey.getCodeId());
                                map.put("request_id", OpenAdUtils.getAdRequestId(tTNativeExpressAd));
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4Banner.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdPlayContinue(map);
                                }
                            }
                        }

                        public void onProgressUpdate(long j, long j2) {
                            Loader4Banner.this.mCurrentPlayPosition = j;
                            Loader4Banner.this.mTotalDuration = j2;
                        }

                        public void onVideoAdComplete() {
                            AdLog.getInstance().sendAdComplete(Loader4Banner.this.mAdKey, null, false, -1);
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, Loader4Banner.this.mAdKey.getCodeId());
                                map.put("request_id", OpenAdUtils.getAdRequestId(tTNativeExpressAd));
                                AdVideoCallbackUtil.addTotalDuration(Loader4Banner.this.mTotalDuration, map);
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4Banner.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdPlayComplete(map);
                                }
                            }
                        }
                    });
                }
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4Banner.this.mAdKey.getCodeId());
                    map.put(PointParamKey.AD_COUNT, Integer.valueOf(list.size()));
                    map.put("request_id", Loader4Banner.this.mRequestId);
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4Banner.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestSuccess(map);
                    }
                }
                BEAdCome.build().setCodeId(Loader4Banner.this.mAdKey.getCodeId()).send();
            }
        });
    }
}

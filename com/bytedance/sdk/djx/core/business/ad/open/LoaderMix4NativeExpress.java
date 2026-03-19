package com.bytedance.sdk.djx.core.business.ad.open;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.djx.core.business.ad.AdKey;
import com.bytedance.sdk.djx.core.business.ad.AdLog;
import com.bytedance.sdk.djx.core.business.ad.AdManager;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.bytedance.sdk.djx.core.business.ad.LoaderAbs;
import com.bytedance.sdk.djx.core.business.ad.LoaderModel;
import com.bytedance.sdk.djx.core.util.AdVideoCallbackUtil;
import com.bytedance.sdk.djx.interfaces.listener.IDJXAdListener;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class LoaderMix4NativeExpress extends Loader4NativeExpress {
    private static final String TAG = "LoaderMix4NativeExpress";
    private long mCurrentPlayPosition;
    private long mTotalDuration;

    @Override // com.bytedance.sdk.djx.core.business.ad.open.Loader4NativeExpress, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected void doLoad() {
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.open.OpenLoaderAbs, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    public void load() {
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.open.OpenLoaderAbs, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    public /* bridge */ /* synthetic */ void load(LoaderModel loaderModel, LoaderAbs.Callback callback) {
        super.load(loaderModel, callback);
    }

    public LoaderMix4NativeExpress(AdKey adKey) {
        super(adKey);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    public String getToken() {
        return TTAdSdk.getAdManager().getBiddingToken(buildAdSlot().build(), true, 5);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.open.OpenLoaderAbs, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected void doLoad(final LoaderModel loaderModel, final LoaderAbs.Callback callback) {
        if (loaderModel == null || TextUtils.isEmpty(loaderModel.mAdm)) {
            onErrorResponse(loaderModel, callback, 0, "adm is null");
            LG.d("AdLog-LoaderMix4NativeExpress", "load ad error rit: " + this.mAdKey.getCodeId() + ", code = 0, msg = adm is null");
        } else {
            this.mTTAdNative.loadNativeExpressAd(buildAdSlot().withBid(loaderModel.mAdm).build(), new TTAdNative.NativeExpressAdListener() { // from class: com.bytedance.sdk.djx.core.business.ad.open.LoaderMix4NativeExpress.1
                public void onError(int i, String str) {
                    LoaderMix4NativeExpress.this.onErrorResponse(loaderModel, callback, i, str);
                    LG.d("AdLog-LoaderMix4NativeExpress", "load ad error rit: " + LoaderMix4NativeExpress.this.mAdKey.getCodeId() + ", code = " + i + ", msg = " + str);
                }

                public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                    if (list == null) {
                        AdLog.getInstance().sendAdSuccess(LoaderMix4NativeExpress.this.mAdKey, 0, loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true);
                        return;
                    }
                    AdLog.getInstance().sendAdSuccess(LoaderMix4NativeExpress.this.mAdKey, list.size(), loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true);
                    LG.d("AdLog-LoaderMix4NativeExpress", "load ad rit: " + LoaderMix4NativeExpress.this.mAdKey.getCodeId() + ", size = " + list.size());
                    ArrayList arrayList = new ArrayList();
                    String str = "";
                    for (final TTNativeExpressAd tTNativeExpressAd : list) {
                        final OpenExpressAd openExpressAd = new OpenExpressAd(tTNativeExpressAd, System.currentTimeMillis());
                        openExpressAd.setFeed(loaderModel.mFeed);
                        arrayList.add(openExpressAd);
                        String adRequestId = OpenAdUtils.getAdRequestId(tTNativeExpressAd);
                        final Map<String, Object> mediaExtraInfo = OpenAdUtils.getMediaExtraInfo(tTNativeExpressAd);
                        tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.sdk.djx.core.business.ad.open.LoaderMix4NativeExpress.1.1
                            public void onAdClicked(View view, int i) {
                                AdLog.getInstance().sendAdClick(LoaderMix4NativeExpress.this.mAdKey, loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true, -1, null);
                                LG.d("AdLog-LoaderMix4NativeExpress", "native ad clicked");
                                if (openExpressAd.getInnerAdExpressListener() != null) {
                                    openExpressAd.getInnerAdExpressListener().onAdClicked(view, openExpressAd);
                                }
                                if (AdManager.inst().mAdListenerMap != null) {
                                    HashMap map = new HashMap();
                                    map.put(IDJXAd.AD_CODE_ID, LoaderMix4NativeExpress.this.mAdKey.getCodeId());
                                    map.put("request_id", OpenAdUtils.getAdRequestId(tTNativeExpressAd));
                                    Map map2 = mediaExtraInfo;
                                    if (map2 != null) {
                                        map.putAll(map2);
                                    }
                                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(LoaderMix4NativeExpress.this.mAdKey.getParamsCode()));
                                    if (iDJXAdListener != null) {
                                        iDJXAdListener.onDJXAdClicked(map);
                                    }
                                }
                            }

                            public void onAdShow(View view, int i) {
                                AdLog.getInstance().sendAdShow(LoaderMix4NativeExpress.this.mAdKey, loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true, -1);
                                LG.d("AdLog-LoaderMix4NativeExpress", "native ad show");
                                if (openExpressAd.getInnerAdExpressListener() != null) {
                                    openExpressAd.getInnerAdExpressListener().onAdShow(openExpressAd);
                                }
                                if (AdManager.inst().mAdListenerMap != null) {
                                    HashMap map = new HashMap();
                                    map.put(IDJXAd.AD_CODE_ID, LoaderMix4NativeExpress.this.mAdKey.getCodeId());
                                    map.put("request_id", OpenAdUtils.getAdRequestId(tTNativeExpressAd));
                                    Map map2 = mediaExtraInfo;
                                    if (map2 != null) {
                                        map.putAll(map2);
                                    }
                                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(LoaderMix4NativeExpress.this.mAdKey.getParamsCode()));
                                    if (iDJXAdListener != null) {
                                        iDJXAdListener.onDJXAdShow(map);
                                    }
                                }
                            }

                            public void onRenderFail(View view, String str2, int i) {
                                LG.d("AdLog-LoaderMix4NativeExpress", "native ad render fail code = " + i + ", msg = " + str2);
                                if (openExpressAd.getInnerAdExpressListener() != null) {
                                    openExpressAd.getInnerAdExpressListener().onRenderFail(openExpressAd, str2, i);
                                }
                            }

                            public void onRenderSuccess(View view, float f, float f2) {
                                LG.d("AdLog-LoaderMix4NativeExpress", "native ad render success");
                                if (openExpressAd.getInnerAdExpressListener() != null) {
                                    openExpressAd.getInnerAdExpressListener().onRenderSuccess(openExpressAd, f, f2);
                                }
                            }
                        });
                        tTNativeExpressAd.render();
                        tTNativeExpressAd.setVideoAdListener(new TTNativeExpressAd.ExpressVideoAdListener() { // from class: com.bytedance.sdk.djx.core.business.ad.open.LoaderMix4NativeExpress.1.2
                            public void onClickRetry() {
                            }

                            public void onVideoLoad() {
                            }

                            public void onVideoError(int i, int i2) {
                                AdLog.getInstance().sendAdPlayFail(LoaderMix4NativeExpress.this.mAdKey, loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true, -1);
                            }

                            public void onVideoAdStartPlay() {
                                AdLog.getInstance().sendAdPlay(LoaderMix4NativeExpress.this.mAdKey, loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true, -1);
                                if (AdManager.inst().mAdListenerMap != null) {
                                    HashMap map = new HashMap();
                                    map.put(IDJXAd.AD_CODE_ID, LoaderMix4NativeExpress.this.mAdKey.getCodeId());
                                    map.put("request_id", OpenAdUtils.getAdRequestId(tTNativeExpressAd));
                                    AdVideoCallbackUtil.addTotalDuration(0L, map);
                                    Map map2 = mediaExtraInfo;
                                    if (map2 != null) {
                                        map.putAll(map2);
                                    }
                                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(LoaderMix4NativeExpress.this.mAdKey.getParamsCode()));
                                    if (iDJXAdListener != null) {
                                        iDJXAdListener.onDJXAdPlayStart(map);
                                    }
                                }
                            }

                            public void onVideoAdPaused() {
                                AdLog.getInstance().sendAdPause(LoaderMix4NativeExpress.this.mAdKey, loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true, -1);
                                if (AdManager.inst().mAdListenerMap != null) {
                                    HashMap map = new HashMap();
                                    map.put(IDJXAd.AD_CODE_ID, LoaderMix4NativeExpress.this.mAdKey.getCodeId());
                                    map.put("request_id", OpenAdUtils.getAdRequestId(tTNativeExpressAd));
                                    AdVideoCallbackUtil.addTotalDuration(LoaderMix4NativeExpress.this.mTotalDuration, map);
                                    AdVideoCallbackUtil.addCurrentDuration(LoaderMix4NativeExpress.this.mCurrentPlayPosition, map);
                                    Map map2 = mediaExtraInfo;
                                    if (map2 != null) {
                                        map.putAll(map2);
                                    }
                                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(LoaderMix4NativeExpress.this.mAdKey.getParamsCode()));
                                    if (iDJXAdListener != null) {
                                        iDJXAdListener.onDJXAdPlayPause(map);
                                    }
                                }
                            }

                            public void onVideoAdContinuePlay() {
                                AdLog.getInstance().sendAdContinue(LoaderMix4NativeExpress.this.mAdKey, loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true, -1);
                                if (AdManager.inst().mAdListenerMap != null) {
                                    HashMap map = new HashMap();
                                    map.put(IDJXAd.AD_CODE_ID, LoaderMix4NativeExpress.this.mAdKey.getCodeId());
                                    map.put("request_id", OpenAdUtils.getAdRequestId(tTNativeExpressAd));
                                    Map map2 = mediaExtraInfo;
                                    if (map2 != null) {
                                        map.putAll(map2);
                                    }
                                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(LoaderMix4NativeExpress.this.mAdKey.getParamsCode()));
                                    if (iDJXAdListener != null) {
                                        iDJXAdListener.onDJXAdPlayContinue(map);
                                    }
                                }
                            }

                            public void onProgressUpdate(long j, long j2) {
                                LoaderMix4NativeExpress.this.mCurrentPlayPosition = j;
                                LoaderMix4NativeExpress.this.mTotalDuration = j2;
                            }

                            public void onVideoAdComplete() {
                                AdLog.getInstance().sendAdComplete(LoaderMix4NativeExpress.this.mAdKey, loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true, -1);
                                if (AdManager.inst().mAdListenerMap != null) {
                                    HashMap map = new HashMap();
                                    map.put(IDJXAd.AD_CODE_ID, LoaderMix4NativeExpress.this.mAdKey.getCodeId());
                                    map.put("request_id", OpenAdUtils.getAdRequestId(tTNativeExpressAd));
                                    AdVideoCallbackUtil.addTotalDuration(LoaderMix4NativeExpress.this.mTotalDuration, map);
                                    Map map2 = mediaExtraInfo;
                                    if (map2 != null) {
                                        map.putAll(map2);
                                    }
                                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(LoaderMix4NativeExpress.this.mAdKey.getParamsCode()));
                                    if (iDJXAdListener != null) {
                                        iDJXAdListener.onDJXAdPlayComplete(map);
                                    }
                                }
                            }
                        });
                        str = adRequestId;
                    }
                    LoaderAbs.Callback callback2 = callback;
                    if (callback2 != null) {
                        callback2.onAdLoadSuccess(arrayList);
                    }
                    if (AdManager.inst().mAdListenerMap != null) {
                        HashMap map = new HashMap();
                        map.put(IDJXAd.AD_CODE_ID, LoaderMix4NativeExpress.this.mAdKey.getCodeId());
                        map.put(PointParamKey.AD_COUNT, Integer.valueOf(list.size()));
                        map.put("request_id", str);
                        IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(LoaderMix4NativeExpress.this.mAdKey.getParamsCode()));
                        if (iDJXAdListener != null) {
                            iDJXAdListener.onDJXAdRequestSuccess(map);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onErrorResponse(LoaderModel loaderModel, LoaderAbs.Callback callback, int i, String str) {
        if (callback != null) {
            callback.onAdLoadError(i, str);
        }
        AdLog.getInstance().sendAdFailed(this.mAdKey, i, str, loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true);
        if (AdManager.inst().mAdListenerMap != null) {
            HashMap map = new HashMap();
            map.put(IDJXAd.AD_CODE_ID, this.mAdKey.getCodeId());
            IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(this.mAdKey.getParamsCode()));
            if (iDJXAdListener != null) {
                iDJXAdListener.onDJXAdRequestFail(i, str, map);
            }
        }
    }
}

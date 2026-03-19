package com.bytedance.sdk.djx.core.business.ad.open;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.djx.core.business.ad.AdKey;
import com.bytedance.sdk.djx.core.business.ad.AdLog;
import com.bytedance.sdk.djx.core.business.ad.AdManager;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.bytedance.sdk.djx.core.business.ad.LoaderAbs;
import com.bytedance.sdk.djx.core.business.ad.LoaderModel;
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
class LoaderMix4ExpressDrawFeed extends Loader4ExpressDrawFeed {
    private static final String TAG = "LoaderMix4ExpressDrawFeed";

    @Override // com.bytedance.sdk.djx.core.business.ad.open.Loader4ExpressDrawFeed, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected void doLoad() {
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.open.OpenLoaderAbs, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    public void load() {
    }

    public LoaderMix4ExpressDrawFeed(AdKey adKey) {
        super(adKey);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    public String getToken() {
        return TTAdSdk.getAdManager().getBiddingToken(buildAdSlot().build(), true, 9);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.open.OpenLoaderAbs, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected void doLoad(final LoaderModel loaderModel, final LoaderAbs.Callback callback) {
        if (loaderModel == null || TextUtils.isEmpty(loaderModel.mAdm)) {
            onErrorResponse(loaderModel, callback, 0, "adm is null");
            LG.d("AdLog-LoaderMix4ExpressDrawFeed", "load ad error rit: " + this.mAdKey.getCodeId() + ", code = 0, msg = adm is null");
        } else {
            this.mTTAdNative.loadExpressDrawFeedAd(buildAdSlot().withBid(loaderModel.mAdm).build(), new TTAdNative.NativeExpressAdListener() { // from class: com.bytedance.sdk.djx.core.business.ad.open.LoaderMix4ExpressDrawFeed.1
                public void onError(int i, String str) {
                    LoaderMix4ExpressDrawFeed.this.onErrorResponse(loaderModel, callback, i, str);
                    LG.d("AdLog-LoaderMix4ExpressDrawFeed", "load ad error rit: " + LoaderMix4ExpressDrawFeed.this.mAdKey.getCodeId() + ", code = " + i + ", msg = " + str);
                }

                public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                    if (list == null) {
                        AdLog.getInstance().sendAdSuccess(LoaderMix4ExpressDrawFeed.this.mAdKey, 0, loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true);
                        return;
                    }
                    AdLog.getInstance().sendAdSuccess(LoaderMix4ExpressDrawFeed.this.mAdKey, list.size(), loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true);
                    LG.d("AdLog-LoaderMix4ExpressDrawFeed", "load ad rit: " + LoaderMix4ExpressDrawFeed.this.mAdKey.getCodeId() + ", size = " + list.size());
                    ArrayList arrayList = new ArrayList();
                    String str = "";
                    for (final TTNativeExpressAd tTNativeExpressAd : list) {
                        final OpenExpressAd openExpressAd = new OpenExpressAd(tTNativeExpressAd, System.currentTimeMillis());
                        arrayList.add(openExpressAd);
                        String adRequestId = OpenAdUtils.getAdRequestId(tTNativeExpressAd);
                        final Map<String, Object> mediaExtraInfo = OpenAdUtils.getMediaExtraInfo(tTNativeExpressAd);
                        tTNativeExpressAd.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.sdk.djx.core.business.ad.open.LoaderMix4ExpressDrawFeed.1.1
                            public void onAdClicked(View view, int i) {
                                AdLog.getInstance().sendAdClick(LoaderMix4ExpressDrawFeed.this.mAdKey, loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true, -1, null);
                                LG.d("AdLog-LoaderMix4ExpressDrawFeed", "draw ad clicked");
                                if (openExpressAd.getInnerAdExpressListener() != null) {
                                    openExpressAd.getInnerAdExpressListener().onAdClicked(view, openExpressAd);
                                }
                                if (AdManager.inst().mAdListenerMap != null) {
                                    HashMap map = new HashMap();
                                    map.put(IDJXAd.AD_CODE_ID, LoaderMix4ExpressDrawFeed.this.mAdKey.getCodeId());
                                    map.put("request_id", OpenAdUtils.getAdRequestId(tTNativeExpressAd));
                                    Map map2 = mediaExtraInfo;
                                    if (map2 != null) {
                                        map.putAll(map2);
                                    }
                                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(LoaderMix4ExpressDrawFeed.this.mAdKey.getParamsCode()));
                                    if (iDJXAdListener != null) {
                                        iDJXAdListener.onDJXAdClicked(map);
                                    }
                                }
                            }

                            public void onAdShow(View view, int i) {
                                AdLog.getInstance().sendAdShow(LoaderMix4ExpressDrawFeed.this.mAdKey, loaderModel.mFeed != null ? loaderModel.mFeed.getReqId() : null, true, -1);
                                LG.d("AdLog-LoaderMix4ExpressDrawFeed", "draw ad show");
                                if (openExpressAd.getInnerAdExpressListener() != null) {
                                    openExpressAd.getInnerAdExpressListener().onAdShow(openExpressAd);
                                }
                                if (AdManager.inst().mAdListenerMap != null) {
                                    HashMap map = new HashMap();
                                    map.put(IDJXAd.AD_CODE_ID, LoaderMix4ExpressDrawFeed.this.mAdKey.getCodeId());
                                    map.put("request_id", OpenAdUtils.getAdRequestId(tTNativeExpressAd));
                                    Map map2 = mediaExtraInfo;
                                    if (map2 != null) {
                                        map.putAll(map2);
                                    }
                                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(LoaderMix4ExpressDrawFeed.this.mAdKey.getParamsCode()));
                                    if (iDJXAdListener != null) {
                                        iDJXAdListener.onDJXAdShow(map);
                                    }
                                }
                            }

                            public void onRenderFail(View view, String str2, int i) {
                                LG.d("AdLog-LoaderMix4ExpressDrawFeed", "draw ad render fail code = " + i + ", msg = " + str2);
                                if (openExpressAd.getInnerAdExpressListener() != null) {
                                    openExpressAd.getInnerAdExpressListener().onRenderFail(openExpressAd, str2, i);
                                }
                            }

                            public void onRenderSuccess(View view, float f, float f2) {
                                LG.d("AdLog-LoaderMix4ExpressDrawFeed", "draw ad render success");
                                if (openExpressAd.getInnerAdExpressListener() != null) {
                                    openExpressAd.getInnerAdExpressListener().onRenderSuccess(openExpressAd, f, f2);
                                }
                            }
                        });
                        tTNativeExpressAd.render();
                        str = adRequestId;
                    }
                    LoaderAbs.Callback callback2 = callback;
                    if (callback2 != null) {
                        callback2.onAdLoadSuccess(arrayList);
                    }
                    if (AdManager.inst().mAdListenerMap != null) {
                        HashMap map = new HashMap();
                        map.put(IDJXAd.AD_CODE_ID, LoaderMix4ExpressDrawFeed.this.mAdKey.getCodeId());
                        map.put(PointParamKey.AD_COUNT, Integer.valueOf(list.size()));
                        map.put("request_id", str);
                        IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(LoaderMix4ExpressDrawFeed.this.mAdKey.getParamsCode()));
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

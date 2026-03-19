package com.bytedance.sdk.djx.core.business.ad.oppo;

import android.view.View;
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
import com.ttshell.sdk.api.TTNativeExpressOb;
import com.ttshell.sdk.api.TTObNative;
import com.ttshell.sdk.api.model.TTObSlot;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class Loader4ObExpressDrawFeed extends ObLoaderAbs {
    private static final int MAX_LOAD_NUM = 3;
    private static final String TAG = "Loader4ObExpressDrawFeed";
    private boolean mHasParseReqId;
    private String mRequestId;

    public Loader4ObExpressDrawFeed(AdKey adKey) {
        super(adKey);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.oppo.ObLoaderAbs, com.bytedance.sdk.djx.core.business.ad.LoaderAbs
    protected void doLoad() {
        int width;
        int height;
        if (this.mAdKey.getWidth() != 0 || this.mAdKey.getHeight() != 0) {
            width = this.mAdKey.getWidth();
            height = this.mAdKey.getHeight();
        } else {
            width = UIUtil.px2dp(UIUtil.getScreenWidth(InnerManager.getContext()));
            height = UIUtil.px2dp(UIUtil.getScreenHeight(InnerManager.getContext()));
        }
        this.mTTAdNative.loadExpressDrawFeedOb(new TTObSlot.Builder().setCodeId(this.mAdKey.getCodeId()).setSupportDeepLink(true).setExpressViewAcceptedSize(width, height).setObCount(3).build(), new TTObNative.NativeExpressObListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo.Loader4ObExpressDrawFeed.1
            public void onError(int i, String str) {
                Loader4ObExpressDrawFeed.this.mIsLoading = false;
                AdLog.getInstance().sendAdFailed(Loader4ObExpressDrawFeed.this.mAdKey, i, str, null, false);
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4ObExpressDrawFeed.this.mAdKey.getCodeId());
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4ObExpressDrawFeed.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestFail(i, str, map);
                    }
                }
                LG.d("AdLog-Loader4ObExpressDrawFeed", "ob load ad error rit: " + Loader4ObExpressDrawFeed.this.mAdKey.getCodeId() + ", code = " + i + ", msg = " + str);
            }

            public void onNativeExpressObLoad(List<TTNativeExpressOb> list) {
                Loader4ObExpressDrawFeed.this.mIsLoading = false;
                Loader4ObExpressDrawFeed.this.mHasParseReqId = false;
                if (list == null) {
                    AdLog.getInstance().sendAdSuccess(Loader4ObExpressDrawFeed.this.mAdKey, 0, null, false);
                    return;
                }
                AdLog.getInstance().sendAdSuccess(Loader4ObExpressDrawFeed.this.mAdKey, list.size(), null, false);
                LG.d("AdLog-Loader4ObExpressDrawFeed", "ob load ad rit: " + Loader4ObExpressDrawFeed.this.mAdKey.getCodeId() + ", size = " + list.size());
                for (final TTNativeExpressOb tTNativeExpressOb : list) {
                    if (!Loader4ObExpressDrawFeed.this.mHasParseReqId) {
                        Loader4ObExpressDrawFeed.this.mRequestId = OppoObUtils.getAdRequestId(tTNativeExpressOb);
                        Loader4ObExpressDrawFeed.this.mHasParseReqId = true;
                    }
                    final Map<String, Object> mediaExtraInfo = OppoObUtils.getMediaExtraInfo(tTNativeExpressOb);
                    AdManager.inst().saveAd(Loader4ObExpressDrawFeed.this.mAdKey, new ObExpressAd(tTNativeExpressOb, System.currentTimeMillis()));
                    tTNativeExpressOb.setExpressInteractionListener(new TTNativeExpressOb.ExpressObInteractionListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo.Loader4ObExpressDrawFeed.1.1
                        public void onObClicked(View view, int i) {
                            AdLog.getInstance().sendAdClick(Loader4ObExpressDrawFeed.this.mAdKey, null, false, -1, null);
                            LG.d("AdLog-Loader4ObExpressDrawFeed", "ob draw ad clicked");
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, Loader4ObExpressDrawFeed.this.mAdKey.getCodeId());
                                map.put("request_id", OppoObUtils.getAdRequestId(tTNativeExpressOb));
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4ObExpressDrawFeed.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdClicked(map);
                                }
                            }
                        }

                        public void onObShow(View view, int i) {
                            AdLog.getInstance().sendAdShow(Loader4ObExpressDrawFeed.this.mAdKey, null, false, -1);
                            LG.d("AdLog-Loader4ObExpressDrawFeed", "ob draw ad show");
                            if (AdManager.inst().mAdListenerMap != null) {
                                HashMap map = new HashMap();
                                map.put(IDJXAd.AD_CODE_ID, Loader4ObExpressDrawFeed.this.mAdKey.getCodeId());
                                map.put("request_id", OppoObUtils.getAdRequestId(tTNativeExpressOb));
                                Map map2 = mediaExtraInfo;
                                if (map2 != null) {
                                    map.putAll(map2);
                                }
                                IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4ObExpressDrawFeed.this.mAdKey.getParamsCode()));
                                if (iDJXAdListener != null) {
                                    iDJXAdListener.onDJXAdShow(map);
                                }
                            }
                        }

                        public void onRenderFail(View view, String str, int i) {
                            LG.d("AdLog-Loader4ObExpressDrawFeed", "ob draw ad render fail code = " + i + ", msg = " + str);
                        }

                        public void onRenderSuccess(View view, float f, float f2) {
                            LG.d("AdLog-Loader4ObExpressDrawFeed", "ob draw ad render success");
                        }
                    });
                    tTNativeExpressOb.render();
                }
                if (AdManager.inst().mAdListenerMap != null) {
                    HashMap map = new HashMap();
                    map.put(IDJXAd.AD_CODE_ID, Loader4ObExpressDrawFeed.this.mAdKey.getCodeId());
                    map.put(PointParamKey.AD_COUNT, Integer.valueOf(list.size()));
                    map.put("request_id", Loader4ObExpressDrawFeed.this.mRequestId);
                    IDJXAdListener iDJXAdListener = AdManager.inst().mAdListenerMap.get(Integer.valueOf(Loader4ObExpressDrawFeed.this.mAdKey.getParamsCode()));
                    if (iDJXAdListener != null) {
                        iDJXAdListener.onDJXAdRequestSuccess(map);
                    }
                }
                BEAdCome.build().setCodeId(Loader4ObExpressDrawFeed.this.mAdKey.getCodeId()).send();
            }
        });
    }
}

package com.alliance.ssp.adapter.tobid.custom;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.alliance.ssp.ad.api.expressfeed.SAExpressFeedAd;
import com.alliance.ssp.ad.api.expressfeed.SAExpressFeedAdInteractionListener;
import com.alliance.ssp.ad.api.expressfeed.SAExpressFeedAdVideoListener;
import com.alliance.ssp.adapter.tobid.utils.YThreadUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.base.WMAdapterError;
import com.windmill.sdk.custom.WMCustomNativeAdapter;
import com.windmill.sdk.natives.WMImage;
import com.windmill.sdk.natives.WMNativeAdContainer;
import com.windmill.sdk.natives.WMNativeAdData;
import com.windmill.sdk.natives.WMNativeAdRender;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class YExpressAd extends WMNativeAdData {
    private static final String TAG = "YExpressAd";
    private Activity activity;
    private WMCustomNativeAdapter adAdapter;
    private WMNativeAdData adDate = this;
    private WMNativeAdData.DislikeInteractionCallback dislikeInteractionCallback;
    private SAExpressFeedAd expressFeedAd;
    private View expressView;

    public void bindImageViews(Context context, List<ImageView> list, int i) {
    }

    public void bindMediaView(Context context, ViewGroup viewGroup) {
    }

    public void bindViewForInteraction(Context context, View view, List<View> list, List<View> list2, View view2) {
    }

    public void connectAdToView(Activity activity, WMNativeAdContainer wMNativeAdContainer, WMNativeAdRender wMNativeAdRender) {
    }

    public Bitmap getAdLogo() {
        return null;
    }

    public int getAdPatternType() {
        return 0;
    }

    public String getCTAText() {
        return null;
    }

    public String getDesc() {
        return null;
    }

    public String getIconUrl() {
        return null;
    }

    public List<WMImage> getImageList() {
        return null;
    }

    public List<String> getImageUrlList() {
        return null;
    }

    public int getInteractionType() {
        return 0;
    }

    public String getTitle() {
        return null;
    }

    public boolean isExpressAd() {
        return true;
    }

    public boolean isNativeDrawAd() {
        return false;
    }

    public void setDownloadListener(WMNativeAdData.AppDownloadListener appDownloadListener) {
    }

    public YExpressAd(Activity activity, SAExpressFeedAd sAExpressFeedAd, WMCustomNativeAdapter wMCustomNativeAdapter) {
        this.activity = activity;
        this.adAdapter = wMCustomNativeAdapter;
        this.expressFeedAd = sAExpressFeedAd;
        if (sAExpressFeedAd == null) {
            Log.e(TAG, "expressFeedAd is null ！！！");
        }
    }

    public void setInteractionListener(final WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener) {
        this.expressFeedAd.setExpressFeedAdInteractionListener(new SAExpressFeedAdInteractionListener() { // from class: com.alliance.ssp.adapter.tobid.custom.YExpressAd.1
            @Override // com.alliance.ssp.ad.api.expressfeed.SAExpressFeedAdInteractionListener
            public void onAdClick() {
                Log.i(YExpressAd.TAG, IAdInterListener.AdCommandType.AD_CLICK);
                if (nativeAdInteractionListener != null && YExpressAd.this.adAdapter != null) {
                    nativeAdInteractionListener.onADClicked(YExpressAd.this.adAdapter.getAdInFo());
                }
                if (YExpressAd.this.adAdapter != null) {
                    YExpressAd.this.adAdapter.callNativeAdClick(YExpressAd.this.adDate);
                }
            }

            @Override // com.alliance.ssp.ad.api.expressfeed.SAExpressFeedAdInteractionListener
            public void onAdShow() {
                Log.i(YExpressAd.TAG, "onAdShow");
                if (nativeAdInteractionListener != null && YExpressAd.this.adAdapter != null) {
                    nativeAdInteractionListener.onADExposed(YExpressAd.this.adAdapter.getAdInFo());
                }
                if (YExpressAd.this.adAdapter != null) {
                    YExpressAd.this.adAdapter.callNativeAdShow(YExpressAd.this.adDate);
                }
            }

            @Override // com.alliance.ssp.ad.api.expressfeed.SAExpressFeedAdInteractionListener
            public void onAdClose() {
                Log.i(YExpressAd.TAG, "onAdClose");
                if (YExpressAd.this.dislikeInteractionCallback != null) {
                    YExpressAd.this.dislikeInteractionCallback.onSelected(0, "0", true);
                }
            }

            @Override // com.alliance.ssp.ad.api.expressfeed.SAExpressFeedAdInteractionListener
            public void onRenderFail(int i, String str) {
                Log.e(YExpressAd.TAG, "onRenderFail: code = " + i + ", msg = " + str);
                if (nativeAdInteractionListener != null && YExpressAd.this.adAdapter != null) {
                    WindMillError windMillError = WindMillError.ERROR_AD_ADAPTER_PLAY;
                    windMillError.setMessage("code : " + i + " msg : " + str);
                    nativeAdInteractionListener.onADError(YExpressAd.this.adAdapter.getAdInFo(), windMillError);
                }
                if (YExpressAd.this.adAdapter != null) {
                    YExpressAd.this.adAdapter.callNativeAdShowError(YExpressAd.this.adDate, new WMAdapterError(i, "onRenderFail:" + str));
                }
                YExpressAd.this.adAdapter.callLoadFail(new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), "onRenderFail: code = " + i + ", msg = " + str));
            }

            @Override // com.alliance.ssp.ad.api.expressfeed.SAExpressFeedAdInteractionListener
            public void onRenderSuccess(View view) {
                Log.i(YExpressAd.TAG, "onRenderSuccess");
                YExpressAd.this.expressView = view;
                if (nativeAdInteractionListener == null || YExpressAd.this.adAdapter == null) {
                    return;
                }
                nativeAdInteractionListener.onADRenderSuccess(YExpressAd.this.adAdapter.getAdInFo(), view, 0.0f, 0.0f);
            }
        });
    }

    public void setMediaListener(WMNativeAdData.NativeADMediaListener nativeADMediaListener) {
        this.expressFeedAd.setExpressFeedAdVideoListener(new SAExpressFeedAdVideoListener() { // from class: com.alliance.ssp.adapter.tobid.custom.YExpressAd.2
            @Override // com.alliance.ssp.ad.api.expressfeed.SAExpressFeedAdVideoListener
            public void onVideoResume() {
                Log.i(YExpressAd.TAG, "onVideoResume");
            }

            @Override // com.alliance.ssp.ad.api.BaseAdVideoListener
            public void onVideoError(int i, String str) {
                Log.e(YExpressAd.TAG, "onVideoError: code" + i + ", msg = " + str);
                YExpressAd.this.adAdapter.callNativeAdShowError(YExpressAd.this.adDate, new WMAdapterError(WindMillError.ERROR_AD_ADAPTER_PLAY.getErrorCode(), "onVideoError: code = " + i + ", msg = " + str));
            }

            @Override // com.alliance.ssp.ad.api.BaseAdVideoListener
            public void onVideoLoad() {
                Log.i(YExpressAd.TAG, "onVideoLoad");
            }

            @Override // com.alliance.ssp.ad.api.BaseAdVideoListener
            public void onVideoStartPlay() {
                Log.i(YExpressAd.TAG, "onVideoStartPlay");
            }

            @Override // com.alliance.ssp.ad.api.BaseAdVideoListener
            public void onVideoPause() {
                Log.i(YExpressAd.TAG, "onVideoPause");
            }

            @Override // com.alliance.ssp.ad.api.BaseAdVideoListener
            public void onVideoComplete() {
                Log.i(YExpressAd.TAG, "onVideoComplete");
            }
        });
    }

    public void setDislikeInteractionCallback(Activity activity, WMNativeAdData.DislikeInteractionCallback dislikeInteractionCallback) {
        this.dislikeInteractionCallback = dislikeInteractionCallback;
    }

    public View getExpressAdView() {
        return this.expressView;
    }

    public void render() {
        Log.i("Adapter", "express ad start render");
        YThreadUtils.runOnUIThread(new Runnable() { // from class: com.alliance.ssp.adapter.tobid.custom.YExpressAd$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m339lambda$render$0$comalliancesspadaptertobidcustomYExpressAd();
            }
        });
    }

    /* renamed from: lambda$render$0$com-alliance-ssp-adapter-tobid-custom-YExpressAd, reason: not valid java name */
    /* synthetic */ void m339lambda$render$0$comalliancesspadaptertobidcustomYExpressAd() {
        SAExpressFeedAd sAExpressFeedAd = this.expressFeedAd;
        if (sAExpressFeedAd != null) {
            sAExpressFeedAd.render();
        }
    }

    public void destroy() {
        YThreadUtils.runOnUIThread(new Runnable() { // from class: com.alliance.ssp.adapter.tobid.custom.YExpressAd$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m338xbd0840c0();
            }
        });
    }

    /* renamed from: lambda$destroy$1$com-alliance-ssp-adapter-tobid-custom-YExpressAd, reason: not valid java name */
    /* synthetic */ void m338xbd0840c0() {
        SAExpressFeedAd sAExpressFeedAd = this.expressFeedAd;
        if (sAExpressFeedAd != null) {
            sAExpressFeedAd.destroy();
            this.expressFeedAd = null;
        }
    }

    public int getNetworkId() {
        WMCustomNativeAdapter wMCustomNativeAdapter = this.adAdapter;
        if (wMCustomNativeAdapter != null) {
            return wMCustomNativeAdapter.getChannelId();
        }
        return 0;
    }
}

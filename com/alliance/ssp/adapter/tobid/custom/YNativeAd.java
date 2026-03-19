package com.alliance.ssp.adapter.tobid.custom;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.alliance.ssp.ad.api.NMNativeADEventListener;
import com.alliance.ssp.ad.api.NMPlayerView;
import com.alliance.ssp.ad.api.SAAllianceNativeFeedAdData;
import com.alliance.ssp.adapter.tobid.utils.YThreadUtils;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.custom.WMCustomNativeAdapter;
import com.windmill.sdk.natives.WMImage;
import com.windmill.sdk.natives.WMNativeAdContainer;
import com.windmill.sdk.natives.WMNativeAdData;
import com.windmill.sdk.natives.WMNativeAdRender;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class YNativeAd extends WMNativeAdData {
    private static final String TAG = "YNativeAd";
    private Activity activity;
    private WeakReference<Activity> activityWeakReference;
    private WMCustomNativeAdapter adAdapter;
    private WMNativeAdData adDate = this;
    private WMNativeAdData.NativeADMediaListener nativeADMediaListener;
    private WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener;
    private SAAllianceNativeFeedAdData saAllianceNativeFeedAdData;

    public void bindImageViews(Context context, List<ImageView> list, int i) {
    }

    public View getExpressAdView() {
        return null;
    }

    public List<WMImage> getImageList() {
        return null;
    }

    public boolean isExpressAd() {
        return false;
    }

    public boolean isNativeDrawAd() {
        return false;
    }

    public void render() {
    }

    public void setDislikeInteractionCallback(Activity activity, WMNativeAdData.DislikeInteractionCallback dislikeInteractionCallback) {
    }

    public void setDownloadListener(WMNativeAdData.AppDownloadListener appDownloadListener) {
    }

    public YNativeAd(Activity activity, SAAllianceNativeFeedAdData sAAllianceNativeFeedAdData, WMCustomNativeAdapter wMCustomNativeAdapter) {
        this.activity = activity;
        this.adAdapter = wMCustomNativeAdapter;
        this.saAllianceNativeFeedAdData = sAAllianceNativeFeedAdData;
    }

    public int getInteractionType() {
        SAAllianceNativeFeedAdData sAAllianceNativeFeedAdData = this.saAllianceNativeFeedAdData;
        if (sAAllianceNativeFeedAdData == null) {
            return 0;
        }
        int ldpType = sAAllianceNativeFeedAdData.getLdpType();
        if (ldpType != 0) {
            if (ldpType == 1) {
                return 1;
            }
            if (ldpType != 2) {
                return 0;
            }
        }
        return 2;
    }

    public int getAdPatternType() {
        SAAllianceNativeFeedAdData sAAllianceNativeFeedAdData = this.saAllianceNativeFeedAdData;
        int i = 0;
        if (sAAllianceNativeFeedAdData != null) {
            if (sAAllianceNativeFeedAdData.getVideoUrl() != null && !this.saAllianceNativeFeedAdData.getVideoUrl().isEmpty()) {
                return 4;
            }
            if (this.saAllianceNativeFeedAdData.getImgUrl() != null && !this.saAllianceNativeFeedAdData.getImgUrl().isEmpty()) {
                i = 2;
                if (this.saAllianceNativeFeedAdData.getImgUrl().size() >= 2) {
                    return 3;
                }
            }
        }
        return i;
    }

    public String getCTAText() {
        SAAllianceNativeFeedAdData sAAllianceNativeFeedAdData = this.saAllianceNativeFeedAdData;
        if (sAAllianceNativeFeedAdData == null) {
            return "";
        }
        int ldpType = sAAllianceNativeFeedAdData.getLdpType();
        return ldpType != 0 ? ldpType != 1 ? ldpType != 2 ? "" : "查看详情" : "立即下载" : "查看详情";
    }

    public String getTitle() {
        SAAllianceNativeFeedAdData sAAllianceNativeFeedAdData = this.saAllianceNativeFeedAdData;
        return sAAllianceNativeFeedAdData != null ? sAAllianceNativeFeedAdData.getTitle() : "";
    }

    public String getDesc() {
        SAAllianceNativeFeedAdData sAAllianceNativeFeedAdData = this.saAllianceNativeFeedAdData;
        return sAAllianceNativeFeedAdData != null ? sAAllianceNativeFeedAdData.getDesc() : "";
    }

    public Bitmap getAdLogo() {
        SAAllianceNativeFeedAdData sAAllianceNativeFeedAdData = this.saAllianceNativeFeedAdData;
        if (sAAllianceNativeFeedAdData != null) {
            return sAAllianceNativeFeedAdData.getLogoBitmap(this.activity);
        }
        return null;
    }

    public String getIconUrl() {
        SAAllianceNativeFeedAdData sAAllianceNativeFeedAdData = this.saAllianceNativeFeedAdData;
        return sAAllianceNativeFeedAdData != null ? sAAllianceNativeFeedAdData.getIconUrl() : "";
    }

    public int getNetworkId() {
        WMCustomNativeAdapter wMCustomNativeAdapter = this.adAdapter;
        if (wMCustomNativeAdapter != null) {
            return wMCustomNativeAdapter.getChannelId();
        }
        return 0;
    }

    public void connectAdToView(Activity activity, WMNativeAdContainer wMNativeAdContainer, WMNativeAdRender wMNativeAdRender) {
        this.activityWeakReference = new WeakReference<>(activity);
        if (wMNativeAdRender != null) {
            View viewCreateView = wMNativeAdRender.createView(activity, getAdPatternType());
            wMNativeAdRender.renderAdView(viewCreateView, this);
            if (wMNativeAdContainer != null) {
                wMNativeAdContainer.removeAllViews();
                wMNativeAdContainer.addView(viewCreateView, new ViewGroup.LayoutParams(-1, -2));
            }
        }
    }

    public List<String> getImageUrlList() {
        SAAllianceNativeFeedAdData sAAllianceNativeFeedAdData = this.saAllianceNativeFeedAdData;
        if (sAAllianceNativeFeedAdData != null) {
            return sAAllianceNativeFeedAdData.getImgUrl();
        }
        return null;
    }

    public void bindViewForInteraction(Context context, View view, List<View> list, List<View> list2, View view2) throws JSONException, PackageManager.NameNotFoundException, IOException {
        this.saAllianceNativeFeedAdData.registerPACAViews((Activity) context, view, (ArrayList) list, new NMNativeADEventListener() { // from class: com.alliance.ssp.adapter.tobid.custom.YNativeAd.1
            @Override // com.alliance.ssp.ad.api.NMNativeADEventListener
            public void onAdExposed() {
                if (YNativeAd.this.nativeAdInteractionListener != null) {
                    YNativeAd.this.nativeAdInteractionListener.onADExposed(YNativeAd.this.adAdapter.getAdInFo());
                }
                if (YNativeAd.this.adAdapter != null) {
                    YNativeAd.this.adAdapter.callNativeAdShow(YNativeAd.this.adDate);
                }
            }

            @Override // com.alliance.ssp.ad.api.NMNativeADEventListener
            public void onAdClicked() {
                if (YNativeAd.this.nativeAdInteractionListener != null) {
                    YNativeAd.this.nativeAdInteractionListener.onADClicked(YNativeAd.this.adAdapter.getAdInFo());
                }
                if (YNativeAd.this.adAdapter != null) {
                    YNativeAd.this.adAdapter.callNativeAdClick(YNativeAd.this.adDate);
                }
            }
        });
    }

    public void setInteractionListener(WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener) {
        if (nativeAdInteractionListener != null) {
            this.nativeAdInteractionListener = nativeAdInteractionListener;
        }
    }

    public void bindMediaView(Context context, ViewGroup viewGroup) throws JSONException, PackageManager.NameNotFoundException, IOException {
        NMPlayerView.NMAPAdNativeVideoViewListener nMAPAdNativeVideoViewListener = new NMPlayerView.NMAPAdNativeVideoViewListener() { // from class: com.alliance.ssp.adapter.tobid.custom.YNativeAd.2
            @Override // com.alliance.ssp.ad.api.NMPlayerView.NMAPAdNativeVideoViewListener
            public void onVideoLoading() {
                Log.i(YNativeAd.TAG, "onVideoLoading: ");
            }

            @Override // com.alliance.ssp.ad.api.NMPlayerView.NMAPAdNativeVideoViewListener
            public void onVideoReady() {
                Log.i(YNativeAd.TAG, "onVideoReady: ");
                if (YNativeAd.this.nativeADMediaListener != null) {
                    YNativeAd.this.nativeADMediaListener.onVideoLoad();
                }
            }

            @Override // com.alliance.ssp.ad.api.NMPlayerView.NMAPAdNativeVideoViewListener
            public void onVideoStart() {
                Log.i(YNativeAd.TAG, "onVideoStart: ");
                if (YNativeAd.this.nativeADMediaListener != null) {
                    YNativeAd.this.nativeADMediaListener.onVideoStart();
                }
            }

            @Override // com.alliance.ssp.ad.api.NMPlayerView.NMAPAdNativeVideoViewListener
            public void onVideoPause() {
                Log.i(YNativeAd.TAG, "onVideoPause: ");
                if (YNativeAd.this.nativeADMediaListener != null) {
                    YNativeAd.this.nativeADMediaListener.onVideoPause();
                }
            }

            @Override // com.alliance.ssp.ad.api.NMPlayerView.NMAPAdNativeVideoViewListener
            public void onVideoResume() {
                Log.i(YNativeAd.TAG, "onVideoResume: ");
                if (YNativeAd.this.nativeADMediaListener != null) {
                    YNativeAd.this.nativeADMediaListener.onVideoResume();
                }
            }

            @Override // com.alliance.ssp.ad.api.NMPlayerView.NMAPAdNativeVideoViewListener
            public void onVideoCompleted() {
                Log.i(YNativeAd.TAG, "onVideoCompleted: ");
                if (YNativeAd.this.nativeADMediaListener != null) {
                    YNativeAd.this.nativeADMediaListener.onVideoCompleted();
                }
            }

            @Override // com.alliance.ssp.ad.api.NMPlayerView.NMAPAdNativeVideoViewListener
            public void onVideoStop() {
                Log.i(YNativeAd.TAG, "onVideoStop: ");
            }

            @Override // com.alliance.ssp.ad.api.NMPlayerView.NMAPAdNativeVideoViewListener
            public void onVideoError(int i) {
                Log.i(YNativeAd.TAG, "onVideoError: ");
                if (YNativeAd.this.nativeADMediaListener != null) {
                    YNativeAd.this.nativeADMediaListener.onVideoError(WindMillError.ERROR_AD_ADAPTER_PLAY);
                }
            }
        };
        NMPlayerView nmApAdVideo = this.saAllianceNativeFeedAdData.getNmApAdVideo(this.activity);
        if (nmApAdVideo != null) {
            nmApAdVideo.setNMApAdNativeVideoviewListener(nMAPAdNativeVideoViewListener);
        }
    }

    public void setMediaListener(WMNativeAdData.NativeADMediaListener nativeADMediaListener) {
        if (nativeADMediaListener != null) {
            this.nativeADMediaListener = nativeADMediaListener;
        }
    }

    public void destroy() {
        YThreadUtils.runOnUIThread(new Runnable() { // from class: com.alliance.ssp.adapter.tobid.custom.YNativeAd$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m340lambda$destroy$0$comalliancesspadaptertobidcustomYNativeAd();
            }
        });
    }

    /* renamed from: lambda$destroy$0$com-alliance-ssp-adapter-tobid-custom-YNativeAd, reason: not valid java name */
    /* synthetic */ void m340lambda$destroy$0$comalliancesspadaptertobidcustomYNativeAd() {
        SAAllianceNativeFeedAdData sAAllianceNativeFeedAdData = this.saAllianceNativeFeedAdData;
        if (sAAllianceNativeFeedAdData != null) {
            sAAllianceNativeFeedAdData.destroy();
            this.saAllianceNativeFeedAdData = null;
        }
    }
}

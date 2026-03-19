package com.alliance.ssp.adapter.tobid.custom;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.alliance.ssp.ad.api.NMNativeADEventListener;
import com.alliance.ssp.ad.api.NMPlayerView;
import com.alliance.ssp.ad.api.SAAllianceNativeFeedAdData;
import com.alliance.ssp.ad.bean.Material;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class YTNativeAdData {
    private final WeakReference<Activity> activityWeakReference;
    private YTDownAppInfo appInfo;
    private final YTNativeADMediaMode feedAdMode;
    private boolean isDownloadType;
    private final SAAllianceNativeFeedAdData mFeedAdData;
    private InteractionListener mInteractionListener;
    private NMPlayerView playerView;
    private YTVideoInteractionListener videoInteractionListener;

    public interface InteractionListener {
        void onAdClick();

        void onAdError(int i, String str);

        void onAdShow();
    }

    public enum YTNativeADMediaMode {
        OneImage,
        GroupImage,
        Video,
        OnlyIcon
    }

    public interface YTVideoInteractionListener {
        void yt_videoDidPause();

        void yt_videoDidPlay();

        void yt_videoDidStop();

        void yt_videoPlayError(String str);
    }

    public String getAdLogoUrl() {
        return null;
    }

    public YTNativeAdData(SAAllianceNativeFeedAdData sAAllianceNativeFeedAdData, Activity activity) {
        YTNativeADMediaMode yTNativeADMediaMode;
        YTNativeADMediaMode yTNativeADMediaMode2;
        this.mFeedAdData = sAAllianceNativeFeedAdData;
        this.activityWeakReference = new WeakReference<>(activity);
        Material material = sAAllianceNativeFeedAdData.getMaterial();
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(material.getVideourl())) {
            yTNativeADMediaMode = YTNativeADMediaMode.Video;
        } else {
            if (material.getImgurl() != null && material.getImgurl().size() > 1) {
                yTNativeADMediaMode2 = YTNativeADMediaMode.GroupImage;
                arrayList.addAll(material.getImgurl());
            } else if (material.getImgurl() != null && material.getImgurl().size() == 1) {
                yTNativeADMediaMode2 = YTNativeADMediaMode.OneImage;
                arrayList.addAll(material.getImgurl());
            } else {
                yTNativeADMediaMode = YTNativeADMediaMode.OnlyIcon;
            }
            yTNativeADMediaMode = yTNativeADMediaMode2;
        }
        this.feedAdMode = yTNativeADMediaMode;
        this.isDownloadType = false;
        if (sAAllianceNativeFeedAdData.getLdpType() == 1) {
            this.isDownloadType = true;
            this.appInfo = new YTDownAppInfo(sAAllianceNativeFeedAdData.getApkName(), sAAllianceNativeFeedAdData.getIconUrl(), "1", null, sAAllianceNativeFeedAdData.getAppPublisher(), sAAllianceNativeFeedAdData.getPrivacyUrl(), sAAllianceNativeFeedAdData.getVersionName(), sAAllianceNativeFeedAdData.getPermissionUrl(), sAAllianceNativeFeedAdData.getAppIntro());
        }
    }

    public void setInteractionListener(InteractionListener interactionListener) {
        this.mInteractionListener = interactionListener;
    }

    public void bindAdToView(ViewGroup viewGroup, ImageView imageView, ImageView imageView2, List<View> list, List<View> list2, View view, ViewGroup viewGroup2, List<ImageView> list3, InteractionListener interactionListener) throws JSONException, PackageManager.NameNotFoundException, IOException {
        setInteractionListener(interactionListener);
        this.mFeedAdData.registerPACAViews(this.activityWeakReference.get(), viewGroup, new ArrayList<>(list), new NMNativeADEventListener() { // from class: com.alliance.ssp.adapter.tobid.custom.YTNativeAdData.1
            @Override // com.alliance.ssp.ad.api.NMNativeADEventListener
            public void onAdExposed() {
                if (YTNativeAdData.this.mInteractionListener != null) {
                    YTNativeAdData.this.mInteractionListener.onAdShow();
                }
            }

            @Override // com.alliance.ssp.ad.api.NMNativeADEventListener
            public void onAdClicked() {
                if (YTNativeAdData.this.mInteractionListener != null) {
                    YTNativeAdData.this.mInteractionListener.onAdClick();
                }
            }
        });
        if (this.feedAdMode == YTNativeADMediaMode.Video) {
            registerMediaContainer(viewGroup2);
        }
    }

    void registerMediaContainer(ViewGroup viewGroup) throws JSONException, PackageManager.NameNotFoundException, IOException {
        NMPlayerView nmApAdVideo = this.mFeedAdData.getNmApAdVideo(this.activityWeakReference.get());
        this.playerView = nmApAdVideo;
        if (nmApAdVideo == null) {
            return;
        }
        nmApAdVideo.setVideoMute(true);
        viewGroup.removeAllViews();
        this.playerView.showVideo(viewGroup);
        this.playerView.setNMApAdNativeVideoviewListener(new NMPlayerView.NMAPAdNativeVideoViewListener() { // from class: com.alliance.ssp.adapter.tobid.custom.YTNativeAdData.2
            @Override // com.alliance.ssp.ad.api.NMPlayerView.NMAPAdNativeVideoViewListener
            public void onVideoLoading() {
            }

            @Override // com.alliance.ssp.ad.api.NMPlayerView.NMAPAdNativeVideoViewListener
            public void onVideoReady() {
            }

            @Override // com.alliance.ssp.ad.api.NMPlayerView.NMAPAdNativeVideoViewListener
            public void onVideoStart() {
                if (YTNativeAdData.this.videoInteractionListener != null) {
                    YTNativeAdData.this.videoInteractionListener.yt_videoDidPlay();
                }
            }

            @Override // com.alliance.ssp.ad.api.NMPlayerView.NMAPAdNativeVideoViewListener
            public void onVideoPause() {
                if (YTNativeAdData.this.videoInteractionListener != null) {
                    YTNativeAdData.this.videoInteractionListener.yt_videoDidPause();
                }
            }

            @Override // com.alliance.ssp.ad.api.NMPlayerView.NMAPAdNativeVideoViewListener
            public void onVideoResume() {
                if (YTNativeAdData.this.videoInteractionListener != null) {
                    YTNativeAdData.this.videoInteractionListener.yt_videoDidPlay();
                }
            }

            @Override // com.alliance.ssp.ad.api.NMPlayerView.NMAPAdNativeVideoViewListener
            public void onVideoCompleted() {
                if (YTNativeAdData.this.videoInteractionListener != null) {
                    YTNativeAdData.this.videoInteractionListener.yt_videoDidStop();
                }
            }

            @Override // com.alliance.ssp.ad.api.NMPlayerView.NMAPAdNativeVideoViewListener
            public void onVideoStop() {
                if (YTNativeAdData.this.videoInteractionListener != null) {
                    YTNativeAdData.this.videoInteractionListener.yt_videoDidStop();
                }
            }

            @Override // com.alliance.ssp.ad.api.NMPlayerView.NMAPAdNativeVideoViewListener
            public void onVideoError(int i) {
                if (YTNativeAdData.this.videoInteractionListener != null) {
                    YTNativeAdData.this.videoInteractionListener.yt_videoPlayError("play error");
                }
            }
        });
    }

    public YTNativeADMediaMode getFeedAdMode() {
        return this.feedAdMode;
    }

    public String getTitle() {
        return this.mFeedAdData.getTitle();
    }

    public String getDescription() {
        return this.mFeedAdData.getDesc();
    }

    public Bitmap getAdLogo() {
        return this.mFeedAdData.getLogoBitmapNoText(this.activityWeakReference.get());
    }

    public YTDownAppInfo getDownAppInfo() {
        return this.appInfo;
    }

    public String getIconUrl() {
        return this.mFeedAdData.getIconUrl();
    }

    public List<String> getImageList() {
        return this.mFeedAdData.getImgUrl();
    }

    public boolean isDownAPPAd() {
        return this.isDownloadType;
    }

    public void setSAVideoInteractionListener(YTVideoInteractionListener yTVideoInteractionListener) {
        this.videoInteractionListener = yTVideoInteractionListener;
    }
}

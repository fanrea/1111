package com.bytedance.sdk.djx.core.business.ad;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.djx.model.Feed;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface IDJXAd {
    public static final String AD_CODE_ID = "ad_id";
    public static final String AD_REQUEST_ID = "request_id";
    public static final String AD_UNIQUE_ID = "ad_unique_id";
    public static final int OB_AD_TYPE_EXPRESS = 3;
    public static final int OB_AD_TYPE_FEED = 4;
    public static final int OPEN_AD_TYPE_DRAW_FEED = 7;
    public static final int OPEN_AD_TYPE_EXPRESS = 1;
    public static final int OPEN_AD_TYPE_FEED = 2;
    public static final int VF_AD_TYPE_DRAW_FEED = 8;
    public static final int VF_AD_TYPE_EXPRESS = 5;
    public static final int VF_AD_TYPE_FEED = 6;

    public interface AdExpressInteractionListener extends AdInteractionListener {
        void onAdDismiss();

        void onRenderFail(IDJXAd iDJXAd, String str, int i);

        void onRenderSuccess(IDJXAd iDJXAd, float f, float f2);
    }

    public interface AdInteractionListener {
        void onAdClicked(View view, IDJXAd iDJXAd);

        void onAdCreativeClick(View view, IDJXAd iDJXAd);

        void onAdShow(IDJXAd iDJXAd);
    }

    public interface CustomVideo {
        String getVideoUrl();

        void reportVideoAutoStart();

        void reportVideoBreak(long j);

        void reportVideoContinue(long j);

        void reportVideoError(long j, int i, int i2);

        void reportVideoFinish();

        void reportVideoPause(long j);

        void reportVideoStart();

        void reportVideoStartError(int i, int i2);
    }

    public interface DislikeInteractionCallback {
        void onCancel();

        void onRefuse();

        void onSelected(int i, String str);

        void onShow();
    }

    public interface DrawVideoListener {
        void onClick();

        void onClickRetry();
    }

    public interface ExpressVideoAdListener {
        void onClickRetry();

        void onProgressUpdate(long j, long j2);

        void onVideoAdComplete(long j);

        void onVideoAdContinuePlay();

        void onVideoAdPaused(long j, long j2);

        void onVideoAdStartPlay();

        void onVideoError(int i, int i2);

        void onVideoLoad();
    }

    public interface FullVideoListener {
        void onAdClose(IDJXAd iDJXAd);

        void onAdShow(IDJXAd iDJXAd);

        void onAdVideoBarClick(IDJXAd iDJXAd);

        void onSkippedVideo(IDJXAd iDJXAd);

        void onVideoComplete(IDJXAd iDJXAd);
    }

    public interface Image {
        int getHeight();

        String getUrl();

        int getWidth();
    }

    public interface RewardVideoListener extends AdInteractionListener, ExpressVideoAdListener {
        void onRewardVerify(boolean z, int i, String str, int i2, String str2);

        void onSkippedVideo();
    }

    public interface VideoAdListener {
        void onProgressUpdate(long j, long j2);

        void onVideoAdComplete(IDJXAd iDJXAd, long j);

        void onVideoAdContinuePlay(IDJXAd iDJXAd);

        void onVideoAdPaused(IDJXAd iDJXAd, long j, long j2);

        void onVideoAdStartPlay(IDJXAd iDJXAd);

        void onVideoError(int i, int i2);

        void onVideoLoad(IDJXAd iDJXAd);
    }

    void destroy();

    void dismissByReflect();

    long getAdCacheTime();

    AdComplianceInfo getAdComplianceInfo();

    Bitmap getAdLogo();

    int getAdTypeName();

    View getAdView();

    String getButtonText();

    String getCoverUrl();

    CustomVideo getCustomVideo();

    String getDescription();

    Feed getFeed();

    String getIcon();

    List<Image> getImageList();

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    String getRequestId();

    String getTitle();

    String getTitleOrAppName();

    long getVideoDuration();

    void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, AdInteractionListener adInteractionListener);

    void setDislikeCallback(Activity activity, DislikeInteractionCallback dislikeInteractionCallback);

    void setDrawVideoListener(DrawVideoListener drawVideoListener);

    void setExpressAdInteractionListener(AdExpressInteractionListener adExpressInteractionListener);

    void setExpressVideoAdListener(ExpressVideoAdListener expressVideoAdListener);

    void setFeed(Feed feed);

    void setFullVideoListener(FullVideoListener fullVideoListener);

    void setRewardVideoListener(RewardVideoListener rewardVideoListener);

    void setVideoAdListener(VideoAdListener videoAdListener);

    void show(Context context);

    void showDislikeDialog(Activity activity, DislikeInteractionCallback dislikeInteractionCallback);
}

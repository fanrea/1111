package com.kwad.sdk.api;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.tube.KSTubeChannelData;
import com.kwad.sdk.api.tube.detail.KSTubeEpisodeLoadListener;
import com.kwad.sdk.api.tube.log.KSTubeLog;
import com.kwad.sdk.api.tube.request.KSTubeLoadListener;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

@KsAdSdkApi
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface KsTubePage {

    @KsAdSdkApi
    @Retention(RetentionPolicy.SOURCE)
    public @interface DetailPageMode {
        public static final int ALL_EPISODE = 0;
        public static final int SINGLE_EPISODE = 1;
    }

    @KsAdSdkApi
    public interface InteractListener {
        boolean isNeedBlock(KsContentPage.ContentItem contentItem);

        void onTubeChannelClick(KSTubeChannelData kSTubeChannelData);

        void showAdIfNeeded(Activity activity, KsContentPage.ContentItem contentItem, RewardCallback rewardCallback);
    }

    @KsAdSdkApi
    @Retention(RetentionPolicy.SOURCE)
    public @interface NextStep {
        public static final int CLOSE_PAGE = 1;
        public static final int DEFAULT = 0;
        public static final int GO_BACK_LAST_VIDEO = 2;
    }

    @KsAdSdkApi
    public interface RewardCallback {
        void onRewardArrived();

        void onRewardFail(int i);
    }

    void destroy();

    Fragment getFragment();

    KsContentPage loadTubeContentPage(KSTubeChannelData kSTubeChannelData);

    boolean onBackPressed();

    void playSelectPage(int i);

    void reportKSTubeLog(KSTubeLog kSTubeLog);

    void requestTube(int i, int i2, KSTubeLoadListener kSTubeLoadListener);

    void requestTube(List<Long> list, KSTubeLoadListener kSTubeLoadListener);

    void requestTubeEpisode(KSTubeChannelData kSTubeChannelData, int i, KSTubeEpisodeLoadListener kSTubeEpisodeLoadListener);

    void requestTubeEpisodeNumList(KSTubeChannelData kSTubeChannelData, KSTubeEpisodeLoadListener kSTubeEpisodeLoadListener);

    void requestTubeHistory(int i, int i2, KSTubeLoadListener kSTubeLoadListener);

    void setPageInteractListener(InteractListener interactListener);

    void setPageListener(KsContentPage.PageListener pageListener);

    void setVideoListener(KsContentPage.VideoListener videoListener);
}

package com.kwad.sdk.api;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.tube.KSTubeData;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

@KsAdSdkApi
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface KsContentPage {

    @KsAdSdkApi
    public interface ExternalViewControlListener {
        void addView(ViewGroup viewGroup);

        void removeView(ViewGroup viewGroup);
    }

    @KsAdSdkApi
    public interface KsEcBtnClickListener {
        @KsAdSdkApi
        void onCurrentGoodCardClick(String str);

        @KsAdSdkApi
        void onGoShoppingBtnClick(String str);

        @KsAdSdkApi
        void onOpenKwaiBtnClick();
    }

    @KsAdSdkApi
    public interface KsPageLeaveClickListener {
        void onPageLeaveClick();
    }

    @KsAdSdkApi
    public interface KsShareListener {
        @KsAdSdkApi
        void onClickShareButton(String str);
    }

    @KsAdSdkApi
    public interface KsVideoBtnClickListener {
        @KsAdSdkApi
        void onAvatarClick(int i);

        @KsAdSdkApi
        void onClickLikeBtn(int i, boolean z);

        @KsAdSdkApi
        void onCommentsClick(int i);
    }

    @KsAdSdkApi
    public interface OnPageLoadListener {
        @KsAdSdkApi
        void onLoadError(KsContentPage ksContentPage, String str);

        @KsAdSdkApi
        void onLoadFinish(KsContentPage ksContentPage, int i);

        @KsAdSdkApi
        void onLoadStart(KsContentPage ksContentPage, int i);
    }

    @KsAdSdkApi
    public interface PageListener {
        @KsAdSdkApi
        void onPageEnter(ContentItem contentItem);

        @KsAdSdkApi
        void onPageLeave(ContentItem contentItem);

        @KsAdSdkApi
        void onPagePause(ContentItem contentItem);

        @KsAdSdkApi
        void onPageResume(ContentItem contentItem);
    }

    @KsAdSdkApi
    public static abstract class SubShowItem {
        @KsAdSdkApi
        public abstract int getItemViewType();

        @KsAdSdkApi
        public abstract View instantiateItem();

        public void onPageCreate() {
        }

        @KsAdSdkApi
        public void onPageDestroy() {
        }

        @KsAdSdkApi
        public void onPagePause() {
        }

        @KsAdSdkApi
        public void onPageResume() {
        }

        @KsAdSdkApi
        public void onPageVisibleChange(boolean z) {
        }
    }

    @KsAdSdkApi
    public interface VideoListener {
        @KsAdSdkApi
        void onVideoPlayCompleted(ContentItem contentItem);

        @KsAdSdkApi
        void onVideoPlayError(ContentItem contentItem, int i, int i2);

        @KsAdSdkApi
        void onVideoPlayPaused(ContentItem contentItem);

        @KsAdSdkApi
        void onVideoPlayResume(ContentItem contentItem);

        @KsAdSdkApi
        void onVideoPlayStart(ContentItem contentItem);
    }

    @KsAdSdkApi
    void addPageLoadListener(OnPageLoadListener onPageLoadListener);

    @KsAdSdkApi
    void addSubItem(List<SubShowItem> list);

    @KsAdSdkApi
    Fragment getFragment();

    @KsAdSdkApi
    int getSubCountInPage();

    @KsAdSdkApi
    boolean onBackPressed();

    @KsAdSdkApi
    boolean onPageLeaveIntercept(KsPageLeaveClickListener ksPageLeaveClickListener);

    @KsAdSdkApi
    void refreshBySchema(String str);

    @KsAdSdkApi
    void setAddSubEnable(boolean z);

    @KsAdSdkApi
    void setEcBtnClickListener(KsEcBtnClickListener ksEcBtnClickListener);

    @KsAdSdkApi
    void setExternalViewControlListener(ExternalViewControlListener externalViewControlListener);

    @KsAdSdkApi
    void setPageListener(PageListener pageListener);

    @KsAdSdkApi
    void setShareListener(KsShareListener ksShareListener);

    @KsAdSdkApi
    void setVideoBtnClickListener(KsVideoBtnClickListener ksVideoBtnClickListener);

    @KsAdSdkApi
    void setVideoListener(VideoListener videoListener);

    @KsAdSdkApi
    void tryToRefresh();

    @KsAdSdkApi
    public static class ContentItem {
        public String id;
        public int materialType = 0;
        public int position;
        public KSTubeData tubeData;
        public long videoDuration;

        @KsAdSdkApi
        @Retention(RetentionPolicy.SOURCE)
        public @interface MaterialType {
            public static final int AD = 2;
            public static final int CONTENT = 1;
            public static final int LIVE = 4;
            public static final int THIRD_AD = 3;
            public static final int UNKNOWN = 0;
        }

        public String toString() {
            return "ContentItem{id='" + this.id + "', position=" + this.position + ", materialType=" + this.materialType + ", videoDuration=" + this.videoDuration + ", tubeData=" + this.tubeData + '}';
        }
    }
}

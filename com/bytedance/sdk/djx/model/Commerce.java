package com.bytedance.sdk.djx.model;

import com.alipay.sdk.m.u.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class Commerce {
    private int mAdExpire;
    private int mAdMode;
    private int mAdModeNews;
    private AdSort mAdSort;
    private int mAdVideoPlayer;
    private int mAdRenderMethod = 2;
    private int mAdCoverShow = 1;
    private int mAdCoverPlayMode = 0;
    private int mAdCoverShowTime = 2;
    private int mInterstitialAwake = -1;
    private int mInterstitialPostAwake = -1;
    private int mNewsInsertAwake = -1;
    private int mAdHalfScreenInterstitialAwake = -1;
    private int mAdFullScreenInterstitialAwake = -1;
    private int mNewsInsertLoopEnable = 1;
    private int mNewsInsertLoopSec = 60;
    private int mDrawAdExpress = 1;
    private int mDrawAdCardExpress = 1;
    private int mVideoBannerLocation = 0;
    private int mVideoBannerAwake = -1;
    private int mVideoBannerLoopDuration = 60;
    private int mVideoBannerCarousel = 30;
    private int mAdCardStyle = 0;
    private long mAdLearnMoreShow = 0;
    private long mAdLearnMoreHighlight = 7000;
    private long mAdMiniCardShow = 5000;
    private long mAdMiniCardHighlight = 7000;
    private long mAdLargeCardShow = 12000;
    private long mAdDurationLimit = 14000;
    private boolean mAdShakeCoverShow = false;
    private long mAdShakeCoverAppear = b.a;
    private long mAdShakeCoverDisappear = 5000;
    private int mAdShakeAccelerationThreshold = 16;
    private boolean mAdFullScreenClick = false;
    private boolean mDramaDrawCustomOpen = true;
    private boolean mBannerCustomBoxOpen = true;
    private boolean mBannerCustomDetailOpen = true;

    public boolean isBannerCustomBoxOpen() {
        return this.mBannerCustomBoxOpen;
    }

    public void setBannerCustomBoxOpen(boolean z) {
        this.mBannerCustomBoxOpen = z;
    }

    public boolean isBannerCustomDetailOpen() {
        return this.mBannerCustomDetailOpen;
    }

    public void setBannerCustomDetailOpen(boolean z) {
        this.mBannerCustomDetailOpen = z;
    }

    public boolean isDramaDrawCustomOpen() {
        return this.mDramaDrawCustomOpen;
    }

    public void setDramaDrawCustomOpen(boolean z) {
        this.mDramaDrawCustomOpen = z;
    }

    public int getDrawAdExpress() {
        return this.mDrawAdExpress;
    }

    public void setDrawAdExpress(int i) {
        this.mDrawAdExpress = i;
    }

    public int getDrawAdCardExpress() {
        return this.mDrawAdCardExpress;
    }

    public void setDrawAdCardExpress(int i) {
        this.mDrawAdCardExpress = i;
    }

    public int getNewsInsertAwake() {
        return this.mNewsInsertAwake;
    }

    public void setNewsInsertAwake(int i) {
        this.mNewsInsertAwake = i;
    }

    public int getNewsInsertLoopEnable() {
        return this.mNewsInsertLoopEnable;
    }

    public void setNewsInsertLoopEnable(int i) {
        this.mNewsInsertLoopEnable = i;
    }

    public int getNewsInsertLoopSec() {
        return this.mNewsInsertLoopSec;
    }

    public void setNewsInsertLoopSec(int i) {
        this.mNewsInsertLoopSec = i;
    }

    public int getInterstitialAwake() {
        return this.mInterstitialAwake;
    }

    public void setInterstitialAwake(int i) {
        this.mInterstitialAwake = i;
    }

    public int getInterstitialPostAwake() {
        return this.mInterstitialPostAwake;
    }

    public void setInterstitialPostAwake(int i) {
        this.mInterstitialPostAwake = i;
    }

    public int getAdCoverShow() {
        return this.mAdCoverShow;
    }

    public void setAdCoverShow(int i) {
        this.mAdCoverShow = i;
    }

    public int getAdCoverPlayMode() {
        return this.mAdCoverPlayMode;
    }

    public void setAdCoverPlayMode(int i) {
        this.mAdCoverPlayMode = i;
    }

    public int getAdCoverShowTime() {
        return this.mAdCoverShowTime;
    }

    public void setAdCoverShowTime(int i) {
        this.mAdCoverShowTime = i;
    }

    public int getAdExpire() {
        return this.mAdExpire;
    }

    public void setAdExpire(int i) {
        this.mAdExpire = i;
    }

    public AdSort getAdSort() {
        return this.mAdSort;
    }

    public void setAdSort(AdSort adSort) {
        this.mAdSort = adSort;
    }

    public int getAdMode() {
        return this.mAdMode;
    }

    public void setAdMode(int i) {
        this.mAdMode = i;
    }

    public int getAdModeNews() {
        return this.mAdModeNews;
    }

    public void setAdModeNews(int i) {
        this.mAdModeNews = i;
    }

    public int getAdVideoPlayer() {
        return this.mAdVideoPlayer;
    }

    public void setAdVideoPlayer(int i) {
        this.mAdVideoPlayer = i;
    }

    public int getAdRenderMethod() {
        return this.mAdRenderMethod;
    }

    public void setAdRenderMethod(int i) {
        this.mAdRenderMethod = i;
    }

    public int getVideoBannerAdLocation() {
        return this.mVideoBannerLocation;
    }

    public void setVideoBannerAdLocation(int i) {
        this.mVideoBannerLocation = i;
    }

    public int getVideoBannerAdAwake() {
        return this.mVideoBannerAwake;
    }

    public void setVideoBannerAdAwake(int i) {
        this.mVideoBannerAwake = i;
    }

    public int getVideoBannerAdLoopDuration() {
        return this.mVideoBannerLoopDuration;
    }

    public void setVideoBannerAdLoopDuration(int i) {
        this.mVideoBannerLoopDuration = i;
    }

    public int getVideoBannerAdCarousel() {
        return this.mVideoBannerCarousel;
    }

    public void setVideoBannerAdCarousel(int i) {
        this.mVideoBannerCarousel = i;
    }

    public int getAdHalfScreenInterstitialAwake() {
        return this.mAdHalfScreenInterstitialAwake;
    }

    public void setAdHalfScreenInterstitialAwake(int i) {
        this.mAdHalfScreenInterstitialAwake = i;
    }

    public int getAdFullScreenInterstitialAwake() {
        return this.mAdFullScreenInterstitialAwake;
    }

    public void setAdFullScreenInterstitialAwake(int i) {
        this.mAdFullScreenInterstitialAwake = i;
    }

    public int getAdCardStyle() {
        return this.mAdCardStyle;
    }

    public void setAdCardStyle(int i) {
        this.mAdCardStyle = i;
    }

    public long getAdLearnMoreShow() {
        return this.mAdLearnMoreShow;
    }

    public long getAdLearnMoreHighlight() {
        return this.mAdLearnMoreHighlight;
    }

    public void setAdLearnMoreHighlight(long j) {
        this.mAdLearnMoreHighlight = j;
    }

    public void setAdLearnMoreShow(long j) {
        this.mAdLearnMoreShow = j;
    }

    public long getAdMiniCardShow() {
        return this.mAdMiniCardShow;
    }

    public void setAdMiniCardShow(long j) {
        this.mAdMiniCardShow = j;
    }

    public long getAdMiniCardHighlight() {
        return this.mAdMiniCardHighlight;
    }

    public void setAdMiniCardHighlight(long j) {
        this.mAdMiniCardHighlight = j;
    }

    public long getAdLargeCardShow() {
        return this.mAdLargeCardShow;
    }

    public void setAdLargeCardShow(long j) {
        this.mAdLargeCardShow = j;
    }

    public long getAdDurationLimit() {
        return this.mAdDurationLimit;
    }

    public void setAdDurationLimit(long j) {
        this.mAdDurationLimit = j;
    }

    public boolean isAdShakeCoverShow() {
        return this.mAdShakeCoverShow;
    }

    public void setAdShakeCoverShow(boolean z) {
        this.mAdShakeCoverShow = z;
    }

    public long getAdShakeCoverAppear() {
        return this.mAdShakeCoverAppear;
    }

    public void setAdShakeCoverAppear(long j) {
        this.mAdShakeCoverAppear = j;
    }

    public long getAdShakeCoverDisappear() {
        return this.mAdShakeCoverDisappear;
    }

    public void setAdShakeCoverDisappear(long j) {
        this.mAdShakeCoverDisappear = j;
    }

    public int getAdShakeAccelerationThreshold() {
        return this.mAdShakeAccelerationThreshold;
    }

    public void setAdShakeAccelerationThreshold(int i) {
        this.mAdShakeAccelerationThreshold = i;
    }

    public boolean isAdFullScreenClick() {
        return this.mAdFullScreenClick;
    }

    public void setAdFullScreenClick(boolean z) {
        this.mAdFullScreenClick = z;
    }

    public static class AdSort {
        private FeedImageMode feedImageMode;
        private ArticleDetailRelated mArticleDetailRelated;
        private VideoCard mVideoCard;
        private VideoDetailRelated mVideoDetailRelated;
        private News news;
        private Suduku suduku;
        private VideoDoubleFeed videoDoubleFeed;

        public FeedImageMode getFeedImageMode() {
            return this.feedImageMode;
        }

        public void setFeedImageMode(FeedImageMode feedImageMode) {
            this.feedImageMode = feedImageMode;
        }

        public Suduku getSuduku() {
            return this.suduku;
        }

        public void setSuduku(Suduku suduku) {
            this.suduku = suduku;
        }

        public VideoDoubleFeed getVideoDoubleFeed() {
            return this.videoDoubleFeed;
        }

        public void setVideoDoubleFeed(VideoDoubleFeed videoDoubleFeed) {
            this.videoDoubleFeed = videoDoubleFeed;
        }

        public News getNews() {
            return this.news;
        }

        public void setNews(News news) {
            this.news = news;
        }

        public VideoCard getVideoCard() {
            return this.mVideoCard;
        }

        public void setVideoCard(VideoCard videoCard) {
            this.mVideoCard = videoCard;
        }

        public VideoDetailRelated getVideoDetailRelated() {
            return this.mVideoDetailRelated;
        }

        public void setVideoDetailRelated(VideoDetailRelated videoDetailRelated) {
            this.mVideoDetailRelated = videoDetailRelated;
        }

        public ArticleDetailRelated getArticleDetailRelated() {
            return this.mArticleDetailRelated;
        }

        public void setArticleDetailRelated(ArticleDetailRelated articleDetailRelated) {
            this.mArticleDetailRelated = articleDetailRelated;
        }
    }

    public static class FeedImageMode {
        private int firstAdPos;
        private int followAdPos;
        private int followSep;

        public int getFirstAdPos() {
            return this.firstAdPos;
        }

        public void setFirstAdPos(int i) {
            this.firstAdPos = i;
        }

        public int getFollowSep() {
            return this.followSep;
        }

        public void setFollowSep(int i) {
            this.followSep = i;
        }

        public int getFollowAdPos() {
            return this.followAdPos;
        }

        public void setFollowAdPos(int i) {
            this.followAdPos = i;
        }
    }

    public static class Suduku {
        private int firstAdPos;
        private int followAdPos;
        private int followSep;

        public int getFirstAdPos() {
            return this.firstAdPos;
        }

        public void setFirstAdPos(int i) {
            this.firstAdPos = i;
        }

        public int getFollowSep() {
            return this.followSep;
        }

        public void setFollowSep(int i) {
            this.followSep = i;
        }

        public int getFollowAdPos() {
            return this.followAdPos;
        }

        public void setFollowAdPos(int i) {
            this.followAdPos = i;
        }
    }

    public static class VideoDoubleFeed {
        private int firstAdPos;
        private int followAdPos;
        private int followSep;

        public int getFirstAdPos() {
            return this.firstAdPos;
        }

        public void setFirstAdPos(int i) {
            this.firstAdPos = i;
        }

        public int getFollowSep() {
            return this.followSep;
        }

        public void setFollowSep(int i) {
            this.followSep = i;
        }

        public int getFollowAdPos() {
            return this.followAdPos;
        }

        public void setFollowAdPos(int i) {
            this.followAdPos = i;
        }
    }

    public static class News {
        private int firstAdPos;
        private int followAdPos;
        private int followSep;

        public int getFirstAdPos() {
            return this.firstAdPos;
        }

        public void setFirstAdPos(int i) {
            this.firstAdPos = i;
        }

        public int getFollowSep() {
            return this.followSep;
        }

        public void setFollowSep(int i) {
            this.followSep = i;
        }

        public int getFollowAdPos() {
            return this.followAdPos;
        }

        public void setFollowAdPos(int i) {
            this.followAdPos = i;
        }
    }

    public static class VideoCard {
        private int firstAdPos;
        private int followAdPos;
        private int followSep;

        public int getFirstAdPos() {
            return this.firstAdPos;
        }

        public void setFirstAdPos(int i) {
            this.firstAdPos = i;
        }

        public int getFollowSep() {
            return this.followSep;
        }

        public void setFollowSep(int i) {
            this.followSep = i;
        }

        public int getFollowAdPos() {
            return this.followAdPos;
        }

        public void setFollowAdPos(int i) {
            this.followAdPos = i;
        }
    }

    public static class VideoDetailRelated {
        private int firstAdPos;
        private int followAdPos;
        private int followSep;

        public int getFirstAdPos() {
            return this.firstAdPos;
        }

        public void setFirstAdPos(int i) {
            this.firstAdPos = i;
        }

        public int getFollowSep() {
            return this.followSep;
        }

        public void setFollowSep(int i) {
            this.followSep = i;
        }

        public int getFollowAdPos() {
            return this.followAdPos;
        }

        public void setFollowAdPos(int i) {
            this.followAdPos = i;
        }
    }

    public static class ArticleDetailRelated {
        private int firstAdPos;
        private int followAdPos;
        private int followSep;

        public int getFirstAdPos() {
            return this.firstAdPos;
        }

        public void setFirstAdPos(int i) {
            this.firstAdPos = i;
        }

        public int getFollowSep() {
            return this.followSep;
        }

        public void setFollowSep(int i) {
            this.followSep = i;
        }

        public int getFollowAdPos() {
            return this.followAdPos;
        }

        public void setFollowAdPos(int i) {
            this.followAdPos = i;
        }
    }
}

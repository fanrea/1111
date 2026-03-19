package com.bytedance.sdk.djx.core.api.req;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class FeedReqParams {
    public static final String REQ_TYPE_LOAD_MORE = "load_more";
    public static final String REQ_TYPE_OPEN = "open";
    public static final String REQ_TYPE_REFRESH = "refresh";
    public String mAdPreloadIds;
    public AdRefresh mAdRefresh;
    public String mAdToken;
    public String mAdTokenFullScreenInterstitial;
    public String mAdTokenHalfScreenInterstitial;
    public String mAdTokenPostIt;
    public boolean mCached;
    public String mCategory;
    public int mDramaFree;
    public int mDrawType;
    public float mHeight;
    public int mPlatformSource;
    public boolean mPreload;
    public String mPushGroupId;
    public int mRefreshCounter;
    public String mReqType;
    public long mRootGid;
    public int mRootGidPage;
    public String mSkipAdUnion;
    public long mTopDramaId;
    public String mUrgeStay;
    public float mWidth;

    public static FeedReqParams build(FeedReqParams feedReqParams) {
        return new FeedReqParams(feedReqParams);
    }

    public static FeedReqParams build() {
        return new FeedReqParams(null);
    }

    private FeedReqParams(FeedReqParams feedReqParams) {
        this.mPreload = false;
        this.mCached = false;
        this.mUrgeStay = "0";
        this.mDrawType = 1;
        this.mRefreshCounter = -1;
        this.mPlatformSource = 0;
        if (feedReqParams != null) {
            this.mCategory = feedReqParams.mCategory;
            this.mPreload = feedReqParams.mPreload;
            this.mReqType = feedReqParams.mReqType;
            this.mPushGroupId = feedReqParams.mPushGroupId;
            this.mAdToken = feedReqParams.mAdToken;
            this.mAdTokenHalfScreenInterstitial = feedReqParams.mAdTokenHalfScreenInterstitial;
            this.mAdTokenFullScreenInterstitial = feedReqParams.mAdTokenFullScreenInterstitial;
            this.mAdTokenPostIt = feedReqParams.mAdTokenPostIt;
            this.mAdPreloadIds = feedReqParams.mAdPreloadIds;
            this.mSkipAdUnion = feedReqParams.mSkipAdUnion;
            this.mCached = feedReqParams.mCached;
            this.mAdRefresh = feedReqParams.mAdRefresh;
            this.mUrgeStay = feedReqParams.mUrgeStay;
            this.mWidth = feedReqParams.mWidth;
            this.mHeight = feedReqParams.mHeight;
            this.mDrawType = feedReqParams.mDrawType;
            this.mRootGid = feedReqParams.mRootGid;
            this.mRootGidPage = feedReqParams.mRootGidPage;
            this.mRefreshCounter = feedReqParams.mRefreshCounter;
            this.mPlatformSource = feedReqParams.mPlatformSource;
            this.mDramaFree = feedReqParams.mDramaFree;
            this.mTopDramaId = feedReqParams.mTopDramaId;
        }
    }

    public FeedReqParams rootGid(long j, int i) {
        this.mRootGid = j;
        this.mRootGidPage = i;
        return this;
    }

    public FeedReqParams adRefresh(AdRefresh adRefresh) {
        this.mAdRefresh = adRefresh;
        return this;
    }

    public FeedReqParams category(String str) {
        this.mCategory = str;
        return this;
    }

    public FeedReqParams preload(boolean z) {
        this.mPreload = z;
        return this;
    }

    public FeedReqParams requestType(String str) {
        this.mReqType = str;
        return this;
    }

    public FeedReqParams pushGroupId(String str) {
        this.mPushGroupId = str;
        return this;
    }

    public FeedReqParams adToken(String str) {
        this.mAdToken = str;
        return this;
    }

    public FeedReqParams adTokenHalfScreenInterstitial(String str) {
        this.mAdTokenHalfScreenInterstitial = str;
        return this;
    }

    public FeedReqParams adTokenFullScreenInterstitial(String str) {
        this.mAdTokenFullScreenInterstitial = str;
        return this;
    }

    public FeedReqParams adTokenPostIt(String str) {
        this.mAdTokenPostIt = str;
        return this;
    }

    public FeedReqParams adPreloadIds(String str) {
        this.mAdPreloadIds = str;
        return this;
    }

    public FeedReqParams skipAdUnion(String str) {
        this.mSkipAdUnion = str;
        return this;
    }

    public FeedReqParams cached(boolean z) {
        this.mCached = z;
        return this;
    }

    public FeedReqParams urgeStay(String str) {
        this.mUrgeStay = str;
        return this;
    }

    public FeedReqParams width(float f) {
        this.mWidth = f;
        return this;
    }

    public FeedReqParams height(float f) {
        this.mHeight = f;
        return this;
    }

    public FeedReqParams drawType(int i) {
        this.mDrawType = i;
        return this;
    }

    public FeedReqParams platformSource(int i) {
        this.mPlatformSource = i;
        return this;
    }

    public FeedReqParams refreshCounter(int i) {
        this.mRefreshCounter = i;
        return this;
    }

    public FeedReqParams dramaFree(int i) {
        this.mDramaFree = i;
        return this;
    }

    public FeedReqParams topDramaId(long j) {
        this.mTopDramaId = j;
        return this;
    }

    public static class AdRefresh {
        public String mRefreshAdPos;
        public int mRefreshDataCount;
        public int mRefreshPage;
        public String mRefreshReqId;

        public AdRefresh(int i, String str, int i2, String str2) {
            this.mRefreshPage = i;
            this.mRefreshReqId = str;
            this.mRefreshDataCount = i2;
            this.mRefreshAdPos = str2;
        }
    }
}

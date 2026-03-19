package com.bytedance.sdk.djx.model;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class Feed {
    public static final int CELL_TYPE_AD = 1871;
    public static final int CELL_TYPE_DRAMA = 3202;
    public static final int IMAGE_BIG = 1;
    public static final int IMAGE_NO = 0;
    public static final int IMAGE_SMALL = 3;
    public static final int IMAGE_THREE = 2;
    public static final String STICK_PROTECT = "置顶保护";
    private String mAbstract;
    private String mAdId;
    private String mAdMeta;
    private float mAdRankScore;
    private Boolean mAdShakeCoverShow;
    private String mArticleUrl;
    private long mBehotTime;
    private int mBuryCount;
    private int mCategory;
    private String mCategoryName;
    private String mCid;
    private int mCommentCount;
    private String mCommentUrl;
    private List<Image> mCoverImages;
    private int mCoverMode;
    private int mDiggCount;
    private DramaDetail mDramaDetail;
    private String mExtra;
    private String mFirstFramePoster;
    private String mFromUserId;
    private int mFromUserType;
    private long mGroupId;
    private int mGroupSource;
    private boolean mHasVideo;
    private boolean mIsDelete;
    private boolean mIsFavor;
    private boolean mIsLike;
    private boolean mIsStick;
    private long mItemId;
    private String mLabel;
    private Music mMusic;
    private JSONObject mOriginal;
    private long mPublishTime;
    private String mReqId;
    private int mShareCount;
    private String mShareUrl;
    private String mSource;
    private String mTag;
    private int mTip;
    private String mTitle;
    private Video mVideo;
    private int mVideoDuration;
    private String mVideoId;
    private VideoM mVideoModel;
    private String mVideoSearchSuggestWord;
    private String mVideoSearchUrl;
    private long mVideoSize;
    private int mVideoWatchCount;
    private boolean mHasClickLike = false;
    private boolean mHasRead = false;
    private boolean mIsCachedVideo = false;
    private boolean mIsPreloadVideo = false;
    private boolean mIsOnlinePreload = false;
    private boolean mIsAuthorClick = false;
    private boolean mIsApiData = false;
    private boolean mIsAdInterRefresh = false;
    private boolean mHasShowArticleTip = false;
    private boolean mIsSplit = false;
    private int mRootGidPage = 0;
    private int mCellType = -1;
    private int mPlatformSource = 0;
    private int mAdType = 0;

    public Boolean getAdShakeCoverShow() {
        return this.mAdShakeCoverShow;
    }

    public void setAdShakeCoverShow(Boolean bool) {
        this.mAdShakeCoverShow = bool;
    }

    public boolean isSplit() {
        return this.mIsSplit;
    }

    public void setSplit(boolean z) {
        this.mIsSplit = z;
    }

    public int getRootGidPage() {
        return this.mRootGidPage;
    }

    public void setRootGidPage(int i) {
        this.mRootGidPage = i;
    }

    public String getFromUserId() {
        return this.mFromUserId;
    }

    public void setFromUserId(String str) {
        this.mFromUserId = str;
    }

    public int getFromUserType() {
        return this.mFromUserType;
    }

    public void setFromUserType(int i) {
        this.mFromUserType = i;
    }

    public String getReqId() {
        return this.mReqId;
    }

    public void setReqId(String str) {
        this.mReqId = str;
    }

    public boolean isAdInterRefresh() {
        return this.mIsAdInterRefresh;
    }

    public void setAdInterRefresh() {
        this.mIsAdInterRefresh = true;
    }

    public boolean isHasShowArticleTip() {
        return this.mHasShowArticleTip;
    }

    public void setHasShowArticleTip(boolean z) {
        this.mHasShowArticleTip = z;
    }

    public float getAdRankScore() {
        return this.mAdRankScore;
    }

    public void setAdRankScore(float f) {
        this.mAdRankScore = f;
    }

    public int getAdType() {
        return this.mAdType;
    }

    public boolean isInterstitialAd() {
        return this.mAdType == 2;
    }

    public boolean isHalfScreenInterstitialAd() {
        return this.mAdType == 4;
    }

    public boolean isFullScreenInterstitialAd() {
        return this.mAdType == 5;
    }

    public boolean isInterstitialPostAd() {
        return this.mAdType == 3;
    }

    public void setAdType(int i) {
        this.mAdType = i;
    }

    public Drama getDrama() {
        return this.mDramaDetail.getDrama();
    }

    public DramaDetail getDramaDetail() {
        return this.mDramaDetail;
    }

    public void setDramaDetail(DramaDetail dramaDetail) {
        this.mDramaDetail = dramaDetail;
    }

    public String getAdMeta() {
        return this.mAdMeta;
    }

    public void setAdMeta(String str) {
        this.mAdMeta = str;
    }

    public String getAdId() {
        return this.mAdId;
    }

    public void setAdId(String str) {
        this.mAdId = str;
    }

    public String getCid() {
        return this.mCid;
    }

    public void setCid(String str) {
        this.mCid = str;
    }

    public boolean isHasClickLike() {
        return this.mHasClickLike;
    }

    public void setHasClickLike(boolean z) {
        this.mHasClickLike = z;
    }

    public boolean isHasRead() {
        return this.mHasRead;
    }

    public void setHasRead(boolean z) {
        this.mHasRead = z;
    }

    public boolean isCachedVideo() {
        return this.mIsCachedVideo;
    }

    public void setCachedVideo(boolean z) {
        this.mIsCachedVideo = z;
    }

    public boolean isPreloadVideo() {
        return this.mIsPreloadVideo;
    }

    public void setPreloadVideo(boolean z) {
        this.mIsPreloadVideo = z;
    }

    public boolean isOnlinePreload() {
        return this.mIsOnlinePreload;
    }

    public void setOnlinePreload(boolean z) {
        this.mIsOnlinePreload = z;
    }

    public boolean isApiData() {
        return this.mIsApiData;
    }

    public void setApiData(boolean z) {
        this.mIsApiData = z;
    }

    public boolean isAuthorClick() {
        return this.mIsAuthorClick;
    }

    public void setAuthorClick(boolean z) {
        this.mIsAuthorClick = z;
    }

    public long getGroupId() {
        return this.mGroupId;
    }

    public void setGroupId(long j) {
        this.mGroupId = j;
    }

    public long getItemId() {
        return this.mItemId;
    }

    public void setItemId(long j) {
        this.mItemId = j;
    }

    public String getVideoId() {
        return this.mVideoId;
    }

    public void setVideoId(String str) {
        this.mVideoId = str;
    }

    public int getGroupSource() {
        return this.mGroupSource;
    }

    public void setGroupSource(int i) {
        this.mGroupSource = i;
    }

    public String getTag() {
        return this.mTag;
    }

    public void setTag(String str) {
        this.mTag = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String getSource() {
        return this.mSource;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public String getArticleUrl() {
        return this.mArticleUrl;
    }

    public void setArticleUrl(String str) {
        this.mArticleUrl = str;
    }

    public boolean isDelete() {
        return this.mIsDelete;
    }

    public void setDelete(boolean z) {
        this.mIsDelete = z;
    }

    public long getPublishTime() {
        return this.mPublishTime;
    }

    public void setPublishTime(long j) {
        this.mPublishTime = j;
    }

    public long getBehotTime() {
        return this.mBehotTime;
    }

    public void setBehotTime(long j) {
        this.mBehotTime = j;
    }

    public String getAbstract() {
        return this.mAbstract;
    }

    public void setAbstract(String str) {
        this.mAbstract = str;
    }

    public String getShareUrl() {
        return this.mShareUrl;
    }

    public void setShareUrl(String str) {
        this.mShareUrl = str;
    }

    public int getShareCount() {
        return this.mShareCount;
    }

    public void setShareCount(int i) {
        this.mShareCount = i;
    }

    public boolean isHasVideo() {
        return this.mHasVideo;
    }

    public void setHasVideo(boolean z) {
        this.mHasVideo = z;
    }

    public int getVideoWatchCount() {
        return this.mVideoWatchCount;
    }

    public void setVideoWatchCount(int i) {
        this.mVideoWatchCount = i;
    }

    public int getVideoDuration() {
        VideoM videoM = this.mVideoModel;
        if (videoM != null) {
            return Float.valueOf(videoM.getDuration()).intValue();
        }
        Video video = this.mVideo;
        if (video != null) {
            return Float.valueOf(video.getDuration()).intValue();
        }
        return this.mVideoDuration;
    }

    public void setVideoDuration(int i) {
        this.mVideoDuration = i;
    }

    public int getCategory() {
        return this.mCategory;
    }

    public void setCategory(int i) {
        this.mCategory = i;
    }

    public String getCategoryName() {
        return this.mCategoryName;
    }

    public void setCategoryName(String str) {
        this.mCategoryName = str;
    }

    public long getVideoSize() {
        VideoM videoM = this.mVideoModel;
        if (videoM == null || this.mVideoSize > 0) {
            return this.mVideoSize;
        }
        return videoM.getVideoSize();
    }

    public int getTip() {
        return this.mTip;
    }

    public void setTip(int i) {
        this.mTip = i;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public void setLabel(String str) {
        this.mLabel = str;
    }

    public int getDiggCount() {
        return this.mDiggCount;
    }

    public void setDiggCount(int i) {
        this.mDiggCount = i;
    }

    public int getBuryCount() {
        return this.mBuryCount;
    }

    public void setBuryCount(int i) {
        this.mBuryCount = i;
    }

    public int getCommentCount() {
        return this.mCommentCount;
    }

    public void setCommentCount(int i) {
        this.mCommentCount = i;
    }

    public String getCommentUrl() {
        return this.mCommentUrl;
    }

    public void setCommentUrl(String str) {
        this.mCommentUrl = str;
    }

    public int getCoverMode() {
        return this.mCoverMode;
    }

    public void setCoverMode(int i) {
        this.mCoverMode = i;
    }

    public List<Image> getCoverImages() {
        return this.mCoverImages;
    }

    public void setCoverImages(List<Image> list) {
        this.mCoverImages = list;
    }

    public void addCoverImage(Image image) {
        if (image != null) {
            if (this.mCoverImages == null) {
                this.mCoverImages = new ArrayList();
            }
            this.mCoverImages.add(image);
        }
    }

    public Video getVideo() {
        return this.mVideo;
    }

    public void setVideo(Video video) {
        this.mVideo = video;
    }

    public VideoM getVideoModel() {
        return this.mVideoModel;
    }

    public void setVideoModel(VideoM videoM) {
        this.mVideoModel = videoM;
    }

    public boolean hasMusic() {
        return getMusic() != null;
    }

    public Music getMusic() {
        return this.mMusic;
    }

    public void setMusic(Music music) {
        this.mMusic = music;
    }

    public String getFirstFramePoster() {
        return this.mFirstFramePoster;
    }

    public void setFirstFramePoster(String str) {
        this.mFirstFramePoster = str;
    }

    public int getCellType() {
        return this.mCellType;
    }

    public void setCellType(int i) {
        this.mCellType = i;
    }

    public String getVideoPoster() {
        String firstFramePoster = getFirstFramePoster();
        if (!TextUtils.isEmpty(firstFramePoster)) {
            return firstFramePoster;
        }
        if (TextUtils.isEmpty(firstFramePoster) && getVideo() != null) {
            firstFramePoster = getVideo().getPosterUrl();
        }
        if (TextUtils.isEmpty(firstFramePoster) && getCoverImages() != null) {
            for (Image image : getCoverImages()) {
                if (image != null) {
                    firstFramePoster = image.getUrl();
                }
                if (!TextUtils.isEmpty(firstFramePoster)) {
                    break;
                }
            }
        }
        return firstFramePoster;
    }

    public JSONObject getOriginal() {
        return this.mOriginal;
    }

    public void setOriginal(JSONObject jSONObject) {
        this.mOriginal = jSONObject;
    }

    public boolean isLike() {
        return this.mIsLike;
    }

    public void setLike(boolean z) {
        this.mIsLike = z;
    }

    public boolean isFavor() {
        return this.mIsFavor;
    }

    public void setFavor(boolean z) {
        this.mIsFavor = z;
    }

    public boolean isStick() {
        return this.mIsStick;
    }

    public void setStick(boolean z) {
        this.mIsStick = z;
    }

    public String getExtra() {
        return this.mExtra;
    }

    public void setExtra(String str) {
        this.mExtra = str;
    }

    public String getVideoSearchSuggestWord() {
        return this.mVideoSearchSuggestWord;
    }

    public void setVideoSearchSuggestWord(String str) {
        this.mVideoSearchSuggestWord = str;
    }

    public String getVideoSearchUrl() {
        return this.mVideoSearchUrl;
    }

    public void setVideoSearchUrl(String str) {
        this.mVideoSearchUrl = str;
    }

    public boolean isStickProtect() {
        return STICK_PROTECT.equals(this.mLabel);
    }

    public String getContentType() {
        return this.mHasVideo ? "video" : "text";
    }

    public void setPlatformSource(int i) {
        this.mPlatformSource = i;
    }

    public int getPlatformSource() {
        return this.mPlatformSource;
    }

    public String getRealCoverUrl() {
        String posterUrl = getVideo() != null ? getVideo().getPosterUrl() : null;
        return (posterUrl != null || getCoverImages() == null || getCoverImages().isEmpty()) ? posterUrl : getCoverImages().get(0).getUrl();
    }

    public boolean isType4Drama() {
        return getCellType() == 3202;
    }

    public boolean isType4Ad() {
        return getCellType() == 1871;
    }
}

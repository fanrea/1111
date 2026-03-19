package com.bytedance.sdk.djx.core.settings;

import com.baidu.mobads.container.components.j.a;
import com.bytedance.sdk.djx.model.Commerce;
import com.bytedance.sdk.djx.model.ContentCfg;
import com.bytedance.sdk.djx.model.FeaturesCfg;
import com.bytedance.sdk.djx.model.LogCfg;
import com.bytedance.sdk.djx.model.SettingCfg;
import com.bytedance.sdk.djx.model.VideoCfg;
import com.bytedance.sdk.djx.model.ev.BESettingUpdate;
import com.bytedance.sdk.djx.setting.OnSettingsUpdateListener;
import com.bytedance.sdk.djx.setting.SettingsHelper;
import com.bytedance.sdk.djx.utils.JSON;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class SettingData implements OnSettingsUpdateListener {
    private static final int AD_VIDEO_PLAYER = 1;
    private static final int DEFAULT_CACHE_EXPIRE_RANDOM_HOURS = 24;
    private static final int DEFAULT_RETRY_TIME_SEC = 3600;
    private static final long DEFAULT_SWITCH_CACHE_TIMEOUT = 3000;
    private static final int DEFAULT_VIDEO_HARD_ENCODE = 0;
    private static final int DRAW_FIRST_AD_POS_DEF = 4;
    private static final int DRAW_FOLLOW_AD_POS_DEF = 5;
    private static final int DRAW_FOLLOW_SEP_DEF = 5;
    private static final int EXPOSURE_VALID_PERCENT_DRAW = 70;
    private static final int EXPOSURE_VALID_PERCENT_GRID = 70;
    private static final int EXPOSURE_VALID_PERCENT_NEWS = 50;
    private static final int MIN_FLING_DISTANCE = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final double MIN_SCROLL_DISTANCE = 0.4d;
    private static final int PRELOAD_EXPIRE = 1440;
    private static final int PRELOAD_SIZE_2G = 800;
    private static final int PRELOAD_SIZE_3G = 800;
    private static final int PRELOAD_SIZE_4G = 800;
    private static final int PRELOAD_SIZE_MAX = 524288000;
    private static final int PRELOAD_SIZE_OTHER = 800;
    private static final int PRELOAD_SIZE_WIFI = -1;
    private static final String SP_KEY_CFG_DATA = "cfg_data";
    private static final String SP_KEY_UPDATE_TIME = "update_time";
    private static volatile SettingData instance;
    private int mDrawFirstAdPos = 4;
    private int mDrawFollowSep = 5;
    private int mDrawFollowAdPos = 5;
    private int mVideoHardEncode = 0;
    private int mPreloadSizeWifi = -1;
    private int mPreloadSize4G = 800;
    private int mPreloadSize3G = 800;
    private int mPreloadSize2G = 800;
    private int mPreloadSizeOther = 800;
    private int mPreloadExpire = PRELOAD_EXPIRE;
    private int mAdVideoPlayer = 1;
    private int mMinFlingDistance = 25;
    private int mMinFlingVelocity = 400;
    private double mMinScrollDistance = MIN_SCROLL_DISTANCE;
    private long mSwitchCacheTimeout = 3000;
    private int mCacheExpireRandomHours = 24;
    private int mAdMode = 0;
    private int mAdModeNews = 0;
    private int mAdExpire = 60;
    private int mAdRenderMethod = 2;
    private int mAdCoverShow = 1;
    private int mAdCoverPlayMode = 0;
    private int mAdCoverShowTime = 2;
    private int mAdInterstitialAwake = -1;
    private int mAdHalfScreenInterstitialAwake = -1;
    private int mAdFullScreenInterstitialAwake = -1;
    private int mAdInterstitialPostAwake = -1;
    private int mAdCardStyle = 0;
    private long mAdLearnMoreShow = 0;
    private long mAdLearnMoreHighlight = 7000;
    private long mAdMiniCardShow = 5000;
    private long mAdMiniCardHighlight = 7000;
    private long mAdLargeCardShow = 12000;
    private long mAdDurationLimit = 14000;
    private boolean mAdShakeCoverShow = false;
    private long mAdShakeCoverAppear = 3000;
    private long mAdShakeCoverDisappear = 5000;
    private int mAdShakeAccelerationThreshold = 16;
    private boolean mAdFullScreenClick = false;
    private int mVideoBannerLocation = 0;
    private int mVideoBannerAwake = -1;
    private int mVideoBannerLoopDuration = 60;
    private int mVideoBannerCarousel = 30;
    private final int mDrawTitleSize = 15;
    private final int mDrawAuthorNameSize = 15;
    private final int mDrawRingtoneSize = 13;
    private final int mDrawMusicSize = 14;
    private final int mIsNotach = 0;
    private final int mOffsetDownward = 0;
    private int mEnableDramaCache = 1;
    private int mHotListRetryTime = 0;
    private int mDramaCacheMaxSize = 100;
    private int mDramaCacheExpireTime = 518400;
    private int mEnableLike = 1;
    private int mEnableComment = 1;
    private int mEnableShare = 1;
    private int mFeedEnableDigg = 1;
    private int mFeedEnableFavor = 1;
    private int mFeedEnableShare = 1;
    private int mFeedEnableComment = 1;
    private int mEnableContinuousPlay = 0;
    private int mInnerEnterClose = 1;
    private final int mShortVideoSingleStyle = 0;
    private int mEnableWhiteScreen = 0;
    private int mEnableWhiteScreenDetail = 0;
    private int mEnableHomePage = 1;
    private int mEnableMusicTurnTable = 1;
    private int mEnableVideoCardEnterMode = 1;
    private int mEnableRedPacket = 0;
    private int mClosePreload = 0;
    private final int mFeedSinglePt = 4;
    private final int mShortVideoSinglePt = 4;
    private int mSmallVideoCardSubNum = 16;
    private int mArticleDetailRelatedNum = 5;
    private int mVideoDetailRelatedNum = 8;
    private int mVideoDetailRelatedTotal = 20;
    private int mDrawExposureValidPercent = 70;
    private int mGridExposureValidPercent = 70;
    private int mNewsExposureValidPercent = 50;
    private int mEnableSearchSuggest = 1;
    private int mEnableLiveEntrance = 1;
    private int mEnableNewsFilterForOutside = 1;
    private int mEnableOtherView = 1;
    private int mEnableStickProtectShowAd = 1;
    private int mDrawAdExpress = 1;
    private int mDrawAdCardExpress = 1;
    private boolean mDramaDrawCustomOpen = true;
    private boolean mBannerCustomBoxOpen = true;
    private boolean mBannerCustomDetailOpen = true;
    private boolean mConsecutiveUnlockingEnable = true;
    private List<String> mLivePluginBlockList = Collections.emptyList();
    private final List<String> mVideoPluginBlockList = Collections.emptyList();
    private Map<String, Object> mSceneMap = new HashMap();
    private List<String> mSharePanelConfig = new ArrayList();
    private List<String> mFeedSharePanelConfig = new ArrayList();
    private boolean mEnableShowLikeGuide = true;
    private boolean mEnableShowFollowGuide = true;
    private boolean mEnableWriteComment = true;
    private int mMixContinue = 0;
    private int mEnableStickCustom = 0;
    private int mCloseCacheUp = 1;
    private int mSkitContinue = 1;
    private int mEnableSyncHistory = 1;
    private int mIsInDramaBlackList = 0;
    private String mShortPlayFirstFrame = "first_frame";
    private int mDidDegrade = 0;
    private int mSeekThumbShow = 0;

    public int getDrawAuthorNameSize() {
        return 15;
    }

    public int getDrawMusicSize() {
        return 14;
    }

    public int getDrawRingtoneSize() {
        return 13;
    }

    public int getDrawTitleSize() {
        return 15;
    }

    public int getFeedSinglePt() {
        return 4;
    }

    public int getOffsetDownward() {
        return 0;
    }

    public int getShortVideoSinglePt() {
        return 4;
    }

    public boolean isNotach() {
        return false;
    }

    public boolean isShortVideoBlackStyle() {
        return false;
    }

    public void onSettingUpdated(SettingCfg settingCfg) {
    }

    private SettingData() {
        SettingsHelper.registerListener(this);
    }

    public static SettingData getInstance() {
        if (instance == null) {
            synchronized (SettingData.class) {
                if (instance == null) {
                    instance = new SettingData();
                }
            }
        }
        return instance;
    }

    public void onSettingsUpdate(boolean z, JSONObject jSONObject) {
        SettingCfg settingCfg = new SettingCfg();
        settingCfg.setUpdateTime(JSON.getLong(jSONObject, SP_KEY_UPDATE_TIME));
        settingCfg.setCommerce(SettingsParser.parseCommerce(JSON.getJsonObject(jSONObject, "commerce")));
        settingCfg.setVideo(SettingsParser.parseVideo(JSON.getJsonObject(jSONObject, "video")));
        settingCfg.setFeaturesCfg(SettingsParser.parseFeatures(JSON.getJsonObject(jSONObject, "features")));
        settingCfg.setContentCfg(SettingsParser.parseContent(JSON.getJsonObject(jSONObject, "content")));
        settingCfg.setLogCfg(SettingsParser.parseLogCfg(JSON.getJsonObject(jSONObject, a.b)));
        update(settingCfg);
        BESettingUpdate.build(z).send();
    }

    public void update(SettingCfg settingCfg) {
        saveCommerceData(settingCfg.getCommerce());
        saveVideoData(settingCfg.getVideo());
        saveFeaturesData(settingCfg.getFeaturesCfg());
        saveContentData(settingCfg.getContentCfg());
        saveLogData(settingCfg.getLogCfg());
    }

    public boolean isVideoHardEncode() {
        return this.mVideoHardEncode == 1;
    }

    public int getDrawFirstAdPos() {
        return this.mDrawFirstAdPos;
    }

    public int getDrawFollowSep() {
        return this.mDrawFollowSep;
    }

    public int getDrawFollowAdPos() {
        return this.mDrawFollowAdPos;
    }

    public boolean isAdCoverShow() {
        return this.mAdCoverShow == 1;
    }

    public int getAdCoverPlayMode() {
        return this.mAdCoverPlayMode;
    }

    public int getAdCoverShowTime() {
        return this.mAdCoverShowTime * 1000;
    }

    public int getAdExpire() {
        return this.mAdExpire;
    }

    public boolean isAdRenderNative() {
        return this.mAdRenderMethod == 2;
    }

    public boolean isMixAdLogic() {
        return this.mAdMode == 1;
    }

    public void setMixAdLogic(int i) {
        if (i > -1) {
            setAdMode(i);
        }
    }

    public int getAdInterstitialAwake() {
        return this.mAdInterstitialAwake;
    }

    public int getAdInterstitialPostAwake() {
        return this.mAdInterstitialPostAwake;
    }

    public int getAdHalfScreenInterstitialAwake() {
        return this.mAdHalfScreenInterstitialAwake;
    }

    public int getAdFullScreenInterstitialAwake() {
        return this.mAdFullScreenInterstitialAwake;
    }

    public int getVideoBannerLocation() {
        return this.mVideoBannerLocation;
    }

    public int getAdCardStyle() {
        return this.mAdCardStyle;
    }

    public long getAdLearnMoreShow() {
        return this.mAdLearnMoreShow;
    }

    public long getAdLearnMoreHighlight() {
        return this.mAdLearnMoreHighlight;
    }

    public long getAdMiniCardShow() {
        return this.mAdMiniCardShow;
    }

    public long getAdMiniCardHighlight() {
        return this.mAdMiniCardHighlight;
    }

    public long getAdLargeCardShow() {
        return this.mAdLargeCardShow;
    }

    public long getAdDurationLimit() {
        return this.mAdDurationLimit;
    }

    public boolean isAdShakeCoverShow() {
        return this.mAdShakeCoverShow;
    }

    public long getAdShakeCoverAppear() {
        return this.mAdShakeCoverAppear;
    }

    public long getAdShakeCoverDisappear() {
        return this.mAdShakeCoverDisappear;
    }

    public int getAdShakeAccelerationThreshold() {
        return this.mAdShakeAccelerationThreshold;
    }

    public boolean isAdFullScreenClick() {
        return this.mAdFullScreenClick;
    }

    public int getVideoBannerAwake() {
        return this.mVideoBannerAwake;
    }

    public int getVideoBannerLoopDuration() {
        return this.mVideoBannerLoopDuration;
    }

    public int getVideoBannerCarousel() {
        return this.mVideoBannerCarousel;
    }

    public int getDrawAdExpress() {
        return this.mDrawAdExpress;
    }

    public int getDrawAdCardExpress() {
        return this.mDrawAdCardExpress;
    }

    public boolean isDramaDrawCustomOpen() {
        return this.mDramaDrawCustomOpen;
    }

    public boolean isBannerCustomBoxOpen() {
        return this.mBannerCustomBoxOpen;
    }

    public boolean isBannerCustomDetailOpen() {
        return this.mBannerCustomDetailOpen;
    }

    public int getAdModeNews() {
        return this.mAdModeNews;
    }

    public void setAdMode(int i) {
        if (i <= -1 || this.mAdMode == i) {
            return;
        }
        this.mAdMode = i;
    }

    public boolean isNewsMixAdLogic() {
        return this.mAdModeNews == 1;
    }

    public void setNewsMixAdLogic(int i) {
        if (i > -1) {
            setAdModeNews(i);
        }
    }

    public void setAdModeNews(int i) {
        if (i <= -1 || this.mAdModeNews == i) {
            return;
        }
        this.mAdModeNews = i;
    }

    public boolean isEnableLike() {
        return this.mEnableLike == 1;
    }

    public boolean isEnableDramaCache() {
        return this.mEnableDramaCache == 1;
    }

    public int getHostListRetryTime() {
        int i = this.mHotListRetryTime;
        if (i == 0) {
            return 3600;
        }
        return i;
    }

    public boolean getConsecutiveUnlockingEnable() {
        return this.mConsecutiveUnlockingEnable;
    }

    public int getDramaCacheMaxSize() {
        return this.mDramaCacheMaxSize;
    }

    public int getDramaCacheExpireTime() {
        return this.mDramaCacheExpireTime;
    }

    public boolean isEnableComment() {
        return this.mEnableComment == 1;
    }

    public boolean isEnableShare() {
        return this.mEnableShare == 1;
    }

    public boolean isFeedEnableDigg() {
        return this.mFeedEnableDigg == 1;
    }

    public boolean isFeedEnableFavor() {
        return this.mFeedEnableFavor == 1;
    }

    public boolean isFeedEnableShare() {
        return this.mFeedEnableShare == 1;
    }

    public boolean isFeedEnableComment() {
        return this.mFeedEnableComment == 1;
    }

    public boolean isContinuousPlay() {
        return this.mEnableContinuousPlay == 1;
    }

    public boolean isInnerBack() {
        return this.mInnerEnterClose == 1;
    }

    public boolean isEnableWhiteScreen() {
        return this.mEnableWhiteScreen == 1;
    }

    public boolean isEnableWhiteScreenDetail() {
        return this.mEnableWhiteScreenDetail == 1;
    }

    public boolean isEnableHomePage() {
        return this.mEnableHomePage == 1;
    }

    public boolean isEnableMusicTurnTable() {
        return this.mEnableMusicTurnTable == 1;
    }

    public boolean isVideoCard14Enter() {
        return this.mEnableVideoCardEnterMode == 0;
    }

    public boolean isShowRedPacket() {
        return this.mEnableRedPacket == 1;
    }

    public int getSmallVideoCardSubNum() {
        return this.mSmallVideoCardSubNum;
    }

    public int getArticleDetailRelatedNum() {
        return this.mArticleDetailRelatedNum;
    }

    public int getVideoDetailRelatedNum() {
        return this.mVideoDetailRelatedNum;
    }

    public int getVideoDetailRelatedTotal() {
        return this.mVideoDetailRelatedTotal;
    }

    public int getDrawExposureValidPercent() {
        return this.mDrawExposureValidPercent;
    }

    public int getGridExposureValidPercent() {
        return this.mGridExposureValidPercent;
    }

    public int getNewsExposureValidPercent() {
        return this.mNewsExposureValidPercent;
    }

    public int getPreloadSizeWifi() {
        int i = this.mPreloadSizeWifi;
        return i <= -1 ? PRELOAD_SIZE_MAX : i * 1024;
    }

    public int getPreloadSize4G() {
        int i = this.mPreloadSize4G;
        return i <= -1 ? PRELOAD_SIZE_MAX : i * 1024;
    }

    public int getPreloadSize3G() {
        int i = this.mPreloadSize3G;
        return i <= -1 ? PRELOAD_SIZE_MAX : i * 1024;
    }

    public int getPreloadSize2G() {
        int i = this.mPreloadSize2G;
        return i <= -1 ? PRELOAD_SIZE_MAX : i * 1024;
    }

    public int getPreloadSizeOther() {
        int i = this.mPreloadSizeOther;
        return i <= -1 ? PRELOAD_SIZE_MAX : i * 1024;
    }

    public int getPreloadExpire() {
        int i = this.mPreloadExpire;
        return i < 0 ? PRELOAD_EXPIRE : i;
    }

    public boolean isClosePreload() {
        return this.mClosePreload == 1;
    }

    public boolean isCloseCacheUp() {
        return this.mCloseCacheUp == 1;
    }

    public boolean isAdTTPlayer() {
        return this.mAdVideoPlayer == 2;
    }

    public List<Integer> getVidVersions() {
        if (SettingsHelper.sExtra != null) {
            return SettingsHelper.sExtra.getVidList();
        }
        return null;
    }

    public JSONArray getVidOthers() {
        if (SettingsHelper.sExtra != null) {
            return SettingsHelper.sExtra.getAdLogParams();
        }
        return null;
    }

    public List<String> getSharePanelConfig() {
        return this.mSharePanelConfig;
    }

    public List<String> getFeedSharePanelConfig() {
        return this.mFeedSharePanelConfig;
    }

    public int getMinFlingDistance() {
        return this.mMinFlingDistance;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public double getMinScrollDistance() {
        return this.mMinScrollDistance;
    }

    @Deprecated
    public int getEnableSearchSuggest() {
        return this.mEnableSearchSuggest;
    }

    @Deprecated
    public void setEnableSearchSuggest(int i) {
        this.mEnableSearchSuggest = i;
    }

    public int getEnableLiveEntrance() {
        return this.mEnableLiveEntrance;
    }

    public long getSwitchCacheTimeout() {
        return this.mSwitchCacheTimeout;
    }

    public void setSwitchCacheTimeout(long j) {
        this.mSwitchCacheTimeout = j;
    }

    public int getCacheExpireRandomHours() {
        return this.mCacheExpireRandomHours;
    }

    public void setCacheExpireRandomHours(int i) {
        this.mCacheExpireRandomHours = i;
    }

    public List<String> getLivePluginBlockList() {
        return this.mLivePluginBlockList;
    }

    public List<String> getVideoPluginBlockList() {
        return this.mVideoPluginBlockList;
    }

    public boolean getEnableNewsFilterForOutside() {
        return this.mEnableNewsFilterForOutside != 0;
    }

    public boolean getEnableOtherView() {
        return this.mEnableOtherView == 1;
    }

    public boolean isStickProtectShowAd() {
        return this.mEnableStickProtectShowAd == 1;
    }

    public boolean isMixContinue() {
        return this.mMixContinue == 1;
    }

    public boolean isSkitContinue() {
        return this.mSkitContinue == 1;
    }

    public boolean isEnableStickCustom() {
        return this.mEnableStickCustom == 1;
    }

    public boolean getEnableShowLikeGuide() {
        return this.mEnableShowLikeGuide;
    }

    public boolean getEnableShowFollowGuide() {
        return this.mEnableShowFollowGuide;
    }

    public boolean getEnableWriteComment() {
        return this.mEnableWriteComment;
    }

    public boolean isEnableSyncHistory() {
        return this.mEnableSyncHistory == 1;
    }

    public boolean isIsInDramaBlackList() {
        return this.mIsInDramaBlackList == 1;
    }

    public String getShortPlayFirstFrame() {
        return this.mShortPlayFirstFrame;
    }

    public int getDidDegrade() {
        return this.mDidDegrade;
    }

    public boolean isSeekThumbShow() {
        return this.mSeekThumbShow == 1;
    }

    private void saveVideoData(VideoCfg videoCfg) {
        if (videoCfg == null) {
            return;
        }
        this.mVideoHardEncode = videoCfg.getHardEncode();
    }

    private void saveCommerceData(Commerce commerce) {
        if (commerce == null) {
            return;
        }
        if (commerce.getAdSort() != null && commerce.getAdSort().getFeedImageMode() != null) {
            this.mDrawFirstAdPos = commerce.getAdSort().getFeedImageMode().getFirstAdPos();
            this.mDrawFollowSep = commerce.getAdSort().getFeedImageMode().getFollowSep();
            this.mDrawFollowAdPos = commerce.getAdSort().getFeedImageMode().getFollowAdPos();
        }
        this.mAdExpire = commerce.getAdExpire();
        this.mAdMode = commerce.getAdMode();
        this.mAdModeNews = commerce.getAdModeNews();
        this.mAdRenderMethod = commerce.getAdRenderMethod();
        this.mAdVideoPlayer = commerce.getAdVideoPlayer();
        this.mAdInterstitialAwake = commerce.getInterstitialAwake();
        this.mAdInterstitialPostAwake = commerce.getInterstitialPostAwake();
        this.mAdHalfScreenInterstitialAwake = commerce.getAdHalfScreenInterstitialAwake();
        this.mAdFullScreenInterstitialAwake = commerce.getAdFullScreenInterstitialAwake();
        this.mVideoBannerLocation = commerce.getVideoBannerAdLocation();
        this.mVideoBannerAwake = commerce.getVideoBannerAdAwake();
        this.mVideoBannerLoopDuration = commerce.getVideoBannerAdLoopDuration();
        this.mVideoBannerCarousel = commerce.getVideoBannerAdCarousel();
        this.mDrawAdExpress = commerce.getDrawAdExpress();
        this.mDrawAdCardExpress = commerce.getDrawAdCardExpress();
        this.mDramaDrawCustomOpen = commerce.isDramaDrawCustomOpen();
        this.mBannerCustomBoxOpen = commerce.isBannerCustomBoxOpen();
        this.mBannerCustomDetailOpen = commerce.isBannerCustomDetailOpen();
        this.mAdCoverShow = commerce.getAdCoverShow();
        this.mAdCoverPlayMode = commerce.getAdCoverPlayMode();
        this.mAdCoverShowTime = commerce.getAdCoverShowTime();
        this.mAdCardStyle = commerce.getAdCardStyle();
        this.mAdLearnMoreShow = commerce.getAdLearnMoreShow();
        this.mAdLearnMoreHighlight = commerce.getAdLearnMoreHighlight();
        this.mAdMiniCardShow = commerce.getAdMiniCardShow();
        this.mAdMiniCardHighlight = commerce.getAdMiniCardHighlight();
        this.mAdLargeCardShow = commerce.getAdLargeCardShow();
        this.mAdDurationLimit = commerce.getAdDurationLimit();
        this.mAdShakeCoverShow = commerce.isAdShakeCoverShow();
        this.mAdShakeCoverAppear = commerce.getAdShakeCoverAppear();
        this.mAdShakeCoverDisappear = commerce.getAdShakeCoverDisappear();
        this.mAdShakeAccelerationThreshold = commerce.getAdShakeAccelerationThreshold();
        this.mAdFullScreenClick = commerce.isAdFullScreenClick();
    }

    private void saveFeaturesData(FeaturesCfg featuresCfg) {
        if (featuresCfg == null) {
            return;
        }
        this.mEnableDramaCache = featuresCfg.getEnableDramaCache();
        this.mHotListRetryTime = featuresCfg.getHotListRetryTime();
        this.mDramaCacheExpireTime = featuresCfg.getDramaCacheExpireTime();
        this.mDramaCacheMaxSize = featuresCfg.getDramaCacheMaxSize();
        this.mEnableLike = featuresCfg.getEnableLike();
        this.mEnableComment = featuresCfg.getEnableComment();
        this.mEnableShare = featuresCfg.getEnableShare();
        this.mFeedEnableDigg = featuresCfg.getFeedEnableDigg();
        this.mFeedEnableFavor = featuresCfg.getFeedEnableFavor();
        this.mFeedEnableComment = featuresCfg.getFeedEnableComment();
        this.mFeedEnableShare = featuresCfg.getFeedEnableShare();
        this.mEnableContinuousPlay = featuresCfg.getEnableContinuousPlay();
        this.mInnerEnterClose = featuresCfg.getInnerEnterClose();
        this.mEnableWhiteScreen = featuresCfg.getEnableWhiteScreen();
        this.mEnableWhiteScreenDetail = featuresCfg.getEnableWhiteScreenDetail();
        this.mEnableHomePage = featuresCfg.getEnableHomePage();
        this.mEnableMusicTurnTable = featuresCfg.getEnableMusicTurnTable();
        this.mEnableVideoCardEnterMode = featuresCfg.getVideoCard14EnterMode();
        this.mEnableRedPacket = featuresCfg.getEnableRedPacket();
        this.mSharePanelConfig = featuresCfg.getSharePanelConfig();
        this.mFeedSharePanelConfig = featuresCfg.getFeedSharePanelConfig();
        this.mEnableSearchSuggest = featuresCfg.getEnableSearchSuggest();
        this.mEnableLiveEntrance = featuresCfg.getEnableLiveEntrance();
        this.mSwitchCacheTimeout = featuresCfg.getSwitchCacheTimeout();
        this.mCacheExpireRandomHours = featuresCfg.getCacheExpireRandomHours();
        this.mLivePluginBlockList = featuresCfg.getLivePluginBlockList();
        this.mEnableOtherView = featuresCfg.getEnableOtherView();
        this.mEnableNewsFilterForOutside = featuresCfg.getEnableNewsFilterForOutside();
        this.mEnableStickProtectShowAd = featuresCfg.getEnableStickProtectShowAd();
        this.mEnableShowLikeGuide = featuresCfg.getEnableShowLikeGuide();
        this.mEnableShowFollowGuide = featuresCfg.getEnableShowFollowGuide();
        this.mMixContinue = featuresCfg.getMixContinue();
        this.mSkitContinue = featuresCfg.getSkitContinue();
        this.mEnableWriteComment = featuresCfg.getEnableWriteComment();
        this.mEnableStickCustom = featuresCfg.getEnableStickCustom();
        this.mEnableSyncHistory = featuresCfg.isEnableSyncHistory();
        this.mIsInDramaBlackList = featuresCfg.isInDramaBlackList();
        this.mShortPlayFirstFrame = featuresCfg.getShortPlayFirstFrame();
        this.mDidDegrade = featuresCfg.getDidDegrade();
        this.mSeekThumbShow = featuresCfg.getSeekThumbShow();
        this.mConsecutiveUnlockingEnable = featuresCfg.getConsecutiveUnlockingEnable();
    }

    private void saveContentData(ContentCfg contentCfg) {
        if (contentCfg == null) {
            return;
        }
        this.mSmallVideoCardSubNum = contentCfg.getSmallVideoCardSubNum();
        this.mArticleDetailRelatedNum = contentCfg.getArticleDetailRelatedNum();
        this.mVideoDetailRelatedNum = contentCfg.getVideoDetailRelatedNum();
        this.mVideoDetailRelatedTotal = contentCfg.getVideoDetailRelatedTotal();
        this.mPreloadSizeWifi = contentCfg.getPreloadSizeWifi();
        this.mPreloadSize4G = contentCfg.getPreloadSize4G();
        this.mPreloadSize3G = contentCfg.getPreloadSize3G();
        this.mPreloadSize2G = contentCfg.getPreloadSize2G();
        this.mPreloadSizeOther = contentCfg.getPreloadSizeOther();
        this.mPreloadExpire = contentCfg.getPreloadExpire();
        this.mClosePreload = contentCfg.getClosePreload();
        this.mCloseCacheUp = contentCfg.getCloseCacheUp();
        this.mMinFlingDistance = contentCfg.getMinFlingDistance() > 0 ? contentCfg.getMinFlingDistance() : 25;
        this.mMinFlingVelocity = contentCfg.getMinFlingVelocity() > 0 ? contentCfg.getMinFlingVelocity() : 400;
        this.mMinScrollDistance = (contentCfg.getMinScrollDistance() <= 0.0d || contentCfg.getMinScrollDistance() > 1.0d) ? MIN_SCROLL_DISTANCE : contentCfg.getMinScrollDistance();
        if (contentCfg.getCustomCateCfg() != null) {
            this.mSceneMap = contentCfg.getCustomCateCfg().getSceneMap();
        } else {
            this.mSceneMap = new HashMap();
        }
    }

    private void saveLogData(LogCfg logCfg) {
        if (logCfg == null || logCfg.getExposure() == null) {
            return;
        }
        this.mDrawExposureValidPercent = logCfg.getExposure().getFeedImageMode();
        this.mGridExposureValidPercent = logCfg.getExposure().getSuduku();
        this.mNewsExposureValidPercent = logCfg.getExposure().getNews();
    }
}

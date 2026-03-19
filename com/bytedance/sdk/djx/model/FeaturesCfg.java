package com.bytedance.sdk.djx.model;

import android.text.TextUtils;
import com.bytedance.sdk.djx.settings.DJXGlobalSettings;
import com.bytedance.sdk.djx.utils.DJXSdkUtils;
import com.bytedance.sdk.djx.utils.SP;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class FeaturesCfg {
    private int mCacheExpireRandomHours;
    private int mDramaCacheExpireTime;
    private int mDramaCacheMaxSize;
    private int mEnableComment;
    private int mEnableContinuousPlay;
    private int mEnableHomePage;
    private int mEnableLike;
    private int mEnableMusicTurnTable;
    private int mEnableShare;
    private int mEnableWhiteScreen;
    private int mEnableWhiteScreenDetail;
    private int mFeedEnableComment;
    private int mFeedEnableDigg;
    private int mFeedEnableFavor;
    private int mFeedEnableShare;
    private List<String> mFeedSharePanelConfig;
    private int mInnerEnterClose;
    private List<String> mSharePanelConfig;
    private long mSwitchCacheTimeout;
    private int mEnableDramaCache = 1;
    private int mVideoCard14EnterMode = 1;
    private int mEnableRedPacket = 0;
    private int mEnableSearchSuggest = 1;
    private List<String> mLivePluginBlockList = Collections.emptyList();
    private int mEnableLiveEntrance = 1;
    private int mEnableOtherView = 1;
    private int mEnableNewsFilterForOutside = 1;
    private int mEnableStickProtectShowAd = 1;
    private boolean mEnableShowLikeGuide = true;
    private boolean mEnableShowFollowGuide = true;
    private boolean mEnableWriteComment = true;
    private int mMixContinue = 0;
    private int mEnableStickCustom = 0;
    private int mSkitContinue = 1;
    private int mHotListRetryTime = 0;
    private boolean mConsecutiveUnlockingEnable = true;
    private int mPluginMode = 0;
    private String mAdSdkBlockList = null;
    private int mEnableSyncHistory = 1;
    private int mIsInDramaBlackList = 0;
    private String mShortPlayFirstFrame = "first_frame";
    private int mDidDegrade = 0;
    private int mSeekThumbShow = 0;

    public int getSeekThumbShow() {
        return this.mSeekThumbShow;
    }

    public void setSeekThumbShow(int i) {
        this.mSeekThumbShow = i;
    }

    public int getDidDegrade() {
        return this.mDidDegrade;
    }

    public void setDidDegrade(int i) {
        this.mDidDegrade = i;
    }

    public String getShortPlayFirstFrame() {
        return this.mShortPlayFirstFrame;
    }

    public void setShortPlayFirstFrame(String str) {
        this.mShortPlayFirstFrame = str;
    }

    public int isInDramaBlackList() {
        return this.mIsInDramaBlackList;
    }

    public void setInDramaBlackList(int i) {
        this.mIsInDramaBlackList = i;
    }

    public int isEnableSyncHistory() {
        return this.mEnableSyncHistory;
    }

    public void setEnableSyncHistory(int i) {
        this.mEnableSyncHistory = i;
    }

    public int getSkitContinue() {
        return this.mSkitContinue;
    }

    public void setSkitContinue(int i) {
        this.mSkitContinue = i;
    }

    public int getPluginMode() {
        return this.mPluginMode;
    }

    public void setPluginMode(int i) {
        if (i == 1 && !DJXGlobalSettings.getInstance().getPluginMode()) {
            DJXSdkUtils.fetchPlugin();
        }
        this.mPluginMode = i;
        SP.globalSettings().put("plugin_mode", i);
    }

    public void setAdSdkBlockList(String str) {
        this.mAdSdkBlockList = str;
        if (TextUtils.isEmpty(str)) {
            SP.globalSettings().remove("plugin_adsdk_blocklist");
        } else {
            SP.globalSettings().put("plugin_adsdk_blocklist", str);
        }
    }

    public int getMixContinue() {
        return this.mMixContinue;
    }

    public void setMixContinue(int i) {
        this.mMixContinue = i;
    }

    public int getVideoCard14EnterMode() {
        return this.mVideoCard14EnterMode;
    }

    public void setVideoCard14EnterMode(int i) {
        this.mVideoCard14EnterMode = i;
    }

    public int getEnableDramaCache() {
        return this.mEnableDramaCache;
    }

    public void setEnableDramaCache(int i) {
        this.mEnableDramaCache = i;
    }

    public int getDramaCacheMaxSize() {
        return this.mDramaCacheMaxSize;
    }

    public void setDramaCacheMaxSize(int i) {
        this.mDramaCacheMaxSize = i;
    }

    public int getDramaCacheExpireTime() {
        return this.mDramaCacheExpireTime;
    }

    public void setDramaCacheExpireTime(int i) {
        this.mDramaCacheExpireTime = i;
    }

    public int getEnableLike() {
        return this.mEnableLike;
    }

    public void setEnableLike(int i) {
        this.mEnableLike = i;
    }

    public int getEnableComment() {
        return this.mEnableComment;
    }

    public void setEnableComment(int i) {
        this.mEnableComment = i;
    }

    public int getEnableShare() {
        return this.mEnableShare;
    }

    public void setEnableShare(int i) {
        this.mEnableShare = i;
    }

    public int getEnableContinuousPlay() {
        return this.mEnableContinuousPlay;
    }

    public void setEnableContinuousPlay(int i) {
        this.mEnableContinuousPlay = i;
    }

    public int getInnerEnterClose() {
        return this.mInnerEnterClose;
    }

    public void setInnerEnterClose(int i) {
        this.mInnerEnterClose = i;
    }

    public int getEnableWhiteScreen() {
        return this.mEnableWhiteScreen;
    }

    public void setEnableWhiteScreen(int i) {
        this.mEnableWhiteScreen = i;
    }

    public int getEnableWhiteScreenDetail() {
        return this.mEnableWhiteScreenDetail;
    }

    public void setEnableWhiteScreenDetail(int i) {
        this.mEnableWhiteScreenDetail = i;
    }

    public int getFeedEnableDigg() {
        return this.mFeedEnableDigg;
    }

    public void setFeedEnableDigg(int i) {
        this.mFeedEnableDigg = i;
    }

    public int getFeedEnableFavor() {
        return this.mFeedEnableFavor;
    }

    public void setFeedEnableFavor(int i) {
        this.mFeedEnableFavor = i;
    }

    public int getFeedEnableComment() {
        return this.mFeedEnableComment;
    }

    public void setFeedEnableComment(int i) {
        this.mFeedEnableComment = i;
    }

    public int getFeedEnableShare() {
        return this.mFeedEnableShare;
    }

    public void setFeedEnableShare(int i) {
        this.mFeedEnableShare = i;
    }

    public int getEnableHomePage() {
        return this.mEnableHomePage;
    }

    public void setEnableHomePage(int i) {
        this.mEnableHomePage = i;
    }

    public int getEnableMusicTurnTable() {
        return this.mEnableMusicTurnTable;
    }

    public void setEnableMusicTurnTable(int i) {
        this.mEnableMusicTurnTable = i;
    }

    public List<String> getSharePanelConfig() {
        return this.mSharePanelConfig;
    }

    public List<String> getFeedSharePanelConfig() {
        return this.mFeedSharePanelConfig;
    }

    public void setFeedSharePanelConfig(List<String> list) {
        this.mFeedSharePanelConfig = list;
    }

    public void setSharePanelConfig(List<String> list) {
        this.mSharePanelConfig = list;
    }

    public int getEnableRedPacket() {
        return this.mEnableRedPacket;
    }

    public void setEnableRedPacket(int i) {
        this.mEnableRedPacket = i;
    }

    @Deprecated
    public int getEnableSearchSuggest() {
        return this.mEnableSearchSuggest;
    }

    public void setEnableSearchSuggest(int i) {
        this.mEnableSearchSuggest = i;
    }

    public List<String> getLivePluginBlockList() {
        return this.mLivePluginBlockList;
    }

    public void setLivePluginBlockList(List<String> list) {
        this.mLivePluginBlockList = list;
    }

    public int getEnableLiveEntrance() {
        return this.mEnableLiveEntrance;
    }

    public void setEnableLiveEntrance(int i) {
        this.mEnableLiveEntrance = i;
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

    public int getEnableOtherView() {
        return this.mEnableOtherView;
    }

    public void setEnableOtherView(int i) {
        this.mEnableOtherView = i;
    }

    public int getEnableNewsFilterForOutside() {
        return this.mEnableNewsFilterForOutside;
    }

    public void setEnableNewsFilterForOutside(int i) {
        this.mEnableNewsFilterForOutside = i;
    }

    public void setVideoPluginBLockList(String str) {
        DJXGlobalSettings.getInstance().saveVideoPluginBlockList(str);
    }

    public int getEnableStickProtectShowAd() {
        return this.mEnableStickProtectShowAd;
    }

    public void setEnableStickProtectShowAd(int i) {
        this.mEnableStickProtectShowAd = i;
    }

    public void setEnableShowLikeGuide(boolean z) {
        this.mEnableShowLikeGuide = z;
    }

    public void setEnableShowFollowGuide(boolean z) {
        this.mEnableShowFollowGuide = z;
    }

    public boolean getEnableWriteComment() {
        return this.mEnableWriteComment;
    }

    public void setEnableWriteComment(boolean z) {
        this.mEnableWriteComment = z;
    }

    public boolean getEnableShowLikeGuide() {
        return this.mEnableShowLikeGuide;
    }

    public boolean getEnableShowFollowGuide() {
        return this.mEnableShowFollowGuide;
    }

    public int getEnableStickCustom() {
        return this.mEnableStickCustom;
    }

    public void setEnableStickCustom(int i) {
        this.mEnableStickCustom = i;
    }

    public void setHotListRetryTime(int i) {
        this.mHotListRetryTime = i;
    }

    public int getHotListRetryTime() {
        return this.mHotListRetryTime;
    }

    public void setConsecutiveUnlockingEnable(boolean z) {
        this.mConsecutiveUnlockingEnable = z;
    }

    public boolean getConsecutiveUnlockingEnable() {
        return this.mConsecutiveUnlockingEnable;
    }
}

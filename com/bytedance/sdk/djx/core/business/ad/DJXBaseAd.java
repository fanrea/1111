package com.bytedance.sdk.djx.core.business.ad;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.bytedance.sdk.djx.model.Feed;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class DJXBaseAd implements IDJXAd {
    protected long mCurrentPlayPosition;
    private Feed mFeed;
    protected long mTotalDuration;

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void destroy() {
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void dismissByReflect() {
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public long getAdCacheTime() {
        return 0L;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public AdComplianceInfo getAdComplianceInfo() {
        return null;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public Bitmap getAdLogo() {
        return null;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public int getAdTypeName() {
        return 0;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public View getAdView() {
        return null;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public String getButtonText() {
        return null;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public String getCoverUrl() {
        return null;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public IDJXAd.CustomVideo getCustomVideo() {
        return null;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public String getDescription() {
        return null;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public String getIcon() {
        return null;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public List<IDJXAd.Image> getImageList() {
        return null;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public int getInteractionType() {
        return 0;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public Map<String, Object> getMediaExtraInfo() {
        return null;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public String getRequestId() {
        return null;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public String getTitle() {
        return null;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public long getVideoDuration() {
        return 0L;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, IDJXAd.AdInteractionListener adInteractionListener) {
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void setDislikeCallback(Activity activity, IDJXAd.DislikeInteractionCallback dislikeInteractionCallback) {
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void setDrawVideoListener(IDJXAd.DrawVideoListener drawVideoListener) {
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void setExpressAdInteractionListener(IDJXAd.AdExpressInteractionListener adExpressInteractionListener) {
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void setExpressVideoAdListener(IDJXAd.ExpressVideoAdListener expressVideoAdListener) {
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void setFullVideoListener(IDJXAd.FullVideoListener fullVideoListener) {
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void setRewardVideoListener(IDJXAd.RewardVideoListener rewardVideoListener) {
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void setVideoAdListener(IDJXAd.VideoAdListener videoAdListener) {
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void show(Context context) {
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void showDislikeDialog(Activity activity, IDJXAd.DislikeInteractionCallback dislikeInteractionCallback) {
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public String getTitleOrAppName() {
        AdComplianceInfo adComplianceInfo = getAdComplianceInfo();
        if (adComplianceInfo != null && !TextUtils.isEmpty(adComplianceInfo.appName)) {
            return adComplianceInfo.appName;
        }
        return getTitle();
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void setFeed(Feed feed) {
        this.mFeed = feed;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public Feed getFeed() {
        return this.mFeed;
    }
}

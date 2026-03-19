package com.kwad.components.ct.response.model;

import com.kwad.components.ct.response.a.c;
import com.kwad.components.ct.response.model.hotspot.NewsInfo;
import com.kwad.components.ct.response.model.live.LiveInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class CtAdTemplate extends AdTemplate implements Serializable {
    private static final long serialVersionUID = 6856410513496739700L;
    public transient boolean adFromAdx;
    public boolean isDrawAdHasLook;
    public transient boolean mContentPvReported;
    public boolean mHasEntryAdClick;
    public transient boolean mHorizontalFeedSuggestPvReported;
    public transient boolean mHorizontalRelatedSuggestPvReported;
    public boolean mIsNotNeedAvatarGuider;
    public LiveInfo mLiveInfo;
    public String mPcursor;
    public PreloadData mPreloadData;
    public transient boolean mRelatedContentPvReported;
    public int mRequestCount;
    public boolean needHide;
    public NewsInfo newsInfo;
    public PhotoAd photoAd;
    public CtPhotoInfo photoInfo;
    public transient boolean thirdFromAdx;

    public CtAdTemplate() {
        this.photoInfo = new CtPhotoInfo();
        this.photoAd = new PhotoAd();
        this.newsInfo = new NewsInfo();
        this.mLiveInfo = new LiveInfo();
        this.adFromAdx = false;
        this.thirdFromAdx = false;
        this.isDrawAdHasLook = false;
        this.mPreloadData = new PreloadData();
    }

    @Override // com.kwad.sdk.core.response.model.AdTemplate
    public CtAdResultData createAdResultData() {
        CtAdResultData ctAdResultData = new CtAdResultData();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(this);
        ctAdResultData.setAdTemplateList(arrayList);
        return ctAdResultData;
    }

    public CtAdTemplate(AdTemplate adTemplate) {
        this.photoInfo = new CtPhotoInfo();
        this.photoAd = new PhotoAd();
        this.newsInfo = new NewsInfo();
        this.mLiveInfo = new LiveInfo();
        this.adFromAdx = false;
        this.thirdFromAdx = false;
        this.isDrawAdHasLook = false;
        this.mPreloadData = new PreloadData();
        parseJson(adTemplate.toJson());
        this.mOriginJString = adTemplate.mOriginJString;
        this.photoInfo = new CtPhotoInfo(adTemplate.photoInfo);
        this.positionShow = adTemplate.positionShow;
        this.adxResult = adTemplate.adxResult;
        setServerPosition(adTemplate.getServerPosition());
        this.mIsFromContent = adTemplate.mIsFromContent;
        this.hasEnterAdWebViewLandPageActivity = adTemplate.hasEnterAdWebViewLandPageActivity;
        this.mPvReported = adTemplate.mPvReported;
        this.mTrackUrlReported = adTemplate.mTrackUrlReported;
        this.mHasSelected = adTemplate.mHasSelected;
        this.downloadSource = adTemplate.downloadSource;
        this.installFrom = adTemplate.installFrom;
        this.interactLandingPageShowing = adTemplate.interactLandingPageShowing;
        this.mAdWebVideoPageShowing = adTemplate.mAdWebVideoPageShowing;
        this.mCheatingFlow = adTemplate.mCheatingFlow;
        this.mXiaomiAppStoreDetailViewOpen = adTemplate.mXiaomiAppStoreDetailViewOpen;
        this.mLocalParams = adTemplate.getLocalParams();
        if (adTemplate instanceof CtAdTemplate) {
            CtAdTemplate ctAdTemplate = (CtAdTemplate) adTemplate;
            this.adFromAdx = ctAdTemplate.adFromAdx;
            this.thirdFromAdx = ctAdTemplate.thirdFromAdx;
            this.mRequestCount = ctAdTemplate.mRequestCount;
            this.mContentPvReported = ctAdTemplate.mContentPvReported;
            this.mHorizontalFeedSuggestPvReported = ctAdTemplate.mHorizontalFeedSuggestPvReported;
            this.mRelatedContentPvReported = ctAdTemplate.mRelatedContentPvReported;
            this.mHorizontalRelatedSuggestPvReported = ctAdTemplate.mHorizontalRelatedSuggestPvReported;
        }
    }

    @Override // com.kwad.sdk.core.response.model.AdTemplate
    public PhotoInfo createPhotoInfo() {
        return new CtPhotoInfo();
    }

    @Override // com.kwad.sdk.core.response.model.AdTemplate
    public void setPhotoInfo(PhotoInfo photoInfo) {
        this.photoInfo = c.a(photoInfo);
    }
}

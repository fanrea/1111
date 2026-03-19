package com.bytedance.sdk.djx.core.business.ad.oppo3110;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.TTImage;
import com.bykv.vk.openvk.TTNtObject;
import com.bykv.vk.openvk.TTVfObject;
import com.bytedance.sdk.djx.core.business.ad.DJXBaseAd;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class VfFeedAd extends DJXBaseAd {
    private long mAdCacheTime;
    private TTVfObject mFeedAd;

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public int getAdTypeName() {
        return 6;
    }

    public VfFeedAd(TTVfObject tTVfObject, long j) {
        this.mFeedAd = tTVfObject;
        this.mAdCacheTime = j;
    }

    public TTVfObject getAd() {
        return this.mFeedAd;
    }

    public void setAd(TTVfObject tTVfObject) {
        this.mFeedAd = tTVfObject;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public String getTitle() {
        TTVfObject tTVfObject = this.mFeedAd;
        return tTVfObject == null ? "" : tTVfObject.getTitle();
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public String getButtonText() {
        TTVfObject tTVfObject = this.mFeedAd;
        return tTVfObject == null ? "" : tTVfObject.getButtonText();
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public Bitmap getAdLogo() {
        TTVfObject tTVfObject = this.mFeedAd;
        if (tTVfObject == null) {
            return null;
        }
        return tTVfObject.getAdLogo();
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public long getAdCacheTime() {
        return this.mAdCacheTime;
    }

    public void setAdCacheTime(long j) {
        this.mAdCacheTime = j;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public View getAdView() {
        TTVfObject tTVfObject = this.mFeedAd;
        if (tTVfObject == null) {
            return null;
        }
        return tTVfObject.getAdView();
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public String getRequestId() {
        return OppoVfUtils.getAdRequestId(this.mFeedAd);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public String getIcon() {
        TTVfObject tTVfObject = this.mFeedAd;
        if (tTVfObject == null || tTVfObject.getIcon() == null) {
            return null;
        }
        return this.mFeedAd.getIcon().getImageUrl();
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public String getDescription() {
        TTVfObject tTVfObject = this.mFeedAd;
        if (tTVfObject == null) {
            return null;
        }
        return tTVfObject.getDescription();
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public List<IDJXAd.Image> getImageList() {
        TTVfObject tTVfObject = this.mFeedAd;
        if (tTVfObject == null || tTVfObject.getImageList() == null || this.mFeedAd.getImageList().isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this.mFeedAd.getImageList().iterator();
        while (it.hasNext()) {
            arrayList.add(new VfImageAd((TTImage) it.next()));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public String getCoverUrl() {
        TTVfObject tTVfObject = this.mFeedAd;
        if (tTVfObject != null && tTVfObject.getVideoCoverImage() != null) {
            if (!TextUtils.isEmpty(this.mFeedAd.getVideoCoverImage().getImageUrl())) {
                return this.mFeedAd.getVideoCoverImage().getImageUrl();
            }
            List<IDJXAd.Image> imageList = getImageList();
            if (imageList != null && !imageList.isEmpty()) {
                for (IDJXAd.Image image : imageList) {
                    if (image != null && !TextUtils.isEmpty(image.getUrl())) {
                        return image.getUrl();
                    }
                }
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public long getVideoDuration() {
        TTVfObject tTVfObject = this.mFeedAd;
        if (tTVfObject == null) {
            return 0L;
        }
        long videoDuration = (long) tTVfObject.getVideoDuration();
        return videoDuration < 1000 ? videoDuration * 1000 : videoDuration;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public IDJXAd.CustomVideo getCustomVideo() {
        TTVfObject tTVfObject = this.mFeedAd;
        if (tTVfObject == null || tTVfObject.getCustomVideo() == null) {
            return null;
        }
        return new VfCustomVideo(this.mFeedAd.getCustomVideo());
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public Map<String, Object> getMediaExtraInfo() {
        return OppoVfUtils.getMediaExtraInfo(this.mFeedAd);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, final IDJXAd.AdInteractionListener adInteractionListener) {
        TTVfObject tTVfObject = this.mFeedAd;
        if (tTVfObject == null) {
            return;
        }
        tTVfObject.registerViewForInteraction(viewGroup, list, list2, new TTNtObject.AdInteractionListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo3110.VfFeedAd.1
            public void onClicked(View view, TTNtObject tTNtObject) {
                adInteractionListener.onAdClicked(view, new VfNativeAd(tTNtObject));
            }

            public void onCreativeClick(View view, TTNtObject tTNtObject) {
                adInteractionListener.onAdCreativeClick(view, new VfNativeAd(tTNtObject));
            }

            public void onShow(TTNtObject tTNtObject) {
                adInteractionListener.onAdShow(new VfNativeAd(tTNtObject));
            }
        });
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void setVideoAdListener(final IDJXAd.VideoAdListener videoAdListener) {
        TTVfObject tTVfObject = this.mFeedAd;
        if (tTVfObject == null || videoAdListener == null) {
            return;
        }
        tTVfObject.setVideoListener(new TTVfObject.VideoVfListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo3110.VfFeedAd.2
            public void onVideoLoad(TTVfObject tTVfObject2) {
                videoAdListener.onVideoLoad(new VfFeedAd(tTVfObject2, System.currentTimeMillis()));
            }

            public void onVideoError(int i, int i2) {
                videoAdListener.onVideoError(i, i2);
            }

            public void onVideoStartPlay(TTVfObject tTVfObject2) {
                videoAdListener.onVideoAdStartPlay(new VfFeedAd(tTVfObject2, System.currentTimeMillis()));
            }

            public void onVideoPaused(TTVfObject tTVfObject2) {
                videoAdListener.onVideoAdPaused(new VfFeedAd(tTVfObject2, System.currentTimeMillis()), VfFeedAd.this.mCurrentPlayPosition, VfFeedAd.this.mTotalDuration);
            }

            public void onVideoContinuePlay(TTVfObject tTVfObject2) {
                videoAdListener.onVideoAdContinuePlay(new VfFeedAd(tTVfObject2, System.currentTimeMillis()));
            }

            public void onProgressUpdate(long j, long j2) {
                videoAdListener.onProgressUpdate(j, j2);
                VfFeedAd.this.mCurrentPlayPosition = j;
                VfFeedAd.this.mTotalDuration = j2;
            }

            public void onVideoComplete(TTVfObject tTVfObject2) {
                videoAdListener.onVideoAdComplete(new VfFeedAd(tTVfObject2, System.currentTimeMillis()), VfFeedAd.this.mTotalDuration);
            }
        });
    }
}

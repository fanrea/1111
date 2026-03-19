package com.bytedance.sdk.djx.core.business.ad.open;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.djx.core.business.ad.DJXBaseAd;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class OpenFeedAd extends DJXBaseAd {
    private long mAdCacheTime;
    private long mCurrentPlayPosition;
    private TTFeedAd mFeedAd;

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public int getAdTypeName() {
        return 2;
    }

    public OpenFeedAd(TTFeedAd tTFeedAd, long j) {
        this.mFeedAd = tTFeedAd;
        this.mAdCacheTime = j;
    }

    public TTFeedAd getAd() {
        return this.mFeedAd;
    }

    public void setAd(TTFeedAd tTFeedAd) {
        this.mFeedAd = tTFeedAd;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public String getTitle() {
        TTFeedAd tTFeedAd = this.mFeedAd;
        return tTFeedAd == null ? "" : tTFeedAd.getTitle();
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public String getButtonText() {
        TTFeedAd tTFeedAd = this.mFeedAd;
        return tTFeedAd == null ? "" : tTFeedAd.getButtonText();
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public Bitmap getAdLogo() {
        TTFeedAd tTFeedAd = this.mFeedAd;
        if (tTFeedAd == null) {
            return null;
        }
        return tTFeedAd.getAdLogo();
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
        TTFeedAd tTFeedAd = this.mFeedAd;
        if (tTFeedAd == null) {
            return null;
        }
        return tTFeedAd.getAdView();
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public String getRequestId() {
        return OpenAdUtils.getAdRequestId(this.mFeedAd);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public String getIcon() {
        TTFeedAd tTFeedAd = this.mFeedAd;
        if (tTFeedAd == null || tTFeedAd.getIcon() == null) {
            return null;
        }
        return this.mFeedAd.getIcon().getImageUrl();
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public String getDescription() {
        TTFeedAd tTFeedAd = this.mFeedAd;
        if (tTFeedAd == null) {
            return null;
        }
        return tTFeedAd.getDescription();
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public List<IDJXAd.Image> getImageList() {
        TTFeedAd tTFeedAd = this.mFeedAd;
        if (tTFeedAd == null || tTFeedAd.getImageList() == null || this.mFeedAd.getImageList().isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this.mFeedAd.getImageList().iterator();
        while (it.hasNext()) {
            arrayList.add(new OpenImageAd((TTImage) it.next()));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public String getCoverUrl() {
        TTFeedAd tTFeedAd = this.mFeedAd;
        if (tTFeedAd != null && tTFeedAd.getVideoCoverImage() != null) {
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
        TTFeedAd tTFeedAd = this.mFeedAd;
        if (tTFeedAd == null) {
            return 0L;
        }
        long videoDuration = (long) tTFeedAd.getVideoDuration();
        return videoDuration < 1000 ? videoDuration * 1000 : videoDuration;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public IDJXAd.CustomVideo getCustomVideo() {
        TTFeedAd tTFeedAd = this.mFeedAd;
        if (tTFeedAd == null || tTFeedAd.getCustomVideo() == null) {
            return null;
        }
        return new OpenCustomVideo(this.mFeedAd.getCustomVideo());
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public Map<String, Object> getMediaExtraInfo() {
        return OpenAdUtils.getMediaExtraInfo(this.mFeedAd);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, final IDJXAd.AdInteractionListener adInteractionListener) {
        TTFeedAd tTFeedAd = this.mFeedAd;
        if (tTFeedAd == null) {
            return;
        }
        tTFeedAd.registerViewForInteraction(viewGroup, list, list2, new TTNativeAd.AdInteractionListener() { // from class: com.bytedance.sdk.djx.core.business.ad.open.OpenFeedAd.1
            public void onAdClicked(View view, TTNativeAd tTNativeAd) {
                adInteractionListener.onAdClicked(view, new OpenNativeAd(tTNativeAd));
            }

            public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
                adInteractionListener.onAdCreativeClick(view, new OpenNativeAd(tTNativeAd));
            }

            public void onAdShow(TTNativeAd tTNativeAd) {
                adInteractionListener.onAdShow(new OpenNativeAd(tTNativeAd));
            }
        });
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void setVideoAdListener(final IDJXAd.VideoAdListener videoAdListener) {
        TTFeedAd tTFeedAd = this.mFeedAd;
        if (tTFeedAd == null || videoAdListener == null) {
            return;
        }
        tTFeedAd.setVideoAdListener(new TTFeedAd.VideoAdListener() { // from class: com.bytedance.sdk.djx.core.business.ad.open.OpenFeedAd.2
            public void onVideoLoad(TTFeedAd tTFeedAd2) {
                videoAdListener.onVideoLoad(new OpenFeedAd(tTFeedAd2, System.currentTimeMillis()));
            }

            public void onVideoError(int i, int i2) {
                videoAdListener.onVideoError(i, i2);
            }

            public void onVideoAdStartPlay(TTFeedAd tTFeedAd2) {
                videoAdListener.onVideoAdStartPlay(new OpenFeedAd(tTFeedAd2, System.currentTimeMillis()));
            }

            public void onVideoAdPaused(TTFeedAd tTFeedAd2) {
                videoAdListener.onVideoAdPaused(new OpenFeedAd(tTFeedAd2, System.currentTimeMillis()), OpenFeedAd.this.mCurrentPlayPosition, OpenFeedAd.this.mTotalDuration);
            }

            public void onVideoAdContinuePlay(TTFeedAd tTFeedAd2) {
                videoAdListener.onVideoAdContinuePlay(new OpenFeedAd(tTFeedAd2, System.currentTimeMillis()));
            }

            public void onProgressUpdate(long j, long j2) {
                videoAdListener.onProgressUpdate(j, j2);
                OpenFeedAd.this.mCurrentPlayPosition = j;
                OpenFeedAd.this.mTotalDuration = j2;
            }

            public void onVideoAdComplete(TTFeedAd tTFeedAd2) {
                videoAdListener.onVideoAdComplete(new OpenFeedAd(tTFeedAd2, System.currentTimeMillis()), OpenFeedAd.this.mTotalDuration);
            }
        });
    }
}

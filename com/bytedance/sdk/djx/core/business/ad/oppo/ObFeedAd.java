package com.bytedance.sdk.djx.core.business.ad.oppo;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.djx.core.business.ad.DJXBaseAd;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.ttshell.sdk.api.TTFeedOb;
import com.ttshell.sdk.api.TTNativeOb;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ObFeedAd extends DJXBaseAd {
    private long mAdCacheTime;
    private TTFeedOb mFeedAd;

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public int getAdTypeName() {
        return 4;
    }

    public ObFeedAd(TTFeedOb tTFeedOb, long j) {
        this.mFeedAd = tTFeedOb;
        this.mAdCacheTime = j;
    }

    public TTFeedOb getAd() {
        return this.mFeedAd;
    }

    public void setAd(TTFeedOb tTFeedOb) {
        this.mFeedAd = tTFeedOb;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public String getTitle() {
        TTFeedOb tTFeedOb = this.mFeedAd;
        return tTFeedOb == null ? "" : tTFeedOb.getTitle();
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public String getButtonText() {
        TTFeedOb tTFeedOb = this.mFeedAd;
        return tTFeedOb == null ? "" : tTFeedOb.getButtonText();
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public Bitmap getAdLogo() {
        TTFeedOb tTFeedOb = this.mFeedAd;
        if (tTFeedOb == null) {
            return null;
        }
        return tTFeedOb.getObLogo();
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
        TTFeedOb tTFeedOb = this.mFeedAd;
        if (tTFeedOb == null) {
            return null;
        }
        return tTFeedOb.getObView();
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public String getRequestId() {
        return OppoObUtils.getAdRequestId(this.mFeedAd);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public Map<String, Object> getMediaExtraInfo() {
        return OppoObUtils.getMediaExtraInfo(this.mFeedAd);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, final IDJXAd.AdInteractionListener adInteractionListener) {
        TTFeedOb tTFeedOb = this.mFeedAd;
        if (tTFeedOb == null) {
            return;
        }
        tTFeedOb.registerViewForInteraction(viewGroup, list, list2, new TTNativeOb.ObInteractionListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo.ObFeedAd.1
            public void onObClicked(View view, TTNativeOb tTNativeOb) {
                adInteractionListener.onAdClicked(view, new ObNativeAd(tTNativeOb));
            }

            public void onObCreativeClick(View view, TTNativeOb tTNativeOb) {
                adInteractionListener.onAdCreativeClick(view, new ObNativeAd(tTNativeOb));
            }

            public void onObShow(TTNativeOb tTNativeOb) {
                adInteractionListener.onAdShow(new ObNativeAd(tTNativeOb));
            }
        });
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void setVideoAdListener(final IDJXAd.VideoAdListener videoAdListener) {
        TTFeedOb tTFeedOb = this.mFeedAd;
        if (tTFeedOb == null || videoAdListener == null) {
            return;
        }
        tTFeedOb.setVideoObListener(new TTFeedOb.VideoObListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo.ObFeedAd.2
            public void onVideoLoad(TTFeedOb tTFeedOb2) {
                videoAdListener.onVideoLoad(new ObFeedAd(tTFeedOb2, System.currentTimeMillis()));
            }

            public void onVideoError(int i, int i2) {
                videoAdListener.onVideoError(i, i2);
            }

            public void onVideoObStartPlay(TTFeedOb tTFeedOb2) {
                videoAdListener.onVideoAdStartPlay(new ObFeedAd(tTFeedOb2, System.currentTimeMillis()));
            }

            public void onVideoObPaused(TTFeedOb tTFeedOb2) {
                videoAdListener.onVideoAdPaused(new ObFeedAd(tTFeedOb2, System.currentTimeMillis()), ObFeedAd.this.mCurrentPlayPosition, ObFeedAd.this.mTotalDuration);
            }

            public void onVideoObContinuePlay(TTFeedOb tTFeedOb2) {
                videoAdListener.onVideoAdContinuePlay(new ObFeedAd(tTFeedOb2, System.currentTimeMillis()));
            }

            public void onProgressUpdate(long j, long j2) {
                videoAdListener.onProgressUpdate(j, j2);
                ObFeedAd.this.mCurrentPlayPosition = j;
                ObFeedAd.this.mTotalDuration = j2;
            }

            public void onVideoObComplete(TTFeedOb tTFeedOb2) {
                videoAdListener.onVideoAdComplete(new ObFeedAd(tTFeedOb2, System.currentTimeMillis()), ObFeedAd.this.mTotalDuration);
            }
        });
    }
}

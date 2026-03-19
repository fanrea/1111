package com.bytedance.sdk.djx.core.business.ad.oppo;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.djx.core.business.ad.DJXBaseAd;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.ttshell.sdk.api.TTNativeExpressOb;
import com.ttshell.sdk.api.TTObDislike;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ObExpressAd extends DJXBaseAd {
    private long mAdCacheTime;
    private TTNativeExpressOb mNativeExpressOb;

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public int getAdTypeName() {
        return 3;
    }

    public ObExpressAd(TTNativeExpressOb tTNativeExpressOb, long j) {
        this.mNativeExpressOb = tTNativeExpressOb;
        this.mAdCacheTime = j;
    }

    public TTNativeExpressOb getAd() {
        return this.mNativeExpressOb;
    }

    public void setAd(TTNativeExpressOb tTNativeExpressOb) {
        this.mNativeExpressOb = tTNativeExpressOb;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public View getAdView() {
        TTNativeExpressOb tTNativeExpressOb = this.mNativeExpressOb;
        if (tTNativeExpressOb == null) {
            return null;
        }
        return tTNativeExpressOb.getExpressObView();
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public long getAdCacheTime() {
        return this.mAdCacheTime;
    }

    public void setAdCacheTime(long j) {
        this.mAdCacheTime = j;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public String getRequestId() {
        return OppoObUtils.getAdRequestId(this.mNativeExpressOb);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public Map<String, Object> getMediaExtraInfo() {
        return OppoObUtils.getMediaExtraInfo(this.mNativeExpressOb);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void destroy() {
        TTNativeExpressOb tTNativeExpressOb = this.mNativeExpressOb;
        if (tTNativeExpressOb != null) {
            tTNativeExpressOb.destroy();
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void setDislikeCallback(Activity activity, final IDJXAd.DislikeInteractionCallback dislikeInteractionCallback) {
        TTNativeExpressOb tTNativeExpressOb = this.mNativeExpressOb;
        if (tTNativeExpressOb == null) {
            return;
        }
        tTNativeExpressOb.setDislikeCallback(activity, new TTObDislike.DislikeInteractionCallback() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo.ObExpressAd.1
            public void onSelected(int i, String str) {
                IDJXAd.DislikeInteractionCallback dislikeInteractionCallback2 = dislikeInteractionCallback;
                if (dislikeInteractionCallback2 != null) {
                    dislikeInteractionCallback2.onSelected(i, str);
                }
            }

            public void onCancel() {
                IDJXAd.DislikeInteractionCallback dislikeInteractionCallback2 = dislikeInteractionCallback;
                if (dislikeInteractionCallback2 != null) {
                    dislikeInteractionCallback2.onCancel();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void setExpressVideoAdListener(final IDJXAd.ExpressVideoAdListener expressVideoAdListener) {
        TTNativeExpressOb tTNativeExpressOb = this.mNativeExpressOb;
        if (tTNativeExpressOb == null || expressVideoAdListener == null) {
            return;
        }
        tTNativeExpressOb.setVideoObListener(new TTNativeExpressOb.ExpressVideoObListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo.ObExpressAd.2
            public void onVideoLoad() {
                expressVideoAdListener.onVideoLoad();
            }

            public void onVideoError(int i, int i2) {
                expressVideoAdListener.onVideoError(i, i2);
            }

            public void onVideoObStartPlay() {
                expressVideoAdListener.onVideoAdStartPlay();
            }

            public void onVideoObPaused() {
                expressVideoAdListener.onVideoAdPaused(ObExpressAd.this.mCurrentPlayPosition, ObExpressAd.this.mTotalDuration);
            }

            public void onVideoObContinuePlay() {
                expressVideoAdListener.onVideoAdContinuePlay();
            }

            public void onProgressUpdate(long j, long j2) {
                expressVideoAdListener.onProgressUpdate(j, j2);
                ObExpressAd.this.mCurrentPlayPosition = j;
                ObExpressAd.this.mTotalDuration = j2;
            }

            public void onVideoObComplete() {
                expressVideoAdListener.onVideoAdComplete(ObExpressAd.this.mTotalDuration);
            }

            public void onClickRetry() {
                expressVideoAdListener.onClickRetry();
            }
        });
    }
}

package com.bytedance.sdk.djx.core.business.ad.open;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.djx.core.business.ad.DJXBaseAd;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class OpenExpressAd extends DJXBaseAd {
    private long mAdCacheTime;
    protected IDJXAd.AdExpressInteractionListener mExpressListener;
    private final IDJXAd.AdExpressInteractionListener mInnerAdListener = new IDJXAd.AdExpressInteractionListener() { // from class: com.bytedance.sdk.djx.core.business.ad.open.OpenExpressAd.4
        @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.AdExpressInteractionListener
        public void onRenderFail(IDJXAd iDJXAd, String str, int i) {
            if (OpenExpressAd.this.mExpressListener != null) {
                OpenExpressAd.this.mExpressListener.onRenderFail(iDJXAd, str, i);
            }
        }

        @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.AdExpressInteractionListener
        public void onRenderSuccess(IDJXAd iDJXAd, float f, float f2) {
            if (OpenExpressAd.this.mExpressListener != null) {
                OpenExpressAd.this.mExpressListener.onRenderSuccess(iDJXAd, f, f2);
            }
        }

        @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.AdExpressInteractionListener
        public void onAdDismiss() {
            if (OpenExpressAd.this.mExpressListener != null) {
                OpenExpressAd.this.mExpressListener.onAdDismiss();
            }
        }

        @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.AdInteractionListener
        public void onAdClicked(View view, IDJXAd iDJXAd) {
            if (OpenExpressAd.this.mExpressListener != null) {
                OpenExpressAd.this.mExpressListener.onAdClicked(view, iDJXAd);
            }
        }

        @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.AdInteractionListener
        public void onAdCreativeClick(View view, IDJXAd iDJXAd) {
            if (OpenExpressAd.this.mExpressListener != null) {
                OpenExpressAd.this.mExpressListener.onAdCreativeClick(view, iDJXAd);
            }
        }

        @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.AdInteractionListener
        public void onAdShow(IDJXAd iDJXAd) {
            if (OpenExpressAd.this.mExpressListener != null) {
                OpenExpressAd.this.mExpressListener.onAdShow(iDJXAd);
            }
        }
    };
    protected TTNativeExpressAd mNativeExpressAd;

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public int getAdTypeName() {
        return 1;
    }

    public OpenExpressAd(TTNativeExpressAd tTNativeExpressAd, long j) {
        this.mNativeExpressAd = tTNativeExpressAd;
        this.mAdCacheTime = j;
    }

    public TTNativeExpressAd getAd() {
        return this.mNativeExpressAd;
    }

    public void setAd(TTNativeExpressAd tTNativeExpressAd) {
        this.mNativeExpressAd = tTNativeExpressAd;
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
        TTNativeExpressAd tTNativeExpressAd = this.mNativeExpressAd;
        if (tTNativeExpressAd == null) {
            return null;
        }
        return tTNativeExpressAd.getExpressAdView();
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public String getRequestId() {
        return OpenAdUtils.getAdRequestId(this.mNativeExpressAd);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public Map<String, Object> getMediaExtraInfo() {
        return OpenAdUtils.getMediaExtraInfo(this.mNativeExpressAd);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void destroy() {
        TTNativeExpressAd tTNativeExpressAd = this.mNativeExpressAd;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void setDislikeCallback(Activity activity, final IDJXAd.DislikeInteractionCallback dislikeInteractionCallback) {
        TTNativeExpressAd tTNativeExpressAd = this.mNativeExpressAd;
        if (tTNativeExpressAd == null) {
            return;
        }
        tTNativeExpressAd.setDislikeCallback(activity, new TTAdDislike.DislikeInteractionCallback() { // from class: com.bytedance.sdk.djx.core.business.ad.open.OpenExpressAd.1
            public void onShow() {
                IDJXAd.DislikeInteractionCallback dislikeInteractionCallback2 = dislikeInteractionCallback;
                if (dislikeInteractionCallback2 != null) {
                    dislikeInteractionCallback2.onShow();
                }
            }

            public void onSelected(int i, String str, boolean z) {
                IDJXAd.DislikeInteractionCallback dislikeInteractionCallback2 = dislikeInteractionCallback;
                if (dislikeInteractionCallback2 != null) {
                    dislikeInteractionCallback2.onSelected(i, str);
                }
            }

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

            public void onRefuse() {
                IDJXAd.DislikeInteractionCallback dislikeInteractionCallback2 = dislikeInteractionCallback;
                if (dislikeInteractionCallback2 != null) {
                    dislikeInteractionCallback2.onRefuse();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void setExpressVideoAdListener(final IDJXAd.ExpressVideoAdListener expressVideoAdListener) {
        TTNativeExpressAd tTNativeExpressAd = this.mNativeExpressAd;
        if (tTNativeExpressAd == null || expressVideoAdListener == null) {
            return;
        }
        tTNativeExpressAd.setVideoAdListener(new TTNativeExpressAd.ExpressVideoAdListener() { // from class: com.bytedance.sdk.djx.core.business.ad.open.OpenExpressAd.2
            public void onVideoLoad() {
                expressVideoAdListener.onVideoLoad();
            }

            public void onVideoError(int i, int i2) {
                expressVideoAdListener.onVideoError(i, i2);
            }

            public void onVideoAdStartPlay() {
                expressVideoAdListener.onVideoAdStartPlay();
            }

            public void onVideoAdPaused() {
                expressVideoAdListener.onVideoAdPaused(OpenExpressAd.this.mCurrentPlayPosition, OpenExpressAd.this.mTotalDuration);
            }

            public void onVideoAdContinuePlay() {
                expressVideoAdListener.onVideoAdContinuePlay();
            }

            public void onProgressUpdate(long j, long j2) {
                expressVideoAdListener.onProgressUpdate(j, j2);
                OpenExpressAd.this.mCurrentPlayPosition = j;
                OpenExpressAd.this.mTotalDuration = j2;
            }

            public void onVideoAdComplete() {
                expressVideoAdListener.onVideoAdComplete(OpenExpressAd.this.mTotalDuration);
            }

            public void onClickRetry() {
                expressVideoAdListener.onClickRetry();
            }
        });
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void showDislikeDialog(Activity activity, final IDJXAd.DislikeInteractionCallback dislikeInteractionCallback) {
        TTAdDislike dislikeDialog;
        TTNativeExpressAd tTNativeExpressAd = this.mNativeExpressAd;
        if (tTNativeExpressAd == null || (dislikeDialog = tTNativeExpressAd.getDislikeDialog(activity)) == null) {
            return;
        }
        dislikeDialog.setDislikeInteractionCallback(new TTAdDislike.DislikeInteractionCallback() { // from class: com.bytedance.sdk.djx.core.business.ad.open.OpenExpressAd.3
            public void onShow() {
                IDJXAd.DislikeInteractionCallback dislikeInteractionCallback2 = dislikeInteractionCallback;
                if (dislikeInteractionCallback2 != null) {
                    dislikeInteractionCallback2.onShow();
                }
            }

            public void onSelected(int i, String str, boolean z) {
                IDJXAd.DislikeInteractionCallback dislikeInteractionCallback2 = dislikeInteractionCallback;
                if (dislikeInteractionCallback2 != null) {
                    dislikeInteractionCallback2.onSelected(i, str);
                }
            }

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

            public void onRefuse() {
                IDJXAd.DislikeInteractionCallback dislikeInteractionCallback2 = dislikeInteractionCallback;
                if (dislikeInteractionCallback2 != null) {
                    dislikeInteractionCallback2.onRefuse();
                }
            }
        });
        dislikeDialog.showDislikeDialog();
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void setExpressAdInteractionListener(IDJXAd.AdExpressInteractionListener adExpressInteractionListener) {
        super.setExpressAdInteractionListener(adExpressInteractionListener);
        this.mExpressListener = adExpressInteractionListener;
    }

    public void setSlideIntervalTime(int i) {
        TTNativeExpressAd tTNativeExpressAd = this.mNativeExpressAd;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.setSlideIntervalTime(i);
        }
    }

    IDJXAd.AdExpressInteractionListener getInnerAdExpressListener() {
        return this.mInnerAdListener;
    }
}

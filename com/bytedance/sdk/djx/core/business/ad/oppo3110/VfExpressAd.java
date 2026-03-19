package com.bytedance.sdk.djx.core.business.ad.oppo3110;

import android.app.Activity;
import android.view.View;
import com.bykv.vk.openvk.TTNtExpressObject;
import com.bykv.vk.openvk.TTVfDislike;
import com.bytedance.sdk.djx.core.business.ad.DJXBaseAd;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class VfExpressAd extends DJXBaseAd {
    private long mAdCacheTime;
    protected IDJXAd.AdExpressInteractionListener mExpressListener;
    private final IDJXAd.AdExpressInteractionListener mInnerAdListener = new IDJXAd.AdExpressInteractionListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo3110.VfExpressAd.4
        @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.AdExpressInteractionListener
        public void onRenderFail(IDJXAd iDJXAd, String str, int i) {
            if (VfExpressAd.this.mExpressListener != null) {
                VfExpressAd.this.mExpressListener.onRenderFail(iDJXAd, str, i);
            }
        }

        @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.AdExpressInteractionListener
        public void onRenderSuccess(IDJXAd iDJXAd, float f, float f2) {
            if (VfExpressAd.this.mExpressListener != null) {
                VfExpressAd.this.mExpressListener.onRenderSuccess(iDJXAd, f, f2);
            }
        }

        @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.AdExpressInteractionListener
        public void onAdDismiss() {
            if (VfExpressAd.this.mExpressListener != null) {
                VfExpressAd.this.mExpressListener.onAdDismiss();
            }
        }

        @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.AdInteractionListener
        public void onAdClicked(View view, IDJXAd iDJXAd) {
            if (VfExpressAd.this.mExpressListener != null) {
                VfExpressAd.this.mExpressListener.onAdClicked(view, iDJXAd);
            }
        }

        @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.AdInteractionListener
        public void onAdCreativeClick(View view, IDJXAd iDJXAd) {
            if (VfExpressAd.this.mExpressListener != null) {
                VfExpressAd.this.mExpressListener.onAdCreativeClick(view, iDJXAd);
            }
        }

        @Override // com.bytedance.sdk.djx.core.business.ad.IDJXAd.AdInteractionListener
        public void onAdShow(IDJXAd iDJXAd) {
            if (VfExpressAd.this.mExpressListener != null) {
                VfExpressAd.this.mExpressListener.onAdShow(iDJXAd);
            }
        }
    };
    protected TTNtExpressObject mNativeExpressVf;

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public int getAdTypeName() {
        return 5;
    }

    public VfExpressAd(TTNtExpressObject tTNtExpressObject, long j) {
        this.mNativeExpressVf = tTNtExpressObject;
        this.mAdCacheTime = j;
    }

    public TTNtExpressObject getAd() {
        return this.mNativeExpressVf;
    }

    public void setAd(TTNtExpressObject tTNtExpressObject) {
        this.mNativeExpressVf = tTNtExpressObject;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public View getAdView() {
        TTNtExpressObject tTNtExpressObject = this.mNativeExpressVf;
        if (tTNtExpressObject == null) {
            return null;
        }
        return tTNtExpressObject.getExpressNtView();
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
        return OppoVfUtils.getAdRequestId(this.mNativeExpressVf);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public Map<String, Object> getMediaExtraInfo() {
        return OppoVfUtils.getMediaExtraInfo(this.mNativeExpressVf);
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void destroy() {
        TTNtExpressObject tTNtExpressObject = this.mNativeExpressVf;
        if (tTNtExpressObject != null) {
            tTNtExpressObject.destroy();
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void setDislikeCallback(Activity activity, final IDJXAd.DislikeInteractionCallback dislikeInteractionCallback) {
        TTNtExpressObject tTNtExpressObject = this.mNativeExpressVf;
        if (tTNtExpressObject == null) {
            return;
        }
        tTNtExpressObject.setDislikeCallback(activity, new TTVfDislike.DislikeInteractionCallback() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo3110.VfExpressAd.1
            public void onShow() {
                IDJXAd.DislikeInteractionCallback dislikeInteractionCallback2 = dislikeInteractionCallback;
                if (dislikeInteractionCallback2 != null) {
                    dislikeInteractionCallback2.onShow();
                }
            }

            public void onSelected(int i, String str) {
                IDJXAd.DislikeInteractionCallback dislikeInteractionCallback2 = dislikeInteractionCallback;
                if (dislikeInteractionCallback2 != null) {
                    dislikeInteractionCallback2.onSelected(i, str);
                }
            }

            public void onSelected(int i, String str, boolean z) {
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
        TTNtExpressObject tTNtExpressObject = this.mNativeExpressVf;
        if (tTNtExpressObject == null || expressVideoAdListener == null) {
            return;
        }
        tTNtExpressObject.setVideoListener(new TTNtExpressObject.ExpressVideoListener() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo3110.VfExpressAd.2
            public void onVideoLoad() {
                expressVideoAdListener.onVideoLoad();
            }

            public void onVideoError(int i, int i2) {
                expressVideoAdListener.onVideoError(i, i2);
            }

            public void onVideoStartPlay() {
                expressVideoAdListener.onVideoAdStartPlay();
            }

            public void onVideoPaused() {
                expressVideoAdListener.onVideoAdPaused(VfExpressAd.this.mCurrentPlayPosition, VfExpressAd.this.mTotalDuration);
            }

            public void onVideoContinuePlay() {
                expressVideoAdListener.onVideoAdContinuePlay();
            }

            public void onProgressUpdate(long j, long j2) {
                expressVideoAdListener.onProgressUpdate(j, j2);
                VfExpressAd.this.mCurrentPlayPosition = j;
                VfExpressAd.this.mTotalDuration = j2;
            }

            public void onVideoComplete() {
                expressVideoAdListener.onVideoAdComplete(VfExpressAd.this.mTotalDuration);
            }

            public void onClickRetry() {
                expressVideoAdListener.onClickRetry();
            }
        });
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void showDislikeDialog(Activity activity, final IDJXAd.DislikeInteractionCallback dislikeInteractionCallback) {
        TTVfDislike dislikeDialog;
        TTNtExpressObject tTNtExpressObject = this.mNativeExpressVf;
        if (tTNtExpressObject == null || (dislikeDialog = tTNtExpressObject.getDislikeDialog(activity)) == null) {
            return;
        }
        dislikeDialog.setDislikeInteractionCallback(new TTVfDislike.DislikeInteractionCallback() { // from class: com.bytedance.sdk.djx.core.business.ad.oppo3110.VfExpressAd.3
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

    IDJXAd.AdExpressInteractionListener getInnerAdExpressListener() {
        return this.mInnerAdListener;
    }
}

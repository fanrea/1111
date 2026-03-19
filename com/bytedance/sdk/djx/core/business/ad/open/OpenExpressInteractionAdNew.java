package com.bytedance.sdk.djx.core.business.ad.open;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.djx.core.business.ad.DJXBaseAd;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class OpenExpressInteractionAdNew extends DJXBaseAd {
    private static final String TAG = "OpenExpressInteractionAdNew";
    private long mAdCacheTime;
    protected IDJXAd.FullVideoListener mFullVideoListener;
    protected TTFullScreenVideoAd mNativeExpressAd;

    public OpenExpressInteractionAdNew(TTFullScreenVideoAd tTFullScreenVideoAd, long j) {
        this.mNativeExpressAd = tTFullScreenVideoAd;
        this.mAdCacheTime = j;
    }

    public TTFullScreenVideoAd getAd() {
        return this.mNativeExpressAd;
    }

    public void setAd(TTFullScreenVideoAd tTFullScreenVideoAd) {
        this.mNativeExpressAd = tTFullScreenVideoAd;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public long getAdCacheTime() {
        return this.mAdCacheTime;
    }

    public void setAdCacheTime(long j) {
        this.mAdCacheTime = j;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void show(Context context) {
        if (context instanceof Activity) {
            try {
                TTFullScreenVideoAd tTFullScreenVideoAd = this.mNativeExpressAd;
                if (tTFullScreenVideoAd != null) {
                    tTFullScreenVideoAd.showFullScreenVideoAd((Activity) context);
                } else {
                    IDJXAd.FullVideoListener fullVideoListener = this.mFullVideoListener;
                    if (fullVideoListener != null) {
                        fullVideoListener.onAdClose(this);
                    }
                }
                return;
            } catch (Throwable th) {
                LG.d(TAG, "show full screen activity error", th);
                IDJXAd.FullVideoListener fullVideoListener2 = this.mFullVideoListener;
                if (fullVideoListener2 != null) {
                    fullVideoListener2.onAdClose(this);
                    return;
                }
                return;
            }
        }
        IDJXAd.FullVideoListener fullVideoListener3 = this.mFullVideoListener;
        if (fullVideoListener3 != null) {
            fullVideoListener3.onAdClose(this);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void setFullVideoListener(IDJXAd.FullVideoListener fullVideoListener) {
        this.mFullVideoListener = fullVideoListener;
    }

    public IDJXAd.FullVideoListener getFullVideoListener() {
        return this.mFullVideoListener;
    }
}

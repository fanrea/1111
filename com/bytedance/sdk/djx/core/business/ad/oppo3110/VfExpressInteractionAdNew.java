package com.bytedance.sdk.djx.core.business.ad.oppo3110;

import android.app.Activity;
import android.content.Context;
import com.bykv.vk.openvk.TTFullVideoObject;
import com.bytedance.sdk.djx.core.business.ad.DJXBaseAd;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.bytedance.sdk.djx.utils.LG;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class VfExpressInteractionAdNew extends DJXBaseAd {
    private static final String TAG = "VfExpressInteractionAdNew";
    private long mAdCacheTime;
    protected IDJXAd.FullVideoListener mFullVideoListener;
    protected TTFullVideoObject mNativeExpressAd;

    public VfExpressInteractionAdNew(TTFullVideoObject tTFullVideoObject, long j) {
        this.mNativeExpressAd = tTFullVideoObject;
        this.mAdCacheTime = j;
    }

    public TTFullVideoObject getAd() {
        return this.mNativeExpressAd;
    }

    public void setAd(TTFullVideoObject tTFullVideoObject) {
        this.mNativeExpressAd = tTFullVideoObject;
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
                TTFullVideoObject tTFullVideoObject = this.mNativeExpressAd;
                if (tTFullVideoObject != null) {
                    tTFullVideoObject.showFullVideoVs((Activity) context);
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

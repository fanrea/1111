package com.kwad.components.ct.coupon.model;

import com.kwad.sdk.core.b;
import com.kwad.sdk.core.response.a.a;
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class CouponStatus extends a implements b, Serializable {
    private static final int DEF_COUPON_VIDEO_SECONDS = 5;
    private static final long serialVersionUID = 8301131859564901468L;
    public volatile CouponStatusInfo couponStatusInfo;
    public volatile SdkConfigData.CouponActiveConfig couponActiveConfig = null;
    public int currentWatchVideoCount = 0;
    public int winningTimes = 0;

    public int getCouponVideoThreshold() {
        if (this.couponActiveConfig != null) {
            return this.couponActiveConfig.videoThreshold;
        }
        return Integer.MAX_VALUE;
    }

    public int getCouponVideoSeconds() {
        if (this.couponActiveConfig != null) {
            return this.couponActiveConfig.videoSeconds;
        }
        return 5;
    }

    public int getStatusCode() {
        if (this.couponStatusInfo != null) {
            return this.couponStatusInfo.statusCode;
        }
        return -1;
    }

    public void setStatusCode(int i) {
        if (this.couponStatusInfo != null) {
            this.couponStatusInfo.statusCode = i;
        }
    }

    public boolean isNewUser() {
        return this.couponStatusInfo != null && this.couponStatusInfo.isNewUser;
    }

    public double getCurrTotalAmount() {
        if (this.couponStatusInfo != null) {
            return this.couponStatusInfo.currTotalAmount;
        }
        return 0.0d;
    }

    public boolean isWaitingOpen() {
        if (isNewUser()) {
            return true;
        }
        return getStatusCode() == 0 && this.currentWatchVideoCount == this.couponActiveConfig.videoThreshold;
    }

    public boolean isAccumulating() {
        return !isNewUser() && getStatusCode() == 0 && this.currentWatchVideoCount < this.couponActiveConfig.videoThreshold;
    }

    public boolean isEnable() {
        return this.couponActiveConfig != null && this.couponActiveConfig.videoThreshold > 0 && this.couponActiveConfig.videoSeconds > 0;
    }
}

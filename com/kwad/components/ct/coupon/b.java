package com.kwad.components.ct.coupon;

import android.text.TextUtils;
import com.kwad.components.ct.coupon.model.CouponStatus;
import com.kwad.components.ct.coupon.model.CouponStatusInfo;
import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.utils.ag;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b {
    private static volatile b amB;
    private final CouponStatus amC;
    private a amD;
    private boolean amE;
    private boolean amF;
    public volatile boolean amG = false;

    public interface a {
        void xw();
    }

    private b() {
        CouponStatus couponStatus = new CouponStatus();
        this.amC = couponStatus;
        try {
            String strH = ag.h("ksadsdk_pref", "key_couponActiveData", (String) null);
            if (TextUtils.isEmpty(strH)) {
                return;
            }
            SdkConfigData.CouponActiveConfig couponActiveConfig = new SdkConfigData.CouponActiveConfig();
            couponActiveConfig.parseJson(new JSONObject(strH));
            couponStatus.couponActiveConfig = couponActiveConfig;
        } catch (JSONException unused) {
        }
    }

    public static b xo() {
        if (amB == null) {
            synchronized (b.class) {
                if (amB == null) {
                    amB = new b();
                }
            }
        }
        return amB;
    }

    public final CouponStatus xp() {
        return this.amC;
    }

    public final boolean xq() {
        return this.amC.isNewUser() && !this.amE;
    }

    public final void bl(boolean z) {
        this.amE = true;
    }

    public final void a(SdkConfigData.CouponActiveConfig couponActiveConfig) {
        com.kwad.sdk.core.d.c.d("CouponManager", "setCouponActiveConfig : " + couponActiveConfig);
        this.amC.couponActiveConfig = couponActiveConfig;
        if (couponActiveConfig != null) {
            ag.g("ksadsdk_pref", "key_couponActiveData", couponActiveConfig.toJson().toString());
        }
    }

    public final boolean b(CouponStatusInfo couponStatusInfo) {
        com.kwad.sdk.core.d.c.d("CouponManager", "update couponStatusInfo=" + couponStatusInfo.toJson().toString());
        boolean z = !a(this.amC.couponStatusInfo, couponStatusInfo);
        this.amC.couponStatusInfo = couponStatusInfo;
        return z;
    }

    private static boolean a(CouponStatusInfo couponStatusInfo, CouponStatusInfo couponStatusInfo2) {
        if (couponStatusInfo == couponStatusInfo2) {
            return true;
        }
        return couponStatusInfo != null && couponStatusInfo.statusCode == couponStatusInfo2.statusCode;
    }

    public final void xr() {
        this.amC.currentWatchVideoCount = 0;
    }

    public final void xs() {
        a aVar;
        this.amC.currentWatchVideoCount++;
        com.kwad.sdk.core.d.c.d("CouponManager", "当前播放 " + this.amC.currentWatchVideoCount + "个视频");
        if (this.amC.currentWatchVideoCount < this.amC.getCouponVideoThreshold() || (aVar = this.amD) == null) {
            return;
        }
        CouponStatusInfo couponStatusInfo = this.amC.couponStatusInfo;
        aVar.xw();
    }

    public final boolean isAccumulating() {
        return this.amC.isAccumulating();
    }

    public final ActivityInfo xt() {
        if (this.amC.couponActiveConfig != null) {
            return this.amC.couponActiveConfig.activityInfo;
        }
        return null;
    }

    public final void a(a aVar) {
        this.amD = aVar;
    }

    public final void bm(boolean z) {
        this.amF = true;
    }

    public final boolean xu() {
        return this.amF;
    }

    public final int getCouponVideoSeconds() {
        return this.amC.getCouponVideoSeconds();
    }

    public final void bn(boolean z) {
        this.amG = true;
    }

    public final boolean xv() {
        boolean z = this.amG;
        this.amG = false;
        return z;
    }
}

package com.bytedance.sdk.djx.core.business.ad.open;

import android.app.Activity;
import com.bytedance.applog.aggregation.MetricsSQLiteCacheKt;
import com.bytedance.sdk.djx.core.business.ad.AdComplianceInfo;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.Reflector;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class OpenDrawFeedAd extends OpenFeedAd {
    private final TTDrawFeedAd mDrawFeedAd;

    public static class LiveAdCoupon {
        public int amount;
        public String expireTime;
        public boolean hasCoupon;
        public String startTime;
        public int threshold;
        public int type;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.open.OpenFeedAd, com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public int getAdTypeName() {
        return 7;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public AdComplianceInfo getAdComplianceInfo() {
        ComplianceInfo complianceInfo = this.mDrawFeedAd.getComplianceInfo();
        if (complianceInfo == null) {
            return null;
        }
        AdComplianceInfo adComplianceInfo = new AdComplianceInfo();
        adComplianceInfo.appName = complianceInfo.getAppName();
        adComplianceInfo.developerName = complianceInfo.getDeveloperName();
        adComplianceInfo.appVersion = complianceInfo.getAppVersion();
        adComplianceInfo.privacyUrl = complianceInfo.getPrivacyUrl();
        adComplianceInfo.permissionsMap = complianceInfo.getPermissionsMap();
        try {
            adComplianceInfo.permissionUrl = (String) Reflector.with(complianceInfo).method("getPermissionUrl", new Class[0]).call(new Object[0]);
        } catch (Reflector.DJXReflectedException unused) {
        }
        try {
            adComplianceInfo.functionDescUrl = (String) Reflector.with(complianceInfo).method("getFunctionDescUrl", new Class[0]).call(new Object[0]);
            return adComplianceInfo;
        } catch (Reflector.DJXReflectedException unused2) {
            return adComplianceInfo;
        }
    }

    public LiveAdCoupon getLiveAdCoupon() {
        TTDrawFeedAd tTDrawFeedAd = this.mDrawFeedAd;
        LiveAdCoupon liveAdCoupon = null;
        if (tTDrawFeedAd != null) {
            Map mediaExtraInfo = tTDrawFeedAd.getMediaExtraInfo();
            if (mediaExtraInfo.get("coupon") != null) {
                JSONObject jSONObject = (JSONObject) mediaExtraInfo.get("coupon");
                if (jSONObject == null) {
                    return null;
                }
                liveAdCoupon = new LiveAdCoupon();
                try {
                    liveAdCoupon.type = ((Integer) jSONObject.get("type")).intValue();
                    liveAdCoupon.threshold = ((Integer) jSONObject.get("threshold")).intValue();
                    liveAdCoupon.amount = ((Integer) jSONObject.get("amount")).intValue();
                    liveAdCoupon.startTime = (String) jSONObject.get(MetricsSQLiteCacheKt.METRICS_START_TIME);
                    liveAdCoupon.expireTime = (String) jSONObject.get("expire_time");
                } catch (JSONException e) {
                    LG.e("Parse coupon info failed: " + e);
                }
            }
        }
        return liveAdCoupon;
    }

    public int getImageMode() {
        TTDrawFeedAd tTDrawFeedAd = this.mDrawFeedAd;
        if (tTDrawFeedAd != null) {
            return tTDrawFeedAd.getImageMode();
        }
        return 0;
    }

    public OpenDrawFeedAd(TTDrawFeedAd tTDrawFeedAd, long j) {
        super(tTDrawFeedAd, j);
        this.mDrawFeedAd = tTDrawFeedAd;
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void setDrawVideoListener(final IDJXAd.DrawVideoListener drawVideoListener) {
        TTDrawFeedAd tTDrawFeedAd = this.mDrawFeedAd;
        if (tTDrawFeedAd == null || drawVideoListener == null) {
            return;
        }
        tTDrawFeedAd.setDrawVideoListener(new TTDrawFeedAd.DrawVideoListener() { // from class: com.bytedance.sdk.djx.core.business.ad.open.OpenDrawFeedAd.1
            public void onClickRetry() {
                drawVideoListener.onClickRetry();
            }

            public void onClick() {
                drawVideoListener.onClick();
            }
        });
    }

    @Override // com.bytedance.sdk.djx.core.business.ad.DJXBaseAd, com.bytedance.sdk.djx.core.business.ad.IDJXAd
    public void showDislikeDialog(Activity activity, final IDJXAd.DislikeInteractionCallback dislikeInteractionCallback) {
        TTAdDislike dislikeDialog;
        TTDrawFeedAd tTDrawFeedAd = this.mDrawFeedAd;
        if (tTDrawFeedAd == null || (dislikeDialog = tTDrawFeedAd.getDislikeDialog(activity)) == null) {
            return;
        }
        dislikeDialog.setDislikeInteractionCallback(new TTAdDislike.DislikeInteractionCallback() { // from class: com.bytedance.sdk.djx.core.business.ad.open.OpenDrawFeedAd.2
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
}

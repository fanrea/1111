package com.bytedance.sdk.djx.core.business.ad.open;

import android.text.TextUtils;
import com.bytedance.sdk.djx.core.business.ad.AdKey;
import com.bytedance.sdk.djx.core.business.ad.AdUtils;
import com.bytedance.sdk.djx.core.business.ad.AdVidUtils;
import com.bytedance.sdk.djx.core.settings.SettingData;
import com.bytedance.sdk.djx.model.ev.BEADVideoPreload;
import com.bytedance.sdk.djx.utils.Encrypt;
import com.bytedance.sdk.djx.utils.Reflector;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class OpenAdUtils {
    private static final String MIN_USER_DATA_REPORT_VERSION = "3.6.0.0";
    private static final String OPEN_CLASS = "com.bytedance.sdk.openadsdk.TTAdNative";
    public static final long PRELOAD_AD_VIDEO_SIZE = 819200;

    OpenAdUtils() {
    }

    public static String getAdRequestId(Object obj) {
        if (obj == null) {
            return "";
        }
        Map mediaExtraInfo = null;
        if (obj instanceof TTNativeExpressAd) {
            mediaExtraInfo = ((TTNativeExpressAd) obj).getMediaExtraInfo();
        } else if (obj instanceof TTNativeAd) {
            mediaExtraInfo = ((TTNativeAd) obj).getMediaExtraInfo();
        } else if (obj instanceof TTRewardVideoAd) {
            mediaExtraInfo = ((TTRewardVideoAd) obj).getMediaExtraInfo();
        } else if (obj instanceof TTFullScreenVideoAd) {
            mediaExtraInfo = ((TTFullScreenVideoAd) obj).getMediaExtraInfo();
        }
        return mediaExtraInfo == null ? "" : String.valueOf(mediaExtraInfo.get("request_id"));
    }

    public static Map<String, Object> getMediaExtraInfo(Object obj) {
        Map mediaExtraInfo = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof TTNativeExpressAd) {
            mediaExtraInfo = ((TTNativeExpressAd) obj).getMediaExtraInfo();
        } else if (obj instanceof TTNativeAd) {
            mediaExtraInfo = ((TTNativeAd) obj).getMediaExtraInfo();
        } else if (obj instanceof TTRewardVideoAd) {
            mediaExtraInfo = ((TTRewardVideoAd) obj).getMediaExtraInfo();
        } else if (obj instanceof TTFullScreenVideoAd) {
            mediaExtraInfo = ((TTFullScreenVideoAd) obj).getMediaExtraInfo();
        }
        return AdUtils.adExtraTransform(mediaExtraInfo);
    }

    public static boolean isSupportTTSdkPlayer(TTDrawFeedAd tTDrawFeedAd) {
        if (TextUtils.isEmpty(getAdVideoUrl(tTDrawFeedAd))) {
            return false;
        }
        return SettingData.getInstance().isAdTTPlayer();
    }

    public static void preloadAd(TTDrawFeedAd tTDrawFeedAd) {
        String adVideoUrl = getAdVideoUrl(tTDrawFeedAd);
        if (TextUtils.isEmpty(adVideoUrl)) {
            return;
        }
        BEADVideoPreload.build(Encrypt.md5ToString(adVideoUrl), adVideoUrl, 819200L).send();
    }

    public static String getAdVideoUrl(TTDrawFeedAd tTDrawFeedAd) {
        if (tTDrawFeedAd == null || tTDrawFeedAd.getCustomVideo() == null) {
            return null;
        }
        return tTDrawFeedAd.getCustomVideo().getVideoUrl();
    }

    public static boolean checkDataReportVersion() {
        return AdUtils.isExist(OPEN_CLASS) && MIN_USER_DATA_REPORT_VERSION.compareTo(TTAdSdk.getAdManager().getSDKVersion()) <= 0;
    }

    public static AdSlot.Builder createAdSlotBuilder(String str, AdKey adKey) {
        AdSlot.Builder builder = new AdSlot.Builder();
        if (checkDataReportVersion()) {
            setUserData(builder, AdVidUtils.buildUserData(adKey));
        }
        builder.setExternalABVid(AdVidUtils.buildVid());
        return builder;
    }

    public static void setUserData(AdSlot.Builder builder, String str) {
        try {
            Reflector.on(builder.getClass()).method("setUserData", new Class[]{String.class}).callByCaller(builder, new Object[]{str});
        } catch (Throwable unused) {
        }
    }
}

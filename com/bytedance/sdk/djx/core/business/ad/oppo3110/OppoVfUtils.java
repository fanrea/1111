package com.bytedance.sdk.djx.core.business.ad.oppo3110;

import android.text.TextUtils;
import com.bykv.vk.openvk.TTDrawVfObject;
import com.bykv.vk.openvk.TTFullVideoObject;
import com.bykv.vk.openvk.TTNtExpressObject;
import com.bykv.vk.openvk.TTRdVideoObject;
import com.bykv.vk.openvk.TTVfObject;
import com.bykv.vk.openvk.VfSlot;
import com.bytedance.sdk.djx.core.business.ad.AdUtils;
import com.bytedance.sdk.djx.core.business.ad.AdVidUtils;
import com.bytedance.sdk.djx.core.settings.SettingData;
import com.bytedance.sdk.djx.model.ev.BEADVideoPreload;
import com.bytedance.sdk.djx.utils.Encrypt;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class OppoVfUtils {
    public static final long PRELOAD_AD_VIDEO_SIZE = 819200;

    OppoVfUtils() {
    }

    public static String getAdRequestId(Object obj) {
        if (obj == null) {
            return "";
        }
        Map mediaExtraInfo = null;
        if (obj instanceof TTNtExpressObject) {
            mediaExtraInfo = ((TTNtExpressObject) obj).getMediaExtraInfo();
        } else if (obj instanceof TTVfObject) {
            mediaExtraInfo = ((TTVfObject) obj).getMediaExtraInfo();
        } else if (obj instanceof TTRdVideoObject) {
            mediaExtraInfo = ((TTRdVideoObject) obj).getMediaExtraInfo();
        }
        return mediaExtraInfo == null ? "" : String.valueOf(mediaExtraInfo.get("request_id"));
    }

    public static Map<String, Object> getMediaExtraInfo(Object obj) {
        Map mediaExtraInfo = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof TTNtExpressObject) {
            mediaExtraInfo = ((TTNtExpressObject) obj).getMediaExtraInfo();
        } else if (obj instanceof TTVfObject) {
            mediaExtraInfo = ((TTVfObject) obj).getMediaExtraInfo();
        } else if (obj instanceof TTRdVideoObject) {
            mediaExtraInfo = ((TTRdVideoObject) obj).getMediaExtraInfo();
        } else if (obj instanceof TTFullVideoObject) {
            mediaExtraInfo = ((TTFullVideoObject) obj).getMediaExtraInfo();
        }
        return AdUtils.adExtraTransform(mediaExtraInfo);
    }

    public static boolean isSupportTTSdkPlayer(TTDrawVfObject tTDrawVfObject) {
        if (TextUtils.isEmpty(getAdVideoUrl(tTDrawVfObject))) {
            return false;
        }
        return SettingData.getInstance().isAdTTPlayer();
    }

    public static void preloadAd(TTDrawVfObject tTDrawVfObject) {
        String adVideoUrl = getAdVideoUrl(tTDrawVfObject);
        if (TextUtils.isEmpty(adVideoUrl)) {
            return;
        }
        BEADVideoPreload.build(Encrypt.md5ToString(adVideoUrl), adVideoUrl, 819200L).send();
    }

    public static String getAdVideoUrl(TTDrawVfObject tTDrawVfObject) {
        if (tTDrawVfObject == null || tTDrawVfObject.getCustomVideo() == null) {
            return null;
        }
        return tTDrawVfObject.getCustomVideo().getVideoUrl();
    }

    public static VfSlot.Builder createVfSlotBuilder() {
        VfSlot.Builder builder = new VfSlot.Builder();
        builder.setUserData(AdVidUtils.buildUserData(null));
        builder.setExternalABVid(AdVidUtils.buildVid());
        return builder;
    }
}

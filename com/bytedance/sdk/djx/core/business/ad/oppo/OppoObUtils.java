package com.bytedance.sdk.djx.core.business.ad.oppo;

import com.bytedance.sdk.djx.core.business.ad.AdUtils;
import com.ttshell.sdk.api.TTNativeExpressOb;
import com.ttshell.sdk.api.TTNativeOb;
import com.ttshell.sdk.api.TTRewardVideoOb;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class OppoObUtils {
    OppoObUtils() {
    }

    public static String getAdRequestId(Object obj) {
        if (obj == null) {
            return "";
        }
        Map mediaExtraInfo = null;
        if (obj instanceof TTNativeExpressOb) {
            mediaExtraInfo = ((TTNativeExpressOb) obj).getMediaExtraInfo();
        } else if (obj instanceof TTNativeOb) {
            mediaExtraInfo = ((TTNativeOb) obj).getMediaExtraInfo();
        } else if (obj instanceof TTRewardVideoOb) {
            mediaExtraInfo = ((TTRewardVideoOb) obj).getMediaExtraInfo();
        }
        return mediaExtraInfo == null ? "" : String.valueOf(mediaExtraInfo.get("request_id"));
    }

    public static Map<String, Object> getMediaExtraInfo(Object obj) {
        Map mediaExtraInfo = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof TTNativeExpressOb) {
            mediaExtraInfo = ((TTNativeExpressOb) obj).getMediaExtraInfo();
        } else if (obj instanceof TTNativeOb) {
            mediaExtraInfo = ((TTNativeOb) obj).getMediaExtraInfo();
        } else if (obj instanceof TTRewardVideoOb) {
            mediaExtraInfo = ((TTRewardVideoOb) obj).getMediaExtraInfo();
        }
        return AdUtils.adExtraTransform(mediaExtraInfo);
    }
}

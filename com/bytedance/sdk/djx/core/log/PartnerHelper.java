package com.bytedance.sdk.djx.core.log;

import android.text.TextUtils;
import com.bytedance.sdk.djx.core.DevInfo;
import com.bytedance.sdk.djx.core.api.req.FeedApi;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class PartnerHelper {
    private static final String P_MVID = "MVID";
    private static final String P_NEWS = "NEWS";
    private static final String P_VID = "VID";

    public static String getSiteId() {
        return DevInfo.sSiteId;
    }

    public static String getPartner(String str) {
        return DevInfo.sPartner;
    }

    public static String getScene(String str, String str2) {
        return !TextUtils.isEmpty(str2) ? str2 : ("hotsoon_video_detail_draw".equals(str) || FeedApi.CATEGORY_GRID.equals(str)) ? P_MVID : !"video".equals(str) ? (str == null || !str.startsWith("subv_")) ? P_NEWS : P_VID : P_VID;
    }

    public static String getPartnerType(String str, String str2) {
        return TextUtils.isEmpty(str2) ? ILogConst.PLAY_SOURCE_DEFAULT : "content";
    }
}

package com.bytedance.sdk.commonsdk.api.utils;

import android.text.TextUtils;
import com.bytedance.sdk.commonsdk.api.model.CommonError;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class NetUtils {
    private static final String REQ_ID = "X-Tt-Logid";

    private NetUtils() {
    }

    public static void injectReqId(CommonError commonError, Map<String, String> map) {
        if (map == null || commonError == null || !TextUtils.isEmpty(commonError.requestId)) {
            return;
        }
        String str = map.get("X-Tt-Logid");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        commonError.requestId = str;
    }
}

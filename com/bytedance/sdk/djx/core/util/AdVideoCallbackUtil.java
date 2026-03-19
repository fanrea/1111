package com.bytedance.sdk.djx.core.util;

import android.text.TextUtils;
import com.bytedance.sdk.djx.core.business.ad.AdKey;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.bytedance.sdk.djx.utils.Encrypt;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class AdVideoCallbackUtil {
    private static final String CURRENT_DURATION = "current_duration";
    private static final String INTERACTION_TYPE = "interaction_type";
    private static final String TOTAL_DURATION = "total_duration";

    public static void addCallbackParams(Map<String, Object> map, AdKey adKey, IDJXAd iDJXAd, String str) {
        if (adKey != null) {
            map.put(IDJXAd.AD_CODE_ID, adKey.getCodeId());
        }
        if (iDJXAd != null) {
            map.put("request_id", iDJXAd.getRequestId());
            map.put(INTERACTION_TYPE, Integer.valueOf(iDJXAd.getInteractionType()));
        }
        if (str == null || TextUtils.isEmpty(str)) {
            return;
        }
        String strMd5ToString = Encrypt.md5ToString(Encrypt.md5(str.getBytes()));
        if (!TextUtils.isEmpty(strMd5ToString) && strMd5ToString.length() > 16) {
            strMd5ToString = strMd5ToString.substring(0, 16);
        }
        map.put(IDJXAd.AD_UNIQUE_ID, strMd5ToString);
    }

    public static void addCallbackParams(Map<String, Object> map, String str, IDJXAd iDJXAd) {
        map.put(IDJXAd.AD_CODE_ID, str);
        if (iDJXAd != null) {
            map.put("request_id", iDJXAd.getRequestId());
        }
    }

    public static void addTotalDuration(long j, Map<String, Object> map) {
        map.put(TOTAL_DURATION, Long.valueOf(j));
    }

    public static void addCurrentDuration(long j, Map<String, Object> map) {
        map.put(CURRENT_DURATION, Long.valueOf(j));
    }

    public static long getTotalDuration(Map<String, Object> map) {
        if (map == null) {
            return 0L;
        }
        Object obj = map.get(TOTAL_DURATION);
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        return 0L;
    }

    public static long getCurrentDuration(Map<String, Object> map) {
        if (map == null) {
            return 0L;
        }
        Object obj = map.get(CURRENT_DURATION);
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        return 0L;
    }
}

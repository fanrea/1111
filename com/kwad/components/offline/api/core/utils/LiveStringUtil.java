package com.kwad.components.offline.api.core.utils;

import android.text.TextUtils;
import com.bytedance.sdk.djx.core.log.ILogConst;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class LiveStringUtil {
    public static String emptyIfNull(String str) {
        return str != null ? str : "";
    }

    public static boolean isNullString(String str) {
        return TextUtils.isEmpty(str) || ILogConst.CACHE_PLAY_REASON_NULL.equalsIgnoreCase(str);
    }

    public static boolean isEquals(String str, String str2) {
        return !TextUtils.isEmpty(str) && str.equals(str2);
    }
}

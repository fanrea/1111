package com.kwai.video.hodor.util;

import android.text.TextUtils;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class HeaderUtil {
    public static String parseHeaderMapToFlatString(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(": ");
            if (!TextUtils.isEmpty(entry.getValue())) {
                sb.append(entry.getValue());
            }
            sb.append("\r\n");
        }
        return sb.toString();
    }
}

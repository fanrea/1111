package com.kwad.components.offline.api.core.utils;

import com.alipay.sdk.m.s.a;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class LiveRequestDataUtils {
    public static String appendUrl(String str, Map<String, String> map) {
        String str2;
        if (map == null || map.size() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = map.keySet().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            str2 = a.n;
            if (!zHasNext) {
                break;
            }
            String next = it.next();
            if (map.get(next) != null) {
                sb.append(next).append("=").append(map.get(next)).append(a.n);
            }
        }
        String strSubstring = sb.toString().substring(0, r7.length() - 1);
        StringBuilder sbAppend = new StringBuilder().append(str);
        if (!str.contains("?")) {
            str2 = "?";
        }
        return sbAppend.append(str2).toString() + strSubstring;
    }
}

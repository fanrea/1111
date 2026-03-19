package com.bytedance.sdk.djx.net.img;

import android.net.Uri;
import com.alipay.sdk.m.l.a;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class CacheKeyOptUtils {
    private static final List<String> URL_SUFFIX_DOMIN_LIST = Arrays.asList("byteimg.com", "pstatp.com", "bytecdn.cn");

    private CacheKeyOptUtils() {
    }

    public static Uri getCacheKeySourceUri(Uri uri) {
        String path;
        return (!isEquivalentHostImgUri(uri) || (path = uri.getPath()) == null || path.length() <= 10) ? uri : Uri.parse(uri.getScheme() + uri.getPath());
    }

    private static boolean isEquivalentHostImgUri(Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            if (URL_SUFFIX_DOMIN_LIST.size() <= 0) {
                return false;
            }
            String scheme = uri.getScheme();
            if (a.r.equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                return matchSettingsList(uri.getAuthority());
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean matchSettingsList(String str) {
        Iterator<String> it = URL_SUFFIX_DOMIN_LIST.iterator();
        while (it.hasNext()) {
            if (str.endsWith(it.next())) {
                return true;
            }
        }
        return false;
    }
}

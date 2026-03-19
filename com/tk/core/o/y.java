package com.tk.core.o;

import android.text.TextUtils;
import com.kuaishou.tk.api.export.sdk.UriUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class y extends UriUtils {
    private static int da(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.startsWith(UriUtils.ASSET_PREFIX)) {
            return z.b(UriUtils.getResName(str), "drawable", null);
        }
        return z.b(str, "drawable", null);
    }

    public static String A(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(UriUtils.BUNDLE_PREFIX)) {
            return B(str, str2);
        }
        if (str.startsWith(UriUtils.FILE_PREFIX)) {
            return ax(str);
        }
        if (str.startsWith(UriUtils.ASSET_PREFIX)) {
            return ay(str);
        }
        return (str.startsWith("http://") || str.startsWith("https://")) ? str : B(str, str2);
    }

    private static String B(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strConcat = str2.concat(UriUtils.getMappedPath(str, UriUtils.BUNDLE_PREFIX));
        if (f.cS(strConcat)) {
            return strConcat;
        }
        com.tk.core.i.a.a("TKUriUtil", "showBundleImage", new Exception(str + " not exist"));
        return null;
    }

    private static String ax(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String mappedPath = UriUtils.getMappedPath(str, UriUtils.FILE_PREFIX);
        if (f.cS(mappedPath)) {
            return mappedPath;
        }
        com.tk.core.i.a.a("TKUriUtil", "showFileImage", new Exception(str + " not exist"));
        return null;
    }

    private static String ay(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String resName = UriUtils.getResName(str);
        if (da(resName) != 0) {
            return resName;
        }
        com.tk.core.i.a.a("TKUriUtil", "showAssetImage", new Exception(str + " not exist"));
        return null;
    }
}

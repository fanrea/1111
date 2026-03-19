package com.kuaishou.tk.api.export.sdk;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class UriUtils {
    public static final String ASSET_PREFIX = "asset://";
    public static final String BASE64_PREFIX = "data:image";
    public static final String BASE64_PREFIX2 = "data:Image";
    public static final String BUNDLE_PREFIX = "bundle://";
    public static final String FILE_PREFIX = "file://";
    public static final String HTTPS_PREFIX = "https://";
    public static final String HTTP_PREFIX = "http://";

    public static String getResName(String str) {
        int iLastIndexOf;
        String mappedPath = getMappedPath(str, ASSET_PREFIX);
        return (mappedPath == null || mappedPath.length() <= 0 || -1 == (iLastIndexOf = mappedPath.lastIndexOf("."))) ? mappedPath : mappedPath.substring(0, iLastIndexOf);
    }

    public static String getMappedPath(String str, String str2) {
        if (str == null || str.length() <= 0 || !str.startsWith(str2)) {
            return str;
        }
        return str.substring(str2 != null ? str2.length() : 0);
    }
}

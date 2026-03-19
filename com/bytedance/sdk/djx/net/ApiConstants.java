package com.bytedance.sdk.djx.net;

import com.bytedance.sdk.djx.utils.debug.DebugInfo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class ApiConstants {
    public static final String DEFAULT_HOST = "https://csj-sp.csjdeveloper.com";
    public static final String KEY_LOGID = "X-Tt-Logid";
    public static final String KEY_NONCE = "X-Nonce";
    public static final String KEY_SALT = "X-Salt";
    public static final String KEY_SIGN = "X-Signature";
    public static final String KEY_TIME = "X-Timestamp";
    public static final String KEY_TOKEN = "X-Access-Token";
    public static final String PATH_VERSION_1 = "/csj_sp/api/v1";

    private ApiConstants() {
    }

    public static String getHost() {
        String strHost = DebugInfo.Bridge.host();
        return (strHost == null || strHost.length() <= 0) ? DEFAULT_HOST : strHost;
    }

    public static String getHostWithPath() {
        return getHost() + PATH_VERSION_1;
    }
}

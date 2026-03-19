package com.lingku.xuanshang.xutils.http;

import com.bytedance.applog.log.LogUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public enum HttpMethod {
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    PATCH("PATCH"),
    HEAD("HEAD"),
    MOVE("MOVE"),
    COPY("COPY"),
    DELETE("DELETE"),
    OPTIONS("OPTIONS"),
    TRACE(LogUtils.EVENT_TYPE_TRACE),
    CONNECT("CONNECT");

    public final String b;

    HttpMethod(String str) {
        this.b = str;
    }

    public static boolean permitsCache(HttpMethod httpMethod) {
        return httpMethod == GET || httpMethod == POST;
    }

    public static boolean permitsRequestBody(HttpMethod httpMethod) {
        return httpMethod == null || httpMethod == POST || httpMethod == PUT || httpMethod == PATCH || httpMethod == DELETE;
    }

    public static boolean permitsRetry(HttpMethod httpMethod) {
        return httpMethod == GET;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.b;
    }
}

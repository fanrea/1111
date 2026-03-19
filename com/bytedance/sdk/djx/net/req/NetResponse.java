package com.bytedance.sdk.djx.net.req;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class NetResponse<T> {
    public int code;
    public T data;
    public Throwable error;
    public Map<String, String> headers;
    public String message;
    public NetBuilder netBuilder;

    public static <T> NetResponse<T> success(NetBuilder netBuilder, T t) {
        return new NetResponse<>(netBuilder, t);
    }

    public static <T> NetResponse<T> error(NetBuilder netBuilder, int i, String str, Throwable th) {
        return new NetResponse<>(netBuilder, i, str, th);
    }

    private NetResponse(NetBuilder netBuilder, T t) {
        this.netBuilder = netBuilder;
        this.data = t;
    }

    private NetResponse(NetBuilder netBuilder, int i, String str, Throwable th) {
        this.netBuilder = netBuilder;
        this.code = i;
        this.message = str;
        this.error = th;
    }

    public String getHeader(String str) {
        Map<String, String> map;
        if (TextUtils.isEmpty(str) || (map = this.headers) == null) {
            return null;
        }
        return map.get(str);
    }

    public NetResponse code(int i) {
        this.code = i;
        return this;
    }

    public NetResponse message(String str) {
        this.message = str;
        return this;
    }

    public NetResponse headers(Map<String, String> map) {
        this.headers = map;
        return this;
    }
}

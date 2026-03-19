package com.lingku.xuanshang.xutils.http.app;

import com.lingku.xuanshang.xutils.http.request.UriRequest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface RequestInterceptListener {
    void afterRequest(UriRequest uriRequest);

    void beforeRequest(UriRequest uriRequest);
}

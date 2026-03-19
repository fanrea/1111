package com.lingku.xuanshang.xutils.http.app;

import com.lingku.xuanshang.xutils.http.RequestParams;
import com.lingku.xuanshang.xutils.http.request.UriRequest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface RequestTracker {
    void onCache(UriRequest uriRequest, Object obj);

    void onCancelled(UriRequest uriRequest);

    void onError(UriRequest uriRequest, Throwable th, boolean z);

    void onFinished(UriRequest uriRequest);

    void onRequestCreated(UriRequest uriRequest);

    void onStart(RequestParams requestParams);

    void onSuccess(UriRequest uriRequest, Object obj);

    void onWaiting(RequestParams requestParams);
}

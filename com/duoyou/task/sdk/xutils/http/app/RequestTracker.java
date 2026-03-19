package com.duoyou.task.sdk.xutils.http.app;

import com.duoyou.task.sdk.xutils.http.RequestParams;
import com.duoyou.task.sdk.xutils.http.request.UriRequest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
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

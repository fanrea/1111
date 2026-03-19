package com.duoyou.task.sdk.xutils.http;

import com.duoyou.task.sdk.xutils.common.util.LogUtil;
import com.duoyou.task.sdk.xutils.http.app.RequestTracker;
import com.duoyou.task.sdk.xutils.http.request.UriRequest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class RequestTrackerWrapper implements RequestTracker {
    private final RequestTracker base;

    public RequestTrackerWrapper(RequestTracker requestTracker) {
        this.base = requestTracker;
    }

    @Override // com.duoyou.task.sdk.xutils.http.app.RequestTracker
    public void onWaiting(RequestParams requestParams) {
        try {
            this.base.onWaiting(requestParams);
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
    }

    @Override // com.duoyou.task.sdk.xutils.http.app.RequestTracker
    public void onStart(RequestParams requestParams) {
        try {
            this.base.onStart(requestParams);
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
    }

    @Override // com.duoyou.task.sdk.xutils.http.app.RequestTracker
    public void onRequestCreated(UriRequest uriRequest) {
        try {
            this.base.onRequestCreated(uriRequest);
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
    }

    @Override // com.duoyou.task.sdk.xutils.http.app.RequestTracker
    public void onCache(UriRequest uriRequest, Object obj) {
        try {
            this.base.onCache(uriRequest, obj);
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
    }

    @Override // com.duoyou.task.sdk.xutils.http.app.RequestTracker
    public void onSuccess(UriRequest uriRequest, Object obj) {
        try {
            this.base.onSuccess(uriRequest, obj);
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
    }

    @Override // com.duoyou.task.sdk.xutils.http.app.RequestTracker
    public void onCancelled(UriRequest uriRequest) {
        try {
            this.base.onCancelled(uriRequest);
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
    }

    @Override // com.duoyou.task.sdk.xutils.http.app.RequestTracker
    public void onError(UriRequest uriRequest, Throwable th, boolean z) {
        try {
            this.base.onError(uriRequest, th, z);
        } catch (Throwable th2) {
            LogUtil.e(th2.getMessage(), th2);
        }
    }

    @Override // com.duoyou.task.sdk.xutils.http.app.RequestTracker
    public void onFinished(UriRequest uriRequest) {
        try {
            this.base.onFinished(uriRequest);
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
    }
}

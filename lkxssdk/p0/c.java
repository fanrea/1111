package lkxssdk.p0;

import com.lingku.xuanshang.xutils.common.util.LogUtil;
import com.lingku.xuanshang.xutils.http.RequestParams;
import com.lingku.xuanshang.xutils.http.app.RequestTracker;
import com.lingku.xuanshang.xutils.http.request.UriRequest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class c implements RequestTracker {
    public final RequestTracker a;

    public c(RequestTracker requestTracker) {
        this.a = requestTracker;
    }

    @Override // com.lingku.xuanshang.xutils.http.app.RequestTracker
    public void onCache(UriRequest uriRequest, Object obj) {
        try {
            this.a.onCache(uriRequest, obj);
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
    }

    @Override // com.lingku.xuanshang.xutils.http.app.RequestTracker
    public void onCancelled(UriRequest uriRequest) {
        try {
            this.a.onCancelled(uriRequest);
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
    }

    @Override // com.lingku.xuanshang.xutils.http.app.RequestTracker
    public void onError(UriRequest uriRequest, Throwable th, boolean z) {
        try {
            this.a.onError(uriRequest, th, z);
        } catch (Throwable th2) {
            LogUtil.e(th2.getMessage(), th2);
        }
    }

    @Override // com.lingku.xuanshang.xutils.http.app.RequestTracker
    public void onFinished(UriRequest uriRequest) {
        try {
            this.a.onFinished(uriRequest);
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
    }

    @Override // com.lingku.xuanshang.xutils.http.app.RequestTracker
    public void onRequestCreated(UriRequest uriRequest) {
        try {
            this.a.onRequestCreated(uriRequest);
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
    }

    @Override // com.lingku.xuanshang.xutils.http.app.RequestTracker
    public void onStart(RequestParams requestParams) {
        try {
            this.a.onStart(requestParams);
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
    }

    @Override // com.lingku.xuanshang.xutils.http.app.RequestTracker
    public void onSuccess(UriRequest uriRequest, Object obj) {
        try {
            this.a.onSuccess(uriRequest, obj);
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
    }

    @Override // com.lingku.xuanshang.xutils.http.app.RequestTracker
    public void onWaiting(RequestParams requestParams) {
        try {
            this.a.onWaiting(requestParams);
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
    }
}

package com.duoyou.task.sdk.xutils.http;

import com.duoyou.task.sdk.xutils.HttpManager;
import com.duoyou.task.sdk.xutils.common.Callback;
import com.duoyou.task.sdk.xutils.x;
import java.lang.reflect.Type;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class HttpManagerImpl implements HttpManager {
    private static volatile HttpManagerImpl instance;
    private static final Object lock = new Object();

    private HttpManagerImpl() {
    }

    public static void registerInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new HttpManagerImpl();
                }
            }
        }
        x.Ext.setHttpManager(instance);
    }

    @Override // com.duoyou.task.sdk.xutils.HttpManager
    public <T> Callback.Cancelable get(RequestParams requestParams, Callback.CommonCallback<T> commonCallback) {
        return request(HttpMethod.GET, requestParams, commonCallback);
    }

    @Override // com.duoyou.task.sdk.xutils.HttpManager
    public <T> Callback.Cancelable post(RequestParams requestParams, Callback.CommonCallback<T> commonCallback) {
        return request(HttpMethod.POST, requestParams, commonCallback);
    }

    @Override // com.duoyou.task.sdk.xutils.HttpManager
    public <T> Callback.Cancelable request(HttpMethod httpMethod, RequestParams requestParams, Callback.CommonCallback<T> commonCallback) {
        requestParams.setMethod(httpMethod);
        return x.task().start(new HttpTask(requestParams, commonCallback instanceof Callback.Cancelable ? (Callback.Cancelable) commonCallback : null, commonCallback));
    }

    @Override // com.duoyou.task.sdk.xutils.HttpManager
    public <T> T getSync(RequestParams requestParams, Class<T> cls) {
        return (T) requestSync(HttpMethod.GET, requestParams, cls);
    }

    @Override // com.duoyou.task.sdk.xutils.HttpManager
    public <T> T postSync(RequestParams requestParams, Class<T> cls) {
        return (T) requestSync(HttpMethod.POST, requestParams, cls);
    }

    @Override // com.duoyou.task.sdk.xutils.HttpManager
    public <T> T requestSync(HttpMethod httpMethod, RequestParams requestParams, Class<T> cls) {
        return (T) requestSync(httpMethod, requestParams, new DefaultSyncCallback(cls));
    }

    @Override // com.duoyou.task.sdk.xutils.HttpManager
    public <T> T requestSync(HttpMethod httpMethod, RequestParams requestParams, Callback.TypedCallback<T> typedCallback) {
        requestParams.setMethod(httpMethod);
        return (T) x.task().startSync(new HttpTask(requestParams, null, typedCallback));
    }

    public class DefaultSyncCallback<T> implements Callback.TypedCallback<T> {
        private final Class<T> resultType;

        @Override // com.duoyou.task.sdk.xutils.common.Callback.CommonCallback
        public void onCancelled(Callback.CancelledException cancelledException) {
        }

        @Override // com.duoyou.task.sdk.xutils.common.Callback.CommonCallback
        public void onError(Throwable th, boolean z) {
        }

        @Override // com.duoyou.task.sdk.xutils.common.Callback.CommonCallback
        public void onFinished() {
        }

        @Override // com.duoyou.task.sdk.xutils.common.Callback.CommonCallback
        public void onSuccess(T t) {
        }

        public DefaultSyncCallback(Class<T> cls) {
            this.resultType = cls;
        }

        @Override // com.duoyou.task.sdk.xutils.common.Callback.TypedCallback
        public Type getLoadType() {
            return this.resultType;
        }
    }
}

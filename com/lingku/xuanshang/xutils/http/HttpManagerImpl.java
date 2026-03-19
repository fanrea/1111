package com.lingku.xuanshang.xutils.http;

import com.lingku.xuanshang.xutils.HttpManager;
import com.lingku.xuanshang.xutils.common.Callback;
import com.lingku.xuanshang.xutils.x;
import java.lang.reflect.Type;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class HttpManagerImpl implements HttpManager {
    public static final Object a = new Object();
    public static volatile HttpManagerImpl b;

    public class a<T> implements Callback.TypedCallback<T> {
        public final Class<T> a;

        public a(HttpManagerImpl httpManagerImpl, Class<T> cls) {
            this.a = cls;
        }

        @Override // com.lingku.xuanshang.xutils.common.Callback.TypedCallback
        public Type getLoadType() {
            return this.a;
        }

        @Override // com.lingku.xuanshang.xutils.common.Callback.CommonCallback
        public void onCancelled(Callback.CancelledException cancelledException) {
        }

        @Override // com.lingku.xuanshang.xutils.common.Callback.CommonCallback
        public void onError(Throwable th, boolean z) {
        }

        @Override // com.lingku.xuanshang.xutils.common.Callback.CommonCallback
        public void onFinished() {
        }

        @Override // com.lingku.xuanshang.xutils.common.Callback.CommonCallback
        public void onSuccess(T t) {
        }
    }

    public static void registerInstance() {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new HttpManagerImpl();
                }
            }
        }
        x.Ext.setHttpManager(b);
    }

    @Override // com.lingku.xuanshang.xutils.HttpManager
    public <T> Callback.Cancelable get(RequestParams requestParams, Callback.CommonCallback<T> commonCallback) {
        return request(HttpMethod.GET, requestParams, commonCallback);
    }

    @Override // com.lingku.xuanshang.xutils.HttpManager
    public <T> T getSync(RequestParams requestParams, Class<T> cls) {
        return (T) requestSync(HttpMethod.GET, requestParams, cls);
    }

    @Override // com.lingku.xuanshang.xutils.HttpManager
    public <T> Callback.Cancelable post(RequestParams requestParams, Callback.CommonCallback<T> commonCallback) {
        return request(HttpMethod.POST, requestParams, commonCallback);
    }

    @Override // com.lingku.xuanshang.xutils.HttpManager
    public <T> T postSync(RequestParams requestParams, Class<T> cls) {
        return (T) requestSync(HttpMethod.POST, requestParams, cls);
    }

    @Override // com.lingku.xuanshang.xutils.HttpManager
    public <T> Callback.Cancelable request(HttpMethod httpMethod, RequestParams requestParams, Callback.CommonCallback<T> commonCallback) {
        requestParams.setMethod(httpMethod);
        return x.task().start(new HttpTask(requestParams, commonCallback instanceof Callback.Cancelable ? (Callback.Cancelable) commonCallback : null, commonCallback));
    }

    @Override // com.lingku.xuanshang.xutils.HttpManager
    public <T> T requestSync(HttpMethod httpMethod, RequestParams requestParams, Callback.TypedCallback<T> typedCallback) {
        requestParams.setMethod(httpMethod);
        return (T) x.task().startSync(new HttpTask(requestParams, null, typedCallback));
    }

    @Override // com.lingku.xuanshang.xutils.HttpManager
    public <T> T requestSync(HttpMethod httpMethod, RequestParams requestParams, Class<T> cls) {
        return (T) requestSync(httpMethod, requestParams, new a(this, cls));
    }
}

package com.lingku.xuanshang.xutils;

import com.lingku.xuanshang.xutils.common.Callback;
import com.lingku.xuanshang.xutils.http.HttpMethod;
import com.lingku.xuanshang.xutils.http.RequestParams;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface HttpManager {
    <T> Callback.Cancelable get(RequestParams requestParams, Callback.CommonCallback<T> commonCallback);

    <T> T getSync(RequestParams requestParams, Class<T> cls);

    <T> Callback.Cancelable post(RequestParams requestParams, Callback.CommonCallback<T> commonCallback);

    <T> T postSync(RequestParams requestParams, Class<T> cls);

    <T> Callback.Cancelable request(HttpMethod httpMethod, RequestParams requestParams, Callback.CommonCallback<T> commonCallback);

    <T> T requestSync(HttpMethod httpMethod, RequestParams requestParams, Callback.TypedCallback<T> typedCallback);

    <T> T requestSync(HttpMethod httpMethod, RequestParams requestParams, Class<T> cls);
}

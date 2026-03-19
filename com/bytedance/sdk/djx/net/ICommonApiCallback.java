package com.bytedance.sdk.djx.net;

import com.bytedance.sdk.commonsdk.api.model.CommonError;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface ICommonApiCallback<T> {
    void onApiFailure(CommonError commonError, T t);

    void onApiSuccess(T t);
}

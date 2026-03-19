package com.bytedance.sdk.djx.net;

import com.bytedance.sdk.commonsdk.api.model.CommonError;
import com.bytedance.sdk.commonsdk.api.model.CommonOthers;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface ICommonReqCallback<T> {
    void onError(CommonError commonError);

    void onSuccess(T t, CommonOthers commonOthers);
}

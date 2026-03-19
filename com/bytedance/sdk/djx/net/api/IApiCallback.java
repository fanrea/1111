package com.bytedance.sdk.djx.net.api;

import com.bytedance.sdk.djx.model.DJXError;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface IApiCallback<T> {
    void onApiFailure(DJXError dJXError, T t);

    void onApiSuccess(T t);
}

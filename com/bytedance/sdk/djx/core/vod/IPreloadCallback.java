package com.bytedance.sdk.djx.core.vod;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface IPreloadCallback<T> {
    void onFailure(T t);

    void onSuccess(T t, String str, String str2, String str3);
}

package com.bytedance.rpc.callback;

import com.bytedance.rpc.RpcException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface RpcCallback<DATA> {
    void onFailure(RpcException rpcException);

    void onSuccess(DATA data);
}

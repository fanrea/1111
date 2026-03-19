package com.bytedance.sdk.djx.net.token;

import com.bytedance.sdk.commonsdk.api.model.CommonError;
import com.bytedance.sdk.commonsdk.api.model.CommonUser;
import com.bytedance.sdk.djx.net.api.TokenRsp;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface TokenApiRegisterCallback {
    void eventBusAddListener();

    void onApiFailure(CommonError commonError, TokenRsp tokenRsp, boolean z);

    void onApiFailureWhenDidDegrade(CommonError commonError, TokenRsp tokenRsp);

    void onApiSuccess(TokenRsp tokenRsp, CommonUser commonUser, boolean z);
}

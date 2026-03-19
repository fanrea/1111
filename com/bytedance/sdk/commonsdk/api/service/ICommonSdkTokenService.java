package com.bytedance.sdk.commonsdk.api.service;

import com.bytedance.sdk.djx.net.api.TokenApiConfig;
import com.bytedance.sdk.djx.net.api.TokenRsp;
import com.bytedance.sdk.djx.net.token.OnTokenResultListener;
import com.bytedance.sdk.djx.net.token.TokenApiRegisterCallback;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface ICommonSdkTokenService {
    boolean getRecommendSwitch();

    String getToken();

    String getUserId();

    String getUserMeta();

    int getUserType();

    String getUtUid();

    void handleBEBDDidComeEvent(TokenApiConfig tokenApiConfig, TokenApiRegisterCallback tokenApiRegisterCallback);

    void init(TokenApiConfig tokenApiConfig, TokenApiRegisterCallback tokenApiRegisterCallback, OnTokenResultListener onTokenResultListener);

    boolean isCustomLoginSuccess();

    boolean isGetTokenFromServer();

    boolean isHasSyncMark();

    boolean isSyncHistory();

    void saveToken(TokenRsp tokenRsp);

    void setRecommendSwitch(boolean z);

    void update(String str, TokenApiConfig tokenApiConfig, boolean z, TokenApiRegisterCallback tokenApiRegisterCallback);
}

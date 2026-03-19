package com.bytedance.sdk.commonsdk.register;

import com.bytedance.sdk.commonsdk.api.service.ICommonSdkTokenService;
import com.bytedance.sdk.djx.net.api.TokenApiConfig;
import com.bytedance.sdk.djx.net.api.TokenRsp;
import com.bytedance.sdk.djx.net.token.OnTokenResultListener;
import com.bytedance.sdk.djx.net.token.TokenApiRegisterCallback;
import com.bytedance.sdk.djx.proguard3.e.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class CommonSdkTokenService implements ICommonSdkTokenService {
    @Override // com.bytedance.sdk.commonsdk.api.service.ICommonSdkTokenService
    public void init(TokenApiConfig tokenApiConfig, TokenApiRegisterCallback tokenApiRegisterCallback, OnTokenResultListener onTokenResultListener) {
        a.a().a(tokenApiConfig, tokenApiRegisterCallback, onTokenResultListener);
    }

    @Override // com.bytedance.sdk.commonsdk.api.service.ICommonSdkTokenService
    public void update(String str, TokenApiConfig tokenApiConfig, boolean z, TokenApiRegisterCallback tokenApiRegisterCallback) {
        a.a().a(str, tokenApiConfig, z, tokenApiRegisterCallback);
    }

    @Override // com.bytedance.sdk.commonsdk.api.service.ICommonSdkTokenService
    public boolean isHasSyncMark() {
        return a.a.get();
    }

    @Override // com.bytedance.sdk.commonsdk.api.service.ICommonSdkTokenService
    public boolean isCustomLoginSuccess() {
        return a.a().b();
    }

    @Override // com.bytedance.sdk.commonsdk.api.service.ICommonSdkTokenService
    public void handleBEBDDidComeEvent(TokenApiConfig tokenApiConfig, TokenApiRegisterCallback tokenApiRegisterCallback) {
        a.a().a(tokenApiConfig, tokenApiRegisterCallback);
    }

    @Override // com.bytedance.sdk.commonsdk.api.service.ICommonSdkTokenService
    public void saveToken(TokenRsp tokenRsp) {
        a.a().a(tokenRsp);
    }

    @Override // com.bytedance.sdk.commonsdk.api.service.ICommonSdkTokenService
    public String getToken() {
        return a.a().d();
    }

    @Override // com.bytedance.sdk.commonsdk.api.service.ICommonSdkTokenService
    public String getUserId() {
        return a.a().e();
    }

    @Override // com.bytedance.sdk.commonsdk.api.service.ICommonSdkTokenService
    public String getUtUid() {
        return a.a().f();
    }

    @Override // com.bytedance.sdk.commonsdk.api.service.ICommonSdkTokenService
    public int getUserType() {
        return a.a().g();
    }

    @Override // com.bytedance.sdk.commonsdk.api.service.ICommonSdkTokenService
    public String getUserMeta() {
        return a.a().h();
    }

    @Override // com.bytedance.sdk.commonsdk.api.service.ICommonSdkTokenService
    public boolean getRecommendSwitch() {
        return a.a().i();
    }

    @Override // com.bytedance.sdk.commonsdk.api.service.ICommonSdkTokenService
    public boolean isGetTokenFromServer() {
        return a.a().j();
    }

    @Override // com.bytedance.sdk.commonsdk.api.service.ICommonSdkTokenService
    public void setRecommendSwitch(boolean z) {
        a.a().a(z);
    }

    @Override // com.bytedance.sdk.commonsdk.api.service.ICommonSdkTokenService
    public boolean isSyncHistory() {
        return a.a().k();
    }
}

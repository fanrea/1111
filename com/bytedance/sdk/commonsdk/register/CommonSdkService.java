package com.bytedance.sdk.commonsdk.register;

import com.bytedance.sdk.commonsdk.api.service.ICommonSdkApplogService;
import com.bytedance.sdk.commonsdk.api.service.ICommonSdkService;
import com.bytedance.sdk.commonsdk.api.service.ICommonSdkTokenService;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class CommonSdkService implements ICommonSdkService {
    @Override // com.bytedance.sdk.commonsdk.api.service.ICommonSdkService
    public ICommonSdkApplogService getCommonSdkApplogService() {
        return new CommonSdkApplogService();
    }

    @Override // com.bytedance.sdk.commonsdk.api.service.ICommonSdkService
    public ICommonSdkTokenService getCommonSdkTokenService() {
        return new CommonSdkTokenService();
    }

    public static CommonSdkService getInstance() {
        return a.a;
    }

    private static class a {
        private static final CommonSdkService a = new CommonSdkService();
    }
}

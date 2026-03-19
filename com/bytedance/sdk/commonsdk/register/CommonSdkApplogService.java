package com.bytedance.sdk.commonsdk.register;

import android.content.Context;
import com.bytedance.applog.IAppLogInstance;
import com.bytedance.sdk.commonsdk.api.ICommonPrivacyController;
import com.bytedance.sdk.commonsdk.api.IGetNewTokenApiConfigCallback;
import com.bytedance.sdk.commonsdk.api.service.ICommonSdkApplogService;
import com.bytedance.sdk.djx.net.api.TokenApiConfig;
import com.bytedance.sdk.djx.proguard3.f.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class CommonSdkApplogService implements ICommonSdkApplogService {
    @Override // com.bytedance.sdk.commonsdk.api.service.ICommonSdkApplogService
    public IAppLogInstance getAppLogInstance(String str) {
        return a.a(str);
    }

    @Override // com.bytedance.sdk.commonsdk.api.service.ICommonSdkApplogService
    public void initApplog(Context context, TokenApiConfig tokenApiConfig, ICommonPrivacyController iCommonPrivacyController, boolean z, IGetNewTokenApiConfigCallback iGetNewTokenApiConfigCallback) {
        a.a(context, tokenApiConfig, iCommonPrivacyController, z, iGetNewTokenApiConfigCallback);
    }
}

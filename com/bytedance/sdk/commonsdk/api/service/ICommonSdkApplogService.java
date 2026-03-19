package com.bytedance.sdk.commonsdk.api.service;

import android.content.Context;
import com.bytedance.applog.IAppLogInstance;
import com.bytedance.sdk.commonsdk.api.ICommonPrivacyController;
import com.bytedance.sdk.commonsdk.api.IGetNewTokenApiConfigCallback;
import com.bytedance.sdk.djx.net.api.TokenApiConfig;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface ICommonSdkApplogService {
    IAppLogInstance getAppLogInstance(String str);

    void initApplog(Context context, TokenApiConfig tokenApiConfig, ICommonPrivacyController iCommonPrivacyController, boolean z, IGetNewTokenApiConfigCallback iGetNewTokenApiConfigCallback);
}

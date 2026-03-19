package com.kwad.sdk.liteapi;

import com.kwad.sdk.api.SdkConfig;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class InputParamHolder {
    private static SdkConfig mSdkConfig;

    public static void holderSdkConfig(SdkConfig sdkConfig) {
        mSdkConfig = sdkConfig;
    }

    public static SdkConfig getSDKConfig() {
        return mSdkConfig;
    }

    public static String getAppId() {
        SdkConfig sdkConfig = mSdkConfig;
        return sdkConfig == null ? "" : sdkConfig.appId;
    }

    public static String getAppName() {
        SdkConfig sdkConfig = mSdkConfig;
        return sdkConfig == null ? "" : sdkConfig.appName;
    }
}

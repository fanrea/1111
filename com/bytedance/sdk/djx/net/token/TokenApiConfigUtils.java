package com.bytedance.sdk.djx.net.token;

import com.bytedance.sdk.djx.core.DevInfo;
import com.bytedance.sdk.djx.net.ApiConstants;
import com.bytedance.sdk.djx.net.NetClient;
import com.bytedance.sdk.djx.net.api.TokenApiConfig;
import com.bytedance.sdk.djx.utils.DeviceUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class TokenApiConfigUtils {
    private TokenApiConfigUtils() {
    }

    public static TokenApiConfig buildTokenApiConfig() {
        TokenApiConfig tokenApiConfig = new TokenApiConfig();
        tokenApiConfig.sdkName = "djxsdk";
        tokenApiConfig.hostWithPath = ApiConstants.getHostWithPath();
        tokenApiConfig.devInfoAppid = DevInfo.sAppId;
        tokenApiConfig.siteId = DevInfo.sSiteId;
        tokenApiConfig.postBuilder = NetClient.post();
        tokenApiConfig.localDid = DeviceUtils.getLocalDid();
        tokenApiConfig.did = DeviceUtils.getDid();
        tokenApiConfig.netClientCommonParams = NetClient.getCommonParams();
        tokenApiConfig.oldPartner = DevInfo.sOldPartner;
        tokenApiConfig.oldUUID = DevInfo.sOldUUID;
        tokenApiConfig.contentUUID = DevInfo.sContentUUID;
        tokenApiConfig.bindDidSpName = "djxsdk_bind";
        return tokenApiConfig;
    }
}

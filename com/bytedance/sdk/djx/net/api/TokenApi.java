package com.bytedance.sdk.djx.net.api;

import android.text.TextUtils;
import com.bytedance.sdk.commonsdk.api.model.CommonError;
import com.bytedance.sdk.commonsdk.api.utils.JSON;
import com.bytedance.sdk.commonsdk.api.utils.NetUtils;
import com.bytedance.sdk.djx.net.ICommonApiCallback;
import com.bytedance.sdk.djx.net.cb.NetCallback;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.bytedance.sdk.djx.net.req.NetBuilder;
import com.bytedance.sdk.djx.net.req.NetResponse;
import com.bytedance.sdk.djx.net.req.k.OkPostBuilder;
import com.bytedance.sdk.djx.net.token.Token;
import com.bytedance.sdk.djx.net.token.UserConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class TokenApi {
    private static final String TAG = "TokenApi";

    private TokenApi() {
    }

    public static void register(Map<String, String> map, final TokenApiConfig tokenApiConfig, final ICommonApiCallback<TokenRsp> iCommonApiCallback) {
        ((OkPostBuilder) tokenApiConfig.postBuilder.url(tokenApiConfig.hostWithPath + "/user/login?siteid=" + tokenApiConfig.siteId).addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM).params(buildParams(map, tokenApiConfig))).go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.net.api.TokenApi.1
            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetError(NetBuilder netBuilder, int i, String str, Throwable th) {
                if (iCommonApiCallback != null) {
                    CommonError commonErrorBuild = CommonError.build(i, str);
                    NetUtils.injectReqId(commonErrorBuild, netBuilder.mResponseHeaders);
                    iCommonApiCallback.onApiFailure(commonErrorBuild, null);
                }
            }

            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetSuccess(NetBuilder netBuilder, NetResponse<String> netResponse) {
                try {
                    TokenRsp tokenRsp = TokenApi.parse(JSON.build(netResponse.data));
                    if (tokenRsp.isOk()) {
                        tokenRsp.setDid(tokenApiConfig.did);
                        ICommonApiCallback iCommonApiCallback2 = iCommonApiCallback;
                        if (iCommonApiCallback2 != null) {
                            iCommonApiCallback2.onApiSuccess(tokenRsp);
                        }
                    } else if (iCommonApiCallback != null) {
                        CommonError dJXError = tokenRsp.toDJXError();
                        NetUtils.injectReqId(dJXError, netBuilder.mResponseHeaders);
                        iCommonApiCallback.onApiFailure(dJXError, tokenRsp);
                    }
                } catch (Throwable unused) {
                    ICommonApiCallback iCommonApiCallback3 = iCommonApiCallback;
                    if (iCommonApiCallback3 != null) {
                        iCommonApiCallback3.onApiFailure(CommonError.build(-2, ErrCode.msg(-2)), null);
                    }
                }
            }
        });
    }

    private static Map<String, String> buildParams(Map<String, String> map, TokenApiConfig tokenApiConfig) {
        HashMap map2 = new HashMap(tokenApiConfig.netClientCommonParams);
        if (!TextUtils.isEmpty(tokenApiConfig.oldPartner)) {
            map2.put("original_partner", tokenApiConfig.oldPartner);
        }
        if (!TextUtils.isEmpty(tokenApiConfig.oldUUID)) {
            map2.put("original_uuid", tokenApiConfig.oldUUID);
        }
        if (!TextUtils.isEmpty(tokenApiConfig.contentUUID)) {
            map2.put("content_uuid", tokenApiConfig.contentUUID);
        }
        if (map != null && !map.isEmpty()) {
            map2.putAll(map);
        }
        return map2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TokenRsp parse(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new TokenRsp();
        }
        TokenRsp tokenRsp = new TokenRsp();
        tokenRsp.parseComm(jSONObject);
        JSONObject jsonObject = JSON.getJsonObject(jSONObject, "data");
        String string = JSON.getString(jsonObject, "access_token");
        long j = JSON.getLong(jsonObject, "expires_in");
        long j2 = JSON.getLong(jsonObject, "min_expires_second");
        String string2 = JSON.getString(jsonObject, "user_id");
        int i = JSON.getInt(jsonObject, "user_type");
        String string3 = JSON.getString(jsonObject, "ouid");
        String string4 = JSON.getString(jsonObject, "login_type");
        boolean z = JSON.getBoolean(jsonObject, "recommend_switch", true);
        tokenRsp.setData(new Token(string, j, j2, new UserConfig(string2, i, string3, string4, z, JSON.getString(jsonObject, "user_meta")), JSON.getBoolean(jsonObject, "sync_history")));
        return tokenRsp;
    }
}

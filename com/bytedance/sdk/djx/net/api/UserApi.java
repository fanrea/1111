package com.bytedance.sdk.djx.net.api;

import android.text.TextUtils;
import com.bytedance.sdk.djx.core.business.web.bridge.IFunc;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.net.ApiConstants;
import com.bytedance.sdk.djx.net.NetClient;
import com.bytedance.sdk.djx.net.cb.NetCallback;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.bytedance.sdk.djx.net.req.NetBuilder;
import com.bytedance.sdk.djx.net.req.NetResponse;
import com.bytedance.sdk.djx.net.req.k.OkPostBuilder;
import com.bytedance.sdk.djx.net.token.UserConfig;
import com.bytedance.sdk.djx.utils.JSON;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.NetUtils;
import com.ss.texturerender.TextureRenderKeys;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: UserApi.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\bH\u0002J\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007J\u001a\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J$\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00180\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/sdk/djx/net/api/UserApi;", "", "()V", "GET_USER_INFO_URL", "", "TAG", "USER_CONFIG_REPORT_URL", "buildParams", "", IFunc.IVK_GET_USER_INFO, "", TextureRenderKeys.KEY_IS_CALLBACK, "Lcom/bytedance/sdk/djx/net/api/IApiCallback;", "Lcom/bytedance/sdk/djx/net/api/UserConfigRsp;", "parsePostRsp", "Lcom/bytedance/sdk/djx/net/api/BaseDjxRsp;", "json", "Lorg/json/JSONObject;", "parseUserInfo", "Lcom/bytedance/sdk/djx/net/token/UserConfig;", "parseUserInfoRsp", "reportUserConfig", "recommendSwitch", "", "Lcom/bytedance/sdk/djx/net/api/BaseRsp;", "net_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class UserApi {
    private static final String TAG = "UserApi";
    public static final UserApi INSTANCE = new UserApi();
    private static final String USER_CONFIG_REPORT_URL = Intrinsics.stringPlus(ApiConstants.getHostWithPath(), "/user/config_report");
    private static final String GET_USER_INFO_URL = Intrinsics.stringPlus(ApiConstants.getHostWithPath(), "/user/info");

    private UserApi() {
    }

    @JvmStatic
    public static final void reportUserConfig(boolean recommendSwitch, final IApiCallback<BaseRsp<Object>> callback) {
        Intrinsics.checkNotNullParameter(callback, TextureRenderKeys.KEY_IS_CALLBACK);
        OkPostBuilder okPostBuilderPost = NetClient.post();
        okPostBuilderPost.url(USER_CONFIG_REPORT_URL);
        okPostBuilderPost.addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM);
        okPostBuilderPost.params(INSTANCE.buildParams());
        okPostBuilderPost.addParam("recommend_switch", String.valueOf(recommendSwitch));
        okPostBuilderPost.go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.net.api.UserApi.reportUserConfig.2
            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetSuccess(NetBuilder<?> builder, NetResponse<String> response) {
                Intrinsics.checkNotNullParameter(response, "response");
                try {
                    BaseDjxRsp postRsp = UserApi.INSTANCE.parsePostRsp(JSON.build(response.data));
                    if (postRsp == null) {
                        return;
                    }
                    IApiCallback<BaseRsp<Object>> iApiCallback = callback;
                    if (postRsp.isOk()) {
                        iApiCallback.onApiSuccess(postRsp);
                        return;
                    }
                    DJXError dJXError = postRsp.toDJXError();
                    Intrinsics.checkNotNullExpressionValue(dJXError, "rsp.toDJXError()");
                    NetUtils.injectReqId(dJXError, builder == null ? null : builder.mResponseHeaders);
                    iApiCallback.onApiFailure(dJXError, postRsp);
                } catch (Throwable th) {
                    LG.e(UserApi.TAG, "callback error", th);
                    callback.onApiFailure(DJXError.build(-2, ErrCode.msg(-2)), null);
                }
            }

            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetError(NetBuilder<? extends NetBuilder<?>> builder, int code, String msg, Throwable throwable) {
                DJXError dJXErrorBuild = DJXError.build(code, msg);
                NetUtils.injectReqId(dJXErrorBuild, builder == null ? null : builder.mResponseHeaders);
                callback.onApiFailure(dJXErrorBuild, null);
            }
        });
    }

    @JvmStatic
    public static final void getUserInfo(final IApiCallback<UserConfigRsp> callback) {
        Intrinsics.checkNotNullParameter(callback, TextureRenderKeys.KEY_IS_CALLBACK);
        OkPostBuilder okPostBuilderPost = NetClient.post();
        okPostBuilderPost.url(GET_USER_INFO_URL);
        okPostBuilderPost.addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM);
        okPostBuilderPost.params(INSTANCE.buildParams());
        okPostBuilderPost.go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.net.api.UserApi.getUserInfo.2
            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetSuccess(NetBuilder<?> builder, NetResponse<String> response) {
                Intrinsics.checkNotNullParameter(response, "response");
                try {
                    UserConfigRsp userInfoRsp = UserApi.INSTANCE.parseUserInfoRsp(JSON.build(response.data));
                    if (userInfoRsp == null) {
                        return;
                    }
                    IApiCallback<UserConfigRsp> iApiCallback = callback;
                    if (userInfoRsp.isOk()) {
                        iApiCallback.onApiSuccess(userInfoRsp);
                        return;
                    }
                    int code = userInfoRsp.getCode();
                    if (TextUtils.isEmpty(userInfoRsp.getMsg())) {
                        ErrCode.msg(code);
                    }
                    DJXError dJXError = userInfoRsp.toDJXError();
                    Intrinsics.checkNotNullExpressionValue(dJXError, "rsp.toDJXError()");
                    NetUtils.injectReqId(dJXError, builder == null ? null : builder.mResponseHeaders);
                    iApiCallback.onApiFailure(dJXError, userInfoRsp);
                } catch (Throwable th) {
                    LG.e(UserApi.TAG, "callback error", th);
                    callback.onApiFailure(DJXError.build(-2, ErrCode.msg(-2)), null);
                }
            }

            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetError(NetBuilder<? extends NetBuilder<?>> builder, int code, String msg, Throwable throwable) {
                DJXError dJXErrorBuild = DJXError.build(code, msg);
                NetUtils.injectReqId(dJXErrorBuild, builder == null ? null : builder.mResponseHeaders);
                callback.onApiFailure(dJXErrorBuild, null);
            }
        });
    }

    private final Map<String, String> buildParams() {
        return new HashMap(NetClient.getCommonParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BaseDjxRsp<Object> parsePostRsp(JSONObject json) {
        if (json == null) {
            return null;
        }
        BaseDjxRsp<Object> baseDjxRsp = new BaseDjxRsp<>();
        baseDjxRsp.parseComm(json);
        return baseDjxRsp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UserConfigRsp parseUserInfoRsp(JSONObject json) {
        if (json == null) {
            return null;
        }
        UserConfigRsp userConfigRsp = new UserConfigRsp();
        userConfigRsp.parseComm(json);
        JSONObject jsonObject = JSON.getJsonObject(json, "data");
        UserApi userApi = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(jsonObject, "data");
        userConfigRsp.setData(userApi.parseUserInfo(jsonObject));
        return userConfigRsp;
    }

    private final UserConfig parseUserInfo(JSONObject json) {
        String string = JSON.getString(json, "user_id");
        Intrinsics.checkNotNullExpressionValue(string, "getString(json, \"user_id\")");
        int i = JSON.getInt(json, "user_type");
        String string2 = JSON.getString(json, "ouid");
        Intrinsics.checkNotNullExpressionValue(string2, "getString(json, \"ouid\")");
        String string3 = JSON.getString(json, "login_type");
        Intrinsics.checkNotNullExpressionValue(string3, "getString(json, \"login_type\")");
        boolean z = JSON.getBoolean(json, "recommend_switch");
        String string4 = JSON.getString(json, "user_meta");
        Intrinsics.checkNotNullExpressionValue(string4, "getString(json, \"user_meta\")");
        return new UserConfig(string, i, string2, string3, z, string4);
    }
}

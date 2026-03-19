package com.bytedance.sdk.djx.core.api.req;

import android.text.TextUtils;
import com.bytedance.sdk.djx.core.api.rsp.ProtocolRsp;
import com.bytedance.sdk.djx.core.api.rsp.SignProtocolRsp;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.model.DJXProtocol;
import com.bytedance.sdk.djx.net.ApiConstants;
import com.bytedance.sdk.djx.net.NetClient;
import com.bytedance.sdk.djx.net.api.ErrCode;
import com.bytedance.sdk.djx.net.api.IApiCallback;
import com.bytedance.sdk.djx.net.cb.NetCallback;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.bytedance.sdk.djx.net.req.NetBuilder;
import com.bytedance.sdk.djx.net.req.NetResponse;
import com.bytedance.sdk.djx.utils.JSON;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.NetUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ProtocolApi {
    private static final String P_GET_URL = ApiConstants.getHostWithPath() + "/user/query_protocol";
    private static final String P_SIGN_URL = ApiConstants.getHostWithPath() + "/user/sign_protocol";
    private static final String TAG = "ProtocolApi";

    public static void getProtocol(List<Integer> list, final IApiCallback<ProtocolRsp> iApiCallback) {
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(",");
        }
        if (sb.lastIndexOf(",") == sb.length() - 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        NetClient.post().url(P_GET_URL).addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM).params(NetClient.getCommonParams()).addParam("protocol_types", sb.toString()).go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.core.api.req.ProtocolApi.1
            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetError(NetBuilder netBuilder, int i, String str, Throwable th) {
                if (iApiCallback != null) {
                    DJXError dJXErrorBuild = DJXError.build(i, str);
                    NetUtils.injectReqId(dJXErrorBuild, netBuilder.mResponseHeaders);
                    iApiCallback.onApiFailure(dJXErrorBuild, null);
                }
            }

            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetSuccess(NetBuilder netBuilder, NetResponse<String> netResponse) {
                try {
                    ProtocolRsp protocolRsp = ProtocolApi.parseProtocolRsp(JSON.build(netResponse.data));
                    if (protocolRsp.isOk()) {
                        IApiCallback iApiCallback2 = iApiCallback;
                        if (iApiCallback2 != null) {
                            iApiCallback2.onApiSuccess(protocolRsp);
                        }
                    } else if (iApiCallback != null) {
                        DJXError dJXError = protocolRsp.toDJXError();
                        NetUtils.injectReqId(dJXError, netBuilder.mResponseHeaders);
                        iApiCallback.onApiFailure(dJXError, protocolRsp);
                    }
                } catch (Throwable th) {
                    LG.e(ProtocolApi.TAG, "callback error", th);
                    IApiCallback iApiCallback3 = iApiCallback;
                    if (iApiCallback3 != null) {
                        iApiCallback3.onApiFailure(DJXError.build(-2, ErrCode.msg(-2)), null);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ProtocolRsp parseProtocolRsp(JSONObject jSONObject) {
        ProtocolRsp protocolRsp = new ProtocolRsp();
        protocolRsp.parseComm(jSONObject);
        protocolRsp.setData(new ArrayList());
        JSONArray jsonArray = JSON.getJsonArray(JSON.getJsonObject(jSONObject, "data"), "list");
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length(); i++) {
                protocolRsp.getData().add(parserProtocol(jsonArray.optJSONObject(i)));
            }
        }
        return protocolRsp;
    }

    private static DJXProtocol parserProtocol(JSONObject jSONObject) {
        DJXProtocol dJXProtocol = new DJXProtocol();
        dJXProtocol.id = JSON.getInt(jSONObject, "protocol_id");
        dJXProtocol.url = JSON.getString(jSONObject, "protocol_url");
        dJXProtocol.name = JSON.getString(jSONObject, "protocol_name");
        dJXProtocol.type = JSON.getInt(jSONObject, "protocol_type");
        dJXProtocol.isSigned = JSON.getBoolean(jSONObject, "is_signed_protocol");
        return dJXProtocol;
    }

    public static void signedProtocol(List<String> list, final IApiCallback<SignProtocolRsp> iApiCallback) {
        if (list == null || list.isEmpty()) {
            if (iApiCallback != null) {
                iApiCallback.onApiFailure(DJXError.build(-1, "ids is null"), null);
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(",");
        }
        if (sb.lastIndexOf(",") == sb.length() - 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        NetClient.post().url(P_SIGN_URL).addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM).params(NetClient.getCommonParams()).addParam("protocol_ids", sb.toString()).go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.core.api.req.ProtocolApi.2
            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetError(NetBuilder netBuilder, int i, String str, Throwable th) {
                if (iApiCallback != null) {
                    DJXError dJXErrorBuild = DJXError.build(i, str);
                    NetUtils.injectReqId(dJXErrorBuild, netBuilder.mResponseHeaders);
                    iApiCallback.onApiFailure(dJXErrorBuild, null);
                }
            }

            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetSuccess(NetBuilder netBuilder, NetResponse<String> netResponse) {
                try {
                    SignProtocolRsp signProtocolRsp = ProtocolApi.parseSignProtocolRsp(JSON.build(netResponse.data));
                    if (signProtocolRsp.isOk()) {
                        IApiCallback iApiCallback2 = iApiCallback;
                        if (iApiCallback2 != null) {
                            iApiCallback2.onApiSuccess(signProtocolRsp);
                            return;
                        }
                        return;
                    }
                    int code = signProtocolRsp.getCode();
                    if (TextUtils.isEmpty(signProtocolRsp.getMsg())) {
                        ErrCode.msg(code);
                    }
                    if (iApiCallback != null) {
                        DJXError dJXError = signProtocolRsp.toDJXError();
                        NetUtils.injectReqId(dJXError, netBuilder.mResponseHeaders);
                        iApiCallback.onApiFailure(dJXError, signProtocolRsp);
                    }
                } catch (Throwable th) {
                    LG.e(ProtocolApi.TAG, "callback error", th);
                    IApiCallback iApiCallback3 = iApiCallback;
                    if (iApiCallback3 != null) {
                        iApiCallback3.onApiFailure(DJXError.build(-2, ErrCode.msg(-2)), null);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SignProtocolRsp parseSignProtocolRsp(JSONObject jSONObject) {
        SignProtocolRsp signProtocolRsp = new SignProtocolRsp();
        signProtocolRsp.parseComm(jSONObject);
        return signProtocolRsp;
    }
}

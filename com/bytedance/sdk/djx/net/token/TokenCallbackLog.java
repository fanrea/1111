package com.bytedance.sdk.djx.net.token;

import android.os.SystemClock;
import com.baidu.mobads.container.adrequest.g;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.commonsdk.api.model.CommonError;
import com.bytedance.sdk.commonsdk.api.model.CommonOthers;
import com.bytedance.sdk.djx.IDJXService;
import com.bytedance.sdk.djx.net.ICommonReqCallback;
import com.bytedance.sdk.djx.net.log.Upload4AppLog;
import com.bytedance.sdk.djx.utils.CommonConvertDjxUtils;
import com.bytedance.sdk.djx.utils.JSON;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class TokenCallbackLog<T> implements ICommonReqCallback<T> {
    private ICommonReqCallback<T> callback;
    private final long start = SystemClock.elapsedRealtime();

    public static <T> TokenCallbackLog<T> build(IDJXService.IDJXCallback<T> iDJXCallback) {
        return new TokenCallbackLog<>(iDJXCallback);
    }

    private TokenCallbackLog(IDJXService.IDJXCallback<T> iDJXCallback) {
        this.callback = convertICommonReqCallback(iDJXCallback);
    }

    private ICommonReqCallback<T> convertICommonReqCallback(final IDJXService.IDJXCallback<T> iDJXCallback) {
        return new ICommonReqCallback<T>() { // from class: com.bytedance.sdk.djx.net.token.TokenCallbackLog.1
            @Override // com.bytedance.sdk.djx.net.ICommonReqCallback
            public void onSuccess(T t, CommonOthers commonOthers) {
                IDJXService.IDJXCallback iDJXCallback2 = iDJXCallback;
                if (iDJXCallback2 != null) {
                    iDJXCallback2.onSuccess(t, CommonConvertDjxUtils.commonOthersConvertDJXOthers(commonOthers));
                }
            }

            @Override // com.bytedance.sdk.djx.net.ICommonReqCallback
            public void onError(CommonError commonError) {
                IDJXService.IDJXCallback iDJXCallback2 = iDJXCallback;
                if (iDJXCallback2 != null) {
                    iDJXCallback2.onError(CommonConvertDjxUtils.commonErrorConvertDJXError(commonError));
                }
            }
        };
    }

    @Override // com.bytedance.sdk.djx.net.ICommonReqCallback
    public void onSuccess(T t, CommonOthers commonOthers) {
        JSONObject jSONObjectBuild = JSON.build();
        JSON.putLong(jSONObjectBuild, "duration", SystemClock.elapsedRealtime() - this.start);
        JSON.putInt(jSONObjectBuild, "code", 0);
        JSON.putObject(jSONObjectBuild, "msg", "success");
        if (commonOthers != null) {
            JSON.putObject(jSONObjectBuild, g.o, commonOthers.requestId);
            JSON.putInt(jSONObjectBuild, Config.EXCEPTION_MEMORY_TOTAL, commonOthers.total);
        }
        send(jSONObjectBuild);
        ICommonReqCallback<T> iCommonReqCallback = this.callback;
        if (iCommonReqCallback != null) {
            iCommonReqCallback.onSuccess(t, commonOthers);
        }
    }

    @Override // com.bytedance.sdk.djx.net.ICommonReqCallback
    public void onError(CommonError commonError) {
        JSONObject jSONObjectBuild = JSON.build();
        JSON.putLong(jSONObjectBuild, "duration", SystemClock.elapsedRealtime() - this.start);
        JSON.putInt(jSONObjectBuild, "code", commonError.code);
        JSON.putObject(jSONObjectBuild, "sub_code", commonError.subCode);
        JSON.putObject(jSONObjectBuild, "msg", commonError.msg);
        JSON.putObject(jSONObjectBuild, g.o, commonError.requestId);
        send(jSONObjectBuild);
        ICommonReqCallback<T> iCommonReqCallback = this.callback;
        if (iCommonReqCallback != null) {
            iCommonReqCallback.onError(commonError);
        }
    }

    private void send(JSONObject jSONObject) {
        if (jSONObject != null) {
            Upload4AppLog.DEFAULT.send("req_token", "service", jSONObject, null);
        }
    }

    public void reSetCallback() {
        this.callback = null;
    }
}

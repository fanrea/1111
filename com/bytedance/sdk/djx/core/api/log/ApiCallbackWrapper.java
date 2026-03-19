package com.bytedance.sdk.djx.core.api.log;

import android.os.SystemClock;
import com.baidu.mobads.container.adrequest.g;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.djx.IDJXService;
import com.bytedance.sdk.djx.core.log.BLogAgent;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.model.DJXOthers;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ApiCallbackWrapper<T> implements IDJXService.IDJXCallback<T> {
    private final IDJXService.IDJXCallback<T> callback;
    private final String name;
    private final long start = SystemClock.elapsedRealtime();

    public static <T> ApiCallbackWrapper<T> build(String str, IDJXService.IDJXCallback<T> iDJXCallback) {
        return new ApiCallbackWrapper<>(str, iDJXCallback);
    }

    private ApiCallbackWrapper(String str, IDJXService.IDJXCallback<T> iDJXCallback) {
        this.callback = iDJXCallback;
        this.name = str;
    }

    @Override // com.bytedance.sdk.djx.IDJXService.IDJXCallback
    public void onSuccess(T t, DJXOthers dJXOthers) {
        BLogAgent bLogAgentPutString = BLogAgent.build("service", this.name, null).putLong("duration", SystemClock.elapsedRealtime() - this.start).putInt("code", 0).putString("msg", "success");
        if (dJXOthers != null) {
            bLogAgentPutString.putString(g.o, dJXOthers.requestId).putInt(Config.EXCEPTION_MEMORY_TOTAL, dJXOthers.total);
        }
        bLogAgentPutString.send();
        IDJXService.IDJXCallback<T> iDJXCallback = this.callback;
        if (iDJXCallback != null) {
            iDJXCallback.onSuccess(t, dJXOthers);
        }
    }

    @Override // com.bytedance.sdk.djx.IDJXService.IDJXCallback
    public void onError(DJXError dJXError) {
        BLogAgent.build("service", this.name, null).putLong("duration", SystemClock.elapsedRealtime() - this.start).putInt("code", dJXError.code).putString("sub_code", dJXError.subCode).putString("msg", dJXError.msg).putString(g.o, dJXError.requestId).send();
        IDJXService.IDJXCallback<T> iDJXCallback = this.callback;
        if (iDJXCallback != null) {
            iDJXCallback.onError(dJXError);
        }
    }
}

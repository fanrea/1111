package com.bytedance.sdk.djx.core.init.pay;

import com.bytedance.sdk.djx.net.NetClient;
import com.bytedance.sdk.djx.net.cb.NetCallback;
import com.bytedance.sdk.djx.net.req.NetBuilder;
import com.bytedance.sdk.djx.net.req.NetResponse;
import com.bytedance.sdk.djx.utils.JSON;
import com.pangrowth.empay.IEMNetCallback;
import com.pangrowth.empay.IEMNetWork;
import com.pangrowth.empay.model.EMPayResponse;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class PayNetImpl implements IEMNetWork {
    public void execPost(String str, Map<String, String> map, Map<String, String> map2, final IEMNetCallback iEMNetCallback) {
        HashMap map3 = new HashMap();
        map3.putAll(NetClient.getCommonParams());
        map3.putAll(map);
        NetClient.post().url(str).params(map3).headers(new HashMap(map2)).go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.core.init.pay.PayNetImpl.1
            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetError(NetBuilder netBuilder, int i, String str2, Throwable th) {
                super.onNetError(netBuilder, i, str2, th);
                if (iEMNetCallback != null) {
                    EMPayResponse eMPayResponse = new EMPayResponse();
                    eMPayResponse.setCode(i);
                    eMPayResponse.setMsg(str2);
                    iEMNetCallback.onResult(eMPayResponse);
                }
            }

            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetSuccess(NetBuilder netBuilder, NetResponse<String> netResponse) {
                super.onNetSuccess(netBuilder, netResponse);
                if (iEMNetCallback != null) {
                    EMPayResponse rVar = EMPayResponse.Companion.parser(JSON.build(netResponse.data));
                    rVar.setHeaders(netResponse.headers);
                    iEMNetCallback.onResult(rVar);
                }
            }
        });
    }

    public void execGet(String str, Map<String, String> map, Map<String, String> map2, final IEMNetCallback iEMNetCallback) {
        HashMap map3 = new HashMap();
        map3.putAll(NetClient.getCommonParams());
        map3.putAll(map);
        NetClient.get().url(str).params(map3).headers(new HashMap(map2)).go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.core.init.pay.PayNetImpl.2
            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetError(NetBuilder netBuilder, int i, String str2, Throwable th) {
                super.onNetError(netBuilder, i, str2, th);
                if (iEMNetCallback != null) {
                    EMPayResponse eMPayResponse = new EMPayResponse();
                    eMPayResponse.setCode(i);
                    eMPayResponse.setMsg(str2);
                    iEMNetCallback.onResult(eMPayResponse);
                }
            }

            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetSuccess(NetBuilder netBuilder, NetResponse<String> netResponse) {
                super.onNetSuccess(netBuilder, netResponse);
                if (iEMNetCallback != null) {
                    EMPayResponse rVar = EMPayResponse.Companion.parser(JSON.build(netResponse.data));
                    rVar.setHeaders(netResponse.headers);
                    iEMNetCallback.onResult(rVar);
                }
            }
        });
    }
}

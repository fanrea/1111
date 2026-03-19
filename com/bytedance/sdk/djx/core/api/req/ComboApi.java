package com.bytedance.sdk.djx.core.api.req;

import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.djx.core.api.rsp.ComboRsp;
import com.bytedance.sdk.djx.model.DJXCombo;
import com.bytedance.sdk.djx.model.DJXError;
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
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ComboApi {
    private static final String C_GET_URL = ApiConstants.getHostWithPath() + "/pay/query_combo";
    private static final String TAG = "ComboApi";

    public static void getCombos(String str, int i, final IApiCallback<ComboRsp> iApiCallback) {
        NetClient.post().url(C_GET_URL).addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM).params(NetClient.getCommonParams()).addParam("combo_types", str).addParam("page", String.valueOf(i)).addParam("num", "50").go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.core.api.req.ComboApi.1
            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetError(NetBuilder netBuilder, int i2, String str2, Throwable th) {
                if (iApiCallback != null) {
                    DJXError dJXErrorBuild = DJXError.build(i2, str2);
                    NetUtils.injectReqId(dJXErrorBuild, netBuilder.mResponseHeaders);
                    iApiCallback.onApiFailure(dJXErrorBuild, null);
                }
            }

            @Override // com.bytedance.sdk.djx.net.cb.NetCallback
            public void onNetSuccess(NetBuilder netBuilder, NetResponse<String> netResponse) {
                try {
                    ComboRsp comboRsp = ComboApi.parseComboRsp(JSON.build(netResponse.data));
                    if (comboRsp.isOk()) {
                        IApiCallback iApiCallback2 = iApiCallback;
                        if (iApiCallback2 != null) {
                            iApiCallback2.onApiSuccess(comboRsp);
                        }
                    } else if (iApiCallback != null) {
                        DJXError dJXError = comboRsp.toDJXError();
                        NetUtils.injectReqId(dJXError, netBuilder.mResponseHeaders);
                        iApiCallback.onApiFailure(dJXError, comboRsp);
                    }
                } catch (Throwable th) {
                    LG.e(ComboApi.TAG, "callback error", th);
                    IApiCallback iApiCallback3 = iApiCallback;
                    if (iApiCallback3 != null) {
                        iApiCallback3.onApiFailure(DJXError.build(-2, ErrCode.msg(-2)), null);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ComboRsp parseComboRsp(JSONObject jSONObject) {
        ComboRsp comboRsp = new ComboRsp();
        comboRsp.parseComm(jSONObject);
        JSONObject jsonObject = JSON.getJsonObject(jSONObject, "data");
        comboRsp.setHasMore(JSON.getBoolean(jsonObject, "has_more"));
        comboRsp.setTotal(JSON.getInt(jsonObject, Config.EXCEPTION_MEMORY_TOTAL));
        ArrayList arrayList = new ArrayList();
        JSONArray jsonArray = JSON.getJsonArray(jsonObject, "list");
        if (jsonArray != null && jsonArray.length() > 0) {
            int length = jsonArray.length();
            for (int i = 0; i < length; i++) {
                arrayList.add(parseCombo(jsonArray.optJSONObject(i)));
            }
        }
        comboRsp.setData(arrayList);
        return comboRsp;
    }

    public static DJXCombo parseCombo(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        DJXCombo dJXCombo = new DJXCombo();
        dJXCombo.id = JSON.getLong(jSONObject, "combo_id");
        dJXCombo.name = JSON.getString(jSONObject, "combo_name");
        dJXCombo.desc = JSON.getString(jSONObject, "combo_desc");
        dJXCombo.type = JSON.getInt(jSONObject, "combo_type");
        dJXCombo.durationType = JSON.getInt(jSONObject, "duration_type");
        dJXCombo.duration = JSON.getLong(jSONObject, "membership_duration");
        dJXCombo.number = JSON.getInt(jSONObject, "shortplay_num");
        dJXCombo.moneyType = JSON.getString(jSONObject, "virtual_currency");
        dJXCombo.money = JSON.getInt(jSONObject, "virtual_amount");
        JSONArray jsonArray = JSON.getJsonArray(jSONObject, "pay_method");
        if (jsonArray != null && jsonArray.length() > 0 && (jSONObjectOptJSONObject = jsonArray.optJSONObject(0)) != null) {
            dJXCombo.payType = JSON.getInt(jSONObjectOptJSONObject, "pay_type");
            dJXCombo.payAmount = JSON.getLong(jSONObjectOptJSONObject, "amount");
            dJXCombo.payMoney = JSON.getString(jSONObjectOptJSONObject, "currency");
        }
        return dJXCombo;
    }
}

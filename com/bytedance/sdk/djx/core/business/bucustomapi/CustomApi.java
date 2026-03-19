package com.bytedance.sdk.djx.core.business.bucustomapi;

import com.bytedance.sdk.djx.IDJXService;
import com.bytedance.sdk.djx.model.DJXError;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class CustomApi {
    public static void request(Map<String, String> map, IDJXService.IDJXCallback<JSONObject> iDJXCallback) throws JSONException {
        if (CustomApiHandler.checkParamsOK(map)) {
            CustomApiHandler.handle(map, iDJXCallback);
        } else if (iDJXCallback != null) {
            iDJXCallback.onError(DJXError.build(-1, "参数错误：缺少必要参数"));
        }
    }
}

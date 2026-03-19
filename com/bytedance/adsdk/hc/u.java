package com.bytedance.adsdk.hc;

import android.text.TextUtils;
import com.bytedance.sdk.djx.core.log.ILogConst;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u implements gb {
    @Override // com.bytedance.adsdk.hc.gb
    public Object d(JSONObject jSONObject, Object[] objArr) {
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                String strValueOf = String.valueOf(obj);
                if (!TextUtils.isEmpty(strValueOf) && !TextUtils.equals(strValueOf, ILogConst.CACHE_PLAY_REASON_NULL)) {
                    return strValueOf;
                }
            }
        }
        return null;
    }
}

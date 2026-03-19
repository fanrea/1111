package com.bytedance.adsdk.hc;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.mq;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an implements gb {
    @Override // com.bytedance.adsdk.hc.gb
    /* renamed from: hc, reason: merged with bridge method [inline-methods] */
    public String d(JSONObject jSONObject, Object[] objArr) {
        if (objArr != null && objArr.length >= 2) {
            String strValueOf = String.valueOf(objArr[0]);
            if (TextUtils.isEmpty(strValueOf)) {
                return null;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(strValueOf);
                String strValueOf2 = String.valueOf(objArr[1]);
                if (TextUtils.isEmpty(strValueOf2)) {
                    return null;
                }
                Object objD = com.bytedance.adsdk.hc.hc.d.d(strValueOf2).d(jSONObject2);
                if (TextUtils.isEmpty(String.valueOf(objD))) {
                    if (objArr.length >= 3) {
                        return String.valueOf(objArr[2]);
                    }
                    return null;
                }
                return String.valueOf(objD);
            } catch (JSONException e) {
                mq.d(e);
            }
        }
        return null;
    }
}

package com.bytedance.adsdk.hc;

import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h implements gb {
    @Override // com.bytedance.adsdk.hc.gb
    /* renamed from: hc, reason: merged with bridge method [inline-methods] */
    public Boolean d(JSONObject jSONObject, Object[] objArr) throws NumberFormatException {
        if (objArr == null || objArr.length <= 0) {
            return Boolean.FALSE;
        }
        try {
            Double.parseDouble(String.valueOf(objArr[0]));
            return Boolean.TRUE;
        } catch (NumberFormatException unused) {
            return Boolean.FALSE;
        }
    }
}

package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class bc extends zw {
    private final fs an;
    private final Context u;

    bc(Context context, fs fsVar) {
        super(true, false);
        this.u = context;
        this.an = fsVar;
    }

    @Override // com.bytedance.embedapplog.zw
    protected boolean d(JSONObject jSONObject) throws JSONException {
        String strD = d.mq() != null ? d.mq().s().d() : "";
        if (TextUtils.isEmpty(strD)) {
            return true;
        }
        jSONObject.put("mc", strD);
        return true;
    }
}

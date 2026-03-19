package com.bytedance.embedapplog;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class dc extends zw {
    private final Context u;

    dc(Context context) {
        super(true, true);
        this.u = context;
    }

    @Override // com.bytedance.embedapplog.zw
    protected boolean d(JSONObject jSONObject) throws JSONException {
        ba.d(jSONObject, "access", qy.d(this.u));
        return true;
    }
}

package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class s extends zw {
    private final fs u;

    s(Context context, fs fsVar) {
        super(true, false);
        this.u = fsVar;
    }

    @Override // com.bytedance.embedapplog.zw
    protected boolean d(JSONObject jSONObject) throws JSONException {
        String strD = f.d(this.u.c());
        if (TextUtils.isEmpty(strD)) {
            return false;
        }
        jSONObject.put("cdid", strD);
        return true;
    }
}

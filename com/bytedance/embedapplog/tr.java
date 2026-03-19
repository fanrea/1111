package com.bytedance.embedapplog;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class tr extends zw {
    private final fs an;
    private final Context u;

    tr(Context context, fs fsVar) {
        super(true, false);
        this.u = context;
        this.an = fsVar;
    }

    @Override // com.bytedance.embedapplog.zw
    protected boolean d(JSONObject jSONObject) {
        Map<String, String> mapD = f.d(this.u, this.an.c());
        if (mapD == null) {
            return !d.hc;
        }
        jSONObject.put("oaid", new JSONObject(mapD));
        return true;
    }
}

package com.bytedance.adsdk.ugeno.u.hc;

import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.u.an;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u extends d {
    public u(com.bytedance.adsdk.ugeno.hc.b bVar, String str, an.d dVar) {
        super(bVar, str, dVar);
    }

    @Override // com.bytedance.adsdk.ugeno.u.hc.d
    public void d() throws JSONException {
        if (this.an == null || this.an.size() <= 0) {
            return;
        }
        String str = this.an.get("id");
        if (TextUtils.isEmpty(str)) {
            d(this.b);
            return;
        }
        com.bytedance.adsdk.ugeno.hc.b bVarHc = this.b.hc(this.b);
        if (bVarHc == null) {
            return;
        }
        d(bVarHc.c(str));
    }

    private void d(com.bytedance.adsdk.ugeno.hc.b bVar) throws JSONException {
        if (bVar == null) {
            return;
        }
        for (String str : this.an.keySet()) {
            if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "id")) {
                bVar.d(str, this.an.get(str));
            }
        }
        bVar.d(this.an.containsKey("width"), this.an.containsKey("height"));
        bVar.hc();
    }
}

package com.qq.e.comm.plugin;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class dn extends h4 implements lk {
    String I1;
    int J1;

    public dn(String str, String str2, String str3, JSONObject jSONObject, mb mbVar) throws JSONException {
        super(str, str2, str3, e2.UNIFIED_INTERSTITIAL_FULLSCREEN, jSONObject, mbVar);
        en.a(this, jSONObject);
        int iA = fn.a(this);
        this.J1 = iA;
        try {
            jSONObject.putOpt("card_show_time", Integer.valueOf(iA));
        } catch (JSONException unused) {
        }
    }

    @Override // com.qq.e.comm.plugin.lk
    public final boolean b() {
        return d1.a(g0());
    }

    @Override // com.qq.e.comm.plugin.lk
    public final String a() {
        return this.I1;
    }
}

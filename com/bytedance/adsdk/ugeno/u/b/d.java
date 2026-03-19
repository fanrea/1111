package com.bytedance.adsdk.ugeno.u.b;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends hc implements com.bytedance.adsdk.ugeno.d.hc {
    private String mk;

    public d(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.u.b.hc
    public boolean d(Object... objArr) {
        com.bytedance.adsdk.ugeno.hc.b bVarHc;
        com.bytedance.adsdk.ugeno.d.d dVarTc;
        if (this.u != null && this.u.size() > 0) {
            String str = this.u.get("name");
            this.mk = this.u.get("state");
            if (!TextUtils.isEmpty(str) && (bVarHc = this.hc.hc(this.hc)) != null && (dVarTc = bVarHc.an(str).tc(str)) != null) {
                dVarTc.d(this);
            }
        }
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.d.hc
    public void d() {
        if ((TextUtils.equals(this.mk, "start") || TextUtils.isEmpty(this.mk)) && this.d != null) {
            this.d.d(this.hc, this.an, this.b.hc());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.d.hc
    public void hc() {
        if ((TextUtils.equals(this.mk, "complete") || TextUtils.isEmpty(this.mk)) && this.d != null) {
            this.d.d(this.hc, this.an, this.b.hc());
        }
    }
}

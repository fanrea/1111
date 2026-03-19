package com.bytedance.adsdk.ugeno.b.d;

import com.bytedance.adsdk.ugeno.b.cb;
import com.bytedance.adsdk.ugeno.b.yo;
import com.bytedance.adsdk.ugeno.hc.b;
import com.bytedance.adsdk.ugeno.u.an;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class hc implements yo {
    protected JSONObject c;
    protected yo d;
    protected String hc;
    protected boolean b = true;
    protected boolean u = false;

    public abstract void b(cb cbVar, yo.hc hcVar, yo.d dVar);

    public hc(yo yoVar) {
        this.d = yoVar;
    }

    public void d(JSONObject jSONObject) {
        this.c = jSONObject;
    }

    public void d(String str) {
        this.hc = str;
    }

    public void d(boolean z) {
        this.b = z;
    }

    public boolean d() {
        String str;
        return this.b && (str = this.hc) != null && "3".compareTo(str) <= 0 && this.c != null;
    }

    public void hc(boolean z) {
        this.u = z;
    }

    @Override // com.bytedance.adsdk.ugeno.b.yo
    public void d(cb cbVar, yo.hc hcVar, yo.d dVar) {
        if (d()) {
            b(cbVar, hcVar, dVar);
        } else {
            hc(cbVar, hcVar, dVar);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.b.yo
    public void d(b bVar, String str, an.d dVar) {
        yo yoVar = this.d;
        if (yoVar == null) {
            return;
        }
        yoVar.d(bVar, str, dVar);
    }

    protected void hc(cb cbVar, yo.hc hcVar, yo.d dVar) {
        yo yoVar = this.d;
        if (yoVar == null) {
            return;
        }
        yoVar.d(cbVar, hcVar, dVar);
    }
}

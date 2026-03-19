package com.bytedance.adsdk.ugeno.u.b;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.u.an;
import com.bytedance.adsdk.ugeno.u.mk;
import com.bytedance.adsdk.ugeno.u.tc;
import io.reactivex.annotations.SchedulerSupport;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class hc {
    protected String an;
    protected com.bytedance.adsdk.ugeno.u.an b;
    protected an.d c;
    protected mk d;
    protected String gb;
    protected String h;
    protected com.bytedance.adsdk.ugeno.hc.b hc;
    protected Context tc;
    protected String tt;
    protected Map<String, String> u;

    public abstract boolean d(Object... objArr);

    public hc(Context context) {
        this.tc = context;
    }

    public void an() {
        this.c = this.b.d();
        com.bytedance.adsdk.ugeno.u.an anVar = this.b;
        if (anVar == null) {
            return;
        }
        an.d dVarD = anVar.d();
        this.c = dVarD;
        if (dVarD == null) {
            return;
        }
        this.u = dVarD.b();
        this.an = this.c.hc();
        this.h = this.c.d();
        this.gb = this.c.c();
        this.tt = this.c.u();
    }

    public String h() {
        return this.an;
    }

    public String gb() {
        return this.gb;
    }

    public void d(com.bytedance.adsdk.ugeno.hc.b bVar) {
        this.hc = bVar;
    }

    public void d(com.bytedance.adsdk.ugeno.u.an anVar) {
        this.b = anVar;
    }

    public void d(mk mkVar) {
        this.d = mkVar;
    }

    public static class d {
        public static hc d(Context context, com.bytedance.adsdk.ugeno.hc.b bVar, JSONObject jSONObject, JSONObject jSONObject2) {
            com.bytedance.adsdk.ugeno.u.an anVarD;
            an.d dVarD;
            com.bytedance.adsdk.ugeno.u.h hVarD;
            if (bVar == null || jSONObject == null || (anVarD = com.bytedance.adsdk.ugeno.u.an.d(jSONObject, jSONObject2)) == null || (dVarD = anVarD.d()) == null) {
                return null;
            }
            String strD = dVarD.d();
            if (TextUtils.equals(strD, SchedulerSupport.CUSTOM)) {
                b bVar2 = new b(context);
                bVar2.d(bVar);
                bVar2.d(anVarD);
                bVar2.an();
                return bVar2;
            }
            if (TextUtils.isEmpty(strD) || TextUtils.equals(strD, "global")) {
                hVarD = tc.d(dVarD.hc());
            } else {
                hVarD = tc.d(dVarD.u());
            }
            if (hVarD == null) {
                return null;
            }
            hc hcVarD = hVarD.d(context);
            hcVarD.d(bVar);
            hcVarD.d(anVarD);
            hcVarD.an();
            return hcVarD;
        }
    }
}

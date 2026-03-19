package com.bytedance.d.hc.u.d;

import android.content.Context;
import android.os.Process;
import com.bytedance.d.hc.gb;
import com.bytedance.d.hc.gb.e;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import io.reactivex.annotations.SchedulerSupport;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class b {
    protected com.bytedance.d.hc.u b = gb.d().b();
    protected hc c;
    protected com.bytedance.d.hc.b d;
    protected Context hc;
    protected c u;

    protected boolean d() {
        return true;
    }

    protected boolean hc() {
        return true;
    }

    b(com.bytedance.d.hc.b bVar, Context context, hc hcVar, c cVar) {
        this.d = bVar;
        this.hc = context;
        this.c = hcVar;
        this.u = cVar;
    }

    public com.bytedance.d.hc.b.d d(com.bytedance.d.hc.b.d dVar) {
        if (dVar == null) {
            dVar = new com.bytedance.d.hc.b.d();
        }
        hc(dVar);
        u(dVar);
        return dVar;
    }

    void hc(com.bytedance.d.hc.b.d dVar) throws JSONException {
        hc hcVar;
        if (hc() && (hcVar = this.c) != null) {
            dVar.d(hcVar);
        }
        dVar.d(gb.an());
        hc hcVar2 = this.c;
        dVar.d("is_background", Boolean.valueOf((hcVar2 == null || !hcVar2.b()) && !com.bytedance.d.hc.gb.d.d(this.hc)));
        dVar.d("pid", Integer.valueOf(Process.myPid()));
        dVar.d("battery", Integer.valueOf(this.u.d()));
        dVar.d(this.b.u());
        dVar.hc(gb.tt());
        dVar.d(gb.tc(), gb.mk());
        dVar.d(this.b.an());
        dVar.d(e.d(this.hc));
        if (d()) {
            c(dVar);
        }
        dVar.d(this.b.c());
        String strH = gb.h();
        if (strH != null) {
            dVar.d("business", strH);
        }
        if (gb.gb()) {
            dVar.d("is_mp", (Object) 1);
        }
        dVar.b(gb.hc().d());
        dVar.d("crash_uuid", UUID.randomUUID().toString());
    }

    void b(com.bytedance.d.hc.b.d dVar) throws JSONException {
        Map<String, Object> mapD = gb.d().d();
        if (mapD == null) {
            return;
        }
        if (mapD.containsKey("app_version")) {
            dVar.d("crash_version", mapD.get("app_version"));
        }
        if (mapD.containsKey(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME)) {
            dVar.d("app_version", mapD.get(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME));
        }
        if (mapD.containsKey("version_code")) {
            try {
                dVar.d("crash_version_code", Integer.valueOf(Integer.parseInt(mapD.get("version_code").toString())));
            } catch (Exception unused) {
                dVar.d("crash_version_code", mapD.get("version_code"));
            }
        }
        if (mapD.containsKey("update_version_code")) {
            try {
                dVar.d("crash_update_version_code", Integer.valueOf(Integer.parseInt(mapD.get("update_version_code").toString())));
            } catch (Exception unused2) {
                dVar.d("crash_update_version_code", mapD.get("update_version_code"));
            }
        }
    }

    private void u(com.bytedance.d.hc.b.d dVar) throws JSONException {
        List<com.bytedance.d.hc.d> listD = gb.hc().d(this.d);
        if (listD != null) {
            JSONObject jSONObject = new JSONObject();
            Iterator<com.bytedance.d.hc.d> it = listD.iterator();
            while (it.hasNext()) {
                Map<? extends String, ? extends String> mapD = it.next().d(this.d);
                if (mapD != null) {
                    try {
                        for (String str : mapD.keySet()) {
                            jSONObject.put(str, mapD.get(str));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            dVar.d(SchedulerSupport.CUSTOM, jSONObject);
        }
    }

    protected void c(com.bytedance.d.hc.b.d dVar) throws JSONException {
        dVar.hc(com.bytedance.d.hc.u.c.d(gb.u().c(), gb.u().u()));
    }
}

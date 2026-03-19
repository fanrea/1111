package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.vg;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ov extends c30 {
    private final boolean a;

    /* compiled from: A */
    private static final class b {
        static final ov a = new ov();
    }

    public static ov b() {
        return b.a;
    }

    @Override // com.qq.e.comm.plugin.c30
    public String a() {
        return "removeDownloadTask";
    }

    private ov() {
        this.a = r1.d().f().a("dfwrdtdl", 1) == 1;
    }

    @Override // com.qq.e.comm.plugin.c30
    public void a(jm jmVar, ug ugVar) throws JSONException {
        JSONObject jSONObjectD = ugVar.d();
        if (jSONObjectD == null) {
            return;
        }
        int iOptInt = jSONObjectD.optInt("taskId");
        if (com.qq.e.comm.plugin.apkmanager.l.e().a(com.qq.e.comm.plugin.apkmanager.l.e().a(iOptInt), this.a)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("taskId", iOptInt);
            } catch (JSONException unused) {
                jmVar.b().a(new vg(ugVar, vg.a.ERROR, ""));
            }
            jmVar.b().a(new vg(ugVar, vg.a.OK, jSONObject));
            return;
        }
        jmVar.b().a(new vg(ugVar, vg.a.ERROR, ""));
    }
}

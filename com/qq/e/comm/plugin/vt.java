package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import com.qq.e.comm.plugin.vg;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class vt extends c30 {

    /* compiled from: A */
    private static final class b {
        static final vt a = new vt();
    }

    public static vt b() {
        return b.a;
    }

    @Override // com.qq.e.comm.plugin.c30
    public String a() {
        return "pauseDownloadTask";
    }

    private vt() {
    }

    @Override // com.qq.e.comm.plugin.c30
    public void a(jm jmVar, ug ugVar) throws JSONException {
        JSONObject jSONObjectD = ugVar.d();
        if (jSONObjectD == null) {
            return;
        }
        int iOptInt = jSONObjectD.optInt("taskId");
        ApkDownloadTask apkDownloadTaskA = com.qq.e.comm.plugin.apkmanager.l.e().a(iOptInt);
        if (apkDownloadTaskA != null) {
            j3.b(4001004, apkDownloadTaskA, 1, 104);
            if (com.qq.e.comm.plugin.apkmanager.l.e().a(apkDownloadTaskA)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("taskId", iOptInt);
                } catch (JSONException unused) {
                    jmVar.b().a(new vg(ugVar, vg.a.ERROR, ""));
                }
                jmVar.b().a(new vg(ugVar, vg.a.OK, jSONObject));
                return;
            }
        }
        jmVar.b().a(new vg(ugVar, vg.a.ERROR, ""));
    }
}

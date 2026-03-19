package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import com.qq.e.comm.plugin.vg;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class jo extends c30 {

    /* compiled from: A */
    private static final class b {
        static final jo a = new jo();
    }

    public static jo b() {
        return b.a;
    }

    @Override // com.qq.e.comm.plugin.c30
    public String a() {
        return "loadDownloadingTask";
    }

    @Override // com.qq.e.comm.plugin.c30
    public void a(jm jmVar, ug ugVar) throws JSONException {
        List<ApkDownloadTask> listD = com.qq.e.comm.plugin.apkmanager.l.e().d();
        if (listD == null || listD.isEmpty()) {
            jmVar.b().a(new vg(ugVar, vg.a.ERROR, ""));
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            for (ApkDownloadTask apkDownloadTask : listD) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("taskId", apkDownloadTask.t());
                jSONObject2.put("logoUrl", apkDownloadTask.k());
                jSONObject2.put("appName", apkDownloadTask.p());
                jSONObject2.put("pkgName", apkDownloadTask.r());
                jSONObject2.put("progress", apkDownloadTask.b("progress"));
                jSONObject2.put("totalSize", apkDownloadTask.c("totalSize"));
                jSONObject2.put("status", apkDownloadTask.o());
                jSONObject2.put("nTag", apkDownloadTask.d("notifyTag"));
                jSONObject2.put("nId", apkDownloadTask.b("notifyId"));
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("list", jSONArray);
        } catch (JSONException unused) {
            jmVar.b().a(new vg(ugVar, vg.a.ERROR, ""));
        }
        jmVar.b().a(new vg(ugVar, vg.a.OK, jSONObject));
    }

    private jo() {
    }
}

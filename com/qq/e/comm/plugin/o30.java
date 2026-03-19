package com.qq.e.comm.plugin;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class o30 extends c30 {

    /* compiled from: A */
    private static final class b {
        static final o30 a = new o30();
    }

    public static o30 b() {
        return b.a;
    }

    @Override // com.qq.e.comm.plugin.c30
    public String a() {
        return "updateDownloadProgress";
    }

    private o30() {
    }

    @Override // com.qq.e.comm.plugin.c30
    public void a(jm jmVar, ug ugVar) {
        JSONObject jSONObjectD = ugVar.d();
        if (jSONObjectD == null) {
            return;
        }
        com.qq.e.comm.plugin.apkmanager.l.e().a(jSONObjectD.optInt("taskId"), jSONObjectD.optInt("progress"), jSONObjectD.optLong("totalSize"));
    }
}

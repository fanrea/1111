package com.qq.e.comm.plugin;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class n5 extends c30 {

    /* compiled from: A */
    private static final class b {
        static final n5 a = new n5();
    }

    public static n5 b() {
        return b.a;
    }

    @Override // com.qq.e.comm.plugin.c30
    public String a() {
        return "loadURL";
    }

    private n5() {
    }

    @Override // com.qq.e.comm.plugin.c30
    public void a(jm jmVar, ug ugVar) {
        JSONObject jSONObjectD = ugVar.d();
        if (jSONObjectD != null && jSONObjectD.has("url")) {
            a(jmVar, jSONObjectD.optString("url"), jSONObjectD.optString("browsertype"));
        } else {
            qm$h$$ExternalSyntheticBackport0.m(ugVar);
        }
    }

    public void a(jm jmVar, String str, String str2) {
        if ("innerbrowser".equals(str2)) {
            o5.b(str, (h4) null);
            return;
        }
        if ("website".equals(str2)) {
            o5.b(str);
        } else if ("loadurl".equals(str2)) {
            jmVar.loadUrl(str);
        } else {
            o5.b(str);
        }
    }
}

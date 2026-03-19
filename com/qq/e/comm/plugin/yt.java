package com.qq.e.comm.plugin;

import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class yt extends c30 {

    /* compiled from: A */
    private static final class b {
        static final yt a = new yt();
    }

    public static yt b() {
        return b.a;
    }

    @Override // com.qq.e.comm.plugin.c30
    public String a() {
        return "ping";
    }

    private yt() {
    }

    @Override // com.qq.e.comm.plugin.c30
    public void a(jm jmVar, ug ugVar) {
        JSONObject jSONObjectD = ugVar.d();
        if (jSONObjectD == null || !jSONObjectD.has("url")) {
            return;
        }
        String strOptString = jSONObjectD.optString("url");
        boolean zOptBoolean = jSONObjectD.optBoolean("imp", false);
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        zt.a(strOptString, zOptBoolean);
    }
}

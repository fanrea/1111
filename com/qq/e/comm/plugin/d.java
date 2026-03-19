package com.qq.e.comm.plugin;

import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class d extends c30 {

    /* compiled from: A */
    private static final class b {
        static final d a = new d();
    }

    public static final d b() {
        return b.a;
    }

    @Override // com.qq.e.comm.plugin.c30
    public String a() {
        return "adEvent";
    }

    private d() {
    }

    @Override // com.qq.e.comm.plugin.c30
    public void a(jm jmVar, ug ugVar) {
        e eVarA;
        JSONObject jSONObjectD = ugVar.d();
        String strOptString = jSONObjectD.optString("type", "");
        JSONObject jSONObjectOptJSONObject = jSONObjectD.optJSONObject("paras");
        if (TextUtils.isEmpty(strOptString) || (eVarA = e.a(strOptString, jSONObjectOptJSONObject)) == null) {
            return;
        }
        jmVar.a(eVarA);
    }
}

package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.vg;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class y6 extends e30 {
    private String a;

    public String a() {
        return "gdtcommon";
    }

    public y6(String str) {
        this.a = str;
    }

    @Override // com.qq.e.comm.plugin.e30
    public ih<String> a(jm jmVar, ug ugVar) throws JSONException {
        String strA = ugVar.a();
        strA.hashCode();
        if (strA.equals("getControlServerSettings")) {
            b(jmVar, ugVar);
        }
        return new ih<>(null);
    }

    private void b(jm jmVar, ug ugVar) throws JSONException {
        try {
            JSONObject jSONObjectD = ugVar.d();
            if (jSONObjectD == null) {
                jmVar.b().a(new vg(ugVar, vg.a.JSON_PARSE_EXCEPTION, ""));
                return;
            }
            JSONArray jSONArray = jSONObjectD.getJSONArray("settings");
            JSONObject jSONObject = new JSONObject();
            if (jSONArray != null) {
                vx vxVarF = r1.d().f();
                JSONObject jSONObject2 = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string = jSONArray.getString(i);
                    jSONObject2.put(string, vxVarF.a(string, this.a));
                }
                jSONObject.put("data", jSONObject2);
                jSONObject.put("code", 0);
            }
            jmVar.b().a(new vg(ugVar, vg.a.OK, jSONObject));
        } catch (JSONException unused) {
            jmVar.b().a(new vg(ugVar, vg.a.ERROR, ""));
        }
    }
}

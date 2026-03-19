package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.fo;
import com.qq.e.comm.plugin.vg;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class io extends c30 {

    /* compiled from: A */
    private static final class b {
        static final io a = new io(null);
    }

    public static io b() {
        return b.a;
    }

    @Override // com.qq.e.comm.plugin.c30
    public String a() {
        return "loadAD";
    }

    private io() {
    }

    private w1 a(e2 e2Var, JSONObject jSONObject, String str) {
        String strOptString = jSONObject.optString("jsver");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("extreq");
        int iOptInt = jSONObject.optInt("adposcount");
        int iOptInt2 = jSONObject.optInt("count");
        int iOptInt3 = jSONObject.optInt("posw");
        int iOptInt4 = jSONObject.optInt("posh");
        w1 w1Var = new w1(e2Var);
        w1Var.a(jSONObjectOptJSONObject);
        if (iOptInt <= 0) {
            iOptInt = 1;
        }
        w1Var.a(iOptInt);
        if (iOptInt2 <= 0) {
            iOptInt2 = e2Var.b();
        }
        w1Var.b(iOptInt2);
        w1Var.f(str);
        if (iOptInt3 > 0 && iOptInt4 > 0) {
            w1Var.k(iOptInt3);
            w1Var.j(iOptInt4);
        } else {
            b2 b2VarA = x1.a(e2Var, r1.d().c().h());
            w1Var.k(b2VarA.c());
            w1Var.j(b2VarA.b());
        }
        w1Var.c(2);
        w1Var.b(strOptString);
        return w1Var;
    }

    /* synthetic */ io(a aVar) {
        this();
    }

    /* compiled from: A */
    class a implements fo.c {
        final /* synthetic */ jm a;
        final /* synthetic */ ug b;

        a(jm jmVar, ug ugVar) {
            this.a = jmVar;
            this.b = ugVar;
        }

        @Override // com.qq.e.comm.plugin.fo.c
        public void a(eo eoVar) {
            HashMap map = new HashMap();
            map.put("errorCode", Integer.valueOf(eoVar.a()));
            this.a.b().a(new vg(this.b, vg.a.ERROR, new JSONObject(map)));
        }

        @Override // com.qq.e.comm.plugin.fo.c
        public void a(JSONObject jSONObject) {
            this.a.b().a(new vg(this.b, vg.a.OK, jSONObject.toString()));
        }
    }

    @Override // com.qq.e.comm.plugin.c30
    public void a(jm jmVar, ug ugVar) {
        JSONObject jSONObjectD;
        e2 e2VarA = e2.a(ugVar.e());
        if (e2VarA == null || (jSONObjectD = ugVar.d()) == null) {
            return;
        }
        try {
            String strOptString = jSONObjectD.optString("posid");
            a(jmVar, ugVar, strOptString, a(e2VarA, jSONObjectD, strOptString));
        } catch (Throwable unused) {
            qm$h$$ExternalSyntheticBackport0.m(ugVar);
            jmVar.b().a(new vg(ugVar, vg.a.ERROR, "Exception occurred when fetching ad"));
        }
    }

    private void a(jm jmVar, ug ugVar, String str, w1 w1Var) throws JSONException {
        e2 e2VarA = ((ps) jmVar.b()).a().a();
        fo.a(w1Var, new j(e2VarA, str), new a(jmVar, ugVar));
    }
}

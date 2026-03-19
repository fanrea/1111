package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.qq.e.comm.plugin.ty;
import com.sigmob.sdk.base.mta.PointCategory;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class vx {
    private z a;
    protected String b;
    protected z c;
    private final z d;
    private String e;
    protected tx f;
    private final tx g;
    private String h;
    protected bu i;
    private final ta j;
    private final sa k;
    private String l;
    private String m = "";
    private Context n;
    private String o;
    private boolean p;
    private final j20 q;

    private void d(String str) {
    }

    public vx(Context context) {
        j20 j20Var = new j20();
        this.q = j20Var;
        j20Var.d();
        this.n = context;
        this.a = new z();
        this.d = new z();
        this.g = new ji();
        this.i = new bu();
        this.j = new ta();
        this.k = new sa();
        j20Var.c();
        this.o = gu.a("e_qq_com_setting");
        j20Var.c();
        j();
        j20Var.c();
        i();
        j20Var.c();
        h();
        j20Var.a();
        this.p = true;
    }

    public String f() {
        return this.q.toString();
    }

    private void j() {
        try {
            this.l = gu.d(new File(this.n.getDir(this.o, 0), "gdt_suid"));
        } catch (Throwable unused) {
            this.l = null;
        }
    }

    private void i() {
        ty.b<tx> bVarC = ty.c(this.n);
        if (bVarC != null) {
            a(bVarC.b(), bVarC.a());
        }
    }

    private void h() {
        ty.b<bu> bVarB = ty.b(this.n);
        if (bVarB != null) {
            a(bVarB.b(), bVarB.a());
        }
    }

    public void k() {
        tx txVar = this.f;
        if (txVar != null) {
            a(txVar.a(), true);
        }
    }

    public Object b(String str) throws JSONException {
        jn jnVar = new jn();
        Object objA = this.j.a(str);
        if (objA != null) {
            jnVar.a("placement", objA);
        }
        JSONObject jSONObjectA = this.k.a();
        if (jSONObjectA != null) {
            jnVar.a(PointCategory.APP, jSONObjectA);
        }
        return jnVar.a();
    }

    public Object a(String str) {
        Object objA;
        Object objA2;
        Object objA3;
        Object objA4;
        Object objA5;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            objA = n4.a(str, (String) null);
        } catch (Throwable unused) {
        }
        if (objA != null) {
            return objA;
        }
        Object objA6 = this.k.a(str);
        if (objA6 != null) {
            return objA6;
        }
        z zVar = this.a;
        if (zVar != null && (objA5 = zVar.a(str)) != null) {
            return objA5;
        }
        z zVar2 = this.c;
        if (zVar2 != null && (objA4 = zVar2.a(str)) != null) {
            return objA4;
        }
        z zVar3 = this.d;
        if (zVar3 != null && (objA3 = zVar3.a(str)) != null) {
            return objA3;
        }
        tx txVar = this.f;
        if (txVar != null && (objA2 = txVar.a(str)) != null) {
            return objA2;
        }
        tx txVar2 = this.g;
        if (txVar2 != null) {
            return txVar2.a(str);
        }
        return null;
    }

    public void f(String str, String str2) {
        if (ty.c(this.n, str, str2)) {
            try {
                a(str, new tx(ty.a(str2)));
            } catch (UnsupportedEncodingException e) {
                e.getMessage();
            }
        }
    }

    public void g(String str) {
        this.l = str;
        gu.c(new File(this.n.getDir(this.o, 0), "gdt_suid"), str);
    }

    public String g() {
        return ty.a.toString();
    }

    public String e() {
        return this.l;
    }

    public String d() {
        return this.m;
    }

    public String c() {
        return this.o;
    }

    public void d(String str, String str2) {
        if (ty.a(this.n, str, str2)) {
            try {
                a(str, new z(ty.a(str2)));
            } catch (UnsupportedEncodingException e) {
                e.getMessage();
            }
        }
    }

    public void e(String str) {
        try {
            z zVar = new z();
            if (!TextUtils.isEmpty(str)) {
                zVar = new z(ty.a(str));
            }
            this.a = zVar;
        } catch (Throwable unused) {
        }
    }

    public String b() {
        return this.e;
    }

    public String a() {
        return this.b;
    }

    public void f(String str) {
        this.m = str;
    }

    public String c(String str) {
        d(str);
        Object objA = a(str);
        if (objA == null) {
            return null;
        }
        return objA.toString();
    }

    public void e(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            ty.a(this.n);
            this.i = new bu();
            this.h = null;
        } else if (ty.b(this.n, str, str2)) {
            try {
                a(str, new bu(ty.a(str2)));
            } catch (UnsupportedEncodingException e) {
                e.getMessage();
            }
        }
    }

    public Object a(String str, String str2) {
        Object objA;
        Object objA2;
        Object objA3;
        Object objA4;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                Object objA5 = n4.a(str, str2);
                if (objA5 != null) {
                    return objA5;
                }
                Object objA6 = this.j.a(str, str2);
                if (objA6 != null) {
                    return objA6;
                }
                bu buVar = this.i;
                if (buVar != null && (objA4 = buVar.a(str, str2)) != null) {
                    return objA4;
                }
                z zVar = this.a;
                if (zVar != null && (objA3 = zVar.a(str, str2)) != null) {
                    return objA3;
                }
                z zVar2 = this.c;
                if (zVar2 != null && (objA2 = zVar2.a(str, str2)) != null) {
                    return objA2;
                }
                z zVar3 = this.d;
                return (zVar3 == null || (objA = zVar3.a(str, str2)) == null) ? a(str) : objA;
            } catch (Throwable unused) {
                return null;
            }
        }
        return a(str);
    }

    public String b(String str, String str2) {
        d(str);
        Object objA = a(str);
        return objA == null ? str2 : objA.toString();
    }

    public String c(String str, String str2) {
        return a(str, str2, (String) null);
    }

    private Object a(h4 h4Var, String str, boolean z) {
        return a(str, h4Var.y0(), h4Var.e(), z, h4Var.k());
    }

    public Object a(String str, String str2, JSONObject jSONObject, boolean z, e2 e2Var) {
        Object objA;
        Object objOpt;
        return (jSONObject == null || (objOpt = jSONObject.opt(str)) == null) ? (!z || e2Var == null || (objA = a(a(str, e2Var), str2)) == null) ? a(str, str2) : objA : objOpt;
    }

    public int a(h4 h4Var, String str, int i) {
        return a(h4Var, str, i, true);
    }

    public int a(h4 h4Var, String str, int i, boolean z) {
        Object objA = a(h4Var, str, z);
        return objA instanceof Integer ? ((Integer) objA).intValue() : i;
    }

    public int a(String str, int i) {
        d(str);
        Object objA = a(str);
        return (objA == null || !(objA instanceof Integer)) ? i : ((Integer) objA).intValue();
    }

    public int a(String str, String str2, int i) {
        Object objA = a(str, str2);
        return (objA == null || !(objA instanceof Integer)) ? i : ((Integer) objA).intValue();
    }

    public String a(h4 h4Var, String str, String str2) {
        return a(h4Var, str, str2, true);
    }

    public String a(h4 h4Var, String str, String str2, boolean z) {
        Object objA = a(h4Var, str, z);
        return objA != null ? objA.toString() : str2;
    }

    public String a(String str, String str2, String str3) {
        Object objA = a(str, str2);
        return objA == null ? str3 : objA.toString();
    }

    protected void a(JSONObject jSONObject, boolean z) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        if (z) {
            try {
                vc.b();
                n4.c();
            } catch (Throwable unused) {
                return;
            }
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString = jSONObject.optString(next);
            vc.b(strOptString);
            n4.b(next, strOptString);
        }
    }

    private void a(String str, z zVar) {
        this.b = str;
        this.c = zVar;
    }

    public void a(String str, Object obj) throws JSONException {
        this.d.a(str, obj);
    }

    public void a(String str, Object obj, String str2) throws JSONException {
        this.d.a(str, obj, str2);
    }

    private void a(String str, bu buVar) {
        this.h = str;
        this.i = buVar;
    }

    private void a(String str, tx txVar) {
        this.e = str;
        this.f = txVar;
        if (!this.p || txVar == null) {
            return;
        }
        a(txVar.a(), true);
    }

    public void a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            this.k.a((JSONObject) null);
            this.j.a(str, (JSONObject) null);
        } else {
            this.k.a(jSONObject.optJSONObject(PointCategory.APP));
            this.j.a(str, jSONObject.optJSONObject("placement"));
        }
    }

    public static String a(String str, e2 e2Var) {
        return str + Config.replace + e2Var.d();
    }
}

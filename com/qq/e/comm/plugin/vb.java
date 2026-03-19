package com.qq.e.comm.plugin;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobstat.forbes.Config;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class vb {
    public static final vb v = new vb();
    private int a;
    private String b;
    private JSONObject c;
    private long d;
    private WeakReference<zj> e;
    private String f;
    private String g;
    private int h;
    private long i;
    private int j;
    private int k;
    private JSONObject l;
    private JSONObject m;
    private String n;
    private boolean o;
    private int p;
    private boolean q;
    private boolean r;
    private int s;
    private String t;
    private int u;

    private vb() {
        this.j = -1;
        this.q = false;
        this.r = false;
        this.s = 1;
        this.u = -1;
    }

    long k() {
        return this.d;
    }

    String h() {
        return this.n;
    }

    boolean n() {
        return this.o;
    }

    zj d() {
        WeakReference<zj> weakReference = this.e;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    String i() {
        return this.g;
    }

    String g() {
        return this.f;
    }

    boolean o() {
        return this.r;
    }

    boolean m() {
        return (TextUtils.isEmpty(this.f) || TextUtils.isEmpty(this.g)) ? false : true;
    }

    boolean l() {
        return this.q;
    }

    int f() {
        return this.p;
    }

    long j() {
        return this.i;
    }

    JSONObject c() {
        return this.l;
    }

    /* compiled from: A */
    public static class b {
        private final vb a = new vb();

        private b b(JSONObject jSONObject) throws JSONException {
            if (this.a.g(jSONObject) && this.a.f(jSONObject)) {
                try {
                    this.a.c = jSONObject.optJSONObject("p");
                    this.a.g = jSONObject.optString("sn");
                    if (this.a.c != null) {
                        this.a.b = gp.a(this.a.g + " " + this.a.c);
                    } else {
                        vb vbVar = this.a;
                        vbVar.b = vbVar.g;
                    }
                    this.a.l = jSONObject.optJSONObject("dr");
                    if (this.a.l == null) {
                        this.a.l = new JSONObject();
                    }
                    this.a.l.put("ph", this.a.b);
                    this.a.n = "f_" + this.a.g;
                    this.a.o = jSONObject.optInt("rse", 0) > 0;
                    this.a.p = jSONObject.optInt("pf");
                    this.a.q = jSONObject.optInt("phv") > 0;
                    this.a.r = jSONObject.optInt("sbc", 0) > 0;
                    vb vbVar2 = this.a;
                    vbVar2.j = jSONObject.optInt("rc", vbVar2.j);
                    vb vbVar3 = this.a;
                    vbVar3.h = jSONObject.optInt("iv", vbVar3.h);
                    vb vbVar4 = this.a;
                    vbVar4.d = jSONObject.optLong(TypedValues.TransitionType.S_TO, vbVar4.d);
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("rkl");
                    if (jSONArrayOptJSONArray != null && this.a.u >= 0) {
                        vb vbVar5 = this.a;
                        vbVar5.f = jSONArrayOptJSONArray.optString(vbVar5.u);
                    } else {
                        vb vbVar6 = this.a;
                        vbVar6.f = jSONObject.optString("rk", vbVar6.f);
                    }
                    vb vbVar7 = this.a;
                    vbVar7.s = jSONObject.optInt("dim", vbVar7.s);
                    if (this.a.s != 2) {
                        if (this.a.s == 3) {
                            vb vbVar8 = this.a;
                            vbVar8.f = vb.a(vbVar8.f, this.a.t);
                        }
                    } else {
                        vb vbVar9 = this.a;
                        vbVar9.f = vb.a(vbVar9.f, Integer.valueOf(this.a.a));
                    }
                    vb vbVar10 = this.a;
                    vbVar10.i = jSONObject.optLong("sd", vbVar10.i);
                } catch (Exception e) {
                    this.a.f = null;
                    e.getMessage();
                }
                return this;
            }
            this.a.f = null;
            return this;
        }

        public b c(JSONObject jSONObject) {
            this.a.m = jSONObject;
            return this;
        }

        public vb a(String str) {
            if (TextUtils.isEmpty(str)) {
                return this.a;
            }
            return a(jn.a(str).a());
        }

        public b b(String str) {
            this.a.t = str;
            return this;
        }

        public b c(String str) {
            this.a.f = str;
            return this;
        }

        public vb a(JSONObject jSONObject) throws JSONException {
            if (jSONObject != null) {
                b(jSONObject);
            }
            return this.a;
        }

        public b b(int i) {
            this.a.s = i;
            return this;
        }

        public b a(e2 e2Var) {
            this.a.a = e2Var.d();
            return this;
        }

        public b a(int i) {
            this.a.k = i;
            return this;
        }

        public b a(int i, int i2) {
            if (i2 == 2) {
                i *= 60;
            } else if (i2 == 3) {
                i *= 3600;
            } else if (i2 == 4) {
                i *= 86400;
            } else if (i2 == 5) {
                i *= -1;
            }
            this.a.h = i;
            return this;
        }

        public b a(long j) {
            this.a.i = j;
            return this;
        }
    }

    String a() {
        return this.b;
    }

    int b() {
        return this.k;
    }

    int e() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt("rc", this.j);
        this.j = iOptInt;
        return iOptInt == -1 || (iOptInt & this.k) > 0;
    }

    String a(JSONObject jSONObject) throws JSONException {
        jn jnVarA = new jn().a("rk", this.f);
        JSONObject jSONObject2 = this.c;
        if (jSONObject2 != null) {
            jnVarA.a("p", jSONObject2);
        }
        if (jSONObject != null) {
            jnVarA.a("cr", jSONObject);
        }
        int i = this.a;
        if (i != 0) {
            jnVarA.a(com.baidu.mobads.container.landingpage.aq.b, i);
        }
        if (!TextUtils.isEmpty(this.t)) {
            jnVarA.a("pid", this.t);
        }
        JSONObject jSONObject3 = this.m;
        if (jSONObject3 != null) {
            jnVarA.a("ext", jSONObject3);
        }
        return this.n + "(" + jnVarA.a() + ");";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("atl");
        if (jSONArrayOptJSONArray == null) {
            return true;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            if (jSONArrayOptJSONArray.optInt(i) == this.a) {
                this.u = i;
                return true;
            }
        }
        return false;
    }

    static int d(JSONObject jSONObject) {
        return jSONObject.optInt("dim", 1);
    }

    String a(String str, JSONObject jSONObject, boolean z) {
        StringBuilder sb = new StringBuilder("var ");
        sb.append(this.n);
        sb.append("=function(params){");
        sb.append(str);
        sb.append("};");
        if (z) {
            sb.append(a(jSONObject));
        }
        return sb.toString();
    }

    static int c(JSONObject jSONObject) {
        return jSONObject.optInt("cos", 0);
    }

    static int b(JSONObject jSONObject) {
        return jSONObject.optInt("prexp");
    }

    static JSONArray e(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("rk");
        if (!TextUtils.isEmpty(strOptString)) {
            return new JSONArray().put(strOptString);
        }
        return jSONObject.optJSONArray("rkl");
    }

    public vb a(zj zjVar) {
        if (zjVar != null) {
            this.e = new WeakReference<>(zjVar);
        }
        return this;
    }

    public static String a(String str, Object obj) {
        return str + Config.replace + obj;
    }
}

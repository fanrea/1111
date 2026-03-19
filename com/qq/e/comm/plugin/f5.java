package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class f5 {
    protected final JSONObject a = new JSONObject();
    private String b;
    private String c;
    private String d;
    private int e;
    private int f;
    private int g;
    private String h;
    private int i;
    private h4 j;

    public f5() {
    }

    public f5(f5 f5Var) throws JSONException {
        if (f5Var == null) {
            return;
        }
        JSONObject jSONObjectJ = f5Var.j();
        if (jSONObjectJ != null) {
            Iterator<String> itKeys = jSONObjectJ.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                a(next, jSONObjectJ.opt(next));
            }
        }
        this.b = f5Var.b;
        this.c = f5Var.c;
        this.d = f5Var.d;
        this.e = f5Var.e;
        this.f = f5Var.f;
        this.g = f5Var.g;
        this.h = f5Var.h;
        this.i = f5Var.i;
        this.j = f5Var.j;
    }

    public String e() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String i() {
        return this.d;
    }

    public int f() {
        return this.e;
    }

    public int b() {
        return this.f;
    }

    public int d() {
        return this.g;
    }

    public String h() {
        return this.h;
    }

    public int g() {
        return this.i;
    }

    public JSONObject j() {
        if (this.a.length() > 0) {
            return this.a;
        }
        return null;
    }

    public String toString() {
        return this.a.toString();
    }

    public f5 c(String str) throws JSONException {
        this.b = str;
        a("pid", str);
        return this;
    }

    public h4 a() {
        return this.j;
    }

    public f5 e(String str) throws JSONException {
        this.d = str;
        a("traceid", str);
        return this;
    }

    public static f5 a(h4 h4Var) {
        return a(h4Var, (yq) null);
    }

    public f5 d(String str) throws JSONException {
        if (str != null && str.length() <= 0) {
            str = null;
        }
        this.h = str;
        a("tid", str);
        return this;
    }

    public static f5 a(h4 h4Var, yq yqVar) throws JSONException {
        f5 f5Var = new f5();
        if (h4Var != null) {
            f5Var.j = h4Var;
            f5Var.c(h4Var.y0());
            f5Var.a(h4Var.g());
            f5Var.b(h4Var);
            f5Var.b(h4Var.B0());
            f5Var.a(h4Var.k());
            f5Var.a(h4Var.C1() || h4Var.W0() > 0);
            if (yqVar != null) {
                f5Var.d(yqVar.m());
                f5Var.c(3);
            } else {
                String strO0 = h4Var.O0();
                if (!TextUtils.isEmpty(strO0)) {
                    f5Var.d(strO0);
                } else if (h4Var.p0() != null) {
                    f5Var.d(h4Var.p0().m());
                }
                if (h4Var.D0() != Integer.MIN_VALUE) {
                    f5Var.c(h4Var.D0());
                }
            }
            if (!TextUtils.isEmpty(h4Var.f0())) {
                f5Var.b(h4Var.f0());
            }
        }
        return f5Var;
    }

    public f5 b(String str) throws JSONException {
        a("inex", str);
        return this;
    }

    public f5 c(int i) throws JSONException {
        this.i = i;
        a("rt", Integer.valueOf(i));
        return this;
    }

    public f5 b(int i) throws JSONException {
        this.e = i;
        a(Config.PLATFORM_TYPE, Integer.valueOf(i));
        return this;
    }

    protected void a(String str, Object obj) throws JSONException {
        try {
            this.a.put(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public f5 b(h4 h4Var) throws JSONException {
        if (!TextUtils.isEmpty(h4Var.r0())) {
            e(h4Var.r0());
        } else {
            e(h4Var.S0());
        }
        return this;
    }

    public f5 a(String str) throws JSONException {
        this.c = str;
        a("aid", str);
        return this;
    }

    public f5 a(int i) throws JSONException {
        this.f = i;
        a(com.baidu.mobads.container.landingpage.aq.b, Integer.valueOf(i));
        return this;
    }

    public f5 a(e2 e2Var) throws JSONException {
        if (e2Var != null) {
            int i = e2Var.c;
            this.f = i;
            a(com.baidu.mobads.container.landingpage.aq.b, Integer.valueOf(i));
        }
        return this;
    }

    public f5 a(boolean z) throws JSONException {
        int i = z ? 2 : 1;
        this.g = i;
        a("vdo", Integer.valueOf(i));
        return this;
    }

    public f5 a(JSONObject jSONObject) throws JSONException {
        String strOptString = jSONObject.optString("netlog_traceid");
        if (!TextUtils.isEmpty(strOptString)) {
            e(strOptString);
        } else {
            e(jSONObject.optString("traceid"));
        }
        return this;
    }
}

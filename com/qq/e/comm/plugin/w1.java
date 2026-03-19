package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.qq.e.comm.constants.LoginType;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class w1 {
    private int A;
    private int B;
    private int C;
    private JSONObject D;
    private JSONArray E;
    private Integer F;
    private boolean G;
    private String H;
    private long I;
    private JSONObject J;
    private String a;
    private String b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private final int h;
    private mb i = mb.DEFAULT;
    private String j;
    private String k;
    private int l;
    private int m;
    private List<String> n;
    private int o;
    private String p;
    private String q;
    private LoginType r;
    private String s;
    private String t;
    private String u;
    private int v;
    private int w;
    private JSONObject x;
    private Map<String, String> y;
    private final e2 z;

    public w1(e2 e2Var) {
        this.z = e2Var;
        this.h = e2Var.e();
    }

    public int u() {
        return this.l;
    }

    public int t() {
        return this.m;
    }

    public String w() {
        return this.a;
    }

    public String E() {
        return this.b;
    }

    public boolean K() {
        return !TextUtils.isEmpty(this.b);
    }

    public int a() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public int y() {
        return this.f;
    }

    public int v() {
        return this.g;
    }

    public int x() {
        return this.h;
    }

    public e2 b() {
        return this.z;
    }

    public mb g() {
        return this.i;
    }

    public String q() {
        return this.j;
    }

    public String l() {
        return this.k;
    }

    public JSONObject h() {
        return this.J;
    }

    public List<String> c() {
        return this.n;
    }

    public int j() {
        return this.o;
    }

    public String G() {
        return this.p;
    }

    public String I() {
        return this.q;
    }

    public String n() {
        return this.t;
    }

    public String F() {
        return this.u;
    }

    public LoginType o() {
        return this.r;
    }

    public void a(int i) {
        this.c = i;
    }

    public String m() {
        return this.s;
    }

    public int r() {
        return this.w;
    }

    public int p() {
        return this.v;
    }

    public int z() {
        return this.A;
    }

    public int C() {
        return this.B;
    }

    public JSONObject H() {
        return this.D;
    }

    public void h(int i) {
        this.m = i;
    }

    public void b(int i) {
        this.d = i;
    }

    public JSONObject i() {
        return this.x;
    }

    public Map<String, String> f() {
        return this.y;
    }

    public JSONArray D() {
        return this.E;
    }

    public Integer s() {
        return this.F;
    }

    public boolean J() {
        return this.G;
    }

    public String k() {
        return this.H;
    }

    public void c(int i) {
        this.e = i;
    }

    public void d(int i) {
        this.o = i;
    }

    public int B() {
        return this.C;
    }

    public long A() {
        return this.I;
    }

    public void j(int i) {
        this.g = i;
    }

    public void i(int i) {
        this.l = i;
    }

    public void e(int i) {
        this.v = i;
    }

    public void a(List<String> list) {
        this.n = list;
    }

    public void l(int i) {
        this.A = i;
    }

    public void k(int i) {
        this.f = i;
    }

    public void g(int i) {
        this.F = Integer.valueOf(i);
    }

    public void h(String str) {
        this.u = str;
    }

    public void f(int i) {
        this.w = i;
    }

    public void d(String str) {
        this.t = str;
    }

    public void j(String str) {
        this.q = str;
    }

    public void e(String str) {
        this.j = str;
    }

    public void c(String str) {
        this.s = str;
    }

    public void b(JSONObject jSONObject) {
        this.x = jSONObject;
    }

    public void m(int i) {
        this.C = i;
    }

    public void i(String str) {
        this.p = str;
    }

    public void g(String str) {
        this.b = str;
    }

    public void f(String str) {
        this.a = str;
    }

    public void a(Map map) {
        try {
            this.y = map;
        } catch (Exception unused) {
        }
    }

    public void b(String str) {
        this.k = str;
    }

    public void c(JSONObject jSONObject) {
        this.D = jSONObject;
    }

    public void a(mb mbVar) {
        if (mbVar != null) {
            this.i = mbVar;
        }
    }

    public void b(boolean z) {
        if (z) {
            this.B = 1;
        } else {
            this.B = 0;
        }
    }

    public void a(JSONObject jSONObject) {
        this.J = jSONObject;
    }

    public void a(String str) {
        this.H = str;
    }

    public void a(LoginType loginType) {
        this.r = loginType;
    }

    public void a(boolean z) {
        this.G = z;
    }

    public void a(long j) {
        this.I = j;
    }

    public void a(JSONArray jSONArray) {
        this.E = jSONArray;
    }
}

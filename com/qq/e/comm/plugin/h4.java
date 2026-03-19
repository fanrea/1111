package com.qq.e.comm.plugin;

import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import com.kwai.middleware.azeroth.network.NetworkDefine;
import com.qq.e.comm.plugin.lx;
import com.qq.e.comm.plugin.xc;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class h4 {
    private static volatile String[] H1;
    protected l3 A;
    String A0;
    long A1;
    String B;
    int B0;
    String C;
    long C0;
    String D;
    boolean D0;
    long D1;
    String E;
    yq E0;
    int F0;
    private int F1;
    String G;
    double G0;
    private int G1;
    int H;
    String H0;
    int I;
    String I0;
    l00 J;
    int J0;

    /* renamed from: K, reason: collision with root package name */
    private e2 f776K;
    boolean K0;
    private mb L;
    String L0;
    protected JSONObject M;
    int M0;
    protected String N;
    int N0;
    d7 O;
    JSONObject O0;
    int P;
    JSONArray P0;
    String Q;
    boolean Q0;
    boolean R;
    String R0;
    int S;
    String S0;
    int T;
    String T0;
    int U;
    String U0;
    int V;
    List<xv> W;
    JSONObject W0;
    List<xv> X;
    JSONArray X0;
    protected List<String> Y;
    List<r9> Y0;
    protected List<String> Z;
    ib a0;
    boolean a1;
    String b;
    String b0;
    String c;
    String c0;
    String d;
    q3 d0;
    Map<String, Object> d1;
    String e;
    String e0;
    private SparseArray<h4> e1;
    String f;
    int f0;
    private String f1;
    String g;
    String g0;
    int h;
    k50 h0;
    int i;
    boolean i0;
    private long i1;
    protected String j;
    String j0;
    String k;
    ku k0;
    protected String l;
    boolean l0;
    private int l1;
    String m;
    List<String> m0;
    int n;
    String n0;
    private String n1;
    int o;
    boolean o0;
    String p;
    boolean p0;
    private boolean p1;
    String q;
    String q0;
    private bp q1;
    String r;
    List<ef> r0;
    String s;
    int s0;
    String t;
    String t0;
    boolean u;
    String u0;
    boolean v;
    String v0;
    long v1;
    boolean w;
    String w0;
    long w1;
    String x;
    boolean x0;
    long x1;
    int y;
    String y0;
    long y1;
    int z;
    String z0;
    long z1;
    int F = -1;
    private volatile String V0 = null;
    int Z0 = Integer.MIN_VALUE;
    int b1 = 0;
    private int c1 = Integer.MIN_VALUE;
    private int g1 = 2;
    private int h1 = 0;
    private final Map<String, String> j1 = new ConcurrentHashMap();
    private final Map<String, String> k1 = new ConcurrentHashMap();
    private volatile int m1 = -1;
    private volatile int o1 = -1;
    private final AtomicInteger r1 = new AtomicInteger(0);
    private final AtomicInteger s1 = new AtomicInteger(0);
    private boolean t1 = false;
    boolean u1 = false;
    List<Long> B1 = new ArrayList();
    List<Long> C1 = new ArrayList();
    private int E1 = -1;
    String a = String.valueOf(ks.a());

    private void c() {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_AVOUTSYNC_MAX_DIFF, 0, this);
    }

    private static void j1() {
        if (H1 != null) {
            return;
        }
        synchronized (h4.class) {
            if (H1 != null) {
                return;
            }
            String strB = r1.d().f().b("aiek", "");
            String[] strArrSplit = !TextUtils.isEmpty(strB) ? strB.split(",") : null;
            if (strArrSplit == null) {
                H1 = new String[0];
            } else {
                H1 = strArrSplit;
            }
        }
    }

    public h4(String str, String str2, String str3, e2 e2Var, JSONObject jSONObject, mb mbVar) {
        yq yqVar;
        this.H = -1;
        this.C = str;
        this.D = str2;
        this.E = str3;
        this.f776K = e2Var;
        this.L = mbVar;
        if (jSONObject == null) {
            return;
        }
        j1();
        Object objRemove = jSONObject.remove("ad_req");
        if (objRemove instanceof String) {
            this.n1 = (String) objRemove;
        }
        i4.a(this, jSONObject);
        this.M = jSONObject;
        this.H = a(jSONObject, str2);
        String strOptString = jSONObject.optString("negative_feedback_url");
        if (!TextUtils.isEmpty(strOptString)) {
            this.p = strOptString.replace("__ACT_TYPE__", "2001");
        }
        this.u = y.d(jSONObject);
        this.l0 = jSONObject.optInt("is_app_subscribe", 0) == 1 && y.b(this.n);
        if (k1()) {
            this.A = y.a(jSONObject);
        }
        if (this.d0 == null) {
            this.d0 = new q3();
        }
        this.a0 = jb.a(jSONObject);
        this.h0 = a(jSONObject);
        this.r0 = ef.a(jSONObject);
        this.Y0 = r9.a(jSONObject);
        this.q1 = bp.a(jSONObject, k.a(this));
        b.c().a(this.k0, this);
        vc.a(this.k0);
        if (e2Var == e2.REWARDVIDEOAD && je.C == -1) {
            je.C = xc.a("rppj", y0(), 0, x0());
        }
        if (je.C != 1 && (yqVar = this.E0) != null && yqVar.x()) {
            this.E0 = null;
        }
        x9.a(x0());
        if (this.E0 != null) {
            a50.b = xc.a("dlvncc", y0(), 10, x0());
            a50.c = xc.a("dlvnc", y0(), 0, x0(), new a()) == 0;
            q8.a().a(this);
        }
        this.G1 = y8.a(this, this.E0);
        this.d1 = ln.c(jSONObject.optJSONObject("ext2"));
        if (!this.M.has("v_type")) {
            this.S = this.R ? 1 : 0;
        }
        qn.a(this);
        yc.a(this);
        c();
    }

    /* compiled from: A */
    class a implements xc.b<Integer> {
        a() {
        }

        @Override // com.qq.e.comm.plugin.xc.b
        public void a(boolean z, Integer num, boolean z2, Integer num2) {
            if (!z2 || num2 == null) {
                return;
            }
            a50.d = (num.intValue() * 10) + num2.intValue();
        }
    }

    public final d7 z() {
        return this.O;
    }

    public final String g() {
        return this.b;
    }

    public final String R0() {
        return this.c;
    }

    public final String B() {
        return this.d;
    }

    public final String H() {
        return this.e;
    }

    public final String c0() {
        return this.f;
    }

    public final String d0() {
        return this.g;
    }

    public final String S() {
        return this.j;
    }

    public final String x() {
        return this.l;
    }

    public final String F() {
        return this.m;
    }

    public final int B0() {
        return this.n;
    }

    public final int I() {
        return this.o;
    }

    public final String q0() {
        return this.p;
    }

    public final boolean k1() {
        return this.u && !this.l0;
    }

    public final boolean E1() {
        return this.o == 12;
    }

    public final boolean F1() {
        return this.o == 23;
    }

    public final boolean u1() {
        return this.n == 53;
    }

    public final boolean z1() {
        return this.v;
    }

    public final boolean y1() {
        return this.w && this.v;
    }

    public final String O0() {
        return this.x;
    }

    public int H0() {
        return this.F0;
    }

    public int P0() {
        if (this.c1 == Integer.MIN_VALUE) {
            yq yqVar = this.E0;
            if (yqVar != null) {
                this.c1 = yqVar.a;
            } else {
                this.c1 = 0;
            }
        }
        return this.c1;
    }

    public final l3 o() {
        return this.A;
    }

    public final String y0() {
        return this.D;
    }

    public boolean x1() {
        return !TextUtils.isEmpty(this.E);
    }

    public final e2 k() {
        return this.f776K;
    }

    public final String n() {
        return this.C;
    }

    public final JSONObject h() {
        return this.M;
    }

    public final String i() {
        if (TextUtils.isEmpty(this.N)) {
            this.N = this.M.toString();
        }
        return this.N;
    }

    public final String j() {
        return this.n1;
    }

    public final String V0() {
        return this.Q;
    }

    public final boolean n1() {
        return this.R;
    }

    public final int Z0() {
        return this.S;
    }

    public final String S0() {
        return this.r;
    }

    public final String r0() {
        return this.t;
    }

    public final int M() {
        return this.F;
    }

    public final String g1() {
        return this.G;
    }

    public final int o0() {
        return this.H;
    }

    public final boolean l1() {
        return this.I > 1;
    }

    public final int z0() {
        l00 l00Var = this.J;
        if (l00Var != null) {
            return l00Var.a();
        }
        return -1;
    }

    public final int b1() {
        return this.T;
    }

    public final int X0() {
        return this.U;
    }

    public final int W0() {
        return this.V;
    }

    public final List<xv> E0() {
        return this.W;
    }

    public final List<String> v() {
        return this.Y;
    }

    public final ku x0() {
        return this.k0;
    }

    public final ib L() {
        return this.a0;
    }

    public final String a1() {
        return this.b0;
    }

    public final String C() {
        String str = this.c0;
        if (str == null || TextUtils.isEmpty(str)) {
            return u1() ? "打开快应用" : E1() ? "去微信看看" : this.u ? "立即下载" : "查看详情";
        }
        return this.c0;
    }

    public final String D() {
        return this.e0;
    }

    public final String u0() {
        return this.c0;
    }

    public final q3 q() {
        return this.d0;
    }

    public final int n0() {
        return this.f0;
    }

    public final String G() {
        return this.g0;
    }

    public final k50 d1() {
        return this.h0;
    }

    public final boolean C1() {
        return !TextUtils.isEmpty(V0());
    }

    public final boolean o1() {
        ku kuVar = this.k0;
        if (kuVar == null) {
            return false;
        }
        return kuVar.c();
    }

    public final String A0() {
        return this.j0;
    }

    public final int w0() {
        return this.h;
    }

    public final int v0() {
        return this.i;
    }

    public final int Q0() {
        return this.y;
    }

    public final int N0() {
        return this.z;
    }

    public final List<String> I0() {
        return this.m0;
    }

    public final boolean m1() {
        return this.p0;
    }

    public final int f() {
        return this.s0;
    }

    public final String b0() {
        return this.t0;
    }

    public final yq p0() {
        return this.E0;
    }

    public final String c1() {
        return this.v0;
    }

    public final String f1() {
        return this.w0;
    }

    public final int g0() {
        return this.B0;
    }

    public final double K() {
        return this.G0;
    }

    public String s0() {
        return this.a;
    }

    public final List<r9> l0() {
        return this.Y0;
    }

    public String f0() {
        return this.f1;
    }

    public final boolean A1() {
        return this.K0;
    }

    public final String F0() {
        if (this.O0 == null) {
            return null;
        }
        return this.O0.optString("rcc") + this.O0.optString("rcd");
    }

    public final int r() {
        if (this.m1 >= 0) {
            return this.m1;
        }
        synchronized (this) {
            if (this.m1 >= 0) {
                return this.m1;
            }
            y1 y1VarC = c(5);
            if (y1VarC != null) {
                this.m1 = y1VarC.c();
            }
            if (this.m1 < 0) {
                this.m1 = 0;
            }
            return this.m1;
        }
    }

    public final int J() {
        if (this.o1 >= 0) {
            return this.o1;
        }
        synchronized (this) {
            if (this.o1 >= 0) {
                return this.o1;
            }
            y1 y1VarC = c(7);
            if (y1VarC != null) {
                this.o1 = y1VarC.c();
            }
            if (this.o1 < 0) {
                this.o1 = 0;
            }
            return this.o1;
        }
    }

    public int T0() {
        return this.r1.get();
    }

    public void i1() {
        this.r1.incrementAndGet();
    }

    public final int U0() {
        return this.s1.get();
    }

    public final int l() {
        if (r() <= 0) {
            return 0;
        }
        return this.s1.getAndIncrement();
    }

    public boolean a0() {
        return this.t1;
    }

    public boolean s1() {
        return this.u1;
    }

    public boolean t1() {
        return this.N0 == 1;
    }

    public int e0() {
        return this.M0;
    }

    public final long d() {
        return this.v1;
    }

    public final long h0() {
        if (this.w1 <= 0) {
            this.w1 = System.currentTimeMillis();
        }
        return this.w1;
    }

    public final boolean v1() {
        return this.a1;
    }

    public final long L0() {
        return this.x1;
    }

    public final long X() {
        return this.y1;
    }

    public final long R() {
        return this.z1;
    }

    public final long Y0() {
        return this.A1;
    }

    public final void b(long j) {
        if (this.B1 == null) {
            this.B1 = new ArrayList();
        }
        this.B1.add(Long.valueOf(j));
    }

    public List<Long> w() {
        return this.B1;
    }

    public final void a(long j) {
        if (this.C1 == null) {
            this.C1 = new ArrayList();
        }
        this.C1.add(Long.valueOf(j));
    }

    public List<Long> s() {
        return this.C1;
    }

    public final long Y() {
        return this.D1;
    }

    public String p() {
        return this.n0;
    }

    public String k0() {
        return this.q0;
    }

    public List<ef> Z() {
        return this.r0;
    }

    public boolean w1() {
        return this.x0;
    }

    public String K0() {
        return this.y0;
    }

    public String e1() {
        return this.z0;
    }

    public String W() {
        return this.A0;
    }

    public final String y() {
        return this.H0;
    }

    public final String C0() {
        return this.I0;
    }

    public long M0() {
        if (this.C0 <= 0 && this.i0) {
            this.C0 = ap.a();
        }
        return this.C0;
    }

    public int D0() {
        return this.Z0;
    }

    public final int E() {
        return this.J0;
    }

    public boolean h1() {
        if (this.E1 < 0) {
            this.E1 = y8.b(this);
        }
        int i = this.F1 + 1;
        this.F1 = i;
        int i2 = this.E1;
        if (i2 > 0) {
            y8.a(this, i2, i);
        }
        return I1();
    }

    public boolean I1() {
        int i = this.E1;
        return i > 0 && this.F1 >= i;
    }

    public int J0() {
        return this.G1;
    }

    public boolean D1() {
        if (this.V0 == null) {
            i0();
        }
        return !TextUtils.isEmpty(this.V0);
    }

    public String i0() {
        if (this.V0 == null) {
            synchronized (this) {
                if (this.V0 == null) {
                    if (c(6) == null) {
                        this.V0 = "";
                    } else {
                        jn jnVar = new jn();
                        jnVar.a("acra", 6);
                        jnVar.a("sld", 8);
                        this.V0 = th.a(this.l, ac.a(jnVar.toString(), "click"));
                    }
                }
            }
        }
        if (!this.V0.isEmpty()) {
            return this.V0;
        }
        return this.U0;
    }

    public boolean r1() {
        return this.Q0;
    }

    public String u() {
        return this.R0;
    }

    public String m() {
        return this.S0;
    }

    public String t0() {
        return this.T0;
    }

    public boolean B1() {
        return this.p1;
    }

    public void H1() {
        this.p1 = true;
    }

    public JSONObject e() {
        return this.W0;
    }

    public JSONArray A() {
        return this.X0;
    }

    public String N() {
        if (!TextUtils.isEmpty(this.t)) {
            return this.t;
        }
        return this.r;
    }

    public final Map<String, Object> V() {
        HashMap map = new HashMap();
        map.put("mp", Integer.valueOf(this.H));
        map.put("request_id", this.r);
        map.put("is_reward_ad", Boolean.valueOf(this.x0));
        map.put(NetworkDefine.PARAM_TOKEN, this.s);
        Map<String, Object> map2 = this.d1;
        if (map2 != null) {
            map.putAll(map2);
        }
        map.put("exp_dev_extra", this.j1);
        map.put("click_dev_extra", this.k1);
        return map;
    }

    public final Map<String, String> O() {
        return this.j1;
    }

    public final Map<String, String> t() {
        return this.k1;
    }

    public final String T() {
        return this.L0;
    }

    public int Q() {
        return this.g1;
    }

    public void G1() {
        this.g1 = 1;
    }

    public int P() {
        return this.h1;
    }

    public int U() {
        SparseArray<h4> sparseArray = this.e1;
        if (sparseArray != null) {
            return sparseArray.size();
        }
        yq yqVar = this.E0;
        if (yqVar == null) {
            return 0;
        }
        return yqVar.i();
    }

    public long j0() {
        return this.i1;
    }

    public boolean p1() {
        yq yqVarP0 = p0();
        return yqVarP0 != null && yqVarP0.D();
    }

    public boolean q1() {
        yq yqVar = this.E0;
        return yqVar == null || yqVar.E();
    }

    public JSONArray G0() {
        return this.P0;
    }

    public bp m0() {
        return this.q1;
    }

    public final void h(long j) {
        this.x1 = j;
    }

    public final void i(long j) {
        this.A1 = j;
    }

    public final void f(long j) {
        this.w1 = j;
    }

    public void g(long j) {
        this.i1 = j;
    }

    public final h4 b(int i) {
        SparseArray<h4> sparseArray;
        if (i < 0 || (sparseArray = this.e1) == null) {
            return null;
        }
        return sparseArray.get(i);
    }

    private y1 c(int i) {
        JSONArray jSONArray = this.P0;
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            y1 y1VarA = y1.a(this.P0.optJSONObject(i2), i);
            if (y1VarA != null) {
                return y1VarA;
            }
        }
        return null;
    }

    public boolean d(int i) {
        return (i & this.l1) > 0;
    }

    public void a(int i) {
        this.l1 = i | this.l1;
    }

    public void e(int i) {
        this.h1 = i;
    }

    public void b(boolean z) {
        this.t1 = z;
    }

    public void f(int i) {
        this.Z0 = i;
    }

    public final void c(long j) {
        this.z1 = j;
    }

    public final h4 a(String str) {
        int size;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equals(this.r)) {
            return this;
        }
        SparseArray<h4> sparseArray = this.e1;
        if (sparseArray != null && (size = sparseArray.size()) != 0) {
            for (int i = 0; i < size; i++) {
                h4 h4VarValueAt = this.e1.valueAt(i);
                if (h4VarValueAt != null && str.equals(h4VarValueAt.r)) {
                    return h4VarValueAt;
                }
            }
        }
        return null;
    }

    public final void d(long j) {
        this.y1 = j;
    }

    public final void e(long j) {
        this.D1 = j;
    }

    public final void c(boolean z) {
        this.u1 = z;
    }

    public void b(String str) {
        this.f1 = str;
    }

    public static int a(JSONObject jSONObject, String str) {
        String strOptString = jSONObject.optString("mp");
        if (!TextUtils.isEmpty(strOptString)) {
            try {
                byte[] bArrD = lx.d(Base64.decode(strOptString, 0));
                if (bArrD != null) {
                    return Integer.parseInt(new String(bArrD, d6.a));
                }
            } catch (lx.d unused) {
                b10.a(1232002, new f5().c(str));
            } catch (NumberFormatException unused2) {
            }
        }
        return -1;
    }

    public void a(int i, h4 h4Var) {
        if (this.e1 == null) {
            this.e1 = new SparseArray<>(5);
        }
        this.e1.put(i, h4Var);
    }

    public final void a(boolean z) {
        this.D0 = z;
    }

    public void a(yq yqVar) {
        if (yqVar == null) {
            return;
        }
        String strM = yqVar.m();
        if (!TextUtils.isEmpty(strM)) {
            if (!TextUtils.isEmpty(this.j)) {
                this.j = a30.c(this.j, "template_id", strM);
            }
            if (!TextUtils.isEmpty(this.l)) {
                this.l = a30.c(this.l, "template_id", strM);
            }
        }
        this.E0 = yqVar;
        this.x = strM;
        this.c1 = yqVar.v();
    }

    public static k50 a(JSONObject jSONObject) {
        return new k50(jSONObject.optString("wxappid"), jSONObject.optJSONObject("wechat_ad_trace_data"), jSONObject.optString("wechat_app_username"), jSONObject.optString("wechat_app_path"), jSONObject.optString("wechat_app_token"));
    }
}

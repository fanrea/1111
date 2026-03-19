package com.baidu.mobads.container.h;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.container.h;
import com.baidu.mobads.container.j;
import com.baidu.mobads.container.l.g;
import com.baidu.mobads.container.util.SPUtils;
import com.baidu.mobads.container.util.bl;
import com.baidu.mobads.container.util.n;
import com.baidu.mobads.container.util.u;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static final String a = "image_memory_cache";
    public static final String b = "function";
    public static final String c = "state_machine";
    public static final String d = "state_machine_storage";
    public static final String e = "performance_monitoring";
    public static final String f = "track_log_386";
    public static final String g = "track_log_455";
    public static final String h = "mffunc";
    public static final String i = "check_thread";
    public static final String j = "track_sub_809";
    public static final String k = "reissue_delay";
    public static final String l = "reissue_expiretime";
    public static final String m = "reissue_retry_count";
    public static final String n = "exoplayer_enable";
    public static final String o = "apk_link_dialog";
    public static final String p = "my4bThqGua4sugFVpgP1pyq8Q-7NwNFugY7nH7qffRPQfRI7Rzfb";
    private static final String q = a.class.getName();
    private static volatile a r = null;
    private Context v;
    private JSONObject w;
    private JSONArray y;
    private double z;
    private String s = "baidu_cloudControlConfig";
    private final String t = "preload";
    private final String u = "function";
    private EnumC0128a x = EnumC0128a.AVAILABLE_PK_TYPE_GRAY;
    private String A = null;
    private String B = null;
    private String C = null;
    private String D = null;
    private String E = null;
    private Boolean F = null;
    private Boolean G = null;
    private Boolean H = null;
    private Boolean I = null;
    private String J = null;

    /* renamed from: K, reason: collision with root package name */
    private Boolean f732K = null;
    private Boolean L = null;
    private Boolean M = null;
    private int N = -1;
    private int O = -1;
    private int P = -1;
    private int Q = -1;
    private int R = -1;
    private int S = -1;
    private int T = -1;
    private int U = -1;
    private Long V = null;
    private Long W = null;
    private Long X = null;
    private Boolean Y = null;
    private String Z = "";
    private int aa = -1;
    private int ab = -1;
    private final HashMap<String, String> ac = new HashMap<>();

    /* renamed from: com.baidu.mobads.container.h.a$a, reason: collision with other inner class name */
    public enum EnumC0128a {
        AVAILABLE_PK_TYPE_GRAY(1),
        AVAILABLE_PK_TYPE_ASSETS(2),
        AVAILABLE_PK_TYPE_SPECIAL(3);

        private int d;

        EnumC0128a(int i) {
            this.d = i;
        }

        public int b() {
            return this.d;
        }
    }

    public static a a() {
        if (r == null) {
            synchronized (a.class) {
                if (r == null) {
                    r = new a();
                    r.a(com.baidu.mobads.container.config.b.a().c());
                }
            }
        }
        return r;
    }

    public void a(Context context) {
        if (context != null) {
            this.v = context.getApplicationContext();
        }
    }

    private a() {
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x02d1 A[Catch: all -> 0x02d7, TRY_LEAVE, TryCatch #6 {all -> 0x02d7, blocks: (B:3:0x0010, B:6:0x001f, B:9:0x0032, B:119:0x02bb, B:121:0x02d1, B:114:0x02ac, B:117:0x02b4), top: B:132:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 732
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.container.h.a.a(java.lang.String):void");
    }

    public void b() {
        JSONObject jSONObjectOptJSONObject;
        try {
            SPUtils sPUtils = new SPUtils(this.v, h.n);
            if (this.w != null && (jSONObjectOptJSONObject = this.w.optJSONObject("logo_list")) != null) {
                String strOptString = jSONObjectOptJSONObject.optString(h.q);
                if (!TextUtils.isEmpty(strOptString)) {
                    sPUtils.putString(h.q, strOptString);
                    n.a = strOptString;
                }
                String strOptString2 = jSONObjectOptJSONObject.optString(h.r);
                if (!TextUtils.isEmpty(strOptString2)) {
                    sPUtils.putString(h.r, strOptString2);
                    n.b = strOptString2;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(double d2) {
        if (this.y == null) {
            return;
        }
        try {
            double dB = c.a(this.v).b();
            String str = dB == 0.0d ? "" : "" + dB;
            double dA = c.a(this.v).a();
            String str2 = dA != 0.0d ? "" + dA : "";
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            for (int i2 = 0; i2 < this.y.length(); i2++) {
                String strOptString = this.y.optString(i2);
                if (j.b() == Double.valueOf(strOptString).doubleValue()) {
                    this.z = Double.valueOf(strOptString).doubleValue();
                }
                if (!TextUtils.isEmpty(str) && strOptString.equals(str)) {
                    z = true;
                }
                if ((!TextUtils.isEmpty(str2) && strOptString.equals(str2)) || TextUtils.isEmpty(str2)) {
                    z2 = true;
                }
                if (d2 == Double.valueOf(strOptString).doubleValue() || d2 <= dB) {
                    z3 = true;
                }
            }
            if (!z || !z2 || !z3) {
                this.x = EnumC0128a.AVAILABLE_PK_TYPE_GRAY;
            } else {
                this.x = EnumC0128a.AVAILABLE_PK_TYPE_ASSETS;
            }
        } catch (Throwable th) {
        }
    }

    public int c() {
        if (this.x == null) {
            try {
                return new SPUtils(this.v, this.s).b("baidu_cloudConfig_pktype", 1);
            } catch (Throwable th) {
                th.printStackTrace();
                return 1;
            }
        }
        return this.x.b();
    }

    public boolean d() {
        try {
            return TextUtils.equals(a("function", "security_sdk"), "1");
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean b(double d2) {
        try {
            if (this.y == null) {
                String string = new SPUtils(this.v, this.s).getString("baidu_cloudConfig_v", "");
                if (!TextUtils.isEmpty(string)) {
                    this.y = new JSONArray(string);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (this.y == null) {
            return false;
        }
        if (d2 == this.z) {
            return true;
        }
        for (int i2 = 0; i2 < this.y.length(); i2++) {
            try {
                this.z = Double.parseDouble(this.y.optString(i2));
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            if (d2 == this.z) {
                return true;
            }
        }
        return false;
    }

    public String b(String str) {
        return a(str, null);
    }

    public String a(String str, String str2) {
        try {
            if (this.v == null) {
                this.v = com.baidu.mobads.container.config.b.a().c();
            }
            if (this.w == null && this.v != null) {
                String string = new SPUtils(this.v, this.s).getString("baidu_cloudConfig", "");
                if (!TextUtils.isEmpty(string)) {
                    this.w = new JSONObject(string);
                }
            }
        } catch (JSONException e2) {
            g.c(e2);
        } catch (Throwable th) {
            g.c(th);
        }
        if (this.w == null) {
            return null;
        }
        String strOptString = this.w.optString(str);
        if (TextUtils.isEmpty(str2)) {
            return strOptString;
        }
        if (!TextUtils.isEmpty(strOptString)) {
            return new JSONObject(strOptString).optString(str2);
        }
        return null;
    }

    public boolean e() {
        try {
            if (this.A == null) {
                this.A = a("function", "use_https");
            }
            if (TextUtils.equals(this.A, "1")) {
                return true;
            }
            if (TextUtils.equals(this.A, "0")) {
                return false;
            }
            return com.baidu.mobads.container.config.b.a().d();
        } catch (Throwable th) {
            return com.baidu.mobads.container.config.b.a().d();
        }
    }

    public boolean f() {
        try {
            if (this.B == null) {
                this.B = a("function", "use_location");
            }
            if (TextUtils.equals(this.B, "1")) {
                return true;
            }
            if (TextUtils.equals(this.B, "0")) {
                return false;
            }
            return bl.a(bl.a);
        } catch (Throwable th) {
            return bl.a(bl.a);
        }
    }

    public boolean g() {
        try {
            if (this.C == null) {
                this.C = a("function", "use_sn");
            }
            if (TextUtils.equals(this.C, "1")) {
                return true;
            }
            if (TextUtils.equals(this.C, "0")) {
                return false;
            }
            return bl.a(bl.d);
        } catch (Throwable th) {
            return bl.a(bl.d);
        }
    }

    public boolean h() {
        try {
            if (this.D == null) {
                this.D = a("function", "close_sp_shake");
            }
            if (TextUtils.equals(this.D, "1")) {
                return false;
            }
            if (TextUtils.equals(this.D, "0")) {
                return true;
            }
            return com.baidu.mobads.container.config.a.a().f();
        } catch (Throwable th) {
            return com.baidu.mobads.container.config.a.a().f();
        }
    }

    public boolean i() {
        try {
            if (this.E == null) {
                this.E = a("function", "use_o");
            }
            if (TextUtils.equals(this.E, "1")) {
                return true;
            }
            if (TextUtils.equals(this.E, "0")) {
                return false;
            }
            return bl.a(bl.e);
        } catch (Throwable th) {
            return bl.a(bl.e);
        }
    }

    public boolean j() {
        try {
            if (!TextUtils.isEmpty(this.J)) {
                return Boolean.parseBoolean(this.J);
            }
            return ((Boolean) com.baidu.mobads.container.config.a.a().g(com.baidu.mobads.container.config.a.E)).booleanValue();
        } catch (Throwable th) {
            return true;
        }
    }

    public boolean k() {
        if (Build.VERSION.SDK_INT < 30) {
            return true;
        }
        return this.v.checkSelfPermission(u.b(p)) == 0;
    }

    public boolean l() {
        try {
            if (this.F == null) {
                String strA = a("function", "use_new_impression");
                if (!TextUtils.isEmpty(strA)) {
                    this.F = Boolean.valueOf(Boolean.parseBoolean(strA));
                } else {
                    this.F = (Boolean) com.baidu.mobads.container.config.a.a().g("useNewImpression");
                }
            }
            return this.F.booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean m() {
        try {
            if (this.G == null) {
                String strA = a("function", "use_new_network");
                if (!TextUtils.isEmpty(strA)) {
                    this.G = Boolean.valueOf(Boolean.parseBoolean(strA));
                } else {
                    this.G = (Boolean) com.baidu.mobads.container.config.a.a().g("useNewNetwork");
                }
            }
            return this.G.booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean n() {
        try {
            if (this.H == null) {
                String strA = a("function", "use_eof_exception");
                if (!TextUtils.isEmpty(strA)) {
                    this.H = Boolean.valueOf(Boolean.parseBoolean(strA));
                } else {
                    this.H = (Boolean) com.baidu.mobads.container.config.a.a().g("switchEOFOn");
                }
            }
            return this.H.booleanValue();
        } catch (Throwable th) {
            return true;
        }
    }

    public int o() {
        try {
            if (this.O < 0) {
                this.O = c(e, a("function", e));
            }
            return this.O;
        } catch (Throwable th) {
            return -1;
        }
    }

    public int p() {
        try {
            if (this.N < 0) {
                this.N = c(c, a("function", c));
            }
            return this.N;
        } catch (Throwable th) {
            return -1;
        }
    }

    public int q() {
        try {
            if (this.P < 0) {
                this.P = c(d, a("function", d));
            }
            return this.P;
        } catch (Throwable th) {
            return -1;
        }
    }

    public boolean r() {
        try {
            if (this.Q < 0) {
                this.Q = c(i, a("function", i));
            }
            return 1 == this.Q;
        } catch (Throwable th) {
            return false;
        }
    }

    public int s() {
        try {
            if (this.R < 0) {
                this.R = c(f, a("function", f));
            }
            return this.R;
        } catch (Throwable th) {
            return -1;
        }
    }

    public int t() {
        try {
            if (this.S < 0) {
                this.S = c(g, a("function", g));
            }
            return this.S;
        } catch (Throwable th) {
            return -1;
        }
    }

    public int u() {
        try {
            if (this.T < 0) {
                this.T = c(h, a("function", h));
            }
            return this.T;
        } catch (Throwable th) {
            return -1;
        }
    }

    public long a(long j2) {
        try {
            if (this.V == null) {
                this.V = Long.valueOf(c(a("function", k)));
            }
            if (this.V.longValue() >= 0) {
                return this.V.longValue();
            }
        } catch (Throwable th) {
            g.b(th);
        }
        return j2;
    }

    public long b(long j2) {
        try {
            if (this.W == null) {
                this.W = Long.valueOf(c(a("function", l)));
            }
            if (this.W.longValue() >= 0) {
                return this.W.longValue();
            }
        } catch (Throwable th) {
            g.b(th);
        }
        return j2;
    }

    public long c(long j2) {
        try {
            if (this.X == null) {
                this.X = Long.valueOf(c(a("function", m)));
            }
            if (this.X.longValue() >= 0) {
                return this.X.longValue();
            }
        } catch (Throwable th) {
            g.b(th);
        }
        return j2;
    }

    public boolean v() {
        try {
            if (this.f732K == null) {
                String strA = a("function", "int_shake_check");
                if (!TextUtils.isEmpty(strA)) {
                    this.f732K = Boolean.valueOf(Boolean.parseBoolean(strA));
                } else {
                    this.f732K = (Boolean) com.baidu.mobads.container.config.a.a().g("intShakeCheck");
                }
            }
            return this.f732K.booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean w() {
        try {
            if (this.L == null) {
                String strA = a("function", "mtj_distinguish_logo");
                if (!TextUtils.isEmpty(strA)) {
                    this.L = Boolean.valueOf(Boolean.parseBoolean(strA));
                } else {
                    this.L = (Boolean) com.baidu.mobads.container.config.a.a().g("mtjDistinguishLogo");
                }
            }
            return this.L.booleanValue();
        } catch (Throwable th) {
            return true;
        }
    }

    public boolean x() {
        try {
            if (this.M == null) {
                String strA = a("function", "use_null_accessibility_delegate");
                if (!TextUtils.isEmpty(strA)) {
                    this.M = Boolean.valueOf(Boolean.parseBoolean(strA));
                } else {
                    this.M = (Boolean) com.baidu.mobads.container.config.a.a().g("useNullAccessibilityDelegate");
                }
            }
            return this.M.booleanValue();
        } catch (Throwable th) {
            return true;
        }
    }

    public boolean y() {
        try {
            if (this.Y == null) {
                this.Y = (Boolean) com.baidu.mobads.container.config.a.a().g("activityContentSwitch");
            }
            return this.Y.booleanValue();
        } catch (Throwable th) {
            return true;
        }
    }

    public String z() {
        try {
            if (this.Z == null) {
                this.Z = (String) com.baidu.mobads.container.config.a.a().g("activityExposureString");
            }
            return this.Z;
        } catch (Throwable th) {
            return "";
        }
    }

    public boolean A() {
        try {
            if (this.I == null) {
                String strA = a("function", "use_iad_time");
                if (!TextUtils.isEmpty(strA)) {
                    this.I = Boolean.valueOf(Boolean.parseBoolean(strA));
                } else {
                    this.I = (Boolean) com.baidu.mobads.container.config.a.a().g("iadexTimesOn");
                }
            }
            return this.I.booleanValue();
        } catch (Throwable th) {
            return true;
        }
    }

    public boolean B() {
        return Boolean.parseBoolean(b(com.baidu.mobads.container.config.a.z, "true"));
    }

    public boolean C() {
        return Boolean.parseBoolean(b(com.baidu.mobads.container.config.a.A, "true"));
    }

    public boolean D() {
        return Boolean.parseBoolean(b(com.baidu.mobads.container.config.a.F, "true"));
    }

    public boolean E() {
        try {
            if (this.ab < 0) {
                this.ab = c(com.baidu.mobads.container.config.a.G, a("function", com.baidu.mobads.container.config.a.G));
            }
            return this.ab == 1;
        } catch (Throwable th) {
            return true;
        }
    }

    public boolean F() {
        if (this.aa < 0) {
            if ("1".equals(a("function", n))) {
                this.aa = 1;
            } else {
                this.aa = 0;
            }
        }
        return this.aa == 1;
    }

    public boolean G() {
        try {
            if (this.U < 0) {
                String strA = a("function", j);
                if (TextUtils.isEmpty(strA)) {
                    this.U = ((Integer) com.baidu.mobads.container.config.a.a().g(j)).intValue();
                } else {
                    this.U = Integer.parseInt(strA);
                }
            }
            return this.U == 1;
        } catch (Throwable th) {
            return false;
        }
    }

    private String b(String str, String str2) {
        try {
            String strA = this.ac.get(str);
            if (strA == null) {
                strA = a("function", str);
                if (TextUtils.isEmpty(strA)) {
                    strA = "";
                }
                this.ac.put(str, strA);
            }
            if (TextUtils.isEmpty(strA)) {
                return (String) com.baidu.mobads.container.config.a.a().g(str);
            }
            return strA;
        } catch (Throwable th) {
            return str2;
        }
    }

    private long c(String str) {
        try {
            return Long.parseLong(str);
        } catch (Throwable th) {
            return -1L;
        }
    }

    private int c(String str, String str2) {
        try {
            return Integer.parseInt(str2);
        } catch (Throwable th) {
            return d(str);
        }
    }

    private int d(String str) {
        try {
            return ((Integer) com.baidu.mobads.container.config.a.a().g(str)).intValue();
        } catch (Throwable th) {
            return 0;
        }
    }
}

package com.alipay.sdk.m.m;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.u.e;
import com.alipay.sdk.m.u.j;
import com.alipay.sdk.m.u.n;
import com.baidu.mobstat.forbes.Config;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class a {
    public static final String A = "DynCon";
    public static final int B = 10000;
    public static final String C = "https://h5.m.taobao.com/mlapp/olist.html";
    public static final int D = 10;
    public static final boolean E = true;
    public static final boolean F = false;
    public static final boolean G = true;
    public static final boolean H = true;
    public static final boolean I = false;
    public static final boolean J = false;

    /* renamed from: K, reason: collision with root package name */
    public static final boolean f713K = false;
    public static final boolean L = false;
    public static final boolean M = true;
    public static final String N = "";
    public static final boolean O = false;
    public static final boolean P = false;
    public static final int Q = 1000;
    public static final boolean R = true;
    public static final String S = "";
    public static final boolean T = false;
    public static final boolean U = false;
    public static final int V = 1000;
    public static final int W = 20000;
    public static final boolean X = false;
    public static final String Y = "alipay_cashier_dynamic_config";
    public static final String Z = "timeout";
    public static final String a0 = "h5_port_degrade";
    public static final String b0 = "st_sdk_config";
    public static final String c0 = "tbreturl";
    public static final String d0 = "launchAppSwitch";
    public static final String e0 = "configQueryInterval";
    public static final String f0 = "deg_log_mcgw";
    public static final String g0 = "deg_start_srv_first";
    public static final String h0 = "prev_jump_dual";
    public static final String i0 = "bind_use_imp";
    public static final String j0 = "retry_bnd_once";
    public static final String k0 = "skip_trans";
    public static final String l0 = "start_trans";
    public static final String m0 = "up_before_pay";
    public static final String n0 = "lck_k";
    public static final String o0 = "use_sc_lck_a";
    public static final String p0 = "utdid_factor";
    public static final String q0 = "cfg_max_time";
    public static final String r0 = "get_oa_id";
    public static final String s0 = "notifyFailApp";
    public static final String t0 = "startactivity_in_ui_thread";
    public static final String u0 = "intercept_batch";
    public static final String v0 = "bind_with_startActivity";
    public static final String w0 = "enableStartActivityFallback";
    public static final String x0 = "enableBindExFallback";
    public static a y0;
    public JSONObject w;
    public int a = 10000;
    public boolean b = false;
    public String c = C;
    public int d = 10;
    public boolean e = true;
    public boolean f = false;
    public boolean g = false;
    public boolean h = false;
    public boolean i = true;
    public boolean j = true;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;
    public boolean n = false;
    public boolean o = true;
    public String p = "";
    public String q = "";
    public boolean r = false;
    public boolean s = false;
    public boolean t = false;
    public int u = 1000;
    public boolean v = false;
    public boolean x = true;
    public List<b> y = null;
    public int z = -1;

    /* renamed from: com.alipay.sdk.m.m.a$a, reason: collision with other inner class name */
    public class RunnableC0054a implements Runnable {
        public final /* synthetic */ com.alipay.sdk.m.s.a a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;

        public RunnableC0054a(com.alipay.sdk.m.s.a aVar, Context context, boolean z, int i) {
            this.a = aVar;
            this.b = context;
            this.c = z;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.alipay.sdk.m.p.b bVarA = new com.alipay.sdk.m.q.b().a(this.a, this.b);
                if (bVarA != null) {
                    a.this.a(this.a, bVarA.a());
                    a.this.a(com.alipay.sdk.m.s.a.h());
                    com.alipay.sdk.m.k.a.a(this.a, com.alipay.sdk.m.k.b.l, "offcfg|" + this.c + "|" + this.d);
                }
            } catch (Throwable th) {
                e.a(th);
            }
        }
    }

    private JSONObject A() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("timeout", i());
        jSONObject.put(a0, v());
        jSONObject.put(c0, o());
        jSONObject.put(e0, d());
        jSONObject.put(d0, b.a(j()));
        jSONObject.put(u0, g());
        jSONObject.put(f0, e());
        jSONObject.put(g0, f());
        jSONObject.put(h0, k());
        jSONObject.put(i0, b());
        jSONObject.put(j0, l());
        jSONObject.put(k0, n());
        jSONObject.put(l0, x());
        jSONObject.put(m0, p());
        jSONObject.put(o0, m());
        jSONObject.put(n0, h());
        jSONObject.put(v0, c());
        jSONObject.put(q0, y());
        jSONObject.put(r0, u());
        jSONObject.put(s0, s());
        jSONObject.put(w0, t());
        jSONObject.put(x0, r());
        jSONObject.put(t0, w());
        jSONObject.put(com.alipay.sdk.m.u.a.b, a());
        return jSONObject;
    }

    private int y() {
        return this.u;
    }

    public static a z() {
        if (y0 == null) {
            a aVar = new a();
            y0 = aVar;
            aVar.q();
        }
        return y0;
    }

    public boolean b() {
        return this.k;
    }

    public String c() {
        return this.q;
    }

    public int d() {
        return this.d;
    }

    public boolean e() {
        return this.h;
    }

    public boolean f() {
        return this.i;
    }

    public boolean g() {
        return this.e;
    }

    public String h() {
        return this.p;
    }

    public int i() {
        int i = this.a;
        if (i < 1000 || i > 20000) {
            e.b(A, "time(def) = 10000");
            return 10000;
        }
        e.b(A, "time = " + this.a);
        return this.a;
    }

    public List<b> j() {
        return this.y;
    }

    public boolean k() {
        return this.j;
    }

    public boolean l() {
        return this.l;
    }

    public boolean m() {
        return this.t;
    }

    public boolean n() {
        return this.m;
    }

    public String o() {
        return this.c;
    }

    public boolean p() {
        return this.o;
    }

    public void q() {
        Context contextB = com.alipay.sdk.m.s.b.d().b();
        String strA = j.a(com.alipay.sdk.m.s.a.h(), contextB, Y, null);
        try {
            this.z = Integer.parseInt(j.a(com.alipay.sdk.m.s.a.h(), contextB, p0, "-1"));
        } catch (Exception unused) {
        }
        a(strA);
    }

    public boolean r() {
        return this.s;
    }

    public boolean s() {
        return this.v;
    }

    public boolean t() {
        return this.r;
    }

    public boolean u() {
        return this.x;
    }

    public boolean v() {
        return this.b;
    }

    public boolean w() {
        return this.f;
    }

    public boolean x() {
        return this.n;
    }

    public static final class b {
        public final String a;
        public final int b;
        public final String c;

        public b(String str, int i, String str2) {
            this.a = str;
            this.b = i;
            this.c = str2;
        }

        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new b(jSONObject.optString(Config.PACKAGE_NAME), jSONObject.optInt("v", 0), jSONObject.optString("pk"));
        }

        public String toString() {
            return String.valueOf(a(this));
        }

        public static List<b> a(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                b bVarA = a(jSONArray.optJSONObject(i));
                if (bVarA != null) {
                    arrayList.add(bVarA);
                }
            }
            return arrayList;
        }

        public static JSONObject a(b bVar) throws JSONException {
            if (bVar == null) {
                return null;
            }
            try {
                return new JSONObject().put(Config.PACKAGE_NAME, bVar.a).put("v", bVar.b).put("pk", bVar.c);
            } catch (JSONException e) {
                e.a(e);
                return null;
            }
        }

        public static JSONArray a(List<b> list) {
            if (list == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(a(it.next()));
            }
            return jSONArray;
        }
    }

    public JSONObject a() {
        return this.w;
    }

    public void a(boolean z) {
        this.g = z;
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            a(new JSONObject(str));
        } catch (Throwable th) {
            e.a(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.alipay.sdk.m.s.a aVar) {
        try {
            JSONObject jSONObjectA = A();
            j.b(aVar, com.alipay.sdk.m.s.b.d().b(), Y, jSONObjectA.toString());
        } catch (Exception e) {
            e.a(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.alipay.sdk.m.s.a aVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(b0);
            com.alipay.sdk.m.u.a.a(aVar, jSONObjectOptJSONObject, com.alipay.sdk.m.u.a.a(aVar, jSONObject));
            if (jSONObjectOptJSONObject != null) {
                a(jSONObjectOptJSONObject);
            } else {
                e.e(A, "empty config");
            }
        } catch (Throwable th) {
            e.a(th);
        }
    }

    private void a(JSONObject jSONObject) {
        this.a = jSONObject.optInt("timeout", 10000);
        this.b = jSONObject.optBoolean(a0, false);
        this.c = jSONObject.optString(c0, C).trim();
        this.d = jSONObject.optInt(e0, 10);
        this.y = b.a(jSONObject.optJSONArray(d0));
        this.e = jSONObject.optBoolean(u0, true);
        this.h = jSONObject.optBoolean(f0, false);
        this.i = jSONObject.optBoolean(g0, true);
        this.j = jSONObject.optBoolean(h0, true);
        this.k = jSONObject.optBoolean(i0, false);
        this.l = jSONObject.optBoolean(j0, false);
        this.m = jSONObject.optBoolean(k0, false);
        this.n = jSONObject.optBoolean(l0, false);
        this.o = jSONObject.optBoolean(m0, true);
        this.p = jSONObject.optString(n0, "");
        this.t = jSONObject.optBoolean(o0, false);
        this.v = jSONObject.optBoolean(s0, false);
        this.q = jSONObject.optString(v0, "");
        this.u = jSONObject.optInt(q0, 1000);
        this.x = jSONObject.optBoolean(r0, true);
        this.r = jSONObject.optBoolean(w0, false);
        this.s = jSONObject.optBoolean(x0, false);
        this.f = jSONObject.optBoolean(t0, false);
        this.w = jSONObject.optJSONObject(com.alipay.sdk.m.u.a.b);
    }

    public void a(com.alipay.sdk.m.s.a aVar, Context context, boolean z, int i) {
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "oncfg|" + z + "|" + i);
        RunnableC0054a runnableC0054a = new RunnableC0054a(aVar, context, z, i);
        if (z && !n.h()) {
            int iY = y();
            if (n.a(iY, runnableC0054a, "AlipayDCPBlok")) {
                return;
            }
            com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.m0, "" + iY);
            return;
        }
        Thread thread = new Thread(runnableC0054a);
        thread.setName("AlipayDCP");
        thread.start();
    }

    public boolean a(Context context, int i) {
        if (this.z == -1) {
            this.z = n.a();
            j.b(com.alipay.sdk.m.s.a.h(), context, p0, String.valueOf(this.z));
        }
        return this.z < i;
    }
}

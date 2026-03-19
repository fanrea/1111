package com.qq.e.comm.plugin;

import android.text.TextUtils;
import android.view.View;
import com.kuaishou.android.live.network.ApiStatus;
import com.qq.e.comm.plugin.wp;
import io.netty.util.internal.StringUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class gf implements gk {
    private static final String i = "gf";
    private static final String j = m10.a("anNlcw");
    private static final String m = m10.a("anNlcA");
    private static final String n = m10.a("Y2pzbQ");
    private static final String o = m10.a("anNlZQ");
    private final f9 a;
    private final im b;
    private final h4 c;
    private final wp.b d;
    protected final List<d> e;
    private h8 f;
    private y1 g;
    private AtomicBoolean h;

    /* compiled from: A */
    interface d {
        boolean a(int i);
    }

    private String a(String str, JSONObject jSONObject) {
        return (String) pro.getobjresult(29, 0, this, str, jSONObject);
    }

    public void c() {
    }

    public void c(h8 h8Var) {
    }

    public void d(h8 h8Var) {
    }

    public void e(h8 h8Var) {
    }

    public void f(h8 h8Var) {
    }

    public void g(h8 h8Var) {
    }

    protected boolean j(h8 h8Var) {
        boolean zA = ro.b().a(b(h8Var), this.b.g());
        if (zA) {
            z30.a();
        }
        return zA;
    }

    public void k(h8 h8Var) {
    }

    public void l(h8 h8Var) {
    }

    public void m(h8 h8Var) {
    }

    public gf(f9 f9Var) {
        this(f9Var, null, null);
    }

    @Override // com.qq.e.comm.plugin.gk
    public void c(w40 w40Var, h8 h8Var) {
        a(w40Var, h8Var.c, j);
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ h8 a;

        a(h8 h8Var) {
            this.a = h8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            gf.this.c(this.a);
        }
    }

    public gf(f9 f9Var, h4 h4Var) {
        this(f9Var, h4Var, null);
    }

    public gf(f9 f9Var, h4 h4Var, wp.b bVar) {
        this.h = new AtomicBoolean(false);
        this.a = f9Var;
        this.b = f9Var.m();
        this.c = h4Var;
        this.d = bVar;
        this.e = new CopyOnWriteArrayList();
        b();
    }

    public void h(h8 h8Var) {
        vp.a(b(h8Var), this.d);
    }

    public void i(h8 h8Var) {
        this.b.a(h8Var.b, h8Var.c);
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ i6 a;
        final /* synthetic */ h8 b;

        b(i6 i6Var, h8 h8Var) {
            this.a = i6Var;
            this.b = h8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            gf.this.a(this.a, this.b);
            if (gf.this.c != null) {
                d8.b(gf.this.c);
            }
        }
    }

    private String a(w40 w40Var, JSONObject jSONObject, String str) {
        Object objA;
        if (jSONObject.length() <= 0) {
            return null;
        }
        String strReplace = jSONObject.optString(str).replace("()", "");
        if (TextUtils.isEmpty(strReplace) || (objA = this.a.a(str, strReplace, jSONObject)) == null) {
            return null;
        }
        return objA.toString();
    }

    public void b() {
        h4 h4VarB = b((h8) null);
        if (h4VarB == null) {
            return;
        }
        this.e.add(new c(c7.c(h4VarB), c7.d(h4VarB), c7.b(h4VarB), c7.a(h4VarB)));
    }

    /* compiled from: A */
    public static class c implements d {
        private final Set<String> a;
        private final Set<String> b;
        private final Set<String> c;
        private final Set<String> d;

        public c(Set<String> set, Set<String> set2, Set<String> set3, Set<String> set4) {
            this.a = set;
            this.b = set2;
            this.c = set3;
            this.d = set4;
        }

        private boolean a(String str, Set<String> set) {
            if (!TextUtils.isEmpty(str) && set != null && !set.isEmpty()) {
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    if (str.endsWith(it.next())) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean a(Set<String> set) {
            return (set == null || set.isEmpty()) ? false : true;
        }

        @Override // com.qq.e.comm.plugin.gf.d
        public boolean a(int i) {
            boolean z;
            if (i > 0) {
                String strValueOf = String.valueOf(i);
                if (!a(this.a) && !a(this.b)) {
                    if (a(this.d) || a(this.c)) {
                        Set<String> set = this.d;
                        z = (set != null && set.contains(strValueOf)) || a(strValueOf, this.c);
                        String unused = gf.i;
                        return z;
                    }
                    String unused2 = gf.i;
                    return false;
                }
                Set<String> set2 = this.a;
                z = (set2 != null && set2.contains(strValueOf)) || a(strValueOf, this.b);
                String unused3 = gf.i;
                return !z;
            }
            String unused4 = gf.i;
            return false;
        }
    }

    private i6 a(h8 h8Var, int i2) throws JSONException {
        JSONObject jSONObject = h8Var.c;
        h4 h4VarB = b(h8Var);
        i6 i6Var = new i6(h4VarB);
        i6Var.h = a(jSONObject, h8Var.a, h4VarB);
        i6Var.t = jSONObject.optInt("nw") == 0;
        i6Var.c = h8Var.d();
        i6Var.d = h8Var.c();
        i6Var.f = i2;
        i6Var.l = jSONObject.optInt("viewIndex", -1);
        int i3 = h8Var.a;
        if (i3 == 5) {
            i6Var.i = (float[]) jSONObject.opt("shakeMaxAcceleration");
        } else if (i3 == 8) {
            i6Var.j = new int[]{jSONObject.optInt("tx"), jSONObject.optInt("ty"), jSONObject.optInt("tz")};
            i6Var.k = jSONObject.optLong("nt", -999L);
        }
        i6Var.m = jSONObject;
        a(i6Var);
        int i4 = h8Var.a;
        if (i4 == 5 || i4 == 8) {
            i6Var.p = jSONObject.optLong("motionDuration", -999L);
        }
        e8 e8VarC = this.b.c();
        i6Var.q = e8VarC != null && e8VarC.k();
        i6Var.s = a(h8Var);
        return i6Var;
    }

    protected h4 b(h8 h8Var) {
        h4 h4Var = this.c;
        if (h4Var == null) {
            return null;
        }
        if (h8Var == null) {
            return h4Var;
        }
        h4 h4VarA = this.c.a(h8Var.c.optString("tid"));
        return h4VarA != null ? h4VarA : this.c;
    }

    private boolean b(w40 w40Var) {
        if (w40Var == null || !w40Var.K()) {
            return false;
        }
        for (w40 w40VarC = w40Var; w40VarC != null; w40VarC = w40VarC.C()) {
            if (!w40VarC.L() || !w40Var.K() || w40VarC.A().getAlpha() == 0.0f) {
                return false;
            }
        }
        return true;
    }

    void a(JSONObject jSONObject) {
        h8 h8Var = this.f;
        this.f = null;
        if (h8Var == null) {
            return;
        }
        a(h8Var.b, h8Var);
    }

    public boolean b(i6 i6Var) {
        int i2 = i6Var.u;
        if (i2 <= 0) {
            return true;
        }
        if (!a(i2)) {
            return false;
        }
        i6Var.s = this.g;
        return true;
    }

    @Override // com.qq.e.comm.plugin.gk
    public boolean b(w40 w40Var, h8 h8Var) {
        if (!w40Var.K()) {
            return false;
        }
        JSONObject jSONObject = h8Var.c;
        boolean z = jSONObject.optInt("pc", 0) == 1;
        String strA = a(w40Var, jSONObject, n);
        if (z) {
            this.f = h8Var;
            return true;
        }
        if (strA == null) {
            strA = h8Var.b;
        } else if (strA.length() == 0) {
            this.f = h8Var;
            return true;
        }
        return a(strA, h8Var);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private boolean a(String str, h8 h8Var) throws JSONException {
        f9 f9Var = this.a;
        if (f9Var != null) {
            f9Var.a(h8Var, str);
        }
        String strA = a(str, h8Var.c);
        strA.hashCode();
        strA.hashCode();
        boolean z = false;
        char c2 = 65535;
        switch (strA.hashCode()) {
            case -1936979796:
                if (strA.equals("popupClose")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1625740791:
                if (strA.equals("showLandingPage")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1178343643:
                if (strA.equals("adClick")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1178337387:
                if (strA.equals("adClose")) {
                    c2 = 3;
                    break;
                }
                break;
            case -841999016:
                if (strA.equals("ctaClick")) {
                    c2 = 4;
                    break;
                }
                break;
            case -682345939:
                if (strA.equals("endCardClose")) {
                    c2 = 5;
                    break;
                }
                break;
            case -266912051:
                if (strA.equals("userEyes")) {
                    c2 = 6;
                    break;
                }
                break;
            case -264639046:
                if (strA.equals("adLogoClick")) {
                    c2 = 7;
                    break;
                }
                break;
            case -155481098:
                if (strA.equals("popupSucceed")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 94750088:
                if (strA.equals("click")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 94756344:
                if (strA.equals("close")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 158711817:
                if (strA.equals("popupFailed")) {
                    c2 = 11;
                    break;
                }
                break;
            case 976974752:
                if (strA.equals("gameEntry")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 1046787284:
                if (strA.equals("replayVideo")) {
                    c2 = StringUtil.CARRIAGE_RETURN;
                    break;
                }
                break;
            case 1148342887:
                if (strA.equals("stopAutoAction")) {
                    c2 = 14;
                    break;
                }
                break;
            case 1372735184:
                if (strA.equals("forceCloseAd")) {
                    c2 = 15;
                    break;
                }
                break;
            case 1522058230:
                if (strA.equals("miitActivity")) {
                    c2 = 16;
                    break;
                }
                break;
            case 1756742202:
                if (strA.equals("volumeChanged")) {
                    c2 = 17;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case '\b':
            case 11:
                i(h8Var);
                return true;
            case 1:
                l(h8Var);
                return true;
            case 2:
            case '\t':
                a(h8Var, z);
                return true;
            case 3:
            case '\n':
                xo.a((Runnable) new a(h8Var));
                return true;
            case 4:
                z = true;
                a(h8Var, z);
                return true;
            case 5:
                e(h8Var);
                return true;
            case 6:
                return j(h8Var);
            case 7:
                d(h8Var);
                return true;
            case '\f':
                g(h8Var);
                return true;
            case '\r':
                k(h8Var);
                return true;
            case 14:
                m(h8Var);
                return true;
            case 15:
                f(h8Var);
                return true;
            case 16:
                h(h8Var);
                return true;
            case 17:
                c();
                return true;
            default:
                return false;
        }
    }

    private void a(i6 i6Var) throws JSONException {
        Set<w40> setD = this.a.d();
        if (setD == null || setD.isEmpty()) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        int[] iArr = new int[2];
        View viewG = this.b.g();
        if (viewG == null) {
            return;
        }
        viewG.getLocationOnScreen(iArr);
        for (w40 w40Var : setD) {
            if (b(w40Var)) {
                w40Var.A().getLocationOnScreen(new int[2]);
                jn jnVar = new jn();
                jnVar.a("cvx", String.valueOf(zu.b(r5[0] - iArr[0])));
                jnVar.a("cvy", String.valueOf(zu.b(r5[1] - iArr[1])));
                jnVar.a("cvw", String.valueOf(zu.b(w40Var.A().getWidth())));
                jnVar.a("cvh", String.valueOf(zu.b(w40Var.A().getHeight())));
                jnVar.a("cvt", String.valueOf(a(w40Var)));
                jnVar.a("cvv", ((Boolean) d50.a(w40Var.A(), 50, -1).first).booleanValue() ? "1" : "-1");
                jSONArray.put(jnVar.a());
            }
        }
        if (jSONArray.length() >= 0) {
            i6Var.o = jSONArray;
        }
    }

    private int a(w40 w40Var) {
        if (w40Var == null) {
            return -1;
        }
        for (h8 h8Var : w40Var.t()) {
            if ("adClose".equals(h8Var.b)) {
                return 1;
            }
            if ("endCardClose".equals(h8Var.b)) {
                return 2;
            }
            if ("forceCloseAd".equals(h8Var.b)) {
                return 3;
            }
        }
        return -1;
    }

    private y1 a(h8 h8Var) {
        int i2;
        y1 y1Var = this.g;
        if (y1Var == null) {
            return null;
        }
        int iA = y1Var.a();
        if (iA == h8Var.c.optInt("acra", 0) || (((i2 = h8Var.a) == 5 && iA == 3) || (i2 == 8 && iA == 4))) {
            return this.g;
        }
        return null;
    }

    private int a(JSONObject jSONObject, int i2, h4 h4Var) {
        int iOptInt = jSONObject.optInt("sld", ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG);
        if (iOptInt != -999) {
            return iOptInt;
        }
        if (i2 == 1) {
            return h4Var != null ? k6.a(jSONObject, h4Var.k()) ? 4 : 0 : iOptInt;
        }
        if (i2 == 5) {
            return 2;
        }
        if (i2 == 4) {
            return 1;
        }
        if (i2 == 8) {
            return 5;
        }
        return iOptInt;
    }

    private boolean a(int i2) {
        y1 y1Var = this.g;
        return y1Var != null && y1Var.a() == i2 && this.h.compareAndSet(false, true);
    }

    public void a(i6 i6Var, h8 h8Var) {
        if (h8Var != null) {
            int i2 = h8Var.a;
            if (i2 == 5 || i2 == 8) {
                z30.a();
            }
        }
    }

    @Override // com.qq.e.comm.plugin.gk
    public void a(w40 w40Var, h8 h8Var) {
        a(w40Var, h8Var.c, o);
    }

    @Override // com.qq.e.comm.plugin.gk
    public void a(w40 w40Var, h8 h8Var, float f) {
        a(w40Var, h8Var.c, m);
    }

    void a(y1 y1Var) {
        this.g = y1Var;
    }

    private boolean a(h8 h8Var, boolean z) throws JSONException {
        h4 h4Var;
        h4 h4VarB;
        int iE = -1;
        if (z && (h4VarB = b(h8Var)) != null && h4VarB.z() != null) {
            iE = h4VarB.z().e();
        }
        i6 i6VarA = a(h8Var, iE);
        Iterator<d> it = this.e.iterator();
        while (it.hasNext()) {
            if (it.next().a(i6VarA.c)) {
                return false;
            }
        }
        e8 e8VarC = this.b.c();
        int i2 = h8Var.a;
        if ((i2 == 4 || i2 == 1) && e8VarC != null && e8VarC.k() && (h4Var = this.c) != null && h4Var.h1()) {
            e8VarC.a(0);
        }
        xo.a((Runnable) new b(i6VarA, h8Var));
        return true;
    }
}

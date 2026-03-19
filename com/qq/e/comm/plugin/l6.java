package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;
import java.util.List;
import java.util.concurrent.Future;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class l6 {
    private final m6 A;
    public final h4 B;
    public final int C;
    public final a7 D;
    public final boolean E;
    public final boolean F;
    public boolean G;
    public boolean H;
    public int I;
    public JSONObject J;

    /* renamed from: K, reason: collision with root package name */
    public y1 f778K;
    public final int L;
    public final long a;
    final e2 b;
    final int c;
    final String d;
    final boolean e;
    final boolean f;
    final String g;
    final boolean h;
    final int i;
    final Boolean j;
    final d7 k;
    final boolean l;
    final boolean m;
    final String n;
    final boolean o;
    final boolean p;
    final Integer q;
    final long r;
    final boolean s;
    final boolean t;
    final boolean u;
    final Context v;
    final int w;
    final f5 x;
    private Future<m6> y;
    String z;

    private l6(b bVar) {
        String strG;
        List<r9> listL0;
        this.a = System.currentTimeMillis();
        this.G = true;
        this.H = false;
        h4 h4Var = bVar.a;
        this.B = h4Var;
        this.b = h4Var.k();
        this.c = h4Var.B0();
        if (bVar.k <= -1 || (listL0 = h4Var.l0()) == null || listL0.size() <= bVar.k) {
            this.d = h4Var.x();
            strG = h4Var.G();
        } else {
            r9 r9Var = listL0.get(bVar.k);
            String strA = r9Var.a();
            this.d = TextUtils.isEmpty(strA) ? h4Var.x() : strA;
            strG = r9Var.b();
            if (TextUtils.isEmpty(strG)) {
                strG = h4Var.G();
            }
        }
        this.e = h4Var.C1();
        boolean zD = a30.d(strG);
        this.f = zD;
        this.g = zD ? strG : null;
        this.h = h4Var.k1();
        l3 l3VarO = h4Var.o();
        if (l3VarO != null && !TextUtils.isEmpty(l3VarO.e())) {
            this.i = com.qq.e.comm.plugin.apkmanager.l.e().b(l3VarO.e());
        } else {
            this.i = 0;
        }
        if (k.d(h4Var)) {
            this.j = Boolean.TRUE;
        } else if (k.f(h4Var)) {
            this.j = Boolean.FALSE;
        } else {
            this.j = null;
        }
        this.k = h4Var.z();
        this.l = h4Var.z1();
        this.m = (h4Var instanceof pw) && ((pw) h4Var).L1() == rw.PAGE;
        this.E = h4Var.E() == 1;
        this.n = bVar.b;
        b.k(bVar);
        this.o = bVar.c;
        this.p = bVar.d;
        this.q = bVar.e;
        this.r = bVar.f;
        this.s = bVar.g;
        this.t = bVar.h;
        this.u = bVar.i;
        this.v = r1.d().a();
        this.x = f5.a(h4Var);
        if (h4Var.r1()) {
            this.w = -1;
            this.A = new m6(200, h4Var.S0(), null, h4Var.m(), h4Var.u(), h4Var.t0(), this.j != null ? 0 : null);
        } else {
            this.w = n6.a();
            this.A = null;
        }
        this.C = bVar.j;
        this.D = bVar.p;
        this.F = bVar.l;
        this.J = bVar.m;
        this.I = bVar.n;
        this.f778K = bVar.o;
        this.L = n6.a(h4Var);
    }

    protected m6 a() {
        m6 m6Var = this.A;
        if (m6Var != null) {
            return m6Var;
        }
        try {
            return this.y.get();
        } catch (Exception unused) {
            return new m6(-1);
        }
    }

    /* compiled from: A */
    public static class b {
        private h4 a;
        private String b;
        private long f;
        private boolean g;
        private int j;
        private JSONObject m;
        private int n;
        private y1 o;
        private a7 p;
        private boolean c = false;
        private boolean d = false;
        private Integer e = 0;
        private boolean h = true;
        private boolean i = true;
        private int k = -1;
        private boolean l = false;

        static /* synthetic */ f2 k(b bVar) {
            bVar.getClass();
            return null;
        }

        public b(h4 h4Var) {
            this.a = h4Var;
            this.f = h4Var.M0();
        }

        public b a(String str) {
            this.b = str;
            return this;
        }

        public b c(boolean z) {
            this.c = z && !this.a.A1();
            return this;
        }

        private b e(boolean z) {
            this.d = z;
            return this;
        }

        public b d(boolean z) {
            this.g = z;
            return this;
        }

        public b b(boolean z) {
            this.i = z;
            return this;
        }

        public b f(boolean z) {
            this.l = z;
            return this;
        }

        public b a(boolean z) {
            this.h = z;
            return this;
        }

        public b c(int i) {
            this.n = i;
            return this;
        }

        private b d(int i) {
            this.k = i;
            return this;
        }

        private b b(int i) {
            this.j = i;
            return this;
        }

        private b a(int i) {
            this.e = Integer.valueOf(i);
            return this;
        }

        private b a(y1 y1Var) {
            if (y1Var != null) {
                this.o = y1Var;
            }
            return this;
        }

        public b a(i6 i6Var) {
            return a(i6Var.h).d(i6Var.l).a(i6Var.m).b(i6Var.c).a(i6Var.d).e(i6Var.n).a(i6Var.s);
        }

        private b a(a7 a7Var) {
            this.p = a7Var;
            return this;
        }

        private b a(JSONObject jSONObject) {
            this.m = jSONObject;
            return this;
        }

        public l6 a() {
            return new l6(this);
        }
    }

    void a(Future<m6> future) {
        if (future == null) {
            return;
        }
        this.y = future;
    }
}

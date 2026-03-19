package com.qq.e.comm.plugin;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class bo {
    private static final boolean i;
    private final w40 a;
    private z10 b;
    private JSONObject c;
    private int d = 0;
    private int e = 0;
    private boolean f = false;
    private ob g;
    private zn h;

    static {
        i = r1.d().f().a("fsalb", 0) == 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0020, code lost:
    
        if (r0 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void d() {
        /*
            r3 = this;
            boolean r0 = com.qq.e.comm.plugin.p8.a
            if (r0 != 0) goto L47
            int r0 = r3.d
            r1 = 1
            if (r0 == r1) goto Le
            int r2 = r3.e
            if (r2 == r1) goto Le
            goto L47
        Le:
            com.qq.e.comm.plugin.z10 r2 = r3.b
            java.util.Map<java.lang.String, com.qq.e.comm.plugin.ob> r2 = r2.e
            if (r0 != r1) goto L29
            if (r2 == 0) goto L22
            java.lang.String r0 = "15"
            java.lang.Object r0 = r2.get(r0)
            com.qq.e.comm.plugin.ob r0 = (com.qq.e.comm.plugin.ob) r0
            r3.g = r0
            if (r0 != 0) goto L29
        L22:
            r3.c()
            r3.f()
            return
        L29:
            com.qq.e.comm.plugin.zn r0 = r3.h
            if (r0 == 0) goto L3b
            int r2 = r3.e
            if (r2 != r1) goto L3b
            boolean r0 = r0.K()
            if (r0 == 0) goto L3b
            r3.c()
            return
        L3b:
            int r0 = r3.d
            if (r0 != r1) goto L46
            com.qq.e.comm.plugin.ob r0 = r3.g
            if (r0 == 0) goto L46
            r0.d()
        L46:
            return
        L47:
            r3.c()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.bo.d():void");
    }

    bo(w40 w40Var) {
        this.a = w40Var;
    }

    void a(z10 z10Var) {
        this.d = z10Var.b();
        this.e = z10Var.c();
        this.b = z10Var;
    }

    private void f() {
        b10.b(1190201, this.a.c().c(), 1);
    }

    private void c() {
        this.a.I();
        this.a.a(this.b);
        zn znVar = this.h;
        if (znVar != null) {
            znVar.c(this.a);
        }
    }

    public boolean a(JSONObject jSONObject) {
        if (this.d != 1 || e()) {
            return false;
        }
        zn znVar = this.h;
        if (znVar != null && znVar.K()) {
            Object objE = this.g.e(jSONObject);
            if ((objE instanceof Integer) && ((Integer) objE).intValue() != 2) {
                this.g.d();
                a(this.c, false);
                this.a.c(this.c);
                if (i) {
                    this.h.c(this.a);
                }
                return false;
            }
        }
        JSONObject jSONObject2 = this.c;
        if (jSONObject2 == null) {
            this.c = ln.a(jSONObject);
        } else {
            try {
                this.c = ln.b(jSONObject2, jSONObject);
            } catch (JSONException unused) {
            }
        }
        return true;
    }

    boolean e() {
        return this.f;
    }

    public int b() {
        return this.d;
    }

    public boolean a(String str, f10 f10Var) {
        if (this.d != 1 || e()) {
            return false;
        }
        zn znVar = this.h;
        if (znVar != null && znVar.K() && "15".equals(str) && f10Var.f(new JSONObject[0]) != 2) {
            this.g.d();
            a(false);
            this.a.l();
            this.h.c(this.a);
        }
        return true;
    }

    void b(boolean z) {
        this.f = z;
    }

    public void a() {
        this.f = false;
        this.c = null;
    }

    @Deprecated
    private void a(JSONObject jSONObject, boolean z) {
        if (this.f) {
            return;
        }
        if (z && this.d == 1) {
            this.c = jSONObject;
            return;
        }
        this.a.I();
        this.a.a(this.b);
        w40 w40Var = this.a;
        if (w40Var instanceof zn) {
            Iterator<w40> it = ((zn) w40Var).P().iterator();
            while (it.hasNext()) {
                it.next().x().a(jSONObject, true);
            }
        }
        if (!i || z) {
            this.h.c(this.a);
        }
        this.a.m();
        this.a.n();
    }

    private void a(boolean z) {
        if (this.f) {
            return;
        }
        if (z && this.d == 1) {
            return;
        }
        this.a.I();
        this.a.a(this.b);
        w40 w40Var = this.a;
        if (w40Var instanceof zn) {
            Iterator<w40> it = ((zn) w40Var).P().iterator();
            while (it.hasNext()) {
                it.next().x().a(true);
            }
        }
        if (z) {
            this.h.c(this.a);
        }
        this.a.m();
        this.a.n();
    }

    void a(zn znVar) {
        this.h = znVar;
    }
}

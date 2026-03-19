package com.qq.e.comm.plugin;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.comm.plugin.kq;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class br implements ik {
    private final f5 a;
    private final VideoOption b;
    private ej c;
    private final kq d;
    private final ed e;
    private l40 f;
    private Cif g;
    private int h;
    private boolean i = false;
    private boolean j;

    public void j() {
        u2 u2VarA = u2.a();
        r5 r5VarD = u2VarA.d(this.d);
        i6 i6Var = new i6(this.e);
        i6Var.c = i();
        if (r5VarD != null) {
            r5VarD.a(i6Var);
        }
        i6Var.b = u2VarA.a(this.d);
        ej ejVar = this.c;
        if (ejVar != null) {
            ejVar.a(i6Var);
        }
    }

    public br(Context context, kq kqVar, ed edVar, VideoOption videoOption, f5 f5Var) {
        this.d = kqVar;
        this.e = edVar;
        this.a = f5Var;
        this.b = videoOption;
    }

    /* compiled from: A */
    class a implements ej {
        a() {
        }

        @Override // com.qq.e.comm.plugin.ej
        public void a(i6 i6Var) {
            if (br.this.c != null) {
                br.this.c.a(i6Var);
            }
        }

        @Override // com.qq.e.comm.plugin.ej
        public void c() {
            if (br.this.c != null) {
                br.this.c.c();
            }
        }

        @Override // com.qq.e.comm.plugin.ej
        public void b() {
            if (br.this.c != null) {
                br.this.c.b();
            }
        }

        @Override // com.qq.e.comm.plugin.ej
        public void a(boolean z) {
            if (br.this.c != null) {
                br.this.c.a(z);
            }
        }

        @Override // com.qq.e.comm.plugin.ej
        public void a(String str) {
            if (br.this.c != null) {
                br.this.c.a(str);
            }
        }

        @Override // com.qq.e.comm.plugin.ej
        public void a() {
            if (br.this.c != null) {
                br.this.c.a();
            }
        }

        @Override // com.qq.e.comm.plugin.ej
        public void a(int i, int... iArr) {
            if (br.this.c != null) {
                br.this.c.a(i, iArr);
            } else if (i == 1001) {
                br.this.j = true;
            }
        }
    }

    /* compiled from: A */
    class b implements i7 {
        @Override // com.qq.e.comm.plugin.i7
        public void a() {
            if (r1.d().f().a("ntvbc", br.this.e.y0(), 1) == 1) {
                if (br.this.e.p0() == null || !br.this.e.p0().A()) {
                    br.this.j();
                }
            }
        }

        b() {
        }
    }

    /* compiled from: A */
    class c implements kq.b {
        @Override // com.qq.e.comm.plugin.kq.b
        public void dispatchTouchEvent(MotionEvent motionEvent) {
            r5 r5VarD = u2.a().d(br.this.d);
            if (r5VarD != null) {
                r5VarD.a(motionEvent, false);
            }
        }

        c() {
        }
    }

    /* compiled from: A */
    class d implements kq.c {
        final /* synthetic */ Cif a;

        d(Cif cif) {
            this.a = cif;
        }

        @Override // com.qq.e.comm.plugin.kq.c
        public void a(boolean z) throws JSONException {
            if (br.this.f != null) {
                br.this.f.c(z);
            }
            this.a.a(new m8().f(z).f());
        }

        @Override // com.qq.e.comm.plugin.kq.c
        public void b(boolean z) {
            if (!br.this.i && z) {
                br.this.i = true;
            }
            if (!z || br.this.c == null) {
                return;
            }
            br.this.c.c();
        }
    }

    /* compiled from: A */
    private class e extends gf {
        public e(f9 f9Var, h4 h4Var) {
            super(f9Var, h4Var);
        }

        @Override // com.qq.e.comm.plugin.gf
        public void a(i6 i6Var, h8 h8Var) {
            super.a(i6Var, h8Var);
            br.this.a(i6Var, h8Var);
        }

        @Override // com.qq.e.comm.plugin.gf
        public void c(h8 h8Var) throws JSONException {
            if (br.this.g.s()) {
                if (br.this.f != null) {
                    br.this.f.d(true);
                }
                br.this.k();
            } else if (br.this.c != null) {
                br.this.c.a(true);
            }
        }

        @Override // com.qq.e.comm.plugin.gf
        public void f(h8 h8Var) {
            if (br.this.c != null) {
                br.this.c.a(true);
            }
        }

        @Override // com.qq.e.comm.plugin.gf
        public void d(h8 h8Var) {
            if (br.this.c != null) {
                br.this.c.b();
            }
        }

        @Override // com.qq.e.comm.plugin.gf
        public void e(h8 h8Var) {
            if (br.this.c != null) {
                br.this.c.a();
            }
        }

        @Override // com.qq.e.comm.plugin.gf
        public void k(h8 h8Var) throws JSONException {
            if (br.this.f != null) {
                br.this.f.b();
            }
            if (br.this.g != null) {
                br.this.g.t();
            }
        }
    }

    private int i() {
        if (this.h == 0) {
            this.h = r1.d().f().a("ihsppcid", 10024);
        }
        return this.h;
    }

    @Override // com.qq.e.comm.plugin.ik
    public int g() {
        l40 l40Var = this.f;
        if (l40Var == null) {
            return 2;
        }
        return l40Var.j();
    }

    @Override // com.qq.e.comm.plugin.ik
    public int getCurrentPosition() {
        l40 l40Var = this.f;
        if (l40Var == null) {
            return 0;
        }
        return l40Var.f();
    }

    @Override // com.qq.e.comm.plugin.ik
    public int getDuration() {
        l40 l40Var = this.f;
        if (l40Var == null) {
            return 0;
        }
        return l40Var.g();
    }

    @Override // com.qq.e.comm.plugin.ik
    public int d() {
        l40 l40Var = this.f;
        if (l40Var == null) {
            return 0;
        }
        return l40Var.i();
    }

    @Override // com.qq.e.comm.plugin.ik
    public int f() {
        l40 l40Var = this.f;
        if (l40Var == null) {
            return 0;
        }
        return l40Var.k();
    }

    @Override // com.qq.e.comm.plugin.ik
    public int e() {
        l40 l40Var = this.f;
        if (l40Var == null) {
            return 0;
        }
        return l40Var.h();
    }

    public void k() throws JSONException {
        Cif cif = this.g;
        if (cif != null) {
            cif.v();
        }
    }

    @Override // com.qq.e.comm.plugin.ik
    public void c() {
        l40 l40Var = this.f;
        if (l40Var != null) {
            l40Var.n();
        }
    }

    public void h() {
        Cif cif = this.g;
        if (cif != null) {
            cif.c();
        }
        l40 l40Var = this.f;
        if (l40Var != null) {
            l40Var.d();
        }
        u2.a().b(this.d);
    }

    @Override // com.qq.e.comm.plugin.ik
    public mh b() {
        l40 l40Var = this.f;
        if (l40Var != null) {
            return l40Var.l();
        }
        return null;
    }

    @Override // com.qq.e.comm.plugin.ik
    public View a() {
        return this.d;
    }

    private void a(Cif cif) {
        this.d.a(new c());
        this.d.a(new d(cif));
    }

    public void b(Cif cif) {
        this.g = cif;
    }

    @Override // com.qq.e.comm.plugin.ik
    public void a(long j, long j2, int i) {
        l40 l40Var = this.f;
        if (l40Var != null) {
            l40Var.a(j, j2, i);
        }
    }

    @Override // com.qq.e.comm.plugin.ik
    public void a(ej ejVar) {
        ej ejVar2;
        this.c = ejVar;
        if (this.i && ejVar != null) {
            ejVar.c();
        }
        if (!this.j || (ejVar2 = this.c) == null) {
            return;
        }
        ejVar2.a(1001, new int[0]);
        this.j = false;
    }

    @Override // com.qq.e.comm.plugin.ik
    public void a(String str) {
        l40 l40Var = this.f;
        if (l40Var != null) {
            l40Var.a(str);
        }
    }

    public void a(Cif cif, mh mhVar, rg rgVar, FrameLayout frameLayout, al alVar, f6 f6Var, boolean z) {
        if (mhVar != null && rgVar != null) {
            l40 l40Var = new l40(cif, mhVar, rgVar, frameLayout, alVar, f6Var, this.b, this.e, z, new a());
            this.f = l40Var;
            l40Var.a(new b());
        }
        a(cif);
        cif.a(new e(cif, this.e));
        this.e.f(3);
        u2.a().a(this.d, this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i6 i6Var, h8 h8Var) {
        Cif cif;
        u2 u2VarA = u2.a();
        r5 r5VarD = u2VarA.d(this.d);
        if (r5VarD != null) {
            r5VarD.a(i6Var);
        }
        i6Var.b = u2VarA.a(this.d);
        ej ejVar = this.c;
        if (ejVar != null) {
            ejVar.a(i6Var);
        }
        if (!this.e.k().f() || (cif = this.g) == null || cif.l() == null) {
            return;
        }
        g4.a((View) this.g.l().getParent());
    }
}

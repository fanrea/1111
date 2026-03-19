package com.qq.e.comm.plugin;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import com.qq.e.comm.plugin.fs.FSCallback;
import com.qq.e.comm.plugin.hs;
import com.qq.e.comm.plugin.w40;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class bg extends u4<c> {
    private static final String J = "bg";
    private h4 G;
    private FSCallback H;
    private boolean I;

    private i6 O() {
        i6 i6Var = new i6(this.G);
        i6Var.h = 4;
        i6Var.c = this.w;
        i6Var.f = -1;
        i6Var.l = -1;
        i6Var.n = true;
        return i6Var;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.w40
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public c b(e8 e8Var) {
        c cVar = new c(e8Var.d());
        cVar.a(new a());
        return cVar;
    }

    private bg() {
        this.I = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        FSCallback fSCallback;
        if (this.I || (fSCallback = this.H) == null) {
            return;
        }
        this.I = true;
        fSCallback.V().b(O());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        FSCallback fSCallback = this.H;
        if (fSCallback != null) {
            fSCallback.D().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(float f) {
        FSCallback fSCallback = this.H;
        if (fSCallback != null) {
            fSCallback.m().b(Float.valueOf(f));
        }
    }

    /* synthetic */ bg(a aVar) {
        this();
    }

    /* compiled from: A */
    class a implements hs.k {
        a() {
        }

        @Override // com.qq.e.comm.plugin.hs.k
        public void a() {
            String unused = bg.J;
            bg.this.Q();
            bg.this.P();
        }

        @Override // com.qq.e.comm.plugin.hs.k
        public void c() {
            String unused = bg.J;
            bg.this.Q();
        }

        @Override // com.qq.e.comm.plugin.hs.k
        public void b() {
            String unused = bg.J;
            bg.this.Q();
        }

        @Override // com.qq.e.comm.plugin.hs.k
        public void d() {
            String unused = bg.J;
            bg.this.Q();
        }

        @Override // com.qq.e.comm.plugin.hs.k
        public void a(float f) {
            bg.this.e(f);
        }
    }

    @Override // com.qq.e.comm.plugin.w40
    protected boolean a(String str, cm cmVar) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "pageCardHeight":
                ((c) this.A).e(cmVar.c(new JSONObject[0]).e());
                return true;
            case "backBgColor":
                ((c) this.A).a(v30.b(cmVar));
                return true;
            case "adModel":
                h4 h4Var = (h4) cmVar.e(new JSONObject[0]);
                this.G = h4Var;
                if (h4Var != null) {
                    this.H = (FSCallback) x5.b(h4Var.s0(), FSCallback.class);
                }
                return true;
            case "pageCardShowIndexInterval":
                ((c) this.A).f(cmVar.f(new JSONObject[0]));
                return true;
            case "16":
                ((c) this.A).c(v30.b(cmVar));
                return true;
            case "71":
                ((c) this.A).a(cmVar.toString());
                return true;
            case "72":
                ((c) this.A).c(cmVar.c(new JSONObject[0]).e());
                return true;
            case "73":
                ((c) this.A).g(v30.b(cmVar));
                return true;
            case "rowSpace":
                ((c) this.A).b(cmVar.b(new JSONObject[0]));
                return true;
            case "backTextColor":
                ((c) this.A).b(v30.b(cmVar));
                return true;
            case "lineNumPageCard":
                ((c) this.A).d(cmVar.f(new JSONObject[0]));
                return true;
            default:
                return super.a(str, cmVar);
        }
    }

    @Override // com.qq.e.comm.plugin.w40
    public void clear() {
        super.clear();
        this.G = null;
        this.H = null;
        this.I = false;
    }

    /* compiled from: A */
    static class c extends hs implements dl<bg> {
        private bg f0;

        public c(Context context) {
            super(context);
        }

        @Override // com.qq.e.comm.plugin.dl
        public void a(bg bgVar) {
            this.f0 = bgVar;
        }

        @Override // android.view.View
        protected void onVisibilityChanged(View view, int i) {
            bg bgVar = this.f0;
            if (bgVar != null) {
                bgVar.a(view, i);
            }
        }

        @Override // com.qq.e.comm.plugin.hs, android.view.View
        protected void onMeasure(int i, int i2) {
            v40<V> v40VarV = this.f0.v();
            if (v40VarV == 0) {
                super.onMeasure(i, i2);
                return;
            }
            Pair<Integer, Integer> pairB = v40VarV.b(i, i2);
            super.onMeasure(((Integer) pairB.first).intValue(), ((Integer) pairB.second).intValue());
            Pair<Integer, Integer> pairA = v40VarV.a(i, i2);
            if (pairA != null) {
                super.onMeasure(((Integer) pairA.first).intValue(), ((Integer) pairA.second).intValue());
            }
        }

        @Override // com.qq.e.comm.plugin.hs, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            q();
        }
    }

    /* compiled from: A */
    static class b implements w40.e {
        @Override // com.qq.e.comm.plugin.w40.e
        public w40 a() {
            return new bg(null);
        }

        b() {
        }
    }
}

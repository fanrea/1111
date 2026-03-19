package com.qq.e.comm.plugin;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.plugin.l6;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class oz {
    private xz a;
    private rj b;
    private a c;

    private boolean a(int i) {
        return i == 2;
    }

    oz() {
    }

    public void c(qj qjVar) {
        if (a(qjVar.b)) {
            a(this.a, this.b);
        } else {
            a(qjVar, this.a, this.c);
        }
    }

    public boolean b(qj qjVar) {
        return (qjVar == null || b() || g00.d()) ? false : true;
    }

    private void a(qj qjVar) {
        int i;
        i6 i6Var = qjVar.a;
        if (i6Var.c == 0 && (i = qjVar.b) != 0) {
            int i2 = i != 1 ? i != 10 ? i != 4 ? i != 5 ? 0 : 10024 : 10025 : 1008 : 10021;
            if (i2 != 0) {
                i6Var.c = i2;
            }
        }
    }

    /* compiled from: A */
    private static class a extends cz {
        at f;
        rj g;
        xz h;

        public a(Context context) {
            super(context);
        }

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.oz$a$a, reason: collision with other inner class name */
        class C0719a implements rs {
            final /* synthetic */ rs a;

            C0719a(rs rsVar) {
                this.a = rsVar;
            }

            @Override // com.qq.e.comm.plugin.rs
            public void onCancel() {
                this.a.onCancel();
                rj rjVar = a.this.g;
                if (rjVar != null) {
                    rjVar.c();
                }
            }

            @Override // com.qq.e.comm.plugin.rs
            public boolean a(JSONObject jSONObject) {
                rj rjVar = a.this.g;
                if (rjVar != null) {
                    rjVar.c();
                }
                return this.a.a(jSONObject);
            }

            @Override // com.qq.e.comm.plugin.rs
            public void b(boolean z) {
                this.a.b(z);
                rj rjVar = a.this.g;
                if (rjVar == null || z) {
                    return;
                }
                rjVar.a(0);
            }

            @Override // com.qq.e.comm.plugin.rs
            public void a(boolean z) {
                rj rjVar;
                this.a.a(z);
                if (!z || (rjVar = a.this.g) == null) {
                    return;
                }
                rjVar.r();
            }
        }

        /* compiled from: A */
        class b implements rs {
            final /* synthetic */ rs a;

            b(rs rsVar) {
                this.a = rsVar;
            }

            @Override // com.qq.e.comm.plugin.rs
            public void onCancel() {
                this.a.onCancel();
                rj rjVar = a.this.g;
                if (rjVar != null) {
                    rjVar.c();
                }
            }

            @Override // com.qq.e.comm.plugin.rs
            public boolean a(JSONObject jSONObject) {
                boolean zA = this.a.a(jSONObject);
                rj rjVar = a.this.g;
                if (rjVar != null) {
                    rjVar.a(0);
                }
                return zA;
            }

            @Override // com.qq.e.comm.plugin.rs
            public void b(boolean z) {
                this.a.b(z);
                rj rjVar = a.this.g;
                if (rjVar == null || z) {
                    return;
                }
                rjVar.c();
            }

            @Override // com.qq.e.comm.plugin.rs
            public void a(boolean z) {
                rj rjVar;
                if (!z || (rjVar = a.this.g) == null) {
                    return;
                }
                rjVar.r();
            }
        }

        @Override // com.qq.e.comm.plugin.cz, com.qq.e.comm.plugin.qs
        public void a(boolean z) {
            super.a(z);
            rj rjVar = this.g;
            if (rjVar != null) {
                rjVar.a(30);
            }
        }

        @Override // com.qq.e.comm.plugin.cz, com.qq.e.comm.plugin.qs
        public void g() {
            super.g();
            rj rjVar = this.g;
            if (rjVar != null) {
                rjVar.a(30);
            }
        }

        @Override // com.qq.e.comm.plugin.cz, com.qq.e.comm.plugin.qs
        public boolean b(String str, h4 h4Var) {
            boolean zB = super.b(str, h4Var);
            rj rjVar = this.g;
            if (rjVar != null) {
                rjVar.a(30);
            }
            return zB;
        }

        @Override // com.qq.e.comm.plugin.cz, com.qq.e.comm.plugin.qs
        public void a(l3 l3Var) {
            super.a(l3Var);
            rj rjVar = this.g;
            if (rjVar != null) {
                rjVar.a(0);
            }
        }

        @Override // com.qq.e.comm.plugin.cz, com.qq.e.comm.plugin.qs
        public void a(h4 h4Var, DownloadConfirmListener downloadConfirmListener, rs rsVar, int i) {
            super.a(h4Var, downloadConfirmListener, new b(rsVar), i);
        }

        @Override // com.qq.e.comm.plugin.cz, com.qq.e.comm.plugin.qs
        public void a(String str, rs rsVar) {
            Activity activityB;
            if (this.g == null || (activityB = c1.b(this.a.get())) == null) {
                return;
            }
            at atVar = new at(activityB, str, new C0719a(rsVar));
            this.f = atVar;
            atVar.c();
        }
    }

    public void b(xz xzVar, rj rjVar) {
        this.a = xzVar;
        this.b = rjVar;
        ViewGroup viewGroup = xzVar.r;
        Context contextA = viewGroup != null ? c1.a(viewGroup.getContext()) : null;
        if (contextA == null) {
            contextA = c1.a(xzVar.a);
        }
        if (contextA == null) {
            contextA = xzVar.a;
        }
        a aVar = new a(contextA);
        this.c = aVar;
        aVar.g = rjVar;
        aVar.h = xzVar;
        g00.e();
        this.c.a(xzVar.b());
    }

    public void a() {
        a aVar = this.c;
        if (aVar != null) {
            at atVar = aVar.f;
            if (atVar != null) {
                atVar.a();
                this.c.f = null;
            }
            a aVar2 = this.c;
            aVar2.g = null;
            aVar2.h = null;
            this.c = null;
        }
        this.b = null;
        this.a = null;
    }

    private void a(xz xzVar, rj rjVar) throws JSONException {
        if (xzVar == null || rjVar == null) {
            return;
        }
        f00.e(xzVar);
        rjVar.a(0);
    }

    private void a(qj qjVar, xz xzVar, qs qsVar) {
        if (qjVar == null || xzVar == null || qsVar == null) {
            return;
        }
        a(qjVar);
        f00.d(this.a);
        boolean zG = zz.g(xzVar.c);
        mu muVarB = xzVar.b();
        u2 u2VarA = u2.a();
        r5 r5VarD = u2VarA.d(xzVar.w);
        if (r5VarD != null) {
            r5VarD.d(41);
            r5VarD.e(xzVar.v.get().booleanValue() ? 1 : 2);
            r5VarD.a(muVarB.s1());
            r5VarD.a(qjVar.a);
            r5VarD.c(qjVar.a.c == 10071);
        }
        String strA = u2VarA.a(xzVar.w);
        j6.a(new l6.b(muVarB).a(strA).c(zG).a(qjVar.a).a(), qsVar);
        zv.a(xzVar.w, muVarB, strA);
        ADListener aDListener = xzVar.j;
        if (aDListener != null) {
            aDListener.onADEvent(new ADEvent(105, new Object[0]));
        }
        f00.a(xzVar, qjVar);
    }

    public boolean b() {
        return this.a == null || this.b == null;
    }
}

package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import com.qq.e.comm.plugin.tu;
import com.qq.e.comm.plugin.u6;
import com.qq.e.comm.plugin.v30;
import com.qq.e.comm.plugin.w40;
import com.sigmob.sdk.base.mta.PointType;
import io.netty.util.internal.StringUtil;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class dg extends u4<d> {
    private final tu.b G;
    private cr H;
    private String[] I;
    private int J;

    /* renamed from: K, reason: collision with root package name */
    private boolean f775K;

    /* compiled from: A */
    public static class c implements w40.e {
        @Override // com.qq.e.comm.plugin.w40.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public dg a() {
            return new dg(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.u4, com.qq.e.comm.plugin.w40
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public e p() {
        return new e(this, (d) this.A);
    }

    private dg() {
        this.G = new tu.b();
        this.I = new String[5];
        this.J = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.w40
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public d b(e8 e8Var) {
        cr crVar = new cr();
        this.H = crVar;
        crVar.a(this.n);
        this.H.I();
        return new d(e8Var.d(), this.H.A());
    }

    /* synthetic */ dg(a aVar) {
        this();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.qq.e.comm.plugin.w40
    protected boolean a(String str, cm cmVar) {
        str.hashCode();
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1487056351:
                if (str.equals("idleProgress")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1169023802:
                if (str.equals("adModel")) {
                    c2 = 1;
                    break;
                }
                break;
            case 57:
                if (str.equals("9")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1567:
                if (str.equals(PointType.SIGMOB_APP)) {
                    c2 = 3;
                    break;
                }
                break;
            case 1568:
                if (str.equals("11")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1569:
                if (str.equals("12")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1573:
                if (str.equals("16")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1598:
                if (str.equals("20")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1636:
                if (str.equals("37")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 1754:
                if (str.equals("71")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 1755:
                if (str.equals("72")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 1756:
                if (str.equals("73")) {
                    c2 = 11;
                    break;
                }
                break;
            case 3683:
                if (str.equals("tW")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 1525876935:
                if (str.equals("proBrBgClr")) {
                    c2 = StringUtil.CARRIAGE_RETURN;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                if (this.f775K) {
                    ((d) this.A).a(cmVar.f(new JSONObject[0]));
                    break;
                } else {
                    this.G.b(cmVar.f(new JSONObject[0]));
                    break;
                }
            case 1:
                h4 h4Var = (h4) cmVar.e(new JSONObject[0]);
                q3 q3VarQ = h4Var.q();
                this.I[1] = q3VarQ.c();
                this.I[2] = q3VarQ.b();
                this.I[3] = q3VarQ.a();
                this.I[4] = q3VarQ.e();
                this.G.a(h4Var);
                this.J |= 1;
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                this.H.B().a(str, cmVar);
                break;
            case 6:
                this.G.d(v30.b(cmVar));
                break;
            case 7:
                this.G.f(cmVar.c(new JSONObject[0]).a(this.p.i()));
                break;
            case '\b':
                v30.a(cmVar, c().f(), new a());
                break;
            case '\t':
                this.I[0] = cmVar.toString();
                this.J |= 2;
                break;
            case '\n':
                this.G.g(cmVar.a(new JSONObject[0]));
                break;
            case 11:
                int iB = v30.b(cmVar);
                this.G.c(iB);
                this.G.e(iB);
                break;
            case '\f':
                this.G.h(cmVar.a(new JSONObject[0]));
                break;
            case '\r':
                this.G.a(v30.b(cmVar));
                break;
            default:
                if (super.a(str, cmVar) || this.H.a(str, cmVar)) {
                }
                break;
        }
        return true;
    }

    /* compiled from: A */
    class a implements v30.d {
        a() {
        }

        @Override // com.qq.e.comm.plugin.v30.d
        public void a(Object[] objArr) {
            dg.this.G.a(objArr);
        }
    }

    @Override // com.qq.e.comm.plugin.w40
    protected void M() {
        if (!this.f.f()) {
            O();
        }
        super.M();
    }

    private void O() {
        if ((this.J ^ 3) == 0) {
            this.G.a(this.I);
            ((d) this.A).a(this.G);
            this.J = 0;
            this.f775K = true;
        }
    }

    @Override // com.qq.e.comm.plugin.w40
    public void k() {
        super.k();
        O();
    }

    /* compiled from: A */
    class b implements u6.b {
        b() {
        }

        @Override // com.qq.e.comm.plugin.u6.b
        public void a(int i) {
            if (dg.this.f775K) {
                ((d) dg.this.A).setBackgroundColor(i);
            } else {
                dg.this.G.d(i);
            }
        }
    }

    @Override // com.qq.e.comm.plugin.w40
    public void clear() {
        V v = this.A;
        if (v != 0) {
            ((d) v).a();
        }
        super.clear();
        this.f775K = false;
        this.J = 0;
        this.H = null;
        this.I = new String[5];
    }

    @Override // com.qq.e.comm.plugin.w40
    protected void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        u6.a(c().f(), str, new b());
    }

    @Override // com.qq.e.comm.plugin.w40
    public void f(int i) {
        if (this.f775K) {
            ((d) this.A).setBackgroundColor(i);
        } else {
            this.G.d(i);
        }
    }

    /* compiled from: A */
    static class e extends v40<d> {
        public e(dg dgVar, d dVar) {
            super(dgVar, dVar);
        }

        @Override // com.qq.e.comm.plugin.v40
        public void h() {
            er erVarV = j().v();
            if (erVarV != null) {
                erVarV.h();
            }
            super.h();
        }

        @Override // com.qq.e.comm.plugin.v40
        public void a(int i, int i2, int i3, int i4) {
            super.a(i, i2, i3, i4);
            cr crVarJ = j();
            dr drVarA = crVarJ.A();
            if (drVarA == null) {
                return;
            }
            u8 u8VarB = crVarJ.B();
            if (u8VarB.a(new r8(i, i2, i3, i4))) {
                drVarA.setPadding(u8VarB.c(), u8VarB.e(), u8VarB.d(), u8VarB.b());
            }
        }

        cr j() {
            return ((dg) this.a).H;
        }
    }

    /* compiled from: A */
    static class d extends tu implements dl<dg> {
        private dg p;

        public d(Context context, TextView textView) {
            super(context, textView);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            v40<V> v40VarV = this.p.v();
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

        @Override // android.view.View
        protected void onVisibilityChanged(View view, int i) {
            dg dgVar = this.p;
            if (dgVar != null) {
                dgVar.a(view, i);
            }
        }

        @Override // com.qq.e.comm.plugin.tu
        protected void a(tu.b bVar) {
            super.a(bVar);
        }

        @Override // com.qq.e.comm.plugin.dl
        public void a(dg dgVar) {
            this.p = dgVar;
        }
    }
}

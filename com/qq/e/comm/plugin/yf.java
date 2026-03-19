package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.qq.e.comm.plugin.u6;
import com.qq.e.comm.plugin.v30;
import com.qq.e.comm.plugin.w40;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class yf extends u4<f> implements m {
    private h4 G;
    private boolean H;
    private boolean I;
    private String J;

    /* renamed from: K, reason: collision with root package name */
    private q3 f788K;
    private JSONObject L;
    private JSONObject M;
    private int N;
    private int O;
    private String P;
    private String Q;
    private String R;
    private String S;
    private String T;

    private yf() {
        this.H = false;
        this.I = false;
        this.N = 0;
        this.O = 0;
        this.P = "dsTxt";
        this.Q = "dPro";
        this.R = "dsTxtVis";
        this.S = "norTxtVis";
        this.T = "noneDlVis";
    }

    /* compiled from: A */
    class a implements v30.d {
        a() {
        }

        @Override // com.qq.e.comm.plugin.v30.d
        public void a(Object[] objArr) {
            ((f) yf.this.A).a(objArr);
        }
    }

    /* synthetic */ yf(a aVar) {
        this();
    }

    @Override // com.qq.e.comm.plugin.w40
    protected void M() throws JSONException {
        super.M();
        h4 h4Var = this.G;
        if (h4Var == null || this.I) {
            return;
        }
        a(h4Var);
        this.I = true;
    }

    private void a(h4 h4Var) throws JSONException {
        if (!h4Var.k1() || h4Var.o() == null) {
            return;
        }
        l3 l3VarO = h4Var.o();
        String strE = l3VarO.e();
        this.J = strE;
        if (TextUtils.isEmpty(strE)) {
            return;
        }
        q3 q3VarQ = h4Var.q();
        this.f788K = q3VarQ;
        q3VarQ.a(h4Var.D());
        a(l3VarO.j(), com.qq.e.comm.plugin.apkmanager.l.e().a(this.J));
        com.qq.e.comm.plugin.apkmanager.l.e().a(this.J, this);
    }

    private boolean n(int i) {
        if (i != 0 && i != 16 && i != 64) {
            if (this.N != 1) {
                this.N = 1;
                return true;
            }
        } else if (this.N != 0) {
            this.N = 0;
            return true;
        }
        return false;
    }

    private boolean m(int i) {
        if (i == 4) {
            if (this.O != 1) {
                this.O = 1;
                return true;
            }
        } else if (this.O != 0) {
            this.O = 0;
            return true;
        }
        return false;
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ int b;

        b(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            yf.this.a(this.a, this.b);
        }
    }

    /* compiled from: A */
    class c implements v30.c {
        c() {
        }

        @Override // com.qq.e.comm.plugin.v30.c
        public void a(int i) {
            ((f) yf.this.A).b(i);
        }
    }

    @Override // com.qq.e.comm.plugin.w40
    public void f(int i) {
        ((f) this.A).setBackgroundColor(i);
    }

    /* compiled from: A */
    class d implements u6.b {
        d() {
        }

        @Override // com.qq.e.comm.plugin.u6.b
        public void a(int i) {
            if (yf.this.A != null) {
                ((f) yf.this.A).b(i);
            }
        }
    }

    protected void c(cm cmVar) {
        v30.a(cmVar, c().f(), new c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.w40
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public f b(e8 e8Var) {
        f fVar = new f(e8Var.d());
        fVar.c(100);
        fVar.b(v30.b(t30.c((Object) "#66FFFFFF")));
        fVar.setBackgroundColor(v30.b(t30.c((Object) "#33FFFFFF")));
        return fVar;
    }

    @Override // com.qq.e.comm.plugin.w40
    public void clear() {
        super.clear();
        com.qq.e.comm.plugin.apkmanager.l.e().b(this.J, this);
        this.G = null;
        this.H = false;
        this.I = false;
        this.J = null;
        this.f788K = null;
        this.L = null;
        this.M = null;
        this.N = 0;
        this.O = 0;
        this.P = "dsTxt";
        this.Q = "dPro";
        this.R = "dsTxtVis";
        this.S = "norTxtVis";
        this.T = "noneDlVis";
    }

    @Override // com.qq.e.comm.plugin.w40
    protected void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        u6.a(c().f(), str, new d());
    }

    /* compiled from: A */
    static class f extends Cdo implements dl<yf> {
        private yf m;

        public f(Context context) {
            super(context);
            a(true);
        }

        @Override // android.view.View
        protected void onVisibilityChanged(View view, int i) {
            yf yfVar = this.m;
            if (yfVar != null) {
                yfVar.a(view, i);
            }
        }

        @Override // com.qq.e.comm.plugin.dl
        public void a(yf yfVar) {
            this.m = yfVar;
        }
    }

    /* compiled from: A */
    static class e implements w40.e {
        @Override // com.qq.e.comm.plugin.w40.e
        public w40 a() {
            return new yf(null);
        }

        e() {
        }
    }

    @Override // com.qq.e.comm.plugin.m
    public void a(String str, int i, int i2, long j) {
        if (this.J.equals(str)) {
            xo.d(new b(i, i2));
        }
    }

    @Override // com.qq.e.comm.plugin.w40
    protected boolean a(String str, cm cmVar) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "bindDataSuffix":
                String string = cmVar.toString();
                if (!TextUtils.isEmpty(string)) {
                    this.P = "dsTxt" + string;
                    this.Q = "dPro" + string;
                    this.R = "dsTxtVis" + string;
                    this.S = "norTxtVis" + string;
                    this.T = "noneDlVis" + string;
                }
                return true;
            case "barColor":
                c(cmVar);
                return true;
            case "adModel":
                this.G = (h4) cmVar.e(new JSONObject[0]);
                return true;
            case "progress":
                ((f) this.A).a(cmVar.f(new JSONObject[0]));
                return true;
            case "progressGradient":
                v30.a(cmVar, c().f(), new a());
                return true;
            case "barBgRadius":
                ((f) this.A).a(cmVar.c(new JSONObject[0]).a(this.p.i()));
                return true;
            case "barRoundEnable":
                ((f) this.A).a(cmVar.f(new JSONObject[0]) > 0);
                return true;
            case "showProgressPercent":
                this.H = cmVar.f(new JSONObject[0]) > 0;
                return true;
            default:
                return super.a(str, cmVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r8, int r9) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.yf.a(int, int):void");
    }
}

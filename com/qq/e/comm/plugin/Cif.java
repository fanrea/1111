package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.qq.e.comm.plugin.callback.biz.ARCallback;
import com.qq.e.comm.plugin.callback.biz.ApkCallback;
import com.qq.e.comm.plugin.callback.biz.DialogStateCallback;
import com.qq.e.comm.plugin.callback.biz.LPCallback;
import com.qq.e.comm.plugin.callback.biz.UIChangedCallback;
import com.qq.e.comm.plugin.dysi.IGDTBiz;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* renamed from: com.qq.e.comm.plugin.if, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Cif extends f9 {
    private final boolean u;
    private y1 v;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(y1 y1Var) {
        pro.getVresult(182, 0, this, y1Var);
    }

    public Cif(im imVar, h4 h4Var, boolean z) throws JSONException {
        super(imVar, h4Var, h4Var.p0());
        this.u = z;
        b(h4Var);
        c(h4Var);
        a(h4Var);
        w();
        d(h4Var);
        c9.a(h4Var.k(), h4Var.p0().m(), z, t10.d());
    }

    @Override // com.qq.e.comm.plugin.f9
    public void c() {
        super.c();
        x5.c(this.b.s0(), LPCallback.class);
        x5.c(this.b.s0(), ARCallback.class);
        x5.c(this.b.s0(), UIChangedCallback.class);
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.if$a */
    class a extends ms<String> {
        a(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(String str) {
            im imVar;
            if (TextUtils.isEmpty(str) || (imVar = Cif.this.a) == null) {
                return;
            }
            try {
                imVar.a(str);
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.if$b */
    class b extends ms<String> {
        b(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(String str) {
            if (TextUtils.isEmpty(str) || Cif.this.a == null) {
                return;
            }
            try {
                Cif.this.a.a(new JSONObject(str));
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.if$c */
    class c extends ms<y1> {
        c(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(y1 y1Var) {
            Cif cif = Cif.this;
            if (cif.m == null) {
                cif.v = y1Var;
            } else {
                cif.a(y1Var);
            }
        }
    }

    private void w() {
        ((ARCallback) x5.b(this.b.s0(), ARCallback.class)).J().a(new c(this));
    }

    public void v() throws JSONException {
        g8.a(this, this.b);
    }

    public void t() throws JSONException {
        g8.a(this);
    }

    public boolean s() {
        return g8.d(this.b);
    }

    public int r() {
        return g8.c(this.b);
    }

    public boolean q() {
        return g8.a(this.b);
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.if$d */
    class d extends ms<Integer> {
        d(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Integer num) {
            int i = f9.t;
            IGDTBiz iGDTBizG = Cif.this.g();
            if (iGDTBizG == null) {
                return;
            }
            iGDTBizG.onDialogShow(num.intValue());
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.if$e */
    class e extends ms<Integer> {
        e(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Integer num) {
            int i = f9.t;
            IGDTBiz iGDTBizG = Cif.this.g();
            if (iGDTBizG == null) {
                return;
            }
            iGDTBizG.onDialogDismiss(num.intValue());
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.if$f */
    class f extends ms<Void> {
        f(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r1) {
            Cif.this.g().onLandingPageOpen();
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.if$g */
    class g extends ms<Void> {
        g(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r1) {
            Cif.this.g().onLandingPageClose();
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.if$h */
    class h extends ms<Integer> {
        h(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Integer num) {
            IGDTBiz iGDTBizG = Cif.this.g();
            if (iGDTBizG != null) {
                iGDTBizG.onApkStartInstall(String.valueOf(num));
            }
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.if$i */
    class i extends ms<Integer> {
        i(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Integer num) {
            IGDTBiz iGDTBizG = Cif.this.g();
            if (iGDTBizG != null) {
                iGDTBizG.onGoAppStore(String.valueOf(num));
            }
        }
    }

    public void u() {
        IGDTBiz iGDTBizG = g();
        if (iGDTBizG == null) {
            return;
        }
        iGDTBizG.onVideoLandingPageClicked();
    }

    private void c(h4 h4Var) {
        if (h4Var == null || g() == null) {
            return;
        }
        LPCallback lPCallback = (LPCallback) x5.b(h4Var.s0(), LPCallback.class);
        lPCallback.o().a(new f(this));
        lPCallback.onClose().a(new g(this));
    }

    public void d(String str) {
        IGDTBiz iGDTBizG = g();
        if (iGDTBizG == null) {
            return;
        }
        iGDTBizG.onPageLoadStart(str);
    }

    public boolean e(String str) throws JSONException {
        if (!this.c.z()) {
            return false;
        }
        a(new m8().c(str).f());
        return true;
    }

    public void b(int i2) {
        IGDTBiz iGDTBizG = g();
        if (iGDTBizG == null) {
            return;
        }
        iGDTBizG.onPageLoadEnd(String.valueOf(i2));
    }

    private void d(h4 h4Var) {
        if (h4Var == null) {
            return;
        }
        UIChangedCallback uIChangedCallback = (UIChangedCallback) x5.b(h4Var.s0(), UIChangedCallback.class);
        uIChangedCallback.r().a(new a(this));
        uIChangedCallback.e().a(new b(this));
    }

    public void a(int i2) {
        IGDTBiz iGDTBizG = g();
        if (iGDTBizG == null) {
            return;
        }
        iGDTBizG.onReward(i2);
    }

    private void b(h4 h4Var) {
        if (h4Var == null) {
            return;
        }
        DialogStateCallback dialogStateCallback = (DialogStateCallback) x5.b(h4Var.s0(), DialogStateCallback.class);
        dialogStateCallback.j().a(new d(this));
        dialogStateCallback.i().a(new e(this));
    }

    @Override // com.qq.e.comm.plugin.f9
    public void a(gf gfVar) {
        super.a(gfVar);
        y1 y1Var = this.v;
        if (y1Var == null || this.m == null) {
            return;
        }
        a(y1Var);
        this.v = null;
    }

    private void a(h4 h4Var) {
        l3 l3VarO;
        if (h4Var == null || !h4Var.k1() || g() == null || (l3VarO = h4Var.o()) == null) {
            return;
        }
        String strE = l3VarO.e();
        if (TextUtils.isEmpty(strE)) {
            return;
        }
        ApkCallback apkCallback = (ApkCallback) x5.b(strE, ApkCallback.class);
        apkCallback.b0().a(new h(this));
        apkCallback.g().a(new i(this));
    }
}

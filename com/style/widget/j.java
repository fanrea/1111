package com.style.widget;

import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.container.nativecpu.AbstractData;
import com.baidu.mobads.container.util.animation.a;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class j extends RelativeLayout {
    private static final int bw = 10005;
    private static final int bx = 10006;
    public static final int f = 10000;
    public static final int g = 10001;
    public static final int h = 10002;
    public static final int i = 10003;
    public static final int j = 10004;
    public static final int k = 10007;
    public static final int l = 10008;
    public static final int m = 10009;
    public static final int n = 10010;
    public static final int o = Color.parseColor("#F4F5F6");
    public static final int p = Color.parseColor("#000000");
    public static final int q = Color.parseColor("#999999");
    public static final int r = Color.parseColor("#3388FF");
    public static final int s = Color.parseColor("#D7E6FF");
    public static final int t = Color.parseColor("#FFFFFF");
    public static final int u = Color.parseColor("#F5F5F5");
    public int A;
    public int B;
    public ImageView C;
    public int D;
    public int E;
    public int F;
    public int G;
    public Drawable H;
    public int I;
    public int J;

    /* renamed from: K, reason: collision with root package name */
    public boolean f799K;
    public boolean L;
    public boolean M;
    public boolean N;
    public ad O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public ImageView W;
    public double a;
    public ImageView aA;
    public int aB;
    public int aC;
    public int aD;
    public int aE;
    public int aF;
    public int aG;
    public ImageView aH;
    public int aI;
    public int aJ;
    public int aK;
    public int aL;
    public int aM;
    public int aN;
    public TextView aO;
    public int aP;
    public int aQ;
    public int aR;
    public int aS;
    public int aT;
    public int aU;
    public int aV;
    public Typeface aW;
    public int aX;
    public int aY;
    public u aZ;
    public int aa;
    public int ab;
    public int ac;
    public int ad;
    public int ae;
    public int af;
    public RelativeLayout ag;
    public TextView ah;
    public int ai;
    public int aj;
    public int ak;
    public int al;
    public int am;
    public boolean an;
    public int ao;
    public int ap;
    public Typeface aq;
    public ImageView ar;
    public com.style.widget.e.a as;
    public int at;
    public int au;
    public int av;
    public int aw;
    public boolean ax;
    public int ay;
    public int az;
    public double b;
    public u ba;
    public int bb;
    public int bc;
    public int bd;
    public int be;
    public int bf;
    public int bg;
    public int bh;
    public int bi;
    public int bj;
    public int bk;
    public Typeface bl;
    protected TextView bm;
    protected int bn;
    protected int bo;
    protected int bp;
    protected int bq;
    protected int br;
    protected int bs;
    public boolean bt;
    public com.baidu.mobads.container.k bu;
    public boolean bv;
    private AnimatorSet by;
    public double c;
    public double d;
    public double e;
    public ag v;
    protected Context w;
    protected AbstractData x;
    public ImageView y;
    public int z;

    public j(Context context, AbstractData abstractData) {
        super(context);
        this.a = 4.0d;
        this.b = 1.5d;
        this.c = 1.4d;
        this.d = 1.43d;
        this.e = 2.0d;
        this.z = 12;
        this.A = 12;
        this.B = 4;
        this.D = 12;
        this.E = 22;
        this.G = o;
        this.f799K = true;
        this.L = false;
        this.M = false;
        this.N = true;
        this.P = Color.parseColor("#F5F5F5");
        this.Q = 335;
        this.R = 65;
        this.S = 12;
        this.T = 12;
        this.U = 18;
        this.V = 0;
        this.aa = 36;
        this.ab = 36;
        this.ac = 12;
        this.ad = 0;
        this.ae = 12;
        this.af = 0;
        this.aj = 12;
        this.ak = 12;
        this.al = 12;
        this.am = 0;
        this.an = false;
        this.ao = 15;
        this.ap = p;
        this.av = 12;
        this.aw = 12;
        this.ax = false;
        this.ay = 12;
        this.az = 12;
        this.aD = 12;
        this.aE = 12;
        this.aF = 12;
        this.aG = 12;
        this.aK = 12;
        this.aL = 12;
        this.aM = 12;
        this.aN = 12;
        this.aP = 12;
        this.aQ = 4;
        this.aS = 12;
        this.aT = 16;
        this.aU = 9;
        this.aV = q;
        this.aX = p;
        this.aY = q;
        this.bb = 56;
        this.bc = 22;
        this.bd = 12;
        this.be = 12;
        this.bf = 4;
        this.bg = 12;
        this.bh = r;
        this.bi = s;
        this.bj = 10;
        this.bk = t;
        this.bn = 15;
        this.bo = 15;
        this.bp = 0;
        this.bq = 15;
        this.br = 12;
        this.bs = 12;
        this.bt = true;
        this.bu = null;
        this.bv = false;
        this.w = context;
        this.x = abstractData;
        z();
    }

    private void z() {
        if (this.x instanceof com.baidu.mobads.container.nativecpu.a) {
            return;
        }
        this.bu = this.x.getBaseAdContainer();
        if (this.bu != null) {
            this.bu.addEventListener(com.baidu.mobads.container.components.k.b.T, new a());
        }
    }

    private RelativeLayout.LayoutParams A() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.mobads.container.util.ab.a(this.w, this.E), com.baidu.mobads.container.util.ab.a(this.w, this.D));
        if (x()) {
            layoutParams.addRule(3, 10010);
            layoutParams.addRule(11);
            layoutParams.setMargins(0, 0, com.baidu.mobads.container.util.ab.a(this.w, this.z), 0);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(1, 10006);
            layoutParams.setMargins(0, 0, com.baidu.mobads.container.util.ab.a(this.w, this.F), com.baidu.mobads.container.util.ab.a(this.w, this.aT));
        }
        return layoutParams;
    }

    private RelativeLayout.LayoutParams B() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.mobads.container.util.ab.a(this.w, this.D), com.baidu.mobads.container.util.ab.a(this.w, this.D));
        if (x()) {
            layoutParams.addRule(3, 10010);
            layoutParams.addRule(0, 10005);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(1, 10008);
            layoutParams.setMargins(com.baidu.mobads.container.util.ab.a(this.w, this.aQ), 0, 0, com.baidu.mobads.container.util.ab.a(this.w, this.aT));
        }
        return layoutParams;
    }

    public void a() {
        this.C = new ImageView(this.w);
        this.C.setId(10006);
        this.C.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.mobads.container.util.d.d.a(this.w).b(this.C, com.baidu.mobads.container.h.k);
        this.C.setClickable(true);
        this.C.setOnClickListener(new k(this));
        addView(this.C, B());
        this.y = new ImageView(this.w);
        this.y.setId(10005);
        com.baidu.mobads.container.util.d.d.a(this.w).b(this.y, com.baidu.mobads.container.h.l);
        this.y.setClickable(true);
        this.y.setOnClickListener(new m(this));
        addView(this.y, A());
    }

    public void b() {
        if (this.C != null) {
            this.C.setLayoutParams(B());
        }
        if (this.y != null) {
            this.y.setLayoutParams(A());
        }
    }

    private RelativeLayout.LayoutParams C() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.mobads.container.util.ab.a(this.w, this.E), com.baidu.mobads.container.util.ab.a(this.w, this.D));
        if (!x()) {
            layoutParams.addRule(12);
            layoutParams.addRule(0, 10002);
            layoutParams.setMargins(0, 0, com.baidu.mobads.container.util.ab.a(this.w, this.F), com.baidu.mobads.container.util.ab.a(this.w, this.aT));
        } else {
            layoutParams.addRule(3, 10010);
            layoutParams.addRule(11);
            layoutParams.setMargins(0, 0, com.baidu.mobads.container.util.ab.a(this.w, this.z), 0);
        }
        return layoutParams;
    }

    private RelativeLayout.LayoutParams D() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.mobads.container.util.ab.a(this.w, this.D), com.baidu.mobads.container.util.ab.a(this.w, this.D));
        if (!x()) {
            layoutParams.addRule(12);
            layoutParams.addRule(0, 10005);
            layoutParams.setMargins(com.baidu.mobads.container.util.ab.a(this.w, this.aQ), 0, 0, com.baidu.mobads.container.util.ab.a(this.w, this.aT));
        } else {
            layoutParams.addRule(3, 10010);
            layoutParams.addRule(0, 10005);
        }
        return layoutParams;
    }

    public void c() {
        this.y = new ImageView(this.w);
        this.y.setId(10005);
        com.baidu.mobads.container.util.d.d.a(this.w).b(this.y, com.baidu.mobads.container.h.l);
        this.y.setClickable(true);
        this.y.setOnClickListener(new n(this));
        addView(this.y, C());
        this.C = new ImageView(this.w);
        this.C.setId(10006);
        this.C.setScaleType(ImageView.ScaleType.FIT_XY);
        com.baidu.mobads.container.util.d.d.a(this.w).b(this.C, com.baidu.mobads.container.h.k);
        this.C.setClickable(true);
        this.C.setOnClickListener(new o(this));
        addView(this.C, D());
    }

    public void d() {
        if (this.C != null) {
            this.C.setLayoutParams(D());
        }
        if (this.y != null) {
            this.y.setLayoutParams(C());
        }
    }

    public void e() {
        this.aO = new TextView(this.w);
        this.aO.setId(10008);
        this.aO.setMaxLines(1);
        this.aO.setEllipsize(TextUtils.TruncateAt.END);
        this.aO.setTextColor(this.aV);
        this.aO.setTextSize(2, this.aU);
        if (this.aW != null) {
            this.aO.setTypeface(this.aW);
        }
        if (this.x.getBrandName() == null || this.x.getBrandName().length() == 0) {
            this.aO.setText("智能优选");
        } else {
            this.aO.setText(this.x.getBrandName());
        }
    }

    public void f() {
        this.aR = this.I - com.baidu.mobads.container.util.ab.a(this.w, this.aP + this.aP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, a(this.aO)[1]);
        if (this.x != null && this.x.getStyleType() == 33) {
            layoutParams.addRule(1, 10002);
            layoutParams.addRule(12);
        } else if (this.x != null && this.x.getStyleType() == 34) {
            layoutParams.addRule(0, 10006);
            layoutParams.addRule(12);
        } else {
            layoutParams.addRule(9);
            layoutParams.addRule(12);
        }
        layoutParams.setMargins(com.baidu.mobads.container.util.ab.a(this.w, this.aP), 0, 0, com.baidu.mobads.container.util.ab.a(this.w, this.aT));
        addView(this.aO, layoutParams);
    }

    public void g() {
        this.aO.setTextColor(this.aV);
        this.aO.setTextSize(2, this.aU);
        this.aO.setTypeface(this.aW);
        this.aR = this.I - com.baidu.mobads.container.util.ab.a(this.w, this.aP + this.aP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.x != null && this.x.getStyleType() == 33) {
            layoutParams.addRule(1, 10002);
            layoutParams.addRule(12);
        } else if (this.x != null && this.x.getStyleType() == 34) {
            layoutParams.addRule(0, 10006);
            layoutParams.addRule(12);
        } else {
            layoutParams.addRule(9);
            layoutParams.addRule(12);
        }
        layoutParams.setMargins(com.baidu.mobads.container.util.ab.a(this.w, this.aP), 0, 0, com.baidu.mobads.container.util.ab.a(this.w, this.aT));
        this.aO.setLayoutParams(layoutParams);
    }

    public void h() {
        if (!this.N) {
            return;
        }
        if (this.v != null) {
            this.M = this.v.c();
        }
        this.ba = new u(this.w);
        this.ba.setId(10009);
        this.ba.a(this.x.getActionText(this.w));
        this.ba.d(this.bk);
        this.ba.e(com.baidu.mobads.container.util.ab.c(this.w, this.bj));
        this.ba.a(this.bl);
        this.ba.b(this.bh);
        this.ba.setBackgroundColor(this.bi);
        if (this.x.isDownloadApp()) {
            this.ba.b(this.x.getAppPackage());
        }
    }

    public void i() {
        this.aZ = new u(this.w);
        this.aZ.a(this.x.getActionText(this.w));
        if (this.x.isDownloadApp()) {
            this.aZ.b(this.x.getAppPackage());
        }
    }

    private void E() {
        this.bm = new TextView(this.w);
        this.bm.setText("X");
        this.bm.setTextSize(2, 11.0f);
        this.bm.setTextColor(Color.parseColor("#cccccc"));
        this.bm.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(4.0f);
        gradientDrawable.setStroke(1, Color.parseColor("#cccccc"));
        gradientDrawable.setColor(Color.parseColor("#eeeeee"));
        this.bm.setBackgroundDrawable(gradientDrawable);
        this.bm.setOnClickListener(new p(this));
    }

    private RelativeLayout.LayoutParams F() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.mobads.container.util.ab.a(this.w, this.bn), com.baidu.mobads.container.util.ab.a(this.w, this.bo));
        if (this.ba != null && this.ba.getVisibility() == 8) {
            if (this.x != null && this.x.getStyleType() == 34) {
                layoutParams.addRule(9);
            } else {
                layoutParams.addRule(11);
            }
        } else if (this.x != null && this.x.getStyleType() == 34) {
            layoutParams.addRule(1, 10009);
        } else {
            layoutParams.addRule(0, 10009);
        }
        layoutParams.addRule(12);
        layoutParams.setMargins(com.baidu.mobads.container.util.ab.a(this.w, this.br), com.baidu.mobads.container.util.ab.a(this.w, this.bp), com.baidu.mobads.container.util.ab.a(this.w, this.bs), com.baidu.mobads.container.util.ab.a(this.w, this.bq));
        return layoutParams;
    }

    protected void j() {
        E();
        addView(this.bm, F());
    }

    public void k() {
        if (this.bm != null) {
            if (!this.bt) {
                this.bm.setVisibility(8);
            } else {
                this.bm.setLayoutParams(F());
            }
        }
    }

    public void l() {
        this.ba.setLayoutParams(I());
        addView(this.ba, I());
        a(this.ba, this.ba.c());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        G();
    }

    private void a(View view, float f2) {
        com.baidu.mobads.container.adrequest.t adContainerContext;
        com.baidu.mobads.container.k baseAdContainer;
        if (this.by != null) {
            return;
        }
        int btnStyleType = 0;
        int[] btnStyleColors = {-35564, -648683, -3602220, -194648};
        if (this.x instanceof com.baidu.mobads.container.a.d) {
            try {
                btnStyleType = ((com.baidu.mobads.container.a.d) this.x).getBtnStyleType();
                btnStyleColors = ((com.baidu.mobads.container.a.d) this.x).getBtnStyleColors();
            } catch (Throwable th) {
                bq.a().a(th);
            }
        }
        this.by = com.baidu.mobads.container.util.animation.j.a(view, (int) f2, btnStyleType, btnStyleColors, a.EnumC0133a.PAINT);
        if (this.bu != null) {
            adContainerContext = this.bu.getAdContainerContext();
        } else if (this.x != null && (baseAdContainer = this.x.getBaseAdContainer()) != null) {
            adContainerContext = baseAdContainer.getAdContainerContext();
        } else {
            adContainerContext = null;
        }
        if (adContainerContext != null && this.x != null) {
            by.a(adContainerContext, this.x, (com.baidu.mobads.container.adrequest.j) null, 1);
        }
    }

    private void G() {
        com.baidu.mobads.container.util.h.a(new q(this));
    }

    public void m() {
        i();
        this.O = new ad(this.w, this.x, this.aZ);
        this.O.setId(10010);
    }

    public void n() {
        if (this.O == null) {
            m();
        }
        this.O.aa(com.baidu.mobads.container.util.ab.a(this.w, this.R));
        this.O.Z(this.I - com.baidu.mobads.container.util.ab.c(this.w, this.S + this.T));
        this.O.b(new r(this));
        this.O.a(new s(this));
        this.O.c(new t(this));
        this.O.g();
        addView(this.O, H());
        a(this.aZ, this.aZ.c());
    }

    public void o() {
        try {
            com.style.widget.a aVarA = com.style.widget.a.a(this.w);
            aVarA.a(new l(this));
            aVarA.a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void p() {
        if (this.ba != null) {
            this.ba.d(this.bk);
            this.ba.e(com.baidu.mobads.container.util.ab.c(this.w, this.bj));
            this.ba.a(this.bl);
            this.ba.b(this.bh);
            this.ba.setBackgroundColor(this.bi);
            this.ba.setLayoutParams(I());
        }
    }

    private RelativeLayout.LayoutParams H() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.baidu.mobads.container.util.ab.a(this.w, this.R));
        if (this.x.getStyleType() == 28) {
            layoutParams.addRule(3, 10001);
        } else if (this.x.getStyleType() == 37) {
            layoutParams.addRule(3, 10007);
        } else {
            layoutParams.addRule(3, 10002);
        }
        layoutParams.setMargins(com.baidu.mobads.container.util.ab.a(this.w, this.S), com.baidu.mobads.container.util.ab.a(this.w, this.U), com.baidu.mobads.container.util.ab.a(this.w, this.T), com.baidu.mobads.container.util.ab.a(this.w, this.V));
        return layoutParams;
    }

    private RelativeLayout.LayoutParams I() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.mobads.container.util.ab.a(this.w, this.bb), com.baidu.mobads.container.util.ab.a(this.w, this.bc));
        layoutParams.addRule(12);
        if (this.x != null && this.x.getStyleType() == 34) {
            layoutParams.addRule(9);
        } else {
            layoutParams.addRule(11);
        }
        layoutParams.setMargins(com.baidu.mobads.container.util.ab.a(this.w, this.bd), com.baidu.mobads.container.util.ab.a(this.w, this.bf), com.baidu.mobads.container.util.ab.a(this.w, this.be), com.baidu.mobads.container.util.ab.a(this.w, this.bg));
        return layoutParams;
    }

    public void q() {
    }

    public void r() {
    }

    public void s() {
    }

    public void a(com.baidu.mobads.container.a.d dVar) {
        if (dVar != null) {
            int iN = dVar.n();
            if (iN == 1) {
                this.M = true;
            } else if (iN == 0) {
                this.M = false;
            }
        }
    }

    public void a(Object obj) {
        if (obj == null) {
            return;
        }
        this.v = new ag(obj);
        if (this.O != null) {
            if (this.v.ae() >= 0) {
                this.O.V(this.v.ae());
            }
            this.O.Y(this.v.af());
            if (this.v.ag() >= 0) {
                this.O.S(this.v.ag());
            }
            if (this.v.ah() >= 0) {
                this.O.X(this.v.ah());
            }
            if (this.v.ai() >= 0) {
                this.O.R(this.v.ai());
            }
            if (this.v.aj() >= 0) {
                this.O.W(this.v.aj());
            }
            if (this.v.ak() >= 0) {
                this.O.r(this.v.ak());
            }
            this.O.s(this.v.al());
            if (this.v.am() >= 0) {
                this.O.o(this.v.am());
            }
            if (this.v.an() >= 0) {
                this.O.t(this.v.an());
            }
            if (this.v.ao() >= 0) {
                this.O.n(this.v.ao());
            }
            if (this.v.ap() >= 0) {
                this.O.u(this.v.ap());
            }
            if (this.v.aq() >= 0) {
                this.O.J(this.v.aq());
            }
            this.O.K(this.v.ar());
            if (this.v.as() >= 0) {
                this.O.E(this.v.as());
            }
            if (this.v.at() >= 0) {
                this.O.I(this.v.at());
            }
            if (this.v.au() >= 0) {
                this.O.D(this.v.au());
            }
            if (this.v.av() >= 0) {
                this.O.H(this.v.av());
            }
            if (this.v.aw() >= 0) {
                this.O.z(this.v.aw());
            }
            this.O.A(this.v.ax());
            if (this.v.ay() >= 0) {
                this.O.w(this.v.ay());
            }
            if (this.v.az() >= 0) {
                this.O.C(this.v.az());
            }
            if (this.v.aA() >= 0) {
                this.O.v(this.v.aA());
            }
            if (this.v.aB() >= 0) {
                this.O.B(this.v.aB());
            }
            if (this.v.aC() >= 0) {
                this.O.L(this.v.aC());
            }
            this.O.M(this.v.aD());
            if (this.v.aE() >= 0) {
                this.O.O(this.v.aE());
            }
            if (this.v.aF() >= 0) {
                this.O.Q(this.v.aF());
            }
            if (this.v.aG() >= 0) {
                this.O.N(this.v.aG());
            }
            if (this.v.aH() >= 0) {
                this.O.P(this.v.aH());
            }
            if (this.v.aI() >= 0) {
                this.O.l(this.v.aI());
            }
            if (this.v.aJ() >= 0) {
                this.O.m(this.v.aJ());
            }
            if (this.v.aK() >= 0) {
                this.O.d(this.v.aK());
            }
            if (this.v.aL() >= 0) {
                this.O.k(this.v.aL());
            }
            if (this.v.aM() >= 0) {
                this.O.i(this.v.aM());
            }
            if (this.v.aN() >= 0) {
                this.O.j(this.v.aN());
            }
            this.O.e(this.v.aO());
            this.O.f(this.v.aP());
            if (this.v.aQ() >= 0) {
                this.O.g(this.v.aQ());
            }
            this.O.h(this.v.aR());
            this.O.a(this.v.aS());
            this.O.setBackgroundColor(this.v.b(u));
            this.O.a(this.v.aT());
            if (this.v.aU() >= 0) {
                this.O.ae(this.v.aU());
            }
            if (this.v.aV() >= 0) {
                this.O.ad(this.v.aV());
            }
            if (this.v.aW() >= 0) {
                this.O.ac(this.v.aW());
            }
            if (this.v.aX() >= 0) {
                this.O.ab(this.v.aX());
            }
        }
        this.bt = this.v.aT();
        if (this.v.aU() >= 0) {
            this.bp = this.v.aU();
        }
        if (this.v.aV() >= 0) {
            this.bq = this.v.aV();
        }
        if (this.v.aW() >= 0) {
            this.br = this.v.aW();
        }
        if (this.v.aX() >= 0) {
            this.bs = this.v.aX();
        }
        if (this.v.i() >= 0) {
            this.U = this.v.i();
        }
        if (this.v.j() >= 0) {
            this.V = this.v.j();
        }
        if (this.v.g() >= 0) {
            this.S = this.v.g();
        }
        if (this.v.h() >= 0) {
            this.T = this.v.h();
        }
        this.f799K = this.v.a();
        this.L = this.v.b();
        this.M = this.v.c();
        this.N = this.v.d();
        if (this.v.k() >= 0) {
            this.aa = this.v.k();
        }
        if (this.v.l() >= 0) {
            this.ab = this.v.l();
        }
        if (this.v.m() >= 0) {
            this.ac = this.v.m();
        }
        if (this.v.n() >= 0) {
            this.ad = this.v.n();
        }
        if (this.v.o() >= 0) {
            this.ae = this.v.o();
        }
        if (this.v.p() >= 0) {
            this.af = this.v.p();
        }
        if (this.v.q() >= 0) {
            this.aj = this.v.q();
        }
        if (this.v.r() >= 0) {
            this.ak = this.v.r();
        }
        if (this.v.s() >= 0) {
            this.al = this.v.s();
        }
        if (this.v.t() >= 0) {
            this.am = this.v.t();
            this.an = true;
        }
        if (this.v.u() >= 0) {
            this.ao = this.v.u();
        }
        this.ap = this.v.a(p);
        this.aq = this.v.v();
        if (this.v.w() >= 0) {
            this.at = com.baidu.mobads.container.util.ab.a(this.w, this.v.w());
        }
        if (this.v.x() >= 0) {
            this.au = com.baidu.mobads.container.util.ab.a(this.w, this.v.x());
        }
        if (this.v.y() >= 0) {
            this.av = this.v.y();
        }
        if (this.v.z() >= 0) {
            this.aw = this.v.z();
            this.ax = true;
        }
        if (this.v.A() >= 0) {
            this.ay = this.v.A();
        }
        if (this.v.B() >= 0) {
            this.az = this.v.B();
        }
        if (this.v.C() >= 0) {
            this.aB = com.baidu.mobads.container.util.ab.a(this.w, this.v.C());
        }
        if (this.v.D() >= 0) {
            this.aC = com.baidu.mobads.container.util.ab.a(this.w, this.v.D());
        }
        if (this.v.E() >= 0) {
            this.aD = this.v.E();
        }
        if (this.v.F() >= 0) {
            this.aE = this.v.F();
        }
        if (this.v.G() >= 0) {
            this.aF = this.v.G();
        }
        if (this.v.H() >= 0) {
            this.aG = this.v.H();
        }
        if (this.v.I() >= 0) {
            this.aI = com.baidu.mobads.container.util.ab.a(this.w, this.v.I());
        }
        if (this.v.J() >= 0) {
            this.aJ = com.baidu.mobads.container.util.ab.a(this.w, this.v.J());
        }
        if (this.v.K() >= 0) {
            this.aK = this.v.K();
        }
        if (this.v.L() >= 0) {
            this.aL = this.v.L();
        }
        if (this.v.M() >= 0) {
            this.aM = this.v.M();
        }
        if (this.v.N() >= 0) {
            this.aN = this.v.N();
        }
        this.G = this.v.c(o);
        this.H = this.v.O();
        this.aV = this.v.T();
        this.aW = this.v.U();
        if (this.v.P() >= 0) {
            this.aP = this.v.P();
        }
        if (this.v.Q() >= 0) {
            this.aQ = this.v.Q();
        }
        if (this.v.R() >= 0) {
            this.aT = this.v.R();
        }
        if (this.v.S() >= 0) {
            this.aU = this.v.S();
        }
        if (this.v.V() >= 0) {
            this.bb = this.v.V();
        }
        if (this.v.W() >= 0) {
            this.bc = this.v.W();
        }
        if (this.v.X() >= 0) {
            this.bd = this.v.X();
        }
        if (this.v.Y() >= 0) {
            this.be = this.v.Y();
        }
        if (this.v.aa() >= 0) {
            this.bg = this.v.aa();
        }
        if (this.v.Z() >= 0) {
            this.bf = this.v.Z();
        }
        this.bk = this.v.ac();
        this.bl = this.v.ad();
        if (this.v.ab() >= 0) {
            this.bj = this.v.ab();
        }
        this.bh = this.v.d(r);
        this.bi = this.v.e(s);
    }

    public void t() {
        if (this.O != null) {
            this.R = Math.max(this.O.ah() + this.O.al() + this.O.ag(), this.O.aa() + this.O.Y() + a(this.O.T()) + this.O.p() + this.O.n() + a(this.O.k()));
        }
    }

    public int a(float f2) {
        Paint paint = new Paint();
        paint.setTextSize(f2);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (int) Math.ceil(fontMetrics.bottom - fontMetrics.top);
    }

    public int[] a(View view) {
        int iMakeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
            view.setLayoutParams(layoutParams);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i2 = layoutParams.height;
        if (i2 > 0) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, iMakeMeasureSpec);
        return new int[]{view.getMeasuredWidth(), view.getMeasuredHeight()};
    }

    protected void u() {
        try {
            this.ah.setTextSize(2, this.ao);
            if (this.ap != this.aX) {
                this.ah.setTextColor(this.ap);
            }
            if (this.aq != null) {
                this.ah.setTypeface(this.aq);
            }
        } catch (Throwable th) {
            bq.a().a(th);
        }
    }

    protected void a(ImageView imageView, int i2, String str) {
        if (imageView != null) {
            imageView.setId(i2);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setBackgroundColor(o);
            com.baidu.mobads.container.util.d.d.a(this.w).b(imageView, str);
        }
    }

    protected void a(com.style.widget.e.a aVar, int i2) {
        if (aVar != null) {
            aVar.setId(i2);
            aVar.setBackgroundColor(o);
            aVar.a(this.x);
        }
    }

    public void v() {
        if (this.O != null && x()) {
            this.O.aa(com.baidu.mobads.container.util.ab.a(this.w, this.R));
            this.O.Z(this.I - com.baidu.mobads.container.util.ab.c(this.w, this.S + this.T));
            this.O.h();
            this.O.setLayoutParams(H());
        }
    }

    protected void w() {
        if (this.O != null && !x()) {
            f();
            if (this.N) {
                j();
                l();
                com.baidu.mobads.container.b.c.a().a(this.x.getAppPackage(), this.ba);
            }
            this.O.setVisibility(8);
            return;
        }
        if (this.O != null && x()) {
            v();
        } else if (!this.N && this.ba != null) {
            this.ba.setVisibility(8);
        }
    }

    protected void b(View view) {
        if (view != null) {
            if (this.H != null) {
                if (com.baidu.mobads.container.util.x.a(null).a() >= 16) {
                    view.setBackground(this.H);
                    return;
                } else {
                    view.setBackgroundDrawable(this.H);
                    return;
                }
            }
            if (this.G != o) {
                view.setBackgroundColor(this.G);
            }
        }
    }

    protected boolean x() {
        return (this.x == null || this.x.getActionType() != 2 || TextUtils.isEmpty(this.x.getPrivacyUrl()) || TextUtils.isEmpty(this.x.getPowerUrl()) || TextUtils.isEmpty(this.x.getPublisher()) || TextUtils.isEmpty(this.x.getVersion()) || !this.f799K) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        try {
            if (this.x != null) {
                this.x.unionLogoClick(this.w);
            }
        } catch (Throwable th) {
        }
    }

    public void y() {
        if (this.x != null) {
            this.x.recordImpression(this);
        }
    }

    public void a(boolean z) {
        if (this.x != null) {
            this.x.handleClick(this, z);
        }
    }

    public class a implements IOAdEventListener {
        public a() {
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            if (com.baidu.mobads.container.components.k.b.T.equals(iOAdEvent.getType()) && j.this.x != null && j.this.ba != null && !j.this.bv) {
                j.this.bv = true;
                if (!j.this.x()) {
                    com.baidu.mobads.container.b.c.a().a(j.this.x.getAppPackage(), j.this.ba);
                } else {
                    com.baidu.mobads.container.b.c.a().a(j.this.x.getAppPackage(), j.this.aZ);
                }
            }
        }
    }
}

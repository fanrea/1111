package com.component.feed;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.nativecpu.AbstractData;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.container.util.ce;
import com.baidu.mobads.container.util.cm;
import com.component.player.AdVideoViewListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public abstract class a extends RelativeLayout {
    private static final String a = "CoreVideoWrapper";
    protected static final String b = "re_play";
    protected static final String c = "auto_replay";
    public static final String d = "play";
    public static final String e = "stop";
    public static final String f = "play_start";
    public static final String g = "play_completion";
    public static final String h = "buffing_start";
    public static final String i = "play_error";
    protected static final String j = "vstart";
    protected static final String k = "vrepeatedplay";
    protected static final String l = "vclose";
    protected static final String m = "vreadyplay";
    protected static final String n = "vplayfail";
    protected static final String o = "vmute";
    public static final String p = "vfrozen";
    public static final String q = "vshow";
    protected long A;
    protected long B;
    protected IFeedPortraitListener C;
    protected boolean D;
    protected FrameLayout E;
    protected ar F;
    protected boolean G;
    protected ImageView H;
    protected String I;
    public boolean J;

    /* renamed from: K, reason: collision with root package name */
    protected double f757K;
    protected String L;
    protected String M;
    protected int N;
    protected boolean O;
    protected boolean P;
    protected boolean Q;
    protected int R;
    protected final AdVideoViewListener S;
    private boolean T;
    private com.component.a.f.e U;
    protected AbstractData r;
    protected int s;
    protected int t;
    protected boolean u;
    protected int v;
    protected bq w;
    protected com.component.player.c x;
    protected Context y;
    protected boolean z;

    protected abstract void a(Object obj);

    protected abstract void b();

    protected abstract void c();

    protected abstract void d();

    protected abstract void e();

    protected abstract void f();

    public a(Context context) {
        super(context);
        this.s = -1;
        this.t = -16777216;
        this.u = false;
        this.v = 2;
        this.w = bq.a();
        this.A = 0L;
        this.B = 0L;
        this.D = true;
        this.G = false;
        this.J = false;
        this.f757K = 0.0d;
        this.L = "ad_click";
        this.M = "";
        this.N = 0;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.R = 7;
        this.S = new c(this);
        this.y = context;
        a();
    }

    private void a() {
        h();
        this.E = new FrameLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView(this.E, layoutParams);
    }

    private void h() {
        this.x = new com.component.player.c(this.y);
        this.x.a(new b(this));
        addView(this.x, new RelativeLayout.LayoutParams(-1, -1));
    }

    public void c(Object obj) {
        if (obj == null) {
            this.w.b(a, "广告响应内容为空，无法播放");
        } else {
            i();
            j();
        }
    }

    protected void i() {
        this.D = true;
        this.z = false;
        this.P = false;
        this.Q = false;
        this.O = false;
        this.N = 0;
        this.A = 0L;
        this.B = 0L;
    }

    public void a(IFeedPortraitListener iFeedPortraitListener) {
        this.C = iFeedPortraitListener;
    }

    public void a(com.component.player.o oVar) {
        if (this.x != null) {
            this.x.a(oVar);
        }
    }

    protected void j() {
        if (this.x != null) {
            this.x.a(this.S);
            this.x.e();
            this.x.a(this.u, this.t, this.s, this.v);
            this.x.i();
            this.x.a(new d(this));
        }
        u();
    }

    protected void k() {
        if (this.x != null) {
            this.x.a(D());
        }
    }

    protected void d(Object obj) {
        if (obj == null) {
            return;
        }
        if (this.r == null) {
            this.r = new com.baidu.mobads.container.a.d(obj);
        }
        u();
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        if (this.E != null) {
            this.E.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        }
        com.baidu.mobads.container.util.d.d.a(this.y).b(imageView, this.r.getImageUrl());
        B();
    }

    public void l() {
        if (this.r != null && AbstractData.a.NORMAL != this.r.getMaterialType() && this.x != null) {
            ce.b(null, this.r.getThirdTrackers(q));
            this.D = true;
            this.Q = true;
            this.x.a(new e(this));
            this.x.d();
            List<String> thirdTrackers = this.r.getThirdTrackers(j);
            int i2 = !this.r.isAutoPlay() ? 1 : 0;
            double dG = this.x.g();
            Double.isNaN(dG);
            double dG2 = this.x.g();
            Double.isNaN(dG2);
            ce.a(dG / 1000.0d, dG2 / 1000.0d, thirdTrackers, i2, 0);
        }
    }

    public void m() {
        if (this.x != null && this.D && this.r != null) {
            this.x.b();
            List<String> thirdTrackers = this.r.getThirdTrackers("vclose");
            int i2 = !this.r.isAutoPlay() ? 1 : 0;
            double dG = this.x.g();
            Double.isNaN(dG);
            ce.a(dG / 1000.0d, this.f757K, thirdTrackers, i2, this.R);
            this.R = 7;
            double dG2 = this.x.g();
            Double.isNaN(dG2);
            this.f757K = dG2 / 1000.0d;
        }
    }

    public void n() {
        if (this.x != null && this.D && this.r != null) {
            this.x.c();
            if (this.x.g() > 100) {
                List<String> thirdTrackers = this.r.getThirdTrackers(j);
                int i2 = !this.r.isAutoPlay() ? 1 : 0;
                double dG = this.x.g();
                Double.isNaN(dG);
                double dG2 = this.x.g();
                Double.isNaN(dG2);
                ce.a(dG / 1000.0d, dG2 / 1000.0d, thirdTrackers, i2, 0);
            }
        }
    }

    private void I() {
        r();
        if (this.x != null) {
            this.x.c(0);
        }
    }

    protected void o() {
        this.w.b(a, "showEndFrame,,");
        u();
        if (this.x != null) {
            this.x.c(4);
        }
        if (this.G) {
            return;
        }
        this.F = new ar(getContext());
        this.F.a = new f(this);
        this.F.a(this.r);
        if (this.E != null) {
            this.E.addView(this.F, new FrameLayout.LayoutParams(-1, -1));
        }
        this.F.setOnClickListener(new g(this));
        B();
    }

    protected void p() {
    }

    protected void a(String str) {
        I();
        if (this.x == null || this.r == null) {
            return;
        }
        this.D = true;
        this.x.d();
        p();
        if (this.C != null) {
            this.C.playRenderingStart();
        }
        ce.a(0.0d, 0.0d, this.r.getThirdTrackers(k), !this.r.isAutoPlay() ? 1 : 0, 0);
        b(str);
    }

    protected void q() {
        if (this.N == 2) {
            a(c);
        }
    }

    protected void r() {
        if (this.E != null) {
            this.E.setVisibility(8);
        }
    }

    public void s() {
        J();
        if (this.x != null) {
            if (this.x.g() / 1000 != this.x.h() / 1000) {
                List<String> thirdTrackers = this.r.getThirdTrackers("vclose");
                int i2 = !this.r.isAutoPlay() ? 1 : 0;
                double dG = this.x.g();
                Double.isNaN(dG);
                ce.a(dG / 1000.0d, this.f757K, thirdTrackers, i2, this.R);
            }
            u();
            this.x.e();
        }
    }

    private void J() {
        this.D = false;
        this.z = false;
    }

    protected void t() {
        if (this.r != null) {
            HashMap map = (HashMap) this.r.getExtras();
            this.I = map != null ? (String) map.get("appsid") : DeviceUtils.getInstance().l(this.y);
        }
    }

    protected void e(Object obj) {
        b(obj);
    }

    public void b(Object obj) {
        u();
        f(obj);
        B();
    }

    protected void u() {
        if (this.E != null) {
            this.E.removeAllViews();
        }
    }

    public void f(Object obj) {
        if (obj == null) {
            return;
        }
        a(obj);
        this.H = new ImageView(getContext());
        this.H.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (this.E != null) {
            this.E.addView(this.H, new FrameLayout.LayoutParams(-1, -1));
        }
        if (this.H != null && this.r != null) {
            com.baidu.mobads.container.util.d.d.a(this.y).b(this.H, this.r.getImageUrl());
        }
    }

    public void v() {
        this.H = new ImageView(getContext());
        this.H.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (this.H != null && this.r != null) {
            com.baidu.mobads.container.util.d.d.a(this.y).b(this.H, this.r.getImageUrl());
        }
    }

    public void w() {
        if (this.E != null && this.H != null) {
            this.E.addView(this.H, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void a(boolean z) {
        if (this.x != null) {
            this.x.b(z);
        }
    }

    public void b(boolean z) {
        if (this.x != null) {
            this.x.b(z);
            int i2 = z ? 2 : 1;
            List<String> thirdTrackers = this.r.getThirdTrackers(o);
            int i3 = !this.r.isAutoPlay() ? 1 : 0;
            double dG = this.x.g();
            Double.isNaN(dG);
            ce.a(dG / 1000.0d, this.f757K, thirdTrackers, i3, i2);
        }
    }

    public void b(int i2) {
        if (this.x != null) {
            this.x.b(i2);
        }
    }

    public void a(float f2) {
        if (this.x != null) {
            this.x.a(f2);
        }
    }

    public boolean x() {
        if (this.x != null) {
            return this.x.f();
        }
        return false;
    }

    public long y() {
        if (this.x != null) {
            return this.x.g();
        }
        return 0L;
    }

    public long z() {
        if (this.x != null) {
            return this.x.h();
        }
        return 0L;
    }

    public void d(boolean z) {
        this.u = z;
    }

    public void c(int i2) {
        this.t = i2;
    }

    public void d(int i2) {
        this.s = i2;
    }

    public void e(int i2) {
        this.v = i2;
    }

    public void e(boolean z) {
        this.T = z;
    }

    public boolean A() {
        return this.F != null && this.F.getVisibility() == 0;
    }

    protected void B() {
        if (this.E != null) {
            this.E.setVisibility(0);
        }
    }

    public void C() {
        r();
    }

    protected String D() {
        if (this.r == null || this.y == null) {
            return "";
        }
        return this.r.getVideoUrl();
    }

    public void f(boolean z) {
        this.J = z;
    }

    public void g(Object obj) {
    }

    public void h(Object obj) {
    }

    public void g(boolean z) {
        this.P = z;
    }

    public boolean g() {
        return this.x.o();
    }

    public void E() {
        if (this.N == 1 && !this.O && this.r.getActionType() == 1) {
            this.O = true;
            this.r.handleClick(this, this.J, 3);
        }
    }

    public void F() {
        com.baidu.mobads.container.adrequest.j jVarE;
        com.component.a.f.e eVarA;
        try {
            if ((this.r instanceof com.baidu.mobads.container.a.d) && (jVarE = ((com.baidu.mobads.container.a.d) this.r).e()) != null && jVarE.getOriginJsonObject() != null) {
                com.baidu.mobads.container.k baseAdContainer = this.r.getBaseAdContainer();
                if ((baseAdContainer instanceof com.baidu.mobads.container.f.b) && (eVarA = ((com.baidu.mobads.container.f.b) baseAdContainer).a(jVarE)) != null) {
                    if (eVarA.c() != null) {
                        this.N = eVarA.c().optInt("auto_c", this.N);
                    }
                    Iterator<com.component.a.f.e> it = eVarA.iterator();
                    while (it.hasNext()) {
                        com.component.a.f.e next = it.next();
                        if (next != null && "native_video".equals(next.l(""))) {
                            this.U = next;
                            this.M = next.q(this.M);
                            JSONObject jSONObjectC = next.c();
                            if (jSONObjectC != null) {
                                this.L = jSONObjectC.optString("cover_click", this.L);
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(View view) {
        com.baidu.mobads.container.adrequest.j jVarE;
        if ((this.r instanceof com.baidu.mobads.container.a.d) && (jVarE = ((com.baidu.mobads.container.a.d) this.r).e()) != null && jVarE.getOriginJsonObject() != null) {
            int iOptInt = jVarE.getOriginJsonObject().optInt("dl_dialog", -1);
            if (iOptInt == 0) {
                this.J = false;
            } else if (iOptInt == 1) {
                this.J = true;
            }
        }
        this.r.handleClick(view, this.J);
    }

    public void G() {
        if (this.E != null) {
            this.E.setOnClickListener(new h(this));
        }
    }

    public void H() {
        if (this.x != null) {
            if ("ad_click".equals(this.M)) {
                this.x.setOnClickListener(new i(this));
            } else if ("play".equals(this.M)) {
                this.x.setOnClickListener(new j(this));
            }
        }
    }

    protected void b(String str) {
        a(str, "");
    }

    protected void a(String str, String str2) {
        com.baidu.mobads.container.adrequest.t adContainerContext;
        by.a aVarA = by.a.a(this.y.getApplicationContext()).a(602).a(this.I).a(cm.V, str2).a("reason", str);
        if (h.equals(str)) {
            aVarA.a("subtype", "808");
        }
        if (this.r != null) {
            aVarA.a("qk", this.r.getQueryKey()).a("adid", this.r.getAdid()).a(com.baidu.mobads.container.components.command.j.f, this.r.getBuyer()).a("act", this.r.getActionType()).a("vurl", this.r.getVideoUrl()).a("adtype", this.r.getMaterialType().b());
            com.baidu.mobads.container.k baseAdContainer = this.r.getBaseAdContainer();
            if (baseAdContainer != null && (adContainerContext = baseAdContainer.getAdContainerContext()) != null) {
                aVarA.b(adContainerContext.l()).c(adContainerContext.k()).a(adContainerContext.z());
            }
        }
        if (this.x != null) {
            aVarA.a(this.x.j().g());
        }
        aVarA.f();
    }
}

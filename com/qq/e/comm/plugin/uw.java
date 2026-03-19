package com.qq.e.comm.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.l6;
import com.qq.e.comm.plugin.so;
import com.qq.e.comm.plugin.tn;
import com.qq.e.comm.plugin.tw;
import com.qq.e.comm.plugin.wd;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class uw implements ACTD, sh, tn.a {
    public static final String Z = "uw";
    private static final boolean a0;
    private ValueCallback<Uri[]> A;
    private ValueCallback<Uri> B;
    private cz D;
    private long F;
    private boolean G;
    private boolean H;
    private boolean I;
    private String J;

    /* renamed from: K, reason: collision with root package name */
    private String f784K;
    private String L;
    private boolean M;
    private boolean N;
    private long O;
    private long P;
    private boolean Q;
    private boolean R;
    private long S;
    private long T;
    private final Activity a;
    private jm b;
    private long c;
    private long d;
    private String e;
    private boolean f;
    private tw g;
    private f20 h;
    private boolean i;
    private Handler j;
    private int m;
    private int n;
    private p6 o;
    private so q;
    private int r;
    private int s;
    private int t;
    private boolean v;
    private String x;
    private pw y;
    private boolean p = false;
    private final int u = 5;
    private boolean w = false;
    private boolean z = false;
    private f5 C = new f5();
    private boolean E = true;
    private int U = -1;
    private boolean V = false;
    private boolean W = false;
    private boolean X = false;
    private boolean Y = false;

    static {
        a0 = r1.d().f().a("rpdtpsblr", 0) == 1;
    }

    @Override // com.qq.e.comm.plugin.sh
    public void b(String str) {
    }

    @Override // com.qq.e.comm.plugin.sh
    public void c() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onAfterCreate(Bundle bundle) {
        Object obj;
        this.T = System.currentTimeMillis();
        this.a.getWindow().setBackgroundDrawable(null);
        FrameLayout frameLayout = new FrameLayout(this.a);
        frameLayout.setBackgroundColor(-16777216);
        this.a.setContentView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
        Intent intent = this.a.getIntent();
        this.c = intent.getLongExtra("clickStartTime", System.currentTimeMillis());
        String stringExtra = intent.getStringExtra("objectId");
        this.x = stringExtra;
        pw pwVar = (pw) ((ud) zm.a(stringExtra, ud.class)).a();
        this.y = pwVar;
        if (pwVar == null) {
            zm.a(ud.class);
            this.a.finish();
            return;
        }
        a(pwVar);
        ua.b(this.a, ua.a(this.y));
        this.C = f5.a(this.y);
        wd.a().a(this.y.S0(), 10001);
        if (!this.y.N1()) {
            ax.b(this.y);
            wd.a().a(this.y.S0(), 10015, 5001);
            this.a.finish();
            a(2050005, this.e);
            return;
        }
        tw twVar = new tw(this.a, this.y);
        this.g = twVar;
        twVar.a(new c());
        int iApplyDimension = (int) TypedValue.applyDimension(1, 45.0f, this.a.getResources().getDisplayMetrics());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, iApplyDimension);
        layoutParams.gravity = 48;
        this.g.setLayoutParams(layoutParams);
        this.g.setBackgroundColor(-16777216);
        this.g.a(new d());
        String strM1 = this.y.M1();
        this.f784K = strM1;
        if (TextUtils.isEmpty(strM1) || this.R) {
            this.f784K = this.H ? "完成互动" : "浏览页面";
        }
        this.g.a(this.f784K, this.r, this.M ? String.format("秒获得%s", this.L) : String.format("秒后即可获得%s", this.L));
        this.J = String.format("恭喜获得%s！", this.L);
        if (this.s <= 0) {
            b();
        }
        frameLayout.addView(this.g);
        Pair<jm, Boolean> pairA = xw.a(this.y.S0());
        if (pairA == null || (obj = pairA.first) == null) {
            jm jmVarA = new qh(this.a, this.y).a();
            this.b = jmVarA;
            jmVarA.a(1);
            if (this.b.b() != null) {
                this.b.b().a("videoService", new ww());
            }
            if (a0) {
                this.b.c(this.N);
                this.b.a(3);
            }
            this.b.loadUrl(this.e);
        } else {
            jm jmVar = (jm) obj;
            this.b = jmVar;
            jmVar.a(1);
            this.b.a(this.a);
            if (((Boolean) pairA.second).booleanValue()) {
                m();
                j();
            }
        }
        this.b.a(this);
        this.b.c(this.N);
        this.b.a(2);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.topMargin = iApplyDimension;
        this.b.a().setLayoutParams(layoutParams2);
        this.b.b().a(new vw(this));
        tn tnVar = new tn(this.y, this.b);
        tnVar.a(this);
        this.b.a().setOnTouchListener(tnVar);
        this.b.b(true);
        frameLayout.addView(this.b.a());
        this.y.f(10);
        u2.a().a(this.b.a(), this.y);
        Handler handler = new Handler(Looper.getMainLooper());
        this.j = handler;
        handler.postDelayed(new e(), this.m * 1000);
        this.j.postDelayed(new f(), this.n * 1000);
        this.D = new g(this.a);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onStop() {
    }

    static /* synthetic */ int c(uw uwVar) {
        int i2 = uwVar.t + 1;
        uwVar.t = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() throws JSONException {
        this.S = System.currentTimeMillis();
        rw rwVar = rw.PAGE;
        ax.b(rwVar, this.y, -1L, h(), this.r * 1000, null, this.H, this.I);
        wd wdVarA = wd.a();
        wd.c cVar = new wd.c();
        cVar.a = this.y.S0();
        cVar.b = new zw(h(), this.r * 1000, this.H ? 3 : 2, this.U, -1);
        wdVarA.a(this.y.S0(), 10014, cVar);
        this.G = true;
        this.p = false;
        this.g.a(this.J);
        if (!this.H) {
            ax.a(rwVar, this.y, -1L, h(), this.r * 1000, null, this.H, this.I);
        } else {
            ax.a(this.y, this.r * 1000, h(), this.H, this.I);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long h() {
        return (System.currentTimeMillis() - this.P) + this.O;
    }

    private void i() {
        String str = "浏览页面 %d 秒即可获得奖励\n确认要离开吗？";
        if (this.H) {
            boolean z = this.I;
            if (!z && !this.w) {
                str = "互动 %d 秒后即可获得奖励\n确认要离开吗？";
            } else if ((!z || this.w) && !z) {
                str = "完成互动即可获得奖励\n确认要离开吗？";
            }
        }
        if (this.o == null) {
            this.o = new p6(this.a);
        }
        this.o.setCancelable(false);
        if (!this.o.isShowing()) {
            boolean zA = ua.a(this.y);
            ua.d(this.a, zA);
            this.o.show();
            ua.a(this.a, zA, false);
            ua.a(this.a, zA);
        }
        LinearLayout linearLayoutA = this.o.a(this.a, false, String.format(Locale.getDefault(), str, Integer.valueOf(this.r)), "抓住奖励机会", "放弃奖励离开");
        this.o.setContentView(linearLayoutA);
        Window window = this.o.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            linearLayoutA.measure(0, 0);
            attributes.width = linearLayoutA.getMeasuredWidth();
            attributes.height = linearLayoutA.getMeasuredHeight();
            attributes.gravity = 17;
            window.setAttributes(attributes);
            window.getDecorView().setPadding(0, 0, 0, 0);
            window.setBackgroundDrawable(gx.a(yu.a((Context) this.a, 10), -1, 255));
        }
        this.o.a().setOnClickListener(new k());
        this.o.b().setOnClickListener(new a());
    }

    public uw(Activity activity) {
        this.a = activity;
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBeforeCreate(Bundle bundle) {
        this.a.requestWindowFeature(1);
        if (Build.VERSION.SDK_INT >= 21) {
            this.a.getWindow().setStatusBarColor(-16777216);
        }
    }

    /* compiled from: A */
    class c implements tw.b {
        c() {
        }

        @Override // com.qq.e.comm.plugin.tw.b
        public void b() throws JSONException {
            uw.this.n();
        }
    }

    /* compiled from: A */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws JSONException {
            uw.this.a(true);
        }
    }

    /* compiled from: A */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            uw.this.m();
        }
    }

    /* compiled from: A */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            uw.this.j();
        }
    }

    /* compiled from: A */
    class g extends cz {
        g(Context context) {
            super(context);
        }

        @Override // com.qq.e.comm.plugin.cz, com.qq.e.comm.plugin.qs
        public void i() {
            if (uw.this.y.k1()) {
                super.i();
            }
        }
    }

    /* compiled from: A */
    class h implements so.f {
        @Override // com.qq.e.comm.plugin.so.f
        public void onComplainSuccess() {
            wd.a().a(uw.this.y.S0(), com.style.widget.ad.f);
        }

        h() {
        }
    }

    /* compiled from: A */
    class i implements DialogInterface.OnDismissListener {
        i() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) throws JSONException {
            uw.this.e();
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onResume() throws JSONException {
        if (this.h != null && !k()) {
            e();
        }
        if (this.f) {
            jm jmVar = this.b;
            if (jmVar != null) {
                jmVar.onResume();
            }
            this.f = false;
            if (this.i) {
                j();
                this.i = false;
            }
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onPause() throws JSONException {
        d();
        jm jmVar = this.b;
        if (jmVar != null) {
            jmVar.onPause();
        }
        this.f = true;
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onDestroy() throws JSONException {
        this.z = true;
        if (this.b != null) {
            u2.a().b(this.b.a());
            this.b.d();
            this.b = null;
        }
        f20 f20Var = this.h;
        if (f20Var != null) {
            f20Var.h();
            this.h = null;
        }
        Handler handler = this.j;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        pw pwVar = this.y;
        if (pwVar != null) {
            xw.b(pwVar.S0());
        }
        zm.b(this.x, ud.class);
        ax.a(this.C, System.currentTimeMillis() - this.F, this.G, this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() throws JSONException {
        so soVar = new so(this.a, (h4) this.y);
        this.q = soVar;
        soVar.a(new h());
        this.q.a(new i());
        this.q.j();
        d();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBackPressed() throws JSONException {
        a(false);
    }

    private boolean l() {
        return xc.a("rpnsdbr", this.y.y0(), 0, this.y.x0()) == 1;
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onActivityResult(int i2, int i3, Intent intent) {
        Uri data;
        if (1 == i2 && this.A != null) {
            this.A.onReceiveValue((i3 != -1 || intent == null || (data = intent.getData()) == null) ? null : new Uri[]{data});
            this.A = null;
        } else {
            if (2 != i2 || this.B == null) {
                return;
            }
            this.B.onReceiveValue((i3 != -1 || intent == null) ? null : intent.getData());
            this.B = null;
        }
    }

    private boolean k() {
        so soVar;
        p6 p6Var = this.o;
        return (p6Var != null && p6Var.isShowing()) || ((soVar = this.q) != null && soVar.i());
    }

    /* compiled from: A */
    class j extends f20 {
        j(long j, long j2) {
            super(j, j2);
        }

        @Override // com.qq.e.comm.plugin.f20
        public void a(long j) {
            int iRound = Math.round(j / 1000.0f);
            if (iRound > 0) {
                uw.this.g.c(iRound);
            } else {
                if (!uw.this.H || uw.this.I) {
                    uw.this.g.a(uw.this.J);
                } else {
                    uw.this.o();
                }
                uw.this.p = false;
            }
            uw.c(uw.this);
            if (uw.this.t < uw.this.s * 2 || uw.this.s >= uw.this.r) {
                if (uw.this.t < uw.this.r * 2 || uw.this.s < uw.this.r) {
                    return;
                }
                uw.this.b();
                return;
            }
            uw.this.b();
        }

        @Override // com.qq.e.comm.plugin.f20
        public void d() throws JSONException {
            if (uw.this.w || uw.this.h == null || uw.this.b == null) {
                return;
            }
            ax.b(uw.this.y, uw.this.r * 1000, uw.this.h(), uw.this.H, uw.this.I);
            if (!uw.this.H || uw.this.I) {
                uw.this.f();
            }
            if (uw.this.H) {
                if (uw.this.I) {
                    uw.this.g.a(uw.this.J);
                } else {
                    uw.this.o();
                    if (uw.this.v) {
                        xo.a(new a(), 5000L);
                    }
                }
            }
            uw.this.w = true;
            uw.this.b();
        }

        /* compiled from: A */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (uw.this.I) {
                    return;
                }
                String str = uw.Z;
                uw.this.b(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) throws JSONException {
        jm jmVar;
        if (this.y == null || (jmVar = this.b) == null) {
            return;
        }
        if (!z && jmVar.canGoBack()) {
            this.b.goBack();
            return;
        }
        boolean z2 = this.H;
        if ((!z2 && this.w) || ((z2 && this.I && this.w) || l())) {
            ax.a(this.y, this.r * 1000, this.S, h(), this.T, this.H, this.I);
            wd.a().a(this.y.S0(), 10004);
            this.a.finish();
            a(2050005, this.e);
            return;
        }
        if (this.p) {
            d();
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (!this.f && !k()) {
            if (this.h != null) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.F = jCurrentTimeMillis;
            this.P = jCurrentTimeMillis;
            j jVar = new j(this.r * 1000, 500L);
            this.h = jVar;
            jVar.g();
            return;
        }
        this.i = true;
    }

    /* compiled from: A */
    class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws JSONException {
            ax.a(uw.this.y, uw.this.r * 1000, uw.this.S, uw.this.h(), uw.this.T, uw.this.H, uw.this.I);
            wd.a().a(uw.this.y.S0(), 10004);
            uw.this.a.finish();
            uw uwVar = uw.this;
            uwVar.a(2050005, uwVar.e);
        }
    }

    /* compiled from: A */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws JSONException {
            uw.this.o.cancel();
            uw.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.g.a(this.f784K, "", this.M ? String.format("获取%s", this.L) : String.format("后即可获取%s", this.L));
    }

    private JSONArray g() throws JSONException {
        ImageView imageViewA = this.g.a();
        if (imageViewA.getVisibility() != 0 || imageViewA.getAlpha() == 0.0f) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        imageViewA.getLocationOnScreen(new int[2]);
        jn jnVar = new jn();
        jnVar.a("cvx", String.valueOf(zu.b(r2[0])));
        jnVar.a("cvy", String.valueOf(zu.b(r2[1])));
        jnVar.a("cvw", String.valueOf(zu.b(imageViewA.getWidth())));
        jnVar.a("cvh", String.valueOf(zu.b(imageViewA.getHeight())));
        jnVar.a("cvt", String.valueOf(1));
        jnVar.a("cvv", ((Boolean) d50.a(imageViewA, 50, -1).first).booleanValue() ? "1" : "-1");
        jSONArray.put(jnVar.a());
        return jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.p = true;
        this.g.a().setVisibility(0);
    }

    /* compiled from: A */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (uw.this.b == null || uw.this.b.a() == null) {
                return;
            }
            ad.a(u2.a().c(uw.this.b.a()), uw.this.y, null, 10, null);
            zv.a(uw.this.b.a(), uw.this.y);
        }
    }

    public void m() {
        if (this.z) {
            return;
        }
        ax.a(rw.PAGE, this.C);
        this.b.a().post(new b());
        wd.a().a(this.y.S0(), 10002);
        this.z = true;
    }

    private void a(h4 h4Var, String str) {
        if (h4Var.D1() && r1.d().f().a("rvpie", str, 0) == 1) {
            this.m = 0;
        } else {
            this.m = xc.a("rewardPageCountDelayTime", str, 5, h4Var.x0());
        }
        this.n = r1.d().f().a("rpdct", str, 5);
    }

    private void d() throws JSONException {
        f20 f20Var = this.h;
        if (f20Var != null) {
            f20Var.e();
            long jCurrentTimeMillis = this.O + (System.currentTimeMillis() - this.P);
            this.O = jCurrentTimeMillis;
            ax.a(this.y, this.r * 1000, 1, jCurrentTimeMillis, this.H, this.I);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() throws JSONException {
        f20 f20Var = this.h;
        if (f20Var != null) {
            f20Var.f();
            this.P = System.currentTimeMillis();
            ax.a(this.y, this.r * 1000, 2, h(), this.H, this.I);
        } else if (this.i) {
            j();
            this.i = false;
        }
    }

    private void c(i6 i6Var) {
        int iB;
        h4 h4VarA = i6Var.a();
        if (h4VarA == null) {
            return;
        }
        if (h4VarA.o() != null) {
            iB = com.qq.e.comm.plugin.apkmanager.l.e().b(h4VarA.o().e());
        } else {
            iB = 0;
        }
        boolean z = this.E;
        if ((iB == 4 || iB == 16 || iB == 32 || iB == 128) && !z) {
            return;
        }
        i6Var.o = g();
        String strB = b(i6Var);
        j6.a(new l6.b(h4VarA).a(strB).a(false).a(i6Var).a(), this.D);
        zv.a(this.b.a(), h4VarA, strB);
        wd.a().a(h4VarA.S0(), 10003);
        this.E = false;
    }

    private void a(h4 h4Var) {
        String strY0 = h4Var.y0();
        vx vxVarF = r1.d().f();
        a(h4Var, strY0);
        this.Q = vxVarF.a("rpnaspl", strY0, 1) == 1;
        this.s = xc.a("rewardPageCloseTime", strY0, 0, h4Var.x0());
        this.e = this.y.i0();
        this.H = d1.a(this.y.g0());
        if (vn.a(strY0, this.y.I()) && this.H) {
            this.e = vn.a(this.e, "2");
        }
        if (this.H) {
            boolean z = vxVarF.a("ritvfb", strY0, 0) == 1;
            this.R = z;
            this.H = (!z) & this.H;
        }
        if (this.H) {
            this.v = dx.c(strY0);
            this.r = xc.a("skrdct", h4Var.y0(), 15, h4Var.x0());
        } else {
            this.r = xc.a("rewardPageEffectiveTime", strY0, 15, h4Var.x0());
        }
        this.N = vxVarF.a("dwajwl", strY0, 0) == 1;
        Pair<String, Boolean> pairD = dx.d(h4Var);
        this.L = (String) pairD.first;
        this.M = ((Boolean) pairD.second).booleanValue();
    }

    @Override // com.qq.e.comm.plugin.sh
    public void d(String str) {
        this.e = str;
        if (this.W) {
            return;
        }
        this.W = true;
        this.d = System.currentTimeMillis();
        a(2050001, str);
    }

    @Override // com.qq.e.comm.plugin.sh
    public void c(String str) throws JSONException {
        if (!this.V) {
            this.V = true;
            ax.a(true, 0, (String) null, (String) null, this.C);
            a(2050003, str);
        }
        jm jmVar = this.b;
        if (jmVar == null || jmVar.a() == null) {
            return;
        }
        m();
        j();
    }

    private String b(i6 i6Var) {
        View viewA = this.b.a();
        u2 u2VarA = u2.a();
        r5 r5VarD = u2VarA.d(viewA);
        if (r5VarD != null) {
            r5VarD.a(i6Var);
        }
        return u2VarA.a(viewA);
    }

    @Override // com.qq.e.comm.plugin.tn.a
    public void a(i6 i6Var) {
        jm jmVar = this.b;
        if (jmVar == null || jmVar.a() == null) {
            return;
        }
        this.b.c(true);
        this.b.a(4);
        u2.a().a(this.b.a(), this.y, i6Var.b);
        c(i6Var);
    }

    public void b(boolean z) {
        if (!this.I) {
            ax.a(this.y, this.r * 1000, h());
            ax.a(this.y, System.currentTimeMillis() - this.F);
            this.I = true;
        }
        if (this.w) {
            this.g.a(this.J);
        } else {
            this.g.b();
        }
        b();
        if (this.H) {
            this.U = z ? -1 : 1;
        }
        if (!this.w || this.G) {
            return;
        }
        f();
    }

    @Override // com.qq.e.comm.plugin.tn.a
    public void a() {
        if (this.v && this.w && !this.I) {
            b(false);
        }
    }

    @Override // com.qq.e.comm.plugin.sh
    public void b(ValueCallback<Uri> valueCallback, Intent intent) {
        if (valueCallback == null || intent == null) {
            return;
        }
        this.B = valueCallback;
        this.a.startActivityForResult(intent, 2);
    }

    @Override // com.qq.e.comm.plugin.sh
    public void a(String str, Bitmap bitmap) {
        if (this.X) {
            return;
        }
        this.X = true;
        a(2050002, str);
    }

    private void b(int i2, String str, String str2) {
        if (this.Q) {
            un.a(i2, this.c, this.C, str, str2);
        }
    }

    @Override // com.qq.e.comm.plugin.sh
    public void a(int i2) {
        if (i2 == 100) {
            this.g.c();
        } else {
            this.g.b(i2);
        }
    }

    @Override // com.qq.e.comm.plugin.sh
    public void a(int i2, String str, String str2) throws JSONException {
        wd.a().a(this.y.S0(), 10015, Integer.valueOf(ErrorCode.REWARD_PAGE_SHOW_ERROR));
        ax.a(false, i2, str2, str, this.C);
        this.a.finish();
        if (this.Y) {
            return;
        }
        this.Y = true;
        b(2050004, str2, str);
    }

    @Override // com.qq.e.comm.plugin.sh
    public boolean a(ValueCallback<Uri[]> valueCallback, Intent intent) {
        if (valueCallback == null || intent == null) {
            return false;
        }
        this.A = valueCallback;
        this.a.startActivityForResult(intent, 1);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        b(i2, str, null);
    }
}

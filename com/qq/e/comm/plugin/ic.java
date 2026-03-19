package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.kwad.components.offline.api.explore.model.ExploreConstants;
import com.qq.e.comm.plugin.q6;
import com.qq.e.comm.plugin.wp;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class ic extends RelativeLayout implements fk, View.OnClickListener {
    private final h4 a;
    private final sd b;
    private final jm c;
    private oo d;
    private final ImageView e;
    private bc f;
    private CountDownTimer g;
    private boolean h;
    private boolean i;
    private dc j;
    private final f5 m;
    private final ja n;
    private final String o;
    private final int p;
    private int q;
    private volatile boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private final int v;
    private final int w;
    private Boolean x;
    private q6.b y;
    private boolean z;

    ic(Context context, h4 h4Var, String str, int i, sd sdVar) {
        super(context);
        this.r = true;
        this.w = r1.d().f().a("rewardVideoDemoGamePreloadTime", 3);
        setBackgroundColor(-16777216);
        this.o = str;
        this.p = i;
        this.b = sdVar;
        this.n = new ja();
        this.a = h4Var;
        this.v = dx.c(h4Var);
        this.m = f5.a(h4Var);
        a();
        jm jmVarA = new qh(context, h4Var, true).a();
        this.c = jmVarA;
        jmVarA.b().a(new wp.c(h4Var));
        jmVarA.a(new a());
        addView(jmVarA.a(), new RelativeLayout.LayoutParams(-1, -1));
        ua.b(this, 0);
        if (dc.a(i)) {
            dc dcVar = new dc(context, h4Var);
            this.j = dcVar;
            dcVar.setVisibility(8);
            addView(this.j, new RelativeLayout.LayoutParams(-1, -1));
            this.j.setOnClickListener(new b());
        }
        ImageView imageView = new ImageView(context);
        this.e = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        q6.b bVarA = q6.a(q6.c.END_CARD, h4Var);
        this.y = bVarA;
        imageView.setPadding(bVarA.a, bVarA.b, bVarA.c, bVarA.d);
        imageView.setImageBitmap(gw.a("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"));
        imageView.setOnClickListener(this);
        int iA = yu.a(context, 30);
        int iA2 = yu.a(context, 20);
        q6.b bVar = this.y;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(bVar.a + iA + bVar.c, iA + bVar.b + bVar.d);
        layoutParams.addRule(11, -1);
        q6.b bVar2 = this.y;
        layoutParams.leftMargin = -bVar2.a;
        layoutParams.rightMargin = iA2 - bVar2.c;
        layoutParams.topMargin = iA2 - bVar2.b;
        layoutParams.bottomMargin = -bVar2.d;
        addView(imageView, layoutParams);
        imageView.setVisibility(this.q <= 0 ? 0 : 8);
        jmVarA.a().setBackgroundColor(0);
        if (i == 1) {
            oo ooVar = new oo(getContext());
            this.d = ooVar;
            addView(ooVar);
        }
    }

    /* compiled from: A */
    class a implements sh {
        long a;

        @Override // com.qq.e.comm.plugin.sh
        public void a(int i) {
        }

        @Override // com.qq.e.comm.plugin.sh
        public boolean a(ValueCallback<Uri[]> valueCallback, Intent intent) {
            return false;
        }

        @Override // com.qq.e.comm.plugin.sh
        public void b(ValueCallback<Uri> valueCallback, Intent intent) {
        }

        @Override // com.qq.e.comm.plugin.sh
        public void b(String str) {
        }

        @Override // com.qq.e.comm.plugin.sh
        public void c() {
        }

        @Override // com.qq.e.comm.plugin.sh
        public void d(String str) {
        }

        a() {
        }

        @Override // com.qq.e.comm.plugin.sh
        public void a(String str, Bitmap bitmap) {
            this.a = System.currentTimeMillis();
        }

        @Override // com.qq.e.comm.plugin.sh
        public void a(int i, String str, String str2) throws JSONException {
            if (ic.this.h) {
                if (!dc.a(ic.this.p) || ic.this.j == null) {
                    return;
                }
                ic.this.j.setVisibility(0);
                return;
            }
            ic.this.h = true;
            if (!ic.this.i) {
                if (ic.this.c != null) {
                    ic.this.c.loadUrl(str2);
                }
                ic.this.i = true;
            }
            if (ic.this.d != null) {
                ic.this.d.a();
            }
            if (ic.this.f != null) {
                ic.this.f.f();
            }
            if (ic.this.x == null) {
                ic.this.x = Boolean.FALSE;
                pd.a(ic.this.o, "EndCard", ic.this.p, System.currentTimeMillis() - this.a, str2, str, ic.this.m);
                if (ic.this.o.equals(ExploreConstants.SCENE_INTERSTITIAL)) {
                    ic.this.n.a("wu", str2);
                    b10.a(1030019, ic.this.m, Integer.valueOf(ic.this.p), ic.this.n);
                } else if (ic.this.o.equals(ExploreConstants.SCENE_REWARD)) {
                    b10.a(1020017, ic.this.m, Integer.valueOf(ic.this.p), ic.this.b(str2));
                }
                gc.a(ic.this.m, ic.this.p, i, ic.this.b(str2));
                if (ic.this.p == 2) {
                    b10.b(1140004, ic.this.m, 0, ic.this.b(str2));
                }
            }
        }

        @Override // com.qq.e.comm.plugin.sh
        public void c(String str) throws JSONException {
            ic.this.r = false;
            if (ic.this.h) {
                return;
            }
            if (ic.this.d != null) {
                ic.this.d.a();
            }
            if (ic.this.x == null) {
                ic.this.x = Boolean.TRUE;
                pd.a(ic.this.o, "EndCard", ic.this.p, System.currentTimeMillis() - this.a, str, null, ic.this.m);
                if (ic.this.o.equals(ExploreConstants.SCENE_INTERSTITIAL)) {
                    ic.this.n.a("wu", str);
                    b10.a(1030018, ic.this.m, Integer.valueOf(ic.this.p), ic.this.n);
                } else if (ic.this.o.equals(ExploreConstants.SCENE_REWARD)) {
                    b10.a(1020030, ic.this.m, Integer.valueOf(ic.this.p));
                }
                gc.d(ic.this.m, ic.this.p);
            }
        }
    }

    /* compiled from: A */
    class b implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            u2 u2VarA = u2.a();
            r5 r5VarD = u2VarA.d(ic.this.j);
            i6 i6Var = new i6(ic.this.a);
            i6Var.h = 0;
            if (r5VarD != null) {
                r5VarD.a(i6Var);
            }
            i6Var.b = u2VarA.a(ic.this.j);
            if (ic.this.f != null) {
                ic.this.f.a(i6Var, false);
            }
            b10.a(9120027, ic.this.m, Integer.valueOf(ic.this.y.b));
        }

        b() {
        }
    }

    @Override // com.qq.e.comm.plugin.fk
    public void show() {
        a(true);
    }

    /* compiled from: A */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ic.this.e != null) {
                ic.this.e.setVisibility(0);
            }
        }
    }

    /* compiled from: A */
    class d implements Runnable {
        final /* synthetic */ int a;

        d(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean unused = ic.this.r;
            if (!ic.this.r || ic.this.j == null) {
                return;
            }
            ic.this.j.setVisibility(0);
        }
    }

    @Override // com.qq.e.comm.plugin.fk
    public void c() {
        setVisibility(4);
    }

    /* compiled from: A */
    class e extends CountDownTimer {
        @Override // android.os.CountDownTimer
        public void onTick(long j) {
        }

        e(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (ic.this.d != null) {
                ic.this.d.a();
            }
        }
    }

    @Override // com.qq.e.comm.plugin.fk
    public void e() {
        bc bcVar = this.f;
        if (bcVar != null) {
            bcVar.g();
        }
        show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bc bcVar;
        if (view != this.e || (bcVar = this.f) == null) {
            return;
        }
        bcVar.a();
        b10.a(1403014, this.m);
    }

    @Override // com.qq.e.comm.plugin.fk
    public void onDestroy() {
        jm jmVar = this.c;
        if (jmVar != null) {
            jmVar.d();
        }
        CountDownTimer countDownTimer = this.g;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.g = null;
        }
        if (this.x == null) {
            gc.a(this.m, this.p);
        }
        if (!this.s || this.t) {
            return;
        }
        gc.e(this.m, this.p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ja b(String str) throws JSONException {
        ja jaVar = new ja();
        if (str != null) {
            jaVar.a("rs", str);
        }
        return jaVar;
    }

    @Override // com.qq.e.comm.plugin.fk
    public void a(ViewGroup viewGroup) {
        if (getParent() == null) {
            viewGroup.addView(this, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    private void a(long j, long j2) {
        if (((lk) this.a).b()) {
            long jMin = Math.min(rd.a(j, this.b), this.v * 1000) - (this.w * 1000);
            if (jMin <= 0) {
                jMin = 0;
            }
            if (j2 >= jMin) {
                a(((lk) this.a).a());
                this.s = true;
                return;
            }
            return;
        }
        a(((lk) this.a).a());
        this.s = true;
    }

    private void a() {
        vx vxVarF = r1.d().f();
        if (this.o.equals(ExploreConstants.SCENE_INTERSTITIAL)) {
            this.q = vxVarF.a("iecst", 0);
        } else if (this.o.equals(ExploreConstants.SCENE_REWARD)) {
            this.q = vxVarF.a("recst", 0);
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (vn.a(this.a.y0(), this.a.I())) {
            str = vn.a(str, "2");
        }
        if (this.s) {
            return;
        }
        this.s = true;
        if (this.c != null) {
            gc.c(this.m, this.p);
            this.c.loadUrl(str);
            this.r = true;
            if (dc.a(this.p)) {
                int iB = dc.b() * 1000;
                postDelayed(new d(iB), iB);
            }
            oo ooVar = this.d;
            if (ooVar != null) {
                ooVar.setVisibility(0);
                this.g = new e(com.alipay.sdk.m.u.b.a, com.alipay.sdk.m.u.b.a).start();
            }
        }
    }

    @Override // com.qq.e.comm.plugin.em
    public boolean a(j40 j40Var, long j, long j2) {
        if (j40Var == j40.UNINITIALIZED) {
            return true;
        }
        if (!(this.a instanceof lk)) {
            return false;
        }
        if (!this.s) {
            a(j, j2);
        }
        if ((j40Var == j40.STOP || j40Var == j40.ERROR || j40Var == j40.END) && !this.u) {
            show();
            this.u = true;
        }
        return true;
    }

    @Override // com.qq.e.comm.plugin.fk
    public void a(bc bcVar) {
        this.f = bcVar;
        this.c.b().a("videoService", new df(this.a, this.f));
    }

    public void a(boolean z) {
        dc dcVar;
        dc dcVar2;
        if (this.z) {
            return;
        }
        this.z = true;
        gc.b(this.m, this.p);
        if (this.i && this.h && ((dcVar2 = this.j) == null || dcVar2.getVisibility() == 8)) {
            bc bcVar = this.f;
            if (bcVar != null) {
                bcVar.a();
            }
            gc.b(this.m, this.p, 9001, null);
            return;
        }
        bringToFront();
        invalidate();
        setVisibility(0);
        this.t = true;
        if (!this.s) {
            if (TextUtils.isEmpty(((lk) this.a).a()) && (dcVar = this.j) != null) {
                dcVar.setVisibility(0);
            } else {
                a(((lk) this.a).a());
            }
            this.s = true;
        }
        bc bcVar2 = this.f;
        if (bcVar2 != null) {
            bcVar2.h();
        }
        if (!z) {
            this.e.setVisibility(8);
        } else {
            ImageView imageView = this.e;
            if (imageView != null && this.q > 0) {
                imageView.postDelayed(new c(), this.q * 1000);
            }
        }
        if (this.o.equals(ExploreConstants.SCENE_REWARD)) {
            b10.a(1020071, this.m, Integer.valueOf(this.p));
        } else if (this.o.equals(ExploreConstants.SCENE_INTERSTITIAL)) {
            b10.a(1030030, this.m, Integer.valueOf(this.p));
        }
        gc.f(this.m, this.p);
        b10.a(9120026, this.m, Integer.valueOf(this.y.b));
    }
}

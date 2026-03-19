package com.qq.e.comm.plugin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.comm.plugin.adview.video.VideoCallback;
import com.qq.e.comm.plugin.dl.LandingPageCallback;
import com.qq.e.comm.plugin.eg;
import com.qq.e.comm.plugin.hg;
import com.qq.e.comm.plugin.j8;
import com.qq.e.comm.plugin.v30;
import com.qq.e.comm.plugin.w40;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ag extends u4<d> {
    private hg G;
    private eg H;

    /* compiled from: A */
    public static class b implements w40.e {
        @Override // com.qq.e.comm.plugin.w40.e
        public w40 a() {
            return new ag();
        }
    }

    private ag() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qq.e.comm.plugin.w40
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public d b(e8 e8Var) {
        hg hgVar = (hg) new hg.a().a();
        this.G = hgVar;
        hgVar.a(this.n);
        this.G.I();
        this.G.a("initVideo", (JSONObject) null);
        eg egVar = (eg) new eg.d().a();
        this.H = egVar;
        egVar.a(this.n);
        this.H.I();
        return new d(e8Var.d(), (eg.e) this.H.A(), (hg.b) this.G.A());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qq.e.comm.plugin.w40
    protected void M() {
        this.G.M();
        super.M();
        lb lbVar = this.t;
        if (lbVar != null && lbVar.a() && A() != 0) {
            ((d) A()).setWillNotDraw(false);
        }
        ((d) this.A).d();
    }

    @Override // com.qq.e.comm.plugin.w40
    public void clear() {
        super.clear();
        this.G = null;
        this.H = null;
    }

    /* compiled from: A */
    public static class d extends FrameLayout implements dl<ag>, os {
        private final ns A;
        private boolean B;
        private boolean C;
        private long D;
        private ag a;
        private final hg.b b;
        private final WebView c;
        private final jm d;
        private final ImageView e;
        private final FrameLayout.LayoutParams f;
        private final eg.e g;
        private final FrameLayout.LayoutParams h;
        private boolean i;
        private h4 j;
        private int m;
        private int n;
        private int o;
        private float p;
        private float q;
        private boolean r;
        private boolean s;
        private boolean t;
        private boolean u;
        private c v;
        private j8 w;
        private w40.d x;
        private ValueAnimator y;
        private LandingPageCallback z;

        public d(Context context, eg.e eVar, hg.b bVar) throws JSONException {
            super(context);
            this.f = new FrameLayout.LayoutParams(-1, -1);
            this.h = new FrameLayout.LayoutParams(-1, -1, 1);
            this.i = false;
            this.p = -1.0f;
            this.r = false;
            this.s = false;
            this.t = false;
            this.u = false;
            this.A = new ns();
            this.B = false;
            this.C = false;
            this.b = bVar;
            this.g = eVar;
            jm jmVarA = new qh(getContext()).a();
            this.d = jmVarA;
            this.c = (WebView) jmVarA.a();
            ImageView imageView = new ImageView(getContext());
            this.e = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            mm.a().a("https://qzs.gdtimg.com/union/res/union_cdn/page/temp_v2/webview-cover.png", imageView);
            jmVarA.a(new C0695d());
        }

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.ag$d$d, reason: collision with other inner class name */
        class C0695d extends fz {
            C0695d() {
            }

            @Override // com.qq.e.comm.plugin.fz, com.qq.e.comm.plugin.sh
            public void c(String str) {
                super.c(str);
                if (d.this.e.getVisibility() == 0) {
                    d.this.e.setVisibility(8);
                }
            }
        }

        /* compiled from: A */
        class e extends ms<Void> {
            e(os osVar) {
                super(osVar);
            }

            @Override // com.qq.e.comm.plugin.ms
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void b(Void r2) throws JSONException {
                d.this.b();
                d.this.i = false;
                d.this.b(false);
            }
        }

        /* compiled from: A */
        class f extends ms<Void> {
            f(os osVar) {
                super(osVar);
            }

            @Override // com.qq.e.comm.plugin.ms
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void b(Void r2) {
                d.this.C = false;
            }
        }

        /* compiled from: A */
        class g extends ms<Void> {
            g(os osVar) {
                super(osVar);
            }

            @Override // com.qq.e.comm.plugin.ms
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void b(Void r2) {
                d dVar = d.this;
                dVar.a(dVar.z);
            }
        }

        /* compiled from: A */
        class h extends ms<Long> {
            h(os osVar) {
                super(osVar);
            }

            @Override // com.qq.e.comm.plugin.ms
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void b(Long l) throws JSONException {
                if (l == null || !d.this.C || d.this.z == null) {
                    return;
                }
                if (l.longValue() >= d.this.D) {
                    d.this.b();
                    d.this.b(true);
                    d.this.z.W().a();
                    return;
                }
                d.this.z.L().b(Integer.valueOf(((int) ((d.this.D - l.longValue()) / 1000)) + 1));
            }
        }

        /* compiled from: A */
        class i implements v30.c {
            i() {
            }

            @Override // com.qq.e.comm.plugin.v30.c
            public void a(int i) {
                d.this.g.setBackgroundColor(i);
            }
        }

        /* compiled from: A */
        class j implements j8.f {
            j() {
            }

            @Override // com.qq.e.comm.plugin.j8.f
            public void b() {
                if (d.this.s) {
                    return;
                }
                d.this.t = false;
                int i = -d.this.m;
                if (d.this.v != null && d.this.v.a()) {
                    i += d.this.o;
                }
                d.this.a(i, 300, false, true);
                d.this.a.G.a(new int[]{0, 0, 0, 0});
                if (d.this.z != null) {
                    d.this.z.U().a();
                }
            }

            @Override // com.qq.e.comm.plugin.j8.f
            public void a() {
                d.this.b.setVisibility(8);
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            c();
        }

        /* compiled from: A */
        class k implements Runnable {
            k() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.e.setVisibility(8);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x0055  */
        @Override // android.view.ViewGroup
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onInterceptTouchEvent(android.view.MotionEvent r6) throws org.json.JSONException {
            /*
                r5 = this;
                boolean r0 = r5.r
                r1 = 1
                if (r0 == 0) goto L6
                return r1
            L6:
                int r0 = r6.getAction()
                if (r0 == 0) goto L66
                if (r0 == r1) goto L55
                r2 = 2
                if (r0 == r2) goto L15
                r1 = 3
                if (r0 == r1) goto L55
                goto L6e
            L15:
                float r0 = r6.getY()
                float r2 = r5.p
                float r2 = r0 - r2
                int r3 = r5.m
                if (r3 == 0) goto L50
                int r3 = r5.a()
                int r4 = r5.m
                if (r3 != r4) goto L2e
                r3 = 0
                int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
                if (r2 <= 0) goto L50
            L2e:
                android.webkit.WebView r2 = r5.c
                int r2 = r2.getScrollY()
                if (r2 > 0) goto L50
                android.webkit.WebView r2 = r5.c
                float r2 = r2.getY()
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 < 0) goto L50
                com.qq.e.comm.plugin.j8 r0 = r5.w
                if (r0 == 0) goto L4a
                int r0 = r0.b()
                if (r0 != 0) goto L50
            L4a:
                boolean r0 = r5.s
                if (r0 == 0) goto L4f
                goto L50
            L4f:
                return r1
            L50:
                boolean r6 = super.onInterceptTouchEvent(r6)
                return r6
            L55:
                float r0 = r5.p
                android.webkit.WebView r1 = r5.c
                float r1 = r1.getY()
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 < 0) goto L6e
                r0 = 0
                r5.b(r0)
                goto L6e
            L66:
                float r0 = r6.getY()
                int r0 = (int) r0
                float r0 = (float) r0
                r5.p = r0
            L6e:
                boolean r6 = super.onInterceptTouchEvent(r6)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.ag.d.onInterceptTouchEvent(android.view.MotionEvent):boolean");
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) throws JSONException {
            if (this.r) {
                return true;
            }
            int action = motionEvent.getAction();
            if (action == 1) {
                f();
                b(false);
            } else if (action == 2) {
                float y = motionEvent.getY();
                float f2 = y - this.p;
                this.p = y;
                if (a(f2)) {
                    return true;
                }
            } else if (action == 3) {
                b(false);
            }
            return super.onTouchEvent(motionEvent);
        }

        /* compiled from: A */
        class l extends AnimatorListenerAdapter {
            final /* synthetic */ int a;
            final /* synthetic */ boolean b;

            l(int i, boolean z) {
                this.a = i;
                this.b = z;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (this.a > 0) {
                    d.this.r = false;
                }
                d.this.b.animate().setListener(null);
                if (this.b) {
                    d.this.c.scrollTo(0, 0);
                }
            }
        }

        /* compiled from: A */
        class a extends AnimatorListenerAdapter {
            final /* synthetic */ int a;
            final /* synthetic */ boolean b;

            a(int i, boolean z) {
                this.a = i;
                this.b = z;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                d.this.c.animate().setListener(null);
                if (this.a > 0) {
                    d.this.r = false;
                }
                if (this.b) {
                    d.this.c.scrollTo(0, 0);
                }
            }
        }

        /* compiled from: A */
        class b implements ValueAnimator.AnimatorUpdateListener {
            b() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.this.h.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                d.this.b.setLayoutParams(d.this.h);
            }
        }

        /* compiled from: A */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.g.setVisibility(0);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            this.B = true;
            xo.a((Object) null);
        }

        @Override // android.view.View
        protected void onVisibilityChanged(View view, int i2) {
            ag agVar = this.a;
            if (agVar != null) {
                agVar.a(view, i2);
            }
        }

        protected void d() {
            FrameLayout.LayoutParams layoutParams;
            WebView webView = this.c;
            if (webView != null && webView.getParent() == null && (layoutParams = this.f) != null) {
                addView(this.c, layoutParams);
                addView(this.e, this.f);
                xo.a(new k(), 5000L);
            }
            if (this.b.getParent() == null) {
                addView(this.b, this.h);
            }
            eg.e eVar = this.g;
            if (eVar == null || eVar.getParent() != null) {
                return;
            }
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, zu.a(2.0d));
            layoutParams2.gravity = 80;
            this.b.addView(this.g, layoutParams2);
        }

        @Override // com.qq.e.comm.plugin.os
        public ns i() {
            return this.A;
        }

        private void f() {
            int iA;
            boolean z = false;
            if (a() >= this.m * this.q) {
                iA = -a();
            } else if (this.v.a()) {
                iA = (this.m - a()) - this.o;
                z = true;
            } else {
                iA = this.m - a();
            }
            a(iA, 300, z, true);
        }

        @Override // com.qq.e.comm.plugin.os
        public boolean k() {
            return this.B;
        }

        private void c(float f2, int i2, boolean z, boolean z2) {
            if (i2 > 0) {
                this.r = true;
            }
            this.b.animate().cancel();
            if (!z) {
                this.b.animate().translationYBy(f2).setDuration(i2).start();
            } else if (this.w != null) {
                e();
            }
            this.c.animate().cancel();
            long j2 = i2;
            this.c.animate().translationYBy(f2).setDuration(j2).setListener(new l(i2, z2)).start();
            if (this.e.getVisibility() == 0) {
                this.e.animate().cancel();
                this.e.animate().translationYBy(f2).setDuration(j2).start();
            }
        }

        private void b(float f2, int i2, boolean z, boolean z2) {
            if (i2 > 0) {
                this.r = true;
            }
            float fA = a() + f2;
            this.c.animate().cancel();
            long j2 = i2;
            this.c.animate().translationYBy(f2).setDuration(j2).setListener(new a(i2, z2)).start();
            if (this.e.getVisibility() == 0) {
                this.e.animate().cancel();
                this.e.animate().translationYBy(f2).setDuration(j2).start();
            }
            int i3 = (int) (this.n + fA);
            ValueAnimator valueAnimator = this.y;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            if (!z) {
                ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.h.height, i3);
                this.y = valueAnimatorOfInt;
                valueAnimatorOfInt.addUpdateListener(new b());
                this.y.setDuration(j2).start();
                return;
            }
            if (this.w != null) {
                e();
            }
        }

        private void e() {
            this.g.setVisibility(8);
            this.g.postDelayed(new c(), 300L);
            this.w.e();
            int iA = zu.a(8.0d);
            this.a.G.a(new int[]{iA, iA, iA, iA});
        }

        private void c() {
            h4 h4Var;
            if (this.u || this.v == null || (h4Var = this.j) == null || !(h4Var instanceof lk)) {
                return;
            }
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                int height = viewGroup.getHeight();
                int width = viewGroup.getWidth();
                if (height <= 0 || height < width) {
                    return;
                }
                this.u = true;
                int iB1 = this.j.b1();
                int iX0 = this.j.X0();
                this.h.height = this.v.c.a(new JSONObject[0]);
                this.n = this.h.height;
                float fB = this.v.a.b(new JSONObject[0]);
                int i2 = this.n;
                int i3 = (int) (fB * i2);
                this.o = i3;
                this.m = i3 - i2;
                if (!this.v.a()) {
                    height -= this.o;
                }
                FrameLayout.LayoutParams layoutParams = this.f;
                layoutParams.height = height;
                layoutParams.topMargin = this.n;
                if (this.w == null) {
                    int iA = this.v.f.a(new JSONObject[0]);
                    int i4 = ((int) (((iA * 1.0f) / iB1) * iX0)) + 2;
                    int iA2 = this.v.g.a(new JSONObject[0]);
                    int iA3 = this.v.h.a(new JSONObject[0]);
                    int iA4 = this.v.i.a(new JSONObject[0]);
                    int iA5 = this.v.j.a(new JSONObject[0]);
                    if (iA2 <= iA4) {
                        iA2 = (zu.c() - iA) - iA4;
                    }
                    if (iA3 <= iA5) {
                        iA3 = (zu.b() - i4) - iA5;
                    }
                    j8 j8Var = new j8(this.b);
                    this.w = j8Var;
                    j8Var.a(iA, i4).a(new Point(iA2, iA3)).a(new j());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(float f2, int i2, boolean z, boolean z2) {
            if (this.t) {
                return;
            }
            if (z) {
                this.t = true;
            }
            c cVar = this.v;
            if (cVar != null && cVar.d.f(new JSONObject[0]) != 1) {
                b(f2, i2, z, z2);
            } else {
                c(f2, i2, z, z2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(boolean z) throws JSONException {
            if (this.i || this.x == null) {
                return;
            }
            this.i = true;
            this.d.c(true);
            h8 h8Var = new h8(1, "adClick");
            h8Var.a("sld", (Object) 4);
            if (z) {
                h8Var.a("sld", (Object) 8);
            }
            this.x.b(this.a, h8Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            a((this.m - a()) - this.o, 300, true, true);
            this.C = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean z) {
            w40.d dVar;
            this.b.a();
            this.s = true;
            if (this.t && (dVar = this.x) != null && !z) {
                dVar.b(this.a, new h8(1, "forceCloseAd"));
                return;
            }
            j8 j8Var = this.w;
            if (j8Var != null) {
                j8Var.a();
            }
            int iA = this.m - a();
            c cVar = this.v;
            if (cVar != null && !cVar.a()) {
                this.f.height += this.o;
            }
            a(iA - this.o, 300, false, true);
            LandingPageCallback landingPageCallback = this.z;
            if (landingPageCallback != null) {
                landingPageCallback.W().a();
            }
            this.C = false;
            this.t = true;
        }

        private int a() {
            WebView webView = this.c;
            if (webView == null) {
                return 0;
            }
            return (int) webView.getTranslationY();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(LandingPageCallback landingPageCallback) {
            c cVar;
            h4 h4Var = this.j;
            if (h4Var != null && h4Var.W0() >= 0 && (cVar = this.v) != null) {
                long jF = cVar.k.f(new JSONObject[0]) * 1000;
                this.D = jF;
                if (jF > 0) {
                    int iA = xc.a("lpvnafst", this.j.y0(), -1, this.j.x0());
                    if (iA >= 0) {
                        this.D = iA * 1000;
                    }
                    if (rd.a(this.j.W0() * 1000, xc.a("restpl", this.j.y0(), 0, this.j.x0())) - this.D <= com.alipay.sdk.m.u.b.a) {
                        landingPageCallback.l().a();
                        return;
                    } else {
                        this.C = true;
                        return;
                    }
                }
            }
            landingPageCallback.l().a();
        }

        public void a(h4 h4Var) {
            this.j = h4Var;
            this.d.c(r1.d().f().a("dwajwl", this.j.y0(), 0) == 1);
            this.d.loadUrl(this.j.i0());
            LandingPageCallback landingPageCallback = (LandingPageCallback) x5.b(this.j.s0(), LandingPageCallback.class);
            this.z = landingPageCallback;
            landingPageCallback.t().a(new e(this));
            this.z.l().a(new f(this));
            VideoCallback videoCallback = (VideoCallback) x5.b(this.j.s0(), VideoCallback.class);
            videoCallback.a().a(new g(this));
            videoCallback.F().a(new h(this));
        }

        public void a(cm cmVar) {
            v30.a(cmVar, this.a.c().f(), new i());
        }

        public void a(c cVar) {
            this.v = cVar;
            if (cVar.b.b(new JSONObject[0]) == 0.0f) {
                this.q = 0.3f;
            } else {
                this.q = this.v.b.b(new JSONObject[0]);
            }
        }

        public void a(int i2) {
            this.g.a(i2);
        }

        @Override // com.qq.e.comm.plugin.dl
        public void a(ag agVar) {
            this.a = agVar;
        }

        private boolean a(float f2) {
            float fA = a() + f2;
            if (fA >= 0.0f || fA <= this.m) {
                return false;
            }
            a(f2, 0, false, false);
            return true;
        }
    }

    @Override // com.qq.e.comm.plugin.w40, com.qq.e.comm.plugin.fm
    public void a(String str, JSONObject jSONObject) {
        super.a(str, jSONObject);
        str.hashCode();
        if (str.equals("closeVideo")) {
            ((d) this.A).a(false);
        } else if (str.equals("closeVideoAuto")) {
            ((d) this.A).a(true);
        }
    }

    @Override // com.qq.e.comm.plugin.w40
    protected boolean a(String str, cm cmVar) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "barColor":
                this.H.c(cmVar);
                return true;
            case "progress":
                ((d) this.A).a(cmVar.f(new JSONObject[0]));
                return true;
            case "extraParams":
                c cVar = new c();
                try {
                    JSONObject jSONObject = new JSONObject(cmVar.toString());
                    cVar.a = t30.c((Object) jSONObject.optString("videoShowMinSpace"));
                    cVar.b = t30.c((Object) jSONObject.optString("videoAbsorbRatio"));
                    cVar.c = t30.c((Object) jSONObject.optString("verticalVideoHeight"));
                    cVar.d = t30.c((Object) jSONObject.optString("videoMoveType"));
                    cVar.e = t30.c((Object) jSONObject.optString("videoWindowEnable"));
                    cVar.f = t30.c((Object) jSONObject.optString("videoWindowWidth"));
                    cVar.g = t30.c((Object) jSONObject.optString("videoWindowLeft"));
                    cVar.h = t30.c((Object) jSONObject.optString("videoWindowTop"));
                    cVar.i = t30.c((Object) jSONObject.optString("videoWindowRight"));
                    cVar.j = t30.c((Object) jSONObject.optString("videoWindowBottom"));
                    ((d) this.A).a(cVar);
                    cVar.k = t30.c((Object) jSONObject.optString("autoFSTime"));
                } catch (JSONException unused) {
                }
                return true;
            case "barBgColor":
                ((d) this.A).a(cmVar);
                return true;
            default:
                if ("adModel".equals(str)) {
                    ((d) this.A).a((h4) cmVar.e(new JSONObject[0]));
                }
                if (this.G.c(str, cmVar)) {
                    return true;
                }
                return super.a(str, cmVar);
        }
    }

    @Override // com.qq.e.comm.plugin.w40
    public void a(w40.d dVar) {
        ((d) this.A).x = dVar;
    }

    /* compiled from: A */
    private static class c {
        public f10 a;
        public f10 b;
        public f10 c;
        public f10 d;
        public f10 e;
        public f10 f;
        public f10 g;
        public f10 h;
        public f10 i;
        public f10 j;
        public f10 k;

        private c() {
        }

        public boolean a() {
            return this.e.f(new JSONObject[0]) == 1;
        }
    }
}

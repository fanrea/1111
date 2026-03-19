package com.baidu.mobads.container.s;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.container.util.bv;
import com.baidu.mobads.container.util.d.d;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ab extends com.component.a.d.c implements com.component.a.c.c {
    private static final String b = ab.class.getSimpleName();
    public ImageView a;
    private Context d;
    private AnimatorSet e;
    private View f;
    private TextView g;
    private com.baidu.mobads.container.util.g.c h;
    private boolean i;
    private com.component.a.i.f j;
    private d k;
    private com.baidu.mobads.container.s.a l;
    private a m;
    private RelativeLayout n;
    private com.component.a.a.f o;
    private boolean p;
    private final b q;

    public interface a {
        void a(int i);
    }

    public ab(Context context, b bVar, boolean z, com.baidu.mobads.container.util.g.b bVar2, com.baidu.mobads.container.k kVar, com.baidu.mobads.container.adrequest.j jVar, boolean z2) {
        super(context, null);
        this.i = false;
        this.d = context;
        this.p = z2;
        if (bVar != null) {
            this.q = bVar;
        } else {
            this.q = new b();
        }
        if (!z) {
            if (this.q.F) {
                if (!a(kVar, jVar)) {
                    if (this.q.G == 1) {
                        o();
                    } else {
                        r();
                    }
                } else {
                    a(2, kVar, jVar);
                }
            } else if (a(kVar, jVar)) {
                a(1, kVar, jVar);
            } else {
                f();
                n();
            }
        }
        c(bVar2);
        a(true);
    }

    public ab(Context context, b bVar, boolean z, com.baidu.mobads.container.util.g.b bVar2) {
        this(context, bVar, z, bVar2, null, null, false);
    }

    private void a(int i, com.baidu.mobads.container.k kVar, com.baidu.mobads.container.adrequest.j jVar) {
        if (this.n == null) {
            this.n = new RelativeLayout(this.d);
            this.n.setOnClickListener(new ac(this, i));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.mobads.container.util.ab.a(this.d, this.q.c), com.baidu.mobads.container.util.ab.a(this.d, this.q.d));
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = bv.a(this.d, this.q.e);
            try {
                new com.component.a.g.d(kVar, jVar).a(this.n, new JSONObject(com.baidu.mobads.container.u.n.d.replace("https://mobads-pre-config.cdn.bcebos.com/sdk/splash/bd_splash_shake_lottie_red_package_common.json", this.q.b)), new ad(this));
                addView(this.n, layoutParams);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            TextView textView = new TextView(this.d);
            textView.setText(this.q.t);
            textView.setTextColor(-1);
            textView.setShadowLayer(5.0f, com.baidu.mobads.container.util.ab.a(this.d, 3.0f), 0.0f, -1);
            textView.setTextSize(2, 12.0f);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(14);
            layoutParams2.addRule(12);
            layoutParams2.bottomMargin = bv.a(this.d, this.q.f);
            addView(textView, layoutParams2);
        }
    }

    public void a(a aVar) {
        this.m = aVar;
    }

    private void o() {
        try {
            s();
            if (this.l == null) {
                this.l = new com.baidu.mobads.container.s.a(this.d, this.q.H, this.q.a);
                Context context = this.d;
                double d = this.q.H;
                Double.isNaN(d);
                int iA = com.baidu.mobads.container.util.ab.a(context, (float) (d * 1.59d));
                Context context2 = this.d;
                double d2 = this.q.H;
                Double.isNaN(d2);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, com.baidu.mobads.container.util.ab.a(context2, (float) (d2 * 1.59d)));
                layoutParams.addRule(2, this.g.getId());
                layoutParams.bottomMargin = bv.a(this.d, 18.0f);
                layoutParams.addRule(14);
                this.l.setOnClickListener(new ae(this));
                addView(this.l, layoutParams);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void r() {
        try {
            s();
            if (this.k == null) {
                this.k = new d(this.d, this.q.H, this.q.a);
                Context context = this.d;
                double d = this.q.H;
                Double.isNaN(d);
                int iA = com.baidu.mobads.container.util.ab.a(context, (float) (d * 1.59d));
                Context context2 = this.d;
                double d2 = this.q.H;
                Double.isNaN(d2);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, com.baidu.mobads.container.util.ab.a(context2, (float) (d2 * 1.59d)));
                layoutParams.addRule(2, this.g.getId());
                layoutParams.bottomMargin = bv.a(this.d, 18.0f);
                layoutParams.addRule(14);
                this.k.setOnClickListener(new af(this));
                addView(this.k, layoutParams);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void s() {
        try {
            if (this.g == null) {
                this.g = new TextView(this.d);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.bottomMargin = 0;
                layoutParams.addRule(14);
                layoutParams.addRule(12);
                this.g.setId(101);
                this.g.setText(this.q.t);
                this.g.setTextColor(this.q.v);
                this.g.setTextSize(2, this.q.u);
                this.g.setTypeface(this.q.w);
                this.g.setGravity(17);
                this.g.setShadowLayer(3.5f, 1.0f, -1.0f, -13421773);
                this.g.setClickable(false);
                addView(this.g, layoutParams);
            }
        } catch (Throwable th) {
        }
    }

    public int a() {
        if (this.q == null) {
            return 2;
        }
        return this.q.g;
    }

    public boolean b() {
        if (this.q == null) {
            return true;
        }
        return this.q.B;
    }

    public boolean c() {
        if (this.q == null) {
            return false;
        }
        return this.q.C;
    }

    public int d() {
        if (this.q == null) {
            return 0;
        }
        return this.q.D;
    }

    public int e() {
        if (this.q == null) {
            return 0;
        }
        return this.q.E;
    }

    public void a(boolean z) {
        com.baidu.mobads.container.util.g.c cVar = this.h;
        if (cVar != null) {
            if (z) {
                cVar.b(this);
            } else {
                cVar.b((View) null);
            }
        }
    }

    public void a(View view) {
        com.baidu.mobads.container.util.g.c cVar = this.h;
        if (cVar != null) {
            cVar.b(view);
        }
    }

    @Override // com.component.a.d.c, com.component.a.c.c
    public void setLifeCycle(com.component.a.i.f fVar) {
        this.j = fVar;
    }

    @Override // com.component.a.d.c, com.component.a.c.c
    public com.component.a.i.f getLifeCycle() {
        return this.j;
    }

    public void f() {
        try {
            if (this.d == null) {
                return;
            }
            if (this.g == null) {
                this.g = new TextView(this.d);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.bottomMargin = 0;
                layoutParams.addRule(14);
                layoutParams.addRule(12);
                this.g.setId(101);
                this.g.setText(this.q.t);
                this.g.setTextColor(this.q.v);
                this.g.setTextSize(2, this.q.u);
                this.g.setTypeface(this.q.w);
                this.g.setGravity(17);
                this.g.setShadowLayer(3.5f, 1.0f, -1.0f, -13421773);
                this.g.setClickable(false);
                addView(this.g, layoutParams);
            }
            if (this.a == null) {
                this.a = new ImageView(this.d);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(bv.a(this.d, this.q.h), bv.a(this.d, this.q.h));
                layoutParams2.addRule(2, this.g.getId());
                layoutParams2.bottomMargin = bv.a(this.d, 18.0f);
                layoutParams2.addRule(14);
                this.a.setId(102);
                if (TextUtils.isEmpty(this.q.s)) {
                    com.component.b.a.a().a(this.a, "ic_white_shake_gesture");
                } else {
                    com.baidu.mobads.container.util.d.d.a(this.d).b(this.a, this.q.s);
                }
                if (this.p) {
                    this.a.setOnClickListener(new ag(this));
                }
                addView(this.a, layoutParams2);
            }
            if (this.q.g == 2 && this.f == null && this.a != null) {
                this.f = new View(this.d);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(this.q.x);
                gradientDrawable.setAlpha((int) this.q.y);
                double dA = bv.a(this.d, this.q.h * 1.35f);
                Double.isNaN(dA);
                float f = (float) (dA * 0.5d);
                gradientDrawable.setCornerRadii(new float[]{f, f, f, f, f, f, f, f});
                this.f.setBackgroundDrawable(gradientDrawable);
                this.f.setClickable(false);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(bv.a(this.d, this.q.h * 1.35f), bv.a(this.d, this.q.h * 1.35f));
                layoutParams3.addRule(2, this.g.getId());
                layoutParams3.bottomMargin = bv.a(this.d, 18.0f - ((this.q.h * 0.35000002f) / 2.0f));
                layoutParams3.addRule(14);
                if (this.p) {
                    this.f.setOnClickListener(new ah(this));
                }
                addView(this.f, 0, layoutParams3);
            }
        } catch (Throwable th) {
            m();
            com.baidu.mobads.container.l.g.e(b, "attachToParent: ", th);
        }
    }

    private boolean a(com.baidu.mobads.container.k kVar, com.baidu.mobads.container.adrequest.j jVar) {
        try {
            if (com.baidu.mobads.container.util.x.a(null).a() > 25 && !TextUtils.isEmpty(this.q.b) && kVar != null && jVar != null) {
                if (com.baidu.mobads.container.util.d.d.a(this.d).b(this.q.b, d.e.COMMON)) {
                    return true;
                }
                try {
                    new com.component.a.g.d(kVar, jVar).a((ViewGroup) null, new JSONObject(com.baidu.mobads.container.u.n.d.replace("https://mobads-pre-config.cdn.bcebos.com/sdk/splash/bd_splash_shake_lottie_red_package_common.json", this.q.b)), new ai(this));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return false;
    }

    @Override // com.component.a.d.c, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            t();
        } else {
            u();
        }
        if (this.j != null) {
            this.j.a(this, z);
        }
    }

    public com.baidu.mobads.container.s.a g() {
        return this.l;
    }

    public d h() {
        return this.k;
    }

    private void c(com.baidu.mobads.container.util.g.b bVar) {
        this.h = new com.baidu.mobads.container.util.g.c(this.d);
        if (this.q.g == 2 && this.q.z) {
            this.h.a(this);
            this.h.a(1000L);
        }
        this.h.b(this.q.i);
        this.h.a(this.q.j);
        this.h.b(this.q.k);
        this.h.a(this.q.l);
        this.h.c(this.q.m);
        this.h.d(this.q.n);
        this.h.e(this.q.o);
        this.h.f(this.q.q);
        this.h.a(this.q.p);
        this.h.a(bVar);
        this.h.c();
    }

    public void a(com.baidu.mobads.container.util.g.b bVar) {
        if (this.h != null) {
            this.h.a(bVar);
        }
    }

    public void b(com.baidu.mobads.container.util.g.b bVar) {
        if (this.h != null) {
            this.h.b(bVar);
        }
    }

    public void i() {
        this.i = false;
        com.baidu.mobads.container.util.g.c cVar = this.h;
        if (cVar != null) {
            cVar.a();
        }
    }

    private void t() {
        com.baidu.mobads.container.util.g.c cVar = this.h;
        if (cVar != null && getParent() != null && !this.i) {
            cVar.a();
        }
    }

    public void j() {
        this.i = true;
        u();
    }

    private void u() {
        com.baidu.mobads.container.util.g.c cVar = this.h;
        if (cVar != null) {
            cVar.b();
        }
    }

    public void k() {
        try {
            t();
            com.baidu.mobads.container.util.g.c cVar = this.h;
            if (cVar != null) {
                cVar.c();
            }
            com.baidu.mobads.container.util.h.a(new aj(this));
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.e(b, "shake start: ", th);
        }
    }

    public void l() {
        try {
            u();
            com.baidu.mobads.container.util.g.c cVar = this.h;
            if (cVar != null) {
                cVar.d();
            }
            com.baidu.mobads.container.util.h.a(new ak(this));
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.e(b, "shake close: ", th);
        }
    }

    public void m() {
        l();
        a((View) null);
        this.d = null;
        this.h = null;
    }

    public Animator n() {
        try {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.a, "rotation", 0.0f, -7.5f, -15.0f, 40.0f, 10.0f, -20.0f, 15.0f, -5.0f, 0.0f, 0.0f, 0.0f, 0.0f);
            objectAnimatorOfFloat.setRepeatCount(-1);
            this.e = new AnimatorSet();
            this.e.play(objectAnimatorOfFloat);
            this.e.setDuration(1300L);
            this.e.start();
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.e(b, "animation start: ", th);
        }
        return this.e;
    }

    @Override // com.component.a.d.c, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.j != null) {
            this.j.a((View) this, i);
        }
    }

    @Override // com.component.a.d.c, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        k();
        if (this.j != null) {
            this.j.e(this);
        }
    }

    @Override // com.component.a.d.c, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l();
        if (this.j != null) {
            this.j.f(this);
        }
    }

    @Override // com.component.a.d.c, android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.j != null) {
            this.j.b(view, i);
        }
    }

    public void a(float f) {
        if (this.q.G == 1) {
            if (this.l != null) {
                this.l.a(f);
            }
        } else if (this.k != null) {
            this.k.a(f);
        }
    }

    public static class b {
        private String A;
        private String s;
        private Typeface w;
        private int g = 2;
        private int h = 60;
        private float i = 7.0f;
        private int j = 190;
        private int k = 1;
        private float l = 6.0f;
        private float m = 0.0f;
        private float n = 0.0f;
        private float o = 4.0f;
        private boolean p = false;
        private float q = 35.0f;
        private String r = "ad_click";
        private String t = "摇动手机  了解更多";
        private int u = 14;
        private int v = -1;
        private int x = -6710887;
        private float y = 76.5f;
        private boolean z = true;
        private boolean B = true;
        private boolean C = false;
        private int D = 0;
        private int E = 2000;
        private boolean F = false;
        private int G = 1;
        private int H = 67;
        protected int a = -16777216;
        protected String b = "";
        protected int c = 165;
        protected int d = 165;
        protected int e = 4;
        protected int f = 11;

        public b a(int i) {
            this.f = i;
            return this;
        }

        public b b(int i) {
            this.e = i;
            return this;
        }

        public b c(int i) {
            this.d = i;
            return this;
        }

        public b d(int i) {
            this.c = i;
            return this;
        }

        public b a(String str) {
            this.b = str;
            return this;
        }

        public b a(boolean z) {
            this.F = z;
            return this;
        }

        public b e(int i) {
            this.G = i;
            return this;
        }

        public b f(int i) {
            if (i > 0) {
                this.g = i;
            }
            return this;
        }

        public b g(int i) {
            if (i > 0) {
                this.h = i;
            }
            return this;
        }

        public b a(float f) {
            this.i = f;
            return this;
        }

        public b b(String str) {
            this.r = str;
            return this;
        }

        public b c(String str) {
            this.s = str;
            return this;
        }

        public b d(String str) {
            this.t = str;
            return this;
        }

        public b h(int i) {
            this.a = i;
            return this;
        }

        public b i(int i) {
            if (i > 0) {
                this.H = i;
            }
            return this;
        }

        public b j(int i) {
            if (i > 0) {
                this.u = i;
            }
            return this;
        }

        public b k(int i) {
            if (i > 0) {
                this.v = i;
            }
            return this;
        }

        public b a(Typeface typeface) {
            this.w = typeface;
            return this;
        }

        public b l(int i) {
            if (i > 0) {
                this.x = i;
            }
            return this;
        }

        public b b(float f) {
            if (f > 0.0f) {
                this.y = f;
            }
            return this;
        }

        public b m(int i) {
            if (i == 1) {
                this.z = true;
            } else {
                this.z = false;
            }
            return this;
        }

        public b e(String str) {
            this.A = str;
            return this;
        }

        public b b(boolean z) {
            this.B = z;
            return this;
        }

        public b c(boolean z) {
            this.C = z;
            return this;
        }

        public b n(int i) {
            this.j = i;
            return this;
        }

        public b o(int i) {
            this.k = i;
            return this;
        }

        public b c(float f) {
            this.l = f;
            return this;
        }

        public b d(float f) {
            this.m = f;
            return this;
        }

        public b e(float f) {
            this.n = f;
            return this;
        }

        public b d(boolean z) {
            this.p = z;
            return this;
        }

        public b f(float f) {
            this.q = f;
            return this;
        }

        public b g(float f) {
            this.o = f;
            return this;
        }

        public b p(int i) {
            this.D = i;
            return this;
        }

        public b q(int i) {
            this.E = i;
            return this;
        }
    }
}

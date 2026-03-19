package com.component.a.g.c;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.baidu.mobads.container.util.ab;
import com.baidu.mobads.container.util.animation.a;
import com.component.a.g.c.e;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class m extends com.component.a.g.c.e {

    public interface e {
        void a(boolean z);
    }

    public static abstract class b extends com.component.a.d.c {
        protected int a;
        protected int b;
        protected int d;
        protected int e;
        protected int f;
        protected int g;
        protected a h;
        boolean i;
        private boolean j;

        public interface a {
            void a(int i, int i2);

            void b(int i, int i2);
        }

        public abstract void a(boolean z);

        protected abstract void c(int i, int i2);

        public abstract void d();

        public abstract void e();

        public abstract void f();

        public abstract void g();

        public abstract void h();

        public b(Context context, com.component.a.f.e eVar) {
            super(context, eVar);
            this.f = 0;
            this.g = 0;
            this.j = false;
            this.i = eVar.e(-1) == 1;
        }

        public boolean i() {
            return this.i;
        }

        public void a(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            double d = i;
            double d2 = i2;
            Double.isNaN(d);
            Double.isNaN(d2);
            this.d = Math.max(1, Math.min((int) Math.ceil(d / d2), i3));
        }

        public void b(int i) {
            int i2;
            if (!this.i || j()) {
                return;
            }
            f();
            this.e = Math.min(i, this.a);
            if (this.f < this.d - 1) {
                double d = this.e - (this.b * this.f);
                double d2 = this.b;
                Double.isNaN(d2);
                if (d >= d2 * 0.9d) {
                    a();
                }
                if (this.e >= this.b * (this.f + 1)) {
                    b();
                }
            } else {
                double d3 = this.e - (this.b * (this.d - 1));
                double d4 = this.a - (this.b * (this.d - 1));
                Double.isNaN(d4);
                if (d3 >= d4 * 0.9d) {
                    a();
                }
                if (this.e >= this.a) {
                    b();
                }
            }
            if (this.f < this.d - 1) {
                i2 = ((this.f + 1) * this.b) - this.e;
            } else {
                i2 = this.a - this.e;
            }
            c(i2, Math.min(this.f + 1, this.d));
        }

        public boolean j() {
            if (this.a == 0 || this.b == 0) {
                return true;
            }
            int i = this.f;
            double d = this.a;
            double d2 = this.b;
            Double.isNaN(d);
            Double.isNaN(d2);
            return i >= ((int) Math.ceil(d / d2));
        }

        protected boolean k() {
            return this.j;
        }

        public void b(boolean z) {
            this.j = z;
        }

        private void a() {
            if (this.g <= this.f && this.g < this.d) {
                this.g++;
                if (this.h != null) {
                    this.h.a(this.e, this.f);
                }
            }
        }

        private void b() {
            if (this.f <= this.d - 1) {
                this.f++;
                d(this.e, this.f - 1);
            }
        }

        protected void d(int i, int i2) {
            if (this.h != null) {
                this.h.b(i, i2);
            }
        }

        public void a(a aVar) {
            this.h = aVar;
        }
    }

    public static class f extends b {
        private a j;
        private a k;
        private com.component.a.d.c l;
        private com.component.a.d.c m;
        private com.component.a.a.q n;
        private com.component.feed.ax o;
        private com.component.a.a.f p;
        private com.component.a.a.q q;

        public f(Context context, com.component.a.f.e eVar) {
            super(context, eVar);
        }

        abstract class a extends c {
            protected final com.component.a.a.q e;

            public a(ViewGroup viewGroup) {
                super(viewGroup);
                this.e = (com.component.a.a.q) com.component.a.g.c.e.findViewByName(com.component.a.i.n.a(viewGroup), "segmented_countdown_text_hint_text", com.component.a.a.q.class);
            }

            public a(ViewGroup viewGroup, com.component.feed.ax axVar, com.component.a.a.f fVar, com.component.a.a.q qVar) {
                super(viewGroup, axVar, fVar);
                this.e = qVar;
            }

            public String a() {
                return com.component.a.i.f.c((View) this.e).o("");
            }

            public void a(CharSequence charSequence) {
                if (this.e != null) {
                    this.e.setText(charSequence);
                }
            }

            public void b(boolean z) {
                if (z) {
                    Paint paint = new Paint();
                    paint.setTextSize(this.e.getTextSize());
                    paint.setTextAlign(this.e.getPaint().getTextAlign());
                    paint.setTypeface(this.e.getTypeface());
                    float fMeasureText = paint.measureText(a());
                    ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
                    layoutParams.width = (int) fMeasureText;
                    this.e.setLayoutParams(layoutParams);
                    return;
                }
                ViewGroup.LayoutParams layoutParams2 = this.e.getLayoutParams();
                layoutParams2.width = -2;
                this.e.setLayoutParams(layoutParams2);
            }

            @Override // com.component.a.g.c.m.c
            public void a(boolean z) {
                if (this.c != null) {
                    if (!com.component.a.i.w.a(this.c) || f.this.k()) {
                        this.c.setAlpha(0.5f);
                    } else {
                        com.baidu.mobads.container.util.animation.a.a(this.c).a(200).b("1").c("0.5").a(a.b.ALPHA).i();
                    }
                }
                if (this.e != null) {
                    if (!com.component.a.i.w.a(this.e) || f.this.k()) {
                        this.e.setAlpha(0.5f);
                    } else {
                        com.baidu.mobads.container.util.animation.a.a(this.e).a(200).b("1").c("0.5").a(a.b.ALPHA).i();
                    }
                }
            }
        }

        @Override // com.component.a.g.c.m.b
        public void d() {
            Map<View, com.component.a.f.e> mapA = com.component.a.i.n.a(this);
            this.l = (com.component.a.d.c) com.component.a.g.c.e.findViewByName(mapA, "segmented_countdown_first_text_hint", com.component.a.d.c.class);
            this.m = (com.component.a.d.c) com.component.a.g.c.e.findViewByName(mapA, "segmented_countdown_second_text_hint", com.component.a.d.c.class);
            this.n = (com.component.a.a.q) com.component.a.g.c.e.findViewByName(mapA, "segmented_countdown_second_text_label", com.component.a.a.q.class);
            this.o = (com.component.feed.ax) com.component.a.g.c.e.findViewByName(mapA, "segmented_countdown_second_hint_icon", com.component.feed.ax.class);
            this.p = (com.component.a.a.f) com.component.a.g.c.e.findViewByName(mapA, "segmented_countdown_second_checkmark", com.component.a.a.f.class);
            this.q = (com.component.a.a.q) com.component.a.g.c.e.findViewByName(mapA, "segmented_countdown_second_text_hint_text", com.component.a.a.q.class);
            this.j = new t(this, this.l);
            this.k = new u(this, this.m, this.o, this.p, this.q);
        }

        @Override // com.component.a.g.c.m.b
        public void a(boolean z) {
            this.j.b(z);
            this.k.b(z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (this.m != null && this.d > 1) {
                if (!com.component.a.i.w.a(this.m) || k()) {
                    this.m.setVisibility(0);
                    this.m.setAlpha(1.0f);
                } else {
                    com.baidu.mobads.container.util.animation.a.a(this.m).a(200).a(new JSONArray().put("alpha")).a(a.b.ENTER).i();
                }
            }
        }

        @Override // com.component.a.g.c.m.b
        public void e() {
        }

        @Override // com.component.a.g.c.m.b
        public void f() {
        }

        @Override // com.component.a.g.c.m.b
        public void g() {
        }

        @Override // com.component.a.g.c.m.b
        public void h() {
        }

        @Override // com.component.a.g.c.m.b
        protected void d(int i, int i2) {
            if (i2 == 0) {
                this.j.a(false, k());
            } else {
                this.k.a(false, k());
            }
            super.d(i, i2);
        }

        @Override // com.component.a.g.c.m.b
        protected void c(int i, int i2) {
            double d = i;
            Double.isNaN(d);
            String strValueOf = String.valueOf((int) Math.round(d / 1000.0d));
            if (this.f == 0) {
                this.j.a(this.j.a().replace("XX", strValueOf));
            } else if (this.f == 1) {
                this.k.a(this.k.a().replace("XX", strValueOf));
            }
        }
    }

    public static class d extends b {
        private com.component.a.a.f j;
        private com.component.a.a.f k;
        private com.component.a.d.c l;
        private com.component.a.a.q m;
        private com.component.a.d.c n;
        private c o;
        private com.component.a.a.q p;
        private String q;

        public d(Context context, com.component.a.f.e eVar) {
            super(context, eVar);
        }

        @Override // com.component.a.g.c.m.b
        public void d() {
            Map<View, com.component.a.f.e> mapA = com.component.a.i.n.a(this);
            this.j = (com.component.a.a.f) com.component.a.g.c.e.findViewByName(mapA, "segmented_countdown_gift_box", com.component.a.a.f.class);
            this.k = (com.component.a.a.f) com.component.a.g.c.e.findViewByName(mapA, "segmented_countdown_gift_progress", com.component.a.a.f.class);
            this.l = (com.component.a.d.c) com.component.a.g.c.e.findViewByName(mapA, "segmented_countdown_gift_bubble", com.component.a.d.c.class);
            this.m = (com.component.a.a.q) com.component.a.g.c.e.findViewByName(mapA, "segmented_countdown_gift_bubble_text", com.component.a.a.q.class);
            this.q = com.component.a.i.f.c((View) this.m).o("");
            this.n = (com.component.a.d.c) com.component.a.g.c.e.findViewByName(mapA, "segmented_countdown_gift_hint", com.component.a.d.c.class);
            this.p = (com.component.a.a.q) com.component.a.g.c.e.findViewByName(mapA, "segmented_countdown_gift_hint_text", com.component.a.a.q.class);
            this.o = new q(this, this.n);
        }

        @Override // com.component.a.g.c.m.b
        public void a(boolean z) {
            if (z) {
                Paint paint = new Paint();
                paint.setTextSize(this.p.getTextSize());
                paint.setTextAlign(this.p.getPaint().getTextAlign());
                paint.setTypeface(this.p.getTypeface());
                float fMeasureText = paint.measureText("已领取");
                ViewGroup.LayoutParams layoutParams = this.p.getLayoutParams();
                layoutParams.width = (int) fMeasureText;
                this.p.setLayoutParams(layoutParams);
                Paint paint2 = new Paint();
                paint2.setTextSize(this.m.getTextSize());
                paint2.setTextAlign(this.m.getPaint().getTextAlign());
                paint2.setTypeface(this.m.getTypeface());
                float fMax = 0.0f;
                for (String str : this.q.split("\n")) {
                    fMax = Math.max(fMax, paint2.measureText(str));
                }
                ViewGroup.LayoutParams layoutParams2 = this.m.getLayoutParams();
                layoutParams2.width = (int) fMax;
                this.m.setLayoutParams(layoutParams2);
                return;
            }
            ViewGroup.LayoutParams layoutParams3 = this.p.getLayoutParams();
            layoutParams3.width = -2;
            this.p.setLayoutParams(layoutParams3);
            ViewGroup.LayoutParams layoutParams4 = this.m.getLayoutParams();
            layoutParams4.width = -2;
            this.m.setLayoutParams(layoutParams4);
        }

        @Override // com.component.a.g.c.m.b
        public void e() {
            if (this.j != null) {
                this.j.f();
            }
            if (this.k != null) {
                this.k.f();
            }
        }

        @Override // com.component.a.g.c.m.b
        public void f() {
            if (this.j != null && !this.j.p()) {
                this.j.g();
            }
            if (this.k != null && !this.k.p()) {
                this.k.g();
            }
        }

        @Override // com.component.a.g.c.m.b
        public void g() {
            if (this.j != null) {
                this.j.t();
            }
            if (this.k != null) {
                this.k.t();
            }
        }

        @Override // com.component.a.g.c.m.b
        public void h() {
            if (this.j != null) {
                this.j.s();
            }
            if (this.k != null) {
                this.k.s();
            }
        }

        @Override // com.component.a.g.c.m.b
        protected void c(int i, int i2) {
            int i3;
            String str;
            double d = i;
            Double.isNaN(d);
            String strValueOf = String.valueOf((int) Math.round(d / 1000.0d));
            if (this.m != null && this.q != null) {
                this.m.setText(this.q.replace("XX", strValueOf));
            }
            if (this.p != null) {
                if (this.f >= this.d) {
                    str = "已领取";
                } else if (this.d == 1) {
                    str = strValueOf + "s";
                } else {
                    str = i2 + "/" + this.d;
                }
                this.p.setText(str);
            }
            if (this.k != null) {
                if (this.f >= this.d) {
                    com.baidu.mobads.container.util.h.a(new r(this));
                    return;
                }
                if (this.f == this.d - 1) {
                    i3 = this.a - ((this.d - 1) * this.b);
                } else {
                    i3 = this.b;
                }
                this.k.d(1.0f - (i / i3));
            }
        }

        @Override // com.component.a.g.c.m.b
        protected void d(int i, int i2) {
            boolean z = i2 >= this.d - 1;
            c(z);
            if (this.o != null) {
                this.o.a(!z, k());
            }
            if (z && this.j != null && this.k != null) {
                com.baidu.mobads.container.util.h.a(new s(this));
            }
            super.d(i, i2);
        }

        private void c(boolean z) {
            if (this.d == 1) {
                return;
            }
            if (this.m != null && z) {
                this.q = "恭喜您\n已领取全部奖励～";
                this.m.setText(this.q);
            }
            if (this.l == null || !com.component.a.i.w.a(this.l) || k()) {
                return;
            }
            com.baidu.mobads.container.util.animation.a aVarA = com.baidu.mobads.container.util.animation.a.a(this.l).a(320).b("0.1").c("1").a(new AccelerateDecelerateInterpolator()).a(a.b.SCALE);
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVarA);
            float width = this.l.getWidth();
            float x = this.l.getX();
            if (width != 0.0f && x != 0.0f) {
                arrayList.add(com.baidu.mobads.container.util.animation.a.a(this.l).a(320).b(String.valueOf(x - (width / 2.0f))).c(String.valueOf(x)).a(new AccelerateDecelerateInterpolator()).a(a.b.ABSOLUTE_X));
            }
            arrayList.add(com.baidu.mobads.container.util.animation.a.a(this.l).a(50).b("0").c("1").a(a.b.ALPHA));
            com.baidu.mobads.container.util.animation.j.c(com.baidu.mobads.container.util.animation.a.a(this.l).a(arrayList).a(a.b.GROUP));
            com.baidu.mobads.container.util.animation.a.a(this.l).b(3320).a(200).a(new JSONArray().put("alpha")).a(a.b.EXIT).i();
        }
    }

    public static abstract class c {
        protected final ViewGroup a;
        protected final com.component.feed.ax b;
        protected final com.component.a.a.f c;

        public abstract void a(boolean z);

        public c(ViewGroup viewGroup) {
            this.a = viewGroup;
            Map<View, com.component.a.f.e> mapA = com.component.a.i.n.a(viewGroup);
            this.b = (com.component.feed.ax) com.component.a.g.c.e.findViewByName(mapA, "segmented_countdown_hint_icon", com.component.feed.ax.class);
            this.c = (com.component.a.a.f) com.component.a.g.c.e.findViewByName(mapA, "segmented_countdown_checkmark", com.component.a.a.f.class);
        }

        public c(ViewGroup viewGroup, com.component.feed.ax axVar, com.component.a.a.f fVar) {
            this.a = viewGroup;
            this.b = axVar;
            this.c = fVar;
        }

        public void a(boolean z, boolean z2) {
            if (this.c != null && this.b != null) {
                this.b.setVisibility(4);
                this.c.setVisibility(0);
                if (!com.component.a.i.w.a(this.c) || z2) {
                    if (!z) {
                        this.c.setVisibility(0);
                        this.b.setVisibility(4);
                        this.c.d(1.0f);
                        a(false);
                        return;
                    }
                    return;
                }
                this.c.a(new p(this, z));
                this.c.f();
            }
        }
    }

    public static class a extends b {
        private final e.a j;
        private final com.component.a.f.e k;
        private final com.baidu.mobads.container.adrequest.j l;
        private com.component.a.a.q m;
        private View n;
        private String o;
        private int p;
        private int q;
        private boolean r;
        private e s;

        public a(Context context, e.a aVar, com.component.a.f.e eVar, com.baidu.mobads.container.adrequest.j jVar) {
            super(context, eVar);
            this.o = "";
            this.p = 0;
            this.q = 5000;
            this.r = true;
            this.j = aVar;
            this.k = eVar;
            this.l = jVar;
            JSONObject jSONObjectC = eVar.c();
            this.p = jSONObjectC.optInt("delay_time", this.p);
            this.q = jSONObjectC.optInt(com.baidu.mobads.container.adrequest.n.m, this.q);
            this.r = jSONObjectC.optInt("dc_sc_off", 0) == 0;
            a(this.p + this.q, Math.max(1, this.p), 2);
        }

        public int a() {
            return this.p;
        }

        public int b() {
            return this.q;
        }

        public void a(e eVar) {
            this.s = eVar;
        }

        public void c() {
            this.i = false;
            this.f = 3;
            setVisibility(8);
        }

        @Override // com.component.a.d.c, android.view.View
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (this.s != null) {
                this.s.a(z);
            }
        }

        @Override // com.component.a.g.c.m.b
        public void d() {
            setVisibility(8);
            Map<View, com.component.a.f.e> mapA = com.component.a.i.n.a(this);
            this.m = (com.component.a.a.q) com.component.a.g.c.e.findViewByName(mapA, "dc_first_text", com.component.a.a.q.class);
            this.n = com.component.a.g.c.e.findViewByName(mapA, "dc_close");
            if (this.n != null) {
                this.n.setOnClickListener(new o(this));
            }
            this.o = com.component.a.i.f.c((View) this.m).o("");
            if (TextUtils.isEmpty(this.o)) {
                ab.a aVarA = com.baidu.mobads.container.util.ab.a(getContext(), this.l);
                String appName = this.l.getAppName();
                switch (aVarA) {
                    case APP_DOWNLOAD:
                        if (TextUtils.isEmpty(appName)) {
                            this.o = "为您下载APP";
                            break;
                        } else {
                            this.o = "为您下载“" + appName + "”";
                            break;
                        }
                    case DEEP_LINK:
                        if (TextUtils.isEmpty(appName)) {
                            this.o = "为您打开第三方应用";
                            break;
                        } else {
                            this.o = "为您打开“" + appName + "”";
                            break;
                        }
                    default:
                        this.o = "带您进入详情页";
                        break;
                }
            }
        }

        @Override // com.component.a.g.c.m.b
        public void a(boolean z) {
            String str;
            if (this.m != null) {
                if (z) {
                    if (this.r) {
                        str = "XX秒后" + this.o;
                    } else {
                        str = this.o;
                    }
                    Paint paint = new Paint();
                    paint.setTextSize(this.m.getTextSize());
                    paint.setTextAlign(this.m.getPaint().getTextAlign());
                    paint.setTypeface(this.m.getTypeface());
                    float fMeasureText = paint.measureText(str);
                    ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
                    layoutParams.width = (int) fMeasureText;
                    this.m.setLayoutParams(layoutParams);
                    return;
                }
                ViewGroup.LayoutParams layoutParams2 = this.m.getLayoutParams();
                layoutParams2.width = -2;
                this.m.setLayoutParams(layoutParams2);
            }
        }

        @Override // com.component.a.g.c.m.b
        public void e() {
        }

        @Override // com.component.a.g.c.m.b
        public void f() {
        }

        @Override // com.component.a.g.c.m.b
        public void g() {
        }

        @Override // com.component.a.g.c.m.b
        public void h() {
        }

        @Override // com.component.a.g.c.m.b
        protected void c(int i, int i2) {
            String str;
            String strValueOf = String.valueOf((i + 800) / 1000);
            if (this.m != null) {
                if (this.r) {
                    str = strValueOf + "秒后" + this.o;
                } else {
                    str = this.o;
                }
                this.m.setText(str);
            }
        }

        @Override // com.component.a.g.c.m.b
        protected void d(int i, int i2) {
            super.d(i, i2);
            if (i2 == 0) {
                setVisibility(0);
                return;
            }
            if (i2 == 1 && getVisibility() == 0) {
                if (hasWindowFocus() && com.baidu.mobads.container.util.r.d(this) == 0) {
                    com.component.a.f.d dVar = new com.component.a.f.d(this.n, "click", this.k);
                    dVar.a(3);
                    dVar.a(this.k.l(""), this.k.m(""));
                    this.j.a(dVar);
                }
                setVisibility(8);
            }
        }
    }

    public m(Context context, com.baidu.mobads.container.adrequest.j jVar, e.a aVar) {
        super(context, jVar, aVar);
    }

    @Override // com.component.a.g.c.e
    public View onPrepareView(View view, com.component.a.f.e eVar) {
        if (eVar == null) {
            return super.onPrepareView(view, null);
        }
        String strM = eVar.m("");
        if (TextUtils.equals("segmented_countdown_text", strM)) {
            return new f(this.mAppContext, eVar);
        }
        if (TextUtils.equals("segmented_countdown_gift", strM)) {
            return new d(this.mAppContext, eVar);
        }
        if (TextUtils.equals("dc_view", strM)) {
            return new a(this.mAppContext, this.mFlyweight, eVar, this.mAdInfo);
        }
        return super.onPrepareView(view, eVar);
    }

    @Override // com.component.a.g.c.e
    public void onCreateView(com.component.a.f.d dVar) {
        if (dVar == null) {
            return;
        }
        com.component.a.f.e eVarF = dVar.f();
        View viewE = dVar.e();
        if (eVarF == null || viewE == null) {
            return;
        }
        eVarF.m("");
        if (viewE instanceof b) {
            ((b) viewE).d();
        }
    }
}

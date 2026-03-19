package com.style.widget.e;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.nativecpu.AbstractData;
import com.baidu.mobads.container.o.j;
import com.baidu.mobads.container.util.bv;
import com.baidu.mobads.container.util.cf;
import com.component.a.f.e;
import com.component.a.g.c.bm;
import com.component.a.g.c.m;
import com.component.a.g.d;
import com.component.feed.ae;
import com.component.feed.ax;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class f extends d.c {
    private static final String c = "gesture_view";
    private static final String d = "barrage_view";
    private View C;
    private final a E;
    private final com.component.a.b.e I;
    private View J;
    ObjectAnimator b;
    private final com.baidu.mobads.container.adrequest.j e;
    private final com.baidu.mobads.container.a.a f;
    private final String g;
    private final int h;
    private final int j;
    private w k;
    private View l;
    private View m;
    private View n;
    private View o;
    private View p;
    private ae q;
    private e r;
    private m.d t;
    private m.f u;
    private View x;
    private View y;
    private String s = "";
    private int v = -1;
    private int w = 0;
    Handler a = new Handler();
    private boolean z = false;
    private int A = 1;
    private int B = 1;
    private final ArrayList<b> D = new ArrayList<>();
    private final Handler F = new Handler(Looper.getMainLooper());
    private final Runnable G = new g(this);
    private long H = 0;

    /* renamed from: K, reason: collision with root package name */
    private boolean f798K = false;
    private final int i = k();

    public interface a {
        void a(String str, com.component.a.f.d dVar);

        boolean a(com.component.a.f.d dVar);
    }

    static /* synthetic */ long a(f fVar, long j) {
        long j2 = fVar.H + j;
        fVar.H = j2;
        return j2;
    }

    public f(com.baidu.mobads.container.k kVar, com.baidu.mobads.container.adrequest.j jVar, a aVar) {
        this.e = jVar;
        this.f = new com.baidu.mobads.container.a.a(kVar, jVar);
        this.h = jVar.getFeedAdStyleType();
        this.g = jVar.getMaterialType();
        this.j = jVar.getFeedExpressStyleType();
        this.E = aVar;
        kVar.getAdContainerContext().s().addEventListener(com.baidu.mobads.container.components.k.b.F, new j(this));
        this.I = new k(this, "ad");
        l lVar = new l(this);
        this.I.a("pause_video", lVar);
        this.I.a("resume_video", lVar);
    }

    public void a(View view) {
        this.J = view;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.component.a.g.d.c
    public void a(View view, String str, String str2) {
        int iOptInt;
        List<com.component.a.f.e> listO;
        List<com.component.a.f.e> listO2;
        if ("video_view".equals(str2)) {
            if (view instanceof com.component.a.a.r) {
                a((com.component.a.a.r) view);
                return;
            }
            if ((view instanceof ax) && l()) {
                if (!TextUtils.isEmpty(this.e.getMainPictureUrl())) {
                    ax axVar = (ax) view;
                    axVar.a(true);
                    axVar.a(1);
                    axVar.b(true);
                    axVar.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    return;
                }
                Integer numA = com.component.b.a.a().a("bg_blur_white");
                if (numA != null) {
                    ((ax) view).setImageResource(numA.intValue());
                    return;
                } else {
                    view.setBackgroundColor(-16777216);
                    return;
                }
            }
            return;
        }
        if ("tail_view".equals(str2)) {
            view.setVisibility(8);
            if (this.k != null) {
                this.k.c(view);
                return;
            } else {
                this.l = view;
                return;
            }
        }
        if ("video_cover".equals(str2)) {
            view.setVisibility(8);
            if (this.k != null) {
                this.k.b(view);
                return;
            } else {
                this.m = view;
                return;
            }
        }
        if ("mute_view".equals(str2)) {
            if ("true".equals(this.e.getMute())) {
                com.component.b.a.a().a((ImageView) view, "ic_white_voice_mute");
                return;
            } else {
                com.component.b.a.a().a((ImageView) view, "ic_white_voice");
                return;
            }
        }
        if (c.equals(str2)) {
            if (view.getVisibility() != 0) {
                return;
            }
            this.n = view;
            if ("video".equals(this.g)) {
                view.setVisibility(4);
                if (this.k != null) {
                    this.k.a(view, 3, 3000, true);
                } else {
                    this.s = c;
                }
            }
            com.component.a.i.f fVarA = com.component.a.i.f.a(view);
            if (fVarA != null) {
                try {
                    if (fVarA.b() != null && (listO = fVarA.b().o()) != null && listO.size() > 0) {
                        for (com.component.a.f.e eVar : listO) {
                            if (eVar.e(1) != 1 && (listO2 = eVar.o()) != null && listO2.size() > 0) {
                                Iterator<com.component.a.f.e> it = listO2.iterator();
                                while (it.hasNext()) {
                                    if (TextUtils.equals(it.next().m(""), "gesture_lottie")) {
                                        this.n.setAlpha(0.0f);
                                    }
                                }
                            }
                        }
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            }
            return;
        }
        boolean z = view instanceof com.component.a.d.c;
        if (z) {
            com.component.a.d.c cVar = (com.component.a.d.c) view;
            if (cVar.p()) {
                com.component.a.i.f lifeCycle = cVar.getLifeCycle();
                if (lifeCycle != null && lifeCycle.b() != null) {
                    String[] strArr = new String[3];
                    JSONObject jSONObjectC = lifeCycle.b().c();
                    if (jSONObjectC != null) {
                        strArr[0] = jSONObjectC.optString("slide_dir", "0");
                        strArr[1] = jSONObjectC.optString("slide_check", "");
                        strArr[2] = jSONObjectC.optString("slide_angle", "");
                    }
                    com.baidu.mobads.container.adrequest.n.a(this.e, "slide_view".equals(str2) ? j.a.TEMPLATE_SLIDE_VIEW.b() : 1024, strArr);
                    return;
                }
                return;
            }
        }
        if (d.equals(str2)) {
            if ((view instanceof com.component.a.a.a) && "video".equals(this.g)) {
                view.setVisibility(4);
                if (this.k != null) {
                    this.k.a(view, -1, 0, false);
                    return;
                } else {
                    this.o = view;
                    this.s = d;
                    return;
                }
            }
            return;
        }
        if ("dc_container".equals(str2)) {
            if (this.r != null) {
                this.r.b(view);
                return;
            }
            return;
        }
        if ("dc_view".equals(str2) && (view instanceof m.a)) {
            m.a aVar = (m.a) view;
            if (aVar.i()) {
                this.r = new e();
                this.r.a(aVar);
                com.baidu.mobads.container.adrequest.n.a(this.e, j.a.DC_VIEW.b(), "" + aVar.a(), "" + aVar.b());
                return;
            }
            return;
        }
        if (bm.b.equals(str2) && (view instanceof ae)) {
            this.q = (ae) view;
            this.q.setVisibility(4);
            this.q.j();
            com.baidu.mobads.container.adrequest.n.e(this.e, str2, com.baidu.mobads.container.o.j.a(str2, view));
            return;
        }
        if ("segmented_countdown_gift".equals(str2) && (view instanceof m.d) && view.getVisibility() == 0) {
            this.t = (m.d) view;
            return;
        }
        if ("segmented_countdown_text".equals(str2)) {
            if ((view instanceof m.f) && view.getVisibility() == 0) {
                this.u = (m.f) view;
                return;
            }
            return;
        }
        if ("notice_view".equals(str2)) {
            if (z) {
                this.x = view;
                try {
                    this.v = a((com.component.a.c.c) view).c().optInt(com.baidu.mobads.container.adrequest.n.m, this.v);
                } catch (Throwable th2) {
                }
                cf.a(this.x, new m(this));
                m();
                return;
            }
            return;
        }
        if ("dislike_view".equals(str2)) {
            if (view instanceof com.component.a.c.c) {
                try {
                    JSONObject jSONObjectC2 = a((com.component.a.c.c) view).c();
                    this.z = 1 == jSONObjectC2.optInt("px_close", 0);
                    this.A = jSONObjectC2.optInt("px_close_w", 1) > 0 ? jSONObjectC2.optInt("px_close_w", 1) : this.A;
                    if (jSONObjectC2.optInt("px_close_h", 1) > 0) {
                        iOptInt = jSONObjectC2.optInt("px_close_h", 1);
                    } else {
                        iOptInt = this.B;
                    }
                    this.B = iOptInt;
                    if (this.z) {
                        com.baidu.mobads.container.adrequest.n.a(this.e, j.a.PX_CLOSE.b(), "" + this.A, "" + this.B);
                        cf.a(view, new n(this, view, this.e.getUniqueId()));
                        return;
                    }
                    return;
                } catch (Throwable th3) {
                    return;
                }
            }
            return;
        }
        if ("coupon_flip_page".equals(str2) && view != 0) {
            this.C = view;
            com.baidu.mobads.container.adrequest.n.e(this.e, str2, com.baidu.mobads.container.o.j.f(str2, view));
            return;
        }
        if ("coupon_float".equals(str2) && (view instanceof com.component.a.c.c)) {
            this.p = view;
            int iA = bv.a(view.getContext(), com.component.a.i.f.c(view).b(124));
            View viewA = com.component.a.i.n.a(com.component.a.i.n.a(view), "coupon_float_card_text");
            view.addOnLayoutChangeListener(new p(this, com.component.a.i.f.c(viewA).g().c(10), iA, viewA));
            com.baidu.mobads.container.adrequest.n.e(this.e, str2, com.baidu.mobads.container.o.j.a(this.e.getOriginJsonObject(), str2, view));
            return;
        }
        if ("dynamic_barrage".equals(str2)) {
            a(str2, view);
            com.baidu.mobads.container.adrequest.n.e(this.e, str2, com.baidu.mobads.container.o.j.h(str2, view));
            return;
        }
        if ("bubble_widget".equals(str2)) {
            a(str2, view);
            com.baidu.mobads.container.adrequest.n.e(this.e, str2, com.baidu.mobads.container.o.j.g(str2, view));
            return;
        }
        if ("bookmark".equals(str2)) {
            if ("feed_native_template".equals(this.e.getTemplateId())) {
                com.baidu.mobads.container.adrequest.n.a(this.e, j.a.FEED_BOOKMARK.b(), new String[0]);
                return;
            } else {
                com.baidu.mobads.container.adrequest.n.a(this.e, j.a.BOOKMARK.b(), new String[0]);
                return;
            }
        }
        if ("easter_egg".equals(str2)) {
            com.baidu.mobads.container.adrequest.n.e(this.e, str2, com.baidu.mobads.container.o.j.b(str2, view));
        } else if ("one_purchase".equals(str2)) {
            com.baidu.mobads.container.adrequest.n.e(this.e, str2, com.baidu.mobads.container.o.j.n(str2, view));
        } else if ("coupon_discount".equals(str2)) {
            com.baidu.mobads.container.adrequest.n.e(this.e, str2, com.baidu.mobads.container.o.j.o(str2, view));
        }
    }

    @Override // com.component.a.g.d.c
    public void a(View view, String str) {
        com.component.a.f.e eVarB;
        super.a(view, str);
        if ("volume".equals(str) && (view instanceof ImageView)) {
            if (this.k != null) {
                if (this.k.g()) {
                    this.k.b(false);
                    com.component.b.a.a().a((ImageView) view, "ic_white_voice");
                } else {
                    this.k.b(true);
                    com.component.b.a.a().a((ImageView) view, "ic_white_voice_mute");
                }
            }
        } else if ("replay".equals(str)) {
            if (this.k != null) {
                this.k.i(8);
                this.k.l();
            }
        } else if ("ad_click".equals(str) || com.component.a.g.b.j.equals(str)) {
            if (this.r != null) {
                this.r.a();
                this.r = null;
            }
            if (this.y != null) {
                this.y.setVisibility(8);
                this.y = null;
            }
            if (this.C != null) {
                this.C.setVisibility(8);
                this.C = null;
            }
        } else if ("dislike".equals(str) || "close".equals(str)) {
            if ("close".equals(str) && "coupon_float_close_view".equals(com.component.a.i.f.c(view).m(""))) {
                if (this.p != null) {
                    this.p.setVisibility(8);
                    this.p = null;
                }
            } else if (this.y != null) {
                this.y.setVisibility(8);
                this.y = null;
            }
        }
        if ((view instanceof com.component.a.d.c) && this.n != null) {
            com.component.a.d.c cVar = (com.component.a.d.c) view;
            if (cVar.p()) {
                j();
                return;
            }
            com.component.a.i.f lifeCycle = cVar.getLifeCycle();
            if (lifeCycle != null && (eVarB = lifeCycle.b()) != null && "slide_view".equals(eVarB.m(""))) {
                j();
            }
        }
    }

    @Override // com.component.a.g.d.c
    public void a(com.component.a.f.d dVar) {
        super.a(dVar);
        if (this.E != null && dVar != null) {
            if (bm.h.equals(dVar.d())) {
                c();
            }
            this.E.a(dVar.d(), dVar);
        }
    }

    public com.component.a.b.e a() {
        return this.I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.F.post(this.G);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.F.removeCallbacksAndMessages(null);
    }

    private void i() {
        if (this.J != null) {
            this.J.post(new q(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.component.a.b.j jVar) {
        a(jVar, (com.component.a.b.o) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.component.a.b.j jVar, com.component.a.b.o oVar) {
        if (this.I != null) {
            this.I.a(jVar, oVar);
        }
    }

    public void b() {
        a(com.component.a.g.b.b.b);
    }

    public void c() {
        a(com.component.a.g.b.b.c);
    }

    public void d() {
        i();
    }

    public void e() {
        i();
    }

    public void a(View view, int i) {
        i();
    }

    public void a(int i) {
        i();
    }

    public void a(boolean z) {
        i();
    }

    public void f() {
        if (this.k != null) {
            this.k.J();
        }
        if (this.q != null) {
            this.q.m();
        }
        if (this.x != null) {
            this.a.removeCallbacksAndMessages(null);
        }
        this.f798K = false;
        h();
    }

    private void j() {
        if (this.n != null) {
            this.n.setVisibility(4);
            if (this.k != null) {
                this.k.j(2);
            }
        }
    }

    private int k() {
        if (this.e == null) {
            return 0;
        }
        int mainMaterialWidth = this.e.getMainMaterialWidth();
        int mainMaterialHeight = this.e.getMainMaterialHeight();
        if (mainMaterialHeight > mainMaterialWidth) {
            return 1;
        }
        if (mainMaterialHeight < mainMaterialWidth) {
            return 0;
        }
        return (this.h == 41 || this.h == 42) ? 1 : 0;
    }

    private boolean l() {
        return this.j < 41 && this.i == 1;
    }

    private void a(com.component.a.a.r rVar) {
        rVar.setOnClickListener(null);
        Context context = rVar.getContext();
        this.k = new w(context);
        if ("video".equals(this.g)) {
            if (this.n != null && TextUtils.equals(c, this.s)) {
                this.k.a(this.n, 3, 3000, true);
            }
            if (this.o != null && TextUtils.equals(d, this.s)) {
                this.k.a(this.o, -1, 0, false);
            }
            if (this.m != null) {
                this.k.b(this.m);
            }
            if (this.l != null) {
                this.k.c(this.l);
            }
        }
        this.k.a((v) new r(this));
        this.k.a((com.component.player.o) new h(this));
        com.component.a.f.e eVarA = a((com.component.a.c.c) rVar);
        this.k.a(eVarA);
        this.k.a((AbstractData) this.f);
        if (l() && !TextUtils.isEmpty(this.e.getMainPictureUrl())) {
            rVar.addView(a(context, eVarA), new RelativeLayout.LayoutParams(-1, -1));
            this.k.h(75);
        }
        rVar.addView(this.k, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void a(String str, View view) {
        b bVar = new b(view, str);
        if ("video".equals(this.g)) {
            this.D.add(bVar);
        } else {
            bVar.f();
        }
    }

    private com.component.a.f.e a(com.component.a.c.c cVar) {
        com.component.a.i.f lifeCycle;
        if (cVar != null && (lifeCycle = cVar.getLifeCycle()) != null) {
            return lifeCycle.b();
        }
        return null;
    }

    private ax a(Context context, com.component.a.f.e eVar) {
        e.f fVarH;
        float[] fArrA = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        if (eVar != null && (fVarH = eVar.h()) != null) {
            fArrA = fVarH.a(fArrA);
        }
        ax axVarA = new ax.a(context).a(ax.b.RoundRect).a(fArrA).b(true).b(9.5f).a();
        axVarA.setScaleType(ImageView.ScaleType.CENTER_CROP);
        com.baidu.mobads.container.util.d.d.a(context).b(axVarA, this.e.getMainPictureUrl());
        return axVarA;
    }

    private void m() {
        if (this.v != -1 && this.x != null) {
            this.a.postDelayed(new i(this), this.v + 2300);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        try {
            if (this.x != null) {
                this.a.removeCallbacksAndMessages(null);
                this.b = ObjectAnimator.ofFloat(this.x, "translationY", 0.0f, -this.w);
                this.b.setDuration(300L);
                this.b.start();
            }
        } catch (Throwable th) {
        }
    }

    static class b {
        private final View a;
        private final String b;
        private com.component.a.f.e e;
        private int c = 0;
        private int d = -1;
        private int f = 0;
        private int g = -1;

        /* JADX WARN: Multi-variable type inference failed */
        public b(View view, String str) {
            this.a = view;
            this.a.setVisibility(8);
            this.b = str;
            if (view instanceof com.component.a.c.c) {
                a((com.component.a.c.c) view);
            }
        }

        public void a(com.component.a.c.c cVar) {
            com.component.a.i.f lifeCycle;
            JSONObject jSONObjectC;
            if (cVar != null && (lifeCycle = cVar.getLifeCycle()) != null) {
                this.e = lifeCycle.b();
                if (this.e != null && (jSONObjectC = this.e.c()) != null) {
                    this.c = jSONObjectC.optInt("delay_time", this.c);
                    this.d = jSONObjectC.optInt(com.baidu.mobads.container.adrequest.n.m, this.d);
                }
            }
        }

        public void a() {
            this.f = 0;
            if (this.c == 0) {
                h();
                this.g = 1;
            } else {
                this.g = 0;
            }
        }

        public void a(int i) {
            this.f = i;
            if (this.g == 0) {
                if (this.f >= this.c) {
                    h();
                    this.g = 1;
                    return;
                }
                return;
            }
            if (this.g == 1 && this.d > 0 && this.f > this.d) {
                i();
                this.g = -1;
            }
        }

        public void b() {
            if (this.g == 1) {
                h();
            }
        }

        public void c() {
            if (this.g == 1) {
                i();
            }
        }

        public void d() {
            this.g = -1;
            i();
        }

        public void e() {
            this.g = -1;
            i();
        }

        public void f() {
            this.a.addOnAttachStateChangeListener(new s(this));
        }

        public void g() {
            if (this.d > 0) {
                cf.a(this.a, (cf.a) new u(this), this.d);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h() {
            if (this.a.getVisibility() == 8) {
                this.a.setVisibility(0);
                if (this.a instanceof com.component.a.a.f) {
                    ((com.component.a.a.f) this.a).f();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i() {
            if (this.a.getVisibility() != 8) {
                this.a.setVisibility(8);
                if (this.a instanceof com.component.a.a.f) {
                    ((com.component.a.a.f) this.a).s();
                }
            }
        }
    }
}

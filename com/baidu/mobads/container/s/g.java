package com.baidu.mobads.container.s;

import aegon.chrome.net.NetError;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.container.util.bv;
import com.baidu.mobads.container.util.cf;
import com.component.a.d.c;
import com.component.a.f.e;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class g extends com.component.a.d.c {
    private static final float a = 0.75f;
    private static final float[] b = {0.0f, 0.53125f, 0.71875f, 0.90625f};
    private b d;
    private a e;
    private com.baidu.mobads.container.util.g.c f;
    private com.component.a.d.c g;
    private com.component.a.a.f h;
    private com.component.a.a.q i;
    private com.component.a.d.c j;
    private com.component.a.a.f k;
    private com.component.a.a.f l;
    private com.component.a.a.q m;
    private float n;

    public interface a {
        void a(float f, float f2);

        void a(View view, MotionEvent motionEvent, MotionEvent motionEvent2);

        void b(View view, MotionEvent motionEvent, MotionEvent motionEvent2);
    }

    public g(Context context, com.component.a.f.e eVar) {
        super(context, eVar);
        this.d = new b();
    }

    public void a() {
        int i;
        View view;
        int i2;
        int iA;
        if (this.d.e) {
            this.f = new com.baidu.mobads.container.util.g.c(getContext());
            this.f.b(this);
            this.f.b(this.d.g);
            this.f.a(this.d.h);
            this.f.c(this.d.i);
            this.f.a(this.d.j);
            this.f.b(this.d.k);
            this.f.d(this.d.l);
            this.f.a(1000L);
            this.f.f(this.d.n);
            this.f.a(this.d.m);
            this.f.a(new h(this));
            this.f.c();
        }
        Map<View, com.component.a.f.e> mapA = com.component.a.i.n.a(this);
        this.g = (com.component.a.d.c) com.component.a.g.c.e.findViewByName(mapA, "mix_interact_background", com.component.a.d.c.class);
        if (this.g != null) {
            float fB = com.component.a.i.f.c((View) this.g).b(800) / (Math.abs(com.component.a.i.f.c((View) this.g).a(0, NetError.ERR_INVALID_RESPONSE, 0, 0)[1]) + 0);
            if (!Float.isNaN(fB)) {
                this.g.setScaleX(fB);
                this.g.setScaleY(fB);
            }
            this.g.setTranslationY(bv.a(getContext(), ((r1 - r5) / 2.0f) - 90.0f));
        }
        this.h = (com.component.a.a.f) com.component.a.g.c.e.findViewByName(mapA, "mix_interact_background_arc", com.component.a.a.f.class);
        if (this.h != null) {
            this.h.setAlpha(this.d.b);
        }
        this.i = (com.component.a.a.q) com.component.a.g.c.e.findViewByName(mapA, "mix_interact_slide_text", com.component.a.a.q.class);
        if (this.g != null) {
            if (this.d.r == 0) {
                i = -1;
            } else {
                i = 1;
            }
            int iA2 = bv.a(getContext(), 90.0f) + 0;
            switch (this.d.q) {
                case 1:
                    view = new View(getContext());
                    c.a aVar = new c.a(0, 0);
                    aVar.addRule(12);
                    aVar.a().a = 1.0f;
                    aVar.a().b = 0.5f;
                    addView(view, aVar);
                    i2 = 0;
                    iA = 0;
                    break;
                case 2:
                    view = this.g;
                    iA = bv.a(getContext(), 310.0f);
                    i2 = 1;
                    break;
                default:
                    view = new View(getContext());
                    addView(view, new c.a(-1, -1));
                    i2 = 0;
                    iA = 0;
                    break;
            }
            cf.a(view, new i(this, view, i, iA2, i2, iA));
        }
        this.j = (com.component.a.d.c) com.component.a.g.c.e.findViewByName(mapA, "mix_interact_shake_container", com.component.a.d.c.class);
        this.k = (com.component.a.a.f) com.component.a.g.c.e.findViewByName(mapA, "mix_interact_shake_progress", com.component.a.a.f.class);
        this.l = (com.component.a.a.f) com.component.a.g.c.e.findViewByName(mapA, "mix_interact_shake_icon", com.component.a.a.f.class);
        this.m = (com.component.a.a.q) com.component.a.g.c.e.findViewByName(mapA, "mix_interact_shake_text", com.component.a.a.q.class);
        if (this.m == null || TextUtils.isEmpty(this.d.c)) {
            return;
        }
        this.m.setText(this.d.c);
    }

    public void b() {
        if (this.h != null) {
            this.h.f();
        }
        if (this.l != null) {
            this.l.f();
        }
    }

    public void a(a aVar) {
        this.e = aVar;
    }

    private static int a(int i, int i2, int i3) {
        if (i2 == 3) {
            return i3;
        }
        double dPow = Math.pow(0.75d, i2);
        double d = i;
        Double.isNaN(d);
        return (int) (d * dPow);
    }

    public static g a(ViewGroup viewGroup, com.baidu.mobads.container.k kVar, com.baidu.mobads.container.adrequest.j jVar) {
        e.h hVar;
        JSONArray jSONArrayOptJSONArray;
        b bVar = new b(jVar);
        if (!bVar.a) {
            return null;
        }
        com.component.a.g.d dVar = new com.component.a.g.d(kVar, jVar);
        JSONObject jSONObjectB = com.component.a.i.n.b(com.baidu.mobads.container.u.n.n);
        try {
            double dPow = Math.pow(0.75d, bVar.p);
            Iterator<com.component.a.f.e> it = new com.component.a.f.e(jSONObjectB).iterator();
            while (it.hasNext()) {
                com.component.a.f.e next = it.next();
                if (!"mix_interact_background".equals(next.m(""))) {
                    if (!"mix_interact_slide_text".equals(next.m(""))) {
                        if (!"mix_interact_shake_text".equals(next.m(""))) {
                            if (!"mix_interact_shake_icon".equals(next.m(""))) {
                                if (!"mix_interact_shake_container".equals(next.m(""))) {
                                    if ("mix_interact_shake_progress".equals(next.m("")) && bVar.e && (jSONArrayOptJSONArray = next.f().optJSONArray("margins")) != null && jSONArrayOptJSONArray.length() > 3) {
                                        jSONArrayOptJSONArray.put(3, a(jSONArrayOptJSONArray.getInt(3), bVar.p, 83));
                                    }
                                } else if (!bVar.e) {
                                    next.f().put("visibility", 0);
                                }
                            } else if (bVar.e) {
                                if (!TextUtils.isEmpty(bVar.f) && (hVar = next.l().get(0)) != null) {
                                    hVar.b().put("json", bVar.f);
                                }
                                JSONObject jSONObjectF = next.f();
                                double dB = next.b(160);
                                Double.isNaN(dB);
                                jSONObjectF.put("h", Math.max(100, (int) (dB * dPow)));
                                JSONArray jSONArrayOptJSONArray2 = jSONObjectF.optJSONArray("margins");
                                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 3) {
                                    jSONArrayOptJSONArray2.put(3, a(jSONArrayOptJSONArray2.getInt(3), bVar.p, 21));
                                }
                            }
                        } else if (bVar.e) {
                            JSONObject jSONObjectF2 = next.f();
                            if (!TextUtils.isEmpty(bVar.c)) {
                                jSONObjectF2.put("src", bVar.c);
                            }
                            JSONArray jSONArrayOptJSONArray3 = jSONObjectF2.optJSONArray("margins");
                            if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 3) {
                                jSONArrayOptJSONArray3.put(3, a(jSONArrayOptJSONArray3.getInt(3), bVar.p, 13));
                            }
                        }
                    } else if (!bVar.e) {
                        JSONObject jSONObjectF3 = next.f();
                        jSONObjectF3.put("visibility", 1);
                        if (!TextUtils.isEmpty(bVar.d)) {
                            jSONObjectF3.put("src", bVar.d);
                        }
                    }
                } else {
                    JSONArray jSONArrayOptJSONArray4 = next.f().optJSONArray("margins");
                    if (jSONArrayOptJSONArray4 != null && jSONArrayOptJSONArray4.length() > 3) {
                        jSONArrayOptJSONArray4.put(1, (int) (jSONArrayOptJSONArray4.getInt(1) * bVar.o));
                    }
                }
            }
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.e("mix_inter_view control params parse error.");
        }
        View viewA = dVar.a(viewGroup, jSONObjectB, new c.a(-1, -1), null);
        if (!(viewA instanceof g) || viewA.getVisibility() != 0) {
            return null;
        }
        g gVar = (g) viewA;
        gVar.d = bVar;
        gVar.a();
        gVar.b();
        return gVar;
    }

    @Override // com.component.a.d.c, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f != null) {
            this.f.c();
        }
    }

    @Override // com.component.a.d.c, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f != null) {
            this.f.d();
        }
    }

    @Override // com.component.a.d.c, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            if (this.f != null) {
                this.f.a();
            }
        } else if (this.f != null) {
            this.f.b();
        }
    }

    public void c() {
        if (this.f != null) {
            this.f.b();
            this.f.d();
            this.f.b((View) null);
            this.f = null;
        }
    }

    public static class b {
        private boolean a;
        private float b;
        private String c;
        private String d;
        private boolean e;
        private String f;
        private float g;
        private float h;
        private float i;
        private int j;
        private int k;
        private int l;
        private boolean m;
        private float n;
        private float o;
        private int p;
        private int q;
        private int r;

        public b() {
            this.a = false;
            this.b = 0.3f;
            this.e = false;
            this.g = 7.0f;
            this.h = 6.0f;
            this.i = 0.0f;
            this.j = 190;
            this.k = 1;
            this.l = 0;
            this.m = false;
            this.n = 35.0f;
            this.o = 0.625f;
            this.p = 2;
            this.q = 0;
            this.r = 1;
        }

        public b(com.baidu.mobads.container.adrequest.j jVar) {
            this.a = false;
            this.b = 0.3f;
            this.e = false;
            this.g = 7.0f;
            this.h = 6.0f;
            this.i = 0.0f;
            this.j = 190;
            this.k = 1;
            this.l = 0;
            this.m = false;
            this.n = 35.0f;
            this.o = 0.625f;
            this.p = 2;
            this.q = 0;
            this.r = 1;
            com.baidu.mobads.container.components.i.a aVar = new com.baidu.mobads.container.components.i.a(null, jVar.getOriginJsonObject());
            this.a = aVar.a("mutable_click", 0) == 1;
            this.b = (float) aVar.a("mutable_bg_alpha", this.b);
            this.e = aVar.a("mutable_shake", 1) == 1;
            this.c = aVar.a("mutable_shake_hint", "");
            this.f = aVar.a("mutable_shake_anim", "");
            this.g = (float) aVar.a("mutable_shake_velocity", this.g);
            this.h = (float) aVar.a("mutable_shake_speed", this.h);
            this.i = (float) aVar.a("mutable_shake_angle", this.i);
            this.j = aVar.a("mutable_shake_detect_time", this.j);
            this.k = aVar.a("mutable_shake_success_time", this.k);
            this.l = aVar.a("mutable_shake_opt_time", this.l);
            this.n = (float) aVar.a("mutable_shake_twoway_angle", this.n);
            this.m = aVar.a("mutable_shake_twoway_switch", 0) == 1;
            this.d = aVar.a("mutable_shake_none_hint", "");
            this.o = (float) aVar.a("mutable_slide_area_height", this.o);
            this.q = aVar.a("mutable_slide_area_success", this.q);
            this.r = aVar.a("mutable_slide_legal", this.r);
            for (int i = 0; i < g.b.length && this.o >= g.b[i]; i++) {
                this.p = (g.b.length - i) - 1;
            }
        }
    }
}

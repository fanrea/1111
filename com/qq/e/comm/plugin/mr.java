package com.qq.e.comm.plugin;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.comm.plugin.callback.biz.ClickCallback;
import com.qq.e.comm.plugin.hg;
import com.qq.e.comm.plugin.rg;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class mr extends t4 implements os {
    private final VideoOption r;
    private final Cif s;
    private FrameLayout t;
    private boolean u;
    private boolean v;
    private volatile boolean w;
    private final ns x;
    private final m8 y;

    @Override // com.qq.e.comm.plugin.cl
    public boolean d() {
        return true;
    }

    public mr(Context context, bl blVar, fr frVar, VideoOption videoOption, rg.d dVar, ah ahVar, com.qq.e.comm.plugin.nativeadunified.c cVar, View.OnTouchListener onTouchListener, MediaView mediaView, JSONObject jSONObject) {
        super(context, frVar, blVar, videoOption, dVar, ahVar, cVar, onTouchListener, mediaView, jSONObject);
        this.x = new ns();
        this.y = new m8();
        this.s = q8.a().b(context, frVar);
        this.g.f(3);
        this.r = videoOption;
        s();
        r();
    }

    private void s() {
        if (this.s == null) {
            this.g.h(7);
            return;
        }
        if (!this.g.C1()) {
            this.g.h(8);
            return;
        }
        this.s.a((hg.c) null);
        this.t = this.s.f();
        mh mhVarJ = this.s.j();
        this.d = mhVarJ;
        if (mhVarJ != null && this.t != null) {
            rg rgVarQ = q();
            this.e = rgVarQ;
            this.t.addView(rgVarQ);
            a(this.d);
            this.u = true;
            return;
        }
        this.g.h(this.t == null ? 9 : 10);
    }

    /* compiled from: A */
    class a extends ms<Void> {
        a(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r2) {
            if (mr.this.s != null) {
                mr.this.s.b("");
            }
        }
    }

    private void r() {
        ((ClickCallback) x5.b(this.g.s0(), ClickCallback.class)).O().a(new a(this));
    }

    /* compiled from: A */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            rg rgVar = mr.this.e;
            if (rgVar != null) {
                rgVar.j();
            }
        }
    }

    /* compiled from: A */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            mr.this.b.f();
        }
    }

    /* compiled from: A */
    class d extends gf {
        d(f9 f9Var, h4 h4Var) {
            super(f9Var, h4Var);
        }

        @Override // com.qq.e.comm.plugin.gf
        public void a(i6 i6Var, h8 h8Var) {
            super.a(i6Var, h8Var);
            mr.this.m.a(i6Var);
        }

        @Override // com.qq.e.comm.plugin.gf
        public void k(h8 h8Var) throws JSONException {
            super.k(h8Var);
            mr.this.m.a();
            mr.this.s.t();
        }
    }

    private JSONObject u() throws JSONException {
        m8 m8Var = new m8();
        if (this.r != null) {
            m8Var.g(!r1.getAutoPlayMuted());
        } else {
            m8Var.g(false);
        }
        return m8Var.f();
    }

    @Override // com.qq.e.comm.plugin.t4
    public boolean p() {
        return this.s.s();
    }

    @Override // com.qq.e.comm.plugin.cl
    public void n() throws JSONException {
        this.v = false;
        this.s.t();
    }

    @Override // com.qq.e.comm.plugin.t4, com.qq.e.comm.plugin.cl
    public void destroy() {
        Cif cif = this.s;
        if (cif != null) {
            cif.c();
        }
        super.destroy();
        x5.c(this.g.s0(), ClickCallback.class);
        this.w = true;
    }

    @Override // com.qq.e.comm.plugin.cl
    public void f() {
        this.s.e().a(0);
    }

    public boolean t() {
        return this.u;
    }

    @Override // com.qq.e.comm.plugin.t4
    public void a(View view, FrameLayout.LayoutParams layoutParams) {
        FrameLayout frameLayout = this.t;
        if (frameLayout != null) {
            frameLayout.addView(view, layoutParams);
        }
    }

    @Override // com.qq.e.comm.plugin.os
    public ns i() {
        return this.x;
    }

    @Override // com.qq.e.comm.plugin.os
    public boolean k() {
        return this.w;
    }

    @Override // com.qq.e.comm.plugin.t4, com.qq.e.comm.plugin.ah
    public void a(int i, int i2, int i3) throws JSONException {
        super.a(i, i2, i3);
        this.y.a(i, i2);
        this.s.a(this.y.f());
    }

    @Override // com.qq.e.comm.plugin.t4, com.qq.e.comm.plugin.cl
    public void a(MediaView mediaView) throws JSONException {
        super.a(mediaView);
        View viewL = this.s.l();
        b50.a(viewL);
        this.f.addView(viewL, o());
        this.f.post(new b());
        if (this.e != null) {
            if (this.b.e()) {
                this.e.setOnClickListener(new c());
            } else {
                this.e.setOnClickListener(null);
                this.e.setClickable(false);
            }
        }
        this.s.a(u());
        this.s.a(new d(this.s, this.g));
        FrameLayout frameLayoutF = this.s.f();
        if (frameLayoutF == null) {
            frameLayoutF = this.f;
        }
        a(frameLayoutF);
        if (this.v) {
            a(false);
        }
    }

    @Override // com.qq.e.comm.plugin.t4, com.qq.e.comm.plugin.cl
    public void a(boolean z) throws JSONException {
        if (z && this.s.n()) {
            this.m.a();
            return;
        }
        this.v = true;
        if (p()) {
            this.s.v();
        } else {
            super.a(z);
        }
    }
}

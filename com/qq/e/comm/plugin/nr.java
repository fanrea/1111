package com.qq.e.comm.plugin;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.comm.plugin.callback.biz.ClickCallback;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class nr implements cl, os {
    protected fr a;
    protected final com.qq.e.comm.plugin.nativeadunified.c b;
    private final Cif c;
    private volatile boolean d;
    private final ns e = new ns();

    @Override // com.qq.e.comm.plugin.cl
    public void a() {
    }

    @Override // com.qq.e.comm.plugin.cl
    public void a(int i) {
    }

    @Override // com.qq.e.comm.plugin.cl
    public void a(boolean z) {
    }

    @Override // com.qq.e.comm.plugin.cl
    public mh b() {
        return null;
    }

    @Override // com.qq.e.comm.plugin.cl
    public void b(boolean z) {
    }

    @Override // com.qq.e.comm.plugin.cl
    public void c() {
    }

    @Override // com.qq.e.comm.plugin.cl
    public void e() {
    }

    @Override // com.qq.e.comm.plugin.cl
    public String g() {
        return null;
    }

    @Override // com.qq.e.comm.plugin.cl
    public int getCurrentPosition() {
        return 0;
    }

    @Override // com.qq.e.comm.plugin.cl
    public int getDuration() {
        return 1;
    }

    @Override // com.qq.e.comm.plugin.cl
    public void h() {
    }

    @Override // com.qq.e.comm.plugin.cl
    public boolean isPlaying() {
        return false;
    }

    @Override // com.qq.e.comm.plugin.cl
    public void j() {
    }

    @Override // com.qq.e.comm.plugin.cl
    public void l() {
    }

    @Override // com.qq.e.comm.plugin.cl
    public void m() {
    }

    @Override // com.qq.e.comm.plugin.cl
    public void n() {
    }

    @Override // com.qq.e.comm.plugin.cl
    public void pause() {
    }

    @Override // com.qq.e.comm.plugin.cl
    public void play() {
    }

    protected FrameLayout.LayoutParams q() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    @Override // com.qq.e.comm.plugin.cl
    public void setDataSource(String str) {
    }

    @Override // com.qq.e.comm.plugin.cl
    public void stop() {
    }

    public nr(Context context, fr frVar, com.qq.e.comm.plugin.nativeadunified.c cVar) {
        this.a = frVar;
        this.b = cVar;
        this.c = q8.a().b(context, frVar);
        o();
        this.a.f(3);
    }

    /* compiled from: A */
    class a extends ms<Void> {
        a(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r2) {
            if (nr.this.c != null) {
                nr.this.c.b("");
            }
        }
    }

    private void o() {
        ((ClickCallback) x5.b(this.a.s0(), ClickCallback.class)).O().a(new a(this));
    }

    public void s() {
        Cif cif = this.c;
        if (cif == null) {
            return;
        }
        cif.a(new b(this.c, this.a));
    }

    /* compiled from: A */
    class b extends gf {
        b(f9 f9Var, h4 h4Var) {
            super(f9Var, h4Var);
        }

        @Override // com.qq.e.comm.plugin.gf
        public void a(i6 i6Var, h8 h8Var) {
            super.a(i6Var, h8Var);
            nr.this.b.a(i6Var);
        }
    }

    public void p() {
        Cif cif = this.c;
        if (cif == null) {
            return;
        }
        b50.a(cif.l());
    }

    public void a(ViewGroup viewGroup) {
        Cif cif = this.c;
        if (cif == null) {
            return;
        }
        View viewL = cif.l();
        b50.a(viewL);
        viewGroup.addView(viewL, q());
    }

    @Override // com.qq.e.comm.plugin.cl
    public void a(MediaView mediaView) throws JSONException {
        View view;
        Cif cif = this.c;
        if (cif == null) {
            ImageView imageView = new ImageView(mediaView.getContext());
            mm.a().a(this.a.c0(), imageView);
            view = imageView;
        } else {
            View viewL = cif.l();
            b50.a(viewL);
            s();
            view = viewL;
        }
        mediaView.addView(view, q());
    }

    @Override // com.qq.e.comm.plugin.cl
    public void destroy() {
        Cif cif = this.c;
        if (cif != null) {
            cif.c();
        }
        x5.c(this.a.s0(), ClickCallback.class);
        this.d = true;
    }

    @Override // com.qq.e.comm.plugin.cl
    public void f() {
        this.c.e().a(0);
    }

    @Override // com.qq.e.comm.plugin.cl
    public boolean d() {
        return this.c != null;
    }

    @Override // com.qq.e.comm.plugin.os
    public ns i() {
        return this.e;
    }

    @Override // com.qq.e.comm.plugin.os
    public boolean k() {
        return this.d;
    }

    public View r() {
        Cif cif = this.c;
        if (cif == null) {
            return null;
        }
        return cif.l();
    }
}

package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.comm.plugin.fq;
import com.qq.e.comm.plugin.rg;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class t4 implements cl, ah {
    private final JSONObject a;
    protected final bl b;
    protected final Context c;
    protected mh d;
    protected rg e;
    protected MediaView f;
    protected fr g;
    protected boolean h;
    protected boolean i;
    private final g6 j;
    protected final com.qq.e.comm.plugin.nativeadunified.c m;
    protected final View.OnTouchListener n;
    private final rg.d o;
    private final ah p;
    protected al q;

    public abstract void a(View view, FrameLayout.LayoutParams layoutParams);

    protected FrameLayout.LayoutParams o() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    public abstract boolean p();

    public t4(Context context, fr frVar, bl blVar, VideoOption videoOption, rg.d dVar, ah ahVar, com.qq.e.comm.plugin.nativeadunified.c cVar, View.OnTouchListener onTouchListener, MediaView mediaView, JSONObject jSONObject) {
        this.h = true;
        this.i = true;
        this.c = context;
        this.b = blVar;
        this.g = frVar;
        this.o = dVar;
        this.p = ahVar;
        this.m = cVar;
        this.n = onTouchListener;
        this.f = mediaView;
        if (videoOption != null) {
            this.i = videoOption.isNeedCoverImage();
            this.h = videoOption.isNeedProgressBar();
        }
        this.j = new g6(this.f.getContext());
        this.a = jSONObject;
    }

    protected rg q() {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObject = this.a;
        rg rgVar = (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("play_btn")) == null) ? null : new rg(this.c, this.g.c0(), this.h, this.i, jSONObjectOptJSONObject.optString("res"), jSONObjectOptJSONObject.optInt("width", -1), jSONObjectOptJSONObject.optInt("height", -1));
        if (rgVar == null) {
            rgVar = new rg(this.c, this.g.c0(), this.h, this.i);
        }
        rgVar.c(false);
        rgVar.a(f5.a(this.g));
        rgVar.b(true);
        rgVar.a(this.o);
        return rgVar;
    }

    /* compiled from: A */
    class a implements yj {
        a() {
        }

        @Override // com.qq.e.comm.plugin.yj
        public void onP() {
            t4.this.b.d();
        }

        @Override // com.qq.e.comm.plugin.yj
        public void onPause() {
            t4.this.b.pauseVideo();
        }

        @Override // com.qq.e.comm.plugin.yj
        public void onStop() {
            t4.this.b.stopVideo();
        }
    }

    @Override // com.qq.e.comm.plugin.cl
    public void pause() {
        mh mhVar = this.d;
        if (mhVar != null) {
            mhVar.pause();
        }
    }

    @Override // com.qq.e.comm.plugin.cl
    public void play() {
        mh mhVar = this.d;
        if (mhVar != null) {
            mhVar.play();
        }
    }

    @Override // com.qq.e.comm.plugin.cl
    public void stop() {
        mh mhVar = this.d;
        if (mhVar != null) {
            mhVar.a(true, true);
        }
    }

    @Override // com.qq.e.comm.plugin.cl
    public boolean isPlaying() {
        mh mhVar = this.d;
        if (mhVar != null) {
            return mhVar.isPlaying();
        }
        return false;
    }

    @Override // com.qq.e.comm.plugin.cl
    public void c() {
        mh mhVar = this.d;
        if (mhVar != null) {
            mhVar.c();
        }
    }

    @Override // com.qq.e.comm.plugin.cl
    public int getDuration() {
        mh mhVar = this.d;
        if (mhVar != null) {
            return mhVar.getDuration();
        }
        return 0;
    }

    @Override // com.qq.e.comm.plugin.cl
    public int getCurrentPosition() {
        mh mhVar = this.d;
        if (mhVar != null) {
            return mhVar.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.qq.e.comm.plugin.cl
    public String g() {
        mh mhVar = this.d;
        if (mhVar != null) {
            return mhVar.q();
        }
        return null;
    }

    @Override // com.qq.e.comm.plugin.cl
    public void setDataSource(String str) {
        mh mhVar = this.d;
        if (mhVar != null) {
            mhVar.setDataSource(str);
        }
    }

    @Override // com.qq.e.comm.plugin.cl
    public void h() {
        rg rgVar = this.e;
        if (rgVar != null) {
            rgVar.c();
        }
    }

    @Override // com.qq.e.comm.plugin.cl
    public void j() {
        rg rgVar = this.e;
        if (rgVar != null) {
            rgVar.j();
        }
    }

    @Override // com.qq.e.comm.plugin.cl
    public void e() {
        this.j.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(yu.a(this.f.getContext().getApplicationContext(), 46), yu.a(this.f.getContext().getApplicationContext(), 46));
        layoutParams.gravity = 17;
        b50.a(this.j);
        a(this.j, layoutParams);
    }

    @Override // com.qq.e.comm.plugin.cl
    public void l() {
        g6 g6Var = this.j;
        if (g6Var != null) {
            g6Var.setVisibility(8);
        }
    }

    @Override // com.qq.e.comm.plugin.cl
    public void m() {
        al alVar = this.q;
        if (alVar != null) {
            alVar.c();
        }
    }

    protected void a(FrameLayout frameLayout) {
        ViewGroup viewGroup;
        if (p() || TextUtils.isEmpty(this.g.a()) || frameLayout == null) {
            return;
        }
        al alVar = this.q;
        if (alVar == null) {
            fq fqVar = new fq(this.c, this.g);
            this.q = fqVar;
            fqVar.a(new b());
            frameLayout.addOnLayoutChangeListener(new c(frameLayout));
        } else {
            View viewA = alVar.a();
            if (viewA != null && (viewGroup = (ViewGroup) viewA.getParent()) != null) {
                viewGroup.removeView(viewA);
            }
        }
        frameLayout.addView(this.q.a(), o());
    }

    /* compiled from: A */
    class b implements fq.a {
        b() {
        }

        @Override // com.qq.e.comm.plugin.fq.a
        public void b() {
            t4.this.m.a();
        }

        @Override // com.qq.e.comm.plugin.fq.a
        public void a(View view, String str) {
            t4.this.m.a(str);
        }
    }

    /* compiled from: A */
    class c implements View.OnLayoutChangeListener {
        final /* synthetic */ FrameLayout a;

        c(FrameLayout frameLayout) {
            this.a = frameLayout;
        }

        /* compiled from: A */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ViewGroup.LayoutParams layoutParams;
                al alVar = t4.this.q;
                if (alVar == null || alVar.a() == null || (layoutParams = t4.this.q.a().getLayoutParams()) == null) {
                    return;
                }
                if (layoutParams.width == c.this.a.getWidth() && layoutParams.height == t4.this.d.r().getHeight()) {
                    return;
                }
                layoutParams.width = c.this.a.getWidth();
                layoutParams.height = c.this.a.getHeight();
                t4.this.q.a().setLayoutParams(layoutParams);
            }
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.a.post(new a());
        }
    }

    @Override // com.qq.e.comm.plugin.cl
    public void destroy() {
        mh mhVar = this.d;
        if (mhVar != null) {
            mhVar.free();
        }
        rg rgVar = this.e;
        if (rgVar != null) {
            rgVar.g();
            this.e.removeAllViews();
        }
        al alVar = this.q;
        if (alVar != null) {
            alVar.destroy();
            this.q = null;
        }
    }

    @Override // com.qq.e.comm.plugin.cl
    public mh b() {
        return this.d;
    }

    @Override // com.qq.e.comm.plugin.cl
    public void b(boolean z) {
        rg rgVar = this.e;
        if (rgVar != null) {
            if (z) {
                rgVar.h();
            } else {
                rgVar.j();
            }
        }
    }

    @Override // com.qq.e.comm.plugin.ah
    public boolean a(int i, j40 j40Var, float f) {
        ah ahVar = this.p;
        if (ahVar != null) {
            return ahVar.a(i, j40Var, f);
        }
        return true;
    }

    public void a(int i, int i2, int i3) {
        ah ahVar = this.p;
        if (ahVar != null) {
            ahVar.a(i, i2, i3);
        }
    }

    @Override // com.qq.e.comm.plugin.cl
    public void a(MediaView mediaView) {
        this.f = mediaView;
    }

    @Override // com.qq.e.comm.plugin.cl
    public void a(int i) {
        g6 g6Var = this.j;
        if (g6Var != null) {
            g6Var.a(i);
        }
    }

    protected void a(mh mhVar) {
        mhVar.a(this.g);
        mhVar.a(true);
        if (r1.d().f().a("nuvdfsw", 0) == 1) {
            mhVar.r().setFitsSystemWindows(true);
        }
        mhVar.r().setLayoutParams(o());
        mhVar.b(this.g.b1(), this.g.X0());
        mhVar.a(this.g.w0(), this.g.v0());
        mhVar.a(this);
        mhVar.a(this.e);
        mhVar.a(new a());
    }

    @Override // com.qq.e.comm.plugin.cl
    public void a() {
        mh mhVar = this.d;
        if (mhVar != null) {
            mhVar.a();
        }
    }

    @Override // com.qq.e.comm.plugin.cl
    public void a(boolean z) {
        al alVar = this.q;
        if (alVar != null) {
            alVar.show();
        }
    }

    @Override // com.qq.e.comm.plugin.ah
    public void a(int i, int i2) {
        ah ahVar = this.p;
        if (ahVar != null) {
            ahVar.a(i, i2);
        }
    }
}

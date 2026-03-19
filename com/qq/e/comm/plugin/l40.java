package com.qq.e.comm.plugin;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.comm.plugin.fq;
import com.qq.e.comm.plugin.rg;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class l40 implements rg.d, fq.a {
    private boolean f;
    private final Cif g;
    private final mh h;
    private final rg i;
    private final FrameLayout j;
    private final al m;
    private int n;
    private final ej o;
    private final VideoOption p;
    private final h4 q;
    private final f5 r;
    private i7 s;
    private volatile String u;
    private final f6 w;
    private boolean x;
    private int a = 1;
    private int b = 1;
    private int c = 1;
    private int d = 1;
    private jp e = jp.INIT;
    private final AtomicBoolean t = new AtomicBoolean(false);
    private int v = 0;
    private final m8 y = new m8();

    /* compiled from: A */
    static /* synthetic */ class e {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[jp.values().length];
            a = iArr;
            try {
                iArr[jp.PLAYING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[jp.INIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[jp.AUTO_PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void p() {
        xo.a((Runnable) new c());
    }

    @Override // com.qq.e.comm.plugin.wg.a
    public void c() {
    }

    void c(boolean z) {
        int i = e.a[this.e.ordinal()];
        if (i == 1) {
            if (z) {
                return;
            }
            d(false);
            return;
        }
        if (i != 2) {
            if (i != 3) {
                return;
            }
        } else if (!m()) {
            this.i.j();
            return;
        }
        if (z) {
            this.d = 1;
            o();
        }
    }

    l40(Cif cif, mh mhVar, rg rgVar, FrameLayout frameLayout, al alVar, f6 f6Var, VideoOption videoOption, h4 h4Var, boolean z, ej ejVar) {
        this.g = cif;
        this.h = mhVar;
        this.i = rgVar;
        this.j = frameLayout;
        this.m = alVar;
        this.w = f6Var;
        this.o = ejVar;
        this.p = videoOption;
        this.q = h4Var;
        this.r = f5.a(h4Var);
        rgVar.a(this);
        rgVar.d(!cif.n());
        mhVar.a(new a(h4Var, z));
        mhVar.a(new b());
        if (alVar != null) {
            alVar.a(this);
        }
        q();
    }

    /* compiled from: A */
    class a extends bh {
        a(h4 h4Var, boolean z) {
            super(h4Var, z);
        }

        @Override // com.qq.e.comm.plugin.bh, com.qq.e.comm.plugin.ah
        public boolean a(int i, j40 j40Var, float f) {
            super.a(i, j40Var, f);
            l40.this.o.a(1009, i, j40Var.b());
            return true;
        }

        @Override // com.qq.e.comm.plugin.bh, com.qq.e.comm.plugin.ah
        public void a(int i, int i2, int i3) throws JSONException {
            super.a(i, i2, i3);
            l40.this.o.a(1008, i, i2);
            l40.this.y.a(i, i2);
            l40.this.g.a(l40.this.y.f());
        }
    }

    /* compiled from: A */
    class b implements yj {
        b() {
        }

        @Override // com.qq.e.comm.plugin.yj
        public void onP() {
            l40.this.o();
        }

        @Override // com.qq.e.comm.plugin.yj
        public void onPause() {
            l40.this.d(false);
        }

        @Override // com.qq.e.comm.plugin.yj
        public void onStop() {
            l40.this.e = jp.END;
            l40 l40Var = l40.this;
            l40Var.v = l40Var.h.getCurrentPosition();
            l40.this.h.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        VideoOption videoOption = this.p;
        if (videoOption != null) {
            return k.a(videoOption.getAutoPlayPolicy());
        }
        return true;
    }

    void o() {
        ej ejVar;
        this.t.set(true);
        if (!TextUtils.isEmpty(this.u)) {
            this.e = jp.PLAYING;
            this.h.play();
        } else {
            if (!TextUtils.isEmpty(this.u) || (ejVar = this.o) == null) {
                return;
            }
            ejVar.a(1001, new int[0]);
        }
    }

    public void n() {
        p();
    }

    @Override // com.qq.e.comm.plugin.wg.a
    public void onVideoReady() {
        this.c = 0;
        int duration = this.h.getDuration();
        this.n = duration;
        this.o.a(210, duration);
    }

    @Override // com.qq.e.comm.plugin.wg.a
    public void onVideoStart() throws JSONException {
        this.o.a(202, new int[0]);
        if (this.m != null && !this.g.s()) {
            this.m.c();
        }
        e();
        e(true);
    }

    @Override // com.qq.e.comm.plugin.wg.a
    public void onVideoStop() {
        this.v = this.h.getCurrentPosition();
        this.e = jp.END;
        this.o.a(205, new int[0]);
    }

    @Override // com.qq.e.comm.plugin.wg.a
    public void onVideoPause() {
        this.v = this.h.getCurrentPosition();
        this.o.a(204, new int[0]);
    }

    @Override // com.qq.e.comm.plugin.wg.a
    public void onVideoResume() {
        this.b = 2;
        this.o.a(203, new int[0]);
    }

    /* compiled from: A */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l40.this.x || !l40.this.m()) {
                return;
            }
            l40.this.x = true;
            l40.this.w.setVisibility(0);
            l40.this.w.b();
        }
    }

    private void e(boolean z) throws JSONException {
        if (this.q.k() == e2.NATIVEEXPRESSAD && this.q.k1()) {
            this.g.a(new m8().a(z).f());
        }
    }

    /* compiled from: A */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l40.this.w.setVisibility(4);
            l40.this.w.c();
        }
    }

    private void e() {
        xo.a((Runnable) new d());
    }

    private void q() {
        VideoOption videoOption = this.p;
        if (videoOption != null) {
            if (videoOption.getAutoPlayMuted()) {
                this.h.a();
                return;
            } else {
                this.h.c();
                return;
            }
        }
        this.h.a();
    }

    int i() {
        return this.a;
    }

    int j() {
        return this.c;
    }

    int k() {
        return this.b;
    }

    int h() {
        return this.d;
    }

    public int f() {
        if (this.e == jp.PLAYING) {
            this.v = this.h.getCurrentPosition();
        }
        return this.v;
    }

    mh l() {
        return this.h;
    }

    int g() {
        return this.n;
    }

    @Override // com.qq.e.comm.plugin.rg.d
    public void b(boolean z) {
        this.f = z;
    }

    public void d() {
        al alVar = this.m;
        if (alVar != null) {
            alVar.destroy();
        }
        this.h.free();
    }

    @Override // com.qq.e.comm.plugin.fq.a
    public void a(View view, String str) {
        this.o.a(str);
    }

    private void f(boolean z) throws JSONException {
        if (z && this.g.n()) {
            b();
            return;
        }
        if (this.g.s()) {
            this.g.v();
        } else {
            al alVar = this.m;
            if (alVar != null) {
                alVar.show();
            }
        }
        e(false);
    }

    void d(boolean z) {
        jp jpVar;
        this.t.set(false);
        if (z) {
            jpVar = jp.MANUAL_PAUSE;
        } else {
            jpVar = jp.AUTO_PAUSE;
        }
        this.e = jpVar;
        this.h.pause();
    }

    @Override // com.qq.e.comm.plugin.fq.a
    public void b() {
        o();
    }

    @Override // com.qq.e.comm.plugin.rg.d
    public void a(boolean z) {
        ej ejVar;
        this.t.set(!z);
        if (!z) {
            this.d = 0;
            if (TextUtils.isEmpty(this.u) && (ejVar = this.o) != null) {
                ejVar.a(1001, new int[0]);
            }
        }
        i7 i7Var = this.s;
        if (i7Var != null) {
            i7Var.a();
        }
        this.e = z ? jp.MANUAL_PAUSE : jp.PLAYING;
    }

    public void a(long j, long j2, int i) {
        p();
    }

    @Override // com.qq.e.comm.plugin.wg.a
    public void a() throws JSONException {
        this.e = jp.END;
        this.v = this.h.getCurrentPosition();
        this.o.a(206, new int[0]);
        f(true);
        this.b = 3;
    }

    @Override // com.qq.e.comm.plugin.wg.a
    public void a(int i, Exception exc) throws JSONException {
        this.c = 2;
        this.e = jp.ERROR;
        this.o.a(207, new int[0]);
        e();
        f(false);
    }

    public void a(i7 i7Var) {
        this.s = i7Var;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.c = 2;
            e();
        } else if (TextUtils.isEmpty(this.u)) {
            this.u = str;
            this.c = 0;
            this.h.setDataSource(this.u);
            if (this.t.get()) {
                o();
            }
        }
    }
}

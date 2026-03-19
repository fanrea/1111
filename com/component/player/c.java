package com.component.player;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.util.ab;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.ci;
import com.baidu.mobads.container.util.cm;
import com.baidu.mobads.container.util.d.d;
import com.component.player.AdVideoViewListener;
import com.component.player.f;
import java.lang.ref.SoftReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c extends RelativeLayout implements l, u {
    private static final String j = "AdVideoView";
    private static final int s = 200;
    private boolean A;
    private m B;
    private o C;
    private Surface D;
    private SurfaceHolder E;
    public t a;
    public AdVideoViewListener b;
    public q c;
    public View d;
    public boolean e;
    public boolean f;
    protected final com.component.player.a g;
    r h;
    p i;
    private AdVideoViewListener.a k;
    private AdVideoViewListener.b l;
    private b m;
    private int n;
    private int o;
    private boolean p;
    private int q;
    private a r;
    private boolean t;
    private String u;
    private boolean v;
    private boolean w;
    private long x;
    private long y;
    private int z;

    public c(Context context) {
        super(context);
        this.n = -1;
        this.o = -16777216;
        this.p = false;
        this.q = 4;
        this.u = "";
        this.w = false;
        this.z = 1;
        this.A = false;
        this.e = false;
        this.f = false;
        this.g = new com.component.player.a();
        this.h = new d(this);
        this.i = new e(this);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = -1;
        this.o = -16777216;
        this.p = false;
        this.q = 4;
        this.u = "";
        this.w = false;
        this.z = 1;
        this.A = false;
        this.e = false;
        this.f = false;
        this.g = new com.component.player.a();
        this.h = new d(this);
        this.i = new e(this);
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = -1;
        this.o = -16777216;
        this.p = false;
        this.q = 4;
        this.u = "";
        this.w = false;
        this.z = 1;
        this.A = false;
        this.e = false;
        this.f = false;
        this.g = new com.component.player.a();
        this.h = new d(this);
        this.i = new e(this);
    }

    public void a(boolean z) {
        this.e = z;
        if (this.c instanceof j) {
            ((j) this.c).a(z);
        }
    }

    public void a(int i) {
        this.z = i;
    }

    public Bitmap a() {
        if (this.c instanceof TextureView) {
            return ((TextureView) this.c).getBitmap();
        }
        long jG = g();
        if (jG == 0) {
            jG = l();
        }
        return w.a().b(getContext(), this.u, jG);
    }

    @Override // com.component.player.l
    public void b() {
        this.v = false;
        if (this.a != null && this.a.k() != f.a.PLAYBACKCOMPLETED) {
            this.a.b();
            a(this.a.h());
            b(this.a.i());
            if (this.b != null) {
                this.g.b((int) this.x);
                this.b.playPause();
            }
        }
    }

    @Override // com.component.player.l
    public void c() {
        this.v = true;
        v();
        if (this.b != null && this.x != 0) {
            this.g.e();
            this.b.playResume();
        }
    }

    @Override // com.component.player.l
    public void d() {
        this.x = 0L;
        this.v = true;
        v();
    }

    @Override // com.component.player.l
    public void e() {
        t tVar = this.a;
        if (tVar != null) {
            this.a = null;
            a(false);
            a(tVar.h());
            b(tVar.i());
            tVar.a((u) null);
            tVar.d();
            if (this.r != null) {
                this.r.a(false);
            }
            if (this.b != null) {
                this.g.c((int) this.x);
                this.b.playStop();
            }
        }
    }

    @Override // com.component.player.l
    public void a(AdVideoViewListener adVideoViewListener) {
        this.b = adVideoViewListener;
    }

    @Override // com.component.player.l
    public void a(AdVideoViewListener.a aVar) {
        this.k = aVar;
    }

    @Override // com.component.player.l
    public void a(AdVideoViewListener.b bVar) {
        this.l = bVar;
    }

    @Override // android.view.View, com.component.player.l
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.component.player.l
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.mobads.container.l.g.b().e("视频物料异常");
            return;
        }
        this.u = str;
        p();
        if (this.a != null) {
            String strA = com.baidu.mobads.container.util.d.d.a(getContext()).a(str, d.e.VIDEO);
            boolean zEquals = w.a.equals(this.a.a());
            int i = 1;
            int i2 = zEquals ? 2 : 0;
            if (TextUtils.isEmpty(strA)) {
                i = i2;
            } else if (!zEquals) {
                str = strA;
            }
            this.g.a(str, i, zEquals ? 1 : 0);
            this.a.a(str);
        }
    }

    @Override // com.component.player.l
    public boolean f() {
        if (this.a != null) {
            return this.a.j();
        }
        return false;
    }

    @Override // com.component.player.l
    public void b(int i) {
        if (this.a != null) {
            this.a.a(i);
        }
    }

    @Override // com.component.player.l
    public int g() {
        if (this.a != null) {
            return (int) this.a.h();
        }
        return 0;
    }

    @Override // com.component.player.l
    public int h() {
        if (this.a != null) {
            return (int) this.a.i();
        }
        return 0;
    }

    @Override // com.component.player.l
    public void b(boolean z) {
        this.g.a(z);
        this.t = z;
        if (this.t) {
            b(0.0f);
        } else {
            b(1.0f);
        }
    }

    @Override // com.component.player.u
    public void a(cm cmVar) {
        b(cmVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.e && this.a == null && !TextUtils.isEmpty(this.u)) {
            a(this.u);
            b(this.t);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!this.e) {
            e();
        }
    }

    @Override // com.component.player.l
    public void a(float f) {
        if (this.a != null) {
            this.a.b(f);
        }
    }

    public void i() {
        this.x = 0L;
        this.y = 0L;
        d(false);
        q();
        r();
    }

    public void c(boolean z) {
        this.x = 0L;
        this.y = 0L;
        d(z);
        q();
    }

    public void a(boolean z, int i, int i2, int i3) {
        this.p = z;
        this.o = i;
        this.n = i2;
        this.q = ab.a(getContext(), i3);
    }

    public void c(int i) {
        if (this.p) {
            this.m.setVisibility(i);
        }
    }

    public com.component.player.a j() {
        return this.g;
    }

    private void b(float f) {
        if (this.a != null) {
            this.a.a(f);
        }
    }

    private void b(cm cmVar) {
        switch (cmVar.getCode()) {
            case 256:
                this.x = 0L;
                t();
                if (this.b != null) {
                    this.g.f();
                    this.b.playCompletion();
                    break;
                }
                break;
            case 257:
                this.x = 0L;
                b(cmVar.getMessage());
                break;
            case 258:
                if (this.l != null) {
                    this.g.a();
                    this.l.a();
                }
                if (this.x > 0 && this.a != null) {
                    this.a.a(this.x);
                }
                b(this.t);
                if (this.c != null && this.a != null) {
                    this.c.a(this.a.f(), this.a.g());
                }
                if (this.m != null) {
                    this.m.a(this.x / h());
                }
                if (this.r != null) {
                    removeCallbacks(this.r);
                    this.r.a(true);
                    postDelayed(this.r, 200L);
                }
                if (this.v && ci.a(this)) {
                    u();
                    break;
                }
                break;
            case 260:
                t();
                if (this.b != null) {
                    this.g.a(h());
                    this.b.renderingStart();
                    break;
                }
                break;
            case 261:
                s();
                if (this.B != null) {
                    this.g.c();
                    this.B.a();
                    break;
                }
                break;
            case 262:
                this.g.d();
                t();
                break;
        }
    }

    private void b(String str) {
        if (this.b != null) {
            this.g.a(str);
            this.b.playFailure(str);
        }
        t();
        e();
    }

    private void p() {
        if (this.a == null) {
            this.a = w.a().a(getContext());
            bq.a().a(j, "Init player: " + this.a.a());
            this.a.a((u) this);
        }
    }

    private void d(boolean z) {
        com.baidu.mobads.container.l.g.b().c("是否使用surfaceView" + z);
        if (!z && com.baidu.mobads.container.util.x.a(null).a() >= 14) {
            this.A = false;
            this.c = new j(getContext(), this.h);
            ((j) this.c).a(this.e);
        } else {
            this.A = true;
            this.c = new i(getContext(), this.i);
        }
        this.c.a(this.z);
    }

    private void q() {
        removeAllViews();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        setBackgroundColor(Color.parseColor("#000000"));
        addView((View) this.c, layoutParams);
    }

    private void r() {
        if (this.p) {
            this.m = new b(getContext());
            this.m.a(this.n);
            this.m.b(this.o);
            this.m.c(this.q);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.q);
            layoutParams.addRule(12);
            addView(this.m, layoutParams);
            this.m.a(0.0f);
            this.m.setVisibility(0);
            if (this.r == null) {
                this.r = new a(this);
                return;
            }
            return;
        }
        if (this.m != null) {
            this.m.setVisibility(8);
        }
    }

    public void k() {
    }

    public void a(m mVar) {
        this.B = mVar;
    }

    public void a(o oVar) {
        this.C = oVar;
        if (this.r == null) {
            this.r = new a(this);
        }
    }

    static class a implements Runnable {
        private final SoftReference<c> a;
        private boolean b = false;

        a(c cVar) {
            this.a = new SoftReference<>(cVar);
        }

        public void a(boolean z) {
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = this.a.get();
            if (cVar != null) {
                int iG = cVar.g();
                int iH = cVar.h();
                if (iH > 0) {
                    float f = iG / iH;
                    if (cVar.m != null) {
                        cVar.m.a(f);
                    }
                    if (cVar.C != null) {
                        cVar.C.a(iG, f);
                    }
                    cVar.g.a(iG, f);
                }
                if (this.b) {
                    cVar.postDelayed(this, 200L);
                }
            }
        }
    }

    private void s() {
        if (this.d == null) {
            this.d = new ProgressBar(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.d.setLayoutParams(layoutParams);
            addView(this.d);
            return;
        }
        this.d.setVisibility(0);
    }

    private void t() {
        if (this.d != null) {
            this.d.setVisibility(8);
        }
    }

    private void u() {
        if (this.a != null) {
            this.a.a(this.A ? this.E : this.D);
            if (this.b != null) {
                this.g.b();
                this.b.playStart();
                return;
            }
            return;
        }
        com.baidu.mobads.container.l.g.b().c("播放失败：播放器已被释放");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (TextUtils.isEmpty(this.u)) {
            com.baidu.mobads.container.l.g.b().e("视频链接为空，不需重新播放");
        } else if (this.v && this.w) {
            u();
        }
    }

    private void a(long j2) {
        this.x = j2;
    }

    public int l() {
        return (int) this.x;
    }

    private void b(long j2) {
        this.y = j2;
    }

    public int m() {
        return (int) this.y;
    }

    public void n() {
        this.u = "";
    }

    public boolean o() {
        return this.t;
    }
}

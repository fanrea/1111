package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.comm.plugin.e50;
import com.qq.e.comm.plugin.wg;
import com.qq.e.comm.plugin.xg;
import java.lang.ref.WeakReference;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class rg extends xg implements xg.a, wg, e50.a {
    private mk c;
    private boolean d;
    private d e;
    private ImageView f;
    private f6 g;
    private Cdo h;
    private final Context i;
    private b40 j;
    private final String m;
    private final boolean n;
    private final boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private f5 s;
    private final Context t;
    private final e50 u;
    private boolean v;
    private boolean w;
    private final View.OnClickListener x;
    private yg y;
    private final Handler z;

    /* compiled from: A */
    public interface d extends wg.a {
        void a(boolean z);

        void b(boolean z);
    }

    @Override // com.qq.e.comm.plugin.xg.a
    public void a() {
    }

    public rg(Context context, String str, boolean z, boolean z2) {
        this(context, str, z, z2, null, -1, -1);
    }

    private void f() {
        if (this.h == null) {
            Cdo cdo = new Cdo(getContext());
            this.h = cdo;
            cdo.c(100);
            this.h.a(true);
            this.h.b(Color.parseColor("#66FFFFFF"));
            this.h.setBackgroundColor(Color.parseColor("#33FFFFFF"));
        }
        this.h.setVisibility(this.n ? 0 : 4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, yu.a(this.i, 2));
        layoutParams.gravity = 80;
        addView(this.h, layoutParams);
    }

    /* compiled from: A */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (rg.this.e != null && rg.this.c != null) {
                rg.this.e.a(rg.this.c.isPlaying());
            }
            rg.this.b();
            rg.this.c();
        }
    }

    public rg(Context context, String str, boolean z, boolean z2, String str2, int i, int i2) throws JSONException {
        super(context);
        this.w = true;
        this.x = new a();
        this.y = new b();
        this.z = new e(this);
        this.m = str;
        this.n = z;
        this.o = z2;
        this.i = context.getApplicationContext();
        this.t = context;
        this.u = new e50(this);
        b(str2, i, i2);
    }

    /* compiled from: A */
    class b implements yg {
        b() {
        }

        @Override // com.qq.e.comm.plugin.yg
        public void onVideoReady() {
            if (rg.this.e != null) {
                rg.this.e.onVideoReady();
            }
        }

        @Override // com.qq.e.comm.plugin.yg
        public void onVideoStart() {
            rg.this.z.sendEmptyMessage(10002);
            rg.this.d();
            if (rg.this.e != null) {
                rg.this.e.onVideoStart();
            }
            rg.this.c();
        }

        @Override // com.qq.e.comm.plugin.yg
        public void a() {
            rg.this.z.removeMessages(10002);
            if (rg.this.h != null) {
                rg.this.h.a(100);
            }
            if (rg.this.e != null) {
                rg.this.e.a();
            }
            rg.this.i();
            if (rg.this.w) {
                rg.this.h();
            }
        }

        @Override // com.qq.e.comm.plugin.yg
        public void onVideoStop() {
            rg.this.z.removeMessages(10002);
            if (rg.this.h != null) {
                rg.this.h.a(100);
            }
            rg.this.i();
            if (rg.this.e != null) {
                rg.this.e.onVideoStop();
            }
        }

        @Override // com.qq.e.comm.plugin.yg
        public void onVideoPause() {
            rg.this.z.removeMessages(10002);
            rg.this.i();
            if (rg.this.e != null) {
                rg.this.e.onVideoPause();
            }
        }

        @Override // com.qq.e.comm.plugin.yg
        public void onVideoResume() {
            rg.this.z.sendEmptyMessage(10002);
            rg.this.d();
            if (rg.this.e != null) {
                rg.this.e.onVideoResume();
            }
            rg.this.c();
        }

        @Override // com.qq.e.comm.plugin.yg
        public void d() {
            rg.this.z.removeMessages(10002);
            rg.this.r = true;
            if (rg.this.q && rg.this.g != null) {
                rg.this.g.setVisibility(0);
                rg.this.g.b();
            }
            if (rg.this.e != null) {
                rg.this.e.b(true);
            }
        }

        @Override // com.qq.e.comm.plugin.yg
        public void b() {
            rg.this.z.sendEmptyMessage(10002);
            rg.this.r = false;
            if (rg.this.q && rg.this.g != null) {
                rg.this.g.c();
                rg.this.g.setVisibility(4);
            }
            if (rg.this.e != null) {
                rg.this.e.b(false);
            }
        }

        @Override // com.qq.e.comm.plugin.yg
        public void c() {
            if (rg.this.e != null) {
                rg.this.e.c();
            }
        }

        @Override // com.qq.e.comm.plugin.yg
        public void a(int i, Exception exc) {
            rg.this.z.sendEmptyMessage(10003);
            if (rg.this.e != null) {
                rg.this.e.a(i, exc);
            }
            rg.this.i();
        }
    }

    private void e() throws JSONException {
        if (this.j == null && this.m != null) {
            this.j = new b40(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            addView(this.j, layoutParams);
            mm.a().a(this.m, this.j);
        }
        b40 b40Var = this.j;
        if (b40Var != null) {
            b40Var.setAlpha(this.o ? 1.0f : 0.0f);
        }
    }

    private void a(String str, int i, int i2) {
        FrameLayout.LayoutParams layoutParams;
        Bitmap bitmapA;
        if (this.f == null) {
            this.f = new ImageView(getContext());
            if (!TextUtils.isEmpty(str) && (bitmapA = gw.a(str)) != null) {
                this.f.setImageBitmap(bitmapA);
            } else {
                this.f.setImageBitmap(hp.a(this.i));
            }
            this.f.setOnClickListener(this.x);
        }
        if (i >= 0 && i2 >= 0) {
            layoutParams = new FrameLayout.LayoutParams(yu.a(this.i, i), yu.a(this.i, i2));
        } else {
            int iA = yu.a(this.i, 46);
            layoutParams = new FrameLayout.LayoutParams(iA, iA);
        }
        layoutParams.gravity = 17;
        this.f.setVisibility(4);
        addView(this.f, layoutParams);
        if (this.g == null) {
            this.g = new f6(getContext());
        }
        this.g.setVisibility(4);
        addView(this.g, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        mk mkVar = this.c;
        if (mkVar != null) {
            if (mkVar.isPlaying()) {
                this.c.pause();
            } else {
                this.c.play();
            }
        }
    }

    /* compiled from: A */
    class c implements yg {
        final /* synthetic */ yg a;

        c(yg ygVar) {
            this.a = ygVar;
        }

        @Override // com.qq.e.comm.plugin.yg
        public void onVideoReady() {
            this.a.onVideoReady();
            rg.this.y.onVideoReady();
        }

        @Override // com.qq.e.comm.plugin.yg
        public void onVideoStart() {
            this.a.onVideoStart();
            rg.this.y.onVideoStart();
        }

        @Override // com.qq.e.comm.plugin.yg
        public void a() {
            this.a.a();
            rg.this.y.a();
        }

        @Override // com.qq.e.comm.plugin.yg
        public void onVideoStop() {
            this.a.onVideoStop();
            rg.this.y.onVideoStop();
        }

        @Override // com.qq.e.comm.plugin.yg
        public void onVideoPause() {
            this.a.onVideoPause();
            rg.this.y.onVideoPause();
        }

        @Override // com.qq.e.comm.plugin.yg
        public void onVideoResume() {
            this.a.onVideoResume();
            rg.this.y.onVideoResume();
        }

        @Override // com.qq.e.comm.plugin.yg
        public void d() {
            this.a.d();
            rg.this.y.d();
        }

        @Override // com.qq.e.comm.plugin.yg
        public void b() {
            this.a.b();
            rg.this.y.b();
        }

        @Override // com.qq.e.comm.plugin.yg
        public void c() {
            this.a.c();
            rg.this.y.c();
        }

        @Override // com.qq.e.comm.plugin.yg
        public void a(int i, Exception exc) {
            this.a.a(i, exc);
            rg.this.y.a(i, exc);
        }
    }

    private void b(String str, int i, int i2) throws JSONException {
        setBackgroundColor(0);
        e();
        f();
        a(str, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        b40 b40Var = this.j;
        if (b40Var == null || !this.o) {
            return;
        }
        b40Var.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        b40 b40Var = this.j;
        if (b40Var == null || b40Var.getAlpha() != 1.0f) {
            return;
        }
        this.j.animate().alpha(0.0f).setDuration(200L);
    }

    /* compiled from: A */
    private static class e extends Handler {
        private WeakReference<rg> a;

        public e(rg rgVar) {
            this.a = new WeakReference<>(rgVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            rg rgVar = this.a.get();
            if (rgVar != null) {
                int i = message.what;
                if (i != 10002) {
                    if (i != 10003) {
                        return;
                    }
                    rgVar.setEnabled(false);
                } else {
                    rgVar.k();
                    if (rgVar.c == null || !rgVar.c.isPlaying()) {
                        return;
                    }
                    sendMessageDelayed(obtainMessage(10002), 500L);
                }
            }
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int k() {
        mk mkVar = this.c;
        if (mkVar == null) {
            return 0;
        }
        int currentPosition = mkVar.getCurrentPosition();
        int duration = this.c.getDuration();
        Cdo cdo = this.h;
        if (cdo != null && duration > 0) {
            cdo.a((currentPosition * 100) / duration);
        }
        return currentPosition;
    }

    public void h() {
        mk mkVar = this.c;
        if (mkVar == null || mkVar.getVideoState() == j40.ERROR || this.c.getVideoState() == j40.UNINITIALIZED) {
            return;
        }
        j();
    }

    public void j() {
        ImageView imageView;
        if (this.d || (imageView = this.f) == null) {
            return;
        }
        this.d = true;
        imageView.setVisibility(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.v) {
            this.u.a(this.t);
        }
    }

    @Override // com.qq.e.comm.plugin.wg
    public void c() {
        ImageView imageView;
        if (!this.d || (imageView = this.f) == null) {
            return;
        }
        imageView.setVisibility(4);
        this.d = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e50 e50Var = this.u;
        if (e50Var == null || !this.v) {
            return;
        }
        e50Var.b(this.t);
    }

    public void g() {
        Handler handler = this.z;
        if (handler != null) {
            handler.removeMessages(10002);
        }
    }

    public void d(boolean z) {
        this.w = z;
    }

    public void a(f5 f5Var) {
        this.s = f5Var;
    }

    public void b(boolean z) {
        f6 f6Var;
        this.q = z;
        if (z && this.r) {
            f6 f6Var2 = this.g;
            if (f6Var2 != null) {
                f6Var2.setVisibility(0);
                this.g.b();
                return;
            }
            return;
        }
        if (z || (f6Var = this.g) == null) {
            return;
        }
        f6Var.c();
        this.g.setVisibility(4);
    }

    public void c(boolean z) {
        this.v = z;
    }

    public void a(int i, int i2) {
        b40 b40Var = this.j;
        if (b40Var != null) {
            b40Var.a(i, i2);
        }
    }

    public void a(wg.a aVar) {
        if (aVar instanceof d) {
            this.e = (d) aVar;
        }
    }

    @Override // com.qq.e.comm.plugin.wg
    public void a(mk mkVar) {
        this.c = mkVar;
        yg ygVarE = mkVar.e();
        if (ygVarE != null && this.y != null) {
            this.c.a(new c(ygVarE));
        } else {
            this.c.a(this.y);
        }
        if (mkVar.isPlaying()) {
            this.z.sendEmptyMessage(10002);
        }
    }

    public void a(boolean z) {
        this.p = z;
    }

    @Override // com.qq.e.comm.plugin.e50.a
    public void a(float f) {
        mk mkVar = this.c;
        if (mkVar != null) {
            if (f > 0.0f) {
                mkVar.c();
            } else {
                mkVar.a();
            }
        }
    }
}

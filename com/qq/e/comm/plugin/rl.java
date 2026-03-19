package com.qq.e.comm.plugin;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qq.e.comm.plugin.wp;
import java.io.File;
import java.lang.ref.WeakReference;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public interface rl {
    public static final FrameLayout.LayoutParams k = new FrameLayout.LayoutParams(-1, -1, 17);

    /* compiled from: A */
    public interface b extends wp.b {
        void a(int i, int i2);

        void b(qj qjVar);
    }

    ViewGroup a();

    void a(long j);

    void a(File file);

    void a(String str, yg ygVar);

    void a(boolean z);

    mh b();

    boolean c();

    void e();

    void f();

    void g();

    /* compiled from: A */
    public static class a extends FrameLayout {
        xz a;
        mh b;
        private final int c;
        private final int d;
        private Runnable e;

        public a(xz xzVar) {
            String strY0;
            ku kuVarX0;
            super(xzVar.a);
            this.a = xzVar;
            mu muVarB = xzVar.b();
            if (muVarB == null) {
                kuVarX0 = com.qq.e.comm.plugin.b.c().a(e2.SPLASH.d());
                strY0 = "";
            } else {
                strY0 = muVarB.y0();
                kuVarX0 = muVarB.x0();
            }
            this.c = xc.a("stpto", strY0, -1, kuVarX0);
            this.d = xc.a("stfbt", strY0, 0, kuVarX0);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            r5 r5VarD;
            if (this.a != null && (r5VarD = u2.a().d(this)) != null) {
                r5VarD.a(motionEvent, false);
            }
            return super.dispatchTouchEvent(motionEvent);
        }

        @Override // android.view.View
        protected void onVisibilityChanged(View view, int i) {
            long jMax;
            super.onVisibilityChanged(view, i);
            xz xzVar = this.a;
            if (xzVar == null) {
                return;
            }
            mh mhVar = this.b;
            int i2 = this.c;
            f20 f20Var = i2 < 0 ? null : xzVar.A;
            if (i == 0) {
                if (f20Var != null) {
                    int i3 = this.d;
                    if (i3 > 0) {
                        jMax = i3 + f20Var.c();
                    } else {
                        jMax = i3 < 0 ? Math.max(f20Var.c(), this.d * (-1)) : 0L;
                    }
                    if (jMax > 0) {
                        f20Var.b(Math.min(f20Var.b(), jMax));
                    }
                    f20Var.f();
                    b10.a(1013024, xzVar.c(), Integer.valueOf(this.c), Integer.valueOf(this.d), null);
                }
                Runnable runnable = this.e;
                if (runnable != null) {
                    xo.e(runnable);
                    this.e = null;
                }
                if (mhVar == null || mhVar.isPlaying() || mhVar.getVideoState() == j40.END) {
                    return;
                }
                mhVar.play();
                return;
            }
            if (f20Var != null) {
                if (i2 > 0) {
                    RunnableC0721a runnableC0721a = new RunnableC0721a(f20Var);
                    this.e = runnableC0721a;
                    xo.a(runnableC0721a, this.c * 60 * 1000);
                }
                f20Var.e();
            }
            b10.a(1013023, xzVar.c(), Integer.valueOf(this.c), Integer.valueOf(this.d), null);
            if (mhVar == null || !mhVar.isPlaying()) {
                return;
            }
            mhVar.pause();
        }

        void a() {
            this.a = null;
            this.b = null;
            Runnable runnable = this.e;
            if (runnable != null) {
                xo.e(runnable);
            }
        }

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.rl$a$a, reason: collision with other inner class name */
        private static class RunnableC0721a implements Runnable {
            private WeakReference<f20> a;

            RunnableC0721a(f20 f20Var) {
                this.a = new WeakReference<>(f20Var);
            }

            @Override // java.lang.Runnable
            public void run() {
                f20 f20Var = this.a.get();
                if (f20Var != null) {
                    f20Var.f();
                }
            }
        }
    }
}

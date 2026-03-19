package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.e.o;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class a implements View.OnTouchListener {
    private static final int dg = ViewConfiguration.getTapTimeout();
    final View cR;
    private int cU;
    private int cV;
    private boolean cZ;
    boolean da;
    boolean db;
    boolean dd;
    private boolean de;
    private boolean df;
    private Runnable mRunnable;
    final C0009a cP = new C0009a();
    private final Interpolator cQ = new AccelerateInterpolator();
    private float[] cS = {0.0f, 0.0f};
    private float[] cT = {Float.MAX_VALUE, Float.MAX_VALUE};
    private float[] cW = {0.0f, 0.0f};
    private float[] cX = {0.0f, 0.0f};
    private float[] cY = {Float.MAX_VALUE, Float.MAX_VALUE};

    static float a(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    static int a(int i, int i2, int i3) {
        if (i > i3) {
            return i3;
        }
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public abstract void v(int i);

    public abstract boolean w(int i);

    public a(View view) {
        this.cR = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((displayMetrics.density * 1575.0f) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        float f = i;
        a(f, f);
        float f2 = i2;
        b(f2, f2);
        r(1);
        e(Float.MAX_VALUE, Float.MAX_VALUE);
        d(0.2f, 0.2f);
        c(1.0f, 1.0f);
        s(dg);
        t(500);
        u(500);
    }

    public final a j(boolean z) {
        if (this.de && !z) {
            ae();
        }
        this.de = z;
        return this;
    }

    private a a(float f, float f2) {
        float[] fArr = this.cY;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    private a b(float f, float f2) {
        float[] fArr = this.cX;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    private a c(float f, float f2) {
        float[] fArr = this.cW;
        fArr[0] = 0.001f;
        fArr[1] = 0.001f;
        return this;
    }

    private a r(int i) {
        this.cU = 1;
        return this;
    }

    private a d(float f, float f2) {
        float[] fArr = this.cS;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        return this;
    }

    private a e(float f, float f2) {
        float[] fArr = this.cT;
        fArr[0] = Float.MAX_VALUE;
        fArr[1] = Float.MAX_VALUE;
        return this;
    }

    private a s(int i) {
        this.cV = i;
        return this;
    }

    private a t(int i) {
        this.cP.x(500);
        return this;
    }

    private a u(int i) {
        this.cP.y(500);
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0016  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.de
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L58
        L16:
            r5.ae()
            goto L58
        L1a:
            r5.db = r2
            r5.cZ = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.cR
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.a(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.cR
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.a(r2, r7, r6, r3)
            android.support.v4.widget.a$a r7 = r5.cP
            r7.g(r0, r6)
            boolean r6 = r5.dd
            if (r6 != 0) goto L58
            boolean r6 = r5.ac()
            if (r6 == 0) goto L58
            r5.ad()
        L58:
            boolean r6 = r5.df
            if (r6 == 0) goto L61
            boolean r6 = r5.dd
            if (r6 == 0) goto L61
            return r2
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    final boolean ac() {
        C0009a c0009a = this.cP;
        int iAi = c0009a.ai();
        c0009a.ah();
        return iAi != 0 && w(iAi);
    }

    private void ad() {
        int i;
        if (this.mRunnable == null) {
            this.mRunnable = new b();
        }
        this.dd = true;
        this.da = true;
        if (!this.cZ && (i = this.cV) > 0) {
            o.a(this.cR, this.mRunnable, i);
        } else {
            this.mRunnable.run();
        }
        this.cZ = true;
    }

    private void ae() {
        if (this.da) {
            this.dd = false;
        } else {
            this.cP.ae();
        }
    }

    private float a(int i, float f, float f2, float f3) {
        float fA = a(this.cS[i], f2, this.cT[i], f);
        if (fA == 0.0f) {
            return 0.0f;
        }
        float f4 = this.cW[i];
        float f5 = this.cX[i];
        float f6 = this.cY[i];
        float f7 = f4 * f3;
        if (fA > 0.0f) {
            return a(fA * f7, f5, f6);
        }
        return -a((-fA) * f7, f5, f6);
    }

    private float a(float f, float f2, float f3, float f4) {
        float interpolation;
        float fA = a(f * f2, 0.0f, f3);
        float f5 = f(f2 - f4, fA) - f(f4, fA);
        if (f5 < 0.0f) {
            interpolation = -this.cQ.getInterpolation(-f5);
        } else {
            if (f5 <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.cQ.getInterpolation(f5);
        }
        return a(interpolation, -1.0f, 1.0f);
    }

    private float f(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        int i = this.cU;
        if (i == 0 || i == 1) {
            if (f < f2) {
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.dd && this.cU == 1) {
                    return 1.0f;
                }
            }
        } else if (i == 2 && f < 0.0f) {
            return f / (-f2);
        }
        return 0.0f;
    }

    final void af() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        this.cR.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.dd) {
                if (a.this.da) {
                    a aVar = a.this;
                    aVar.da = false;
                    aVar.cP.start();
                }
                C0009a c0009a = a.this.cP;
                if (c0009a.isFinished() || !a.this.ac()) {
                    a.this.dd = false;
                    return;
                }
                if (a.this.db) {
                    a aVar2 = a.this;
                    aVar2.db = false;
                    aVar2.af();
                }
                c0009a.ag();
                a.this.v(c0009a.aj());
                o.a(a.this.cR, this);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    /* renamed from: android.support.v4.widget.a$a, reason: collision with other inner class name */
    static class C0009a {
        private int dh;
        private int di;
        private float dj;
        private float dk;
        private float dp;
        private int dq;
        private long mStartTime = Long.MIN_VALUE;

        /* renamed from: do, reason: not valid java name */
        private long f0do = -1;
        private long dl = 0;
        private int dm = 0;
        private int dn = 0;

        private static float a(float f) {
            return ((-4.0f) * f * f) + (f * 4.0f);
        }

        C0009a() {
        }

        public final void x(int i) {
            this.dh = i;
        }

        public final void y(int i) {
            this.di = i;
        }

        public final void start() {
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.f0do = -1L;
            this.dl = this.mStartTime;
            this.dp = 0.5f;
            this.dm = 0;
            this.dn = 0;
        }

        public final void ae() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.dq = a.a((int) (jCurrentAnimationTimeMillis - this.mStartTime), 0, this.di);
            this.dp = f(jCurrentAnimationTimeMillis);
            this.f0do = jCurrentAnimationTimeMillis;
        }

        public final boolean isFinished() {
            return this.f0do > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f0do + ((long) this.dq);
        }

        private float f(long j) {
            if (j < this.mStartTime) {
                return 0.0f;
            }
            long j2 = this.f0do;
            if (j2 < 0 || j < j2) {
                return a.a((j - this.mStartTime) / this.dh, 0.0f, 1.0f) * 0.5f;
            }
            long j3 = j - j2;
            float f = this.dp;
            return (1.0f - f) + (f * a.a(j3 / this.dq, 0.0f, 1.0f));
        }

        public final void ag() {
            if (this.dl == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float fA = a(f(jCurrentAnimationTimeMillis));
            long j = jCurrentAnimationTimeMillis - this.dl;
            this.dl = jCurrentAnimationTimeMillis;
            float f = j * fA;
            this.dm = (int) (this.dj * f);
            this.dn = (int) (f * this.dk);
        }

        public final void g(float f, float f2) {
            this.dj = f;
            this.dk = f2;
        }

        public final int ah() {
            float f = this.dj;
            return (int) (f / Math.abs(f));
        }

        public final int ai() {
            float f = this.dk;
            return (int) (f / Math.abs(f));
        }

        public final int aj() {
            return this.dn;
        }
    }
}

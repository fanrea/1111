package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Matrix;
import android.media.AudioManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class mh extends FrameLayout implements mk, com.qq.e.comm.plugin.va.m.q, Handler.Callback {
    private static final int T = r1.d().f().a("skvsrmr", 3);
    private static Boolean U;
    private final Handler A;
    private final Handler B;
    private HandlerThread C;
    private int D;
    private float E;
    private float F;
    private final n40 G;
    private ah H;
    private boolean I;
    private Boolean J;

    /* renamed from: K, reason: collision with root package name */
    private String f779K;
    private AtomicBoolean L;
    private boolean M;
    private int N;
    private int O;
    private long P;
    private l Q;
    private volatile int R;
    private yj S;
    private String a;
    private final q40 b;
    private volatile int c;
    private volatile int d;
    private volatile int e;
    private volatile com.qq.e.comm.plugin.va.m.p f;
    private AudioManager g;
    private int h;
    private int i;
    private h4 j;
    private final AtomicBoolean m;
    private final AtomicBoolean n;
    private volatile int o;
    private final AtomicBoolean p;
    private final AtomicBoolean q;
    private wg r;
    private yg s;
    private Boolean t;
    private boolean u;
    private volatile j40 v;
    private dy w;
    private long x;
    private int y;
    private int z;

    /* compiled from: A */
    public interface l {
        void a(int i);
    }

    @Override // com.qq.e.comm.plugin.va.m.q
    public void onAva() {
    }

    @Override // com.qq.e.comm.plugin.va.m.q
    public void onDes() {
    }

    public View r() {
        return this;
    }

    public mh(Context context, e2 e2Var) {
        super(context);
        this.a = "gdt_tag_player";
        this.m = new AtomicBoolean(false);
        this.n = new AtomicBoolean(false);
        this.p = new AtomicBoolean(false);
        this.q = new AtomicBoolean(false);
        this.v = j40.UNINITIALIZED;
        this.w = dy.DEFAULT;
        this.x = 0L;
        this.y = 0;
        this.z = 0;
        this.D = -1;
        this.E = 1.0f;
        this.F = 1.0f;
        this.I = true;
        this.L = new AtomicBoolean(false);
        this.M = false;
        this.N = 0;
        this.R = 1;
        this.b = p40.a(e2Var);
        this.a += hashCode();
        u();
        if (this.f.getT() == 0) {
            HandlerThread handlerThread = new HandlerThread("mh");
            this.C = handlerThread;
            handlerThread.start();
            this.A = new m50(this, this.C.getLooper());
            this.B = new Handler(Looper.getMainLooper());
        } else {
            Handler handler = new Handler(Looper.getMainLooper(), this);
            this.A = handler;
            this.B = handler;
        }
        qm$h$$ExternalSyntheticBackport0.m(this.f);
        this.f.setWor(this.A);
        this.G = new n40();
        this.A.sendEmptyMessage(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        if (this.H == null) {
            return;
        }
        if (!v()) {
            this.O = 0;
            this.P = 0L;
        } else {
            if (this.P == 0) {
                this.P = System.currentTimeMillis();
            }
            this.A.sendEmptyMessageDelayed(14, 500L);
        }
    }

    private void x() {
        if (this.H == null) {
            return;
        }
        this.B.post(new d(getCurrentPosition()));
    }

    /* compiled from: A */
    class d implements Runnable {
        final /* synthetic */ int a;

        d(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a == mh.this.O) {
                if (mh.this.v()) {
                    int iCurrentTimeMillis = (int) (System.currentTimeMillis() - mh.this.P);
                    if (mh.this.I) {
                        mh mhVar = mh.this;
                        mhVar.I = mhVar.H.a(iCurrentTimeMillis, mh.this.v, mh.this.E);
                    }
                }
            } else {
                mh.this.P = System.currentTimeMillis();
                mh.this.O = this.a;
                mh.this.H.a(this.a, mh.this.getDuration(), mh.this.getPlayerVersion());
                if (mh.this.Q != null) {
                    mh.this.Q.a(this.a);
                }
            }
            mh.this.H();
        }
    }

    private void u() {
        this.f = m40.a(getContext(), this, this.b);
        addView((View) this.f, -1, -1);
    }

    public void t() {
        this.f.initP();
        this.g = (AudioManager) getContext().getSystemService("audio");
    }

    private void D() {
        this.n.set(false);
        this.e = 0;
        this.o = 0;
        this.v = j40.UNINITIALIZED;
    }

    @Override // com.qq.e.comm.plugin.va.m.q
    public void onStar() {
        this.t = Boolean.TRUE;
        n();
    }

    @Override // com.qq.e.comm.plugin.va.m.q
    public void onEnd() {
        this.t = Boolean.FALSE;
        o();
    }

    /* compiled from: A */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (mh.this.s != null) {
                mh.this.s.b();
            }
        }
    }

    private void o() {
        this.B.post(new e());
    }

    /* compiled from: A */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (mh.this.s != null) {
                mh.this.s.d();
            }
        }
    }

    /* compiled from: A */
    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (mh.this.r != null) {
                mh.this.r.c();
            }
        }
    }

    private void s() {
        this.B.post(new g());
    }

    private void n() {
        this.B.post(new f());
    }

    private boolean w() {
        return (!this.f.isV() || this.v == j40.ERROR || this.v == j40.UNINITIALIZED) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v() {
        return this.f.isV() && (this.v == j40.PLAY || this.v == j40.PREPARED || (this.v == j40.UNINITIALIZED && this.f.isDa()));
    }

    @Override // com.qq.e.comm.plugin.jj
    public void setDataSource(String str) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 7;
        messageObtain.obj = str;
        this.A.sendMessage(messageObtain);
        if (this.J == null) {
            this.J = Boolean.valueOf(!str.startsWith(com.alipay.sdk.m.l.a.r));
        }
    }

    private void b() {
        wg wgVar = this.r;
        if (wgVar != null) {
            wgVar.a(this);
        }
    }

    @Override // com.qq.e.comm.plugin.va.m.q
    public void onC() {
        j40 j40Var = this.v;
        j40 j40Var2 = j40.END;
        if (j40Var != j40Var2) {
            this.v = j40Var2;
            if (this.q.get()) {
                oi.a().e();
            }
            J();
            this.B.post(new h());
        }
    }

    /* compiled from: A */
    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (mh.this.s != null) {
                mh.this.s.a();
            }
        }
    }

    @Override // com.qq.e.comm.plugin.va.m.q
    public void onPre(int i2, int i3) {
        this.v = j40.PREPARED;
        b(i2, i3);
        setSpeed(this.F);
        this.B.post(new i());
        if (this.n.get()) {
            seekTo(this.o);
        }
    }

    /* compiled from: A */
    class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (mh.this.s != null) {
                mh.this.s.onVideoReady();
            }
        }
    }

    /* compiled from: A */
    class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (mh.this.s != null) {
                if (mh.this.R == 2) {
                    mh.this.s.onVideoResume();
                    return;
                }
                mh.this.s.onVideoStart();
                float f = mh.this.m.get() ? 0.0f : 0.8f;
                if (!mh.this.f.isV() || mh.this.v == j40.ERROR) {
                    return;
                }
                mh.this.f.setV(f, f);
            }
        }
    }

    @Override // com.qq.e.comm.plugin.va.m.q
    public void onP() {
        this.v = j40.PLAY;
        this.B.post(new j());
    }

    @Override // com.qq.e.comm.plugin.va.m.q
    public void onE(int i2, Exception exc) {
        h4 h4Var;
        qm$h$$ExternalSyntheticBackport0.m(exc);
        if (this.v == j40.END && (h4Var = this.j) != null) {
            if (U == null) {
                U = Boolean.valueOf(xc.a("vieac", "", 0, h4Var.x0()) == 1);
            }
            if (U.booleanValue()) {
                return;
            } else {
                o40.a(this.j);
            }
        }
        if (this.q.get()) {
            oi.a().a(i2);
        }
        j40 j40Var = this.v;
        j40 j40Var2 = j40.ERROR;
        if (j40Var != j40Var2) {
            this.v = j40Var2;
            J();
            this.B.post(new k(i2, exc));
        }
    }

    /* compiled from: A */
    class k implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ Exception b;

        k(int i, Exception exc) {
            this.a = i;
            this.b = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (mh.this.s != null) {
                mh.this.s.a(this.a, this.b);
            }
        }
    }

    @Override // com.qq.e.comm.plugin.va.m.q
    public void onCha(int i2, int i3) {
        b(i2, i3);
        if (this.c == 0 || this.d == 0) {
            return;
        }
        this.B.post(new a());
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            mh.this.requestLayout();
        }
    }

    @Override // com.qq.e.comm.plugin.jj
    public void play() {
        this.A.sendEmptyMessage(1);
    }

    private void A() {
        if (!this.u && this.f.isDa() && this.v != j40.PLAY && this.f.isV()) {
            if (!this.M && this.v != j40.PAUSE) {
                if (this.v != j40.END && this.v != j40.STOP) {
                    K();
                    this.R = 1;
                    this.f.play();
                    setSpeed(this.F);
                    return;
                }
                this.R = 1;
                a(this.f779K);
                H();
                this.f.play();
                return;
            }
            this.M = false;
            this.R = 2;
            this.f.play();
            H();
            K();
            this.D = getCurrentPosition();
            setSpeed(this.F);
        }
    }

    @Override // com.qq.e.comm.plugin.jj
    public void pause() {
        this.A.sendEmptyMessage(2);
    }

    public void y() {
        this.A.sendEmptyMessage(15);
    }

    public void L() {
        this.A.sendEmptyMessage(16);
    }

    private void z() {
        if (this.v == j40.UNINITIALIZED || this.v == j40.PREPARED) {
            return;
        }
        j40 j40Var = this.v;
        j40 j40Var2 = j40.PAUSE;
        if (j40Var == j40Var2 || this.v == j40.STOP || this.v == j40.END || !this.f.isV()) {
            return;
        }
        this.v = j40Var2;
        if (this.f.isPlaying()) {
            this.M = true;
            this.f.pause();
        }
        this.D = getCurrentPosition();
        J();
        this.B.post(new b());
    }

    /* compiled from: A */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (mh.this.s != null) {
                mh.this.s.onVideoPause();
            }
        }
    }

    public void I() {
        this.A.sendEmptyMessage(3);
    }

    /* compiled from: A */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (mh.this.s != null) {
                mh.this.s.onVideoStop();
            }
        }
    }

    @Override // com.qq.e.comm.plugin.jj
    public void setTransform(Matrix matrix) {
        this.f.setTransform(matrix);
    }

    @Override // com.qq.e.comm.plugin.jj
    public int getPlayerVersion() {
        return this.f.getPlayerVersion();
    }

    @Override // com.qq.e.comm.plugin.jj
    public void seekTo(int i2) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 10;
        messageObtain.arg1 = i2;
        this.A.sendMessage(messageObtain);
    }

    @Override // com.qq.e.comm.plugin.jj
    public int getDuration() {
        if (this.e == 0) {
            try {
                if (w()) {
                    this.e = this.f.getDuration();
                }
            } catch (Exception unused) {
            }
        }
        return this.e;
    }

    private void F() {
        try {
            if (!this.f.isV() || this.v == j40.ERROR || this.m.get()) {
                return;
            }
            this.f.setV(0.0f, 0.0f);
            this.m.set(true);
            J();
        } catch (Exception unused) {
        }
    }

    private void G() {
        try {
            if (this.f.isV() && this.v != j40.ERROR && this.m.get()) {
                this.f.setV(0.8f, 0.8f);
                this.m.set(false);
                K();
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.qq.e.comm.plugin.jj
    public int getCurrentPosition() {
        try {
            if (!w()) {
                return 0;
            }
            if (this.v == j40.END) {
                return getDuration();
            }
            return this.f.getCurrentPosition();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.qq.e.comm.plugin.mk
    public void c() {
        this.A.sendEmptyMessage(9);
    }

    public void a(boolean z, boolean z2) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 3;
        messageObtain.arg1 = z ? 1 : 0;
        messageObtain.arg2 = z2 ? 1 : 0;
        this.A.sendMessage(messageObtain);
    }

    @Override // com.qq.e.comm.plugin.mk
    public j40 getVideoState() {
        return this.v;
    }

    public String q() {
        return this.f779K;
    }

    @Override // com.qq.e.comm.plugin.mk
    public yg e() {
        return this.s;
    }

    @Override // com.qq.e.comm.plugin.jj
    public boolean isPlaying() {
        try {
            if (w() && this.f.isV()) {
                return this.f.isPlaying();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.qq.e.comm.plugin.mk
    public int i() {
        if (this.D < 0) {
            this.D = getCurrentPosition();
        }
        return this.D;
    }

    @Override // com.qq.e.comm.plugin.jj
    public void free() {
        int i2;
        ah ahVar = this.H;
        if (ahVar != null) {
            Boolean bool = this.J;
            if (bool == null) {
                i2 = -1;
            } else {
                i2 = bool.booleanValue() ? 1 : 0;
            }
            ahVar.a(i2, p40.a(this.b));
        }
        hashCode();
        this.A.sendEmptyMessage(12);
    }

    @Override // com.qq.e.comm.plugin.jj
    public void setSpeed(float f2) {
        if (f2 > T || f2 < 0.0f || f2 == this.E) {
            return;
        }
        this.F = f2;
        if (!this.f.isV() || M()) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 17;
        messageObtain.obj = Float.valueOf(f2);
        this.A.sendMessage(messageObtain);
    }

    boolean M() {
        return this.v == j40.UNINITIALIZED || this.v == j40.END || this.v == j40.ERROR || this.v == j40.PAUSE;
    }

    private void p() {
        yg ygVar = this.s;
        if (ygVar != null) {
            ygVar.c();
        }
        pv.a().b(this);
        int currentPosition = getCurrentPosition();
        if (this.q.get() && currentPosition > 0 && !oi.a().c()) {
            oi.a().e();
        }
        this.f.res();
        this.f.free();
        this.v = j40.UNINITIALIZED;
        B();
    }

    private synchronized void B() {
        HandlerThread handlerThread = this.C;
        if (handlerThread != null) {
            handlerThread.quit();
            this.C = null;
        }
    }

    protected void finalize() {
        try {
            super.finalize();
            B();
        } catch (Throwable unused) {
        }
    }

    private void C() {
        this.f.res();
        this.f.relea();
        if (this.v == j40.END) {
            this.N = 0;
        }
        this.v = j40.UNINITIALIZED;
        this.L.set(true);
    }

    private void E() {
        if (this.L.get()) {
            this.L.set(false);
            this.f.resto();
            D();
            int i2 = this.N;
            if (i2 > 0) {
                seekTo(i2);
            }
            float f2 = this.m.get() ? 0.0f : 1.0f;
            this.f.setV(f2, f2);
            if (this.f779K != null) {
                this.f.setDataSource(this.f779K);
                H();
            } else {
                hashCode();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        pv.a().b(this);
        this.A.sendEmptyMessage(5);
    }

    @Override // com.qq.e.comm.plugin.mk
    public void d() {
        this.A.sendEmptyMessage(4);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.A.sendEmptyMessage(13);
        if (this.f.isV()) {
            pv.a().a(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    private void b(boolean z, boolean z2) {
        if (this.v == j40.UNINITIALIZED || this.v == j40.PREPARED) {
            return;
        }
        j40 j40Var = this.v;
        j40 j40Var2 = j40.STOP;
        if (j40Var == j40Var2 || this.v == j40.END || this.v == j40.ERROR || !this.f.isV()) {
            return;
        }
        this.v = j40Var2;
        this.D = getCurrentPosition();
        J();
        this.B.post(new c());
        if (z || this.f.isPlaying()) {
            this.f.seekTo(z2 ? 0 : getDuration());
            this.f.pause();
            s();
        }
        if (z) {
            this.M = false;
        }
    }

    private void j() {
        this.N = getCurrentPosition();
        if (!this.q.get() || this.N <= 0 || oi.a().c()) {
            return;
        }
        oi.a().e();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006b  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r8, int r9) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.mh.onMeasure(int, int):void");
    }

    @Override // com.qq.e.comm.plugin.mk
    public q40 g() {
        return this.b;
    }

    @Override // com.qq.e.comm.plugin.mk
    public int f() {
        return getWidth();
    }

    @Override // com.qq.e.comm.plugin.mk
    public int h() {
        return getHeight();
    }

    private void K() {
        AudioManager audioManager;
        if (this.m.get() || this.v != j40.PLAY || (audioManager = this.g) == null) {
            return;
        }
        audioManager.requestAudioFocus(null, 3, 2);
    }

    private void J() {
        AudioManager audioManager = this.g;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(null);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                A();
                return false;
            case 2:
                z();
                return false;
            case 3:
                b(message.arg1 == 1, message.arg2 == 1);
                return false;
            case 4:
                C();
                return false;
            case 5:
                E();
                return false;
            case 6:
                t();
                return false;
            case 7:
                a(String.valueOf(message.obj));
                return false;
            case 8:
                F();
                return false;
            case 9:
                G();
                return false;
            case 10:
                a(message.arg1);
                return false;
            case 11:
            default:
                return false;
            case 12:
                p();
                return false;
            case 13:
                j();
                return false;
            case 14:
                x();
                return false;
            case 15:
                this.u = true;
                z();
                return false;
            case 16:
                this.u = false;
                A();
                return false;
            case 17:
                a(((Float) message.obj).floatValue());
                return false;
        }
    }

    public void l() {
        yj yjVar = this.S;
        if (yjVar != null) {
            yjVar.onP();
        } else {
            play();
        }
    }

    public void k() {
        yj yjVar = this.S;
        if (yjVar != null) {
            yjVar.onPause();
        } else {
            pause();
        }
    }

    public void m() {
        yj yjVar = this.S;
        if (yjVar != null) {
            yjVar.onStop();
        } else {
            I();
        }
    }

    public void b(int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        this.G.a(i2, i3);
        this.c = i2;
        this.d = i3;
        wg wgVar = this.r;
        if (wgVar == null || !(wgVar instanceof rg)) {
            return;
        }
        if (i2 == this.y && i3 == this.z) {
            return;
        }
        this.y = i2;
        this.z = i3;
        ((rg) wgVar).a(i2, i3);
    }

    private void a(int i2) {
        try {
            if (w()) {
                this.f.seekTo(i2);
                this.n.set(false);
                this.o = 0;
                return;
            }
        } catch (Exception unused) {
        }
        this.n.set(true);
        this.o = i2;
    }

    public void a(h4 h4Var) {
        if (h4Var == null) {
            return;
        }
        this.j = h4Var;
        this.a += h4Var.R0();
        this.q.set(h4Var.n1());
        yg ygVar = this.s;
        if (ygVar instanceof zg) {
            return;
        }
        this.s = new zg(this, ygVar, h4Var);
    }

    private void a(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("127.0.0.1")) {
            str = str.replace("12345567", String.valueOf(hashCode()));
        }
        D();
        this.f.setDataSource(str);
        this.f779K = str;
        H();
    }

    public void a(boolean z) {
        this.p.set(z);
    }

    public void a(yj yjVar) {
        this.S = yjVar;
    }

    public void a(wg wgVar) {
        this.r = wgVar;
        if (this.c > 0 && this.d > 0) {
            wg wgVar2 = this.r;
            if (wgVar2 instanceof rg) {
                ((rg) wgVar2).a(this.c, this.d);
            }
        }
        s();
        b();
    }

    @Override // com.qq.e.comm.plugin.mk
    public void a(yg ygVar) {
        Boolean bool;
        h4 h4Var = this.j;
        if (h4Var == null) {
            this.s = ygVar;
        } else {
            this.s = new zg(this, ygVar, h4Var);
        }
        if (ygVar == null || (bool = this.t) == null) {
            return;
        }
        if (bool.booleanValue()) {
            n();
        } else {
            o();
        }
    }

    public void a(ah ahVar) {
        if (ahVar == null) {
            return;
        }
        this.H = ahVar;
    }

    @Deprecated
    public void a(int i2, int i3) {
        this.h = i2;
        this.i = i3;
    }

    public void a(dy dyVar) {
        this.w = dyVar;
    }

    public void a(l lVar) {
        this.Q = lVar;
    }

    private void a(float f2) {
        if (!this.f.isV() || M() || this.E == f2) {
            return;
        }
        this.f.setSpeed(f2);
        this.E = f2;
    }

    @Override // com.qq.e.comm.plugin.mk
    public void a() {
        this.A.sendEmptyMessage(8);
    }
}

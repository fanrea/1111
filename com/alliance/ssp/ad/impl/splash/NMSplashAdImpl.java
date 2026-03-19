package com.alliance.ssp.ad.impl.splash;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.alliance.ssp.ad.activity.SAAllianceWebViewActivity;
import com.alliance.ssp.ad.api.SAAllianceAdParams;
import com.alliance.ssp.ad.api.YTAdInfo;
import com.alliance.ssp.ad.api.splash.SASplashAdInteractionListener;
import com.alliance.ssp.ad.api.splash.SASplashAdLoadListener;
import com.alliance.ssp.ad.bean.Interaction;
import com.alliance.ssp.ad.bean.Material;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.bean.SAAllianceEngineData;
import com.alliance.ssp.ad.bean.Shake;
import com.alliance.ssp.ad.http.action.BaseNetAction;
import com.alliance.ssp.ad.l.c;
import com.alliance.ssp.ad.l.k;
import com.alliance.ssp.ad.l.l;
import com.alliance.ssp.ad.o0.j;
import com.alliance.ssp.ad.o0.n;
import com.alliance.ssp.ad.o0.s;
import com.alliance.ssp.ad.r.c;
import com.alliance.ssp.ad.r.i;
import com.alliance.ssp.ad.t.h;
import com.alliance.ssp.ad.video.VideoController;
import com.alliance.ssp.ad.video.f;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class NMSplashAdImpl extends com.alliance.ssp.ad.z.a implements f.a {
    public boolean A1;
    public com.alliance.ssp.ad.m0.a B1;
    public l C1;
    public NMSplashAdImpl D0;
    public boolean D1;
    public com.alliance.ssp.ad.impl.splash.c E0;
    public boolean E1;
    public ViewGroup F0;
    public float F1;
    public FrameLayout G0;
    public boolean G1;
    public FrameLayout H0;
    public boolean H1;
    public FrameLayout I0;
    public boolean I1;
    public FrameLayout J0;
    public int J1;
    public FrameLayout K0;
    public FrameLayout L0;
    public ImageView M0;
    public ImageView N0;
    public FrameLayout O0;
    public TextView P0;
    public TextView Q0;
    public com.alliance.ssp.ad.l.c R0;
    public Bitmap S0;
    public Material T0;
    public Shake U0;
    public String V0;
    public String W0;
    public String X0;
    public int Y0;
    public int Z0;
    public int a1;
    public long b1;
    public boolean c1;
    public boolean d1;
    public boolean e1;
    public boolean f1;
    public boolean g1;
    public boolean h1;
    public boolean i1;
    public boolean j1;
    public Handler k1;
    public Handler l1;
    public VideoController m1;
    public int n1;
    public SAAllianceAdData o1;
    public String p1;
    public boolean q1;
    public boolean r1;
    public int s1;
    public int t1;
    public int u1;
    public int v1;
    public int w1;
    public SPLASH_STATE x1;
    public ViewGroup y1;
    public k z1;

    public enum SPLASH_STATE {
        IDLE,
        REQUESTING,
        LOADING,
        RENDERING,
        SHOWING,
        NO_FORE,
        DESTROY,
        ERROR
    }

    public class b implements VideoController.h {
        public b() {
        }

        @Override // com.alliance.ssp.ad.video.VideoController.h
        public void a(boolean z) {
            if (z) {
                NMSplashAdImpl nMSplashAdImpl = NMSplashAdImpl.this;
                nMSplashAdImpl.o("", "", nMSplashAdImpl.h);
            } else {
                NMSplashAdImpl nMSplashAdImpl2 = NMSplashAdImpl.this;
                nMSplashAdImpl2.j("", "", nMSplashAdImpl2.h);
            }
        }
    }

    public class c implements com.alliance.ssp.ad.c0.a {
        public c() {
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalStateException {
            VideoController videoController = NMSplashAdImpl.this.m1;
            if (videoController != null) {
                videoController.f();
            }
        }
    }

    public NMSplashAdImpl(int i, WeakReference<Activity> weakReference, ViewGroup viewGroup, int i2, SAAllianceAdParams sAAllianceAdParams, SASplashAdLoadListener sASplashAdLoadListener, com.alliance.ssp.ad.d0.g gVar) {
        super(i, weakReference, "", "", viewGroup, i2, sAAllianceAdParams, sASplashAdLoadListener, null, gVar);
        this.E0 = null;
        this.K0 = null;
        this.M0 = null;
        this.N0 = null;
        this.O0 = null;
        this.P0 = null;
        this.Q0 = null;
        this.S0 = null;
        this.V0 = "";
        this.W0 = "";
        this.Z0 = 1;
        this.a1 = 0;
        this.b1 = 0L;
        this.c1 = false;
        this.d1 = false;
        this.e1 = false;
        this.f1 = false;
        this.g1 = false;
        this.h1 = false;
        this.i1 = false;
        this.j1 = false;
        this.n1 = 1;
        this.q1 = false;
        this.r1 = true;
        this.s1 = 0;
        this.t1 = 0;
        this.u1 = 0;
        this.v1 = 0;
        this.w1 = 3000;
        this.x1 = SPLASH_STATE.IDLE;
        this.y1 = null;
        this.A1 = false;
        this.C1 = null;
        this.D1 = false;
        this.E1 = false;
        this.F1 = -1.0f;
        this.G1 = false;
        this.H1 = false;
        this.I1 = false;
        this.J1 = 0;
        gVar.e = this;
        this.D0 = this;
        this.X0 = sAAllianceAdParams.getPosId();
        if (i2 > 0) {
            this.w1 = i2;
        }
        a(sAAllianceAdParams);
        this.x1 = SPLASH_STATE.REQUESTING;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I() {
        TextView textView = this.P0;
        if (textView != null) {
            textView.setText("跳过");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J() {
        int i = com.alliance.ssp.ad.o0.l.a;
        i.a().a(this.T0.getAdm(), new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final View view, final double d2, final double d3) throws JSONException, PackageManager.NameNotFoundException, IOException {
        com.alliance.ssp.ad.l.c cVar;
        try {
            n nVar = n.d;
            nVar.c.post(new Runnable() { // from class: com.alliance.ssp.ad.impl.splash.NMSplashAdImpl$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
                    this.f$0.a(d3, d2);
                }
            });
            if (d2 >= 0.2d && (cVar = this.R0) != null && !this.D1) {
                this.D1 = true;
                cVar.b();
            }
            float f2 = this.A;
            if (f2 >= 0.0f && ((float) d2) == f2 && b()) {
                nVar.c.post(new Runnable() { // from class: com.alliance.ssp.ad.impl.splash.NMSplashAdImpl$$ExternalSyntheticLambda14
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.f(view);
                    }
                });
                if (a("unuser", 0)) {
                    this.B = true;
                    c(1);
                }
            }
        } catch (Exception e2) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("NMSplashAdImpl 004: ")), e2);
        }
    }

    public static /* synthetic */ boolean b(NMSplashAdImpl nMSplashAdImpl, boolean z) {
        nMSplashAdImpl.getClass();
        return z;
    }

    public static /* synthetic */ boolean e(NMSplashAdImpl nMSplashAdImpl, boolean z) {
        nMSplashAdImpl.getClass();
        return z;
    }

    public final void E() {
        l lVar = this.C1;
        if (lVar != null) {
            lVar.b();
        }
        VideoController videoController = this.m1;
        if (videoController != null && !this.d1 && videoController.f()) {
            k("", "", this.h);
        }
        this.q = true;
        com.alliance.ssp.ad.l.c cVar = this.R0;
        if (cVar != null) {
            cVar.a();
        }
        k kVar = this.z1;
        if (kVar != null) {
            kVar.f();
        }
    }

    public final void F() {
        l lVar = this.C1;
        if (lVar != null) {
            lVar.c();
        }
        l lVar2 = this.C1;
        if (lVar2 != null) {
            lVar2.c();
        }
        VideoController videoController = this.m1;
        if (videoController != null && !this.d1 && videoController.i()) {
            b(this.h);
        }
        this.q = false;
        com.alliance.ssp.ad.l.c cVar = this.R0;
        if (cVar != null) {
            cVar.f();
        }
        if (this.x1.equals(SPLASH_STATE.NO_FORE)) {
            this.x1 = SPLASH_STATE.SHOWING;
        }
        k kVar = this.z1;
        if (kVar != null) {
            kVar.g();
        }
    }

    public final void G() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        Context contextA = com.alliance.ssp.ad.o0.b.a(this.f);
        if (contextA != null) {
            if (contextA instanceof Activity) {
                int i = com.alliance.ssp.ad.o0.l.a;
                ((Activity) contextA).setRequestedOrientation(this.Z0);
            } else {
                Activity activityB = com.alliance.ssp.ad.o0.b.b();
                if (activityB != null) {
                    int i2 = com.alliance.ssp.ad.o0.l.a;
                    activityB.setRequestedOrientation(this.Z0);
                }
            }
        }
        M();
        p();
    }

    public final void H() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (this.A1) {
            int i = this.t1;
            if (i != 0) {
                if (i == 1) {
                    F();
                } else if (i == 2) {
                    d(1);
                    G();
                }
            } else if (this.E1) {
                d(1);
                G();
            }
            this.A1 = false;
        }
        this.q = false;
        com.alliance.ssp.ad.l.c cVar = this.R0;
        if (cVar != null) {
            cVar.f();
        }
    }

    public final void K() {
        t();
        int i = com.alliance.ssp.ad.o0.l.a;
        this.x1 = SPLASH_STATE.LOADING;
        final Context contextA = com.alliance.ssp.ad.o0.b.a(this.f);
        Runnable runnable = new Runnable() { // from class: com.alliance.ssp.ad.impl.splash.NMSplashAdImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(contextA);
            }
        };
        Runnable runnable2 = new Runnable() { // from class: com.alliance.ssp.ad.impl.splash.NMSplashAdImpl$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.J();
            }
        };
        this.T0.getAdm();
        if (this.h1) {
            VideoController videoController = new VideoController(contextA, this.W0, this.F0, false, false, this.r1, this);
            this.m1 = videoController;
            this.p = videoController;
            videoController.D = true;
            videoController.E = true;
            return;
        }
        if (this.T0.getAdm().endsWith(PictureMimeType.GIF) && contextA != null) {
            n.d.a.execute(runnable);
        } else if (this.T0.getAdm() == null || this.T0.getAdm().isEmpty()) {
            this.x1 = SPLASH_STATE.ERROR;
        } else {
            n.d.a.execute(runnable2);
        }
    }

    public final void L() {
        Context contextA = com.alliance.ssp.ad.o0.b.a(this.f);
        if (contextA == null) {
            return;
        }
        com.alliance.ssp.ad.m0.a aVar = new com.alliance.ssp.ad.m0.a(new com.alliance.ssp.ad.m0.c() { // from class: com.alliance.ssp.ad.impl.splash.NMSplashAdImpl$$ExternalSyntheticLambda0
            @Override // com.alliance.ssp.ad.m0.c
            public final void a(Object obj) {
                this.f$0.a((Intent) obj);
            }
        }, contextA);
        this.B1 = aVar;
        aVar.b("SA_TARGET_YT_WEB_ACTIVITY_FINISHED");
    }

    public final void M() {
        VideoController videoController = this.m1;
        if (videoController != null) {
            videoController.g();
        }
        this.q = false;
        com.alliance.ssp.ad.l.c cVar = this.R0;
        if (cVar != null) {
            cVar.g();
        }
        k kVar = this.z1;
        if (kVar != null) {
            kVar.b();
        }
        this.x1 = SPLASH_STATE.DESTROY;
        com.alliance.ssp.ad.m0.a aVar = this.B1;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void b(int i) {
    }

    public final void d(final int i) {
        n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.impl.splash.NMSplashAdImpl$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.e(i);
            }
        });
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void onError(MediaPlayer mediaPlayer, int i, int i2) {
        int i3 = com.alliance.ssp.ad.o0.l.a;
        a("Show failure", 100006, "1", "素材不可用");
        q("", "", this.h);
        b(100006, "1", "加载素材失败");
        this.x1 = SPLASH_STATE.ERROR;
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        VideoController videoController;
        int i3 = com.alliance.ssp.ad.o0.l.a;
        if (i != 3 || (videoController = this.m1) == null) {
            return;
        }
        videoController.b(false);
    }

    @Override // com.alliance.ssp.ad.t.a
    public void q() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        H();
    }

    @Override // com.alliance.ssp.ad.t.a
    public void r() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Context context) {
        int i = com.alliance.ssp.ad.o0.l.a;
        j.a().a(context, this.T0.getAdm(), "aaaccc", new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        int i = com.alliance.ssp.ad.o0.l.a;
        a("user", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        int i = com.alliance.ssp.ad.o0.l.a;
        if (this.n1 == 1) {
            a(this.G0, "1");
        } else {
            a(view, (String) null);
        }
    }

    public final void g(View view) {
        if (view != null) {
            view.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.alliance.ssp.ad.impl.splash.NMSplashAdImpl$$ExternalSyntheticLambda9
                @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
                public final void onWindowFocusChanged(boolean z) throws IllegalStateException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
                    this.f$0.a(z);
                }
            });
        }
    }

    public final void b(View view, ViewGroup viewGroup) throws JSONException, PackageManager.NameNotFoundException, IOException {
        FrameLayout frameLayout;
        VideoController videoController = this.m1;
        if (videoController == null) {
            int i = com.alliance.ssp.ad.o0.l.a;
            return;
        }
        this.O0.addView(videoController.r.a(new com.alliance.ssp.ad.video.b(videoController, new b())));
        a(this.O0, 88);
        FrameLayout frameLayout2 = this.K0;
        if (frameLayout2 != null && (frameLayout = this.m1.t) != null) {
            frameLayout2.addView(frameLayout);
        }
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        viewGroup.setVisibility(4);
        new com.alliance.ssp.ad.z.c(this, Looper.getMainLooper(), viewGroup).sendEmptyMessageDelayed(0, 100L);
        if (this.n1 == 0) {
            this.K0.setOnClickListener(new View.OnClickListener() { // from class: com.alliance.ssp.ad.impl.splash.NMSplashAdImpl$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.e(view2);
                }
            });
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        this.X = com.alliance.ssp.ad.a.f.a("", i2);
        this.Y = com.alliance.ssp.ad.a.f.a("", i3);
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.G = "" + jCurrentTimeMillis;
        this.H = String.valueOf((int) (jCurrentTimeMillis / 1000));
        int i4 = com.alliance.ssp.ad.o0.l.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        int i = com.alliance.ssp.ad.o0.l.a;
        a("user", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        SASplashAdInteractionListener sASplashAdInteractionListener;
        synchronized (com.alliance.ssp.ad.impl.splash.c.f) {
            try {
                com.alliance.ssp.ad.impl.splash.c cVar = this.E0;
                if (cVar != null && (sASplashAdInteractionListener = cVar.c) != null) {
                    if (i == 0) {
                        sASplashAdInteractionListener.onAdSkip();
                    } else if (i == 1) {
                        sASplashAdInteractionListener.onAdTimeOver();
                    } else if (i != 2) {
                        if (i == 3 && this.v1 != 1) {
                            sASplashAdInteractionListener.onAdClick();
                            x();
                        }
                    } else {
                        sASplashAdInteractionListener.onAdShow();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        int i = com.alliance.ssp.ad.o0.l.a;
        a("user", 0);
    }

    public class e implements j.b {
        public e() {
        }

        @Override // com.alliance.ssp.ad.o0.j.b
        public void a(int i) {
        }

        @Override // com.alliance.ssp.ad.o0.j.b
        public void a(File file) {
            NMSplashAdImpl.this.V0 = file.getAbsolutePath() + "/aaaccc.gif";
            NMSplashAdImpl.this.s();
            NMSplashAdImpl nMSplashAdImpl = NMSplashAdImpl.this;
            long jCurrentTimeMillis = System.currentTimeMillis();
            NMSplashAdImpl nMSplashAdImpl2 = NMSplashAdImpl.this;
            nMSplashAdImpl.b1 = jCurrentTimeMillis - nMSplashAdImpl2.b1;
            long j = nMSplashAdImpl2.b1;
            int i = com.alliance.ssp.ad.o0.l.a;
        }

        @Override // com.alliance.ssp.ad.o0.j.b
        public void a(Exception exc) {
            NMSplashAdImpl.this.b1 = System.currentTimeMillis() - NMSplashAdImpl.this.b1;
            long j = NMSplashAdImpl.this.b1;
            exc.getMessage();
            int i = com.alliance.ssp.ad.o0.l.a;
            NMSplashAdImpl.this.b(100006, "1", "加载gif素材失败");
            NMSplashAdImpl.this.x1 = SPLASH_STATE.ERROR;
        }
    }

    public class f implements i.a {
        public f() {
        }

        @Override // com.alliance.ssp.ad.r.i.a
        public void a(String str, Bitmap bitmap) {
            NMSplashAdImpl nMSplashAdImpl = NMSplashAdImpl.this;
            nMSplashAdImpl.v = bitmap;
            nMSplashAdImpl.S0 = bitmap;
            nMSplashAdImpl.s();
            NMSplashAdImpl.this.b1 = System.currentTimeMillis() - NMSplashAdImpl.this.b1;
            long j = NMSplashAdImpl.this.b1;
            int i = com.alliance.ssp.ad.o0.l.a;
        }

        @Override // com.alliance.ssp.ad.r.i.a
        public void a(String str, Exception exc) {
            exc.getMessage();
            int i = com.alliance.ssp.ad.o0.l.a;
            NMSplashAdImpl.this.b(100006, "1", "加载image素材失败");
            NMSplashAdImpl.this.x1 = SPLASH_STATE.ERROR;
        }
    }

    public class a implements k.b {
        public a() {
        }

        public void a(View view, float f, float f2, float f3, float f4) {
            NMSplashAdImpl nMSplashAdImpl = NMSplashAdImpl.this;
            if (nMSplashAdImpl.x1 != SPLASH_STATE.SHOWING) {
                return;
            }
            NMSplashAdImpl.a(nMSplashAdImpl, true);
            NMSplashAdImpl nMSplashAdImpl2 = NMSplashAdImpl.this;
            nMSplashAdImpl2.getClass();
            nMSplashAdImpl2.P = "" + ((int) f);
            nMSplashAdImpl2.Q = com.alliance.ssp.ad.a.b.a("").append((int) f2).toString();
            nMSplashAdImpl2.R = com.alliance.ssp.ad.a.b.a("").append((int) f3).toString();
            nMSplashAdImpl2.S = com.alliance.ssp.ad.a.b.a("").append((int) f4).toString();
            Point pointA = nMSplashAdImpl2.a(view, f, f2);
            Point pointA2 = nMSplashAdImpl2.a(view, f3, f4);
            nMSplashAdImpl2.f716K = com.alliance.ssp.ad.a.b.a("").append(pointA.x).toString();
            nMSplashAdImpl2.L = com.alliance.ssp.ad.a.b.a("").append(pointA.y).toString();
            nMSplashAdImpl2.M = com.alliance.ssp.ad.a.b.a("").append(pointA2.x).toString();
            nMSplashAdImpl2.N = com.alliance.ssp.ad.a.b.a("").append(pointA2.y).toString();
            if (NMSplashAdImpl.this.a("swipe", 0)) {
                return;
            }
            NMSplashAdImpl.b(NMSplashAdImpl.this, false);
        }

        public void a(View view, float f, float f2) {
            NMSplashAdImpl nMSplashAdImpl = NMSplashAdImpl.this;
            if (nMSplashAdImpl.x1 != SPLASH_STATE.SHOWING) {
                return;
            }
            int i = (int) f;
            nMSplashAdImpl.P = com.alliance.ssp.ad.a.b.a("").append(i).toString();
            int i2 = (int) f2;
            nMSplashAdImpl.Q = com.alliance.ssp.ad.a.b.a("").append(i2).toString();
            nMSplashAdImpl.R = com.alliance.ssp.ad.a.f.a("", i);
            nMSplashAdImpl.S = com.alliance.ssp.ad.a.f.a("", i2);
            Point pointA = nMSplashAdImpl.a(view, f, f2);
            nMSplashAdImpl.f716K = com.alliance.ssp.ad.a.b.a("").append(pointA.x).toString();
            nMSplashAdImpl.L = com.alliance.ssp.ad.a.b.a("").append(pointA.y).toString();
            nMSplashAdImpl.M = com.alliance.ssp.ad.a.b.a("").append(pointA.x).toString();
            nMSplashAdImpl.N = com.alliance.ssp.ad.a.b.a("").append(pointA.y).toString();
            NMSplashAdImpl.this.a("user", 1);
        }
    }

    public static void a(NMSplashAdImpl nMSplashAdImpl, int i, String str, String str2) {
        Handler handler;
        nMSplashAdImpl.getClass();
        int i2 = com.alliance.ssp.ad.o0.l.a;
        if (nMSplashAdImpl.o1 != null && (handler = nMSplashAdImpl.l1) != null) {
            handler.removeCallbacksAndMessages(null);
            nMSplashAdImpl.l1.sendEmptyMessage(0);
        } else {
            nMSplashAdImpl.a(i, str, str2);
            nMSplashAdImpl.x1 = SPLASH_STATE.ERROR;
            com.alliance.ssp.ad.t.i.a(nMSplashAdImpl.w, nMSplashAdImpl.X0, i, str2);
        }
    }

    public final void b(Context context) {
        if (context != null) {
            try {
                if (this.U0 != null) {
                    int i = 108;
                    int i2 = 1;
                    if (this.T0.getTempid() != null && !this.T0.getTempid().isEmpty() && !this.T0.getTempid().equals("1100001") && this.T0.getTempid().equals("1100002")) {
                        i2 = 3;
                        i = 154;
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.H0.getLayoutParams();
                        int i3 = (int) ((154 * context.getResources().getDisplayMetrics().density) + 0.5f);
                        layoutParams.width = i3;
                        layoutParams.height = i3;
                        this.H0.setLayoutParams(layoutParams);
                    }
                    com.alliance.ssp.ad.l.c cVar = new com.alliance.ssp.ad.l.c(context, i2, i, this.U0, new c.b() { // from class: com.alliance.ssp.ad.impl.splash.NMSplashAdImpl$$ExternalSyntheticLambda10
                        @Override // com.alliance.ssp.ad.l.c.b
                        public final void a(int[] iArr) {
                            this.f$0.a(iArr);
                        }
                    });
                    this.R0 = cVar;
                    this.H0.addView(cVar.h);
                    this.u1 = this.U0.getResetSensitivity();
                    return;
                }
            } catch (Exception e2) {
                e2.getMessage();
                int i4 = com.alliance.ssp.ad.o0.l.a;
                return;
            }
        }
        this.H0.setVisibility(8);
    }

    public static /* synthetic */ boolean a(NMSplashAdImpl nMSplashAdImpl, boolean z) {
        nMSplashAdImpl.getClass();
        return z;
    }

    public static void a(NMSplashAdImpl nMSplashAdImpl, String str) {
        SAAllianceAdData sAAllianceAdDataCopy;
        nMSplashAdImpl.getClass();
        int i = com.alliance.ssp.ad.o0.l.a;
        Context contextA = com.alliance.ssp.ad.o0.b.a(nMSplashAdImpl.f);
        if (contextA == null || (sAAllianceAdDataCopy = nMSplashAdImpl.h.copy()) == null) {
            return;
        }
        if (sAAllianceAdDataCopy.getMaterial() == null) {
            sAAllianceAdDataCopy.setMaterial(new Material(null));
        }
        sAAllianceAdDataCopy.getMaterial().setLdp(str);
        if (sAAllianceAdDataCopy.getInteraction() == null) {
            sAAllianceAdDataCopy.setInteraction(new Interaction(null));
        }
        sAAllianceAdDataCopy.setInteraction(nMSplashAdImpl.h.getInteraction());
        Intent intent = new Intent(contextA, (Class<?>) SAAllianceWebViewActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("extra_name_land_page_ad_data", sAAllianceAdDataCopy);
        contextA.startActivity(intent);
    }

    public class d implements com.alliance.ssp.ad.p.a<SAAllianceEngineData> {
        public final /* synthetic */ Context a;

        public d(Context context) {
            this.a = context;
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(SAAllianceEngineData sAAllianceEngineData) throws JSONException, PackageManager.NameNotFoundException, IOException {
            SAAllianceEngineData sAAllianceEngineData2 = sAAllianceEngineData;
            if (sAAllianceEngineData2 == null) {
                NMSplashAdImpl.a(NMSplashAdImpl.this, 8193, "002", "无广告填充，请联系技术进行排查。");
                return;
            }
            try {
                List<SAAllianceAdData> data = sAAllianceEngineData2.getData();
                if (data == null) {
                    NMSplashAdImpl.a(NMSplashAdImpl.this, sAAllianceEngineData2.getCode(), "001", sAAllianceEngineData2.getMessage());
                    return;
                }
                if (data.size() > 0 && sAAllianceEngineData2.getData() != null && !sAAllianceEngineData2.getData().isEmpty()) {
                    for (SAAllianceAdData sAAllianceAdData : data) {
                        sAAllianceAdData.setDeadlineTime(NMSplashAdImpl.this.E.a(sAAllianceAdData.getCacheTimeout()));
                        sAAllianceAdData.setPriceD(NMSplashAdImpl.this.E.a(sAAllianceAdData.getPrice()));
                        NMSplashAdImpl nMSplashAdImpl = NMSplashAdImpl.this;
                        h hVar = nMSplashAdImpl.E;
                        if (hVar != null) {
                            hVar.a(this.a, nMSplashAdImpl.X0, sAAllianceAdData.getWaitLoadTimeout());
                            if (sAAllianceAdData.isNeedCache()) {
                                sAAllianceAdData.setRequestid(NMSplashAdImpl.this.w);
                                NMSplashAdImpl nMSplashAdImpl2 = NMSplashAdImpl.this;
                                nMSplashAdImpl2.E.a(this.a, sAAllianceAdData, nMSplashAdImpl2.X0);
                            }
                        }
                        NMSplashAdImpl nMSplashAdImpl3 = NMSplashAdImpl.this;
                        if (!nMSplashAdImpl3.q1) {
                            Handler handler = nMSplashAdImpl3.l1;
                            if (handler != null) {
                                handler.removeCallbacksAndMessages(null);
                                NMSplashAdImpl.this.l1 = null;
                            }
                            NMSplashAdImpl nMSplashAdImpl4 = NMSplashAdImpl.this;
                            NMSplashAdImpl.a(nMSplashAdImpl4, nMSplashAdImpl4.o1, sAAllianceAdData);
                        }
                    }
                    return;
                }
                NMSplashAdImpl.a(NMSplashAdImpl.this, sAAllianceEngineData2.getCode(), "003", sAAllianceEngineData2.getMessage());
            } catch (Exception e) {
                e.getMessage();
                int i = com.alliance.ssp.ad.o0.l.a;
                new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("NMSplashAdImpl 001: ")), e);
                NMSplashAdImpl nMSplashAdImpl5 = NMSplashAdImpl.this;
                nMSplashAdImpl5.x1 = SPLASH_STATE.ERROR;
                nMSplashAdImpl5.a(8194, "001", "渲染失败。");
                NMSplashAdImpl nMSplashAdImpl6 = NMSplashAdImpl.this;
                com.alliance.ssp.ad.t.i.a(nMSplashAdImpl6.w, nMSplashAdImpl6.X0, 8194, "渲染失败。");
            }
        }

        @Override // com.alliance.ssp.ad.p.a
        public void a(int i, String str) {
            NMSplashAdImpl.a(NMSplashAdImpl.this, i, "004", str);
        }
    }

    public static void a(NMSplashAdImpl nMSplashAdImpl, SAAllianceAdData sAAllianceAdData, SAAllianceAdData sAAllianceAdData2) throws JSONException, PackageManager.NameNotFoundException, IOException {
        nMSplashAdImpl.getClass();
        try {
            if (sAAllianceAdData == null) {
                nMSplashAdImpl.h = sAAllianceAdData2;
                nMSplashAdImpl.p1 = nMSplashAdImpl.w;
            } else if (sAAllianceAdData2 != null && sAAllianceAdData.getPriceD() <= sAAllianceAdData2.getPriceD()) {
                nMSplashAdImpl.h = sAAllianceAdData2;
                nMSplashAdImpl.p1 = nMSplashAdImpl.w;
            } else {
                nMSplashAdImpl.h = sAAllianceAdData;
                nMSplashAdImpl.p1 = sAAllianceAdData.getRequestid();
                nMSplashAdImpl.h.setParentCrequestid(sAAllianceAdData.getRequestid());
            }
            nMSplashAdImpl.h.setCrequestid(nMSplashAdImpl.w);
            nMSplashAdImpl.E.a(nMSplashAdImpl.X0, nMSplashAdImpl.p1);
            int i = com.alliance.ssp.ad.o0.l.a;
            nMSplashAdImpl.h.setSpostype(Integer.parseInt(nMSplashAdImpl.j0));
            nMSplashAdImpl.h.getRestype();
            nMSplashAdImpl.v1 = nMSplashAdImpl.h.getClickCallbackSwitch();
            if (nMSplashAdImpl.h.getMaterial() == null) {
                nMSplashAdImpl.a(8196, "001", "广告素材为空，请联系运营检查代码位ID配置情况。01");
                com.alliance.ssp.ad.t.i.a(nMSplashAdImpl.w, nMSplashAdImpl.X0, 8196, "广告素材为空，请联系运营检查代码位ID配置情况。01");
                return;
            }
            Material material = nMSplashAdImpl.h.getMaterial();
            nMSplashAdImpl.T0 = material;
            if (material != null) {
                material.getTempid();
                nMSplashAdImpl.Y0 = nMSplashAdImpl.T0.getLdptype();
            }
            String tagCode = nMSplashAdImpl.h.getTagCode();
            if (tagCode != null && !tagCode.isEmpty()) {
                nMSplashAdImpl.o = tagCode;
            }
            String price = nMSplashAdImpl.h.getPrice();
            nMSplashAdImpl.s = price;
            if (price == null || price.isEmpty()) {
                nMSplashAdImpl.s = "-1";
            }
            if (nMSplashAdImpl.h.getInteraction() != null) {
                if (nMSplashAdImpl.h.getInteraction().getShake() != null) {
                    nMSplashAdImpl.U0 = nMSplashAdImpl.h.getInteraction().getShake();
                    nMSplashAdImpl.s1 = 1;
                } else if (nMSplashAdImpl.h.getInteraction().getSwipe() != null) {
                    nMSplashAdImpl.s1 = 2;
                }
                int i2 = nMSplashAdImpl.h.getInteraction().clickArea;
                nMSplashAdImpl.n1 = i2;
                if (i2 == -1) {
                    nMSplashAdImpl.n1 = 1;
                }
            }
            int splashClickFollow = nMSplashAdImpl.h.getSplashClickFollow();
            nMSplashAdImpl.t1 = splashClickFollow;
            if (splashClickFollow < 0 || splashClickFollow > 2) {
                nMSplashAdImpl.t1 = 0;
            }
            SAAllianceAdParams sAAllianceAdParams = nMSplashAdImpl.g;
            if (sAAllianceAdParams != null && sAAllianceAdParams.getUserId() != null && !nMSplashAdImpl.g.getUserId().isEmpty()) {
                nMSplashAdImpl.h.setUserId(nMSplashAdImpl.g.getUserId());
            }
            com.alliance.ssp.ad.impl.splash.c cVar = new com.alliance.ssp.ad.impl.splash.c(nMSplashAdImpl.v, nMSplashAdImpl.D0);
            nMSplashAdImpl.E0 = cVar;
            cVar.a = nMSplashAdImpl.s;
            String videourl = nMSplashAdImpl.T0.getVideourl();
            nMSplashAdImpl.W0 = videourl;
            if (videourl != null && !videourl.isEmpty()) {
                nMSplashAdImpl.h1 = true;
                nMSplashAdImpl.e1 = true;
                nMSplashAdImpl.E0.b = new YTAdInfo(new ArrayList<String>() { // from class: com.alliance.ssp.ad.impl.splash.NMSplashAdImpl.3
                    {
                        add(NMSplashAdImpl.this.W0);
                    }
                });
            } else {
                nMSplashAdImpl.f1 = true;
                nMSplashAdImpl.E0.b = new YTAdInfo(new ArrayList<String>() { // from class: com.alliance.ssp.ad.impl.splash.NMSplashAdImpl.4
                    {
                        add(NMSplashAdImpl.this.T0.getAdm());
                    }
                });
            }
            nMSplashAdImpl.a(nMSplashAdImpl.E0);
            com.alliance.ssp.ad.t.i.a(nMSplashAdImpl.w, nMSplashAdImpl.X0);
            nMSplashAdImpl.q1 = true;
            System.currentTimeMillis();
            nMSplashAdImpl.K();
        } catch (Exception e2) {
            e2.getMessage();
            int i3 = com.alliance.ssp.ad.o0.l.a;
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("NMSplashAdImpl 002: ")), e2);
            nMSplashAdImpl.x1 = SPLASH_STATE.ERROR;
            nMSplashAdImpl.a(8194, "001", "渲染失败。");
            com.alliance.ssp.ad.t.i.a(nMSplashAdImpl.w, nMSplashAdImpl.X0, 8194, "渲染失败。");
        }
    }

    public final void b(final View view) {
        this.C1 = l.a(5000L, 100L, new l.a() { // from class: com.alliance.ssp.ad.impl.splash.NMSplashAdImpl$$ExternalSyntheticLambda8
            @Override // com.alliance.ssp.ad.l.l.a
            public final void a(double d2, double d3) throws JSONException, PackageManager.NameNotFoundException, IOException {
                this.f$0.a(view, d2, d3);
            }
        });
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void b(MediaPlayer mediaPlayer) {
        s();
        if (!this.k0) {
            l("", "", this.h);
        }
        System.currentTimeMillis();
        int i = com.alliance.ssp.ad.o0.l.a;
        mediaPlayer.setVideoScalingMode(2);
    }

    public final void a(SAAllianceAdParams sAAllianceAdParams) {
        System.currentTimeMillis();
        int i = com.alliance.ssp.ad.o0.l.a;
        Context contextA = com.alliance.ssp.ad.o0.b.a(this.f);
        SAAllianceAdData sAAllianceAdDataA = a(contextA, this.X0);
        this.o1 = sAAllianceAdDataA;
        if (sAAllianceAdDataA != null) {
            long jA = this.E.a(contextA, this.X0);
            this.o1.getRequestid();
            this.o1.getPriceD();
            com.alliance.ssp.ad.z.e eVar = new com.alliance.ssp.ad.z.e(this, Looper.getMainLooper());
            this.l1 = eVar;
            eVar.sendEmptyMessageDelayed(0, jA);
        }
        this.b1 = System.currentTimeMillis();
        sAAllianceAdParams.setImageAcceptedWidth(SAAllianceAdParams.Screen_Width);
        sAAllianceAdParams.setImageAcceptedHeight(SAAllianceAdParams.Screen_Height);
        this.r1 = sAAllianceAdParams.getMute();
        sAAllianceAdParams.setSpostype(1);
        com.alliance.ssp.ad.http.action.b bVar = new com.alliance.ssp.ad.http.action.b(sAAllianceAdParams, this.w, this.C0, 0, new d(contextA), BaseNetAction.Method.POST, this.w1);
        com.alliance.ssp.ad.t.i.a(this.w, this.X0, null, "0", "开屏");
        bVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) throws IllegalStateException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        VideoController videoController;
        int i = com.alliance.ssp.ad.o0.l.a;
        if (z) {
            if (this.x1.equals(SPLASH_STATE.NO_FORE)) {
                this.x1 = SPLASH_STATE.SHOWING;
            }
            if (this.j1) {
                this.j1 = false;
                d(1);
                G();
            }
            this.q = false;
            com.alliance.ssp.ad.l.c cVar = this.R0;
            if (cVar != null) {
                cVar.f();
            }
            if (this.A1) {
                if (this.t1 != 1 || (videoController = this.m1) == null) {
                    return;
                }
                videoController.i();
                n.d.c.postDelayed(new g(), 20L);
                return;
            }
            int i2 = this.t1;
            if (i2 != 0) {
                if (i2 != 1) {
                    return;
                }
                F();
                return;
            }
            VideoController videoController2 = this.m1;
            if (videoController2 != null) {
                float f2 = this.F1;
                if (f2 != -1.0f) {
                    videoController2.b(f2);
                    this.F1 = -1.0f;
                    return;
                }
                return;
            }
            return;
        }
        this.x1 = SPLASH_STATE.NO_FORE;
        this.q = true;
        com.alliance.ssp.ad.l.c cVar2 = this.R0;
        if (cVar2 != null) {
            cVar2.a();
        }
        if (this.A1) {
            if (this.t1 != 0) {
                E();
                return;
            }
            return;
        }
        int i3 = this.t1;
        if (i3 == 0) {
            VideoController videoController3 = this.m1;
            if (videoController3 != null) {
                this.F1 = videoController3.w != null ? videoController3.B : -1.0f;
                videoController3.b(0.0f);
                return;
            }
            return;
        }
        if (i3 == 1) {
            E();
        } else {
            if (i3 != 2) {
                return;
            }
            this.j1 = true;
            this.C1.d();
        }
    }

    public final void a(View view, int i) throws JSONException, PackageManager.NameNotFoundException, IOException {
        Context contextA = com.alliance.ssp.ad.o0.b.a(this.f);
        if (contextA == null) {
            return;
        }
        try {
            int identifier = contextA.getResources().getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier > 0 ? contextA.getResources().getDimensionPixelSize(identifier) : 0;
            if (dimensionPixelSize > 0) {
                int i2 = (int) ((i * contextA.getResources().getDisplayMetrics().density) + 0.5f);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                marginLayoutParams.setMargins(0, dimensionPixelSize + 15, i2, 0);
                view.setLayoutParams(marginLayoutParams);
            }
        } catch (Exception e2) {
            new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("NMSplashAdImpl 006: ")), (Exception) null);
        }
    }

    public final void a(Context context) {
        k kVar;
        this.G0.setOnClickListener(new View.OnClickListener() { // from class: com.alliance.ssp.ad.impl.splash.NMSplashAdImpl$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.c(view);
            }
        });
        final GestureDetector gestureDetector = new GestureDetector(new s(this));
        this.G0.setOnTouchListener(new View.OnTouchListener() { // from class: com.alliance.ssp.ad.impl.splash.NMSplashAdImpl$$ExternalSyntheticLambda12
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return NMSplashAdImpl.a(gestureDetector, view, motionEvent);
            }
        });
        int i = this.s1;
        if (i == 1) {
            b(context);
            return;
        }
        if (i != 2) {
            return;
        }
        int width = (int) ((this.F0.getWidth() / context.getResources().getDisplayMetrics().density) + 0.5f);
        boolean z = this.n1 == 0;
        a aVar = new a();
        if (width <= 0) {
            int i2 = com.alliance.ssp.ad.o0.l.a;
            kVar = null;
        } else {
            kVar = new k(context, 1, width, z, aVar);
        }
        this.z1 = kVar;
        FrameLayout frameLayout = kVar.e;
        this.L0 = frameLayout;
        if (frameLayout != null && this.I0 != null) {
            this.G0.setVisibility(8);
            this.I0.addView(this.L0);
        }
        if (this.Y0 == 1) {
            k kVar2 = this.z1;
            kVar2.getClass();
            TextView textView = kVar2.f;
            if (textView != null) {
                textView.setText(" 划一划");
            }
            TextView textView2 = kVar2.g;
            if (textView2 != null) {
                textView2.setText("下载 App 或跳转至第三方应用");
            }
        }
    }

    public static /* synthetic */ boolean a(GestureDetector gestureDetector, View view, MotionEvent motionEvent) {
        gestureDetector.onTouchEvent(motionEvent);
        return false;
    }

    public final void a(final View view) {
        this.P0.setOnClickListener(new View.OnClickListener() { // from class: com.alliance.ssp.ad.impl.splash.NMSplashAdImpl$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) throws IllegalAccessException, JSONException, NoSuchFieldException, PackageManager.NameNotFoundException, ClassNotFoundException, IOException, IllegalArgumentException, InvocationTargetException {
                this.f$0.a(view, view2);
            }
        });
        b(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, View view2) throws IllegalAccessException, JSONException, NoSuchFieldException, PackageManager.NameNotFoundException, ClassNotFoundException, IOException, IllegalArgumentException, InvocationTargetException {
        int i = com.alliance.ssp.ad.o0.l.a;
        if (this.A <= 0.0f && b()) {
            if (this.n1 == 1) {
                a(this.G0, "1");
            } else {
                a(view, (String) null);
            }
            if (a("close_button", 0)) {
                this.B = true;
                c(2);
                return;
            }
        }
        G();
        d(0);
        E();
        new com.alliance.ssp.ad.d0.f().a(1, 1, this.h, this.w, "", 0);
        m("", "", this.h);
    }

    public final void a(View view, ViewGroup viewGroup) throws JSONException, PackageManager.NameNotFoundException, IOException {
        this.M0.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (!this.V0.isEmpty()) {
            com.alliance.ssp.ad.o0.d.a(this.f, this.M0, this.V0, 0.8f);
        } else {
            try {
                this.M0.setImageBitmap(this.S0);
                if (this.n1 == 0) {
                    this.M0.setOnClickListener(new View.OnClickListener() { // from class: com.alliance.ssp.ad.impl.splash.NMSplashAdImpl$$ExternalSyntheticLambda7
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            this.f$0.d(view2);
                        }
                    });
                }
            } catch (Exception e2) {
                new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("NMSplashAdImpl 003: ")), e2);
                this.x1 = SPLASH_STATE.ERROR;
            }
        }
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        this.X = com.alliance.ssp.ad.a.f.a("", i);
        this.Y = com.alliance.ssp.ad.a.f.a("", i2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.G = "" + jCurrentTimeMillis;
        this.H = String.valueOf((int) (jCurrentTimeMillis / 1000));
        int i3 = com.alliance.ssp.ad.o0.l.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int[] iArr) {
        if (this.q || this.x1 != SPLASH_STATE.SHOWING) {
            return;
        }
        int i = com.alliance.ssp.ad.o0.l.a;
        this.q = true;
        this.C = iArr;
        if (a("shake", 0)) {
            return;
        }
        this.q = false;
    }

    public final boolean a(String str, int i) {
        int i2 = com.alliance.ssp.ad.o0.l.a;
        ViewGroup viewGroup = this.y1;
        if (viewGroup == null || viewGroup.getVisibility() != 0) {
            return false;
        }
        this.x = str;
        this.D = i == 1;
        boolean zA = a(this.T0, this.h, true, (c.b) null, (com.alliance.ssp.ad.c0.a) new c());
        if (zA) {
            d(3);
            int i3 = this.Y0;
            if (i3 == 0 || i3 == 2) {
                L();
            }
            this.x1 = SPLASH_STATE.NO_FORE;
            com.alliance.ssp.ad.l.c cVar = this.R0;
            if (cVar != null && this.u1 == 1) {
                cVar.a(50.0d, 35.0d, 2000.0d);
                SAAllianceAdData sAAllianceAdData = this.h;
                if (sAAllianceAdData != null && sAAllianceAdData.getInteraction() != null && this.h.getInteraction().getShake() != null) {
                    this.h.getInteraction().getShake().setAcceleration(50.0d);
                    this.h.getInteraction().getShake().setRotationAngle(35.0d);
                    this.h.getInteraction().getShake().setOperationTime(2.0d);
                }
            }
        }
        return zA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Intent intent) {
        int i = com.alliance.ssp.ad.o0.l.a;
        if (this.x1 == SPLASH_STATE.DESTROY || intent == null || intent.getAction() == null || !intent.getAction().equals("SA_TARGET_YT_WEB_ACTIVITY_FINISHED")) {
            return;
        }
        F();
        this.B1.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(double d2, double d3) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        TextView textView = this.P0;
        if (textView != null) {
            textView.setText(com.alliance.ssp.ad.a.b.a("跳过 ").append(((int) d2) + 1).toString());
        }
        if (d3 >= 5.0d || d2 <= 0.0d) {
            n.d.c.post(new Runnable() { // from class: com.alliance.ssp.ad.impl.splash.NMSplashAdImpl$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.I();
                }
            });
            if (!this.A1 && this.t1 != 0) {
                int i = com.alliance.ssp.ad.o0.l.a;
                d(1);
                G();
            } else {
                if (this.t1 == 0 && !this.j1) {
                    if (this.x1 == SPLASH_STATE.SHOWING) {
                        d(1);
                        G();
                    }
                    this.j1 = true;
                    return;
                }
                this.E1 = true;
            }
        }
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void a() {
        int i = com.alliance.ssp.ad.o0.l.a;
        this.x1 = SPLASH_STATE.SHOWING;
        if (!this.g1) {
            this.g1 = true;
        }
        b(this.h);
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void a(int i) {
        if (i >= 25 && !this.G1) {
            this.G1 = true;
            g("", "", this.h);
        }
        if (i >= 50 && !this.H1) {
            this.H1 = true;
            y();
            i("", "", this.h);
        }
        if (i < 75 || this.I1) {
            return;
        }
        this.I1 = true;
        n("", "", this.h);
    }

    @Override // com.alliance.ssp.ad.video.f.a
    public void a(MediaPlayer mediaPlayer) {
        int i = com.alliance.ssp.ad.o0.l.a;
        this.d1 = true;
        if (this.c1) {
            return;
        }
        this.c1 = true;
        p("", "", this.h);
    }
}

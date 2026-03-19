package com.qq.e.comm.plugin.nativeadunified;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.dhylive.app.R;
import com.google.android.material.badge.BadgeDrawable;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.CustomizeVideo;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.NativeUnifiedADDataAdapter;
import com.qq.e.ads.nativ.VideoPreloadListener;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.ads.nativ.widget.ViewStatusListener;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADEventListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.plugin.a40;
import com.qq.e.comm.plugin.ad;
import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import com.qq.e.comm.plugin.aq;
import com.qq.e.comm.plugin.b10;
import com.qq.e.comm.plugin.b5;
import com.qq.e.comm.plugin.bb;
import com.qq.e.comm.plugin.bd;
import com.qq.e.comm.plugin.bh;
import com.qq.e.comm.plugin.bl;
import com.qq.e.comm.plugin.c0;
import com.qq.e.comm.plugin.c40;
import com.qq.e.comm.plugin.callback.biz.ARCallback;
import com.qq.e.comm.plugin.callback.biz.DialogStateCallback;
import com.qq.e.comm.plugin.cd;
import com.qq.e.comm.plugin.cl;
import com.qq.e.comm.plugin.d3;
import com.qq.e.comm.plugin.d50;
import com.qq.e.comm.plugin.db;
import com.qq.e.comm.plugin.e2;
import com.qq.e.comm.plugin.e5;
import com.qq.e.comm.plugin.f40;
import com.qq.e.comm.plugin.f5;
import com.qq.e.comm.plugin.fb;
import com.qq.e.comm.plugin.fr;
import com.qq.e.comm.plugin.gb;
import com.qq.e.comm.plugin.gu;
import com.qq.e.comm.plugin.h10;
import com.qq.e.comm.plugin.h4;
import com.qq.e.comm.plugin.i40;
import com.qq.e.comm.plugin.i6;
import com.qq.e.comm.plugin.j3;
import com.qq.e.comm.plugin.j40;
import com.qq.e.comm.plugin.jp;
import com.qq.e.comm.plugin.jr;
import com.qq.e.comm.plugin.ko;
import com.qq.e.comm.plugin.kp;
import com.qq.e.comm.plugin.kr;
import com.qq.e.comm.plugin.ku;
import com.qq.e.comm.plugin.l3;
import com.qq.e.comm.plugin.lj;
import com.qq.e.comm.plugin.lx;
import com.qq.e.comm.plugin.mm;
import com.qq.e.comm.plugin.ms;
import com.qq.e.comm.plugin.nativeadunified.d;
import com.qq.e.comm.plugin.nm;
import com.qq.e.comm.plugin.nr;
import com.qq.e.comm.plugin.ns;
import com.qq.e.comm.plugin.or;
import com.qq.e.comm.plugin.os;
import com.qq.e.comm.plugin.q1;
import com.qq.e.comm.plugin.q7;
import com.qq.e.comm.plugin.qm$h$$ExternalSyntheticBackport0;
import com.qq.e.comm.plugin.r1;
import com.qq.e.comm.plugin.r5;
import com.qq.e.comm.plugin.rg;
import com.qq.e.comm.plugin.ro;
import com.qq.e.comm.plugin.so;
import com.qq.e.comm.plugin.ss;
import com.qq.e.comm.plugin.to;
import com.qq.e.comm.plugin.u2;
import com.qq.e.comm.plugin.ui;
import com.qq.e.comm.plugin.uy;
import com.qq.e.comm.plugin.v20;
import com.qq.e.comm.plugin.v5;
import com.qq.e.comm.plugin.vx;
import com.qq.e.comm.plugin.w5;
import com.qq.e.comm.plugin.wd;
import com.qq.e.comm.plugin.x5;
import com.qq.e.comm.plugin.xc;
import com.qq.e.comm.plugin.xo;
import com.qq.e.comm.plugin.y1;
import com.qq.e.comm.plugin.y8;
import com.qq.e.comm.plugin.yq;
import com.qq.e.comm.plugin.yu;
import com.qq.e.comm.plugin.z30;
import com.qq.e.comm.plugin.zr;
import com.qq.e.comm.plugin.zt;
import com.qq.e.comm.plugin.zv;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class e implements NativeUnifiedADData, com.qq.e.comm.plugin.m, rg.d, ADEventListener, i40, os, bl {
    private static final String B0 = "com.qq.e.comm.plugin.nativeadunified.e";
    private static final boolean C0;
    private final com.qq.e.comm.plugin.nativeadunified.d A0;
    private volatile boolean B;
    boolean C;
    private final boolean D;
    private final boolean E;
    private List<String> F;
    private volatile String H;
    private long J;

    /* renamed from: K, reason: collision with root package name */
    private long f780K;
    private volatile int L;
    private volatile boolean M;
    private final w5 N;
    private ADListener P;
    ImageView Q;
    private String R;
    private final f5 T;
    private long U;
    private com.qq.e.comm.plugin.nativeadunified.c W;
    private boolean X;
    private List<ImageView> Z;
    private final com.qq.e.comm.plugin.nativeadunified.f a;
    long a0;
    private final JSONObject b;
    long b0;
    private Context c;
    private boolean c0;
    private final fr d;
    private String d0;
    ViewGroup e;
    private String e0;
    private boolean f;
    private long f0;
    private boolean g;
    private final int g0;
    private uy h0;
    MediaView i;
    private long i0;
    cl j;
    private final boolean j0;
    private boolean k0;
    private boolean l0;
    or m;
    private boolean m0;
    private boolean n0;
    private long o;
    private long o0;
    private int p;
    private final int p0;
    private final boolean t0;
    private boolean u;
    private final boolean u0;
    private boolean v;
    private final boolean v0;
    private boolean w;
    private final int w0;
    private y1 y0;
    private String z0;
    private int h = 0;
    private jp n = jp.INIT;
    private int q = 1;
    int r = 1;
    int s = 1;
    private int t = 1;
    private int x = com.qq.e.comm.plugin.k.a();
    private boolean y = false;
    private boolean z = false;
    private boolean A = false;
    private volatile c40 G = c40.NOT_DOWNLOAD;
    private AtomicBoolean I = new AtomicBoolean(false);
    private final ns O = new ns();
    private final w S = new w(Looper.getMainLooper());
    private boolean V = false;
    private boolean Y = false;
    private long q0 = 0;
    private float r0 = 0.0f;
    private boolean s0 = false;
    private List<com.qq.e.comm.plugin.nativeadunified.g> x0 = new ArrayList();

    /* compiled from: A */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.R();
        }
    }

    /* compiled from: A */
    class b extends q7 {
        b(long j, boolean z) {
            super(j, z);
        }

        @Override // com.qq.e.comm.plugin.q7
        public boolean a() {
            return e.this.d.B1();
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return ro.b().a(e.this.d, e.this.e);
        }
    }

    /* compiled from: A */
    class c implements so.f {
        c() {
        }

        @Override // com.qq.e.comm.plugin.so.f
        public void onComplainSuccess() {
            e.this.b(304, new Object[0]);
        }
    }

    /* compiled from: A */
    class d implements DialogInterface.OnDismissListener {
        final /* synthetic */ DialogStateCallback a;

        d(DialogStateCallback dialogStateCallback) {
            this.a = dialogStateCallback;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            this.a.i().b(1);
        }
    }

    /* compiled from: A */
    class f implements CustomizeVideo {
        f() {
        }

        @Override // com.qq.e.ads.nativ.CustomizeVideo
        public String getVideoUrl() {
            return e.this.d.V0();
        }

        @Override // com.qq.e.ads.nativ.CustomizeVideo
        public void reportVideoCompleted() {
            String unused = e.B0;
        }

        @Override // com.qq.e.ads.nativ.CustomizeVideo
        public void reportVideoError(long j, int i, int i2) {
            String unused = e.B0;
        }

        @Override // com.qq.e.ads.nativ.CustomizeVideo
        public void reportVideoPause(long j) {
            String unused = e.B0;
        }

        @Override // com.qq.e.ads.nativ.CustomizeVideo
        public void reportVideoPreload() {
            String unused = e.B0;
        }

        @Override // com.qq.e.ads.nativ.CustomizeVideo
        public void reportVideoResume(long j) {
            String unused = e.B0;
        }

        @Override // com.qq.e.ads.nativ.CustomizeVideo
        public void reportVideoStart() {
            String unused = e.B0;
        }
    }

    /* compiled from: A */
    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.P();
        }
    }

    /* compiled from: A */
    class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            cl clVar = e.this.j;
            if (clVar != null) {
                clVar.h();
            }
        }
    }

    /* compiled from: A */
    class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ad.a(u2.a().c(e.this.e), e.this.d, e.this.d0, e.this.d.D0(), null);
            e eVar = e.this;
            zv.a(eVar.e, eVar.d, 1, new kr());
            if (e.this.H() && !com.qq.e.comm.plugin.k.a(e.this.x)) {
                b10.a(1130304, e.this.T);
            }
            e eVar2 = e.this;
            eVar2.a(eVar2.d);
        }
    }

    /* compiled from: A */
    class k implements d.g {
        k() {
        }

        @Override // com.qq.e.comm.plugin.nativeadunified.d.g
        public void a() {
            e.this.a(111, new Object[0]);
        }
    }

    /* compiled from: A */
    class l implements ss {

        /* compiled from: A */
        class a implements Runnable {
            final /* synthetic */ float[] a;
            final /* synthetic */ long b;

            a(float[] fArr, long j) {
                this.a = fArr;
                this.b = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                eVar.a(this.a, this.b - eVar.q0);
            }
        }

        l() {
        }

        @Override // com.qq.e.comm.plugin.ss
        public void a() {
        }

        @Override // com.qq.e.comm.plugin.ss
        public void a(float f) {
            if (f < e.this.r0) {
                e.this.s0 = false;
            } else {
                if (e.this.s0) {
                    return;
                }
                e.this.s0 = true;
                e.this.q0 = System.currentTimeMillis();
                long unused = e.this.q0;
            }
        }

        @Override // com.qq.e.comm.plugin.ss
        public void a(float[] fArr) {
            xo.d(new a(fArr, System.currentTimeMillis()));
        }
    }

    /* compiled from: A */
    class m implements Runnable {
        m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            cl clVar = e.this.j;
            if (clVar != null) {
                clVar.b(false);
            }
        }
    }

    /* compiled from: A */
    class n implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ Object[] b;

        n(int i, Object[] objArr) {
            this.a = i;
            this.b = objArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.b(this.a, this.b);
        }
    }

    /* compiled from: A */
    static /* synthetic */ class o {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[jp.values().length];
            a = iArr;
            try {
                iArr[jp.AUTO_PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[jp.PLAYING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[jp.INIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[jp.MANUAL_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[jp.DEV_PAUSE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[jp.DEV_STOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[jp.END.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* compiled from: A */
    class q implements View.OnAttachStateChangeListener {
        q() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            e.this.S();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            e.this.U();
        }
    }

    /* compiled from: A */
    class t implements Runnable {
        final /* synthetic */ List a;

        t(List list) {
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.X) {
                return;
            }
            View[] viewArr = new View[this.a.size()];
            this.a.toArray(viewArr);
            e eVar = e.this;
            eVar.X = com.qq.e.comm.plugin.nativeadunified.i.a(eVar.T, viewArr);
        }
    }

    /* compiled from: A */
    class v implements Runnable {
        v() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.P();
        }
    }

    /* compiled from: A */
    private class w extends Handler {
        w(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws JSONException {
            switch (message.what) {
                case 1:
                    if (!e.this.m()) {
                        sendEmptyMessageDelayed(1, e.this.H() ? 100L : 1000L);
                        return;
                    } else {
                        e eVar = e.this;
                        eVar.a((View) eVar.e);
                        return;
                    }
                case 2:
                default:
                    return;
                case 3:
                    boolean zK = e.this.K();
                    e.this.d(zK);
                    e.this.c(zK);
                    e.this.j(zK);
                    e.this.l(zK);
                    e.this.S.sendEmptyMessageDelayed(3, 200L);
                    return;
                case 4:
                    cl clVar = e.this.j;
                    if (clVar != null) {
                        clVar.a(message.arg1);
                        if (message.arg1 == 100) {
                            e.this.j.l();
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    cl clVar2 = e.this.j;
                    if (clVar2 != null) {
                        clVar2.b(true);
                        break;
                    }
                    break;
                case 6:
                    e.this.G = c40.COMPLETE;
                    Object obj = message.obj;
                    if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                        e.this.b(212, new Object[0]);
                    }
                    e eVar2 = e.this;
                    if (eVar2.C) {
                        eVar2.P();
                        return;
                    }
                    return;
                case 7:
                    Object obj2 = message.obj;
                    if ((obj2 instanceof Boolean) && ((Boolean) obj2).booleanValue()) {
                        e.this.b(213, 5002);
                    }
                    e eVar3 = e.this;
                    if (eVar3.C) {
                        eVar3.q = 2;
                        e.this.G = c40.FAILED;
                        e.this.o();
                        e.this.a(107, 5002);
                        if (e.this.d != null && com.qq.e.comm.plugin.k.b()) {
                            com.qq.e.comm.plugin.k.g(e.this.d);
                        }
                        cl clVar3 = e.this.j;
                        if (clVar3 != null) {
                            clVar3.h();
                            return;
                        }
                        return;
                    }
                    return;
                case 8:
                    break;
            }
            cl clVar4 = e.this.j;
            if (clVar4 != null) {
                clVar4.l();
            }
        }
    }

    static {
        C0 = r1.d().f().a("uctl", 0) == 1;
    }

    private File A() {
        if (!TextUtils.isEmpty(this.z0)) {
            File file = new File(this.z0);
            if (file.exists()) {
                return file;
            }
        }
        File fileA = f40.a(this.d);
        if (fileA != null) {
            this.z0 = fileA.getAbsolutePath();
        }
        return fileA;
    }

    private void B() {
        if (this.j == null && !or.a(t()) && this.d.o1() && this.d.p0() != null && this.m == null) {
            this.m = new or(this.d, this.W, this.T);
        }
    }

    private void C() {
        if (r1.d().f().a("nusupsak", t(), 0) == 0) {
            return;
        }
        this.i0 = aq.a(t());
        this.h0 = new uy(aq.f(this.d), aq.e(this.d));
    }

    private boolean D() {
        return this.x == 1 || zr.WIFI == r1.d().c().p();
    }

    private boolean E() {
        return this.v0 || this.u0;
    }

    private boolean F() {
        return com.qq.e.comm.plugin.k.a(this.f0);
    }

    private boolean G() {
        fr frVar = this.d;
        if (frVar == null || TextUtils.isEmpty(frVar.y())) {
            return false;
        }
        int iA = r1.d().f().a("nalca", this.e0, 0);
        if (iA > 10000) {
            iA = com.qq.e.comm.plugin.b.c().a(this.d.x0(), String.valueOf(iA), 0);
        }
        return iA == 1;
    }

    private boolean I() {
        if (A() == null) {
            return false;
        }
        this.o = (int) (r0.length() >> 10);
        return true;
    }

    private boolean J() {
        int i2 = this.g0;
        if (i2 <= 0) {
            return false;
        }
        return ((Boolean) d50.a(this.e, i2).first).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean K() {
        return d50.b(this.c, this.e, cd.a(e2.NATIVEUNIFIEDAD, this.e0), this.D);
    }

    private void L() {
        if (this.G == c40.NOT_DOWNLOAD && H()) {
            h();
            cl clVar = this.j;
            if (clVar != null) {
                clVar.h();
            }
            h(false);
        }
    }

    private void M() {
        MediaView mediaView;
        if (this.X || (mediaView = this.i) == null) {
            return;
        }
        this.X = com.qq.e.comm.plugin.nativeadunified.i.a(this.T, mediaView);
    }

    private void N() {
        if (!H()) {
            GDTLogger.e("preloadVideo调用视频，请确认是否是视频广告");
            return;
        }
        this.u = true;
        if (I()) {
            b(212, new Object[0]);
        } else if (this.G == c40.NOT_DOWNLOAD) {
            h(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        i(true);
    }

    private void Q() {
        if (this.X) {
            return;
        }
        M();
        a(this.Z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        so soVar = new so(this.c, this.d);
        soVar.a(new c());
        DialogStateCallback dialogStateCallback = (DialogStateCallback) x5.b(this.d.s0(), DialogStateCallback.class);
        soVar.a(new d(dialogStateCallback));
        dialogStateCallback.j().b(1);
        soVar.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        if (!this.m0) {
            this.m0 = true;
            this.S.sendEmptyMessage(3);
        }
        if (this.f) {
            return;
        }
        this.S.sendEmptyMessage(1);
    }

    private void T() throws JSONException {
        if (this.h0 == null) {
            return;
        }
        this.r0 = aq.b();
        this.h0.a(new l());
        this.h0.start();
    }

    private void V() {
        pro.getVresult(378, 0, this);
    }

    private void W() {
        o();
        a(206, new Object[0]);
    }

    private void setVideoOption(VideoOption videoOption) {
        vx vxVarF = r1.d().f();
        if (vxVarF != null) {
            String strC = vxVarF.c("shouldMuteVideo");
            if (TextUtils.isEmpty(strC)) {
                c(videoOption);
            } else {
                this.v = "1".equals(strC);
            }
            String strC2 = vxVarF.c("videoAutoPlayPolicy", t());
            if (TextUtils.isEmpty(strC2)) {
                d(videoOption);
            } else {
                try {
                    this.x = Integer.parseInt(strC2);
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        } else {
            c(videoOption);
            d(videoOption);
        }
        int i2 = this.x;
        if (i2 < 0 || i2 > 2) {
            this.x = com.qq.e.comm.plugin.k.a();
        }
        if (videoOption != null) {
            this.A = videoOption.isEnableUserControl();
        }
    }

    private void setVolumeOn(boolean z) {
        cl clVar;
        if (this.i == null || (clVar = this.j) == null) {
            return;
        }
        if (z) {
            clVar.a();
        } else {
            clVar.c();
        }
    }

    boolean H() {
        return this.d.C1();
    }

    String O() {
        return a(new i6(this.d));
    }

    protected void U() {
        this.S.removeMessages(1);
        this.S.removeMessages(3);
        this.m0 = false;
        l(false);
        cl clVar = this.j;
        if (clVar == null || this.n != jp.PLAYING) {
            return;
        }
        clVar.pause();
        a(jp.AUTO_PAUSE);
    }

    @Override // com.qq.e.comm.plugin.rg.d
    public void b(boolean z) {
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToCustomVideo(ViewGroup viewGroup, Context context, List<View> list, List<View> list2) throws JSONException {
        if (!this.j0) {
            com.qq.e.comm.plugin.nativeadunified.i.a(this.T, ErrorCode.PrivateError.ERROR_INTERFACE_CALLED, "");
            return;
        }
        if (a(context, viewGroup)) {
            return;
        }
        this.d.h(2);
        this.d.f(0);
        this.T.c(0);
        this.c = context;
        this.W = new com.qq.e.comm.plugin.nativeadunified.c(this, this.d, context, this.T);
        b(viewGroup);
        a(list, list2, true);
        u2.a().a(this.e, this.d);
        T();
        V();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list) throws JSONException {
        bindAdToView(context, nativeAdContainer, layoutParams, list, null);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindCTAViews(List<View> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            View view = list.get(i2);
            if (view != null) {
                view.setOnClickListener(new com.qq.e.comm.plugin.nativeadunified.b(this, this.d));
                if (this.j0) {
                    view.setOnTouchListener(new com.qq.e.comm.plugin.nativeadunified.h(this.e));
                } else if (E()) {
                    com.qq.e.comm.plugin.nativeadunified.g gVar = new com.qq.e.comm.plugin.nativeadunified.g(this.d, this.w0, this);
                    this.x0.add(gVar);
                    view.setOnTouchListener(gVar);
                } else if (C0) {
                    view.setOnTouchListener(null);
                }
            }
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindImageViews(List<ImageView> list, byte[] bArr) throws JSONException {
        b10.a(1060025, this.T);
        if (list == null || list.isEmpty()) {
            GDTLogger.e("传入的ImageView列表为空");
            b10.a(1060024, this.T);
        } else {
            this.Z = list;
            a(list, e5.a(bArr));
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindMediaView(MediaView mediaView, VideoOption videoOption, NativeADMediaListener nativeADMediaListener) throws JSONException {
        cl clVar;
        boolean z = this.C;
        boolean z2 = false;
        this.C = false;
        if (this.u && this.G == c40.START) {
            s();
        }
        if (mediaView == null) {
            GDTLogger.e("bindMediaView发生错误，MediaView为空");
            com.qq.e.comm.plugin.nativeadunified.i.a(this.T, 4001, "mediaView == null");
            return;
        }
        if (mediaView.getVisibility() != 0) {
            GDTLogger.e("bindMediaView发生错误，MediaView不可见");
            com.qq.e.comm.plugin.nativeadunified.i.a(this.T, 4001, "mediaView inVisible");
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 16) {
            GDTLogger.e("bindMediaView发生错误，不支持4.1以下手机");
            com.qq.e.comm.plugin.nativeadunified.i.a(this.T, 4001, "sdk version = " + i2);
            return;
        }
        if (getAdPatternType() != 2) {
            GDTLogger.e("bindMediaView发生错误，该广告不是视频广告");
            com.qq.e.comm.plugin.nativeadunified.i.a(this.T, 4001, "no video");
            return;
        }
        if (!a(this.e, mediaView)) {
            GDTLogger.e("bindMediaView发生错误，MediaView未在container中");
            com.qq.e.comm.plugin.nativeadunified.i.a(this.T, 4001, "MediaView is not in container");
            return;
        }
        if (this.B) {
            GDTLogger.e("bindMediaView发生错误，当前对象已销毁");
            com.qq.e.comm.plugin.nativeadunified.i.a(this.T, ErrorCode.PrivateError.AD_DATA_DESTROYED, "");
            return;
        }
        if (F()) {
            GDTLogger.e("bindMediaView发生错误，广告已过期");
            com.qq.e.comm.plugin.nativeadunified.i.a(this.T, ErrorCode.AD_DATA_EXPIRE, "");
            return;
        }
        if (!z) {
            com.qq.e.comm.plugin.nativeadunified.i.h(this.T);
            com.qq.e.comm.plugin.nativeadunified.i.a(this.T, nativeADMediaListener != null);
            fr frVar = this.d;
            if (frVar != null) {
                frVar.h(1);
            }
            if (this.m != null) {
                b10.a(1060037, this.T, 8);
            }
        }
        this.C = true;
        this.i = mediaView;
        setVideoOption(videoOption);
        a(videoOption);
        setVolumeOn(this.v);
        if (I()) {
            this.G = c40.COMPLETE;
            z2 = true;
        } else {
            this.G = c40.NOT_DOWNLOAD;
        }
        if (D() && !this.E) {
            if (z2) {
                this.S.post(new v());
            } else {
                L();
            }
            if (this.n == jp.PLAYING && (clVar = this.j) != null && !clVar.isPlaying()) {
                a(jp.AUTO_PAUSE);
            }
        }
        if (this.E) {
            r();
        }
    }

    @Override // com.qq.e.comm.plugin.wg.a
    public void c() {
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void destroy() throws JSONException {
        ViewParent parent;
        x5.c(this.d.s0(), ARCallback.class);
        this.B = true;
        this.A0.a();
        uy uyVar = this.h0;
        if (uyVar != null) {
            uyVar.stop();
        }
        this.S.removeCallbacksAndMessages(null);
        wd.a().a(this.d.y());
        if (this.x0.size() > 0) {
            Iterator<com.qq.e.comm.plugin.nativeadunified.g> it = this.x0.iterator();
            while (it.hasNext()) {
                it.next().d();
            }
            this.x0.clear();
        }
        w5 w5Var = this.N;
        cl clVar = this.j;
        w5Var.a(clVar == null ? null : clVar.b());
        cl clVar2 = this.j;
        if (clVar2 != null) {
            clVar2.destroy();
            this.j = null;
        }
        MediaView mediaView = this.i;
        if (mediaView != null) {
            mediaView.removeAllViews();
            this.i = null;
        }
        ImageView imageView = this.Q;
        if (imageView != null && (parent = imageView.getParent()) != null) {
            ((ViewGroup) parent).removeView(imageView);
        }
        this.c = null;
        u2.a().b(this.e);
        if (this.a0 > 0) {
            com.qq.e.comm.plugin.nativeadunified.i.c(this.T, System.currentTimeMillis() - this.a0);
        }
        or orVar = this.m;
        if (orVar != null) {
            orVar.a();
            this.m = null;
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean equalsAdData(NativeUnifiedADData nativeUnifiedADData) {
        if (nativeUnifiedADData == null || !(nativeUnifiedADData instanceof NativeUnifiedADDataAdapter)) {
            return false;
        }
        NativeUnifiedADData adData = ((NativeUnifiedADDataAdapter) nativeUnifiedADData).getAdData();
        if (!(adData instanceof e)) {
            return false;
        }
        e eVar = (e) adData;
        return w() == null ? eVar.w() == null : w().equals(eVar.w());
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAdPatternType() {
        if (this.E) {
            return 2;
        }
        return this.d.J1();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        fr frVar = this.d;
        if (frVar != null) {
            return frVar.p();
        }
        return null;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public NativeUnifiedADAppMiitInfo getAppMiitInfo() {
        l3 l3VarO;
        com.qq.e.comm.plugin.nativeadunified.i.d(this.T);
        fr frVar = this.d;
        if (frVar == null || (l3VarO = frVar.o()) == null) {
            return null;
        }
        return new com.qq.e.comm.plugin.nativeadunified.a().a(l3VarO);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public double getAppPrice() {
        return this.d.K1();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppScore() {
        return this.d.L1();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppStatus() {
        return this.d.M1();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getButtonText() {
        b10.a(1060026, this.T);
        if (!this.d.k1()) {
            return this.d.C();
        }
        int iM1 = this.d.M1();
        if (iM1 == 1) {
            return this.d.q().e();
        }
        if (iM1 != 4) {
            if (iM1 == 8) {
                return this.d.q().a();
            }
            if (iM1 == 32) {
                return this.d.q().b();
            }
            if (iM1 != 128) {
                return this.d.C();
            }
        }
        return this.d.q().c() + " " + this.h + "%";
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getCTAText() {
        return this.d.N1();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public CustomizeVideo getCustomizeVideo() {
        if (this.j0) {
            return new f();
        }
        return null;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getDesc() {
        return this.d.H();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public long getDownloadCount() {
        return this.d.O1();
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        kp.b().a(this.e0, this.d.k());
        return this.d.M();
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        kp.b().a(this.e0, this.d.k());
        return TextUtils.isEmpty(this.R) ? this.d.g1() : this.R;
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        Map<String, Object> mapV = this.d.V();
        this.A0.a(mapV);
        return mapV;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getIconUrl() {
        return c0.e().d(this.d.d0());
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public List<String> getImgList() {
        if (this.F == null) {
            if (this.E) {
                this.F = new ArrayList();
            } else {
                this.F = new ArrayList(this.d.P1());
            }
        }
        return this.F;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getImgUrl() {
        return c0.e().d(this.d.c0());
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureHeight() {
        return this.d.v0();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureWidth() {
        return this.d.w0();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getProgress() {
        return this.h;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getTitle() {
        return this.d.R0();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoCurrentPosition() {
        cl clVar = this.j;
        if (clVar != null) {
            return clVar.getCurrentPosition();
        }
        GDTLogger.e("getVideoCurrentPosition调用失败，请确定是否是视频广告");
        return -1;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoDuration() {
        return this.E ? this.p0 : this.d.W0() * 1000;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean isAppAd() {
        return this.d.k1();
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        return !F();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean isWeChatCanvasAd() {
        return this.d.E1();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void negativeFeedback() {
        if (TextUtils.isEmpty(this.d.q0())) {
            return;
        }
        zt.a(this.d.q0());
    }

    @Override // com.qq.e.comm.plugin.wg.a
    public void onVideoPause() {
        a(204, new Object[0]);
        if (!this.V) {
            o();
        }
        this.V = false;
    }

    @Override // com.qq.e.comm.plugin.wg.a
    public void onVideoReady() {
        cl clVar;
        this.q = 0;
        if (this.i != null && (clVar = this.j) != null) {
            this.p = clVar.getDuration();
        }
        a(210, Integer.valueOf(this.p));
    }

    @Override // com.qq.e.comm.plugin.wg.a
    public void onVideoResume() {
        this.t = 2;
        a(203, new Object[0]);
        this.S.sendEmptyMessage(8);
    }

    @Override // com.qq.e.comm.plugin.wg.a
    public void onVideoStart() {
        M();
        if (!this.f) {
            q();
        }
        this.M = true;
        a(202, new Object[0]);
        if (this.U > 0) {
            a40.b(System.currentTimeMillis() - this.U, (int) this.o, this.d.V0(), this.T);
            com.qq.e.comm.plugin.nativeadunified.i.a(true, this.T, 0);
            this.U = -1L;
        }
        S();
        this.S.sendEmptyMessage(8);
        if (!TextUtils.isEmpty(this.H)) {
            com.qq.e.comm.plugin.nativeadunified.i.a(this.T, this.L, this.f780K, this.J);
        }
        if (this.a0 > 0 && !this.c0) {
            com.qq.e.comm.plugin.nativeadunified.i.d(this.T, System.currentTimeMillis() - this.a0);
            this.c0 = true;
        }
        cl clVar = this.j;
        if (clVar != null) {
            clVar.m();
            this.j.n();
        }
        this.N.g();
    }

    @Override // com.qq.e.comm.plugin.wg.a
    public void onVideoStop() {
        o();
        a(205, new Object[0]);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void pauseAppDownload() throws JSONException {
        ApkDownloadTask apkDownloadTaskC;
        if (isAppAd() && h10.e(getAppStatus()) && (apkDownloadTaskC = com.qq.e.comm.plugin.apkmanager.l.e().c(u().o().e())) != null) {
            j3.b(4001004, apkDownloadTaskC, 1, 103);
            com.qq.e.comm.plugin.apkmanager.l.e().a(apkDownloadTaskC);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void pauseVideo() {
        e(true);
    }

    public void preloadVideo(VideoPreloadListener videoPreloadListener) {
        if (H()) {
            b(212, new Object[0]);
        } else {
            GDTLogger.e("preloadVideo调用失败，请确定是否是视频广告");
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resume() {
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resumeAppDownload() throws JSONException {
        if (isAppAd() && h10.b(getAppStatus())) {
            String strE = u().o().e();
            ApkDownloadTask apkDownloadTaskC = com.qq.e.comm.plugin.apkmanager.l.e().c(strE);
            if (apkDownloadTaskC != null) {
                apkDownloadTaskC.a(u());
                v20 v20VarA = j3.a(strE);
                v20VarA.a = false;
                v20VarA.b = 2;
                j3.b(4001005, apkDownloadTaskC, 1, 103);
            }
            com.qq.e.comm.plugin.apkmanager.l.e().b(apkDownloadTaskC);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resumeVideo() {
        g(true);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i2, int i3, String str) {
        b5.a(i2, i3, str, this.e0, this.d, this.T, this);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i2) {
        b5.a(i2, this.d, this.e0, this.T, this);
    }

    @Override // com.qq.e.comm.adevent.ADEventListener
    public void setAdListener(ADListener aDListener) {
        this.P = aDListener;
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i2) {
        try {
            this.d0 = b5.a(i2);
        } catch (lx.d unused) {
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        fr frVar = this.d;
        if (frVar == null || downloadConfirmListener == null) {
            GDTLogger.e("setDownloadConfirmListener错误广告数据或listener为空");
            return;
        }
        String strK0 = frVar.k0();
        qm$h$$ExternalSyntheticBackport0.m(downloadConfirmListener);
        d3.b().a(strK0, downloadConfirmListener);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void setNativeAdEventListener(NativeADEventListener nativeADEventListener) {
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void setVideoMute(boolean z) {
        if (this.j != null) {
            setVolumeOn(z);
            this.v = z;
        } else {
            GDTLogger.e("setVideoMute调用失败，请确定是否是视频广告");
        }
        this.w = true;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void startVideo() {
        g(true);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void stopVideo() {
        jp jpVar;
        cl clVar = this.j;
        if (clVar == null || !((jpVar = this.n) == jp.PLAYING || jpVar == jp.DEV_PAUSE || jpVar == jp.MANUAL_PAUSE)) {
            GDTLogger.e("stopVideo调用失败，请确定是否是视频广告");
            return;
        }
        clVar.stop();
        this.S.postDelayed(new m(), 100L);
        a(jp.DEV_STOP);
    }

    int x() {
        cl clVar = this.j;
        if (clVar != null) {
            return clVar.getCurrentPosition();
        }
        return 0;
    }

    public String y() {
        return this.d.W();
    }

    public String z() {
        return this.d.e1();
    }

    /* compiled from: A */
    class u implements ViewStatusListener {
        final /* synthetic */ NativeAdContainer a;

        u(NativeAdContainer nativeAdContainer) {
            this.a = nativeAdContainer;
        }

        @Override // com.qq.e.ads.nativ.widget.ViewStatusListener
        public void onAttachToWindow() {
            e.this.S();
            ImageView imageView = e.this.Q;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            or orVar = e.this.m;
            if (orVar != null) {
                orVar.e(this.a);
            }
        }

        @Override // com.qq.e.ads.nativ.widget.ViewStatusListener
        public void onDetachFromWindow() {
            e.this.U();
            ImageView imageView = e.this.Q;
            if (imageView != null) {
                imageView.setVisibility(4);
            }
            or orVar = e.this.m;
            if (orVar != null) {
                orVar.c();
            }
        }

        @Override // com.qq.e.ads.nativ.widget.ViewStatusListener
        public void onDispatchTouchEvent(MotionEvent motionEvent) {
            r5 r5VarD = u2.a().d(e.this.e);
            if (r5VarD != null) {
                r5VarD.a(motionEvent, false);
            }
        }

        @Override // com.qq.e.ads.nativ.widget.ViewStatusListener
        public void onWindowFocusChanged(boolean z) {
        }

        @Override // com.qq.e.ads.nativ.widget.ViewStatusListener
        public void onWindowVisibilityChanged(int i) {
            if (i == 0) {
                e.this.S();
            } else {
                e.this.U();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z) {
        if (this.E && this.f && this.n0) {
            long j2 = this.o0 + 200;
            this.o0 = j2;
            if (j2 >= this.p0 && j2 < r2 + 200) {
                a(206, new Object[0]);
            }
        }
        this.n0 = z;
    }

    private void k(boolean z) {
        cl clVar = this.j;
        if (clVar != null) {
            clVar.a(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(boolean z) {
        ViewGroup viewGroup;
        if (z || !this.f || this.g || m() || (viewGroup = this.e) == null || !viewGroup.hasWindowFocus()) {
            return;
        }
        b10.a(1402004, this.T);
        this.g = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        return d50.b(this.c, this.e, cd.a(this.e0), this.D);
    }

    private boolean n() {
        return (this.x == 0 && zr.WIFI == r1.d().c().p()) || this.x == 1 || this.y || this.z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        f(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.l0) {
            return;
        }
        this.l0 = true;
        a(211, new Object[0]);
    }

    private ImageView v() {
        for (int i2 = 0; i2 < this.e.getChildCount(); i2++) {
            View childAt = this.e.getChildAt(i2);
            if (childAt instanceof to) {
                return (to) childAt;
            }
        }
        return null;
    }

    private String w() {
        return this.d.g();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) throws JSONException {
        if (a(context, nativeAdContainer)) {
            return;
        }
        this.c = context;
        this.W = new com.qq.e.comm.plugin.nativeadunified.c(this, this.d, context, this.T);
        B();
        a(nativeAdContainer);
        a(layoutParams);
        a(list, list2, false);
        u2.a().a(this.e, this.d);
        T();
        if (getAdPatternType() != 2) {
            V();
        }
        if (this.d.p0() != null || H()) {
            return;
        }
        b10.a(1060034, this.T, Integer.valueOf(a((ViewGroup) nativeAdContainer) ? 1 : 0));
    }

    void q() {
        MediaView mediaView = this.i;
        if (mediaView == null) {
            GDTLogger.e("未绑定MediaView组件，不上报广告曝光！");
        } else if (mediaView.getGlobalVisibleRect(new Rect())) {
            a((View) this.e);
        } else {
            GDTLogger.e("MediaView不可见，不上报广告曝光！");
        }
    }

    void r() {
        if (this.k0) {
            return;
        }
        this.k0 = true;
        Object[] objArr = new Object[1];
        cl clVar = this.j;
        objArr[0] = Integer.valueOf(clVar == null ? -1 : clVar.getDuration());
        a(201, objArr);
    }

    @Override // com.qq.e.comm.pi.IBiddingLoss
    public void sendLossNotification(Map<String, Object> map) {
        b5.a(map, this.e0, this.d, this.T, this);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        b5.a(map, this.d, this.e0, this.T, this);
    }

    String t() {
        return this.a.e();
    }

    @Override // com.qq.e.comm.plugin.bl
    public boolean e() {
        return this.A;
    }

    private void d(VideoOption videoOption) {
        if (videoOption != null) {
            this.x = videoOption.getAutoPlayPolicy();
        }
    }

    private void e(boolean z) {
        cl clVar = this.j;
        if (clVar == null) {
            GDTLogger.e("pauseVideo调用失败，请确定是否是视频广告");
        } else if (clVar.isPlaying()) {
            this.j.pause();
            this.j.b(false);
            a(jp.DEV_PAUSE);
        }
    }

    private void g(boolean z) {
        if (this.j != null && K()) {
            if (this.j.isPlaying()) {
                return;
            }
            if (z) {
                this.z = true;
                if (!I() && (TextUtils.isEmpty(this.H) || !this.I.get())) {
                    L();
                    return;
                }
            }
            this.r = 0;
            d();
            return;
        }
        GDTLogger.e("startVideo调用失败，请确定是否是视频广告并且视频容器可见");
    }

    @Override // com.qq.e.comm.plugin.os
    public boolean k() {
        return this.B;
    }

    @Override // com.qq.e.comm.plugin.bl
    public void d() {
        File fileA = A();
        String absolutePath = fileA != null ? fileA.getAbsolutePath() : null;
        if (absolutePath == null && TextUtils.isEmpty(this.H)) {
            GDTLogger.e("播放视频失败，视频播放文件不存在");
            return;
        }
        a(jp.PLAYING);
        if (this.j != null) {
            this.S.post(new i());
            if (TextUtils.isEmpty(this.j.g()) || !this.M) {
                if (TextUtils.isEmpty(absolutePath)) {
                    this.j.setDataSource(this.H);
                } else {
                    this.N.h();
                    this.j.setDataSource(absolutePath);
                }
            }
            if (this.U == 0) {
                this.U = System.currentTimeMillis();
            }
            this.j.play();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindImageViews(List<ImageView> list, int i2) throws JSONException {
        b10.a(1060025, this.T);
        if (list != null && !list.isEmpty()) {
            this.Z = list;
            a(list, e5.a(this.c, i2));
        } else {
            GDTLogger.e("传入的ImageView列表为空");
            b10.a(1060024, this.T);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (H()) {
            if (this.G == c40.COMPLETE || !TextUtils.isEmpty(this.H)) {
                int i2 = o.a[this.n.ordinal()];
                if (i2 == 1) {
                    if (z) {
                        this.r = 1;
                        d();
                        return;
                    }
                    return;
                }
                if (i2 == 2 && !z) {
                    a(jp.AUTO_PAUSE);
                    cl clVar = this.j;
                    if (clVar != null) {
                        clVar.pause();
                    }
                }
            }
        }
    }

    void f(boolean z) {
        if (this.i == null) {
            return;
        }
        int iX = this.q == 0 ? x() : 0;
        int i2 = this.q;
        ad.a(this.r, this.s, this.t, z ? 3 : i2, iX, i2 == 0 ? this.p : 0, this.d, null);
    }

    public void h(boolean z) {
        double dC;
        double dK = this.d.K();
        if (TextUtils.isEmpty(this.H)) {
            dC = 1.0d;
        } else if (z) {
            if (v5.a(dK)) {
                return;
            }
            this.N.h();
            dC = 1.0d;
        } else {
            dC = this.N.c();
        }
        a(z, dC);
    }

    private void c(VideoOption videoOption) {
        if (this.w) {
            return;
        }
        if (videoOption != null) {
            this.v = videoOption.getAutoPlayMuted();
        } else {
            this.v = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) throws JSONException {
        uy uyVar = this.h0;
        if (uyVar == null) {
            return;
        }
        if (z) {
            uyVar.resume();
        } else if (uyVar.pause()) {
            this.h0.reset();
        }
    }

    @Override // com.qq.e.comm.plugin.bl
    public void f() {
        this.y = true;
        if (!I()) {
            L();
            return;
        }
        cl clVar = this.j;
        if (clVar != null) {
            if (clVar.isPlaying()) {
                e(false);
            } else {
                g(false);
            }
            a(208, new Object[0]);
            return;
        }
        GDTLogger.e("VideoView未初始化完成，无法播放或暂停");
    }

    private void h() {
        cl clVar = this.j;
        if (clVar == null) {
            return;
        }
        clVar.e();
    }

    e(fr frVar, com.qq.e.comm.plugin.nativeadunified.f fVar, JSONObject jSONObject) throws JSONException {
        this.e0 = fVar.e();
        this.d = frVar;
        this.f0 = com.qq.e.comm.plugin.k.b(frVar);
        yq yqVarP0 = frVar.p0();
        frVar.f(0);
        this.a = fVar;
        vx vxVarF = r1.d().f();
        this.D = vxVarF.a("nativeCheckWindowFocus", 1) == 1;
        this.j0 = xc.a("nucve", frVar.y0(), 0, frVar.x0()) == 1;
        boolean z = !H() && ((vxVarF.a("nunrcfg", this.e0, 3) & 2) == 2) && yqVarP0 != null && (frVar.J1() != 3 || (vxVarF.a("skutie", frVar.y0(), 0) == 1));
        this.E = z;
        if (z) {
            frVar.S1();
        }
        this.T = f5.a(frVar);
        com.qq.e.comm.plugin.apkmanager.l.e().a(frVar.R1(), this);
        w5 w5Var = new w5(frVar, this);
        this.N = w5Var;
        if (w5Var.f()) {
            this.H = ui.a().c(frVar.V0(), frVar.k().c);
        } else {
            this.H = ui.a().a(frVar.V0());
        }
        if (TextUtils.isEmpty(this.H)) {
            w5Var.h();
        }
        if (H() && vxVarF.a("nativeUnifiedPreloadVideo", 1) == 1) {
            N();
        }
        C();
        this.g0 = r1.d().f().a("ecvcr", this.e0, 0);
        this.p0 = vxVarF.a("dptvd", this.e0, 5000);
        this.t0 = xc.a("nuaac", this.e0, 0, (ku) null) == 1;
        this.u0 = xc.a("nuoac", this.e0, 0, (ku) null) == 1;
        this.v0 = frVar.J0() > 0;
        this.w0 = y8.c(frVar);
        this.b = jSONObject;
        com.qq.e.comm.plugin.nativeadunified.d dVar = new com.qq.e.comm.plugin.nativeadunified.d(frVar);
        this.A0 = dVar;
        dVar.a(new k());
    }

    /* compiled from: A */
    class p extends ms<y1> {
        p(os osVar) {
            super(osVar);
        }

        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(y1 y1Var) {
            if (y1Var.a() != 3 || e.this.h0 == null) {
                return;
            }
            e.this.y0 = y1Var;
            e.this.h0.d(y1Var.c());
        }
    }

    /* compiled from: A */
    class r implements nm {
        final /* synthetic */ List a;

        r(List list) {
            this.a = list;
        }

        @Override // com.qq.e.comm.plugin.nm
        public void a(String str, int i, Exception exc) {
        }

        @Override // com.qq.e.comm.plugin.nm
        public void a(String str, ImageView imageView, ko koVar) {
            e.this.Y = true;
            e.this.a((List<ImageView>) this.a);
        }
    }

    /* compiled from: A */
    class s implements nm {
        final /* synthetic */ AtomicInteger a;
        final /* synthetic */ List b;

        s(AtomicInteger atomicInteger, List list) {
            this.a = atomicInteger;
            this.b = list;
        }

        @Override // com.qq.e.comm.plugin.nm
        public void a(String str, int i, Exception exc) {
        }

        @Override // com.qq.e.comm.plugin.nm
        public void a(String str, ImageView imageView, ko koVar) {
            if (this.a.decrementAndGet() == 0) {
                e.this.Y = true;
                e.this.a((List<ImageView>) this.b);
            }
        }
    }

    private cl b(VideoOption videoOption) {
        or orVar = this.m;
        if (orVar != null) {
            orVar.a(true);
            nr nrVarB = this.m.b();
            if (nrVarB != null) {
                fr frVar = this.d;
                if (frVar != null) {
                    frVar.h(4);
                }
                return nrVarB;
            }
        }
        com.qq.e.comm.plugin.nativeadunified.g gVar = E() ? new com.qq.e.comm.plugin.nativeadunified.g(this.d, this.w0, this) : null;
        if (gVar != null) {
            this.x0.add(gVar);
        }
        Context context = this.c;
        fr frVar2 = this.d;
        return jr.a(context, frVar2, this, videoOption, this, new C0716e(frVar2, this.N.f()), new com.qq.e.comm.plugin.nativeadunified.c(this, this.d, this.c, this.T), gVar, this.i, this.b);
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.nativeadunified.e$e, reason: collision with other inner class name */
    class C0716e extends bh {
        C0716e(h4 h4Var, boolean z) {
            super(h4Var, z);
        }

        @Override // com.qq.e.comm.plugin.bh, com.qq.e.comm.plugin.ah
        public boolean a(int i, j40 j40Var, float f) {
            super.a(i, j40Var, f);
            e.this.N.a(i, j40Var);
            return true;
        }

        @Override // com.qq.e.comm.plugin.bh, com.qq.e.comm.plugin.ah
        public void a(int i, int i2, int i3) {
            super.a(i, i2, i3);
            e.this.N.a(i, i2, e.this.L);
        }
    }

    private void b(ViewGroup viewGroup) {
        this.e = viewGroup;
        viewGroup.setTag(R.string.a_delay, Integer.valueOf(hashCode()));
        this.e.addOnAttachStateChangeListener(new q());
        S();
    }

    void b(int i2, Object... objArr) {
        ADListener aDListener = this.P;
        if (aDListener != null) {
            aDListener.onADEvent(new ADEvent(i2, objArr));
        }
    }

    /* compiled from: A */
    class g implements bb {
        final /* synthetic */ long a;
        final /* synthetic */ boolean b;
        final /* synthetic */ String c;

        /* compiled from: A */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.i(false);
            }
        }

        g(long j, boolean z, String str) {
            this.a = j;
            this.b = z;
            this.c = str;
        }

        @Override // com.qq.e.comm.plugin.bb
        public void b() {
            e.this.G = c40.FAILED;
            e.this.S.sendEmptyMessage(5);
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(db dbVar) {
            GDTLogger.e("视频下载失败, code: " + dbVar.a() + ", msg: " + dbVar.b());
            Message messageObtain = Message.obtain();
            messageObtain.what = 7;
            messageObtain.obj = Boolean.valueOf(this.b);
            e.this.S.sendMessage(messageObtain);
            e.this.S.sendEmptyMessage(5);
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a() {
            e.this.G = c40.START;
            e.this.s();
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(long j, boolean z) {
            e.this.o = j >> 10;
            e eVar = e.this;
            if (eVar.C && !TextUtils.isEmpty(eVar.H)) {
                e.this.S.post(new a());
            }
            e.this.I.set(true);
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(long j, long j2, int i) {
            e.this.getTitle();
            Message messageObtain = Message.obtain();
            messageObtain.what = 4;
            messageObtain.arg1 = i;
            e.this.S.sendMessage(messageObtain);
            e.this.J = j2;
            e.this.f780K = j;
            e.this.L = i;
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(File file, long j) {
            e.this.b0 = System.currentTimeMillis();
            long jCurrentTimeMillis = e.this.o / (System.currentTimeMillis() - this.a);
            if (e.this.B) {
                return;
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 6;
            messageObtain.obj = Boolean.valueOf(this.b);
            e.this.S.sendMessage(messageObtain);
            a40.a(j, (int) e.this.o, this.c, e.this.T);
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(boolean z) {
            e.this.G = c40.PAUSE;
        }
    }

    public fr u() {
        return this.d;
    }

    public void a(jp jpVar) {
        qm$h$$ExternalSyntheticBackport0.m(this.n);
        qm$h$$ExternalSyntheticBackport0.m(jpVar);
        this.n = jpVar;
    }

    @Override // com.qq.e.comm.plugin.os
    public ns i() {
        return this.O;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z) {
        if (this.B) {
            return;
        }
        if (!n()) {
            cl clVar = this.j;
            if (clVar != null && z) {
                clVar.j();
            }
            r1.d().c().p().c();
            return;
        }
        if (this.q == 0) {
            return;
        }
        jp jpVar = this.n;
        if (jpVar != jp.END && jpVar != jp.MANUAL_PAUSE && jpVar != jp.DEV_PAUSE && jpVar != jp.DEV_STOP) {
            a(jp.AUTO_PAUSE);
        }
        r();
        if (K()) {
            this.q = 0;
            d();
        } else {
            S();
        }
    }

    @Override // com.qq.e.comm.plugin.i40
    public void a(lj ljVar, double d2) {
        a(false, d2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(fr frVar) {
        if (frVar == null) {
            return;
        }
        b10.a(9200025, f5.a(frVar), Integer.valueOf(frVar.Q1()), Integer.valueOf(H() ? 1 : 2), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(float[] fArr, long j2) {
        Object tag;
        uy uyVar = this.h0;
        if (uyVar == null) {
            return false;
        }
        uyVar.reset();
        if (this.W == null || (tag = this.e.getTag(R.string.a_delay)) == null || !(tag instanceof Integer) || ((Integer) tag).intValue() != hashCode() || aq.a(this.i0) || !K() || J()) {
            return false;
        }
        z30.a();
        i6 i6Var = new i6(this.d);
        i6Var.i = fArr;
        i6Var.p = j2;
        i6Var.s = this.y0;
        this.W.b(i6Var);
        aq.d();
        return true;
    }

    @Override // com.qq.e.comm.plugin.m
    public void a(String str, int i2, int i3, long j2) {
        fr frVar = this.d;
        if (frVar != null) {
            frVar.g(i2);
            if (this.d.o() != null) {
                this.d.o().c(i2);
                this.d.o().a(i3);
            }
        }
        this.h = i3;
        a(111, new Object[0]);
    }

    private boolean a(ViewGroup viewGroup) {
        int childCount;
        if (viewGroup != null && (childCount = viewGroup.getChildCount()) > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt instanceof MediaView) {
                    return true;
                }
                if ((childAt instanceof ViewGroup) && a((ViewGroup) childAt)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean a(Context context, ViewGroup viewGroup) throws JSONException {
        if (this.W == null) {
            com.qq.e.comm.plugin.nativeadunified.i.g(this.T);
        }
        kp.b().b(this.a.e(), e2.NATIVEUNIFIEDAD);
        if (viewGroup == null) {
            GDTLogger.e("bindAdToView发生错误，NativeAdContainer为空");
            if (this.W == null) {
                com.qq.e.comm.plugin.nativeadunified.i.a(this.T, 4001, "container == null");
            }
            return true;
        }
        if (context == null) {
            GDTLogger.e("bindAdToView发生错误，Context为空");
            if (this.W == null) {
                com.qq.e.comm.plugin.nativeadunified.i.a(this.T, 4001, "context == null");
            }
            return true;
        }
        if (this.B) {
            GDTLogger.e("NativeUnifiedADData has been destroyed");
            if (this.W == null) {
                com.qq.e.comm.plugin.nativeadunified.i.a(this.T, ErrorCode.PrivateError.AD_DATA_DESTROYED, "");
            }
            return true;
        }
        if (F()) {
            GDTLogger.e("bindAdToView发生错误，广告已过期");
            com.qq.e.comm.plugin.nativeadunified.i.a(this.T, ErrorCode.AD_DATA_EXPIRE, "");
            return true;
        }
        if (H() || this.W != null) {
            return false;
        }
        com.qq.e.comm.plugin.nativeadunified.i.h(this.T);
        return false;
    }

    private void a(List<ImageView> list, Bitmap bitmap) throws JSONException {
        StringBuilder sb;
        String str;
        int size = list.size();
        int adPatternType = getAdPatternType();
        if (adPatternType == 4 || adPatternType == 1) {
            if (size > 1) {
                b10.b(1060022, this.T, Integer.valueOf(size));
                GDTLogger.e("只有一张图片但是传入了 " + size + "个ImageView，只有第一个ImageView会展示图片");
            }
            mm.a().a(this.d.c0(), list.get(0), new r(list), bitmap);
            return;
        }
        if (adPatternType == 3) {
            int size2 = this.d.P1().size();
            int iMin = Math.min(size2, size);
            if (size2 != size) {
                b10.b(1060023, this.T, Integer.valueOf(size));
                if (size2 > size) {
                    sb = new StringBuilder("只有前");
                    sb.append(iMin);
                    str = "个图片能正确展示";
                } else {
                    sb = new StringBuilder("只有前");
                    sb.append(iMin);
                    str = "个ImageView会展示图片";
                }
                sb.append(str);
                GDTLogger.e("图片个数与ImageView个数不符，图片个数为 " + size2 + "，而传入的ImageView个数为 " + size + "，" + sb.toString());
            }
            AtomicInteger atomicInteger = new AtomicInteger(iMin);
            for (int i2 = 0; i2 < iMin; i2++) {
                mm.a().a(this.d.P1().get(i2), list.get(i2), new s(atomicInteger, list), bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<ImageView> list) {
        if (this.X || !this.Y || list == null || list.size() <= 0) {
            return;
        }
        xo.a((Runnable) new t(list));
    }

    private void a(List<View> list, List<View> list2, boolean z) {
        boolean z2 = this.t0;
        if (list != null && list.size() > 0) {
            for (View view : list) {
                a(view, new com.qq.e.comm.plugin.nativeadunified.c(this, this.d, this.c, this.T), z);
                if (this.e == view) {
                    z2 = false;
                }
            }
        }
        if (z2) {
            a(this.e, new com.qq.e.comm.plugin.nativeadunified.c(this, this.d, this.c, this.T), z);
        }
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        Iterator<View> it = list2.iterator();
        while (it.hasNext()) {
            a(it.next(), new com.qq.e.comm.plugin.nativeadunified.c(this, this.d, this.c, this.T, true), z);
        }
    }

    private void a(View view, com.qq.e.comm.plugin.nativeadunified.c cVar, boolean z) {
        if (view == null) {
            return;
        }
        view.setOnClickListener(cVar);
        if (z) {
            view.setOnTouchListener(new com.qq.e.comm.plugin.nativeadunified.h(this.e));
            return;
        }
        if (E()) {
            com.qq.e.comm.plugin.nativeadunified.g gVar = new com.qq.e.comm.plugin.nativeadunified.g(this.d, this.w0, this);
            this.x0.add(gVar);
            view.setOnTouchListener(gVar);
        } else if (C0) {
            view.setOnTouchListener(null);
        }
    }

    private void a(NativeAdContainer nativeAdContainer) {
        ViewGroup viewGroup = this.e;
        if (viewGroup instanceof NativeAdContainer) {
            ((NativeAdContainer) viewGroup).setViewStatusListener(null);
        }
        this.e = nativeAdContainer;
        nativeAdContainer.setTag(R.string.a_delay, Integer.valueOf(hashCode()));
        nativeAdContainer.setViewStatusListener(new u(nativeAdContainer));
    }

    private void a(FrameLayout.LayoutParams layoutParams) throws JSONException {
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(q1.b(), q1.a());
            layoutParams.gravity = BadgeDrawable.BOTTOM_END;
            int iA = yu.a(this.c, 4);
            layoutParams.rightMargin = iA;
            layoutParams.bottomMargin = iA;
        }
        ImageView imageViewV = v();
        this.Q = imageViewV;
        if (imageViewV == null) {
            to toVar = new to(this.c);
            this.Q = toVar;
            this.e.addView(toVar, layoutParams);
        } else {
            imageViewV.setLayoutParams(layoutParams);
            this.Q.bringToFront();
        }
        if (G()) {
            q1.a(this.Q, true);
            this.Q.setOnClickListener(new a());
        } else {
            q1.a(this.Q, false);
            this.Q.setOnClickListener(new com.qq.e.comm.plugin.nativeadunified.c(this, this.d, this.c, this.T));
        }
        if (ro.b().f()) {
            this.Q.setOnTouchListener(new b(ro.b().c(), true));
        }
    }

    boolean a(View view, View view2) {
        if (view2 != null && view != null) {
            if (view == view2) {
                return true;
            }
            for (ViewParent parent = view2.getParent(); parent != null; parent = parent.getParent()) {
                if (parent == view) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(VideoOption videoOption) {
        boolean z = this.j == null;
        this.i.removeAllViews();
        if (this.j == null) {
            this.j = b(videoOption);
        }
        this.j.a(this.i);
        if (!this.j.d()) {
            V();
        }
        if (z) {
            a(jp.INIT);
            a(209, new Object[0]);
        }
    }

    private void a(boolean z, double d2) {
        File fileO = gu.o();
        if (fileO == null) {
            a(107, 5002);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strV0 = this.d.V0();
        fb.a().a(new gb.b().a(d2).d(strV0).a(f40.b(strV0)).a(fileO).d(TextUtils.isEmpty(this.H)).c(this.N.b()).a(this.T).a(), new g(jCurrentTimeMillis, z, strV0));
        if (this.I.get() && this.C && !TextUtils.isEmpty(this.H)) {
            this.S.post(new h());
        }
    }

    void a(View view) {
        Q();
        if (this.f) {
            return;
        }
        or orVar = this.m;
        if (orVar != null) {
            orVar.f(this.e);
        }
        this.a.a(this.d);
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.a0 = jCurrentTimeMillis;
        com.qq.e.comm.plugin.nativeadunified.i.a(this.T, jCurrentTimeMillis - this.a.r);
        view.post(new j());
        a(103, new Object[0]);
        if (this.E) {
            a(202, new Object[0]);
        }
        this.f = true;
        bd.a(this.T);
    }

    String a(i6 i6Var) {
        u2 u2VarA = u2.a();
        r5 r5VarD = u2VarA.d(this.e);
        if (r5VarD != null) {
            r5VarD.a(i6Var);
        }
        return u2VarA.a(this.e);
    }

    @Override // com.qq.e.comm.plugin.wg.a
    public void a() {
        W();
        this.t = 3;
        a(jp.END);
        k(true);
    }

    @Override // com.qq.e.comm.plugin.wg.a
    public void a(int i2, Exception exc) {
        this.q = 2;
        a(207, 5003);
        o();
        com.qq.e.comm.plugin.nativeadunified.i.a(false, this.T, i2);
        if (!TextUtils.isEmpty(this.H)) {
            com.qq.e.comm.plugin.nativeadunified.i.b(this.T, this.L, this.f780K, this.J);
        }
        k(false);
        this.N.e();
    }

    @Override // com.qq.e.comm.plugin.rg.d
    public void a(boolean z) {
        qm$h$$ExternalSyntheticBackport0.m(this.n);
        if (!z) {
            this.r = 0;
        }
        a(z ? jp.MANUAL_PAUSE : jp.PLAYING);
        if (this.A) {
            f();
            return;
        }
        if (!z && !I()) {
            L();
        }
        this.W.b();
    }

    public void a(String str) {
        this.R = str;
    }

    void a(int i2, Object... objArr) {
        this.S.post(new n(i2, objArr));
    }
}

package com.qq.e.comm.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.baidu.mobstat.forbes.Config;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADEventListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.plugin.callback.biz.DialogStateCallback;
import com.qq.e.comm.plugin.callback.biz.UIChangedCallback;
import com.qq.e.comm.plugin.dj;
import com.qq.e.comm.plugin.gb;
import com.qq.e.comm.plugin.lx;
import com.qq.e.comm.plugin.q50;
import com.qq.e.comm.plugin.so;
import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class dd implements iq, ADEventListener, m, i40 {
    private Boolean A;
    private String B;
    private String C;
    private long D;
    private boolean E;
    private final w5 F;
    private i G;
    private Context a;
    protected ed b;
    protected ADListener c;
    protected f5 d;
    private int f;
    protected dj g;
    public ik h;
    protected boolean i;
    private boolean j;
    private String n;
    private String o;
    private boolean q;
    private String r;
    private gd s;
    private boolean u;
    private long v;
    private long w;
    private int x;
    private volatile boolean y;
    private c40 m = c40.NOT_DOWNLOAD;
    private AtomicBoolean p = new AtomicBoolean(false);
    private AtomicBoolean t = new AtomicBoolean(false);
    private final long z = System.currentTimeMillis();
    private Handler e = new Handler(Looper.getMainLooper());

    /* compiled from: A */
    public interface i {
        void a(ed edVar);
    }

    protected abstract dj a(Context context, ed edVar, VideoOption videoOption, dj.a aVar, f5 f5Var);

    public void destroy() {
        xo.d(new d());
    }

    protected void w() {
    }

    protected void y() {
    }

    public dd(Context context, ed edVar) {
        this.a = context;
        this.C = edVar.y0();
        this.b = edVar;
        this.D = k.b(edVar);
        this.r = Config.DEVICE_ID_SEC + this.b.g();
        this.d = f5.a(edVar);
        this.F = new w5(this.b, this);
        if (this.b.C1()) {
            h();
            if (!n()) {
                if (r1.d().f().a("Express2_Preload_Video", 1) == 1) {
                    b(true);
                }
            } else {
                id.c(this.d);
            }
        }
        if (this.b.k1()) {
            com.qq.e.comm.plugin.apkmanager.l.e().a(this.b.o().e(), this);
        }
        if (r1.d().f().a("eimgp", this.C, 0) == 1) {
            q50.e().a(this.b.c0(), (q50.d) null);
        }
        this.s = new gd(this.a, this, this.b);
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.dd$a$a, reason: collision with other inner class name */
        class C0705a implements dj.a {
            private boolean a;

            C0705a() {
            }

            /* compiled from: A */
            /* renamed from: com.qq.e.comm.plugin.dd$a$a$a, reason: collision with other inner class name */
            class C0706a implements ej {
                final /* synthetic */ long a;

                C0706a(long j) {
                    this.a = j;
                }

                @Override // com.qq.e.comm.plugin.ej
                public void a(i6 i6Var) {
                    dd.this.a(i6Var);
                    id.a(dd.this.d, System.currentTimeMillis() - this.a);
                }

                @Override // com.qq.e.comm.plugin.ej
                public void c() {
                    dd.this.a((View) null);
                }

                @Override // com.qq.e.comm.plugin.ej
                public void b() {
                    dd.this.g();
                }

                @Override // com.qq.e.comm.plugin.ej
                public void a(boolean z) {
                    dd.this.a(106, Boolean.valueOf(z));
                    id.a(dd.this.d, r8.getVideoDuration(), System.currentTimeMillis() - this.a);
                }

                @Override // com.qq.e.comm.plugin.ej
                public void a(String str) {
                    dd.this.s.a(str);
                    if (dd.this.k()) {
                        dd.this.c(true);
                    }
                    id.a(dd.this.d, System.currentTimeMillis() - this.a);
                }

                @Override // com.qq.e.comm.plugin.ej
                public void a() {
                    dd.this.a(106, Boolean.TRUE);
                    id.a(dd.this.d, r0.getVideoDuration(), System.currentTimeMillis() - this.a);
                }

                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // com.qq.e.comm.plugin.ej
                public void a(int i, int... iArr) {
                    if (i == 210) {
                        if (iArr == null || iArr.length != 1) {
                            return;
                        }
                        i = -1;
                        for (int i2 : iArr) {
                        }
                        dd.this.a(i, Integer.valueOf(i2));
                        return;
                    }
                    if (i == 1001) {
                        dd.this.a(false);
                        return;
                    }
                    if (i == 1008) {
                        int i3 = iArr[0];
                        int i4 = iArr[1];
                        String unused = dd.this.r;
                        int unused2 = dd.this.x;
                        dd.this.F.a(i3, i4, dd.this.x);
                        return;
                    }
                    if (i != 1009) {
                        switch (i) {
                            case 201:
                            case 203:
                                dd.this.a(i, new Object[0]);
                                break;
                            case 202:
                                dd ddVar = dd.this;
                                ddVar.a(ddVar.x, dd.this.w, dd.this.v);
                                if (!C0705a.this.a) {
                                    dd.this.a(System.currentTimeMillis() - this.a);
                                    C0705a.this.a = true;
                                }
                                dd.this.a(i, new Object[0]);
                                dd.this.y = true;
                                break;
                            case 204:
                            case 205:
                            case 206:
                                dd.this.t();
                                dd.this.a(i, new Object[0]);
                                break;
                            case 207:
                                dd.this.z();
                                dd.this.o();
                                dd.this.t();
                                dd.this.a(i, new Object[0]);
                                break;
                        }
                        return;
                    }
                    int i5 = iArr[0];
                    j40 j40VarA = j40.a(iArr[1]);
                    String unused3 = dd.this.r;
                    dd.this.F.a(i5, j40VarA);
                }
            }

            @Override // com.qq.e.comm.plugin.dj.a
            public void a(int i) {
                if (dd.this.n()) {
                    dd.this.c();
                }
                dd.this.A = Boolean.FALSE;
                dd.this.a(110, Integer.valueOf(i));
                ed edVar = dd.this.b;
                if (edVar != null && edVar.k() == e2.NATIVEEXPRESSAD) {
                    dd.this.b(i);
                }
                dd ddVar = dd.this;
                id.a(ddVar.d, i, ddVar.i ? 4 : 3);
            }

            @Override // com.qq.e.comm.plugin.dj.a
            public void a(ik ikVar) {
                dd.this.A = Boolean.TRUE;
                long jCurrentTimeMillis = System.currentTimeMillis();
                dd.this.h = ikVar;
                ikVar.a(new C0706a(jCurrentTimeMillis));
                dd.this.a(109, new Object[0]);
                if (dd.this.n()) {
                    dd.this.c();
                    dd.this.r();
                } else if (!TextUtils.isEmpty(dd.this.o) && dd.this.p.get() && dd.this.b.K() == 1.0d) {
                    dd.this.r();
                }
                ed edVar = dd.this.b;
                if (edVar != null && edVar.k() == e2.NATIVEEXPRESSAD) {
                    dd.this.x();
                }
                dd ddVar = dd.this;
                id.a(ddVar.d, 101, ddVar.i ? 2 : 1);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (dd.this.g == null) {
                C0705a c0705a = new C0705a();
                dd ddVar = dd.this;
                Context context = ddVar.a;
                ed edVar = dd.this.b;
                ddVar.g = ddVar.a(context, edVar, edVar.K1(), c0705a, dd.this.d);
            }
            dd ddVar2 = dd.this;
            ddVar2.h = ddVar2.g.b();
            dd ddVar3 = dd.this;
            ddVar3.g.a(ddVar3.F.f());
        }
    }

    public void s() {
        if (this.t.get()) {
            return;
        }
        this.t.set(true);
        e2 e2VarK = this.b.k();
        e2 e2Var = e2.NATIVEEXPRESSAD;
        if (e2VarK == e2Var) {
            v();
        }
        if (this.a != null && e2Var == this.b.k()) {
            kp.b().b(this.b.y0(), e2Var);
        }
        if (e2Var == this.b.k() && i()) {
            a(110, new Object[0]);
        } else {
            this.e.post(new a());
        }
    }

    public boolean isValid() {
        return !i();
    }

    /* compiled from: A */
    class b implements so.f {
        b() {
        }

        @Override // com.qq.e.comm.plugin.so.f
        public void onComplainSuccess() {
            dd.this.a(304, new Object[0]);
        }
    }

    /* compiled from: A */
    class c implements DialogInterface.OnDismissListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            ((DialogStateCallback) x5.b(dd.this.b.s0(), DialogStateCallback.class)).i().b(1);
        }
    }

    public String getECPMLevel() {
        return this.b.g1();
    }

    public int getECPM() {
        return this.b.M();
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i2) {
        b5.a(i2, this.b, this.C, this.d, this);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i2, int i3, String str) {
        b5.a(i2, i3, str, this.C, this.b, this.d, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.b == null || !k.b()) {
            return;
        }
        k.g(this.b);
    }

    public boolean i() {
        return k.a(this.D);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i2) {
        try {
            this.B = b5.a(i2);
        } catch (lx.d unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        so soVar = new so(j(), this.b);
        soVar.a(new b());
        soVar.a(new c());
        soVar.j();
        ((DialogStateCallback) x5.b(this.b.s0(), DialogStateCallback.class)).j().b(1);
    }

    @Override // com.qq.e.comm.plugin.iq
    public int getVideoDuration() {
        return this.b.W0() * 1000;
    }

    /* compiled from: A */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            dd.this.a();
        }
    }

    @Override // com.qq.e.comm.plugin.iq
    public View j() {
        dj djVar = this.g;
        if (djVar != null) {
            return djVar.a();
        }
        return null;
    }

    public boolean k() {
        return this.b.C1();
    }

    /* compiled from: A */
    class e implements Runnable {
        final /* synthetic */ View a;

        e(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            dd.this.b.c(System.currentTimeMillis());
            String strC = u2.a().c(this.a);
            dd ddVar = dd.this;
            ad.a(strC, ddVar.b, ddVar.B, dd.this.b.D0(), null);
            zv.a(this.a, dd.this.b);
            dd.this.A();
        }
    }

    public String[] f() {
        return new String[]{this.b.e1()};
    }

    public String[] e() {
        return new String[]{this.b.W()};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        int iA;
        if (this.b.C1()) {
            VideoOption videoOptionK1 = this.b.K1();
            if (videoOptionK1 != null) {
                iA = videoOptionK1.getAutoPlayPolicy();
            } else {
                iA = k.a();
            }
            if (k.a(iA)) {
                return;
            }
            b10.a(1130304, this.d);
        }
    }

    private void u() {
        x6.a(this.d, System.currentTimeMillis() - this.z);
    }

    protected void t() {
        c(false);
    }

    /* compiled from: A */
    class f implements nm {
        @Override // com.qq.e.comm.plugin.nm
        public void a(String str, int i, Exception exc) {
        }

        f() {
        }

        @Override // com.qq.e.comm.plugin.nm
        public void a(String str, ImageView imageView, ko koVar) {
            if (koVar.a()) {
                return;
            }
            b10.a(9130005, dd.this.d, 2);
        }
    }

    public boolean n() {
        return this.m == c40.COMPLETE && !TextUtils.isEmpty(this.n);
    }

    private boolean m() {
        return this.m == c40.FAILED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.h != null) {
            if (n()) {
                this.h.a(this.n);
            } else {
                this.h.a(this.o);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        File fileA = f40.a(this.b);
        if (fileA != null) {
            this.m = c40.COMPLETE;
            this.n = fileA.getAbsolutePath();
        }
        if (this.m == c40.COMPLETE || !TextUtils.isEmpty(this.o)) {
            return;
        }
        if (this.F.f()) {
            this.o = ui.a().c(this.b.V0(), this.b.k().c);
        } else {
            this.o = ui.a().a(this.b.V0());
        }
    }

    /* compiled from: A */
    class g implements bb {
        final /* synthetic */ boolean a;
        final /* synthetic */ boolean b;

        @Override // com.qq.e.comm.plugin.bb
        public void b() {
        }

        g(boolean z, boolean z2) {
            this.a = z;
            this.b = z2;
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(File file, long j) {
            dd.this.h();
            if (dd.this.n()) {
                if (TextUtils.isEmpty(dd.this.o) || !dd.this.y) {
                    dd.this.r();
                }
                dd.this.c();
            }
            a40.a(j, dd.this.f, dd.this.b.V0(), dd.this.d);
            String unused = dd.this.r;
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(long j, boolean z) {
            dd.this.f = (int) (j >> 10);
            dd.this.p.set(true);
            if (TextUtils.isEmpty(dd.this.o)) {
                return;
            }
            if ((dd.this.b.K() == 1.0d || !this.a) && !this.b) {
                dd.this.r();
                dd.this.y();
            }
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(db dbVar) {
            dd.this.F.h();
            dd.this.m = c40.FAILED;
            if (!dd.this.j || !this.a) {
                dd.this.a(207, new Object[0]);
            }
            dd.this.q = true;
            ik ikVar = dd.this.h;
            if (ikVar != null) {
                ikVar.a((String) null);
            }
            dd.this.t();
            String unused = dd.this.r;
            dbVar.b();
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(boolean z) {
            dd.this.m = c40.PAUSE;
            String unused = dd.this.r;
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(long j, long j2, int i) {
            String unused = dd.this.r;
            ik ikVar = dd.this.h;
            if (ikVar != null) {
                ikVar.a(j, j2, i);
            }
            dd.this.v = j2;
            dd.this.w = j;
            dd.this.x = i;
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a() {
            dd.this.m = c40.START;
            ik ikVar = dd.this.h;
            if (ikVar != null) {
                ikVar.c();
            }
            String unused = dd.this.r;
        }
    }

    /* compiled from: A */
    class h extends xx {
        final /* synthetic */ int b;
        final /* synthetic */ Object[] c;

        h(int i, Object[] objArr) {
            this.b = i;
            this.c = objArr;
        }

        @Override // com.qq.e.comm.plugin.xx
        public void b() {
            ADListener aDListener = dd.this.c;
            if (aDListener != null) {
                aDListener.onADEvent(new ADEvent(this.b, this.c));
            }
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        b5.a(map, this.b, this.C, this.d, this);
    }

    @Override // com.qq.e.comm.adevent.ADEventListener
    public void setAdListener(ADListener aDListener) {
        this.c = aDListener;
        gd gdVar = this.s;
        if (gdVar != null) {
            gdVar.a(aDListener);
        }
        if (this.E) {
            c();
            this.E = false;
        }
    }

    @Override // com.qq.e.comm.pi.IBiddingLoss
    public void sendLossNotification(Map<String, Object> map) {
        b5.a(map, this.C, this.b, this.d, this);
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        ed edVar = this.b;
        if (edVar != null) {
            return edVar.p();
        }
        return null;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        ed edVar = this.b;
        if (edVar != null && downloadConfirmListener != null) {
            String strK0 = edVar.k0();
            qm$h$$ExternalSyntheticBackport0.m(downloadConfirmListener);
            d3.b().a(strK0, downloadConfirmListener);
        } else {
            qm$h$$ExternalSyntheticBackport0.m(edVar);
            qm$h$$ExternalSyntheticBackport0.m(downloadConfirmListener);
        }
    }

    private void v() {
        id.a(this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        id.b(this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.j) {
            return;
        }
        a(201, new Object[0]);
        this.j = true;
    }

    protected void z() {
        if (!TextUtils.isEmpty(this.o)) {
            id.a(this.d, this.x, this.w, this.v);
        }
        this.F.e();
    }

    public ed d() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.g != null) {
            ik ikVar = this.h;
            if (ikVar != null) {
                this.F.a(ikVar.b());
            }
            this.g.destroy();
        }
        if (this.b.R() > 0 && !this.u) {
            id.b(this.d, System.currentTimeMillis() - this.b.R());
            if (this.b.k().i()) {
                b10.a(1402004, this.d);
            }
        }
        if (this.A == null && !this.u && this.t.get()) {
            b10.a(1404009, this.d);
        }
        this.u = true;
    }

    public void q() {
        b(true);
    }

    private void b(boolean z) {
        double dC;
        if (this.b.C1() && !m()) {
            if (n()) {
                r();
                c();
                return;
            }
            boolean z2 = !TextUtils.isEmpty(this.o);
            mm.a().a(this.b.d0(), new f());
            double dK = this.b.K();
            if (!z2) {
                this.F.h();
            } else if (z) {
                if (v5.a(dK)) {
                    if (this.c != null) {
                        c();
                        return;
                    } else {
                        this.E = true;
                        return;
                    }
                }
                this.F.h();
            } else {
                if (this.b.D0() == 3) {
                    dC = this.F.c();
                    a(z, z2, dC, false);
                }
                this.F.h();
            }
            dC = 1.0d;
            a(z, z2, dC, false);
        }
    }

    protected void c(boolean z) {
        int iG;
        int i2;
        int i3;
        int iD;
        int i4;
        int i5;
        int videoDuration = getVideoDuration();
        ik ikVar = this.h;
        if (ikVar != null) {
            iG = ikVar.g();
            int currentPosition = iG == 0 ? this.h.getCurrentPosition() : 0;
            if (this.h.getDuration() > 0) {
                videoDuration = this.h.getDuration();
            }
            int iE = this.h.e();
            int iF = this.h.f();
            iD = this.h.d();
            i2 = videoDuration;
            i5 = currentPosition;
            i4 = iF;
            i3 = iE;
        } else {
            iG = 2;
            i2 = videoDuration;
            i3 = 1;
            iD = 1;
            i4 = 1;
            i5 = 0;
        }
        ad.a(i3, iD, i4, z ? 3 : iG, i5, i2, this.b, null);
    }

    public void a(boolean z) {
        b(z);
    }

    @Override // com.qq.e.comm.plugin.iq
    public mh b() {
        ik ikVar = this.h;
        if (ikVar != null) {
            return ikVar.b();
        }
        return null;
    }

    protected void a(int i2, Object... objArr) {
        if (this.c != null) {
            this.e.post(new h(i2, objArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        id.b(this.d, i2);
    }

    protected void a(i6 i6Var) {
        this.s.a(i6Var);
        if (k()) {
            c(true);
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null || this.b == null) {
            return;
        }
        String strOptString = jSONObject.optString("startAnimationGroup", "");
        String strOptString2 = jSONObject.optString("bindData", "");
        if (!TextUtils.isEmpty(strOptString)) {
            ((UIChangedCallback) x5.b(this.b.s0(), UIChangedCallback.class)).r().b(strOptString);
        }
        if (TextUtils.isEmpty(strOptString2)) {
            return;
        }
        ((UIChangedCallback) x5.b(this.b.s0(), UIChangedCallback.class)).e().b(strOptString2);
    }

    @Override // com.qq.e.comm.plugin.m
    public void a(String str, int i2, int i3, long j) {
        l3 l3VarO = this.b.o();
        if (l3VarO != null) {
            l3VarO.a(i3);
            l3VarO.c(i2);
        }
    }

    public void a(View view) {
        if (this.i) {
            return;
        }
        i iVar = this.G;
        if (iVar != null) {
            iVar.a(this.b);
        }
        ik ikVar = this.h;
        if (ikVar == null && view == null) {
            return;
        }
        if (view == null) {
            view = ikVar.a();
        }
        this.i = true;
        u2 u2VarA = u2.a();
        if (u2VarA.d(view) == null) {
            u2VarA.a(view, this.b);
        }
        a(103, new Object[0]);
        view.post(new e(view));
        w();
        u();
        bd.a(this.d);
    }

    public void a(Activity activity) {
        dj djVar = this.g;
        if (djVar != null) {
            djVar.a(activity);
        }
    }

    public void a(ADSize aDSize) {
        this.b.a(aDSize.getWidth(), aDSize.getHeight());
    }

    public void a(i iVar) {
        this.G = iVar;
    }

    @Override // com.qq.e.comm.plugin.i40
    public void a(lj ljVar, double d2) {
        a(false, true, d2, true);
    }

    protected void a(int i2) {
        id.a(i2, this.d);
    }

    protected void a(int i2, long j, long j2) {
        if (!TextUtils.isEmpty(this.o)) {
            id.b(this.d, i2, j, j2);
        }
        this.F.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        id.c(this.d, j);
    }

    private void a(boolean z, boolean z2, double d2, boolean z3) {
        fb.a().a(new gb.b().d(this.b.V0()).a(f40.b(this.b.V0())).a(gu.o()).d(!z2).a(d2).c(this.F.b()).a(this.d).a(), new g(z, z3));
    }
}

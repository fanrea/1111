package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.plugin.e00;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class qz implements NSPVI, vk<mu>, ml, gm, hk, rj, e00.b {
    private static final String p;
    private static boolean q;
    private final xz a;
    private final uz b;
    private final yz c;
    private final i00 d;
    private final rz e;
    private final oz f;
    private final e00 g;
    private final c00 h;
    private mu i;
    private long j;
    private final boolean m;
    private final boolean n;
    private String o;

    static {
        q8.a().b(e2.SPLASH);
        p = "qz";
        q = true;
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public String getAdNetWorkName() {
        return null;
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void preload() {
        uz uzVar = new uz();
        uzVar.a(this.a, this);
        uzVar.g();
        uzVar.a();
    }

    @Override // com.qq.e.comm.plugin.k00.d
    public void s() {
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setSkipView(View view) {
        GDTLogger.e("注意！开屏自定义跳过功能已废弃，调用不生效");
    }

    public qz(Context context, String str, String str2, String str3) {
        this(context, str, str2, str3, mb.DEFAULT);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchAndShowIn(ViewGroup viewGroup) {
        a(false, true, viewGroup);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchFullScreenAndShowIn(ViewGroup viewGroup) {
        a(true, true, viewGroup);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchAdOnly() {
        a(false, false, null);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void fetchFullScreenAdOnly() {
        a(true, false, null);
    }

    public qz(Context context, String str, String str2, String str3, mb mbVar) {
        xz xzVar = new xz(context, str, str2, str3);
        this.a = xzVar;
        this.n = zz.f(str2);
        this.m = !TextUtils.isEmpty(str3);
        xzVar.i = mbVar;
        this.b = new uz();
        this.c = new yz();
        this.d = new i00();
        this.e = new rz();
        this.f = new oz();
        this.g = new e00();
        this.h = new c00();
    }

    @Override // com.qq.e.comm.plugin.ml
    public void e() throws JSONException {
        if (this.n) {
            return;
        }
        if (this.h.o()) {
            this.d.h();
        }
        D();
    }

    private void D() throws JSONException {
        if (this.h.f()) {
            if (!this.n && this.a.b() != this.c.c()) {
                this.a.a(this.c.c());
            }
            xz xzVar = this.a;
            xzVar.y = k.b(xzVar.b());
            boolean zC = zz.c();
            a aVar = new a();
            b5.d(this.a.c, this);
            if (zC) {
                xo.b(aVar);
            } else {
                xo.a((Runnable) aVar);
            }
            xz xzVar2 = this.a;
            if (xzVar2.q) {
                a(xzVar2.p, xzVar2.r);
            }
        }
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            mu muVarB = qz.this.a.b();
            if (qz.this.a.j == null || muVarB == null) {
                return;
            }
            qz.this.a.j.onADEvent(new ADEvent(100, Long.valueOf(qz.this.a.y)));
            muVarB.h(qz.this.j);
            muVarB.d(System.currentTimeMillis());
            f00.a(qz.this.a, qz.this.m, System.currentTimeMillis() - qz.this.j, qz.q);
            boolean unused = qz.q = false;
        }
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void showAd(ViewGroup viewGroup) throws JSONException {
        a(false, viewGroup);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void showFullScreenAd(ViewGroup viewGroup) throws JSONException {
        a(true, viewGroup);
    }

    /* compiled from: A */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f00.e(qz.this.a.c());
        }
    }

    private boolean C() {
        return k.a(this.a.y);
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        return !C();
    }

    @Override // com.qq.e.comm.plugin.gm
    public void n() throws JSONException {
        if (this.h.h()) {
            mu muVarB = this.a.b();
            muVarB.f(this.a.n);
            u2.a().a(this.a.w, muVarB);
            this.g.e();
            xo.d(new c());
            f00.a(this.a, (Integer) null);
        }
    }

    /* compiled from: A */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (qz.this.a.j != null) {
                qz.this.a.j.onADEvent(new ADEvent(102, new Object[0]));
            }
        }
    }

    @Override // com.qq.e.comm.plugin.ml
    public void a(db dbVar) {
        if (this.n) {
            return;
        }
        int iA = dbVar == null ? 0 : dbVar.a();
        go.d(this.a.c(), iA);
        c(iA);
    }

    @Override // com.qq.e.comm.plugin.gm
    public String o() {
        return this.c.d();
    }

    @Override // com.qq.e.comm.plugin.gm
    public File i() {
        return this.c.b();
    }

    @Override // com.qq.e.comm.plugin.gm
    public void q() {
        if (this.h.b()) {
            this.e.b();
            xo.d(new d());
            if (i() == null) {
                b10.a(1013025, this.a.c(), Integer.valueOf(this.n ? 1 : 2));
            }
            this.b.a(2);
        }
    }

    /* compiled from: A */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (qz.this.a.j != null) {
                qz.this.a.j.onADEvent(new ADEvent(103, new Object[0]));
                bd.a(qz.this.a.c());
            }
        }
    }

    @Override // com.qq.e.comm.plugin.wp.b
    public void k() {
        c();
    }

    @Override // com.qq.e.comm.plugin.k00.d
    public void m() {
        d(0);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void zoomOutAnimationFinish() {
        this.d.t();
    }

    @Override // com.qq.e.comm.plugin.rj
    public void r() {
        if (this.h.l()) {
            this.g.c();
            this.d.g();
        }
    }

    @Override // com.qq.e.comm.plugin.e00.b
    public void g() throws JSONException {
        b(false);
    }

    @Override // com.qq.e.comm.plugin.e00.b
    public void h() throws JSONException {
        b(true);
    }

    private void a(boolean z, boolean z2, ViewGroup viewGroup) {
        if (z2 && viewGroup == null) {
            GDTLogger.e("加载并展示容器不能为空");
            return;
        }
        if (this.h.e()) {
            A();
            if (this.h.g()) {
                this.j = System.currentTimeMillis();
                xz xzVar = this.a;
                xzVar.o = zz.a(z2, xzVar.c);
                xz xzVar2 = this.a;
                xzVar2.C = zz.e(xzVar2.c);
                f00.a(z2, this.a.c(), this.a.o, this.n);
                xz xzVar3 = this.a;
                xzVar3.p = z;
                xzVar3.q = z2;
                xzVar3.r = viewGroup;
                xzVar3.B = SystemClock.elapsedRealtime();
                this.b.f();
                this.g.f();
            }
        }
    }

    private void b(boolean z) throws JSONException {
        if (this.h.p()) {
            return;
        }
        if (this.n) {
            c(z);
            return;
        }
        if (this.a.b() != null && this.c.b() != null) {
            if (this.h.o()) {
                this.d.p();
                f00.a(this.a, z, 1);
                return;
            } else if (this.h.n()) {
                D();
                f00.a(this.a, z, 2);
                return;
            }
        }
        if (this.h.n()) {
            mu muVarV = v();
            if (muVarV != null) {
                this.c.a(muVarV);
                f00.a(this.a, z, 3);
                return;
            }
            f00.b(this.a, z, 3);
        } else if (this.h.o()) {
            mu muVarV2 = v();
            if (muVarV2 != null) {
                muVarV2.d(true);
                this.a.a(muVarV2);
                this.c.a();
                this.c.a(this.a, this);
                this.c.a(true);
                this.c.a(muVarV2);
                f00.a(this.a, z, 4);
                return;
            }
            f00.b(this.a, z, 4);
        }
        if (z) {
            c(4011);
        }
    }

    private mu v() {
        if (this.i == null) {
            this.i = this.b.b();
        }
        return this.i;
    }

    @Override // com.qq.e.comm.plugin.f20.b
    public void f() {
        if (this.a.g() && E()) {
            return;
        }
        this.d.a(0L);
        d(0);
    }

    private boolean E() {
        if (!this.h.k()) {
            return false;
        }
        this.g.g();
        this.d.r();
        ADListener aDListener = this.a.j;
        if (aDListener == null) {
            return true;
        }
        aDListener.onADEvent(new ADEvent(113, new Object[0]));
        return true;
    }

    /* compiled from: A */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (qz.this.a.j != null) {
                qz.this.a.j.onADEvent(new ADEvent(106, new Object[0]));
            }
        }
    }

    private void d(int i) {
        if (this.h.c()) {
            xo.a(new e(), i);
            this.b.a(3);
            f00.c(this.a);
            xz xzVar = this.a;
            if (xzVar != null) {
                b10.a(1402004, xzVar.c());
            }
            u();
        }
    }

    /* compiled from: A */
    class f implements Runnable {
        final /* synthetic */ int a;

        f(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            qz.this.a.j.onADEvent(new ADEvent(101, Integer.valueOf(this.a)));
        }
    }

    private void A() {
        this.a.e();
        this.g.a(this.a, this);
        this.b.a(this.a, this);
        this.c.a(this.a, this);
        this.d.a(this.a, this);
        this.e.a(this.a, this);
    }

    private void u() {
        u2.a().b(this.a.w);
        this.f.a();
        this.e.a();
        this.d.a();
        this.c.a();
        this.b.a();
        this.g.a();
        this.a.a();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setSupportZoomOut(boolean z) {
        this.a.a(z);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setFetchDelay(int i) {
        zz.a(i);
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setAdListener(ADListener aDListener) {
        this.a.j = aDListener;
    }

    private void c(int i) {
        int iA = this.h.a();
        if (this.h.d()) {
            if (i == 4011) {
                f00.a(this.a, iA, this.n);
            }
            if (this.a.j != null) {
                xo.d(new f(i));
            }
            u();
        }
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public Bitmap getZoomOutBitmap() {
        return this.d.e();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setDeveloperLogo(int i) {
        if (i == 0) {
            return;
        }
        this.a.l = i;
    }

    @Override // com.qq.e.comm.plugin.vk
    public boolean a() {
        return this.h.n();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.a.z = serverSideVerificationOptions;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        mu muVarB = this.a.b();
        if (muVarB == null) {
            return null;
        }
        return muVarB.p();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        mu muVarB;
        if (downloadConfirmListener != null && (muVarB = this.a.b()) != null) {
            String strK0 = muVarB.k0();
            qm$h$$ExternalSyntheticBackport0.m(downloadConfirmListener);
            d3.b().a(strK0, downloadConfirmListener);
            return;
        }
        GDTLogger.e("设置下载确认弹窗错误，listener 为空或广告未加载");
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        kp kpVarB = kp.b();
        xz xzVar = this.a;
        kpVarB.a(xzVar.c, xzVar.e);
        mu muVarB = this.a.b();
        return muVarB == null ? "" : muVarB.g1();
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        kp kpVarB = kp.b();
        xz xzVar = this.a;
        kpVarB.a(xzVar.c, xzVar.e);
        mu muVarB = this.a.b();
        if (muVarB == null) {
            return -1;
        }
        return muVarB.M();
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i) {
        b5.a(i, this.a.b(), this.a.c, this.a.c(), this);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i, int i2, String str) {
        b5.a(i, i2, str, this.a.c, this.a.b(), this.a.c(), this);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i) {
        mu muVarB = this.a.b();
        if (muVarB != null) {
            b5.a(muVarB.y0(), i);
        }
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        mu muVarB = this.a.b();
        if (muVarB != null) {
            return muVarB.V();
        }
        return new HashMap();
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.a.h = loadAdParams;
        this.o = b5.a(loadAdParams);
    }

    public String[] x() {
        mu muVarB = this.a.b();
        return muVarB == null ? new String[0] : new String[]{muVarB.e1()};
    }

    public String[] w() {
        mu muVarB = this.a.b();
        return muVarB == null ? new String[0] : new String[]{muVarB.W()};
    }

    public int y() {
        mu muVarB = this.a.b();
        if (muVarB == null) {
            return -1;
        }
        return muVarB.o0();
    }

    public boolean B() {
        mu muVarB = this.a.b();
        if (muVarB == null) {
            return false;
        }
        return muVarB.l1();
    }

    public int z() {
        mu muVarB = this.a.b();
        if (muVarB == null) {
            return -1;
        }
        return muVarB.z0();
    }

    @Override // com.qq.e.comm.plugin.wp.b
    public void d() {
        r();
    }

    private void c(boolean z) throws JSONException {
        if (this.h.m() || this.h.o()) {
            return;
        }
        if (this.h.n()) {
            mu muVarV = v();
            if (muVarV != null) {
                this.a.a(muVarV);
                this.c.a(muVarV);
                f00.a(this.a, z, 5);
                D();
                return;
            }
            f00.b(this.a, z, 5);
        }
        if (z) {
            c(4011);
        }
    }

    @Override // com.qq.e.comm.plugin.f20.b
    public void a(long j) {
        if (this.h.p()) {
            this.d.a(j);
            ADListener aDListener = this.a.j;
            if (aDListener != null) {
                aDListener.onADEvent(new ADEvent(112, Long.valueOf(j)));
            }
        }
    }

    @Override // com.qq.e.comm.pi.NSPVI
    public void setDeveloperLogo(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        this.a.m = bArr;
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        b5.a(map, this.a.b(), this.a.c, this.a.c(), this);
    }

    @Override // com.qq.e.comm.pi.IBiddingLoss
    public void sendLossNotification(Map<String, Object> map) {
        b5.a(map, this.a.c, this.a.b(), this.a.c(), this, this.o);
    }

    @Override // com.qq.e.comm.plugin.rj
    public void c() {
        if (this.h.l()) {
            this.g.d();
            this.d.j();
        }
    }

    @Override // com.qq.e.comm.plugin.rj
    public void a(int i) {
        d(i);
    }

    @Override // com.qq.e.comm.plugin.vk
    public void a(eo eoVar) {
        c(eoVar.a());
    }

    @Override // com.qq.e.comm.plugin.vk
    public void a(mu muVar) throws JSONException {
        if (this.h.j()) {
            this.a.a(muVar);
            b10.a(1010410, this.a.c(), Integer.valueOf(!muVar.C1() ? 1 : 0));
            this.c.a(muVar);
            if (this.n) {
                D();
            }
        }
    }

    @Override // com.qq.e.comm.plugin.gm
    public void a(nc ncVar) throws JSONException {
        f00.a(this.a, Integer.valueOf(ncVar.a));
        c(ncVar.a);
    }

    @Override // com.qq.e.comm.plugin.gm
    public void a(qj qjVar) {
        if (this.h.l() && this.f.b(qjVar)) {
            this.f.c(qjVar);
        }
    }

    public void a(String str) {
        this.a.g = str;
        pu.a().a(str);
    }

    private void a(boolean z, ViewGroup viewGroup) throws JSONException {
        int i;
        if (viewGroup == null) {
            GDTLogger.e("展示广告容器不能为空");
            return;
        }
        if (this.a.b() != null && !this.h.n()) {
            if (!this.h.m()) {
                GDTLogger.e("请勿重复调用 show 接口");
                return;
            }
            if (this.h.i()) {
                f00.f(this.a);
                if (z != this.a.p) {
                    i = ErrorCode.METHOD_CALL_ERROR;
                } else {
                    i = C() ? ErrorCode.AD_DATA_EXPIRE : 0;
                }
                if (i != 0) {
                    f00.a(this.a, Integer.valueOf(i));
                    c(i);
                    return;
                }
                xz xzVar = this.a;
                xzVar.r = viewGroup;
                this.f.b(xzVar, this);
                this.d.l();
                viewGroup.post(new b());
                return;
            }
            return;
        }
        GDTLogger.e("加载广告后再调用 show 接口");
    }
}

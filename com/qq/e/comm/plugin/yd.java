package com.qq.e.comm.plugin;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.plugin.fs.FSCallback;
import com.qq.e.comm.plugin.g1;
import com.qq.e.comm.plugin.me;
import com.qq.e.comm.plugin.qo;
import com.qq.e.comm.plugin.xc;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class yd extends l30 implements qk, os {
    private static final e2 M;
    private static final xk<dn> N;
    private dn B;
    private DownloadConfirmListener C;
    private ServerSideVerificationOptions D;
    private final boolean E;
    private boolean F;
    private boolean G;
    private final ns H;
    public long I;
    private volatile g1<dn> J;

    /* renamed from: K, reason: collision with root package name */
    private AtomicBoolean f787K;
    private long L;

    static {
        e2 e2Var = e2.UNIFIED_INTERSTITIAL_FULLSCREEN;
        M = e2Var;
        j30.n = new AtomicBoolean();
        j30.o = System.currentTimeMillis();
        q8.a().b(e2Var);
        N = new a();
    }

    @Override // com.qq.e.comm.plugin.os
    public boolean k() {
        return false;
    }

    /* compiled from: A */
    class a implements xk<dn> {
        @Override // com.qq.e.comm.plugin.xk
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public dn a(String str, String str2, String str3, e2 e2Var, JSONObject jSONObject, mb mbVar) {
            return new dn(str, str2, str3, jSONObject, mbVar);
        }

        a() {
        }
    }

    public yd(Context context, ADSize aDSize, String str, String str2, String str3, mb mbVar, ADListener aDListener) {
        super(context, aDSize, str, str2, str3, mbVar, aDListener, M);
        this.H = new ns();
        this.f787K = new AtomicBoolean();
        this.E = r1.d().f().a("uirsd", str2, 1) == 1;
    }

    @Override // com.qq.e.comm.plugin.l30, com.qq.e.comm.pi.NEADI
    public void loadAd(int i) {
        g();
        this.i = i;
        this.J.a(a(i, this.v), this.t, this.r, new b());
    }

    /* compiled from: A */
    class b implements g1.h<dn> {
        @Override // com.qq.e.comm.plugin.g1.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public dn a(JSONObject jSONObject) {
            return (dn) yd.N.a(yd.this.c, yd.this.d, yd.this.e, yd.this.a, jSONObject, yd.this.g);
        }

        b() {
        }

        @Override // com.qq.e.comm.plugin.g1.h
        public void a(dn dnVar) {
            yd.this.a(dnVar);
        }

        @Override // com.qq.e.comm.plugin.g1.h
        public void a(eo eoVar) {
            yd.this.b(eoVar.a());
        }
    }

    @Override // com.qq.e.comm.plugin.f0
    protected void g() {
        if (this.J != null) {
            return;
        }
        synchronized (this) {
            if (this.J != null) {
                return;
            }
            e2 e2Var = e2.UNIFIED_INTERSTITIAL_FULLSCREEN;
            int iA = xc.a("ifcasi", e2Var.c(), this.d, 3);
            g1<dn> g1VarA = g1.a(this.d, this.r, e2Var);
            g1VarA.a(TextUtils.isEmpty(this.e) && iA > 0).a(iA).b(xc.a("ifreti", e2Var.c(), this.d, 250));
            this.J = g1VarA;
        }
    }

    /* compiled from: A */
    class c implements Runnable {
        final /* synthetic */ dn a;

        c(dn dnVar) {
            this.a = dnVar;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            if (yd.this.B == null) {
                return;
            }
            yd.this.B.f(3);
            yd.this.r.c(3);
            if (yd.this.h != null) {
                yd.this.h.onADEvent(new ADEvent(100, new Object[0]));
                go.a(yd.this.r, 1, yd.this.B);
                if (yd.this.E) {
                    yd.this.h.onADEvent(new ADEvent(109, new Object[0]));
                }
            }
            hd.a(yd.this.B.y0(), new VideoOption.Builder().setAutoPlayMuted(!yd.this.v()).setDetailPageMuted(false).setAutoPlayPolicy(1).build());
            yd.this.a(this.a, false);
        }
    }

    private void b(dn dnVar) {
        this.B = dnVar;
        if (dnVar.p0() != null) {
            b10.a(9411011, f5.a(dnVar), 2);
        }
        this.F = false;
        try {
            String strC = r1.d().f().c("videoOptions", this.B.y0());
            if (strC == null) {
                strC = "{}";
            }
            this.G = !new JSONObject(strC).optBoolean("autoPlayMuted", false);
        } catch (Exception e) {
            e.getMessage();
        }
        xo.a((Runnable) new c(dnVar));
        this.I = System.currentTimeMillis();
        xc.c cVarD = xc.d();
        e2 e2Var = e2.UNIFIED_INTERSTITIAL_FULLSCREEN;
        cVarD.a(dnVar, e2Var.c(), "ifcasi", 3).a(dnVar, e2Var.c(), "ifreti", 250).a();
    }

    /* compiled from: A */
    class d implements me.c {
        final /* synthetic */ boolean a;

        @Override // com.qq.e.comm.plugin.me.c
        public void a() {
        }

        @Override // com.qq.e.comm.plugin.me.c
        public void a(int i, long j, long j2) {
        }

        @Override // com.qq.e.comm.plugin.me.c
        public void a(db dbVar) {
        }

        @Override // com.qq.e.comm.plugin.me.c
        public void a(boolean z) {
        }

        @Override // com.qq.e.comm.plugin.me.c
        public void b() {
        }

        @Override // com.qq.e.comm.plugin.me.c
        public void onCancel() {
        }

        d(boolean z) {
            this.a = z;
        }

        @Override // com.qq.e.comm.plugin.me.c
        public void a(String str) {
            if (this.a) {
                return;
            }
            if (!yd.this.F) {
                yd.this.h.onADEvent(new ADEvent(201, new Object[0]));
                yd.this.F = true;
            }
            if (yd.this.E) {
                return;
            }
            yd.this.h.onADEvent(new ADEvent(109, new Object[0]));
        }
    }

    @Override // com.qq.e.comm.plugin.l30
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public dn n() {
        return this.B;
    }

    @Override // com.qq.e.comm.plugin.l30, com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        dn dnVar = this.B;
        if (dnVar != null) {
            return dnVar.p();
        }
        return null;
    }

    @Override // com.qq.e.comm.plugin.f0, com.qq.e.comm.pi.NEADI
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.D = serverSideVerificationOptions;
    }

    @Override // com.qq.e.comm.plugin.l30, com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.C = downloadConfirmListener;
        dn dnVar = this.B;
        if (dnVar != null && downloadConfirmListener != null) {
            String strK0 = dnVar.k0();
            qm$h$$ExternalSyntheticBackport0.m(downloadConfirmListener);
            d3.b().a(strK0, downloadConfirmListener);
            return;
        }
        GDTLogger.e("setDownloadConfirmListener错误广告数据或listener为空");
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener = this.C;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i, str, downloadConfirmCallBack);
        }
    }

    public final String u() {
        return this.e;
    }

    @Override // com.qq.e.comm.plugin.l30, com.qq.e.comm.plugin.f0
    public String[] d() {
        dn dnVar = this.B;
        return dnVar != null ? new String[]{dnVar.e1()} : super.d();
    }

    public boolean v() {
        return this.G;
    }

    @Override // com.qq.e.comm.plugin.l30, com.qq.e.comm.plugin.f0
    public String[] c() {
        dn dnVar = this.B;
        return dnVar != null ? new String[]{dnVar.W()} : super.c();
    }

    @Override // com.qq.e.comm.plugin.l30
    public boolean o() {
        return k.a(this.L);
    }

    public void w() {
        this.f787K.set(true);
        if (this.J != null) {
            w1 w1VarA = a(this.i);
            this.J.a((g1<dn>) n(), w1VarA, this.t, (qo.f) null, this.r);
            this.J.b(w1VarA, this.t, this.r);
        }
    }

    @Override // com.qq.e.comm.plugin.l30
    public void close() {
        dn dnVar = this.B;
        if (dnVar != null) {
            ((FSCallback) x5.b(dnVar.s0(), FSCallback.class)).Q().a();
        }
    }

    @Override // com.qq.e.comm.plugin.qk
    public ServerSideVerificationOptions l() {
        return this.D;
    }

    @Override // com.qq.e.comm.plugin.os
    public ns i() {
        return this.H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(dn dnVar, boolean z) {
        String strV0 = dnVar.V0();
        String strA = ui.a().a(strV0);
        if (!this.F && !z && !TextUtils.isEmpty(strA) && v5.a(this.B.K())) {
            this.h.onADEvent(new ADEvent(201, new Object[0]));
            this.F = true;
            if (this.E) {
                return;
            }
            this.h.onADEvent(new ADEvent(109, new Object[0]));
            return;
        }
        if (f40.a(dnVar) == null) {
            me.a().a(strV0, strA, new d(z), dnVar, true);
        } else {
            if (z) {
                return;
            }
            this.h.onADEvent(new ADEvent(201, new Object[0]));
            if (this.E) {
                return;
            }
            this.h.onADEvent(new ADEvent(109, new Object[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(dn dnVar) {
        this.r = f5.a(dnVar);
        this.L = k.b(dnVar);
        if (!dnVar.m1()) {
            GDTLogger.e("广告样式校验失败：插屏全屏广告使用了插屏半屏的广告位");
            b(ErrorCode.RENDER_TYPE_POSTYPE_NOTMATCH);
            go.a(ErrorCode.RENDER_TYPE_POSTYPE_NOTMATCH, this.r, 1);
        } else {
            go.b(this.r, 1);
            this.F = false;
            b(dnVar);
        }
    }
}

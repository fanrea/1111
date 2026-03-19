package com.qq.e.comm.plugin;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.plugin.f0;
import com.qq.e.comm.plugin.g1;
import com.qq.e.comm.plugin.xc;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class l30 extends f0 implements ApkDownloadComplianceInterface {
    private dd A;
    private ed x;
    private mi y;
    private mi z;

    static {
        q8.a().b(e2.UNIFIED_INTERSTITIAL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public mi h() {
        return new mi(this.b, this.c, this.d, this.e, this.h);
    }

    public l30(Context context, ADSize aDSize, String str, String str2, String str3, mb mbVar, ADListener aDListener) {
        this(context, aDSize, str, str2, str3, mbVar, aDListener, e2.UNIFIED_INTERSTITIAL);
    }

    /* compiled from: A */
    class a implements g1.h<ed> {
        a() {
        }

        @Override // com.qq.e.comm.plugin.g1.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ed a(JSONObject jSONObject) {
            return l30.this.a(jSONObject);
        }

        @Override // com.qq.e.comm.plugin.g1.h
        public void a(ed edVar) {
            if (l30.this.a(edVar)) {
                l30.this.b(ErrorCode.RENDER_TYPE_POSTYPE_NOTMATCH);
                return;
            }
            l30 l30Var = l30.this;
            l30Var.y = l30Var.h();
            l30 l30Var2 = l30.this;
            l30Var2.A = l30Var2.u.a(edVar);
            if (l30.this.y.a(l30.this.A)) {
                go.b(l30.this.r, 1);
                l30.this.c(edVar);
            } else {
                l30.this.b(6000);
            }
        }

        @Override // com.qq.e.comm.plugin.g1.h
        public void a(eo eoVar) {
            l30.this.b(eoVar.a());
        }
    }

    @Override // com.qq.e.comm.plugin.f0
    protected g1<ed> f() {
        return super.a(xc.a("ihcasi", this.a.c(), this.d, 6), xc.a("ihreti", this.a.c(), this.d, 300));
    }

    public l30(Context context, ADSize aDSize, String str, String str2, String str3, mb mbVar, ADListener aDListener, e2 e2Var) {
        super(context, aDSize, str, str2, mbVar, aDListener, str3, e2Var);
    }

    private void r() {
        this.x = null;
        dd ddVar = this.A;
        if (ddVar != null) {
            ddVar.destroy();
            this.A = null;
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ h4 a;

        b(h4 h4Var) {
            this.a = h4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.C1() && f40.a(this.a) == null) {
                l30.this.h.onADEvent(new ADEvent(211, new Object[0]));
            }
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.v = loadAdParams;
        this.w = b5.a(loadAdParams);
    }

    public h4 n() {
        return this.x;
    }

    public f5 p() {
        return this.r;
    }

    public void show() {
        Activity activityM = m();
        if (activityM == null) {
            GDTLogger.e("构造插屏广告时的Activity已经被系统回收，如果需要跨Activity展示插屏广告请在show方法中指定Activity参数");
        } else {
            show(activityM);
        }
    }

    private Activity m() {
        Context context = this.b;
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    public void close() {
        mi miVar = this.z;
        if (miVar != null) {
            miVar.close();
        }
    }

    public void loadAd() {
        loadAd(r1.d().f().a("ilat", e2.UNIFIED_INTERSTITIAL.b()));
    }

    private void q() {
        b(this.x);
    }

    private void b(h4 h4Var) {
        this.h.onADEvent(new ADEvent(100, new Object[0]));
        go.a(this.r, 1, h4Var);
    }

    public int getAdPatternType() {
        mi miVar = this.y;
        if (miVar != null) {
            return miVar.getAdPatternType();
        }
        return 0;
    }

    public int getVideoDuration() {
        mi miVar = this.y;
        if (miVar != null) {
            return miVar.getVideoDuration();
        }
        return 0;
    }

    public boolean o() {
        mi miVar = this.y;
        if (miVar != null) {
            return miVar.h();
        }
        return false;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        mi miVar = this.y;
        return miVar != null ? miVar.getApkInfoUrl() : "";
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        mi miVar = this.y;
        if (miVar != null) {
            miVar.setDownloadConfirmListener(downloadConfirmListener);
        }
    }

    public void destroy() {
        mi miVar = this.z;
        if (miVar != null) {
            miVar.destroy();
        }
    }

    /* compiled from: A */
    private static class c extends f0.b {
        @Override // com.qq.e.comm.plugin.f0.b
        public dd a(ed edVar) {
            return new ki(this.a, edVar);
        }

        private c(Context context, ADSize aDSize) {
            super(context, aDSize);
        }

        /* synthetic */ c(Context context, ADSize aDSize, a aVar) {
            this(context, aDSize);
        }
    }

    @Override // com.qq.e.comm.pi.NEADI
    public void loadAd(int i) {
        g();
        r();
        this.i = i;
        this.s.a(a(i, this.v), this.t, this.r, new a());
    }

    @Override // com.qq.e.comm.plugin.f0
    public String[] d() {
        mi miVar = this.y;
        return miVar != null ? miVar.f() : new String[0];
    }

    protected void d(h4 h4Var) {
        xc.c cVarD = xc.d();
        e2 e2Var = e2.UNIFIED_INTERSTITIAL;
        cVarD.a(h4Var, e2Var.c(), "ihcasi", 6).a(h4Var, e2Var.c(), "ihreti", 300).a();
    }

    @Override // com.qq.e.comm.plugin.f0
    public String[] c() {
        mi miVar = this.y;
        return miVar != null ? miVar.e() : new String[0];
    }

    public void show(Activity activity) {
        mi miVar = this.y;
        if (miVar != null) {
            this.z = miVar;
            miVar.show(activity);
            q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(h4 h4Var) {
        if (!h4Var.m1()) {
            return false;
        }
        GDTLogger.e("广告样式校验失败：插屏半屏广告使用了插屏全屏的广告位");
        go.a(ErrorCode.RENDER_TYPE_POSTYPE_NOTMATCH, this.r, 1);
        return true;
    }

    @Override // com.qq.e.comm.plugin.f0
    protected f0.b a() {
        return new c(this.b, this.f, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ed edVar) {
        this.x = edVar;
        this.r = f5.a(edVar);
        b((h4) this.x);
        c((h4) edVar);
        d(edVar);
    }

    private void c(h4 h4Var) {
        xo.a((Runnable) new b(h4Var));
    }
}

package com.kwad.components.core.p.b;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kuaishou.tk.api.export.sdk.TkBundleInfo;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.library.solder.lib.i;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class a<T extends IOfflineCompo<?>> {
    private long KA;
    private String Tm = "";

    protected abstract void a(Context context, boolean z, T t);

    protected abstract String getTag();

    public abstract boolean isEnabled();

    public abstract String qM();

    protected abstract String qN();

    protected abstract String qO();

    protected abstract String qP();

    protected abstract String qQ();

    protected abstract String qR();

    protected abstract String qS();

    public final void init(Context context) {
        try {
            if (isEnabled()) {
                this.KA = SystemClock.elapsedRealtime();
                com.kwad.components.core.p.c.a.c(qM(), getDuration());
                c.d(getTag(), "init start");
                aw(context);
                return;
            }
            try {
                c.d(getTag(), "del start");
                com.kwad.library.solder.a.a.r(context, qN());
            } catch (Throwable unused) {
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getDuration() {
        return SystemClock.elapsedRealtime() - this.KA;
    }

    private void aw(final Context context) {
        if (com.kwad.components.core.a.OR.booleanValue()) {
            c.d(getTag(), "init start disableOffline");
            a(context, false, getClass().getClassLoader());
        } else {
            com.kwad.library.solder.lib.c.b bVarQJ = qJ();
            c.d(getTag(), "load component start pluginInfo: " + bVarQJ);
            com.kwad.library.solder.a.a.a(context, bVarQJ, new b.a() { // from class: com.kwad.components.core.p.b.a.1
                long Tn;

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.library.solder.lib.ext.b.C0565b, com.kwad.library.solder.lib.ext.b
                public void a(com.kwad.library.solder.lib.b.a aVar, com.kwad.library.b.a aVar2) {
                    super.a((AnonymousClass1) aVar, (com.kwad.library.solder.lib.b.a) aVar2);
                    c.d(a.this.getTag(), "load component resource success");
                    com.kwad.components.core.p.c.a.a(a.this.qM(), a.this.getDuration(), a.this.Tm);
                    a.this.a(context, !"LOCAL".equals(r4.Tm), aVar2.Pe());
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.library.solder.lib.ext.b.C0565b, com.kwad.library.solder.lib.ext.b
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void d(com.kwad.library.solder.lib.b.a aVar) {
                    super.d((AnonymousClass1) aVar);
                    c.d(a.this.getTag(), "update component resource success");
                    com.kwad.components.core.p.c.c.a(a.this.qM(), a.this.getDuration(), SystemClock.elapsedRealtime() - this.Tn, a.this.Tm);
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.library.solder.lib.ext.b.C0565b, com.kwad.library.solder.lib.ext.b
                public void a(com.kwad.library.solder.lib.b.a aVar, PluginError pluginError) {
                    super.a((AnonymousClass1) aVar, pluginError);
                    if (aVar.getState() == 1) {
                        com.kwad.components.core.p.c.c.b(a.this.qM(), a.this.getDuration(), pluginError.getCode(), a.this.Tm, pluginError.getMessage());
                    }
                    com.kwad.components.core.p.c.a.a(a.this.qM(), a.this.getDuration(), pluginError.getCode(), "cmp_load_error " + pluginError.getMessage(), a.this.Tm);
                    c.d(a.this.getTag(), "load component resource failed error: " + pluginError);
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.library.solder.lib.ext.b.C0565b, com.kwad.library.solder.lib.ext.b
                public void b(com.kwad.library.solder.lib.b.a aVar) {
                    super.b((AnonymousClass1) aVar);
                    c.d(a.this.getTag(), "install component resource start");
                    com.kwad.components.core.p.c.a.b(a.this.qM(), a.this.getDuration(), a.this.Tm);
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.library.solder.lib.ext.b.C0565b, com.kwad.library.solder.lib.ext.b
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public void a(com.kwad.library.solder.lib.b.a aVar) {
                    super.a((AnonymousClass1) aVar);
                    c.d(a.this.getTag(), "install component resource success");
                    com.kwad.components.core.p.c.a.c(a.this.qM(), a.this.getDuration(), a.this.Tm);
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.library.solder.lib.ext.b.C0565b, com.kwad.library.solder.lib.ext.b
                /* renamed from: d, reason: merged with bridge method [inline-methods] */
                public void e(com.kwad.library.solder.lib.b.a aVar) {
                    super.e((AnonymousClass1) aVar);
                    this.Tn = SystemClock.elapsedRealtime();
                    a.this.Tm = aVar.PE() ? "ASSETS" : TkBundleInfo.BUNDLE_CACHE_NETWORK;
                    c.d(a.this.getTag(), "update component resource start");
                    com.kwad.components.core.p.c.c.d(a.this.qM(), a.this.getDuration(), a.this.Tm);
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.library.solder.lib.ext.b.C0565b, com.kwad.library.solder.lib.ext.b
                /* renamed from: e, reason: merged with bridge method [inline-methods] */
                public void c(com.kwad.library.solder.lib.b.a aVar) {
                    super.c((AnonymousClass1) aVar);
                    c.d(a.this.getTag(), "load component resource start");
                    a.this.Tm = "LOCAL";
                    com.kwad.components.core.p.c.a.b(a.this.qM(), a.this.getDuration(), aVar.Pv().Pi().PJ());
                }
            });
        }
    }

    private com.kwad.library.solder.lib.c.b qJ() {
        com.kwad.library.solder.lib.c.b bVar = new com.kwad.library.solder.lib.c.b();
        bVar.bjd = qN();
        bVar.enable = true;
        bVar.bjh = false;
        bVar.bje = com.kwad.sdk.core.network.idc.a.aaw().fu(qP());
        bVar.version = qO();
        bVar.bjg = qQ();
        if (com.kwad.components.core.a.OU.booleanValue()) {
            bVar.biI = qR();
            bVar.biJ = true;
        }
        if (TextUtils.isEmpty(qQ()) || TextUtils.isEmpty(qN()) || TextUtils.isEmpty(qO()) || TextUtils.isEmpty(qP())) {
            com.kwad.components.core.p.c.a.a(qM(), getDuration(), 6001, "buildRemotePlugInfo error", this.Tm);
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, boolean z, ClassLoader classLoader) {
        qK();
        String strQS = qS();
        try {
            IOfflineCompo iOfflineCompo = (IOfflineCompo) classLoader.loadClass(strQS).newInstance();
            c.d(getTag(), "load component instance success: " + iOfflineCompo.getClass().getName() + ", loadFromNet:" + z + ", classLoader:" + classLoader);
            a(context, z, (boolean) iOfflineCompo);
        } catch (Throwable th) {
            com.kwad.components.core.p.c.a.a(qM(), getDuration(), 4005, "loadClass error", this.Tm);
            c.e(getTag(), "loadClass or instance failed: " + strQS, th);
        }
    }

    private void qK() {
        c.d(getTag(), "init component start cost: " + getDuration());
        com.kwad.components.core.p.c.a.d(qM(), getDuration());
    }

    public final void qL() {
        c.d(getTag(), "init component success cost: " + getDuration());
        com.kwad.components.core.p.c.a.c(qM(), getDuration(), i.Po().Pi().PJ());
    }

    public final void aP(int i) {
        c.d(getTag(), "init component error time: " + getDuration());
        com.kwad.components.core.p.c.a.a(qM(), getDuration(), 5001, "cmp_init_error, errorCode:" + i, this.Tm);
    }
}

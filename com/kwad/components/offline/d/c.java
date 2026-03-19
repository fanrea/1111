package com.kwad.components.offline.d;

import android.content.Context;
import android.os.SystemClock;
import com.kwad.components.core.request.h;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.report.TKDownloadMsg;
import com.kwad.library.solder.lib.i;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bh;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.core.p.b.a<ITkOfflineCompo> {
    private static long bbO;
    private final List<com.kwad.components.core.p.a.e.a> bbN;
    private final AtomicBoolean bbP;

    @Override // com.kwad.components.core.p.b.a
    public final String getTag() {
        return "TkInitModule";
    }

    @Override // com.kwad.components.core.p.b.a
    public final String qM() {
        return "TK";
    }

    @Override // com.kwad.components.core.p.b.a
    public final String qN() {
        return ITkOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.p.b.a
    public final String qO() {
        return "4.5.20.1";
    }

    @Override // com.kwad.components.core.p.b.a
    public final String qP() {
        return "https://p2-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/tk/ks_so-tachikomaNoSoRelease-4.4.20.2-634ee5d43a-104.zip";
    }

    @Override // com.kwad.components.core.p.b.a
    public final String qQ() {
        return "91ef97cd6a396acd3eaffce69d31b5c5";
    }

    @Override // com.kwad.components.core.p.b.a
    public final String qR() {
        return "ks_tk_45201";
    }

    @Override // com.kwad.components.core.p.b.a
    public final String qS() {
        return ITkOfflineCompo.IMPL;
    }

    /* synthetic */ c(byte b) {
        this();
    }

    static final class a {
        private static final c bbZ = new c(0);
    }

    public static c LU() {
        return a.bbZ;
    }

    private c() {
        this.bbN = new CopyOnWriteArrayList();
        this.bbP = new AtomicBoolean(false);
    }

    public static void aQ(Context context) {
        bbO = SystemClock.elapsedRealtime();
        LU().init(context);
    }

    @Override // com.kwad.components.core.p.b.a
    public final boolean isEnabled() {
        return com.kwad.sdk.core.h.a.acv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.p.b.a
    public void a(Context context, boolean z, ITkOfflineCompo iTkOfflineCompo) {
        iTkOfflineCompo.init(context, new d(), new AnonymousClass1(iTkOfflineCompo, z, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - bbO, context));
    }

    /* renamed from: com.kwad.components.offline.d.c$1, reason: invalid class name */
    final class AnonymousClass1 implements InitCallBack {
        final /* synthetic */ ITkOfflineCompo bbQ;
        final /* synthetic */ boolean bbR;
        final /* synthetic */ long bbS;
        final /* synthetic */ long bbT;
        final /* synthetic */ Context val$context;

        AnonymousClass1(ITkOfflineCompo iTkOfflineCompo, boolean z, long j, long j2, Context context) {
            this.bbQ = iTkOfflineCompo;
            this.bbR = z;
            this.bbS = j;
            this.bbT = j2;
            this.val$context = context;
        }

        @Override // com.kwad.components.offline.api.InitCallBack
        public final void onSuccess(boolean z) {
            try {
                final b bVar = new b(this.bbQ);
                com.kwad.sdk.components.d.a(com.kwad.components.core.p.a.e.c.class, bVar);
                c.this.bbP.set(true);
                int i = z ? 2 : 1;
                int i2 = this.bbR ? 2 : 1;
                c.this.b(i, i2, SystemClock.elapsedRealtime() - this.bbS, this.bbT);
                TkLoggerReporter.get().reportTKSOLoad(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setDownloadState(3).setOfflineLoadTime(this.bbT).setSoLoadTime(SystemClock.elapsedRealtime() - this.bbS).setInitSdkTimeConsuming(SystemClock.elapsedRealtime() - l.UL().Vp()).setThreadPoolCoreSize(i.Po().Pi().PJ()).setOfflineSource(i2).setSoSource(i).toJson());
                c.this.qL();
                h.b(new com.kwad.components.core.request.i() { // from class: com.kwad.components.offline.d.c.1.1
                    @Override // com.kwad.components.core.request.i, com.kwad.components.core.request.h.a
                    public final void d(final SdkConfigData sdkConfigData) {
                        super.d(sdkConfigData);
                        com.kwad.sdk.utils.h.execute(new bh() { // from class: com.kwad.components.offline.d.c.1.1.1
                            @Override // com.kwad.sdk.utils.bh
                            public final void doTask() {
                                bVar.onConfigRefresh(AnonymousClass1.this.val$context, sdkConfigData.toJson());
                            }
                        });
                    }
                });
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }

        @Override // com.kwad.components.offline.api.InitCallBack
        public final void onError(int i) {
            c.this.aP(i);
        }
    }

    public final void a(com.kwad.components.core.p.a.e.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            if (this.bbP.get()) {
                aVar.a(1, 1, 0L, 0L);
            }
            this.bbN.add(aVar);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void b(com.kwad.components.core.p.a.e.a aVar) {
        if (aVar == null) {
            return;
        }
        this.bbN.remove(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2, long j, long j2) {
        Iterator<com.kwad.components.core.p.a.e.a> it = this.bbN.iterator();
        while (it.hasNext()) {
            try {
                it.next().a(i, i2, j, j2);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }
}

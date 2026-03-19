package com.kwad.sdk.commercial.h;

import android.content.Context;
import com.kwad.sdk.core.c.b;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.i.g;
import com.kwad.sdk.i.h;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.bh;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a implements com.kwad.sdk.core.d.a.a {
    private final AtomicBoolean mHasInit;

    @Override // com.kwad.sdk.core.d.a.a
    public final void printStackTraceOnly(Throwable th) {
    }

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
        this.mHasInit = new AtomicBoolean(false);
    }

    /* renamed from: com.kwad.sdk.commercial.h.a$a, reason: collision with other inner class name */
    static final class C0573a {
        private static final a buD = new a(0);
    }

    public static a WH() {
        return C0573a.buD;
    }

    public static void register() {
        c.a(WH());
    }

    public final void bJ(String str) {
        try {
            if (this.mHasInit.get()) {
                return;
            }
            Context contextAnu = ServiceProvider.anu();
            final f fVar = (f) ServiceProvider.get(f.class);
            h.alv().a(str, g.alq().hy(ServiceProvider.getSDKConfig().appId).hz(ServiceProvider.getSdkVersion()).hA(be.getOaid()).hD(be.eg(contextAnu)).hB(be.getDeviceId()).hC(be.eh(contextAnu)).p(fVar.TY()).di(com.kwad.sdk.components.g.encryptDisable()).hE(fVar.TX()).k(fVar.Ua()).q(fVar.TZ()), new com.kwad.sdk.i.f() { // from class: com.kwad.sdk.commercial.h.a.1
                @Override // com.kwad.sdk.i.f
                public final String ax(String str2) {
                    return fVar.ax(str2);
                }

                @Override // com.kwad.sdk.i.f
                public final void a(String str2, Map<String, String> map, String str3) {
                    fVar.a(str2, map, str3);
                }
            });
            b.aaf();
            b.a(new d() { // from class: com.kwad.sdk.commercial.h.a.2
                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                public final void onBackToForeground() {
                    super.onBackToForeground();
                    com.kwad.sdk.utils.h.schedule(new bh() { // from class: com.kwad.sdk.commercial.h.a.2.1
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            h.alv().alw();
                        }
                    }, 3L, TimeUnit.SECONDS);
                }

                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                public final void onBackToBackground() {
                    super.onBackToBackground();
                }
            });
            this.mHasInit.set(true);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void v(String str, String str2) {
        h.alv().f("v", str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void v(String str, String str2, boolean z) {
        h.alv().f("v", str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void d(String str, String str2) {
        h.alv().f("d", str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void i(String str, String str2) {
        h.alv().f("i", str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void w(String str, String str2) {
        h.alv().f("w", str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void w(String str, String str2, boolean z) {
        h.alv().f("w", str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void e(String str, String str2) {
        h.alv().f("e", str, str2);
    }
}

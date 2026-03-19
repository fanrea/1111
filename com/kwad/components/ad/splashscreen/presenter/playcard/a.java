package com.kwad.components.ad.splashscreen.presenter.playcard;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.splashscreen.presenter.e;
import com.kwad.components.ad.splashscreen.presenter.j;
import com.kwad.components.core.webview.tachikoma.f.g;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends e {
    private long KA;
    private com.kwad.components.core.p.a.e.b Kz;
    private volatile boolean KB = false;
    private g oh = new g() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.a.1
        @Override // com.kwad.components.core.webview.tachikoma.f.b
        public final void x(String str) {
            a.this.HX.dA = true;
            if ("tk_splash".equals(str)) {
                a.this.ba();
            }
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.g
        public final void a(String str, long j, long j2, long j3) {
            if (TextUtils.isEmpty(str) || !str.equals(com.kwad.sdk.core.response.b.b.ej(a.this.HX.mAdTemplate))) {
                return;
            }
            com.kwad.components.ad.splashscreen.monitor.b.md();
            com.kwad.components.ad.splashscreen.monitor.b.a(a.this.HX.mAdTemplate, a.this.HX.Hj, a.this.HX.Hs, a.this.HX.Hu, a.this.HX.Ht, a.this.HX.Hv, j, j2, j3, SystemClock.elapsedRealtime() - a.this.KA);
            a.this.HX.Hw = j;
            a.this.HX.Hx = j2;
            a.this.HX.Hy = j3;
            bx.d(a.this.KC);
        }
    };
    private final Runnable KC = new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.a.2
        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.KB) {
                a.this.HX.dA = true;
                a.this.ba();
                com.kwad.components.ad.splashscreen.monitor.b.md();
                com.kwad.components.ad.splashscreen.monitor.b.c(a.this.HX.mAdTemplate, a.this.HX.Hj);
                return;
            }
            a.this.nd();
        }
    };
    private com.kwad.components.core.p.a.e.a KD = new com.kwad.components.core.p.a.e.a() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.a.3
        @Override // com.kwad.components.core.p.a.e.a
        public final void a(int i, int i2, long j, long j2) {
            a.this.HX.Hs = i;
            a.this.HX.Ht = i2;
            a.this.HX.Hu = j;
            a.this.HX.Hv = j2;
            com.kwad.components.ad.splashscreen.monitor.b.md();
            com.kwad.components.ad.splashscreen.monitor.b.g(a.this.HX.mAdTemplate, SystemClock.elapsedRealtime() - a.this.KA);
            a.this.nd();
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.KA = SystemClock.elapsedRealtime();
        com.kwad.components.ad.splashscreen.monitor.b.md();
        com.kwad.components.ad.splashscreen.monitor.b.a(this.HX.mAdTemplate, this.HX.Hj);
        this.HX.Hr = this.KA;
        bx.runOnUiThreadDelay(this.KC, com.kwad.sdk.core.response.b.b.dV(this.HX.mAdTemplate));
        com.kwad.components.core.webview.tachikoma.e.c.wq().a(this.oh);
        nc();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.p.a.e.b bVar = this.Kz;
        if (bVar != null) {
            bVar.b(this.KD);
        }
        bx.d(this.KC);
        com.kwad.components.core.webview.tachikoma.e.c.wq().b(this.oh);
    }

    private void nc() {
        com.kwad.components.core.p.a.e.b bVar = (com.kwad.components.core.p.a.e.b) com.kwad.sdk.components.d.g(com.kwad.components.core.p.a.e.b.class);
        this.Kz = bVar;
        if (bVar != null) {
            bVar.a(this.KD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nd() {
        if (this.KB) {
            return;
        }
        this.KB = true;
        bx.postOnUiThread(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.a.4
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                a.this.a(new com.kwad.components.ad.splashscreen.presenter.a.a(), true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba() {
        if (this.HX.Hq) {
            return;
        }
        this.HX.Hq = true;
        this.HX.Hp = true;
        bx.postOnUiThread(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.a.5
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                a.this.a(new j(), true);
            }
        });
    }
}

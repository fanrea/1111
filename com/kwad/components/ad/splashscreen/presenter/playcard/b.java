package com.kwad.components.ad.splashscreen.presenter.playcard;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.splashscreen.presenter.e;
import com.kwad.components.ad.splashscreen.presenter.s;
import com.kwad.components.core.webview.tachikoma.f.g;
import com.kwad.sdk.utils.bx;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends e {
    private long KA;
    private com.kwad.components.core.p.a.e.b Kz;
    private volatile boolean KB = false;
    private g oh = new g() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.b.1
        @Override // com.kwad.components.core.webview.tachikoma.f.b
        public final void x(String str) {
            b.this.HX.dA = true;
            if ("tk_splash".equals(str)) {
                b.this.ne();
            }
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.g
        public final void a(String str, long j, long j2, long j3) {
            if (TextUtils.isEmpty(str) || !str.equals(com.kwad.sdk.core.response.b.b.ej(b.this.HX.mAdTemplate))) {
                return;
            }
            com.kwad.components.ad.splashscreen.monitor.b.md();
            com.kwad.components.ad.splashscreen.monitor.b.a(b.this.HX.mAdTemplate, b.this.HX.Hj, b.this.HX.Hs, b.this.HX.Hu, b.this.HX.Ht, b.this.HX.Hv, j, j2, j3, SystemClock.elapsedRealtime() - b.this.KA);
            b.this.HX.Hw = j;
            b.this.HX.Hx = j2;
            b.this.HX.Hy = j3;
            bx.d(b.this.KC);
        }
    };
    private final Runnable KC = new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.b.2
        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.KB) {
                b.this.HX.dA = true;
                b.this.ne();
                com.kwad.components.ad.splashscreen.monitor.b.md();
                com.kwad.components.ad.splashscreen.monitor.b.c(b.this.HX.mAdTemplate, b.this.HX.Hj);
                return;
            }
            b.this.nd();
        }
    };
    private com.kwad.components.core.p.a.e.a KD = new com.kwad.components.core.p.a.e.a() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.b.3
        @Override // com.kwad.components.core.p.a.e.a
        public final void a(int i, int i2, long j, long j2) {
            b.this.HX.Hs = i;
            b.this.HX.Ht = i2;
            b.this.HX.Hu = j;
            b.this.HX.Hv = j2;
            com.kwad.components.ad.splashscreen.monitor.b.md();
            com.kwad.components.ad.splashscreen.monitor.b.g(b.this.HX.mAdTemplate, SystemClock.elapsedRealtime() - b.this.KA);
            b.this.nd();
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
        if (nf()) {
            com.kwad.components.ad.splashscreen.monitor.b.md();
            com.kwad.components.ad.splashscreen.monitor.b.a(this.HX.mAdTemplate, this.HX.Hj);
            this.HX.Hr = this.KA;
            bx.runOnUiThreadDelay(this.KC, com.kwad.sdk.core.response.b.b.dU(com.kwad.sdk.core.response.b.e.eP(this.HX.mAdTemplate)));
            com.kwad.components.core.webview.tachikoma.e.c.wq().a(this.oh);
        }
        if (com.kwad.sdk.core.config.e.Yc()) {
            nc();
        } else {
            ne();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.p.a.e.b bVar = this.Kz;
        if (bVar != null) {
            bVar.b(this.KD);
        }
        if (nf()) {
            bx.d(this.KC);
            com.kwad.components.core.webview.tachikoma.e.c.wq().b(this.oh);
        }
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
        if (nf()) {
            bx.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.b.4
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.a(new d(), true);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ne() {
        if (!com.kwad.sdk.core.response.b.b.eh(com.kwad.sdk.core.response.b.e.eP(this.HX.mAdTemplate)) || this.HX.Hp) {
            return;
        }
        this.HX.Hp = true;
        bx.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.b.5
            @Override // java.lang.Runnable
            public final void run() {
                b.this.a(new s(), true);
            }
        });
    }

    private boolean nf() {
        if (com.kwad.sdk.core.config.e.Yc()) {
            return com.kwad.sdk.core.response.b.b.dP(com.kwad.sdk.core.response.b.e.eP(this.HX.mAdTemplate));
        }
        return false;
    }
}

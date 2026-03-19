package com.kwad.components.ad.h.a.a;

import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bx;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    public static int se = 1;
    public static int sf = 2;
    private com.kwad.sdk.core.webview.c.c sd;
    private int sg;
    private int sh;
    private InterfaceC0414b sj;
    private c si = new c(this, 0);
    private Runnable sk = null;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public int sm;
        public int sn;
    }

    /* renamed from: com.kwad.components.ad.h.a.a.b$b, reason: collision with other inner class name */
    public interface InterfaceC0414b {
        void Q(int i);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerTimerListener";
    }

    private b(int i, int i2) {
        this.sg = i;
        this.sh = i2;
    }

    public static b J(AdTemplate adTemplate) {
        AdInfo adInfoEP = e.eP(adTemplate);
        if (!(!com.kwad.sdk.core.response.b.a.bi(adInfoEP))) {
            return null;
        }
        if (com.kwad.sdk.core.response.b.a.bT(adInfoEP)) {
            return new b(sf, f(adInfoEP));
        }
        if (adInfoEP.adInsertScreenInfo.autoCloseTime > 0) {
            return new b(se, adInfoEP.adInsertScreenInfo.autoCloseTime);
        }
        return null;
    }

    private static int f(AdInfo adInfo) {
        int iB = com.kwad.components.ad.interstitial.b.b.b(adInfo);
        if (iB <= 0) {
            iB = 60;
        }
        int i = adInfo.adInsertScreenInfo.autoCloseTime;
        return i > 0 ? Math.min(iB, i) : iB;
    }

    public final void a(InterfaceC0414b interfaceC0414b) {
        this.sj = interfaceC0414b;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.sd = cVar;
        Runnable runnable = this.sk;
        if (runnable != null) {
            runnable.run();
            this.sk = null;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.sd = null;
    }

    public final void az() {
        com.kwad.sdk.core.d.c.d("RegisterTimer", "startTimer: mCallBackFunction: " + this.sd);
        if (this.sd == null) {
            this.sk = new Runnable() { // from class: com.kwad.components.ad.h.a.a.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.az();
                }
            };
        } else {
            this.si.X(this.sh);
            bx.runOnUiThread(this.si);
        }
    }

    public final void fU() {
        this.si.z(true);
    }

    public final void fV() {
        this.si.z(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(int i) {
        com.kwad.sdk.core.d.c.d("RegisterTimer", "updateTimer: " + i + ", mCallBackFunction: " + this.sd);
        if (i >= 0 && this.sd != null) {
            InterfaceC0414b interfaceC0414b = this.sj;
            if (interfaceC0414b != null && i == 0) {
                interfaceC0414b.Q(this.sg);
            }
            a aVar = new a();
            aVar.sn = i;
            aVar.sm = this.sg;
            com.kwad.sdk.core.webview.c.c cVar = this.sd;
            if (cVar != null) {
                cVar.a(aVar);
            }
        }
    }

    class c implements Runnable {
        private boolean so;
        private int sp;

        private c() {
            this.so = false;
            this.sp = -1;
        }

        /* synthetic */ c(b bVar, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.c.d("RegisterTimer", "TimerRunnable run timerPaused:  " + this.so + ", currentTime: " + this.sp);
            if (this.so) {
                bx.a(this, null, 1000L);
                return;
            }
            int i = this.sp;
            if (i < 0) {
                return;
            }
            b.this.W(i);
            this.sp--;
            bx.a(this, null, 1000L);
        }

        public final void X(int i) {
            this.sp = i;
        }

        public final void z(boolean z) {
            this.so = z;
        }
    }
}

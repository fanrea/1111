package com.kwad.sdk.f.a;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.c.b;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.z;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a {
    private static volatile a bPn;
    private Activity mActivity;
    private int bPo = 3;
    private int bPp = 3;
    private int bPq = 3;
    private int bPr = 3;
    private AtomicBoolean bPs = new AtomicBoolean(false);
    private boolean bPt = false;
    private AtomicBoolean bPu = new AtomicBoolean(false);
    private AtomicBoolean mHasInit = new AtomicBoolean(false);

    private static boolean fS(int i) {
        return (i & 1) != 0;
    }

    private static boolean fT(int i) {
        return (i & 2) != 0;
    }

    private static boolean fU(int i) {
        return i == 1;
    }

    static /* synthetic */ int b(a aVar, Activity activity) {
        return v(activity);
    }

    static /* synthetic */ int c(a aVar, Activity activity) {
        return u(activity);
    }

    public static a aeT() {
        if (bPn == null) {
            synchronized (a.class) {
                if (bPn == null) {
                    bPn = new a();
                }
            }
        }
        return bPn;
    }

    public final void init(int i) {
        if (this.mHasInit.get() || i == 0) {
            return;
        }
        aeU();
        if (fS(i)) {
            this.bPt = true;
        }
        if (fT(i)) {
            this.bPs.set(true);
        }
        this.mHasInit.set(true);
    }

    private void aeU() {
        this.bPo = Build.VERSION.SDK_INT;
        b.aaf();
        b.a(new d() { // from class: com.kwad.sdk.f.a.a.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* renamed from: onActivityCreated */
            public final void a(Activity activity, Bundle bundle) {
                super.a(activity, bundle);
                try {
                    a.this.mActivity = activity;
                    if (a.this.bPu.get()) {
                        return;
                    }
                    a aVar = a.this;
                    aVar.bPq = a.b(aVar, activity);
                    a aVar2 = a.this;
                    aVar2.bPp = a.c(aVar2, activity);
                    a.this.aeV();
                } catch (Throwable th) {
                    c.e("HdrHelper", "collectHdrAbility error", th);
                }
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* renamed from: onActivityDestroyed */
            public final void b(Activity activity) {
                a.this.mActivity = null;
                b.aaf();
                b.b((com.kwad.sdk.core.c.c) this);
                super.b(activity);
            }
        });
    }

    private static int u(Activity activity) {
        try {
            if (Build.VERSION.SDK_INT < 26) {
                return 3;
            }
            int colorMode = activity.getWindow().getColorMode();
            activity.getWindow().setColorMode(2);
            int colorMode2 = activity.getWindow().getColorMode();
            activity.getWindow().setColorMode(colorMode);
            return colorMode2 == 2 ? 1 : 2;
        } catch (Throwable th) {
            c.e("HdrHelper", "getColorModeSupport error", th);
            return 3;
        }
    }

    private static int v(Activity activity) {
        try {
            if (Build.VERSION.SDK_INT < 34) {
                return 3;
            }
            Display display = activity.getDisplay();
            return display != null ? ((Boolean) z.f(display, "isHdrSdrRatioAvailable", new Object[0])).booleanValue() : false ? 1 : 2;
        } catch (Throwable th) {
            c.e("HdrHelper", "getScreenHdrAvailable error", th);
            return 3;
        }
    }

    public final void aeV() {
        if (!this.bPt || aeW()) {
            return;
        }
        report();
        ag.n("ksadsdk_pref", "hdr_has_reported", true);
        this.bPu.set(true);
    }

    private boolean aeW() {
        if (this.bPu.get()) {
            return true;
        }
        this.bPu.set(ag.o("ksadsdk_pref", "hdr_has_reported", false));
        return this.bPu.get();
    }

    private void report() {
        this.bPr = L(this.bPp, this.bPq);
        this.bPo = Build.VERSION.SDK_INT;
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(1.0d).V("ad_sdk_hdr", "stats_ranger").w(new com.kwad.sdk.f.a.a.a(this.bPo, this.bPp, this.bPq, this.bPr)).a(com.kwai.adclient.kscommerciallogger.model.a.crg));
    }

    private static int L(int i, int i2) {
        return (Build.VERSION.SDK_INT >= 34 && fU(i) && fU(i2)) ? 1 : 2;
    }
}

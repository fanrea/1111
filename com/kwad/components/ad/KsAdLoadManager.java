package com.kwad.components.ad;

import android.content.Context;
import com.kwad.components.ad.adbit.c;
import com.kwad.components.core.c.d;
import com.kwad.components.core.c.g;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.l;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class KsAdLoadManager {
    private volatile boolean dm;

    /* synthetic */ KsAdLoadManager(byte b) {
        this();
    }

    private KsAdLoadManager() {
        this.dm = false;
    }

    enum Holder {
        INSTANCE;

        private final KsAdLoadManager mInstance = new KsAdLoadManager(0);

        Holder() {
        }
    }

    public static KsAdLoadManager P() {
        return Holder.INSTANCE.mInstance;
    }

    public final void a(com.kwad.components.core.request.model.a aVar) {
        if (!l.UL().Vn()) {
            com.kwad.components.core.request.model.a.a(aVar, e.bCv.errorCode, e.bCv.msg, true);
            return;
        }
        if (c.c(aVar) || b(aVar)) {
            return;
        }
        if (!this.dm) {
            Q();
            this.dm = true;
        }
        d.ol().d(aVar);
    }

    private static void Q() {
        boolean zZg = com.kwad.sdk.core.config.e.Zg();
        com.kwad.sdk.core.d.c.d("AdLoadManager", "reportInstallerCheckRecord isInstallerCheckEnable: " + zZg);
        if (zZg) {
            Context context = ServiceProvider.getContext();
            try {
                com.kwad.components.ad.j.b.ak(context);
                com.kwad.components.ad.j.b.al(context);
            } catch (Throwable th) {
                com.kwad.sdk.crash.b.s(th);
            }
        }
    }

    private static boolean b(com.kwad.components.core.request.model.a aVar) {
        try {
            com.kwad.sdk.components.d.g(DevelopMangerComponents.class);
            return false;
        } catch (Exception e) {
            ServiceProvider.reportSdkCaughtException(e);
            return false;
        }
    }

    public final synchronized <T> void b(List<T> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            g.ou().add(it.next());
        }
    }

    public final synchronized <T> void a(T t) {
        g.ou().add(t);
    }
}

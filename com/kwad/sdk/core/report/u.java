package com.kwad.sdk.core.report;

import android.content.Context;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bs;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class u<T extends e, R extends com.kwad.sdk.core.network.f> implements Runnable {
    private static AtomicLong bGb = new AtomicLong(-1);
    protected final l<T> bEn;
    protected final b<T, R> bGc;
    protected final Context mContext;
    protected final AtomicInteger mCount;

    public interface a {
        void abz();
    }

    public u(Context context, l<T> lVar, b<T, R> bVar, AtomicInteger atomicInteger) {
        this.mContext = context;
        this.bEn = lVar;
        this.bGc = bVar;
        this.mCount = atomicInteger;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.mCount.get() > 0 || !ao.isNetworkConnected(this.mContext)) {
            return;
        }
        aby();
    }

    protected final void aby() {
        long jApW = bs.apW();
        if (jApW >= bGb.get() * 2) {
            try {
                List<T> listFq = this.bEn.fq(200);
                if (listFq.isEmpty()) {
                    return;
                }
                this.bGc.a(listFq, new AtomicBoolean(false), new a() { // from class: com.kwad.sdk.core.report.u.1
                    @Override // com.kwad.sdk.core.report.u.a
                    public final void abz() {
                        u.this.aby();
                    }
                });
            } catch (OutOfMemoryError e) {
                bGb.set(jApW);
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(e);
            } catch (Throwable th) {
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
            }
        }
    }
}

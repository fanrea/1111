package com.bytedance.sdk.component.adexpress.hc;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.hc.tc;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class cb implements tc {
    private AtomicBoolean an = new AtomicBoolean(false);
    private gb b;
    private uo c;
    private Context d;
    private com.bytedance.sdk.component.adexpress.u.d hc;
    private ScheduledFuture<?> u;

    public cb(Context context, uo uoVar, com.bytedance.sdk.component.adexpress.u.d dVar, gb gbVar) {
        this.d = context;
        this.c = uoVar;
        this.b = gbVar;
        this.hc = dVar;
        dVar.d(this.b);
    }

    @Override // com.bytedance.sdk.component.adexpress.hc.tc
    public boolean d(final tc.d dVar) {
        int iGb = this.c.gb();
        if (iGb < 0) {
            d(dVar, 107, "time is ".concat(String.valueOf(iGb)));
        } else {
            this.u = com.bytedance.sdk.component.adexpress.c.u.d(new d(1, dVar), iGb, TimeUnit.MILLISECONDS);
            this.hc.d(new h() { // from class: com.bytedance.sdk.component.adexpress.hc.cb.1
                @Override // com.bytedance.sdk.component.adexpress.hc.h
                public void d(View view, k kVar) {
                    e eVarHc;
                    cb.this.b();
                    if (dVar.b() || (eVarHc = dVar.hc()) == null) {
                        return;
                    }
                    eVarHc.d(cb.this.hc, kVar);
                    dVar.d(true);
                }

                @Override // com.bytedance.sdk.component.adexpress.hc.h
                public void d(int i, String str) {
                    cb.this.d(dVar, i, str);
                }
            });
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.hc.tc
    public void d() {
        this.hc.c();
        b();
    }

    public com.bytedance.sdk.component.adexpress.u.d hc() {
        return this.hc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            ScheduledFuture<?> scheduledFuture = this.u;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.u.cancel(false);
            this.u = null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
    }

    private class d implements Runnable {
        private int b;
        tc.d d;

        public d(int i, tc.d dVar) {
            this.b = i;
            this.d = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.b == 1) {
                cb.this.hc.d(true);
                cb.this.d(this.d, 107, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(tc.d dVar, int i, String str) {
        e eVarHc;
        if (dVar.b() || this.an.get()) {
            return;
        }
        b();
        this.c.h().d(i, str);
        if (dVar.hc(this)) {
            dVar.d(this);
        } else {
            if (dVar.b() || (eVarHc = dVar.hc()) == null) {
                return;
            }
            dVar.d(true);
            eVarHc.a_(i);
        }
        this.an.getAndSet(true);
    }
}

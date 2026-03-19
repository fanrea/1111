package com.bytedance.sdk.component.adexpress.d.hc;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.d.b.d;
import com.bytedance.sdk.component.tc.tt;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.component.utils.w;
import com.sigmob.sdk.base.mta.PointCategory;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u extends b {
    private static File d;
    private static volatile u hc;
    private AtomicBoolean b = new AtomicBoolean(true);
    private AtomicBoolean c = new AtomicBoolean(false);
    private boolean u = false;
    private AtomicBoolean an = new AtomicBoolean(false);
    private AtomicInteger h = new AtomicInteger(0);
    private AtomicLong gb = new AtomicLong();

    public static u hc() {
        if (hc == null) {
            synchronized (u.class) {
                if (hc == null) {
                    hc = new u();
                }
            }
        }
        return hc;
    }

    private u() {
        gb();
    }

    private void gb() {
        com.bytedance.sdk.component.adexpress.c.u.hc(new tt(PointCategory.INIT) { // from class: com.bytedance.sdk.component.adexpress.d.hc.u.1
            @Override // java.lang.Runnable
            public void run() throws IOException {
                gb.d();
                u.this.b.set(false);
                u.this.b();
                u.this.an();
                if (com.bytedance.sdk.component.adexpress.d.d.d.d().b() == null || !w.d(com.bytedance.sdk.component.adexpress.d.d.d.d().b().getContext())) {
                    return;
                }
                com.bytedance.sdk.component.adexpress.d.d.d.d().b().hc().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.d.hc.u.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.bytedance.sdk.component.adexpress.d.d.d.d().b() != null) {
                            com.bytedance.sdk.component.adexpress.d.d.d.d();
                        }
                    }
                });
            }
        }, 10);
    }

    public void b() {
        com.bytedance.sdk.component.adexpress.d.b.d dVarHc = gb.hc();
        if (dVarHc == null || !dVarHc.an()) {
            return;
        }
        boolean zD = d(dVarHc);
        if (!zD) {
            gb.c();
        }
        this.u = zD;
    }

    public boolean d(com.bytedance.sdk.component.adexpress.d.b.d dVar) {
        if (dVar == null) {
            return false;
        }
        return d(dVar.d()) || d(dVar.u()) || d(dVar.getResources());
    }

    public boolean c() {
        return this.u;
    }

    public com.bytedance.sdk.component.adexpress.d.b.d u() {
        return gb.hc();
    }

    @Override // com.bytedance.sdk.component.adexpress.d.hc.b
    public File d() {
        return h();
    }

    public void an() {
        d(false);
    }

    public void d(boolean z) {
        boolean z2;
        if (this.b.get()) {
            return;
        }
        try {
            if (this.c.get()) {
                if (z) {
                    this.h.getAndIncrement();
                    return;
                }
                return;
            }
            boolean z3 = true;
            this.c.set(true);
            com.bytedance.sdk.component.adexpress.d.b.d dVarB = com.bytedance.sdk.component.adexpress.d.d.d.d().b().b();
            com.bytedance.sdk.component.adexpress.d.b.d dVarHc = gb.hc();
            if (dVarB != null && dVarB.an()) {
                if (!gb.hc(dVarB)) {
                    this.c.set(false);
                    this.gb.set(System.currentTimeMillis());
                    return;
                }
                if (com.bytedance.sdk.component.adexpress.d.d.d.d().b() != null) {
                    com.bytedance.sdk.component.adexpress.d.d.d.d().b().hc().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.d.hc.u.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.sdk.component.adexpress.u.u.d().hc();
                        }
                    });
                }
                gb.d(dVarB);
                boolean zD = (dVarB.u() == null || TextUtils.isEmpty(dVarB.u().d())) ? false : d(dVarB.u().d());
                List<d.C0260d> listD = null;
                if (dVarB.d().size() != 0) {
                    listD = d(dVarB, dVarHc);
                    z2 = listD != null;
                } else {
                    z2 = zD;
                }
                if (!zD) {
                    List<d.C0260d> listHc = hc(dVarB, dVarHc);
                    if (listD == null || listHc == null) {
                        listD = listHc;
                    } else {
                        listD.addAll(listHc);
                    }
                    if (listHc == null) {
                        z3 = false;
                    }
                    if (listHc == null) {
                        this.c.set(false);
                    }
                    z2 = z3;
                }
                if (z2 && d(dVarB)) {
                    gb.d(dVarB);
                    gb.b();
                    hc(listD);
                }
                b();
                this.c.set(false);
                this.gb.set(System.currentTimeMillis());
                tt();
                return;
            }
            this.c.set(false);
            d(109);
        } catch (Throwable unused) {
        }
    }

    private void tt() {
        if (this.h.getAndSet(0) <= 0 || System.currentTimeMillis() - this.gb.get() <= 600000) {
            return;
        }
        an();
    }

    public static File h() {
        if (d == null) {
            try {
                File file = new File(new File(c.d(), "tt_tmpl_pkg"), "template");
                file.mkdirs();
                d = file;
            } catch (Throwable th) {
                mq.b("TemplateManager", "getTemplateDir error", th);
            }
        }
        return d;
    }
}

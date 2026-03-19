package com.kwad.components.core.e.a;

import android.app.Activity;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e {
    private final List<b> Qb;
    private final Stack<AdTemplate> Qc;
    private final AtomicBoolean Qd;
    private final Set<String> Qe;
    private final String TAG;
    private final AtomicBoolean sO;

    /* synthetic */ e(byte b) {
        this();
    }

    private e() {
        this.TAG = "InstalledActivateManager";
        this.Qb = new CopyOnWriteArrayList();
        this.Qc = new Stack<>();
        this.sO = new AtomicBoolean();
        this.Qd = new AtomicBoolean();
        this.Qe = new HashSet();
    }

    static class a {
        private static final e Qi = new e(0);
    }

    public static e oS() {
        return a.Qi;
    }

    public final boolean isShowing() {
        return this.sO.get();
    }

    public final void a(b bVar) {
        this.Qb.add(bVar);
    }

    public final void b(b bVar) {
        this.Qb.remove(bVar);
    }

    public final void ff() {
        this.sO.set(true);
        Iterator<b> it = this.Qb.iterator();
        while (it.hasNext()) {
            it.next().oQ();
        }
    }

    public final void eQ() {
        this.sO.set(false);
        Iterator<b> it = this.Qb.iterator();
        while (it.hasNext()) {
            it.next().gd();
        }
    }

    public final synchronized void ay(AdTemplate adTemplate) {
        String strAB = com.kwad.sdk.core.response.b.a.aB(com.kwad.sdk.core.response.b.e.eP(adTemplate));
        if (com.kwad.sdk.core.response.b.b.eb(adTemplate) && !this.Qe.contains(strAB)) {
            this.Qe.add(strAB);
            az(adTemplate);
        }
    }

    private void az(final AdTemplate adTemplate) {
        if (this.Qd.get() || this.sO.get()) {
            com.kwad.sdk.core.d.c.d("InstalledActivateManager", "mLoadDisable: " + this.sO.get() + ", mLoadDisable: " + this.Qd.get());
            this.Qc.add(adTemplate);
        } else {
            com.kwad.sdk.core.d.c.d("InstalledActivateManager", "showInstalledActivate");
            this.Qd.set(true);
            bx.runOnUiThreadDelay(new bh() { // from class: com.kwad.components.core.e.a.e.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    final com.kwad.components.ad.b.a.a aVar = (com.kwad.components.ad.b.a.a) com.kwad.sdk.components.d.g(com.kwad.components.ad.b.a.a.class);
                    if (aVar != null && aVar.X()) {
                        aVar.a(new com.kwad.components.ad.b.a.c() { // from class: com.kwad.components.core.e.a.e.1.1
                            @Override // com.kwad.components.ad.b.a.c, com.kwad.components.ad.b.a.b
                            public final void Z() {
                                aVar.b(this);
                                oU();
                                com.kwad.sdk.core.d.c.d("InstalledActivateManager", "startShow onPushAdClose");
                            }
                        });
                    } else {
                        oU();
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void oU() {
                    com.kwad.sdk.core.c.b.aaf();
                    if (!com.kwad.sdk.core.c.b.isEnable()) {
                        e.this.Qd.set(false);
                        return;
                    }
                    com.kwad.sdk.core.c.b.aaf();
                    if (com.kwad.sdk.core.c.b.getCurrentActivity() != null) {
                        com.kwad.sdk.core.c.b.aaf();
                        if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                            oV();
                            return;
                        }
                    }
                    com.kwad.sdk.core.c.b.aaf();
                    com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.e.a.e.1.2
                        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                        /* renamed from: onActivityResumed */
                        public final void d(Activity activity) {
                            super.d(activity);
                            com.kwad.sdk.core.c.b.aaf();
                            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
                            com.kwad.sdk.core.d.c.d("InstalledActivateManager", "startShow onBackToForeground");
                            oV();
                        }
                    });
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void oV() {
                    com.kwad.sdk.core.d.c.d("InstalledActivateManager", "startShow");
                    e.this.aA(adTemplate);
                    e.this.Qd.set(false);
                    e.this.Qe.remove(com.kwad.sdk.core.response.b.a.aB(com.kwad.sdk.core.response.b.e.eP(adTemplate)));
                }
            }, com.kwad.sdk.core.response.b.b.ec(adTemplate));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aA(AdTemplate adTemplate) {
        if (a(adTemplate, new b() { // from class: com.kwad.components.core.e.a.e.2
            @Override // com.kwad.components.core.e.a.b
            public final void oQ() {
                com.kwad.sdk.core.d.c.d("InstalledActivateManager", "onViewShow");
                e.this.ff();
            }

            @Override // com.kwad.components.core.e.a.b
            public final void gd() {
                com.kwad.sdk.core.d.c.d("InstalledActivateManager", "onViewClose");
                e.this.eQ();
                e.this.oT();
            }
        })) {
            return;
        }
        oT();
    }

    private static boolean a(AdTemplate adTemplate, b bVar) {
        com.kwad.sdk.core.d.c.d("InstalledActivateManager", "showToActivityWindow");
        return new h().b(adTemplate, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void oT() {
        if (this.Qc.isEmpty()) {
            return;
        }
        az(this.Qc.pop());
    }
}

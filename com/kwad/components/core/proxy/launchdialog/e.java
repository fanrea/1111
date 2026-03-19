package com.kwad.components.core.proxy.launchdialog;

import android.app.Application;
import android.content.Context;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e {
    private static e Yn = new e();
    private List<b> Yo = new CopyOnWriteArrayList();
    private a Yp = new a();
    private com.kwad.components.core.proxy.b Yq = new com.kwad.components.core.proxy.b(this.Yp);

    public static e sq() {
        return Yn;
    }

    public final void a(b bVar) {
        if (bVar != null) {
            this.Yo.add(bVar);
        }
    }

    public final void b(b bVar) {
        if (bVar != null) {
            this.Yo.remove(bVar);
        }
    }

    public final void init(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(this.Yq);
        }
    }

    public final void aG(final AdTemplate adTemplate) {
        n(this.Yp.sk());
        sq().a(DetectEventType.USER_CANCEL, new f() { // from class: com.kwad.components.core.proxy.launchdialog.e.1
            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void j(com.kwad.components.core.proxy.a aVar) {
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CANCEL PageLaunchDialogManager onContinue");
            }

            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void k(com.kwad.components.core.proxy.a aVar) {
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CANCEL PageLaunchDialogManager onComplete");
                e.this.aI(adTemplate);
                e.this.n(aVar);
            }

            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void l(com.kwad.components.core.proxy.a aVar) {
                e.this.n(aVar);
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CANCEL PageLaunchDialogManager onTimeout");
            }

            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void m(com.kwad.components.core.proxy.a aVar) {
                e.this.n(aVar);
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CANCEL PageLaunchDialogManager onNotMatch");
            }
        });
        sq().a(DetectEventType.USER_CONFIRM, new f() { // from class: com.kwad.components.core.proxy.launchdialog.e.2
            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void j(com.kwad.components.core.proxy.a aVar) {
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CONFIRM PageLaunchDialogManager onContinue");
            }

            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void k(com.kwad.components.core.proxy.a aVar) {
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CONFIRM PageLaunchDialogManager onComplete");
                e.this.aH(adTemplate);
                e.this.n(aVar);
            }

            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void l(com.kwad.components.core.proxy.a aVar) {
                e.this.n(aVar);
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CONFIRM PageLaunchDialogManager onTimeout");
            }

            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void m(com.kwad.components.core.proxy.a aVar) {
                e.this.n(aVar);
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CONFIRM PageLaunchDialogManager onNotMatch");
            }
        });
        long jEV = com.kwad.sdk.core.response.b.e.eV(adTemplate);
        Iterator<b> it = this.Yo.iterator();
        while (it.hasNext()) {
            it.next().b(jEV, 1);
        }
    }

    private void a(DetectEventType detectEventType, f fVar) {
        c cVarA = this.Yp.a(detectEventType);
        if (cVarA != null) {
            cVarA.a(fVar);
            cVarA.start();
        }
    }

    public final void n(com.kwad.components.core.proxy.a aVar) {
        this.Yp.i(aVar);
        this.Yp.h(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.e(adTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().eR(230).eY(25));
        long jEV = com.kwad.sdk.core.response.b.e.eV(adTemplate);
        Iterator<b> it = this.Yo.iterator();
        while (it.hasNext()) {
            it.next().b(jEV, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.e(adTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().eR(231).eY(25));
        long jEV = com.kwad.sdk.core.response.b.e.eV(adTemplate);
        Iterator<b> it = this.Yo.iterator();
        while (it.hasNext()) {
            it.next().b(jEV, 3);
        }
    }
}

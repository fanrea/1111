package com.kwad.sdk.a.a;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.kwad.sdk.a.a.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c {
    private e brs;
    private final Map<String, Integer> brt;
    private final Map<String, Integer> bru;
    private final Stack<AdTemplate> brv;
    private volatile boolean brw;
    public volatile boolean brx;
    public volatile boolean bry;

    static final class a {
        static final c brD = new c(0);
    }

    /* synthetic */ c(byte b) {
        this();
    }

    static /* synthetic */ e a(c cVar, e eVar) {
        cVar.brs = null;
        return null;
    }

    private c() {
        this.brt = new HashMap();
        this.bru = new HashMap();
        this.brv = new Stack<>();
        this.brw = false;
        this.brx = false;
        this.bry = false;
    }

    public static c VC() {
        return a.brD;
    }

    public final void cs(boolean z) {
        this.brw = z;
    }

    private static boolean bn(AdTemplate adTemplate) {
        String strI;
        if (adTemplate == null) {
            return false;
        }
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        if (as.aF(ServiceProvider.getContext(), com.kwad.sdk.core.response.b.a.aB(adInfoEP)) || (strI = com.kwad.sdk.core.download.a.I(adInfoEP)) == null || TextUtils.isEmpty(strI)) {
            return false;
        }
        return new File(strI).exists();
    }

    public final void bo(AdTemplate adTemplate) {
        if (bn(adTemplate)) {
            this.brv.add(adTemplate);
        }
    }

    public final void bp(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        this.brv.remove(adTemplate);
    }

    public final void bq(final AdTemplate adTemplate) {
        int iXU = com.kwad.sdk.core.config.e.XU();
        if (adTemplate == null || iXU <= 0) {
            return;
        }
        final AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        if (adTemplate.mAdScene.getAdStyle() == 0) {
            return;
        }
        String strValueOf = String.valueOf(com.kwad.sdk.core.response.b.e.eV(adTemplate));
        int iIntValue = 0;
        if (this.brt.containsKey(strValueOf)) {
            iIntValue = this.brt.get(strValueOf).intValue();
            this.brt.put(strValueOf, Integer.valueOf(iIntValue));
        }
        if (iIntValue > 0) {
            return;
        }
        h.schedule(new bh() { // from class: com.kwad.sdk.a.a.c.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                if (adInfoEP.status == 12 || adInfoEP.status == 10 || !w.il(com.kwad.sdk.core.download.a.I(com.kwad.sdk.core.response.b.e.eP(adTemplate)))) {
                    return;
                }
                c.this.e(adTemplate, true);
            }
        }, iXU, TimeUnit.SECONDS);
    }

    public final void br(final AdTemplate adTemplate) {
        int iYh = com.kwad.sdk.core.config.e.Yh();
        if (iYh < 0) {
            return;
        }
        final AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        String strValueOf = String.valueOf(adInfoEP.adBaseInfo.creativeId);
        int iIntValue = 0;
        if (this.bru.containsKey(strValueOf)) {
            iIntValue = this.bru.get(strValueOf).intValue();
            this.bru.put(strValueOf, Integer.valueOf(iIntValue));
        }
        if (iIntValue > 0) {
            return;
        }
        h.schedule(new Runnable() { // from class: com.kwad.sdk.a.a.c.2
            @Override // java.lang.Runnable
            public final void run() {
                if (as.aG(ServiceProvider.getContext(), com.kwad.sdk.core.response.b.a.aB(adInfoEP)) == 1) {
                    return;
                }
                c.this.e(adTemplate, false);
            }
        }, iYh, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final AdTemplate adTemplate, final boolean z) {
        bx.runOnUiThread(new bh() { // from class: com.kwad.sdk.a.a.c.3
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                int iXV = com.kwad.sdk.core.config.e.XV();
                boolean z2 = z;
                if (!z2 || iXV != 2) {
                    c.this.a(adTemplate, z2, iXV, false);
                } else {
                    c.this.a(adTemplate, (DialogInterface.OnDismissListener) null, new DialogInterface.OnClickListener() { // from class: com.kwad.sdk.a.a.c.3.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (i != -1) {
                                if (i == -2) {
                                    c cVar = c.this;
                                    c.h(adTemplate, 1);
                                    return;
                                }
                                return;
                            }
                            com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                            bVar.eR(29);
                            bVar.eY(23);
                            com.kwad.sdk.core.adlog.c.e(adTemplate, (JSONObject) null, bVar);
                            com.kwad.sdk.a.a.a.Vx();
                        }
                    });
                }
            }
        });
    }

    public final void VD() {
        b.Vz().a(new b.a() { // from class: com.kwad.sdk.a.a.c.4
            @Override // com.kwad.sdk.a.a.b.a
            public final void hC() {
                bx.runOnUiThreadDelay(new bh() { // from class: com.kwad.sdk.a.a.c.4.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        if (!c.this.brw) {
                            c.this.VF();
                        } else {
                            c.this.bry = true;
                        }
                    }
                }, com.kwad.sdk.core.config.e.XX());
            }

            @Override // com.kwad.sdk.a.a.b.a
            public final void VB() {
                com.kwad.sdk.core.d.c.d("InstallTipsManager", "showInitDelayDialog failed");
            }
        });
    }

    public final void VE() {
        cs(false);
        if (this.brx || !this.bry) {
            return;
        }
        bx.runOnUiThreadDelay(new bh() { // from class: com.kwad.sdk.a.a.c.5
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                c.this.VF();
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VF() {
        if (!this.brx && com.kwad.sdk.a.a.a.b.dT() <= 0) {
            bx.runOnUiThread(new Runnable() { // from class: com.kwad.sdk.a.a.c.6
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        AdTemplate adTemplateVA = b.Vz().VA();
                        if (adTemplateVA == null || com.kwad.sdk.core.config.e.XW() == 0) {
                            return;
                        }
                        c.this.brx = true;
                        com.kwad.sdk.core.c.b.aaf();
                        com.kwad.sdk.a.a.a.b.J(com.kwad.sdk.core.c.b.getCurrentActivity());
                        c.this.bs(adTemplateVA);
                    } catch (Throwable th) {
                        com.kwad.components.core.d.a.reportSdkCaughtException(th);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs(final AdTemplate adTemplate) {
        a(adTemplate, (DialogInterface.OnDismissListener) null, new DialogInterface.OnClickListener() { // from class: com.kwad.sdk.a.a.c.7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                try {
                    if (i == -1) {
                        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                        bVar.eR(29);
                        bVar.eY(23);
                        com.kwad.sdk.core.adlog.c.e(adTemplate, (JSONObject) null, bVar);
                        com.kwad.sdk.a.a.a.Vx();
                    } else {
                        if (i != -2) {
                            return;
                        }
                        c cVar = c.this;
                        c.h(adTemplate, 1);
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        bx.runOnUiThreadDelay(new bh() { // from class: com.kwad.sdk.a.a.c.8
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                if (com.kwad.sdk.a.a.a.Vx()) {
                    c cVar = c.this;
                    c.h(adTemplate, 2);
                }
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.adlog.c.e(adTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().eR(69).eY(23).fc(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdTemplate adTemplate, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnClickListener onClickListener) {
        if (com.kwad.sdk.a.a.a.pe()) {
            return;
        }
        com.kwad.sdk.core.c.b.aaf();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        if (currentActivity != null && com.kwad.sdk.a.a.a.a(currentActivity, adTemplate, onDismissListener, onClickListener)) {
            a(adTemplate, true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdTemplate adTemplate, boolean z, int i, boolean z2) {
        if (this.brs != null || com.kwad.components.core.e.c.b.pe()) {
            return;
        }
        b(adTemplate, z, z && i == 1, z2);
    }

    private void b(final AdTemplate adTemplate, boolean z, boolean z2, boolean z3) {
        Context context;
        Context contextWrapContextIfNeed;
        com.kwad.sdk.core.c.b.aaf();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        if (currentActivity == null || (context = ((f) ServiceProvider.get(f.class)).getContext()) == null || (contextWrapContextIfNeed = m.wrapContextIfNeed(context)) == null) {
            return;
        }
        e eVar = new e(contextWrapContextIfNeed, adTemplate, z, z2, z3);
        View viewFindViewById = currentActivity.getWindow().getDecorView().findViewById(R.id.content);
        if (viewFindViewById instanceof FrameLayout) {
            eVar.b((FrameLayout) viewFindViewById);
            this.brs = eVar;
            a(adTemplate, z, z3);
        }
        if (z3) {
            com.kwad.sdk.core.c.b.aaf();
            com.kwad.sdk.a.a.a.b.J(com.kwad.sdk.core.c.b.getCurrentActivity());
            bx.runOnUiThreadDelay(new bh() { // from class: com.kwad.sdk.a.a.c.9
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    if (c.this.brs != null) {
                        c.this.brs.dismiss();
                        c.a(c.this, (e) null);
                        c cVar = c.this;
                        c.h(adTemplate, 2);
                    }
                }
            }, 5000L);
        }
    }

    private void a(AdTemplate adTemplate, boolean z, boolean z2) {
        String strValueOf = String.valueOf(com.kwad.sdk.core.response.b.e.eV(adTemplate));
        if (z) {
            b(this.brt, strValueOf);
            com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
            if (z2) {
                bVar.eY(23);
                bVar.eR(191);
            } else {
                bVar.eR(92);
            }
            com.kwad.sdk.core.adlog.c.d(adTemplate, (JSONObject) null, bVar);
            return;
        }
        com.kwad.sdk.core.adlog.c.d(adTemplate, 93, (JSONObject) null);
        b(this.bru, strValueOf);
    }

    private static void b(Map<String, Integer> map, String str) {
        if (map.containsKey(str)) {
            map.put(str, Integer.valueOf(map.get(str).intValue() + 1));
        } else {
            map.put(str, 1);
        }
    }

    public final void VG() {
        this.brs = null;
    }

    public final void dismiss() {
        com.kwad.sdk.a.a.a.Vx();
        e eVar = this.brs;
        if (eVar != null) {
            eVar.dismiss();
            this.brs = null;
        }
    }
}

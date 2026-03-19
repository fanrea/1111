package com.kwad.components.ad.interstitial.g;

import android.app.Activity;
import android.content.DialogInterface;
import com.kwad.components.ad.interstitial.f.c;
import com.kwad.components.core.page.widget.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    public static boolean d(final c cVar) {
        Activity ownerActivity;
        if (cVar.mN != null && (ownerActivity = cVar.mN.getOwnerActivity()) != null && !ownerActivity.isFinishing()) {
            AdInfo adInfoEP = e.eP(cVar.mAdTemplate);
            int iDT = com.kwad.components.ad.interstitial.c.b.dT();
            int iDU = com.kwad.components.ad.interstitial.c.b.dU();
            if (iDT > com.kwad.sdk.core.response.b.a.cK(adInfoEP) && iDU < com.kwad.sdk.core.response.b.a.cL(adInfoEP)) {
                if (com.kwad.sdk.core.response.b.a.cM(adInfoEP) == 2) {
                    com.kwad.components.ad.interstitial.h.b.e(cVar);
                    return true;
                }
                if (com.kwad.sdk.core.response.b.a.cM(adInfoEP) == 1) {
                    new com.kwad.components.core.page.widget.a(ownerActivity, com.kwad.sdk.core.response.b.a.cN(adInfoEP), new a.InterfaceC0483a() { // from class: com.kwad.components.ad.interstitial.g.a.1
                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0483a
                        public final void c(DialogInterface dialogInterface) {
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0483a
                        public final void a(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            com.kwad.sdk.core.adlog.c.c(cVar.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().eW(8));
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0483a
                        public final void b(DialogInterface dialogInterface) {
                            c cVar2 = cVar;
                            cVar2.a(false, -1, cVar2.ed);
                            dialogInterface.dismiss();
                            com.kwad.sdk.core.adlog.c.e(cVar.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().eR(151).eW(8));
                            cVar.mN.dismiss();
                        }
                    }).show();
                    com.kwad.sdk.core.adlog.c.d(cVar.mAdTemplate, new JSONObject(), new com.kwad.sdk.core.adlog.c.b().eR(149).eW(8));
                    return true;
                }
            }
        }
        return false;
    }
}
